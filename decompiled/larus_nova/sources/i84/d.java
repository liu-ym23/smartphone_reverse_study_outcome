package i84;

import android.text.TextUtils;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.o0;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f488617b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, l74.c>> f488618a;

    public static d b() {
        if (f488617b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f488617b != null) goto L9;
        f488617b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f488617b;
    }

    public d() {
        this.f488618a = new ConcurrentHashMap();
    }

    public final z74.a a(int r100) {
        Map<String, Map<String, l74.c>> r101 = this.f488618a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Map r103 = (Map) r102.get(String.valueOf(r100));
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
        Map<String, Map<String, l74.c>> r104 = this.f488618a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(String.valueOf(r100), r103);
    L5:
        z74.a r106 = (z74.a) r103.get("activate");
        if (r106 != null) goto L9;
        z74.a r107 = new z74.a();
        r103.put("activate", r107);
        return r107;
    L9:
        return r106;
    }

    public final z74.b c(int r100) {
        Map<String, Map<String, l74.c>> r101 = this.f488618a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Map r103 = (Map) r102.get(String.valueOf(r100));
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
        Map<String, Map<String, l74.c>> r104 = this.f488618a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(String.valueOf(r100), r103);
    L5:
        z74.b r106 = (z74.b) r103.get("params");
        if (r106 != null) goto L9;
        z74.b r107 = new z74.b();
        r103.put("params", r107);
        return r107;
    L9:
        return r106;
    }

    public final z74.c d(int r100) {
        Map<String, Map<String, l74.c>> r101 = this.f488618a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Map r103 = (Map) r102.get(String.valueOf(r100));
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
        Map<String, Map<String, l74.c>> r104 = this.f488618a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(String.valueOf(r100), r103);
    L5:
        z74.c r106 = (z74.c) r103.get(MiPushClient.COMMAND_REGISTER);
        if (r106 != null) goto L9;
        z74.c r107 = new z74.c();
        r103.put(MiPushClient.COMMAND_REGISTER, r107);
        return r107;
    L9:
        return r106;
    }

    public static void e(o0 r100, JSONObject r101, JSONObject r102) {
        JSONObject r103 = new JSONObject();
        if (TextUtils.isEmpty(r102.optString("device_id_str")) == true) goto L5;
        boolean r104 = true;
    L6:
        JSONObject r105 = r101.optJSONObject("oaid");
        String r106 = null;
        if (r105 == null) goto L9;
        e84.n r107 = e84.n.a(r105.toString());
    L10:
        boolean r108 = TextUtils.isEmpty(r101.optString("install_id"));
        boolean r109 = TextUtils.isEmpty(r101.optString("device_id"));
        r103.put("reqeust_did_success", r104);     // Catch: JSONException -> L21
        r103.put("empty_iid", r108);     // Catch: JSONException -> L21
        r103.put("empty_did", r109);     // Catch: JSONException -> L21
        if (r107 != null) goto L14;
        String r110 = null;
    L15:
        r103.put("dr_oaid", r110);     // Catch: JSONException -> L21
        r103.put("oaid_thread_switch_ts", e84.o.f471333b - e84.o.f471332a);     // Catch: JSONException -> L21
        r103.put("oaid_file_load_ts", e84.o.f471334c - e84.o.f471333b);     // Catch: JSONException -> L21
        r103.put("oaid_sys_call_ts", e84.o.f471335d - e84.o.f471334c);     // Catch: JSONException -> L21
        r103.put("oaid_save_ts", e84.o.f471336e - e84.o.f471335d);     // Catch: JSONException -> L21
        r103.put("dr_wait_oaid_realtime", e84.o.f471338g - e84.o.f471337f);     // Catch: JSONException -> L21
        r103.put("dr_wait_oaid_estimate_time", e84.o.f471338g - e84.o.f471337f);     // Catch: JSONException -> L21
        r103.put("support_oaid", r101.optBoolean("oaid_may_support"));     // Catch: JSONException -> L21
        e84.m r111 = e84.k.e(r100.getContext()).f471311a;     // Catch: JSONException -> L21
        if (r111 == null) goto L19;
        r106 = r111.getName();     // Catch: JSONException -> L21
    L19:
        r103.put("oaid_impl", r106);     // Catch: JSONException -> L21
    L23:
        if (r100 == null) goto L27;
        c0 r112 = r100.E;
        if (r112 == null) goto L27;
        ((nw3.c) r112).a("did_fetch_result", r103);
    L27:
        com.bytedance.bdinstall.t.a("did_fetch_result, " + r103);
        return;
    L14:
        r110 = r107.f471325a;     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }
}
