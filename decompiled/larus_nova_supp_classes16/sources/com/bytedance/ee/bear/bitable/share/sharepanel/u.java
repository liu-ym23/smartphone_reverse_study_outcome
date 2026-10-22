package com.bytedance.ee.bear.bitable.share.sharepanel;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ FormsShareFragmentDelegate a;

    public u(FormsShareFragmentDelegate r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("FormsShareFragmentDelegate", "updatePermission()...error", r5, false);
        FormsShareFragmentDelegate r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.x(r5);
        com.bytedance.ee.bear.bitable.share.view.memberview.d r6 = this.a.i;
        if (r6 == null) goto L6;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.share.IBitableSharePermSetInfo");
        r6.s();
        return;
    }
}
