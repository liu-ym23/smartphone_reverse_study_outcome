package com.bytedance.ruler.strategy.cache;

import android.util.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public final class c<K, V> extends LruCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<K, V> f267714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267715b;

    public interface a<K, V> {
        void a(K r100, V r101);
    }

    public c() {
        super(1000);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, K r101, V r102, V r103) {
        super.entryRemoved(r100, r101, r102, r103);
        if (r103 != null) goto L11;
        if (r100 == true) goto L6;
        return;
    L6:
        if (this.f267715b == true) goto L13;
        a<K, V> r104 = this.f267714a;
        if (r104 == null) goto L14;
        r104.a(r101, r102);
        return;
    L14:
        return;
    L13:
        return;
    }
}
