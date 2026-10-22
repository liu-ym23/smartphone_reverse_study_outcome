package com.bytedance.ee.bear.list.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/KeepWithinParentBoundsScrollingBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "<init>", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "Landroid/view/View;", "dependency", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeepWithinParentBoundsScrollingBehavior extends AppBarLayout.ScrollingViewBehavior {
    public KeepWithinParentBoundsScrollingBehavior() {
    }

    public KeepWithinParentBoundsScrollingBehavior(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    public final boolean layoutDependsOn(CoordinatorLayout r4, View r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        if ((r6 instanceof AppBarLayout) == false) goto L5;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r1).height = r4.getHeight() - ((AppBarLayout) r6).getBottom();
        r5.setLayoutParams(r1);
        return super.layoutDependsOn(r4, r5, r6);
    L5:
        return super.onDependentViewChanged(r4, r5, r6);
    }
}
