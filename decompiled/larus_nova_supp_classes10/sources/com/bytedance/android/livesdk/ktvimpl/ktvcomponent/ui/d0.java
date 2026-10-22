package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ KtvComponentUIWidget a;

    public d0(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = s1.j(2131168828) + s1.j(2131168845);
        KtvComponentUIWidget r1 = this.a;
        DataCenter r2 = ((Widget) r1).dataCenter;
        TokenCert r3 = KtvComponentUIWidget.y1;
        r1.getClass();
        IMiddlewareMsgWindowService r4 = jc1.k.f(IMiddlewareMsgWindowService.class);
        if (r4 == null) goto L7;
        d71.c r5 = r4.cardRecorder();
        if (r5 == null) goto L7;
        boolean r6 = r5.b(r2, MsgWindowPosition.TOP_RIGHT);
    L8:
        ALogger.i("KtvComponentUIWidget", "onChange isAnyCardShowing: " + r6);
        if (r6 == false) goto L16;
        KtvComponentUIWidget r7 = this.a;
        if (r7.V == r0) goto L17;
        r7.V = r0;
        if (((Widget) r7).containerView == null) goto L18;
        r7.jr(r7.Mq());
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r6 = false;
        goto L8
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
