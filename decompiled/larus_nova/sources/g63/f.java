package g63;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f480156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f480157b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f480156a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("comment_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, this.f480157b, r101);
    }

    public f() {
        super("single_comment_click");
    }
}
