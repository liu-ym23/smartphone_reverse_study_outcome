package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.select.m f414075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLongClickListener f414076b;

    public f(com.ss.android.lark.widget.select.m r100, ContentLongClickListener r101) {
        this.f414075a = r100;
        this.f414076b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f414075a.a();     // Catch: Throwable -> L6
        if (this.f414075a.f448446i == true) goto L9;
        this.f414076b.f414045d = null;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
