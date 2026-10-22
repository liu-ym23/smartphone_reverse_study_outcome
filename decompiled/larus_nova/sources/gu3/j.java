package gu3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements nt3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile nt3.a f482778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f482779b;

    @Override // nt3.b
    public final nt3.a getConfig() {
        return this.f482778a;
    }

    public j(JSONObject r100) {
        this.f482779b = r100;
        hu3.a.a().b();
        hu3.a.a().c(new i(this));
    }
}
