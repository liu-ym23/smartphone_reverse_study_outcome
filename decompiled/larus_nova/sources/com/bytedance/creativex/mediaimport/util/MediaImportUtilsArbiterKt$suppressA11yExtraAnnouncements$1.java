package com.bytedance.creativex.mediaimport.util;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/creativex/mediaimport/util/MediaImportUtilsArbiterKt$suppressA11yExtraAnnouncements$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaImportUtilsArbiterKt$suppressA11yExtraAnnouncements$1 extends AccessibilityDelegateCompat {
    public MediaImportUtilsArbiterKt$suppressA11yExtraAnnouncements$1() {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setClassName(View.class.getName());
    }
}
