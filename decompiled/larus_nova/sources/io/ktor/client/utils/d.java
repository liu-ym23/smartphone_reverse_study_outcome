package io.ktor.client.utils;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static final Throwable a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Throwable r101 = r100;
    L4:
        if ((r101 instanceof CancellationException) == false) goto L9;
        CancellationException r102 = (CancellationException) r101;
        if (Intrinsics.areEqual(r101, r102.getCause()) == true) goto L7;
        r101 = r102.getCause();
        goto L4
    L7:
        return r100;
    L9:
        if (r101 != null) goto L12;
        return r100;
    L12:
        return r101;
    }
}
