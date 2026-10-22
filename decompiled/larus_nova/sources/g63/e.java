package g63;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f480154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f480155b;

    public static final class a {
    }

    static {
    }

    public e() {
        super("kol_selected_comment_page_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f480154a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_type", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ALL_VIDEO_CNT, String.valueOf(this.f480155b), r101);
    }
}
