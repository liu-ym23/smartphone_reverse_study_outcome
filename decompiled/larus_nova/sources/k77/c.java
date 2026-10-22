package k77;

import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f502033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f502034b;

    public final String toString() {
        JSONObject r100 = new JSONObject();
        Map<String, String> r101 = this.f502033a;
        if (r101 == null) goto L5;
        add(r100, "component_info", StringUtils.mapToString(r101));
    L5:
        add(r100, "update_version_code", this.f502034b);
        return r100.toString();
    }

    public c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L9
        String r102 = r101.optString("component_info");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r102) == true) goto L7;
        this.f502033a = StringUtils.stringToMap(r102, new HashMap());     // Catch: Throwable -> L9
    L7:
        this.f502034b = r101.optInt("update_version_code");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        f.f("ComponentProcessInfo", "error when parse ComponentProcessInfo ", th);
        return;
    }
}
