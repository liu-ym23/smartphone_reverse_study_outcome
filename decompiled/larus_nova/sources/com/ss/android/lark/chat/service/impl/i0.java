package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chat f416512b;

    public i0(ImSdkChatPushImplV2 r100, Chat r101) {
        this.f416511a = r100;
        this.f416512b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416511a.f416337m).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((z) r100.next()).onPushChatRemoveMe(this.f416512b);     // Catch: Throwable -> L7
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
