package yb3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public c() {
        super("show_comment_detail_page");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("action_type", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
