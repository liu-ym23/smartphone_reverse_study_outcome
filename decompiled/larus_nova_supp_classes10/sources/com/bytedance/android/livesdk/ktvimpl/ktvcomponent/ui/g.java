package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public g(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        Integer r12 = (Integer) r11;
        if (r12 == null) goto L16;
        if (r12.intValue() != 0) goto L16;
        if (this.a.b1 == false) goto L10;
    L12:
        KtvComponentUIWidget r13 = this.a;
        int[] r6 = new int[2];
        ((Widget) r13).containerView.getLocationOnScreen(r6);
        int r7 = r6[1] - s1.A();
        if (r13.k1 <= r7) goto L37;
        fd0.f r8 = LiveAnimator.a(new View[]{((Widget) r13).containerView});
        r8.c("y", new float[]{r7, r13.k1});
        r8.a.b = 100;
        r8.e();
        return;
    L37:
        return;
    L10:
        if (KtvComponentUIWidget.kr() == false) goto L12;
        KtvComponentUIWidget r14 = this.a;
        r14.b1 = true;
        r14.Lq(new KtvComponentUIWidget$initAvoidAndSwitchAnimation$1$1(this));
    L16:
        if (this.a.b1 == true) goto L18;
    L20:
        KtvComponentUIWidget r15 = this.a;
        r15.getClass();
        KtvComponentContext r9 = KtvComponentContext.Companion.getContext();
        if (r9 == null) goto L25;
        com.bytedance.live.datacontext.n<Integer> r10 = r9.getPanelTop();
        if (r10 == null) goto L25;
        Integer r16 = (Integer) r10.getValue();
    L26:
        if (r16 != null) goto L28;
        return;
    L28:
        if (r16.intValue() <= 0) goto L41;
        int[] r17 = new int[2];
        ((Widget) r15).containerView.getLocationOnScreen(r17);
        int r18 = r17[1] - s1.A();
        int r19 = ((Widget) r15).containerView.getHeight() + r18;
        if (r19 <= r16.intValue()) goto L40;
        r15.k1 = r18;
        float r20 = ((r16.intValue() + r18) - r19) - s1.A();
        fd0.f r21 = LiveAnimator.a(new View[]{((Widget) r15).containerView});
        float[] r3 = new float[2];
        r3[0] = r18;
        float r110 = r15.V;
        if (r20 >= r110) goto L35;
        r20 = r110;
    L35:
        r3[1] = r20;
        r21.c("y", r3);
        r21.a.b = 100;
        r21.e();
        return;
    L40:
        return;
    L41:
        return;
    L25:
        r16 = null;
        goto L26
    L18:
        if (KtvComponentUIWidget.kr() == true) goto L20;
        KtvComponentUIWidget r111 = this.a;
        r111.b1 = false;
        r111.Lq(new KtvComponentUIWidget$initAvoidAndSwitchAnimation$1$2(this));
        goto L20
    }
}
