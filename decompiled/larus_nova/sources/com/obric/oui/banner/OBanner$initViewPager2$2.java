package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/banner/OBanner$initViewPager2$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBanner$initViewPager2$2 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        int r104 = OBanner.A;
        throw null;
    L10:
        return super.onRequestSendAccessibilityEvent(r100, r101, r102);
    L5:
        if (r102.getEventType() != 4096) goto L7;
        r103 = true;
        goto L8
    }
}
