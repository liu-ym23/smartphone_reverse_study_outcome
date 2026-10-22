package com.bytedance.map.api.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes21.dex */
public class CheckUtil {
    public CheckUtil() {
    }

    public static boolean checkZoom(float r100) {
        if (r100 >= 3.0f) goto L5;
        return false;
    L5:
        if (r100 > 19.0f) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean checkLatLng(double r100, double r101) {
        boolean r102 = Pattern.matches("[\\-+]?(0?\\d{1,2}|0?\\d{1,2}\\.\\d{1,15}|1[0-7]?\\d|1[0-7]?\\d\\.\\d{1,15}|180|180\\.0{1,15})", String.valueOf(r101));
        boolean r103 = Pattern.matches("[\\-+]?([0-8]?\\d|[0-8]?\\d\\.\\d{1,15}|90|90\\.0{1,15})", String.valueOf(r100));
        if (r102 == false) goto L7;
        if (r103 == false) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }
}
