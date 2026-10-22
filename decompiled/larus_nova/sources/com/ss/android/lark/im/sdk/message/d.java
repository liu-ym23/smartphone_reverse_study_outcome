package com.ss.android.lark.im.sdk.message;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.message.send.k;
import com.ss.android.lark.im.sdk.message.send.l;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendMessagePipelines f425935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageParams<?, ?> f425936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f425937c;

    public d(f r100, p0 r101, k r102) {
        this.f425935a = r100;
        this.f425936b = r101;
        this.f425937c = r102;
    }

    public final void a() {
        int r100 = com.ss.android.lark.im.sdk.a.f425904a;
        com.ss.android.lark.im.sdk.a.b(this.f425935a.c(), "send local pre-message runnable start to run, cId is " + this.f425936b.f415245d);
        ((l) this.f425935a.f425921m.getValue()).c(this.f425937c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
