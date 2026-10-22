package q74;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends p74.a {
    @Override // p74.a
    public final String b() {
        return "d_a0";
    }

    @Override // p74.a
    public final String c() {
        JSONArray r100 = this.f528018c.optJSONArray("path");
        if (r100 != null) goto L5;
        return "";
    L5:
        JSONObject r101 = new JSONObject();
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L22;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: Exception -> L15
        Class<?> r104 = this.f528019d.f553481a;     // Catch: Exception -> L15
        if (r104 != null) goto L26;
    L10:
        String r105 = "";
    L13:
        r101.put(r103, r105);     // Catch: Exception -> L15
    L20:
        r102 = r102 + 1;
        goto L7
    L26:
        r105 = (String) r104.getDeclaredMethod("getDA0Result", new Class[]{String.class}).invoke(null, new Object[]{r103});     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r105) == true) goto L10;
    L15:
        e = move-exception;
        if (e.getCause() == null) goto L19;
        this.f528017b = e.getCause().getMessage();
        goto L20
    L19:
        this.f528017b = e.getMessage();
        goto L20
    L22:
        return r101.toString();
    }

    public a(JSONObject r100) {
        super(r100);
    }
}
