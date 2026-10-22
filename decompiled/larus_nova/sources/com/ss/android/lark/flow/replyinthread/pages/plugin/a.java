package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplyInThreadKeyboardPlugin f424035a;

    public a(ReplyInThreadKeyboardPlugin r100) {
        this.f424035a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IKeyboardComponent r100 = this.f424035a.f423982i;     // Catch: Throwable -> L18
        if (r100 == null) goto L7;
        com.ss.android.lark.keyboard.b r101 = r100.n();     // Catch: Throwable -> L18
        if (r101 == null) goto L7;
        com.ss.android.lark.keyboard.keyboard2.b r102 = r101.L();     // Catch: Throwable -> L18
    L8:
        if (r102 == null) goto L12;
        EditText r103 = r102.c();     // Catch: Throwable -> L18
        if (r103 == null) goto L12;
        r103.requestFocus();     // Catch: Throwable -> L18
    L12:
        IKeyboardComponent r104 = this.f424035a.f423982i;     // Catch: Throwable -> L18
        if (r104 == null) goto L21;
        com.ss.android.lark.keyboard.b r105 = r104.n();     // Catch: Throwable -> L18
        if (r105 == null) goto L25;
        com.ss.android.lark.c.f(r105);     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L21:
        return;
    L7:
        r102 = null;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
