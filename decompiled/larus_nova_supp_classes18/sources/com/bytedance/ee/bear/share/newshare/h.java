package com.bytedance.ee.bear.share.newshare;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ ShareDocFragment b;

    public h(Ref.BooleanRef r1, ShareDocFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("ShareDocFragment", "fetch publicPermission failed", r5, false);
        this.a.element = true;
        ShareDocFragment r0 = this.b;
        Intrinsics.checkNotNull(r5);
        r0.Ma0(r5);
        ShareDocFragment.Ra0(this.b, r5);
    }
}
