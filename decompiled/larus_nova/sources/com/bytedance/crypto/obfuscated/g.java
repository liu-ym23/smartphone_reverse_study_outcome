package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f204243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f204244c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f204245a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f204246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f204247b;

        public a(String r100, String r101) {
            this.f204246a = r100;
            this.f204247b = r101;
        }
    }

    public g() {
        this.f204245a = Arrays.asList(new a[]{new a("com.obric.aikernel", "0cdc978ba742397606daefeba9d508fffbfbdb229900648056b7a2a3607678e9")});
    }

    public static g a() {
        if (f204243b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f204243b != null) goto L9;
        f204243b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f204243b;
    }

    public final int a(Context r100) {
        String r101 = r100.getPackageName();
        LogUtils.d("PlatKeyManagerImpl", "packageName: " + r101);
        List<byte[]> r102 = CommonUtils.getContextSignature(r100);
        if (r102 != null) goto L6;
        LogUtils.e("PlatKeyManagerImpl", "getContextSignature failed.");
        return -100;
    L6:
        LogUtils.d("PlatKeyManagerImpl", "signatureList.size(): " + r102.size());
        Iterator<byte[]> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        String r104 = CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r103.next(), "SHA-256"));
        LogUtils.d("PlatKeyManagerImpl", "signHashHex: " + r104);
        Iterator<a> r105 = this.f204245a.iterator();
    L11:
        if (r105.hasNext() == false) goto L8;
        a r106 = r105.next();
        if (r106.f204246a.equals(r101) == false) goto L11;
        if (r106.f204247b.equals(r104) == false) goto L11;
        LogUtils.d("PlatKeyManagerImpl", "Found in APP_WHITE_LISTS");
        return 0;
    L18:
        LogUtils.d("PlatKeyManagerImpl", "Not found in APP_WHITE_LISTS");
        return -1;
    }

    public String a(Context r100, String r101, int r102, String r103) {
        if (r100 == null) goto L39;
        if (r101 == null) goto L39;
        if (r101.isEmpty() == true) goto L39;
        if (r103 == null) goto L39;
        if (r103.isEmpty() == true) goto L39;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: ".concat(r101));
        LogUtils.i("PlatKeyManagerImpl", "reEncryptFEK keyAlias: ".concat(r103));
        e r104 = b.a(r101, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r104 != null) goto L16;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return null;
    L16:
        if (r104.f204237a.length == FrameworkSecurityCompat.PlatformKeyConst.IV_LEN()) goto L18;
        LogUtils.e("PlatKeyManagerImpl", "Invalid modelKeyCipher data");
        byte[] r105 = null;
    L19:
        byte[] r106 = FrameworkSecurityCompat.platformKeyDecrypt(r100, r102, r105, CryptoUtils.convertPEMToUncompressedECPubKey(r104.f204239c), new Bundle());
        if (r106 != null) goto L22;
    L37:
        LogUtils.e("PlatKeyManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");
        return null;
    L22:
        if (r106.length != 32) goto L37;
        i r107 = b.a(r100, r103);
        if (r107 != null) goto L28;
        LogUtils.e("PlatKeyManagerImpl", "prepareExternalDeviceKey failed.");
        return null;
    L28:
        byte[] r108 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r107.f204255f), null, CryptoUtils.hexStringToByteArray(r107.f204253d), r106);
        if (r108 != null) goto L31;
    L35:
        LogUtils.e("PlatKeyManagerImpl", "Re-encrypt FEK failed.");
        return null;
    L31:
        if (r108.length == 0) goto L35;
        LogUtils.d("PlatKeyManagerImpl", "reEncFEKCipher: " + CryptoUtils.byteArrayToHexString(r108));
        return CryptoUtils.byteArrayToHexString(r108);
    L18:
        r105 = new byte[((FrameworkSecurityCompat.PlatformKeyConst.MAGIC_NUM_LEN() + FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_VER_LEN()) + r104.f204237a.length) + r104.f204238b.length];
        ByteBuffer r109 = ByteBuffer.wrap(r105);
        r109.putInt(-65536);
        r109.putInt(r102);
        r109.put(r104.f204237a);
        r109.put(r104.f204238b);
    L39:
        LogUtils.e("PlatKeyManagerImpl", "Input params is null!!");
        return null;
    }
}
