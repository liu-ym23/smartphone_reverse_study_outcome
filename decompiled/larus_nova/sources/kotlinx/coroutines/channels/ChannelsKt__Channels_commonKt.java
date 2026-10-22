package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final <E> Object a(ReceiveChannel<? extends E> r100, Function1<? super E, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ChannelsKt__Channels_commonKt$consumeEach$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$1 r103 = (ChannelsKt__Channels_commonKt$consumeEach$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        ChannelIterator r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel<? extends E> r109 = (ReceiveChannel) r103.L$1;
        Function1<? super E, Unit> r110 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r105).booleanValue() == false) goto L28;
        r110.invoke((Object) r108.next());     // Catch: Throwable -> L14
        Function1<? super E, Unit> r111 = r110;
    L21:
        r103.L$0 = r111;     // Catch: Throwable -> L14
        r103.L$1 = r109;     // Catch: Throwable -> L14
        r103.L$2 = r108;     // Catch: Throwable -> L14
        r103.label = 1;     // Catch: Throwable -> L14
        Object r112 = r108.hasNext(r103);     // Catch: Throwable -> L14
        if (r112 != r106) goto L24;
        return r106;
    L24:
        r110 = r111;
        r105 = r112;
        goto L26
    L28:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r109, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L14:
        Throwable th10 = th;
    L37:
        throw th10;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(r109, th10);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        r109 = r100;
        r108 = r100.iterator();     // Catch: Throwable -> L31
        r111 = r101;
    L31:
        th = move-exception;
        r109 = r100;
        th10 = th;
    L7:
        r103 = new ChannelsKt__Channels_commonKt$consumeEach$1(r102);
        goto L8
    }
}
