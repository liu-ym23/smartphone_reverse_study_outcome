package com.bytedance.bdlocation.utils;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    public static String decrypt(String r100) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L13;
        byte[] r101 = Base64.decode(r100, 10);     // Catch: Exception -> L14
        int r102 = r101.length;     // Catch: Exception -> L14
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        r101[r103] = (byte) (r101[r103] ^ (-99));     // Catch: Exception -> L14
        r103 = r103 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r101);
    }

    public static String encrypt(JSONObject r100) {
        if (r100 != null) goto L11;
        return null;
    L11:
        byte[] r101 = r100.toString().getBytes(XML.CHARSET_UTF8);     // Catch: Exception -> L10
        int r102 = r101.length;     // Catch: Exception -> L10
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101[r103] = (byte) (r101[r103] ^ (-99));     // Catch: Exception -> L10
        r103 = r103 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r101, 10);
    L10:
        return null;
    }
}
