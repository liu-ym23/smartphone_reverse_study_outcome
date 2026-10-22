package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatterPushImplV2 f416586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chatter f416587b;

    public w0(ImSdkChatterPushImplV2 r100, Chatter r101) {
        this.f416586a = r100;
        this.f416587b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416586a.f416368i).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((com.ss.android.lark.biz.im.api.h0) r100.next()).a(this.f416587b);     // Catch: Throwable -> L7
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
