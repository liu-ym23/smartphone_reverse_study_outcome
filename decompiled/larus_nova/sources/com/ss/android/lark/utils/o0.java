package com.ss.android.lark.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class o0 {
    public static boolean a(Context r100) {
        String r101 = com.larksuite.framework.utils.z.b(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r101, r100.getPackageName()) == false) goto L7;
        return true;
    }

    public static boolean b(Context r100) {
        String r101 = com.larksuite.framework.utils.z.b(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L9:
        return false;
    L5:
        if (r101.endsWith(":docs") == false) goto L7;
    L8:
        return true;
    L7:
        if (r101.endsWith(":p0") == false) goto L9;
        goto L8
    }

    public static boolean c(Context r100) {
        String r101 = com.larksuite.framework.utils.z.b(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(":wschannel") == false) goto L7;
        return true;
    }
}
