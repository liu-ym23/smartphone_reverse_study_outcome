package r07;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f535487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f535488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f535489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f535490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f535491e;

    public final void d() {
        if (((ConcurrentHashMap) this.f535487a).size() > 2) goto L5;
        return;
    L5:
        if (this.f535488b > 0) goto L7;
        return;
    L7:
        if (((ConcurrentHashMap) this.f535487a).containsKey("scc_report_reason") == false) goto L12;
        long r100 = SystemClock.uptimeMillis() - this.f535488b;
        ((ConcurrentHashMap) this.f535487a).put("scc_total_cost", r100 + "");
        n07.b.b("ttwebview_scc", new HashMap(this.f535487a));
        return;
    }

    public c() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        this.f535487a = r100;
        r100.put("scc_mode", "coreless");
        r100.put("scc_version", "1");
        this.f535488b = 0;
        this.f535489c = 0;
        this.f535490d = 0;
        this.f535491e = 0;
    }

    public final void b() {
        this.f535489c = SystemClock.uptimeMillis();
        ((ConcurrentHashMap) this.f535487a).put("scc_report_reason", "scc_cloudservice");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_check_delta", "-1");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_label", "error");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_backend_code", "-1");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_ttnet_code", "-1");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_user_wait_time", "-1");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_result_apply", "0");
    }

    public final void c(boolean r100, String r101) {
        long r102 = SystemClock.uptimeMillis() - this.f535490d;
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_user_wait_time", r102 + "");
        Map<String, String> r103 = this.f535487a;
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        ((ConcurrentHashMap) r103).put("scc_cloudservice_result_apply", r104);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        String r105 = (String) ((ConcurrentHashMap) this.f535487a).get("scc_cloudservice_result");
        if (TextUtils.isEmpty(r105) == true) goto L13;
        JSONObject r106 = new JSONObject(r105);     // Catch: JSONException -> L12
        r106.put("error", r101);     // Catch: JSONException -> L12
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_result", r106.toString());     // Catch: JSONException -> L12
    L13:
        d();
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public final void a(int r100, int r101, String r102, String r103, JSONObject r104) {
        long r105 = SystemClock.uptimeMillis() - this.f535489c;
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_check_delta", r105 + "");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_ttnet_code", r100 + "");
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_backend_code", r101 + "");
        if (TextUtils.isEmpty(r102) == true) goto L6;
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_label", r102);
    L6:
        if (r104 != null) goto L8;
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_result", SliceInitService.DEFAULT_SWITCH);
        return;
    L8:
        if (TextUtils.isEmpty(r103) == false) goto L16;
    L13:
        ((ConcurrentHashMap) this.f535487a).put("scc_cloudservice_result", r104.toString());
        return;
    L16:
        r104.put("scc_logid", r103);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.toString();
        goto L13
    }
}
