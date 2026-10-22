package io.ktor.client.request;

import io.ktor.http.g0;
import io.ktor.http.h0;
import io.ktor.http.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static void a(HttpRequestBuilder r100, String r101, Integer r102, String r103) {
        HttpRequestKt$url$1 r104 = HttpRequestKt$url$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r104, "block");
        g0 r105 = r100.f491758a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(r104, "block");
        j0 r106 = j0.f491877c;
        j0 r107 = j0.a.a("ws");
        r105.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f491862a = r107;
        if (r101 == null) goto L5;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f491863b = r101;
    L5:
        if (r102 == null) goto L7;
        r105.f491864c = r102.intValue();
    L7:
        if (r103 == null) goto L9;
        h0.c(r105, r103);
    L9:
        r104.invoke(r105);
    }
}
