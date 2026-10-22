package kt1;

import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static boolean a(DiagnoseEngine r110, DiagnoseResult r111) {
        boolean r100 = false;
        v2 r101 = r110.f121946g;     // Catch: Exception -> L20
        if (r101 != null) goto L6;
    L22:
        return r100;
    L6:
        if (r110.f121940a.size() <= 0) goto L22;
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L20
        int r103 = r110.f121940a.size();     // Catch: Exception -> L20
        float r104 = 0.0f;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L14;
        int r106 = r110.f121940a.get(r105).optInt("net_quality", 6);     // Catch: Exception -> L20
        r104 = r104 + r106;     // Catch: Exception -> L20
        if (r106 > r101.netStatus) goto L12;
        r102.append(r106);     // Catch: Exception -> L20
        r102.append("#");     // Catch: Exception -> L20
    L12:
        r105 = r105 + 1;     // Catch: Exception -> L20
        goto L8
    L14:
        if ((r104 / r103) >= r101.netStatus) goto L22;
        r100 = true;
        JSONObject r112 = r111.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L20
        if (r112 != null) goto L18;
        r112 = new JSONObject();     // Catch: Exception -> L20
    L18:
        r112.put("net_status_over_list", r102.toString());     // Catch: Exception -> L20
        r111.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r112);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
