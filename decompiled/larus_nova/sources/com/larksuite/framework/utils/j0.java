package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class j0 {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Log.w("UIDUtils", "uid is invalid.");
        return "";
    L7:
        if (TextUtils.equals(r100, "absent_user") == false) goto L10;
        return r100;
    L10:
        if (r100.length() >= 9) goto L14;
        Log.w("UIDUtils", "uid less than limit.");
        return "";
    L14:
        return r100.substring(8);
    }
}
