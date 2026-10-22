package ny2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521188a;

    @Override // ny2.a, ny2.f
    public final JSONObject a() {
        JSONObject r100 = super.a();
        bz2.e.i(r100, "event_type", this.f521188a);
        return r100;
    }

    public b(String r100) {
        this.f521188a = null;
        this.f521188a = r100;
    }
}
