package com.obric.oui.chip.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import wma.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010I\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010KJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J>\u0010\u001b\u001a\u00020\u000426\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0015J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00105\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b4\u0010,R\u0017\u00108\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,R*\u0010\u001a\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b\u001a\u0010<\"\u0004\b=\u0010>R$\u0010D\u001a\u00020?2\u0006\u00109\u001a\u00020?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006M"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "widgetBgColor", "", "setWidgetBgColor", "textColor", "setChipTextColor", "chipIconTintColor", "setChipIconTintColor", "closeIconTintColor", "setCloseIconTintColor", "arrowIconTintColor", "setArrowIconTintColor", "widgetBgColorDisabled", "setWidgetBgColorDisabled", "textColorDisabled", "setChipTextColorDisabled", "Landroid/view/View$OnClickListener;", "l", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "isOn", "setOnCheckedListener", "isToggleable", "setToggleable", "minWidth", "setMinimumWidth", "minHeight", "setMinimumHeight", "Lcom/obric/oui/layout/OUILinearLayout;", RXScreenCaptureService.KEY_INDEX, "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipContainer", "Landroid/widget/ImageView;", ce.f26395j, "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", ce.f26396k, "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "getCloseIcon", "closeIcon", "m", "getArrowIcon", "arrowIcon", "value", "y", "Z", "()Z", "setOn", "(Z)V", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f399414z = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f399415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OUILinearLayout f399416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f399417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f399418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f399419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f399420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f399421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f399422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f399423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f399424q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f399425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f399426s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f399427t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f399428u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function2<? super OChip, ? super Boolean, Unit> f399429v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnClickListener f399430w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<q> f399431x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f399432y;

    public static final class a {
    }

    static {
    }

    public OChip(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OChip(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final CharSequence getText() {
        return this.f399418k.getText();
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f399428u == false) goto L6;
        setOn(!this.f399432y);
    L6:
        return super.performClick();
    }

    public final ImageView getArrowIcon() {
        return this.f399420m;
    }

    public final OUILinearLayout getChipContainer() {
        return this.f399416i;
    }

    public final ImageView getChipIcon() {
        return this.f399417j;
    }

    public final ImageView getCloseIcon() {
        return this.f399419l;
    }

    public final TextView getTextView() {
        return this.f399418k;
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L27;
        int r101 = this.f399426s;
        if (r101 == 0) goto L7;
        this.f399416i.setBackgroundColor(r101);
    L7:
        if (this.f399421n == 0) goto L13;
        Drawable r102 = this.f399417j.getDrawable();
        if (r102 == null) goto L13;
        r102.setTint(this.f399421n);
    L13:
        if (this.f399422o == 0) goto L19;
        Drawable r103 = this.f399419l.getDrawable();
        if (r103 == null) goto L19;
        r103.setTint(this.f399422o);
    L19:
        if (this.f399423p == 0) goto L24;
        Drawable r104 = this.f399420m.getDrawable();
        if (r104 == null) goto L24;
        r104.setTint(this.f399423p);
    L24:
        int r105 = this.f399424q;
        if (r105 == 0) goto L38;
        this.f399418k.setTextColor(r105);
        return;
    L38:
        return;
    L27:
        int r106 = this.f399427t;
        if (r106 == 0) goto L31;
        this.f399416i.setBackgroundColor(r106);
    L31:
        if (this.f399425r == 0) goto L40;
        Drawable r107 = this.f399417j.getDrawable();
        if (r107 == null) goto L36;
        r107.setTint(this.f399425r);
    L36:
        this.f399418k.setTextColor(this.f399425r);
        return;
    }

    public final void setArrowIconTintColor(int r100) {
        if (r100 == 0) goto L10;
        this.f399423p = r100;
        if (this.f399432y == false) goto L11;
        Drawable r101 = this.f399420m.getDrawable();
        if (r101 == null) goto L12;
        r101.setTint(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipIconTintColor(int r100) {
        if (r100 == 0) goto L10;
        this.f399421n = r100;
        if (this.f399432y == false) goto L11;
        Drawable r101 = this.f399417j.getDrawable();
        if (r101 == null) goto L12;
        r101.setTint(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipTextColor(int r100) {
        if (r100 == 0) goto L7;
        this.f399424q = r100;
        if (this.f399432y == false) goto L8;
        this.f399418k.setTextColor(r100);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r100) {
        if (r100 == 0) goto L11;
        this.f399425r = r100;
        if (this.f399432y == true) goto L12;
        Drawable r101 = this.f399417j.getDrawable();
        if (r101 == null) goto L9;
        r101.setTint(r100);
    L9:
        this.f399418k.setTextColor(r100);
        return;
    L12:
        return;
    }

    public final void setCloseIconTintColor(int r100) {
        if (r100 == 0) goto L10;
        this.f399422o = r100;
        if (this.f399432y == false) goto L11;
        Drawable r101 = this.f399419l.getDrawable();
        if (r101 == null) goto L12;
        r101.setTint(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r100) {
        super.setMinimumHeight(r100);
        this.f399416i.setMinimumHeight(r100);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r100) {
        super.setMinimumWidth(r100);
        this.f399416i.setMinimumWidth(r100);
    }

    public final void setOn(boolean r100) {
        if (this.f399432y == r100) goto L9;
        this.f399432y = r100;
        d(r100);
        Function2<? super OChip, ? super Boolean, Unit> r101 = this.f399429v;
        if (r101 == null) goto L10;
        r101.invoke(this, Boolean.valueOf(this.f399432y));
        return;
    L10:
        return;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f399429v = r100;
    }

    public final void setOnCloseListener(View.OnClickListener r100) {
        this.f399430w = r100;
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f399418k.setText(r100);
    }

    public final void setToggleable(boolean r100) {
        this.f399428u = r100;
    }

    public final void setWidgetBgColor(int r100) {
        if (r100 == 0) goto L7;
        this.f399426s = r100;
        if (this.f399432y == false) goto L8;
        this.f399416i.setBackgroundColor(r100);
        return;
    L8:
        return;
    }

    public final void setWidgetBgColorDisabled(int r100) {
        if (r100 == 0) goto L7;
        this.f399427t = r100;
        if (this.f399432y == true) goto L8;
        this.f399416i.setBackgroundColor(r100);
        return;
    L8:
        return;
    }

    public OChip(Context r110, AttributeSet r210, int r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r210, r211, 8);
        View r100 = FrameLayout.inflate(r110, R.layout.o_chip_v2, this);
        this.f399415h = r100;
        OUILinearLayout r101 = (OUILinearLayout) r100.findViewById(R.id.chip_container);
        this.f399416i = r101;
        ImageView r102 = (ImageView) r100.findViewById(R.id.chip_icon);
        this.f399417j = r102;
        TextView r103 = (TextView) r100.findViewById(R.id.chip_text);
        this.f399418k = r103;
        ImageView r104 = (ImageView) r100.findViewById(R.id.close_icon);
        this.f399419l = r104;
        ImageView r105 = (ImageView) r100.findViewById(R.id.arrow_icon);
        this.f399420m = r105;
        this.f399432y = true;
        TypedArray r111 = r110.obtainStyledAttributes(r210, new int[]{R.attr.oui_arrow_icon_tint_color, R.attr.oui_chipArrowIcon, R.attr.oui_chipArrowSpaceL, R.attr.oui_chipArrowSpaceR, R.attr.oui_chipIconSpaceL, R.attr.oui_chipIconSpaceR, R.attr.oui_chip_icon, R.attr.oui_chip_icon_tint_color, R.attr.oui_chip_style, R.attr.oui_chip_toggleable, R.attr.oui_close_icon, R.attr.oui_close_icon_tint_color, R.attr.oui_enable_checked, R.attr.oui_text, R.attr.oui_text_color, R.attr.oui_text_color_disabled, R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorDisabled, R.attr.oui_widgetPaddingL, R.attr.oui_widgetPaddingR, R.attr.oui_widgetPressColor, R.attr.oui_widgetShadowNormal});
        getChipIcon().setImageDrawable(r111.getDrawable(6));
        getTextView().setText(r111.getText(13));
        getCloseIcon().setImageDrawable(r111.getDrawable(10));
        getArrowIcon().setImageDrawable(r111.getDrawable(1));
        this.f399421n = r111.getColor(7, 0);
        this.f399422o = r111.getColor(11, 0);
        this.f399423p = r111.getColor(0, 0);
        this.f399424q = r111.getColor(14, 0);
        this.f399425r = r111.getColor(15, 0);
        this.f399426s = r111.getColor(16, 0);
        this.f399427t = r111.getColor(17, 0);
        this.f399428u = r111.getBoolean(9, false);
        int r112 = r111.getDimensionPixelSize(18, 0);
        int r113 = r111.getDimensionPixelSize(19, 0);
        int r114 = r111.getDimensionPixelSize(4, 0);
        int r115 = r111.getDimensionPixelSize(5, 0);
        int r106 = r111.getDimensionPixelSize(2, 0);
        r111.getDimensionPixelSize(3, 0);
        getChipContainer().setPadding(r112, getChipContainer().getPaddingTop(), r113, getChipContainer().getPaddingBottom());
        int r107 = r111.getColor(20, 0);
        if (r107 == 0) goto L5;
        getChipContainer().setOverridePressColor(r107);
        getChipContainer().m1("OChip");
    L5:
        List<q> r108 = l.b(r110, r111, 21);
        if (r108 == null) goto L8;
        this.f399431x = r108;
        Intrinsics.checkNotNull(r108);
        q r116 = (q) CollectionsKt.getOrNull(r108, 0);
        List<q> r117 = this.f399431x;
        Intrinsics.checkNotNull(r117);
        int r118 = 0;
        c(r116, (q) CollectionsKt.getOrNull(r117, 1), false);
    L9:
        if (r108 == null) goto L11;
        boolean r109 = true;
    L12:
        r111.recycle();
        TypedArray r119 = r110.obtainStyledAttributes(r210, new int[]{android.R.attr.minWidth, android.R.attr.minHeight});
        int r120 = r119.getDimensionPixelSize(r118, r118);
        int r121 = r119.getDimensionPixelSize(1, r118);
        if (r120 <= 0) goto L15;
        getChipContainer().setMinimumWidth(r120);
    L15:
        if (r121 <= 0) goto L17;
        getChipContainer().setMinimumHeight(r121);
    L17:
        r119.recycle();
        setChangeAlphaWhenPress(false);
        if (r102.getDrawable() == null) goto L20;
        boolean r122 = true;
    L22:
        if (r122 == false) goto L28;
        ViewGroup.LayoutParams r123 = r103.getLayoutParams();
        if (r123 == null) goto L27;
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        r124.setMarginStart(r114);
        r103.setLayoutParams(r124);
        r102.setVisibility(0);
    L32:
        if (r104.getDrawable() == null) goto L34;
        boolean r125 = true;
    L35:
        if (r125 == false) goto L41;
        ViewGroup.LayoutParams r126 = r104.getLayoutParams();
        if (r126 == null) goto L40;
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        r127.setMarginStart(r115);
        r104.setLayoutParams(r127);
        r104.setVisibility(0);
        r104.setOnClickListener(new nla.a(this));
    L45:
        if (r105.getDrawable() == null) goto L47;
        boolean r128 = true;
    L48:
        if (r128 == false) goto L54;
        ViewGroup.LayoutParams r129 = r105.getLayoutParams();
        if (r129 == null) goto L53;
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r129;
        r130.setMarginStart(r106);
        r105.setLayoutParams(r130);
        r105.setVisibility(0);
    L57:
        d(true);
        int r131 = d.n(this, 99);
        if (r109 == false) goto L60;
        b.a("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r131);
        r101.setRadius(r131);
    L61:
        setClipChildren(false);
        return;
    L60:
        setRadius(r131);
        goto L61
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        ViewGroup.LayoutParams r132 = r105.getLayoutParams();
        if (r132 == null) goto L64;
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
        r133.setMarginStart(0);
        r105.setLayoutParams(r133);
        r105.setVisibility(8);
        goto L57
    L64:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L47:
        r128 = false;
        goto L48
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L41:
        ViewGroup.LayoutParams r134 = r104.getLayoutParams();
        if (r134 == null) goto L66;
        ViewGroup.MarginLayoutParams r135 = (ViewGroup.MarginLayoutParams) r134;
        r135.setMarginStart(0);
        r104.setLayoutParams(r135);
        r104.setVisibility(8);
        goto L45
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        r125 = false;
        goto L35
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        ViewGroup.LayoutParams r136 = r103.getLayoutParams();
        if (r136 == null) goto L68;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136;
        r137.setMarginStart(0);
        r103.setLayoutParams(r137);
        r102.setVisibility(8);
        goto L32
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        r122 = false;
        goto L22
    L11:
        r109 = false;
        goto L12
    L8:
        r118 = 0;
        goto L9
    }

    public /* synthetic */ OChip(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
