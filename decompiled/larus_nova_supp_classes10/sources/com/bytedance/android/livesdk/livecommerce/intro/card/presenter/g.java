package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardButtonComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hl.m;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends oh2.a implements com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a {
    public IntroPromotionVO i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IntroPromotionVO r4 = (IntroPromotionVO) r3;
            this.a.i = r4;
            if (r4 == null) goto L11;
            k0 r0 = r4.getPurchase();
            if (r0 == null) goto L13;
            g r1 = this.a;
            s0 r5 = r4.getControl();
            if (r5 == null) goto L9;
            Integer r6 = Integer.valueOf(r5.d());
        L10:
            ((IntroCardButtonComponent) r1.w().f()).a(r0, r6);
            return;
        L9:
            r6 = null;
            goto L10
        L13:
            return;
        L11:
            Unit r7 = Unit.INSTANCE;
        }
    }

    public g() {
        super(0);
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
    }

    @Override // oh2.a
    public final void D(oh2.h r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ((IntroCardButtonComponent) w().f()).setPresenter(this);
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        bk2.e<IntroPromotionVO> r1 = r0.getCardState();
        if (r1 == null) goto L9;
        r1.b(r3.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a
    public final void h(View r21, l0 r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        Intrinsics.checkNotNullParameter(r22, "purchaseButton");
        com.bytedance.android.ec.core.utils.s0.a(new m());
        oh2.e r1 = this.f;
        String r3 = null;
        if (r1 == null) goto L7;
        oh2.d r2 = r1.d;
        if (r2 == null) goto L7;
        LiveActionTracker r6 = r2.b(null);
    L8:
        IntroPromotionVO r4 = this.i;
        if (r4 == null) goto L13;
        IntroProduct r5 = r4.getProduct();
        if (r5 == null) goto L13;
        String r7 = r5.i();
    L14:
        IntroPromotionVO r8 = this.i;
        if (r8 == null) goto L19;
        IntroProduct r9 = r8.getProduct();
        if (r9 == null) goto L19;
        String r10 = r9.g();
    L20:
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r11 = r22.a();
        if (r11 == null) goto L23;
        boolean r17 = true;
    L24:
        xh.a r12 = xh.c.a("Live");
        Pair[] r13 = new Pair[3];
        r13[0] = TuplesKt.to("button_enabled", String.valueOf(!r17));
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        r13[1] = TuplesKt.to("promotion_id", r7);
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r13[2] = TuplesKt.to("product_id", r10);
        r12.d("good_list", "cell_action_button", MapsKt.mapOf(r13));
        if (r6 == null) goto L33;
        il2.a.C0145a.a(r6, "click_card", MapsKt.mapOf(TuplesKt.to("click_area", "button")), false, null, null, null, 60);
    L33:
        oh2.e r14 = this.f;
        if (r14 == null) goto L38;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r15 = r14.b;
        if (r15 == null) goto L38;
        r15.b();
        String r16 = "a1128.b3295.c59667.d30614";
    L40:
        if (r16 != null) goto L42;
        String r18 = "";
    L43:
        BtmItemBuilder r19 = new BtmItemBuilder(r18, Boolean.TRUE).withView(r21);
        com.bytedance.android.btm.api.model.d r110 = BtmUtilsKt.e(r16, PageFinder.via(r21));
        if (r6 == null) goto L46;
        r6.g = r110;
    L46:
        if (r17 == true) goto L60;
        oh2.c r20 = this.g;
        if (r20 == null) goto L55;
        oh2.e r23 = this.f;
        if (r23 == null) goto L54;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r24 = r23.b;
        if (r24 == null) goto L54;
        r24.b();
        r3 = "a1128.b3295.c59667.d30614";
    L54:
        oh2.c.a.b(r20, "button", false, r3, r21);
    L55:
        if (r6 == null) goto L73;
        il2.a r25 = il2.a.C0145a.a(r6, "check_buy_btn", null, false, "buy_btn_disable", null, null, 48);
        if (r25 == null) goto L74;
        ((LiveActionTracker) r25).e(false);
        return;
    L74:
        return;
    L73:
        return;
    L60:
        if (r11 != null) goto L62;
        return;
    L62:
        oh2.c r26 = this.g;
        if (r26 == null) goto L66;
        r26.a("button", true, r16, r19, r21);
    L66:
        if (r6 == 0) goto L69;
        il2.a.C0145a.a(r6, "check_buy_btn", MapsKt.mapOf(TuplesKt.to("action", r11)), false, null, null, null, 60);
    L69:
        oh2.c r27 = this.g;
        if (r27 == null) goto L75;
        oh2.c.a.a(r27, u().c(), "button", 1, r11, r110, BtmSDK.INSTANCE.getPageId(PageFinder.via(r21)), r6);
        return;
    L75:
        return;
    L42:
        r18 = r16;
    L38:
        r16 = null;
        goto L40
    L23:
        r17 = false;
    L19:
        r10 = null;
    L13:
        r7 = null;
    L7:
        r6 = null;
        goto L8
    }
}
