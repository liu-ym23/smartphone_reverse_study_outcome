package com.ss.texturerender.effect.vr.director.sensordirector;

import android.hardware.SensorEvent;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.math.Matrix3x3d;
import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.math.Vector3d;

/* JADX INFO: loaded from: classes40.dex */
public class SensorFusionEkf {
    private static final double DEFAULT_GYRO_TIME = 0.009999999776482582d;
    private static final double EPSILON = 1.0E-15d;
    private static final double INITIAL_STATE_COVARIANCE = 25.0d;
    private static final double KMinAccelNoiseSigma = 0.75d;
    private static final double MAX_ACC_NORM_CHANGE = 0.15d;
    private static final double NANO_TO_SEC = 9.999999717180685E-10d;
    private static final double kMaxAccelNoiseSigma = 7.0d;
    private final String LOG_TAG;
    private double MAX_GYRO_DELAY;
    private Matrix3x3d mAccMeasureCovariance;
    private Matrix3x3d mAccMeasureJacobian;
    private Vector3d mAccSample;
    private long mAccTimeStamp;
    private double mAverageAccNormChange;
    private GyroBiasEstimator mBiasEstimator;
    private int mDisplayRotation;
    private Quaternion mEkfToHeadTracker;
    private Vector3d mGyroBias;
    private boolean mGyroEnableSmoother;
    private Vector3d mGyroSample;
    private double mGyroSmoothFactor;
    private TimeFilter mGyroTimeFilter;
    private long mGyroTimeStamp;
    private Vector3d mInnovation;
    private Matrix3x3d mInnovationCovariance;
    private boolean mIsAlignedGravity;
    private boolean mIsDisableZrotation;
    private Matrix3x3d mKalmanGain;
    private Quaternion mLastRotationFromStart;
    private double mPreviousAccNorm;
    private Quaternion mPreviousRotation;
    private Matrix3x3d mProcessCovariance;
    private double mRadius;
    private Quaternion mRotationFromStart;
    private int mSensorStartPos;
    private Vector3d mStartDirection;
    private Matrix3x3d mStateCovariance;
    private Vector3d mTestZrot;
    private int mTexType;

    private void computeMeasurementJacobian() {
        int r100 = 0;
    L4:
        if (r100 >= 3) goto L10;
        Vector3d r101 = new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        r101.setComponent(r100, 1.0E-7d);
        double r102 = r101.length();
        if (r102 >= EPSILON) goto L8;
        Quaternion r103 = new Quaternion();
    L9:
        Vector3d r104 = computeInnovation(r103.times(this.mRotationFromStart));
        Vector3d.sub(this.mInnovation, r104, r101);
        r101.devide(1.0E-7d);
        this.mAccMeasureJacobian.set(0, r100, r101.f457024x);
        this.mAccMeasureJacobian.set(1, r100, r101.f457025y);
        this.mAccMeasureJacobian.set(2, r100, r101.f457026z);
        r100 = r100 + 1;
        goto L4
    L8:
        r101.normalize();
        r103 = Quaternion.fromAxisAndAngle(r101, r102);
        goto L9
    }

    private void updateMeasurementCovariance() {
        double r100 = this.mAccSample.length();
        double r101 = Math.abs(r100 - this.mPreviousAccNorm);
        this.mPreviousAccNorm = r100;
        double r102 = (this.mAverageAccNormChange + r101) / 2.0d;
        this.mAverageAccNormChange = r102;
        double r103 = Math.min(kMaxAccelNoiseSigma, ((r102 / MAX_ACC_NORM_CHANGE) * 6.25d) + KMinAccelNoiseSigma);
        this.mAccMeasureCovariance.setIdentity();
        this.mAccMeasureCovariance.scale(r103 * r103);
    }

    public Quaternion getRotation() {
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "mDisplayRotation:" + this.mDisplayRotation + ",rotation:" + this.mRotationFromStart + ";acc:" + this.mAccSample.toString());
        Quaternion r100 = this.mRotationFromStart;
        if (r100 != null) goto L5;
        return null;
    L5:
        Quaternion r101 = this.mLastRotationFromStart;
        if (r101 == null) goto L9;
        r100 = r100.times(r101);
    L9:
        Quaternion r102 = new Quaternion();
        int r103 = this.mDisplayRotation;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L13;
        Quaternion r104 = new Quaternion(-r100.getX0(), -r100.getX1(), r100.getX2(), r100.getX3());
        Quaternion r105 = Quaternion.fromAxisAndAngle(new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d), 3.141592653589793d);
    L18:
        Quaternion r210 = r104;
        r102 = r105;
        r100 = r210;
    L19:
        if (r100 != null) goto L21;
        return null;
    L21:
        Quaternion r106 = this.mEkfToHeadTracker;
        if (r106 == null) goto L25;
        r100 = r100.times(r106);
    L25:
        Quaternion r107 = r100.times(r102);
        if (this.mIsDisableZrotation == false) goto L32;
        if (this.mTestZrot != null) goto L30;
        this.mTestZrot = new Vector3d(1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    L30:
        Vector3d r108 = Quaternion.applyToVector(this.mTestZrot, r107);
        r108.setComponent(2, AudioStats.AUDIO_AMPLITUDE_NONE);
        r107 = r107.times(Quaternion.rotateInto(r108, this.mTestZrot));
    L32:
        if (this.mGyroEnableSmoother == true) goto L34;
        return r107;
    L34:
        if (this.mPreviousRotation != null) goto L36;
        this.mPreviousRotation = r107;
    L36:
        Quaternion r109 = slerp(this.mPreviousRotation, r107, this.mGyroSmoothFactor);
        this.mPreviousRotation = r109;
        return r109;
    L13:
        if (r103 != 3) goto L19;
        r104 = new Quaternion(r100.getX1(), -r100.getX0(), r100.getX2(), r100.getX3());
        r105 = Quaternion.fromAxisAndAngle(new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d), 4.71238898038469d);
        goto L18
    L17:
        r104 = new Quaternion(-r100.getX1(), r100.getX0(), r100.getX2(), r100.getX3());
        r105 = Quaternion.fromAxisAndAngle(new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d), 1.5707963267948966d);
        goto L18
    }

    public void reset() {
        this.mGyroTimeFilter = new TimeFilter();
        this.mBiasEstimator = new GyroBiasEstimator();
        this.mRotationFromStart = new Quaternion();
        Matrix3x3d r100 = new Matrix3x3d();
        this.mStateCovariance = r100;
        r100.setIdentity();
        this.mStateCovariance.scale(INITIAL_STATE_COVARIANCE);
        this.mGyroSample = new Vector3d();
        this.mGyroBias = new Vector3d();
        Matrix3x3d r101 = new Matrix3x3d();
        this.mProcessCovariance = r101;
        r101.setIdentity();
        this.mIsAlignedGravity = false;
        this.mAccMeasureCovariance = new Matrix3x3d();
        this.mAccMeasureJacobian = new Matrix3x3d();
        this.mKalmanGain = new Matrix3x3d();
        this.mInnovationCovariance = new Matrix3x3d();
        this.mEkfToHeadTracker = null;
        this.mDisplayRotation = 0;
        this.mPreviousRotation = null;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "ekf reset");
    }

    public int getDisplayRotation() {
        return this.mDisplayRotation;
    }

    public boolean isAlignedGravity() {
        return this.mIsAlignedGravity;
    }

    public SensorFusionEkf(int r100) {
        this.mGyroTimeStamp = -1;
        this.MAX_GYRO_DELAY = 0.03999999910593033d;
        this.mGyroEnableSmoother = false;
        this.mGyroSmoothFactor = 1.0d;
        this.mPreviousRotation = null;
        this.mAccTimeStamp = -1;
        this.mAccSample = new Vector3d();
        this.mTexType = -1;
        this.mIsDisableZrotation = false;
        this.mTestZrot = null;
        this.mRadius = 800.0d;
        String r101 = TextureRenderLog.getLogTag(this);
        this.LOG_TAG = r101;
        this.mTexType = r100;
        reset();
        TextureRenderLog.i(this.mTexType, r101, "new SensorFusionEkf");
    }

    private Vector3d computeInnovation(Quaternion r100) {
        Quaternion r101 = Quaternion.rotateInto(Quaternion.applyToVector(this.mStartDirection, r100), this.mAccSample);
        Vector3d r102 = r101.getAxis();
        r102.scale(r101.getAngle());
        return r102;
    }

    private Quaternion rotationFromVector(Vector3d r100) {
        double r101 = r100.length();
        if (r101 < EPSILON) goto L5;
        r100.normalize();
        return Quaternion.fromAxisAndAngle(r100, r101);
    L5:
        return new Quaternion();
    }

    private void updateStateCovariance(Matrix3x3d r100) {
        this.mStateCovariance = Matrix3x3d.mult(Matrix3x3d.mult(r100, this.mStateCovariance), r100.transpose());
    }

    public synchronized void processAcc(SensorEvent r110) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L6:
        if (this.mAccTimeStamp <= r110.timestamp) goto L9;
        monitor-exit(this);
        return;
    L9:
        Vector3d r100 = this.mAccSample;     // Catch: Throwable -> L31
        float[] r101 = r110.values;     // Catch: Throwable -> L31
        r100.set(r101[0], r101[1], r101[2]);     // Catch: Throwable -> L31
        long r102 = r110.timestamp;     // Catch: Throwable -> L31
        this.mAccTimeStamp = r102;     // Catch: Throwable -> L31
        this.mBiasEstimator.processAccelerometer(this.mAccSample, r102);     // Catch: Throwable -> L31
        if (this.mIsAlignedGravity == true) goto L28;
        this.mIsAlignedGravity = true;     // Catch: Throwable -> L31
        if (this.mSensorStartPos != 2) goto L14;
        this.mStartDirection = new Vector3d(this.mAccSample);     // Catch: Throwable -> L31
    L25:
        this.mRotationFromStart = Quaternion.rotateInto(this.mStartDirection, this.mAccSample);     // Catch: Throwable -> L31
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "rotation start:" + this.mRotationFromStart + ";acc:" + this.mAccSample.toString());     // Catch: Throwable -> L31
        this.mPreviousAccNorm = this.mAccSample.length();     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L14:
        int r111 = this.mDisplayRotation;     // Catch: Throwable -> L31
        if (r111 == 0) goto L24;
        if (r111 == 1) goto L23;
        if (r111 != 2) goto L19;
        this.mStartDirection = new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, -1.0d, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L31
        goto L25
    L19:
        if (r111 != 3) goto L25;
        this.mStartDirection = new Vector3d(-1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L31
        goto L25
    L23:
        this.mStartDirection = new Vector3d(1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L31
        goto L25
    L24:
        this.mStartDirection = new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L31
        goto L25
    L28:
        updateMeasurementCovariance();     // Catch: Throwable -> L31
        this.mInnovation = computeInnovation(this.mRotationFromStart);     // Catch: Throwable -> L31
        computeMeasurementJacobian();     // Catch: Throwable -> L31
        Matrix3x3d r112 = this.mAccMeasureJacobian.transpose();     // Catch: Throwable -> L31
        Matrix3x3d.mult(this.mAccMeasureJacobian, this.mStateCovariance, this.mInnovationCovariance);     // Catch: Throwable -> L31
        Matrix3x3d r103 = this.mInnovationCovariance;     // Catch: Throwable -> L31
        Matrix3x3d.mult(r103, r112, r103);     // Catch: Throwable -> L31
        Matrix3x3d r104 = this.mInnovationCovariance;     // Catch: Throwable -> L31
        Matrix3x3d.add(r104, this.mAccMeasureCovariance, r104);     // Catch: Throwable -> L31
        Matrix3x3d r105 = new Matrix3x3d();     // Catch: Throwable -> L31
        this.mInnovationCovariance.invert(r105);     // Catch: Throwable -> L31
        Matrix3x3d.mult(this.mStateCovariance, r112, this.mKalmanGain);     // Catch: Throwable -> L31
        Matrix3x3d r113 = this.mKalmanGain;     // Catch: Throwable -> L31
        Matrix3x3d.mult(r113, r105, r113);     // Catch: Throwable -> L31
        Vector3d r114 = new Vector3d();     // Catch: Throwable -> L31
        Matrix3x3d.mult(this.mKalmanGain, this.mInnovation, r114);     // Catch: Throwable -> L31
        Matrix3x3d r106 = new Matrix3x3d();     // Catch: Throwable -> L31
        Matrix3x3d.mult(this.mKalmanGain, this.mAccMeasureJacobian, r106);     // Catch: Throwable -> L31
        Matrix3x3d r107 = new Matrix3x3d();     // Catch: Throwable -> L31
        r107.setIdentity();     // Catch: Throwable -> L31
        r107.minusEquals(r106);     // Catch: Throwable -> L31
        Matrix3x3d r108 = this.mStateCovariance;     // Catch: Throwable -> L31
        Matrix3x3d.mult(r107, r108, r108);     // Catch: Throwable -> L31
        Quaternion r115 = rotationFromVector(r114);     // Catch: Throwable -> L31
        this.mRotationFromStart = r115.times(this.mRotationFromStart);     // Catch: Throwable -> L31
        updateStateCovariance(Matrix3x3d.rotationMatrix3x3(r115));     // Catch: Throwable -> L31
        monitor-exit(this);
    }

    public synchronized void processGyro(SensorEvent r110) {
        monitor-enter(this);
        long r100 = this.mGyroTimeStamp;     // Catch: Throwable -> L27
        long r101 = r110.timestamp;     // Catch: Throwable -> L27
        if (r100 <= r101) goto L9;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "lastTime > curTime, return");     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L9:
        if (r100 <= 0) goto L24;
        double r102 = (r101 - r100) * NANO_TO_SEC;
        if (this.mGyroTimeFilter != null) goto L15;
        this.mGyroTimeFilter = new TimeFilter();     // Catch: Throwable -> L27
    L15:
        if (r102 > this.MAX_GYRO_DELAY) goto L17;
        this.mGyroTimeFilter.addSample(r102);     // Catch: Throwable -> L27
    L21:
        Vector3d r103 = this.mGyroSample;     // Catch: Throwable -> L27
        float[] r104 = r110.values;     // Catch: Throwable -> L27
        r103.set(r104[0], r104[1], r104[2]);     // Catch: Throwable -> L27
        this.mBiasEstimator.processGyroscope(this.mGyroSample, r110.timestamp);     // Catch: Throwable -> L27
        this.mBiasEstimator.getGyroBias(this.mGyroBias);     // Catch: Throwable -> L27
        if (this.mIsAlignedGravity == false) goto L24;
        Quaternion r105 = getRotationFromGyro(this.mGyroSample.sub(this.mGyroBias), r102);     // Catch: Throwable -> L27
        this.mRotationFromStart = r105.times(this.mRotationFromStart);     // Catch: Throwable -> L27
        updateStateCovariance(Matrix3x3d.rotationMatrix3x3(r105));     // Catch: Throwable -> L27
        this.mStateCovariance.plusEquals(this.mProcessCovariance.mult(r102 * r102));     // Catch: Throwable -> L27
        goto L24
    L17:
        if (this.mGyroTimeFilter.isFilterValid() == false) goto L19;
        r102 = this.mGyroTimeFilter.getFilteredTime();     // Catch: Throwable -> L27
        goto L21
    L19:
        r102 = DEFAULT_GYRO_TIME;
    L24:
        this.mGyroTimeStamp = r110.timestamp;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public void setDisplayRotation(int r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "display rotation:" + r100);
        if (this.mDisplayRotation == r100) goto L5;
        this.mPreviousRotation = null;
    L5:
        this.mDisplayRotation = r100;
    }

    public void setIsDisableZrotation(boolean r100) {
        this.mIsDisableZrotation = r100;
    }

    public void setRotationFromStart(Quaternion r100) {
        this.mLastRotationFromStart = r100;
        this.mPreviousRotation = null;
    }

    public void setSensorStartPos(int r100) {
        this.mSensorStartPos = r100;
    }

    private Quaternion getRotationFromGyro(Vector3d r100, double r101) {
        double r102 = r100.length();
        if (r102 >= EPSILON) goto L7;
        return new Quaternion();
    L7:
        return Quaternion.fromAxisAndAngle(r100.devide(r102), (-r101) * r102);
    }

    public void setGyroSmootherParam(boolean r100, double r101) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "enable smoother:" + r100 + ",factor:" + r101);
        this.mGyroEnableSmoother = r100;
        this.mGyroSmoothFactor = r101;
    }

    private Quaternion slerp(Quaternion r310, Quaternion r311, double r312) {
        double r100 = r310.getX0();
        double r101 = r310.getX1();
        double r102 = r310.getX2();
        double r103 = r310.getX3();
        double r104 = r311.getX0();
        double r110 = r311.getX1();
        double r111 = r311.getX2();
        double r112 = r311.getX3();
        double r113 = (((r103 * r112) + (r100 * r104)) + (r101 * r110)) + (r102 * r111);
        if (Math.abs(r113) >= 1.0d) goto L5;
        double r114 = Math.acos(r113);
        double r115 = Math.sqrt(1.0d - (r113 * r113));
        if (Math.abs(r115) >= 0.001d) goto L10;
        double r210 = (r100 * 0.5d) + (r104 * 0.5d);
        double r211 = (r101 * 0.5d) + (r110 * 0.5d);
        double r212 = (r102 * 0.5d) + (r111 * 0.5d);
        return new Quaternion(r210, r211, r212, (r103 * 0.5d) + (r112 * 0.5d));
    L10:
        double r213 = Math.sin((1.0d - r312) * r114) / r115;
        double r116 = Math.sin(r114 * r312) / r115;
        double r214 = (r100 * r213) + (r104 * r116);
        double r215 = (r101 * r213) + (r110 * r116);
        double r216 = (r102 * r213) + (r111 * r116);
        return new Quaternion(r214, r215, r216, (r103 * r213) + (r112 * r116));
    L5:
        return new Quaternion(r100, r101, r102, r103);
    }

    public boolean processScroll(MotionEvent r110, MotionEvent r111, float r112, float r210) {
        this.mRotationFromStart = Quaternion.rotateInto(new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, -this.mRadius), new Vector3d(-r112, r210, -this.mRadius)).times(this.mRotationFromStart);
        return true;
    }
}
