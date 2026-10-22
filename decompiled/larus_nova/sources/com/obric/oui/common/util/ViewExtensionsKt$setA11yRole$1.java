package com.obric.oui.common.util;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/common/util/ViewExtensionsKt$setA11yRole$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ViewExtensionsKt$setA11yRole$1 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        if (r101 == null) goto L7;
        r101.setRoleDescription(null);
        return;
    }
}
