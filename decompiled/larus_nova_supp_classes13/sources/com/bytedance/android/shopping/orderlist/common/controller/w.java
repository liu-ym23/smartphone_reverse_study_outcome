package com.bytedance.android.shopping.orderlist.common.controller;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w {
    public long a;
    public boolean b;
    public final float c;
    public final String d;
    public final String e;

    public w(float r2, String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r6, "renderNodeKey");
        this.c = r2;
        this.d = r3;
        this.e = r6;
        this.a = r4;
        this.b = true;
    }
}
