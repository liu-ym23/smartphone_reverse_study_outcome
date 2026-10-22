package com.bytedance.ies.web.jsbridge2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f249420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f249421b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f249421b.f249302f == true) goto L10;
        String r100 = this.f249420a;     // Catch: Throwable -> L7
        this.f249421b.f249423o.evaluateJavascript(r100, null);     // Catch: Throwable -> L7
        return;
    }

    public p0(q0 r100, String r101) {
        this.f249421b = r100;
        this.f249420a = r101;
    }
}
