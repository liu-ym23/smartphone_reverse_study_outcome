package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f416463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageInfo f416464b;

    public d1(g0 r100, MessageInfo r101) {
        this.f416463a = r100;
        this.f416464b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f416463a.c(this.f416464b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
