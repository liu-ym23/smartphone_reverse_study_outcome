package com.lynx.canvas.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import faceverify.w;
import fna.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonDefaultSensorService extends KryptonSensorService {
    private static final String TAG = "KryptonDefaultSensorService";
    private HashMap<Integer, Sensor> mCachedSensors;
    private final Invoker mInvoker;
    private KryptonSensorService.Listener mListener;
    private SensorEventListener mOrientationListener;
    private final SensorManager mSensorManager;

    public interface Invoker {
        boolean registerSensorListener(SensorManager r100, SensorEventListener r101, Sensor r102, int r103);

        void unregisterSensorListener(SensorManager r100, SensorEventListener r101);
    }

    private void initSensorEventListener() {
        this.mOrientationListener = new AnonymousClass1(this);
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void stop() {
        Invoker r100 = this.mInvoker;
        if (r100 == null) goto L5;
        r100.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
        return;
    L5:
        INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mSensorManager, this.mOrientationListener);
    }

    public static /* synthetic */ KryptonSensorService.Listener access$000(KryptonDefaultSensorService r100) {
        return r100.mListener;
    }

    private Collection<Sensor> getSensors(List<Integer> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L40;
        HashMap<Integer, Sensor> r101 = this.mCachedSensors;
        if (r101 != null) goto L10;
        this.mCachedSensors = new HashMap();
    L22:
        Iterator<Integer> r102 = r100.iterator();
    L24:
        if (r102.hasNext() == false) goto L29;
        Integer r103 = r102.next();
        Sensor r104 = this.mSensorManager.getDefaultSensor(r103.intValue());
        if (r104 == null) goto L24;
        this.mCachedSensors.put(r103, r104);
        goto L24
    L29:
        return this.mCachedSensors.values();
    L10:
        if (r101.size() == r100.size()) goto L12;
        this.mCachedSensors.clear();
        goto L22
    L12:
        Iterator<Integer> r105 = r100.iterator();
    L14:
        if (r105.hasNext() == false) goto L19;
        Integer r106 = r105.next();
        if (this.mCachedSensors.containsKey(r106) == true) goto L14;
        this.mCachedSensors.clear();
    L19:
        if (this.mCachedSensors.isEmpty() == true) goto L22;
        return this.mCachedSensors.values();
    L40:
        return null;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public List<Integer> getAvailableSensorTypes(List<Integer> r100) {
        if (this.mSensorManager == null) goto L15;
        if (r100 == null) goto L24;
        ArrayList r101 = new ArrayList();
        Iterator<Integer> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Integer r103 = r102.next();
        if (r103 == null) goto L8;
        if (this.mSensorManager.getDefaultSensor(r103.intValue()) == null) goto L8;
        r101.add(r103);
        goto L8
    L14:
        return r101;
    L24:
        return null;
    L15:
        return null;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void setListener(KryptonSensorService.Listener r100) {
        monitor-enter(this);
        this.mListener = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public KryptonDefaultSensorService(Context r100, Invoker r101) {
        this.mSensorManager = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.mInvoker = r101;
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101) {
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

    @Override // com.lynx.canvas.KryptonSensorService
    public boolean start(List<Integer> r100, int r101) {
        if (this.mSensorManager != null) goto L6;
        KryptonLLog.e(TAG, "get system sensor service error");
        return false;
    L6:
        Collection<Sensor> r102 = getSensors(r100);
        if (r102 != null) goto L9;
    L26:
        KryptonLLog.e(TAG, "start error with empty type list");
        return false;
    L9:
        if (r102.isEmpty() == true) goto L26;
        if (this.mOrientationListener != null) goto L14;
        initSensorEventListener();
    L14:
        int r103 = r101 * 1000;
        Invoker r104 = this.mInvoker;
        if (r104 == null) goto L20;
        r104.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
        Iterator<Sensor> r105 = r102.iterator();
    L18:
        if (r105.hasNext() == false) goto L24;
        Sensor r106 = r105.next();
        this.mInvoker.registerSensorListener(this.mSensorManager, this.mOrientationListener, r106, r103);
        goto L18
    L24:
        return true;
    L20:
        INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mSensorManager, this.mOrientationListener);
        Iterator<Sensor> r107 = r102.iterator();
    L22:
        if (r107.hasNext() == false) goto L30;
        Sensor r108 = r107.next();
        this.mSensorManager.registerListener(this.mOrientationListener, r108, r103);
        goto L22
    L30:
        return true;
    }
}
