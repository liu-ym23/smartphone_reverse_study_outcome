package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;

    public g(KtvComponentAudienceLogicWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u r0 = m.e(this.a);     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        j r1 = r0.J();     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r2.removePlayMode(21);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
