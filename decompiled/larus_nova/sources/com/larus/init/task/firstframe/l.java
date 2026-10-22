package com.larus.init.task.firstframe;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.api.IApmTrace;
import com.larus.utils.logger.FLogger;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f351308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f351309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k f351310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PriorityQueue<FirstFrameTaskInfo> f351311d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f351312e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f351313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f351314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f351315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f351316i;

    static {
        f351311d = new PriorityQueue();
        f351312e = new Handler(Looper.getMainLooper());
    }

    public static void a() {
        if (com.bytedance.apm.d.l() == true) goto L5;
        return;
    L5:
        if (f351311d.isEmpty() == true) goto L22;
        IApmTrace.f286937a.b();
        FLogger.f375446a.d("FlowFirstFrameTaskDispatcher", com.bytedance.apm.d.c() + " dispatchTask");
    L8:
        PriorityQueue<FirstFrameTaskInfo> r100 = f351311d;
        if ((!r100.isEmpty()) == false) goto L14;
        final FirstFrameTaskInfo r101 = r100.poll();
        if (r101 == null) goto L12;
        f351312e.post(new g(r101));
        goto L8
    L12:
        return;
    L14:
        f351308a = true;
        j r102 = f351309b;
        if (r102 == null) goto L21;
        r102.a();
        return;
    L21:
        return;
    }
}
