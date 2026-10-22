package com.bytedance.ee.bear.document;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class q1 {
    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (s45.p.a().v6(r100) == true) goto L7;
        return false;
    L7:
        if (r100.contains("/file/f") == false) goto L9;
        return true;
    L9:
        if (r100.contains("//file/f") == false) goto L16;
        return true;
    L16:
        return false;
    }
}
