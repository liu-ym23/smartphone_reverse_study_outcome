package com.ss.ttm.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.TTPlayerConfiger;
import el9.a;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class AVLogger {
    public static final boolean DEBUG = false;
    public static final String FORMAT = "<%s,%x>%s";
    public static final int LEVEL_LOG_ALL = 0;
    public static final int LEVEL_LOG_DEBUG = 16777216;
    public static final int LEVEL_LOG_ERROR = 67108864;
    public static final int LEVEL_LOG_FATAL = 83886080;
    public static final int LEVEL_LOG_INFO = 33554432;
    public static final int LEVEL_LOG_INFO_KILL = 34603008;
    public static final int LEVEL_LOG_INFO_TRACK_FUNC = 42860544;
    public static final int LEVEL_LOG_INFO_TRACK_LIFE = 42926080;
    public static final int LEVEL_LOG_SILENT = 100663296;
    public static final int LEVEL_LOG_VERBOSE = 0;
    public static final int LEVEL_LOG_WARN = 50331648;
    private static final String TAG = "ttmj";
    private static final String TTVideoEngineLog = "com.ss.ttvideoengine.utils.TTVideoEngineLog";
    private static int gLogLevel = 33554432;
    private static Method methodLogD;
    private static Method methodLogE;
    private static Method methodLogI;
    private static Method methodLogW;
    private static Class<?> objectTTVideoEngineLog;

    public AVLogger() {
    }

    public static void Debug(String r100, Object r101, String r102) {
    }

    public static void Verbose(String r100, Object r101, String r102) {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void d(String r100, String r101) {
    }

    public static void v(String r100, String r101) {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttm_utils_AVLogger_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void setLogLevel(int r100) {
        gLogLevel = r100;
    }

    public static void e(String r100, String r101) {
        Error(r100, null, r101);
    }

    public static void i(String r100, String r101) {
        Info(r100, null, r101);
    }

    public static void k(String r100, String r101) {
        InfoKill(r100, null, r101);
    }

    public static void w(String r100, String r101) {
        Warn(r100, null, r101);
    }

    public static void Error(String r100, Object r101, String r102) {
        log(67108864, r100, r101, r102);
    }

    public static void Info(String r100, Object r101, String r102) {
        log(33554432, r100, r101, r102);
    }

    public static void InfoKill(String r100, Object r101, String r102) {
        log(34603008, r100, r101, r102);
    }

    public static void InfoTrackFunc(String r100, Object r101, String r102) {
        log(42860544, r100, r101, r102);
    }

    public static void InfoTrackLife(String r100, Object r101, String r102) {
        log(42926080, r100, r101, r102);
    }

    public static void Warn(String r100, Object r101, String r102) {
        log(50331648, r100, r101, r102);
    }

    private static void log(int r100, String r101, Object r110, String r111) {
        if (r100 >= (gLogLevel & (-65536))) goto L6;
        return;
    L6:
        if (TTPlayerConfiger.getValue(75, 0) != 1) goto L8;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L20:
        Locale r103 = Locale.US;
        Object[] r104 = new Object[3];
        r104[0] = r101;
        if (r110 != null) goto L23;
        int r105 = 0;
    L24:
        r104[1] = Integer.valueOf(r105);
        r104[2] = r111;
        String r106 = String.format(r103, FORMAT, r104);
        if (r100 != 0) goto L27;
        if (r102 == false) goto L54;
        com.ss.vcbkit.a.d(r106);     // Catch: Exception -> L52
    L62:
        return;
    L54:
        if (r102 == false) goto L56;
        com.ss.vcbkit.a.a(r106);     // Catch: Exception -> L52
        goto L62
    L56:
        methodLogD.invoke(objectTTVideoEngineLog, new Object[]{TAG, r106});     // Catch: Exception -> L52
        goto L62
    L27:
        if (r100 == 16777216) goto L54;
        if (r100 != 33554432) goto L31;
    L47:
        if (r102 == false) goto L49;
        com.ss.vcbkit.a.c(TAG, r106);     // Catch: Exception -> L52
        goto L62
    L49:
        methodLogI.invoke(objectTTVideoEngineLog, new Object[]{TAG, r106});     // Catch: Exception -> L52
        goto L62
    L31:
        if (r100 == 34603008) goto L47;
        if (r100 == 42860544) goto L47;
        if (r100 == 42926080) goto L47;
        if (r100 != 50331648) goto L39;
        if (r102 == false) goto L46;
        com.ss.vcbkit.a.e(TAG, r106);     // Catch: Exception -> L52
        goto L62
    L46:
        methodLogW.invoke(objectTTVideoEngineLog, new Object[]{TAG, r106});     // Catch: Exception -> L52
        goto L62
    L39:
        if (r100 != 67108864) goto L66;
        if (r102 == false) goto L43;
        com.ss.vcbkit.a.b(TAG, r106);     // Catch: Exception -> L52
        goto L62
    L43:
        methodLogE.invoke(objectTTVideoEngineLog, new Object[]{TAG, r106});     // Catch: Exception -> L52
        goto L62
    L66:
        return;
    L52:
        e = move-exception;
        e.toString();
        return;
    L23:
        r105 = r110.hashCode();
        goto L24
    L12:
        if (objectTTVideoEngineLog != null) goto L20;
        Class<?> r107 = INVOKESTATIC_com_ss_ttm_utils_AVLogger_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTVideoEngineLog);     // Catch: Exception -> L17
        objectTTVideoEngineLog = r107;     // Catch: Exception -> L17
        if (r107 == null) goto L20;
        methodLogD = r107.getMethod("d", new Class[]{String.class, String.class});     // Catch: Exception -> L17
        methodLogI = objectTTVideoEngineLog.getMethod(RXScreenCaptureService.KEY_INDEX, new Class[]{String.class, String.class});     // Catch: Exception -> L17
        methodLogW = objectTTVideoEngineLog.getMethod("w", new Class[]{String.class, String.class});     // Catch: Exception -> L17
        methodLogE = objectTTVideoEngineLog.getMethod("e", new Class[]{String.class, String.class});     // Catch: Exception -> L17
    L17:
        e = move-exception;
        objectTTVideoEngineLog = null;
        e.toString();
        return;
    L8:
        r102 = false;
        goto L10
    }
}
