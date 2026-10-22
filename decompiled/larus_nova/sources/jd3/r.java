package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f498422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498423h;

    public static final class a {
    }

    static {
    }

    public r() {
        super("ec_cache_monitor");
        this.f498420e = "type";
        this.f498421f = "is_fullscreen";
        this.f498422g = "has_price_diff";
        this.f498423h = "scene";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(this.f498423h, this.f498419d);
        appendParam(this.f498420e, this.f498416a);
        appendParam(this.f498421f, this.f498417b);
        appendParam(this.f498422g, this.f498418c);
    }

    public final String getType() {
        return this.f498416a;
    }
}
