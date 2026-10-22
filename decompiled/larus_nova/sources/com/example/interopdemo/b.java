package com.example.interopdemo;

import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b {
    public b() {
    }

    public final Object a(pt7.a r100, nt7.c r101, Continuation r102) {
        if ((r102 instanceof BaseSsCall$executeInner$1) == false) goto L7;
        BaseSsCall$executeInner$1 r103 = (BaseSsCall$executeInner$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L19;
        if (r106 != 1) goto L18;
        ResultKt.throwOnFailure(r105);
        pt7.d r107 = (pt7.d) r105;
        ot7.b r108 = new ot7.b();
        if (r107 == null) goto L16;
        String r109 = r107.f530649a;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f526688a = r109;
        r108.f526689b = r107.f530651c;
        Intrinsics.checkNotNullParameter(r107.f530650b, "<set-?>");
        List<Pair<String, String>> r110 = r107.f530652d;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r108.f526690c = r110;
        r108.f526691d = r107.f530655g;
        String r111 = r107.f530656h;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r108.f526692e = r111;
        String r112 = r107.f530657i;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r108.f526693f = r112;
        int r113 = r107.f530658j;
        if (r113 == 0) goto L16;
        r108.f526694g = r113;
        String r114 = r107.f530659k;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r108.f526695h = r114;
    L16:
        return r108;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r105);
        String r115 = r101.f520528a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        Intrinsics.checkNotNullParameter(r101.f520529b, "<set-?>");
        List<Pair<String, String>> r116 = r101.f520530c;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r100.f530660a = r116;
        String r117 = r101.f520531d;
        boolean r118 = false;
        if (Intrinsics.areEqual(r117, "STRING") == false) goto L25;
        if (r101.f520532e.length() > 0) goto L31;
    L32:
        if (r118 == false) goto L37;
        String r119 = r101.f520531d;
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        if (Intrinsics.areEqual(r119, "STRING") == false) goto L36;
        Intrinsics.checkNotNullParameter(r101.f520532e, "<set-?>");
        goto L37
    L36:
        Intrinsics.checkNotNullParameter(r101.f520533f, "<set-?>");
    L37:
        r103.label = 1;
        r100.a();
        throw null;
    L31:
        r118 = true;
        goto L32
    L25:
        if (Intrinsics.areEqual(r117, "BYTEARRAY") == false) goto L32;
        if (r101.f520533f.length != 0) goto L29;
        boolean r120 = true;
    L30:
        if (r120 == true) goto L32;
    L29:
        r120 = false;
    L7:
        r103 = new BaseSsCall$executeInner$1(this, r102);
        goto L8
    }
}
