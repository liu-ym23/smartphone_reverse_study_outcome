package com.ss.android.lark.photoeditor.impl.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f438594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f438595b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L3:
        if (this.f438594a != (-1)) goto L5;
        this.f438595b.getView().z(R.string.Lark_Legacy_Success);     // Catch: Throwable -> L7
    L5:
        this.f438595b.getView().y();     // Catch: Throwable -> L7
    }

    public n(o r100, int r101) {
        this.f438595b = r100;
        this.f438594a = r101;
    }
}
