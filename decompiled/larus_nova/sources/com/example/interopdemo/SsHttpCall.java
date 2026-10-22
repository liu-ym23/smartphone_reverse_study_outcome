package com.example.interopdemo;

import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class SsHttpCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f274030a;

    public SsHttpCall() {
        this.f274030a = new a();
    }

    public static nt7.c a(nt7.a r110) {
        nt7.b r100 = r110.f520520d;
        if (r100 == null) goto L6;
        byte[] r101 = r100.a();
        if (r101 == null) goto L6;
    L7:
        String r102 = r110.f520517a;
        String r103 = r110.f520518b;
        List<Pair<String, String>> r104 = r110.f520519c;
        return new nt7.c(r102, r103, r104, r101, r110.f520521e, r110.f520522f, r110.f520523g, r110.f520524h);
    L6:
        r101 = new byte[0];
        goto L7
    }

    public final Object b(nt7.a r110, Continuation<? super ot7.a> r111) {
        if ((r111 instanceof SsHttpCall$execute$1) == false) goto L7;
        SsHttpCall$execute$1 r100 = (SsHttpCall$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        SsHttpCall r113 = (SsHttpCall) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        ot7.b r114 = (ot7.b) r112;
        r113.getClass();
        return new ot7.a(r114.f526688a, r114.f526689b, r114.f526690c, r114.f526691d, r114.f526693f, r114.f526692e, r114.f526694g, r114.f526695h);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        nt7.c r115 = a(r110);
        a r116 = this.f274030a;
        r100.L$0 = this;
        r100.label = 1;
        r112 = r116.a(r116.f274031a, r115, r100);
        if (r112 != r102) goto L17;
        return r102;
    L17:
        r113 = this;
    L7:
        r100 = new SsHttpCall$execute$1(this, r111);
        goto L8
    }
}
