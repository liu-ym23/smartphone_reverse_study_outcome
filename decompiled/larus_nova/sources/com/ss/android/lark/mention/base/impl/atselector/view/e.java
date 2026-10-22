package com.ss.android.lark.mention.base.impl.atselector.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtView f431843a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f431843a.mSearchEt.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(AtView r100) {
        this.f431843a = r100;
    }
}
