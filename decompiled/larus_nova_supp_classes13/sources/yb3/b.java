package yb3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public String g;
    public String h;
    public String i;
    public Integer j;

    public static final class a {
    }

    static {
    }

    public b() {
        super("comment_content_exit");
    }

    public final void buildParams() {
        String r0 = String.valueOf(this.f);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("show_num", r0, r1);
        appendParam("action_type", String.valueOf(this.g), r1);
        appendParam("content_type", this.a, r1);
        appendParam("comment_id", this.b, r1);
        appendParam("comment_rank", String.valueOf(this.c), r1);
        appendParam("picture_num", String.valueOf(this.d), r1);
        appendParam("video_num", String.valueOf(this.e), r1);
        appendParam("comment_switch_type", String.valueOf(this.h), r1);
        appendParam("user_comment_level", String.valueOf(this.i), r1);
        appendParam("content_rank", String.valueOf(this.j), r1);
    }
}
