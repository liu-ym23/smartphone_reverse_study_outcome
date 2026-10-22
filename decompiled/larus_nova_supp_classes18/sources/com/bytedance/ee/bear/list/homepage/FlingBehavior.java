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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FlingBehavior extends AppBarLayout.Behavior {
    public boolean a;
    public boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile Field e;
    public volatile Field f;

    public final synchronized Field getFlingRunnableField() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L25;
        Field r0 = this.e;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L25:
        Class<? super Object> r1 = getClass().getSuperclass().getSuperclass().getSuperclass();     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        this.e = r1.getDeclaredField("flingRunnable");     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (this.e == null) goto L24;
        this.e.setAccessible(true);     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L24:
    L18:
        this.c = true;     // Catch: Throwable -> L21
        Field r2 = this.e;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L14:
        this.e = null;     // Catch: NoSuchFieldException -> L16 Throwable -> L21
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
        if (this.d == false) goto L25;
        Field r0 = this.f;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L25:
        Class<? super Object> r1 = getClass().getSuperclass().getSuperclass().getSuperclass();     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        this.f = r1.getDeclaredField("scroller");     // Catch: NoSuchFieldException -> L16 Throwable -> L21
        if (this.f == null) goto L24;
        this.f.setAccessible(true);     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L24:
    L18:
        this.d = true;     // Catch: Throwable -> L21
        Field r2 = this.f;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L14:
        this.f = null;     // Catch: NoSuchFieldException -> L16 Throwable -> L21
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    }

    public FlingBehavior() {
        this.c = false;
        this.d = false;
        CoreThreadPool.getDefault().getCachedThreadPool().submit(new b(this));
    }

    public final void stopAppbarLayoutFling(AppBarLayout r5) {
        Field r0 = getFlingRunnableField();     // Catch: IllegalAccessException -> L13
        if (r0 == null) goto L7;
        Runnable r1 = (Runnable) r0.get(this);     // Catch: IllegalAccessException -> L13
        if (r1 == null) goto L7;
        a.b("AppbarLayoutBehavior", "there is a flingRunnable");     // Catch: IllegalAccessException -> L13
        r5.removeCallbacks(r1);     // Catch: IllegalAccessException -> L13
        r0.set(this, null);     // Catch: IllegalAccessException -> L13
    L7:
        OverScroller r6 = (OverScroller) getScrollerField().get(this);     // Catch: IllegalAccessException -> L13
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.isFinished() == true) goto L19;
        r6.abortAnimation();     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public FlingBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = false;
        this.d = false;
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r2, View r3, MotionEvent r4) {
        AppBarLayout r5 = (AppBarLayout) r3;
        this.b = this.a;
        if (r4.getActionMasked() != 0) goto L6;
        stopAppbarLayoutFling(r5);
    L6:
        return super/*com.google.android.material.appbar.AppBarLayout.BaseBehavior*/.onInterceptTouchEvent(r2, r5, r4);
    }

    public final boolean onTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        return super/*com.google.android.material.appbar.AppBarLayout.BaseBehavior*/.onTouchEvent(r1, (AppBarLayout) r2, r3);
    L5:
        e = move-exception;
        a.d("AppbarLayoutBehavior", "onTouchEvent()...error = " + e);
        return false;
    }

    public final void onStopNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4) {
        super.onStopNestedScroll(r1, r2, r3, r4);
        this.a = false;
        this.b = false;
    }

    public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
        onStopNestedScroll(r1, (AppBarLayout) r2, r3, r4);
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, View r4, int r5, int r6) {
        stopAppbarLayoutFling(r2);
        return super.onStartNestedScroll(r1, r2, r3, r4, r5, r6);
    }

    public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        return onStartNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6);
    }

    public final void onNestedPreScroll(CoordinatorLayout r2, AppBarLayout r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L6;
        this.a = true;
    L6:
        if (this.b == true) goto L9;
        super.onNestedPreScroll(r2, r3, r4, r5, r6, r7, r8);
        return;
    }

    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        onNestedPreScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7);
    }

    public final void onNestedScroll(CoordinatorLayout r2, AppBarLayout r3, View r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.b == true) goto L6;
        super/*com.google.android.material.appbar.AppBarLayout.BaseBehavior*/.onNestedScroll(r2, r3, r4, r5, r6, r7, r8, r9);
        return;
    }

    public final /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
        onNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7, r8);
    }
}
