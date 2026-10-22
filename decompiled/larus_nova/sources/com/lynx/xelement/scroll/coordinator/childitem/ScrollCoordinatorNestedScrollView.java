package com.lynx.xelement.scroll.coordinator.childitem;

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
import q8a.c;
import q8a.d;

/* JADX INFO: loaded from: classes32.dex */
public class ScrollCoordinatorNestedScrollView extends NestedScrollView implements IDrawChildHook.IDrawChildHookBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f384305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f384306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f384307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f384308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f384309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f384310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f384311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f384312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f384313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f384314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<a> f384315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IDrawChildHook f384316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f384317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f384318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f384319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f384320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f384321q;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onScrollChanged();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ScrollCoordinatorNestedScrollView> f384322a;

        public final void a() {
            if (this.f384322a.get() == null) goto L18;
            ScrollCoordinatorNestedScrollView r100 = this.f384322a.get();
            int r101 = r100.getScrollY();
            int r102 = r100.f384307c.getScrollX();
            boolean r103 = r100.f384310f;
            if (r103 == true) goto L7;
        L8:
            if (r103 == false) goto L10;
        L15:
            r100.f384318n = r101;
            r100.f384319o = r102;
            r100.postDelayed(this, r100.f384320p);
            return;
        L10:
            if ((r100.f384318n - r101) != 0) goto L15;
        L11:
            r100.f(0);
            Iterator<a> r104 = r100.f384315k.iterator();
        L13:
            if (r104.hasNext() == false) goto L19;
            r104.next().b();
            goto L13
        L19:
            return;
        L7:
            if ((r100.f384319o - r102) == 0) goto L11;
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

        public b(ScrollCoordinatorNestedScrollView r100) {
            this.f384322a = new WeakReference(r100);
        }
    }

    public final void finalize() throws Throwable {
        removeCallbacks(this.f384317m);
        super.finalize();
    }

    public int getOrientation() {
        return this.f384305a.getOrientation();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f384306b == false) goto L5;
        this.f384305a.removeAllViews();
        return;
    L5:
        super.removeAllViews();
        this.f384306b = true;
    }

    public int getContentHeight() {
        return this.f384312h;
    }

    public int getContentWidth() {
        return this.f384311g;
    }

    public HorizontalScrollView getHScrollView() {
        return this.f384307c;
    }

    public LinearLayout getLinearLayout() {
        return this.f384305a;
    }

    public ScrollCoordinatorNestedScrollView(Context r100) {
        super(r100);
        this.f384306b = false;
        this.f384310f = false;
        this.f384311g = 0;
        this.f384312h = 0;
        this.f384313i = false;
        this.f384314j = false;
        this.f384318n = 0;
        this.f384319o = 0;
        this.f384320p = 300;
        this.f384321q = 0;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.f384315k = new ArrayList();
        if (this.f384305a != null) goto L5;
        c r101 = new c(this, getContext());
        this.f384305a = r101;
        r101.setOrientation(1);
        this.f384305a.setWillNotDraw(true);
        d r102 = new d(this, getContext());
        this.f384307c = r102;
        r102.setHorizontalScrollBarEnabled(false);
        this.f384307c.setOverScrollMode(2);
        this.f384307c.setFadingEdgeLength(0);
        this.f384307c.setWillNotDraw(true);
        this.f384307c.addView(this.f384305a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f384307c, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f384317m = new b(this);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f384306b == false) goto L5;
        this.f384305a.addView(r100);
        return;
    L5:
        super.addView(r100);
        this.f384306b = true;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f384316l = r100;
    }

    public final void e(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.f384313i = true;
        return;
    L6:
        if (r100.getAction() == 1) goto L8;
        return;
    L8:
        if (this.f384314j == false) goto L13;
        f(2);
        Iterator<a> r101 = this.f384315k.iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        r101.next().d();
    L13:
        this.f384314j = false;
        this.f384313i = false;
    }

    public final void f(int r100) {
        this.f384321q = r100;
        Iterator<a> r101 = this.f384315k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c();
        goto L4
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f384310f == false) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f384310f == true) goto L12;
        e(r100);
        if (r100.getAction() != 0) goto L8;
        f(this.f384321q);
    L8:
        if (r100.getAction() != 1) goto L11;
        this.f384318n = getScrollY();
        this.f384319o = this.f384307c.getScrollX();
        postDelayed(this.f384317m, this.f384320p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f384306b == false) goto L5;
        this.f384305a.removeView(r100);
        return;
    L5:
        super.removeView(r100);
        this.f384306b = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        if (this.f384306b == false) goto L5;
        this.f384305a.removeViewAt(r100);
        return;
    L5:
        super.removeViewAt(r100);
        this.f384306b = true;
    }

    public void setOnScrollListener(a r100) {
        this.f384315k.add(r100);
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L5;
        this.f384305a.setOrientation(0);
        this.f384310f = true;
        return;
    L5:
        if (r100 != 1) goto L9;
        this.f384305a.setOrientation(1);
        this.f384310f = false;
        return;
    }

    public void setScrollBarEnable(boolean r100) {
        setVerticalScrollBarEnabled(r100);
        this.f384307c.setHorizontalScrollBarEnabled(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        if (this.f384306b == false) goto L5;
        this.f384305a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f384306b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (this.f384306b == false) goto L5;
        this.f384305a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f384306b = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        if (this.f384306b == false) goto L5;
        this.f384305a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f384306b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (this.f384306b == false) goto L5;
        this.f384305a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f384306b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (r101 != this.f384308d) goto L6;
        return;
    L6:
        if (this.f384313i == true) goto L8;
    L13:
        f(this.f384321q);
        Iterator<a> r104 = this.f384315k.iterator();
    L15:
        if (r104.hasNext() == false) goto L18;
        r104.next().onScrollChanged();
    L18:
        if (this.f384308d == getScrollY()) goto L23;
        this.f384308d = getScrollY();
        return;
    L23:
        return;
    L8:
        if (this.f384314j == true) goto L13;
        this.f384314j = true;
        f(1);
        Iterator<a> r105 = this.f384315k.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        r105.next().a();
        goto L11
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f384305a.setPadding(r100, r101, r102, r103);
    }
}
