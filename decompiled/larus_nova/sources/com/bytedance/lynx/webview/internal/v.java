package com.bytedance.lynx.webview.internal;

import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f265365e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f265366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f265367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f265368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f265369d;

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f265366a == 0) goto L6;
    L13:
        boolean r100 = true;
    L14:
        if (r100 == false) goto L19;
        HashMap r101 = new HashMap();     // Catch: Throwable -> L17
        r101.put("loadUrl", Integer.valueOf(this.f265366a));     // Catch: Throwable -> L17
        r101.put("onPageStarted", Integer.valueOf(this.f265367b));     // Catch: Throwable -> L17
        r101.put("onPageFinished", Integer.valueOf(this.f265368c));     // Catch: Throwable -> L17
        EventStatistics.d("ttwebview_pv", r101, new HashMap());     // Catch: Throwable -> L17
        this.f265366a = 0;     // Catch: Throwable -> L17
        this.f265367b = 0;     // Catch: Throwable -> L17
        this.f265368c = 0;     // Catch: Throwable -> L17
        this.f265369d = false;     // Catch: Throwable -> L17
    L19:
        monitor-exit(this);
        return;
    L6:
        if (this.f265367b != 0) goto L13;
        if (this.f265368c != 0) goto L13;
        if (this.f265369d == true) goto L13;
        r100 = false;
        goto L14
    }

    static {
        f265365e = new v();
    }

    public v() {
        this.f265366a = 0;
        this.f265367b = 0;
        this.f265368c = 0;
        this.f265369d = true;
    }
}
