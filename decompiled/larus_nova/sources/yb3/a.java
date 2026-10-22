package yb3;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f567075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f567076b;

    /* JADX INFO: renamed from: yb3.a$a, reason: collision with other inner class name */
    public static final class C8322a {
    }

    static {
    }

    public a() {
        super("click_comment_like");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f567075a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("action_type", r100, r101);
        appendParam("type", this.f567076b, r101);
    }
}
