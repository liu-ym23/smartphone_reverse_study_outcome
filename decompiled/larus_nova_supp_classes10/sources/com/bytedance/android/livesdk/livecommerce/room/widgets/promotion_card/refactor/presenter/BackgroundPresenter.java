package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.ECCombinationProduct;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotionPopHeader;
import com.bytedance.android.ec.model.response.PopStyle;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.CombinationView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BackgroundPresenter extends p {
    public String g;
    public String h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BackgroundPresenter a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        public a(BackgroundPresenter r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r19) {
            ECUIPromotion r1 = (ECUIPromotion) r19;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.isAuction() == false) goto L7;
            return;
        L7:
            if ((!Intrinsics.areEqual(r1.getPromotionId(), this.a.g)) == false) goto L9;
            this.a.h = null;
        L9:
            OptCardUtil.b(null, "observe promotion change");
            final BackgroundPresenter r2 = this.a;
            r2.getClass();
            r2.g = r1.getPromotionId();
            ECPromotionImageView r5 = r2.w().b(2131376196).f();
            OptCardUtil.b("image", "bind image");
            r5.setPromotionImageBindConfig(new com.bytedance.android.ec.core.utils.w(new o(r2), new BackgroundPresenter$updateUI$2(r2)));
            r5.setCallerContext(new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_view"));
            ECLiveImageUtils.h(r5, r1, r1.getStatus(), false, false);
            Query r6 = r2.w().b(2131376194);
            r6.g(8);
            ECUISmallPopCard r9 = r1.smallPopCard;
            if (r9 == null) goto L24;
            String r10 = r9.backgroundImgNew;
            if (r10 == null) goto L24;
            if (r10.length() <= 0) goto L16;
            boolean r11 = true;
        L17:
            if (r11 == false) goto L24;
            ECCurrentPromotion.PopBackground r12 = r1.getBackground();
            if (r12 == null) goto L23;
            RitTagTrack r13 = r12.tagTrack;
            if (r13 == null) goto L23;
            r13.setVisibile(true);
        L23:
            r6.g(0);
            ViewExtensionsKt.g(r6.f(), 16.0f, 16.0f, 16.0f, 16.0f);
            r6.g(0);
            SimpleDraweeView r7 = r6.f();
            ImageExtensionsKt.D(r7, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_activity_view"));
            ECLiveImageUtils.j(r7, r10);
            goto L24
        L16:
            r11 = false;
        L24:
            ECCombination r8 = r1.getCombination();
            if (r8 == null) goto L65;
            r1.setShowCombination(true);
            Query r14 = r2.w().b(2131368493);
            r14.g(0);
            CombinationView r15 = (CombinationView) r14.f();
            Intrinsics.checkNotNullParameter(r8, "combination");
            int r16 = com.bytedance.android.ec.core.utils.s.a;
            PopStyle r17 = r8.getPopStyle();
            if (r17 == null) goto L29;
            String r18 = r17.getBackgroundColor();
        L30:
            Integer r20 = com.bytedance.android.ec.core.utils.s.b(r18);
            if (r20 == null) goto L33;
            r15.setBackgroundColor(r20.intValue());
        L33:
            r15.setRadius(UtilityKotlinExtentionsKt.c(6));
            List r21 = r8.getCombinationProducts();
            if (r21 == null) goto L52;
            Iterator<T> r22 = r21.iterator();
            int r110 = 0;
        L37:
            if (r22.hasNext() == false) goto L52;
            T r111 = r22.next();
            int r112 = r110 + 1;
            if (r110 >= 0) goto L41;
            CollectionsKt.throwIndexOverflow();
        L41:
            ECCombinationProduct r113 = (ECCombinationProduct) r111;
            if (r110 < ((ArrayList) r15.b).size()) goto L45;
            List<ECNetImageView> r114 = r15.b;
            ECNetImageView r115 = new ECNetImageView(r15.getContext());
            LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams((int) UtilityKotlinExtentionsKt.c(23), (int) UtilityKotlinExtentionsKt.c(23));
            r116.setMargins((int) UtilityKotlinExtentionsKt.c(2), (int) UtilityKotlinExtentionsKt.c(3), 0, (int) UtilityKotlinExtentionsKt.c(3));
            Unit r3 = Unit.INSTANCE;
            r115.setLayoutParams(r116);
            ((ArrayList) r114).add(r115);
            View r4 = (View) ListProtector.get(r15.b, r110);
            int r23 = r15.c;
            r15.c = r23 + 1;
            r15.addView(r4, r23);
        L45:
            if (((ECNetImageView) ListProtector.get(r15.b, r110)).getVisibility() == 0) goto L47;
            r15.c++;
            ((ECNetImageView) ListProtector.get(r15.b, r110)).setVisibility(0);
        L47:
            ECLiveImageUtils.i((SimpleDraweeView) ListProtector.get(r15.b, r110), r113.getCoverUrl(), 4, 0);
            ECDraweeView r24 = r15.e;
            PopStyle r25 = r8.getPopStyle();
            if (r25 == null) goto L50;
            String r26 = r25.getRightIcon();
        L51:
            com.bytedance.android.ec.core.utils.y.d(r24, r26);
            r110 = r112;
            goto L37
        L50:
            r26 = null;
        L52:
            int r27 = r15.c - r15.d;
            List r28 = r8.getCombinationProducts();
            if (r28 != null) goto L55;
        L66:
            Query r29 = r2.w().b(2131377666);
            if (ECLiveABUtils.INSTANCE.getECOM_TRYON_CLICK_AREA().booleanValue() == false) goto L71;
            View r30 = r29.f();
            ViewGroup.LayoutParams r31 = r30.getLayoutParams();
            if (r31 == null) goto L71;
            r31.width = -2;
            r30.setLayoutParams(r31);
        L71:
            ECPromotionPopHeader r32 = r1.popHeader;
            if (r32 != null) goto L74;
            r29.c();
            return;
        L74:
            if ((!Intrinsics.areEqual(r1.getPromotionId(), r2.h)) == false) goto L93;
            r2.h = r1.getPromotionId();
            int r33 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
            ExplainCardViewModel r34 = r2.e;
            if (r34 == null) goto L80;
            ml.b r35 = r34.getLiveRoomInfo();
            if (r35 == null) goto L80;
            String r36 = r35.roomId();
        L81:
            ExplainCardViewModel r37 = r2.e;
            if (r37 == null) goto L86;
            Function0<Map<String, Map<String, String>>> r38 = r37.getEventPassthroughParams();
            if (r38 == null) goto L86;
            Map r39 = (Map) r38.invoke();
        L87:
            ExplainCardViewModel r40 = r2.e;
            if (r40 == null) goto L90;
            RoomContextController r41 = r40.getRoomContextController();
        L91:
            Intrinsics.checkNotNullParameter(r1, "uiPromotion");
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECCardBannerExplainStatusShowEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.f(r1, ControllerExtensionsKt.c(r41, r36), r39));
            goto L93
        L90:
            r41 = null;
        L86:
            r39 = null;
        L80:
            r36 = null;
        L93:
            if (r29.d() == true) goto L95;
            r29.g(0);
        L95:
            ECNetImageView r42 = r29.b(2131376705).f();
            ECUrlModel r43 = r32.getRightIcon();
            if (r43 != null) goto L98;
            r42.setVisibility(8);
        L99:
            ECNetImageView r44 = r29.b(2131376704).f();
            ECUrlModel r45 = r32.getLeftIcon();
            if (r45 != null) goto L102;
            r44.setVisibility(8);
        L103:
            Query r46 = r29.b(2131391651);
            String r47 = r32.getText();
            if (r47 != null) goto L106;
            r47 = "";
        L106:
            r46.e(r47);
            r29.f().setOnClickListener(new n(r32, r2, r1));
            return;
        L102:
            r44.setVisibility(0);
            ECLiveImageUtils.c(r44, r45, true, null);
            goto L103
        L98:
            r42.setVisibility(0);
            ECLiveImageUtils.c(r42, r43, true, null);
            goto L99
        L55:
            if (r27 <= r28.size()) goto L57;
            boolean r48 = true;
        L58:
            if (r48 == true) goto L61;
            r28 = null;
        L61:
            if (r28 == null) goto L66;
            int r49 = r28.size();
        L63:
            if (r49 >= r27) goto L66;
            r15.c--;
            ((ECNetImageView) ListProtector.get(r15.b, r49)).setVisibility(8);
            r49 = r49 + 1;
            goto L63
        L57:
            r48 = false;
            goto L58
        L29:
            r18 = null;
            goto L30
        L65:
            r1.setShowCombination(false);
            r2.w().b(2131368493).c();
            goto L66
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BackgroundPresenter a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        public b(BackgroundPresenter r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            pk2.d r6 = (pk2.d) r5;
            View r0 = this.a.w().b(2131372721).f();
            if (r6.b != 2) goto L6;
            r0.setPivotX(UtilityKotlinExtentionsKt.c(4));
            r0.setPivotY(UtilityKotlinExtentionsKt.c(4));
            r0.setBackgroundColor(-1);
            r0.animate().scaleX(0.25f).scaleY(0.25f).setDuration(500).setInterpolator(new FastOutSlowInInterpolator()).start();
        L6:
            if (r6.b != 0) goto L9;
            r0.animate().cancel();
            r0.setScaleX(1.0f);
            r0.setScaleY(1.0f);
            r0.setBackgroundColor(0);
            return;
        }
    }

    public BackgroundPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L5;
        r0.getPromotionState().b(r5.getLifecycleOwner(), new a(this, r5));
        r0.getCardExtendInfoState().b(r5.getLifecycleOwner(), new b(this, r5));
    L5:
        com.bytedance.android.ec.core.widget.f.c(w().b(2131368493).f(), null, "bind_key_live_cart_card", new BackgroundPresenter$bind$2(this), 1);
    }
}
