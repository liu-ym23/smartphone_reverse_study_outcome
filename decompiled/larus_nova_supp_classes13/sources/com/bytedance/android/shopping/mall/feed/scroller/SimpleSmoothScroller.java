package com.bytedance.android.shopping.mall.feed.scroller;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.bytedance.common.utility.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/scroller/SimpleSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleSmoothScroller extends LinearSmoothScroller {
    public static final Lazy a = null;

    public static final class a {
    }

    public final int getVerticalSnapPreference() {
        return -1;
    }

    static {
        a = LazyKt.lazy(SimpleSmoothScroller$Companion$customMillisecondsPerInch$2.INSTANCE);
    }

    public final void onStop() {
        super.onStop();
        Logger.d("EaseInOutSmoothScroller", "onStop");
    }

    public SimpleSmoothScroller(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final float calculateSpeedPerPixel(DisplayMetrics r2) {
        Intrinsics.checkNotNullParameter(r2, "displayMetrics");
        return ((Number) a.getValue()).floatValue() / r2.densityDpi;
    }
}
