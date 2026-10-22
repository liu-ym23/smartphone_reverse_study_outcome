package com.bytedance.ee.bear.list.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.list.homepage.title.b;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeCoordinatorLayout extends CoordinatorLayout {
    public b a;

    public HomeCoordinatorLayout(Context r1) {
        super(r1);
    }

    public void setMainTitle(b r1) {
        this.a = r1;
    }

    public HomeCoordinatorLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public HomeCoordinatorLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return super.onNestedPreFling(r1, r2, r3);
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        super.onNestedPreScroll(r1, r2, r3, r4, r5);
        a.h("HomeCoordinatorLayout", "onNestedPreScroll()...dy = " + r3);
        b r6 = this.a;
        if (r6 == null) goto L6;
        r6.a(r3);
        return;
    }
}
