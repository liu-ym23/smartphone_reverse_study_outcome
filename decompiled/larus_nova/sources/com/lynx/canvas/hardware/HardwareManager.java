package com.lynx.canvas.hardware;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class HardwareManager implements KryptonSensorService.Listener {
    private static final int GYROSCOPE_SENSOR_AVAILABLE = 2;
    private static final ArrayList<Integer> MONITOR_GYROSCOPE_TYPE_LIST = null;
    private static final int ORIENTATION_SENSOR_AVAILABLE = 4;
    private static final int SENSOR_AVAILABILITY_KNOWN = 1;
    private static final String TAG = "KryptonHardwareManager";
    private final long mNativePtr;
    private boolean mReleased;
    private KryptonSensorService mSensorService;

    private static native void nativeNotifyGyroscopeData(long r100, float r101, float r102, float r103, long r104);

    private static native void nativeNotifyOrientationData(long r100, float r101, float r102, float r103, long r104);

    private static ArrayList<Integer> monitorGyroscopeSensorTypeList() {
        ArrayList<Integer> r100 = new ArrayList();
        r100.add(new Integer(4));
        r100.add(new Integer(15));
        return r100;
    }

    private void stopMonitorGyroscope() {
        KryptonSensorService r100 = this.mSensorService;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    static {
        MONITOR_GYROSCOPE_TYPE_LIST = monitorGyroscopeSensorTypeList();
    }

    private void release() {
        stopMonitorGyroscope();
        monitor-enter(this);
        this.mReleased = true;     // Catch: Throwable -> L10
        KryptonSensorService r100 = this.mSensorService;     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        r100.setListener(null);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int startMonitorGyroscope(int r100) {
        KryptonSensorService r101 = this.mSensorService;
        int r102 = 0;
        if (r101 != null) goto L6;
        KryptonLLog.e(TAG, "startMonitorGyroscope error: no sensor service");
        return 0;
    L6:
        ArrayList<Integer> r103 = MONITOR_GYROSCOPE_TYPE_LIST;
        List<Integer> r104 = r101.getAvailableSensorTypes(r103);
        if (r104 != null) goto L9;
    L15:
        this.mSensorService.start(r103, r100);
        return r102;
    L9:
        if (r104.contains(4) == false) goto L11;
        r102 = 3;
    L13:
        if (r104.contains(15) == false) goto L15;
        r102 = r102 | 4;
        goto L15
    L11:
        r102 = 1;
        goto L13
    }

    public HardwareManager(long r100, KryptonApp r101) {
        this.mNativePtr = r100;
        KryptonSensorService r102 = (KryptonSensorService) r101.getService(KryptonSensorService.class);
        this.mSensorService = r102;
        if (r102 == null) goto L5;
        r102.setListener(this);
        return;
    L5:
        KryptonLLog.e(TAG, "no sensor service found");
    }

    private static HardwareManager createInstance(long r100, KryptonApp r101) {
        return new HardwareManager(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyGyroscopeData(float r100, float r110, float r111, long r112) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReleased == true) goto L6;
        nativeNotifyGyroscopeData(this.mNativePtr, r100, r110, r111, r112);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyOrientationData(float r100, float r110, float r111, long r112) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReleased == true) goto L6;
        nativeNotifyOrientationData(this.mNativePtr, r100, r110, r111, r112);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }
}
