package com.bytedance.android.shopping.product.flow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3PreSecKillLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3PresaleDepositLayout;
import com.bytedance.android.shopping.anchorv3.repository.AnchorV3Repository;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.utils.v;
import com.bytedance.android.shopping.anchorv4.widgets.ActivityBarShopLayout;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.monitor.d;
import com.bytedance.android.shopping.product.flow.banner.BannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.android.shopping.product.flow.indicator.DefaultBannerIndicatorView;
import com.bytedance.android.shopping.product.flow.indicator.MediaBannerIndicatorView;
import com.bytedance.android.shopping.product.flow.view.bottom.CollectionAbilityView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardAbilityBarView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardCartView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardPriceAndSalesView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.jedi.model.combine.Combine;
import com.bytedance.jedi.model.combine.CombineExtensionsKt;
import com.bytedance.jedi.model.combine.Strategies;
import d63.l;
import d63.m;
import d63.q;
import d63.r;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yg3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/ECBaseProductFlowCard;", "Lcom/bytedance/android/shopping/product/flow/ECAbsProductFlowCard;", "Lyg3/e;", "Landroid/graphics/drawable/Drawable;", "background", "", "setBackgroundCompat", "Lcom/bytedance/android/shopping/anchorv4/widgets/ActivityBarShopLayout;", "m", "Lcom/bytedance/android/shopping/anchorv4/widgets/ActivityBarShopLayout;", "getActivityBarView", "()Lcom/bytedance/android/shopping/anchorv4/widgets/ActivityBarShopLayout;", "setActivityBarView", "(Lcom/bytedance/android/shopping/anchorv4/widgets/ActivityBarShopLayout;)V", "activityBarView", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "n", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuRestoreState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "setSkuRestoreState", "(Lcom/bytedance/android/ec/model/sku/SkuRestoreState;)V", "skuRestoreState", "Lcom/bytedance/android/shopping/product/flow/view/bottom/CollectionAbilityView;", "o", "Lcom/bytedance/android/shopping/product/flow/view/bottom/CollectionAbilityView;", "getCollectionAbilityView", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/CollectionAbilityView;", "setCollectionAbilityView", "(Lcom/bytedance/android/shopping/product/flow/view/bottom/CollectionAbilityView;)V", "collectionAbilityView", "Lbh3/b;", "p", "Lbh3/b;", "getPriceAndActivityStyleAdapter", "()Lbh3/b;", "setPriceAndActivityStyleAdapter", "(Lbh3/b;)V", "priceAndActivityStyleAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECBaseProductFlowCard extends ECAbsProductFlowCard implements e {
    public PromotionProductStruct k;
    public boolean l;
    public ActivityBarShopLayout m;
    public SkuRestoreState n;
    public CollectionAbilityView o;
    public bh3.b p;

    public ECBaseProductFlowCard(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECBaseProductFlowCard(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F() {
        int r0 = zg3.b.a;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter("can't jump to good detail due to link is null or empty", "msg");
        int r2 = zg3.a.a;
        Toast.makeText(r1, "can't jump to good detail due to link is null or empty", 0).show();
    }

    public final void G() {
        PromotionProductStruct r1 = this.k;
        if (r1 == null) goto L21;
        PromotionProductBaseStruct r2 = r1.getBaseInfo();
        if (r2 == null) goto L22;
        String r3 = r2.getPromotionId();
        if (r3 == null) goto L23;
        AnchorV3PromotionRequestParam r4 = new AnchorV3PromotionRequestParam(CollectionsKt.listOf(r3), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, null, null, null, null, null, null, null, -2, 2047, null);
        AnchorV3Repository r5 = AnchorV3Repository.h;
        PromotionProductStruct r6 = this.k;
        if (r6 == null) goto L14;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L14;
        String r8 = r7.getPromotionId();
    L15:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "requestParam");
        com.bytedance.android.shopping.anchorv3.repository.c r9 = AnchorV3Repository.b;
        if (r9.i(r4) == null) goto L18;
        d r10 = d.h;
        Observable r11 = ((com.bytedance.android.shopping.anchorv3.repository.api.c) AnchorV3Repository.c.getValue()).a(r4).subscribeOn(Schedulers.io()).map(new com.bytedance.android.shopping.anchorv3.repository.a(r4, r8));
    L19:
        r11.observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r3));
        return;
    L18:
        d r12 = d.h;
        Combine r13 = CombineExtensionsKt.a((com.bytedance.android.shopping.anchorv3.repository.api.c) AnchorV3Repository.c.getValue(), r9);
        Strategies.a.getClass();
        Function2 r14 = Strategies.a();
        Intrinsics.checkNotNullParameter(r14, "strategy");
        r11 = new Combine.applyStrategy.1(r14, r13).a(r4).subscribeOn(Schedulers.io()).map(new com.bytedance.android.shopping.anchorv3.repository.b(r4, r8));
    L14:
        r8 = null;
        goto L15
    L23:
        return;
    L22:
        return;
    }

    @Override // yg3.e
    public final void g() {
        F();
    }

    public final ActivityBarShopLayout getActivityBarView() {
        return this.m;
    }

    public final CollectionAbilityView getCollectionAbilityView() {
        return this.o;
    }

    public final bh3.b getPriceAndActivityStyleAdapter() {
        return this.p;
    }

    public final SkuRestoreState getSkuRestoreState() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBackgroundCompat(Drawable r1) {
        setBackground(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard
    public final void B(ProductFlowCardBuyButton r15) {
        Intrinsics.checkNotNullParameter(r15, "buyButton");
        PromotionProductStruct r16 = this.k;
        if (r16 == null) goto L19;
        ActivityVO r17 = f53.a.c(r16);
        PromotionProductStruct r0 = this.k;
        if (r0 == null) goto L20;
        q r1 = r.a(r0);
        if (r17.getActivityType() != 5) goto L9;
        return;
    L9:
        if (r17.getActivityType() != 4) goto L11;
        return;
    L11:
        if (r1.a == true) goto L13;
    L14:
        int r18 = com.bytedance.android.shopping.anchorv3.utils.purchase.a.a;
        FragmentActivity r19 = getContext();
        if (r19 == null) goto L18;
        com.bytedance.android.shopping.anchorv3.utils.purchase.a.e(r19, getECOrderTrackerData(), new ProductPurchaseInfo(false, this.k, "product_flow_page", new ECBaseProductFlowCard$placeOrder$1(this), new ECBaseProductFlowCard$placeOrder$2(this), new ECBaseProductFlowCard$placeOrder$3(this), this.n, new ECBaseProductFlowCard$placeOrder$4(this), null, 257, null), null, null, null, null, null, 2040);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L13:
        if (r17.getActivityType() == 13) goto L14;
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard
    public final void C(ProductFlowCardCartView r60) {
        Intrinsics.checkNotNullParameter(r60, "cartView");
        PromotionProductStruct r1 = this.k;
        if (r1 == null) goto L20;
        ActivityVO r2 = f53.a.c(r1);
        PromotionProductStruct r4 = this.k;
        if (r4 == null) goto L7;
        AnchorV3Param r3 = new AnchorV3Param(new AnchorV3PromotionRequestParam(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, null, null, null, null, null, null, null, -1, 2047, null), r4, null, null, null, null, null, null, null, null, null, JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("ecom_scene_id", "1003")}).toString(), null, null, null, null, false, null, null, 0, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, -2052, 524287, null);
    L8:
        int r5 = v.a;
        Context r6 = getContext();
        FragmentActivity r7 = getContext();
        if (r7 == null) goto L19;
        FragmentManager r8 = r7.getSupportFragmentManager();
        boolean r9 = true;
        if (r2.getActivityType() == 1) goto L13;
    L15:
        r9 = false;
    L16:
        v.b(r6, r8, r9, this.k, r3);
        return;
    L13:
        if (r2.isOnActivity() == false) goto L15;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard
    public final void D(ProductFlowCardPriceAndSalesView r2) {
        Intrinsics.checkNotNullParameter(r2, "priceAndSalesView");
        F();
    }

    @Override // com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard
    public final void E(ProductFlowCardTitleView r2) {
        Intrinsics.checkNotNullParameter(r2, "titleView");
        F();
    }

    public final void setActivityBarView(ActivityBarShopLayout r1) {
        this.m = r1;
    }

    public final void setCollectionAbilityView(CollectionAbilityView r1) {
        this.o = r1;
    }

    public final void setPriceAndActivityStyleAdapter(bh3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void setSkuRestoreState(SkuRestoreState r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard
    public final void y(BannerView r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerBannerView");
        F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.product.flow.ECAbsProductFlowCard, com.bytedance.android.shopping.product.flow.ECBaseProductFlowCard, yg3.e] */
    /* JADX WARN: Type inference failed for: r11v75, types: [android.view.View, com.bytedance.android.shopping.anchorv4.widgets.ActivityBarShopLayout] */
    /* JADX WARN: Type inference failed for: r11v89 */
    /* JADX WARN: Type inference failed for: r11v90 */
    /* JADX WARN: Type inference failed for: r3v32, types: [com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView] */
    public ECBaseProductFlowCard(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.p = new bh3.a();
        AttributeSet r14 = null;
        int r0 = 6;
        int r1 = 0;
        DefaultBannerIndicatorView r15 = new DefaultBannerIndicatorView(r11, r14, r0, r1);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r2.gravity = 81;
        r2.bottomMargin = com.bytedance.android.shopping.extensions.b.b(14);
        r15.setLayoutParams(r2);
        r15.setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(1462315305);
        r6.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(10));
        Unit r7 = Unit.INSTANCE;
        setBackgroundCompat(r6);
        MediaBannerIndicatorView r8 = new MediaBannerIndicatorView(r11, r14, r0, r1);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -2);
        r16.gravity = 81;
        r16.bottomMargin = com.bytedance.android.shopping.extensions.b.b(14);
        r8.setLayoutParams(r16);
        getBannerView().setIndicator(r15);
        getBannerView().setOnOverScrollListener(this);
        int r17 = ch3.a.a;
        ProductFlowCardAbilityBarView.a(getAbilityBarView(), ch3.a.a(getContext(), 2131248163, j.c(2131913967)));
        CollectionAbilityView r18 = new CollectionAbilityView(getContext(), null, 6, 0);
        r18.setTag(2131896762, "collect");
        this.o = r18;
        ProductFlowCardAbilityBarView.a(getAbilityBarView(), r18);
        CollectionAbilityView r19 = this.o;
        if (r19 == null) goto L5;
        r19.setOnClickListener(new ECBaseProductFlowCard$initAbilityView$4(this));
    L5:
        PromotionProductStruct r110 = this.k;
        if (r110 == null) goto L8;
        l r111 = m.b(r110);
    L9:
        if (r111 == null) goto L32;
        List r3 = r111.b;
        if (r3 == null) goto L32;
        List<? extends ECUrlModel> r4 = f63.b.a(r3);
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        PromotionProductStruct r9 = this.k;
        if (r9 == null) goto L19;
        PromotionProductExtraStruct r10 = r9.getExtraInfo();
        if (r10 == null) goto L19;
        if (r10.getProductVideo() == null) goto L19;
        r5.element = new a(r4);
    L19:
        BannerView r20 = getBannerView();
        Object r21 = r20.g;
        if ((r21 instanceof View) == true) goto L22;
        r21 = null;
    L22:
        View r22 = (View) r21;
        if (r22 == null) goto L26;
        r20.removeView(r22);
    L26:
        if (((yg3.b) r5.element) == null) goto L28;
        getBannerView().setIndicator(r8);
    L29:
        BannerView r112 = getBannerView();
        ECUrlModel r113 = r111.h;
        yg3.b r23 = (yg3.b) r5.element;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r4, "list");
        r112.d = r4;
        BannerAdapter r24 = r112.b;
        r24.a = r4;
        r24.b = r113;
        r24.d = r23;
        r112.a.scrollToPosition(0);
        r112.b.notifyDataSetChanged();
        yg3.c r114 = r112.g;
        if (r114 == null) goto L32;
        r114.a(0, r112.b.getItemCount() - 1);
        goto L32
    L28:
        getBannerView().setIndicator(r15);
    L32:
        getProductTopActivityContainer().removeAllViews();
        getProductBottomActivityContainer().removeAllViews();
        PromotionProductStruct r115 = this.k;
        if (r115 == null) goto L127;
        ActivityVO r25 = f53.a.c(r115);
        PromotionProductStruct r26 = this.k;
        if (r26 == null) goto L127;
        bh3.b r116 = this.p;
        Intrinsics.checkNotNull(null);
        int r117 = r116.a();
        int r27 = bh3.c.a;
        if (r117 != 0) goto L59;
        WeakHashMap<Context, HashMap<String, Queue<WeakReference<View>>>> r118 = ah3.a.a;
        HashMap<String, Queue<WeakReference<View>>> r119 = ah3.a.a.get(getContext());
        if (r119 == null) goto L46;
        Queue<WeakReference<View>> r120 = r119.get(ActivityBarShopLayout.class.getName());
        if (r120 == null) goto L46;
        WeakReference<View> r121 = r120.poll();
        if (r121 == null) goto L46;
        Object r122 = (View) r121.get();
    L48:
        if ((r122 instanceof ActivityBarShopLayout) == true) goto L50;
        r122 = null;
    L50:
        ActivityBarShopLayout r123 = (ActivityBarShopLayout) r122;
        ?? r124 = r123;
        if (r123 != null) goto L53;
        r124 = new ActivityBarShopLayout(getContext(), null, 6, 0);
    L53:
        PromotionProductBaseStruct r28 = r26.getBaseInfo();
        if (r28 == null) goto L56;
        Long r29 = r28.getSales();
    L57:
        r124.f(r25, r29, false, null, r26, true);
        f.b(getProductTopActivityContainer(), r124);
        this.m = r124;
        this.l = true;
        goto L127
    L56:
        r29 = null;
    L46:
        r122 = null;
        goto L48
    L59:
        if (r25.isPreSeckillActivity() == false) goto L65;
        PromotionProductBaseStruct r125 = r26.getBaseInfo();
        if (r125 != null) goto L63;
    L64:
        boolean r126 = true;
    L66:
        boolean r30 = r25.isDepositActivity();
        if (r126 == false) goto L83;
        WeakHashMap<Context, HashMap<String, Queue<WeakReference<View>>>> r127 = ah3.a.a;
        HashMap<String, Queue<WeakReference<View>>> r128 = ah3.a.a.get(getContext());
        if (r128 == null) goto L75;
        Queue<WeakReference<View>> r129 = r128.get(AnchorV3PreSecKillLayout.class.getName());
        if (r129 == null) goto L75;
        WeakReference<View> r130 = r129.poll();
        if (r130 == null) goto L75;
        View r131 = r130.get();
    L77:
        if ((r131 instanceof AnchorV3PreSecKillLayout) == true) goto L79;
        r131 = null;
    L79:
        AnchorV3PreSecKillLayout r132 = (AnchorV3PreSecKillLayout) r131;
        if (r132 != null) goto L82;
        r132 = new AnchorV3PreSecKillLayout(getContext(), null, 6, 0);
    L82:
        r132.setSecKillInfo(r26);
    L119:
        if (r132 == null) goto L125;
        f.b(getProductBottomActivityContainer(), r132);
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L124;
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        r134.leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r134.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        goto L125
    L124:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L125:
        this.l = false;
    L75:
        r131 = null;
        goto L77
    L83:
        if (r30 == false) goto L118;
        WeakHashMap<Context, HashMap<String, Queue<WeakReference<View>>>> r135 = ah3.a.a;
        HashMap<String, Queue<WeakReference<View>>> r136 = ah3.a.a.get(getContext());
        if (r136 == null) goto L91;
        Queue<WeakReference<View>> r137 = r136.get(AnchorV3PresaleDepositLayout.class.getName());
        if (r137 == null) goto L91;
        WeakReference<View> r138 = r137.poll();
        if (r138 == null) goto L91;
        AnchorV3PreSecKillLayout r139 = (View) r138.get();
    L93:
        if ((r139 instanceof AnchorV3PresaleDepositLayout) == true) goto L95;
        r139 = null;
    L95:
        r132 = (AnchorV3PresaleDepositLayout) r139;
        if (r132 != null) goto L98;
        r132 = new AnchorV3PresaleDepositLayout(getContext(), null, 6, 0);
    L98:
        PromotionProductPrivilegesStruct r31 = r26.getPrivilegeInfo();
        if (r31 == null) goto L119;
        List r32 = r31.getBanners();
        if (r32 == null) goto L119;
        Iterator r33 = r32.iterator();
    L104:
        if (r33.hasNext() == false) goto L114;
        Object r34 = r33.next();
        Integer r35 = ((PromotionProductBannerStruct) r34).getBannerType();
        if (r35 != null) goto L109;
    L111:
        boolean r36 = false;
    L112:
        if (r36 == false) goto L104;
    L115:
        PromotionProductBannerStruct r37 = (PromotionProductBannerStruct) r34;
        if (r37 == null) goto L119;
        AnchorV3PresaleDepositLayout.b(r132, r37);
        goto L119
    L109:
        if (r35.intValue() != 4) goto L111;
        r36 = true;
        goto L112
    L114:
        r34 = null;
    L91:
        r139 = null;
        goto L93
    L118:
        r132 = null;
        goto L119
    L63:
        if (r125.isSoldOut() != true) goto L64;
    L65:
        r126 = false;
    L127:
        if (this.l == false) goto L129;
        getPriceAndSalesView().setVisibility(8);
    L137:
        ProductFlowCardTitleView r140 = getProductTitleView();
        PromotionProductStruct r141 = this.k;
        if (r141 == null) goto L142;
        PromotionProductBaseStruct r142 = r141.getBaseInfo();
        if (r142 == null) goto L142;
        String r143 = r142.getTitle();
    L143:
        PromotionProductStruct r38 = this.k;
        if (r38 == null) goto L152;
        PromotionProductPrivilegesStruct r39 = r38.getPrivilegeInfo();
        if (r39 == null) goto L152;
        PromotionProductActivitiesStruct r40 = r39.getActivities();
        if (r40 == null) goto L152;
        PromotionMarketFloor r41 = r40.getPlatformTextActivity();
        if (r41 == null) goto L152;
        ECUrlModel r42 = r41.getIcon();
    L153:
        int r43 = ProductFlowCardTitleView.d;
        r140.a(r143, r42, null);
        return;
    L152:
        r42 = null;
    L142:
        r143 = null;
        goto L143
    L129:
        getPriceAndSalesView().setVisibility(0);
        PromotionProductStruct r144 = this.k;
        if (r144 == null) goto L137;
        bh3.b r44 = this.p;
        Intrinsics.checkNotNull(null);
        int r45 = r44.a();
        int r46 = bh3.c.a;
        if (r45 != 2) goto L134;
        getPriceAndSalesView().setStyle(0);
    L136:
        getPriceAndSalesView().a(r144);
        goto L137
    L134:
        if (r45 != 1) goto L136;
        getPriceAndSalesView().setStyle(1);
        goto L136
    L8:
        r111 = null;
        goto L9
    }

    public /* synthetic */ ECBaseProductFlowCard(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
