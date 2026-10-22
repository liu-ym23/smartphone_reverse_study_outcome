package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes23.dex */
public final class Base64Utils {
    public Base64Utils() {
    }

    public static byte[] decode(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.decode(r100, 0);
    }

    public static byte[] decodeUrlSafe(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.decode(r100, 10);
    }

    @ResultIgnorabilityUnspecified
    public static byte[] decodeUrlSafeNoPadding(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.decode(r100, 11);
    }

    public static String encode(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r100, 0);
    }

    public static String encodeUrlSafe(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r100, 10);
    }

    public static String encodeUrlSafeNoPadding(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r100, 11);
    }
}
