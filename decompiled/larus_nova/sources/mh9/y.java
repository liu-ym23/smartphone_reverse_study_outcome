package mh9;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class y {
    public static final String a(boolean r100) {
        if (r100 == false) goto L4;
        return BdpAppEventConstant.TRUE;
    L4:
        return BdpAppEventConstant.FALSE;
    }

    public static final d0 b(String r100) {
        if (r100 == null) goto L4;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        wt7.c r102 = wt7.a.f561230a;     // Catch: Throwable -> L10
        juc.d<d0> r103 = d0.Companion.serializer();     // Catch: Throwable -> L10
        r102.getClass();     // Catch: Throwable -> L10
        d0 r104 = (d0) wt7.c.a(r100, r103);     // Catch: Throwable -> L10
        if (r104 != null) goto L8;
        r104 = new d0(MapsKt.emptyMap());     // Catch: Throwable -> L10
    L8:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L10
    L13:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L17;
        r105 = new d0(MapsKt.emptyMap());
    L17:
        return (d0) r105;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L4:
        return new d0(MapsKt.emptyMap());
    }
}
