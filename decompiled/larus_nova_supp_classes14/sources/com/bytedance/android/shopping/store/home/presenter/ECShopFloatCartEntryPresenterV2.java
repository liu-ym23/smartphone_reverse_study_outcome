package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.bytedance.android.ec.store.view.ECShopLabelTextView;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopCartInfo;
import com.bytedance.android.shopping.store.home.entity.ShopCartIconType;
import com.bytedance.android.shopping.store.home.entity.ShopCartStatus;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFloatCartEntryPresenterV2 extends ECShopAbsFloatPresenter {
    public final Lazy k;
    public final long l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public Runnable r;
    public ECShopCartInfo s;
    public boolean t;
    public AnimationStatus u;
    public float v;

    public static final class a implements z3 {
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onHidden() {
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void a() {
            ECShopFloatCartEntryPresenterV2 r0 = this.a;
            if (r0.t == true) goto L15;
            ECStoreViewModel r1 = r0.W();
            ECShopCartInfo r2 = this.a.s;
            if (r2 == null) goto L7;
            Map<String, String> r3 = r2.getLogExtra();
        L8:
            Pair<String, String>[] r4 = new Pair[7];
            r4[0] = TuplesKt.to("page_name", "store_page");
            r4[1] = TuplesKt.to("store_type", "shop");
            r4[2] = TuplesKt.to("click_area", "icon");
            r4[3] = TuplesKt.to("author_id", this.a.W().getStoreParam().getStoreAccountParam().getUserId());
            r4[4] = TuplesKt.to("shop_id", this.a.W().getStoreParam().getShopId());
            r4[5] = TuplesKt.to("sec_shop_id", this.a.W().getStoreParam().getSecShopId());
            ShopCartStatus.a r5 = ShopCartStatus.Companion;
            ECShopCartInfo r6 = this.a.s;
            if (r6 == null) goto L13;
            CartCtrlInfo r7 = r6.getCartCtrlInfo();
            if (r7 == null) goto L13;
            Integer r8 = r7.getShopCartStatus();
        L14:
            r5.getClass();
            r4[6] = TuplesKt.to("cart_status", ShopCartStatus.a.a(r8));
            r1.doEventAction("show_cart_entrance", r3, r4);
        L13:
            r8 = null;
            goto L14
        L7:
            r3 = null;
        L15:
            ECShopFloatCartEntryPresenterV2 r9 = this.a;
            r9.t = true;
            Runnable r10 = r9.r;
            if (r10 == null) goto L18;
            r10.run();
        L18:
            this.a.r = null;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onClick() {
            ECStoreViewModel r0 = this.a.W();
            Pair<String, String>[] r1 = new Pair[7];
            r1[0] = TuplesKt.to("page_name", "store_page");
            r1[1] = TuplesKt.to("store_type", "shop");
            r1[2] = TuplesKt.to("click_area", "icon");
            r1[3] = TuplesKt.to("author_id", this.a.W().getStoreParam().getStoreAccountParam().getUserId());
            r1[4] = TuplesKt.to("shop_id", this.a.W().getStoreParam().getShopId());
            r1[5] = TuplesKt.to("sec_shop_id", this.a.W().getStoreParam().getSecShopId());
            ShopCartStatus.a r2 = ShopCartStatus.Companion;
            ECShopCartInfo r3 = this.a.s;
            if (r3 == null) goto L7;
            CartCtrlInfo r4 = r3.getCartCtrlInfo();
            if (r4 == null) goto L7;
            Integer r5 = r4.getShopCartStatus();
        L8:
            r2.getClass();
            r1[6] = TuplesKt.to("cart_status", ShopCartStatus.a.a(r5));
            r0.doEventAction("click_cart_entrance", r1);
            return;
        L7:
            r5 = null;
            goto L8
        }

        public a(ECShopFloatCartEntryPresenterV2 r1) {
            this.a = r1;
        }
    }

    public static final class b implements a4 {
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Integer> a() {
            return this.a.W().getScrollState();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Pair<Integer, Integer>> b() {
            return this.a.W().getSelectedTabLocation();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<Float> c() {
            return this.a.W().getCollapseFactor();
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final jm.a<StoreCartEntryConfig> d() {
            return this.a.W().getCartEntryConfig();
        }

        public b(ECShopFloatCartEntryPresenterV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final void e(LottieAnimationViewWithPlayCount r3) {
            this.a.W().getCartAnimationView().setValue(new WeakReference(r3));
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.a4
        public final void f(View r3) {
            this.a.W().getCartView().setValue(new WeakReference(r3));
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

        public c(ECShopFloatCartEntryPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            StoreCartEntryConfig r6 = (StoreCartEntryConfig) r5;
            ECShopFloatCartEntryPresenterV2 r0 = this.a;
            boolean r1 = false;
            if (r6 == null) goto L13;
            String r2 = r6.getJumpUrl();
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L13;
            r1 = true;
            goto L13
        L7:
            if (StringsKt.isBlank(r2) == true) goto L10;
            r3 = false;
        L13:
            r0.h = Boolean.valueOf(r1);
            Boolean r4 = this.a.h;
            Intrinsics.checkNotNull(r4);
            if (r4.booleanValue() == false) goto L17;
            this.a.Q();
            this.a.y().setOnClickListener(new z(this, r6));
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

        public d(ECShopFloatCartEntryPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            ECShopCartInfo r14 = (ECShopCartInfo) r13;
            this.a.s = r14;
            if (r14 == null) goto L7;
            Map<String, String> r1 = r14.getBizExtra();
            if (r1 == null) goto L7;
            String r2 = r1.get("icon_type");
        L9:
            if (Intrinsics.areEqual(r2, ShopCartIconType.RED.getType()) == false) goto L15;
            if (this.a.W().isBrandShopUpgrade() == false) goto L13;
            this.a.U().setAnimation("shop_cart_animation_all_red_new.json");
        L18:
            this.a.y().setOnClickListener(new b0(this, r14));
            Gson r3 = new Gson();     // Catch: Exception -> L27
            CartCtrlInfo r4 = r14.getCartCtrlInfo();     // Catch: Exception -> L27
            if (r4 == null) goto L22;
            String r5 = r4.getNativeStorage();     // Catch: Exception -> L27
        L23:
            ShopRemoteStruct r6 = (ShopRemoteStruct) r3.fromJson(r5, ShopRemoteStruct.class);     // Catch: Exception -> L27
            if (r6 == null) goto L29;
            ECShopDataStorageForRemote.b.c(r6.getActionType(), r6.getSecShopId(), r6.getUserId(), r6.getBusinessId(), r6.getData());     // Catch: Exception -> L27
            this.a.W().getStoreParam().updateSqlClientData();     // Catch: Exception -> L27
        L29:
            CartCtrlInfo r7 = r14.getCartCtrlInfo();
            if (r7 == null) goto L32;
            Integer r8 = r7.getShopCartStatus();
        L33:
            int r9 = ShopCartStatus.BOTTOM.getStatus();
            if (r8 != null) goto L37;
        L39:
            int r10 = ShopCartStatus.SLIDE.getStatus();
            if (r8 != null) goto L43;
        L50:
            ShopCartStatus.ICON.getStatus();
            if (r8 == null) goto L61;
            r8.intValue();
            return;
        L61:
            return;
        L43:
            if (r8.intValue() != r10) goto L50;
            this.a.V().setVisibility(8);
            this.a.V().a(r14.getBottomLabel(), true);
            com.bytedance.android.ec.core.imagex.h0.d((SimpleDraweeView) this.a.o.getValue(), r14.getProductImg(), this.a.W().getImageCallerContext(), null, null, null, null, 120);
            ((ECShopLabelTextView) this.a.p.getValue()).a(r14.getSlideLabel(), false);
            ECShopFloatCartEntryPresenterV2 r11 = this.a;
            SimpleDraweeView r12 = (SimpleDraweeView) r11.o.getValue();
            Intrinsics.checkNotNullParameter(r12, "$this$unSpecifiedWidth");
            r12.measure(View.MeasureSpec.makeMeasureSpec(0, 0), 0);
            float r15 = r12.getMeasuredWidth();
            ECShopLabelTextView r16 = (ECShopLabelTextView) this.a.p.getValue();
            Intrinsics.checkNotNullParameter(r16, "$this$unSpecifiedWidth");
            r16.measure(View.MeasureSpec.makeMeasureSpec(0, 0), 0);
            r11.v = ((r15 + r16.getMeasuredWidth()) + com.bytedance.android.shopping.store.utils.o.a(63)) + com.bytedance.android.shopping.store.utils.o.a(26);
            ECShopFloatCartEntryPresenterV2 r17 = this.a;
            if (r17.u == AnimationStatus.RUNNING) goto L60;
            a0 r18 = new a0(this, r14);
            r17.r = r18;
            if (r17.t == false) goto L58;
            r18.run();
            this.a.r = null;
            return;
        L58:
            return;
        L60:
            return;
        L37:
            if (r8.intValue() != r9) goto L39;
            this.a.V().a(r14.getBottomLabel(), true);
            this.a.V().setVisibility(0);
            return;
        L32:
            r8 = null;
            goto L33
        L22:
            r5 = null;
        L27:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            goto L29
        L13:
            this.a.U().setAnimation("shop_cart_animation_all_red.json");
            goto L18
        L15:
            if (this.a.W().isBrandShopUpgrade() == false) goto L17;
            this.a.U().setAnimation("shop_cart_animation_black_red_new.json");
            goto L18
        L17:
            this.a.U().setAnimation("shop_cart_animation_black_red.json");
        L7:
            r2 = null;
            goto L9
        }
    }

    public final LottieAnimationViewWithPlayCount U() {
        return (LottieAnimationViewWithPlayCount) this.m.getValue();
    }

    public final ECShopLabelTextView V() {
        return (ECShopLabelTextView) this.n.getValue();
    }

    public final ECStoreViewModel W() {
        return (ECStoreViewModel) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final z3 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final a4 F() {
        return new b(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final boolean D() {
        uj3.j r0 = W().getCurrentTab();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.i() == true) goto L10;
        if (r0.g() == true) goto L10;
        return false;
    L10:
        if (r0.d != TabEnum.MOMENTS_TAB.getType()) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r1 = false;
        goto L13
    }

    public ECShopFloatCartEntryPresenterV2(final Fragment r3) {
        super(r3);
        this.k = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$viewModel$2(this, r3));
        this.l = 200;
        this.m = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartAnimation$2(this));
        this.n = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartBottomDesc$2(this));
        this.o = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$productImg$2(this));
        this.p = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartSlideDesc$2(this));
        this.q = LazyKt.lazy(new ECShopFloatCartEntryPresenterV2$cartSlideWrapper$2(this));
        this.u = AnimationStatus.DEFAULT;
        this.v = com.bytedance.android.ec.core.utils.q.a(20);
    }

    public static final void S(ECShopFloatCartEntryPresenterV2 r5) {
        r5.V().setVisibility(0);
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(r5.V(), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f})});
        r6.setInterpolator(new com.bytedance.android.ec.hybrid.tools.g(2.366f));
        r6.setDuration(343);
        r6.start();
    }

    public static final View T(ECShopFloatCartEntryPresenterV2 r0) {
        return (View) r0.q.getValue();
    }

    public final void A(QModel r4) {
        jm.a<StoreCartEntryConfig> r5 = G().d();
        if (r5 == null) goto L5;
        r5.a(I(), new c(this), false);
    L5:
        W().getCartInfo().a(I(), new d(this), false);
        K();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final void O(int r2) {
        if (r2 != 0) goto L4;
        G().f(y());
        G().e(U());
        return;
    L4:
        G().f(null);
        G().e(null);
    }
}
