package com.ss.videoarch.strategy.log;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AppLogWrapperTOB {
    public static final String APPLOGWRAPPE_CLASS_NAME = "com.pandora.common.applog.AppLogWrapper";
    public static final String APPLOG_CLASS_NAME = "com.bytedance.applog.AppLog";
    private static final String TAG = "AppLogTOB";
    private static Class<?> sAppLogClass;
    private static Class<?> sAppLogWrapperClass;

    public AppLogWrapperTOB() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isAppLogExist() {
        if (getAppLogClass() == null) goto L12;
        if (getAppLogWrapperClass() == null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    private static Class<?> getAppLogClass() throws ClassNotFoundException {
        monitor-enter(AppLogWrapperTOB.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAppLogClass != null) goto L7;
        sAppLogClass = INVOKESTATIC_com_ss_videoarch_strategy_log_AppLogWrapperTOB_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APPLOG_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        Class<?> r100 = sAppLogClass;     // Catch: Throwable -> L10
        monitor-exit(AppLogWrapperTOB.class);     // Catch: Throwable -> L10
        return r100;
    }

    private static Class<?> getAppLogWrapperClass() throws ClassNotFoundException {
        monitor-enter(AppLogWrapperTOB.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAppLogWrapperClass != null) goto L7;
        sAppLogWrapperClass = INVOKESTATIC_com_ss_videoarch_strategy_log_AppLogWrapperTOB_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APPLOGWRAPPE_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        Class<?> r100 = sAppLogWrapperClass;     // Catch: Throwable -> L10
        monitor-exit(AppLogWrapperTOB.class);     // Catch: Throwable -> L10
        return r100;
    }

    public static String getDeviceID() {
        Class<?> r100 = getAppLogWrapperClass();     // Catch: Exception -> L4
        Method r101 = r100.getDeclaredMethod("getDid", new Class[0]);     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        return (String) r101.invoke(r100, new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_strategy_log_AppLogWrapperTOB_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void onEventV3(String r100, JSONObject r101) {
        Class<?> r102 = getAppLogWrapperClass();     // Catch: Exception -> L4
        Method r103 = r102.getDeclaredMethod("onEventV3", new Class[]{String.class, JSONObject.class});     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        r103.invoke(r102, new Object[]{r100, r101});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
