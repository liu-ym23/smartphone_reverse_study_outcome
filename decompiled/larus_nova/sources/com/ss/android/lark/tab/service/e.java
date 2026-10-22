package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.PushChatTabs;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatTabPush f441147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushChatTabs f441148b;

    public e(ChatTabPush r100, PushChatTabs r101) {
        this.f441147a = r100;
        this.f441148b = r101;
    }

    public final void a() {
        CopyOnWriteArrayList<ChatTabPush.b> r100 = this.f441147a.f441129b;
        PushChatTabs r101 = this.f441148b;
        Iterator<ChatTabPush.b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ChatTabPush.b r103 = r102.next();
        r103.getClass();
        if (Intrinsics.areEqual(null, r101.chat_id.toString()) == false) goto L4;
        r103.a(new p6c.c(r101.chat_id.longValue(), p6c.d.a(r101.chat_id.toString(), r101.tabs), r101.version.longValue()));
        goto L4
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
