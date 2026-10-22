package kt1;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements e {
    public d() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r110, DiagnoseResult r111) {
    L32:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L34:
        return r111;
    L4:
        if (c.b().f506004a == false) goto L34;
        v2 r100 = r110.f121946g;     // Catch: Exception -> L32
        if (r100 == null) goto L34;
        v2.a r101 = r100.diagnoseTypeHot;     // Catch: Exception -> L32
        if (r101 == null) goto L34;
        if (r101.enable == false) goto L34;
        if (c.b().f506005b == false) goto L14;
        double r102 = r100.diagnoseTypeHot.temperatureAnchor;     // Catch: Exception -> L32
    L15:
        int r103 = 0;
        if (r110.f121940a.isEmpty() == true) goto L29;
        int r104 = 0;
    L19:
        if (r103 >= r110.f121940a.size()) goto L28;
        JSONObject r105 = r110.f121940a.get(r103);     // Catch: Exception -> L32
        if ((r105.opt(IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE) instanceof Map) == false) goto L27;
        String r106 = (String) ((Map) r105.opt(IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE)).get("thermal");     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r106) == true) goto L27;
        if (new JSONObject(r106).optDouble("value") <= r102) goto L27;
        r104 = 1;
    L27:
        r103 = r103 + 1;     // Catch: Exception -> L32
        goto L19
    L28:
        r103 = r104;
    L29:
        if (r103 == 0) goto L34;
        JSONArray r112 = r111.monitorInfo.optJSONArray(DiagnoseResult.KEY_DIAGNOSE_TYPE);     // Catch: Exception -> L32
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L32
        r107.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, DiagnoseResult.DIAGNOSE_TYPE_HOT);     // Catch: Exception -> L32
        r107.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L32
        r112.put(r107);     // Catch: Exception -> L32
        goto L34
    L14:
        r102 = r100.diagnoseTypeHot.temperature;     // Catch: Exception -> L32
        goto L15
    }
}
