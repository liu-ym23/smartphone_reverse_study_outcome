package com.ss.android.ugc.route_monitor.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes40.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454777a = 0;

    static {
    }

    public static void a(String r100) {
        TextUtils.isEmpty(r100);
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        Logger r101 = Logger.f454747c;     // Catch: Throwable -> L8
        th.getMessage();     // Catch: Throwable -> L8
        r101.a();     // Catch: Throwable -> L8
        int r102 = v.f454784a;
        return;
    L8:
        th = move-exception;
        Logger.f454747c.d(th);     // Catch: Throwable -> L12
        v.a(null);
        return;
    L12:
        th = move-exception;
        v.a(null);
        throw th;
    }
}
