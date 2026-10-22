package com.ss.android.message.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.utils.f;
import com.bytedance.push.utils.i;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.message.AppProvider;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import f06.b;
import f06.c;
import f06.d;
import ita.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class ToolUtils {
    public static int FALSE = 0;
    public static final int FOCUS_PERMISSION_STATUS_CLOSE = 1;
    public static final int FOCUS_PERMISSION_STATUS_OPEN = 2;
    public static final int FOCUS_PERMISSION_STATUS_UNKNOWN = -1;
    public static String HONOR = "honor";
    public static String HW = "huawei";
    public static String MESSAGE_PROCESS_SUFFIX = ":push";
    private static final long MIN_GET_RUNNING_APP_PROCESS_INVOKE_INTERVAL = 1000;
    public static String ONEPLUS = "oneplus";
    public static String OPPO = "oppo";
    public static String PUSH_SERVICE_PROCESS_SUFFIX = ":pushservice";
    public static String SMP_PROCESS_SUFFIX = ":smp";
    public static final String SMP_PROCESS_SUFFIX_V2 = ":widgetProvider";
    private static final String TAG = "ToolUtils";
    public static int TRUE = 1;
    public static String VIVO = "vivo";
    public static String XIAOMI = "xiaomi";
    private static int debugMode;
    private static long initTimeStamp;
    private static Boolean isMainProcess;
    private static long lastInvokeGetRunningAppProcessTimeStamp;
    private static List<ActivityManager.RunningAppProcessInfo> lastRunningAppProcess;
    private static final Object runningAppLock = null;
    private static String sAndroidId;
    private static final Object sAndroidIdLock = null;
    private static ProcessEnum sCurProcess;
    private static String sCurProcessName;
    private static String sCurProcessNameSuffix;
    private static String sImei;
    public static boolean sIsInited;
    public static boolean sIsMiui;
    private static final Object sProcessNameLock = null;
    private static final Object sPushFakeDeviceIdLock = null;
    private static long timeStampFromProc;

    public static class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a() {
        }
    }

    public ToolUtils() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String getCurrentProcessNameByActivityThread() {
        Method r100 = INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r101 instanceof String) == false) goto L12;
        return (String) r101;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean isHuaweiDevice() {
        String r100 = Build.BRAND;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r100) == false) goto L6;
    L7:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r101) == true) goto L16;
        if (r101.toLowerCase().startsWith(HW) == false) goto L17;
    L11:
        return true;
    L17:
        return false;
    L16:
        return false;
    L6:
        if (r100.toLowerCase().startsWith(HW) == true) goto L11;
    L18:
        return false;
    }

    static {
        sPushFakeDeviceIdLock = new Object();
        sProcessNameLock = new Object();
        sIsMiui = false;
        sIsInited = false;
        sAndroidId = "";
        sAndroidIdLock = new Object();
        sImei = "";
        runningAppLock = new Object();
        timeStampFromProc = 0;
        initTimeStamp = 0;
        debugMode = -1;
    }

    public static long currentTimeMillis() {
        long r100 = timeStampFromProc;
        if (r100 != 0) goto L13;
        String r101 = i.c().b("log.tag.push.timestamp");
        if (TextUtils.isEmpty(r101) == false) goto L18;
        timeStampFromProc = -1;
    L17:
        return System.currentTimeMillis();
    L18:
        timeStampFromProc = CastLongProtector.parseLong(r101);     // Catch: Throwable -> L9
    L10:
        initTimeStamp = System.currentTimeMillis();
        return timeStampFromProc;
    L9:
        timeStampFromProc = -1;
        goto L10
    L13:
        if (r100 == (-1)) goto L17;
        return r100 + (System.currentTimeMillis() - initTimeStamp);
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L14
        if (r102 <= 0) goto L9;
        r101.append((char) r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (f.f267065a == false) goto L11;
        f.b("Process", "get processName = " + r101.toString());     // Catch: Throwable -> L14
    L11:
        String r103 = r101.toString();     // Catch: Throwable -> L14
        r100.close();     // Catch: Exception -> L19
    L13:
        return r103;
    L16:
        if (r100 != null) goto L25;
    L18:
        return null;
    L25:
        r100.close();     // Catch: Exception -> L20
    L15:
        r100 = null;
        goto L16
    }

    private static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String getEMUI() {
        Method r100 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Object r101 = r100.invoke(null, new Object[]{com.alipay.sdk.m.c.a.f25238a});     // Catch: Throwable -> L7
        f.b("ToolUtils", "getEMUI: emuiVersion " + r101);     // Catch: Throwable -> L7
        if ((r101 instanceof String) == false) goto L12;
        return (String) r101;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String getRomInfo() {
        StringBuilder r100 = new StringBuilder();
        if (isMiui() == false) goto L7;
        r100.append("MIUI-");     // Catch: Throwable -> L20
    L17:
        r100.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L20
        goto L19
    L7:
        if (isFlyme() == false) goto L9;
        r100.append("FLYME-");     // Catch: Throwable -> L20
        goto L17
    L9:
        String r101 = getEmuiInfo();     // Catch: Throwable -> L20
        if (isEmui(r101) == false) goto L15;
        if (isNexus6p() == true) goto L15;
        r100.append("EMUI-");     // Catch: Throwable -> L20
    L15:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        r100.append(r101);     // Catch: Throwable -> L20
        r100.append("-");     // Catch: Throwable -> L20
    L19:
        return r100.toString();
    }

    public static boolean isDebugModeFromProc() {
        if (debugMode != (-1)) goto L11;
        String r100 = i.c().b("log.tag.push.debug_mode");
        if (TextUtils.isEmpty(r100) == false) goto L14;
        debugMode = 0;
        goto L11
    L14:
        debugMode = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L9
    L9:
        debugMode = 0;
    L11:
        if (debugMode != 1) goto L16;
        return true;
    L16:
        return false;
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.indexOf("Flyme") < 0) goto L5;
        return true;
    L5:
        if (Build.USER.equals("flyme") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L11;
        if (INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("miui.os.Build") == null) goto L9;
        sIsMiui = true;     // Catch: Exception -> L12
        sIsInited = true;     // Catch: Exception -> L12
        return true;
    L9:
        sIsInited = true;
    L11:
        return sIsMiui;
    }

    public static boolean isNexus6p() {
        if ("angler".equals(Build.BOARD) == false) goto L11;
        String r100 = Build.MODEL;
        if (r100 == null) goto L11;
        if (r100.toLowerCase().contains("nexus") == false) goto L11;
        if (r100.toLowerCase().contains("6p") == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isOppoDevice() {
        String r100 = Build.MANUFACTURER;
        String r101 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        boolean r102 = false;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
    L17:
        boolean r103 = false;
    L18:
        i r104 = i.c();
        if (TextUtils.isEmpty(r104.f267076f) == false) goto L22;
        r104.f267076f = r104.b("ro.build.version.opporom");
    L22:
        if ((!TextUtils.isEmpty(r104.f267076f)) == true) goto L25;
        if (r102 == true) goto L25;
        if (r103 == true) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (r101.toLowerCase().contains(OPPO) == false) goto L15;
    L16:
        r103 = true;
        goto L18
    L15:
        if (r101.toLowerCase().contains(ONEPLUS) == false) goto L17;
    L5:
        if (r100.toLowerCase().contains(OPPO) == false) goto L7;
    L8:
        r102 = true;
        goto L11
    L7:
        if (r100.toLowerCase().contains(ONEPLUS) == false) goto L9;
        goto L8
    }

    public static String getEmuiInfo() {
        String r100 = getSystemProperty(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        return getSystemProperty("ro.build.version.magic");
    }

    public static String getMagicUI() {
        String r100 = getSystemProperty(com.alipay.sdk.m.c.a.f25238a);     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r100) == true) goto L10;
        return getSystemProperty("ro.build.version.magic");
    L10:
        return r100;
    L6:
        return "";
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() {
        if (isActiveUser(AppProvider.getApp()) == true) goto L6;
        f.b("ToolUtils", "[getRunningAppProcesses]return  empty running process because cur is inactive user");
        return new ArrayList();
    L6:
        boolean r100 = false;
        Map<String, Boolean> r101 = com.ss.android.pushmanager.setting.a.f449563c;     // Catch: Throwable -> L15
        Boolean r102 = (Boolean) ((HashMap) r101).get("opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        if (r102 == null) goto L10;
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return cache value for opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        r100 = r102.booleanValue();     // Catch: Throwable -> L15
    L35:
    L17:
        f.b("ToolUtils", "[getRunningAppProcesses]optSensitiveApiInvoke:" + r100);
        if (r100 == false) goto L31;
        Object r103 = runningAppLock;
        monitor-enter(r103);
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L28
        if ((r104 - lastInvokeGetRunningAppProcessTimeStamp) < 1000) goto L24;
        f.b("ToolUtils", "[getRunningAppProcesses]invoke getRunningAppProcess");     // Catch: Throwable -> L28
        lastInvokeGetRunningAppProcessTimeStamp = r104;     // Catch: Throwable -> L28
        lastRunningAppProcess = getRunningAppProcessesInternal();     // Catch: Throwable -> L28
    L25:
        monitor-exit(r103);     // Catch: Throwable -> L28
        return lastRunningAppProcess;
    L24:
        f.b("ToolUtils", "[getRunningAppProcesses]api invoke frequency,return lastRunningAppProcess");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        f.b("ToolUtils", "[getRunningAppProcesses]invoke getRunningAppProcessesInternal without any frequency because settings of opt_sensitive_api_invoke is false");
        return getRunningAppProcessesInternal();
    L10:
        Application r105 = AppProvider.getApp();     // Catch: Throwable -> L15
        if (r105 != null) goto L13;
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return defaultValue because context is null");     // Catch: Throwable -> L15
        goto L35
    L13:
        boolean r106 = r105.getSharedPreferences("push_multi_process_config", 4).getBoolean("opt_sensitive_api_invoke", false);     // Catch: Throwable -> L15
        ((HashMap) r101).put("opt_sensitive_api_invoke", Boolean.valueOf(r106));     // Catch: Throwable -> L15
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return " + r106 + " for opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        r100 = r106;
    L15:
        th = move-exception;
        f.f("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return defaultValue because exception ", th);
        goto L17
    }

    private static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessesInternal() {
        return ((ActivityManager) AppProvider.getApp().getSystemService("activity")).getRunningAppProcesses();
    }

    public static void killSelf() {
        Process.killProcess(Process.myPid());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_message_util_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static Map<String, String> addNetworkTagToHeader(Map<String, String> r100) {
        a r101 = new a();     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        Map r102 = new HashMap();     // Catch: Exception -> L8
    L6:
        Pair<String, String> r103 = BDNetworkTagManager.getInstance().buildBDNetworkTag(r101);     // Catch: Exception -> L8
        r102.put(r103.first, r103.second);     // Catch: Exception -> L8
        return r102;
    L5:
        r102 = r100;
    L8:
        return r100;
    }

    public static int areNotificationsEnabled(Context r110) {
        if (r110 != null) goto L6;
        return -1;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L24;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L8:
        if (((Boolean) Reflect.on((NotificationManager) r110.getSystemService("notification")).call("areNotificationsEnabled").get()).booleanValue() == false) goto L11;
        return TRUE;
    L11:
        return FALSE;
    L24:
        AppOpsManager r100 = (AppOpsManager) r110.getSystemService("appops");     // Catch: Throwable -> L20
        ApplicationInfo r101 = r110.getApplicationInfo();     // Catch: Throwable -> L20
        String r111 = r110.getApplicationContext().getPackageName();     // Catch: Throwable -> L20
        int r102 = r101.uid;     // Catch: Throwable -> L20
        Reflect r103 = Reflect.on(r100);     // Catch: Throwable -> L20
        Class<?> r104 = Integer.TYPE;     // Catch: Throwable -> L20
        if (((Integer) r103.call("checkOpNoThrow", new Class[]{r104, r104, String.class}, new Object[]{Integer.valueOf(((Integer) r103.field("OP_POST_NOTIFICATION", new Class[]{r104}).get()).intValue()), Integer.valueOf(r102), r111}).get()).intValue() != 0) goto L19;
        return TRUE;
    L19:
        return FALSE;
    L20:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String bundleToString(Bundle r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        Set<String> r101 = r100.keySet();
        if (r101 == null) goto L16;
        StringBuilder r102 = new StringBuilder();
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        Object r105 = r100.get(r104);
        if ((r105 instanceof Intent) == true) goto L12;
        r102.append(String.format("%s--%s\n", new Object[]{r104, r105}));
        goto L9
    L12:
        r102.append(String.format("%s--%s\n", new Object[]{r104, bundleToString(((Intent) r105).getExtras())}));
        goto L9
    L15:
        return r102.toString();
    L16:
        return "";
    }

    private static String com_ss_android_message_util_ToolUtils_android_telephony_TelephonyManager_getDeviceId(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getDeviceId();
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, r113, r111, true);
        return r113;
    }

    public static String getAndroidId(Context r100) {
        f.b("ToolUtils", "[getAndroidId]sAndroidId:" + sAndroidId + " stack:" + Log.getStackTraceString(new Throwable()));
        Object r101 = sAndroidIdLock;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(sAndroidId) == true) goto L10;
        f.b("ToolUtils", "[getAndroidId]cur has valid android,return " + sAndroidId);     // Catch: Throwable -> L19
        String r102 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r102;
    L10:
        if (isActiveUser(r100) == true) goto L14;
        f.b("ToolUtils", "[getAndroidId]return " + sAndroidId + " because cur is guest user");     // Catch: Throwable -> L19
        String r103 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L14:
        IPushConfigurationService r104 = PushCommonSupport.getInstance().getPushConfigurationService();     // Catch: Throwable -> L19
        boolean r105 = false;
        if (r104 == null) goto L21;
        PushCommonConfiguration r106 = r104.getPushCommonConfiguration();     // Catch: Throwable -> L19
        if (r106 == null) goto L21;
        boolean r107 = r106.mIPushCommonConfiguration.optAnr();     // Catch: Throwable -> L19
    L22:
        if (r107 == true) goto L24;
        r105 = true;
    L24:
        if (r105 == false) goto L26;
        boolean r108 = m67.a.d();     // Catch: Throwable -> L19
    L27:
        if (r108 == false) goto L48;
        f.b("ToolUtils", "[getAndroidId]use cache because cur is background");     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(sAndroidId) == true) goto L31;
    L33:
        String r109 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r109;
    L31:
        if (((PushOnlineSettings) j77.i.a(r100, PushOnlineSettings.class)).R() == false) goto L33;
        sAndroidId = ((LocalSettings) j77.i.a(r100, LocalSettings.class)).getAndroidId();     // Catch: Throwable -> L19
        goto L33
    L48:
        f.b("ToolUtils", "[getAndroidId]invoke sys api to get android_id");     // Catch: Throwable -> L40
        String r110 = com_ss_android_message_util_ToolUtils_android_provider_Settings$Secure_getString(r100.getContentResolver(), "android_id");     // Catch: Throwable -> L40
        sAndroidId = r110;     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r110) == true) goto L42;
        ((LocalSettings) j77.i.a(r100, LocalSettings.class)).o(sAndroidId);     // Catch: Throwable -> L40
    L42:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return sAndroidId;
    L40:
        th = move-exception;
        f.f("ToolUtils", "error when get android_id", th);     // Catch: Throwable -> L19
        goto L42
    L26:
        r108 = m67.a.f512287g;     // Catch: Throwable -> L19
    L21:
        r107 = false;
        goto L22
    }

    public static ProcessEnum getCurProcess(Context r100) {
        ProcessEnum r101 = sCurProcess;
        if (r101 == null) goto L5;
        return r101;
    L5:
        ProcessEnum r102 = ProcessEnum.parseProcess(getCurProcessName(r100), r100.getPackageName());
        sCurProcess = r102;
        return r102;
    }

    public static String getCurProcessName(Context r100) {
        Object r101 = sProcessNameLock;
        monitor-enter(r101);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (sCurProcessName != null) goto L8;
        sCurProcessName = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mProcess;     // Catch: Throwable -> L30
    L8:
        if (TextUtils.isEmpty(sCurProcessName) == true) goto L12;
        String r102 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r102;
    L12:
        String r103 = getCurrentProcessNameByApplication();     // Catch: Throwable -> L30
        sCurProcessName = r103;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r103) == true) goto L17;
        String r104 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r104;
    L17:
        String r105 = getCurrentProcessNameByActivityThread();     // Catch: Throwable -> L30
        sCurProcessName = r105;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r105) == true) goto L22;
        String r106 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r106;
    L22:
        String r107 = getCurProcessNameFromProc();     // Catch: Throwable -> L30
        sCurProcessName = r107;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r107) == true) goto L27;
        String r108 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r108;
    L27:
        String r109 = getCurrentProcessNameByActivityManager(r100);     // Catch: Throwable -> L30
        sCurProcessName = r109;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r109;
    }

    public static String getCurProcessNameSuffix(Context r100) {
        String r101 = sCurProcessNameSuffix;
        if (StringUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        String r102 = getProcessSuffix(r100, getCurProcessName(r100));
        sCurProcessNameSuffix = r102;
        return r102;
    }

    private static String getCurrentProcessNameByActivityManager(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r102 = getRunningAppProcesses();
        if (r102 == null) goto L14;
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();
        if (r104.pid != r101) goto L9;
        return r104.processName;
    L14:
        return null;
    }

    public static String getDeviceId(Context r100) {
        HashMap r101 = new HashMap();
        getSSIDs(r100, r101);
        return (String) r101.get("device_id");
    }

    public static String getFocusPermissionVersion(Context r100) {
        f.b("ToolUtils", "[getFocusPermissionVersion]");
        if (i.c().j() == false) goto L12;
        int r101 = Settings.System.getInt(r100.getContentResolver(), "notification_focus_protocol", 0);     // Catch: Throwable -> L6
        f.b("ToolUtils", "[getFocusPermissionVersion]notificationFocusProtocol:" + r101);     // Catch: Throwable -> L6
        return String.valueOf(r101);
    L6:
        th = move-exception;
        f.e("ToolUtils", "[getFocusPermissionVersion]exception:" + th.getLocalizedMessage());
        return "-1";
    L12:
        return "-1";
    }

    public static String getImei(Context r100) {
        String r101 = sImei;
        monitor-enter(r101);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(sImei) == true) goto L10;
        String r102 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r102;
    L10:
        if (isActiveUser(r100) == true) goto L15;
        String r103 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r103;
    L15:
        if (m67.a.d() == false) goto L19;
        String r104 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r104;
    L19:
        if (r100 != null) goto L23;
        String r105 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r105;
    L23:
        TelephonyManager r106 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L47
        if (r106 != null) goto L28;
        String r107 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r107;
    L28:
        int r108 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L47
        if (r108 >= 23) goto L31;
    L44:
        String r109 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r101);     // Catch: Throwable -> L47
        return r109;
    L31:
        if (com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") != 0) goto L44;
        if (r108 >= 26) goto L50;
        sImei = com_ss_android_message_util_ToolUtils_android_telephony_TelephonyManager_getDeviceId(r106);     // Catch: Throwable -> L47
        goto L44
    L50:
        Object r110 = INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L42
        if (r110 == null) goto L44;
        if ((r110 instanceof String) == false) goto L44;
        sImei = (String) r110;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
        goto L44
    }

    public static String getLaunchActivity(Context r100) {
        ComponentName r101 = k.e(r100, r100.getPackageName()).resolveActivity(r100.getPackageManager());     // Catch: Exception -> L6
        if (r101 == null) goto L12;
        return r101.getClassName();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getPushFakeDeviceId(Context r100) {
        Object r101 = sPushFakeDeviceIdLock;
        monitor-enter(r101);
        SharedPreferences r102 = r100.getSharedPreferences("push_multi_process_config", 4);     // Catch: Throwable -> L15
        String r103 = r102.getString("depths_device_id", "");     // Catch: Throwable -> L15
        f.b("ToolUtils", "[getPushFakeDeviceId]cache id:" + r103);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r103) == true) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L8:
        DisplayMetrics r104 = INVOKEVIRTUAL_com_ss_android_message_util_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Throwable -> L15
        int r105 = r104.widthPixels;     // Catch: Throwable -> L15
        int r106 = r104.heightPixels;     // Catch: Throwable -> L15
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L15
        r107.append(Build.BOARD);     // Catch: Throwable -> L15
        r107.append(Build.HARDWARE);     // Catch: Throwable -> L15
        String[] r108 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L15
        if (r108.length <= 0) goto L11;
        int r109 = r108.hashCode();     // Catch: Throwable -> L15
    L12:
        r107.append(r109);     // Catch: Throwable -> L15
        r107.append(Build.BRAND);     // Catch: Throwable -> L15
        r107.append(System.currentTimeMillis());     // Catch: Throwable -> L15
        r107.append(new Random().nextInt(9999));     // Catch: Throwable -> L15
        r107.append(r105);     // Catch: Throwable -> L15
        r107.append(r106);     // Catch: Throwable -> L15
        String r110 = toSha256(r107.toString());     // Catch: Throwable -> L15
        f.b("ToolUtils", "[getPushFakeDeviceId]depths device id:" + r110);     // Catch: Throwable -> L15
        r102.edit().putString("depths_device_id", r110).apply();     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r110;
    L11:
        r109 = 0;
    L15:
        th = move-exception;
        f.f("ToolUtils", "[getPushFakeDeviceId]exception ", th);     // Catch: Throwable -> L19
        return "";
    L19:
        th = move-exception;
        throw th;
    }

    public static String getSystemProperty(String r100) {
        BufferedReader r101 = null;
        String r102 = null;
        Process r103 = com_ss_android_message_util_ToolUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100);     // Catch: Throwable -> L12
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r103.getInputStream()), 1024);     // Catch: Throwable -> L12
        r102 = r104.readLine();     // Catch: Throwable -> L10
        r103.destroy();     // Catch: Throwable -> L10
        r104.close();     // Catch: IOException -> L7
    L9:
        return r102;
    L7:
        e = move-exception;
        f.e("ToolUtils", "Exception while closing InputStream" + e.getMessage());
    L10:
        th = th;
        String r105 = r102;
        r101 = r104;
    L32:
        f.e("ToolUtils", "Unable to read sysprop " + r100 + th.getMessage());     // Catch: Throwable -> L21
        if (r101 != null) goto L34;
    L20:
        return r105;
    L34:
        r101.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        f.e("ToolUtils", "Exception while closing InputStream" + e.getMessage());
    L21:
        th = move-exception;
        if (r101 != null) goto L38;
    L27:
        throw th;
    L38:
        r101.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        f.e("ToolUtils", "Exception while closing InputStream" + e.getMessage());
    L12:
        th = th;
        r105 = null;
        goto L32
    }

    public static String getUserSerial(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = r100.getSystemService("user");
        if (r101 != null) goto L21;
        f.e("ToolUtils", "userManager not exsit !!!");
        return null;
    L21:
        Object r102 = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L20
        return String.valueOf(((Long) r101.getClass().getMethod("getSerialNumberForUser", new Class[]{r102.getClass()}).invoke(r101, new Object[]{r102})).longValue());
    L13:
        e = move-exception;
        f.e("ToolUtils", e.getMessage());
    L15:
        e = move-exception;
        f.e("ToolUtils", e.getMessage());
    L17:
        e = move-exception;
        f.e("ToolUtils", e.getMessage());
    L11:
        e = move-exception;
        f.e("ToolUtils", e.getMessage());
    L19:
        return null;
    }

    public static boolean hasCreatedNotificationChannel(Context r100) {
        NotificationManager r101 = (NotificationManager) r100.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 26) goto L11;
        List<NotificationChannel> r102 = r101.getNotificationChannels();
        if (r102 != null) goto L7;
    L9:
        return false;
    L7:
        if (r102.size() <= 0) goto L9;
        return true;
    L11:
        return true;
    }

    public static int hasFocusPermission(Context r100) {
        f.b("ToolUtils", "[hasFocusPermission]");
        if (i.c().j() == false) goto L18;
        Uri r101 = UriProtector.parse("content://miui.statusbar.notification.public");     // Catch: Throwable -> L12
        Bundle r102 = new Bundle();     // Catch: Throwable -> L12
        r102.putString("package", r100.getPackageName());     // Catch: Throwable -> L12
        Bundle r103 = r100.getContentResolver().call(r101, "canShowFocus", null, r102);     // Catch: Throwable -> L12
        if (r103 == null) goto L19;
        boolean r104 = r103.getBoolean("canShowFocus", false);     // Catch: Throwable -> L12
        f.b("ToolUtils", "[hasFocusPermission]canShowFocus:" + r104);     // Catch: Throwable -> L12
        if (r104 == false) goto L10;
        return 2;
    L10:
        return 1;
    L19:
        return -1;
    L12:
        th = move-exception;
        f.e("ToolUtils", "[hasFocusPermission]exception:" + th.getLocalizedMessage());
        return -1;
    L18:
        return -1;
    }

    public static boolean isActiveUser(Context r100) {
        PushCommonConfiguration r101 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r101 != null) goto L5;
        return false;
    L5:
        IPushCommonConfiguration r102 = r101.mIPushCommonConfiguration;
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r102.isGuestMode() == false) goto L12;
        return false;
    L12:
        if (r102.hasAgreedForPrivacyDialog() == true) goto L15;
        return false;
    L15:
        return !TextUtils.isEmpty(getDeviceId(r100));
    }

    public static boolean isEmui(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r100.toLowerCase().startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHuaweiDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isMainProcess(Context r100) {
        Boolean r101 = isMainProcess;
        if (r101 != null) goto L5;
        String r102 = getCurProcessName(r100);
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r102 != null) goto L13;
    L15:
        Boolean r104 = Boolean.valueOf(r103);
        isMainProcess = r104;
        return r104.booleanValue();
    L13:
        if (r102.equals(r100.getPackageName()) == false) goto L15;
        r103 = true;
        goto L15
    L9:
        if (r102.contains(":") == false) goto L11;
        return false;
    L5:
        return r101.booleanValue();
    }

    public static Boolean isMainProcessStart(Context r100) {
        IPushCommonConfiguration r101 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
        if (r101 != null) goto L5;
    L26:
        f.b("ToolUtils", "hasAgreedForPrivacyDialog return false when isMainProcessStart is invoked.");
        return null;
    L5:
        if (r101.hasAgreedForPrivacyDialog() == false) goto L26;
        if (isMainProcess(r100) == false) goto L11;
        f.b("ToolUtils", "isMainProcess return true when isMainProcessStart is invoked.");
        return Boolean.TRUE;
    L11:
        f.b("ToolUtils", "getRunningAppProcesses is to be invoked when isMainProcessStart is invoked.");
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L25
        List<ActivityManager.RunningAppProcessInfo> r103 = getRunningAppProcesses();     // Catch: Throwable -> L25
        String r104 = r100.getPackageName();     // Catch: Throwable -> L25
        if (r103 == null) goto L24;
        if (r103.isEmpty() == true) goto L24;
        Iterator<ActivityManager.RunningAppProcessInfo> r105 = r103.iterator();     // Catch: Throwable -> L25
    L18:
        if (r105.hasNext() == false) goto L24;
        if (r104.equals(r105.next().processName) == false) goto L18;
        return Boolean.TRUE;
    L24:
        return Boolean.FALSE;
    L25:
        return null;
    }

    public static boolean isMessageProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L10;
        isMainProcess = Boolean.FALSE;
        return true;
    L10:
        return false;
    }

    public static boolean isPushServiceProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.endsWith(PUSH_SERVICE_PROCESS_SUFFIX) == false) goto L10;
        isMainProcess = Boolean.FALSE;
        return true;
    L10:
        return false;
    }

    public static boolean isSmpProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.endsWith(SMP_PROCESS_SUFFIX) == false) goto L7;
    L8:
        isMainProcess = Boolean.FALSE;
        return true;
    L7:
        if (r101.endsWith(SMP_PROCESS_SUFFIX_V2) == true) goto L8;
        return false;
    }

    public static boolean isSmpProcessStart(Context r100) {
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.hasAgreedForPrivacyDialog() == true) goto L7;
        f.b("ToolUtils", "hasAgreedForPrivacyDialog return false when isSmpProcessStart is invoked.");
        return false;
    L7:
        if (isSmpProcess(r100) == false) goto L10;
        f.b("ToolUtils", "isSmpProcess return true when isSmpProcessStart is invoked.");
        return true;
    L10:
        f.b("ToolUtils", "getRunningAppProcesses is to be invoked when isSmpProcessStart is invoked.");
        List<ActivityManager.RunningAppProcessInfo> r101 = getRunningAppProcesses();     // Catch: Throwable -> L22
        String r102 = r100.getPackageName() + ":smp";     // Catch: Throwable -> L22
        if (r101 == null) goto L21;
        if (r101.isEmpty() == true) goto L21;
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r101.iterator();     // Catch: Throwable -> L22
    L17:
        if (r103.hasNext() == false) goto L21;
        if (r102.equals(r103.next().processName) == false) goto L17;
        return true;
    L21:
        return false;
    }

    public static boolean isTargetBrandDevice(String r100) {
        String r101 = Build.BRAND;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r101) == false) goto L6;
    L7:
        String r102 = Build.MANUFACTURER;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r102) == true) goto L16;
        if (r102.toLowerCase().startsWith(r100) == true) goto L12;
        return false;
    L12:
        return true;
    L16:
        return false;
    L6:
        if (r101.toLowerCase().startsWith(r100) == true) goto L12;
    L18:
        return false;
    }

    public static void killAll(Context r100) {
        f.a("kill all");
        List<ActivityManager.RunningAppProcessInfo> r101 = getRunningAppProcesses();
        if (r101 == null) goto L10;
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();
        if (r103.pid == Process.myPid()) goto L6;
        Process.killProcess(r103.pid);
    L10:
        Process.killProcess(Process.myPid());
    }

    public static String listToString(List<Long> r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        int r102 = r100.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        r101.append((Long) ListProtector.get(r100, r103));
        if (r103 >= (r102 - 1)) goto L11;
        r101.append(",");
    L11:
        r103 = r103 + 1;
    L13:
        return r101.toString();
    }

    public static String listToStringDivideByComma(List<String> r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L19;
        if (r100.isEmpty() == true) goto L19;
        Iterator<String> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        if (TextUtils.isEmpty(r102.next()) == false) goto L8;
        r102.remove();
        goto L8
    L12:
        int r103 = r100.size();
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L19;
        r101.append((String) ListProtector.get(r100, r104));
        if (r104 >= (r103 - 1)) goto L17;
        r101.append(",");
    L17:
        r104 = r104 + 1;
    L19:
        return r101.toString();
    }

    public static void setMessageProcessSuffix(String r100) {
        MESSAGE_PROCESS_SUFFIX = r100;
    }

    public static void setProcessName(String r100) {
        sCurProcessName = r100;
    }

    public static void setPushServiceProcessSuffix(String r100) {
        PUSH_SERVICE_PROCESS_SUFFIX = r100;
    }

    public static List<String> stringDividedByCommaToList(String r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L22:
        return r101;
    L5:
        if (r100.length() <= 0) goto L22;
        String[] r102 = r100.split(",");     // Catch: Throwable -> L20
        Iterator r103 = new ArrayList(Arrays.asList(r102)).iterator();     // Catch: Throwable -> L20
    L8:
        if (r103.hasNext() == false) goto L12;
        if (TextUtils.isEmpty((String) r103.next()) == false) goto L8;
        r103.remove();     // Catch: Throwable -> L20
        goto L8
    L12:
        int r104 = r102.length;     // Catch: Throwable -> L20
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L22;
        String r106 = r102[r105];     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r106) == true) goto L19;
        if (r101.contains(r106) == true) goto L19;
        r101.add(r106);     // Catch: Throwable -> L20
    L19:
        r105 = r105 + 1;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    }

    public static List<Long> stringToList(String r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L20:
        return r101;
    L5:
        if (r100.length() <= 0) goto L20;
        String[] r102 = r100.split(",");     // Catch: Throwable -> L18
        Iterator r103 = new ArrayList(Arrays.asList(r102)).iterator();     // Catch: Throwable -> L18
    L8:
        if (r103.hasNext() == false) goto L12;
        if (TextUtils.isEmpty((String) r103.next()) == false) goto L8;
        r103.remove();     // Catch: Throwable -> L18
        goto L8
    L12:
        int r104 = r102.length;     // Catch: Throwable -> L18
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L20;
        String r106 = r102[r105];     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r106) == true) goto L17;
        r101.add(CastLongProtector.valueOf(r106));     // Catch: Throwable -> L21
    L17:
        r105 = r105 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static String toSha256(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L10
        r101.update(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L10
        byte[] r102 = r101.digest();     // Catch: Throwable -> L10
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L10
        int r104 = r102.length;     // Catch: Throwable -> L10
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE);     // Catch: Throwable -> L10
        if (r106.length() != 1) goto L7;
        r103.append('0');     // Catch: Throwable -> L10
    L7:
        r103.append(r106);     // Catch: Throwable -> L10
        r105 = r105 + 1;     // Catch: Throwable -> L10
        goto L3
    L8:
        return r103.toString();
    L10:
        th = move-exception;
        f.e("ToolUtils", "[toMd5]exception:" + th.getLocalizedMessage());
        return r100;
    }

    public static String addUrlParam(String r100, Map<String, String> r101) {
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L9;
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();
        r102.add(new Pair(r104.getKey(), r104.getValue()));
    L9:
        return addUrlParam(r100, r102);
    }

    private static int com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_ss_android_message_util_ToolUtils_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r110, r111};
        b r112 = new b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private static Process com_ss_android_message_util_ToolUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static String getProcessSuffix(Context r100, String r101) {
        if (TextUtils.equals(r101, r100.getPackageName()) == false) goto L6;
        return PullConfiguration.PROCESS_NAME_MAIN;
    L6:
        if (r101.contains(":") == true) goto L11;
        return "";
    L11:
        return r101.split(":")[1];
    }

    public static List<ActivityManager.RunningTaskInfo> getRunningTasks(ActivityManager r100, int r101) {
        return r100.getRunningTasks(r101);
    }

    public static void getSSIDs(Context r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = r100.getSharedPreferences("push_multi_process_config", 4).getString(MultiProcessFileUtils.KEY_SSIDS, "");
        if (StringUtils.isEmpty(r102) == false) goto L7;
        return;
    L7:
        StringUtils.stringToMap(r102, r101);
    }

    public static ApplicationInfo getTargetApplicationInfo(Context r100, String r101) {
        return r100.getPackageManager().getApplicationInfo(r101, 0);
    L4:
        return null;
    }

    public static boolean isApplicationForeground(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L27;
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> r103 = getRunningAppProcesses();
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.isEmpty() == true) goto L25;
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L28;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();
        if (r101.equals(r105.processName) == false) goto L13;
        if (r105.importance != 100) goto L26;
        return true;
    L26:
        return false;
    L28:
        return false;
    L25:
        return false;
    L27:
        return false;
    }

    public static boolean isInstalledApp(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(r101, 65536);
        if (r102 != null) goto L8;
    L11:
        return false;
    L8:
        if (r102.size() <= 0) goto L11;
        return true;
    }

    public static boolean parseBool(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return r101;
    L9:
        return Boolean.parseBoolean(r100);
    L6:
        th = move-exception;
        f.f("ToolUtils", "[parseBool] ", th);
        goto L8
    }

    public static int parseInt(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return r101;
    L9:
        return CastIntegerProtector.parseInt(r100);
    L6:
        th = move-exception;
        f.f("ToolUtils", "[parseLong] ", th);
        goto L8
    }

    public static long parseLong(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return r101;
    L9:
        return CastLongProtector.parseLong(r100);
    L6:
        th = move-exception;
        f.f("ToolUtils", "[parseLong] ", th);
        goto L8
    }

    public static String addUrlParam(String r100, List<Pair<String, String>> r101) {
        StringBuilder r102 = new StringBuilder(r100);
        if (r100.indexOf(63) >= 0) goto L5;
        r102.append("?");
    L6:
        r102.append(NetworkUtils.format(r101, "UTF-8"));
        return r102.toString();
    L5:
        r102.append("&");
        goto L6
    }

    public static boolean isInstalledApp(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        if (r100.getPackageManager().getPackageInfo(r101, 0) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static boolean isServiceRunning(Context r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (StringUtils.isEmpty(r102) == true) goto L35;
        List<ActivityManager.RunningServiceInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);     // Catch: Throwable -> L22
        if (r103 != null) goto L12;
        return false;
    L12:
        if (r103.size() <= 0) goto L34;
        Iterator<ActivityManager.RunningServiceInfo> r104 = r103.iterator();     // Catch: Throwable -> L22
    L15:
        if (r104.hasNext() == false) goto L37;
        ActivityManager.RunningServiceInfo r105 = r104.next();     // Catch: Throwable -> L22
        if (r101.equals(r105.service.getPackageName()) == false) goto L15;
        if (r102.equals(r105.service.getClassName()) == false) goto L15;
        return true;
    L37:
        return false;
    L34:
        return false;
    L36:
        return false;
    L35:
        return false;
    }

    public static void setComponentEnable(Context r100, String r101, boolean r102) {
        ComponentName r103 = new ComponentName(r100.getPackageName(), r101);
        PackageManager r104 = r100.getPackageManager();
        f.g("", "set " + r101 + " enable to " + r102);     // Catch: Throwable -> L9
        if (r102 == false) goto L6;
        int r105 = 1;
    L7:
        r104.setComponentEnabledSetting(r103, r105, 1);     // Catch: Throwable -> L9
        return;
    L6:
        r105 = 2;
    L9:
        th = move-exception;
        f.d("error to set " + r101 + " enable to " + r102);
        th.printStackTrace();
    }
}
