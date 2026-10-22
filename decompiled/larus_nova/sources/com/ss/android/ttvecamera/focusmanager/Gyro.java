package com.ss.android.ttvecamera.focusmanager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.TELogUtils;
import faceverify.w;
import java.util.concurrent.CopyOnWriteArrayList;
import rc4.a;

/* JADX INFO: loaded from: classes38.dex */
public class Gyro {
    private static final float ANGLE_TOLERANCE = 0.5f;
    private static final float NS2S = 1.0E-9f;
    private static final float SPEED_TOLERANCE = 0.5f;
    private static final String TAG = "Gyro";
    private final float[] mAngles;
    private final CopyOnWriteArrayList<GyroListener> mListeners;
    private final Sensor mSensor;
    private final SensorEventListener mSensorEventListener;
    private final SensorManager mSensorManager;
    private float mTimestamp;

    public interface GyroListener {
        void onChange();
    }

    private void clearAngle() {
        TELogUtils.d(TAG, "clearAngle");
        float[] r100 = this.mAngles;
        r100[0] = 0.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
    }

    public boolean isSupportGyro() {
        if (this.mSensorManager != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        TELogUtils.i(TAG, "isSupportGyro = " + r100);
        return r100;
    L5:
        if (this.mSensor == null) goto L7;
        r100 = true;
        goto L8
    }

    public Gyro(Context r100) {
        this.mAngles = new float[3];
        this.mListeners = new CopyOnWriteArrayList();
        this.mSensorEventListener = new AnonymousClass1(this);
        TELogUtils.d(TAG, TAG);
        if (r100 == null) goto L5;
        SensorManager r101 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.mSensorManager = r101;
        this.mSensor = r101.getDefaultSensor(4);
        return;
    L5:
        this.mSensorManager = null;
        this.mSensor = null;
        TELogUtils.e(TAG, "Gyro init failed, no context");
    }

    public static /* synthetic */ float access$000(Gyro r100) {
        return r100.mTimestamp;
    }

    public static /* synthetic */ float[] access$100(Gyro r100) {
        return r100.mAngles;
    }

    public static /* synthetic */ CopyOnWriteArrayList access$200(Gyro r100) {
        return r100.mListeners;
    }

    public static /* synthetic */ void access$300(Gyro r100) {
        r100.clearAngle();
    }

    public void destroy(Cert r100) {
        TELogUtils.i(TAG, "destroy sensor, Cert: " + r100);
        this.mListeners.clear();
        clearAngle();
        SensorManager r101 = this.mSensorManager;
        if (r101 == null) goto L13;
        Sensor r102 = this.mSensor;
        if (r102 == null) goto L14;
        a.b(r101, this.mSensorEventListener, r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        TELogUtils.w(TAG, "sensorManager unregister listener exception occurred.", e);
        return;
    L14:
        return;
    }

    public static /* synthetic */ float access$002(Gyro r100, float r101) {
        r100.mTimestamp = r101;
        return r101;
    }

    public void unregister(GyroListener r100, Cert r101) {
        if (this.mSensorManager != null) goto L5;
    L16:
        TELogUtils.e(TAG, "unregister sensor, mSensorManager or mSensor is null.");
        return;
    L5:
        if (this.mSensor == null) goto L16;
        TELogUtils.i(TAG, "unregister sensor, Cert: " + r101);
        this.mListeners.remove(r100);
        if (this.mListeners.isEmpty() == true) goto L18;
    L14:
        clearAngle();
        return;
    L18:
        a.b(this.mSensorManager, this.mSensorEventListener, this.mSensor);     // Catch: Exception -> L11
    L13:
        TELogUtils.d(TAG, "sensorManager unregister listener");
    L11:
        e = move-exception;
        TELogUtils.w(TAG, "sensorManager unregister listener exception occurred.", e);
        goto L13
    }

    public void register(GyroListener r100, Handler r101, Cert r102) {
        if (this.mSensorManager != null) goto L5;
    L19:
        TELogUtils.e(TAG, "register sensor, mSensorManager or mSensor is null.");
        return;
    L5:
        if (this.mSensor == null) goto L19;
        if (this.mListeners.contains(r100) == false) goto L10;
        return;
    L10:
        TELogUtils.i(TAG, "register sensor, Cert: " + r102);
        this.mListeners.add(r100);
        if (this.mListeners.size() == 1) goto L21;
    L17:
        clearAngle();
        return;
    L21:
        a.a(this.mSensorManager, this.mSensorEventListener, this.mSensor, r101);     // Catch: Exception -> L14
    L16:
        TELogUtils.d(TAG, "sensorManager register listener");
    L14:
        e = move-exception;
        TELogUtils.w(TAG, "sensorManager register listener exception occurred.", e);
        this.mListeners.remove(r100);
        goto L16
    }
}
