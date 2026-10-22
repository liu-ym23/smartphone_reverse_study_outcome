package com.larus.bmhome.auth;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class t0 implements Function0 {
    public /* synthetic */ t0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        boolean r102 = true;
        if (z0.b().length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L17;
        String r104 = z0.f295858b.getString("app_launch_cache_launch_info", "");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L20
        if (r104.length() == 0) goto L13;
        r102 = false;
    L13:
        if (r102 == true) goto L17;
        a r105 = (a) z0.f295857a.fromJson(r104, a.class);     // Catch: Throwable -> L20
        if (r105 == null) goto L17;
    L18:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r106) == true) goto L27;
        r100 = r106;
    L27:
        return (a) r100;
    L17:
        r105 = null;
        goto L18
    L6:
        r103 = false;
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
