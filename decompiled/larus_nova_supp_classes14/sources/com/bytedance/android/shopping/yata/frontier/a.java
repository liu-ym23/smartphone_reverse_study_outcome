package com.bytedance.android.shopping.yata.frontier;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;

    public a(int r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "appKey");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = r2 + '_' + r3 + '_' + r4 + '_' + r5;
    }
}
