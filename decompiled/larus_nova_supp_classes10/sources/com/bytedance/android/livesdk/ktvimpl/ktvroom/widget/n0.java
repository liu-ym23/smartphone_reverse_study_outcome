package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMidiSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ KtvOpusMidiWidget a;

    public n0(KtvOpusMidiWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        sh6.b r12 = (sh6.b) r11;
        KtvOpusMidiWidget r0 = this.a;
        KtvMidiStageViewModel r1 = null;
        if (r12 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r13 = (com.bytedance.android.livesdk.ktvimpl.base.sei.a) sh6.c.b(r12);
    L6:
        r0.getClass();
        StringBuilder r2 = new StringBuilder("onSongFeedbackShow1:");
        r2.append(r13);
        r2.append(", copyright: ");
        com.bytedance.android.livesdk.ktvimpl.base.util.j r3 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        boolean r4 = r13 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h;
        if (r4 == true) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = null;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.h r6 = (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r5;
        long r7 = 0;
        if (r6 == null) goto L15;
        Long r8 = r6.i();
        if (r8 == null) goto L15;
        long r9 = r8.longValue();
    L16:
        Long r10 = Long.valueOf(r9);
        r3.getClass();
        r2.append(com.bytedance.android.livesdk.ktvimpl.base.util.j.e(r10));
        ALogger.i("midi-check", r2.toString());
        if (r4 == false) goto L76;
        com.bytedance.android.livesdk.ktvimpl.base.sei.h r14 = (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r13;
        String r15 = r14.f();
        if (r15 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == true) goto L77;
        Long r17 = r14.i();
        if (r17 == null) goto L30;
        r7 = r17.longValue();
    L30:
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.e(Long.valueOf(r7)) == false) goto L79;
        ALogger.i("midi-check", "onSongFeedbackShow:" + r13);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r18 = r0.c;
        if (r18 == null) goto L37;
        View r19 = r18.asView();
        if (r19 == null) goto L37;
        r19.setVisibility(8);
    L37:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r110 = r0.c;
        if ((r110 instanceof KtvMidiSurfaceView) == true) goto L40;
        r110 = null;
    L40:
        KtvMidiSurfaceView r111 = (KtvMidiSurfaceView) r110;
        if (r111 == null) goto L43;
        r111.setBusinessVisible(8);
    L43:
        Object r112 = r0.d;
        if ((r112 instanceof View) == true) goto L46;
        r112 = null;
    L46:
        View r113 = (View) r112;
        if (r113 == null) goto L49;
        r113.setVisibility(0);
    L49:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r114 = r0.d;
        if (r114 == null) goto L52;
        r114.F5(r14);
    L52:
        View r115 = r0.o;
        if (r115 == null) goto L55;
        r115.setBackgroundColor(ColorProtector.parseColor("#81000000"));
    L55:
        View r116 = r0.o;
        if (r116 == null) goto L59;
        r116.setVisibility(0);
    L59:
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r14.k()) == false) goto L61;
        String r117 = "oneself";
    L62:
        int r20 = mb0.f.a;
        mb0.f.g(r14.i(), r14.j(), r14.f(), r14.g(), r14.l());
        Long r21 = KtvLoggerHelper.a;
        int r22 = (int) r14.g();
        String r23 = r14.k();
        if (r14.l() == false) goto L65;
        String r24 = "mark";
    L66:
        KtvLoggerHelper.g0(r22, r23, r117, r24);
        KtvMidiStageViewModel r118 = r0.b;
        if ((r118 instanceof KtvMidiStageViewModel) == false) goto L70;
        r1 = r118;
    L70:
        if (r1 == null) goto L72;
        r1.startFeedBackShowTimer();
    L72:
        Function0<Unit> r119 = r0.h;
        if (r119 == null) goto L78;
        Unit r120 = (Unit) r119.invoke();
        return;
    L78:
        return;
    L65:
        r24 = null;
        goto L66
    L61:
        r117 = "others";
        goto L62
    L79:
        return;
    L77:
        return;
    L21:
        if (r15.length() == 0) goto L24;
        r16 = false;
        goto L25
    L76:
        return;
    L15:
        r9 = 0;
        goto L16
    L9:
        r5 = r13;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
