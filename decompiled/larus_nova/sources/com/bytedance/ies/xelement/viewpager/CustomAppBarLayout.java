package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes19.dex */
@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class CustomAppBarLayout extends BaseCustomAppBarLayout {

    public static class Behavior extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f250430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f250431b;

        public Behavior() {
            setDragCallback(new a(this));
        }

        public final Field getFlingRunnableField() throws NoSuchFieldException {
            Class<? super Object> r100 = getClass().getSuperclass();
            if (r100 != null) goto L16;
            Class<? super Object> r101 = null;
        L8:
            if (r101 == null) goto L15;
            return r101.getDeclaredField("mFlingRunnable");
        L5:
            e = move-exception;
            e.printStackTrace();
            Class<? super Object> r102 = r100.getSuperclass().getSuperclass();
            if (r102 == null) goto L15;
            return r102.getDeclaredField("flingRunnable");
        L15:
            return null;
        L16:
            r101 = r100.getSuperclass();     // Catch: NoSuchFieldException -> L5
            goto L8
        }

        public final void stopAppbarLayoutFling(AppBarLayout r100) {
            Field r101 = getFlingRunnableField();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r101 == null) goto L7;
            r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            Runnable r102 = (Runnable) r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r102 == null) goto L7;
            r100.removeCallbacks(r102);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            r101.set(this, null);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        L7:
            Class<? super Object> r103 = getClass().getSuperclass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r103 == null) goto L18;
            r103.getSuperclass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        L20:
            return;
        L18:
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
        }

        public Behavior(Context r100, AttributeSet r101) {
            super(r100, r101);
            setDragCallback(new a(this));
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            AppBarLayout r103 = (AppBarLayout) r101;
            this.f250431b = this.f250430a;
            if (r102.getActionMasked() != 0) goto L7;
            stopAppbarLayoutFling(r103);
        L7:
            if (r103 != null) goto L9;
        L11:
            boolean r104 = true;
        L12:
            if (r104 == true) goto L15;
            return true;
        L15:
            return super.onInterceptTouchEvent(r100, r103, r102);
        L9:
            if ((r103 instanceof BaseCustomAppBarLayout) == false) goto L11;
            r104 = ((BaseCustomAppBarLayout) r103).f250429b;
            goto L12
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
            super.onStopNestedScroll(r100, r101, r102, r103);
            this.f250430a = false;
            this.f250431b = false;
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
            boolean r107 = true;
            if (r106 != 1) goto L6;
            this.f250430a = true;
        L6:
            if (this.f250431b == true) goto L14;
            if (r101 != null) goto L9;
        L11:
            if (r107 == false) goto L15;
            super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
            return;
        L15:
            return;
        L9:
            if ((r101 instanceof BaseCustomAppBarLayout) == false) goto L11;
            r107 = ((BaseCustomAppBarLayout) r101).f250429b;
            goto L11
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            if (this.f250431b == true) goto L17;
            if (r101 != null) goto L15;
        L8:
            boolean r108 = true;
        L9:
            if (r108 == false) goto L18;
            super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
            return;
        L18:
            return;
        L15:
            if ((r101 instanceof BaseCustomAppBarLayout) == false) goto L8;
            r108 = ((BaseCustomAppBarLayout) r101).f250429b;     // Catch: Throwable -> L12
            goto L9
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior getBehavior() {
        return new Behavior();
    }

    public CustomAppBarLayout(Context r100) {
        super(r100);
    }

    public CustomAppBarLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
