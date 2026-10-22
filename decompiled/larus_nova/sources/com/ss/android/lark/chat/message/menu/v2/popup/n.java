package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f415896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupMenuContentContainer f415897b;

    public n(PopupMenuContentContainer r100, PopupMenuContentContainer r101) {
        this.f415896a = r100;
        this.f415897b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupMenuContentContainer r100 = this.f415897b;     // Catch: Throwable -> L4
        r100.setTranslationY(r100.getHeight());     // Catch: Throwable -> L4
        this.f415897b.animate().translationY(0.0f).setDuration(200).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
