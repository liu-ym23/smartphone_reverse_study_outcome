package com.ss.android.ugc.aweme.poi.bean;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"locallife-saas-model_release"}, k = 2, mv = {1, 4, 3})
public final class PoiBizCodeKt {
    public static final PoiBizCode a(String r100) {
        PoiBizCode[] r101 = PoiBizCode.values();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        int r103 = r101.length;     // Catch: Throwable -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L10;
        PoiBizCode r105 = r101[r104];     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r105.bizCode, r100) == true) goto L7;
        r104 = r104 + 1;     // Catch: Throwable -> L11
        goto L4
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r106) == false) goto L16;
        r106 = null;
    L16:
        PoiBizCode r107 = (PoiBizCode) r106;
        if (r107 == null) goto L19;
        return r107;
    L19:
        return PoiBizCode.DEFAULT;
    L10:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
