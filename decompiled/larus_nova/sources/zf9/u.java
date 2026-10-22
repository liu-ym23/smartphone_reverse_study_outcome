package zf9;

import android.content.Context;
import com.facebook.cache.disk.DiskCacheConfig;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import qt9.b1;
import qt9.f1;

/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f571771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f571772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f571773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f571774d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f571775e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f571776f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f571777g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f571778h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f571779i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f571780j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f571781k = null;

    public u() {
    }

    static {
        f571771a = new u();
        f571772b = LazyKt.lazy(new b());
        f571773c = LazyKt.lazy(new j());
        f571774d = LazyKt.lazy(new k());
        f571775e = LazyKt.lazy(new l());
        f571776f = LazyKt.lazy(new m());
        f571777g = LazyKt.lazy(new n());
        f571778h = LazyKt.lazy(new o());
        f571779i = LazyKt.lazy(new p());
        f571780j = LazyKt.lazy(new q());
        f571781k = LazyKt.lazy(new r());
    }

    public static b1 d() {
        return (b1) f571779i.getValue();
    }

    public static f1 e() {
        return (f1) f571778h.getValue();
    }

    public static int c() {
        int r100 = Math.min((int) Runtime.getRuntime().maxMemory(), Integer.MAX_VALUE);
        if (r100 >= 16777216) goto L6;
        return 1048576;
    L6:
        if (r100 >= 33554432) goto L8;
        return 2097152;
    L8:
        return 4194304;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void b(HashMap r100, String r101, Context r102, Triple r103) {
        DiskCacheConfig r104 = DiskCacheConfig.newBuilder(r102).setBaseDirectoryPath(r102.getCacheDir()).setBaseDirectoryName(r101).setMaxCacheSize(((Number) r103.getFirst()).intValue() * 1024).setMaxCacheSizeOnLowDiskSpace(((Number) r103.getSecond()).longValue() * 1024).setMaxCacheSizeOnVeryLowDiskSpace(((Number) r103.getThird()).longValue() * 1024).build();
        r100.put(r101, r104);
        Intrinsics.checkNotNull(r104);
    }
}
