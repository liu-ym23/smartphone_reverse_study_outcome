package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q1 extends com.bytedance.android.ec.core.event.a {
    public String a;

    public q1() {
        super("label_group_show");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("label_content_type", "label_group", com.bytedance.android.ec.core.event.a.b.a.a);
        appendParam("label_group_show_name", this.a);
    }
}
