package com.bytedance.dux.utils;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/dux/utils/DuxAccessibilityUtil$setButtonAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxAccessibilityUtil$setButtonAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setClassName(Button.class.getName());
        if ((!StringsKt.isBlank(null)) == false) goto L6;
        r101.setContentDescription(null);
        return;
    }
}
