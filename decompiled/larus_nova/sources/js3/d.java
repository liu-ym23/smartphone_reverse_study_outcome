package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f500216c;

    @Override // hs3.c
    public final boolean b() {
        return false;
    }

    @Override // hs3.c
    public final String d() {
        return UploadTypeInf.TIMER;
    }

    @Override // hs3.c
    public final String e() {
        return UploadTypeInf.TIMER;
    }

    @Override // hs3.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("type", this.f500214a);     // Catch: JSONException -> L5
        r100.put("key", this.f500215b);     // Catch: JSONException -> L5
        r100.put("value", this.f500216c);     // Catch: JSONException -> L5
        return r100;
    L5:
        return null;
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        String r101 = this.f500214a;
        return zs3.c.f573475a.c(r101);
    }

    public d(String r100, String r101, float r102) {
        this.f500214a = r100;
        this.f500215b = r101;
        this.f500216c = r102;
    }
}
