package io.ktor.utils.io;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes41.dex */
public final class ByteReadChannelKt {
    public static final Object a(ByteReadChannel r100, d r101, long r102, Continuation<? super Long> r103) {
        if ((r103 instanceof ByteReadChannelKt$copyAndClose$1) == false) goto L7;
        ByteReadChannelKt$copyAndClose$1 r104 = (ByteReadChannelKt$copyAndClose$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r101 = (d) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        long r109 = ((Number) r106).longValue();
        e.a(r101);
        return Boxing.boxLong(r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r101;
        r104.label = 1;
        r106 = ByteReadChannelJVMKt.a(r100, r101, r102, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new ByteReadChannelKt$copyAndClose$1(r103);
        goto L8
    }
}
