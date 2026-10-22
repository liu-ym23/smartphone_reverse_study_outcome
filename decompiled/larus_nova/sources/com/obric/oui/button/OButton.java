package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001YJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J-\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001aH\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0011H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0011H\u0096\u0001J\u0013\u00105\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u00020\u0011H\u0096\u0001J\u0011\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0005H\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0011H\u0096\u0001J\t\u0010;\u001a\u00020\u0002H\u0096\u0001J\t\u0010=\u001a\u00020<H\u0096\u0001J\t\u0010>\u001a\u00020\u0003H\u0096\u0001J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0011J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001aJ\u0010\u0010H\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R.\u0010Q\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010I8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010X\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "pressed", "", "setPressState", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "resId", "setButtonSourceBitmap", "selected", "setSelected", "enabled", "setEnabled", "setPressed", "alpha", "setDisabledTextAlpha", "setTextColor", "Landroid/graphics/drawable/Drawable;", "value", "f", "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "h", "I", "getMImageTintColorId", "()I", "setMImageTintColorId", "(I)V", "mImageTintColorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OButton extends Button implements com.obric.oui.common.style.a, b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f399053p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f399054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f399055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f399056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f399057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f399058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f399059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f399062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f399065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f399066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f399067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f399068o;

    public static final class a {
    }

    static {
    }

    public OButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public OButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        this.f399055b.C1(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.f399055b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        this.f399055b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        this.f399055b.T0(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        this.f399054a.Y4(r100, r101);
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    public final void b(q r100, q r101, boolean r102) {
        this.f399055b.A(r100, r101, false);
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.f399055b.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.f399056c.a();
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        this.f399054a.m1(r100);
    }

    public void setBorderColor(int r100) {
        this.f399055b.p(r100);
    }

    public void setBorderWidth(int r100) {
        this.f399055b.q(r100);
    }

    public void setBottomDividerAlpha(int r100) {
        this.f399055b.r(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r100) {
        this.f399054a.setChangeAlphaWhenDisable(r100);
    }

    @Override // com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r100) {
        this.f399054a.setChangeAlphaWhenPress(r100);
    }

    public void setEnableShadowWidthRadius(boolean r100) {
        this.f399055b.s(r100);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r100) {
        this.f399054a.setKeepPressAlpha(r100);
    }

    public void setLeftDividerAlpha(int r100) {
        this.f399055b.t(r100);
    }

    public void setOuterNormalColor(int r100) {
        this.f399055b.u(r100);
    }

    public void setOutlineExcludePadding(boolean r100) {
        this.f399055b.v(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r100) {
        this.f399054a.setOverridePressColor(r100);
    }

    public void setRadius(int r100) {
        this.f399055b.w(r100);
    }

    public void setRightDividerAlpha(int r100) {
        this.f399055b.z(r100);
    }

    public void setShadowAlpha(float r100) {
        this.f399055b.B(r100);
    }

    public void setShadowColor(int r100) {
        this.f399055b.C(r100);
    }

    public void setShadowElevation(int r100) {
        this.f399055b.D(r100);
    }

    public void setShadowStyle(int r100) {
        this.f399055b.E(r100);
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        this.f399055b.F(r100);
    }

    public void setTopDividerAlpha(int r100) {
        this.f399055b.G(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f399055b.f399546J;
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.f399056c.f399584b;
    }

    public b getLayoutHelper() {
        return this.f399056c.f399583a;
    }

    public int getRadius() {
        return this.f399055b.C;
    }

    public float getShadowAlpha() {
        return this.f399055b.U;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f399055b.V;
    }

    public int getShadowElevation() {
        return this.f399055b.T;
    }

    public final Drawable getMIcon() {
        return this.f399059f;
    }

    public final int getMImageTintColorId() {
        return this.f399061h;
    }

    private final void setPressState(boolean r100) {
        if (this.f399062i != r100) goto L6;
        wma.b.h("OButton", Intrinsics.stringPlus("setPressState, already set, skip! pressed: ", Boolean.valueOf(r100)));
        return;
    L6:
        this.f399062i = r100;
        j r101 = this.f399058e;
        if (r101 == null) goto L10;
        r101.g(r100);
    L10:
        h r102 = this.f399057d;
        if (r102 == null) goto L15;
        r102.f(r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r110) {
        if (this.f399065l == true) goto L5;
        return;
    L5:
        float r111 = RangesKt.coerceIn(r110 / 255.0f, 0.0f, 1.0f);
        int r100 = this.f399063j;
        if (r100 == 0) goto L9;
        int r101 = (r100 >> 24) & 255;
        int r102 = RangesKt.coerceIn((int) (r101 * (1 - (r111 * 0.7f))), 0, 255);
        int r103 = ((r100 >> 16) & 255) << 16;
        setTextColor((r100 & 255) | ((r103 | (r102 << 24)) | (((r100 >> 8) & 255) << 8)));
        wma.b.a("OButton", "updateTextColorOnPress, fraction: " + r111 + ", newTextAlpha: " + r102 + ", originTextAlpha: " + r101);
    L9:
        int r104 = this.f399064k;
        if (r104 == 0) goto L18;
        int r105 = RangesKt.coerceIn((int) (r104 * (1 - (0.7f * r111))), 0, 255);
        Drawable r106 = this.f399059f;
        if (r106 == null) goto L16;
        r106.setAlpha(r105);
    L16:
        wma.b.a("OButton", "updateIconAlphaOnPress, fraction: " + r111 + ", alpha: " + r105 + ", originIconAlpha: " + this.f399064k);
        return;
    }

    public final void a(boolean r100) {
        int r101 = getPaddingTop();
        int r102 = getPaddingRight();
        int r103 = getPaddingBottom();
        if (r100 == false) goto L5;
        int r104 = getPaddingRight() - this.f399066m;
    L7:
        if (r104 == getPaddingLeft()) goto L10;
        setPadding(r104, r101, r102, r103);
        return;
    L10:
        return;
    L5:
        r104 = getPaddingRight();
        goto L7
    }

    public final void c(boolean r100) {
        int r101 = this.f399063j;
        if (r101 != 0) goto L5;
        return;
    L5:
        int r102 = 0;
        if (r100 == true) goto L14;
        int r103 = vma.h.a(r101, this.f399067n);
        this.f399068o = true;
        super.setTextColor(r103);
        this.f399068o = false;
        Drawable[] r104 = getCompoundDrawables();
        int r105 = r104.length;
    L8:
        if (r102 >= r105) goto L21;
        Drawable r106 = r104[r102];
        if (r106 == null) goto L13;
        r106.setAlpha((int) (this.f399067n * 255));
    L13:
        r102 = r102 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.f399068o = true;
        super.setTextColor(r101);
        this.f399068o = false;
        Drawable[] r107 = getCompoundDrawables();
        int r108 = r107.length;
    L15:
        if (r102 >= r108) goto L21;
        Drawable r109 = r107[r102];
        if (r109 == null) goto L20;
        r109.setAlpha(255);
    L20:
        r102 = r102 + 1;
        goto L15
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f399054a.f399513g = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (r100 == null) goto L13;
        Drawable r101 = this.f399059f;
        if (r101 == null) goto L14;
        int r102 = (getWidth() - r101.getIntrinsicWidth()) / 2;
        int r103 = (getHeight() - r101.getIntrinsicHeight()) / 2;
        r101.setBounds(r102, r103, r101.getIntrinsicWidth() + r102, r101.getIntrinsicHeight() + r103);
        if (this.f399061h == 0) goto L11;
        r101.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f399061h), PorterDuff.Mode.SRC_IN));
    L11:
        r101.draw(r100);
        return;
    L14:
        return;
    }

    public final void setButtonSourceBitmap(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r100));
        Drawable r101 = this.f399059f;
        if (r101 != null) goto L7;
        int r102 = 0;
    L8:
        this.f399064k = r102;
        invalidate();
        return;
    L7:
        r102 = r101.getAlpha();
        goto L8
    }

    public void setChangeAlphaWhenSelected(boolean r100) {
        this.f399054a.f399512f = r100;
    }

    public final void setDisabledTextAlpha(float r100) {
        this.f399067n = r100;
        if (isEnabled() == true) goto L6;
        c(false);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        h r101 = this.f399057d;
        if (r101 == null) goto L6;
        r101.e(this, r100);
    L6:
        c(r100);
    }

    public final void setMIcon(Drawable r100) {
        this.f399059f = r100;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r100) {
        this.f399061h = r100;
        invalidate();
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        j r101 = this.f399058e;
        if (r101 == null) goto L6;
        r101.g(r100);
    L6:
        h r102 = this.f399057d;
        if (r102 == null) goto L11;
        r102.f(r100);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        h r101 = this.f399057d;
        if (r101 == null) goto L7;
        r101.Y4(this, r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r100) {
        this.f399055b.f399569p1 = r100;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        if (this.f399068o == true) goto L5;
        this.f399063j = r100;
    L5:
        super.setTextColor(r100);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r100) {
        this.f399055b.f399551d = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        b(r100, r101, false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        Drawable r104 = this.f399059f;
        if (r104 == null) goto L6;
        r102 = Math.max(r102, (r104.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r103 = Math.max(r103, (r104.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r102, r103);
    }

    public OButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r103 & 16) == 0) goto L8;
        o r104 = new o(r100, r101, r102, 0);
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100, r101, r102);
        this.f399054a = r104.f399584b;
        l r105 = r104.f399583a;
        this.f399055b = r105;
        this.f399056c = r104;
        this.f399067n = 1.0f;
        r105.V0 = true;
        r104.b(this);
        l r106 = (l) getLayoutHelper();
        this.f399057d = (h) getAlphaHelper();
        this.f399058e = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon, R.attr.iconTint, R.attr.oui_buttonChangeAlphaWhenPressed, R.attr.oui_buttonTextStyle, R.attr.oui_widgetDisableAlpha, R.attr.oui_widgetPaddingOffset});
        this.f399060g = r107.getResourceId(0, 0);
        setMImageTintColorId(r107.getResourceId(1, 0));
        int r108 = this.f399060g;
        if (r108 == 0) goto L12;
        setButtonSourceBitmap(r108);
    L12:
        setTextAppearance(r107.getResourceId(3, R.style.Title_Title_M_Thick));
        this.f399065l = r107.getBoolean(2, false);
        int r109 = getCurrentTextColor();
        this.f399063j = r109;
        setCompoundDrawableTintList(ColorStateList.valueOf(r109));
        this.f399066m = r107.getDimensionPixelSize(5, 0);
        if (((Drawable) ArraysKt.getOrNull(getCompoundDrawables(), 0)) == null) goto L15;
        a(true);
    L15:
        this.f399067n = r107.getFloat(4, 1.0f);
        r107.recycle();
        c(isEnabled());
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawables(r100, r101, r102, r103);
        if (r100 == null) goto L5;
        boolean r104 = true;
    L6:
        a(r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesRelative(r100, r101, r102, r103);
        if (r100 == null) goto L5;
        boolean r104 = true;
    L6:
        a(r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
