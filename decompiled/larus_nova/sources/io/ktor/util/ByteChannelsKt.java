package io.ktor.util;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.v;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes41.dex */
public final class ByteChannelsKt {
    public static final Pair a(ByteReadChannel r110, io.ktor.client.statement.b r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "coroutineScope");
        io.ktor.utils.io.internal.f.b r100 = io.ktor.utils.io.internal.f.f492077c;
        final ByteBufferChannel r101 = new ByteBufferChannel(true, r100, 8);
        final ByteBufferChannel r102 = new ByteBufferChannel(true, r100, 8);
        BuildersKt.launch$default(r111, null, null, new ByteChannelsKt$split$1(r110, r101, r102, null), 3, null).invokeOnCompletion(new ByteChannelsKt$split$2(r101, r102));
        return TuplesKt.to(r101, r102);
    }

    public static final Object b(ByteReadChannel r100, Continuation<? super byte[]> r101) {
        if ((r101 instanceof ByteChannelsKt$toByteArray$1) == false) goto L7;
        ByteChannelsKt$toByteArray$1 r102 = (ByteChannelsKt$toByteArray$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return v.b((io.ktor.utils.io.core.k) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r104 = r100.h(Long.MAX_VALUE, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new ByteChannelsKt$toByteArray$1(r101);
        goto L8
    }
}
