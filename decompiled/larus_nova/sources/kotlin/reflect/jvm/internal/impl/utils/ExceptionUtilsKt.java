package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<?> r101 = r100.getClass();
    L4:
        if (Intrinsics.areEqual(r101.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") == true) goto L5;
        r101 = r101.getSuperclass();
        if (r101 != null) goto L4;
        return false;
    L5:
        return true;
    }

    public static final RuntimeException rethrow(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        throw r100;
    }
}
