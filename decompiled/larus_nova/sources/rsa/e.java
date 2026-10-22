package rsa;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    public static Map<String, String> a(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L4;
        r101.put(r103, r104);
        goto L4
    L8:
        return r101;
    }
}
