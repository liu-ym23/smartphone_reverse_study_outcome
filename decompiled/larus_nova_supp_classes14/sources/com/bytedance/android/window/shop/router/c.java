package com.bytedance.android.window.shop.router;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.android.ec.core.event.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam("location", this.a);
        appendParam("business", this.b);
        appendParam("in_schema", this.c);
        appendParam("out_schema", this.d);
    }

    public c(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "location");
        Intrinsics.checkNotNullParameter(r3, "business");
        super("schema_report");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
