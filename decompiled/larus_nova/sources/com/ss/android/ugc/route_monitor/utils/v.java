package com.ss.android.ugc.route_monitor.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454784a = 0;

    static {
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Logger r101 = Logger.f454747c;
        e.getMessage();
        r101.a();
        return;
    }
}
