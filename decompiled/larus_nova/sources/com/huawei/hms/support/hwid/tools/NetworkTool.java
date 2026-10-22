package com.huawei.hms.support.hwid.tools;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: loaded from: classes23.dex */
public final class NetworkTool {
    public NetworkTool() {
    }

    private static boolean a(Boolean r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.booleanValue() == false) goto L6;
        return true;
    }

    public static String buildNetworkUrl(String r100, Boolean r101) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (a(r101) == false) goto L7;
        String r102 = "https";
    L8:
        StringBuilder r103 = new StringBuilder((r102.length() + 3) + String.valueOf(r100).length());
        r103.append(r102);
        r103.append("://");
        r103.append(r100);
        return r103.toString();
    L7:
        r102 = "http";
        goto L8
    L11:
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static String buildNetworkCookie(String r100, String r101, String r102, String r103, Boolean r104, Boolean r105, Long r106) {
        StringBuilder r107 = new StringBuilder(r100);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r107.append(r101);
    L6:
        if (a(r104) == false) goto L9;
        r107.append(";HttpOnly");
    L9:
        if (a(r105) == false) goto L12;
        r107.append(";Secure");
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r107.append(";Domain=");
        r107.append(r102);
    L15:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        r107.append(";Path=");
        r107.append(r103);
    L17:
        if (r106 == null) goto L22;
        if (r106.longValue() <= 0) goto L22;
        r107.append(";Max-Age=");
        r107.append(r106);
    L22:
        return r107.toString();
    }
}
