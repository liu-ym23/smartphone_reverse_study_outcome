package kc7;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static a a(String r100) {
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L19
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L19
        a r103 = new a();     // Catch: Exception -> L19
        if (r102.hasNext() == false) goto L18;
        String r104 = r102.next();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r104) == true) goto L18;
        if (r104.hashCode() == 1481071862) goto L12;
    L14:
        byte r105 = -1;
    L15:
        if (r105 != 0) goto L18;
        r103.f502412a = Integer.valueOf(r101.optInt(r104));     // Catch: Exception -> L19
        goto L18
    L12:
        if (r104.equals("country_code") == false) goto L14;
        r105 = 0;
    L18:
        return r103;
    L25:
        return null;
    }
}
