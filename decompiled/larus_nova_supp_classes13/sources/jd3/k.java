package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.ec.core.event.a {
    public int a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;

    public static final class a {
    }

    static {
    }

    public k() {
        super("ec_anchor_v3_comment_interaction_duration");
        this.b = "";
        this.c = "";
        this.i = "";
    }

    public final void buildParams() {
        appendParam("data_type", String.valueOf(this.a));
        appendParam("interaction_type", this.b);
        appendParam("interaction_content", this.c);
        appendParam("duration", String.valueOf(this.d));
        appendParam("comments_page_api_duration", String.valueOf(this.e));
        appendParam("comments_api_duration", String.valueOf(this.f));
        appendParam("same_comments_api_duration", String.valueOf(this.g));
        appendParam("render_duration", String.valueOf(this.h));
        appendParam("type", this.i);
    }

    public final String getType() {
        return this.i;
    }
}
