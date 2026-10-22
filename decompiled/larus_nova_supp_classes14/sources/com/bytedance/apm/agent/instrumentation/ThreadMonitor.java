package com.bytedance.apm.agent.instrumentation;

import android.content.Context;
import com.bytedance.apm.d;
import com.bytedance.apm.util.a;
import com.bytedance.apm.util.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ThreadMonitor {
    private static final String TAG = "ThreadMonitor";

    public ThreadMonitor() {
    }

    private static boolean isLocalChannel() {
        JSONObject r0 = d.g;
        if (r0 != null) goto L5;
    L8:
        return false;
    L5:
        if (r0.optString("channel") == null) goto L8;
        return d.g.optString("channel").contains("local");
    }

    private static boolean isDebuggable() {
        Context r0 = d.getContext();
        Boolean r1 = a.b;
        if (r1 == null) goto L6;
        return r1.booleanValue();
    L6:
        if (r0 != null) goto L15;
    L7:
        return false;
    L15:
        if ((r0.getApplicationInfo().flags & 2) == 0) goto L11;
        boolean r2 = true;
    L12:
        Boolean r3 = Boolean.valueOf(r2);     // Catch: Exception -> L14
        a.b = r3;     // Catch: Exception -> L14
        return r3.booleanValue();
    L11:
        r2 = false;
        goto L12
    }

    public static void sleepMonitor(long r3) throws InterruptedException {
        if (u.a() == true) goto L5;
    L9:
        Thread.sleep(r3);
        return;
    L5:
        if (r3 <= 10) goto L9;
        if (isDebuggable() == true) goto L9;
        isLocalChannel();
        goto L9
    }
}
