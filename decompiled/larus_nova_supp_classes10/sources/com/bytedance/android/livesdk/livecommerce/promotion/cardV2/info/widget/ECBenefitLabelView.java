package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.model.ColorPattern;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.TextPattern;
import com.bytedance.android.ec.model.response.BenefitLabelElementType;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECBenefitLabelView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "label", "", "setStyle", "setDivLineStyle", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBenefitLabelView extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public PromotionBenefitLabel a;
    public final LinearLayout b;
    public final VerticalDashLineView c;
    public final LinearLayout d;
    public final List<q83.a> e;
    public final fj2.b f;
    public final float g;
    public final LivePromotionCardArgsV2 h;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a i;
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.k j;

    public static final class a {
    }

    static {
    }

    public ECBenefitLabelView(Context r9) {
        this(r9, null, 0, null, null, null, 62);
    }

    public ECBenefitLabelView(Context r9, AttributeSet r10) {
        this(r9, r10, 0, null, null, null, 60);
    }

    public ECBenefitLabelView(Context r9, AttributeSet r10, int r11) {
        this(r9, r10, r11, null, null, null, 56);
    }

    public final void c() {
        this.b.removeAllViews();
        this.d.removeAllViews();
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        q83.a r1 = (q83.a) r0.next();
        LivePromotionCardArgsV2 r2 = this.h;
        if (r2 == null) goto L10;
        ILivePromotionCardContainerHandler r3 = r2.b;
        if (r3 == null) goto L10;
        r3.a();
    L10:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r1);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L4;
        if ((r1 instanceof ECNewCountDownView) == false) goto L4;
        ((ECNewCountDownView) r1).c = null;
        goto L4
    L15:
        ((ArrayList) this.e).clear();
    }

    private final void setDivLineStyle(PromotionBenefitLabel r9) {
        DivLinePattern r0 = r9.getDivLinePattern();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        boolean r3 = true;
        if (r0.getStyle() == 1) goto L9;
        r3 = false;
    L9:
        VerticalDashLineView r1 = this.c;
        float r4 = 0.0f;
        if (r3 == false) goto L12;
        float r7 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L13:
        if (r3 == false) goto L15;
        r4 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L15:
        float r5 = 2;
        r1.a(2.0f, r7, r4, (UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d)) / r5) + r5);
        int r6 = com.bytedance.android.ec.core.utils.s.a;
        Integer r8 = com.bytedance.android.ec.core.utils.s.b(r0.getDivLineColor());
        if (r8 == null) goto L20;
        int r10 = r8.intValue();
        this.c.setDashLineColor(r10);
        if (r10 != 0) goto L20;
        this.c.setVisibility(8);
    L20:
        int r11 = r0.getDivLineHeight();
        TextPattern r12 = r9.getTextPattern();
        if (r12 != null) goto L23;
    L25:
        this.c.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r0.getDivLineHeight())) - r2;
        return;
    L23:
        if (r11 != r12.getHeight()) goto L25;
        r2 = 4;
        goto L25
    L12:
        r7 = 0.0f;
        goto L13
    }

    private final void setStyle(PromotionBenefitLabel r17) {
        ColorPattern r1 = r17.getColorPattern();
        if (r1 != null) goto L5;
    L47:
        TextPattern r2 = r17.getTextPattern();
        if (r2 == null) goto L51;
        int r3 = Integer.valueOf(r2.getInnerPadding()).intValue();
        this.b.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r3)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r3)), 0);
        this.d.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r3)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r3)), 0);
        return;
    L51:
        return;
    L5:
        if (r17.getLeft() != null) goto L7;
        boolean r4 = true;
    L8:
        List r5 = r17.getRight();
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        int r7 = com.bytedance.android.ec.core.utils.s.a;
        Integer r8 = com.bytedance.android.ec.core.utils.s.b(r1.getLeftBgColor());
        if (r8 == null) goto L23;
        int r9 = r8.intValue();
        LinearLayout r11 = this.b;
        float r10 = this.g;
        GradientDrawable r12 = new GradientDrawable();
        r12.setColor(r9);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L21;
        if (r6 == false) goto L21;
        r12.setCornerRadii(new float[]{r10, r10, r10, r10, r10, r10, r10, r10});
    L22:
        r11.setBackground(r12);
    L24:
        Integer r13 = com.bytedance.android.ec.core.utils.s.b(r1.getRightBgColor());
        if (r13 == null) goto L32;
        int r14 = r13.intValue();
        LinearLayout r15 = this.d;
        float r16 = this.g;
        GradientDrawable r18 = new GradientDrawable();
        r18.setColor(r14);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L30;
        if (r4 == false) goto L30;
        r18.setCornerRadii(new float[]{r16, r16, r16, r16, r16, r16, r16, r16});
    L31:
        r15.setBackground(r18);
    L33:
        Integer r19 = com.bytedance.android.ec.core.utils.s.b(r1.getBorderColor());
        if (r19 == null) goto L42;
        int r20 = r19.intValue();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L38;
        float r21 = this.g;
        GradientDrawable r22 = new GradientDrawable();
        r22.setStroke(2, r20);
        r22.setCornerRadius(r21);
        setBackground(r22);
        goto L47
    L38:
        if (Build.VERSION.SDK_INT < 23) goto L47;
        float r23 = this.g;
        GradientDrawable r24 = new GradientDrawable();
        r24.setStroke(2, r20);
        r24.setCornerRadius(r23);
        setForeground(r24);
        goto L47
    L42:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L44;
        setBackground(null);
        goto L47
    L44:
        if (Build.VERSION.SDK_INT < 23) goto L47;
        setForeground(null);
    L30:
        r18.setCornerRadii(new float[]{0.0f, 0.0f, r16, r16, r16, r16, 0.0f, 0.0f});
        goto L31
    L32:
        this.d.setBackground(null);
    L21:
        r12.setCornerRadii(new float[]{r10, r10, 0.0f, 0.0f, 0.0f, 0.0f, r10, r10});
        goto L22
    L23:
        this.b.setBackground(null);
        Unit r25 = Unit.INSTANCE;
        goto L24
    L11:
        if (r5.isEmpty() == true) goto L14;
        r6 = false;
        goto L15
    L7:
        r4 = false;
        goto L8
    }

    public final void a(PromotionBenefitLabel r8, StringBuilder r9) {
        Intrinsics.checkNotNullParameter(r8, "label");
        if (r8.isUsable() == true) goto L9;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L9;
        c();
        setVisibility(8);
        return;
    L9:
        if (Intrinsics.areEqual(this.a, r8) == false) goto L11;
        return;
    L11:
        this.a = r8;
        c();
        com.bytedance.android.ec.core.utils.r.a(r8);
        if (r8.getTextPattern() != null) goto L14;
    L54:
        setVisibility(8);
        return;
    L14:
        if (r8.getColorPattern() == null) goto L54;
        if (r8.getDivLinePattern() == null) goto L54;
        setStyle(r8);
        com.bytedance.android.ec.model.response.b r0 = r8.getLeft();
        if (r0 == null) goto L32;
        ExtensionsKt.visible(this.b);
        View r1 = b(r0, r8, true, r9);
        if (r1 == null) goto L31;
        this.b.addView(r1);
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if ((r5 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r5 = null;
    L25:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r6 == null) goto L31;
        if (com.bytedance.commerce.base.view.b.a(this.b).size() <= 1) goto L30;
        r6.leftMargin = UtilityKotlinExtentionsKt.d(2);
        r1.setLayoutParams(r6);
        goto L31
    L30:
        r6.leftMargin = 0;
        r1.setLayoutParams(r6);
    L31:
        ExtensionsKt.visible(this.c);
        setDivLineStyle(r8);
    L33:
        List r2 = r8.getRight();
        if (r2 == null) goto L49;
        ExtensionsKt.visible(this.d);
        Iterator r3 = r2.iterator();
    L37:
        if (r3.hasNext() == false) goto L50;
        View r4 = b((com.bytedance.android.ec.model.response.b) r3.next(), r8, false, r9);
        if (r4 == null) goto L37;
        this.d.addView(r4);
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        if ((r7 instanceof LinearLayout.LayoutParams) == true) goto L43;
        r7 = null;
    L43:
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r7;
        if (r10 == null) goto L37;
        if (com.bytedance.commerce.base.view.b.a(this.d).size() > 1) goto L47;
        r10.leftMargin = 0;
        r4.setLayoutParams(r10);
        goto L37
    L47:
        r10.leftMargin = UtilityKotlinExtentionsKt.d(1);
        r4.setLayoutParams(r10);
    L50:
        RitTagTrack r11 = r8.getTagTrack();
        if (r11 == null) goto L66;
        r11.setVisibile(true);
        return;
    L66:
        return;
    L49:
        this.d.setVisibility(8);
        goto L50
    L32:
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        Unit r12 = Unit.INSTANCE;
        goto L33
    }

    public final void d(TextView r3, PromotionBenefitLabel r4, boolean r5) {
        TextPattern r0 = r4.getTextPattern();
        if (r0 == null) goto L5;
        r3.setTextSize(0, UtilityKotlinExtentionsKt.c(Integer.valueOf(r0.getTextSize())));
    L5:
        ColorPattern r6 = r4.getColorPattern();
        if (r6 == null) goto L14;
        if (r5 == false) goto L11;
        int r7 = com.bytedance.android.ec.core.utils.s.a;
        Integer r8 = com.bytedance.android.ec.core.utils.s.b(r6.getLeftTextColor());
        if (r8 == null) goto L14;
        r3.setTextColor(r8.intValue());
        goto L14
    L11:
        int r9 = com.bytedance.android.ec.core.utils.s.a;
        Integer r10 = com.bytedance.android.ec.core.utils.s.b(r6.getRightTextColor());
        if (r10 == null) goto L14;
        r3.setTextColor(r10.intValue());
    L14:
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r11 = this.j;
        if (r11 == null) goto L22;
        IPromotionUIConfig.d r12 = r11.a(PromotionCardModuleName.InfoAreaBenefitLabelTextModule);
        if (r12 == null) goto L23;
        IPromotionUIConfig.b r13 = r12.a();
        if (r13 == null) goto L24;
        UIConfigHelper.c(r3, r13);
        return;
    L24:
        return;
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECNewCountDownView, java.lang.Object, q83.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final View b(com.bytedance.android.ec.model.response.b r12, PromotionBenefitLabel r13, boolean r14, StringBuilder r15) {
        BenefitLabelElementType r0 = r12.b();
        TextView r1 = null;
        r1 = null;
        Integer r2 = null;
        r1 = null;
        if (r0 == null) goto L11;
        int r3 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.a.a[r0.ordinal()];
        boolean r4 = true;
        if (r3 != 1) goto L8;
        String r16 = r12.d();
        if (r16 == null) goto L59;
        r1 = (TextView) this.f.a(new c(getContext()));
        r1.setText(r16);
        if (r15 == null) goto L58;
        r15.append(r16);
    L58:
        d(r1, r13, r14);
    L59:
        return r1;
    L8:
        if (r3 != 2) goto L10;
        ECUrlModel r5 = r12.c();
        if (r5 == null) goto L59;
        ECDraweeView r17 = this.f.a(new b(getContext()));
        Integer r18 = Integer.valueOf(r5.getWidth());
        if (r18.intValue() <= 0) goto L35;
        boolean r19 = true;
    L36:
        if (r19 == true) goto L39;
        r18 = null;
    L39:
        int r110 = 9;
        if (r18 == null) goto L42;
        int r111 = r18.intValue();
    L43:
        int r112 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r111));
        Integer r113 = Integer.valueOf(r5.getHeight());
        if (r113.intValue() > 0) goto L47;
        r4 = false;
    L47:
        if (r4 == false) goto L49;
        r2 = r113;
    L49:
        if (r2 == null) goto L51;
        r110 = r2.intValue();
    L51:
        r17.setLayoutParams(new LinearLayout.LayoutParams(r112, UtilityKotlinExtentionsKt.d(Integer.valueOf(r110))));
        h0.d(r17, r5, null, null, null, null, null, 120);
        return r17;
    L42:
        r111 = 9;
        goto L43
    L35:
        r19 = false;
        goto L36
    L10:
        if (r3 != 3) goto L11;
        com.bytedance.android.ec.model.response.k r114 = r12.a();
        if (r114 == null) goto L59;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r6 = this.i;
        if (r6 == null) goto L19;
        Long r7 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.a(r6, r114.c(), r114.a());
        if (r7 == null) goto L19;
        long r8 = r7.longValue();
    L20:
        ?? r9 = new ECNewCountDownView(getContext(), r8);
        r9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r9.setTextSize(0, UtilityKotlinExtentionsKt.d(10));
        r9.setLineSpacing(UtilityKotlinExtentionsKt.c(2), 1.0f);
        r9.setCountDown(r114);
        r9.setStringBuilder(r15);
        Handler r115 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        r9.onTick(SystemClock.elapsedRealtime());
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L23;
        r9.setOnCountFinishCallback(new ECBenefitLabelView$createCountDownView$1(this));
    L23:
        LivePromotionCardArgsV2 r116 = this.h;
        if (r116 == null) goto L28;
        ILivePromotionCardContainerHandler r117 = r116.b;
        if (r117 == null) goto L28;
        r117.a();
    L28:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r9);
        ((ArrayList) this.e).add(r9);
        d(r9, r13, r14);
        return r9;
    L19:
        r8 = 0;
    L11:
        return null;
    }

    public ECBenefitLabelView(Context r4, AttributeSet r5, int r6, LivePromotionCardArgsV2 r7, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r8, com.bytedance.android.livesdk.livecommerce.promotion.card.k r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r7 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r8 = null;
    L15:
        if ((r10 & 32) == 0) goto L17;
        r9 = null;
    L17:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.e = new ArrayList();
        this.f = new fj2.b();
        this.g = UtilityKotlinExtentionsKt.c(3);
        setOrientation(0);
        setGravity(16);
        LinearLayout r11 = new LinearLayout(r4);
        r11.setOrientation(0);
        r11.setGravity(16);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        Unit r12 = Unit.INSTANCE;
        this.b = r11;
        addView(r11);
        r11.setVisibility(8);
        View r13 = new VerticalDashLineView(r4, null, 6, 0);
        r13.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(2), -1));
        this.c = r13;
        addView(r13);
        r13.setVisibility(8);
        LinearLayout r14 = new LinearLayout(r4);
        r14.setOrientation(0);
        r14.setGravity(16);
        r14.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.d = r14;
        addView(r14);
        r14.setVisibility(8);
        com.bytedance.android.ec.core.utils.a.f(this);
    }
}
