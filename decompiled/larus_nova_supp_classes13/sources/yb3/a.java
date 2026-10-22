package yb3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    /* JADX INFO: renamed from: yb3.a$a, reason: collision with other inner class name */
    public static final class C0245a {
    }

    static {
    }

    public a() {
        super("click_comment_like");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("action_type", r0, r1);
        appendParam("type", this.b, r1);
    }
}
