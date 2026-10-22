package com.bytedance.android.shopping.deepfeed.slice.action;

import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import com.bytedance.android.shopping.deepfeed.slice.action.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class c<T extends x> extends a {
    public T c;
    public final T d;

    public c(T r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.d = r2;
        this.c = r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void c(DeepFeedSlcCardContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (r2 == null) goto L6;
        this.c = r2;
        return;
    }
}
