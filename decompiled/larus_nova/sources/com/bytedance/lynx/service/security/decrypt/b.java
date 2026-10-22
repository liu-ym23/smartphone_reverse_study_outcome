package com.bytedance.lynx.service.security.decrypt;

import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f264941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f264942b = null;

    static {
        f264942b = new Object();
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("lynxsecurity_decrypt", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> lynxsecurity_decrypt");
        com.bytedance.librarian.a.c("lynxsecurity_decrypt");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> lynxsecurity_decrypt");
    }

    public static a.C3713a c(Throwable r100) {
        DecryptErrorCode r101 = DecryptErrorCode.DecryptConfigNotSet;
        String r102 = r100.getMessage();
        if (r102 != null) goto L6;
        r102 = r100.getClass().getSimpleName();
    L6:
        return new a.C3713a(r101, "Failed to load lynxsecurity_decrypt: ".concat(r102));
    }

    @JvmStatic
    public static final a b(byte[] r100, byte[] r101, byte[] r102) {
        Intrinsics.checkNotNullParameter(r100, "ba");
        Intrinsics.checkNotNullParameter(r101, "dek");
        Intrinsics.checkNotNullParameter(r102, "salt");
        if (f264941a == true) goto L14;
        Object r103 = f264942b;
        monitor-enter(r103);
    L38:
        th = move-exception;
        throw th;
    L8:
        if (f264941a == false) goto L42;
        monitor-exit(r103);
        goto L14
    L42:
        a();     // Catch: UnsatisfiedLinkError -> L15 SecurityException -> L19 Throwable -> L38
        f264941a = true;     // Catch: UnsatisfiedLinkError -> L15 SecurityException -> L19 Throwable -> L38
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r103);
        goto L14
    L15:
        e = move-exception;
        a.C3713a r105 = c(e);     // Catch: Throwable -> L38
    L22:
        a.C3713a r106 = r105;
    L23:
        if (r106 == null) goto L25;
        return r106;
    L25:
        DecryptErrorCode r107 = DecryptErrorCode.InvalidArguments;
        int[] r108 = {r107.getCode()};
        ByteBuffer r109 = LynxDecryptNative.nativeDecryptArtifact(r100, r101, r102, r108);
        if (r109 != null) goto L44;
        DecryptErrorCode.a r110 = DecryptErrorCode.Companion;
        Integer r111 = ArraysKt.firstOrNull(r108);
        if (r111 == null) goto L31;
        int r112 = r111.intValue();
    L32:
        r110.getClass();
        DecryptErrorCode r113 = (DecryptErrorCode) DecryptErrorCode.access$getCODE_MAP$cp().get(Integer.valueOf(r112));
        if (r113 == null) goto L37;
        r107 = r113;
    L37:
        return new a.C3713a(r107, r107.toString());
    L31:
        r112 = r107.getCode();
        goto L32
    L44:
        return new a.b(r109);
    L19:
        e = move-exception;
        r105 = c(e);     // Catch: Throwable -> L38
    L14:
        r106 = null;
        goto L23
    }
}
