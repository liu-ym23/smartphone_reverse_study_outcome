package zlb;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f572822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f572823d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends Map<String, String>> f572824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572825b;

    /* JADX INFO: renamed from: zlb.a$a, reason: collision with other inner class name */
    public static final class C8475a {
        public static void d(ScenarioType r100) {
            Intrinsics.checkNotNullParameter(r100, "scenario");
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
            r101.put("product_type", r100.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L8
            if (a.f572822c == 0) goto L6;
            r101.put(ChameleonOpenTracker.ParamKey.COST, System.currentTimeMillis() - a.f572822c);     // Catch: Exception -> L8
        L6:
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_ui_show_dev", r101);     // Catch: Exception -> L8
            a.f572822c = 0;     // Catch: Exception -> L8
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_ui_show_dev, params = " + r101);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void e(Integer r100, String r101, int r102) {
            JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
            r103.put("errCode", r100);     // Catch: Exception -> L5
            r103.put("errReason", r101);     // Catch: Exception -> L5
            r103.put(ChameleonOpenTracker.ParamKey.COST, r102);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("inlineai_performance_webview_load_fail_dev", r103);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = inlineai_performance_webview_load_fail_dev, params = " + r103);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void a(ScenarioType r100, int r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "scenario");
            Intrinsics.checkNotNullParameter(r102, "message");
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L5
            r104.put("product_type", r100.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r104.put("code", r101);     // Catch: Exception -> L5
            r104.put("message", r102);     // Catch: Exception -> L5
            r104.put(ChameleonOpenTracker.ParamKey.COST, r103);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_get_prompt_dev", r104);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_get_prompt_dev, params = " + r104);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void c(ScenarioType r100, int r101, String r102, int r103, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "scenario");
            Intrinsics.checkNotNullParameter(r102, "message");
            Intrinsics.checkNotNullParameter(r110, "promptId");
            Intrinsics.checkNotNullParameter(r111, "promptType");
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L5
            r104.put("product_type", r100.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r104.put("code", r101);     // Catch: Exception -> L5
            r104.put("message", r102);     // Catch: Exception -> L5
            r104.put(ChameleonOpenTracker.ParamKey.COST, r103);     // Catch: Exception -> L5
            r104.put("prompt_id", r110);     // Catch: Exception -> L5
            r104.put("prompt_type", r111);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_send_prompt_dev", r104);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_send_prompt_dev, params = " + r104);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void b(ScenarioType r100, String r101, String r102, int r103, String r104, int r110, int r111, int r112, int r113, int r114, int r115) {
            Intrinsics.checkNotNullParameter(r100, "scenario");
            Intrinsics.checkNotNullParameter(r101, "promptId");
            Intrinsics.checkNotNullParameter(r102, "promptType");
            Intrinsics.checkNotNullParameter(r104, "taskStatus");
            JSONObject r105 = new JSONObject();     // Catch: Exception -> L5
            r105.put("product_type", r100.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r105.put("prompt_id", r101);     // Catch: Exception -> L5
            r105.put("prompt_type", r102);     // Catch: Exception -> L5
            r105.put("status_code", r103);     // Catch: Exception -> L5
            r105.put("task_status", r104);     // Catch: Exception -> L5
            r105.put("first_push_cost", r110);     // Catch: Exception -> L5
            r105.put("push_cost", r111);     // Catch: Exception -> L5
            r105.put("total_cost", r112);     // Catch: Exception -> L5
            r105.put("content_length", r113);     // Catch: Exception -> L5
            r105.put("push_times", r114);     // Catch: Exception -> L5
            r105.put("waiting_time_before_cancel", r115);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_push_dev", r105);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_push_dev, params = " + r105);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }
    }

    static {
    }

    public final JSONObject a() throws JSONException {
        JSONObject r100 = new JSONObject();
        Function0<? extends Map<String, String>> r101 = this.f572824a;
        if (r101 == null) goto L10;
        Map<String, String> r102 = r101.invoke();
        if (r102 == null) goto L10;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, String> r104 = r103.next();
        r100.put(r104.getKey(), r104.getValue());
    L10:
        r100.put("product_type", this.f572825b);
        return r100;
    }

    public final void b() {
        JSONObject r100 = a();     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_floating_window_view", r100);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_floating_window_view, params = " + r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public a(ScenarioType r100) {
        Intrinsics.checkNotNullParameter(r100, "scenario");
        this.f572825b = r100.name().toLowerCase(Locale.ROOT);
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commandType");
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        JSONObject r102 = a();     // Catch: Exception -> L5
        r102.put("click", "button");     // Catch: Exception -> L5
        r102.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
        r102.put("command_type", r100);     // Catch: Exception -> L5
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_doc_ai_quit_double_check_click", r102);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_doc_ai_quit_double_check_click, params = " + r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commandType");
        Intrinsics.checkNotNullParameter(r101, "pathType");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        JSONObject r103 = a();     // Catch: Exception -> L5
        r103.put("click", "command");     // Catch: Exception -> L5
        r103.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
        r103.put("click_type", "click");     // Catch: Exception -> L5
        r103.put("command_type", r100);     // Catch: Exception -> L5
        r103.put("path_type", r101);     // Catch: Exception -> L5
        r103.put(com.heytap.mcssdk.constant.b.f276354d, r102);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_quick_command_click", r103);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_quick_command_click, params = " + r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "quiteType");
        Intrinsics.checkNotNullParameter(r101, "status");
        JSONObject r103 = a();     // Catch: Exception -> L5
        r103.put("click", "quit");     // Catch: Exception -> L5
        r103.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
        r103.put("quite_type", r100);     // Catch: Exception -> L5
        r103.put("status", r101);     // Catch: Exception -> L5
        r103.put("command_type", r102);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_quit_floating_window_click", r103);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_quit_floating_window_click, params = " + r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "commandType");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        JSONObject r103 = a();     // Catch: Exception -> L5
        r103.put("click", "action");     // Catch: Exception -> L5
        r103.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
        r103.put("action_type", r100);     // Catch: Exception -> L5
        r103.put("command_type", r101);     // Catch: Exception -> L5
        r103.put("action_time_type", "after_output");     // Catch: Exception -> L5
        r103.put(com.heytap.mcssdk.constant.b.f276354d, r102);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_result_action_click", r103);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_result_action_click, params = " + r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }
}
