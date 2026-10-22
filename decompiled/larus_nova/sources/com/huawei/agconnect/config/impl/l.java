package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes23.dex */
public class l {
    private static String a(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return null;
    L5:
        int r103 = r100.getResources().getIdentifier(r102, "string", r101);
        if (r103 != 0) goto L13;
        return null;
    L13:
        return r100.getResources().getString(r103);
    L10:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static String a(Context r100, String r101, String r102, String r103) {
        return a(r100, r101, r102 + Hex.encodeHexString(a(r103.getBytes(XML.CHARSET_UTF8))));
    L4:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static byte[] a(byte[] r100) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(r100);
    }
}
