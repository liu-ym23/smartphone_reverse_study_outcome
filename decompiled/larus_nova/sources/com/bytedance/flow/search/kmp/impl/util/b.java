package com.bytedance.flow.search.kmp.impl.util;

import com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final List<String> a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "domainKeys");
        if (r100.isEmpty() == true) goto L5;
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        pd6.b r103 = pd6.c.f528682a;     // Catch: Throwable -> L13
        SearchDomainGateService r104 = (SearchDomainGateService) pd6.c.a(Reflection.getOrCreateKotlinClass(SearchDomainGateService.class));     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        List<String> r105 = r104.j0(r100);     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r106) == true) goto L19;
        r101 = r106;
    L19:
        List<String> r107 = (List) r101;
        if (r107 != null) goto L23;
        return r100;
    L23:
        return r107;
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }
}
