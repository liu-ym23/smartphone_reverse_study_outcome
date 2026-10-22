package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class CryptoManagerProxy {
    private static volatile CryptoManagerProxy cryptoManager;
    private String mAppid;
    private IEnvBridge mBridge;
    private CloudTransCryptoManager mCloudTransCryptoManager;
    private Context mContext;

    static {
        INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManagerProxy_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("cryptolib");
    }

    public CryptoManagerProxy() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static CryptoManagerProxy getInstance() {
        if (cryptoManager != null) goto L15;
        monitor-enter(CryptoManagerProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cryptoManager != null) goto L9;
        cryptoManager = new CryptoManagerProxy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CryptoManagerProxy.class);     // Catch: Throwable -> L11
    L15:
        return cryptoManager;
    }

    public String chacha20BytesXcrypt(int r100, String r101, String r102) {
        LogUtils.d("CryptoManager", "mode: " + r100 + ", appId: " + r101);
        if (r100 != 1) goto L7;
        return Base64.getEncoder().encodeToString(LocalDataCrypto.getInstance().bytesXcrypt(r100, CryptoConst.ALGORITHM_CHACHA20, r101, r102.getBytes(StandardCharsets.UTF_8)));
    L7:
        return new String(LocalDataCrypto.getInstance().bytesXcrypt(r100, CryptoConst.ALGORITHM_CHACHA20, r101, Base64.getDecoder().decode(r102)), StandardCharsets.UTF_8);
    }

    public String cloudTransXcrypt(int r100, String r101, String r102) {
        LogUtils.d("CryptoManager", "mode: " + r100);
        init(this.mContext, this.mAppid, r101, this.mBridge);
        if (r100 != 1) goto L9;
        return Base64.getEncoder().encodeToString(this.mCloudTransCryptoManager.dataEncrypt(r102.getBytes(StandardCharsets.UTF_8)));
    L9:
        if (r100 != 2) goto L13;
        return new String(this.mCloudTransCryptoManager.dataDecrypt(Base64.getDecoder().decode(r102)), StandardCharsets.UTF_8);
    L13:
        throw new CloudTransException("mode is invalid");     // Catch: CloudTransException -> L6
    L6:
        e = move-exception;
        LogUtils.e("CryptoManager", "cloudTransXcrypt error: " + e.getMessage());
        throw e;
    }

    public void init(Context r100) {
        LocalDataCrypto.getInstance().init(r100);
    }

    public void init(Context r100, String r101, String r102, IEnvBridge r103) {
        LocalDataCrypto.getInstance().init(r100);
        CloudTransCryptoManager r104 = CloudTransCryptoManager.getInstance();
        this.mCloudTransCryptoManager = r104;
        r104.init(r100, r101, r102, r103);
        this.mContext = r100;
        this.mBridge = r103;
        this.mAppid = r101;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_crypto_nativelib_CryptoManagerProxy_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
