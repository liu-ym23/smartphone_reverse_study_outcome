package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessagePushV2 f416468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushMessageReactions f416469b;

    public e1(MessagePushV2 r100, PushMessageReactions r101) {
        this.f416468a = r100;
        this.f416469b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<com.ss.android.lark.biz.im.api.k0> r100 = this.f416468a.f416378c.iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        r100.next().f(this.f416469b);     // Catch: Throwable -> L7
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
