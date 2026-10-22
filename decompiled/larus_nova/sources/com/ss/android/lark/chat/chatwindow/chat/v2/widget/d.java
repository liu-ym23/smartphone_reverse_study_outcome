package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<Object> f414689a;

    public d(c<Object> r100) {
        this.f414689a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f414689a, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
