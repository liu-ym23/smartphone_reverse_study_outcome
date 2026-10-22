package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes32.dex */
@CoordinatorLayout.DefaultBehavior(b.class)
public class ScrollCoordinatorAppBarLayout extends BaseScrollCoordinatorAppBarLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f384259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f384260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f384261d;

    public interface a {
        void a();

        void b();

        void onFling();
    }

    public class b extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f384262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f384263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Field f384264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ScrollCoordinatorAppBarLayout f384265d;

        public final Field getFlingRunnableField() throws NoSuchFieldException {
            Field r100 = this.f384264c;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Class r101 = b.class.getSuperclass();
            if (r101 != null) goto L19;
            Class r102 = null;
        L11:
            if (r102 == null) goto L18;
            Field r103 = r102.getDeclaredField("mFlingRunnable");     // Catch: NoSuchFieldException -> L8
            this.f384264c = r103;     // Catch: NoSuchFieldException -> L8
            return r103;
        L8:
            e = move-exception;
            e.printStackTrace();
            Class r104 = r101.getSuperclass().getSuperclass();
            if (r104 == null) goto L18;
            Field r105 = r104.getDeclaredField("flingRunnable");
            this.f384264c = r105;
            return r105;
        L18:
            return null;
        L19:
            r102 = r101.getSuperclass();     // Catch: NoSuchFieldException -> L8
            goto L11
        }

        public b(ScrollCoordinatorAppBarLayout r100) {
            this.f384265d = r100;
            setDragCallback(new d());
        }

        public final void a(AppBarLayout r100) {
            Field r101 = getFlingRunnableField();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r101 == null) goto L7;
            r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            Runnable r102 = (Runnable) r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            if (r102 == null) goto L7;
            r100.removeCallbacks(r102);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
            r101.set(this, null);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        L7:
            Class r103 = b.class.getSuperclass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
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

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            AppBarLayout r103 = (AppBarLayout) r101;
            this.f384263b = this.f384262a;
            if (r102.getAction() != 0) goto L11;
            if ((r103 instanceof ScrollCoordinatorAppBarLayout) == false) goto L7;
            boolean r104 = ((ScrollCoordinatorAppBarLayout) r103).f384260c;
        L8:
            if (r104 == false) goto L11;
            a(r103);
            goto L11
        L7:
            r104 = true;
        L11:
            return super.onInterceptTouchEvent(r100, r103, r102);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
            super.onStopNestedScroll(r100, r101, r102, r103);
            this.f384262a = false;
            this.f384263b = false;
            a r104 = this.f384265d.f384259b;
            if (r104 == null) goto L6;
            r104.b();
            return;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
            onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedFling(CoordinatorLayout r100, View r101, View r110, float r111, float r112, boolean r113) {
            AppBarLayout r102 = (AppBarLayout) r101;
            a r103 = this.f384265d.f384259b;
            if (r103 == null) goto L6;
            r103.onFling();
        L6:
            return super.onNestedFling(r100, r102, r110, r111, r112, r113);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
            if ((r101 instanceof ScrollCoordinatorAppBarLayout) == false) goto L5;
            boolean r106 = ((ScrollCoordinatorAppBarLayout) r101).f384260c;
        L6:
            if (r106 == false) goto L8;
            a(r101);
        L8:
            a r107 = this.f384265d.f384259b;
            if (r107 == null) goto L12;
            r107.a();
        L12:
            return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
        L5:
            r106 = true;
            goto L6
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
            return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
            boolean r107 = true;
            if (r106 != 1) goto L6;
            this.f384262a = true;
        L6:
            if (this.f384263b == false) goto L8;
            return;
        L8:
            if ((r101 instanceof BaseScrollCoordinatorAppBarLayout) == false) goto L10;
            r107 = ((BaseScrollCoordinatorAppBarLayout) r101).f384247a;
        L10:
            if (r107 == false) goto L14;
            super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
            return;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            if (this.f384263b == true) goto L16;
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L5:
            if ((r101 instanceof BaseScrollCoordinatorAppBarLayout) == false) goto L7;
            boolean r108 = ((BaseScrollCoordinatorAppBarLayout) r101).f384247a;     // Catch: Throwable -> L11
        L8:
            if (r108 == false) goto L17;
            super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);     // Catch: Throwable -> L11
            return;
        L17:
            return;
        L7:
            r108 = true;
            goto L8
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior getBehavior() {
        if (this.f384261d != null) goto L6;
        this.f384261d = new b(this);
    L6:
        return this.f384261d;
    }

    public int getTopAndBottomOffset() {
        b r100 = this.f384261d;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTopAndBottomOffset();
    }

    public ScrollCoordinatorAppBarLayout(Context r100) {
        super(r100);
        this.f384260c = true;
    }

    public void setScrollListener(a r100) {
        this.f384259b = r100;
    }

    public void setTouchStopFlingEnabled(boolean r100) {
        this.f384260c = r100;
    }

    public ScrollCoordinatorAppBarLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f384260c = true;
    }
}
