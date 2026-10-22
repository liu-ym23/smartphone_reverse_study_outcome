package u77;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f549063b;

    public j() {
        this.f549062a = false;
        this.f549063b = 0;
    }

    public j(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L5
        this.f549062a = r101.optBoolean("enable_harmony_os4_importance_category", false);     // Catch: Throwable -> L5
        this.f549063b = r101.optInt("harmony_os4_importance_category_intercept_strategy", 0);     // Catch: Throwable -> L5
        return;
    }
}
