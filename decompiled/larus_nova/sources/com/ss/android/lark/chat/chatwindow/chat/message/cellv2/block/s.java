package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaContentBlock f413229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c f413230b;

    public s(MediaContentBlock r100, com.ss.android.lark.compose.foundation.toast.g r101) {
        this.f413229a = r100;
        this.f413230b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f413229a.f412788k == false) goto L9;
        this.f413230b.show();     // Catch: Throwable -> L6
        return;
    }
}
