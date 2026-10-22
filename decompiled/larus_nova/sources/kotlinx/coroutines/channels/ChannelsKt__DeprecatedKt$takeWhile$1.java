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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {299, 300, 301}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel r100, Function2 r101, Continuation r102) {
        this.$this_takeWhile = r100;
        this.$predicate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$takeWhile$1 r102 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a7 -> B:14:0x0057). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        ChannelIterator r102 = (ChannelIterator) this.L$1;
        k r103 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
    L13:
        ChannelsKt__DeprecatedKt$takeWhile$1 r111 = this;
    L14:
        r111.L$0 = r103;
        r111.L$1 = r102;
        r111.label = 1;
        Object r104 = r102.hasNext(r111);
        if (r104 != r100) goto L17;
        return r100;
    L17:
        Object r105 = r100;
        ChannelsKt__DeprecatedKt$takeWhile$1 r106 = r111;
        r110 = r104;
        k r107 = r103;
        ChannelIterator r108 = r102;
        Object r109 = r105;
    L19:
        if (((Boolean) r110).booleanValue() == false) goto L33;
        Object r112 = r108.next();
        Function2 r113 = r106.$predicate;
        r106.L$0 = r107;
        r106.L$1 = r108;
        r106.L$2 = r112;
        r106.label = 2;
        Object r114 = r113.invoke(r112, r106);
        if (r114 != r109) goto L23;
        return r109;
    L23:
        ChannelIterator r115 = r108;
        Object r116 = r112;
        r110 = r114;
        k r117 = r107;
        ChannelIterator r118 = r115;
    L25:
        if (((Boolean) r110).booleanValue() == false) goto L27;
        r106.L$0 = r117;
        r106.L$1 = r118;
        r106.L$2 = null;
        r106.label = 3;
        if (r117.send(r116, r106) != r109) goto L31;
        return r109;
    L31:
        r111 = r106;
        r100 = r109;
        r102 = r118;
        r103 = r117;
        goto L14
    L27:
        return Unit.INSTANCE;
    L33:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r119 = this.L$2;
        ChannelIterator r120 = (ChannelIterator) this.L$1;
        k r121 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r117 = r121;
        r118 = r120;
        r116 = r119;
        r109 = r100;
        r106 = this;
        goto L25
    L11:
        ChannelIterator r122 = (ChannelIterator) this.L$1;
        k r123 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r107 = r123;
        r108 = r122;
        r109 = r100;
        r106 = this;
        goto L19
    L12:
        ResultKt.throwOnFailure(r110);
        k r124 = (k) this.L$0;
        r102 = this.$this_takeWhile.iterator();
        r103 = r124;
        goto L13
    }
}
