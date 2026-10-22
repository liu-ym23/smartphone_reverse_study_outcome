package com.bytedance.realx.base;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes21.dex */
public class RXPerformanceMonitorAndroid implements ComponentCallbacks2 {
    private static final FileFilter CPU_IDLE_STATE_FILTER = null;
    private static final float ERROR_RESULT = 0.0f;
    private static int mCpuCoreCount;
    private static int mCpuIdleStateCount;
    private static int mMemoryState;
    private static boolean mMemoryStateRegisterd;
    private static RXPerformanceMonitorAndroid mPerformanceMonitor;
    private static int mThermalState;

    public RXPerformanceMonitorAndroid() {
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
        mPerformanceMonitor = new RXPerformanceMonitorAndroid();
    }

    public static boolean getIfRoomsDevice() {
        if ("a3382".equals(Build.MODEL.toLowerCase()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static int getThermalState() {
        if (Build.VERSION.SDK_INT < 29) goto L13;
        if (mThermalState != (-1)) goto L13;
        PowerManager.OnThermalStatusChangedListener r100 = new AnonymousClass2();
        mThermalState = 4;
        PowerManager r101 = (PowerManager) ContextUtils.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r101 == null) goto L16;
        int r102 = r101.getCurrentThermalStatus();     // Catch: Exception -> L10
        mThermalState = r102;     // Catch: Exception -> L10
        mThermalState = convertThermalState(r102);
        r101.addThermalStatusListener(r100);
    L11:
        return mThermalState;
    L16:
        return mThermalState;
    L13:
        if (mThermalState != (-1)) goto L16;
        mThermalState = 4;
        goto L16
    }

    public static int getCurrentPidMemorySize() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L11;
        return 0;
    L11:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L10
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
    L10:
        return 0;
    }

    public static int getJavaAppMemoryUsage() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L11;
        return 0;
    L11:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L10
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getProcessMemoryInfo(new int[]{Process.myPid()})[0].dalvikPss;
    L10:
        return 0;
    }

    public static int getMemoryState() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (mMemoryStateRegisterd == true) goto L10;
        r100.registerComponentCallbacks(mPerformanceMonitor);
        mMemoryStateRegisterd = true;
    L10:
        return mMemoryState;
    }

    public static int getThreadCount() {
        return Thread.activeCount();
    }

    public static /* synthetic */ int access$002(int r100) {
        mThermalState = r100;
        return r100;
    }

    public static /* synthetic */ int access$100(int r100) {
        return convertThermalState(r100);
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
