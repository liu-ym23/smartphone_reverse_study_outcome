package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetChatApplicationBadgeResponse f419143a;

    public g(GetChatApplicationBadgeResponse r100) {
        this.f419143a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((List) OfficeExternalContactRepository.f419134a.getValue()).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((a) r100.next()).a(this.f419143a.friend_badge.intValue(), this.f419143a.latest_apply_username);     // Catch: Throwable -> L7
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
