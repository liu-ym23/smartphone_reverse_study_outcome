package io.opentelemetry.sdk.internal;

import io.opentelemetry.sdk.trace.l;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes41.dex */
public final class d<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, V> f492710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, V>> f492711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, V>> f492712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, Map<String, V>>> f492713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f492714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<V> f492715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function<ltc.e, V> f492716g;

    public d(l r100) {
        this.f492710a = new ConcurrentHashMap();
        this.f492711b = new ConcurrentHashMap();
        this.f492712c = new ConcurrentHashMap();
        this.f492713d = new ConcurrentHashMap();
        this.f492714e = new Object();
        this.f492715f = Collections.newSetFromMap(new IdentityHashMap());
        this.f492716g = r100;
    }

    public final Object a(ltc.a r100) {
        V r101 = this.f492716g.apply(r100);
        Object r102 = this.f492714e;
        monitor-enter(r102);
        this.f492715f.add(r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
