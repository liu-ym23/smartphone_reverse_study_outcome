package kt1;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static boolean a(DiagnoseEngine r210, Map r211, DiagnoseResult r212) {
        String r100 = "cpu_rate";
        String r101 = IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE;
        v2 r102 = r210.f121946g;     // Catch: Exception -> L70
        if (r102 == null) goto L69;
        HashMap r103 = (HashMap) r211;     // Catch: Exception -> L70
        if ((r103.get("performanceData") instanceof LinkedList) == false) goto L69;
        LinkedList r104 = (LinkedList) r103.get("performanceData");     // Catch: Exception -> L70
        if (r104 == null) goto L69;
        if (r104.size() <= 0) goto L69;
        boolean r105 = c.b().f506005b;     // Catch: Exception -> L70
        int r106 = r104.size();     // Catch: Exception -> L70
        if (r105 == false) goto L14;
        double r110 = r102.cpuRateAnchor;     // Catch: Exception -> L70
    L15:
        if (r105 == false) goto L17;
        double r107 = r102.gpuAnchor;     // Catch: Exception -> L70
    L18:
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r114 = new StringBuilder();     // Catch: Exception -> L70
        Iterator r108 = r104.iterator();     // Catch: Exception -> L70
        double r115 = 0.0d;
        double r213 = 0.0d;
        int r109 = 0;
        int r116 = 0;
    L19:
        if (r108.hasNext() == false) goto L49;
        Iterator r214 = r108;
        JSONObject r117 = (JSONObject) r108.next();     // Catch: Exception -> L70
        if ((r117.opt(r101) instanceof Map) == false) goto L46;
        Map r118 = (Map) r117.opt(r101);     // Catch: Exception -> L70
        if (r118.isEmpty() == true) goto L46;
        String r215 = r101;
        if (TextUtils.isEmpty((CharSequence) r118.get(r100)) == true) goto L36;
        String r216 = r100;
        int r217 = r109;
        double r119 = CastDoubleProtector.parseDouble((String) r118.get(r100));     // Catch: Exception -> L70
        if (r119 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
    L33:
        r115 = r115 + r119;     // Catch: Exception -> L70
        if (r119 <= r110) goto L38;
        r116 = r116 + 1;     // Catch: Exception -> L70
        r111.append(r119);     // Catch: Exception -> L70
        r111.append("#");     // Catch: Exception -> L70
    L38:
        if (TextUtils.isEmpty((CharSequence) r118.get(IPerformanceManager.GPU.gpu_usage)) == true) goto L47;
        double r120 = CastDoubleProtector.parseDouble((String) r118.get(IPerformanceManager.GPU.gpu_usage));     // Catch: Exception -> L70
        if (r120 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L42;
        r114.append(r120);     // Catch: Exception -> L70
        r114.append("#");     // Catch: Exception -> L70
        r120 = 0.0d;
    L42:
        r213 = r213 + r120;     // Catch: Exception -> L70
        if (r120 <= r107) goto L47;
        int r121 = r217 + 1;     // Catch: Exception -> L70
        r113.append(r120);     // Catch: Exception -> L70
        r113.append("#");     // Catch: Exception -> L70
        r109 = r121;
    L48:
        r108 = r214;
        r101 = r215;
        r100 = r216;
    L47:
        r109 = r217;
        goto L48
    L31:
        if (r119 <= 1.0d) goto L33;
        r112.append(r119);     // Catch: Exception -> L70
        r112.append("#");     // Catch: Exception -> L70
        r119 = 0.0d;
        goto L33
    L36:
        r216 = r100;
        r217 = r109;
    L46:
        r216 = r100;
        r217 = r109;
        r215 = r101;
        goto L47
    L49:
        int r218 = r109;
        if (r106 <= 0) goto L52;
        double r122 = r106;
        r115 = r115 / r122;
        r213 = r213 / r122;
    L52:
        double r123 = r115;
        double r124 = r213;
        if (r123 <= r110) goto L55;
    L58:
        boolean r125 = true;
        DiagnoseResult r126 = r212;
        JSONObject r127 = r126.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L67
        if (r127 != null) goto L62;
        r127 = new JSONObject();     // Catch: Exception -> L67
    L62:
        r127.put("cpu_rate_over_list", r111.toString());     // Catch: Exception -> L67
        r127.put("cpu_rate_error_list", r112.toString());     // Catch: Exception -> L67
        r127.put("gpu_over_list", r113.toString());     // Catch: Exception -> L67
        r127.put("gpu_error_list", r114.toString());     // Catch: Exception -> L67
        r126.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r127);     // Catch: Exception -> L67
    L78:
        r126.monitorInfo.put("cp_cpu_rate_over_count", r116);     // Catch: Exception -> L65
        r126.monitorInfo.put("cp_cpu_rate_avg", r123);     // Catch: Exception -> L65
        r126.monitorInfo.put("cp_gpu_over_count", r218);     // Catch: Exception -> L65
        r126.monitorInfo.put("cp_gpu_usage_avg", r124);     // Catch: Exception -> L65
        return r125;
    L65:
        e = e;
        boolean r128 = r125;
    L72:
        e.printStackTrace();
        return r128;
    L67:
        e = e;
        r128 = true;
        goto L72
    L55:
        if (r124 > r107) goto L58;
        r126 = r212;
        r125 = false;
        goto L78
    L17:
        r107 = r102.gpu;     // Catch: Exception -> L70
        goto L18
    L14:
        r110 = r102.cpuRate;     // Catch: Exception -> L70
    L69:
        return false;
    L70:
        e = e;
        r128 = false;
        goto L72
    }
}
