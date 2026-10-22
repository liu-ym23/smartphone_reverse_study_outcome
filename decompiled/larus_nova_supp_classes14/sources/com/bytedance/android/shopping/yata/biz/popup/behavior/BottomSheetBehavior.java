package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/BottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSheetBehavior<V extends View> extends SheetBaseBehavior<V> {
    public static final /* synthetic */ int E = 0;
    public int A;
    public boolean B;
    public Map<View, Integer> C;
    public final BottomSheetBehavior$dragCallback$1 D;
    public boolean h;
    public final float i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public ViewDragHelper r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public WeakReference<V> w;
    public WeakReference<View> x;
    public VelocityTracker y;
    public int z;

    public final class a implements Runnable {
        public final View a;
        public final int b;
        public final /* synthetic */ BottomSheetBehavior c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r0 = this.c.r;     // Catch: Throwable -> L9
            if (r0 != null) goto L5;
        L7:
            this.c.setStateInternal(this.b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r0.continueSettling(true) != true) goto L7;
            ViewCompat.postOnAnimation(this.a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(BottomSheetBehavior r2, View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BottomSheetBehavior a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public b(BottomSheetBehavior r1, View r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.startSettlingAnimation(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final boolean b() {
        this.f.getClass();
        return false;
    }

    public final int getExpandedOffset() {
        if (this.h == true) goto L7;
        return 0;
    L7:
        return this.n;
    }

    public final void dispatchOnSlide(int r4) {
        WeakReference<V> r0 = this.w;
        V r1 = null;
        if (r0 == null) goto L5;
        V r2 = r0.get();
    L7:
        if ((r2 instanceof View) == false) goto L10;
        r1 = r2;
    L10:
        if (r1 != null) goto L13;
        return;
    L13:
        if (r4 <= this.p) goto L17;
        SheetBaseBehavior.b r5 = this.b;
        if (r5 == null) goto L21;
        r5.b(r1);
        return;
    L21:
        return;
    L17:
        SheetBaseBehavior.b r6 = this.b;
        if (r6 == null) goto L23;
        r6.b(r1);
        return;
    L23:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior
    public final void setPeekHeight(int r4) {
        boolean r1 = true;
        if (r4 != (-1)) goto L8;
        if (this.k == true) goto L12;
        this.k = true;
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        if (this.q != 4) goto L25;
        WeakReference<V> r5 = this.w;
        if (r5 == null) goto L20;
        V r6 = r5.get();
    L21:
        if (r6 == null) goto L26;
        r6.requestLayout();
        return;
    L26:
        return;
    L20:
        r6 = null;
        goto L21
    L25:
        return;
    L12:
        r1 = false;
        goto L14
    L8:
        if (this.k == false) goto L10;
    L13:
        this.k = false;
        this.j = Math.max(0, r4);
        this.p = this.v - r4;
        goto L14
    L10:
        if (this.j == r4) goto L12;
        goto L12
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior
    public final void setState(int r3) {
        if (r3 == this.q) goto L30;
        WeakReference<V> r0 = this.w;
        if (r0 == null) goto L7;
        if (r0 == null) goto L19;
        V r1 = r0.get();
    L20:
        if (r1 == null) goto L34;
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L24;
    L28:
        startSettlingAnimation(r1, r3);
        return;
    L24:
        if (r2.isLayoutRequested() == false) goto L28;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L28;
        r1.post(new b(this, r1, r3));
        return;
    L34:
        return;
    L19:
        r1 = null;
        goto L20
    L7:
        if (r3 != 4) goto L9;
    L16:
        this.q = r3;
        return;
    L9:
        if (r3 == 3) goto L16;
        if (r3 == 6) goto L16;
        if (this.a == true) goto L15;
        return;
    L15:
        if (r3 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r3) {
        if (this.q == r3) goto L20;
        this.q = r3;
        if (r3 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        WeakReference<V> r0 = this.w;
        Intrinsics.checkNotNull(r0);
        V r1 = r0.get();
        if (r1 == null) goto L21;
        SheetBaseBehavior.b r2 = this.b;
        if (r2 == null) goto L22;
        Intrinsics.checkNotNull(r2);
        r2.a(r1, r3);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (r3 == 3) goto L13;
        if (r3 != 5) goto L11;
    L12:
        updateImportantForAccessibility(false);
        goto L14
    L11:
        if (r3 != 4) goto L14;
    }

    public final void updateImportantForAccessibility(boolean r8) {
        WeakReference<V> r0 = this.w;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        V r1 = r0.get();
    L8:
        if (r1 == null) goto L43;
        CoordinatorLayout r2 = r1.getParent();
        if ((r2 instanceof CoordinatorLayout) == false) goto L54;
        CoordinatorLayout r3 = r2;
        int r4 = r3.getChildCount();
        if (r8 == true) goto L14;
    L17:
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L40;
        View r6 = r3.getChildAt(r5);
        WeakReference<V> r7 = this.w;
        if (r7 == null) goto L22;
        V r9 = r7.get();
    L23:
        if (r6 == r9) goto L39;
        if (r8 == true) goto L35;
        Map<View, Integer> r10 = this.C;
        if (r10 == null) goto L39;
        if (r10 == null) goto L39;
        if (r10.containsKey(r6) != true) goto L39;
        Map<View, Integer> r11 = this.C;
        if (r11 == null) goto L39;
        Integer r12 = r11.get(r6);
        if (r12 == null) goto L39;
        ViewCompat.setImportantForAccessibility(r6, r12.intValue());
        goto L39
    L35:
        Map<View, Integer> r13 = this.C;
        if (r13 == null) goto L38;
        Integer r14 = r13.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L38:
        ViewCompat.setImportantForAccessibility(r6, 4);
    L39:
        r5 = r5 + 1;
        goto L18
    L22:
        r9 = null;
        goto L23
    L40:
        if (r8 == true) goto L55;
        this.C = null;
        return;
    L55:
        return;
    L14:
        if (this.C == null) goto L16;
        return;
    L16:
        this.C = new HashMap(r4);
        goto L17
    L54:
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L7:
        r1 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.shopping.yata.biz.popup.behavior.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.h = true;
        this.q = 4;
        this.D = new BottomSheetBehavior$dragCallback$1(this);
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130968990, 2130968991, 2130968993, 2130968994});
        TypedValue r2 = r7.peekValue(2);
        if (r2 == null) goto L7;
        int r3 = r2.data;
        if (r3 != (-1)) goto L7;
        setPeekHeight(r3);
    L8:
        this.a = r7.getBoolean(1, false);
        if (this.h == true) goto L20;
        this.h = true;
        if (this.w == null) goto L14;
        this.p = Math.max(this.v - this.m, this.n);
    L14:
        if (this.h == true) goto L16;
    L18:
        int r0 = this.q;
    L19:
        setStateInternal(r0);
        goto L20
    L16:
        if (this.q != 6) goto L18;
        r0 = 3;
    L20:
        this.c = r7.getBoolean(3, false);
        r7.recycle();
        this.i = ViewConfiguration.get(r5).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r7.getDimensionPixelSize(2, -1));
        goto L8
    }

    public final Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        return new SavedState(super.onSaveInstanceState(r2, r3), this.q);
    }

    public final boolean shouldHide(View r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "child");
        if (this.c == false) goto L14;
        float r9 = r8 * 0.1f;
        if (r9 <= 500) goto L8;
        return true;
    L8:
        if (r9 >= (-30)) goto L11;
        return false;
    L11:
        if (((this.v - (r7.getTop() + r9)) / r7.getHeight()) < 0.5f) goto L20;
    L15:
        return false;
    L20:
        return true;
    L14:
        if (r7.getTop() < this.p) goto L15;
        if ((Math.abs((r7.getTop() + (r8 * 0.1f)) - this.p) / this.j) <= 0.5f) goto L15;
        return true;
    }

    public final void startSettlingAnimation(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if (r6 != 4) goto L6;
        int r0 = this.p;
    L22:
        ViewDragHelper r2 = this.r;
        if (r2 != null) goto L25;
    L27:
        setStateInternal(r6);
        return;
    L25:
        if (r2.smoothSlideViewTo(r5, r5.getLeft(), r0) != true) goto L27;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new a(this, r5, r6));
        return;
    L6:
        if (r6 != 6) goto L12;
        r0 = this.o;
        if (this.h == false) goto L22;
        int r3 = this.n;
        if (r0 > r3) goto L22;
        r0 = r3;
        r6 = 3;
        goto L22
    L12:
        if (r6 != 3) goto L15;
        r0 = getExpandedOffset();
        goto L22
    L15:
        if (this.a == true) goto L17;
    L19:
        boolean r1 = false;
    L20:
        if (r1 == false) goto L30;
        r0 = this.v;
        goto L22
    L30:
        throw new IllegalArgumentException(("Illegal state argument: " + r6).toString());
    L17:
        if (r6 != 5) goto L19;
        r1 = true;
        goto L20
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r11.isShown() == true) goto L5;
    L70:
        this.s = true;
        return false;
    L5:
        if (this.e.a.d == true) goto L7;
        r12.getY();
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.f.getClass();
        goto L70
    L10:
        this.f.getClass();
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getActionMasked();
        View r2 = null;
        if (r0 != 0) goto L16;
        this.z = -1;
        VelocityTracker r5 = this.y;
        if (r5 == null) goto L16;
        Intrinsics.checkNotNull(r5);
        r5.recycle();
        this.y = null;
    L16:
        if (this.y != null) goto L18;
        this.y = VelocityTracker.obtain();
    L18:
        VelocityTracker r6 = this.y;
        Intrinsics.checkNotNull(r6);
        r6.addMovement(r12);
        if (r0 == 0) goto L31;
        if (r0 == 1) goto L26;
        if (r0 != 2) goto L23;
        this.f.getClass();
    L47:
        if (this.s == true) goto L53;
        ViewDragHelper r13 = this.r;
        if (r13 == null) goto L53;
        if (r13.shouldInterceptTouchEvent(r12) != true) goto L53;
        return true;
    L53:
        b();
        WeakReference<View> r14 = this.x;
        if (r14 == null) goto L56;
        Intrinsics.checkNotNull(r14);
        r2 = r14.get();
    L56:
        if (r0 == 2) goto L58;
        return false;
    L58:
        if (this.s == false) goto L60;
        return false;
    L60:
        if (this.r == null) goto L74;
        float r15 = Math.abs(this.A - r12.getY());
        ViewDragHelper r3 = this.r;
        Intrinsics.checkNotNull(r3);
        if (r15 > r3.getTouchSlop()) goto L64;
        return false;
    L64:
        if (this.q == 1) goto L76;
        if (r2 != null) goto L67;
        return false;
    L67:
        if (r10.isPointInChildBounds(r2, (int) r12.getX(), (int) r12.getY()) == true) goto L78;
        return true;
    L78:
        return false;
    L76:
        return false;
    L74:
        return false;
    L23:
        if (r0 != 3) goto L47;
    L26:
        this.B = false;
        this.z = -1;
        if (this.s == false) goto L30;
        this.s = false;
        return false;
    L30:
        this.f.getClass();
        goto L47
    L31:
        int r7 = (int) r12.getX();
        this.A = (int) r12.getY();
        WeakReference<View> r8 = this.x;
        if (r8 == null) goto L34;
        Intrinsics.checkNotNull(r8);
        View r9 = r8.get();
    L35:
        if (r9 == null) goto L40;
        if (r10.isPointInChildBounds(r9, r7, this.A) == false) goto L40;
        this.z = r12.getPointerId(r12.getActionIndex());
        this.B = true;
    L40:
        if (this.z == (-1)) goto L42;
    L44:
        boolean r16 = false;
    L45:
        this.s = r16;
        goto L47
    L42:
        if (r10.isPointInChildBounds(r11, r7, this.A) == true) goto L44;
        r16 = true;
        goto L45
    L34:
        r9 = null;
        goto L35
    L7:
        r1 = true;
        goto L8
    }

    public final boolean onLayoutChild(CoordinatorLayout r5, V r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "child");
        if (ViewCompat.getFitsSystemWindows(r5) == true) goto L5;
    L7:
        int r0 = r6.getTop();
        r5.onLayoutChild(r6, r7);     // Catch: Exception -> L43
        this.v = r5.getHeight();
        if (this.k == true) goto L12;
        this.m = this.j;
    L16:
        int r8 = Math.max(0, this.v - r6.getHeight());
        this.n = r8;
        int r2 = this.v;
        this.o = r2 / 2;
        if (this.h == false) goto L19;
        this.p = Math.max(r2 - this.m, r8);
    L20:
        int r9 = this.q;
        if (r9 != 3) goto L24;
        ViewCompat.offsetTopAndBottom(r6, getExpandedOffset());
    L39:
        if (this.r != null) goto L41;
        this.r = ViewDragHelper.create(r5, this.D);
    L41:
        this.w = new WeakReference(r6);
        this.x = new WeakReference(findScrollingChild(r6));
        b();
        return true;
    L24:
        if (r9 != 6) goto L27;
        ViewCompat.offsetTopAndBottom(r6, this.o);
        goto L39
    L27:
        if (this.a == false) goto L32;
        if (r9 != 5) goto L32;
        ViewCompat.offsetTopAndBottom(r6, this.v);
    L32:
        if (r9 != 4) goto L34;
        ViewCompat.offsetTopAndBottom(r6, this.p);
        goto L39
    L34:
        if (r9 != 1) goto L36;
    L37:
        ViewCompat.offsetTopAndBottom(r6, r0 - r6.getTop());
        goto L39
    L36:
        if (r9 != 2) goto L39;
    L19:
        this.p = r2 - this.m;
        goto L20
    L12:
        if (this.l != 0) goto L14;
        this.l = r5.getResources().getDimensionPixelSize(2131165793);
    L14:
        this.m = Math.max(this.l, this.v - ((r5.getWidth() * 9) / 16));
    L43:
        e = move-exception;
        String r10 = a((ViewGroup) r5.findViewById(2131367491));     // Catch: Exception -> L47
    L49:
        throw new RuntimeException("invalid state in BottomSheetBehavior: " + r10 + " Real exception: " + e);
    L47:
        r10 = "";
        goto L49
    L5:
        if (ViewCompat.getFitsSystemWindows(r6) == true) goto L7;
        r6.setFitsSystemWindows(true);
        goto L7
    }

    public final void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "state");
        SavedState r5 = (SavedState) r4;
        if (r5.getSuperState() == null) goto L5;
        Parcelable r0 = r5.getSuperState();
        Intrinsics.checkNotNull(r0);
        super.onRestoreInstanceState(r2, r3, r0);
    L5:
        int r6 = r5.a;
        if (r6 != 1) goto L8;
    L10:
        this.q = 4;
        return;
    L8:
        if (r6 == 2) goto L10;
        this.q = r6;
    }

    public final boolean onTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "child");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r6.isShown() == false) goto L40;
        int r8 = r7.getActionMasked();
        if (this.q != 1) goto L42;
        if (r8 != 0) goto L42;
        return true;
    L42:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        ViewDragHelper r3 = this.r;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        r3.processTouchEvent(r7);     // Catch: Throwable -> L16
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r4);     // Catch: Throwable -> L16
    L18:
        if (r8 != 0) goto L23;
        this.z = -1;
        VelocityTracker r9 = this.y;
        if (r9 == null) goto L23;
        Intrinsics.checkNotNull(r9);
        r9.recycle();
        this.y = null;
    L23:
        if (this.y != null) goto L25;
        this.y = VelocityTracker.obtain();
    L25:
        VelocityTracker r0 = this.y;
        if (r0 == null) goto L28;
        r0.addMovement(r7);
    L28:
        ViewDragHelper r1 = this.r;
        if (r1 == null) goto L38;
        if (r8 != 2) goto L38;
        if (this.s == true) goto L38;
        if (Math.abs(this.A - r7.getY()) <= r1.getTouchSlop()) goto L38;
        r1.captureChildView(r6, r7.getPointerId(r7.getActionIndex()));
    L38:
        if (this.s == true) goto L40;
        return true;
    L13:
        r4 = null;
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        return false;
    }

    public final void onStopNestedScroll(CoordinatorLayout r5, V r6, View r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r6, "child");
        Intrinsics.checkNotNullParameter(r7, "target");
        if (r6.getTop() != getExpandedOffset()) goto L5;
        b();
        setStateInternal(3);
        return;
    L5:
        WeakReference<View> r9 = this.x;
        Intrinsics.checkNotNull(r9);
        if (r7 == r9.get()) goto L8;
        return;
    L8:
        if (this.u == true) goto L10;
        return;
    L10:
        if (this.t <= 30) goto L14;
        int r10 = getExpandedOffset();
    L12:
        byte r11 = (byte) 3;
    L49:
        if (r11 != 5) goto L52;
        setStateInternal(r11);
        return;
    L52:
        ViewDragHelper r0 = this.r;
        if (r0 != null) goto L55;
    L57:
        setStateInternal(r11);
    L58:
        this.u = false;
        return;
    L55:
        if (r0.smoothSlideViewTo(r6, r6.getLeft(), r10) != true) goto L57;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r6, new a(this, r6, r11));
        goto L58
    L14:
        if (this.a == false) goto L26;
        VelocityTracker r12 = this.y;
        if (r12 == null) goto L21;
        r12.computeCurrentVelocity(ECDraweeView.SQUARE, this.i);
        VelocityTracker r13 = this.y;
        if (r13 == null) goto L21;
        float r14 = r13.getYVelocity(this.z);
    L23:
        if (shouldHide(r6, r14) == false) goto L26;
        r10 = this.v;
        r11 = (byte) 5;
    L21:
        r14 = 0.0f;
    L26:
        if (this.c == false) goto L29;
        r10 = getExpandedOffset();
        goto L12
    L29:
        if (this.t != 0) goto L47;
        int r15 = r6.getTop();
        if (this.h == true) goto L33;
        int r2 = this.o;
        if (r15 >= r2) goto L43;
        if (r15 >= Math.abs(r15 - this.p)) goto L41;
        r11 = (byte) 3;
        r10 = 0;
        goto L49
    L41:
        r10 = this.o;
    L45:
        r11 = (byte) 6;
        goto L49
    L43:
        if (Math.abs(r15 - r2) >= Math.abs(r15 - this.p)) goto L46;
        r10 = this.o;
        goto L45
    L46:
        r10 = this.p;
    L48:
        r11 = (byte) 4;
        goto L49
    L33:
        if (Math.abs(r15 - this.n) >= Math.abs(r15 - this.p)) goto L35;
        r10 = this.n;
        goto L12
    L35:
        r10 = this.p;
        goto L48
    L47:
        r10 = this.p;
        goto L48
    }

    public final boolean onNestedPreFling(CoordinatorLayout r3, V r4, View r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r3, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        WeakReference<View> r0 = this.x;
        Intrinsics.checkNotNull(r0);
        if (r5 == r0.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.q == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r3, r4, r5, r6, r7) == false) goto L9;
        goto L8
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "directTargetChild");
        Intrinsics.checkNotNullParameter(r4, "target");
        this.t = 0;
        this.u = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        if (r8 == 1) goto L25;
        WeakReference<View> r9 = this.x;
        Intrinsics.checkNotNull(r9);
        if (r4 != r9.get()) goto L26;
        int r10 = r3.getTop();
        int r11 = r10 - r6;
        if (r6 > 0) goto L9;
        if (r6 < 0) goto L14;
    L23:
        dispatchOnSlide(r3.getTop());
        this.t = r6;
        this.u = true;
        b();
        return;
    L14:
        if (r4.canScrollVertically(-1) == true) goto L23;
        if (this.e.a.d == true) goto L23;
        int r12 = this.p;
        if (r11 > r12) goto L20;
    L22:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L23
    L20:
        if (this.a == true) goto L22;
        int r13 = r10 - r12;
        r7[1] = r13;
        ViewCompat.offsetTopAndBottom(r3, -r13);
        setStateInternal(4);
        goto L23
    L9:
        if (r11 >= getExpandedOffset()) goto L11;
        int r14 = r10 - getExpandedOffset();
        r7[1] = r14;
        ViewCompat.offsetTopAndBottom(r3, -r14);
        setStateInternal(3);
        goto L23
    L11:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L23
    L26:
        return;
    }
}
