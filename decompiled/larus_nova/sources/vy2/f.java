package vy2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f557591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f557592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f557593d;

    public static final class a {
    }

    static {
    }

    public f() {
        super("nativeError");
        this.f557591b = "lynx_error";
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.i(r100, "scene", this.f557591b);
        bz2.e.f(r100, "error_code", this.f557592c);
        bz2.e.i(r100, "error_msg", this.f557593d);
    }
}
