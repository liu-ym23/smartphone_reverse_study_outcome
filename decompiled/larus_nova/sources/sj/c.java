package sj;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, SoftReference<V>> f542262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, V> f542263b;

    public c() {
        this.f542262a = new LinkedHashMap();
        this.f542263b = new LinkedHashMap();
    }

    public final synchronized V a(K r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f542262a.containsKey(r100) == false) goto L9;
        SoftReference r101 = (SoftReference) ((LinkedHashMap) this.f542262a).get(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L8;
        V r102 = (V) r101.get();
    L10:
        monitor-exit(this);
        return r102;
    L8:
        r102 = null;
        goto L10
    L9:
        r102 = (V) ((LinkedHashMap) this.f542263b).get(r100);
        goto L10
    }
}
