package com.larus.superthread.impl.monitor;

import com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Instrumentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Instrumentation> f370129a;

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final String getName() {
        return "CombineInstrumentation";
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final int getMaxThreadSize() {
        Iterator<T> r100 = this.f370129a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((Instrumentation) r100.next()).getMaxThreadSize();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final int getPendingSize() {
        Iterator<T> r100 = this.f370129a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((Instrumentation) r100.next()).getPendingSize();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final int getReleaseSize() {
        Iterator<T> r100 = this.f370129a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((Instrumentation) r100.next()).getReleaseSize();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final int getThreadSize() {
        Iterator<T> r100 = this.f370129a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((Instrumentation) r100.next()).getThreadSize();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final int getWaiterSize() {
        Iterator<T> r100 = this.f370129a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((Instrumentation) r100.next()).getWaiterSize();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
    public final Map<String, String> extra() {
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends Instrumentation> r100) {
        Intrinsics.checkNotNullParameter(r100, "instrumentations");
        this.f370129a = r100;
    }
}
