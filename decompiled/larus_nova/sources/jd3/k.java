package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f498364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f498367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f498368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f498369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f498370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f498371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498372i;

    public static final class a {
    }

    static {
    }

    public k() {
        super("ec_anchor_v3_comment_interaction_duration");
        this.f498365b = "";
        this.f498366c = "";
        this.f498372i = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("data_type", String.valueOf(this.f498364a));
        appendParam(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE, this.f498365b);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_CONTENT, this.f498366c);
        appendParam("duration", String.valueOf(this.f498367d));
        appendParam("comments_page_api_duration", String.valueOf(this.f498368e));
        appendParam("comments_api_duration", String.valueOf(this.f498369f));
        appendParam("same_comments_api_duration", String.valueOf(this.f498370g));
        appendParam("render_duration", String.valueOf(this.f498371h));
        appendParam("type", this.f498372i);
    }

    public final String getType() {
        return this.f498372i;
    }
}
