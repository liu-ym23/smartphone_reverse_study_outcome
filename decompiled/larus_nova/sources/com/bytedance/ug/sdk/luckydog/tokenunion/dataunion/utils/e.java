package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f272295b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f272296a;

    public e(Context r100) {
        this.f272296a = r100.getSharedPreferences("sp_luckydog_union", 0);
    }

    public static e a(Context r100) {
        if (f272295b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f272295b != null) goto L9;
        f272295b = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f272295b;
    }

    public final String b(String r100) {
        return this.f272296a.getString(r100, null);
    }
}
