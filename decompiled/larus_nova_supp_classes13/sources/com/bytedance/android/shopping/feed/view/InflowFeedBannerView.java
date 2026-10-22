package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.detail.utils.BannerRenderHelper;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3CommonBannerView;
import com.bytedance.android.shopping.inflow.detail.widget.AnchorV3ProductBrandView;
import com.bytedance.android.shopping.inflow.detail.widget.AnchorV3ProductJidiBannerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedBannerView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedBannerView extends LinearLayout implements c {

    public static final class a {
    }

    static {
    }

    public InflowFeedBannerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowFeedBannerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void b(final PromotionProductStruct r11, final AnchorV3Param r12) {
        removeAllViews();
        PromotionProductPrivilegesStruct r0 = r11.getPrivilegeInfo();
        if (r0 == null) goto L95;
        List r1 = r0.getBanners();
        if (r1 == null) goto L100;
        PromotionProductBannerStruct r2 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L101;
        Integer r3 = r2.getBannerType();
        boolean r4 = true;
        if (r3 == null) goto L41;
        if (r3.intValue() != 2) goto L41;
        HashMap<String, Queue<View>> r13 = i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L39;
        Queue<View> r14 = i.a.get(AnchorV3ProductJidiBannerView.class.getName());
        if (r14 == null) goto L21;
        View r15 = r14.poll();
    L23:
        if ((r15 instanceof AnchorV3ProductJidiBannerView) == true) goto L25;
        r15 = null;
    L25:
        AnchorV3ProductJidiBannerView r16 = (AnchorV3ProductJidiBannerView) r15;
        if (r16 != null) goto L28;
        r16 = new AnchorV3ProductJidiBannerView(getContext(), null, 6, 0);
    L28:
        Intrinsics.checkNotNullParameter(r11, "promotion");
        r16.setVisibility(0);
        r16.b.setText(r2.getContent());
        ECUrlModel r17 = r2.getIcon();
        if (r17 == null) goto L37;
        ViewGroup.LayoutParams r5 = r16.a.getLayoutParams();
        if ((r5 instanceof LinearLayout.LayoutParams) == true) goto L33;
        r5 = null;
    L33:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r6 == null) goto L36;
        r6.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r17.getWidth()));
        r6.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r17.getHeight()));
        r16.a.setLayoutParams(r6);
    L36:
        y.a(r16.a, r17);
    L37:
        r2.getUrl();
        r16.getClass();
        r16.setOnClickListener(null);
        r16.c.setVisibility(8);
        addView(r16);
        return;
    L21:
        r15 = null;
        goto L23
    L39:
        throw new IllegalStateException("only main thread can touch");
    L41:
        if (r3 != null) goto L44;
    L58:
        if (r3 != null) goto L61;
    L77:
        HashMap<String, Queue<View>> r7 = i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L80;
        boolean r8 = true;
    L81:
        if (r8 == false) goto L94;
        Queue<View> r9 = i.a.get(AnchorV3CommonBannerView.class.getName());
        if (r9 == null) goto L85;
        View r10 = r9.poll();
    L87:
        if ((r10 instanceof AnchorV3CommonBannerView) == true) goto L89;
        r10 = null;
    L89:
        View r18 = (AnchorV3CommonBannerView) r10;
        if (r18 != null) goto L92;
        r18 = new AnchorV3CommonBannerView(getContext(), null, 6, 0);
    L92:
        Function1<String, Unit> r19 = new InflowFeedBannerView$addBannerView$1(this, r11, r12);
        Resources r110 = Resources.getSystem();
        AnchorV3CommonBannerView.b(r18, r2, r19, true, MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()))), false, 32);
        addView(r18);
        return;
    L85:
        r10 = null;
        goto L87
    L94:
        throw new IllegalStateException("only main thread can touch");
    L80:
        r8 = false;
        goto L81
    L61:
        if (r3.intValue() != 133) goto L77;
        int r111 = DouyinFlagshipBannerView.d;
        Context r112 = getContext();
        Intrinsics.checkNotNullParameter(r112, "context");
        if (ld3.b.a() == false) goto L65;
        Map r113 = ShoppingAsyncCacheInflater.d;
        DouyinFlagshipBannerView r114 = (DouyinFlagshipBannerView) ShoppingAsyncCacheInflater.a.a(r112).b("ec_douyin_flagship_banner_view", new com.bytedance.android.shopping.feed.view.a());
    L66:
        Intrinsics.checkNotNullParameter(r2, "banner");
        y.a(r114.a, r2.getIcon());
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L69
        r114.c.setBackgroundColor(Color.parseColor(r2.getDrawableRightColor()));     // Catch: Throwable -> L69
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        r114.b.setText(r2.getContent());
        r114.b.setTextColor(Color.parseColor(r2.getTextColor()));     // Catch: Throwable -> L74
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        addView(r114);
        return;
    L74:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L69:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L71
    L65:
        r114 = new DouyinFlagshipBannerView(r112, null, 6, 0);
        goto L66
    L44:
        if (r3.intValue() != 1) goto L58;
        int r116 = AnchorV3ProductBrandView.f;
        Context r117 = getContext();
        Intrinsics.checkNotNullParameter(r117, "context");
        if (ld3.b.a() == false) goto L48;
        Map r22 = ShoppingAsyncCacheInflater.d;
        AnchorV3ProductBrandView r118 = (AnchorV3ProductBrandView) ShoppingAsyncCacheInflater.a.a(r117).b("ec_commerce_anchor_v3_brand_layout", new com.bytedance.android.shopping.inflow.detail.widget.a());
    L49:
        r118.setPageType("half_screen");
        r118.e = true;
        r118.c = r11;
        r118.setVisibility(0);
        r118.b.setText(r2.getContent());
        BannerRenderHelper.a(r118.b, r2, false);
        ECUrlModel r119 = r2.getIcon();
        if (r119 != null) goto L52;
        r118.a.setVisibility(8);
    L57:
        addView(r118);
        return;
    L52:
        if (ECAppInfoService.e.f() == false) goto L54;
        r118.a.setAdjustMode(1);
        ViewGroup.LayoutParams r23 = r118.a.getLayoutParams();
        Resources r24 = Resources.getSystem();
        r23.height = MathKt.roundToInt(TypedValue.applyDimension(1, 18, WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics())));
    L55:
        y.a(r118.a, r119);
        r118.a.setVisibility(0);
        goto L57
    L54:
        r118.a.setAdjustMode(33);
        goto L55
    L48:
        r118 = new AnchorV3ProductBrandView(r117, null, 6, 0);
        goto L49
    L101:
        return;
    L100:
        return;
    }

    public InflowFeedBannerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ InflowFeedBannerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
