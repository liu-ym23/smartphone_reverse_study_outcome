package com.bytedance.mira.plugin.linker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class NSLinker {
    public NSLinker() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private static native boolean native_android_create_classloader_namespace(int r0, int r1, Object r2, boolean r3, String r4);

    private static native boolean native_android_link_namespace(int r0, Object r1, Object r2, String r3);

    static {
        INVOKESTATIC_com_bytedance_mira_plugin_linker_NSLinker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("nslinker");
    }

    private static int getAndroidVersion() {
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L6;
        return Build.VERSION.SDK_INT + 1;
    L6:
        return Build.VERSION.SDK_INT;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_mira_plugin_linker_NSLinker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private static String getLibraryPath(Object r4) {
        Method r0 = BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (String) r0.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        NSLogger.E("Fail:The getLibraryPath method failed to execute, the error message is:" + Log.getStackTraceString(e));
        return null;
    }

    private static int getTargetSdkVersion(Context r1) {
        ApplicationInfo r0 = null;
        if (r1 != null) goto L5;
        Context r2 = null;
    L6:
        if (r2 == null) goto L9;
        r0 = r2.getApplicationInfo();
    L9:
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.targetSdkVersion;
    L5:
        r2 = r1.getApplicationContext();
        goto L6
    }

    public static boolean createClassLoaderNameSpace(Context r3, Object r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
        NSLogger.E("Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L6:
        int r1 = getAndroidVersion();
        if (r1 > 25) goto L10;
        r0 = true;
    L10:
        return native_android_create_classloader_namespace(r1, getTargetSdkVersion(r3), r4, r0, getLibraryPath(r4));
    }

    public static boolean updateClassLoaderParent(Object r2, Object r3) {
        Field r0 = ClassLoader.class.getDeclaredField("parent");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.set(r2, r3);     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        NSLogger.E("Fail:The updateClassLoaderParent method failed to execute, the error message is:" + Log.getStackTraceString(e));
        return false;
    }

    public static boolean linkNameSpace(Object r2, Object r3, List<String> r4) {
        if (r4 != null) goto L4;
    L14:
        NSLogger.E("Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L4:
        if (r4.isEmpty() == true) goto L14;
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r0.append(r5.next());
        r0.append(":");
        goto L10
    L12:
        int r6 = r0.length();
        r0.delete(r6 - 1, r6);
        return native_android_link_namespace(getAndroidVersion(), r2, r3, r0.toString());
    }
}
