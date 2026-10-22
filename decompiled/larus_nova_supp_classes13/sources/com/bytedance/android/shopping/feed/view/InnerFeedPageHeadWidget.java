package com.bytedance.android.shopping.feed.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.e2;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InnerFeedPageHeadWidget;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedPageHeadWidget extends FrameLayout {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public final ECLottieAnimationView e;
    public final View f;
    public final TextView g;
    public final View h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public SearchSuggestWordResponse n;
    public ProductFeedViewModel o;
    public final FrameLayout p;
    public final ViewGroup q;
    public n83.j r;
    public boolean s;
    public final View t;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ InnerFeedPageHeadWidget a;
        public final /* synthetic */ hl.g b;

        public b(InnerFeedPageHeadWidget r1, hl.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = ld3.c.a;     // Catch: Throwable -> L15
            InnerFeedPageHeadWidget.a(this.a);     // Catch: Exception -> L5 Throwable -> L15
        L7:
            TextView r1 = this.a.g;     // Catch: Throwable -> L15
            if (r1 == null) goto L18;
            int r2 = this.b.a;     // Catch: Throwable -> L15
            if (r2 <= 99) goto L12;
            String r3 = "99+";
        L13:
            r1.setText(r3);     // Catch: Throwable -> L15
            return;
        L12:
            r3 = String.valueOf(r2);     // Catch: Throwable -> L15
            goto L13
        L18:
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InnerFeedPageHeadWidget a;

        public c(InnerFeedPageHeadWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.t;     // Catch: Throwable -> L12
            if (r0 == null) goto L5;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L12
        L6:
            if (r1 == null) goto L8;
            r1.height = com.bytedance.android.shopping.extensions.b.b(70);     // Catch: Throwable -> L12
        L8:
            View r2 = this.a.t;     // Catch: Throwable -> L12
            if (r2 == null) goto L15;
            r2.setLayoutParams(r1);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L5:
            r1 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public final void d() {
        View r0 = this.a;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.d;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        FrameLayout r2 = this.p;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        View r3 = this.f;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        ProductFeedViewModel r4 = this.o;
        String r5 = null;
        if (r4 == null) goto L45;
        InnerFlowPageStyleDTO r6 = r4.getInnerFlowPageStyle();
        if (r6 == null) goto L19;
        PageStyle r7 = r6.getPageStyle();
    L20:
        f(r7, r4);
        if (r7 == null) goto L23;
        Integer r8 = r7.getHeaderMallDisplay();
    L24:
        if (r8 != null) goto L27;
    L31:
        View r9 = this.d;
        if (r9 == null) goto L34;
        r9.setVisibility(8);
    L34:
        if (r7 == null) goto L36;
        Integer r10 = r7.getHeaderCouponDisplay();
    L37:
        if (r10 != null) goto L40;
    L44:
        this.b.setVisibility(8);
        goto L45
    L40:
        if (r10.intValue() != 1) goto L44;
        if (ld3.c.i() == false) goto L44;
        this.b.setVisibility(0);
        goto L45
    L36:
        r10 = null;
        goto L37
    L27:
        if (r8.intValue() != 1) goto L31;
        View r11 = this.d;
        if (r11 == null) goto L34;
        r11.setVisibility(0);
        goto L34
    L23:
        r8 = null;
        goto L24
    L19:
        r7 = null;
    L45:
        ProductFeedViewModel r12 = this.o;
        if (r12 == null) goto L52;
        InnerFlowPageStyleDTO r13 = r12.getInnerFlowPageStyle();
        if (r13 == null) goto L52;
        PageStyle r14 = r13.getPageStyle();
        if (r14 == null) goto L52;
        Integer r15 = r14.getHeaderSearchDisplay();
    L53:
        if (r15 != null) goto L56;
    L58:
        this.a.setVisibility(8);
    L59:
        ProductFeedViewModel r16 = this.o;
        if (r16 == null) goto L62;
        AnchorV3Param r17 = r16.m907getAnchorV3Param();
    L63:
        AnchorV3Api.a.getClass();
        AnchorV3Api r18 = AnchorV3Api.a.a;
        if (r18 != null) goto L66;
        return;
    L66:
        if (r17 == null) goto L68;
        r5 = r17.getProductId();
    L68:
        Observable<SearchSuggestWordResponse> r19 = r18.getSearchSuggestWords("30070", "video_product_inner", "video_product_inner", "video_product_inner", r5);
        if (r19 == null) goto L77;
        Observable r20 = r19.subscribeOn(Schedulers.io());
        if (r20 == null) goto L78;
        Observable r21 = r20.observeOn(AndroidSchedulers.mainThread());
        if (r21 == null) goto L79;
        r21.subscribe(new l(this));
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L62:
        r17 = null;
        goto L63
    L56:
        if (r15.intValue() != 1) goto L58;
        this.a.setVisibility(0);
    L52:
        r15 = null;
        goto L53
    }

    public final void e() {
        int r0 = ld3.c.a;
        View r1 = this.t;
        if (r1 == null) goto L5;
        r1.post(new c(this));
    L5:
        ProductFeedViewModel r2 = this.o;
        Integer r3 = null;
        if (r2 == null) goto L12;
        InnerFlowPageStyleDTO r4 = r2.getInnerFlowPageStyle();
        if (r4 == null) goto L12;
        PageStyle r5 = r4.getPageStyle();
        if (r5 == null) goto L12;
        Integer r6 = r5.getHeaderSearchDisplay();
    L13:
        boolean r7 = false;
        if (r6 != null) goto L17;
    L21:
        View r8 = this.a;
        if (r8 == null) goto L24;
        r8.setVisibility(8);
    L24:
        ProductFeedViewModel r9 = this.o;
        if (r9 == null) goto L31;
        InnerFlowPageStyleDTO r10 = r9.getInnerFlowPageStyle();
        if (r10 == null) goto L31;
        PageStyle r11 = r10.getPageStyle();
        if (r11 == null) goto L31;
        Integer r12 = r11.getHeaderCouponDisplay();
    L32:
        if (r12 != null) goto L35;
    L39:
        this.b.setVisibility(8);
    L40:
        View r13 = this.d;
        if (r13 == null) goto L43;
        r13.setVisibility(8);
    L43:
        FrameLayout r14 = this.p;
        if (r14 == null) goto L46;
        r14.setVisibility(8);
    L46:
        View r15 = this.f;
        if (r15 == null) goto L49;
        r15.setVisibility(8);
    L49:
        ProductFeedViewModel r16 = this.o;
        if (r16 == null) goto L56;
        InnerFlowPageStyleDTO r17 = r16.getInnerFlowPageStyle();
        if (r17 == null) goto L54;
        PageStyle r18 = r17.getPageStyle();
    L55:
        f(r18, r16);
        goto L56
    L54:
        r18 = null;
    L56:
        View r19 = this.f;
        if (r19 != null) goto L59;
        return;
    L59:
        if (r19.getVisibility() != 0) goto L61;
        r7 = true;
    L61:
        if (r7 != true) goto L80;
        ProductFeedViewModel r20 = this.o;
        if (r20 == null) goto L69;
        InnerFlowPageStyleDTO r21 = r20.getInnerFlowPageStyle();
        if (r21 == null) goto L69;
        PageStyle r22 = r21.getPageStyle();
        if (r22 == null) goto L69;
        r3 = r22.getHeaderCartDisplay();
    L69:
        if (r3 != null) goto L72;
        return;
    L72:
        if (r3.intValue() == 1) goto L74;
        return;
    L74:
        if (this.j == true) goto L82;
        this.j = true;
        String r23 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d8100", Boolean.FALSE).withView(this.f).build());
        Context r24 = getContext();
        if (r24 == null) goto L83;
        FeedProductEventTracker.N(FeedProductEventTracker.a, r24, r23, "half_screen", 2);
        return;
    L83:
        return;
    L82:
        return;
    L80:
        return;
    L35:
        if (r12.intValue() != 1) goto L39;
        if (ld3.c.i() == false) goto L39;
        this.b.setVisibility(0);
    L31:
        r12 = null;
        goto L32
    L17:
        if (r6.intValue() != 1) goto L21;
        View r25 = this.a;
        if (r25 == null) goto L24;
        r25.setVisibility(0);
    L12:
        r6 = null;
        goto L13
    }

    public InnerFeedPageHeadWidget(Context r2) {
        this(r2, null);
    }

    public static final void a(InnerFeedPageHeadWidget r6) {
        r6.getClass();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 1.25f});
        r1.addUpdateListener(new j(r6));
        r1.setDuration(100);
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{1.25f, 1.0f});
        r4.addUpdateListener(new k(r6));
        r4.setDuration(100);
        AnimatorSet r7 = new AnimatorSet();
        r7.playSequentially(new Animator[]{r1, r4});
        r7.start();
    }

    public final void c(hl.g r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.a > 0) goto L8;
        TextView r6 = this.g;
        if (r6 == null) goto L24;
        r6.setVisibility(8);
        return;
    L24:
        return;
    L8:
        TextView r0 = this.g;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        if (r5.b == false) goto L16;
        TextView r1 = this.g;
        if (r1 == null) goto L25;
        r1.postDelayed(new b(this, r5), 1200);
        return;
    L25:
        return;
    L16:
        TextView r2 = this.g;
        if (r2 == null) goto L27;
        int r7 = r5.a;
        if (r7 <= 99) goto L21;
        String r8 = "99+";
    L22:
        r2.setText(r8);
        return;
    L21:
        r8 = String.valueOf(r7);
        goto L22
    }

    public final void g(boolean r2) {
        if (r2 == false) goto L8;
        this.h.setVisibility(0);
        if (ld3.d.e(ld3.d.a()) == false) goto L6;
        int r3 = 2131233515;
    L7:
        this.h.setBackgroundResource(r3);
        return;
    L6:
        r3 = 2131233516;
        goto L7
    L8:
        this.h.setVisibility(8);
    }

    public InnerFeedPageHeadWidget(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r7).aU(2131560803, this, true);
        this.t = findViewById(2131377610);
        View r9 = findViewById(2131383140);
        this.a = r9;
        View r10 = findViewById(2131383138);
        this.b = r10;
        this.c = findViewById(2131384575);
        View r1 = findViewById(2131383139);
        this.d = r1;
        ECLottieAnimationView r2 = findViewById(2131383135);
        r2.setImageAssetsFolder("images");
        int r3 = ld3.c.a;
        r2.setAnimation("shoppingcar_2.json");
        Unit r4 = Unit.INSTANCE;
        this.e = r2;
        View r5 = findViewById(2131383136);
        this.f = r5;
        this.g = (TextView) findViewById(2131383134);
        com.bytedance.android.ec.core.widget.f.c(r9, null, "bind_product_flow_card", new AnonymousClass2(this), 1);
        if (ld3.c.i() == false) goto L5;
        com.bytedance.android.ec.core.widget.f.c(r10, null, "bind_product_flow_card", new AnonymousClass3(this), 1);
    L5:
        FrameLayout r11 = (FrameLayout) findViewById(2131383137);
        this.p = r11;
        this.q = (ViewGroup) findViewById(2131368122);
        this.h = findViewById(2131383131);
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L15;
        if (r11 == null) goto L9;
        r11.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131896295));
    L9:
        r9.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131896297));
        if (r1 == null) goto L12;
        r1.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131896296));
    L12:
        if (r5 == null) goto L16;
        r5.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131896294));
        return;
    L16:
        return;
    }

    public final void b(final ProductFeedViewModel r8, ProductFeedContentFragment.b r9) {
        Intrinsics.checkNotNullParameter(r8, "productViewModel");
        Intrinsics.checkNotNullParameter(r9, "closeListener");
        this.o = r8;
        WeakReference<View> r0 = com.bytedance.android.shopping.feed.utils.i.a;
        com.bytedance.android.shopping.feed.utils.i.a = new WeakReference(this.e);
        FrameLayout r1 = this.p;
        if (r1 == null) goto L5;
        r1.setOnClickListener(r9);
    L5:
        AnchorV3Param r10 = r8.m907getAnchorV3Param();
        if (r10 != null) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L13;
        e();
    L14:
        View r12 = this.f;
        if (r12 == null) goto L17;
        com.bytedance.android.ec.core.widget.f.c(r12, null, "bind_product_flow_card", new InnerFeedPageHeadWidget$bind$1(this, r8), 1);
    L17:
        View r13 = this.d;
        if (r13 == null) goto L20;
        com.bytedance.android.ec.core.widget.f.c(r13, null, "bind_product_flow_card", new InnerFeedPageHeadWidget$bind$2(this, r8), 1);
    L20:
        int r14 = ECSdk.a;
        IEShoppingService r15 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r15 == null) goto L57;
        if (r15.shouldShowSaasCouponUrge() == false) goto L57;
        AnchorV3Param r16 = r8.m907getAnchorV3Param();
        if (r16 == null) goto L31;
        PromotionProductStruct r17 = r16.getCurrentPromotion();
        if (r17 == null) goto L31;
        PromotionProductPrivilegesStruct r18 = r17.getPrivilegeInfo();
        if (r18 == null) goto L31;
        PromotionProductCouponsStruct r19 = r18.getCoupons();
    L32:
        Context r2 = getContext();
        if (r19 == null) goto L37;
        InnerFlowCouponExtra r4 = r19.getInnerFlowCouponExtra();
        if (r4 == null) goto L37;
        CouponUrgeInfo r5 = r4.getCouponUrgeInfo();
    L38:
        if (r5 == null) goto L55;
        this.q.setVisibility(0);
        if (this.r != null) goto L48;
        IEShoppingService r3 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r3 == null) goto L44;
        n83.j r6 = r3.newCouponUrgeView(r2, 2);
    L45:
        this.r = r6;
        if (r6 == null) goto L48;
        this.q.addView(r6.i(), new FrameLayout.LayoutParams(-2, -1));
        goto L48
    L44:
        r6 = null;
    L48:
        n83.j r7 = this.r;
        if (r7 == null) goto L57;
        ProductFeedViewModel r20 = this.o;
        if (r20 == null) goto L53;
        AnchorV3Param r21 = r20.m907getAnchorV3Param();
    L54:
        r7.a(r19, r21);
        goto L57
    L53:
        r21 = null;
        goto L54
    L55:
        this.q.setVisibility(8);
    L37:
        r5 = null;
    L31:
        r19 = null;
    L57:
        if (this.l == true) goto L66;
        String r22 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d0205", Boolean.FALSE).withView(this.a).build());
        e2 r23 = new e2();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r24 = com.bytedance.android.ec.core.event.a.b.a.a;
        r23.appendParam("btm_id", r22, r24);
        r23.appendParam(SimilarProductParam.ENTER_FROM, "search_order_center_video_ecom_inflow_half_screen", r24);
        int r25 = com.bytedance.android.shopping.feed.fragment.head.e.a;
        AnchorV3Param r26 = r8.m907getAnchorV3Param();
        if (r26 == null) goto L64;
        AnchorV3PromotionRequestParam r27 = r26.getRequestParam();
        if (r27 == null) goto L64;
        String r28 = r27.getEnterFrom();
        if (r28 == null) goto L64;
    L65:
        r23.appendParam("enter_from_second", com.bytedance.android.shopping.feed.fragment.head.e.a(r28), r24);
        r23.appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        r23.post(null, null);
        this.l = true;
    L64:
        r28 = "";
    L66:
        ProductFeedViewModel r29 = this.o;
        if (r29 == null) goto L73;
        InnerFlowPageStyleDTO r30 = r29.getInnerFlowPageStyle();
        if (r30 == null) goto L73;
        PageStyle r31 = r30.getPageStyle();
        if (r31 == null) goto L73;
        Integer r32 = r31.getHeaderCouponDisplay();
    L74:
        if (r32 != null) goto L77;
        return;
    L77:
        if (r32.intValue() != 1) goto L94;
        ProductFeedViewModel r33 = this.o;
        if (r33 == null) goto L83;
        String r34 = r33.getHalfScreenCouponPageSchema();
        if (r34 == null) goto L83;
    L91:
        com.bytedance.android.shopping.feed.event.q r35 = new com.bytedance.android.shopping.feed.event.q();
        r35.appendParam("btm", "a1.b7365c0472.d493768");
        r35.appendParam("url", r34);
        com.bytedance.android.shopping.feed.event.g.c(r35, getContext(), null);
        return;
    L83:
        ProductFeedViewModel r36 = this.o;
        if (r36 == null) goto L90;
        InnerFlowPageStyleDTO r37 = r36.getInnerFlowPageStyle();
        if (r37 == null) goto L90;
        PageStyle r38 = r37.getPageStyle();
        if (r38 == null) goto L90;
        r34 = r38.getHeaderCouponHalfScreenSchema();
    L90:
        r34 = null;
        goto L91
    L94:
        return;
    L73:
        r32 = null;
        goto L74
    L13:
        d();
        goto L14
    L8:
        if (r10.isFullScreen() != true) goto L10;
        r11 = true;
        goto L11
    }

    public final void f(PageStyle r4, ProductFeedViewModel r5) {
        if (r4 == null) goto L4;
        Integer r0 = r4.getHeaderCartDisplay();
    L6:
        if (r0 != null) goto L9;
    L48:
        View r6 = this.f;
        if (r6 == null) goto L56;
        r6.setVisibility(8);
        return;
    L56:
        return;
    L9:
        if (r0.intValue() != 1) goto L48;
        Integer r1 = r4.getHeaderSearchDisplay();
        if (r1 != null) goto L14;
    L25:
        View r7 = this.f;
        if (r7 == null) goto L28;
        r7.setVisibility(0);
    L28:
        PromotionProductStruct r8 = r5.getPromotion();
        if (r8 == null) goto L33;
        PromotionProductExtraStruct r9 = r8.getExtraInfo();
        if (r9 == null) goto L33;
        int r10 = r9.getCartNum();
    L34:
        if (r10 <= 0) goto L45;
        TextView r11 = this.g;
        if (r11 == null) goto L38;
        r11.setVisibility(0);
    L38:
        TextView r12 = this.g;
        if (r12 != null) goto L41;
        return;
    L41:
        if (r10 <= 99) goto L43;
        String r13 = "99+";
    L44:
        r12.setText(r13);
        return;
    L43:
        r13 = String.valueOf(r10);
        goto L44
    L45:
        TextView r14 = this.g;
        if (r14 == null) goto L54;
        r14.setVisibility(8);
        return;
    L54:
        return;
    L33:
        r10 = 0;
        goto L34
    L14:
        if (r1.intValue() != 3) goto L25;
        Integer r2 = r4.getHeaderSearchDisplay();
        if (r2 == null) goto L48;
        if (r2.intValue() != 3) goto L48;
        Integer r15 = r4.getHeaderMallDisplay();
        if (r15 == null) goto L48;
        if (r15.intValue() != 0) goto L48;
    L4:
        r0 = null;
        goto L6
    }
}
