package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuRootView f415898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f415899b;

    public o(PopupMenuRootView r100, View r101) {
        this.f415898a = r100;
        this.f415899b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f415898a.removeView(this.f415899b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
