package io.ktor.utils.io;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static final void a(Throwable r100) {
        Throwable r101 = ExceptionUtilsJvmKt.b(r100, r100);     // Catch: Throwable -> L4
    L5:
        if (r101 != null) goto L8;
        throw r100;
    L8:
        throw r101;
    L4:
        r101 = null;
        goto L5
    }
}
