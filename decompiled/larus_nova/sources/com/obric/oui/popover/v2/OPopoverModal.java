package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.obric.oui.material.OMaterialHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class OPopoverModal extends FrameLayout implements OPopoverBase<OPopoverModal> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Companion f402344r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<Activity, Companion.a> f402345s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f402346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f402347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.InterfaceC4677c f402349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.d f402350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f402351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f402352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OPopoverLayout f402353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f402354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimatorSet f402355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f402356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f402357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f402358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f402359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f402360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f402361p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f402362q;

    public static final class Companion {

        public static final class a {
        }

        public Companion() {
        }

        public final synchronized void a(Activity r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (((a) ((LinkedHashMap) OPopoverModal.f402345s).get(r100)) != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(null, OPopoverModal$Companion$cleanupBackPressManagerLocked$1.INSTANCE);     // Catch: Throwable -> L9
            throw null;     // Catch: Throwable -> L9
        }
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean a() {
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void f() {
        ViewGroup r100 = null;
        setPopoverAnimator(null);
        j();
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        i(getPopoverWindowFrame());
        OPopoverBase.b.d(this);
        if (this.f402356k == false) goto L10;
        ViewParent r101 = getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        r100 = (ViewGroup) r101;
    L7:
        if (r100 == null) goto L10;
        r100.removeView(this);
    L10:
        c.InterfaceC4677c r102 = this.f402349d;
        if (r102 == null) goto L14;
        r102.bubbleDismiss();
    L14:
        Function0<Unit> r103 = this.f402351f;
        if (r103 == null) goto L19;
        r103.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public long getPopoverAnimationDurationMillis() {
        return 0;
    }

    public boolean getPopoverAnimationIsWindowMode() {
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBgColor() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderColor() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderWidth() {
        return 0;
    }

    public boolean getPopoverCoverPreviousWhenStacked() {
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverDisplayOrientation() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverEnableBubbleMaterial() {
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverHeight() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverShowWithAnimation() {
        return false;
    }

    public float getPopoverStackAlphaPrevious() {
        return 0.0f;
    }

    public int getPopoverStackCoverColor() {
        return 0;
    }

    public float getPopoverStackScalePrevious() {
        return 0.0f;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverTransparentBg() {
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverWidth() {
        return 0;
    }

    public final void setOnBubbleStartDismissListener(c.e r100) {
    }

    static {
        f402344r = new Companion();
        f402345s = new LinkedHashMap();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void d() {
        c.d r100 = this.f402350e;
        if (r100 == null) goto L6;
        r100.bubbleShow();
    L6:
        Function0<Unit> r101 = this.f402352g;
        if (r101 == null) goto L11;
        r101.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r100 = this.f402353h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverBubbleLayout");
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r100 = this.f402354i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverWindowFrame");
        return null;
    }

    public final boolean h() {
        if (this.f402353h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        Activity r100 = zma.a.f572881a.getActivity(getContext());
        if (r100 != null) goto L5;
        return;
    L5:
        Companion r101 = f402344r;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (((Companion.a) ((LinkedHashMap) f402345s).get(r100)) != null) goto L11;
        monitor-exit(r101);
        return;
    L11:
        CollectionsKt.removeAll(null, new OPopoverModal$Companion$unregisterShowingPopover$1(this));     // Catch: Throwable -> L14
        r101.a(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);
    }

    public final View getContentView() {
        return getContentViewInternal();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View getContentViewInternal() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getPopoverBubbleLayout();
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public int getDisplayRotationDegreesInternal() {
        Intrinsics.checkNotNullParameter(this, "this");
        int r100 = getPopoverDisplayOrientation();
        if (r100 != 1) goto L5;
        return 90;
    L5:
        if (r100 == 3) goto L7;
        return 0;
    L7:
        return 270;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Context getPopoverContext() {
        return getContext();
    }

    public Animator getPopoverEnterAnimator() {
        Intrinsics.checkNotNullParameter(this, "this");
        return null;
    }

    public Animator getPopoverExitAnimator() {
        Intrinsics.checkNotNullParameter(this, "this");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        j();
        super.onDetachedFromWindow();
        removeCallbacks(null);
        throw null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void b() {
        OPopoverBase.b.h(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterX() {
        return this.f402357l;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterY() {
        return this.f402358m;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet getPopoverAnimator() {
        return this.f402355j;
    }

    public int getPopoverGravity() {
        return this.f402346a;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginX() {
        return this.f402359n;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginY() {
        return this.f402360o;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverPushedToStack() {
        return this.f402361p;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverRemovedFromStack() {
        return this.f402362q;
    }

    public int getPopoverXOffset() {
        return this.f402347b;
    }

    public int getPopoverYOffset() {
        return this.f402348c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        throw null;
    }

    private final void setBubbleLayout(View r100) {
        setPopoverBubbleLayout(OPopoverBase.b.b(this, r100, 2));
        OPopoverLayout r101 = getPopoverBubbleLayout();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        OMaterialHelper.t(r101, this);
    }

    public final void i(View r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setAlpha(1.0f);
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setTranslationY(0.0f);
    }

    public final void setEnableAutoDismiss(boolean r100) {
        removeCallbacks(null);
    }

    public final void setGravity$OUI_standardRelease(int r100) {
        setGravityInternal(r100);
    }

    public void setGravityInternal(int r100) {
        OPopoverBase.b.e(this, r100);
    }

    public final void setMaxContentHeight(int r100) {
        c(r100, getContentViewInternal());
    }

    public final void setOnBubbleDismissListener(c.InterfaceC4677c r100) {
        this.f402349d = r100;
    }

    public final void setOnBubbleShowListener(c.d r100) {
        this.f402350e = r100;
    }

    public final void setOnDismissListener(Function0<Unit> r100) {
        this.f402351f = r100;
    }

    public final void setOnShowListener(Function0<Unit> r100) {
        this.f402352g = r100;
    }

    public void setPopoverAnchorCenterX(float r100) {
        this.f402357l = r100;
    }

    public void setPopoverAnchorCenterY(float r100) {
        this.f402358m = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnimator(AnimatorSet r100) {
        this.f402355j = r100;
    }

    public void setPopoverBubbleLayout(OPopoverLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402353h = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverGravity(int r100) {
        this.f402346a = r100;
    }

    public void setPopoverPopupOriginX(int r100) {
        this.f402359n = r100;
    }

    public void setPopoverPopupOriginY(int r100) {
        this.f402360o = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPushedToStack(boolean r100) {
        this.f402361p = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverRemovedFromStack(boolean r100) {
        this.f402362q = r100;
    }

    public void setPopoverWindowFrame(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402354i = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverXOffset(int r100) {
        this.f402347b = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverYOffset(int r100) {
        this.f402348c = r100;
    }

    public final void setRemoveOnDismiss(boolean r100) {
        this.f402356k = r100;
    }

    public final void setXOffset(int r100) {
        setXOffsetInternal(r100);
    }

    public void setXOffsetInternal(int r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        setPopoverXOffset(r100);
    }

    public final void setYOffset(int r100) {
        setYOffsetInternal(r100);
    }

    public void setYOffsetInternal(int r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        setPopoverYOffset(r100);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void c(int r100, View r101) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r101, "measureTarget");
        if (h() == false) goto L8;
        if (r100 <= 0) goto L9;
        k(r100, r101);
        return;
    L9:
        return;
    }

    public final void k(int r100, View r101) {
        OPopoverBase.b.f(this, r100, r101);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void e(View r100, int r101, int r102) {
        OPopoverBase.b.c(this, r100, r101, r102);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final float g(float r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(this, "this");
        if (Float.isNaN(r100) == false) goto L6;
        return r102;
    L6:
        return r100 - r101;
    }
}
