package com.bytedance.push.utils;

import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class h {
    public static boolean a(String r100, String r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        return PatternProtector.compile(r101).matcher(r100).find();
    L8:
        f.i("PatternUtils", "[inputMatchRegText]return false because  input or reg is null,input:" + r100 + " reg:" + r101);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        f.f("PatternUtils", "[match]inputMatchRegText match exception ", th);
        return false;
    }
}
