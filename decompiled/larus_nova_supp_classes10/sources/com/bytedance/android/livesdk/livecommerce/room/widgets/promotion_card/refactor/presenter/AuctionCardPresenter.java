package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECAuctionStatusLayout;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CurrentUserInfo;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class AuctionCardPresenter extends p {
    public static final /* synthetic */ int l = 0;
    public h g;
    public i h;
    public ECAuctionStatusLayout i;
    public boolean j;
    public String k;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AuctionCardPresenter a;

        public b(AuctionCardPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            ECUIPromotion r14 = (ECUIPromotion) r13;
            if (r14 == null) goto L5;
            String r1 = r14.getPromotionId();
        L7:
            if ((!Intrinsics.areEqual(r1, this.a.k)) == false) goto L9;
            this.a.j = false;
        L9:
            if (r14 != null) goto L11;
        L65:
            this.a.u().d().q(rk2.b.class, 8);
            return;
        L11:
            if (r14.isAuction() != true) goto L65;
            this.a.u().d().q(rk2.b.class, 0);
            final AuctionCardPresenter r2 = this.a;
            ECPromotionAuctionInfo r4 = r14.campaign.auctionInfo;
            ViewGroup r5 = (ViewGroup) r2.w().f();
            if (r5.getChildCount() != 0) goto L15;
            th.a.c(r2.u().c(), 2131560685, r5, true);
        L15:
            ExplainCardViewModel r6 = r2.e;
            if (r6 == null) goto L20;
            QLiveData<bk2.a<Unit>> r7 = r6.getShowCardAction();
            if (r7 == null) goto L20;
            r7.g(new bk2.a(Unit.INSTANCE));
        L20:
            r2.F(r4);
            String r15 = r14.imageUrl;
            if (r15 == null) goto L23;
            float r8 = UtilityKotlinExtentionsKt.c(14);
            ECNetImageView r9 = r2.w().b(2131376196).f();
            r9.setController(Fresco.newDraweeControllerBuilder().setControllerListener(new g(r2)).build());
            r9.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r8, r8, 0.0f, 0.0f));
            r9.setImageURI(r15);
            r9.getHierarchy().setPlaceholderImage(2131234620);
        L23:
            r2.G(r4);
            Query r16 = r2.w().b(2131377427);
            Query r10 = r2.w().b(2131377428);
            if (r2.g != null) goto L27;
            final int r11 = th.a.a(r2.u().c(), 2131101610);
            Query r12 = r16.b(2131390780);
            r12.f().C(new AuctionCardPresenter$updateBidInfo$$inlined$apply$lambda$1(r11));
            Unit r17 = Unit.INSTANCE;
            Query r18 = r10.b(2131390780);
            r18.f().C(new AuctionCardPresenter$updateBidInfo$$inlined$apply$lambda$2(r11));
            r2.g = new h(r12, r18);
        L27:
            if (r2.h != null) goto L29;
            r2.h = new i(r16.b(2131377521), r10.b(2131377521));
        L29:
            Long r19 = r4.getPrice();
            if (r19 == null) goto L34;
            long r20 = r19.longValue();
            h r110 = r2.g;
            if (r110 == null) goto L34;
            r110.c(Long.valueOf(r20));
        L34:
            final Ref.ObjectRef r111 = new Ref.ObjectRef();
            r111.element = null;
            final Ref.ObjectRef r21 = new Ref.ObjectRef();
            String r22 = r4.getPriceLabel();
            if (r22 != null) goto L37;
            r22 = "";
        L37:
            r21.element = r22;
            Integer r23 = r4.getStatus();
            if (r23 != null) goto L41;
        L61:
            i r3 = r2.h;
            if (r3 == null) goto L64;
            r3.c(new Pair((CharSequence) r21.element, (String) r111.element));
        L64:
            r2.E(r4);
            r2.w().b(2131376107).a(new f(r2));
            com.bytedance.android.ec.core.widget.f.c(r2.w().b(2131377443).f(), null, "bind_key_live_cart_card", new AuctionCardPresenter$bindClick$2(r2), 1);
            com.bytedance.android.ec.core.widget.f.c(r2.w().b(2131376196).f(), null, "bind_key_live_cart_card", new AuctionCardPresenter$bindClick$3(r2), 1);
            return;
        L41:
            if (r23.intValue() != 2) goto L61;
            CurrentUserInfo r24 = r4.getCurrentUserInfo();
            if (r24 == null) goto L61;
            ECUrlModel r25 = r24.getUserPic();
            if (r25 == null) goto L49;
            List r26 = r25.getUrlList();
            if (r26 == null) goto L49;
            String r27 = (String) CollectionsKt.firstOrNull(r26);
        L50:
            r111.element = r27;
            String r28 = r24.getUserName();
            if (r28 == null) goto L59;
            if (r28.length() <= 0) goto L55;
            boolean r29 = true;
        L56:
            if (r29 != true) goto L59;
            r21.element = th.a.h(r2.u().c(), 2131896340, new Object[]{r24.getUserName()});
            goto L59
        L55:
            r29 = false;
        L59:
            if (Intrinsics.areEqual(String.valueOf(r24.getUserId()), com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId()) == false) goto L61;
            r111.element = null;
            com.bytedance.android.ec.core.toolbox.text.d r30 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
            r30.append(th.a.g(r2.u().c(), 2131896344));
            com.bytedance.android.ec.core.toolbox.text.c.a.a(r30, (int) UIUtils.dip2Px(r2.u().c(), 2.0f));
            r30.g((int) 4294914884L, new AuctionCardPresenter$updateBidInfo$$inlined$let$lambda$1(r2, r111, r21));
            Unit r31 = Unit.INSTANCE;
            r21.element = r30.f();
        L49:
            r27 = null;
            goto L50
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ AuctionCardPresenter a;

        public c(AuctionCardPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            bk2.a r4 = (bk2.a) r3;
            AuctionCardPresenter r5 = this.a;
            r5.j = true;
            ExplainCardViewModel r6 = r5.e;
            if (r6 == null) goto L14;
            QLiveData<ECUIPromotion> r7 = r6.getPromotionState();
            if (r7 == null) goto L15;
            ECUIPromotion r8 = (ECUIPromotion) r7.a();
            if (r8 == null) goto L16;
            AuctionCardPresenter r0 = this.a;
            r0.k = r8.getPromotionId();
            if (r8.isAuction() == false) goto L17;
            ECPromotionAuctionInfo r9 = r8.getAuctionInfo();
            if (r9 == null) goto L18;
            this.a.F(r9);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        q83.a r0 = this.i;
        if (r0 == null) goto L6;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r0);
        return;
    }

    public AuctionCardPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L7;
        r1.b(r4.getLifecycleOwner(), new b(this));
    L7:
        ExplainCardViewModel r2 = this.e;
        if (r2 == null) goto L13;
        QLiveData<bk2.a<Unit>> r3 = r2.getShowAfterAnimAction();
        if (r3 == null) goto L14;
        r3.b(r4.getLifecycleOwner(), new c(this));
        return;
    L14:
        return;
    }

    public final void E(ECPromotionAuctionInfo r10) {
        Query r0 = w().b(2131390237);
        Query r1 = w().b(2131376056);
        r1.g(8);
        Query r2 = w().b(2131377443);
        Integer r3 = r10.getStatus();
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        if (r4 > 2) goto L18;
        float r5 = UtilityKotlinExtentionsKt.c(12);
        View r6 = r0.b;
        if ((r6 instanceof TextView) == false) goto L11;
        ((TextView) r6).setTextSize(0, r5);
    L11:
        View r7 = r0.b;
        if ((r7 instanceof TextView) == false) goto L15;
        TextView r8 = (TextView) r7;
        r8.setTextColor(r8.getResources().getColor(2131101703));
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        r2.f().setBackgroundResource(2131234241);
    L28:
        Integer r9 = r10.getStatus();
        String r11 = "";
        if (r9 != null) goto L32;
    L48:
        if (r9 != null) goto L51;
    L55:
        if (r9 != null) goto L58;
    L62:
        String r12 = r10.getButtonLabel();
        if (r12 == null) goto L66;
        r11 = r12;
    L66:
        r0.e(r11);
        return;
    L58:
        if (r9.intValue() != 6) goto L62;
        View r13 = r0.b;
        if ((r13 instanceof TextView) == false) goto L72;
        ((TextView) r13).setText(2131896345);
        return;
    L72:
        return;
    L51:
        if (r9.intValue() != 4) goto L55;
        View r14 = r0.b;
        if ((r14 instanceof TextView) == false) goto L70;
        ((TextView) r14).setText(2131896341);
        return;
    L70:
        return;
    L32:
        if (r9.intValue() != 3) goto L48;
        CurrentUserInfo r15 = r10.getCurrentUserInfo();
        if (r15 == null) goto L43;
        ECUrlModel r16 = r15.getUserPic();
        if (r16 == null) goto L42;
        List r17 = r16.getUrlList();
        if (r17 == null) goto L42;
        String r18 = (String) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L42;
        r1.g(0);
        ECNetImageView r19 = r1.f();
        r19.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r19.setImageURI(r18);
    L42:
        r0.e(th.a.h(u().c(), 2131896346, new Object[]{r15.getUserName()}));
        return;
    L43:
        String r110 = r10.getButtonLabel();
        if (r110 == null) goto L47;
        r11 = r110;
    L47:
        r0.e(r11);
        return;
    L17:
        r2.f().setBackgroundColor(th.a.a(u().c(), 2131106067));
        goto L28
    L18:
        float r20 = UtilityKotlinExtentionsKt.c(10);
        View r21 = r0.b;
        if ((r21 instanceof TextView) == false) goto L21;
        ((TextView) r21).setTextSize(0, r20);
    L21:
        View r22 = r0.b;
        if ((r22 instanceof TextView) == false) goto L25;
        TextView r23 = (TextView) r22;
        r23.setTextColor(r23.getResources().getColor(2131106223));
    L25:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        r2.f().setBackgroundResource(2131234240);
        goto L28
    L27:
        r2.f().setBackgroundColor(th.a.a(u().c(), 2131105965));
        goto L28
    L5:
        r4 = 1;
        goto L7
    }

    public final void F(ECPromotionAuctionInfo r8) {
        ECHotAtmosphereView r0 = w().b(2131377516).f();
        if (this.j == true) goto L5;
        r0.setVisibility(4);
        return;
    L5:
        ECHotAtmosphereView.g(r0, true, true, null, 4);
        ECHotAtmosphere r9 = r8.getHotAtmosphere();
        if (r9 == null) goto L33;
        String r2 = r9.num;
        if (r2 == null) goto L14;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        if (r4 <= 0) goto L14;
    L28:
        if (r0.getVisibility() == 0) goto L30;
        r0.setVisibility(0);
        r0.setAlpha(0.0f);
        r0.setVisibility(0);
        r0.animate().cancel();
        ViewPropertyAnimator r5 = r0.animate().alpha(1.0f);
        r5.setDuration(160);
        r5.start();
    L30:
        r0.l(false);
        r0.j(r9, true, false);
        return;
    L12:
        r4 = 0;
    L14:
        int r6 = zg2.a.a;
        ExplainCardViewModel r7 = this.e;
        if (r7 == null) goto L19;
        ml.b r10 = r7.getLiveRoomInfo();
        if (r10 == null) goto L19;
        String r11 = r10.roomId();
    L20:
        ExplainCardViewModel r12 = this.e;
        if (r12 == null) goto L25;
        RoomContextController r13 = r12.getRoomContextController();
        if (r13 == null) goto L25;
        String r14 = r13.D();
    L26:
        zg2.a.a(r11, r14, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
    L25:
        r14 = null;
    L19:
        r11 = null;
        goto L20
    }

    public final void G(final ECPromotionAuctionInfo r4) {
        final q83.a r0 = (ECAuctionStatusLayout) w().b(2131377634).f();
        Function0<Unit> r1 = new AuctionCardPresenter$updateStatus$1(this, r0, r4);
        Intrinsics.checkNotNullParameter(r4, "auctionInfo");
        ((ECAuctionStatusLayout) r0).d = true;
        ((ECAuctionStatusLayout) r0).g = r1;
        ((ECAuctionStatusLayout) r0).c = r4;
        int r2 = wl.a.b;
        ((ECAuctionStatusLayout) r0).h = wl.a.a(r4.getEndTime());
        r0.a(r4);
        this.i = r0;
        if (r0.d(null) == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r0);
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r0);
        if (r0.e(r4) == false) goto L10;
        G(r4);
        E(r4);
        return;
    }
}
