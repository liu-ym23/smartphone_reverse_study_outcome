package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427166a;

    public m(CreationAIDragView r100) {
        this.f427166a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f427166a.t(false, false, CreationAIDragView.AdjustTopSource.VIEW_CHANGE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
