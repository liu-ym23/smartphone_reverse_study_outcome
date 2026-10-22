package com.obric.assistant.remote_card_container.cache;

import androidx.collection.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f391253a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, o9a.d> f391254b = null;

    public n() {
    }

    static {
        f391253a = new n();
        f391254b = new LruCache(50);
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardUri");     // Catch: Throwable -> L7
        p9a.e r101 = p9a.b.f528329a;     // Catch: Throwable -> L7
        p9a.b.a("CardMemoryCache", "removeCache: " + r100);     // Catch: Throwable -> L7
        f391254b.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r100, o9a.d r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardUri");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "remoteCard");     // Catch: Throwable -> L7
        p9a.e r102 = p9a.b.f528329a;     // Catch: Throwable -> L7
        p9a.b.a("CardMemoryCache", "addCache: " + r100);     // Catch: Throwable -> L7
        f391254b.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
