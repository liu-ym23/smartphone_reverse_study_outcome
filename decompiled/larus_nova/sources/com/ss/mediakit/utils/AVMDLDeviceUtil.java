package com.ss.mediakit.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDeviceUtil {
    public static String sBoard;
    public static String sHardware;

    public AVMDLDeviceUtil() {
    }

    public static String getDeviceBoard() {
    L6:
        sBoard = null;
    L8:
        return sBoard;
    L3:
        if (sBoard != null) goto L8;
        sBoard = Build.BOARD;     // Catch: Throwable -> L6
        goto L8
    }

    public static String getDeviceHardware() {
    L6:
        sHardware = null;
    L8:
        return sHardware;
    L3:
        if (sHardware != null) goto L8;
        sHardware = Build.HARDWARE;     // Catch: Throwable -> L6
        goto L8
    }

    private static StatFs getSdcardState() {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L5;
        return null;
    L5:
        return new StatFs(Environment.getExternalStorageDirectory().getPath());
    }

    public static long getTotalFreeStorageKB() {
        StatFs r100 = getSdcardState();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return (((long) r100.getAvailableBlocks()) * ((long) r100.getBlockSize())) / 1024;
    }

    public static long getTotalStorageSpaceKB() {
        StatFs r100 = getSdcardState();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return (r100.getBlockSizeLong() * r100.getBlockCountLong()) / 1024;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static int getBatteryPercentage(Context r100) {
        return ((BatteryManager) r100.getSystemService("batterymanager")).getIntProperty(4);
    }

    public static HashMap<String, Object> getChargingState(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Intent r101 = INVOKEVIRTUAL_com_ss_mediakit_utils_AVMDLDeviceUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r101 != null) goto L8;
        return null;
    L8:
        int r102 = r101.getIntExtra("status", -1);
        if (r102 != 2) goto L11;
    L14:
        int r103 = 1;
    L15:
        int r104 = r101.getIntExtra("plugged", -1);
        int r105 = r101.getIntExtra("level", -1);
        int r106 = r105 * 100;
        int r107 = r106 / r101.getIntExtra("scale", -1);
        HashMap<String, Object> r108 = new HashMap(3);
        r108.put("isCharging", Integer.valueOf(r103));
        r108.put("chargePlug", Integer.valueOf(r104));
        r108.put(BatteryTypeInf.BATTERY_POWER_LOCK, Integer.valueOf(r107));
        return r108;
    L11:
        if (r102 == 5) goto L14;
        r103 = 0;
        goto L15
    }

    public static boolean isOverHeat(Context r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L13
        if (r101 == null) goto L15;
        if (r101.getCurrentThermalStatus() < 3) goto L18;
        return true;
    L18:
        return false;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static boolean isPowerSaveMode(Context r100) {
        if (r100 == null) goto L13;
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L7
        if (r101 == null) goto L14;
        return r101.isPowerSaveMode();
    L14:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    L13:
        return false;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_mediakit_utils_AVMDLDeviceUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
