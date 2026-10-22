package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushPinReadStatusResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushPinReadStatusResponse f416573b;

    public s0(ImSdkChatPushImplV2 r100, PushPinReadStatusResponse r101) {
        this.f416572a = r100;
        this.f416573b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416572a.f416340p).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        aqb.f r101 = (aqb.f) r100.next();     // Catch: Throwable -> L7
        PushPinReadStatusResponse r102 = this.f416573b;     // Catch: Throwable -> L7
        r101.a(r102.chat_id, r102.is_read.booleanValue());     // Catch: Throwable -> L7
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
