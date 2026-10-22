package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes34.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f403517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f403518b;

    public ViewOffsetBehavior() {
        this.f403518b = 0;
    }

    public ViewOffsetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f403518b = 0;
    }

    public void layoutChild(CoordinatorLayout r100, V r101, int r102) {
        r100.onLayoutChild(r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        layoutChild(r100, r101, r102);
        if (this.f403517a != null) goto L5;
        this.f403517a = new d(r101);
    L5:
        d r103 = this.f403517a;
        r103.f403530b = r103.f403529a.getTop();
        r103.f403531c = r103.f403529a.getLeft();
        this.f403517a.a();
        int r104 = this.f403518b;
        if (r104 == 0) goto L13;
        d r105 = this.f403517a;
        if (r105.f403532d == r104) goto L10;
        r105.f403532d = r104;
        r105.a();
    L10:
        this.f403518b = 0;
        return true;
    L13:
        return true;
    }
}
