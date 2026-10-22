package com.larus.disk.impl;

import com.bytedance.android.bytehook.ByteHook;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002J$\u0010\u0016\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082 ¢\u0006\u0002\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0010H\u0082 J\t\u0010\u0018\u001a\u00020\u0010H\u0082 J\t\u0010\u0019\u001a\u00020\u0010H\u0082 J\t\u0010\u001a\u001a\u00020\bH\u0082 J\t\u0010\u001b\u001a\u00020\u0010H\u0082 J\t\u0010\u001c\u001a\u00020\u0010H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/disk/impl/NativeFileAccessMonitor;", "", "<init>", "()V", "TAG", "", "LIBRARY_NAME", "BYTE_HOOK_SUCCESS", "", "loadLock", "libraryLoaded", "", "start", "roots", "", "observationStartMs", "", "([Ljava/lang/String;J)I", "atimeUpdateFailureCount", "hookStats", "Lcom/larus/disk/impl/NativeHookStats;", "ensureLibraryLoaded", "nativeStart", "nativeGetAtimeUpdateFailureCount", "nativeGetHookSuccessCount", "nativeGetHookFailureCount", "nativeGetHookLastErrorCode", "nativeGetHookedSymbolMask", "nativeGetFailedSymbolMask", "START_BYTE_HOOK_FAILED", "START_LIBRARY_LOAD_FAILED", "START_NATIVE_CALL_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeFileAccessMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeFileAccessMonitor f330600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f330601b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f330602c;

    public NativeFileAccessMonitor() {
    }

    private final native long nativeGetAtimeUpdateFailureCount();

    private final native long nativeGetFailedSymbolMask();

    private final native long nativeGetHookFailureCount();

    private final native int nativeGetHookLastErrorCode();

    private final native long nativeGetHookSuccessCount();

    private final native long nativeGetHookedSymbolMask();

    private final native int nativeStart(String[] r100, long r101);

    static {
        f330600a = new NativeFileAccessMonitor();
        f330601b = new Object();
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("app_disk_file_access", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> app_disk_file_access");
        com.bytedance.librarian.a.c("app_disk_file_access");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> app_disk_file_access");
    }

    public final long b() {
    L7:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "read native file access monitor status failed", e);
        return 0;
    L4:
        if (f330602c == false) goto L12;
        return RangesKt.coerceAtLeast(nativeGetAtimeUpdateFailureCount(), 0);
    L12:
        return 0;
    }

    public final q0 c() {
        if (f330602c == false) goto L5;
        return new q0(RangesKt.coerceAtLeast(nativeGetHookSuccessCount(), 0), RangesKt.coerceAtLeast(nativeGetHookFailureCount(), 0), RangesKt.coerceAtLeast(nativeGetHookLastErrorCode(), 0), RangesKt.coerceAtLeast(nativeGetHookedSymbolMask(), 0), RangesKt.coerceAtLeast(nativeGetFailedSymbolMask(), 0));
    L8:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "read native hook status failed", e);
        return new q0(0);
    L5:
        return new q0(0);
    }

    public final int d(String[] r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "roots");
        int r102 = ByteHook.init();     // Catch: Exception -> L57 LinkageError -> L60
        Integer r103 = Integer.valueOf(r102);     // Catch: Exception -> L57 LinkageError -> L60
        Integer r104 = null;
        if (r102 != 0) goto L6;
        ByteHook.Mode r105 = ByteHook.getMode();     // Catch: Exception -> L57 LinkageError -> L60
    L7:
        Pair r106 = TuplesKt.to(r103, r105);     // Catch: Exception -> L57 LinkageError -> L60
        int r107 = ((Number) r106.component1()).intValue();
        ByteHook.Mode r108 = (ByteHook.Mode) r106.component2();
        if (r107 == 0) goto L11;
    L55:
        FLogger.f375446a.e("NativeFileAccessMonitor", "ByteHook unavailable status=" + r107 + " mode=" + r108);
        return 101;
    L11:
        if (r108 != ByteHook.Mode.AUTOMATIC) goto L55;
        boolean r109 = true;
        if (f330602c == true) goto L30;
        Object r110 = f330601b;
        monitor-enter(r110);
    L52:
        th = move-exception;
        throw th;
    L19:
        if (f330602c == false) goto L65;
        monitor-exit(r110);
        goto L30
    L65:
        a();     // Catch: SecurityException -> L24 LinkageError -> L26 Throwable -> L52
        f330602c = true;     // Catch: SecurityException -> L24 LinkageError -> L26 Throwable -> L52
    L28:
        r109 = f330602c;     // Catch: Throwable -> L52
        monitor-exit(r110);
        goto L30
    L26:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "load app_disk_file_access failed", e);     // Catch: Throwable -> L52
    L24:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "load app_disk_file_access denied", e);     // Catch: Throwable -> L52
    L30:
        if (r109 == true) goto L71;
        return 102;
    L71:
        r104 = Integer.valueOf(ByteHook.addIgnore("libapp_disk_file_access.so"));     // Catch: Exception -> L35 LinkageError -> L37
    L39:
        if (r104 == null) goto L67;
        if (r104.intValue() == 0) goto L67;
        FLogger.f375446a.w("NativeFileAccessMonitor", "ByteHook addIgnore failed status=" + r104);
    L67:
    L73:
        return nativeStart(r100, RangesKt.coerceAtLeast(r101, 0));
    L46:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "native file access monitor start failed", e);
    L50:
        return 103;
    L48:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "native file access monitor start failed", e);
        goto L50
    L35:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "ByteHook addIgnore failed", e);
    L37:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "ByteHook addIgnore unavailable", e);
        goto L39
    L6:
        r105 = null;
    L57:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "ByteHook init failed", e);
        return 101;
    L60:
        e = move-exception;
        FLogger.f375446a.e("NativeFileAccessMonitor", "ByteHook load failed", e);
        return 101;
    }
}
