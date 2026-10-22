package com.bytedance.security.android.aopcheck.utils;

import com.bytedance.crash.d;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.reporter.Constant;

/* JADX INFO: loaded from: classes3.dex */
public class KevaUtil {
    private static Keva keva;

    public KevaUtil() {
    }

    public static Keva get() {
        if (keva != null) goto L9;
        keva = Keva.getRepo(Constant.SP_REPO, 1);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        d.d(e, "init_keva_exception");
    L9:
        return keva;
    }
}
