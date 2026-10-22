package com.ss.android.ugc.aweme.search.utils;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/utils/AccessibilityUtil$setAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class AccessibilityUtil$setAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
    }
}
