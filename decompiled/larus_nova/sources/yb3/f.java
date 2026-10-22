package yb3;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f567091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f567092b;

    public static final class a {
    }

    static {
    }

    public f() {
        super("ecom_stay_time");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f567091a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam("action_type", this.f567092b, r101);
    }
}
