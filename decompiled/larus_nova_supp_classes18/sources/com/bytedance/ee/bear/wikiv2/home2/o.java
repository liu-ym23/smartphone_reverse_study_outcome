package com.bytedance.ee.bear.wikiv2.home2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements gqa.b {
    public final /* synthetic */ k a;

    public o(k r1) {
        this.a = r1;
    }

    public final void O0(cqa.h r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        k.b r3 = this.a.m;
        if (r3 == null) goto L6;
        r3.onLoadMore();
        return;
    }
}
