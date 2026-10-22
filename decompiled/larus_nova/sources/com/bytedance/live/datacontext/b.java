package com.bytedance.live.datacontext;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f255078a = null;

    static {
        f255078a = new u();
    }

    public static final void a(DataContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        u r102 = f255078a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, "dc");     // Catch: Throwable -> L7
        r102.a(r101);     // Catch: Throwable -> L7
        int r103 = com.bytedance.revenue.platform.api.core.rx.d.f267510a;     // Catch: Throwable -> L7
        CompletableSubject r104 = new CompletableSubject();     // Catch: Throwable -> L7
        Disposable r105 = r104.subscribe(new v(r102, r101, r100));     // Catch: Throwable -> L7
        r102.f255097a.put(r101, new u.a(r100, r105));     // Catch: Throwable -> L7
        r100.getOnCleared().subscribe(r104);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
