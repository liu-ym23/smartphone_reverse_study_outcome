package q74;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends p74.a {
    @Override // p74.a
    public final String b() {
        return "d_r0";
    }

    @Override // p74.a
    public final String c() {
        JSONArray r100 = this.f528018c.optJSONArray("path");
        if (r100 != null) goto L5;
        return "";
    L5:
        String r101 = "";
        int r102 = 0;
    L32:
    L10:
        e = move-exception;
        m74.a.b("[dt] d_r0jsonArray# error " + e.getMessage());
    L34:
        v74.d r103 = this.f528019d;     // Catch: Exception -> L25
        if (r103 != null) goto L16;
        m74.a.a("[dt] dTraitNativeManager is null, return empty ");     // Catch: Exception -> L25
        return "";
    L16:
        Class<?> r104 = r103.f553481a;     // Catch: Exception -> L25
        if (r104 != null) goto L35;
    L18:
        String r105 = "";
    L22:
        if (TextUtils.isEmpty(r105) == true) goto L30;
        m74.a.a("[dt] modify_time: " + r105);     // Catch: Exception -> L25
        return r105;
    L30:
        return "";
    L35:
        r105 = (String) r104.getDeclaredMethod("getDM0Result", new Class[]{String.class}).invoke(null, new Object[]{r101});     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r105) == true) goto L18;
    L25:
        e = move-exception;
        if (e.getCause() == null) goto L29;
        this.f528017b = e.getCause().getMessage();
        goto L30
    L29:
        this.f528017b = e.getMessage();
        goto L30
    L7:
        if (r102 >= r100.length()) goto L34;
        r101 = r100.optString(r102);     // Catch: Exception -> L10
        r102 = r102 + 1;
        goto L32
    }

    public e(JSONObject r100) {
        super(r100);
    }
}
