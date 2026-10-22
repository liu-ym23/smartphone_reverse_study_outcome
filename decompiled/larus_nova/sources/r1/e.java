package r1;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, e> f535556b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f535557a;

    static {
        f535556b = new HashMap();
    }

    public final boolean a() {
        JSONObject r100 = this.f535557a;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        if (r100.optInt("status") == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return true;
    L15:
        return true;
    }

    public e(JSONObject r100, String r101) {
        this.f535557a = r100;
        if (r100 == null) goto L7;
        JSONObject r102 = r100.optJSONObject("error_module");
        if (r102 == null) goto L7;
        r102.optInt("switcher");
        r102.optInt("err_sampling_rate");
    L7:
        f535556b.put(r101, this);
        com.apm.lite.k.p.a("after update aid " + r101);
    }
}
