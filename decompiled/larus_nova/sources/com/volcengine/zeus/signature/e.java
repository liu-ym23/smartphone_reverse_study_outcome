package com.volcengine.zeus.signature;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static boolean a(String r110, Function0<String> r111) {
        boolean r100 = false;
        if (TextUtils.isEmpty(r110) == false) goto L35;
        return false;
    L35:
        Signature[] r101 = c.b(r110).f462890a;     // Catch: VerifyException -> L32
        String r112 = r111.invoke();
        byte[] r102 = Base64.decode(r112, 0);
        if (r102 != null) goto L9;
    L30:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get expectSignature error : " + r110);
        return false;
    L9:
        if (r102.length == 0) goto L30;
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r105 = r105 + r101[r104].toByteArray().length;
        r104 = r104 + 1;
        goto L12
    L14:
        byte[] r106 = new byte[r105];
        int r107 = r101.length;
        int r108 = 0;
        int r109 = 0;
    L15:
        if (r108 >= r107) goto L17;
        Signature r113 = r101[r108];
        System.arraycopy(r113.toByteArray(), 0, r106, r109, r113.toByteArray().length);
        r109 = r109 + r113.toByteArray().length;
        r108 = r108 + 1;
        goto L15
    L17:
        int r114 = SigningDetails.f462889f;
        if (r105 != r102.length) goto L27;
        int r115 = 0;
    L21:
        if (r115 >= r105) goto L26;
        if (r106[r115] != r102[r115]) goto L27;
        r115 = r115 + 1;
        goto L21
    L26:
        r100 = true;
    L27:
        if (r100 == true) goto L29;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : " + r110 + " expectSignature:" + r102.length + " pluginApkSignature:" + r105);
        StringBuilder r116 = new StringBuilder("ApkSignatureVerify expectSignatureStr:");
        r116.append(r112);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, r116.toString());
        StringBuilder r117 = new StringBuilder("ApkSignatureVerify expectSignature:");
        r117.append(Arrays.toString(r102));
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, r117.toString());
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify pluginApkSignature:" + Arrays.toString(r106));
    L29:
        return r100;
    L32:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : " + r110, e);
        return false;
    }
}
