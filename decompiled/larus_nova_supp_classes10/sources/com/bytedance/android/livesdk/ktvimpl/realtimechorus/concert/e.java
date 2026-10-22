package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.VerticalDragFrameLayout;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ ConcertWidget a;

    public e(ConcertWidget r1) {
        this.a = r1;
    }

    public final void a() {
        VerticalDragFrameLayout r0 = this.a.a;
        if (r0 == null) goto L26;
        int r1 = s1.j(2131168814);
        ConcertWidget r2 = this.a;
        r2.getClass();
        InteractionWidgetsPosContext.a r3 = InteractionWidgetsPosContext.Companion;
        InteractionWidgetsPosContext r4 = InteractionWidgetsPosContext.a.c(r3, ((Widget) r2).dataCenter, 0, 2);
        if (r4 == null) goto L11;
        m r5 = r4.getPublicScreenHeight();
        if (r5 == null) goto L11;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        InteractionWidgetsPosContext r8 = InteractionWidgetsPosContext.a.c(r3, ((Widget) r2).dataCenter, 0, 2);
        if (r8 == null) goto L19;
        m r9 = r8.getPublicScreenBottomMargin();
        if (r9 == null) goto L19;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L19;
        int r11 = r10.intValue();
    L20:
        VerticalDragFrameLayout r12 = r2.a;
        if (r12 == null) goto L23;
        int r13 = r12.getHeight();
    L24:
        int r14 = s1.w();
        ALogger.i("RealtimeChorusConcertWidget", "getBottomRange, screenHeight: " + r14 + ", publicScreenHeight: " + r7 + ", height: " + r13 + ", bottomMargin: " + r11);
        r0.d = r1;
        r0.e = ((r14 - r7) - r13) - r11;
        return;
    L23:
        r13 = s1.j(2131168829);
    L19:
        r11 = s1.j(2131168830);
    L11:
        r7 = s1.j(2131168831);
        goto L12
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
