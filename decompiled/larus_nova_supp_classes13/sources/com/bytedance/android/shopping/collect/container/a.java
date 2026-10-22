package com.bytedance.android.shopping.collect.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final CollectYataQueryFrom a;
    public final CollectYataSkeletonLoadingStatus b;
    public final int c;

    public a(CollectYataQueryFrom r2, CollectYataSkeletonLoadingStatus r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "queryFrom");
        Intrinsics.checkNotNullParameter(r3, "collectYataSkeletonLoadingStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
