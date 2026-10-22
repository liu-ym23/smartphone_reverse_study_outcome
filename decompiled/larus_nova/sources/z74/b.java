package z74;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends l74.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f570656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f570657d;

    @Override // l74.c
    public final void c() {
        this.f570654a = 0;
        this.f570655b = 0;
        this.f570656c = 0;
        this.f570657d = 0;
    }

    @Override // l74.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("params_for_special", "uc_login");     // Catch: JSONException -> L5
        r100.put("duration", this.f570657d);     // Catch: JSONException -> L5
        r100.put("type", getType());     // Catch: JSONException -> L5
        r100.put("state", this.f570655b);     // Catch: JSONException -> L5
        r100.put(ForwardDependency$ForwardLocation.FLAG, this.f570656c);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public b() {
        this.f570654a = 0;
        this.f570655b = 0;
        this.f570656c = 0;
        this.f570657d = 0;
    }

    public int getType() {
        return this.f570654a;
    }
}
