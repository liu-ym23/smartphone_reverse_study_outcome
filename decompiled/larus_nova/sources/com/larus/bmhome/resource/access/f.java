package com.larus.bmhome.resource.access;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements b0, c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f313633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f313634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateFlowImpl f313635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f313636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f313637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f313638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<Job> f313639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f313640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlowImpl f313641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StateFlowImpl f313642k;

    public final synchronized boolean c() {
        monitor-enter(this);
        boolean r100 = d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        a0 r100 = (a0) this.f313635d.getValue();
        if ((r100 instanceof a0.d) == false) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof a0.c) == true) goto L19;
        if ((r100 instanceof a0.a) == true) goto L19;
        if (Intrinsics.areEqual(r100, a0.b.f313616a) == false) goto L12;
    L18:
        return false;
    L12:
        if ((r100 instanceof a0.e) == true) goto L18;
        if ((r100 instanceof a0.f) == true) goto L18;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final z snapshot() {
        return new z(this.f313632a, this.f313633b, (a0) this.f313635d.getValue(), this.f313634c, this.f313637f, this.f313638g, (Map) this.f313636e.getValue());
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final StateFlowImpl a() {
        return this.f313641j;
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final StateFlowImpl b() {
        return this.f313642k;
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final String getTaskId() {
        return this.f313632a;
    }

    public final synchronized boolean e(a0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L12
        if (d() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.f313638g = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.f313635d.setValue(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(q0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L6
        this.f313638g = System.currentTimeMillis();     // Catch: Throwable -> L6
        StateFlowImpl r101 = this.f313636e;     // Catch: Throwable -> L6
        r101.setValue(MapsKt.plus((Map) r101.getValue(), TuplesKt.to(r100.f313716a, r100)));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.resource.access.c0
    public void update(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        e(r100);
    }

    public f(String r100, r0 r101, w r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "request");
        this.f313632a = r100;
        this.f313633b = r101;
        this.f313634c = r102;
        StateFlowImpl r103 = j1.a(a0.b.f313616a);
        this.f313635d = r103;
        StateFlowImpl r104 = j1.a(MapsKt.emptyMap());
        this.f313636e = r104;
        long r105 = System.currentTimeMillis();
        this.f313637f = r105;
        this.f313638g = r105;
        this.f313639h = new AtomicReference(null);
        this.f313640i = new ConcurrentHashMap();
        this.f313641j = r103;
        this.f313642k = r104;
    }
}
