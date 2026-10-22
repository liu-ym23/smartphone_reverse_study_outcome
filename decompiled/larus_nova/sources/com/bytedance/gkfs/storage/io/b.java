package com.bytedance.gkfs.storage.io;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.gkfs.cdc.GkFSByteBuffer;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements Closeable, Flushable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static com.bytedance.gkfs.io.a f245346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.gkfs.c f245347i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static File f245348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReentrantReadWriteLock f245349k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<com.bytedance.gkfs.io.a> f245350l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C3511b f245351m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f245352n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f245353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f245354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f245355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.gkfs.c f245356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.gkfs.io.a f245357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f245358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f245359g;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.gkfs.storage.io.b$a$a, reason: collision with other inner class name */
        public static final class C3510a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f245360a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final b f245361b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C3510a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f245361b, ((C3510a) r100).f245361b) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                b r100 = this.f245361b;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "CacheItem(buffer=" + this.f245361b + ")";
            }

            public C3510a(b r100) {
                this.f245361b = r100;
                this.f245360a = r100.a();
            }
        }

        public a() {
        }

        public static com.bytedance.gkfs.io.a[] f() {
            com.bytedance.gkfs.io.a r100 = b.f245346h;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");
        L5:
            IntProgression r101 = RangesKt.downTo(r100.f245185a, 0);
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<Integer> r103 = r101.iterator();
        L7:
            if (r103.hasNext() == false) goto L9;
            r102.add(new com.bytedance.gkfs.io.a(((IntIterator) r103).nextInt()));
            goto L7
        L9:
            ArrayList r104 = new ArrayList();
            Iterator r105 = r102.iterator();
        L11:
            if (r105.hasNext() == false) goto L20;
            Object r106 = r105.next();
            b.f245352n.getClass();
            PolarisFileWrapper r107 = i((com.bytedance.gkfs.io.a) r106);
            if (r107 == null) goto L17;
            boolean r108 = true;
            if (r107.exists() != true) goto L17;
        L18:
            if (r108 == false) goto L11;
            r104.add(r106);
        L17:
            r108 = false;
            goto L18
        L20:
            Object[] r109 = r104.toArray(new com.bytedance.gkfs.io.a[0]);
            if (r109 == null) goto L25;
            return (com.bytedance.gkfs.io.a[]) r109;
        L25:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public static PolarisFileWrapper c(File r100) {
            return new PolarisFileWrapper(r100.getAbsolutePath() + "-backup");
        }

        public static com.bytedance.gkfs.io.a d(File r100) {
            String r101 = r100.getName();
            int r102 = StringsKt.indexOf$default(r101, ".", 0, false, 6, null);
            if (r101 == null) goto L10;
            Integer r103 = StringsKt.toIntOrNull(r101.substring(0, r102));
            if (r103 == null) goto L8;
            return new com.bytedance.gkfs.io.a(r103.intValue());
        L8:
            return com.bytedance.gkfs.io.a.f245184b;
        L10:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public static PolarisFileWrapper e(File r100) {
            return new PolarisFileWrapper(r100.getAbsolutePath() + "-rewriting");
        }

        public static b g(com.bytedance.gkfs.io.a r100) throws IOException {
            ReentrantReadWriteLock r101 = b.f245349k;
            ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
            int r103 = 0;
            if (r101.getWriteHoldCount() != 0) goto L5;
            int r104 = r101.getReadHoldCount();
        L6:
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L9;
            r102.unlock();
            r105 = r105 + 1;
            goto L7
        L9:
            ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
            r106.lock();
            b.f245352n.getClass();     // Catch: Throwable -> L29
            PolarisFileWrapper r107 = i(r100);     // Catch: Throwable -> L29
            if (r107 != null) goto L13;
        L31:
            if (r103 >= r104) goto L33;
            r102.lock();
            r103 = r103 + 1;
            goto L31
        L33:
            r106.unlock();
            return null;
        L13:
            if (r107.isFile() == true) goto L19;
            b.f245351m.remove(r100);     // Catch: Throwable -> L29
        L15:
            if (r103 >= r104) goto L17;
            r102.lock();
            r103 = r103 + 1;
            goto L15
        L17:
            r106.unlock();
            return null;
        L19:
            C3511b r108 = b.f245351m;     // Catch: Throwable -> L29
            C3510a r109 = r108.get(r100);     // Catch: Throwable -> L29
            if (r109 == null) goto L24;
            b r110 = r109.f245361b;     // Catch: Throwable -> L29
            if (r110 == null) goto L24;
        L25:
            if (r103 >= r104) goto L27;
            r102.lock();
            r103 = r103 + 1;
            goto L25
        L27:
            r106.unlock();
            return r110;
        L24:
            r110 = b(r100, r107, r107.length());     // Catch: Throwable -> L29
            r108.put(r100, new C3510a(r110));     // Catch: Throwable -> L29
        L29:
            th = move-exception;
        L35:
            if (r103 >= r104) goto L37;
            r102.lock();
            r103 = r103 + 1;
            goto L35
        L37:
            r106.unlock();
            throw th;
        L5:
            r104 = 0;
            goto L6
        }

        public static b h(com.bytedance.gkfs.io.a r100) {
            ReentrantReadWriteLock r101 = b.f245349k;
            ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
            int r103 = 0;
            if (r101.getWriteHoldCount() != 0) goto L5;
            int r104 = r101.getReadHoldCount();
        L6:
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L9;
            r102.unlock();
            r105 = r105 + 1;
            goto L7
        L9:
            ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
            r106.lock();
            C3510a r107 = b.f245351m.remove(r100);     // Catch: Throwable -> L19
            if (r107 == null) goto L14;
            b r108 = r107.f245361b;     // Catch: Throwable -> L19
        L15:
            if (r103 >= r104) goto L17;
            r102.lock();
            r103 = r103 + 1;
            goto L15
        L17:
            r106.unlock();
            return r108;
        L14:
            r108 = null;
        L19:
            th = move-exception;
        L20:
            if (r103 >= r104) goto L22;
            r102.lock();
            r103 = r103 + 1;
            goto L20
        L22:
            r106.unlock();
            throw th;
        L5:
            r104 = 0;
            goto L6
        }

        public static PolarisFileWrapper i(com.bytedance.gkfs.io.a r100) {
            if (Intrinsics.areEqual(r100, com.bytedance.gkfs.io.a.f245184b) == false) goto L6;
            return null;
        L6:
            File r101 = b.f245348j;
            if (r101 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("rootDir");
        L10:
            return new PolarisFileWrapper(r101, r100.f245185a + ".gkfsb");
        }

        public static final void a(a r110, b r111) {
            r110.getClass();
            ReentrantReadWriteLock r112 = b.f245349k;
            ReentrantReadWriteLock.ReadLock r100 = r112.readLock();
            int r101 = 0;
            if (r112.getWriteHoldCount() != 0) goto L5;
            int r102 = r112.getReadHoldCount();
        L6:
            int r103 = 0;
        L7:
            if (r103 >= r102) goto L9;
            r100.unlock();
            r103 = r103 + 1;
            goto L7
        L9:
            ReentrantReadWriteLock.WriteLock r113 = r112.writeLock();
            r113.lock();
            C3511b r104 = b.f245351m;     // Catch: Throwable -> L25
            C3510a r105 = r104.get(r111.f245357e);     // Catch: Throwable -> L25
            if (r105 == null) goto L13;
            int r106 = r105.f245360a;     // Catch: Throwable -> L25
        L15:
            if ((r111.a() - r106) >= 2097152) goto L17;
        L20:
            Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L25
        L21:
            if (r101 >= r102) goto L23;
            r100.lock();
            r101 = r101 + 1;
            goto L21
        L23:
            r113.unlock();
            return;
        L17:
            if (UtilsKt.d() == false) goto L19;
            com.bytedance.gkfs.c.b(b.f245347i, "GkFSBlockBuffer", "update cache " + r111 + " from " + r106 + " to " + r111.a(), 0, false, 12);     // Catch: Throwable -> L25
        L19:
            r104.put(r111.f245357e, new C3510a(r111));     // Catch: Throwable -> L25
            goto L20
        L13:
            r106 = 0;
        L25:
            th = move-exception;
        L26:
            if (r101 >= r102) goto L28;
            r100.lock();
            r101 = r101 + 1;
            goto L26
        L28:
            r113.unlock();
            throw th;
        L5:
            r102 = 0;
            goto L6
        }

        public static b b(com.bytedance.gkfs.io.a r100, PolarisFileWrapper r101, long r102) {
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
            Object r104 = Result.m9449constructorimpl(new GkFSBlockMMapBuffer(r100, r101, r102));     // Catch: Throwable -> L4
        L6:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L10;
            GkFSExecutor.a(new c(r105));
        L10:
            if (Result.m9455isFailureimpl(r104) == false) goto L12;
            r104 = null;
        L12:
            GkFSBlockMMapBuffer r106 = (GkFSBlockMMapBuffer) r104;
            if (r106 == null) goto L16;
            return r106;
        L16:
            return new GkFSBlockSafetyBuffer(r100, r101);
        L4:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.gkfs.storage.io.b$b, reason: collision with other inner class name */
    public static final class C3511b extends LruCache<com.bytedance.gkfs.io.a, a.C3510a> {
        public C3511b() {
            super(41943040);
        }

        @Override // android.util.LruCache
        public final int sizeOf(com.bytedance.gkfs.io.a r100, a.C3510a r101) {
            a.C3510a r102 = r101;
            if (r102 != null) goto L7;
            return 1;
        L7:
            return r102.f245360a;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, com.bytedance.gkfs.io.a r101, a.C3510a r102, a.C3510a r110) {
            com.bytedance.gkfs.io.a r103 = r101;
            a.C3510a r111 = r110;
            super.entryRemoved(r100, r103, r102, r111);
            if (UtilsKt.d() == false) goto L14;
            if (r100 == false) goto L15;
            com.bytedance.gkfs.c r104 = b.f245347i;
            StringBuilder r105 = new StringBuilder();
            b r106 = null;
            if (r103 == null) goto L8;
            Integer r107 = Integer.valueOf(r103.f245185a);
        L9:
            r105.append(r107);
            r105.append(" evicted from buffer-cache, newValue=");
            if (r111 == null) goto L12;
            r106 = r111.f245361b;
        L12:
            r105.append(r106);
            com.bytedance.gkfs.c.b(r104, "GkFSBlockBuffer", r105.toString(), 0, false, 12);
            return;
        L8:
            r107 = null;
            goto L9
        L15:
            return;
        }
    }

    public abstract int a();

    public abstract void d();

    public abstract void e(long r100);

    public abstract void f(long r100, byte[] r101, int r102, int r103);

    public abstract void g(long r100, GkFSByteBuffer r101, int r102);

    static {
        f245352n = new a();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        String[] r101 = GeckoFileSystem.f245101a;     // Catch: Throwable -> L8
        Application r102 = GeckoFileSystem.f245104d;     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L8
    L6:
        com.bytedance.librarian.a.e("gkfs", true, r102);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        f245347i = new com.bytedance.gkfs.c();
        f245349k = new ReentrantReadWriteLock();
        f245350l = new LinkedHashSet();
        f245351m = new C3511b();
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final long b() {
        ReentrantReadWriteLock.ReadLock r100 = this.f245354b.readLock();
        r100.lock();
        long r101 = this.f245353a;     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f245355c.compareAndSet(false, true) == false) goto L6;
        a r100 = f245352n;
        com.bytedance.gkfs.io.a r101 = this.f245357e;
        r100.getClass();
        a.h(r101);
        d();
        return;
    }

    public String toString() {
        return "GkFSBlockBuffer@" + hashCode() + "(id=" + this.f245357e.f245185a + ", cacheSize=" + a() + ", blockSize=" + b() + ", backingFile=" + this.f245358f + ')';
    }

    public final File c() {
        return this.f245358f;
    }

    public final void h(int r100) throws IOException {
        monitor-enter(this);
        ReentrantReadWriteLock.ReadLock r101 = this.f245354b.readLock();     // Catch: Throwable -> L12
        r101.lock();     // Catch: Throwable -> L12
        long r102 = this.f245353a + ((long) r100);
        r101.unlock();     // Catch: Throwable -> L12
        e(r102);     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        r101.unlock();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public b(com.bytedance.gkfs.io.a r100, PolarisFileWrapper r101) {
        this.f245357e = r100;
        this.f245358f = r101;
        this.f245359g = 8388608;
        this.f245353a = r101.length();
        this.f245354b = new ReentrantReadWriteLock();
        this.f245355c = new AtomicBoolean(false);
        this.f245356d = new com.bytedance.gkfs.c();
    }
}
