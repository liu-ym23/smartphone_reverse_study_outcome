package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.model.ColorPattern;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.TextPattern;
import com.bytedance.android.ec.model.response.BenefitLabelElementType;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroBenefitLabelView;", "Landroid/widget/LinearLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroBenefitLabelView extends LinearLayout {
    public oh2.e a;
    public oh2.c b;
    public PromotionBenefitLabel c;
    public final LinearLayout d;
    public final VerticalDashLineView e;
    public final LinearLayout f;
    public final List<q83.a> g;
    public final float h;

    public static final class a {
    }

    static {
    }

    public IntroBenefitLabelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c() {
        Iterator r0 = ((ArrayList) this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        q83.a r1 = (q83.a) r0.next();
        oh2.e r2 = this.a;
        if (r2 == null) goto L10;
        oh2.d r3 = r2.d;
        if (r3 == null) goto L10;
        r3.a();
    L10:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r1);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L4;
        if ((r1 instanceof c) == false) goto L4;
        ((c) r1).c = null;
        goto L4
    L15:
        ((ArrayList) this.g).clear();
    }

    public final void a(PromotionBenefitLabel r19, StringBuilder r20) {
        Intrinsics.checkNotNullParameter(r19, "label");
        if (r19.isUsable() == true) goto L7;
        this.d.removeAllViews();
        this.f.removeAllViews();
        c();
        setVisibility(8);
        return;
    L7:
        if (Intrinsics.areEqual(this.c, r19) == false) goto L9;
        return;
    L9:
        this.c = r19;
        this.d.removeAllViews();
        this.f.removeAllViews();
        c();
        r.a(r19);
        if (r19.getTextPattern() != null) goto L12;
    L127:
        setVisibility(8);
        return;
    L12:
        if (r19.getColorPattern() == null) goto L127;
        if (r19.getDivLinePattern() == null) goto L127;
        ColorPattern r3 = r19.getColorPattern();
        int r10 = 4;
        if (r3 != null) goto L19;
        ViewGroup.LayoutParams r8 = null;
    L63:
        TextPattern r4 = r19.getTextPattern();
        if (r4 == null) goto L66;
        int r5 = Integer.valueOf(r4.getInnerPadding()).intValue();
        this.d.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r5)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r5)), 0);
        this.f.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r5)), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r5)), 0);
    L66:
        com.bytedance.android.ec.model.response.b r6 = r19.getLeft();
        if (r6 == null) goto L105;
        ExtensionsKt.visible(this.d);
        View r7 = b(r6, r19, true, r20);
        if (r7 == null) goto L79;
        this.d.addView(r7);
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if ((r9 instanceof LinearLayout.LayoutParams) == true) goto L73;
        r9 = r8;
    L73:
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r9;
        if (r11 == null) goto L79;
        if (com.bytedance.commerce.base.view.b.a(this.d).size() <= 1) goto L78;
        r11.leftMargin = UtilityKotlinExtentionsKt.d(2);
        r7.setLayoutParams(r11);
        goto L79
    L78:
        r11.leftMargin = 0;
        r7.setLayoutParams(r11);
    L79:
        ExtensionsKt.visible(this.e);
        DivLinePattern r12 = r19.getDivLinePattern();
        if (r12 != null) goto L83;
    L106:
        List r13 = r19.getRight();
        if (r13 == null) goto L122;
        ExtensionsKt.visible(this.f);
        Iterator r14 = r13.iterator();
    L110:
        if (r14.hasNext() == false) goto L123;
        View r15 = b((com.bytedance.android.ec.model.response.b) r14.next(), r19, false, r20);
        if (r15 == null) goto L110;
        this.f.addView(r15);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof LinearLayout.LayoutParams) == true) goto L116;
        r16 = r8;
    L116:
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        if (r17 == null) goto L110;
        if (com.bytedance.commerce.base.view.b.a(this.f).size() > 1) goto L120;
        r17.leftMargin = 0;
        r15.setLayoutParams(r17);
        goto L110
    L120:
        r17.leftMargin = UtilityKotlinExtentionsKt.d(1);
        r15.setLayoutParams(r17);
    L123:
        RitTagTrack r1 = r19.getTagTrack();
        if (r1 == null) goto L139;
        r1.setVisibile(true);
        return;
    L139:
        return;
    L122:
        this.f.setVisibility(8);
        goto L123
    L83:
        if (r12.getStyle() != 1) goto L85;
        boolean r18 = true;
    L86:
        VerticalDashLineView r110 = this.e;
        if (r18 == false) goto L89;
        float r111 = UtilityKotlinExtentionsKt.c(1);
    L90:
        if (r18 == false) goto L92;
        float r21 = UtilityKotlinExtentionsKt.c(1);
    L93:
        float r22 = 2;
        r110.a(2.0f, r111, r21, (UtilityKotlinExtentionsKt.c(1) / r22) + r22);
        int r23 = s.a;
        Integer r24 = s.b(r12.getDivLineColor());
        if (r24 == null) goto L98;
        int r25 = r24.intValue();
        this.e.setDashLineColor(r25);
        if (r25 != 0) goto L98;
        this.e.setVisibility(8);
    L98:
        int r26 = r12.getDivLineHeight();
        TextPattern r27 = r19.getTextPattern();
        if (r27 != null) goto L101;
    L103:
        r10 = 0;
    L104:
        this.e.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r12.getDivLineHeight())) - r10;
        goto L106
    L101:
        if (r26 != r27.getHeight()) goto L103;
    L92:
        r21 = 0.0f;
        goto L93
    L89:
        r111 = 0.0f;
        goto L90
    L85:
        r18 = false;
        goto L86
    L105:
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        Unit r28 = Unit.INSTANCE;
        goto L106
    L19:
        if (r19.getLeft() != null) goto L21;
        boolean r112 = true;
    L22:
        List r113 = r19.getRight();
        if (r113 != null) goto L25;
    L28:
        boolean r114 = true;
    L29:
        int r115 = s.a;
        Integer r116 = s.b(r3.getLeftBgColor());
        if (r116 == null) goto L37;
        int r117 = r116.intValue();
        LinearLayout r29 = this.d;
        float r30 = this.h;
        GradientDrawable r118 = new GradientDrawable();
        r118.setColor(r117);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L35;
        if (r114 == false) goto L35;
        r118.setCornerRadii(new float[]{r30, r30, r30, r30, r30, r30, r30, r30});
    L36:
        r29.setBackground(r118);
    L38:
        Integer r31 = s.b(r3.getRightBgColor());
        if (r31 == null) goto L46;
        int r32 = r31.intValue();
        LinearLayout r33 = this.f;
        float r119 = this.h;
        GradientDrawable r120 = new GradientDrawable();
        r120.setColor(r32);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == false) goto L44;
        if (r112 == false) goto L44;
        r120.setCornerRadii(new float[]{r119, r119, r119, r119, r119, r119, r119, r119});
    L45:
        r33.setBackground(r120);
    L47:
        Integer r34 = s.b(r3.getBorderColor());
        if (r34 == null) goto L56;
        int r35 = r34.intValue();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L52;
        float r36 = this.h;
        GradientDrawable r37 = new GradientDrawable();
        r37.setStroke(2, r35);
        r37.setCornerRadius(r36);
        setBackground(r37);
    L60:
        r8 = null;
        goto L63
    L52:
        if (Build.VERSION.SDK_INT < 23) goto L60;
        float r38 = this.h;
        GradientDrawable r39 = new GradientDrawable();
        r39.setStroke(2, r35);
        r39.setCornerRadius(r38);
        setForeground(r39);
        goto L60
    L56:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_PROMOTION_CARD_LABEL() == true) goto L58;
        r8 = null;
        setBackground(null);
        goto L63
    L58:
        if (Build.VERSION.SDK_INT < 23) goto L60;
        r8 = null;
        setForeground(null);
    L44:
        r120.setCornerRadii(new float[]{0.0f, 0.0f, r119, r119, r119, r119, 0.0f, 0.0f});
        goto L45
    L46:
        this.f.setBackground(null);
    L35:
        r118.setCornerRadii(new float[]{r30, r30, 0.0f, 0.0f, 0.0f, 0.0f, r30, r30});
        goto L36
    L37:
        this.d.setBackground(null);
        Unit r40 = Unit.INSTANCE;
        goto L38
    L25:
        if (r113.isEmpty() == true) goto L28;
        r114 = false;
        goto L29
    L21:
        r112 = false;
        goto L22
    }

    public IntroBenefitLabelView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.g = new ArrayList();
        this.h = UtilityKotlinExtentionsKt.c(3);
        setOrientation(0);
        setGravity(16);
        LinearLayout r0 = new LinearLayout(r7);
        r0.setOrientation(0);
        r0.setGravity(16);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        Unit r1 = Unit.INSTANCE;
        this.d = r0;
        addView(r0);
        r0.setVisibility(8);
        View r2 = new VerticalDashLineView(r7, null, 6, 0);
        r2.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(2), -1));
        this.e = r2;
        addView(r2);
        r2.setVisibility(8);
        LinearLayout r3 = new LinearLayout(r7);
        r3.setOrientation(0);
        r3.setGravity(16);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.f = r3;
        addView(r3);
        r3.setVisibility(8);
        com.bytedance.android.ec.core.utils.a.f(this);
    }

    public static void d(TextView r2, PromotionBenefitLabel r3, boolean r4) {
        TextPattern r0 = r3.getTextPattern();
        if (r0 == null) goto L5;
        r2.setTextSize(0, UtilityKotlinExtentionsKt.c(Integer.valueOf(r0.getTextSize())));
    L5:
        ColorPattern r5 = r3.getColorPattern();
        if (r5 == null) goto L15;
        if (r4 == false) goto L11;
        int r6 = s.a;
        Integer r7 = s.b(r5.getLeftTextColor());
        if (r7 == null) goto L16;
        r2.setTextColor(r7.intValue());
        return;
    L16:
        return;
    L11:
        int r8 = s.a;
        Integer r9 = s.b(r5.getRightTextColor());
        if (r9 == null) goto L18;
        r2.setTextColor(r9.intValue());
        return;
    L18:
        return;
    }

    public /* synthetic */ IntroBenefitLabelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.c, java.lang.Object, q83.a] */
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
        int r3 = b.a[r0.ordinal()];
        boolean r4 = true;
        if (r3 != 1) goto L8;
        String r16 = r12.d();
        if (r16 == null) goto L59;
        r1 = new TextView(getContext());
        r1.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r1.setGravity(17);
        r1.setText(r16);
        if (r15 == null) goto L58;
        r15.append(r16);
    L58:
        d(r1, r13, r14);
    L59:
        return r1;
    L8:
        if (r3 != 2) goto L10;
        ECUrlModel r17 = r12.c();
        if (r17 == null) goto L59;
        ECDraweeView r18 = new ECDraweeView(getContext(), null, 0, 6, null);
        Integer r19 = Integer.valueOf(r17.getWidth());
        if (r19.intValue() <= 0) goto L35;
        boolean r110 = true;
    L36:
        if (r110 == true) goto L39;
        r19 = null;
    L39:
        int r111 = 9;
        if (r19 == null) goto L42;
        int r112 = r19.intValue();
    L43:
        int r113 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r112));
        Integer r5 = Integer.valueOf(r17.getHeight());
        if (r5.intValue() > 0) goto L47;
        r4 = false;
    L47:
        if (r4 == false) goto L49;
        r2 = r5;
    L49:
        if (r2 == null) goto L51;
        r111 = r2.intValue();
    L51:
        r18.setLayoutParams(new LinearLayout.LayoutParams(r113, UtilityKotlinExtentionsKt.d(Integer.valueOf(r111))));
        r18.setScaleType(ImageView.ScaleType.FIT_XY);
        h0.d(r18, r17, null, null, null, null, null, 120);
        return r18;
    L42:
        r112 = 9;
        goto L43
    L35:
        r110 = false;
        goto L36
    L10:
        if (r3 != 3) goto L11;
        k r114 = r12.a();
        if (r114 == null) goto L59;
        oh2.c r6 = this.b;
        if (r6 == null) goto L19;
        Long r7 = r6.b(r114.c(), r114.a());
        if (r7 == null) goto L19;
        long r8 = r7.longValue();
    L20:
        ?? r9 = new c(getContext(), r8);
        r9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r9.setTextSize(0, UtilityKotlinExtentionsKt.d(10));
        r9.setLineSpacing(UtilityKotlinExtentionsKt.c(2), 1.0f);
        r9.a = r114;
        r9.b = r15;
        r9.setFontFeatureSettings("tnum");
        Handler r115 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        r9.onTick(SystemClock.elapsedRealtime());
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_TAG_COUNTDOWN_GONE() == false) goto L23;
        Function0<Unit> r116 = new IntroBenefitLabelView$createCountDownView$1(this);
        Intrinsics.checkNotNullParameter(r116, "finishAction");
        r9.c = r116;
    L23:
        oh2.e r117 = this.a;
        if (r117 == null) goto L28;
        oh2.d r118 = r117.d;
        if (r118 == null) goto L28;
        r118.a();
    L28:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r9);
        ((ArrayList) this.g).add(r9);
        d(r9, r13, r14);
        return r9;
    L19:
        r8 = 0;
    L11:
        return null;
    }
}
