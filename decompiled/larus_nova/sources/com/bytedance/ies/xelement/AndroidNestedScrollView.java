package com.bytedance.ies.xelement;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public class AndroidNestedScrollView extends NestedScrollView implements IDrawChildHook.IDrawChildHookBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.xelement.a f249567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.xelement.b f249569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f249570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f249576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<a> f249577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IDrawChildHook f249578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f249579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f249580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f249581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f249582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f249583q;

    public interface a {
        void a();

        void b();

        void d();

        void onScrollChanged(int r100, int r101, int r102, int r103);

        void onScrollStateChanged(int r100);
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AndroidNestedScrollView> f249584a;

        public final void a() {
            if (this.f249584a.get() == null) goto L18;
            AndroidNestedScrollView r100 = this.f249584a.get();
            int r101 = r100.getScrollY();
            int r102 = r100.f249569c.getScrollX();
            boolean r103 = r100.f249572f;
            if (r103 == true) goto L7;
        L8:
            if (r103 == false) goto L10;
        L15:
            r100.f249580n = r101;
            r100.f249581o = r102;
            r100.postDelayed(this, r100.f249582p);
            return;
        L10:
            if ((r100.f249580n - r101) != 0) goto L15;
        L11:
            r100.f(0);
            Iterator<a> r104 = r100.f249577k.iterator();
        L13:
            if (r104.hasNext() == false) goto L19;
            r104.next().b();
            goto L13
        L19:
            return;
        L7:
            if ((r100.f249581o - r102) == 0) goto L11;
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

        public b(AndroidNestedScrollView r100) {
            this.f249584a = new WeakReference(r100);
        }
    }

    public final void finalize() throws Throwable {
        removeCallbacks(this.f249579m);
        super.finalize();
    }

    public int getOrientation() {
        return this.f249567a.getOrientation();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f249568b == false) goto L5;
        this.f249567a.removeAllViews();
        return;
    L5:
        super.removeAllViews();
        this.f249568b = true;
    }

    public int getContentHeight() {
        return this.f249574h;
    }

    public int getContentWidth() {
        return this.f249573g;
    }

    public HorizontalScrollView getHScrollView() {
        return this.f249569c;
    }

    public LinearLayout getLinearLayout() {
        return this.f249567a;
    }

    public AndroidNestedScrollView(Context r100) {
        super(r100);
        this.f249568b = false;
        this.f249572f = false;
        this.f249573g = 0;
        this.f249574h = 0;
        this.f249575i = false;
        this.f249576j = false;
        this.f249580n = 0;
        this.f249581o = 0;
        this.f249582p = 300;
        this.f249583q = 0;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.f249577k = new ArrayList();
        if (this.f249567a != null) goto L5;
        com.bytedance.ies.xelement.a r101 = new com.bytedance.ies.xelement.a(this, getContext());
        this.f249567a = r101;
        r101.setOrientation(1);
        this.f249567a.setWillNotDraw(true);
        com.bytedance.ies.xelement.b r102 = new com.bytedance.ies.xelement.b(this, getContext());
        this.f249569c = r102;
        r102.setHorizontalScrollBarEnabled(false);
        this.f249569c.setOverScrollMode(2);
        this.f249569c.setFadingEdgeLength(0);
        this.f249569c.setWillNotDraw(true);
        this.f249569c.addView(this.f249567a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f249569c, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f249579m = new b(this);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f249568b == false) goto L5;
        this.f249567a.addView(r100);
        return;
    L5:
        super.addView(r100);
        this.f249568b = true;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f249578l = r100;
    }

    public final void e(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.f249575i = true;
        return;
    L6:
        if (r100.getAction() == 1) goto L8;
        return;
    L8:
        if (this.f249576j == false) goto L13;
        f(2);
        Iterator<a> r101 = this.f249577k.iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        r101.next().d();
    L13:
        this.f249576j = false;
        this.f249575i = false;
    }

    public final void f(int r100) {
        this.f249583q = r100;
        Iterator<a> r101 = this.f249577k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onScrollStateChanged(r100);
        goto L4
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f249572f == false) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f249572f == true) goto L12;
        e(r100);
        if (r100.getAction() != 0) goto L8;
        f(this.f249583q);
    L8:
        if (r100.getAction() != 1) goto L11;
        this.f249580n = getScrollY();
        this.f249581o = this.f249569c.getScrollX();
        postDelayed(this.f249579m, this.f249582p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f249568b == false) goto L5;
        this.f249567a.removeView(r100);
        return;
    L5:
        super.removeView(r100);
        this.f249568b = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        if (this.f249568b == false) goto L5;
        this.f249567a.removeViewAt(r100);
        return;
    L5:
        super.removeViewAt(r100);
        this.f249568b = true;
    }

    public void setOnScrollListener(a r100) {
        this.f249577k.add(r100);
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L5;
        this.f249567a.setOrientation(0);
        this.f249572f = true;
        return;
    L5:
        if (r100 != 1) goto L9;
        this.f249567a.setOrientation(1);
        this.f249572f = false;
        return;
    }

    public void setScrollBarEnable(boolean r100) {
        setVerticalScrollBarEnabled(r100);
        this.f249569c.setHorizontalScrollBarEnabled(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        if (this.f249568b == false) goto L5;
        this.f249567a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f249568b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (this.f249568b == false) goto L5;
        this.f249567a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f249568b = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        if (this.f249568b == false) goto L5;
        this.f249567a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f249568b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (this.f249568b == false) goto L5;
        this.f249567a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f249568b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (r101 != this.f249570d) goto L6;
        return;
    L6:
        if (this.f249575i == true) goto L8;
    L13:
        f(this.f249583q);
        Iterator<a> r104 = this.f249577k.iterator();
    L15:
        if (r104.hasNext() == false) goto L18;
        r104.next().onScrollChanged(r100, r101, r102, r103);
    L18:
        if (this.f249570d == getScrollY()) goto L23;
        this.f249570d = getScrollY();
        return;
    L23:
        return;
    L8:
        if (this.f249576j == true) goto L13;
        this.f249576j = true;
        f(1);
        Iterator<a> r105 = this.f249577k.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        r105.next().a();
        goto L11
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f249567a.setPadding(r100, r101, r102, r103);
    }
}
