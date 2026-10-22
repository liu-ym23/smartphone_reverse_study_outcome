package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements ICachedAsyncInflater.b {
    public o() {
    }

    public final View a(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        return new MainProductCardDetailView(r5, null, 6, 0);
    }
}
