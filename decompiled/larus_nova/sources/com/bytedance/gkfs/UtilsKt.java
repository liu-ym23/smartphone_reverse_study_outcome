package com.bytedance.gkfs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.cdc.GkFSByteBuffer;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import ez5.g;
import ez5.h;
import ez5.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 \u001a\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¨\u0006\b"}, d2 = {"", "absDir", "", "contextId", "", "traversalSingleFilesNative", "path", "traversalSingleFilesNativeCallback", "geckox_noasanRelease"}, k = 2, mv = {1, 4, 0})
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f245115a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f245116b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f245117c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f245118d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f245119e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f245120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Long, Function1<File, Unit>> f245121g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f245122h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f245123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f245124j = null;

    public static final int c() {
        return ((Number) f245116b.getValue()).intValue();
    }

    public static final boolean d() {
        return ((Boolean) f245122h.getValue()).booleanValue();
    }

    public static final boolean e() {
        return ((Boolean) f245124j.getValue()).booleanValue();
    }

    private static final native void traversalSingleFilesNative(String r100, long r101);

    static {
        f245115a = (int) Os.sysconf(OsConstants._SC_PAGE_SIZE);
        f245116b = LazyKt.lazy(UtilsKt$DISK_BLOCK_SIZE$2.INSTANCE);
        f245117c = new byte[0];
        f245118d = new AtomicBoolean(false);
        f245119e = new AtomicBoolean(false);
        f245121g = new LinkedHashMap();
        f245122h = LazyKt.lazy(UtilsKt$debuggable$2.INSTANCE);
        f245124j = LazyKt.lazy(UtilsKt$isMainProcess$2.INSTANCE);
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("gkfs", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> gkfs");
        com.bytedance.librarian.a.c("gkfs");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> gkfs");
    }

    public static final void f(final String r100) {
        final Context r101 = GlobalManager.f250642k.getContext();
        if (r101 == null) goto L15;
        g r102 = g.a.f474886a;
        r102.b(r101);
        SharedPreferences r103 = r102.f474885a;
        boolean r104 = false;
        if (r103 == null) goto L8;
        r104 = r103.getBoolean("gkfs_show_toast", false);
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        Handler r105 = i.f474888a;
        Function0<Unit> r106 = new UtilsKt$showToast$1(r101, r100);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        r106.invoke();
        return;
    L13:
        i.f474888a.post(new h(r106));
        return;
    }

    public static final void g(File r100, Function1<? super File, Unit> r101) {
        if (f245118d.compareAndSet(false, true) == false) goto L11;
        AtomicBoolean r102 = f245119e;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        a();     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        r102.set(Result.m9456isSuccessimpl(r104));
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        if (GkFSUtils.h() == true) goto L13;
    L29:
        ArrayDeque r106 = new ArrayDeque();
        r106.offer(r100);
    L31:
        if (r106.size() <= 0) goto L60;
        File r107 = (File) r106.poll();
        if (r107.isDirectory() == true) goto L34;
        if (r107.isFile() == false) goto L31;
        r101.invoke(r107);
        goto L31
    L34:
        File[] r108 = r107.listFiles();
        if (r108 == null) goto L31;
        int r109 = r108.length;
        int r110 = 0;
    L37:
        if (r110 >= r109) goto L31;
        r106.offer(r108[r110]);
        r110 = r110 + 1;
        goto L37
    L60:
        return;
    L13:
        if (f245119e.get() == false) goto L29;
        Map<Long, Function1<File, Unit>> r111 = f245121g;
        monitor-enter(r111);
        long r112 = f245120f + 1;     // Catch: Throwable -> L26
        f245120f = r112;     // Catch: Throwable -> L26
        r111.put(Long.valueOf(r112), r101);     // Catch: Throwable -> L26
        long r113 = f245120f;     // Catch: Throwable -> L26
        monitor-exit(r111);
        traversalSingleFilesNative(r100.getAbsolutePath(), r113);
        monitor-enter(r111);
        Function1<File, Unit> r114 = r111.remove(Long.valueOf(r113));     // Catch: Throwable -> L23
        monitor-exit(r111);
        return;
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    }

    private static final void traversalSingleFilesNativeCallback(String r100, long r101) throws IOException {
        Map<Long, Function1<File, Unit>> r102 = f245121g;
        monitor-enter(r102);
        Function1 r103 = (Function1) ((LinkedHashMap) r102).get(Long.valueOf(r101));     // Catch: Throwable -> L11
        monitor-exit(r102);
        if (r103 == null) goto L9;
        r103.invoke(new PolarisFileWrapper(r100));
        return;
    L9:
        String r104 = "can not find traversal callback for " + r101;
        c.e(c.f245127c, "traversal", r104, 0, false, 28);
        throw new IOException(r104);
    L11:
        th = move-exception;
        throw th;
    }

    public static void b(byte[] r100, GkFSByteBuffer r101, int r102) {
        r101.d(0);
        r101.b(r100, 0, r102 - 0);
    }
}
