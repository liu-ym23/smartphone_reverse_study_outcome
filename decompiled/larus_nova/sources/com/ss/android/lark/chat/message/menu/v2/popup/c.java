package com.ss.android.lark.chat.message.menu.v2.popup;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenu f415881a;

    public c(PopupMenu r100) {
        this.f415881a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupMenu.b r100 = this.f415881a.f415775e;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onShow();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
