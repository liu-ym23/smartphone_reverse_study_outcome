package com.ss.android.ugc.effectmanager.common.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes40.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static boolean substringSafetyCheck(String r100, int r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r101 < 0) goto L15;
        if (r102 < 0) goto L16;
        if (r101 < r102) goto L10;
        return false;
    L10:
        if (r101 < r100.length()) goto L12;
        return false;
    L12:
        if (r102 > r100.length()) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    }
}
