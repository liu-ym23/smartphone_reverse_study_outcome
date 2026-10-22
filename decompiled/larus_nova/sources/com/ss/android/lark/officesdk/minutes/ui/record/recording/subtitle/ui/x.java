package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f436545a;

    public x(w r100) {
        this.f436545a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f436545a;     // Catch: Throwable -> L13
        boolean r101 = true;
        if (r100.f436537a.canScrollVertically(1) == false) goto L5;
    L8:
        boolean r102 = r100.f436540d;     // Catch: Throwable -> L13
        if (r102 == false) goto L16;
        if (r102 == r101) goto L20;
        r100.f(r101, "onRVHeightChanged");     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L16:
        return;
    L5:
        if (r100.f436537a.canScrollVertically(-1) == true) goto L8;
        r101 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
