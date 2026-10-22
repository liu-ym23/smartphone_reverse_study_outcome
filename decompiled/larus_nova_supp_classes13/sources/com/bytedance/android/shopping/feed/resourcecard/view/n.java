package com.bytedance.android.shopping.feed.resourcecard.view;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements ICachedAsyncInflater.b {
    public n() {
    }

    public final View a(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        return new WindowNodeView(r5, null, 6, 0);
    }
}
