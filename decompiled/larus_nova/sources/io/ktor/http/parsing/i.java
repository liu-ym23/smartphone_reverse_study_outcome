package io.ktor.http.parsing;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class i {
    public static final h a(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "grammar");
        return new h(CollectionsKt.listOf(new d[]{r100, r101}));
    }

    public static final l b(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "grammar");
        return new l(CollectionsKt.listOf(new d[]{r100, r101}));
    }

    public static final l c(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        return b(r100, new n(r101));
    }
}
