package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoubaoTyping f416555b;

    public p0(ImSdkChatPushImplV2 r100, DoubaoTyping r101) {
        this.f416554a = r100;
        this.f416555b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416554a.B).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((d0) r100.next()).e(this.f416555b);     // Catch: Throwable -> L7
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
