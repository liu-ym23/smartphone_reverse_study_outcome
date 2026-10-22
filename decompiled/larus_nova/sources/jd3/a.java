package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498258b;

    /* JADX INFO: renamed from: jd3.a$a, reason: collision with other inner class name */
    public static final class C6416a {
    }

    static {
    }

    public a() {
        super("ec_goods_detail_page_exception");
        this.f498257a = "";
        this.f498258b = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498257a;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        appendParam("message", r100);
        String r102 = this.f498258b;
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        appendParam("extra_message", r101);
    }
}
