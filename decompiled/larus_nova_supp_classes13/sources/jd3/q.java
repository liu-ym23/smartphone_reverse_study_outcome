package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public q() {
        super("detail_2_order_adparams_from_feed");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("entrance_info", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
