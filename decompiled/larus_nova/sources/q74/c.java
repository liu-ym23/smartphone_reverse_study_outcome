package q74;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends p74.a {
    @Override // p74.a
    public final String b() {
        return "d_i0";
    }

    @Override // p74.a
    public final String c() {
        JSONArray r100 = this.f528018c.optJSONArray("path");
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.length() > 0) goto L8;
        return "";
    L8:
        String[] r101 = new String[r100.length()];
        int r102 = 0;
    L10:
        if (r102 >= r100.length()) goto L30;
        r101[r102] = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L13
    L15:
        r102 = r102 + 1;
    L13:
        e = move-exception;
        m74.a.b("[dt] d_i0jsonArray parse error " + e.getMessage());
        goto L15
    L30:
        v74.d r103 = this.f528019d;     // Catch: Exception -> L22
        if (r103 != null) goto L21;
        m74.a.a("[dt] d_i0dTraitNativeManager is null, return empty ");     // Catch: Exception -> L22
        return "";
    L21:
        return r103.b(r101);
    L22:
        e = move-exception;
        if (e.getCause() == null) goto L26;
        this.f528017b = e.getCause().getMessage();
    L27:
        return "";
    L26:
        this.f528017b = e.getMessage();
        goto L27
    }

    public c(JSONObject r100) {
        super(r100);
    }
}
