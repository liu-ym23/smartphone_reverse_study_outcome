package com.bytedance.android.shopping.base.event;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(String r8) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L5;
        r6.put("pdp_session_id", r8);
    L5:
        Unit r9 = Unit.INSTANCE;
        a.d("pdp", "page_create", "success", null, false, r6, 24);
    }

    public static void e(String r8) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L5;
        r6.put("pdp_session_id", r8);
    L5:
        Unit r9 = Unit.INSTANCE;
        a.d("pdp", "pdp_first_frame_start", "start", null, false, r6, 24);
    }

    public static void h(String r8) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L5;
        r6.put("pdp_session_id", r8);
    L5:
        Unit r9 = Unit.INSTANCE;
        a.d("pdp", "render", "success", null, false, r6, 24);
    }

    public static void i(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        r6.put("pdp_session_id", r8);
        Unit r9 = Unit.INSTANCE;
        a.d("pdp", "pre_check", "start", null, false, r6, 24);
    }

    public static void j(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        ConcurrentHashMap<String, String> r0 = a.a;
        a.a.clear();
        JSONObject r6 = new JSONObject();
        r6.put("pdp_session_id", r8);
        Unit r9 = Unit.INSTANCE;
        a.d("pdp", "schema_parse", "start", null, false, r6, 24);
    }

    public static void a(boolean r8, String r9) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        r6.put("check_law", r8);
        if (r9 == null) goto L5;
        r6.put("pdp_session_id", r9);
    L5:
        Unit r10 = Unit.INSTANCE;
        a.d("pdp", "first_screen_response_return", "success", null, false, r6, 24);
    }

    public static void d(String r8, boolean r9) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L5;
        r6.put("pdp_session_id", r8);
    L5:
        r6.put("rebuild", r9);
        Unit r10 = Unit.INSTANCE;
        a.d("pdp", "pdp_first_frame_end", "success", null, false, r6, 24);
    }

    public static void g(boolean r8, String r9) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        r6.put("from_cache", r8);
        if (r9 == null) goto L5;
        r6.put("pdp_session_id", r9);
    L5:
        Unit r10 = Unit.INSTANCE;
        a.d("pdp", "render", "start", null, false, r6, 24);
    }

    public static void b(boolean r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        r6.put("enable_opt", r8);
        r6.put("pdp_session_id", r9);
        r6.put("key_data_is_null", r10);
        Unit r11 = Unit.INSTANCE;
        a.d("pdp", "first_screen_response_return", "start", null, false, r6, 24);
    }

    public static void f(boolean r8, String r9, boolean r10) {
        ConcurrentHashMap<String, String> r0 = a.a;
        JSONObject r6 = new JSONObject();
        r6.put("full_mode", r8);
        r6.put("rebuild", r10);
        if (r9 == null) goto L5;
        r6.put("pdp_session_id", r9);
    L5:
        Unit r11 = Unit.INSTANCE;
        a.d("pdp", "page_create", "start", null, false, r6, 24);
    }
}
