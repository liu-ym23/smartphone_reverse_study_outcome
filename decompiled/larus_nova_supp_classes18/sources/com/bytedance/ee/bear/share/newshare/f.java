package com.bytedance.ee.bear.share.newshare;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ShareDocFragment a;

    public f(ShareDocFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("ShareDocFragment", "fetch metaInfo and permission failed", r5, false);
        ShareDocFragment r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.Ma0(r5);
        ShareDocFragment.Ra0(this.a, r5);
    }
}
