package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Map<String, Object> e;

    public o(String r2, String r3, String r4, String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "nodeKey");
        Intrinsics.checkNotNullParameter(r6, "triggerParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
