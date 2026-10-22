package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.model.DelayTaskInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Pair<String, Long>> f254545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f254546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f254547c = null;

    public a() {
    }

    static {
        f254547c = new a();
        f254545a = new CopyOnWriteArrayList();
        f254546b = -1;
    }

    public static void a(String r100, long r101) {
        f254545a.add(new Pair(r100, Long.valueOf(r101)));
    }

    public static void c(DelayTaskInfo r100, boolean r101) {
        if (f254546b >= 0) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        String r102 = InitMonitor.MAIN + r100.taskId + "_TASKEND";
    L9:
        a(r102, System.currentTimeMillis() - f254546b);
        return;
    L8:
        r102 = InitMonitor.ASYNC + r100.taskId + "_TASKEND";
        goto L9
    }

    public static void d(DelayTaskInfo r100, boolean r101) {
        if (f254546b >= 0) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        String r102 = InitMonitor.MAIN + r100.taskId + "_TASKSTART";
    L9:
        a(r102, System.currentTimeMillis() - f254546b);
        return;
    L8:
        r102 = InitMonitor.ASYNC + r100.taskId + "_TASKSTART";
        goto L9
    }

    public static void b(String r100, long r101, boolean r102) {
        if (r102 == false) goto L4;
        String r103 = InitMonitor.MAIN.concat(r100);
    L5:
        a(r103, r101);
        return;
    L4:
        r103 = InitMonitor.ASYNC.concat(r100);
        goto L5
    }
}
