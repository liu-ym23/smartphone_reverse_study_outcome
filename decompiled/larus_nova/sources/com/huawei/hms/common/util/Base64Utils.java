package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public final class Base64Utils {
    public Base64Utils() {
    }

    public static byte[] decode(String r100) {
        byte[] r101 = new byte[0];
        if (r100 != null) goto L9;
    L8:
        return r101;
    L9:
        return Base64.decode(r100, 0);
    L6:
        e = move-exception;
        HMSLog.e("Base64Utils", "decode failed : " + e.getMessage());
        goto L8
    }

    public static byte[] decodeUrlSafe(String r100) {
        byte[] r101 = new byte[0];
        if (r100 != null) goto L10;
    L9:
        return r101;
    L10:
        return Base64.decode(r100, 10);
    L7:
        e = move-exception;
        HMSLog.e("Base64Utils", "decodeUrlSafe failed : " + e.getMessage());
        goto L9
    }

    public static byte[] decodeUrlSafeNoPadding(String r100) {
        byte[] r101 = new byte[0];
        if (r100 != null) goto L10;
    L9:
        return r101;
    L10:
        return Base64.decode(r100, 11);
    L7:
        e = move-exception;
        HMSLog.e("Base64Utils", "decodeUrlSafeNoPadding failed : " + e.getMessage());
        goto L9
    }

    public static String encode(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return Base64.encodeToString(r100, 0);
    }

    public static String encodeUrlSafe(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return Base64.encodeToString(r100, 10);
    }

    public static String encodeUrlSafeNoPadding(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return Base64.encodeToString(r100, 11);
    }
}
