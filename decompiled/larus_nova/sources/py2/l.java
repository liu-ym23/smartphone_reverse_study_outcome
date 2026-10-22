package py2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f531021b;

    public l() {
        super("navigationStart");
        this.f531021b = System.currentTimeMillis();
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.g(r100, "invoke_ts", this.f531021b);
    }
}
