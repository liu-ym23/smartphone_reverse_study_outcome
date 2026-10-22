package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.timetip.PushChatTimeTipNotify;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416544a;

    public m0(ImSdkChatPushImplV2 r100, PushChatTimeTipNotify r101) {
        this.f416544a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416544a.f416343s).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((aqb.e) r100.next()).a();     // Catch: Throwable -> L7
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
