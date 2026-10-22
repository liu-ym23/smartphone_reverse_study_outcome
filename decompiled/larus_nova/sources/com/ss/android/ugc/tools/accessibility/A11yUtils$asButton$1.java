package com.ss.android.ugc.tools.accessibility;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/tools/accessibility/A11yUtils$asButton$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class A11yUtils$asButton$1 extends AccessibilityDelegateCompat {
    public A11yUtils$asButton$1() {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        if (r101 == null) goto L6;
        r101.setClassName(Button.class.getName());
        return;
    }
}
