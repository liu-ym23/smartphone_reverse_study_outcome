package com.ss.android.lark.conditional.access.nopermission.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f418408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment f418409b;

    public w(long r100, OfficeSDKOAuthReauthorizationFragment r101) {
        this.f418408a = r100;
        this.f418409b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = this.f418408a;     // Catch: Throwable -> L9
        OfficeSDKOAuthReauthorizationFragment r101 = this.f418409b;     // Catch: Throwable -> L9
        if (r100 == r101.f418276k) goto L5;
    L7:
        this.f418409b.f418277l = null;     // Catch: Throwable -> L9
        return;
    L5:
        if (r101.getView() == null) goto L7;
        this.f418409b.aa0(false);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
