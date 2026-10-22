package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes19.dex */
@CoordinatorLayout.DefaultBehavior(b.class)
public class CustomAppBarLayoutNG extends BaseCustomAppBarLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f250432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f250433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f250434e;

    public interface a {
        void a();

        void b();

        void onFling();
    }

    public class b extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f250435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f250436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Field f250437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CustomAppBarLayoutNG f250438d;

        public final Field getFlingRunnableField() throws NoSuchFieldException {
            Field r100 = this.f250437c;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Class r101 = b.class.getSuperclass();
            if (r101 != null) goto L19;
            Class r102 = null;
        L11:
            if (r102 == null) goto L18;
            Field r103 = r102.getDeclaredField("mFlingRunnable");     // Catch: NoSuchFieldException -> L8
            this.f250437c = r103;     // Catch: NoSuchFieldException -> L8
            return r103;
        L8:
            e = move-exception;
            e.printStackTrace();
            Class r104 = r101.getSuperclass().getSuperclass();
            if (r104 == null) goto L18;
            Field r105 = r104.getDeclaredField("flingRunnable");
            this.f250437c = r105;
            return r105;
        L18:
            return null;
        L19:
            r102 = r101.getSuperclass();     // Catch: NoSuchFieldException -> L8
            goto L11
        }

        public b(CustomAppBarLayoutNG r100) {
            this.f250438d = r100;
            setDragCallback(new com.bytedance.ies.xelement.viewpager.b());
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
            this.f250436b = this.f250435a;
            if (r102.getAction() != 0) goto L13;
            if (r103 != null) goto L7;
        L9:
            boolean r104 = true;
        L10:
            if (r104 == false) goto L13;
            stopAppbarLayoutFling(r103);
            goto L13
        L7:
            if ((r103 instanceof CustomAppBarLayoutNG) == false) goto L9;
            r104 = ((CustomAppBarLayoutNG) r103).f250433d;
        L13:
            return super.onInterceptTouchEvent(r100, r103, r102);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
            super.onStopNestedScroll(r100, r101, r102, r103);
            this.f250435a = false;
            this.f250436b = false;
            a r104 = this.f250438d.f250432c;
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
            a r103 = this.f250438d.f250432c;
            if (r103 == null) goto L6;
            r103.onFling();
        L6:
            return super.onNestedFling(r100, r102, r110, r111, r112, r113);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
            if (r101 != null) goto L4;
        L6:
            boolean r106 = true;
        L7:
            if (r106 == false) goto L9;
            stopAppbarLayoutFling(r101);
        L9:
            a r107 = this.f250438d.f250432c;
            if (r107 == null) goto L13;
            r107.a();
        L13:
            return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
        L4:
            if ((r101 instanceof CustomAppBarLayoutNG) == false) goto L6;
            r106 = ((CustomAppBarLayoutNG) r101).f250433d;
            goto L7
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
            return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
            boolean r107 = true;
            if (r106 != 1) goto L6;
            this.f250435a = true;
        L6:
            if (this.f250436b == true) goto L14;
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
            if (this.f250436b == true) goto L17;
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
        if (this.f250434e != null) goto L6;
        this.f250434e = new b(this);
    L6:
        return this.f250434e;
    }

    public int getTopAndBottomOffset() {
        b r100 = this.f250434e;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTopAndBottomOffset();
    }

    public CustomAppBarLayoutNG(Context r100) {
        super(r100);
        this.f250433d = true;
    }

    public void setEnableTouchStopFling(boolean r100) {
        this.f250433d = r100;
    }

    public void setScrollListener(a r100) {
        this.f250432c = r100;
    }

    public CustomAppBarLayoutNG(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f250433d = true;
    }
}
