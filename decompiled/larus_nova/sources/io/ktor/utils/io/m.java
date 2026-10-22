package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m {
    public static final Throwable a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Throwable r101 = r100;
    L4:
        if ((r101 instanceof CancellationException) == false) goto L12;
        if (Intrinsics.areEqual(r101, r101.getCause()) == true) goto L7;
        Throwable r102 = r101.getCause();
        if (r102 == null) goto L10;
        r101 = r102;
        goto L4
    L10:
        return r101;
    L7:
        return r100;
    L12:
        return r101;
    }
}
