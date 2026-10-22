package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class n {
    public static boolean a(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (TextUtils.isEmpty(r100[r102]) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
