package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ColorPattern;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECBenefitLabelViewV2;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "label", "", "setStyle", "", "", "borderGradientColors", "setBorderColors", "borderColor", "setBorderColor", "setDivStyle", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBenefitLabelViewV2 extends LinearLayout {
    public static final /* synthetic */ int m = 0;
    public PromotionBenefitLabel a;
    public final LinearLayout b;
    public float c;
    public final ECDivView d;
    public final LinearLayout e;
    public float f;
    public final List<q83.a> g;
    public final fj2.b h;
    public final float i;
    public final LivePromotionCardArgsV2 j;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a k;
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.k l;

    public static final class a {
    }

    static {
    }

    public ECBenefitLabelViewV2(Context r9) {
        this(r9, null, 0, null, null, null, 62);
    }

    public ECBenefitLabelViewV2(Context r9, AttributeSet r10) {
        this(r9, r10, 0, null, null, null, 60);
    }

    public ECBenefitLabelViewV2(Context r9, AttributeSet r10, int r11) {
        this(r9, r10, r11, null, null, null, 56);
    }

    public final void c() {
        this.b.removeAllViews();
        this.c = 0.0f;
        this.d.removeAllViews();
        this.e.removeAllViews();
        this.f = 0.0f;
        Iterator r0 = ((ArrayList) this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        q83.a r1 = (q83.a) r0.next();
        LivePromotionCardArgsV2 r2 = this.j;
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
        ((ArrayList) this.g).clear();
    }

    private final void setBorderColor(String r4) {
        Integer r5 = com.bytedance.android.ec.core.utils.s.b(r4);
        if (r5 == null) goto L11;
        int r6 = r5.intValue();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L7;
        float r0 = this.i;
        GradientDrawable r1 = new GradientDrawable();
        r1.setStroke(2, r6);
        r1.setCornerRadius(r0);
        setBackground(r1);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        float r2 = this.i;
        GradientDrawable r3 = new GradientDrawable();
        r3.setStroke(2, r6);
        r3.setCornerRadius(r2);
        setForeground(r3);
        return;
    L17:
        return;
    L11:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L13;
        setBackground(null);
        return;
    L13:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        setForeground(null);
        return;
    }

    private final void setBorderColors(List<String> r6) {
        float r0 = this.d.getViewWidth();
        float r1 = (this.c + r0) + this.f;
        dm.a.a("ECBenefitLabelView").a("leftContainerWidth = " + this.c + " divViewWidth = " + r0 + " rightContainerWidth = " + this.f);
        if (r1 > 0) goto L5;
        return;
    L5:
        ArrayList r2 = new ArrayList();
        r2.add(Float.valueOf(0.0f));
        r2.add(Float.valueOf(this.c / r1));
        r2.add(Float.valueOf((this.c + r0) / r1));
        r2.add(Float.valueOf(1.0f));
        ArrayList r3 = new ArrayList();
        if (r6 == null) goto L14;
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Integer r4 = com.bytedance.android.ec.core.utils.s.b((String) r7.next());
        if (r4 == null) goto L9;
        r3.add(Integer.valueOf(r4.intValue()));
    L14:
        if ((!r3.isEmpty()) == false) goto L24;
        if (r3.size() != r2.size()) goto L24;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L20;
        final int[] r8 = CollectionsKt.toIntArray(r3);
        final float[] r5 = CollectionsKt.toFloatArray(r2);
        setBackground(new ECBenefitLabelViewV2$getStrokeDrawable$2(this, r8, r5));
        return;
    L20:
        if (Build.VERSION.SDK_INT < 23) goto L35;
        final int[] r9 = CollectionsKt.toIntArray(r3);
        final float[] r10 = CollectionsKt.toFloatArray(r2);
        setForeground(new ECBenefitLabelViewV2$getStrokeDrawable$2(this, r9, r10));
        return;
    L35:
        return;
    L24:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L26;
        setBackground(null);
        return;
    L26:
        if (Build.VERSION.SDK_INT < 23) goto L38;
        setForeground(null);
        return;
    }

    private final void setDivStyle(PromotionBenefitLabel r2) {
        this.d.a(r2);
    }

    private final void setStyle(PromotionBenefitLabel r17) {
        TextPattern r1 = r17.getTextPattern();
        if (r1 == null) goto L5;
        int r2 = Integer.valueOf(r1.getOuterPadding()).intValue();
        setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r2)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r2)), 0);
        e(true, UtilityKotlinExtentionsKt.d(Integer.valueOf(r2)));
        e(false, UtilityKotlinExtentionsKt.d(Integer.valueOf(r2)));
    L6:
        TextPattern r3 = r17.getTextPattern();
        if (r3 == null) goto L9;
        int r4 = Integer.valueOf(r3.getInnerPadding()).intValue();
        this.b.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)), 0);
        e(true, UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)) * 2.0f);
        this.e.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)), 0);
        e(false, UtilityKotlinExtentionsKt.d(Integer.valueOf(r4)) * 2.0f);
    L10:
        ColorPattern r5 = r17.getColorPattern();
        if (r5 == null) goto L49;
        List r6 = r17.getLeftV2();
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        List r8 = r17.getRight();
        if (r8 != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        int r10 = com.bytedance.android.ec.core.utils.s.a;
        Integer r11 = com.bytedance.android.ec.core.utils.s.b(r5.getLeftBgColor());
        if (r11 == null) goto L34;
        int r12 = r11.intValue();
        LinearLayout r13 = this.b;
        float r14 = this.i;
        GradientDrawable r15 = new GradientDrawable();
        r15.setColor(r12);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L32;
        if (r9 == false) goto L32;
        r15.setCornerRadii(new float[]{r14, r14, r14, r14, r14, r14, r14, r14});
    L33:
        r13.setBackground(r15);
    L35:
        Integer r16 = com.bytedance.android.ec.core.utils.s.b(r5.getRightBgColor());
        if (r16 == null) goto L43;
        int r18 = r16.intValue();
        LinearLayout r19 = this.e;
        float r20 = this.i;
        GradientDrawable r21 = new GradientDrawable();
        r21.setColor(r18);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L41;
        if (r7 == false) goto L41;
        r21.setCornerRadii(new float[]{r20, r20, r20, r20, r20, r20, r20, r20});
    L42:
        r19.setBackground(r21);
    L45:
        if (r5.getBorderColorStyle() != 1) goto L47;
        setBorderColors(r5.getBorderGradientColors());
        return;
    L47:
        setBorderColor(r5.getBorderColor());
        return;
    L41:
        r21.setCornerRadii(new float[]{0.0f, 0.0f, r20, r20, r20, r20, 0.0f, 0.0f});
        goto L42
    L43:
        this.e.setBackground(null);
    L32:
        r15.setCornerRadii(new float[]{r14, r14, 0.0f, 0.0f, 0.0f, 0.0f, r14, r14});
        goto L33
    L34:
        this.b.setBackground(null);
        Unit r22 = Unit.INSTANCE;
        goto L35
    L22:
        if (r8.isEmpty() == true) goto L25;
        r9 = false;
        goto L26
    L15:
        if (r6.isEmpty() == true) goto L18;
        r7 = false;
        goto L19
    L49:
        return;
    L9:
        this.b.setPadding(0, 0, 0, 0);
        this.e.setPadding(0, 0, 0, 0);
        goto L10
    L5:
        setPadding(0, 0, 0, 0);
        goto L6
    }

    public final void a(PromotionBenefitLabel r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "label");
        if (r10.isUsable() == true) goto L9;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L9;
        c();
        setVisibility(8);
        return;
    L9:
        if (Intrinsics.areEqual(this.a, r10) == false) goto L11;
        return;
    L11:
        this.a = r10;
        c();
        com.bytedance.android.ec.core.utils.r.a(r10);
        if (r10.getTextPattern() != null) goto L14;
    L78:
        setVisibility(8);
        return;
    L14:
        if (r10.getColorPattern() == null) goto L78;
        if (r10.getDivLinePattern() == null) goto L78;
        List r0 = r10.getLeftV2();
        List r2 = r0;
        if (r2 != null) goto L21;
    L24:
        boolean r3 = true;
    L26:
        if ((!r3) == true) goto L30;
        r0 = null;
    L30:
        if (r0 == null) goto L46;
        ExtensionsKt.visible(this.b);
        this.c = 0.0f;
        Iterator r1 = r0.iterator();
    L33:
        if (r1.hasNext() == false) goto L45;
        View r6 = b((com.bytedance.android.ec.model.response.b) r1.next(), r10, true, r11);
        if (r6 == null) goto L33;
        this.b.addView(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof LinearLayout.LayoutParams) == true) goto L39;
        r7 = null;
    L39:
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7;
        if (r8 == null) goto L33;
        if (com.bytedance.commerce.base.view.b.a(this.b).size() > 1) goto L43;
        r8.leftMargin = 0;
        r6.setLayoutParams(r8);
        goto L33
    L43:
        int r9 = UtilityKotlinExtentionsKt.d(2);
        r8.leftMargin = r9;
        e(true, r9);
        r6.setLayoutParams(r8);
        goto L33
    L45:
        setDivStyle(r10);
        ExtensionsKt.visible(this.d);
    L47:
        List r4 = r10.getRight();
        List r12 = r4;
        if (r12 != null) goto L50;
    L53:
        boolean r13 = true;
    L55:
        if ((!r13) == true) goto L58;
        r4 = null;
    L58:
        if (r4 == null) goto L73;
        ExtensionsKt.visible(this.e);
        this.f = 0.0f;
        Iterator r5 = r4.iterator();
    L61:
        if (r5.hasNext() == false) goto L74;
        View r14 = b((com.bytedance.android.ec.model.response.b) r5.next(), r10, false, r11);
        if (r14 == null) goto L61;
        this.e.addView(r14);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof LinearLayout.LayoutParams) == true) goto L67;
        r15 = null;
    L67:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        if (r16 == null) goto L61;
        if (com.bytedance.commerce.base.view.b.a(this.e).size() > 1) goto L71;
        r16.leftMargin = 0;
        r14.setLayoutParams(r16);
        goto L61
    L71:
        int r17 = UtilityKotlinExtentionsKt.d(1);
        r16.leftMargin = r17;
        e(false, r17);
        r14.setLayoutParams(r16);
    L74:
        setStyle(r10);
        RitTagTrack r18 = r10.getTagTrack();
        if (r18 == null) goto L100;
        r18.setVisibile(true);
        return;
    L100:
        return;
    L73:
        this.e.setVisibility(8);
        this.f = 0.0f;
        Unit r19 = Unit.INSTANCE;
        goto L74
    L50:
        if (r12.isEmpty() == true) goto L53;
        r13 = false;
        goto L55
    L46:
        this.b.setVisibility(8);
        this.c = 0.0f;
        this.d.setVisibility(8);
        Unit r20 = Unit.INSTANCE;
        goto L47
    L21:
        if (r2.isEmpty() == true) goto L24;
        r3 = false;
        goto L26
    }

    public final void e(boolean r1, float r2) {
        if (r1 == false) goto L4;
        this.c += r2;
        return;
    L4:
        this.f += r2;
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
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r11 = this.l;
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
        int r3 = d.a[r0.ordinal()];
        boolean r4 = true;
        if (r3 != 1) goto L8;
        String r16 = r12.d();
        if (r16 == null) goto L72;
        r1 = (TextView) this.h.a(new f(getContext()));
        r1.setText(r16);
        if (r15 == null) goto L58;
        r15.append(r16);
    L58:
        d(r1, r13, r14);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L66
        TextPaint r18 = r1.getPaint();     // Catch: Throwable -> L66
        CharSequence r19 = r1.getText();     // Catch: Throwable -> L66
        if (r19 == null) goto L63;
        String r110 = r19.toString();     // Catch: Throwable -> L66
        if (r110 == null) goto L63;
    L64:
        Object r111 = Result.constructor-impl(Float.valueOf(r18.measureText(r110)));     // Catch: Throwable -> L66
    L68:
        Float r112 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r111) == false) goto L71;
        r111 = r112;
    L71:
        e(r14, ((Number) r111).floatValue());
    L63:
        r110 = "";
    L66:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L72:
        return r1;
    L8:
        if (r3 != 2) goto L10;
        ECUrlModel r5 = r12.c();
        if (r5 == null) goto L72;
        ECDraweeView r114 = this.h.a(new e(getContext()));
        Integer r115 = Integer.valueOf(r5.getWidth());
        if (r115.intValue() <= 0) goto L35;
        boolean r116 = true;
    L36:
        if (r116 == true) goto L39;
        r115 = null;
    L39:
        int r117 = 9;
        if (r115 == null) goto L42;
        int r118 = r115.intValue();
    L43:
        int r119 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r118));
        Integer r6 = Integer.valueOf(r5.getHeight());
        if (r6.intValue() > 0) goto L47;
        r4 = false;
    L47:
        if (r4 == false) goto L49;
        r2 = r6;
    L49:
        if (r2 == null) goto L51;
        r117 = r2.intValue();
    L51:
        r114.setLayoutParams(new LinearLayout.LayoutParams(r119, UtilityKotlinExtentionsKt.d(Integer.valueOf(r117))));
        e(r14, r114.getLayoutParams().width);
        h0.d(r114, r5, null, null, null, null, null, 120);
        return r114;
    L42:
        r118 = 9;
        goto L43
    L35:
        r116 = false;
        goto L36
    L10:
        if (r3 != 3) goto L11;
        com.bytedance.android.ec.model.response.k r120 = r12.a();
        if (r120 == null) goto L72;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r7 = this.k;
        if (r7 == null) goto L19;
        Long r8 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.a(r7, r120.c(), r120.a());
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L20:
        ?? r10 = new ECNewCountDownView(getContext(), r9);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r10.setTextSize(0, UtilityKotlinExtentionsKt.d(10));
        r10.setLineSpacing(UtilityKotlinExtentionsKt.c(2), 1.0f);
        r10.setCountDown(r120);
        r10.setStringBuilder(r15);
        Handler r121 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        r10.onTick(SystemClock.elapsedRealtime());
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L23;
        r10.setOnCountFinishCallback(new ECBenefitLabelViewV2$createCountDownView$1(this));
    L23:
        LivePromotionCardArgsV2 r122 = this.j;
        if (r122 == null) goto L28;
        ILivePromotionCardContainerHandler r123 = r122.b;
        if (r123 == null) goto L28;
        r123.a();
    L28:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r10);
        ((ArrayList) this.g).add(r10);
        d(r10, r13, r14);
        e(r14, r10.getViewWidth());
        return r10;
    L19:
        r9 = 0;
    L11:
        return null;
    }

    public ECBenefitLabelViewV2(Context r4, AttributeSet r5, int r6, LivePromotionCardArgsV2 r7, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r8, com.bytedance.android.livesdk.livecommerce.promotion.card.k r9, int r10) {
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
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.g = new ArrayList();
        this.h = new fj2.b();
        this.i = UtilityKotlinExtentionsKt.c(3);
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
        ECDivView r13 = new ECDivView(r4, null, 6, 0);
        r13.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.d = r13;
        addView(r13);
        r13.setVisibility(8);
        LinearLayout r14 = new LinearLayout(r4);
        r14.setOrientation(0);
        r14.setGravity(16);
        r14.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.e = r14;
        addView(r14);
        r14.setVisibility(8);
        com.bytedance.android.ec.core.utils.a.f(this);
    }
}
