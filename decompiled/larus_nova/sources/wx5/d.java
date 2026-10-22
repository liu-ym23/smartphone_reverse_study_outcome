package wx5;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f561833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f561834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double f561835c = 0.0d;

    static {
        HashSet r100 = new HashSet();
        f561834b = r100;
        f561835c = 1.0E-9d;
        r100.add("ttnet_high_lvl_conn");
        r100.add("multinetwork");
        r100.add("mpa_client");
        r100.add("ttnet_feedback_detect");
        r100.add("ttnet_exception_detect");
        r100.add("ttnet_stress_detect");
        r100.add("ttnet_polling_detect");
        r100.add("long_cost_net_task");
        r100.add("ws_all");
        r100.add("frontier_all");
        r100.add("frontier_msg");
        r100.add("user_msg");
        r100.add(CronetDataStorageAccess.STORE_IDC);
        r100.add("ttnet_route_select");
        r100.add("ws_ping");
        r100.add("frontier_online");
        r100.add("ttnet_all_log");
        r100.add("cookie_mismatch");
        r100.add("cronet_native_requestlog");
        r100.add("ttnet_debug_trace_info");
        r100.add("ttnet_http_dns_fail");
        r100.add("ttnet_tnc_update_result");
        r100.add("cronet_native_requestlog_empty");
        r100.add("frontier_qos");
        r100.add("ttnet_net_exp");
        r100.add("bad_request_diagnosis");
        r100.add("ttnet_raw_detect");
        r100.add("gna_raw_detect");
        r100.add("ttnet_network_environment");
        r100.add("game_network");
        r100.add("ttnet_zstd_stream");
        r100.add("ttnet_zstd_dict_error");
        r100.add("ttnet_load");
        r100.add("ttnet_insec_rect");
        r100.add("ttquiche_native_request_log");
        r100.add("otel_log");
    }

    public static c a(JSONObject r210, int r211) {
        if (r211 <= 0) goto L97;
        if (r210 == null) goto L97;
        JSONObject r100 = r210.optJSONObject("network_image_modules");     // Catch: Exception -> L103
        JSONObject r101 = r210.optJSONObject("custom_event_settings");     // Catch: Exception -> L103
        if (r100 == null) goto L9;
        r100 = r100.optJSONObject("network");     // Catch: Exception -> L103
    L9:
        if (r100 != null) goto L11;
    L12:
        if (r101 != null) goto L14;
        return null;
    L14:
        if (r101.length() <= 0) goto L112;
    L17:
        if (r100 == null) goto L69;
        JSONObject r102 = r100.optJSONObject("api_allow_list");     // Catch: Exception -> L103
        if (r102 != null) goto L21;
    L24:
        boolean r103 = true;
    L25:
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_path_equal", r104);     // Catch: Exception -> L103
        if (r104.isEmpty() == true) goto L28;
        boolean r105 = true;
    L29:
        boolean r106 = r105 | false;     // Catch: Exception -> L103
        ArrayList r110 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_path_prefix", r110);     // Catch: Exception -> L103
        if (r110.isEmpty() == true) goto L32;
        boolean r111 = true;
    L33:
        boolean r107 = r106 | r111;     // Catch: Exception -> L103
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_path_contain", r112);     // Catch: Exception -> L103
        if (r112.isEmpty() == true) goto L36;
        boolean r113 = true;
    L37:
        boolean r108 = r107 | r113;     // Catch: Exception -> L103
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_path_regexp", r114);     // Catch: Exception -> L103
        if (r114.isEmpty() == true) goto L40;
        boolean r115 = true;
    L41:
        boolean r109 = r108 | r115;     // Catch: Exception -> L103
        ArrayList r116 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_host_pattern", r116);     // Catch: Exception -> L103
        if (r116.isEmpty() == true) goto L44;
        boolean r117 = true;
    L45:
        boolean r118 = r109 | r117;     // Catch: Exception -> L103
        ArrayList r119 = new ArrayList();     // Catch: Exception -> L103
        b(r100, "api_allow_list_url_regexp", r119);     // Catch: Exception -> L103
        boolean r120 = r118 | (!r119.isEmpty());     // Catch: Exception -> L103
        if (r103 == true) goto L48;
        if (r120 == false) goto L69;
    L48:
        ArrayList r121 = new ArrayList();     // Catch: Exception -> L103
        if (TextUtils.isEmpty("api_block_list") == true) goto L61;
        JSONArray r122 = r100.optJSONArray("api_block_list");     // Catch: Exception -> L103
        if (r122 == null) goto L61;
        int r123 = 0;
    L55:
        if (r123 >= r122.length()) goto L61;
        String r124 = r122.optString(r123);     // Catch: Exception -> L103
        if (TextUtils.isEmpty(r124) == true) goto L59;
        r121.add(r124);     // Catch: Exception -> L103
    L59:
        r123 = r123 + 1;     // Catch: Exception -> L103
    L61:
        if (Math.abs(r100.optDouble("enable_base_api_all")) <= f561835c) goto L63;
        boolean r125 = true;
    L65:
        if (r100.optInt("enable_api_all_upload") != 1) goto L67;
        boolean r126 = true;
    L68:
        b r127 = new b(r125, r126, (String[]) r121.toArray(new String[0]), (String[]) r104.toArray(new String[0]), (String[]) r112.toArray(new String[0]), (String[]) r110.toArray(new String[0]), (String[]) r114.toArray(new String[0]), (String[]) r119.toArray(new String[0]), (String[]) r116.toArray(new String[0]));     // Catch: Exception -> L103
    L70:
        ArrayList r128 = new ArrayList();     // Catch: Exception -> L103
        if (r101 != null) goto L73;
    L75:
        a r129 = null;
    L76:
        if (r127 != null) goto L83;
        if (r129 != null) goto L83;
        if (Logger.debug() == false) goto L110;
        Logger.d("SlaSamplingSCreator", "create slaSamplingSetting failed, api and event rule is null");     // Catch: Exception -> L103
        return null;
    L110:
        return null;
    L83:
        c r130 = new c(r211, r127, r129);     // Catch: Exception -> L103
        c r131 = f561833a;     // Catch: Exception -> L103
        if (r131 != null) goto L86;
    L92:
        f561833a = r130;     // Catch: Exception -> L103
        return r130;
    L86:
        if (r131.equals(r130) == false) goto L92;
        if (Logger.debug() == false) goto L111;
        Logger.d("SlaSamplingSCreator", "slaSamplingSetting same");     // Catch: Exception -> L103
        return null;
    L111:
        return null;
    L73:
        if (b(r101, "allow_log_type", r128) == false) goto L75;
        r128.retainAll(f561834b);     // Catch: Exception -> L103
        r129 = new a((String[]) r128.toArray(new String[0]));     // Catch: Exception -> L103
        goto L76
    L67:
        r126 = false;
        goto L68
    L63:
        r125 = false;
        goto L65
    L44:
        r117 = false;
        goto L45
    L40:
        r115 = false;
        goto L41
    L36:
        r113 = false;
        goto L37
    L32:
        r111 = false;
        goto L33
    L28:
        r105 = false;
        goto L29
    L21:
        if (r102.length() == 0) goto L24;
        r103 = false;
    L69:
        r127 = null;
        goto L70
    L112:
        return null;
    L11:
        if (r100.length() > 0) goto L17;
    L97:
        if (r210 != null) goto L99;
        String r132 = "jsonObject is null";
    L100:
        Logger.e("SlaSamplingSCreator", "create slaSamplingSetting failed, ".concat(r132));     // Catch: Exception -> L103
        return null;
    L99:
        r132 = "appId is invalid";
    L103:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean b(JSONObject r100, String r101, List<String> r102) {
        if (TextUtils.isEmpty(r101) == true) goto L15;
        JSONObject r103 = r100.optJSONObject(r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        Iterator<String> r104 = r103.keys();
    L9:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L9;
        ((ArrayList) r102).add(r105);
        goto L9
    L13:
        return true;
    L15:
        return false;
    }
}
