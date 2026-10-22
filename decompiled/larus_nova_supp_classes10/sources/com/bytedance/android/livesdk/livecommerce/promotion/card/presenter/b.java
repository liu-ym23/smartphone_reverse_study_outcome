package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomCarryNewView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends QPresenter {
    public boolean e;
    public final LivePromotionCardArgs f;
    public final w83.d<?> g;
    public final Lazy<w83.i> h;

    private final void update(com.bytedance.android.livesdk.livecommerce.promotion.card.i r7) {
        ListItemBottomCarryNewView r0 = (ListItemBottomCarryNewView) w().f();
        Intrinsics.checkNotNullParameter(r7, "item");
        rl.a r1 = r7.a.a.getDynamicSlot();
        if (r1 == null) goto L6;
        ll.a r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        if (r2 == null) goto L31;
        String r8 = r7.a.a.getProductId();
        r0.setVisibility(0);
        int r3 = r2.a();
        if (r3 != DynamicType.NATIVE.getValue()) goto L20;
        r0.setVisibility(0);
        Lazy<? extends w83.i> r9 = r0.a;
        if (r9 != null) goto L13;
    L30:
        r0.b = r2;
        return;
    L13:
        if (r9.isInitialized() != true) goto L30;
        Lazy<? extends w83.i> r10 = r0.a;
        if (r10 == null) goto L30;
        w83.i r11 = (w83.i) r10.getValue();
        if (r11 == null) goto L30;
        w83.i.a.a(r11, r0, r2, true, 8);
        goto L30
    L20:
        if (r3 != DynamicType.LYNX.getValue()) goto L30;
        r0.setVisibility(0);
        Lazy<? extends w83.i> r4 = r0.a;
        if (r4 == null) goto L30;
        if (r4.isInitialized() != true) goto L30;
        Lazy<? extends w83.i> r5 = r0.a;
        if (r5 == null) goto L30;
        w83.i r6 = (w83.i) r5.getValue();
        if (r6 == null) goto L30;
        w83.i.a.b(r6, r0, r2, r8);
        goto L30
    L31:
        ll.a r12 = r0.b;
        if (r12 == null) goto L34;
        Integer r13 = Integer.valueOf(r12.a());
    L35:
        int r14 = DynamicType.NATIVE.getValue();
        if (r13 != null) goto L39;
    L41:
        int r15 = DynamicType.LYNX.getValue();
        if (r13 != null) goto L45;
    L47:
        r0.b = null;
        Unit r16 = Unit.INSTANCE;
        return;
    L45:
        if (r13.intValue() != r15) goto L47;
        r0.a();
        goto L47
    L39:
        if (r13.intValue() != r14) goto L41;
        r0.b();
        goto L47
    L34:
        r13 = null;
    L6:
        r2 = r7.a.a.getClientData().h;
        goto L7
    }

    public final void A(QModel r7) {
        if ((r7 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r7 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r8 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r7;
        if (r8 != null) goto L8;
        return;
    L8:
        if (this.e == true) goto L11;
        this.e = true;
        ListItemBottomCarryNewView r0 = (ListItemBottomCarryNewView) w().f();
        LivePromotionCardArgs r3 = this.f;
        Lazy<w83.i> r4 = this.h;
        Intrinsics.checkNotNullParameter(r3, "argument");
        r0.a = r4;
        r0.getClass();
    L11:
        int r1 = a.a[r8.b.ordinal()];
        if (r1 != 1) goto L14;
        update(r8);
        return;
    L14:
        if (r1 != 2) goto L37;
        ListItemBottomCarryNewView r9 = (ListItemBottomCarryNewView) w().f();
        ll.a r2 = r9.b;
        if (r2 == null) goto L19;
        Integer r5 = Integer.valueOf(r2.a());
    L20:
        int r6 = DynamicType.NATIVE.getValue();
        if (r5 != null) goto L24;
    L26:
        int r10 = DynamicType.LYNX.getValue();
        if (r5 != null) goto L30;
    L32:
        r9.b = null;
        return;
    L30:
        if (r5.intValue() != r10) goto L32;
        r9.a();
        goto L32
    L24:
        if (r5.intValue() != r6) goto L26;
        r9.b();
        goto L32
    L19:
        r5 = null;
        goto L20
    }

    public b(LivePromotionCardArgs r2, w83.d<?> r3, Lazy<? extends w83.i> r4) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        Intrinsics.checkNotNullParameter(r4, "ligoViewManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
