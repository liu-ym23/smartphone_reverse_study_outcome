package com.bytedance.crypto.platform;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.obfuscated.g;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.platformlib.PlatformLib;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ExternalPlatKeyManager {
    private static final String TAG = "ExternalPlatKeyManager";
    private static volatile ExternalPlatKeyManager externalPlatKeyManager;

    private ExternalPlatKeyManager() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static ExternalPlatKeyManager getInstance() {
        if (externalPlatKeyManager != null) goto L15;
        monitor-enter(ExternalPlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (externalPlatKeyManager != null) goto L9;
        externalPlatKeyManager = new ExternalPlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalPlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return externalPlatKeyManager;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_crypto_platform_ExternalPlatKeyManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public int init(Context r110, String r111) {
        String r100 = "";
        g r101 = g.a();
        r101.getClass();
        if (r110 == null) goto L27;
        if (r111 == null) goto L27;
        if (r111.isEmpty() == true) goto L27;
        int r102 = r101.a(r110);
        if (r102 == 0) goto L11;
        LogUtils.e("PlatKeyManagerImpl", "Permission denied, ret: " + r102);
        return -1;
    L11:
        e r103 = b.a(r111, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r103 != null) goto L14;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return -8;
    L14:
        PlatformLib r104 = new PlatformLib();
        String r105 = r103.f204239c;
        Bundle r112 = new Bundle();
        r112.putString("pkg_name", r110.getOpPackageName());
        r112.putString("brand", Build.BRAND);
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 31) goto L17;
        r112.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, Build.SOC_MODEL);
    L23:
        LogUtils.d("PlatKeyManagerImpl", "Build.MANUFACTURER: " + Build.MANUFACTURER);
        LogUtils.d("PlatKeyManagerImpl", "DeviceInfo bundle: " + r112.toString());
        byte[] r107 = r104.init(1, 1, "bdc5afe786f38d4533628da5ea01364dd4a91ae36bb898125f25bde25cd991f2", r105, r112);
        g.f204244c = r107;
        if (r107 == null) goto L26;
        LogUtils.d("PlatKeyManagerImpl", "sharedKeyHash: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r107, "SHA-256")));
        return 0;
    L26:
        LogUtils.e("PlatKeyManagerImpl", "init failed");
        return -14;
    L17:
        LogUtils.d("PlatKeyManagerImpl", "Current sdk version: " + r106);
        Class r108 = INVOKESTATIC_com_bytedance_crypto_platform_ExternalPlatKeyManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L20
        r100 = (String) r108.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r108, new Object[]{PlatformConst.PROP_SOC_MODEL, ""});     // Catch: Exception -> L20
    L22:
        r112.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, r100);
    L20:
        e = move-exception;
        LogUtils.e("PlatKeyManagerImpl", "getProperty failed, exception: " + e.getMessage());
    L27:
        LogUtils.e("PlatKeyManagerImpl", "Invalid input params.");
        return -2;
    }

    public String reEncryptFEK(Context r100, String r101) {
        g r102 = g.a();
        r102.getClass();
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        if (r101.isEmpty() == true) goto L31;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: ".concat(r101));
        if (g.f204244c != null) goto L12;
        String r103 = "The init method failed to be called or executed";
    L11:
        LogUtils.e("PlatKeyManagerImpl", r103);
        return null;
    L12:
        int r104 = r102.a(r100);
        if (r104 == 0) goto L15;
        r103 = "Permission denied, ret: " + r104;
        goto L11
    L15:
        e r105 = b.a(r101, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r105 != null) goto L18;
        r103 = "Parse model key cipher failed!!";
        goto L11
    L18:
        byte[] r106 = AES.gcmXcrypt(2, g.f204244c, null, r105.f204237a, r105.f204238b);
        if (r106.length == 32) goto L21;
        String r107 = "decrypt dataKeyCipher failed or dataKey length invalid";
    L32:
        LogUtils.e("PlatKeyManagerImpl", r107);
        return null;
    L21:
        i r108 = b.a(r100, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r108 != null) goto L24;
        r107 = "prepareExternalDeviceKey failed.";
        goto L32
    L24:
        byte[] r109 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r108.f204255f), null, CryptoUtils.hexStringToByteArray(r108.f204253d), r106);
        if (r109 != null) goto L27;
    L30:
        r107 = "Re-encrypt FEK failed.";
        goto L32
    L27:
        if (r109.length == 0) goto L30;
        LogUtils.d("PlatKeyManagerImpl", "reEncrypt FEKCipher: " + CryptoUtils.byteArrayToHexString(r109));
        return CryptoUtils.byteArrayToHexString(r109);
    L31:
        r107 = "Input params is null!!";
        goto L32
    }

    public int decryptModelFile(Context r100, InputStream r101, OutputStream r102, String r103) {
        g.a().getClass();
        return c.a().a(r100, r101, r102, r103);
    }
}
