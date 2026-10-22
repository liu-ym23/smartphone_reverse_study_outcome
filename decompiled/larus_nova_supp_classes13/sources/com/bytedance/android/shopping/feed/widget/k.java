package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements ICachedAsyncInflater.b {
    public k() {
    }

    public final View a(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        return new InFlowPriceViewV2(r5, null, 6, 0);
    }
}
