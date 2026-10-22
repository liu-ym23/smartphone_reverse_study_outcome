package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class l0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498381a;

    public static final class a {
    }

    static {
    }

    public l0() {
        super("product_extra_info_click");
        this.f498381a = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498381a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_INFO_NAME, r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    }
}
