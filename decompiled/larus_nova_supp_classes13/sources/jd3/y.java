package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y extends com.bytedance.android.ec.core.event.a {
    public String a;

    public y() {
        super("invalid_activity_event");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("page_location", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
