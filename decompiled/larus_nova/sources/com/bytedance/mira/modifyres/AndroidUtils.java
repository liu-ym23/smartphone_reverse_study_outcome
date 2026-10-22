package com.bytedance.mira.modifyres;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidUtils {
    private static String hostIdentity;

    public AndroidUtils() {
    }

    public static String byteArrayToHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r100 == null) goto L11;
        if (r102 >= r100.length) goto L11;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L9;
        r101.append('0');
    L9:
        r101.append(r103);
        r102 = r102 + 1;
    L11:
        return r101.toString().toLowerCase();
    }

    public static String getHostIdentity(Context r100) {
        if (hostIdentity != null) goto L8;
        String[] r101 = ApkIdentityUtils.getApkIdentitySpeed(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir));
        String r102 = r101[0];
        hostIdentity = r102;
        if (TextUtils.isEmpty(r102) == false) goto L8;
        MiraLogger.w(MiraLogger.TAG_INIT, "getHostIdentity failed. Reason: " + r101[2]);
    L8:
        return hostIdentity;
    }

    public static String sha256HMAC(String r100, String r101) {
        Mac r102 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L5
        r102.init(new SecretKeySpec(r101.getBytes(), "HmacSHA256"));     // Catch: Exception -> L5
        return byteArrayToHexString(r102.doFinal(r100.getBytes()));
    L5:
        return "";
    }
}
