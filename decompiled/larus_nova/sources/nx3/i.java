package nx3;

import android.text.TextUtils;
import com.bytedance.applog.log.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static void a(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("oaid");     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        String r102 = r101.optString("id", null);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r100.put("oaid", r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        n.w().q("transferHeader failed", e, new Object[0]);
    }
}
