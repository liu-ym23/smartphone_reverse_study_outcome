package io.ktor.client.request;

import io.ktor.http.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class h {
    public static final void a(t r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == null) goto L6;
        r100.getHeaders().e(r101, r102.toString());
        Unit r103 = Unit.INSTANCE;
        return;
    }
}
