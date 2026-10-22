package kt1;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements e {
    public j() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r210, DiagnoseResult r211) {
        DiagnoseEngine r100 = r210;
        String r101 = IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE;
    L56:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L58:
        return r211;
    L4:
        if (c.b().f506004a == false) goto L58;
        v2 r102 = r100.f121946g;     // Catch: Exception -> L56
        if (r102 == null) goto L58;
        v2.c r103 = r102.diagnoseTypeUIStall;     // Catch: Exception -> L56
        if (r103 == null) goto L58;
        if (r103.enable == false) goto L58;
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L56
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L56
        if (r100.f121940a.isEmpty() == true) goto L48;
        int r106 = r100.f121940a.size();     // Catch: Exception -> L56
        int r110 = 0;
        double r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r112 = 0;
    L14:
        if (r110 >= r106) goto L41;
        JSONObject r113 = r100.f121940a.get(r110);     // Catch: Exception -> L56
        new HashMap();     // Catch: Exception -> L56
        if ((r113.get(r101) instanceof Map) == false) goto L39;
        Map r107 = (Map) r113.get(r101);     // Catch: Exception -> L56
        if (TextUtils.equals("1", (String) r107.get(IPerformanceManager.Stall.has_stall)) == false) goto L20;
        r112 = r112 + 1;     // Catch: Exception -> L56
    L20:
        String r114 = (String) r107.get(IPerformanceManager.Stall.stall_ui_rate);     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r114) == true) goto L32;
        double r115 = CastDoubleProtector.parseDouble(r114);     // Catch: Exception -> L56
        if (r115 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L26;
    L27:
        r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L28:
        double r116 = r111 + r115;     // Catch: Exception -> L56
        if (r115 < r102.diagnoseTypeUIStall.uiStallRate) goto L31;
        r105.append(r114);     // Catch: Exception -> L56
        r105.append("#");     // Catch: Exception -> L56
    L31:
        r111 = r116;
        goto L32
    L26:
        if (r115 <= 1.0d) goto L28;
    L32:
        String r108 = (String) r107.get("fps");     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r108) == true) goto L37;
        String r117 = r101;
        double r212 = r111;
        if (CastDoubleProtector.parseDouble(r108) < r102.diagnoseTypeUIStall.fps) goto L38;
        r104.append(r108);     // Catch: Exception -> L56
        r104.append("#");     // Catch: Exception -> L56
    L38:
        r111 = r212;
    L40:
        r110 = r110 + 1;     // Catch: Exception -> L56
        r100 = r210;
        r101 = r117;
        goto L14
    L37:
        r117 = r101;
        r212 = r111;
        goto L38
    L39:
        r117 = r101;
        goto L40
    L41:
        double r109 = r106;
        double r118 = AudioStats.AUDIO_AMPLITUDE_NONE / r109;     // Catch: Exception -> L56
        double r119 = r111 / r109;     // Catch: Exception -> L56
        v2.c r120 = r102.diagnoseTypeUIStall;     // Catch: Exception -> L56
        if (r112 >= r120.hasStallCount) goto L44;
    L46:
        boolean r121 = false;
    L47:
        double r122 = r118;
        int r123 = r112;
    L49:
        r211.monitorInfo.put("cp_ui_has_stall_count", r123);     // Catch: Exception -> L56
        r211.monitorInfo.put("cp_ui_stall_count_avg", r122);     // Catch: Exception -> L56
        if (r121 == false) goto L58;
        JSONArray r124 = r211.monitorInfo.optJSONArray(DiagnoseResult.KEY_DIAGNOSE_TYPE);     // Catch: Exception -> L56
        JSONObject r125 = new JSONObject();     // Catch: Exception -> L56
        r125.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, DiagnoseResult.DIAGNOSE_TYPE_UI_STALL);     // Catch: Exception -> L56
        r125.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L56
        r124.put(r125);     // Catch: Exception -> L56
        JSONObject r126 = r211.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L56
        if (r126 != null) goto L54;
        r126 = new JSONObject();     // Catch: Exception -> L56
    L54:
        r126.put("fps_over_list", r104.toString());     // Catch: Exception -> L56
        r126.put("ui_stall_rate_over_list", r105.toString());     // Catch: Exception -> L56
        r211.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r126);     // Catch: Exception -> L56
        goto L58
    L44:
        if (r119 < r120.uiStallRate) goto L46;
        r121 = true;
        goto L47
    L48:
        r122 = 0.0d;
        r123 = 0;
        r121 = false;
        goto L49
    }
}
