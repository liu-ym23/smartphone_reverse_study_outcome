package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c f413199a;

    public p(com.ss.android.lark.compose.foundation.toast.g r100) {
        this.f413199a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f413199a.cancel();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
