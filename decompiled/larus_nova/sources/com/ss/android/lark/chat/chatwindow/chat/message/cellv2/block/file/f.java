package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f413151a;

    public f(g r100) {
        this.f413151a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f413151a.showLoading();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
