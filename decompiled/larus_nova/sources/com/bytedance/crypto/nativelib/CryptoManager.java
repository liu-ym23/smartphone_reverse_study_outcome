package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public class CryptoManager {
    private static volatile CryptoManager cryptoManager;
    private Context mContext;

    public CryptoManager() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native void nativeInit(Context r100);

    public String chacha20BytesXcrypt(int r100, String r101, String r102) {
        return null;
    }

    static {
        INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("cryptolib");
    }

    public static CryptoManager getInstance() {
        if (cryptoManager != null) goto L15;
        monitor-enter(CryptoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cryptoManager != null) goto L9;
        cryptoManager = new CryptoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CryptoManager.class);     // Catch: Throwable -> L11
    L15:
        return cryptoManager;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public void init(Context r100) {
        if (r100 == null) goto L5;
        nativeInit(r100.getApplicationContext());
        return;
    }
}
