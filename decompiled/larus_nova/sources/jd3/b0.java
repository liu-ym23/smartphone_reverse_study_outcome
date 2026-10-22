package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498268c;

    public static final class a {
    }

    static {
    }

    public b0() {
        super("order_schema");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498266a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("new_schema", r100, r101);
        appendParam("old_schema", this.f498267b, r101);
        appendParam("scene", this.f498268c, r101);
    }
}
