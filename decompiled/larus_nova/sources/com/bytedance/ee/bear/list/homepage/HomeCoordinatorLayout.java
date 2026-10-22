package com.bytedance.ee.bear.list.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.list.homepage.title.b;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class HomeCoordinatorLayout extends CoordinatorLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f228244a;

    public HomeCoordinatorLayout(Context r100) {
        super(r100);
    }

    public void setMainTitle(b r100) {
        this.f228244a = r100;
    }

    public HomeCoordinatorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public HomeCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return super.onNestedPreFling(r100, r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        super.onNestedPreScroll(r100, r101, r102, r103, r104);
        a.h("HomeCoordinatorLayout", "onNestedPreScroll()...dy = " + r102);
        b r105 = this.f228244a;
        if (r105 == null) goto L6;
        r105.a(r102);
        return;
    }
}
