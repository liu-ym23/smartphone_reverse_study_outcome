package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {52, 53}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public BroadcastKt$broadcast$2(ReceiveChannel<Object> r100, Continuation<? super BroadcastKt$broadcast$2> r101) {
        this.$channel = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BroadcastKt$broadcast$2 r102 = new BroadcastKt$broadcast$2(this.$channel, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<Object> r100, Continuation<? super Unit> r101) {
        return ((BroadcastKt$broadcast$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ChannelIterator<Object> r103 = (ChannelIterator) this.L$1;
        k r104 = (k) this.L$0;
        ResultKt.throwOnFailure(r100);
        k r105 = r104;
    L11:
        BroadcastKt$broadcast$2 r106 = this;
    L12:
        r106.L$0 = r105;
        r106.L$1 = r103;
        r106.label = 1;
        Object r107 = r103.hasNext(r106);
        if (r107 != r101) goto L15;
        return r101;
    L15:
        BroadcastKt$broadcast$2 r108 = r106;
        k r109 = r105;
        r100 = r107;
        BroadcastKt$broadcast$2 r110 = r108;
    L17:
        if (((Boolean) r100).booleanValue() == false) goto L23;
        Object r111 = r103.next();
        r110.L$0 = r109;
        r110.L$1 = r103;
        r110.label = 2;
        if (r109.send(r111, r110) != r101) goto L21;
        return r101;
    L21:
        r105 = r109;
        r106 = r110;
        goto L12
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r103 = (ChannelIterator) this.L$1;
        r109 = (k) this.L$0;
        ResultKt.throwOnFailure(r100);
        r110 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r100);
        r105 = (k) this.L$0;
        r103 = this.$channel.iterator();
        goto L11
    }
}
