package com.bytedance.lynx.webview.adblock;

import android.content.Context;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTWebViewAdblockWrapper f265056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f265057b;

    public final String b(String r100) {
        Object r101 = this.f265057b;
        monitor-enter(r101);
        TTWebViewAdblockWrapper r102 = this.f265056a;     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        String r103 = r102.e(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r103;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return "";
    L12:
        th = move-exception;
        throw th;
    }

    public b(Context r100, String r101) {
        this.f265057b = new Object();
    }

    public final boolean a(String r100, String r101, TTAdblockEngineFactory.ResourceType r102) {
        Object r103 = this.f265057b;
        monitor-enter(r103);
        TTWebViewAdblockWrapper r104 = this.f265056a;     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
        boolean r105 = r104.d(r100, r101, r102.getValue());     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return r105;
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }
}
