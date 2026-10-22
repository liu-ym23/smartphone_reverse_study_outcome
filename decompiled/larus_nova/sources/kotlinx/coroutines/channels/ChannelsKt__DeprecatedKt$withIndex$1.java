package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {400, 401}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel r100, Continuation r101) {
        this.$this_withIndex = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$withIndex$1 r102 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007f -> B:11:0x0047). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        int r102 = this.I$0;
        ChannelIterator r103 = (ChannelIterator) this.L$1;
        k r104 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        k r111 = r104;
        ChannelsKt__DeprecatedKt$withIndex$1 r105 = this;
        int r106 = r102;
        ChannelIterator r107 = r103;
    L11:
        r105.L$0 = r111;
        r105.L$1 = r107;
        r105.I$0 = r106;
        r105.label = 1;
        Object r108 = r107.hasNext(r105);
        if (r108 != r100) goto L14;
        return r100;
    L14:
        ChannelsKt__DeprecatedKt$withIndex$1 r109 = r105;
        k r112 = r111;
        r110 = r108;
        ChannelsKt__DeprecatedKt$withIndex$1 r113 = r109;
        int r114 = r106;
        ChannelIterator r115 = r107;
        int r116 = r114;
    L16:
        if (((Boolean) r110).booleanValue() == false) goto L22;
        int r117 = r116 + 1;
        IndexedValue r118 = new IndexedValue(r116, r115.next());
        r113.L$0 = r112;
        r113.L$1 = r115;
        r113.I$0 = r117;
        r113.label = 2;
        if (r112.send(r118, r113) != r100) goto L20;
        return r100;
    L20:
        r107 = r115;
        r111 = r112;
        r105 = r113;
        r106 = r117;
        goto L11
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r116 = this.I$0;
        r115 = (ChannelIterator) this.L$1;
        r112 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r113 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r110);
        r111 = (k) this.L$0;
        r107 = this.$this_withIndex.iterator();
        r106 = 0;
        r105 = this;
        goto L11
    }
}
