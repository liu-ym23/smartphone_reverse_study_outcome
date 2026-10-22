package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessagePushV2 f416473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushMessageReadStates f416474b;

    public f1(MessagePushV2 r100, PushMessageReadStates r101) {
        this.f416473a = r100;
        this.f416474b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<com.ss.android.lark.biz.im.api.k0> r100 = this.f416473a.f416378c.iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        r100.next().b(this.f416474b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
