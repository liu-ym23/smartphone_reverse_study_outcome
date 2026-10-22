package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.n;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static long a;
    public static final CopyOnWriteArrayList<Pair<String, Long>> b = null;
    public static final b c = null;

    public b() {
    }

    static {
        c = new b();
        b = new CopyOnWriteArrayList();
    }

    public static void c() {
        IApmAgent r0 = (IApmAgent) n.b.a(IApmAgent.class);
        if (r0 == null) goto L14;
        JSONObject r1 = new JSONObject();
        Iterator<Pair<String, Long>> r2 = b.iterator();     // Catch: Exception -> L10
    L7:
        if (r2.hasNext() == false) goto L12;
        Pair<String, Long> r3 = r2.next();     // Catch: Exception -> L10
        r1.put(r3.getFirst(), r3.getSecond().longValue());     // Catch: Exception -> L10
    L12:
        int r4 = c.a;
        c.a("FeedShowTaskMonitor", "sendTaskMonitor " + r1);
        r0.monitorEvent("feed_show_task_monitor", new JSONObject(), r1, new JSONObject());
        b.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L14:
        int r5 = c.a;
    }

    public static void a(FeedShowTaskInfo r5, boolean r6) {
        if (a > 0) goto L6;
        return;
    L6:
        if (r6 == false) goto L8;
        String r7 = InitMonitor.MAIN + r5.taskId + "_TASKEND";
    L9:
        b.add(new Pair(r7, Long.valueOf(System.currentTimeMillis() - a)));
        return;
    L8:
        r7 = InitMonitor.ASYNC + r5.taskId + "_TASKEND";
        goto L9
    }

    public static void b(FeedShowTaskInfo r5, boolean r6) {
        if (a > 0) goto L6;
        return;
    L6:
        if (r6 == false) goto L8;
        String r7 = InitMonitor.MAIN + r5.taskId + "_TASKSTART";
    L9:
        b.add(new Pair(r7, Long.valueOf(System.currentTimeMillis() - a)));
        return;
    L8:
        r7 = InitMonitor.ASYNC + r5.taskId + "_TASKSTART";
        goto L9
    }
}
