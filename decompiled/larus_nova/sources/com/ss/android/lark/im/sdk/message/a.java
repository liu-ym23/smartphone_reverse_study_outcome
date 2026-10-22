package com.ss.android.lark.im.sdk.message;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.message.resend.h;
import com.ss.android.lark.im.sdk.message.resend.i;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResendMessagePipelines f425928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f425929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f425930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f425931d;

    public a(b r100, String r101, i r102, h r103) {
        this.f425928a = r100;
        this.f425929b = r101;
        this.f425930c = r102;
        this.f425931d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.ss.android.lark.im.sdk.a.f425904a;     // Catch: Throwable -> L4
        com.ss.android.lark.im.sdk.a.b(this.f425928a.b(), "message send runnable start to run, cId is " + this.f425929b);     // Catch: Throwable -> L4
        this.f425930c.c(this.f425931d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
