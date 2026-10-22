package vy2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f557575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f557576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f557577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f557578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f557579f;

    public c() {
        super("fetchError");
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.i(r100, com.alipay.sdk.m.p.e.f25671s, this.f557575b);
        bz2.e.f(r100, "error_code", 0);
        bz2.e.i(r100, "error_msg", this.f557579f);
        bz2.e.i(r100, "url", this.f557576c);
        bz2.e.f(r100, "status_code", this.f557577d);
        bz2.e.f(r100, "request_error_code", this.f557578e);
        bz2.e.i(r100, "request_error_msg", null);
        bz2.e.f(r100, "jsb_ret", 0);
        bz2.e.f(r100, "hit_prefetch", 0);
    }
}
