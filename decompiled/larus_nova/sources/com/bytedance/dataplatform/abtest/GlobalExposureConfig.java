package com.bytedance.dataplatform.abtest;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.dataplatform.o;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.abtest.api.IGlobalExposureStarter;
import l38.a;

/* JADX INFO: loaded from: classes3.dex */
public class GlobalExposureConfig implements IGlobalExposureStarter {
    public GlobalExposureConfig() {
    }

    @Override // com.larus.abtest.api.IGlobalExposureStarter
    public final void a() {
        a r100 = (a) o.d("abtest_server_experiment", a.class, new a(false, 0, null, 31), false, true, null);     // Catch: Exception -> L5
    L117:
        Boolean r101 = (Boolean) o.d("exp_im_test_bool_key", Boolean.class, Boolean.FALSE, true, true, null);     // Catch: Exception -> L10
    L147:
        JsonObject r102 = (JsonObject) o.d("exp_im_test_dic_key", JsonObject.class, JsonParser.parseString(SliceInitService.DEFAULT_SWITCH).getAsJsonObject(), true, true, null);     // Catch: Exception -> L15
    L137:
        Double r103 = (Double) o.d("exp_im_test_double_key", Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), true, true, null);     // Catch: Exception -> L20
    L131:
        Integer r104 = (Integer) o.d("exp_im_test_int_key", Integer.class, 0, true, true, null);     // Catch: Exception -> L25
    L123:
        String r105 = (String) o.d("exp_im_test_string_key", String.class, "", true, true, null);     // Catch: Exception -> L30
    L139:
        Boolean r106 = (Boolean) o.d("exp_omni_test_bool_key", Boolean.class, Boolean.FALSE, true, true, null);     // Catch: Exception -> L35
    L127:
        JsonObject r107 = (JsonObject) o.d("exp_omni_test_dic_key", JsonObject.class, JsonParser.parseString(SliceInitService.DEFAULT_SWITCH).getAsJsonObject(), true, true, null);     // Catch: Exception -> L40
    L115:
        Double r108 = (Double) o.d("exp_omni_test_double_key", Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), true, true, null);     // Catch: Exception -> L45
    L151:
        Integer r109 = (Integer) o.d("exp_omni_test_int_key", Integer.class, 0, true, true, null);     // Catch: Exception -> L50
    L125:
        String r110 = (String) o.d("exp_omni_test_string_key", String.class, "", true, true, null);     // Catch: Exception -> L55
    L121:
        Boolean r111 = (Boolean) o.d("first_feed_message_list_opt", Boolean.class, Boolean.TRUE, false, true, null);     // Catch: Exception -> L60
    L149:
        JsonObject r112 = (JsonObject) o.d("flow_av_mmt_client_ab_label", JsonObject.class, JsonParser.parseString(SliceInitService.DEFAULT_SWITCH).getAsJsonObject(), true, true, null);     // Catch: Exception -> L65
    L135:
        JsonObject r113 = (JsonObject) o.d("flow_av_mmt_server_ab_label", JsonObject.class, JsonParser.parseString(SliceInitService.DEFAULT_SWITCH).getAsJsonObject(), true, true, null);     // Catch: Exception -> L70
    L143:
        JsonObject r114 = (JsonObject) o.d("flow_im_network_monitor_config", JsonObject.class, JsonParser.parseString(SliceInitService.DEFAULT_SWITCH).getAsJsonObject(), true, true, null);     // Catch: Exception -> L75
    L113:
        Boolean r115 = (Boolean) o.d("im_enable_sse_monitor", Boolean.class, Boolean.TRUE, true, true, null);     // Catch: Exception -> L80
    L153:
        Boolean r116 = (Boolean) o.d("message_receive_sdk_latency_opt", Boolean.class, Boolean.FALSE, true, true, null);     // Catch: Exception -> L85
    L141:
        Integer r117 = (Integer) o.d("mmt_pre_get_access_delay_ms", Integer.class, 10, true, true, null);     // Catch: Exception -> L90
    L133:
        Integer r118 = (Integer) o.d("mmt_transport_preload_delay_ms", Integer.class, -1, true, true, null);     // Catch: Exception -> L95
    L119:
        Integer r119 = (Integer) o.d("pc_completion_response_timeout_ms", Integer.class, 10000, true, true, null);     // Catch: Exception -> L100
    L155:
        String r120 = (String) o.d("voice_call_ab_sdk_test_did", String.class, "default", true, true, null);     // Catch: Exception -> L105
    L129:
        String r121 = (String) o.d("voice_call_ab_sdk_test_uid", String.class, "default", true, true, null);     // Catch: Exception -> L110
        return;
    L110:
        e = move-exception;
        e.printStackTrace();
        return;
    L105:
        e = move-exception;
        e.printStackTrace();
    L100:
        e = move-exception;
        e.printStackTrace();
    L95:
        e = move-exception;
        e.printStackTrace();
    L90:
        e = move-exception;
        e.printStackTrace();
    L85:
        e = move-exception;
        e.printStackTrace();
    L80:
        e = move-exception;
        e.printStackTrace();
    L75:
        e = move-exception;
        e.printStackTrace();
    L70:
        e = move-exception;
        e.printStackTrace();
    L65:
        e = move-exception;
        e.printStackTrace();
    L60:
        e = move-exception;
        e.printStackTrace();
    L55:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = move-exception;
        e.printStackTrace();
    L45:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = move-exception;
        e.printStackTrace();
    L35:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
    L25:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L117
    }
}
