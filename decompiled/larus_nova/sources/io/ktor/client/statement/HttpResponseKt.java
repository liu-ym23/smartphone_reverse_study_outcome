package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.u;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.core.k;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpResponseKt {
    @InternalAPI
    public static final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        CoroutineContext.Element r101 = r100.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(r101);
        ((CompletableJob) r101).complete();
    }

    public static final io.ktor.client.request.b c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.a80().c();
    }

    public static final Object a(b r100, Charset r101, Continuation<? super String> r102) {
        if ((r102 instanceof HttpResponseKt$bodyAsText$1) == false) goto L7;
        HttpResponseKt$bodyAsText$1 r103 = (HttpResponseKt$bodyAsText$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        CharsetDecoder r108 = (CharsetDecoder) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L22:
        if (r105 == null) goto L26;
        return ksc.b.a(r108, (k) r105, Integer.MAX_VALUE);
    L26:
        throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.core.ByteReadPacket");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Charset r109 = u.b(r100);
        if (r109 == null) goto L18;
        r101 = r109;
    L18:
        CharsetDecoder r110 = r101.newDecoder();
        HttpClientCall r111 = r100.a80();
        KType r112 = Reflection.typeOf(k.class);
        isc.a r113 = isc.b.a(TypesJVMKt.getJavaType(r112), Reflection.getOrCreateKotlinClass(k.class), r112);
        r103.L$0 = r110;
        r103.label = 1;
        r105 = r111.a(r113, r103);
        if (r105 != r106) goto L21;
        return r106;
    L21:
        r108 = r110;
    L7:
        r103 = new HttpResponseKt$bodyAsText$1(r102);
        goto L8
    }
}
