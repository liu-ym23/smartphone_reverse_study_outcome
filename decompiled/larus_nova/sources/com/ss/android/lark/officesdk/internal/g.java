package com.ss.android.lark.officesdk.internal;

import java.util.HashMap;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, b> f433363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f433364b = null;

    static {
        f433363a = new HashMap();
        f433364b = new Object();
    }

    public static void a(String r100, String r101, long r102) {
        b r103 = new b(r100, r101, r102);
        Object r104 = f433364b;
        monitor-enter(r104);
        f433363a.put(r100, r103);     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r104);
        JSONObject r106 = new JSONObject();
        r106.put("task_name", r103.f433356a);
        r106.put("phase", r103.f433357b);
        r106.put("cost_ms", r103.f433358c);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
