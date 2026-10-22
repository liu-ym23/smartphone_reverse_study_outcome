package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.bst.api.e;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.h;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.utils.LiveBstReport;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionCardV2 implements com.bytedance.android.livesdk.livecommerce.promotion.card.b, ViewTreeObserver.OnPreDrawListener {
    public final LivePromotionCardArgsV2 a;
    public final QUIManager b;
    public g c;
    public boolean d;
    public k e;
    public final Map<PromotionCardModuleName, Integer> f;
    public final a g;
    public final Rect h;

    public static final class a implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a {
        public final /* synthetic */ LivePromotionCardV2 a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.promotion.card.g c;

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final LivePromotionCardV2$containerAbility$1$eventAction$1 b() {
            return new LivePromotionCardV2$containerAbility$1$eventAction$1(this);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final void e(Action r4) {
            Intrinsics.checkNotNullParameter(r4, "action");
            g r5 = this.a.c;
            if (r5 == null) goto L5;
            LiveRoomParams r6 = (LiveRoomParams) r5.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        L6:
            int r1 = zg2.a.a;
            if (r6 == null) goto L9;
            String r2 = r6.getRoomId();
        L10:
            if (r6 == null) goto L12;
            String r7 = r6.getRoomUniqueKey();
        L13:
            zg2.a.a(r2, r7, Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR, null);
            return;
        L12:
            r7 = null;
            goto L13
        L9:
            r2 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final boolean f(View r3) {
            Intrinsics.checkNotNullParameter(r3, "cartView");
            g r0 = this.a.c;
            if (r0 != null) goto L7;
            return false;
        L7:
            return this.c.b.p(r3, r0.a);
        }

        public a(LivePromotionCardV2 r1, ViewGroup r2, com.bytedance.android.livesdk.livecommerce.promotion.card.g r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final Long d(long r8, long r10, boolean r12, boolean r13) {
            g r0 = this.a.c;
            Long r1 = null;
            if (r0 == null) goto L5;
            ql.a r2 = r0.a;
        L7:
            if ((r2 instanceof ECUIPromotionV2) == true) goto L9;
            r2 = null;
        L9:
            ECUIPromotionV2 r3 = (ECUIPromotionV2) r2;
            if (r3 != null) goto L13;
            return null;
        L13:
            if (r12 == false) goto L20;
            ECPromotionAuctionInfo r14 = r3.getAuctionInfo();
            if (r14 == null) goto L20;
            long r5 = Long.valueOf(r14.getEndTime()).longValue();
            if (r5 <= 0) goto L20;
            return Long.valueOf((r3.getCurrentTime() + r5) - (r8 * ((long) 1000)));
        L20:
            if (r13 == false) goto L30;
            Long r15 = Long.valueOf(r3.getAuctionV2EndTime());
            if (r15.longValue() <= 0) goto L24;
            boolean r16 = true;
        L25:
            if (r16 == false) goto L27;
            r1 = r15;
        L27:
            if (r1 == null) goto L30;
            return Long.valueOf((r3.getCurrentTime() + r1.longValue()) - (r8 * ((long) 1000)));
        L24:
            r16 = false;
        L30:
            long r17 = r3.getCurrentTime();
            long r4 = 1000;
            return Long.valueOf((r17 + (r10 * r4)) - (r8 * r4));
        L5:
            r2 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final void a(String r9, boolean r10, String r11, BtmItemBuilder r12, View r13) {
            Intrinsics.checkNotNullParameter(r9, "clickArea");
            LivePromotionCardV2 r0 = this.a;
            g r2 = r0.c;
            if (r2 == null) goto L6;
            r0.a.a(r2, r9, r10, r11, r12, r13);
            return;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a
        public final void c(String r15, Integer r16, j0 r17, int r18, int r19, cf.a r20, com.bytedance.android.btm.api.model.d r21, il2.a r22) {
            Intrinsics.checkNotNullParameter(r15, "clickArea");
            Intrinsics.checkNotNullParameter(r17, "action");
            LivePromotionCardV2 r1 = this.a;
            g r6 = r1.c;
            if (r6 == null) goto L5;
            jf.d.b.b(r1.a.g, this.b.getContext(), r15, r16, r6, r17, r18, r19, r20, r21, r22, DeviceStatus$DiffDimension.DIFF_LOCATION_MODE);
            return;
        L5:
            if (r22 == null) goto L11;
            il2.a r2 = il2.a.C0145a.a(r22, "container_handle_click", null, false, "promotion_model_null", null, null, 48);
            if (r2 == null) goto L12;
            ((LiveActionTracker) r2).e(false);
            Unit r3 = Unit.INSTANCE;
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final Map<PromotionCardModuleName, IPromotionUIConfig.d> getUIConfig() {
        return this.e.a;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r0 = this.b.p();
        if (r0.getGlobalVisibleRect(this.h) == true) goto L5;
        return true;
    L5:
        if (r0.isShown() == true) goto L7;
        return true;
    L7:
        if (this.d == false) goto L15;
        final g r1 = this.c;
        if (r1 == null) goto L16;
        final ql.a r2 = r1.a;
        this.a.e.c("livesdk_show_product", r2.getUniTag(), new LivePromotionCardV2$onPreDraw$$inlined$also$lambda$1(r1, r2, this));
        return true;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void release() {
        g r0 = this.c;
        if (r0 == null) goto L5;
        this.b.c(kj2.c.class, new h(r0, UpdateType.VIEW_RECYCLED, this.e));
    L5:
        this.a.f.clearDisposable();
        this.b.p().getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final g Y0() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final View F0(PromotionCardModuleName r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Integer r3 = (Integer) ((LinkedHashMap) this.f).get(r2);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        if (r4 != 0) goto L9;
        return this.b.p();
    L9:
        return this.b.p().findViewById(r4);
    L11:
        return this.b.p();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void w2(Map<PromotionCardModuleName, IPromotionUIConfig.d> r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        k r0 = new k(r6);
        this.e = r0;
        g r7 = this.c;
        if (r7 == null) goto L6;
        this.b.c(kj2.c.class, new h(r7, UpdateType.UPDATE_ALL, r0));
        return;
    }

    public LivePromotionCardV2(ViewGroup r8, com.bytedance.android.livesdk.livecommerce.promotion.card.g r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "argument");
        LivePromotionCardArgsV2 r0 = new LivePromotionCardArgsV2(r9, r8.getContext(), new LivePromotionCardV2$args$1(this));
        this.a = r0;
        QUIManager r1 = new QUIManager();
        this.b = r1;
        this.e = (k) IPromotionUIConfig.b.getValue();
        int r2 = UIConfigHelper.a;
        Pair[] r3 = {TuplesKt.to(PromotionCardModuleName.Title, 2131391606), TuplesKt.to(PromotionCardModuleName.ImageAreaModule, 2131377867), TuplesKt.to(PromotionCardModuleName.InfoAreaModule, 2131378719), TuplesKt.to(PromotionCardModuleName.PriceAreaModule, 2131367779), TuplesKt.to(PromotionCardModuleName.ButtonAreaModule, 2131377852), TuplesKt.to(PromotionCardModuleName.BottomModule, 2131377851), TuplesKt.to(PromotionCardModuleName.CloseModule, 2131376518), TuplesKt.to(PromotionCardModuleName.AddCartModule, 2131374918), TuplesKt.to(PromotionCardModuleName.BuyModule, 2131390705), TuplesKt.to(PromotionCardModuleName.CardModule, 2131375664)};
        Intrinsics.checkNotNullParameter(r3, "moduleIdPair");
        LinkedHashMap r4 = new LinkedHashMap();
        MapsKt.putAll(r4, r3);
        r4.put(PromotionCardModuleName.Parent, 0);
        this.f = r4;
        a r5 = new a(this, r8, r9);
        this.g = r5;
        ShoppingAsyncInflater.a r10 = ShoppingAsyncInflater.e;
        Context r6 = r8.getContext();
        r10.getClass();
        r1.l(new kj2.c(ShoppingAsyncInflater.a.a(r6).aU(2131564760, r8, false), r0, r5, r4), r8.getContext(), true);
        r1.p().getViewTreeObserver().addOnPreDrawListener(this);
        this.h = new Rect();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void A1(final g r10, UpdateType r11) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
        Intrinsics.checkNotNullParameter(r11, "updateType");
        this.c = r10;
        this.d = true;
        this.b.c(kj2.c.class, new h(r10, r11, this.e));
        if (r11 == UpdateType.UPDATE_EXPOSE) goto L20;
        final ql.a r5 = r10.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r12 = this.a.a;
        if (r12 == null) goto L7;
        String r13 = r12.a(LivePromotionCardV2$bindNewBst$promotionBtm$1.INSTANCE, r5.getIronIndex());
    L8:
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        final String r4 = r13;
        final e r14 = new e(this.b.p());
        r14.a = r4;
        if (r5.isLottery() == false) goto L13;
        String r0 = "livesdk_unrec_show_product";
    L14:
        r14.b = r0;
        if (r5.isLottery() == false) goto L17;
        String r1 = "live_shopping_lottery";
    L18:
        r14.d = r1;
        r14.c = r5.getUniTag();
        r14.e = 2131370502;
        r14.f = new LiveBstReport(new LivePromotionCardV2$bindNewBst$$inlined$apply$lambda$1(this, r4, r5, r10), new LivePromotionCardV2$bindNewBst$$inlined$apply$lambda$2(r14, this, r4, r5, r10));
        f r15 = f.b;
        com.bytedance.android.bst.api.d r16 = BtmUtilsKt.h(r14);
        r15.getClass();
        f.a(r16);
        return;
    L17:
        r1 = "live_shopping";
        goto L18
    L13:
        r0 = "livesdk_show_product";
        goto L14
    L7:
        r13 = null;
        goto L8
    }
}
