package tl6;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import rm6.c;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements bt6.a {
    public a() {
    }

    @Override // bt6.a
    public final Object getValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = c.f538571a;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((String) c.a(r100, String.class));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        return null;
    L13:
        return r103;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // bt6.a
    public final int b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        int r103 = c.f538571a;     // Catch: Throwable -> L9
        Integer r104 = (Integer) c.a(r100, Integer.TYPE);     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        int r105 = r104.intValue();     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r105));     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L14;
        return r101;
    L14:
        return ((Number) r106).intValue();
    L6:
        r105 = r101;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // bt6.a
    public final Object a(String r100, Class r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "targetClass");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = c.a(r100, r101);     // Catch: Throwable -> L8
        if (r104 != null) goto L6;
        r104 = r102;
    L6:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r105) != null) goto L13;
        return r105;
    L13:
        return r102;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
