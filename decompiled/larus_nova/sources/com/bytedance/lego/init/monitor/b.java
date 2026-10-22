package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.n;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f254548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Pair<String, Long>> f254549b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f254550c = null;

    public b() {
    }

    static {
        f254550c = new b();
        f254549b = new CopyOnWriteArrayList();
    }

    public static void c() {
        IApmAgent r100 = (IApmAgent) n.f254552b.a(IApmAgent.class);
        if (r100 == null) goto L14;
        JSONObject r101 = new JSONObject();
        Iterator<Pair<String, Long>> r102 = f254549b.iterator();     // Catch: Exception -> L10
    L7:
        if (r102.hasNext() == false) goto L12;
        Pair<String, Long> r103 = r102.next();     // Catch: Exception -> L10
        r101.put(r103.getFirst(), r103.getSecond().longValue());     // Catch: Exception -> L10
    L12:
        int r104 = c.f254571a;
        c.a("FeedShowTaskMonitor", "sendTaskMonitor " + r101);
        r100.monitorEvent("feed_show_task_monitor", new JSONObject(), r101, new JSONObject());
        f254549b.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L14:
        int r105 = c.f254571a;
    }

    public static void a(FeedShowTaskInfo r100, boolean r101) {
        if (f254548a > 0) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        String r102 = InitMonitor.MAIN + r100.taskId + "_TASKEND";
    L9:
        f254549b.add(new Pair(r102, Long.valueOf(System.currentTimeMillis() - f254548a)));
        return;
    L8:
        r102 = InitMonitor.ASYNC + r100.taskId + "_TASKEND";
        goto L9
    }

    public static void b(FeedShowTaskInfo r100, boolean r101) {
        if (f254548a > 0) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        String r102 = InitMonitor.MAIN + r100.taskId + "_TASKSTART";
    L9:
        f254549b.add(new Pair(r102, Long.valueOf(System.currentTimeMillis() - f254548a)));
        return;
    L8:
        r102 = InitMonitor.ASYNC + r100.taskId + "_TASKSTART";
        goto L9
    }
}
