package io.ktor.client.plugins;

import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    public static final class a implements j<b, g> {
    }

    @KtorDsl
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function2<io.ktor.client.statement.b, Continuation<? super Unit>, Object>> f491715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<f> f491716b;

        public b() {
            this.f491715a = new ArrayList();
            this.f491716b = new ArrayList();
        }
    }

    static {
        Intrinsics.checkNotNullParameter("HttpResponseValidator", "name");
    }

    public static final Object b(g r100, io.ktor.client.statement.b r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof HttpCallValidator$validateResponse$1) == false) goto L7;
        HttpCallValidator$validateResponse$1 r103 = (HttpCallValidator$validateResponse$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L21;
        if (r107 != 1) goto L20;
        Iterator r108 = (Iterator) r103.L$1;
        io.ktor.client.statement.b r109 = (io.ktor.client.statement.b) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L13:
        if (r108.hasNext() == false) goto L18;
        Function2 r110 = (Function2) r108.next();
        r103.L$0 = r109;
        r103.L$1 = r108;
        r103.label = 1;
        if (r110.invoke(r109, r103) != r106) goto L13;
        return r106;
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ResultKt.throwOnFailure(r105);
        i.f491722a.trace("Validating response for request " + r101.a80().c().getUrl());
        r100.getClass();
        Iterable r111 = (Iterable) null;
        throw null;
    L7:
        r103 = new HttpCallValidator$validateResponse$1(r100, r102);
        goto L8
    }

    public static final Unit a(g r100, Throwable r101, io.ktor.client.request.b r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof HttpCallValidator$processException$1) == false) goto L7;
        HttpCallValidator$processException$1 r104 = (HttpCallValidator$processException$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L29;
        if (r107 == 1) goto L15;
        if (r107 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator r108 = (Iterator) r104.L$2;
        io.ktor.client.request.b r109 = (io.ktor.client.request.b) r104.L$1;
        Throwable r110 = (Throwable) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        if (r108.hasNext() == false) goto L28;
        f r111 = (f) r108.next();
        if ((r111 instanceof e) == true) goto L25;
        if ((r111 instanceof u) == false) goto L17;
        ((u) r111).getClass();
        r104.L$0 = r110;
        r104.L$1 = r109;
        r104.L$2 = r108;
        r104.label = 2;
        throw null;
    L25:
        ((e) r111).getClass();
        r104.L$0 = r110;
        r104.L$1 = r109;
        r104.L$2 = r108;
        r104.label = 1;
        throw null;
    L28:
        return Unit.INSTANCE;
    L29:
        ResultKt.throwOnFailure(r106);
        i.f491722a.trace("Processing exception " + r101 + " for request " + r102.getUrl());
        r100.getClass();
        Iterable r112 = (Iterable) null;
        throw null;
    L7:
        r104 = new HttpCallValidator$processException$1(r100, r103);
        goto L8
    }
}
