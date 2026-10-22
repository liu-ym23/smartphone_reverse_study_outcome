package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class w extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f498548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498551d;

    public static final class a {
    }

    static {
    }

    public w() {
        super("ec_goods_detail_load_image");
        this.f498548a = 1;
        this.f498549b = "";
        this.f498550c = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f498548a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("result", r100, r101);
        appendParam("url", this.f498549b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MESSAGE, this.f498550c, r101);
        appendParam("position", String.valueOf(this.f498551d), r101);
    }

    public final void setResult(int r100) {
        this.f498548a = r100;
    }
}
