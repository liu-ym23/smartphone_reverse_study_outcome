package com.bytedance.android.shopping.feed.view.bottombar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPageConfigStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.s;
import com.bytedance.android.shopping.feed.utils.t;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.InflowBottomCartView;
import com.bytedance.android.shopping.feed.widget.InflowBottomCommonButton;
import com.bytedance.android.shopping.feed.widget.InflowBottomMemberView;
import com.bytedance.android.shopping.feed.widget.InflowCardBuyButton;
import com.bytedance.android.shopping.feed.widget.ProductFeedAbilityBarView;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0012¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "Landroid/widget/LinearLayout;", "", "", "inflowMainCardLocationType", "", "setInflowMainCardLocationType", "", "textSize", "setBuyButtonTextSize", "", "logExtra", "setInflowSearchLogExtra", "radius", "setRadius", "Landroid/graphics/drawable/Drawable;", "drawable", "setBackGroundDrawable", "", "maxLine", "setMaxLine", "width", "setbuttonContainerWidth", "getBuyButtonActivityType", "Lcom/bytedance/android/shopping/feed/widget/ProductFeedAbilityBarView;", "a", "Lcom/bytedance/android/shopping/feed/widget/ProductFeedAbilityBarView;", "getAbilityViewView", "()Lcom/bytedance/android/shopping/feed/widget/ProductFeedAbilityBarView;", "abilityViewView", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "c", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "getOnBottomBarEventCallBack", "()Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "setOnBottomBarEventCallBack", "(Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;)V", "onBottomBarEventCallBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedBottomBarView extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public final ProductFeedAbilityBarView a;
    public rd3.a b;
    public a c;
    public final boolean d;
    public final RoundLinearLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public String h;
    public Map<String, String> i;
    public final b j;

    public interface a {
        void a(boolean r1);

        void b(InflowCardBuyButton r1);

        void c(View r1);
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ InflowFeedBottomBarView a;

        public b(InflowFeedBottomBarView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            rd3.b r6 = (rd3.b) r5;
            InflowFeedBottomBarView r0 = this.a;
            String r1 = r6.b;
            rd3.a r2 = r0.b;
            Object r3 = null;
            if (r2 == null) goto L11;
            Promotion r4 = r2.f();
            if (r4 == null) goto L11;
            PromotionProductStruct r7 = r4.getPromotionInfo();
            if (r7 == null) goto L11;
            PromotionProductBaseStruct r8 = r7.getBaseInfo();
            if (r8 == null) goto L11;
            String r9 = r8.getProductId();
        L13:
            if (Intrinsics.areEqual(r1, r9) == false) goto L30;
            Boolean r10 = r6.a;
            if (r10 == null) goto L31;
            r10.booleanValue();
            rd3.a r11 = r0.b;
            if (r11 == null) goto L32;
            Promotion r12 = r11.f();
            if (r12 == null) goto L33;
            PromotionProductStruct r13 = r12.getPromotionInfo();
            if (r13 == null) goto L34;
            View r14 = r0.g.getChildAt(0);
            if ((r14 instanceof InflowCardBuyButton) == false) goto L26;
            r3 = r14;
        L26:
            InflowCardBuyButton r15 = (InflowCardBuyButton) r3;
            if (r15 == null) goto L35;
            r15.b(r13);
            return;
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L11:
            r9 = null;
            goto L13
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InflowBottomCommonButton a;
        public final /* synthetic */ InflowFeedBottomBarView b;
        public final /* synthetic */ rd3.a c;

        public c(InflowBottomCommonButton r1, InflowFeedBottomBarView r2, rd3.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            FeedProductEventTracker r0 = FeedProductEventTracker.a;
            Context r1 = this.a.getContext();
            rd3.a r2 = this.c;
            int r3 = vd3.a.a;
            InflowFeedBottomBarView r4 = this.b;
            int r5 = InflowFeedBottomBarView.k;
            r4.getClass();
            if (r2.e == false) goto L5;
            String r6 = "a1.b7365.c3865.d60364";
        L6:
            String r7 = vd3.a.b(r13, r6);
            r0.getClass();
            FeedProductEventTracker.E(r1, r2, true, r7);
            BtmSDK r8 = BtmSDK.INSTANCE;
            InflowFeedBottomBarView r9 = this.b;
            rd3.a r10 = this.c;
            r9.getClass();
            if (r10.e == false) goto L9;
            String r11 = "a1.b7365.c3865.d60364";
        L10:
            String r12 = BtmSDK.createJumpSourceBtmToken$default(r8, r11, PageFinder.via(this.a), null, 4, null);
            p r14 = p.a;
            Context r15 = r13.getContext();
            int r16 = md3.a.a;
            r14.openSchema(r15, md3.a.a(this.a.getJumpUrl(), r12));
            return;
        L9:
            r11 = "a1.b7365.c4701.d05311";
            goto L10
        L5:
            r6 = "a1.b7365.c4701.d05311";
            goto L6
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ s b;

        public d(InflowFeedBottomBarView$getBuyClickListener$1 r1, s r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            boolean r0 = t.a;
            if (t.a == false) goto L5;
            this.a.onClick(r3);
            return;
        L5:
            t.b = r3.hashCode();
            p.a.openSchema(r3.getContext(), this.b.c);
        }
    }

    public InflowFeedBottomBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowFeedBottomBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getBuyButtonActivityType() {
        Object r0 = this.g.getChildAt(0);
        if ((r0 instanceof InflowCardBuyButton) == true) goto L5;
        r0 = null;
    L5:
        InflowCardBuyButton r1 = (InflowCardBuyButton) r0;
        if (r1 != null) goto L8;
        return 0;
    L8:
        return r1.getBuyButtonActivityType();
    }

    public final ProductFeedAbilityBarView getAbilityViewView() {
        return this.a;
    }

    public final a getOnBottomBarEventCallBack() {
        return this.c;
    }

    public void setBackGroundDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        AppCompatButton r0 = this.g.getChildAt(0);
        if ((r0 instanceof InflowCardBuyButton) == true) goto L5;
        r0 = null;
    L5:
        AppCompatButton r1 = (InflowCardBuyButton) r0;
        if (r1 == null) goto L9;
        r1.setBackground(r3);
        return;
    }

    public void setBuyButtonTextSize(float r3) {
        AppCompatButton r0 = this.g.getChildAt(0);
        if ((r0 instanceof InflowCardBuyButton) == true) goto L5;
        r0 = null;
    L5:
        AppCompatButton r1 = (InflowCardBuyButton) r0;
        if (r1 == null) goto L9;
        se3.a.c(r1, 2, r3);
        return;
    }

    public void setInflowMainCardLocationType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inflowMainCardLocationType");
        this.h = r2;
    }

    public void setInflowSearchLogExtra(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logExtra");
        this.i = r2;
    }

    public void setMaxLine(int r3) {
        AppCompatButton r0 = this.g.getChildAt(0);
        if ((r0 instanceof InflowCardBuyButton) == true) goto L5;
        r0 = null;
    L5:
        AppCompatButton r1 = (InflowCardBuyButton) r0;
        if (r1 == null) goto L8;
        r1.setMaxLines(r3);
    L8:
        if (r1 == null) goto L11;
        r1.setEllipsize(TextUtils.TruncateAt.END);
        return;
    }

    public final void setOnBottomBarEventCallBack(a r1) {
        this.c = r1;
    }

    public void setRadius(float r3) {
        Object r0 = this.g.getChildAt(0);
        if ((r0 instanceof InflowCardBuyButton) == true) goto L5;
        r0 = null;
    L5:
        InflowCardBuyButton r1 = (InflowCardBuyButton) r0;
        if (r1 == null) goto L9;
        r1.setRadius(r3);
        return;
    }

    public final void setbuttonContainerWidth(int r3) {
        this.e.setMinimumWidth(com.bytedance.android.shopping.extensions.b.b(80));
        this.e.getLayoutParams().width = r3;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
        return;
    L5:
        if (getChildCount() > 0) goto L7;
        return;
    L7:
        Object r0 = ListProtector.get(com.bytedance.commerce.base.view.b.a(this), 0);
        if ((r0 instanceof ViewGroup) == true) goto L10;
        r0 = null;
    L10:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 != null) goto L13;
        return;
    L13:
        int r12 = View.MeasureSpec.getSize(r10);
        Iterator r2 = com.bytedance.commerce.base.view.b.a(r1).iterator();
        int r3 = 0;
        int r5 = 0;
    L15:
        if (r2.hasNext() == false) goto L34;
        Object r6 = r2.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        View r8 = (View) r6;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r9 = null;
    L22:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r9;
        if (r8.getVisibility() != 0) goto L33;
        int r14 = r8.getMeasuredWidth();
        if (r13 == null) goto L27;
        int r15 = r13.leftMargin;
    L28:
        int r16 = r14 + r15;
        if (r13 == null) goto L31;
        int r17 = r13.rightMargin;
    L32:
        r3 = r3 + (r16 + r17);
        goto L33
    L31:
        r17 = 0;
        goto L32
    L27:
        r15 = 0;
    L33:
        r5 = r7;
        goto L15
    L34:
        if (r3 >= r12) goto L36;
        ProductFeedAbilityBarView r4 = this.a;
        r4.measure(View.MeasureSpec.makeMeasureSpec(r4.getMeasuredWidth() + (r12 - r3), 1073741824), r11);
    L37:
        setMeasuredDimension(r12, getMeasuredHeight());
        return;
    L36:
        this.e.measure(View.MeasureSpec.makeMeasureSpec(this.e.getMeasuredWidth() - (r3 - r12), 1073741824), r11);
        goto L37
    }

    public InflowFeedBottomBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = ld3.d.e(ld3.d.b());
        this.j = new b(this);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560735, this, true);
    L6:
        this.a = (ProductFeedAbilityBarView) findViewById(2131364407);
        RoundLinearLayout r6 = findViewById(2131364426);
        this.e = r6;
        TransitionAnimationHelper.e(r6, 500.0f, false);
        this.f = (FrameLayout) findViewById(2131364428);
        this.g = (FrameLayout) findViewById(2131364429);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560735, this, true);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.widget.Button, androidx.appcompat.widget.AppCompatButton, com.bytedance.android.shopping.feed.widget.InflowCardBuyButton] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.View, com.bytedance.android.shopping.feed.widget.InflowCardBuyButton] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.bytedance.android.shopping.feed.widget.InflowCardBuyButton] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View, com.bytedance.android.shopping.feed.widget.InflowCardBuyButton] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View, com.bytedance.android.shopping.feed.widget.InflowCardBuyButton] */
    /* JADX WARN: Type inference failed for: r4v11, types: [android.view.View$OnClickListener, com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView$getBuyClickListener$1] */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.view.View, com.bytedance.android.shopping.feed.widget.InflowBottomCommonButton] */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.feed.widget.InflowBottomMemberView] */
    public final void a(final rd3.a r49, final MutableLiveData<SkuProductDetailInfo> r50, VideoProductFeedBanner r51) {
        Intrinsics.checkNotNullParameter(r49, "anchorInflowFeedItem");
        Context r3 = getContext();
        PromotionProductButtonStruct r5 = null;
        if ((r3 instanceof LifecycleOwner) == true) goto L5;
        r3 = null;
    L5:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 == null) goto L12;
        ProductFeedViewModel r6 = r49.c;
        if (r6 == null) goto L12;
        MutableLiveData<rd3.b> r7 = r6.getAppointLiveData();
        if (r7 == null) goto L12;
        r7.observe(r4, this.j);
    L12:
        this.b = r49;
        Promotion r8 = r49.f();
        if (r8 == null) goto L111;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L112;
        this.a.b(r49);
        int r10 = 6;
        int r11 = 0;
        if (r9.isOnlyHeadImg() == false) goto L20;
    L104:
        this.f.addView(new InflowBottomCartView(getContext(), r5, r10, null == true ? 1 : 0));
        this.g.addView(new InflowCardBuyButton(getContext(), null, 0, null, 14));
        return;
    L20:
        if (r9.isUseAnchorInfo() == true) goto L104;
        if (this.d == false) goto L25;
        this.e.getLayoutParams().width = com.bytedance.android.shopping.extensions.b.b(188);
    L26:
        this.f.removeAllViews();
        this.g.removeAllViews();
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        FrameLayout r12 = this.g;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -1);
        r13.weight = 1.0f;
        Unit r14 = Unit.INSTANCE;
        r12.setLayoutParams(r13);
        final boolean r15 = true;
        ?? r16 = new InflowFeedBottomBarView$getBuyClickListener$1(this, r49, r15, r50);
        boolean r17 = t.a;
        Promotion r18 = r49.f();
        if (r18 == null) goto L35;
        PromotionProductStruct r19 = r18.getPromotionInfo();
        if (r19 == null) goto L35;
        PromotionProductExtraStruct r110 = r19.getExtraInfo();
        if (r110 == null) goto L35;
        PromotionProductButtonStruct r111 = r110.getBuyButton();
        if (r111 == null) goto L35;
        String r112 = r111.getExtra();
    L36:
        s r113 = t.a(r112);
        if (r113 == null) goto L55;
        Intrinsics.checkNotNullParameter(r113, "data");
        if (r113.a != 2) goto L41;
        boolean r114 = true;
    L42:
        if (r114 == false) goto L55;
        if (t.a == false) goto L50;
        FrameLayout r1 = this.g;
        ?? r2 = new InflowCardBuyButton(getContext(), null, 0, null, 14);
        r2.setDefaultButtonText(r113.d);
        List r20 = r9.getBuyButtonInfos();
        if (r20 == null) goto L48;
        PromotionProductButtonStruct r21 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r20, 0);
    L49:
        r2.a(r9, r21, r16, null);
        r1.addView(r2);
        return;
    L48:
        r21 = null;
        goto L49
    L50:
        d r22 = new d(r16, r113);
        ?? r23 = new InflowBottomMemberView(getContext(), r5, r10, r11);
        List r24 = r9.getBuyButtonInfos();
        if (r24 == null) goto L53;
        r5 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r24, 0);
    L53:
        r23.x(r9, r5, r22, r49);
        se3.a.c(r23, 2, 13.0f);
        r23.setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
        this.g.addView(r23);
        return;
    L41:
        r114 = false;
    L55:
        if (f53.a.b(r9) == false) goto L89;
        List r115 = r9.getBuyButtonInfos();
        if (r115 != null) goto L59;
    L84:
        FrameLayout r25 = this.g;
        ?? r26 = new InflowBottomCommonButton(getContext(), r5, r10, null == true ? 1 : 0);
        List r27 = r9.getBuyButtonInfos();
        if (r27 == null) goto L87;
        PromotionProductButtonStruct r28 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r27, 0);
    L88:
        r26.a(r9, r28, new c(r26, this, r49), null);
        r25.addView(r26);
        return;
    L87:
        r28 = null;
        goto L88
    L59:
        if (r115.size() <= 1) goto L61;
        boolean r116 = true;
    L62:
        if (r116 != true) goto L84;
        this.e.getLayoutParams().width = com.bytedance.android.shopping.extensions.b.b(216);
        ViewGroup.LayoutParams r29 = this.f.getLayoutParams();
        if ((r29 instanceof LinearLayout.LayoutParams) == true) goto L66;
        r29 = null;
    L66:
        LinearLayout.LayoutParams r30 = (LinearLayout.LayoutParams) r29;
        if (r30 == null) goto L69;
        r30.width = 0;
        r30.weight = 1.0f;
    L69:
        ViewGroup.LayoutParams r31 = this.g.getLayoutParams();
        if ((r31 instanceof LinearLayout.LayoutParams) == true) goto L72;
        r31 = null;
    L72:
        LinearLayout.LayoutParams r32 = (LinearLayout.LayoutParams) r31;
        if (r32 == null) goto L75;
        r32.width = 0;
        r32.weight = 1.0f;
    L75:
        FrameLayout r33 = this.f;
        ?? r117 = new InflowCardBuyButton(getContext(), null, 0, new ActivityVO(null, 0, 0, 0, null, null, null, null, false, 0, null, 0, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, 67106815, null), 6);
        List r34 = r9.getBuyButtonInfos();
        if (r34 == null) goto L78;
        PromotionProductButtonStruct r35 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r34, 1);
    L79:
        final Object[] r36 = null == true ? 1 : 0;
        r117.a(r9, r35, new InflowFeedBottomBarView$getBuyClickListener$1(this, r49, r36, r50), null);
        r117.setBackgroundResource(2131234850);
        int r37 = g1.a;
        r117.setTextColor(g1.a.a(r117.getContext(), 2131101218));
        r33.addView(r117);
        FrameLayout r38 = this.g;
        ?? r39 = new InflowCardBuyButton(getContext(), null, 0, null, 14);
        List r40 = r9.getBuyButtonInfos();
        if (r40 == null) goto L82;
        PromotionProductButtonStruct r41 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r40, 0);
    L83:
        r39.a(r9, r41, r16, null);
        r38.addView(r39);
        return;
    L82:
        r41 = null;
        goto L83
    L78:
        r35 = null;
        goto L79
    L61:
        r116 = false;
        goto L62
    L89:
        PromotionProductPageConfigStruct r42 = r9.getPageComsConfig();
        if (r42 != null) goto L92;
    L98:
        FrameLayout r43 = this.g;
        ?? r44 = new InflowCardBuyButton(getContext(), null, 0, null, 14);
        List r45 = r9.getBuyButtonInfos();
        if (r45 == null) goto L101;
        PromotionProductButtonStruct r46 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r45, 0);
    L102:
        r44.a(r9, r46, r16, null);
        r43.addView(r44);
        return;
    L101:
        r46 = null;
        goto L102
    L92:
        if (r42.getShoppingCart() != true) goto L98;
        InflowBottomCartView r47 = new InflowBottomCartView(getContext(), r5, r10, null == true ? 1 : 0);
        final sc3.a r48 = r47.getAddCartListener();
        View.OnClickListener r52 = new InflowFeedBottomBarView$getCartClickListener$1(this, r49, r48, r50);
        Intrinsics.checkNotNullParameter(r9, "promotion");
        r47.e = r51;
        r47.a(r9, null, r52, null);
        this.f.addView(r47);
        FrameLayout r53 = this.g;
        ?? r54 = new InflowCardBuyButton(getContext(), null, 0, null, 14);
        List r55 = r9.getBuyButtonInfos();
        if (r55 == null) goto L96;
        PromotionProductButtonStruct r56 = (PromotionProductButtonStruct) CollectionsKt.getOrNull(r55, 0);
    L97:
        r54.a(r9, r56, r16, null);
        r53.addView(r54);
        return;
    L96:
        r56 = null;
    L35:
        r112 = null;
        goto L36
    L25:
        this.e.getLayoutParams().width = com.bytedance.android.shopping.extensions.b.b(151);
        goto L26
    L112:
        return;
    }

    public /* synthetic */ InflowFeedBottomBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
