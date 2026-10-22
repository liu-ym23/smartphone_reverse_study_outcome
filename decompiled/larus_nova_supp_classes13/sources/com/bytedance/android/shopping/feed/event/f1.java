package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f1 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public f1() {
        super("inflow_unused_monitor");
    }

    public final void buildParams() {
        appendParam("type", this.a);
        appendParam("class_name", this.b);
        appendParam("comment", null);
        appendParam("extra_log", null);
        appendParam("request_id", this.c);
    }

    public final String getType() {
        return this.a;
    }
}
