package com.bytedance.bdp.appbase.base.bdptask;

import androidx.collection.SieveCacheKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes11.dex */
public final class b<V> extends FutureTask<V> implements Comparable<b<?>> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicLong f200480i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f200481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f200482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f200483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f200484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BdpTask f200485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BdpTask.TaskType f200486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f200487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<TracePoint> f200488h;

    static {
        f200480i = new AtomicLong(0);
    }

    public b(Runnable r100) {
        super(r100, null);
        this.f200481a = 0;
        this.f200482b = 0;
        this.f200483c = f200480i.getAndIncrement();
        this.f200484d = false;
        this.f200485e = null;
        this.f200486f = BdpTask.TaskType.CPU;
        this.f200487g = 0;
        this.f200488h = new LinkedList();
    }

    public final int a(b<?> r100) {
        int r101 = this.f200481a;
        int r102 = r100.f200481a;
        if (r101 >= r102) goto L6;
        return -1;
    L6:
        if (r101 <= r102) goto L8;
        return 1;
    L8:
        long r103 = this.f200482b;
        long r104 = r100.f200482b;
        if (r103 >= r104) goto L12;
        return -1;
    L12:
        if (r103 <= r104) goto L15;
        return 1;
    L15:
        if (r101 == (-1)) goto L17;
    L25:
        long r105 = this.f200483c;
        long r106 = r100.f200483c;
        if (r105 >= r106) goto L29;
        return -1;
    L29:
        if (r105 <= r106) goto L31;
        return 1;
    L31:
        return 0;
    L17:
        if (r103 <= SieveCacheKt.NodeMetaAndPreviousMask) goto L25;
        long r107 = this.f200483c;
        long r108 = r100.f200483c;
        if (r107 <= r108) goto L22;
        return -1;
    L22:
        if (r107 >= r108) goto L24;
        return 1;
    L24:
        return 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(b<?> r100) {
        return a(r100);
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable r100) {
        super.setException(r100);
        if (this.f200484d == true) goto L6;
        BdpPoolImpl.f200443d.uncaughtException(ThreadMethodProxy.currentThread(), r100);
        return;
    }
}
