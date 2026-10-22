package in;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f490567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f490568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f490569e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f490570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f490571b;

    public static final class a {
    }

    static {
        f490567c = "";
        f490568d = "";
        f490569e = "";
    }

    public b() {
        super("show_commerce_toast");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        int r100 = this.f490571b;
        if (r100 != 1) goto L5;
        String r101 = String.valueOf(r100);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam("is_live", r101, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    L5:
        String r102 = this.f490570a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r103 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("action_type", r102, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, f490567c, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, f490568d, r103);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, f490569e, r103);
    }
}
