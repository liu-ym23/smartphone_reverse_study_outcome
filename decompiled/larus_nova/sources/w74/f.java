package w74;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f558526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f558527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f558529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f558530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f558531f;

    public final void a() {
        this.f558530e.putOpt("duration", Long.valueOf(this.f558527b));     // Catch: JSONException -> L12
        if ("d_i0".equals(this.f558526a) == false) goto L6;
    L9:
        this.f558530e.putOpt("data", new JSONObject(this.f558528c));     // Catch: JSONException -> L12
    L10:
        this.f558530e.putOpt("errorMsg", this.f558529d);     // Catch: JSONException -> L12
        return;
    L6:
        if ("d_a0".equals(this.f558526a) == true) goto L9;
        this.f558530e.putOpt("data", this.f558528c);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        m74.a.a("[dt]  json error " + Log.getStackTraceString(e));
    }

    public final String toString() {
        return "FingerInfo{name='" + this.f558526a + "', duration=" + this.f558527b + ", data='" + this.f558528c + "', error='" + this.f558529d + "'}";
    }

    public f() {
        this.f558530e = new JSONObject();
    }
}
