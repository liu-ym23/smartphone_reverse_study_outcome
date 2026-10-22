package com.ss.android.lark.app.glide.diskcache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class LarkGlideDiskCache implements DiskCache {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f408713e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f408714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f408715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Key f408716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f408717d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<c> f408718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DiskCache.Factory f408719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f408720c;

        public a() {
            this.f408718a = new ArrayList();
        }
    }

    public static final class b {
    }

    public interface c {
        boolean a();

        boolean b(Key r100);

        DiskCache c(String r100);
    }

    public interface d {
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f408722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap<c, DiskCache> f408723c;

        public final synchronized DiskCache a(Key r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L18
            Iterator<T> r101 = this.f408722b.iterator();     // Catch: Throwable -> L18
        L5:
            if (r101.hasNext() == false) goto L14;
            c r102 = (c) r101.next();     // Catch: Throwable -> L18
            if (r102.b(r100) == false) goto L5;
            HashMap<c, DiskCache> r103 = this.f408723c;     // Catch: Throwable -> L18
            DiskCache r104 = r103.get(r102);     // Catch: Throwable -> L18
            if (r104 != null) goto L11;
            r104 = r102.c(this.f408721a);     // Catch: Throwable -> L18
            r103.put(r102, r104);     // Catch: Throwable -> L18
        L11:
            DiskCache r105 = r104;     // Catch: Throwable -> L18
            monitor-exit(this);
            return r105;
        L14:
            int r106 = LarkGlideDiskCache.f408713e;     // Catch: Throwable -> L18
            Log.e("LarkGlideDiskCache", "not found diskcache  handle for key: " + r100);     // Catch: Throwable -> L18
            monitor-exit(this);
            return null;
        L18:
            th = move-exception;
            throw th;
        }

        public e(String r100, ArrayList<c> r101) {
            Intrinsics.checkNotNullParameter(r101, "handlerDisks");
            this.f408721a = r100;
            this.f408722b = r101;
            this.f408723c = new HashMap();
        }
    }

    static {
    }

    public final e a() {
        d r100 = this.f408714a.f408720c;
        if (r100 == null) goto L5;
        ((ava.c) r100).f16394a.getClass();
        String r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        Log.e("UniDiskLruCache", "empty user key");
    L14:
        ConcurrentHashMap<String, e> r103 = this.f408715b;
        e r104 = r103.get(r101);
        if (r104 != null) goto L21;
        r104 = new e(r101, this.f408714a.f408718a);
        e r105 = r103.putIfAbsent(r101, r104);
        if (r105 == null) goto L21;
        r104 = r105;
    L21:
        return r104;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void clear() {
        e r100 = a();
        monitor-enter(r100);
        Iterator<T> r101 = r100.f408723c.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L9;
        ((DiskCache) r101.next()).clear();     // Catch: Throwable -> L11
        goto L6
    L9:
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public LarkGlideDiskCache(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f408714a = r100;
        this.f408715b = new ConcurrentHashMap();
        this.f408717d = LazyKt.lazy(new LarkGlideDiskCache$backupCache$2(this));
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        DiskCache r101 = a().a(r100);
        if (r101 == null) goto L5;
        r101.delete(r100);
    L5:
        Log.w("LarkGlideDiskCache", "deleted key:" + r100);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File get(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r101 = a();
        DiskCache r102 = r101.a(r100);
        if (r102 == null) goto L6;
        File r103 = r102.get(r100);
        if (r103 == null) goto L6;
    L19:
        if (r103 == null) goto L21;
    L23:
        return r103;
    L21:
        if (Intrinsics.areEqual(r100, this.f408716c) == false) goto L23;
        Log.e("LarkGlideDiskCache", "cache had put but not found, something maybe wrong, key:" + r100);
    L6:
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<T> r104 = r101.f408722b.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        c r105 = (c) r104.next();
        if (r105.b(r100) == false) goto L8;
        boolean r106 = r105.a();
    L14:
        if (r106 == false) goto L18;
        DiskCache r107 = (DiskCache) this.f408717d.getValue();
        if (r107 == null) goto L18;
        r103 = r107.get(r100);
    L18:
        r103 = null;
        goto L19
    L12:
        r106 = false;
        goto L14
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void put(Key r100, DiskCache.Writer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "writer");
        DiskCache r102 = a().a(r100);
        if (r102 == null) goto L6;
        r102.put(r100, r101);
        this.f408716c = r100;
        return;
    }
}
