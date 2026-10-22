package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J-\u0010\u0016\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00150\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000fH\u0096\u0001J\u0013\u00103\u001a\u00020\u00072\b\b\u0001\u00102\u001a\u00020\u000fH\u0096\u0001J\u0011\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0005H\u0096\u0001J\u0011\u00106\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000fH\u0096\u0001J\t\u00109\u001a\u00020\u0002H\u0096\u0001J\t\u0010;\u001a\u00020:H\u0096\u0001J\t\u0010<\u001a\u00020\u0003H\u0096\u0001J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0005H\u0016J\u000e\u0010A\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u000fH\u0016¨\u0006I"}, d2 = {"Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "Lcom/obric/oui/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "pressed", "setPressed", "enabled", "setEnabled", "setVibrateEnabled", "setSoundEffectEnabled", "fakePressed", "setFakePressed", "selected", "setSelected", "minHeight", "setMinimumHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OUICardConstraintLayout extends ConstraintLayout implements com.obric.oui.common.style.a, com.obric.oui.common.style.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ h f401378q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ l f401379r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ o f401380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l f401381t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f401382u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f401383v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f401384w;

    public OUICardConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OUICardConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OUICardConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        this.f401379r.C1(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r100) {
        this.f401379r.getClass();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.f401379r.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        this.f401379r.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        this.f401379r.T0(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r100, boolean r101) {
        this.f401378q.Y4(r100, r101);
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.f401379r.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.f401380s.a();
    }

    public final void k(q r100, q r101, boolean r102) {
        this.f401379r.A(r100, r101, false);
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r100) {
        this.f401378q.m1(r100);
    }

    public void setBorderColor(int r100) {
        this.f401379r.p(r100);
    }

    public void setBorderWidth(int r100) {
        this.f401379r.q(r100);
    }

    public void setBottomDividerAlpha(int r100) {
        this.f401379r.r(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r100) {
        this.f401378q.setChangeAlphaWhenDisable(r100);
    }

    @Override // com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r100) {
        this.f401378q.setChangeAlphaWhenPress(r100);
    }

    public void setEnableShadowWidthRadius(boolean r100) {
        this.f401379r.s(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r100) {
        this.f401378q.setKeepPressAlpha(r100);
    }

    public void setLeftDividerAlpha(int r100) {
        this.f401379r.t(r100);
    }

    public void setOuterNormalColor(int r100) {
        this.f401379r.u(r100);
    }

    public void setOutlineExcludePadding(boolean r100) {
        this.f401379r.v(r100);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r100) {
        this.f401378q.setOverridePressColor(r100);
    }

    public void setRadius(int r100) {
        this.f401379r.w(r100);
    }

    public void setRightDividerAlpha(int r100) {
        this.f401379r.z(r100);
    }

    public void setShadowAlpha(float r100) {
        this.f401379r.B(r100);
    }

    public void setShadowColor(int r100) {
        this.f401379r.C(r100);
    }

    public void setShadowElevation(int r100) {
        this.f401379r.D(r100);
    }

    public void setShadowStyle(int r100) {
        this.f401379r.E(r100);
    }

    public void setShowBorderOnlyBeforeL(boolean r100) {
        this.f401379r.F(r100);
    }

    public void setTopDividerAlpha(int r100) {
        this.f401379r.G(r100);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f401379r.f399546J;
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.f401380s.f399584b;
    }

    public com.obric.oui.common.style.b getLayoutHelper() {
        return this.f401380s.f399583a;
    }

    public int getRadius() {
        return this.f401379r.C;
    }

    public float getShadowAlpha() {
        return this.f401379r.U;
    }

    public int getShadowColor() {
        return this.f401379r.V;
    }

    public int getShadowElevation() {
        return this.f401379r.T;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean Z2() {
        return this.f401384w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        l r101 = this.f401381t;
        if (r101 == null) goto L6;
        r101.e(r100, getWidth(), getHeight());
    L6:
        l r102 = this.f401381t;
        if (r102 == null) goto L11;
        r102.c(r100);
        return;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j r101 = this.f401383v;
        if (r101 == null) goto L7;
        r101.h(r100);
    L7:
        return super.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j r101 = this.f401383v;
        if (r101 == null) goto L6;
        r101.h(r100);
    L6:
        h r102 = this.f401382u;
        if (r102 == null) goto L11;
        r102.b(r100);
    L11:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        l r101 = this.f401381t;
        if (r101 == null) goto L6;
        r101.d(r100);
    L6:
        super.draw(r100);
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r100) {
        this.f401378q.f399513g = r100;
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r100) {
        super.onHoverChanged(r100);
        j r101 = this.f401383v;
        if (r101 == null) goto L7;
        r101.e(r100);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        j r101 = this.f401383v;
        if (r101 == null) goto L7;
        r101.f(r100);
        return;
    }

    public void setChangeAlphaWhenSelected(boolean r100) {
        this.f401378q.f399512f = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        h r101 = this.f401382u;
        if (r101 == null) goto L7;
        r101.e(this, r100);
        return;
    }

    public void setFakePressed(boolean r100) {
        if (this.f401384w == r100) goto L13;
        this.f401384w = r100;
        j r101 = this.f401383v;
        if (r101 == null) goto L8;
        r101.g(r100);
    L8:
        h r102 = this.f401382u;
        if (r102 == null) goto L14;
        r102.f(this.f401384w);
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r100) {
        l r101 = this.f401381t;
        if (r101 == null) goto L6;
        r101.f399552e = r100;
    L6:
        super.setMinimumHeight(r100);
        setMinHeight(r100);
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        j r101 = this.f401383v;
        if (r101 == null) goto L6;
        r101.g(r100);
    L6:
        super.setPressed(r100);
        h r102 = this.f401382u;
        if (r102 == null) goto L11;
        r102.f(r100);
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        h r101 = this.f401382u;
        if (r101 == null) goto L7;
        r101.Y4(this, r100);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r100) {
        this.f401379r.f399569p1 = r100;
    }

    public final void setSoundEffectEnabled(boolean r100) {
        j r101 = this.f401383v;
        if (r101 == null) goto L7;
        r101.f399543d = r100;
        return;
    }

    public final void setVibrateEnabled(boolean r100) {
        j r101 = this.f401383v;
        if (r101 == null) goto L7;
        r101.f399542c = r100;
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r100) {
        this.f401379r.f399551d = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        k(r100, r101, false);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        l r102 = this.f401381t;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.j(r100);
        l r104 = this.f401381t;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.i(r101);
        super.onMeasure(r103, r105);
        l r106 = this.f401381t;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.m(r103, getMeasuredWidth());
        l r108 = this.f401381t;
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

    public OUICardConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
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
        super(r100, r101);
        this.f401378q = r104.f399584b;
        this.f401379r = r104.f399583a;
        this.f401380s = r104;
        r104.b(this);
        this.f401381t = (l) getLayoutHelper();
        this.f401382u = (h) getAlphaHelper();
        this.f401383v = getEffectHelper();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }
}
