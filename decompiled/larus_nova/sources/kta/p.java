package kta;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f506117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f506118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f506119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f506120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f506121g;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        s.c(r100, "id", this.f506115a);
        s.c(r100, "req_id", this.f506116b);
        s.c(r100, "is_track_limited", this.f506117c);
        s.c(r100, "take_ms", this.f506118d);
        s.c(r100, "time", this.f506119e);
        s.c(r100, "query_times", this.f506120f);
        s.c(r100, "hw_id_version_code", this.f506121g);
        return r100;
    }

    public final String toString() {
        return a().toString();
    }

    public p(String r100, String r101, Boolean r102, Long r103, Long r104, Integer r105, Long r106) {
        this.f506115a = r100;
        this.f506116b = r101;
        this.f506117c = r102;
        this.f506118d = r103;
        this.f506119e = r104;
        this.f506120f = r105;
        this.f506121g = r106;
    }
}
