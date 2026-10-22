package kt1;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements e {
    public i() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r310, DiagnoseResult r410) {
        String r100 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r101 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        String r102 = IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE;
    L113:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L115:
        return r410;
    L4:
        if (c.b().f506004a == false) goto L115;
        v2 r103 = r310.f121946g;     // Catch: Exception -> L113
        if (r103 == null) goto L115;
        v2.b r104 = r103.diagnoseTypeStreamStall;     // Catch: Exception -> L113
        if (r104 == null) goto L115;
        if (r104.enable == false) goto L115;
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L113
        String r110 = "cs_preview_fps_avg";
        String r111 = "cs_preview_fps_count";
        boolean r112 = true;
        boolean r113 = false;
        if (c.b().f506005b == true) goto L15;
        String r210 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r311 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        StringBuilder r211 = r107;
        StringBuilder r212 = r108;
        String r114 = "cs_preview_fps_count";
        if (r310.f121942c.isEmpty() == true) goto L60;
        double r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r115 = 0;
        int r116 = 0;
    L46:
        if (r115 >= r310.f121942c.size()) goto L61;
        JSONObject r117 = r310.f121942c.get(r115);     // Catch: Exception -> L113
        if (r117 == null) goto L59;
        if (r117.length() <= 0) goto L59;
        String r118 = r117.optString(LiveCommonConstants.LOG_PARAM_EVENT_KEY);     // Catch: Exception -> L113
        if (TextUtils.equals(r118, "render_stall") == false) goto L55;
        r116 = r116 + 1;     // Catch: Exception -> L113
        r109 = r109 + 1.0d;     // Catch: Exception -> L113
        goto L59
    L55:
        if (TextUtils.equals(r118, "demux_stall") == false) goto L57;
    L58:
        r116 = r116 + 1;     // Catch: Exception -> L113
        goto L59
    L57:
        if (TextUtils.equals(r118, "stall") == true) goto L58;
    L59:
        r115 = r115 + 1;     // Catch: Exception -> L113
    L61:
        double r213 = r109;
        if (r310.f121940a.isEmpty() == true) goto L100;
        int r119 = 0;
        int r120 = 0;
        double r121 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r214 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r215 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r216 = 0;
    L65:
        if (r119 >= r310.f121940a.size()) goto L96;
        JSONObject r122 = r310.f121940a.get(r119);     // Catch: Exception -> L113
        if ((r122.get(r102) instanceof Map) == false) goto L94;
        Map r123 = (Map) r122.get(r102);     // Catch: Exception -> L113
        String r124 = (String) r123.get(IPerformanceManager.Stream.stream_preview_fps);     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r124) == false) goto L71;
        double r125 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r312 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L73:
        if (r312 > r125) goto L75;
        double r126 = r103.diagnoseTypeStreamStall.previewFps;     // Catch: Exception -> L113
    L76:
        double r127 = r121 + r126;     // Catch: Exception -> L113
        if (r126 >= r103.diagnoseTypeStreamStall.previewFps) goto L79;
        r120 = r120 + 1;     // Catch: Exception -> L113
        r105.append(r126);     // Catch: Exception -> L113
        r105.append("#");     // Catch: Exception -> L113
    L79:
        String r128 = (String) r123.get(IPerformanceManager.Stream.stream_real_fps);     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r128) == false) goto L82;
        double r129 = r125;
    L83:
        r214 = r214 + r129;     // Catch: Exception -> L113
        if (r129 >= r103.diagnoseTypeStreamStall.renderFps) goto L86;
        r216 = r216 + 1;     // Catch: Exception -> L113
        r106.append(r129);     // Catch: Exception -> L113
        r106.append("#");     // Catch: Exception -> L113
    L86:
        String r130 = (String) r123.get(IPerformanceManager.Stall.stall_video_rate);     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r130) == false) goto L89;
        double r131 = r125;
    L90:
        r215 = r215 + r131;     // Catch: Exception -> L113
        int r313 = r120;
        if (r131 <= r103.diagnoseTypeStreamStall.renderStallRate) goto L93;
        r106.append(r129);     // Catch: Exception -> L113
        r106.append("#");     // Catch: Exception -> L113
    L93:
        r121 = r127;
        r120 = r313;
    L95:
        r119 = r119 + 1;     // Catch: Exception -> L113
        r102 = r102;
        r114 = r114;
        goto L65
    L89:
        r131 = CastDoubleProtector.parseDouble(r130);     // Catch: Exception -> L113
        goto L90
    L82:
        r129 = CastDoubleProtector.parseDouble(r128);     // Catch: Exception -> L113
        goto L83
    L75:
        r126 = r312;
        goto L76
    L71:
        r312 = CastDoubleProtector.parseDouble(r124);     // Catch: Exception -> L113
        r125 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L73
    L94:
        r102 = r102;
        goto L95
    L96:
        String r314 = r114;
        if (r310.f121940a.isEmpty() == true) goto L99;
        double r132 = r310.f121940a.size();     // Catch: Exception -> L113
        double r133 = r121 / r132;     // Catch: Exception -> L113
        double r134 = r214 / r132;     // Catch: Exception -> L113
        double r135 = r215 / r132;     // Catch: Exception -> L113
        double r136 = r134;
        int r137 = r216;
        double r138 = r133;
        double r139 = r135;
    L101:
        if (r116 > 0) goto L103;
    L105:
        r112 = false;
    L106:
        r410.monitorInfo.put(r314, r120);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_preview_fps_avg", r138);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_render_stall_count_avg", r213);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_render_fps_count", r137);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_render_fps_avg", r136);     // Catch: Exception -> L113
        r113 = r112;
    L107:
        if (r113 == false) goto L115;
        String r140 = r311;
        JSONArray r141 = r410.monitorInfo.optJSONArray(r140);     // Catch: Exception -> L113
        JSONObject r142 = new JSONObject();     // Catch: Exception -> L113
        r142.put(r140, DiagnoseResult.DIAGNOSE_TYPE_STREAM_STALL);     // Catch: Exception -> L113
        r142.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L113
        r141.put(r142);     // Catch: Exception -> L113
        String r143 = r210;
        JSONObject r144 = r410.monitorInfo.optJSONObject(r143);     // Catch: Exception -> L113
        if (r144 != null) goto L111;
        r144 = new JSONObject();     // Catch: Exception -> L113
    L111:
        r144.put("preview_fps_over_list", r105.toString());     // Catch: Exception -> L113
        r144.put("real_fps_over_list", r106.toString());     // Catch: Exception -> L113
        r144.put("render_fps_over_list", r211.toString());     // Catch: Exception -> L113
        r144.put("video_stall_rate_over_list", r212.toString());     // Catch: Exception -> L113
        r410.monitorInfo.put(r143, r144);     // Catch: Exception -> L113
        goto L115
    L103:
        if (r139 <= r103.diagnoseTypeStreamStall.renderStallRate) goto L105;
    L99:
        r138 = r121;
        r136 = r214;
        r139 = r215;
        r137 = r216;
        goto L101
    L100:
        r314 = r114;
        r138 = 0.0d;
        r136 = 0.0d;
        r139 = 0.0d;
        r137 = 0;
        r120 = 0;
        goto L101
    L60:
        r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        r116 = 0;
        goto L61
    L15:
        if (r310.f121941b.isEmpty() == true) goto L40;
        int r145 = 0;
        int r146 = 0;
        double r217 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r218 = 60.0d;
        int r219 = 0;
    L18:
        if (r145 >= r310.f121941b.size()) goto L31;
        JSONObject r147 = r310.f121941b.get(r145);     // Catch: Exception -> L113
        if (r147 != null) goto L22;
    L29:
        String r220 = r100;
        String r315 = r101;
        StringBuilder r221 = r107;
        StringBuilder r222 = r108;
        String r148 = r110;
        String r149 = r111;
    L30:
        r145 = r145 + 1;     // Catch: Exception -> L113
        r110 = r148;
        r111 = r149;
        r107 = r221;
        r108 = r222;
        r100 = r220;
        r101 = r315;
        goto L18
    L22:
        if (r147.length() <= 0) goto L29;
        r220 = r100;
        r315 = r101;
        r221 = r107;
        r222 = r108;
        double r150 = r147.optDouble(IPerformanceStrategyManager.KEY_DOUBLE_PREVIEW_FPS, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L113
        r217 = r217 + r150;     // Catch: Exception -> L113
        if (r150 >= r103.diagnoseTypeStreamStall.previewFps) goto L26;
        r146 = r146 + 1;     // Catch: Exception -> L113
        r105.append(r150);     // Catch: Exception -> L113
        r105.append("#");     // Catch: Exception -> L113
    L26:
        r148 = r110;
        r149 = r111;
        double r223 = r147.optDouble("avg_fps", 60.0d);     // Catch: Exception -> L113
        r218 = r218 + r223;     // Catch: Exception -> L113
        if (r223 >= r103.diagnoseTypeStreamStall.realFps) goto L30;
        r219 = r219 + 1;     // Catch: Exception -> L113
        r106.append(r150);     // Catch: Exception -> L113
        r106.append("#");     // Catch: Exception -> L113
        goto L30
    L31:
        r210 = r100;
        r311 = r101;
        r211 = r107;
        r212 = r108;
        String r151 = r110;
        String r152 = r111;
        if (r310.f121941b.isEmpty() == true) goto L35;
        r217 = r217 / ((double) r310.f121941b.size());     // Catch: Exception -> L113
        r218 = r218 / ((double) r310.f121941b.size());     // Catch: Exception -> L113
    L35:
        if (r217 >= r103.diagnoseTypeStreamStall.previewFps) goto L38;
        if (r146 <= 0) goto L38;
    L39:
        r113 = r112;
        double r153 = r217;
        double r154 = r218;
        int r155 = r219;
    L41:
        r410.monitorInfo.put(r152, r146);     // Catch: Exception -> L113
        r410.monitorInfo.put(r151, r153);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_real_fps_count", r155);     // Catch: Exception -> L113
        r410.monitorInfo.put("cs_real_fps_avg", r154);     // Catch: Exception -> L113
        r106 = r106;
    L38:
        r112 = false;
        goto L39
    L40:
        r210 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        r311 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        r211 = r107;
        r212 = r108;
        r151 = "cs_preview_fps_avg";
        r152 = "cs_preview_fps_count";
        r155 = 0;
        r153 = AudioStats.AUDIO_AMPLITUDE_NONE;
        r154 = 60.0d;
        r146 = 0;
        goto L41
    }
}
