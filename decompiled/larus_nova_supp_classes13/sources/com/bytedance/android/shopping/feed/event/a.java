package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public final boolean a;
    public final boolean b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.event.a$a, reason: collision with other inner class name */
    public static final class C0064a {
    }

    static {
    }

    public final void buildParams() {
        String r1 = "1";
        if (this.b == false) goto L5;
        String r0 = "1";
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("error_status", r0, r3);
        if (this.a == true) goto L10;
        r1 = "0";
    L10:
        appendParam("is_first", r1, r3);
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public a(boolean r2, boolean r3) {
        super("ec_inner_flow_ad_action_event");
        this.a = r2;
        this.b = r3;
    }
}
