package lta;

import com.ss.android.socialbase.appdownloader.util.RomUtils;
import i84.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static void a(JSONObject r100) {
        boolean r101 = pta.d.h();
        if (r101 == false) goto L6;
        Object r102 = "Harmony";
    L23:
        r100.put("os", r102);     // Catch: JSONException -> L9
    L11:
        if (r101 == true) goto L13;
        return;
    L13:
        JSONObject r103 = new JSONObject();
        r103.put("os_api", u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L16
        r103.put("os_version", u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L16
        r103.put("release_type", u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L16
    L27:
        r100.put(RomUtils.OS_HARMONY, r103);     // Catch: JSONException -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r102 = "Android";
        goto L23
    }
}
