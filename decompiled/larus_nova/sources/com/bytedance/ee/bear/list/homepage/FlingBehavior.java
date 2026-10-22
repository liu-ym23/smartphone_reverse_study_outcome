package com.bytedance.ee.bear.list.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larksuite.framework.thread.CoreThreadPool;
import java.lang.reflect.Field;
import tt5.a;
import wc5.b;

/* JADX INFO: loaded from: classes18.dex */
public class FlingBehavior extends AppBarLayout.Behavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f228238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f228239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f228240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f228241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Field f228242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Field f228243f;

    public final synchronized Field getFlingRunnableField() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f228240c == false) goto L25;
        Field r100 = this.f228242e;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r100;
    L25:
        Class<? super Object> r101 = getClass().getSuperclass().getSuperclass().getSuperclass();     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (r101 == null) goto L14;
        this.f228242e = r101.getDeclaredField("flingRunnable");     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (this.f228242e == null) goto L24;
        this.f228242e.setAccessible(true);     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L24:
    L18:
        this.f228240c = true;     // Catch: Throwable -> L21
        Field r102 = this.f228242e;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r102;
    L14:
        this.f228242e = null;     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    }

    public final synchronized Field getScrollerField() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f228241d == false) goto L25;
        Field r100 = this.f228243f;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r100;
    L25:
        Class<? super Object> r101 = getClass().getSuperclass().getSuperclass().getSuperclass();     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (r101 == null) goto L14;
        this.f228243f = r101.getDeclaredField("scroller");     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (this.f228243f == null) goto L24;
        this.f228243f.setAccessible(true);     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L24:
    L18:
        this.f228241d = true;     // Catch: Throwable -> L21
        Field r102 = this.f228243f;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r102;
    L14:
        this.f228243f = null;     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    }

    public FlingBehavior() {
        this.f228240c = false;
        this.f228241d = false;
        CoreThreadPool.getDefault().getCachedThreadPool().submit(new b(this));
    }

    public final void stopAppbarLayoutFling(AppBarLayout r100) {
        Field r101 = getFlingRunnableField();     // Catch: IllegalAccessException -> L13
        if (r101 == null) goto L7;
        Runnable r102 = (Runnable) r101.get(this);     // Catch: IllegalAccessException -> L13
        if (r102 == null) goto L7;
        a.b("AppbarLayoutBehavior", "there is a flingRunnable");     // Catch: IllegalAccessException -> L13
        r100.removeCallbacks(r102);     // Catch: IllegalAccessException -> L13
        r101.set(this, null);     // Catch: IllegalAccessException -> L13
    L7:
        OverScroller r103 = (OverScroller) getScrollerField().get(this);     // Catch: IllegalAccessException -> L13
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.isFinished() == true) goto L19;
        r103.abortAnimation();     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public FlingBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f228240c = false;
        this.f228241d = false;
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        AppBarLayout r103 = (AppBarLayout) r101;
        this.f228239b = this.f228238a;
        if (r102.getActionMasked() != 0) goto L6;
        stopAppbarLayoutFling(r103);
    L6:
        return super.onInterceptTouchEvent(r100, r103, r102);
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        return super.onTouchEvent(r100, (AppBarLayout) r101, r102);
    L5:
        e = move-exception;
        a.d("AppbarLayoutBehavior", "onTouchEvent()...error = " + e);
        return false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
        super.onStopNestedScroll(r100, r101, r102, r103);
        this.f228238a = false;
        this.f228239b = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
        stopAppbarLayoutFling(r101);
        return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 != 1) goto L6;
        this.f228238a = true;
    L6:
        if (this.f228239b == true) goto L9;
        super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
        return;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        if (this.f228239b == true) goto L6;
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
    }
}
