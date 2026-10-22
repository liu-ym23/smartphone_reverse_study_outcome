package io.ktor.util;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Inflater;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes41.dex */
public final class m {
    public static final Object a(Inflater r100, io.ktor.utils.io.d r101, ByteBuffer r102, Checksum r103, Continuation r104) {
        if ((r104 instanceof EncodersJvmKt$inflateTo$1) == false) goto L7;
        EncodersJvmKt$inflateTo$1 r105 = (EncodersJvmKt$inflateTo$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        int r110 = r105.I$0;
        ResultKt.throwOnFailure(r107);
    L18:
        return Boxing.boxInt(r110);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r102.clear();
        r110 = r100.inflate(r102.array(), r102.position(), r102.remaining());
        r102.position(r102.position() + r110);
        r102.flip();
        DeflaterKt.e(r103, r102);
        r105.I$0 = r110;
        r105.label = 1;
        if (r101.x(r102, r105) != r108) goto L18;
        return r108;
    L7:
        r105 = new EncodersJvmKt$inflateTo$1(r104);
        goto L8
    }
}
