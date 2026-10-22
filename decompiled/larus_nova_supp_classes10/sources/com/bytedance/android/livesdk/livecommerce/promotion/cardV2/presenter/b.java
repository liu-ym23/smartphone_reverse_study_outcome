package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.module.PromotionCardExternalView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends QPresenter {
    public boolean e;
    public final LivePromotionCardArgsV2 f;
    public final w83.d<?> g;
    public final Lazy<i> h;

    private final void update(com.bytedance.android.livesdk.livecommerce.promotion.card.h r7) {
        PromotionCardExternalView r0 = (PromotionCardExternalView) w().f();
        Intrinsics.checkNotNullParameter(r7, "item");
        dm.a.b r1 = dm.a.a("CardBottom");
        StringBuilder r2 = new StringBuilder("bind card, product id = ");
        r2.append(r7.a.a.getProductId());
        r2.append(", bottom region=");
        ll.a r3 = r7.a.a.getClientData().h;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L6:
        r2.append(r4);
        r1.a(r2.toString());
        rl.a r5 = r7.a.a.getDynamicSlot();
        if (r5 == null) goto L10;
        ll.a r6 = r5.a();
        if (r6 == null) goto L10;
    L12:
        if (r6 == null) goto L28;
        String r8 = r7.a.a.getProductId();
        r0.setVisibility(0);
        int r9 = r6.a();
        if (r9 != DynamicType.NATIVE.getValue()) goto L21;
        r0.setVisibility(0);
        Lazy<? extends i> r10 = r0.b;
        if (r10 == null) goto L27;
        i r11 = (i) r10.getValue();
        if (r11 == null) goto L27;
        i.a.a(r11, r0, r6, true, 8);
    L27:
        r0.c = r6;
        r0.d = r8;
        return;
    L21:
        if (r9 != DynamicType.LYNX.getValue()) goto L27;
        r0.setVisibility(0);
        Lazy<? extends i> r12 = r0.b;
        if (r12 == null) goto L27;
        i r13 = (i) r12.getValue();
        if (r13 == null) goto L27;
        i.a.b(r13, r0, r6, r8);
        goto L27
    L28:
        ll.a r14 = r0.c;
        if (r14 == null) goto L31;
        Integer r15 = Integer.valueOf(r14.a());
    L32:
        int r16 = DynamicType.NATIVE.getValue();
        if (r15 != null) goto L36;
    L43:
        int r17 = DynamicType.LYNX.getValue();
        if (r15 != null) goto L47;
    L54:
        r0.c = null;
        r0.d = null;
        Unit r18 = Unit.INSTANCE;
        return;
    L47:
        if (r15.intValue() != r17) goto L54;
        Lazy<? extends i> r19 = r0.b;
        if (r19 == null) goto L53;
        i r20 = (i) r19.getValue();
        if (r20 == null) goto L53;
        r20.b(r0);
    L53:
        r0.setVisibility(8);
        goto L54
    L36:
        if (r15.intValue() != r16) goto L43;
        Lazy<? extends i> r21 = r0.b;
        if (r21 == null) goto L42;
        i r22 = (i) r21.getValue();
        if (r22 == null) goto L42;
        r22.d(r0);
    L42:
        r0.setVisibility(8);
        goto L54
    L31:
        r15 = null;
    L10:
        r6 = r7.a.a.getClientData().h;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void A(QModel r8) {
        if ((r8 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.h) == true) goto L5;
        QModel r0 = null;
    L6:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r1 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.e == true) goto L12;
        this.e = true;
        PromotionCardExternalView r2 = (PromotionCardExternalView) w().f();
        LivePromotionCardArgsV2 r4 = this.f;
        Lazy<i> r5 = this.h;
        Intrinsics.checkNotNullParameter(r4, "argument");
        r2.a = r4;
        r2.b = r5;
        r2.getClass();
    L12:
        int r3 = a.a[r1.b.ordinal()];
        if (r3 != 1) goto L15;
        update(r1);
        return;
    L15:
        if (r3 != 2) goto L52;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r9 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r8;
        PromotionCardExternalView r10 = (PromotionCardExternalView) w().f();
        dm.a.b r6 = dm.a.a("CardBottom");
        StringBuilder r7 = new StringBuilder("recycle card, product id=");
        r7.append(r10.d);
        r7.append(", bottom region=");
        ll.a r11 = r10.c;
        if (r11 == null) goto L20;
        Integer r12 = Integer.valueOf(r11.hashCode());
    L21:
        r7.append(r12);
        r6.a(r7.toString());
        ll.a r13 = r10.c;
        if (r13 == null) goto L24;
        Integer r14 = Integer.valueOf(r13.a());
    L25:
        int r15 = DynamicType.NATIVE.getValue();
        if (r14 != null) goto L29;
    L36:
        int r16 = DynamicType.LYNX.getValue();
        if (r14 != null) goto L40;
    L47:
        r10.c = null;
        r10.d = null;
        return;
    L40:
        if (r14.intValue() != r16) goto L47;
        Lazy<? extends i> r17 = r10.b;
        if (r17 == null) goto L46;
        i r18 = (i) r17.getValue();
        if (r18 == null) goto L46;
        r18.b(r10);
    L46:
        r10.setVisibility(8);
        goto L47
    L29:
        if (r14.intValue() != r15) goto L36;
        Lazy<? extends i> r19 = r10.b;
        if (r19 == null) goto L35;
        i r20 = (i) r19.getValue();
        if (r20 == null) goto L35;
        r20.d(r10);
    L35:
        r10.setVisibility(8);
        goto L47
    L24:
        r14 = null;
        goto L25
    L20:
        r12 = null;
        goto L21
    L52:
        return;
    L5:
        r0 = r8;
        goto L6
    }

    public b(LivePromotionCardArgsV2 r2, w83.d<?> r3, Lazy<? extends i> r4) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        Intrinsics.checkNotNullParameter(r4, "ligoViewManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
