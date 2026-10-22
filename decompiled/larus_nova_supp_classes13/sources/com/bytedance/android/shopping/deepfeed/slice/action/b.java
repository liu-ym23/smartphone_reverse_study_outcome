package com.bytedance.android.shopping.deepfeed.slice.action;

import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b extends a {
    public w c;

    public b(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.c = r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void c(DeepFeedSlcCardContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if ((r2 instanceof w) == false) goto L8;
        this.c = r2;
        v r0 = this.a;
        if (r0 == null) goto L9;
        r0.c(r2);
        return;
    L9:
        return;
    }
}
