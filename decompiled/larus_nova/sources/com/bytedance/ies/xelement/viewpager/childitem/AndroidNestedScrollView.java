package com.bytedance.ies.xelement.viewpager.childitem;

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
    public s86.a f250501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s86.b f250503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f250504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f250507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f250508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f250509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f250510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<a> f250511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IDrawChildHook f250512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f250513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f250514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f250515o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f250516p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f250517q;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onScrollChanged();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AndroidNestedScrollView> f250518a;

        public final void a() {
            if (this.f250518a.get() == null) goto L18;
            AndroidNestedScrollView r100 = this.f250518a.get();
            int r101 = r100.getScrollY();
            int r102 = r100.f250503c.getScrollX();
            boolean r103 = r100.f250506f;
            if (r103 == true) goto L7;
        L8:
            if (r103 == false) goto L10;
        L15:
            r100.f250514n = r101;
            r100.f250515o = r102;
            r100.postDelayed(this, r100.f250516p);
            return;
        L10:
            if ((r100.f250514n - r101) != 0) goto L15;
        L11:
            r100.f(0);
            Iterator<a> r104 = r100.f250511k.iterator();
        L13:
            if (r104.hasNext() == false) goto L19;
            r104.next().b();
            goto L13
        L19:
            return;
        L7:
            if ((r100.f250515o - r102) == 0) goto L11;
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
            this.f250518a = new WeakReference(r100);
        }
    }

    public final void finalize() throws Throwable {
        removeCallbacks(this.f250513m);
        super.finalize();
    }

    public int getOrientation() {
        return this.f250501a.getOrientation();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f250502b == false) goto L5;
        this.f250501a.removeAllViews();
        return;
    L5:
        super.removeAllViews();
        this.f250502b = true;
    }

    public int getContentHeight() {
        return this.f250508h;
    }

    public int getContentWidth() {
        return this.f250507g;
    }

    public HorizontalScrollView getHScrollView() {
        return this.f250503c;
    }

    public LinearLayout getLinearLayout() {
        return this.f250501a;
    }

    public AndroidNestedScrollView(Context r100) {
        super(r100);
        this.f250502b = false;
        this.f250506f = false;
        this.f250507g = 0;
        this.f250508h = 0;
        this.f250509i = false;
        this.f250510j = false;
        this.f250514n = 0;
        this.f250515o = 0;
        this.f250516p = 300;
        this.f250517q = 0;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.f250511k = new ArrayList();
        if (this.f250501a != null) goto L5;
        s86.a r101 = new s86.a(this, getContext());
        this.f250501a = r101;
        r101.setOrientation(1);
        this.f250501a.setWillNotDraw(true);
        s86.b r102 = new s86.b(this, getContext());
        this.f250503c = r102;
        r102.setHorizontalScrollBarEnabled(false);
        this.f250503c.setOverScrollMode(2);
        this.f250503c.setFadingEdgeLength(0);
        this.f250503c.setWillNotDraw(true);
        this.f250503c.addView(this.f250501a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f250503c, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f250513m = new b(this);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f250502b == false) goto L5;
        this.f250501a.addView(r100);
        return;
    L5:
        super.addView(r100);
        this.f250502b = true;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f250512l = r100;
    }

    public final void e(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.f250509i = true;
        return;
    L6:
        if (r100.getAction() == 1) goto L8;
        return;
    L8:
        if (this.f250510j == false) goto L13;
        f(2);
        Iterator<a> r101 = this.f250511k.iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        r101.next().d();
    L13:
        this.f250510j = false;
        this.f250509i = false;
    }

    public final void f(int r100) {
        this.f250517q = r100;
        Iterator<a> r101 = this.f250511k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c();
        goto L4
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f250506f == false) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f250506f == true) goto L12;
        e(r100);
        if (r100.getAction() != 0) goto L8;
        f(this.f250517q);
    L8:
        if (r100.getAction() != 1) goto L11;
        this.f250514n = getScrollY();
        this.f250515o = this.f250503c.getScrollX();
        postDelayed(this.f250513m, this.f250516p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f250502b == false) goto L5;
        this.f250501a.removeView(r100);
        return;
    L5:
        super.removeView(r100);
        this.f250502b = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        if (this.f250502b == false) goto L5;
        this.f250501a.removeViewAt(r100);
        return;
    L5:
        super.removeViewAt(r100);
        this.f250502b = true;
    }

    public void setOnScrollListener(a r100) {
        this.f250511k.add(r100);
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L5;
        this.f250501a.setOrientation(0);
        this.f250506f = true;
        return;
    L5:
        if (r100 != 1) goto L9;
        this.f250501a.setOrientation(1);
        this.f250506f = false;
        return;
    }

    public void setScrollBarEnable(boolean r100) {
        setVerticalScrollBarEnabled(r100);
        this.f250503c.setHorizontalScrollBarEnabled(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        if (this.f250502b == false) goto L5;
        this.f250501a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f250502b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (this.f250502b == false) goto L5;
        this.f250501a.addView(r100, r101);
        return;
    L5:
        super.addView(r100, r101);
        this.f250502b = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        if (this.f250502b == false) goto L5;
        this.f250501a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f250502b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (this.f250502b == false) goto L5;
        this.f250501a.addView(r100, r101, r102);
        return;
    L5:
        super.addView(r100, r101, r102);
        this.f250502b = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (r101 != this.f250504d) goto L6;
        return;
    L6:
        if (this.f250509i == true) goto L8;
    L13:
        f(this.f250517q);
        Iterator<a> r104 = this.f250511k.iterator();
    L15:
        if (r104.hasNext() == false) goto L18;
        r104.next().onScrollChanged();
    L18:
        if (this.f250504d == getScrollY()) goto L23;
        this.f250504d = getScrollY();
        return;
    L23:
        return;
    L8:
        if (this.f250510j == true) goto L13;
        this.f250510j = true;
        f(1);
        Iterator<a> r105 = this.f250511k.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        r105.next().a();
        goto L11
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f250501a.setPadding(r100, r101, r102, r103);
    }
}
