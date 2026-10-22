package ih4;

import com.bytedance.crash.util.j;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static void b(JSONObject r210) {
        JSONArray r100 = r210.optJSONArray("history_message");
        JSONObject r101 = r210.optJSONObject("current_message");
        JSONObject r102 = r210.optJSONObject("history_details");
        String r103 = "block_stack";
        JSONArray r104 = r210.optJSONArray("block_stack");
        if (r102 != null) goto L6;
        JSONObject r105 = new JSONObject();
        j.h(r105, "longestMsgType", "no_details");
        j.h(r105, "longestMsg", "no_details");
        j.h(r210, "history_details", r105);
        return;
    L6:
        if (r100 != null) goto L8;
    L81:
        j.h(r102, "longestMsgType", "no_history");
        j.h(r102, "longestMsg", "no_history");
        return;
    L8:
        if (r100.length() == 0) goto L81;
        long r106 = r210.optLong("crash_time");
        long r110 = r102.optLong("last_wall_time");
        long r111 = r102.optLong("last_cpu_time");
        long r112 = 0;
        if (r106 != 0) goto L13;
    L79:
        j.h(r102, "longestMsgType", "no_last_times");
        j.h(r102, "longestMsg", "no_last_times");
        return;
    L13:
        if (r110 == 0) goto L79;
        if (r111 == 0) goto L79;
        j.h(r102, "longestMsgType", "not_found");
        j.h(r102, "longestMsg", "not_found");
        if (r106 <= r110) goto L25;
        if (r101 == null) goto L25;
        r112 = r101.optLong("currentMessageCost");
        long r113 = r106 - r110;
        if (r113 >= r112) goto L23;
        r112 = r113;
    L23:
        a(r104, r101, r110, true);
    L25:
        if (r112 >= 5000) goto L40;
        long r114 = r106 - r110;
        long r211 = r112;
        int r107 = r100.length() - 1;
        int r212 = -1;
    L27:
        if (r107 < 0) goto L39;
        if (r114 >= 10000) goto L39;
        long r213 = r110;
        JSONObject r115 = r100.optJSONObject(r107);
        if (r115 != null) goto L33;
        long r214 = r111;
    L38:
        r107 = r107 - 1;
        r110 = r213;
        r111 = r214;
        goto L27
    L33:
        long r215 = r115.optLong("duration");
        r114 = r114 + r215;
        r214 = r111;
        a(r104, r115, r106 - r114, false);
        if (r114 <= 2500) goto L38;
        if (r215 <= r211) goto L38;
        r212 = r107;
        r211 = r215;
    L39:
        long r216 = r110;
        long r217 = r111;
        int r108 = r212;
    L41:
        long r116 = r112;
        if (r108 < 0) goto L76;
        int r109 = r100.length() - 1;
    L45:
        if (r109 < r108) goto L50;
        String r218 = r103;
        JSONObject r117 = r100.optJSONObject(r109);
        if (r117 == null) goto L49;
        r216 = r216 - r117.optLong("duration");
        r217 = r217 - r117.optLong("cpuDuration");
    L49:
        r109 = r109 - 1;
        r103 = r218;
        goto L45
    L50:
        String r219 = r103;
        JSONObject r118 = r100.optJSONObject(r108);
        if (r118 == null) goto L92;
        long r119 = r118.optLong("duration");
        long r120 = r118.optLong("cpuDuration");
        j.h(r102, "longestMsgWallDuration", Long.valueOf(r119));
        j.h(r102, "longestMessageCpuDuration", Long.valueOf(r120));
        j.h(r102, "longestMsgStartCpuTime", Long.valueOf(r217));
        j.h(r102, "longestMsgEndCpuTime", Long.valueOf(r217 + r120));
        j.h(r102, "longestMsgStartWallTime", Long.valueOf(r216));
        j.h(r102, "longestMsgEndWallTime", Long.valueOf(r216 + r119));
        int r121 = r118.optInt("type");
        if (r121 != 1) goto L65;
        if (r120 > 1) goto L58;
        String r122 = ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE;
    L74:
        j.h(r102, "longestMsgType", r122);
        j.h(r102, "longestMsg", r118.optString("message"));
        j.h(r102, "longestMsgBlockStack", r118.optString(r219));
        return;
    L58:
        if ((2 * r120) <= r119) goto L61;
        r122 = "native_busy";
        goto L74
    L61:
        if ((r120 * 10) >= r119) goto L63;
        r122 = "native_lock";
        goto L74
    L63:
        r122 = "native_unknown";
        goto L74
    L65:
        if (r121 == 8) goto L67;
        r122 = "normal";
        goto L74
    L67:
        if ((2 * r120) <= r119) goto L70;
        r122 = "java_busy";
        goto L74
    L70:
        if ((r120 * 10) >= r119) goto L72;
        r122 = "java_lock";
        goto L74
    L72:
        r122 = "java_unknown";
        goto L74
    L92:
        return;
    L76:
        if (r101 == null) goto L94;
        j.h(r102, "longestMsgWallDuration", Long.valueOf(r116));
        j.h(r102, "longestMessageCpuDuration", -1);
        j.h(r102, "longestMsgStartCpuTime", Long.valueOf(r217));
        j.h(r102, "longestMsgEndCpuTime", -1);
        j.h(r102, "longestMsgStartWallTime", Long.valueOf(r216));
        j.h(r102, "longestMsgEndWallTime", Long.valueOf(r216 + r116));
        j.h(r102, "longestMsgType", "current");
        j.h(r102, "longestMsg", r101.optString("message"));
        j.h(r102, "longestMsgBlockStack", r101.optString("block_stack"));
        return;
    L94:
        return;
    L40:
        r216 = r110;
        r217 = r111;
        r108 = -1;
        goto L41
    }

    public static void a(JSONArray r100, JSONObject r101, long r102, boolean r110) {
        if (r110 == false) goto L4;
        long r103 = r101.optLong("currentMessageCost");     // Catch: Throwable -> L20
    L5:
        if (r100 == null) goto L16;
        long r104 = r103 + r102;     // Catch: Throwable -> L20
        int r111 = 0;
    L9:
        if (r111 >= r100.length()) goto L16;
        JSONObject r105 = r100.optJSONObject(r111);     // Catch: Throwable -> L20
        long r106 = r105.optLong("time");     // Catch: Throwable -> L20
        if (r106 < r102) goto L15;
        if (r106 > r104) goto L15;
        String r107 = r105.optString("trace");     // Catch: Throwable -> L20
    L17:
        if (r107 == null) goto L27;
        j.h(r101, "block_stack", r107);     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L15:
        r111 = r111 + 1;     // Catch: Throwable -> L20
    L16:
        r107 = null;
        goto L17
    L4:
        r103 = r101.optLong("duration");     // Catch: Throwable -> L20
    }
}
