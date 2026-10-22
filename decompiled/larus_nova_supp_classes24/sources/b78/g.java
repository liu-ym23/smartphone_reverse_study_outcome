package b78;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public static final d0 a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return new d0(MapsKt.emptyMap());
    L12:
        if (StringsKt.startsWith$default(r4, "{", false, 2, null) == false) goto L25;
        if (StringsKt.endsWith$default(r4, "}", false, 2, null) == false) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        Object r5 = Result.constructor-impl(k.n(ouc.a.d.e(r4)));     // Catch: Throwable -> L18
    L20:
        d0 r2 = new d0(MapsKt.emptyMap());
        if (Result.isFailure-impl(r5) == false) goto L29;
        r5 = r2;
    L29:
        return (d0) r5;
    L18:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        return new d0(MapsKt.emptyMap());
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
