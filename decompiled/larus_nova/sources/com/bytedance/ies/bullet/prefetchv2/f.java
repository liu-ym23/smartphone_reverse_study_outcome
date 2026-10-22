package com.bytedance.ies.bullet.prefetchv2;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f247531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0<String, v> f247532b;

    public final synchronized void c() {
        monitor-enter(this);
        this.f247532b.d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final Context getContext() {
        return this.f247531a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f247531a = r100;
        this.f247532b = new f0(PrefetchCache$memCache$1.INSTANCE, PrefetchCache$memCache$2.INSTANCE);
    }

    public final synchronized v a(p r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "request");     // Catch: Throwable -> L15
        v r101 = this.f247532b.a(r100.f247575l);     // Catch: Throwable -> L15
        if (r101 != null) goto L7;
        monitor-exit(this);
        return null;
    L7:
        if (r101.a() == false) goto L11;
        int r102 = j.f247548a;     // Catch: Throwable -> L15
        j.c("内存缓存过期: " + r100.f247575l);     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L11:
        monitor-exit(this);
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized v delete(p r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "request");     // Catch: Throwable -> L6
        String r101 = r100.f247575l;     // Catch: Throwable -> L6
        v r102 = this.f247532b.c(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(p r100, v r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "request");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r101, "result");     // Catch: Throwable -> L6
        String r102 = r100.f247575l;     // Catch: Throwable -> L6
        this.f247532b.b(r102, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
