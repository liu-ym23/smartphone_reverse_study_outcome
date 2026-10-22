package com.relax.relaxui.behaviors.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class AndroidScrollView extends androidx.core.widget.NestedScrollView implements IDrawChildHook.IDrawChildHookBinding {
    public static final /* synthetic */ int D = 0;
    public int A;
    public int B;
    public Rect C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f405606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f405607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIScrollView f405608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public opa.a f405609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f405610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CustomHorizontalScrollView f405611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f405612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f405613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f405614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f405615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f405616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f405617l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<b> f405618m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IDrawChildHook f405619n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f405620o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f405621p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f405622q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f405623r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f405624s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f405625t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f405626u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f405627v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f405628w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f405629x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f405630y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f405631z;

    public class CustomHorizontalScrollView extends NestedHorizontalScrollView {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ AndroidScrollView f405632s;

        @Override // android.widget.HorizontalScrollView
        public final int computeScrollDeltaToGetChildRectOnScreen(Rect r100) {
            if (this.f405632s.f405625t == false) goto L5;
            return 0;
        L5:
            return super.computeScrollDeltaToGetChildRectOnScreen(r100);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            if (this.f405632s.f405608c.isEnableNewGesture() == false) goto L15;
            if (Boolean.FALSE.equals(this.f405632s.f405607b) == false) goto L8;
            return true;
        L8:
            if (r100.getActionMasked() != 2) goto L15;
            AndroidScrollView r101 = this.f405632s;
            if (r101.f405607b == null) goto L15;
            if (r101.f405606a == true) goto L15;
            r100.setAction(0);
            this.f405632s.f405606a = true;
        L15:
            return super.dispatchTouchEvent(r100);
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView
        public final void fling(int r110) {
            AndroidScrollView r100 = this.f405632s;
            if (r100.A != 1) goto L5;
            r100.f(2);
        L5:
            ArrayList<b> r101 = this.f405632s.f405618m;
            if (r101 == null) goto L14;
            Iterator<b> r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L14;
            b r103 = r102.next();
            if (r103 == null) goto L9;
            r103.onFling();
        L14:
            if (this.f405632s.f405629x == true) goto L31;
            super.fling(r110);
            return;
        L31:
            Field r104 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L28
            if (r104 == null) goto L27;
            r104.setAccessible(true);     // Catch: Throwable -> L28
            OverScroller r105 = (OverScroller) r104.get(this);     // Catch: Throwable -> L28
            if (r105 == null) goto L25;
            if (getChildCount() <= 0) goto L38;
            int r106 = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int r107 = getChildAt(0).getWidth();
            r105.fling(getScrollX(), getScrollY(), r110, 0, 0, Math.max(0, r107 - r106), 0, 0, r106 / 2, 0);
            postInvalidateOnAnimation();
            return;
        L38:
            return;
        L25:
            throw new Exception("failed to get mScroller in HorizontalScrollView");     // Catch: Throwable -> L28
        L27:
            throw new Exception("can not find mScroller field in HorizontalScrollView");     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            LLog.w("AndroidScrollView", th.getMessage());
            super.fling(r110);
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r100) {
            AndroidScrollView r101 = this.f405632s;
            if (r101.f405614i == true) goto L5;
            return false;
        L5:
            if (r101.f405608c.isEnableNewGesture() == false) goto L14;
            Boolean r102 = this.f405632s.f405607b;
            if (r102 == null) goto L11;
            if (r102.booleanValue() == true) goto L14;
        L11:
            if (r100.getActionMasked() == 0) goto L14;
            return false;
        L14:
            return super.onInterceptTouchEvent(r100);
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            AndroidScrollView r101 = this.f405632s;
            if (r101.f405614i == true) goto L5;
        L33:
            return false;
        L5:
            if (r101.f405608c.isEnableNewGesture() == false) goto L16;
            Boolean r102 = this.f405632s.f405607b;
            if (r102 == null) goto L11;
            if (r102.booleanValue() == true) goto L16;
        L11:
            if (r100.getActionMasked() == 0) goto L16;
            if (r100.getAction() != 1) goto L15;
            this.f405632s.f405615j = false;
        L15:
            return false;
        L16:
            AndroidScrollView r103 = this.f405632s;
            if (r100.getAction() != 2) goto L19;
            boolean r104 = true;
        L20:
            r103.f405630y = r104;
            if (r100.getAction() != 1) goto L24;
            AndroidScrollView r105 = this.f405632s;
            r105.f405615j = false;
            r105.f405630y = false;
            r105.f405608c.o0();
        L35:
            return super.onTouchEvent(r100);
        L31:
            e = move-exception;
            LLog.e("LynxUIScrollView", "CustomHorizontalScrollView onTouchEvent: " + r100.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L34
            goto L33
        L24:
            if (r100.getAction() != 0) goto L27;
            AndroidScrollView r106 = this.f405632s;
            r106.f405615j = true;
            r106.f405608c.n0(r106.A);
            goto L35
        L27:
            if (r100.getAction() != 3) goto L35;
            this.f405632s.f405630y = false;
            goto L35
        L19:
            r104 = false;
            goto L20
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedPreFling(float r100, float r101) {
            boolean r102 = super.dispatchNestedPreFling(r100, r101);
            if (r102 == false) goto L5;
            AndroidScrollView r103 = this.f405632s;
            int r104 = AndroidScrollView.D;
            r103.j(4);
        L5:
            return r102;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
        }

        public CustomHorizontalScrollView(AndroidScrollView r100, Context r101, UIScrollView r102) {
            this.f405632s = r100;
            super(r101, r102);
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
            boolean r103 = super.dispatchNestedFling(r100, r101, r102);
            if (r103 == false) goto L5;
            AndroidScrollView r104 = this.f405632s;
            int r105 = AndroidScrollView.D;
            r104.j(4);
        L5:
            return r103;
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
            boolean r104 = super.dispatchNestedPreScroll(r100, r101, r102, r103);
            if (r104 == false) goto L5;
            AndroidScrollView r105 = this.f405632s;
            int r106 = AndroidScrollView.D;
            r105.j(4);
        L5:
            return r104;
        }

        @Override // android.view.View
        public final void onScrollChanged(int r100, int r101, int r102, int r103) {
            super.onScrollChanged(r100, r101, r102, r103);
            AndroidScrollView r104 = this.f405632s;
            if (r100 != r104.f405613h) goto L5;
            return;
        L5:
            r104.f405613h = getScrollX();
            AndroidScrollView r105 = this.f405632s;
            if (r105.A != 0) goto L8;
            r105.i();
        L8:
            ArrayList<b> r106 = this.f405632s.f405618m;
            if (r106 == null) goto L16;
            Iterator<b> r107 = r106.iterator();
        L12:
            if (r107.hasNext() == false) goto L16;
            b r108 = r107.next();
            if (r108 == null) goto L12;
            r108.onScrollChanged(r100, r101, r102, r103);
        L16:
            AndroidScrollView r109 = this.f405632s;
            if (r109.f405615j == false) goto L19;
            return;
        L19:
            if (r109.f405624s == true) goto L28;
            r109.f405608c.o0();
            return;
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, androidx.core.view.NestedScrollingChild2
        public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
            boolean r105 = super.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
            if (r105 == false) goto L5;
            AndroidScrollView r106 = this.f405632s;
            int r107 = AndroidScrollView.D;
            r106.j(4);
        L5:
            return r105;
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104) {
            boolean r105 = super.dispatchNestedScroll(r100, r101, r102, r103, r104);
            if (r105 == false) goto L5;
            AndroidScrollView r106 = this.f405632s;
            int r107 = AndroidScrollView.D;
            r106.j(4);
        L5:
            return r105;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            int r105 = getScrollX();
            super.onLayout(r100, r101, r102, r103, r104);
            if (this.f405632s.f405614i == true) goto L6;
            return;
        L6:
            if (getChildCount() <= 0) goto L8;
            int r106 = getChildAt(0).getMeasuredWidth();
        L9:
            int r107 = Math.max(0, r106 - (((r103 - r101) - getPaddingLeft()) - getPaddingRight()));
            if (this.f405632s.f405628w == false) goto L17;
            if (ViewCompat.getLayoutDirection(this) != 1) goto L14;
            int r108 = r107;
        L15:
            setScrollX(r108);
            AndroidScrollView r109 = this.f405632s;
            r109.f405628w = false;
            r109.f405613h = getScrollX();
        L28:
            this.f405632s.f405627v = r107;
            int r110 = this.f405653r.f524800e;
            if (this.f405638c == false) goto L35;
            if (r110 > 0) goto L32;
            return;
        L32:
            if (r110 == getScrollX()) goto L37;
            this.f405632s.h(r110, getScrollY(), false);
            return;
        L37:
            return;
        L35:
            return;
        L14:
            r108 = 0;
            goto L15
        L17:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L28;
            if (ViewCompat.isLaidOut(this) == true) goto L23;
            AndroidScrollView r111 = this.f405632s;
            if (r111.f405627v != r107) goto L23;
            setScrollX(r111.f405613h);
        L27:
            AndroidScrollView r112 = this.f405632s;
            r112.f405613h = getScrollX();
        L23:
            int r113 = this.f405632s.f405627v;
            if (r113 == r107) goto L27;
            if (r113 < 0) goto L27;
            setScrollX(MathUtils.clamp(r105 + (r107 - r113), 0, r107));
            goto L27
        L8:
            r106 = 0;
            goto L9
        }

        @Override // com.relax.relaxui.behaviors.scroll.NestedHorizontalScrollView, androidx.core.view.NestedScrollingChild2
        public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105) {
            boolean r106 = super.dispatchNestedScroll(r100, r101, r102, r103, r104, r105);
            if (r106 == false) goto L5;
            AndroidScrollView r107 = this.f405632s;
            int r108 = AndroidScrollView.D;
            r107.j(4);
        L5:
            return r106;
        }
    }

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f405633a;

        public a(boolean r100) {
            this.f405633a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return !this.f405633a;
        }
    }

    public interface b {
        void a();

        void b();

        void onFling();

        void onScrollChanged(int r100, int r101, int r102, int r103);

        void onScrollStateChanged(int r100);
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AndroidScrollView> f405634a;

        public final void a() {
            if (this.f405634a.get() == null) goto L33;
            AndroidScrollView r100 = this.f405634a.get();
            int r101 = r100.getScrollY();
            int r102 = r100.f405611f.getScrollX();
            boolean r103 = r100.f405614i;
            if (r103 == true) goto L7;
        L8:
            if (r103 == false) goto L10;
        L12:
            boolean r104 = false;
        L14:
            if (r100.f405615j == true) goto L26;
            if (r104 == false) goto L26;
            r100.f(0);
            ArrayList<b> r105 = r100.f405618m;
            if (r105 == null) goto L25;
            Iterator<b> r106 = r105.iterator();
        L21:
            if (r106.hasNext() == false) goto L25;
            b r107 = r106.next();
            if (r107 == null) goto L21;
            r107.b();
        L25:
            r100.f405608c.o0();
            return;
        L26:
            r100.f405621p = r101;
            r100.f405622q = r102;
            r100.postDelayed(this, 100);
            return;
        L10:
            if ((r100.f405621p - r101) != 0) goto L12;
        L11:
            r104 = true;
            goto L14
        L7:
            if ((r100.f405622q - r102) == 0) goto L11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(AndroidScrollView r100) {
            this.f405634a = new WeakReference(r100);
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AndroidScrollView> f405635a;

        public final void a() {
            WeakReference<AndroidScrollView> r100 = this.f405635a;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.get() != null) goto L7;
            return;
        L7:
            if (this.f405635a.get().f405609d == null) goto L46;
            AndroidScrollView r101 = this.f405635a.get();
            if (r101.f405624s == false) goto L47;
            int r102 = r101.getRealScrollX();
            int r103 = r101.getRealScrollY();
            int r104 = r101.f405626u;
            opa.a r105 = r101.f405609d;
            if (r101.f405614i == true) goto L21;
            int r106 = r103 + r104;
            r101.h(r102, r106, false);
            if (r104 >= 0) goto L18;
            if (r103 > 0) goto L16;
            r101.f405624s = false;
            return;
        L16:
            r101.postDelayed(this, 16);
            return;
        L18:
            if ((r106 + r101.getMeasuredHeight()) >= r105.getMeasuredHeight()) goto L20;
            r101.postDelayed(this, 16);
            return;
        L20:
            r101.f405624s = false;
            return;
        L21:
            boolean r107 = true;
            if (ViewCompat.getLayoutDirection(r101) != 1) goto L24;
            int r108 = r102 - r104;
        L25:
            r101.h(r108, r103, false);
            if (r104 < 0) goto L28;
            if (r108 > 0) goto L40;
        L42:
            r101.f405624s = false;
            return;
        L40:
            if ((r108 + r101.getMeasuredWidth()) >= r105.getMeasuredWidth()) goto L42;
            r101.postDelayed(this, 16);
            return;
        L28:
            if (ViewCompat.getLayoutDirection(r101) != 0) goto L32;
            if (r102 <= 0) goto L35;
        L34:
            r107 = false;
        L35:
            if (r107 == false) goto L37;
            r101.f405624s = false;
            return;
        L37:
            r101.postDelayed(this, 16);
            return;
        L32:
            if ((r108 + r101.getMeasuredWidth()) < r105.getMeasuredWidth()) goto L34;
        L24:
            r108 = r102 + r104;
            goto L25
        L47:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(AndroidScrollView r100) {
            this.f405635a = new WeakReference(r100);
        }
    }

    public int getOrientation() {
        return this.f405609d.getOrientation();
    }

    public int getRealScrollX() {
        if (this.f405614i == false) goto L7;
        return this.f405611f.getScrollX();
    L7:
        return getScrollX();
    }

    public int getRealScrollY() {
        if (this.f405614i == false) goto L7;
        return this.f405611f.getScrollY();
    L7:
        return getScrollY();
    }

    public final void i() {
        ArrayList<b> r100 = this.f405618m;
        if (r100 == null) goto L11;
        Iterator<b> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        b r102 = r101.next();
        if (r102 == null) goto L6;
        r102.a();
    L11:
        if (this.f405615j == false) goto L13;
    L16:
        int r103 = 1;
    L17:
        f(r103);
        this.f405621p = getScrollY();
        this.f405622q = this.f405611f.getScrollX();
        postDelayed(this.f405620o, 100);
        return;
    L13:
        if (this.f405630y == true) goto L16;
        r103 = 3;
        goto L17
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f405610e == false) goto L5;
        this.f405609d.removeAllViews();
        return;
    L5:
        super.removeAllViews();
        this.f405610e = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        UIScrollView r100 = this.f405608c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f405677s == (-1)) goto L7;
        LLog.i("LynxUIScrollView", "computeScroll: apply mPendingScrollToIndex when computing scroll " + this.f405608c.f405677s);
        setScrollToIndex(this.f405608c.f405677s);
        this.f405608c.f405677s = -1;
    L7:
        this.f405608c.l0();
        if (this.f405608c.isEnableNewGesture() == false) goto L14;
        q7a.b r101 = this.f405608c.getGestureArenaManager();
        if (r101 == null) goto L15;
        r101.b();
        return;
    L15:
        return;
    }

    public int getContentHeight() {
        return this.f405617l;
    }

    public int getContentWidth() {
        return this.f405616k;
    }

    public CustomHorizontalScrollView getHScrollView() {
        return this.f405611f;
    }

    public LinearLayout getLinearLayout() {
        return this.f405609d;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f405610e == false) goto L5;
        this.f405609d.addView(r100);
        return;
    L5:
        super.addView(r100);
        this.f405610e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f405619n = r100;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f405608c.isEnableNewGesture() == false) goto L7;
        return super.canScrollVertically(r100);
    L7:
        if (this.f405631z == false) goto L11;
        if (this.f405614i == true) goto L11;
    L12:
        return true;
    L11:
        if (super.canScrollVertically(r100) == true) goto L12;
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView
    public final int computeScrollDeltaToGetChildRectOnScreen(Rect r100) {
        if (this.f405625t == false) goto L5;
        return 0;
    L5:
        return super.computeScrollDeltaToGetChildRectOnScreen(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Drawable r100 = getBackground();
        if ((r100 instanceof BackgroundDrawable) == false) goto L13;
        BackgroundDrawable r101 = (BackgroundDrawable) r100;
        RectF r102 = r101.b();
        BorderRadius r103 = r101.A;
        Rect r104 = this.C;
        if (r104 != null) goto L7;
        r104 = r100.getBounds();
    L7:
        Path r105 = new Path();
        float r106 = r104.left + r102.left;
        float r107 = r104.top + r102.top;
        int r108 = this.f405612g;
        RectF r109 = new RectF(r106, r107 + r108, r104.right - r102.right, (r104.bottom - r102.bottom) + r108);
        if (r103 != null) goto L10;
        r105.addRect(r109, Path.Direction.CW);
    L11:
        int r111 = r110.save();
        r110.clipPath(r105);
        super.dispatchDraw(r110);
        r110.restoreToCount(r111);
        return;
    L10:
        r105.addRoundRect(r109, BackgroundDrawable.RoundRectPath.c(r103.a(), r102, 1.0f), Path.Direction.CW);
        goto L11
    L13:
        if ((getParent() instanceof ViewGroup) == false) goto L25;
        ViewGroup r112 = (ViewGroup) getParent();
        if (getClipBounds() != null) goto L25;
        Rect r113 = this.f405623r;
        int r114 = getScrollX();
        int r115 = getScrollY();
        int r116 = getScrollX();
        Rect r117 = this.C;
        if (r117 != null) goto L19;
        int r118 = getWidth();
    L20:
        int r119 = r116 + r118;
        int r120 = getScrollY();
        Rect r121 = this.C;
        if (r121 != null) goto L23;
        int r122 = getHeight();
    L24:
        r113.set(r114, r115, r119, r120 + r122);
        r110.clipRect(this.f405623r);
        goto L25
    L23:
        r122 = r121.height();
        goto L24
    L19:
        r118 = r117.width();
    L25:
        super.dispatchDraw(r110);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f405608c.isEnableNewGesture() == false) goto L15;
        if (Boolean.FALSE.equals(this.f405607b) == false) goto L8;
        return true;
    L8:
        if (r100.getActionMasked() != 2) goto L15;
        if (this.f405607b == null) goto L15;
        if (this.f405606a == true) goto L15;
        r100.setAction(0);
        this.f405606a = true;
    L15:
        return super.dispatchTouchEvent(r100);
    }

    public final void e(View r100) {
    L18:
        th = move-exception;
        LLog.w("AndroidScrollView", th.getMessage());
        return;
    L5:
        if ((r100 instanceof HorizontalScrollView) == false) goto L8;
        Field r101 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L18
    L11:
        if (r101 != null) goto L14;
        LLog.w("AndroidScrollView", "did not find mScroller in ".concat(r100.getClass().getName()));     // Catch: Throwable -> L18
        return;
    L14:
        r101.setAccessible(true);     // Catch: Throwable -> L18
        OverScroller r102 = (OverScroller) r101.get(r100);     // Catch: Throwable -> L18
        if (r102.isFinished() == true) goto L22;
        r102.abortAnimation();     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L8:
        if ((r100 instanceof ScrollView) == false) goto L10;
        r101 = ScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L18
        goto L11
    L10:
        r101 = null;
        goto L11
    }

    public final void f(int r100) {
        LLog.i("LynxUIScrollView", "notifyStateChange " + this.A + " -> " + r100);
        int r101 = this.A;
        if (r101 == r100) goto L6;
        this.B = r101;
        this.A = r100;
        j(r100);
        return;
    }

    @Override // androidx.core.widget.NestedScrollView
    public final void fling(int r100) {
        super.fling(r100);
        if (this.A != 1) goto L5;
        f(2);
    L5:
        ArrayList<b> r101 = this.f405618m;
        if (r101 == null) goto L13;
        Iterator<b> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        b r103 = r102.next();
        if (r103 == null) goto L9;
        r103.onFling();
        goto L9
    L19:
        return;
    }

    public final void j(int r100) {
        ArrayList<b> r101 = this.f405618m;
        if (r101 == null) goto L10;
        Iterator<b> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        b r103 = r102.next();
        if (r103 == null) goto L6;
        r103.onScrollStateChanged(r100);
        goto L6
    L16:
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f405614i == false) goto L5;
        return false;
    L5:
        if (this.f405608c.f405671m == false) goto L8;
        requestDisallowInterceptTouchEvent(true);
    L8:
        if (this.f405608c.isEnableNewGesture() == false) goto L17;
        Boolean r101 = this.f405607b;
        if (r101 == null) goto L14;
        if (r101.booleanValue() == true) goto L17;
    L14:
        if (r100.getActionMasked() == 0) goto L17;
        return false;
    L17:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f405614i == false) goto L5;
    L53:
        return false;
    L5:
        if (this.f405608c.isEnableNewGesture() == false) goto L17;
        Boolean r101 = this.f405607b;
        if (r101 == null) goto L11;
        if (r101.booleanValue() == true) goto L17;
    L11:
        if (r100.getActionMasked() == 0) goto L17;
        if (r100.getAction() != 1) goto L15;
        this.f405615j = false;
    L15:
        return false;
    L17:
        if (r100.getAction() != 2) goto L19;
        boolean r102 = true;
    L20:
        this.f405630y = r102;
        boolean r103 = super.onTouchEvent(r100);     // Catch: IllegalStateException -> L32 Throwable -> L44
        goto L45
    L23:
        if (r100.getAction() != 1) goto L26;
        this.f405615j = false;
        this.f405630y = false;
        this.f405608c.o0();
        stopNestedScroll(0);
    L31:
        return r103;
    L26:
        if (r100.getAction() != 0) goto L29;
        this.f405615j = true;
        this.f405608c.n0(this.A);
        goto L31
    L29:
        if (r100.getAction() != 3) goto L31;
        this.f405630y = false;
        stopNestedScroll(0);
    L32:
        e = move-exception;
        LLog.e("LynxUIScrollView", "AndroidScrollView onTouchEvent: " + r100.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L44
        if (r100.getAction() != 1) goto L38;
        this.f405615j = false;
        this.f405630y = false;
        this.f405608c.o0();
        stopNestedScroll(0);
    L43:
        return false;
    L38:
        if (r100.getAction() != 0) goto L41;
        this.f405615j = true;
        this.f405608c.n0(this.A);
        goto L43
    L41:
        if (r100.getAction() != 3) goto L43;
        this.f405630y = false;
        stopNestedScroll(0);
    L45:
        if (r100.getAction() != 1) goto L48;
        this.f405615j = false;
        this.f405630y = false;
        this.f405608c.o0();
        stopNestedScroll(0);
        goto L53
    L48:
        if (r100.getAction() != 0) goto L51;
        this.f405615j = true;
        this.f405608c.n0(this.A);
        goto L53
    L51:
        if (r100.getAction() != 3) goto L53;
        this.f405630y = false;
        stopNestedScroll(0);
        goto L53
    L19:
        r102 = false;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f405610e == false) goto L5;
        this.f405609d.removeView(r100);
        return;
    L5:
        super.removeView(r100);
        this.f405610e = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        if (this.f405610e == false) goto L5;
        this.f405609d.removeViewAt(r100);
        return;
    L5:
        super.removeViewAt(r100);
        this.f405610e = true;
    }

    public void setBlockDescendantFocusability(boolean r100) {
        this.f405625t = r100;
    }

    @Override // android.view.View
    public void setClipBounds(Rect r100) {
        this.C = r100;
    }

    public void setEnableScroll(boolean r100) {
        a r101 = new a(r100);
        this.f405611f.setOnTouchListener(r101);
        setOnTouchListener(r101);
    }

    public void setForceCanScroll(boolean r100) {
        this.f405631z = r100;
    }

    public void setOnScrollListener(b r100) {
        if (this.f405618m != null) goto L5;
        this.f405618m = new ArrayList();
    L5:
        if (r100 == null) goto L8;
        this.f405618m.add(r100);
        return;
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L5;
        this.f405609d.setOrientation(0);
        this.f405614i = true;
        return;
    L5:
        if (r100 != 1) goto L9;
        this.f405609d.setOrientation(1);
        this.f405614i = false;
        return;
    }

    public void setScrollBarEnable(boolean r100) {
        setVerticalScrollBarEnabled(r100);
    }

    public void setScrollToIndex(int r100) {
        UIScrollView r101 = this.f405608c;
        if (r101 == null) goto L20;
        int r102 = r101.getChildCount();
        if (r102 == 0) goto L21;
        if (r100 < 0) goto L22;
        if (r100 < r102) goto L9;
        return;
    L9:
        if (this.f405608c.getChildAt(r100) != null) goto L12;
        return;
    L12:
        if (this.f405614i == false) goto L18;
        int r103 = this.f405611f.getScrollY();
        this.f405611f.getScrollX();
        LynxBaseUI r104 = this.f405608c.getChildAt(r100);
        if (ViewCompat.getLayoutDirection(this) != 1) goto L16;
        int r105 = (r104.getLeft() + r104.getWidth()) - this.f405608c.getWidth();
    L17:
        h(r105, r103, false);
        return;
    L16:
        r105 = r104.getLeft();
        goto L17
    L18:
        h(getScrollX(), this.f405608c.getChildAt(r100).getTop(), false);
        return;
    L22:
        return;
    L21:
        return;
    }

    public AndroidScrollView(Context r100, UIScrollView r101) {
        super(r100);
        this.f405606a = true;
        this.f405607b = null;
        this.f405610e = false;
        this.f405614i = false;
        this.f405615j = false;
        this.f405616k = 0;
        this.f405617l = 0;
        this.f405621p = 0;
        this.f405622q = 0;
        this.f405624s = false;
        this.f405625t = false;
        this.f405626u = 0;
        this.f405627v = 0;
        this.f405628w = false;
        this.f405629x = false;
        this.f405630y = false;
        this.f405631z = false;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.f405608c = r101;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.f405623r = new Rect();
        this.f405618m = new ArrayList();
        if (this.f405609d != null) goto L5;
        opa.a r102 = new opa.a(this, getContext());
        this.f405609d = r102;
        r102.setOrientation(1);
        this.f405609d.setWillNotDraw(true);
        this.f405609d.setFocusableInTouchMode(true);
        CustomHorizontalScrollView r103 = new CustomHorizontalScrollView(this, getContext(), r101);
        this.f405611f = r103;
        r103.setOverScrollMode(2);
        this.f405611f.setFadingEdgeLength(0);
        this.f405611f.setWillNotDraw(true);
        this.f405611f.addView(this.f405609d, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f405611f, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f405620o = new c(this);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        if (this.f405610e == false) goto L5;
        this.f405609d.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f405610e = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        boolean r102 = super.dispatchNestedPreFling(r100, r101);
        if (r102 == false) goto L5;
        j(4);
    L5:
        return r102;
    }

    public final void g(int r110, int r111) {
        boolean r100 = false;
        int r101 = this.f405608c.v0(r110, r111, 0, 0);
        UIScrollView r102 = this.f405608c;
        if (r102.f405663e == true) goto L5;
    L10:
        UIScrollView r112 = this.f405608c;
        if (r112.f405661c == true) goto L13;
    L18:
        UIScrollView r103 = this.f405608c;
        if (r103.f405664f == true) goto L21;
        return;
    L21:
        if ((r101 & 1) == 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L26;
        return;
    L26:
        if ((r101 & 2) == 0) goto L28;
        r100 = true;
    L28:
        if (r100 == true) goto L33;
        r103.q0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltonormalstate");
        return;
    L33:
        return;
    L23:
        r104 = false;
        goto L24
    L13:
        if ((r101 & 1) == 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        r112.q0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltoupperedge");
        goto L18
    L15:
        r105 = false;
        goto L16
    L5:
        if ((r101 & 2) == 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        r102.q0(getScrollX(), getScrollY(), getScrollX(), getScrollY(), "scrolltoloweredge");
        goto L10
    L7:
        r106 = false;
        goto L8
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (this.f405610e == false) goto L5;
        this.f405609d.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f405610e = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        if (this.f405610e == false) goto L5;
        this.f405609d.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f405610e = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        boolean r103 = super.dispatchNestedFling(r100, r101, r102);
        if (r103 == false) goto L5;
        j(4);
    L5:
        return r103;
    }

    public final void h(int r100, int r101, boolean r102) {
        if (this.f405613h == r100) goto L5;
    L7:
        if (r102 == false) goto L13;
        if (this.f405614i == false) goto L11;
        this.f405611f.setSmoothScrollingEnabled(true);
        this.f405611f.b(r100, r101);
        return;
    L11:
        setSmoothScrollingEnabled(true);
        super.smoothScrollTo(r100, r101);
        return;
    L13:
        if (this.f405614i == false) goto L15;
        e(this.f405611f);
        this.f405611f.scrollTo(r100, r101);
        return;
    L15:
        e(this);
        scrollTo(r100, r101);
        return;
    L5:
        if (this.f405612g != r101) goto L7;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (this.f405610e == false) goto L5;
        this.f405609d.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f405610e = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        boolean r104 = super.dispatchNestedPreScroll(r100, r101, r102, r103);
        if (r104 == false) goto L5;
        j(4);
    L5:
        return r104;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (r101 != this.f405612g) goto L5;
        return;
    L5:
        this.f405612g = getScrollY();
        if (this.A != 0) goto L8;
        i();
    L8:
        ArrayList<b> r104 = this.f405618m;
        if (r104 == null) goto L17;
        Iterator<b> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        b r106 = r105.next();
        if (r106 == null) goto L12;
        r106.onScrollChanged(r100, r101, r102, r103);
    L17:
        if (this.f405615j == false) goto L19;
    L21:
        g(r100, r101);
        return;
    L19:
        if (this.f405624s == true) goto L21;
        this.f405608c.o0();
        goto L21
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f405609d.setPadding(r100, r101, r102, r103);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
        boolean r105 = super.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
        if (r105 == false) goto L5;
        j(4);
    L5:
        return r105;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104) {
        boolean r105 = super.dispatchNestedScroll(r100, r101, r102, r103, r104);
        if (r105 == false) goto L5;
        j(4);
    L5:
        return r105;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105) {
        boolean r106 = super.dispatchNestedScroll(r100, r101, r102, r103, r104, r105);
        if (r106 == false) goto L5;
        j(4);
    L5:
        return r106;
    }
}
