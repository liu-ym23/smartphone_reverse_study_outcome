package com.ss.android.lark.chat.message.menu.v2.popup;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuRootView f415894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupMenuContentContainer f415895b;

    public m(PopupMenuRootView r100, PopupMenuContentContainer r101) {
        this.f415894a = r100;
        this.f415895b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f415894a.removeView(this.f415895b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
