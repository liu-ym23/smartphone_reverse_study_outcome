package com.bytedance.common.jato;

import android.text.TextUtils;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class JatoNativeLoader {
    private static final List<String> sBlockJNIMethods = null;
    private static int sIsLoaded;

    public JatoNativeLoader() {
    }

    private static native void addJNIGuardBlackList(String r100);

    static {
        sBlockJNIMethods = new LinkedList();
    }

    private static void flushJNIGuardMethodsToNative() {
        Iterator<String> r100 = sBlockJNIMethods.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r101 = r100.next();
        if (TextUtils.isEmpty(r101) == true) goto L4;
        addJNIGuardBlackList(r101);
        goto L4
    L9:
        sBlockJNIMethods.clear();
    }

    public static boolean isLoaded() {
        if (sIsLoaded <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void loadJNIGuardLocalConfig() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/data/local/tmp/jni_guard_config");
        if (r100.exists() == true) goto L5;
        return;
    L5:
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L17 Exception -> L19
    L40:
        String r103 = r102.readLine();     // Catch: Throwable -> L13 Exception -> L15
        if (r103 == null) goto L11;
        sBlockJNIMethods.add(r103);     // Catch: Throwable -> L13 Exception -> L15
    L11:
        r102.close();     // Catch: Exception -> L24
    L33:
        return;
    L15:
        e = e;
        r101 = r102;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L17
        if (r101 == null) goto L45;
        r101.close();     // Catch: Exception -> L24
        goto L33
    L45:
        return;
    L13:
        th = th;
        r101 = r102;
    L27:
        if (r101 != null) goto L36;
    L32:
        throw th;
    L36:
        r101.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = e;
    L17:
        th = th;
        goto L27
    }

    public static synchronized boolean loadLibrary() {
        monitor-enter(JatoNativeLoader.class);
        int r100 = sIsLoaded;     // Catch: Throwable -> L20
        boolean r101 = false;
        if (r100 == 0) goto L25;
        if (r100 <= 0) goto L9;
        r101 = true;
    L9:
        monitor-exit(JatoNativeLoader.class);
        return r101;
    L25:
        INVOKESTATIC_com_bytedance_common_jato_JatoNativeLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("jato");     // Catch: Throwable -> L13
        loadJNIGuardLocalConfig();     // Catch: Throwable -> L13
        flushJNIGuardMethodsToNative();     // Catch: Throwable -> L13
        sIsLoaded = 1;     // Catch: Throwable -> L13
    L15:
        if (sIsLoaded <= 0) goto L18;
        r101 = true;
    L18:
        monitor-exit(JatoNativeLoader.class);
        return r101;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        sIsLoaded = -1;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_common_jato_JatoNativeLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void addJNIGuardBlockFunc(List<String> r100) {
        if (isLoaded() == false) goto L11;
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L18;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L6;
        addJNIGuardBlackList(r102);
        goto L6
    L18:
        return;
    L11:
        sBlockJNIMethods.addAll(r100);
    }
}
