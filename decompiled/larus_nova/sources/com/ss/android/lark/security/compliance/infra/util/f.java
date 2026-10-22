package com.ss.android.lark.security.compliance.infra.util;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f440480a;

    public static synchronized Gson b() {
        monitor-enter(f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f440480a != null) goto L7;
        f440480a = new Gson();     // Catch: Throwable -> L10
    L7:
        Gson r100 = f440480a;     // Catch: Throwable -> L10
        monitor-exit(f.class);
        return r100;
    }

    public static <T> String c(T r100) {
        return b().toJson(r100);
    L4:
        e = move-exception;
        int r101 = ScsLogger.f440428a;
        ScsLogger.c("GsonUtils", "GsonUtils.toJson error, error is: " + e.getMessage());
        return "";
    }

    public static <T> T a(String r100, Class<T> r101) {
        return (T) GsonProtectorUtils.fromJson(b(), r100, r101);
    }
}
