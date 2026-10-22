package com.ss.ttvideoengine;

import android.text.TextUtils;
import android.util.Base64;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.ttvideodecode.Native;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class JniUtils {
    private static final String TAG = "JniUtils";
    public static volatile String exception = "";
    public static volatile boolean isLibraryLoaded;
    public static volatile LibraryLoaderProxy mProxy;

    public JniUtils() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static int getDecodeMethod() throws Exception {
        String r100 = "exception is null";
        if (isLibraryLoaded == true) goto L19;
        StringBuilder r101 = new StringBuilder("library not load suc exception:");
        if (exception == null) goto L8;
        r100 = exception;
    L8:
        r101.append(r100);
        throw new Exception(r101.toString());
    L19:
        return getSupportedMethod();
    L12:
        th = move-exception;
        StringBuilder r102 = new StringBuilder("getDecodedStr exception:");
        if (th.toString() == null) goto L17;
        r100 = th.toString();
    L17:
        r102.append(r100);
        throw new Exception(r102.toString());
    }

    public static synchronized void loadLibrary() {
        monitor-enter(JniUtils.class);
    L12:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L16
        exception = th.toString();     // Catch: Throwable -> L16
    L14:
        monitor-exit(JniUtils.class);
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isLibraryLoaded == true) goto L14;
        TTVideoEngineLog.d(TAG, "JniUtils.loadLibrary");     // Catch: Throwable -> L12
        if (mProxy == null) goto L9;
        mProxy.loadLibrary("videodec");     // Catch: Throwable -> L12
    L10:
        isLibraryLoaded = true;     // Catch: Throwable -> L12
        goto L14
    L9:
        INVOKESTATIC_com_ss_ttvideoengine_JniUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("videodec");     // Catch: Throwable -> L12
        goto L10
    }

    static {
        if (EngineGlobalConfig.getInstance().getLazyLoadVideodec() != 1) goto L6;
        TTVideoEngineLog.d(TAG, "JniUtils.loadLibrary in static block");
        loadLibrary();
        return;
    }

    public static int getSupportedMethod() {
        return Native.getSupportedMethod();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_ttvideoengine_JniUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static byte[] getSettingSignature(String r100) {
        if (isLibraryLoaded == true) goto L6;
        TTVideoEngineLog.d(TAG, "library not load exception:" + exception);
        return null;
    L6:
        if (r100 != null) goto L14;
        TTVideoEngineLog.d(TAG, "getSettingSignature content is null");
        return null;
    L14:
        return getSignature(r100);
    L11:
        th = move-exception;
        TTVideoEngineLog.d(TAG, "getSettingSignature throwable:" + th);
        return null;
    }

    public static byte[] getSignature(String r100) {
        return Native.getSignature(r100);
    }

    public static void setLoadProxy(LibraryLoaderProxy r100) {
        if (r100 == null) goto L5;
        mProxy = r100;
        return;
    }

    private static byte[] encryptAesCbc128(byte[] r100, byte[] r101) {
        return Native.encryptAesCbc128(r100, r101);
    }

    public static String encryptTimestamp(String r100, String r101) {
        if (isLibraryLoaded == true) goto L7;
        TTVideoEngineLog.d(TAG, "library not load exception:" + exception);
        return "";
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L16:
        return "";
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        byte[] r102 = encryptAesCbc128(r100.getBytes(), r101.getBytes());
        if (r102.length > 0) goto L15;
        return "";
    L15:
        return new String(Base64.encode(r102, 0));
    }

    public static String getDecodedStr(byte[] r100, byte[] r101) {
        return Native.getDecodedStr(r100, r101);
    }

    public static String getDecodedStrWithKey(byte[] r100, byte[] r101) throws Exception {
        String r102 = "exception is null";
        if (isLibraryLoaded == true) goto L19;
        StringBuilder r103 = new StringBuilder("library not load suc exception:");
        if (exception == null) goto L8;
        r102 = exception;
    L8:
        r103.append(r102);
        throw new Exception(r103.toString());
    L19:
        return getDecodedStr(r100, r101);
    L12:
        th = move-exception;
        StringBuilder r104 = new StringBuilder("getDecodedStr exception:");
        if (th.toString() == null) goto L17;
        r102 = th.toString();
    L17:
        r104.append(r102);
        throw new Exception(r104.toString());
    }
}
