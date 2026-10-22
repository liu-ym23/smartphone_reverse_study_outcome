package com.bytedance.mira.plugin.trip.natvierutime.artmethod;

import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ArtMethodExt {
    private static final String TAG = "ArtMethodExt";
    private static volatile boolean sInit;

    public ArtMethodExt() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    private static boolean invokeHiddenApiRestrictions() {
        Method r100 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L5
        Class r101 = INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_artmethod_ArtMethodExt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.VMRuntime");     // Catch: Exception -> L5
        Method r102 = (Method) r100.invoke(r101, new Object[]{"getRuntime", new Class[0]});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Exception -> L5
        Method r104 = (Method) r100.invoke(r101, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});     // Catch: Exception -> L5
        r104.setAccessible(true);     // Catch: Exception -> L5
        r104.invoke(r103, new Object[]{new String[]{"L"}});     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        Log.getStackTraceString(e);
        return false;
    }

    private static void m1() {
    }

    private static void m2() {
    }

    private static native void native_disable_run_java_method(Object r100);

    private static native void native_force_true_java_method(Object r100);

    public static boolean init() {
        if (sInit == true) goto L15;
        monitor-enter(ArtMethodExt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInit == true) goto L9;
        sInit = initInternal();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ArtMethodExt.class);     // Catch: Throwable -> L11
    L15:
        return sInit;
    }

    public static boolean isX86Machine() {
        String[] r100 = Build.SUPPORTED_ABIS;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r100[r102].contains("x86") == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean initInternal() {
        if (isX86Machine() == false) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT != 28) goto L8;
        boolean r100 = invokeHiddenApiRestrictions();
    L9:
        if (r100 == true) goto L15;
        return false;
    L15:
        INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_artmethod_ArtMethodExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("art_method_ext");     // Catch: Throwable -> L14
        return r100;
    L17:
        return false;
    L8:
        r100 = true;
        goto L9
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_artmethod_ArtMethodExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_artmethod_ArtMethodExt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean disableRun(Object r100) {
        if (sInit == true) goto L11;
        return false;
    L11:
        native_disable_run_java_method(r100);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        Log.getStackTraceString(th);
        return false;
    }

    public static boolean forceTrue(Object r100) {
        if (sInit == true) goto L11;
        return false;
    L11:
        native_force_true_java_method(r100);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        Log.getStackTraceString(th);
        return false;
    }
}
