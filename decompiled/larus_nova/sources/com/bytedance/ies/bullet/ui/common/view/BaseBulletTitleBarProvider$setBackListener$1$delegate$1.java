package com.bytedance.ies.bullet.ui.common.view;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider$setBackListener$1$delegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class BaseBulletTitleBarProvider$setBackListener$1$delegate$1 extends AccessibilityDelegateCompat {
    public BaseBulletTitleBarProvider$setBackListener$1$delegate$1() {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setClassName(Button.class.getName());
        r101.setContentDescription("返回");
    }
}
