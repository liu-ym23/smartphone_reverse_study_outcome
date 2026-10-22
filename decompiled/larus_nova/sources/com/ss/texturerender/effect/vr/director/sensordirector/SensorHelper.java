package com.ss.texturerender.effect.vr.director.sensordirector;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.texturerender.TextureRenderLog;
import faceverify.w;
import fna.g;
import java.io.Serializable;
import java.util.ArrayList;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: classes40.dex */
public class SensorHelper {
    private final String LOG_TAG;
    private boolean isRunning;
    private Cert mCert;
    private int mTexType;
    private final ArrayList<SensorEventListener> registeredListeners;
    private SensorEventListener sensorEventListener;
    private Looper sensorLooper;
    private SensorManager sensorManager;

    public void setCert(Serializable r100) {
    }

    private Sensor getUncalibratedGyro() {
        if (Build.MANUFACTURER.equals("HTC") == false) goto L6;
        return null;
    L6:
        return this.sensorManager.getDefaultSensor(16);
    }

    public void start() {
        if (this.isRunning == true) goto L6;
        this.sensorEventListener = new AnonymousClass1(this);
        final String r100 = w.BLOB_ELEM_TYPE_SENSOR;
        PthreadHandlerThreadV2 r101 = new AnonymousClass2(this, r100);
        ThreadMethodProxy.start(r101);
        this.sensorLooper = r101.getLooper();
        this.isRunning = true;
        return;
    }

    public void stop() {
        if (this.isRunning == false) goto L6;
        INVOKEVIRTUAL_com_ss_texturerender_effect_vr_director_sensordirector_SensorHelper_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.sensorManager, this.sensorEventListener);
        this.sensorEventListener = null;
        ThreadMethodProxy.quit(this.sensorLooper);
        this.sensorLooper = null;
        this.isRunning = false;
        return;
    }

    public SensorHelper(SensorManager r100) {
        this.mCert = null;
        this.registeredListeners = new ArrayList();
        this.mTexType = -1;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.sensorManager = r100;
    }

    public static /* synthetic */ ArrayList access$000(SensorHelper r100) {
        return r100.registeredListeners;
    }

    public static /* synthetic */ SensorManager access$100(SensorHelper r100) {
        return r100.sensorManager;
    }

    public static /* synthetic */ SensorEventListener access$200(SensorHelper r100) {
        return r100.sensorEventListener;
    }

    public static /* synthetic */ Sensor access$300(SensorHelper r100) {
        return r100.getUncalibratedGyro();
    }

    public static /* synthetic */ int access$400(SensorHelper r100) {
        return r100.mTexType;
    }

    public static /* synthetic */ String access$500(SensorHelper r100) {
        return r100.LOG_TAG;
    }

    public void registerListener(SensorEventListener r100) {
        ArrayList<SensorEventListener> r101 = this.registeredListeners;
        monitor-enter(r101);
        this.registeredListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterListener(SensorEventListener r100) {
        ArrayList<SensorEventListener> r101 = this.registeredListeners;
        monitor-enter(r101);
        this.registeredListeners.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_com_ss_texturerender_effect_vr_director_sensordirector_SensorHelper_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        b.c(new a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }
}
