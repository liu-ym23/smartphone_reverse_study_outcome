package vy2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends ny2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f557580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f557581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f557582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f557583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f557584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f557585f;

    public d() {
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.g(r100, "load_start", this.f557580a);
        bz2.e.g(r100, "load_finish", this.f557581b);
        bz2.e.g(r100, "load_failed", 0);
        bz2.e.g(r100, "receive_error", 0);
        bz2.e.g(r100, "first_screen", this.f557582c);
        bz2.e.g(r100, "runtime_ready", this.f557583d);
    }
}
