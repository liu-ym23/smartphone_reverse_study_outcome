package com.ss.ttvideoengine.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Debug;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class DeviceMonitorUtils {
    private static final String APM_CPU_INFO_CLASS_PATH = "com.bytedance.apm.perf.entity.CpuInfo";
    private static final String APM_CPU_MANAGER_CLASS_PATH = "com.bytedance.apm6.cpu.ApmCpuManager";
    private static final String TAG = "DeviceMonitorUtils";
    private static final String THOR_CLASS_PATH = "com.ss.thor.ThorUtils";
    private static Class<?> sCpuInfoClz;
    private static Class<?> sCpuManagerClz;
    private static Method sGetCpuRateMethod;
    private static Method sGetCpuSpeedMethod;
    private static Method sGetCurrentCpuInfoMethod;
    private static Method sGetGalvanicNowMethod;
    private static Method sGetInstanceMethod;
    private static Class<?> sThorClz;

    public static class CPUInfo {
        public double cpuAppRate;
        public double cpuAppSpeed;

        public String toString() {
            return "CpuInfo{cpuAppRate=" + this.cpuAppRate + ", cpuAppSpeed=" + this.cpuAppSpeed + '}';
        }

        public CPUInfo() {
            this.cpuAppRate = -1.0d;
            this.cpuAppSpeed = -1.0d;
        }
    }

    public DeviceMonitorUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static double getCPURate() {
    L20:
        e = move-exception;
        TTVideoEngineLog.d(TAG, "getCPURate:" + e);
        return -1.0d;
    L4:
        if (sCpuManagerClz != null) goto L7;
        sCpuManagerClz = INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APM_CPU_MANAGER_CLASS_PATH);     // Catch: Exception -> L20
    L7:
        if (sGetInstanceMethod != null) goto L10;
        sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);     // Catch: Exception -> L20
    L10:
        if (sGetCpuRateMethod != null) goto L12;
        sGetCpuRateMethod = sCpuManagerClz.getMethod("getCpuRate", new Class[0]);     // Catch: Exception -> L20
    L12:
        Object r100 = sGetInstanceMethod.invoke(null, new Object[0]);     // Catch: Exception -> L20
        if (r100 == null) goto L25;
        Object r101 = sGetCpuRateMethod.invoke(r100, new Object[0]);     // Catch: Exception -> L20
        if (r101 == null) goto L26;
        Double r102 = Double.valueOf(CastDoubleProtector.parseDouble(r101.toString()));     // Catch: Exception -> L20
        if (r102 == null) goto L27;
        return r102.doubleValue();
    L27:
        return -1.0d;
    L26:
        return -1.0d;
    L25:
        return -1.0d;
    }

    public static double getCPUSpeed() {
    L20:
        e = move-exception;
        TTVideoEngineLog.d(TAG, "getCPUSpeed:" + e);
        return -1.0d;
    L4:
        if (sCpuManagerClz != null) goto L7;
        sCpuManagerClz = INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APM_CPU_MANAGER_CLASS_PATH);     // Catch: Exception -> L20
    L7:
        if (sGetInstanceMethod != null) goto L10;
        sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);     // Catch: Exception -> L20
    L10:
        if (sGetCpuSpeedMethod != null) goto L12;
        sGetCpuSpeedMethod = sCpuManagerClz.getMethod("getCpuSpeed", new Class[0]);     // Catch: Exception -> L20
    L12:
        Object r100 = sGetInstanceMethod.invoke(null, new Object[0]);     // Catch: Exception -> L20
        if (r100 == null) goto L25;
        Object r101 = sGetCpuSpeedMethod.invoke(r100, new Object[0]);     // Catch: Exception -> L20
        if (r101 == null) goto L26;
        Double r102 = Double.valueOf(CastDoubleProtector.parseDouble(r101.toString()));     // Catch: Exception -> L20
        if (r102 == null) goto L27;
        return r102.doubleValue();
    L27:
        return -1.0d;
    L26:
        return -1.0d;
    L25:
        return -1.0d;
    }

    public static CPUInfo getCurrentCPUInfo() {
        CPUInfo r100 = new CPUInfo();
    L29:
        e = move-exception;
        TTVideoEngineLog.d(TAG, "getCurrentCPUInfo:" + e);
    L31:
        return r100;
    L4:
        if (sCpuManagerClz != null) goto L7;
        sCpuManagerClz = INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APM_CPU_MANAGER_CLASS_PATH);     // Catch: Exception -> L29
    L7:
        if (sGetInstanceMethod != null) goto L10;
        sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);     // Catch: Exception -> L29
    L10:
        if (sGetCurrentCpuInfoMethod != null) goto L13;
        sGetCurrentCpuInfoMethod = sCpuManagerClz.getMethod("getCurrentCpuRate", new Class[0]);     // Catch: Exception -> L29
    L13:
        if (sCpuInfoClz != null) goto L15;
        sCpuInfoClz = INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APM_CPU_INFO_CLASS_PATH);     // Catch: Exception -> L29
    L15:
        Object r101 = sGetInstanceMethod.invoke(null, new Object[0]);     // Catch: Exception -> L29
        if (r101 == null) goto L31;
        Object r102 = sGetCurrentCpuInfoMethod.invoke(r101, new Object[0]);     // Catch: Exception -> L29
        if (r102 != null) goto L20;
    L27:
        TTVideoEngineLog.i(TAG, "is not instance");     // Catch: Exception -> L29
        goto L31
    L20:
        if (sCpuInfoClz.isInstance(r102) == false) goto L27;
        Field r103 = sCpuInfoClz.getDeclaredField("cpuAppRate");     // Catch: Exception -> L29
        if (r103 == null) goto L24;
        r100.cpuAppRate = r103.getDouble(r102);     // Catch: Exception -> L29
    L24:
        Field r104 = sCpuInfoClz.getDeclaredField("cpuAppSpeed");     // Catch: Exception -> L29
        if (r104 == null) goto L31;
        r100.cpuAppSpeed = r104.getDouble(r102);     // Catch: Exception -> L29
        goto L31
    }

    public static int getUsingMemory() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r100);
        return r100.getTotalPss() / 1024;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static HashMap<String, Object> getChargingState(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Intent r101 = INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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

    public static float getGalvanicNow(Context r100) {
        if (r100 != null) goto L16;
        return -1.0f;
    L16:
    L13:
        e = move-exception;
        TTVideoEngineLog.d(TAG, "startThorMonitor failed:" + e);
        return -1.0f;
    L6:
        if (sThorClz != null) goto L9;
        sThorClz = INVOKESTATIC_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(THOR_CLASS_PATH);     // Catch: Exception -> L13
    L9:
        if (sGetGalvanicNowMethod != null) goto L11;
        sGetGalvanicNowMethod = sThorClz.getMethod("getGalvanicNow", new Class[]{Context.class});     // Catch: Exception -> L13
    L11:
        return ((Float) sGetGalvanicNowMethod.invoke(null, new Object[]{r100})).floatValue();
    }

    public static int getPowerCapacity(Context r100) {
        if (r100 != null) goto L12;
        return 0;
    L12:
        BatteryManager r101 = (BatteryManager) r100.getSystemService("batterymanager");     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        return r101.getIntProperty(4);
    L14:
        return 0;
    L9:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static int isPowerSaveMode(Context r100) {
        if (r100 == null) goto L13;
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L7
        if (r101 == null) goto L14;
        return r101.isPowerSaveMode() ? 1 : 0;
    L14:
        return -1;
    L7:
        e = move-exception;
        TTVideoEngineLog.d(TAG, "isPowerSaveMode:" + e);
        return -1;
    L13:
        return -1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
