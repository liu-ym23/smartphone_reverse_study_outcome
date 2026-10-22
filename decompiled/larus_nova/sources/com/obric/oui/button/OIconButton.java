package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J-\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001aH\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0011H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0011H\u0096\u0001J\u0013\u00105\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u00020\u0011H\u0096\u0001J\u0011\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0005H\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0011H\u0096\u0001J\t\u0010;\u001a\u00020\u0002H\u0096\u0001J\t\u0010=\u001a\u00020<H\u0096\u0001J\t\u0010>\u001a\u00020\u0003H\u0096\u0001J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001aJ\u000e\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0011J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0005H\u0016J\u000e\u0010J\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u001a¨\u0006L"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "pressed", "", "setPressState", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "progress", "setAlignmentProgress", GXTemplateKey.FLEXBOX_PADDING, "setTargetLeftPadding", "setBackgroundColor", "setPressed", "enabled", "setEnabled", "selected", "setSelected", "alpha", "setDisabledAlpha", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OIconButton extends AppCompatImageView implements com.obric.oui.common.style.a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f399121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f399122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f399123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f399124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f399125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f399126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f399127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f399128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f399129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f399130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f399131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399132l;

    public static final class a {
    }

    static {
    }

    public OIconButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 0, 30);
    }

    public OIconButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 0, 28);
    }

    public OIconButton(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 0, 24);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        this.f399122b.C1(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.f399122b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        this.f399122b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        this.f399122b.T0(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        this.f399121a.Y4(r100, r101);
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.f399122b.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.f399123c.a();
    }

    public final void j(q r100, q r101, boolean r102) {
        this.f399122b.A(r100, r101, false);
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        this.f399121a.m1(r100);
    }

    public void setBorderColor(int r100) {
        this.f399122b.p(r100);
    }

    public void setBorderWidth(int r100) {
        this.f399122b.q(r100);
    }

    public void setBottomDividerAlpha(int r100) {
        this.f399122b.r(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r100) {
        this.f399121a.setChangeAlphaWhenDisable(r100);
    }

    @Override // com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r100) {
        this.f399121a.setChangeAlphaWhenPress(r100);
    }

    public void setEnableShadowWidthRadius(boolean r100) {
        this.f399122b.s(r100);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r100) {
        this.f399121a.setKeepPressAlpha(r100);
    }

    public void setLeftDividerAlpha(int r100) {
        this.f399122b.t(r100);
    }

    public void setOuterNormalColor(int r100) {
        this.f399122b.u(r100);
    }

    public void setOutlineExcludePadding(boolean r100) {
        this.f399122b.v(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r100) {
        this.f399121a.setOverridePressColor(r100);
    }

    public void setRadius(int r100) {
        this.f399122b.w(r100);
    }

    public void setRightDividerAlpha(int r100) {
        this.f399122b.z(r100);
    }

    public void setShadowAlpha(float r100) {
        this.f399122b.B(r100);
    }

    public void setShadowColor(int r100) {
        this.f399122b.C(r100);
    }

    public void setShadowElevation(int r100) {
        this.f399122b.D(r100);
    }

    public void setShadowStyle(int r100) {
        this.f399122b.E(r100);
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        this.f399122b.F(r100);
    }

    public void setTopDividerAlpha(int r100) {
        this.f399122b.G(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f399122b.f399546J;
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.f399123c.f399584b;
    }

    public b getLayoutHelper() {
        return this.f399123c.f399583a;
    }

    public int getRadius() {
        return this.f399122b.C;
    }

    public float getShadowAlpha() {
        return this.f399122b.U;
    }

    public int getShadowColor() {
        return this.f399122b.V;
    }

    public int getShadowElevation() {
        return this.f399122b.T;
    }

    private final void setPressState(boolean r100) {
        if (this.f399127g != r100) goto L5;
        return;
    L5:
        this.f399127g = r100;
        j r101 = this.f399126f;
        if (r101 == null) goto L9;
        r101.g(r100);
    L9:
        h r102 = this.f399125e;
        if (r102 == null) goto L14;
        r102.f(r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r100) {
        if (this.f399128h == true) goto L5;
        return;
    L5:
        float r101 = RangesKt.coerceIn(r100 / 255.0f, 0.0f, 1.0f);
        if (this.f399129i != 0) goto L8;
        this.f399129i = getImageAlpha();
    L8:
        int r102 = this.f399129i;
        if (r102 == 0) goto L13;
        setImageAlpha(RangesKt.coerceIn((int) (r102 * (1 - (r101 * 0.7f))), 0, 255));
        return;
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        l r101 = this.f399124d;
        if (r101 == null) goto L6;
        r101.e(r100, getWidth(), getHeight());
    L6:
        l r102 = this.f399124d;
        if (r102 == null) goto L11;
        r102.c(r100);
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        l r101 = this.f399124d;
        if (r101 == null) goto L6;
        r101.d(r100);
    L6:
        super.draw(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f399121a.f399513g = r100;
    }

    public final void l(boolean r100) {
        if (r100 == true) goto L8;
        Drawable r101 = getDrawable();
        if (r101 == null) goto L14;
        r101.setAlpha((int) (this.f399130j * 255));
        return;
    L14:
        return;
    L8:
        Drawable r102 = getDrawable();
        if (r102 == null) goto L15;
        r102.setAlpha(255);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f399131k != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        super.onDraw(r100);
        return;
    L9:
        Drawable r102 = getDrawable();
        if (r102 != null) goto L13;
        super.onDraw(r100);
        return;
    L13:
        int r103 = r102.getIntrinsicWidth();
        if (r103 > 0) goto L17;
        super.onDraw(r100);
        return;
    L17:
        float r104 = (this.f399132l - (getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r103) / 2.0f))) * this.f399131k;
        int r105 = r100.save();
        r100.translate(r104, 0.0f);
        super.onDraw(r100);
        r100.restoreToCount(r105);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setAlignmentProgress(float r100) {
        if (this.f399131k != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f399131k = r100;
        invalidate();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setCornerRadius(getRadius());
        r101.setColor(r100);
        setBackground(r101);
    }

    public void setChangeAlphaWhenSelected(boolean r100) {
        this.f399121a.f399512f = r100;
    }

    public final void setDisabledAlpha(float r100) {
        this.f399130j = r100;
        if (isEnabled() == true) goto L6;
        l(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        h r101 = this.f399125e;
        if (r101 == null) goto L6;
        r101.e(this, r100);
    L6:
        l(r100);
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        j r101 = this.f399126f;
        if (r101 == null) goto L6;
        r101.g(r100);
    L6:
        h r102 = this.f399125e;
        if (r102 == null) goto L11;
        r102.f(r100);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        h r101 = this.f399125e;
        if (r101 == null) goto L7;
        r101.Y4(this, r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r100) {
        this.f399122b.f399569p1 = r100;
    }

    public final void setTargetLeftPadding(int r100) {
        this.f399132l = r100;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r100) {
        this.f399122b.f399551d = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        j(r100, r101, false);
    }

    public OIconButton(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        o r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = 0;
    L12:
        if ((r104 & 16) == 0) goto L14;
        r105 = new o(r100, r101, r102, r103);
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100, r101, r102);
        this.f399121a = r105.f399584b;
        this.f399122b = r105.f399583a;
        this.f399123c = r105;
        this.f399130j = 1.0f;
        r105.b(this);
        setEnableShadowWidthRadius(true);
        this.f399124d = (l) getLayoutHelper();
        h r106 = (h) getAlphaHelper();
        this.f399125e = r106;
        if (r106 == null) goto L18;
        r106.h(getRadius());
    L18:
        this.f399126f = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon, R.attr.iconTint, R.attr.oui_buttonChangeAlphaWhenPressed, R.attr.oui_buttonTextStyle, R.attr.oui_widgetDisableAlpha, R.attr.oui_widgetPaddingOffset});
        this.f399128h = r107.getBoolean(2, false);
        this.f399130j = r107.getFloat(4, 1.0f);
        r107.recycle();
        l(isEnabled());
        Resources r108 = r100.getResources();
        this.f399132l = MathKt.roundToInt(16 * WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density);
        if ((getBackground() instanceof ColorDrawable) == false) goto L25;
        GradientDrawable r109 = new GradientDrawable();
        r109.setShape(0);
        r109.setCornerRadius(getRadius());
        Drawable r110 = getBackground();
        if (r110 == null) goto L24;
        r109.setColor(((ColorDrawable) r110).getColor());
        setBackground(r109);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }
}
