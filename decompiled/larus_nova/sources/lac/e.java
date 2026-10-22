package lac;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class e {
    public static b a(Context r100) {
        ApplicationInfo r101 = r100.getApplicationInfo();     // Catch: Throwable -> L8
        if (r101 == null) goto L9;
        String r102 = r101.sourceDir;     // Catch: Throwable -> L8
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L29;
        return null;
    L29:
        String r103 = c.a(new PolarisFileWrapper(r102));     // Catch: JSONException -> L22
        if (r103 == null) goto L24;
        JSONObject r104 = new JSONObject(r103);     // Catch: JSONException -> L22
        Iterator<String> r105 = r104.keys();     // Catch: JSONException -> L22
        HashMap r106 = new HashMap();     // Catch: JSONException -> L22
    L19:
        if (r105.hasNext() == false) goto L25;
        String r107 = r105.next().toString();     // Catch: JSONException -> L22
        r106.put(r107, JSONObjectProtectorUtils.getString(r104, r107));     // Catch: JSONException -> L22
    L25:
        if (r106 == null) goto L35;
        String r108 = (String) r106.get("channel");
        r106.remove("channel");
        return new b(r108, r106);
    L35:
        return null;
    L24:
        r106 = null;
    L22:
        e = move-exception;
        e.printStackTrace();
    L9:
        r102 = null;
        goto L11
    }
}
