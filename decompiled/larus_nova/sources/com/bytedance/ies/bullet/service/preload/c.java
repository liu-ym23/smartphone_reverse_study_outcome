package com.bytedance.ies.bullet.service.preload;

import android.util.LruCache;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f248095b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f248096a;

    public static final class a extends LruCache<String, com.bytedance.ies.bullet.service.preload.a> {
        public a(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, com.bytedance.ies.bullet.service.preload.a r101) {
            com.bytedance.ies.bullet.service.preload.a r102 = r101;
            if (r102 != null) goto L7;
            return 0;
        L7:
            return (int) r102.size();
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, String r101, com.bytedance.ies.bullet.service.preload.a r102, com.bytedance.ies.bullet.service.preload.a r103) {
            com.bytedance.ies.bullet.service.preload.a r104 = r102;
            super.entryRemoved(r100, r101, r104, r103);
            if (r104 == null) goto L5;
            r104.release();
        L5:
            size();
            maxSize();
        }
    }

    public static final class b {
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        a r100 = this.f248096a;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.evictAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L23
        a r101 = this.f248096a;     // Catch: Throwable -> L23
        if (r101 == null) goto L6;
        Map<String, com.bytedance.ies.bullet.service.preload.a> r102 = r101.snapshot();     // Catch: Throwable -> L23
    L7:
        if (r102 == null) goto L19;
        Set<Map.Entry<String, com.bytedance.ies.bullet.service.preload.a>> r103 = r102.entrySet();     // Catch: Throwable -> L23
        if (r103 == null) goto L19;
        Iterator<Map.Entry<String, com.bytedance.ies.bullet.service.preload.a>> r104 = r103.iterator();     // Catch: Throwable -> L23
        if (r104 == null) goto L19;
    L13:
        if (r104.hasNext() == false) goto L19;
        Map.Entry<String, com.bytedance.ies.bullet.service.preload.a> r105 = r104.next();     // Catch: Throwable -> L23
        if (r105.getValue().a(r100) == false) goto L13;
        a r106 = this.f248096a;     // Catch: Throwable -> L23
        if (r106 == null) goto L13;
        com.bytedance.ies.bullet.service.preload.a r107 = r106.remove(r105.getKey());     // Catch: Throwable -> L23
    L19:
        if (r102 == null) goto L21;
        r102.clear();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L6:
        r102 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public c(int r100) {
        this.f248096a = new a(r100);
    }

    public final com.bytedance.ies.bullet.service.preload.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        a r101 = this.f248096a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }
}
