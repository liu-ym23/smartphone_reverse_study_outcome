package wkc;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f560160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f560162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f560163e;

    public a(JSONObject r100) {
        this.f560159a = 0;
        this.f560160b = null;
        this.f560161c = 300;
        this.f560162d = false;
        this.f560163e = false;
        int r101 = JSONObjectProtectorUtils.getInt(r100, "StatusCode");     // Catch: JSONException -> L8
        this.f560159a = r101;     // Catch: JSONException -> L8
        JSONObjectProtectorUtils.getString(r100, "StatusMessage");     // Catch: JSONException -> L8
        if (r101 != 0) goto L6;
        this.f560160b = JSONObjectProtectorUtils.getJSONObject(r100, "IpMap");     // Catch: JSONException -> L8
        JSONObjectProtectorUtils.getString(r100, "Symbol");     // Catch: JSONException -> L8
    L6:
        this.f560161c = JSONObjectProtectorUtils.getInt(r100, "DnsTTL");     // Catch: JSONException -> L8
        this.f560162d = JSONObjectProtectorUtils.getBoolean(r100, "EnableIpSettings");     // Catch: JSONException -> L8
        this.f560163e = JSONObjectProtectorUtils.getBoolean(r100, "EnablePing");     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
