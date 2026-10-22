package com.ss.texturerender.effect.vr.director.sensordirector;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.effect.vr.director.IDirectorEventListener;
import com.ss.texturerender.math.Matrix3x3d;
import com.ss.texturerender.math.Quaternion;
import faceverify.w;

/* JADX INFO: loaded from: classes40.dex */
public class SensorDirector extends GestureDetector.SimpleOnGestureListener implements IDirector, SensorEventListener {
    private final String LOG_TAG;
    private int mDirectMode;
    private IDirectorEventListener mDirectorEventListener;
    private Display mDisplay;
    private SensorFusionEkf mFusionEkf;
    private Quaternion mLastRotation;
    private SensorHelper mSensorEventProvider;
    private boolean mSensorResetPosKeepFix;
    private int mSensorStartPos;
    private int mTexType;
    private boolean resetSensorAfterDisplayRotationChange;
    private volatile boolean tracking;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r100, int r101) {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
        this.mLastRotation = new Quaternion();
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
        if (this.tracking == true) goto L17;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "start");
        this.mSensorEventProvider.registerListener(this);
        this.mSensorEventProvider.start();
        SensorFusionEkf r100 = this.mFusionEkf;
        if (r100 != null) goto L7;
    L15:
        this.tracking = true;
        return;
    L7:
        if (r100.isAlignedGravity() == true) goto L9;
        this.mFusionEkf.reset();
    L14:
        testRotationChange(true);
        goto L15
    L9:
        this.mFusionEkf.reset();
        if (this.mSensorResetPosKeepFix == true) goto L12;
    L13:
        this.mFusionEkf.setSensorStartPos(2);
        this.mFusionEkf.setRotationFromStart(this.mLastRotation);
        goto L14
    L12:
        if (this.mSensorStartPos == 1) goto L14;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
        if (this.tracking == false) goto L6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "stop");
        this.mSensorEventProvider.unregisterListener(this);
        this.mSensorEventProvider.stop();
        this.tracking = false;
        return;
    }

    private void testRotationChange(boolean r100) {
        int r101 = this.mDisplay.getRotation();
        if (r101 == this.mFusionEkf.getDisplayRotation()) goto L10;
        if (r100 == false) goto L6;
        this.mFusionEkf.reset();
    L6:
        this.mFusionEkf.setDisplayRotation(r101);
        this.mFusionEkf.setSensorStartPos(this.mSensorStartPos);
        IDirectorEventListener r102 = this.mDirectorEventListener;
        if (r102 == null) goto L11;
        r102.onDisplayRotationChanged(r101, r100);
        return;
    L11:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r100) {
        if (r100.sensor.getType() != 1) goto L6;
        this.mFusionEkf.processAcc(r100);
        return;
    L6:
        if (r100.sensor.getType() != 4) goto L8;
    L9:
        this.mFusionEkf.processGyro(r100);
        return;
    L8:
        if (r100.sensor.getType() == 16) goto L9;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle r100) {
        if (r100 == null) goto L16;
        SensorFusionEkf r101 = this.mFusionEkf;
        if (r101 == null) goto L11;
        if (r100.getInt(TextureRenderKeys.KEY_IS_INT_DISABLE_AXIS) != 3) goto L8;
        boolean r102 = true;
    L9:
        r101.setIsDisableZrotation(r102);
        goto L11
    L8:
        r102 = false;
    L11:
        if (this.mSensorEventProvider != null) goto L13;
        return;
    L13:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_CERT) == false) goto L18;
        this.mSensorEventProvider.setCert(r100.getSerializable(TextureRenderKeys.KEY_IS_CERT));
        return;
    L18:
        return;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] r100, int r101) {
        testRotationChange(this.resetSensorAfterDisplayRotationChange);
        if (this.mFusionEkf.isAlignedGravity() == false) goto L5;
        this.mLastRotation = this.mFusionEkf.getRotation();
    L5:
        Matrix3x3d.matrixToColumnArray(Matrix3x3d.rotationMatrix3x3(this.mLastRotation), r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (this.mDirectMode != 1) goto L7;
        return false;
    L7:
        return this.mFusionEkf.processScroll(r100, r101, r102, r103);
    }

    public SensorDirector(Context r100, Display r101, int r102, int r103, int r104, int r105, double r110, IDirectorEventListener r111) {
        boolean r106 = true;
        this.mDirectMode = 1;
        this.mLastRotation = new Quaternion();
        this.mTexType = -1;
        this.resetSensorAfterDisplayRotationChange = false;
        this.mDirectorEventListener = null;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r104;
        this.mSensorEventProvider = new SensorHelper((SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR));
        this.mDisplay = r101;
        SensorFusionEkf r107 = new SensorFusionEkf(this.mTexType);
        this.mFusionEkf = r107;
        if (r105 != 1) goto L5;
        boolean r108 = true;
    L6:
        r107.setGyroSmootherParam(r108, r110);
        this.mFusionEkf.setSensorStartPos(r102);
        this.mFusionEkf.setDisplayRotation(this.mDisplay.getRotation());
        this.mSensorStartPos = r102;
        if (r103 == 1) goto L10;
        r106 = false;
    L10:
        this.mSensorResetPosKeepFix = r106;
        this.mDirectorEventListener = r111;
        return;
    L5:
        r108 = false;
        goto L6
    }
}
