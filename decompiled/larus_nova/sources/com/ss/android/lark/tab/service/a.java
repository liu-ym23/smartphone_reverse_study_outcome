package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.PushChatPinCountResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.ChatTabExtra;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatTabExtraPush f441140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushChatPinCountResponse f441141b;

    public a(ChatTabExtraPush r100, PushChatPinCountResponse r101) {
        this.f441140a = r100;
        this.f441141b = r101;
    }

    public final void a() {
        CopyOnWriteArrayList<ChatTabExtraPush.b> r100 = this.f441140a.f441114b;
        PushChatPinCountResponse r101 = this.f441141b;
        Iterator<ChatTabExtraPush.b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ChatTabExtraPush.b r103 = r102.next();
        r103.getClass();
        if (Intrinsics.areEqual(null, r101.chat_id.toString()) == false) goto L4;
        r103.a(new ChatTabExtra(0, (int) r101.count.longValue()));
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
