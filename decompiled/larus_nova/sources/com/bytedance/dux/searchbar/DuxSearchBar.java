package com.bytedance.dux.searchbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import bm4.c;
import com.amap.api.col.s.ce;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.forms.DuxFormEditText;
import com.bytedance.dux.forms.DuxLineInputView;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.dux.theme.ForceDayNight;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.d;
import em4.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u0014\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0012\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0017\u0010-\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00102\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/bytedance/dux/searchbar/DuxSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enable", "", "setAdaptLargeFont", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/dux/searchbar/DuxSearchBar$b;", "getConfig", "", "text", "setText", "getText", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setEditOnFocusChange", "Landroid/text/TextWatcher;", "watcher", "setEditTextWatcher", "Lcom/bytedance/dux/forms/DuxLineInputView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/dux/forms/DuxLineInputView;", "getDuxInputView", "()Lcom/bytedance/dux/forms/DuxLineInputView;", "duxInputView", "Lcom/bytedance/dux/image/DuxImageView;", "b", "Lcom/bytedance/dux/image/DuxImageView;", "getIvBack", "()Lcom/bytedance/dux/image/DuxImageView;", "ivBack", "Lcom/bytedance/dux/text/DuxTextView;", "c", "Lcom/bytedance/dux/text/DuxTextView;", "getTvSearchAction", "()Lcom/bytedance/dux/text/DuxTextView;", "tvSearchAction", "d", "getIvSearchAction", "ivSearchAction", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getInputSearchIconContainer", "()Landroid/view/ViewGroup;", "inputSearchIconContainer", ce.f26391f, "Landroid/view/View$OnFocusChangeListener;", "getDefault_Focus_Change_Listener", "()Landroid/view/View$OnFocusChangeListener;", "Default_Focus_Change_Listener", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DuxComponent f205551i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxLineInputView f205552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxImageView f205553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f205554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxImageView f205555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f205556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yl4.a f205558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f205559h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f205560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f205561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View.OnClickListener f205562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f205563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f205564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f205565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View.OnClickListener f205566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f205567h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Drawable f205568i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final View.OnClickListener f205569j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f205570k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final View.OnClickListener f205571l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f205572m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f205573n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final View.OnFocusChangeListener f205574o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final TextWatcher f205575p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f205576q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f205577r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Boolean f205578s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f205579t;

        public b(boolean r100, Drawable r101, View.OnClickListener r102, boolean r103, String r104, Integer r105, View.OnClickListener r106, boolean r110, Drawable r111, View.OnClickListener r112, boolean r113, View.OnClickListener r114, String r115, String r116, View.OnFocusChangeListener r117, TextWatcher r118, Boolean r119, boolean r210) {
            this.f205560a = r100;
            this.f205561b = r101;
            this.f205562c = r102;
            this.f205563d = r103;
            this.f205564e = r104;
            this.f205565f = r105;
            this.f205566g = r106;
            this.f205567h = r110;
            this.f205568i = r111;
            this.f205569j = r112;
            this.f205570k = r113;
            this.f205571l = r114;
            this.f205572m = r115;
            this.f205573n = r116;
            this.f205574o = r117;
            this.f205575p = r118;
            this.f205576q = false;
            this.f205577r = true;
            this.f205578s = r119;
            this.f205579t = r210;
        }
    }

    public DuxSearchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "originContext");
        this(r100, null, 30);
    }

    public DuxSearchBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "originContext");
        this(r100, r101, 28);
    }

    static {
        f205551i = DuxComponent.SEARCH_BAR;
    }

    public final String getText() {
        return this.f205552a.getText();
    }

    public final b getConfig() {
        return this.f205559h;
    }

    public final View.OnFocusChangeListener getDefault_Focus_Change_Listener() {
        return this.f205558g;
    }

    public final DuxLineInputView getDuxInputView() {
        return this.f205552a;
    }

    public final ViewGroup getInputSearchIconContainer() {
        return this.f205556e;
    }

    public final DuxImageView getIvBack() {
        return this.f205553b;
    }

    public final DuxImageView getIvSearchAction() {
        return this.f205555d;
    }

    public final DuxTextView getTvSearchAction() {
        return this.f205554c;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205557f = DuxLargeFontHelper.a(f205551i, r100);
    }

    public final void setEditOnFocusChange(View.OnFocusChangeListener r100) {
        DuxLineInputView r101 = this.f205552a;
        DuxLineInputView.b r102 = r101.getConfig();
        r102.f205155k = r100;
        r101.Y5(r102);
    }

    public final void setEditTextWatcher(TextWatcher r100) {
        DuxLineInputView r101 = this.f205552a;
        DuxLineInputView.b r102 = r101.getConfig();
        r102.f205154j = r100;
        r101.Y5(r102);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f205552a.setText(r100);
    }

    public DuxSearchBar(Context r310, AttributeSet r311, int r312) {
        if ((r312 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r312 & 4) == 0) goto L9;
        ForceDayNight r101 = ForceDayNight.NONE;
    L10:
        Intrinsics.checkNotNullParameter(r310, "originContext");
        Intrinsics.checkNotNullParameter(r101, "forceDayNight");
        int r102 = bm4.b.f19592a;
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "forceDayNight");
        if (r101 == ForceDayNight.NONE) goto L13;
        int r103 = r101.getAttrValue();
    L22:
        ForceDayNight r104 = ForceDayNight.DARK;
        if (r103 != r104.getAttrValue()) goto L25;
        Intrinsics.checkNotNullParameter(r310, "<this>");
        Context r105 = new bm4.b(bm4.a.a(r310, true), r310, r104);
    L29:
        if (r105 != null) goto L32;
        r105 = r310;
    L32:
        super(r105, r100);
        Lazy r106 = DuxLargeFontHelper.f205243a;
        this.f205557f = DuxLargeFontHelper.a(f205551i, null);
        this.f205558g = new yl4.a(this);
        yl4.b r107 = new yl4.b(this);
        String r108 = "搜索";
        Intrinsics.checkNotNullParameter("搜索", "textActionContent");
        this.f205559h = new b(false, null, null, true, "搜索", null, null, false, null, null, true, null, null, null, null, null, null, false);
        ViewGroup.inflate(getContext(), R.layout.dux_widget_search_bar, this);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Transparent));
        this.f205559h.f205579t = false;
        TypedArray r109 = getContext().getTheme().obtainStyledAttributes(r100, new int[]{android.R.attr.text, android.R.attr.hint, R.attr.adaptLargeFontMode, R.attr.iconActionRes, R.attr.limitLargeFontScale, R.attr.searchActionRes, R.attr.showBackIcon, R.attr.showTextAction, R.attr.textActionContent}, 0, 0);
        this.f205559h.f205573n = r109.getString(1);
        this.f205559h.f205572m = r109.getString(0);
        this.f205559h.f205570k = r109.getBoolean(6, true);
        this.f205559h.f205563d = r109.getBoolean(7, true);
        b r110 = this.f205559h;
        String r111 = r109.getString(8);
        if (r111 == null) goto L36;
        r108 = r111;
    L36:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r110.f205564e = r108;
        this.f205559h.f205568i = r109.getDrawable(5);
        b r112 = this.f205559h;
        if (r112.f205568i == null) goto L39;
        r112.f205567h = true;
    L39:
        r112.f205561b = r109.getDrawable(3);
        b r113 = this.f205559h;
        if (r113.f205561b == null) goto L43;
        r113.f205560a = true;
        r113.f205563d = false;
    L43:
        if (r109.hasValue(2) == false) goto L45;
        this.f205559h.f205578s = Boolean.valueOf(r109.getBoolean(2, false));
    L45:
        this.f205559h.f205579t = r109.getBoolean(4, false);
        DuxLineInputView r114 = (DuxLineInputView) findViewById(R.id.input_view);
        this.f205552a = r114;
        DuxImageView r115 = (DuxImageView) findViewById(R.id.iv_back);
        this.f205553b = r115;
        DuxImageView r116 = (DuxImageView) findViewById(R.id.iv_search_action);
        this.f205555d = r116;
        DuxTextView r117 = (DuxTextView) findViewById(R.id.tv_search_action);
        this.f205554c = r117;
        DuxLineInputView.b r118 = r114.getConfig();
        Context r119 = getContext();
        Intrinsics.checkNotNull(r119);
        View r120 = LayoutInflater.from(r119).inflate(R.layout.dux_widget_search_bar_prefix, null);
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r121 = (ViewGroup) r120;
        this.f205556e = r121;
        r118.f205149e = r120;
        r118.f205164t = true;
        r118.f205168x = false;
        r118.f205154j = r107;
        r114.Y5(r118);
        Context r122 = getContext();
        Intrinsics.checkNotNull(r122);
        Drawable r123 = ContextCompat.getDrawable(r122, R.drawable.dux_bg_search_bar_input);
        Intrinsics.checkNotNull(r123);
        r114.setInputContainerBackground(r123);
        r114.f205140v.setPadding(0, 0, 0, 0);
        r114.La();
        n.f(r114.f205135q);
        r114.F = true;
        r114.setAutoHideClearWhenTextEmpty(true);
        ImageView r124 = r114.getIvClear();
        Context r125 = r114.getContext();
        Intrinsics.checkNotNull(r125);
        ImageViewCompat.setImageTintList(r124, ColorStateList.valueOf(ContextCompat.getColor(r125, R.color.TextQuaternary)));
        int r126 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, R5(Resources.getSystem())));
        EditText r127 = r114.getInterEditText();
        if ((r127 instanceof DuxFormEditText) == false) goto L55;
        DuxFormEditText r128 = (DuxFormEditText) r127;
        r128.setFadingEdgeLength(r126);
        r128.f205121c = false;
        r128.f205123e = false;
        r128.f205122d = true;
        r128.f205124f = false;
        r128.setHorizontalFadingEdgeEnabled(true);
        if (r128.f205123e == false) goto L50;
    L53:
        boolean r129 = true;
    L54:
        r128.setVerticalFadingEdgeEnabled(r129);
        goto L55
    L50:
        if (r128.f205124f == true) goto L53;
        r129 = false;
    L55:
        ViewGroup r130 = r114.getActionContainer();
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L181;
        ConstraintLayout.LayoutParams r132 = (ConstraintLayout.LayoutParams) r131;
        r132.setMarginStart(0);
        r132.setMarginEnd(0);
        r130.setLayoutParams(r132);
        AppCompatEditText r133 = r114.getEditText();
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        if (r134 == null) goto L179;
        ConstraintLayout.LayoutParams r135 = (ConstraintLayout.LayoutParams) r134;
        float r136 = 8;
        r135.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r136, R5(Resources.getSystem()))));
        r135.goneEndMargin = 0;
        r133.setLayoutParams(r135);
        ImageView r137 = r114.getIvClear();
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        if (r138 == null) goto L177;
        LinearLayout.LayoutParams r139 = (LinearLayout.LayoutParams) r138;
        r139.setMarginStart(0);
        r139.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r136, R5(Resources.getSystem()))));
        r137.setLayoutParams(r139);
        ImageView r140 = r114.getIvAction();
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
        if (r141 == null) goto L175;
        LinearLayout.LayoutParams r142 = (LinearLayout.LayoutParams) r141;
        r142.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, R5(Resources.getSystem()))));
        r142.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r136, R5(Resources.getSystem()))));
        r140.setLayoutParams(r142);
        b r143 = this.f205559h;
        Intrinsics.checkNotNullParameter(r143, "config");
        this.f205559h = r143;
        setAdaptLargeFont(r143.f205578s);
        if (r143.f205573n == null) goto L66;
        DuxLineInputView.b r144 = r114.getConfig();
        r144.f205148d = r143.f205573n;
        r114.Y5(r144);
    L66:
        String r145 = r143.f205572m;
        if (r145 != null) goto L69;
    L72:
        boolean r146 = true;
    L73:
        if (r146 == true) goto L76;
        setText(String.valueOf(r143.f205572m));
    L76:
        if (r143.f205570k == true) goto L78;
        n.e(r115);
        this.f205559h.f205570k = false;
    L79:
        View.OnClickListener r147 = r143.f205571l;
        if (r147 == null) goto L82;
        r115.setOnClickListener(r147);
    L82:
        Drawable r148 = r143.f205561b;
        if (r148 == null) goto L88;
        Intrinsics.checkNotNull(r148);
        View.OnClickListener r149 = r143.f205562c;
        r116.setImageDrawable(r148);
        if (r149 == null) goto L88;
        r116.setOnClickListener(r149);
    L88:
        if (r143.f205560a == true) goto L90;
        n.e(r116);
        this.f205559h.f205560a = false;
    L93:
        String r150 = r143.f205564e;
        Integer r151 = r143.f205565f;
        View.OnClickListener r152 = r143.f205566g;
        if (TextUtils.isEmpty(r150) == true) goto L96;
        r117.setText(r150);
    L96:
        if (r152 == null) goto L98;
        r117.setOnClickListener(r152);
    L98:
        if (r151 == null) goto L100;
        r117.setTextColor(r151.intValue());
    L102:
        if (r143.f205563d == false) goto L104;
        n.f(r117);
        n.e(r116);
        b r153 = this.f205559h;
        r153.f205560a = false;
        r153.f205563d = true;
    L105:
        Drawable r154 = r143.f205568i;
        if (r154 == null) goto L112;
        Intrinsics.checkNotNull(r154);
        View.OnClickListener r155 = r143.f205569j;
        DuxLineInputView.b r156 = r114.getConfig();
        r156.f205157m = r154;
        if (r155 == null) goto L110;
        r156.f205159o = r155;
    L110:
        r114.Y5(r156);
    L112:
        if (r143.f205567h == false) goto L117;
        if (this.f205559h.f205568i == null) goto L123;
        r114.U5();
        this.f205559h.f205567h = true;
    L123:
        TextWatcher r157 = r143.f205575p;
        if (r157 == null) goto L126;
        Intrinsics.checkNotNull(r157);
        setEditTextWatcher(r157);
    L126:
        View.OnFocusChangeListener r158 = r143.f205574o;
        if (r158 == null) goto L129;
        Intrinsics.checkNotNull(r158);
        setEditOnFocusChange(r158);
    L129:
        DuxLineInputView.b r159 = r114.getConfig();
        r159.f205168x = r143.f205576q;
        r159.f205169y = r143.f205578s;
        r159.f205170z = r143.f205579t;
        r114.Y5(r159);
        r114.setAutoHideClearWhenTextEmpty(r143.f205577r);
        if (this.f205557f == false) goto L188;
        ViewGroup.LayoutParams r160 = r115.getLayoutParams();
        if (r160 == null) goto L173;
        if (this.f205559h.f205579t == false) goto L137;
        int r161 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L138:
        r160.width = r161;
        if (this.f205559h.f205579t == false) goto L141;
        int r162 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L142:
        r160.height = r162;
        r115.setLayoutParams(r160);
        if (this.f205559h.f205579t == false) goto L145;
        com.bytedance.dux.largefont.a.c(r117, 15.0f);
    L146:
        ViewGroup.LayoutParams r163 = r116.getLayoutParams();
        if (r163 == null) goto L171;
        ViewGroup.MarginLayoutParams r164 = (ViewGroup.MarginLayoutParams) r163;
        if (this.f205559h.f205579t == false) goto L151;
        int r165 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L152:
        r164.width = r165;
        if (this.f205559h.f205579t == false) goto L155;
        int r166 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L156:
        r164.height = r166;
        float r167 = 16;
        r164.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r167, R5(Resources.getSystem()))));
        r116.setLayoutParams(r164);
        r121.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r136, R5(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r136, R5(Resources.getSystem()))), 0);
        ImageView r168 = (ImageView) r121.findViewById(R.id.iv_search);
        ViewGroup.LayoutParams r169 = r168.getLayoutParams();
        if (r169 == null) goto L169;
        if (this.f205559h.f205579t == false) goto L161;
        int r170 = MathKt.roundToInt(TypedValue.applyDimension(1, RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r167, R5(Resources.getSystem())));
    L162:
        r169.width = r170;
        if (this.f205559h.f205579t == false) goto L165;
        int r171 = MathKt.roundToInt(TypedValue.applyDimension(1, r167 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L166:
        r169.height = r171;
        r168.setLayoutParams(r169);
        return;
    L165:
        r171 = MathKt.roundToInt(TypedValue.applyDimension(2, r167, R5(Resources.getSystem())));
        goto L166
    L161:
        r170 = MathKt.roundToInt(TypedValue.applyDimension(2, r167, R5(Resources.getSystem())));
        goto L162
    L169:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L155:
        r166 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L156
    L151:
        r165 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L152
    L171:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L145:
        r117.setTextSize(2, 15.0f);
        goto L146
    L141:
        r162 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L142
    L137:
        r161 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L138
    L173:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L188:
        return;
    L117:
        if (r114.f205133o.getVisibility() != 0) goto L119;
        boolean r172 = true;
    L120:
        if (r172 == false) goto L122;
        n.e(r114.f205133o);
    L122:
        r114.I = false;
        this.f205559h.f205567h = false;
        goto L123
    L119:
        r172 = false;
        goto L120
    L104:
        n.e(r117);
        this.f205559h.f205563d = false;
        goto L105
    L100:
        r117.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
        goto L102
    L90:
        if (this.f205559h.f205561b == null) goto L93;
        n.f(r116);
        this.f205559h.f205560a = true;
        n.e(r117);
        this.f205559h.f205563d = false;
        goto L93
    L78:
        n.f(r115);
        n.a(r115, MathKt.roundToInt(TypedValue.applyDimension(1, 44, R5(Resources.getSystem()))));
        this.f205559h.f205570k = true;
        goto L79
    L69:
        if (r145.length() == 0) goto L72;
        r146 = false;
        goto L73
    L175:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L177:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L179:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L181:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L25:
        ForceDayNight r173 = ForceDayNight.LIGHT;
        if (r103 != r173.getAttrValue()) goto L28;
        Intrinsics.checkNotNullParameter(r310, "<this>");
        r105 = new bm4.b(bm4.a.a(r310, false), r310, r173);
        goto L29
    L28:
        r105 = null;
        goto L29
    L13:
        TypedArray r174 = r310.getTheme().obtainStyledAttributes(r100, new int[]{R.attr.forceDayNightTheme}, 0, 0);
        r103 = r174.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L18
        r174.recycle();
    L184:
        goto L22
    L16:
        th = move-exception;
        r174.recycle();
        throw th;
    L18:
        e = move-exception;
        int r175 = d.f473061a;     // Catch: Throwable -> L16
        d.b(c.class.getSimpleName(), "parseForceDarkAttr failed: " + e);     // Catch: Throwable -> L16
        r174.recycle();
        r103 = 0;
        goto L184
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = r311;
        goto L7
    }
}
