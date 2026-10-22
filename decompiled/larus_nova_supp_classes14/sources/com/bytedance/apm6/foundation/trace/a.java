package com.bytedance.apm6.foundation.trace;

import android.os.Process;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    static {
        Process.myPid();
    }

    public static void b(String r1, long r2, String r4, int r5, long r6, JSONObject r8) {
        TraceBean r0 = new TraceBean();
        r0.a = r1;
        r0.b = r2;
        r0.c = r4;
        r0.e = r5;
        r0.f = r6;
        r0.g = TraceBean.TraceType.ASYNC_SLICE_END;
        r0.h = r8;
        r0.a();
    }

    public static void a(String r1, long r2, String r4, String r5, long r6, int r8, JSONObject r9) {
        TraceBean r0 = new TraceBean();
        r0.a = r1;
        r0.b = r2;
        r0.c = r4;
        r0.f = r6;
        r0.d = r5;
        r0.e = r8;
        r0.g = TraceBean.TraceType.ASYNC_SLICE_BEGIN;
        r0.h = r9;
        r0.a();
    }
}
