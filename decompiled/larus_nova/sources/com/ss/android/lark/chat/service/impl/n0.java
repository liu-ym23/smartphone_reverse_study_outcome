package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushChatChatterListDepartmentName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatPushImplV2 f416546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushChatChatterListDepartmentName f416547b;

    public n0(ImSdkChatPushImplV2 r100, PushChatChatterListDepartmentName r101) {
        this.f416546a = r100;
        this.f416547b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416546a.f416349y).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        b0 r101 = (b0) r100.next();     // Catch: Throwable -> L7
        String r102 = this.f416547b.chat_id;     // Catch: Throwable -> L7
        r101.a();     // Catch: Throwable -> L7
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
