package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class SequentialCopyToKt {
    public static final Object a(ByteChannelSequentialBase r110, ByteChannelSequentialBase r111, long r112, Continuation<? super Long> r113) {
        if ((r113 instanceof SequentialCopyToKt$copyToSequentialImpl$1) == false) goto L7;
        SequentialCopyToKt$copyToSequentialImpl$1 r100 = (SequentialCopyToKt$copyToSequentialImpl$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L32;
        if (r102 != 1) goto L12;
        r112 = r100.J$1;
        long r115 = r100.J$0;
        ByteChannelSequentialBase r103 = (ByteChannelSequentialBase) r100.L$1;
        ByteChannelSequentialBase r104 = (ByteChannelSequentialBase) r100.L$0;
        ResultKt.throwOnFailure(r114);
        if (((Boolean) r114).booleanValue() == false) goto L46;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "dst");
        throw null;
    L46:
        return Boxing.boxLong(r115 - r112);
    L12:
        if (r102 != 2) goto L14;
        r112 = r100.J$1;
        r115 = r100.J$0;
        ByteChannelSequentialBase r105 = (ByteChannelSequentialBase) r100.L$1;
        ByteChannelSequentialBase r106 = (ByteChannelSequentialBase) r100.L$0;
        ResultKt.throwOnFailure(r114);
        long r107 = ((Number) r114).longValue();
        if (r107 == 0) goto L46;
        long r108 = r115;
        long r116 = r107;
    L22:
        long r109 = r108;
        r112 = r112 - r116;
        if (r116 > 0) goto L25;
        r111 = r105;
        r110 = r106;
    L43:
        if (r112 > 0) goto L47;
        r115 = r109;
        goto L46
    L47:
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.J$0 = r109;
        r100.J$1 = r112;
        r100.label = 1;
        r110.getClass();
        throw null;
    L25:
        r105.getClass();
        throw null;
    L14:
        if (r102 != 3) goto L17;
        r116 = r100.J$2;
        r112 = r100.J$1;
        long r117 = r100.J$0;
        r105 = (ByteChannelSequentialBase) r100.L$1;
        ByteChannelSequentialBase r118 = (ByteChannelSequentialBase) r100.L$0;
        ResultKt.throwOnFailure(r114);
        r108 = r117;
        r106 = r118;
        goto L22
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L32:
        ResultKt.throwOnFailure(r114);
        if (r110 == r111) goto L35;
        boolean r119 = true;
    L36:
        if (r119 == false) goto L50;
        if (r110.d() == null) goto L41;
        r111.close(r110.d());
        return Boxing.boxLong(0);
    L41:
        r109 = r112;
        goto L43
    L50:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L35:
        r119 = false;
    L7:
        r100 = new SequentialCopyToKt$copyToSequentialImpl$1(r113);
        goto L8
    }
}
