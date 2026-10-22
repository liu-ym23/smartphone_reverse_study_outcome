package com.larus.cache;

import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.larus.utils.r;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class CacheManagerImpl implements com.larus.cache.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f321243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f321244c;

    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/cache/CacheManagerImpl$AdjustLruSizeResult;", "Ljava/io/Serializable;", "<init>", "()V", "maxSize", "", "getMaxSize", "()J", "setMaxSize", "(J)V", "cachedFilesSize", "getCachedFilesSize", "setCachedFilesSize", "Companion", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdjustLruSizeResult implements Serializable {
        public static final a Companion = null;
        private static final long serialVersionUID = -2890256138506813976L;
        private long cachedFilesSize;
        private long maxSize;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public AdjustLruSizeResult() {
        }

        public final long getCachedFilesSize() {
            return this.cachedFilesSize;
        }

        public final long getMaxSize() {
            return this.maxSize;
        }

        public final void setCachedFilesSize(long r100) {
            this.cachedFilesSize = r100;
        }

        public final void setMaxSize(long r100) {
            this.maxSize = r100;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/cache/CacheManagerImpl$CacheEntry;", "Ljava/io/Serializable;", "json", "", "expireDate", "", "<init>", "(Ljava/lang/String;J)V", "getJson", "()Ljava/lang/String;", "getExpireDate", "()J", "Companion", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CacheEntry implements Serializable {
        public static final a Companion = null;
        private static final long serialVersionUID = -5682307075359201485L;
        private final long expireDate;
        private final String json;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public final long getExpireDate() {
            return this.expireDate;
        }

        public final String getJson() {
            return this.json;
        }

        public CacheEntry(String r100, long r101) {
            this.json = r100;
            this.expireDate = r101;
        }
    }

    public static final class a {
    }

    public static final class b extends h<f> {
        @Override // com.larus.cache.h
        public final void a() {
            WeakReference<T> r100 = this.f321289a;
            if (r100 == 0) goto L5;
            Object r101 = r100.get();
        L6:
            f r102 = (f) r101;
            if (r102 != null) goto L10;
            return;
        L10:
            if (r102.isClosed() == false) goto L12;
            return;
        L12:
            File r103 = r102.f321256a;
            long r104 = r.t(new File[]{r103});
            monitor-enter(r102);
            long r105 = r102.f321263h;     // Catch: Throwable -> L68
            monitor-exit(r102);
            if (r105 < r104) goto L19;
            return;
        L19:
            File[] r106 = r103.listFiles();
            if (r106 != null) goto L22;
            return;
        L22:
            int r107 = r106.length;
            int r108 = 0;
        L23:
            if (r108 >= r107) goto L67;
            File r109 = r106[r108];
            if (r102.isClosed() == true) goto L90;
            if (r109 == null) goto L66;
            if (r109.isDirectory() == false) goto L32;
            r.d(r109);
            r109.delete();
            FLogger.f375446a.d("CacheManagerImpl", "delete file " + r109.getAbsolutePath());
            goto L66
        L32:
            String r110 = r109.getName();
            if (r110 != null) goto L35;
        L38:
            boolean r111 = true;
        L39:
            if (r111 == true) goto L66;
            if (StringsKt.endsWith$default(r110, DefaultDiskStorage.FileType.TEMP, false, 2, null) == true) goto L44;
        L79:
            f.e r112 = r102.e(r110);     // Catch: IOException -> L64
            if (StringsKt.contains$default(r110, "journal", false, 2, null) == false) goto L71;
        L57:
            Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L51
            CloseableKt.closeFinally(r112, null);     // Catch: IOException -> L64
            goto L66
        L71:
            f.p(r110);     // Catch: Throwable -> L51 Exception -> L53
            boolean r114 = true;
        L54:
            if (r114 == false) goto L56;
            if (r112 != null) goto L57;
        L56:
            r109.delete();     // Catch: Throwable -> L51
            FLogger.f375446a.d("CacheManagerImpl", "deleteMedia " + r109.getAbsolutePath());     // Catch: Throwable -> L51
        L53:
            r114 = false;
            goto L54
        L51:
            th = move-exception;
            throw th;     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            CloseableKt.closeFinally(r112, th);     // Catch: IOException -> L64
            throw th;     // Catch: IOException -> L64
        L64:
            e = move-exception;
            FLogger.f375446a.e("CacheManagerImpl", "delete dirty lru file error " + e);
            goto L66
        L44:
            if (r110.length() <= 4) goto L79;
            r110 = r110.substring(0, r110.length() - 4);
            goto L79
        L35:
            if (r110.length() == 0) goto L38;
            r111 = false;
        L66:
            r108 = r108 + 1;
            goto L23
        L90:
            return;
        L67:
            return;
        L68:
            th = move-exception;
            throw th;
        L5:
            r101 = null;
            goto L6
        }

        public b(f r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            super(r100);
        }
    }

    static {
    }

    public final synchronized boolean b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f() == false) goto L7;
        boolean r100 = e();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r100;
    L7:
        if (this.f321243b == null) goto L9;
        r100 = true;
        goto L10
    L9:
        r100 = false;
        goto L10
    }

    public final synchronized void c() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (b() == true) goto L16;
    L8:
        monitor-exit(this);
        return;
    L16:
        f r100 = this.f321243b;     // Catch: IOException -> L13 Throwable -> L10
        if (r100 == null) goto L8;
        r100.flush();     // Catch: IOException -> L13 Throwable -> L10
        goto L8
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        f r100 = this.f321243b;     // Catch: Throwable -> L16
        if (r100 == null) goto L13;
        File r101 = r100.f321256a;     // Catch: Throwable -> L16
        if (r101 == null) goto L8;
        String r102 = r101.getAbsolutePath();     // Catch: Throwable -> L16
    L9:
        if (Intrinsics.areEqual(r102, d().getAbsolutePath()) == false) goto L13;
        boolean r103 = false;
    L14:
        monitor-exit(this);
        return r103;
    L8:
        r102 = null;
    L13:
        r103 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public static File d() {
        return aa9.a.f2357a.c("common_lru_cache", true);
    }

    public final synchronized boolean e() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (q0.c(AppHost.f326268a.getApplication()) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L32
        FLogger.f375446a.d("CacheManagerImpl", "initDiskLruCache start");     // Catch: Throwable -> L32
        f r101 = this.f321243b;     // Catch: IllegalArgumentException -> L15 IOException -> L17 Throwable -> L32
        if (r101 == null) goto L19;
        r101.delete(true);     // Catch: IllegalArgumentException -> L15 IOException -> L17 Throwable -> L32
    L19:
        this.f321243b = null;     // Catch: IllegalArgumentException -> L15 Throwable -> L32
        f r102 = f.g(d(), 1, j0.G2_OTA_SPACE_CHECK_BYTES);     // Catch: IllegalArgumentException -> L15 IOException -> L25 Throwable -> L32
        this.f321243b = r102;     // Catch: IllegalArgumentException -> L15 Throwable -> L32
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CacheManagerImpl$initDiskLruCache$1$1(r102, null), 2, null);     // Catch: Throwable -> L32
        FLogger.f375446a.d("CacheManagerImpl", "initDiskLruCache end cost=" + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L32
        monitor-exit(this);
        return true;
    L25:
        e = move-exception;
        FLogger.f375446a.d("CacheManagerImpl", "initDiskLruCache path " + d() + " error2 " + e);     // Catch: IllegalArgumentException -> L15 Throwable -> L32
        return false;
    L15:
        e = move-exception;
        FLogger.f375446a.d("CacheManagerImpl", "initDiskLruCache path " + d() + " error3 " + e);     // Catch: Throwable -> L32
        return false;
    L17:
        e = move-exception;
        FLogger.f375446a.d("CacheManagerImpl", "initDiskLruCache path " + d() + " error1 " + e);     // Catch: IllegalArgumentException -> L15 Throwable -> L32
        goto L19
    }

    public CacheManagerImpl() {
        this.f321244c = new ConcurrentHashMap();
        e();
    }

    public static int a(File r100) {
        int r101 = 0;
        if (r100.isDirectory() == false) goto L17;
        File[] r102 = r100.listFiles();     // Catch: Exception -> L20
        if (r102 == null) goto L28;
        Iterator r103 = ArrayIteratorKt.iterator(r102);     // Catch: Exception -> L20
    L9:
        if (r103.hasNext() == false) goto L30;
        File r104 = (File) r103.next();     // Catch: Exception -> L20
        if (r104.isDirectory() == true) goto L12;
        if (r104.exists() == false) goto L9;
        r104.delete();     // Catch: Exception -> L20
    L16:
        r101 = r101 + 1;     // Catch: Exception -> L20
        goto L9
    L12:
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L20
        r101 = r101 + a(r104);     // Catch: Exception -> L20
        r104.delete();     // Catch: Exception -> L20
        goto L16
    L30:
        return r101;
    L28:
        return 0;
    L17:
        r100.delete();     // Catch: Exception -> L20
        return 1;
    L29:
        return 0;
    }
}
