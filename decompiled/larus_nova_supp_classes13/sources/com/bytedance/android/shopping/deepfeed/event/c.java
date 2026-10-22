package com.bytedance.android.shopping.deepfeed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {
    public Integer a;

    public static final class a {
    }

    static {
    }

    public c() {
        super("deep_feed_load_more");
    }

    public final void buildParams() {
        Integer r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("state", r1, com.bytedance.android.ec.core.event.a.b.a.a);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
