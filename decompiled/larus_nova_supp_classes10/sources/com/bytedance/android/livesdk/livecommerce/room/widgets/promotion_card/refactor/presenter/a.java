package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
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
public final class a extends p {
    public boolean g;
    public String h;
    public String i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.a$a, reason: collision with other inner class name */
    public static final class C0112a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        public b(a r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            ECUIPromotion r4 = (ECUIPromotion) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(r4.getPromotionId(), this.a.h)) == false) goto L7;
            a r0 = this.a;
            r0.g = false;
            r0.i = null;
        L7:
            a.E(this.a, r4);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ a b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c c;

        public c(ExplainCardViewModel r1, a r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r4) {
            bk2.a r5 = (bk2.a) r4;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.b r6 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.b(this);
            UtilityKotlinExtentionsKt.b.postDelayed(r6, 160);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ a b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c c;

        public d(ExplainCardViewModel r1, a r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
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
            UtilityKotlinExtentionsKt.f(r0, r5, new AboveCardPresenter$bind$$inlined$let$lambda$3$1(this));
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            a r3 = this.a;
            r3.g = false;
            r3.i = null;
        }

        public e(a r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        w().b(2131377516).f().i();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L6;
        r0.getPromotionState().b(r5.getLifecycleOwner(), new b(this, r5));
        r0.getShowAfterAnimAction().b(r5.getLifecycleOwner(), new c(r0, this, r5));
        r0.getHotAtmosphereUpdateAction().b(r5.getLifecycleOwner(), new d(r0, this, r5));
        w().f().addOnAttachStateChangeListener(new e(this, r5));
        return;
    }

    public static final void E(a r10, ECUIPromotion r11) {
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
        Query r1 = r10.w().b(2131377516);
        ECHotAtmosphereView r4 = r1.f();
        r4.setDegradeModeCallback(AboveCardPresenter$updateUI$3.INSTANCE);
        r4.setCallback(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.c(r10, r11));
        if (r10.g == true) goto L11;
        r4.i();
        r1.c();
        return;
    L11:
        if (r11 == null) goto L13;
        String r5 = r11.getPromotionId();
    L14:
        r10.h = r5;
        if (r11 == null) goto L51;
        ECHotAtmosphere r6 = r11.getHotAtmosphere();
        if (r6 == null) goto L51;
        if (r11.canShowHotAtmosphere() == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L51;
        String r7 = r6.num;
        if (r7 == null) goto L30;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L28;
        int r9 = r8.intValue();
    L29:
        if (r9 <= 0) goto L30;
    L43:
        ExplainCardViewModel r14 = r10.e;
        if (r14 == null) goto L46;
        ml.b r15 = r14.getLiveRoomInfo();
    L47:
        r10.F(r11, r15, false);
        if (r4.getVisibility() == 0) goto L50;
        ECHotAtmosphereView.g(r4, true, false, null, 6);
        r4.setAlpha(0.0f);
        r4.setVisibility(0);
        r4.animate().cancel();
        ViewPropertyAnimator r16 = r4.animate().alpha(1.0f);
        r16.setDuration(160);
        r16.start();
    L50:
        r4.l(false);
        r4.j(r6, true, false);
        return;
    L46:
        r15 = null;
        goto L47
    L28:
        r9 = 0;
    L30:
        int r17 = zg2.a.a;
        ExplainCardViewModel r18 = r10.e;
        if (r18 == null) goto L35;
        ml.b r19 = r18.getLiveRoomInfo();
        if (r19 == null) goto L35;
        String r20 = r19.roomId();
    L36:
        ExplainCardViewModel r21 = r10.e;
        if (r21 == null) goto L41;
        RoomContextController r22 = r21.getRoomContextController();
        if (r22 == null) goto L41;
        String r23 = r22.D();
    L42:
        zg2.a.a(r20, r23, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
    L41:
        r23 = null;
    L35:
        r20 = null;
    L51:
        r1.c();
        return;
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
