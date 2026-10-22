package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
public final class WritingKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:39:0x009c). Please report as a decompilation issue!!! */
    public static final Object a(ByteReadChannel r100, final WritableByteChannel r101, final long r110, Continuation<? super Long> r111) {
        if ((r111 instanceof WritingKt$copyTo$1) == false) goto L7;
        WritingKt$copyTo$1 r102 = (WritingKt$copyTo$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r106 = r102.J$0;
        Function1<ByteBuffer, Unit> r113 = (Function1) r102.L$2;
        Ref.LongRef r114 = (Ref.LongRef) r102.L$1;
        ByteReadChannel r107 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r112);
        final Ref.LongRef r115 = r114;
        Function1<ByteBuffer, Unit> r108 = r113;
        r110 = r106;
        r100 = r107;
    L40:
        if (r100.E() == false) goto L35;
    L41:
        Throwable r109 = r100.d();
        if (r109 == null) goto L44;
        throw r109;
    L44:
        return Boxing.boxLong(r115.element);
    L35:
        if (r115.element >= r110) goto L41;
        r102.L$0 = r100;
        r102.L$1 = r115;
        r102.L$2 = r108;
        r102.J$0 = r110;
        r102.label = 1;
        if (r100.m(0, r108, r102) != r104) goto L40;
        return r104;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r110 < 0) goto L17;
        boolean r116 = true;
    L18:
        if (r116 == false) goto L47;
        if ((r101 instanceof SelectableChannel) == false) goto L27;
        if (((SelectableChannel) r101).isBlocking() == true) goto L27;
        throw new IllegalArgumentException("Non-blocking channels are not supported");
    L27:
        if (r100.E() == false) goto L33;
        Throwable r117 = r100.d();
        if (r117 == null) goto L31;
        throw r117;
    L31:
        return Boxing.boxLong(0);
    L33:
        r115 = new Ref.LongRef();
        r108 = new WritingKt$copyTo$copy$1(r110, r115, r101);
        goto L35
    L47:
        throw new IllegalArgumentException(("Limit shouldn't be negative: " + r110).toString());
    L17:
        r116 = false;
    L7:
        r102 = new WritingKt$copyTo$1(r111);
        goto L8
    }
}
