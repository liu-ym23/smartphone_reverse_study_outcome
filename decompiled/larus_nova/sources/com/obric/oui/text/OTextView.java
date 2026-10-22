package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J-\u0010\u0016\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00150\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000fH\u0096\u0001J\u0013\u00103\u001a\u00020\u00072\b\b\u0001\u00102\u001a\u00020\u000fH\u0096\u0001J\u0011\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0005H\u0096\u0001J\u0011\u00106\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000fH\u0096\u0001J\t\u00109\u001a\u00020\u0002H\u0096\u0001J\t\u0010;\u001a\u00020:H\u0096\u0001J\t\u0010<\u001a\u00020\u0003H\u0096\u0001J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0005H\u0016R*\u0010F\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "pressed", "setPressed", "value", "h", "Z", "getEnableAutoAlignLeft", "()Z", "setEnableAutoAlignLeft", "(Z)V", "enableAutoAlignLeft", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OTextView extends TextView implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f403243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f403244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f403245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f403246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f403247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f403248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f403249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f403250h;

    public OTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        this.f403244b.C1(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r100) {
        this.f403244b.getClass();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.f403244b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        this.f403244b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        this.f403244b.T0(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        this.f403243a.Y4(r100, r101);
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    public final void a(q r100, q r101, boolean r102) {
        this.f403244b.A(r100, r101, false);
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.f403244b.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.f403245c.a();
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        this.f403243a.m1(r100);
    }

    public void setBorderColor(int r100) {
        this.f403244b.p(r100);
    }

    public void setBorderWidth(int r100) {
        this.f403244b.q(r100);
    }

    public void setBottomDividerAlpha(int r100) {
        this.f403244b.r(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r100) {
        this.f403243a.setChangeAlphaWhenDisable(r100);
    }

    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r100) {
        this.f403243a.setChangeAlphaWhenPress(r100);
    }

    public void setEnableShadowWidthRadius(boolean r100) {
        this.f403244b.s(r100);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r100) {
        this.f403243a.setKeepPressAlpha(r100);
    }

    public void setLeftDividerAlpha(int r100) {
        this.f403244b.t(r100);
    }

    public void setOuterNormalColor(int r100) {
        this.f403244b.u(r100);
    }

    public void setOutlineExcludePadding(boolean r100) {
        this.f403244b.v(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r100) {
        this.f403243a.setOverridePressColor(r100);
    }

    public void setRadius(int r100) {
        this.f403244b.w(r100);
    }

    public void setRightDividerAlpha(int r100) {
        this.f403244b.z(r100);
    }

    public void setShadowAlpha(float r100) {
        this.f403244b.B(r100);
    }

    public void setShadowColor(int r100) {
        this.f403244b.C(r100);
    }

    public void setShadowElevation(int r100) {
        this.f403244b.D(r100);
    }

    public void setShadowStyle(int r100) {
        this.f403244b.E(r100);
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        this.f403244b.F(r100);
    }

    public void setTopDividerAlpha(int r100) {
        this.f403244b.G(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f403244b.f399546J;
    }

    public a getAlphaHelper() {
        return this.f403245c.f399584b;
    }

    public b getLayoutHelper() {
        return this.f403245c.f399583a;
    }

    public int getRadius() {
        return this.f403244b.C;
    }

    public float getShadowAlpha() {
        return this.f403244b.U;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f403244b.V;
    }

    public int getShadowElevation() {
        return this.f403244b.T;
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f403250h;
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        l r101 = this.f403246d;
        if (r101 == null) goto L6;
        r101.e(r100, getWidth(), getHeight());
    L6:
        l r102 = this.f403246d;
        if (r102 == null) goto L11;
        r102.c(r100);
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        l r101 = this.f403246d;
        if (r101 == null) goto L6;
        r101.d(r100);
    L6:
        super.draw(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f403243a.f399513g = r100;
    }

    public void setChangeAlphaWhenSelected(boolean r100) {
        this.f403243a.f399512f = r100;
    }

    public final void setEnableAutoAlignLeft(boolean r100) {
        if (this.f403250h == r100) goto L6;
        this.f403250h = r100;
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        j r101 = this.f403248f;
        if (r101 == null) goto L6;
        r101.g(r100);
    L6:
        super.setPressed(r100);
        h r102 = this.f403247e;
        if (r102 == null) goto L11;
        r102.f(r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r100) {
        this.f403244b.f399569p1 = r100;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r100) {
        this.f403244b.f399551d = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        a(r100, r101, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OTextView(Context r100, AttributeSet r101, int r102, int r103) {
        o r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = new o(r100, r101, r102, 0);
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100, r101, r102);
        this.f403243a = r104.f399584b;
        this.f403244b = r104.f399583a;
        this.f403245c = r104;
        this.f403249g = getGravity();
        r104.b(this);
        this.f403246d = (l) getLayoutHelper();
        h r105 = (h) getAlphaHelper();
        this.f403247e = r105;
        this.f403248f = getEffectHelper();
        if (r105 == null) goto L15;
        r105.setChangeAlphaWhenPress(false);
    L15:
        if (r105 == null) goto L18;
        r105.setChangeAlphaWhenDisable(false);
    L18:
        setHighlightColor(r100.getColor(R.color.oui_text_highlight_color));
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f403250h == false) goto L16;
        int r105 = 1;
        if (getLineCount() > 1) goto L7;
        boolean r106 = true;
    L8:
        int r107 = this.f403249g & 112;
        if (r106 == true) goto L12;
        r105 = 3;
    L12:
        int r108 = r107 | r105;
        if (getGravity() == r108) goto L17;
        setGravity(r108);
        return;
    L17:
        return;
    L7:
        r106 = false;
        goto L8
    }
}
