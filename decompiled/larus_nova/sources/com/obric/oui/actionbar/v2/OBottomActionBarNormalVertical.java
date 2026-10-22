package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.obric.oui.divider.ODivider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical;", "Landroid/widget/FrameLayout;", "", "getButtonCount", "", "Landroid/view/View;", "buttons", "", "setButtons", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "headerView", "setHeaderView", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getBOTTOM_ACTION_PADDING_BOTTOM", "()I", "BOTTOM_ACTION_PADDING_BOTTOM", "b", "getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBottomActionBarNormalVertical extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f398717i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ODivider f398720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f398721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f398722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f398723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f398724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f398725h;

    public static final class a {
    }

    static {
    }

    public final int getButtonCount() {
        return this.f398722e.getChildCount();
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM() {
        return this.f398718a;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE() {
        return this.f398719b;
    }

    public final int getMaxButtonCount() {
        return this.f398725h;
    }

    public OBottomActionBarNormalVertical(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(int r100) {
        if (zma.a.g(getContext()) == true) goto L7;
        if (r100 <= 0) goto L7;
        int r101 = this.f398719b;
    L8:
        View r102 = this.f398721d;
        r102.setPaddingRelative(r102.getPaddingLeft(), this.f398721d.getPaddingTop(), this.f398721d.getPaddingRight(), Math.max(r100, d.n(this, r101)));
        return;
    L7:
        r101 = this.f398718a;
        goto L8
    }

    public final void setButtons(List<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "buttons");
        this.f398722e.removeAllViews();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        View r102 = (View) r101.next();
        Intrinsics.checkNotNullParameter(r102, "button");
        int r103 = this.f398722e.getChildCount();
        int r104 = this.f398725h;
        if (r103 >= r104) goto L7;
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        if (r105 == null) goto L11;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(r105.width, r105.height);
    L12:
        LinearLayout r107 = this.f398722e;
        if (r107.getChildCount() <= 0) goto L15;
        r106.topMargin = this.f398724g;
    L15:
        Unit r108 = Unit.INSTANCE;
        r107.addView(r102, r106);
        goto L4
    L11:
        r106 = new LinearLayout.LayoutParams(-1, -2);
        goto L12
    L7:
        wma.b.h("OBottomActionBarNormalVertical", Intrinsics.stringPlus("Maximum number of buttons reached: ", Integer.valueOf(r104)));
        goto L4
    }

    public final void setHeaderView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "headerView");
        this.f398723f.removeAllViews();
        this.f398723f.addView(r100);
        ViewGroup.LayoutParams r101 = this.f398722e.getLayoutParams();
        if (r101 == null) goto L7;
        int r102 = d.n(this, 8);
        ((ViewGroup.MarginLayoutParams) r101).topMargin = r102;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setMaxButtonCount(int r100) {
        if (this.f398722e.getChildCount() <= r100) goto L6;
        wma.b.b("OBottomActionBarNormalVertical", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r100 <= 0) goto L8;
        this.f398725h = r100;
        return;
    L8:
        wma.b.b("OBottomActionBarNormalVertical", "Max button count must be greater than 0");
    }

    public OBottomActionBarNormalVertical(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f398718a = 24;
        this.f398719b = 40;
        this.f398724g = d.n(this, 12);
        this.f398725h = 3;
        FrameLayout.inflate(r100, R.layout.o_widget_bottom_action_bar_v2_normal_vertical, this);
        View r102 = findViewById(R.id.bottom_action_bar_root);
        this.f398721d = r102;
        r102.getPaddingBottom();
        ODivider r103 = new ODivider(r100, null, 6, 0);
        this.f398720c = r103;
        addView(r103, new FrameLayout.LayoutParams(-1, d.l(this, 0.6d)));
        this.f398722e = (LinearLayout) findViewById(R.id.action_bar_vertical_container);
        this.f398723f = (FrameLayout) findViewById(R.id.action_bar_header_container);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_bottomActionBarType, R.attr.oui_buttonImgIds, R.attr.oui_buttonLastPrimary, R.attr.oui_buttonStyle, R.attr.oui_buttonTexts, R.attr.oui_hasDivider, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetBlurRadius, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetMaterialSrcType}, 0, 0);
        if (r104.getBoolean(10, true) == false) goto L5;
        a(zma.a.f(this, null, true).f564557d);
        setOnApplyWindowInsetsListener(new b(this));
    L5:
        r104.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        if (this.f398723f.getChildCount() <= 0) goto L19;
        int r101 = View.MeasureSpec.getSize(r110);
        int r102 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), Integer.MIN_VALUE);
        int r103 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f398722e.measure(r102, r103);
        int r104 = this.f398722e.getMeasuredHeight();
        int r105 = this.f398721d.getPaddingTop() + this.f398721d.getPaddingBottom();
        ViewGroup.LayoutParams r106 = this.f398722e.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L8:
        if (r107 != null) goto L10;
        int r108 = 0;
    L11:
        int r109 = Math.max(0, r101 - ((r105 + r108) + r104));
        this.f398723f.measure(r102, r103);
        int r111 = this.f398723f.getMeasuredHeight();
        ViewGroup.LayoutParams r112 = this.f398723f.getLayoutParams();
        if (r109 >= r111) goto L17;
        if (r112.height == r109) goto L19;
        r112.height = r109;
        this.f398723f.setLayoutParams(r112);
        goto L19
    L17:
        if (r112.height == (-2)) goto L19;
        r112.height = -2;
        this.f398723f.setLayoutParams(r112);
        goto L19
    L10:
        r108 = r107.topMargin;
        goto L11
    L7:
        r107 = null;
    L19:
        super.onMeasure(r100, r110);
    }
}
