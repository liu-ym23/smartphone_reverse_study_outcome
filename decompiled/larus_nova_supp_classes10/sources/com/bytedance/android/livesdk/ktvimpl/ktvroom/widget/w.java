package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.text.TextUtils;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvOpusMicLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.message.model.qd;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public w(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        qd r8 = (qd) r7;
        Integer r0 = null;
        if (r8 == null) goto L5;
        Boolean r9 = r8.f;
    L7:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L50;
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.a.xq().getKtvMicLabelEvent(), KtvInteractElementWidget$initView$8$1.INSTANCE);
        KtvInteractElementWidget r10 = this.a;
        KtvRoomInteractViewModel r1 = r10.d;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L11:
        qd r2 = (qd) r1.getKtvMicLabelEvent().getValue();
        if (r2 == null) goto L14;
        String r3 = r2.b;
    L16:
        if (TextUtils.isEmpty(r3) == true) goto L51;
        KtvRoomInteractViewModel r4 = r10.d;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L20:
        qd r5 = (qd) r4.getKtvMicLabelEvent().getValue();
        if (r5 == null) goto L23;
        String r6 = r5.h;
    L25:
        if (TextUtils.isEmpty(r6) == true) goto L54;
        KtvOpusMicLabelAnim r11 = r10.x;
        if (r11 == null) goto L30;
        r11.setOnClickListener(new m(r11, r10));
        r11.setOnLabelAnimStatusChange(new n(r10));
    L30:
        KtvRoomInteractViewModel r12 = r10.d;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L33:
        qd r13 = (qd) r12.getKtvMicLabelEvent().getValue();
        if (r13 == null) goto L52;
        KtvOpusMicLabelAnim r14 = r10.x;
        if (r14 == null) goto L53;
        String r15 = r13.d;
        String r16 = r13.b;
        Intrinsics.checkNotNull(r16);
        l r17 = r10.g;
        if (r17 == null) goto L47;
        Integer r18 = Integer.valueOf(r17.getWidth());
        if (r18.intValue() <= 0) goto L42;
        boolean r19 = true;
    L43:
        if (r19 == false) goto L45;
        r0 = r18;
    L45:
        if (r0 == null) goto L47;
        int r20 = r0.intValue();
    L48:
        r14.a(r15, r16, r20 + r10.i);
        return;
    L42:
        r19 = false;
    L47:
        r20 = com.bytedance.android.live.core.utils.s1.f(230.0f);
        goto L48
    L53:
        return;
    L52:
        return;
    L54:
        return;
    L23:
        r6 = null;
        goto L25
    L51:
        return;
    L14:
        r3 = null;
        goto L16
    L50:
        return;
    L5:
        r9 = null;
        goto L7
    }
}
