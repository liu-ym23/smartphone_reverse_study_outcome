package com.ss.android.ugc.aweme.thread;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
class ThreadPoolStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, WeakReference<ExecutorService>> f454340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ThreadPoolType, AtomicInteger> f454341b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        Iterator r101 = ((HashMap) this.f454340a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        if (((WeakReference) r102.getValue()).get() == null) goto L4;
        ThreadPoolExecutor r104 = (ThreadPoolExecutor) ((WeakReference) r102.getValue()).get();
        r100.append("pool=");
        r100.append(r103);
        r100.append(", core.size=");
        r100.append(r104.getCorePoolSize());
        r100.append(", pool.size=");
        r100.append(r104.getPoolSize());
        r100.append(", largest.pool.size=");
        r100.append(r104.getLargestPoolSize());
        r100.append(", queue.size=");
        r100.append(r104.getQueue().size());
        r100.append(", task.count=");
        r100.append(r104.getTaskCount());
        r100.append(", task.completed.count=");
        r100.append(r104.getCompletedTaskCount());
        r100.append("\n");
        goto L4
    L9:
        return r100.toString();
    }

    public ThreadPoolStore() {
        this.f454340a = new HashMap();
        this.f454341b = new HashMap();
    }
}
