package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498273c;

    public d() {
        super("click_activity_entrance");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498271a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("module_name", this.f498272b, r101);
        appendParam("activity_name", this.f498273c, r101);
    }
}
