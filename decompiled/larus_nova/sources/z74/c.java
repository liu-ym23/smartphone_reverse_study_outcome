package z74;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends l74.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f570658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f570659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f570660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f570661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f570662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f570663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f570664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f570665h;

    @Override // l74.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r100.put("duration", this.f570659b - this.f570658a);     // Catch: JSONException -> L5
        r100.put("retry_count", this.f570660c);     // Catch: JSONException -> L5
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, this.f570662e);     // Catch: JSONException -> L5
        r100.put("did_change", this.f570661d);     // Catch: JSONException -> L5
        r100.put("is_new_user_mode", this.f570663f);     // Catch: JSONException -> L5
        r100.put("scene", this.f570664g);     // Catch: JSONException -> L5
        r100.put("result", this.f570665h);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // l74.c
    public final void c() {
        this.f570658a = 0;
        this.f570659b = 0;
        this.f570660c = 0;
        this.f570661d = false;
        this.f570662e = false;
        this.f570665h = false;
    }

    public c() {
        this.f570658a = 0;
        this.f570659b = 0;
        this.f570660c = 0;
        this.f570661d = false;
        this.f570662e = false;
        this.f570663f = 0;
        this.f570664g = 0;
        this.f570665h = false;
    }

    public void setResult(boolean r100) {
        this.f570665h = r100;
    }
}
