package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f412216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f412217b;

    public d(e r100, int r101) {
        this.f412216a = r100;
        this.f412217b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f412216a.f412218a.e().notifyItemChanged(this.f412217b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
