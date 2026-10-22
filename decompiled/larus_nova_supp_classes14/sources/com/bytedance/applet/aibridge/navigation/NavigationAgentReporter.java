package com.bytedance.applet.aibridge.navigation;

import com.ixigua.lib.track.TrackParams;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class NavigationAgentReporter {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static JSONObject b(String r10, String r11) {
        return new JSONObject(r11);
    L4:
        e = move-exception;
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_agent_report", "content parse failed: type=".concat(e.getClass().getSimpleName()));
        a(r10, false, 0, -2, "content_parse_failed: type=".concat(e.getClass().getSimpleName()), false);
        return null;
    }

    public static void c(String r6, JSONObject r7) {
        JSONObject r8 = new JSONObject().put("api_name", "navigation_agent_report").put("params", new JSONObject().put("event", r6).put("content", r7.toString()));
        String r9 = new JSONObject().put("scene", "FPA_Location_MCP").put("payload", r8.toString()).toString();
        BuildersKt.launch$default(a, null, null, new NavigationAgentReporter$send$1(r6, r9, null), 3, null);
    }

    public static void a(String r3, boolean r4, long r5, long r7, String r9, boolean r10) {
        JSONObject r6 = new JSONObject().put("scene", r3);     // Catch: Exception -> L14
        int r1 = 0;
        if (r4 == false) goto L5;
        int r8 = 1;
    L6:
        JSONObject r11 = r6.put("is_success", r8).put("duration", r5).put("error_code", r7);     // Catch: Exception -> L14
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        JSONObject r12 = r11.put("error_message", r9);     // Catch: Exception -> L14
        if (r10 == false) goto L12;
        r1 = 1;
    L12:
        JSONObject r13 = r12.put("is_retry", r1);     // Catch: Exception -> L14
        by7.a r14 = new by7.a("flow_nav_agent_report");     // Catch: Exception -> L14
        TrackParams r15 = new TrackParams().merge(r13);     // Catch: Exception -> L14
        r14.a.merge(r15);     // Catch: Exception -> L14
        r14.b();     // Catch: Exception -> L14
        return;
    L5:
        r8 = 0;
    L14:
        e = move-exception;
        int r16 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_agent_report", "monitor emit failed: type=".concat(e.getClass().getSimpleName()));
    }
}
