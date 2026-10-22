package yb3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {
    public long a;
    public String b;

    public static final class a {
    }

    static {
    }

    public f() {
        super("ecom_stay_time");
    }

    public final void buildParams() {
        String r0 = String.valueOf(this.a);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("duration", r0, r1);
        appendParam("action_type", this.b, r1);
    }
}
