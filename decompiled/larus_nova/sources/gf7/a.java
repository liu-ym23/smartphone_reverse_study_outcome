package gf7;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481068c;

    /* JADX INFO: renamed from: gf7.a$a, reason: collision with other inner class name */
    public class C6018a implements SDKMonitor.IGetExtendParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f481069a;

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            HashMap r100 = new HashMap();
            r100.put("host_aid", this.f481069a.f481066a);
            return r100;
        }

        public C6018a(a r100) {
            this.f481069a = r100;
        }
    }

    public a() {
        this.f481066a = "";
        this.f481067b = "";
        this.f481068c = "";
    }

    public final void b(String r100, int r101, String r102, int r103) {
        if (r101 == (-1)) goto L35;
        if (r101 != 0) goto L6;
        String r104 = "speech_sdk_init_engine";
    L37:
        if (r104.isEmpty() == false) goto L39;
        return;
    L39:
        JSONObject r105 = new JSONObject();
        r105.put(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, r100);     // Catch: JSONException -> L50
        r105.put("error_code", r103);     // Catch: JSONException -> L50
        r105.put("host_aid", this.f481066a);     // Catch: JSONException -> L50
        r105.put("timestamp", Long.toString(System.currentTimeMillis()));     // Catch: JSONException -> L50
        if (r102 != null) goto L47;
    L52:
        SDKMonitorUtils.getInstance("4060").monitorEvent(r104, r105, null, null);
        return;
    L47:
        if (r102.isEmpty() == true) goto L52;
        r105.put("directive_data", r102);     // Catch: JSONException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L6:
        if (r101 != 1000) goto L8;
        r104 = "speech_sdk_start_engine";
        goto L37
    L8:
        if (r101 != 1001) goto L10;
        r104 = "speech_sdk_stop_engine";
        goto L37
    L10:
        if (r101 != 1100) goto L12;
        r104 = "speech_sdk_finish_talking";
        goto L37
    L12:
        if (r101 != 1200) goto L14;
        r104 = "speech_sdk_trigger_wakeup";
        goto L37
    L14:
        if (r101 != 1400) goto L16;
        r104 = "speech_sdk_directive_synthesis";
        goto L37
    L16:
        if (r101 != 1202) goto L18;
        r104 = "speech_sdk_trigger_wakeup_query";
        goto L37
    L18:
        if (r101 == 1203) goto L27;
        switch(r101) {
            case 2010: goto L26;
            case 2011: goto L25;
            case 2012: goto L24;
            case 2013: goto L23;
            case 2014: goto L22;
            case 2015: goto L21;
            default: goto L20;
        };
    L20:
        r104 = "";
        goto L37
    L21:
        r104 = "speech_sdk_voiceclone_delete_data";
        goto L37
    L22:
        r104 = "speech_sdk_voiceclone_submit_task";
        goto L37
    L23:
        r104 = "speech_sdk_voiceclone_query_status";
        goto L37
    L24:
        r104 = "speech_sdk_voiceclone_record_voice";
        goto L37
    L25:
        r104 = "speech_sdk_voiceclone_check_env";
        goto L37
    L26:
        r104 = "speech_sdk_voiceclone_get_task";
        goto L37
    L27:
        r104 = "speech_sdk_update_wakeup_words_params";
        goto L37
    L35:
        r104 = "speech_sdk_destroy_engine";
        goto L37
    }

    public final void a(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        if (r106.isEmpty() == false) goto L5;
        return;
    L5:
        if (r107.isEmpty() == true) goto L19;
        SDKMonitorUtils.setConfigUrl("4060", Collections.singletonList(r106));
        SDKMonitorUtils.setDefaultReportUrl("4060", Collections.singletonList(r107));
        this.f481066a = r102;
        this.f481067b = r101;
        JSONObject r108 = new JSONObject();
        r108.put("device_id", this.f481067b);     // Catch: JSONException -> L12
        r108.put("host_aid", this.f481066a);     // Catch: JSONException -> L12
        r108.put("sdk_version", r103);     // Catch: JSONException -> L12
        r108.put("app_version", r104);     // Catch: JSONException -> L12
        r108.put("update_version_code", r105);     // Catch: JSONException -> L12
        r108.put("channel", r110);     // Catch: JSONException -> L12
    L14:
        SDKMonitorUtils.initMonitor(r100.getApplicationContext(), "4060", r108, new C6018a(this));
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
