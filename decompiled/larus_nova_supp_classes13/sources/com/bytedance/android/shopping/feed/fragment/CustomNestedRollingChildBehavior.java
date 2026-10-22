package com.bytedance.android.shopping.feed.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/fragment/CustomNestedRollingChildBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomNestedRollingChildBehavior extends BottomSheetBehavior<View> {
    public CustomNestedRollingChildBehavior() {
        this(null, null);
    }

    public CustomNestedRollingChildBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        BottomSheetBehavior.class.getDeclaredField("nestedScrollingChildRef").setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        EnsureManager.ensureNotReachHere();
    }

    public final boolean onLayoutChild(CoordinatorLayout r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        return super.onLayoutChild(r2, r3, r4);
    }
}
