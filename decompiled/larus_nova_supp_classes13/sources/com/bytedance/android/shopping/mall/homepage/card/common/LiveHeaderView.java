package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECParamsFromClientDTO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.mall.homepage.card.product.BreakLineFeedText;
import com.bytedance.android.shopping.mall.homepage.tools.b0;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.android.shopping.mall.homepage.tools.z;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/LiveHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHeaderView extends ConstraintLayout {
    public static final Set<String> m = null;
    public static final int n = 0;
    public static final int o = 0;
    public VideoCardData.Companion.LiveHeader a;
    public View b;
    public BaseViewHolder c;
    public String d;
    public Function1<? super String, Unit> e;
    public final View f;
    public final View g;
    public final SimpleDraweeView h;
    public final SimpleDraweeView i;
    public final AppCompatTextView j;
    public final BreakLineFeedText k;
    public final SimpleDraweeView l;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/LiveHeaderView$Companion$LiveHeaderStyle;", "", "stateStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "userDescStyle", "enterIconLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;)V", "getEnterIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getStateStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getUserDescStyle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeaderStyle {
            private final CommonModel$LayoutStyle enterIconLayout;
            private final CommonModel$CusTextStyle stateStyle;
            private final CommonModel$CusTextStyle userDescStyle;

            public static /* synthetic */ LiveHeaderStyle copy$default(LiveHeaderStyle r0, CommonModel$CusTextStyle r1, CommonModel$CusTextStyle r2, CommonModel$LayoutStyle r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = r0.stateStyle;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = r0.userDescStyle;
            L9:
                if ((r4 & 4) == 0) goto L12;
                r3 = r0.enterIconLayout;
            L12:
                return r0.copy(r1, r2, r3);
            }

            public final CommonModel$CusTextStyle component1() {
                return this.stateStyle;
            }

            public final CommonModel$CusTextStyle component2() {
                return this.userDescStyle;
            }

            public final CommonModel$LayoutStyle component3() {
                return this.enterIconLayout;
            }

            public final LiveHeaderStyle copy(CommonModel$CusTextStyle r2, CommonModel$CusTextStyle r3, CommonModel$LayoutStyle r4) {
                return new LiveHeaderStyle(r2, r3, r4);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof LiveHeaderStyle) == false) goto L12;
                LiveHeaderStyle r4 = (LiveHeaderStyle) r3;
                if (Intrinsics.areEqual(this.stateStyle, r4.stateStyle) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.userDescStyle, r4.userDescStyle) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.enterIconLayout, r4.enterIconLayout) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                CommonModel$CusTextStyle r0 = this.stateStyle;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                CommonModel$CusTextStyle r4 = this.userDescStyle;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                CommonModel$LayoutStyle r7 = this.enterIconLayout;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "LiveHeaderStyle(stateStyle=" + this.stateStyle + ", userDescStyle=" + this.userDescStyle + ", enterIconLayout=" + this.enterIconLayout + ")";
            }

            public final CommonModel$LayoutStyle getEnterIconLayout() {
                return this.enterIconLayout;
            }

            public final CommonModel$CusTextStyle getStateStyle() {
                return this.stateStyle;
            }

            public final CommonModel$CusTextStyle getUserDescStyle() {
                return this.userDescStyle;
            }

            public LiveHeaderStyle(CommonModel$CusTextStyle r1, CommonModel$CusTextStyle r2, CommonModel$LayoutStyle r3) {
                this.stateStyle = r1;
                this.userDescStyle = r2;
                this.enterIconLayout = r3;
            }
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveHeaderView a;

        public a(LiveHeaderView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            LiveHeaderView r10 = this.a;
            Set<String> r0 = LiveHeaderView.m;
            int r11 = r10.Z5();
            LiveHeaderView r1 = this.a;
            Integer r2 = Integer.valueOf(r11);
            VideoCardData.Companion.LiveHeader r3 = r1.a;
            if (r3 == null) goto L37;
            String r4 = r3.getSchema();
            if (r4 == null) goto L37;
            if (r2 == null) goto L8;
            int r5 = r2.intValue();
        L9:
            VideoCardData.Companion.LiveHeader r6 = r1.a;
            if (r6 == null) goto L13;
            String r7 = r6.getBtmCD();
            if (r7 == null) goto L13;
        L14:
            String r8 = r7 + "_i" + (r5 + 1);
            if (BtmSDK.INSTANCE.useV2Api() == false) goto L26;
            LinkedHashMap r12 = new LinkedHashMap();
            VideoCardData.Companion.LiveHeader r13 = r1.a;
            if (r13 == null) goto L21;
            Map<String, String> r14 = r13.getBcmData();
            if (r14 == null) goto L21;
            r12.putAll(r14);
        L21:
            int r15 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
            Map r16 = MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r8), TuplesKt.to("bcm", r12)});
            PageFinder r17 = PageFinder.via(r1.b);
            View r18 = r1.b;
            if (r18 == null) goto L24;
            Context r19 = r18.getContext();
        L25:
            r4 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r4, r16, r17, r19, false);
        L30:
            Map<String, Object> r20 = c0.a;
            Intrinsics.checkNotNullParameter(r4, "schema");
            String r21 = new b0(r4, new z(r5, c0.a)).a();
            k r22 = k.b;
            View r23 = r1.b;
            if (r23 == null) goto L33;
            Context r24 = r23.getContext();
        L34:
            r22.d(r24, r21, null);
            Function1<? super String, Unit> r25 = r1.e;
            if (r25 == null) goto L37;
            Unit r26 = (Unit) r25.invoke(r21);
            goto L37
        L33:
            r24 = null;
            goto L34
        L24:
            r19 = null;
            goto L25
        L26:
            BaseViewHolder r27 = r1.c;
            View r28 = r1.b;
            if (r27 == null) goto L30;
            if (r28 == null) goto L30;
            ToolsKt.z(r27, r28, r8, null);
        L13:
            r7 = "c9582.d3197";
            goto L14
        L8:
            r5 = r1.Z5();
        L37:
            this.a.b6(r11, "video_live_header_click");
        }
    }

    static {
        m = new LinkedHashSet();
        n = com.bytedance.android.shopping.api.mall.common.tools.b0.c(5);
        o = com.bytedance.android.shopping.api.mall.common.tools.b0.c(7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        SimpleDraweeView r0 = this.h;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.api.mall.common.tools.b0.c(16), com.bytedance.android.shopping.api.mall.common.tools.b0.c(16));
        r1.topToTop = this.f.getId();
        r1.startToStart = this.f.getId();
        r1.endToEnd = this.f.getId();
        r1.bottomToBottom = this.f.getId();
        r1.setMargins(com.bytedance.android.shopping.api.mall.common.tools.b0.c(1), com.bytedance.android.shopping.api.mall.common.tools.b0.c(1), com.bytedance.android.shopping.api.mall.common.tools.b0.c(1), com.bytedance.android.shopping.api.mall.common.tools.b0.c(1));
        Unit r2 = Unit.INSTANCE;
        addView(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        SimpleDraweeView r0 = this.i;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.api.mall.common.tools.b0.c(9), com.bytedance.android.shopping.api.mall.common.tools.b0.c(9));
        r1.startToStart = this.f.getId();
        r1.topToTop = this.f.getId();
        r1.setMarginStart(com.bytedance.android.shopping.api.mall.common.tools.b0.c(10));
        ((ViewGroup.MarginLayoutParams) r1).topMargin = com.bytedance.android.shopping.api.mall.common.tools.b0.c(9);
        Unit r2 = Unit.INSTANCE;
        addView(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5() {
        SimpleDraweeView r0 = this.l;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(n, o);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToEnd = this.k.getId();
        r1.endToEnd = 0;
        r1.setMarginStart(com.bytedance.android.shopping.api.mall.common.tools.b0.c(3));
        r1.setMarginEnd(com.bytedance.android.shopping.api.mall.common.tools.b0.c(8));
        Unit r2 = Unit.INSTANCE;
        addView(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5() {
        AppCompatTextView r0 = this.j;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToEnd = this.f.getId();
        r1.setMarginStart(com.bytedance.android.shopping.api.mall.common.tools.b0.c(4));
        Unit r2 = Unit.INSTANCE;
        addView(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        AppCompatTextView r0 = this.k;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToEnd = this.j.getId();
        r1.endToStart = this.l.getId();
        r1.constrainedWidth = true;
        r1.setMarginStart(com.bytedance.android.shopping.api.mall.common.tools.b0.c(4));
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = com.bytedance.android.shopping.api.mall.common.tools.b0.c(Double.valueOf(0.5d));
        r1.horizontalBias = 0.0f;
        r1.horizontalChainStyle = 2;
        r1.matchConstraintDefaultWidth = 1;
        Unit r2 = Unit.INSTANCE;
        addView(r0, r1);
    }

    public final int Z5() {
        BaseViewHolder r0 = this.c;
        if (r0 != null) goto L7;
        return -2;
    L7:
        return ToolsKt.g(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        String r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L16;
        Set<String> r2 = m;
        if (r2.contains(r0) == true) goto L17;
        b6(Z5(), "video_live_header_show");
        String r3 = this.d;
        if (r3 == null) goto L18;
        r2.add(r3);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.product.BreakLineFeedText] */
    public LiveHeaderView(Context r6) {
        super(r6);
        View r7 = new View(getContext());
        r7.setId(ViewCompat.generateViewId());
        Drawable r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Drawable r3 = ResourcesCompat.getDrawable(r7.getResources(), 2131248022, null);     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        r7.setBackground(r3);     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Unit r4 = Unit.INSTANCE;
        this.f = r7;
        View r8 = new View(getContext());
        r8.setId(ViewCompat.generateViewId());
        Drawable r0 = ResourcesCompat.getDrawable(r8.getResources(), 2131248022, null);     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        r8.setBackground(r0);     // Catch: Throwable -> L17
        r1 = r0;
    L15:
        Result.constructor-impl(r1);     // Catch: Throwable -> L17
    L19:
        Unit r5 = Unit.INSTANCE;
        this.g = r8;
        SimpleDraweeView r9 = new SimpleDraweeView(getContext());
        r9.setId(ViewCompat.generateViewId());
        RoundingParams r10 = RoundingParams.fromCornersRadius(5.0f);
        r10.setRoundAsCircle(true);
        r9.getHierarchy().setRoundingParams(r10);
        this.h = r9;
        SimpleDraweeView r11 = new SimpleDraweeView(getContext());
        r11.setId(ViewCompat.generateViewId());
        this.i = r11;
        AppCompatTextView r12 = new AppCompatTextView(getContext());
        r12.setId(ViewCompat.generateViewId());
        ToolsKt.b(r12);
        r12.setIncludeFontPadding(false);
        r12.setMaxLines(1);
        r12.setTextColor(ColorProtector.parseColor("#FF3344"));
        r12.setTextSize(1, 11.0f);
        this.j = r12;
        ?? r13 = new BreakLineFeedText(getContext());
        r13.e = true;
        r13.f = false;
        r13.setId(ViewCompat.generateViewId());
        ToolsKt.b(r13);
        r13.setIncludeFontPadding(false);
        r13.setMaxLines(1);
        r13.setTextSize(1, 11.0f);
        r13.setTextColor(ColorProtector.parseColor("#333333"));
        this.k = r13;
        SimpleDraweeView r14 = new SimpleDraweeView(getContext());
        r14.setId(ViewCompat.generateViewId());
        this.l = r14;
        S5(this.f);
        S5(r8);
        R5();
        T5();
        V5();
        Y5();
        U5();
        setOnClickListener(new a(this));
        return;
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(View r4) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.api.mall.common.tools.b0.c(18), com.bytedance.android.shopping.api.mall.common.tools.b0.c(18));
        r0.startToStart = 0;
        r0.topToTop = 0;
        r0.bottomToBottom = 0;
        r0.setMarginStart(com.bytedance.android.shopping.api.mall.common.tools.b0.c(8));
        Unit r1 = Unit.INSTANCE;
        addView(r4, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.product.BreakLineFeedText] */
    public LiveHeaderView(Context r5, AttributeSet r6) {
        super(r5, r6);
        View r7 = new View(getContext());
        r7.setId(ViewCompat.generateViewId());
        Drawable r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Drawable r2 = ResourcesCompat.getDrawable(r7.getResources(), 2131248022, null);     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r7.setBackground(r2);     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Unit r3 = Unit.INSTANCE;
        this.f = r7;
        View r8 = new View(getContext());
        r8.setId(ViewCompat.generateViewId());
        Drawable r9 = ResourcesCompat.getDrawable(r8.getResources(), 2131248022, null);     // Catch: Throwable -> L17
        if (r9 == null) goto L15;
        r8.setBackground(r9);     // Catch: Throwable -> L17
        r0 = r9;
    L15:
        Result.constructor-impl(r0);     // Catch: Throwable -> L17
    L19:
        Unit r10 = Unit.INSTANCE;
        this.g = r8;
        SimpleDraweeView r11 = new SimpleDraweeView(getContext());
        r11.setId(ViewCompat.generateViewId());
        RoundingParams r4 = RoundingParams.fromCornersRadius(5.0f);
        r4.setRoundAsCircle(true);
        r11.getHierarchy().setRoundingParams(r4);
        this.h = r11;
        SimpleDraweeView r12 = new SimpleDraweeView(getContext());
        r12.setId(ViewCompat.generateViewId());
        this.i = r12;
        AppCompatTextView r13 = new AppCompatTextView(getContext());
        r13.setId(ViewCompat.generateViewId());
        ToolsKt.b(r13);
        r13.setIncludeFontPadding(false);
        r13.setMaxLines(1);
        r13.setTextColor(ColorProtector.parseColor("#FF3344"));
        r13.setTextSize(1, 11.0f);
        this.j = r13;
        ?? r14 = new BreakLineFeedText(getContext());
        r14.e = true;
        r14.f = false;
        r14.setId(ViewCompat.generateViewId());
        ToolsKt.b(r14);
        r14.setIncludeFontPadding(false);
        r14.setMaxLines(1);
        r14.setTextSize(1, 11.0f);
        r14.setTextColor(ColorProtector.parseColor("#333333"));
        this.k = r14;
        SimpleDraweeView r15 = new SimpleDraweeView(getContext());
        r15.setId(ViewCompat.generateViewId());
        this.l = r15;
        S5(this.f);
        S5(r8);
        R5();
        T5();
        V5();
        Y5();
        U5();
        setOnClickListener(new a(this));
        return;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b6(int r8, String r9) {
        int r0 = r9.hashCode();
        if (r0 == (-282608891)) goto L15;
        if (r0 == 1376829920) goto L8;
    L21:
        VideoCardData.Companion.LiveHeaderEventInner r1 = null;
    L22:
        if (r1 == null) goto L55;
        VideoCardData.Companion.LiveHeader r2 = this.a;
        if (r2 == null) goto L27;
        String r3 = r2.getBtmCD();
        if (r3 == null) goto L27;
    L28:
        String r4 = r3 + "_i" + (r8 + 1);
        LinkedHashMap r5 = new LinkedHashMap();
        Map<String, Object> r6 = r1.getParams();
        if (r6 == null) goto L31;
        r5.putAll(r6);
    L31:
        List<ECParamsFromClientDTO> r7 = r1.getParamsFromClient();
        if (r7 == null) goto L42;
        Iterator<T> r10 = r7.iterator();
    L35:
        if (r10.hasNext() == false) goto L42;
        ECParamsFromClientDTO r11 = (ECParamsFromClientDTO) r10.next();
        String r12 = r11.getClientKey();
        String r13 = r11.getReportKey();
        if (r12 == null) goto L35;
        if (r13 == null) goto L35;
        if (Intrinsics.areEqual(r11.getClientKey(), "index") == false) goto L35;
        r5.put(r13, Integer.valueOf(r8));
    L42:
        BaseViewHolder r14 = this.c;
        if (r14 == null) goto L56;
        ToolsKt.x(r14, r9, r4, r5, null);
        return;
    L56:
        return;
    L27:
        r3 = "c9582.d3197";
        goto L28
    L55:
        return;
    L8:
        if (r9.equals("video_live_header_show") == false) goto L21;
        VideoCardData.Companion.LiveHeader r15 = this.a;
        if (r15 == null) goto L21;
        VideoCardData.Companion.LiveHeaderEvent r16 = r15.getEvent();
        if (r16 == null) goto L21;
        r1 = r16.getShowEvent();
        goto L22
    L15:
        if (r9.equals("video_live_header_click") == false) goto L21;
        VideoCardData.Companion.LiveHeader r17 = this.a;
        if (r17 == null) goto L21;
        VideoCardData.Companion.LiveHeaderEvent r18 = r17.getEvent();
        if (r18 == null) goto L21;
        r1 = r18.getClickEvent();
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.product.BreakLineFeedText] */
    public LiveHeaderView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        View r7 = new View(getContext());
        r7.setId(ViewCompat.generateViewId());
        Drawable r8 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Drawable r1 = ResourcesCompat.getDrawable(r7.getResources(), 2131248022, null);     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r7.setBackground(r1);     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r1);     // Catch: Throwable -> L9
    L11:
        Unit r2 = Unit.INSTANCE;
        this.f = r7;
        View r9 = new View(getContext());
        r9.setId(ViewCompat.generateViewId());
        Drawable r10 = ResourcesCompat.getDrawable(r9.getResources(), 2131248022, null);     // Catch: Throwable -> L17
        if (r10 == null) goto L15;
        r9.setBackground(r10);     // Catch: Throwable -> L17
        r8 = r10;
    L15:
        Result.constructor-impl(r8);     // Catch: Throwable -> L17
    L19:
        Unit r11 = Unit.INSTANCE;
        this.g = r9;
        SimpleDraweeView r12 = new SimpleDraweeView(getContext());
        r12.setId(ViewCompat.generateViewId());
        RoundingParams r13 = RoundingParams.fromCornersRadius(5.0f);
        r13.setRoundAsCircle(true);
        r12.getHierarchy().setRoundingParams(r13);
        this.h = r12;
        SimpleDraweeView r14 = new SimpleDraweeView(getContext());
        r14.setId(ViewCompat.generateViewId());
        this.i = r14;
        AppCompatTextView r15 = new AppCompatTextView(getContext());
        r15.setId(ViewCompat.generateViewId());
        ToolsKt.b(r15);
        r15.setIncludeFontPadding(false);
        r15.setMaxLines(1);
        r15.setTextColor(ColorProtector.parseColor("#FF3344"));
        r15.setTextSize(1, 11.0f);
        this.j = r15;
        ?? r16 = new BreakLineFeedText(getContext());
        r16.e = true;
        r16.f = false;
        r16.setId(ViewCompat.generateViewId());
        ToolsKt.b(r16);
        r16.setIncludeFontPadding(false);
        r16.setMaxLines(1);
        r16.setTextSize(1, 11.0f);
        r16.setTextColor(ColorProtector.parseColor("#333333"));
        this.k = r16;
        SimpleDraweeView r17 = new SimpleDraweeView(getContext());
        r17.setId(ViewCompat.generateViewId());
        this.l = r17;
        S5(this.f);
        S5(r9);
        R5();
        T5();
        V5();
        Y5();
        U5();
        setOnClickListener(new a(this));
        return;
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L6:
        r1 = null;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
