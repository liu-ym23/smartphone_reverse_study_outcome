package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public static final class a {
    }

    static {
    }

    public r() {
        super("ec_cache_monitor");
        this.e = "type";
        this.f = "is_fullscreen";
        this.g = "has_price_diff";
        this.h = "scene";
    }

    public final void buildParams() {
        appendParam(this.h, this.d);
        appendParam(this.e, this.a);
        appendParam(this.f, this.b);
        appendParam(this.g, this.c);
    }

    public final String getType() {
        return this.a;
    }
}
