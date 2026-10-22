package com.huawei.hms.healthlite;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes23.dex */
public class aabg {
    public static Intent aab(int r100) {
        Intent r101 = new Intent();
        r101.putExtra("DEEPLINK_RESULT", r100);
        if (r100 <= 0) goto L5;
        r101.putExtra("DEEPLINK_MSG", "The deepLinkUrl is wrong. ");
    L5:
        return r101;
    }

    public static String aab(Object r100) {
        String r101 = null;
        if (r100 != null) goto L6;
        aab("util", "toJson --> object is null");
        return null;
    L6:
        System.currentTimeMillis();
        r101 = GsonProtectorUtils.toJson(new GsonBuilder().serializeSpecialFloatingPointValues().disableHtmlEscaping().enableComplexMapKeySerialization().setLenient().create(), r100);     // Catch: JsonSyntaxException -> L9
    L10:
        System.currentTimeMillis();
        return r101;
    L9:
        aab("util", "toJson --> JsonSyntaxException.");
        goto L10
    }

    public static String aab(String r100, String r101, String r102, String r103) {
        aaba("util", "handleDeepLink url start");
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
    L13:
        aab("util", "Exception is UnsupportedEncodingException");
        r104.append("?errorCode=");
        r104.append(r103);
    L15:
        return r104.toString();
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r104.append("?code=");     // Catch: UnsupportedEncodingException -> L13
        r104.append(URLEncoder.encode(r101, StandardCharsets.UTF_8.name()));     // Catch: UnsupportedEncodingException -> L13
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r104.append("&state=");     // Catch: UnsupportedEncodingException -> L13
        r104.append(URLEncoder.encode(r102, StandardCharsets.UTF_8.name()));     // Catch: UnsupportedEncodingException -> L13
        goto L15
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r104.append("?errorCode=");     // Catch: UnsupportedEncodingException -> L13
        r104.append(r103);     // Catch: UnsupportedEncodingException -> L13
        goto L10
    }

    public static void aab(String r100, String r101) {
    }

    public static void aaba(String r100, String r101) {
    }

    public static void aabb(String r100, String r101) {
    }
}
