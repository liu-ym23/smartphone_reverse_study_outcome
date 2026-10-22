package com.ss.android.lark.preload;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.moment.PreloadMoment;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1c.a f438802a;

    /* JADX INFO: renamed from: com.ss.android.lark.preload.a$a, reason: collision with other inner class name */
    public static class C5249a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f438803a = null;

        static {
            f438803a = new a();
        }
    }

    public a() {
        this.f438802a = new c1c.a();
    }

    public static void a(a r100, d1c.a r110, PreloadMoment r111) {
        r100.getClass();
        StringBuilder r101 = new StringBuilder("finishLoad  TaskName = Docs_preload_task, moment = ");
        r110.getClass();
        r101.append(r111.name());
        Log.i("PreloadEngine", r101.toString());
        PreloadTarget r102 = PreloadTarget.DOC;
        b.a r103 = b.f438804a.get(r102);     // Catch: Exception -> L13
        if (r103 == null) goto L18;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L13
        r104.put(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, null);     // Catch: Exception -> L13
        r104.put("preload_timing", r111);     // Catch: Exception -> L13
        r104.put("business_type", r102);     // Catch: Exception -> L13
        long r105 = SystemClock.uptimeMillis();     // Catch: Exception -> L13
        r103.f438805a = r105;     // Catch: Exception -> L13
        long r106 = r103.f438806b;     // Catch: Exception -> L13
        if (r106 > 0) goto L9;
        r104.put("cost_time_extra", -1);     // Catch: Exception -> L13
    L11:
        Statistics.sendEvent("lark_preload_finish_preload_dev", r104);     // Catch: Exception -> L13
        Log.i("PreloadEngine", "  event: lark_preload_finish_preload_dev, param: " + r104);     // Catch: Exception -> L13
        return;
    L9:
        r104.put("cost_time_extra", r105 - r106);     // Catch: Exception -> L13
        goto L11
    L18:
        return;
    L13:
        e = move-exception;
        Log.e(e.getMessage());
    }
}
