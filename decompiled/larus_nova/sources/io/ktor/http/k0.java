package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class k0 {
    public static final boolean a(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.f491881a, "ws") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.f491881a, "wss") == true) goto L8;
        return false;
    }
}
