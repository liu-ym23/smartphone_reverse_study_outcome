package com.bytedance.bmmt.base;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.PowerManager;
import android.os.Process;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes8.dex */
public class PerformanceMonitorAndroid implements ComponentCallbacks2 {
    private static final FileFilter CPU_IDLE_STATE_FILTER = null;
    private static final float ERROR_RESULT = 0.0f;
    private static int mCpuCoreCount;
    private static int mCpuIdleStateCount;
    private static int mMemoryState;
    private static boolean mMemoryStateRegisterd;
    private static PerformanceMonitorAndroid mPerformanceMonitor;
    private static int mThermalState;

    public PerformanceMonitorAndroid() {
    }

    public static /* bridge */ /* synthetic */ void a(int r100) {
        mThermalState = r100;
    }

    public static /* bridge */ /* synthetic */ int b(int r100) {
        return convertThermalState(r100);
    }

    private static int convertThermalState(int r100) {
        switch(r100) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L4;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return 4;
    L4:
        return 3;
    L5:
        return 2;
    L6:
        return 1;
    L7:
        return 0;
    }

    private static int getCpuIdleStateCount() {
        File[] r100 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu0/cpuidle/").listFiles(CPU_IDLE_STATE_FILTER);     // Catch: Exception -> L7
        if (r100 == null) goto L10;
        return r100.length;
    L10:
        return 0;
    L11:
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    static {
        CPU_IDLE_STATE_FILTER = new AnonymousClass1();
        mCpuCoreCount = -1;
        mCpuIdleStateCount = -1;
        mThermalState = -1;
        mMemoryState = 0;
        mMemoryStateRegisterd = false;
        mPerformanceMonitor = new PerformanceMonitorAndroid();
    }

    public static boolean getIfRoomsDevice() {
        if ("a3382".equals(Build.MODEL.toLowerCase()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static int getThermalState() {
        if (Build.VERSION.SDK_INT < 29) goto L17;
        if (mThermalState != (-1)) goto L17;
        PowerManager.OnThermalStatusChangedListener r100 = new AnonymousClass2();
        mThermalState = 4;
        Context r101 = ContextUtils.getApplicationContext();
        if (r101 == null) goto L9;
        PowerManager r102 = (PowerManager) r101.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r102 == null) goto L20;
        int r103 = r102.getCurrentThermalStatus();     // Catch: Exception -> L14
        mThermalState = r103;     // Catch: Exception -> L14
        mThermalState = convertThermalState(r103);
        r102.addThermalStatusListener(r100);
    L15:
        return mThermalState;
    L20:
        return mThermalState;
    L9:
        return mThermalState;
    L17:
        if (mThermalState != (-1)) goto L20;
        mThermalState = 4;
        goto L20
    }

    public static int getCurrentPidMemorySize() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L19;
        return 0;
    L19:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L18
        if (r101 != null) goto L8;
        return 0;
    L8:
        Debug.MemoryInfo[] r102 = r101.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Exception -> L18
        if (r102 == null) goto L17;
        if (r102.length == 0) goto L17;
        Debug.MemoryInfo r103 = r102[0];     // Catch: Exception -> L18
        if (r103 == null) goto L17;
        return r103.getTotalPss();
    L17:
        return 0;
    }

    public static int getJavaAppMemoryUsage() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L19;
        return 0;
    L19:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L18
        if (r101 != null) goto L8;
        return 0;
    L8:
        Debug.MemoryInfo[] r102 = r101.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Exception -> L18
        if (r102 == null) goto L17;
        if (r102.length == 0) goto L17;
        Debug.MemoryInfo r103 = r102[0];     // Catch: Exception -> L18
        if (r103 == null) goto L17;
        return r103.dalvikPss;
    L17:
        return 0;
    }

    public static int getMemoryState() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (mMemoryStateRegisterd == true) goto L19;
        monitor-enter(PerformanceMonitorAndroid.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (mMemoryStateRegisterd == true) goto L13;
        r100.registerComponentCallbacks(mPerformanceMonitor);     // Catch: Throwable -> L15
        mMemoryStateRegisterd = true;     // Catch: Throwable -> L15
    L13:
        monitor-exit(PerformanceMonitorAndroid.class);     // Catch: Throwable -> L15
    L19:
        return mMemoryState;
    }

    public static int getThreadCount() {
        return Thread.activeCount();
    }

    public static void setThermalState(int r100) {
        mThermalState = r100;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r100) {
        if (r100 != 5) goto L5;
        mMemoryState = 1;
        return;
    L5:
        if (r100 != 10) goto L7;
        mMemoryState = 2;
        return;
    L7:
        if (r100 != 15) goto L9;
        mMemoryState = 3;
        return;
    L9:
        if (r100 != 20) goto L11;
        mMemoryState = 4;
        return;
    L11:
        if (r100 != 40) goto L13;
        mMemoryState = 5;
        return;
    L13:
        if (r100 != 60) goto L15;
        mMemoryState = 6;
        return;
    L15:
        if (r100 != 80) goto L31;
        mMemoryState = 7;
        return;
    }
}
