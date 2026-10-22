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

/* JADX INFO: loaded from: classes.dex */
public final class NSLinker {
    public NSLinker() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native boolean native_android_create_classloader_namespace(int r100, int r101, Object r102, boolean r103, String r104);

    private static native boolean native_android_link_namespace(int r100, Object r101, Object r102, String r103);

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
    public static void INVOKESTATIC_com_bytedance_mira_plugin_linker_NSLinker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static String getLibraryPath(Object r100) {
        Method r101 = BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]);     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        return (String) r101.invoke(r100, new Object[0]);
    L4:
        e = move-exception;
        NSLogger.E("Fail:The getLibraryPath method failed to execute, the error message is:" + Log.getStackTraceString(e));
        return null;
    }

    private static int getTargetSdkVersion(Context r100) {
        ApplicationInfo r101 = null;
        if (r100 != null) goto L5;
        Context r102 = null;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.getApplicationInfo();
    L9:
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.targetSdkVersion;
    L5:
        r102 = r100.getApplicationContext();
        goto L6
    }

    public static boolean createClassLoaderNameSpace(Context r100, Object r101) {
        boolean r102 = false;
        if (r101 != null) goto L6;
        NSLogger.E("Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L6:
        int r103 = getAndroidVersion();
        if (r103 > 25) goto L10;
        r102 = true;
    L10:
        return native_android_create_classloader_namespace(r103, getTargetSdkVersion(r100), r101, r102, getLibraryPath(r101));
    }

    public static boolean updateClassLoaderParent(Object r100, Object r101) {
        Field r102 = ClassLoader.class.getDeclaredField("parent");     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        r102.set(r100, r101);     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        NSLogger.E("Fail:The updateClassLoaderParent method failed to execute, the error message is:" + Log.getStackTraceString(e));
        return false;
    }

    public static boolean linkNameSpace(Object r100, Object r101, List<String> r102) {
        if (r102 != null) goto L4;
    L14:
        NSLogger.E("Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L4:
        if (r102.isEmpty() == true) goto L14;
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        StringBuilder r103 = new StringBuilder();
        Iterator<String> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r103.append(r104.next());
        r103.append(":");
        goto L10
    L12:
        int r105 = r103.length();
        r103.delete(r105 - 1, r105);
        return native_android_link_namespace(getAndroidVersion(), r100, r101, r103.toString());
    }
}
