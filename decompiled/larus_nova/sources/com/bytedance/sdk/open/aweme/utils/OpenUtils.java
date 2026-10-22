package com.bytedance.sdk.open.aweme.utils;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes22.dex */
public class OpenUtils {
    public OpenUtils() {
    }

    public static String[] arrayUnique(String[] r100) {
        if (r100 != null) goto L10;
    L9:
        return r100;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L4:
        if (r100.length <= 0) goto L9;
        return (String[]) new HashSet(new ArrayList(Arrays.asList(r100))).toArray(new String[0]);
    }

    public static String flavor() {
        return "chinainternal";
    }

    public static boolean isExternal() {
        return TextUtils.equals("chinainternal", "chinaexternal");
    }

    public static boolean isInternal() {
        return TextUtils.equals("chinainternal", "chinainternal");
    }

    public static void setViewVisibility(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() != r101) goto L6;
        return;
    L6:
        if (visibilityValid(r101) == false) goto L12;
        r100.setVisibility(r101);
        return;
    }

    private static boolean visibilityValid(int r100) {
        if (r100 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r100 == 8) goto L9;
        if (r100 == 4) goto L9;
        return false;
    }
}
