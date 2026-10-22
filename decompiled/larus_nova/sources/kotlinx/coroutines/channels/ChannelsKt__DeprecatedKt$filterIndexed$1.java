package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {241, 242, 242}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel r100, Function3 r101, Continuation r102) {
        this.$this_filterIndexed = r100;
        this.$predicate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 r102 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L13;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        int r102 = this.I$0;
        ChannelIterator r103 = (ChannelIterator) this.L$1;
        k r104 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
    L14:
        ChannelsKt__DeprecatedKt$filterIndexed$1 r111 = this;
    L15:
        r111.L$0 = r104;
        r111.L$1 = r103;
        r111.L$2 = null;
        r111.I$0 = r102;
        r111.label = 1;
        Object r105 = r103.hasNext(r111);
        if (r105 != r100) goto L18;
        return r100;
    L18:
        Object r112 = r100;
        ChannelsKt__DeprecatedKt$filterIndexed$1 r106 = r111;
        r110 = r105;
        k r107 = r104;
        ChannelIterator r108 = r103;
        int r109 = r102;
        Object r113 = r112;
    L20:
        if (((Boolean) r110).booleanValue() == false) goto L32;
        Object r114 = r108.next();
        Function3 r115 = r106.$predicate;
        int r116 = r109 + 1;
        Integer r117 = Boxing.boxInt(r109);
        r106.L$0 = r107;
        r106.L$1 = r108;
        r106.L$2 = r114;
        r106.I$0 = r116;
        r106.label = 2;
        Object r118 = r115.invoke(r117, r114, r106);
        if (r118 != r113) goto L24;
        return r113;
    L24:
        ChannelIterator r119 = r108;
        Object r120 = r114;
        r110 = r118;
    L11:
        r103 = r119;
        if (((Boolean) r110).booleanValue() == false) goto L30;
        r106.L$0 = r107;
        r106.L$1 = r103;
        r106.L$2 = null;
        r106.I$0 = r116;
        r106.label = 3;
        if (r107.send(r120, r106) != r113) goto L30;
        return r113;
    L30:
        r111 = r106;
        r100 = r113;
        r104 = r107;
        r102 = r116;
        goto L15
    L33:
        r111 = r106;
        r100 = r113;
        r104 = r107;
        r102 = r116;
        goto L15
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r121 = this.I$0;
        Object r122 = this.L$2;
        ChannelIterator r123 = (ChannelIterator) this.L$1;
        r107 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r116 = r121;
        r113 = r100;
        r106 = this;
        r119 = r123;
        r120 = r122;
        goto L11
    L12:
        int r124 = this.I$0;
        ChannelIterator r125 = (ChannelIterator) this.L$1;
        k r126 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r107 = r126;
        r108 = r125;
        r109 = r124;
        r113 = r100;
        r106 = this;
        goto L20
    L13:
        ResultKt.throwOnFailure(r110);
        k r127 = (k) this.L$0;
        r104 = r127;
        r103 = this.$this_filterIndexed.iterator();
        r102 = 0;
        goto L14
    }
}
