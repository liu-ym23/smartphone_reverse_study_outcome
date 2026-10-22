package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g1 extends com.bytedance.android.ec.core.event.a {
    public Integer a;
    public Integer b;

    public static final class a {
    }

    static {
    }

    public g1() {
        super("ec_inner_feed_card_not_show");
    }

    public final void buildParams() {
        Integer r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("card_type", r2, r3);
        Integer r4 = this.a;
        if (r4 == null) goto L9;
        r1 = String.valueOf(r4.intValue());
    L9:
        appendParam("card_position", r1, r3);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
