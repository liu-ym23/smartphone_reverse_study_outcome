package com.ss.texturerender.effect.vr.director.sensordirector;

import androidx.camera.video.AudioStats;
import com.ss.texturerender.math.Vector3d;

/* JADX INFO: loaded from: classes40.dex */
public class GyroBiasEstimator {
    private static final float ACCEL_DIFF_STATIC_THRESHOLD = 0.5f;
    private static final float ACCEL_LOWPASS_FREQ = 1.0f;
    private static final float GYRO_BIAS_LOWPASS_FREQ = 0.15f;
    private static final float GYRO_DIFF_STATIC_THRESHOLD = 0.008f;
    private static final float GYRO_FOR_BIAS_THRESHOLD = 0.3f;
    private static final float GYRO_LOWPASS_FREQ = 10.0f;
    private static final int IS_STATIC_NUM_FRAMES_THRESHOLD = 10;
    private static final int NUM_GYRO_BIAS_SAMPLES_INITIAL_SMOOTHING = 100;
    private static final int NUM_GYRO_BIAS_SAMPLES_THRESHOLD = 30;
    private LowPassFilter accelLowPass;
    private LowPassFilter gyroBiasLowPass;
    private LowPassFilter gyroLowPass;
    private IsStaticCounter isAccelStatic;
    private IsStaticCounter isGyroStatic;
    private Vector3d smoothedAccelDiff;
    private Vector3d smoothedGyroDiff;

    public static class IsStaticCounter {
        private int consecutiveIsStatic;
        private final int minStaticFrames;

        public boolean isRecentlyStatic() {
            if (this.consecutiveIsStatic < this.minStaticFrames) goto L5;
            return true;
        L5:
            return false;
        }

        public IsStaticCounter(int r100) {
            this.minStaticFrames = r100;
        }

        public void appendFrame(boolean r100) {
            if (r100 == true) goto L4;
            this.consecutiveIsStatic = 0;
            return;
        L4:
            this.consecutiveIsStatic++;
        }
    }

    public void reset() {
        this.smoothedGyroDiff = new Vector3d();
        this.smoothedAccelDiff = new Vector3d();
        this.accelLowPass = new LowPassFilter(1.0d);
        this.gyroLowPass = new LowPassFilter(10.0d);
        this.gyroBiasLowPass = new LowPassFilter(0.15000000596046448d);
        this.isAccelStatic = new IsStaticCounter(10);
        this.isGyroStatic = new IsStaticCounter(10);
    }

    public GyroBiasEstimator() {
        reset();
    }

    public void getGyroBias(Vector3d r100) {
        if (this.gyroBiasLowPass.getNumSamples() >= 30) goto L5;
        r100.setZero();
        return;
    L5:
        r100.set(this.gyroBiasLowPass.getFilteredData());
        r100.scale(Math.min(1.0d, ((double) (this.gyroBiasLowPass.getNumSamples() - 30)) / 100.0d));
    }

    private void updateGyroBias(Vector3d r100, long r110) {
        double r101 = r100.length();
        if (r101 >= 0.30000001192092896d) goto L6;
        double r102 = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d - (r101 / 0.30000001192092896d));
        LowPassFilter r103 = this.gyroBiasLowPass;
        Vector3d r104 = this.gyroLowPass.getFilteredData();
        r103.addWeightedSample(r104, r110, r102 * r102);
        return;
    }

    public void processAccelerometer(Vector3d r100, long r101) {
        this.accelLowPass.addSample(r100, r101);
        Vector3d.sub(r100, this.accelLowPass.getFilteredData(), this.smoothedAccelDiff);
        IsStaticCounter r102 = this.isAccelStatic;
        if (this.smoothedAccelDiff.length() >= 0.5d) goto L5;
        boolean r103 = true;
    L6:
        r102.appendFrame(r103);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void processGyroscope(Vector3d r100, long r101) {
        this.gyroLowPass.addSample(r100, r101);
        Vector3d.sub(r100, this.gyroLowPass.getFilteredData(), this.smoothedGyroDiff);
        IsStaticCounter r102 = this.isGyroStatic;
        if (this.smoothedGyroDiff.length() >= 0.00800000037997961d) goto L5;
        boolean r103 = true;
    L6:
        r102.appendFrame(r103);
        if (this.isGyroStatic.isRecentlyStatic() == true) goto L9;
        return;
    L9:
        if (this.isAccelStatic.isRecentlyStatic() == false) goto L13;
        updateGyroBias(r100, r101);
        return;
    L13:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
