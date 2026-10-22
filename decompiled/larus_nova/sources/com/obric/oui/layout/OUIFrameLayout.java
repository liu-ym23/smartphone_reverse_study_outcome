package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import com.obric.oui.lisitem.OListItemSwitch;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010 \u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010.\u001a\u00020\u00072\b\b\u0001\u0010-\u001a\u00020\u000fH\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u000fH\u0096\u0001J\t\u00104\u001a\u00020\u0002H\u0096\u0001J\t\u00106\u001a\u000205H\u0096\u0001J\t\u00107\u001a\u00020\u0003H\u0096\u0001J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0005H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0005H\u0016J\u000e\u0010>\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016¨\u0006G"}, d2 = {"Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "pressed", "setPressed", "enabled", "setEnabled", "changeAlphaWhenEnabledChanged", "setChangeAlphaWhenEnabledChanged", "setVibrateEnabled", "setSoundEffectEnabled", "fakePressed", "setFakePressed", "selected", "setSelected", "", "Lcom/obric/oui/common/style/q;", "getCurrentShadows", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OUIFrameLayout extends FrameLayout implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f401296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f401297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f401298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f401299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f401300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f401301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f401302g;

    public OUIFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 14);
    }

    public OUIFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OUIFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        this.f401297b.C1(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r100) {
        this.f401297b.getClass();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.f401297b.getClass();
        return false;
    }

    public boolean S() {
        this.f401297b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        this.f401297b.T0(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        this.f401296a.Y4(r100, r101);
    }

    public final void c(q r100, q r101, boolean r102) {
        this.f401297b.A(r100, r101, r102);
    }

    public j getEffectHelper() {
        return this.f401298c.a();
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        this.f401296a.m1(r100);
    }

    public void setBorderColor(int r100) {
        this.f401297b.p(r100);
    }

    public void setBorderWidth(int r100) {
        this.f401297b.q(r100);
    }

    public void setBottomDividerAlpha(int r100) {
        this.f401297b.r(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r100) {
        this.f401296a.setChangeAlphaWhenDisable(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r100) {
        this.f401296a.setChangeAlphaWhenPress(r100);
    }

    public void setEnableShadowWidthRadius(boolean r100) {
        this.f401297b.s(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r100) {
        this.f401296a.setKeepPressAlpha(r100);
    }

    public void setLeftDividerAlpha(int r100) {
        this.f401297b.t(r100);
    }

    public void setOuterNormalColor(int r100) {
        this.f401297b.u(r100);
    }

    public void setOutlineExcludePadding(boolean r100) {
        this.f401297b.v(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r100) {
        this.f401296a.setOverridePressColor(r100);
    }

    public void setRadius(int r100) {
        this.f401297b.w(r100);
    }

    public void setRightDividerAlpha(int r100) {
        this.f401297b.z(r100);
    }

    public void setShadowAlpha(float r100) {
        this.f401297b.B(r100);
    }

    public void setShadowColor(int r100) {
        this.f401297b.C(r100);
    }

    public void setShadowElevation(int r100) {
        this.f401297b.D(r100);
    }

    public void setShadowStyle(int r100) {
        this.f401297b.E(r100);
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        this.f401297b.F(r100);
    }

    public void setTopDividerAlpha(int r100) {
        this.f401297b.G(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f401297b.f399546J;
    }

    public a getAlphaHelper() {
        return this.f401298c.f399584b;
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        l r100 = this.f401299d;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getCurrentShadows();
    }

    public b getLayoutHelper() {
        return this.f401298c.f399583a;
    }

    public int getRadius() {
        return this.f401297b.C;
    }

    public float getShadowAlpha() {
        return this.f401297b.U;
    }

    public int getShadowColor() {
        return this.f401297b.V;
    }

    public int getShadowElevation() {
        return this.f401297b.T;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean Z2() {
        return this.f401302g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        l r101 = this.f401299d;
        if (r101 == null) goto L6;
        r101.e(r100, getWidth(), getHeight());
    L6:
        l r102 = this.f401299d;
        if (r102 == null) goto L11;
        r102.c(r100);
        return;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j r101 = this.f401301f;
        if (r101 == null) goto L7;
        r101.h(r100);
    L7:
        return super.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j r101 = this.f401301f;
        if (r101 == null) goto L6;
        r101.h(r100);
    L6:
        h r102 = this.f401300e;
        if (r102 == null) goto L11;
        r102.b(r100);
    L11:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        l r101 = this.f401299d;
        if (r101 == null) goto L6;
        r101.d(r100);
    L6:
        super.draw(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f401296a.f399513g = r100;
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r100) {
        super.onHoverChanged(r100);
        j r101 = this.f401301f;
        if (r101 == null) goto L7;
        r101.e(r100);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        j r101 = this.f401301f;
        if (r101 == null) goto L7;
        r101.f(r100);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenEnabledChanged(boolean r100) {
        h r101 = this.f401300e;
        if (r101 == null) goto L7;
        r101.f399511e = r100;
        return;
    }

    public void setChangeAlphaWhenSelected(boolean r100) {
        this.f401296a.f399512f = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        h r101 = this.f401300e;
        if (r101 == null) goto L7;
        r101.e(this, r100);
        return;
    }

    public void setFakePressed(boolean r100) {
        if (this.f401302g == r100) goto L13;
        this.f401302g = r100;
        j r101 = this.f401301f;
        if (r101 == null) goto L8;
        r101.g(r100);
    L8:
        h r102 = this.f401300e;
        if (r102 == null) goto L14;
        r102.f(this.f401302g);
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        if ((!(this instanceof OListItemSwitch)) == false) goto L13;
        j r101 = this.f401301f;
        if (r101 == null) goto L8;
        r101.g(r100);
    L8:
        super.setPressed(r100);
        h r102 = this.f401300e;
        if (r102 == null) goto L14;
        r102.f(r100);
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        h r101 = this.f401300e;
        if (r101 == null) goto L7;
        r101.Y4(this, r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r100) {
        this.f401297b.f399569p1 = r100;
    }

    public final void setSoundEffectEnabled(boolean r100) {
        j r101 = this.f401301f;
        if (r101 == null) goto L7;
        r101.f399543d = r100;
        return;
    }

    public final void setVibrateEnabled(boolean r100) {
        j r101 = this.f401301f;
        if (r101 == null) goto L7;
        r101.f399542c = r100;
        return;
    }

    public void setWidthMin(int r100) {
        this.f401297b.f399551d = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        c(r100, r101, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        l r102 = this.f401299d;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.j(r100);
        l r104 = this.f401299d;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.i(r101);
        super.onMeasure(r103, r105);
        l r106 = this.f401299d;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.m(r103, getMeasuredWidth());
        l r108 = this.f401299d;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.l(r105, getMeasuredHeight());
        if (r103 != r107) goto L7;
        if (r105 != r109) goto L7;
        return;
    L7:
        super.onMeasure(r107, r109);
        return;
    L8:
        super.onMeasure(r100, r101);
    }

    public OUIFrameLayout(Context r100, AttributeSet r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100, r101);
        this.f401296a = r102.f399584b;
        this.f401297b = r102.f399583a;
        this.f401298c = r102;
        r102.b(this);
        this.f401299d = (l) getLayoutHelper();
        this.f401300e = (h) getAlphaHelper();
        this.f401301f = getEffectHelper();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    public /* synthetic */ OUIFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
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
        this(r100, r101, r104);
    }
}
