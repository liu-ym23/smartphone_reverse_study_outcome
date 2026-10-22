package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Price;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.live.AdTagView;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB%\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/ProductView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "colorString", "", "setThemeColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductView extends ConstraintLayout {
    public String a;
    public String b;
    public final SimpleDraweeView c;
    public final View d;
    public final TextView e;
    public final PriceView f;
    public final TextView g;
    public final ECRoundedLinearLayout h;
    public final AdTagView i;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout] */
    public ProductView(Context r15) {
        super(r15);
        this.a = "";
        this.b = "";
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        ToolsKt.b(r16);
        r16.setId(ViewCompat.generateViewId());
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r0.setStroke((int) UIUtils.dip2Px(r16.getContext(), 0.5f), ColorProtector.parseColor("#F1F1F1"));
        r16.setBackground(r0);
        RoundingParams r1 = RoundingParams.fromCornersRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r16.getHierarchy().setRoundingParams(r1);
        Unit r2 = Unit.INSTANCE;
        this.c = r16;
        View r3 = new View(getContext());
        GradientDrawable r4 = new GradientDrawable();
        r4.setColor(ColorProtector.parseColor("#0A000000"));
        Intrinsics.checkNotNullParameter(r3, "$this$setBackgroundCompat");
        r3.setBackground(r4);
        this.d = r3;
        TextView r5 = new TextView(getContext());
        r5.setId(ViewCompat.generateViewId());
        r5.setTextColor(ColorProtector.parseColor("#161823"));
        ToolsKt.b(r5);
        r5.setMaxLines(1);
        r5.setIncludeFontPadding(false);
        r5.setTextSize(1, 14.0f);
        this.e = r5;
        PriceView r6 = new PriceView(getContext());
        r6.setId(ViewCompat.generateViewId());
        this.f = r6;
        TextView r7 = new TextView(getContext());
        r7.setId(ViewCompat.generateViewId());
        r7.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r7.setEllipsize(TextUtils.TruncateAt.END);
        ToolsKt.b(r7);
        r7.setMaxLines(1);
        r7.setIncludeFontPadding(false);
        r7.setTextSize(1, 13.0f);
        this.g = r7;
        ?? r8 = new ECRoundedLinearLayout(getContext(), null, 6, 0);
        r8.setId(ViewCompat.generateViewId());
        r8.setRadius(UIUtils.dip2Px(r8.getContext(), 4.0f));
        r8.setGravity(17);
        r8.addView(r7, new LinearLayout.LayoutParams(-2, -2));
        this.h = r8;
        ?? r9 = new AdTagView(getContext());
        r9.y();
        r9.setVisibility(8);
        this.i = r9;
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 48.0f), (int) UIUtils.dip2Px(getContext(), 48.0f));
        r10.topToTop = 0;
        r10.leftToLeft = 0;
        r10.setMargins(b0.c(10), 0, 0, 0);
        addView(r16, r10);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, 0);
        r11.topToTop = r16.getId();
        r11.leftToLeft = r16.getId();
        r11.rightToRight = r16.getId();
        r11.bottomToBottom = r16.getId();
        addView(r3, r11);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(0, -2);
        r12.setMargins(b0.c(8), b0.c(3), b0.c(7), 0);
        r12.leftToRight = r16.getId();
        r12.rightToRight = 0;
        r12.topToTop = r16.getId();
        addView(r5, r12);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, -2);
        r13.setMargins(b0.c(8), 0, b0.c(7), b0.c(1));
        r13.leftToRight = r16.getId();
        r13.rightToRight = 0;
        r13.bottomToBottom = r16.getId();
        addView(r6, r13);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, (int) UIUtils.dip2Px(getContext(), 26.0f));
        r14.leftToLeft = 0;
        r14.rightToRight = 0;
        r14.setMargins(b0.c(10), b0.c(8), b0.c(10), 0);
        r14.topToBottom = r16.getId();
        addView(r8, r14);
        ConstraintLayout.LayoutParams r17 = new ConstraintLayout.LayoutParams(-2, -2);
        r17.leftToLeft = r16.getId();
        r17.bottomToBottom = r16.getId();
        addView(r9, r17);
        setPadding(0, b0.c(8), 0, b0.c(8));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setThemeColor(String r4) {
        Intrinsics.checkNotNullParameter(r4, "colorString");
        this.f.setColorRedValue(r4);
        this.h.setBackgroundColor(Color.parseColor(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "an error occurs when parsing color " + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout] */
    public ProductView(Context r14, AttributeSet r15) {
        super(r14, r15);
        this.a = "";
        this.b = "";
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        ToolsKt.b(r16);
        r16.setId(ViewCompat.generateViewId());
        GradientDrawable r17 = new GradientDrawable();
        r17.setCornerRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r17.setStroke((int) UIUtils.dip2Px(r16.getContext(), 0.5f), ColorProtector.parseColor("#F1F1F1"));
        r16.setBackground(r17);
        RoundingParams r18 = RoundingParams.fromCornersRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r16.getHierarchy().setRoundingParams(r18);
        Unit r19 = Unit.INSTANCE;
        this.c = r16;
        View r110 = new View(getContext());
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(ColorProtector.parseColor("#0A000000"));
        Intrinsics.checkNotNullParameter(r110, "$this$setBackgroundCompat");
        r110.setBackground(r0);
        this.d = r110;
        TextView r1 = new TextView(getContext());
        r1.setId(ViewCompat.generateViewId());
        r1.setTextColor(ColorProtector.parseColor("#161823"));
        ToolsKt.b(r1);
        r1.setMaxLines(1);
        r1.setIncludeFontPadding(false);
        r1.setTextSize(1, 14.0f);
        this.e = r1;
        PriceView r4 = new PriceView(getContext());
        r4.setId(ViewCompat.generateViewId());
        this.f = r4;
        TextView r5 = new TextView(getContext());
        r5.setId(ViewCompat.generateViewId());
        r5.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r5.setEllipsize(TextUtils.TruncateAt.END);
        ToolsKt.b(r5);
        r5.setMaxLines(1);
        r5.setIncludeFontPadding(false);
        r5.setTextSize(1, 13.0f);
        this.g = r5;
        ?? r6 = new ECRoundedLinearLayout(getContext(), null, 6, 0);
        r6.setId(ViewCompat.generateViewId());
        r6.setRadius(UIUtils.dip2Px(r6.getContext(), 4.0f));
        r6.setGravity(17);
        r6.addView(r5, new LinearLayout.LayoutParams(-2, -2));
        this.h = r6;
        ?? r2 = new AdTagView(getContext());
        r2.y();
        r2.setVisibility(8);
        this.i = r2;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 48.0f), (int) UIUtils.dip2Px(getContext(), 48.0f));
        r7.topToTop = 0;
        r7.leftToLeft = 0;
        r7.setMargins(b0.c(10), 0, 0, 0);
        addView(r16, r7);
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(0, 0);
        r8.topToTop = r16.getId();
        r8.leftToLeft = r16.getId();
        r8.rightToRight = r16.getId();
        r8.bottomToBottom = r16.getId();
        addView(r110, r8);
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(0, -2);
        r111.setMargins(b0.c(8), b0.c(3), b0.c(7), 0);
        r111.leftToRight = r16.getId();
        r111.rightToRight = 0;
        r111.topToTop = r16.getId();
        addView(r1, r111);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(0, -2);
        r112.setMargins(b0.c(8), 0, b0.c(7), b0.c(1));
        r112.leftToRight = r16.getId();
        r112.rightToRight = 0;
        r112.bottomToBottom = r16.getId();
        addView(r4, r112);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(0, (int) UIUtils.dip2Px(getContext(), 26.0f));
        r113.leftToLeft = 0;
        r113.rightToRight = 0;
        r113.setMargins(b0.c(10), b0.c(8), b0.c(10), 0);
        r113.topToBottom = r16.getId();
        addView(r6, r113);
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(-2, -2);
        r114.leftToLeft = r16.getId();
        r114.bottomToBottom = r16.getId();
        addView(r2, r114);
        setPadding(0, b0.c(8), 0, b0.c(8));
    }

    public final void S5(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "bizTag");
        Intrinsics.checkNotNullParameter(r3, "sceneTag");
        this.b = r2;
        this.a = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout] */
    public ProductView(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.a = "";
        this.b = "";
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        ToolsKt.b(r16);
        r16.setId(ViewCompat.generateViewId());
        GradientDrawable r17 = new GradientDrawable();
        r17.setCornerRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r17.setStroke((int) UIUtils.dip2Px(r16.getContext(), 0.5f), ColorProtector.parseColor("#F1F1F1"));
        r16.setBackground(r17);
        RoundingParams r18 = RoundingParams.fromCornersRadius(UIUtils.dip2Px(r16.getContext(), 4.0f));
        r16.getHierarchy().setRoundingParams(r18);
        Unit r19 = Unit.INSTANCE;
        this.c = r16;
        View r110 = new View(getContext());
        GradientDrawable r111 = new GradientDrawable();
        r111.setColor(ColorProtector.parseColor("#0A000000"));
        Intrinsics.checkNotNullParameter(r110, "$this$setBackgroundCompat");
        r110.setBackground(r111);
        this.d = r110;
        TextView r112 = new TextView(getContext());
        r112.setId(ViewCompat.generateViewId());
        r112.setTextColor(ColorProtector.parseColor("#161823"));
        ToolsKt.b(r112);
        r112.setMaxLines(1);
        r112.setIncludeFontPadding(false);
        r112.setTextSize(1, 14.0f);
        this.e = r112;
        PriceView r3 = new PriceView(getContext());
        r3.setId(ViewCompat.generateViewId());
        this.f = r3;
        TextView r4 = new TextView(getContext());
        r4.setId(ViewCompat.generateViewId());
        r4.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r4.setEllipsize(TextUtils.TruncateAt.END);
        ToolsKt.b(r4);
        r4.setMaxLines(1);
        r4.setIncludeFontPadding(false);
        r4.setTextSize(1, 13.0f);
        this.g = r4;
        ?? r5 = new ECRoundedLinearLayout(getContext(), null, 6, 0);
        r5.setId(ViewCompat.generateViewId());
        r5.setRadius(UIUtils.dip2Px(r5.getContext(), 4.0f));
        r5.setGravity(17);
        r5.addView(r4, new LinearLayout.LayoutParams(-2, -2));
        this.h = r5;
        ?? r0 = new AdTagView(getContext());
        r0.y();
        r0.setVisibility(8);
        this.i = r0;
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 48.0f), (int) UIUtils.dip2Px(getContext(), 48.0f));
        r6.topToTop = 0;
        r6.leftToLeft = 0;
        r6.setMargins(b0.c(10), 0, 0, 0);
        addView(r16, r6);
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(0, 0);
        r7.topToTop = r16.getId();
        r7.leftToLeft = r16.getId();
        r7.rightToRight = r16.getId();
        r7.bottomToBottom = r16.getId();
        addView(r110, r7);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(0, -2);
        r113.setMargins(b0.c(8), b0.c(3), b0.c(7), 0);
        r113.leftToRight = r16.getId();
        r113.rightToRight = 0;
        r113.topToTop = r16.getId();
        addView(r112, r113);
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(0, -2);
        r114.setMargins(b0.c(8), 0, b0.c(7), b0.c(1));
        r114.leftToRight = r16.getId();
        r114.rightToRight = 0;
        r114.bottomToBottom = r16.getId();
        addView(r3, r114);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(0, (int) UIUtils.dip2Px(getContext(), 26.0f));
        r115.leftToLeft = 0;
        r115.rightToRight = 0;
        r115.setMargins(b0.c(10), b0.c(8), b0.c(10), 0);
        r115.topToBottom = r16.getId();
        addView(r5, r115);
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(-2, -2);
        r116.leftToLeft = r16.getId();
        r116.bottomToBottom = r16.getId();
        addView(r0, r116);
        setPadding(0, b0.c(8), 0, b0.c(8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(CommonModel$Product r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "product");
        if (d0.b(this.c, r9.getCover(), this.b, this.a) == true) goto L5;
        this.c.setImageURI(r9.getCover());
    L5:
        this.e.setText(r9.getTitle());
        ToolsKt.y(this, r9.getAccessibilityLabel());
        if (r9.isReturnRewardContainerVisible() == false) goto L8;
        this.h.setVisibility(0);
        this.g.setText(r9.getRewardText());
    L9:
        boolean r0 = true;
        ViewGroup.LayoutParams r3 = null;
        if (r10 == false) goto L36;
        setPadding(0, (int) UIUtils.dip2Px(getContext(), 6.0f), 0, (int) UIUtils.dip2Px(getContext(), 6.0f));
        ViewGroup.LayoutParams r4 = this.c.getLayoutParams();
        if ((r4 instanceof ConstraintLayout.LayoutParams) == true) goto L14;
        r4 = null;
    L14:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        if (r5 == null) goto L17;
        r5.setMargins(b0.c(6), 0, 0, 0);
        ((ViewGroup.MarginLayoutParams) r5).width = b0.c(58);
        ((ViewGroup.MarginLayoutParams) r5).height = b0.c(58);
        this.c.setLayoutParams(r5);
    L17:
        ViewGroup.LayoutParams r6 = this.e.getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == true) goto L20;
        r6 = null;
    L20:
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        if (r7 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = b0.c(6);
        this.e.setLayoutParams(r7);
    L23:
        ViewGroup.LayoutParams r8 = this.f.getLayoutParams();
        if ((r8 instanceof ConstraintLayout.LayoutParams) == true) goto L26;
        r8 = null;
    L26:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r8;
        if (r12 == null) goto L29;
        ((ViewGroup.MarginLayoutParams) r12).bottomMargin = b0.c(6);
        this.f.setLayoutParams(r12);
    L29:
        this.d.setVisibility(0);
        ViewGroup.LayoutParams r13 = this.h.getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L33;
        r3 = r13;
    L33:
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r3;
        if (r14 == null) goto L61;
        r14.setMargins(b0.c(6), b0.c(6), b0.c(6), 0);
        this.h.setLayoutParams(r14);
    L61:
        PriceView r15 = this.f;
        CommonModel$Price r16 = r9.getPrice();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "price");
        r15.b.setText(r16.getKind());
        String r17 = "";
        r15.c.setText("" + r16.getIntegers());
        if (TextUtils.isEmpty(r16.getDecimals()) == true) goto L65;
        r17 = "" + r16.getDecimals();
    L65:
        if (TextUtils.isEmpty(r16.getUnit()) == true) goto L68;
        r17 = r17 + r16.getUnit();
    L68:
        if (r17.length() == 0) goto L71;
        r0 = false;
    L71:
        if (r0 == false) goto L73;
        r15.d.setVisibility(8);
    L75:
        if (TextUtils.isEmpty(r16.getAbove()) == false) goto L77;
        r15.e.setVisibility(8);
    L79:
        if (TextUtils.isEmpty(r16.getLabel()) == false) goto L81;
        r15.f.setVisibility(8);
    L82:
        if (r10 == false) goto L84;
        r15.b.setTypeface(Typeface.DEFAULT_BOLD);
        r15.c.setTypeface(Typeface.DEFAULT_BOLD);
        r15.d.setTypeface(Typeface.DEFAULT_BOLD);
        r15.e.setTypeface(Typeface.DEFAULT_BOLD);
        r15.f.setTypeface(Typeface.DEFAULT_BOLD);
    L85:
        if (r11 == false) goto L87;
        this.i.setVisibility(0);
        return;
    L87:
        this.i.setVisibility(8);
        return;
    L84:
        r15.b.setTypeface(Typeface.DEFAULT);
        r15.c.setTypeface(Typeface.DEFAULT);
        r15.d.setTypeface(Typeface.DEFAULT);
        r15.e.setTypeface(Typeface.DEFAULT);
        r15.f.setTypeface(Typeface.DEFAULT);
        goto L85
    L81:
        r15.f.setVisibility(0);
        r15.f.setText(r16.getLabel());
        goto L82
    L77:
        r15.e.setVisibility(0);
        r15.e.setText(r16.getAbove());
        goto L79
    L73:
        r15.d.setVisibility(0);
        r15.d.setText(r17);
        goto L75
    L36:
        setPadding(0, (int) UIUtils.dip2Px(getContext(), 8.0f), 0, (int) UIUtils.dip2Px(getContext(), 8.0f));
        ViewGroup.LayoutParams r18 = this.c.getLayoutParams();
        if ((r18 instanceof ConstraintLayout.LayoutParams) == true) goto L39;
        r18 = null;
    L39:
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        if (r19 == null) goto L42;
        r19.setMargins(b0.c(10), 0, 0, 0);
        ((ViewGroup.MarginLayoutParams) r19).width = b0.c(48);
        ((ViewGroup.MarginLayoutParams) r19).height = b0.c(48);
        this.c.setLayoutParams(r19);
    L42:
        ViewGroup.LayoutParams r20 = this.e.getLayoutParams();
        if ((r20 instanceof ConstraintLayout.LayoutParams) == true) goto L45;
        r20 = null;
    L45:
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        if (r21 == null) goto L48;
        ((ViewGroup.MarginLayoutParams) r21).topMargin = b0.c(3);
        this.e.setLayoutParams(r21);
    L48:
        ViewGroup.LayoutParams r22 = this.f.getLayoutParams();
        if ((r22 instanceof ConstraintLayout.LayoutParams) == true) goto L51;
        r22 = null;
    L51:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
        if (r23 == null) goto L54;
        ((ViewGroup.MarginLayoutParams) r23).bottomMargin = b0.c(1);
        this.f.setLayoutParams(r23);
    L54:
        this.d.setVisibility(8);
        ViewGroup.LayoutParams r24 = this.h.getLayoutParams();
        if ((r24 instanceof ConstraintLayout.LayoutParams) == false) goto L58;
        r3 = r24;
    L58:
        ConstraintLayout.LayoutParams r25 = (ConstraintLayout.LayoutParams) r3;
        if (r25 == null) goto L61;
        r25.setMargins(b0.c(10), b0.c(8), b0.c(10), 0);
        this.h.setLayoutParams(r25);
        goto L61
    L8:
        this.h.setVisibility(8);
        goto L9
    }
}
