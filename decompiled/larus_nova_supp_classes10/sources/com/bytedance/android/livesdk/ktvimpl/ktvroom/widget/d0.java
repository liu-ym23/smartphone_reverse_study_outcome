package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public d0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        sh6.b r10 = (sh6.b) r9;
        KtvMvMidiWidget r0 = this.a;
        KtvMidiStageViewModel r1 = null;
        if (r10 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r11 = (com.bytedance.android.livesdk.ktvimpl.base.sei.a) sh6.c.b(r10);
    L6:
        r0.getClass();
        ALogger.i("midi-check", "onSongFeedbackShow1:" + r11);
        if ((r11 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h) == false) goto L50;
        com.bytedance.android.livesdk.ktvimpl.base.sei.h r12 = (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r11;
        String r2 = r12.f();
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L52;
        AbsKtvMidiView r4 = r0.c;
        if (r4 == null) goto L20;
        r4.setVisibility(8);
    L20:
        Object r5 = r0.d;
        if ((r5 instanceof View) == true) goto L23;
        r5 = null;
    L23:
        View r6 = (View) r5;
        if (r6 == null) goto L26;
        r6.setVisibility(0);
    L26:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r7 = r0.d;
        if (r7 == null) goto L29;
        r7.F5(r12);
    L29:
        View r8 = r0.j;
        if (r8 == null) goto L32;
        r8.setBackgroundColor(ColorProtector.parseColor("#81000000"));
    L32:
        View r13 = r0.j;
        if (r13 == null) goto L36;
        r13.setVisibility(0);
    L36:
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r12.k()) == false) goto L38;
        String r14 = "oneself";
    L39:
        int r15 = mb0.f.a;
        mb0.f.g(r12.i(), r12.j(), r12.f(), r12.g(), r12.l());
        Long r16 = KtvLoggerHelper.a;
        int r17 = (int) r12.g();
        String r18 = r12.k();
        if (r12.l() == false) goto L42;
        String r19 = "mark";
    L43:
        KtvLoggerHelper.g0(r17, r18, r14, r19);
        KtvMidiStageViewModel r20 = r0.b;
        if ((r20 instanceof KtvMidiStageViewModel) == false) goto L47;
        r1 = r20;
    L47:
        if (r1 == null) goto L51;
        r1.startFeedBackShowTimer();
        return;
    L51:
        return;
    L42:
        r19 = null;
        goto L43
    L38:
        r14 = "others";
        goto L39
    L52:
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L50:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
