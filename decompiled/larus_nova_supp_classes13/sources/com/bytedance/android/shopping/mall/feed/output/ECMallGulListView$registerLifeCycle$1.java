package com.bytedance.android.shopping.mall.feed.output;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/mall/feed/output/ECMallGulListView$registerLifeCycle$1", "Landroidx/lifecycle/LifecycleEventObserver;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallGulListView$registerLifeCycle$1 implements LifecycleEventObserver {
    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        int r5 = ECMallGulListView.b;
        throw null;
    L5:
        if (r4 != 2) goto L7;
        int r6 = ECMallGulListView.b;
        throw null;
    L7:
        if (r4 == 3) goto L9;
        return;
    L9:
        throw null;
    }
}
