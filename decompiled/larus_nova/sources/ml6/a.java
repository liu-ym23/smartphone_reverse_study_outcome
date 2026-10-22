package ml6;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements rs6.a {
    public a() {
    }

    @Override // rs6.a
    public final void a(JSONObject r100) {
        if (r100 != null) goto L13;
        r100 = new JSONObject();
    L13:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        ApmAgent.monitorCommonLog("poi_log", r100);
        return;
    L6:
        if (TextUtils.isEmpty("poi_city") == true) goto L11;
        r100.put("service", "poi_city");     // Catch: JSONException -> L9
        goto L11
    }

    @Override // rs6.a
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        ApmAgent.monitorEvent(r100, r101, r102, r103);
    }
}
