package com.bytedance.android.shopping.legacy;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ue3.b;
import ue3.c;
import ue3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/legacy/DragRelativeLayout;", "Landroid/widget/RelativeLayout;", "", "dockMode", "", "setDockMode", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "getOnViewPositionChanged", "()Lkotlin/jvm/functions/Function0;", "setOnViewPositionChanged", "(Lkotlin/jvm/functions/Function0;)V", "onViewPositionChanged", "", "j", "Z", "getEnableKeepLayout", "()Z", "setEnableKeepLayout", "(Z)V", "enableKeepLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragRelativeLayout extends RelativeLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public ViewDragHelper f;
    public View g;
    public boolean h;
    public Function0<Unit> i;
    public boolean j;
    public Pair<Integer, Integer> k;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (getChildCount() <= 0) goto L6;
        this.g = getChildAt(0);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.j == false) goto L12;
        View r0 = this.g;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getWidth() != 0) goto L9;
        return;
    L9:
        if (r0.getHeight() == 0) goto L15;
        this.k = new Pair(Integer.valueOf(r0.getTop()), Integer.valueOf(r0.getLeft()));
        return;
    L15:
        return;
    }

    public final boolean getEnableKeepLayout() {
        return this.j;
    }

    public final Function0<Unit> getOnViewPositionChanged() {
        return this.i;
    }

    public DragRelativeLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        View r0 = this.g;
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
    L6:
        View r2 = this.g;
        if (r2 == null) goto L9;
        int r3 = r2.getTop();
    L10:
        View r4 = this.g;
        if (r4 == null) goto L13;
        int r5 = r4.getRight();
    L14:
        View r6 = this.g;
        if (r6 == null) goto L17;
        int r8 = r6.getBottom();
    L19:
        if (r7.getX() >= r1) goto L21;
    L27:
        boolean r9 = false;
    L28:
        this.h = r9;
        if (r9 == false) goto L34;
        ViewDragHelper r10 = this.f;
        if (r10 != null) goto L36;
        return false;
    L36:
        return r10.shouldInterceptTouchEvent(r7);
    L34:
        return super.onInterceptTouchEvent(r7);
    L21:
        if (r7.getX() > r5) goto L27;
        if (r7.getY() < r3) goto L27;
        if (r7.getY() > r8) goto L27;
        r9 = true;
        goto L28
    L17:
        r8 = 0;
        goto L19
    L13:
        r5 = 0;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.h == false) goto L12;
        ViewDragHelper r0 = this.f;     // Catch: IllegalArgumentException -> L8
        if (r0 == null) goto L10;
        r0.processTouchEvent(r2);     // Catch: IllegalArgumentException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L10
    L12:
        return super.onTouchEvent(r2);
    }

    public final void setDockMode(int r1) {
        this.a = r1;
    }

    public final void setEnableKeepLayout(boolean r1) {
        this.j = r1;
    }

    public final void setOnViewPositionChanged(Function0<Unit> r1) {
        this.i = r1;
    }

    public DragRelativeLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        if (r3 == null) goto L5;
        TypedArray r4 = getContext().obtainStyledAttributes(r3, new int[]{2130969781, 2130969782, 2130969783, 2130969784, 2130969785});
        this.a = r4.getInt(4, 2131370211);
        this.b = r4.getDimensionPixelOffset(1, 0);
        this.c = r4.getDimensionPixelOffset(2, 0);
        this.d = r4.getDimensionPixelOffset(3, 0);
        this.e = r4.getDimensionPixelOffset(0, 0);
        r4.recycle();
    L5:
        this.f = ViewDragHelper.create(this, 1.0f, new DragRelativeLayout$initDragHelper$1(this));
    }

    public static void a(DragRelativeLayout r4, View r5, int r6, int r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r8 & 4) == 0) goto L8;
        r7 = 0;
    L8:
        r4.getClass();
        int r9 = r5.getLeft();
        int r0 = r5.getTop();
        if (r6 == 0) goto L11;
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{0, r6});
        r10.addUpdateListener(new ue3.a(r5, r9, r0));
        r10.addListener(new b(r4));
    L17:
        if (r10 == null) goto L19;
        r10.setDuration(250);
    L19:
        if (r10 == null) goto L22;
        r10.start();
        return;
    L22:
        return;
    L11:
        if (r7 == 0) goto L13;
        r10 = ValueAnimator.ofInt(new int[]{0, r7});
        r10.addUpdateListener(new c(r5, r9, r0));
        r10.addListener(new d(r4));
        goto L17
    L13:
        Function0<Unit> r11 = r4.i;
        if (r11 == null) goto L16;
        Unit r12 = (Unit) r11.invoke();
    L16:
        r10 = null;
        goto L17
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        View r7 = this.g;
        Pair<Integer, Integer> r8 = this.k;
        if (r7 == null) goto L7;
        if (r8 == null) goto L8;
        r7.layout(((Number) r8.getSecond()).intValue(), ((Number) r8.getFirst()).intValue(), ((Number) r8.getSecond()).intValue() + r7.getWidth(), ((Number) r8.getFirst()).intValue() + r7.getHeight());
        return;
    L8:
        return;
    }
}
