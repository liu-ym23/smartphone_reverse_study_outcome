package com.obric.oui.chip;

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
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes33.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\f\u001a\u00020\u000426\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "checked", "setOnCheckedListener", "Landroid/widget/ImageView;", RXScreenCaptureService.KEY_INDEX, "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", ce.f26395j, "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", ce.f26396k, "getCloseIcon", "closeIcon", "", "value", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f399405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f399406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f399407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f399408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f399409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f399410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function2<? super OChip, ? super Boolean, Unit> f399411n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum Style extends Enum<Style> {
        public static final Style Default = null;
        public static final Style Rect = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f399412a = null;

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f399412a.clone();
        }

        static {
            Style r100 = new Style("Default", 0);
            Default = r100;
            Style r101 = new Style("Rect", 1);
            Rect = r101;
            f399412a = new Style[]{r100, r101};
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399413a = null;

        static {
            int[] r100 = new int[Style.values().length];
            r100[Style.Default.ordinal()] = 1;
            r100[Style.Rect.ordinal()] = 2;
            f399413a = r100;
        }
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
        return this.f399407j.getText();
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f399409l == false) goto L6;
        boolean r100 = !this.f399410m;
        this.f399410m = r100;
        this.f399411n.invoke(this, Boolean.valueOf(r100));
    L6:
        return super.performClick();
    }

    public final ImageView getChipIcon() {
        return this.f399406i;
    }

    public final ImageView getCloseIcon() {
        return this.f399408k;
    }

    public final TextView getTextView() {
        return this.f399407j;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f399411n = r100;
    }

    public final void setOnCloseListener(View.OnClickListener r100) {
        this.f399408k.setOnClickListener(r100);
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f399407j.setText(r100);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OChip(final Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112, 8);
        View r113 = FrameLayout.inflate(r110, R.layout.o_chip, this);
        this.f399405h = r113;
        ImageView r100 = (ImageView) r113.findViewById(R.id.chip_icon);
        this.f399406i = r100;
        TextView r101 = (TextView) r113.findViewById(R.id.chip_text);
        this.f399407j = r101;
        ImageView r114 = (ImageView) r113.findViewById(R.id.close_icon);
        this.f399408k = r114;
        this.f399411n = new OChip$onCheckedListener$1(this, r110);
        TypedArray r115 = r110.obtainStyledAttributes(r111, new int[]{R.attr.oui_arrow_icon_tint_color, R.attr.oui_chipArrowIcon, R.attr.oui_chipArrowSpaceL, R.attr.oui_chipArrowSpaceR, R.attr.oui_chipIconSpaceL, R.attr.oui_chipIconSpaceR, R.attr.oui_chip_icon, R.attr.oui_chip_icon_tint_color, R.attr.oui_chip_style, R.attr.oui_chip_toggleable, R.attr.oui_close_icon, R.attr.oui_close_icon_tint_color, R.attr.oui_enable_checked, R.attr.oui_text, R.attr.oui_text_color, R.attr.oui_text_color_disabled, R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorDisabled, R.attr.oui_widgetPaddingL, R.attr.oui_widgetPaddingR, R.attr.oui_widgetPressColor, R.attr.oui_widgetShadowNormal});
        getChipIcon().setImageDrawable(r115.getDrawable(6));
        getTextView().setText(r115.getText(13));
        getCloseIcon().setImageDrawable(r115.getDrawable(10));
        int r116 = r115.getColor(7, -1);
        int r102 = r115.getColor(11, -1);
        int r103 = r115.getColor(14, -1);
        this.f399409l = r115.getBoolean(12, false);
        Style r104 = Style.values()[r115.getInt(8, 0)];
        r115.recycle();
        if (r100.getDrawable() == null) goto L5;
        boolean r117 = true;
    L7:
        if (r117 == false) goto L13;
        ViewGroup.LayoutParams r118 = r101.getLayoutParams();
        if (r118 == null) goto L12;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        r119.setMarginStart(d.n(this, 4));
        r101.setLayoutParams(r119);
        r100.setVisibility(0);
    L17:
        if (r114.getDrawable() == null) goto L19;
        boolean r120 = true;
    L20:
        if (r120 == false) goto L26;
        ViewGroup.LayoutParams r121 = r101.getLayoutParams();
        if (r121 == null) goto L25;
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        r122.setMarginEnd(d.n(this, 6));
        r101.setLayoutParams(r122);
        r114.setVisibility(0);
    L29:
        if (r116 == (-1)) goto L34;
        Drawable r123 = r100.getDrawable();
        if (r123 == null) goto L34;
        r123.setTint(r116);
    L34:
        if (r102 == (-1)) goto L39;
        Drawable r124 = r114.getDrawable();
        if (r124 == null) goto L39;
        r124.setTint(r102);
    L39:
        if (r103 == (-1)) goto L41;
        r101.setTextColor(r103);
    L41:
        int r125 = a.f399413a[r104.ordinal()];
        if (r125 != 1) goto L44;
        int r126 = d.n(this, 99);
    L49:
        setRadius(r126);
        return;
    L44:
        if (r125 != 2) goto L47;
        r126 = d.n(this, 8);
        goto L49
    L47:
        throw new NoWhenBranchMatchedException();
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L26:
        ViewGroup.LayoutParams r127 = r101.getLayoutParams();
        if (r127 == null) goto L52;
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        r128.setMarginEnd(d.n(this, 6));
        r101.setLayoutParams(r128);
        r114.setVisibility(8);
        goto L29
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r120 = false;
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ViewGroup.LayoutParams r129 = r101.getLayoutParams();
        if (r129 == null) goto L54;
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r129;
        r130.setMarginStart(d.n(this, 6));
        r101.setLayoutParams(r130);
        r100.setVisibility(8);
        goto L17
    L54:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r117 = false;
        goto L7
    }

    public /* synthetic */ OChip(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
