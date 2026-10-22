package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0090 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public static final <T> Object a(FlowCollector<? super T> r100, ReceiveChannel<? extends T> r101, boolean r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r104 = (FlowKt__ChannelsKt$emitAllImpl$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L20;
        if (r108 == 1) goto L17;
        if (r108 != 2) goto L16;
        r102 = r104.Z$0;
        ChannelIterator<? extends T> r109 = (ChannelIterator) r104.L$2;
        r101 = (ReceiveChannel) r104.L$1;
        FlowCollector<? super T> r110 = (FlowCollector) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L36
    L14:
        ChannelIterator<? extends T> r111 = r109;
        r100 = r110;
    L23:
        r104.L$0 = r100;     // Catch: Throwable -> L36
        r104.L$1 = r101;     // Catch: Throwable -> L36
        r104.L$2 = r111;     // Catch: Throwable -> L36
        r104.Z$0 = r102;     // Catch: Throwable -> L36
        r104.label = 1;     // Catch: Throwable -> L36
        Object r112 = r111.hasNext(r104);     // Catch: Throwable -> L36
        if (r112 != r107) goto L26;
        return r107;
    L26:
        r110 = r100;
        r109 = r111;
        r106 = r112;
    L28:
        if (((Boolean) r106).booleanValue() == false) goto L32;
        T r113 = r109.next();     // Catch: Throwable -> L36
        r104.L$0 = r110;     // Catch: Throwable -> L36
        r104.L$1 = r101;     // Catch: Throwable -> L36
        r104.L$2 = r109;     // Catch: Throwable -> L36
        r104.Z$0 = r102;     // Catch: Throwable -> L36
        r104.label = 2;     // Catch: Throwable -> L36
        if (r110.emit(r113, r104) != r107) goto L14;
        return r107;
    L32:
        if (r102 == false) goto L35;
        ChannelsKt.cancelConsumed(r101, null);
    L35:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r102 = r104.Z$0;
        r109 = (ChannelIterator) r104.L$2;
        r101 = (ReceiveChannel) r104.L$1;
        r110 = (FlowCollector) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L36
        goto L28
    L20:
        ResultKt.throwOnFailure(r106);
        if ((r100 instanceof l1) == true) goto L43;
        r111 = r101.iterator();     // Catch: Throwable -> L36
        goto L23
    L43:
        throw ((l1) r100).f504901a;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r102 == false) goto L41;
        ChannelsKt.cancelConsumed(r101, th);
    L41:
        throw th;
    L7:
        r104 = new FlowKt__ChannelsKt$emitAllImpl$1(r103);
        goto L8
    }
}
