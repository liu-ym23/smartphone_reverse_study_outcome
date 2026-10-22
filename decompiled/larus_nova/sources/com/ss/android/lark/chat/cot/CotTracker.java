package com.ss.android.lark.chat.cot;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class CotTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f414784a = null;

    static {
        f414784a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CotTracker$statistics$2.INSTANCE);
    }

    public static void a(String r100, JSONObject r101) {
        Log.d("CotTracker", "send event=" + r100 + ", params=" + r101);
        ((o5c.b) f414784a.getValue()).sendEvent(r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w("CotTracker", "send event=" + r100 + " failed", th);
    }

    public static void b(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("click", r103);
        r104.put("cot_id", r100);
        r104.put("msg_id", r101);
        r104.put("chat_id", r102);
        Unit r105 = Unit.INSTANCE;
        a("im_ai_agent_cot_msg_click", r104);
    }
}
