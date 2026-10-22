package com.bytedance.dux.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/dux/banner/DuxBanner$initViewPager2$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBanner$initViewPager2$2 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r102.getEventType() != 4096) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        int r104 = DuxBanner.f204858u;
        throw null;
    L8:
        return super.onRequestSendAccessibilityEvent(r100, r101, r102);
    L5:
        r103 = false;
        goto L6
    }
}
