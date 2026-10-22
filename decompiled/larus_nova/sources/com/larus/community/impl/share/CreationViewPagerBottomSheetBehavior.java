package com.larus.community.impl.share;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/share/CreationViewPagerBottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "startX", "", "startY", "isHorizontalSwipe", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "onLayoutChild", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "layoutDirection", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "isTouchInsideViewPager", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationViewPagerBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f329792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f329793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f329794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager2 f329795d;

    public CreationViewPagerBottomSheetBehavior() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, "event");
        int r100 = r112.getAction();
        if (r100 != 0) goto L5;
        this.f329792a = r112.getX();
        this.f329793b = r112.getY();
        this.f329794c = false;
    L35:
        return super.onInterceptTouchEvent(r110, r111, r112);
    L5:
        if (r100 != 1) goto L7;
    L32:
        this.f329794c = false;
        goto L35
    L7:
        if (r100 != 2) goto L9;
        float r101 = Math.abs(r112.getX() - this.f329792a);
        float r102 = Math.abs(r112.getY() - this.f329793b);
        ViewPager2 r103 = this.f329795d;
        if (r103 == null) goto L22;
        int[] r104 = new int[2];
        r103.getLocationOnScreen(r104);
        int r105 = r104[0];
        int r106 = r104[1];
        if (r112.getRawX() < r105) goto L22;
        if (r112.getRawX() > (r105 + r103.getWidth())) goto L22;
        if (r112.getRawY() < r106) goto L22;
        if (r112.getRawY() > (r106 + r103.getHeight())) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L35;
        if (r102 > r101) goto L27;
    L30:
        this.f329794c = true;
        return super.onInterceptTouchEvent(r110, r111, r112);
    L27:
        if (r102 <= 1.0f) goto L30;
        this.f329794c = false;
        return true;
    L22:
        r107 = false;
        goto L23
    L9:
        if (r100 == 3) goto L32;
        goto L32
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        boolean r103 = super.onLayoutChild(r100, r101, r102);
        this.f329795d = (ViewPager2) r101.findViewById(R.id.view_pager);
        return r103;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.f329794c == false) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100, r101, r102);
    }
}
