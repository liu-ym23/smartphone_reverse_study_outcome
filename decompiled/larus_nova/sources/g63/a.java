package g63;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f480145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f480146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f480147c;

    /* JADX INFO: renamed from: g63.a$a, reason: collision with other inner class name */
    public static final class C5988a {
    }

    static {
    }

    public a() {
        super("click_comment_like");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f480145a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("comment_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, this.f480146b, r101);
        appendParam("type", this.f480147c, r101);
    }

    public final String getType() {
        return this.f480147c;
    }
}
