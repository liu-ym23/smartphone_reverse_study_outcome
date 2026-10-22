package lta;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends h {
    public final JSONArray h() {
        jta.e r100 = (jta.e) this.f510734e;
        r100.getClass();
        JSONArray r101 = jta.e.f500364i;
        if (r101 != null) goto L29;
        JSONArray r102 = pta.c.o(r100.f500346a);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r100.f500349d) == true) goto L18;
        String r103 = r100.f500349d;     // Catch: Exception -> L20
        if (r102.length() == 0) goto L18;
        int r104 = 0;
    L11:
        if (r104 >= r102.length()) goto L18;
        JSONObject r105 = r102.optJSONObject(r104);     // Catch: Exception -> L20
        if (r105 == null) goto L17;
        String r106 = r105.optString("id");     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r106) == true) goto L17;
        r105.remove("id");     // Catch: Exception -> L20
        r105.put("id", r106 + r103);     // Catch: Exception -> L20
    L17:
        r104 = r104 + 1;     // Catch: Exception -> L20
    L18:
        jta.e.f500364i = r102;     // Catch: Exception -> L20
        return r102;
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L29:
        return r101;
    }

    public e(Context r100, boolean r101) {
        super(r100, r101);
    }
}
