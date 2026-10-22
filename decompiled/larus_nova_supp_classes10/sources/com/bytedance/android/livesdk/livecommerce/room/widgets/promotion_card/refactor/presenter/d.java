package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.ECAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends p {
    public static final /* synthetic */ int k = 0;
    public boolean g;
    public String h;
    public String i;
    public boolean j;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ d a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        public b(d r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            ECUIPromotion r5 = (ECUIPromotion) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(r5.getPromotionId(), this.a.h)) == false) goto L7;
            d r0 = this.a;
            r0.g = false;
            r0.i = null;
            r0.j = false;
        L7:
            d.E(this.a, r5);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ d b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c c;

        public c(ExplainCardViewModel r1, d r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r4) {
            bk2.a r5 = (bk2.a) r4;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.e r6 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.e(this);
            UtilityKotlinExtentionsKt.b.postDelayed(r6, 160);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.d$d, reason: collision with other inner class name */
    public static final class C0113d<T> implements Observer {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ d b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c c;

        public C0113d(ExplainCardViewModel r1, d r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r3) {
            bk2.a r4 = (bk2.a) r3;
            Object r0 = this.a.getPromotionState().a();
            if (r4 == null) goto L5;
            ECHotAtmosphere r5 = (ECHotAtmosphere) r4.b;
        L6:
            UtilityKotlinExtentionsKt.f(r0, r5, new AboveCardPresenterV2$bind$$inlined$let$lambda$3$1(this));
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {
        public final /* synthetic */ d a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public e(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            d r4 = this.a;
            r4.g = false;
            r4.i = null;
            r4.j = false;
        }
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L5;
        r0.getPromotionState().b(r5.getLifecycleOwner(), new b(this, r5));
        r0.getShowAfterAnimAction().b(r5.getLifecycleOwner(), new c(r0, this, r5));
        r0.getHotAtmosphereUpdateAction().b(r5.getLifecycleOwner(), new C0113d(r0, this, r5));
    L5:
        w().f().addOnAttachStateChangeListener(new e(this));
    }

    public static final void E(final d r10, final ECUIPromotion r11) {
        int r1 = 0;
        if (r11 == null) goto L7;
        r10.getClass();
        ECUrlModel r3 = r11.topIcon;
        if (r3 == null) goto L7;
        Query r12 = r10.w().b(2131377662);
        r12.g(0);
        GenericDraweeView r2 = r12.f();
        int r13 = com.bytedance.android.ec.core.imagex.r.h;
        h0.d(r2, r3, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_top_up_view"), null, null, null, null, 120);
        return;
    L7:
        r10.w().b(2131377662).c();
        ECAtmosphereView r0 = (ECAtmosphereView) r10.w().b(2131377424).f();
        if (r10.g == true) goto L10;
        r0.setVisibility(8);
        return;
    L10:
        String r4 = null;
        if (r11 == null) goto L13;
        ECHotAtmosphere r5 = r11.getHotAtmosphere();
    L14:
        if (r11 == null) goto L16;
        ECAtmosphere r6 = r11.getAtmosphere();
    L17:
        r0.setListener(new AboveCardPresenterV2$getAtmosphereListener$1(r10, r11));
        if (r5 != null) goto L20;
    L40:
        if (r6 != null) goto L42;
    L44:
        String r7 = r10.h;
        if (r11 == null) goto L48;
        r4 = r11.getPromotionId();
    L48:
        if ((!Intrinsics.areEqual(r7, r4)) == true) goto L58;
        if (r11 == null) goto L58;
        if (r11.isOnSale() != true) goto L58;
        if (r10.j == true) goto L56;
        return;
    L56:
        if (r11.isOnSale() != true) goto L66;
        r0.setVisibility(0);
        return;
    L66:
        return;
    L58:
        r0.setVisibility(8);
        return;
    L42:
        if (r11.canShowOtherAtmosphere() == false) goto L44;
        r10.h = r11.getPromotionId();
        r0.setVisibility(0);
        r10.j = true;
        r0.a(r6);
        return;
    L20:
        if (r11.canShowHotAtmosphere() == false) goto L40;
        r10.h = r11.getPromotionId();
        r0.setVisibility(0);
        r10.j = true;
        r0.b(r5);
        String r14 = r5.num;
        if (r14 == null) goto L27;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L26;
        r1 = r15.intValue();
    L26:
        if (r1 <= 0) goto L27;
        return;
    L27:
        int r16 = zg2.a.a;
        ExplainCardViewModel r17 = r10.e;
        if (r17 == null) goto L32;
        ml.b r18 = r17.getLiveRoomInfo();
        if (r18 == null) goto L32;
        String r19 = r18.roomId();
    L33:
        ExplainCardViewModel r110 = r10.e;
        if (r110 == null) goto L38;
        RoomContextController r111 = r110.getRoomContextController();
        if (r111 == null) goto L38;
        String r112 = r111.D();
    L39:
        zg2.a.a(r19, r112, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
        return;
    L38:
        r112 = null;
    L32:
        r19 = null;
        goto L33
    L16:
        r6 = null;
        goto L17
    L13:
        r5 = null;
        goto L14
    }

    public final void F(ECUIPromotion r3, ml.b r4, boolean r5) {
        if ((!Intrinsics.areEqual(r3.getPromotionId(), this.i)) == true) goto L5;
        if (r5 == true) goto L5;
        return;
    L5:
        this.i = r3.getPromotionId();
        int r6 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ExplainCardViewModel r7 = this.e;
        RoomContextController r0 = null;
        if (r7 == null) goto L10;
        Function0<Map<String, Map<String, String>>> r8 = r7.getEventPassthroughParams();
        if (r8 == null) goto L10;
        Map r9 = (Map) r8.invoke();
    L11:
        ExplainCardViewModel r1 = this.e;
        if (r1 == null) goto L14;
        r0 = r1.getRoomContextController();
    L14:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.e(r3, r4, r9, r0);
        return;
    L10:
        r9 = null;
        goto L11
    }
}
