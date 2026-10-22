package com.cmic.ida.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class e0 {
    public static boolean a(Context r100, String r101) {
        if (r100.getPackageManager().checkPermission(r101, r100.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
