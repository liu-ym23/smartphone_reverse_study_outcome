package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ef5.x f231494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f231495b;

    public k0(ef5.x r100, int r101) {
        this.f231494a = r100;
        this.f231495b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f231494a.f472514a.scrollToPosition(this.f231495b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
