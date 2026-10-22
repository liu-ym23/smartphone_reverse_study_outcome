package com.bytedance.bmmt.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public class PowerMonitorAndroid {
    private static String TAG = "PowerMonitorAndroid";
    private static BatteryManager batteryManager;
    private static BroadcastReceiver batterySaverReceiver;
    private static Intent batteryStatus;
    private static float batteryVolt;
    private static Context context;
    private static IntentFilter ifilter;
    private static int mBatteryLevel;
    private static int mBatterySaveMode;
    private static int mBatteryTemperature;
    private static BroadcastReceiver mBroadcastReceiver;
    private static int mChargeStatus;
    private static int mCpuCoreCount;
    private static PowerManager powerManager;

    public PowerMonitorAndroid() {
    }

    public static /* bridge */ /* synthetic */ PowerManager a() {
        return powerManager;
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* bridge */ /* synthetic */ void b(int r100) {
        mBatteryLevel = r100;
    }

    public static /* bridge */ /* synthetic */ void c(int r100) {
        mBatterySaveMode = r100;
    }

    public static /* bridge */ /* synthetic */ void d(int r100) {
        mBatteryTemperature = r100;
    }

    public static /* bridge */ /* synthetic */ void e(int r100) {
        mChargeStatus = r100;
    }

    public static int getBatteryCurrentCapacity() {
        BatteryManager r100 = batteryManager;     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        int r101 = ((int) r100.getLongProperty(1)) / 1000;     // Catch: Exception -> L7
    L10:
        if (r101 >= 0) goto L13;
        return -1;
    L13:
        return r101;
    L9:
        r101 = -1;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static int getBatteryMaxCapacity() {
        return 0;
    }

    public static int getBatterySaveStatus() {
        String r100 = Build.MANUFACTURER;     // Catch: Exception -> L26
        if (r100.equalsIgnoreCase("Xiaomi") == true) goto L6;
    L10:
        int r101 = 1;
        if (r100.equalsIgnoreCase("Huawei") == false) goto L17;
        if (Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") != 4) goto L15;
        mBatterySaveMode = 1;     // Catch: Exception -> L26
    L30:
    L29:
        return mBatterySaveMode;
    L15:
        mBatterySaveMode = 0;     // Catch: Exception -> L26
        goto L30
    L17:
        if (powerManager == null) goto L30;
        if (mBatterySaveMode != (-1)) goto L30;
        INVOKEVIRTUAL_com_bytedance_bmmt_base_PowerMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, batterySaverReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));     // Catch: Exception -> L26
        if (powerManager.isPowerSaveMode() == true) goto L24;
        r101 = 0;
    L24:
        mBatterySaveMode = r101;     // Catch: Exception -> L26
        goto L30
    L6:
        if (powerManager == null) goto L10;
        if (mBatterySaveMode != (-1)) goto L10;
        mBatterySaveMode = Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN");     // Catch: Exception -> L26
        INVOKEVIRTUAL_com_bytedance_bmmt_base_PowerMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, batterySaverReceiver, new IntentFilter("miui.intent.action.POWER_SAVE_MODE_CHANGED"));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        mBatterySaveMode = -1;
        e.printStackTrace();
        goto L29
    }

    public static int getVoltage() {
        return -1;
    }

    public static int getBatteryDesignCapacity() {
        return (int) Math.round(((Double) INVOKESTATIC_com_bytedance_bmmt_base_PowerMonitorAndroid_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(INVOKESTATIC_com_bytedance_bmmt_base_PowerMonitorAndroid_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.os.PowerProfile").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), new Object[0])).doubleValue());
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getBatteryLevel() {
        BatteryManager r100 = batteryManager;     // Catch: Exception -> L8
        if (r100 == null) goto L11;
        if (mBatteryLevel != (-1)) goto L11;
        mBatteryLevel = r100.getIntProperty(4);     // Catch: Exception -> L8
    L11:
        return mBatteryLevel;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static int getBatteryTemperature() {
        return mBatteryTemperature / 10;
    }

    public static int getChargeStatus() {
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        int r100 = mChargeStatus;
        if (r100 != 5) goto L15;
        return 1;
    L15:
        if (r100 == 2) goto L23;
        return 0;
    L23:
        return 1;
    L3:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        BatteryManager r101 = batteryManager;     // Catch: Exception -> L10
        if (r101 == null) goto L12;
        if (mChargeStatus != (-1)) goto L12;
        mChargeStatus = r101.getIntProperty(6);     // Catch: Exception -> L10
        goto L12
    }

    public static int getScreenBrightness() {
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") == false) goto L6;
        return -1;
    L6:
        return (int) ((((double) Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1)) / 255.0d) * 100.0d);
    }

    static {
        context = ContextUtils.getApplicationContext();
        batteryVolt = -1.0f;
        mBroadcastReceiver = new AnonymousClass1();
        batterySaverReceiver = new AnonymousClass2();
        mCpuCoreCount = -1;
        mChargeStatus = -1;
        mBatteryLevel = -1;
        mBatteryTemperature = -1;
        mBatterySaveMode = -1;
        batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        IntentFilter r100 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        ifilter = r100;
        batteryStatus = INVOKEVIRTUAL_com_bytedance_bmmt_base_PowerMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, mBroadcastReceiver, r100);
        powerManager = (PowerManager) context.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bmmt_base_PowerMonitorAndroid_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bmmt_base_PowerMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
