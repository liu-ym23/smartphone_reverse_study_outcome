package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object a(BroadcastChannel<E> r100, Function1<? super E, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$consumeEach$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$consumeEach$1 r103 = (ChannelsKt__DeprecatedKt$consumeEach$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L19;
        if (r107 != 1) goto L18;
        ChannelIterator r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel<E> r109 = (ReceiveChannel) r103.L$1;
        Function1<? super E, Unit> r110 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L15
        ChannelsKt__DeprecatedKt$consumeEach$1 r111 = r103;
        ReceiveChannel<E> r112 = r109;
        r101 = r110;
    L14:
        Object r113 = r106;
        ChannelsKt__DeprecatedKt$consumeEach$1 r114 = r111;
    L32:
        Throwable th10 = th;
        r109 = r112;
    L38:
        InlineMarker.finallyStart(1);
        r109.cancel(null);
        InlineMarker.finallyEnd(1);
        throw th10;
    L27:
        if (((Boolean) r105).booleanValue() == false) goto L29;
        r101.invoke((Object) r108.next());     // Catch: Throwable -> L32
        ReceiveChannel<E> r115 = r112;
        r103 = r114;
        r106 = r113;
    L42:
        r103.L$0 = r101;     // Catch: Throwable -> L34
        r103.L$1 = r115;     // Catch: Throwable -> L34
        r103.L$2 = r108;     // Catch: Throwable -> L34
        r103.label = 1;     // Catch: Throwable -> L34
        Object r116 = r108.hasNext(r103);     // Catch: Throwable -> L34
        if (r116 != r106) goto L25;
        return r106;
    L25:
        r111 = r103;
        r112 = r115;
        r105 = r116;
    L34:
        th10 = th;
        r109 = r115;
        goto L38
    L29:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r112.cancel(null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L15:
        th10 = th;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r105);
        ReceiveChannel<E> r118 = r100.openSubscription();
        r115 = r118;
        r108 = r118.iterator();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r109 = r118;
        th10 = th;
    L7:
        r103 = new ChannelsKt__DeprecatedKt$consumeEach$1(r102);
        goto L8
    }
}
