package com.cmic.ida.sdk;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes22.dex */
public class v {
    public static String a(byte[] r100) {
        if (r100 != null) goto L9;
        return "";
    L9:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r101.update(r100);     // Catch: Exception -> L8
        return y0.a(r101.digest());
    L8:
        return "";
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return "";
    L9:
        return a(r100.getBytes(XML.CHARSET_UTF8));
    L8:
        return "";
    }
}
