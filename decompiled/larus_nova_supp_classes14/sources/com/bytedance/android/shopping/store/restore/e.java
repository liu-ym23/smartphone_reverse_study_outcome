package com.bytedance.android.shopping.store.restore;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements d {
    public final LruCache<n, m> a;

    public e() {
        this.a = new LruCache(1);
    }

    @Override // com.bytedance.android.shopping.store.restore.d
    public final void b(m r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        LruCache<n, m> r0 = this.a;
        monitor-enter(r0);
        m r5 = this.a.put(r4.a, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.store.restore.d
    public final m a(n r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        LruCache<n, m> r0 = this.a;
        monitor-enter(r0);
        m r9 = this.a.remove(r7);     // Catch: Throwable -> L16
        monitor-exit(r0);
        if (r9 != null) goto L9;
        return null;
    L9:
        long r1 = r9.c;
        if (r1 > 0) goto L13;
        return r9;
    L13:
        if ((r8 - r9.b) > r1) goto L15;
        return r9;
    L15:
        return null;
    L16:
        th = move-exception;
        throw th;
    }
}
