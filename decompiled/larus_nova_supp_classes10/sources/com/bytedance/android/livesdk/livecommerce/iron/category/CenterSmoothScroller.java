package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CenterSmoothScroller extends LinearSmoothScroller {

    public static final class a {
    }

    static {
    }

    public final int calculateTimeForScrolling(int r1) {
        return 200;
    }

    public CenterSmoothScroller(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
        return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
    }
}
