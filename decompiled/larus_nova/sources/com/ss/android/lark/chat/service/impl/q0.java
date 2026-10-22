package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, Chat> f416557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416558b;

    public q0(Map<String, Chat> r100, ImSdkChatPushImplV2 r101) {
        this.f416557a = r100;
        this.f416558b = r101;
    }

    public final void a() {
        Iterator<String> r100 = this.f416557a.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r101 = r100.next();
        Iterator r102 = ((CopyOnWriteArrayList) this.f416558b.f416332h).iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        ((y) r102.next()).onPushChat(this.f416557a.get(r101));
        goto L7
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
