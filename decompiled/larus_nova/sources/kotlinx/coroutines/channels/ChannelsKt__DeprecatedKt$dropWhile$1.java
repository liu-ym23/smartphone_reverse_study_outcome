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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {211, 212, 213, 217, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel r100, Function2 r101, Continuation r102) {
        this.$this_dropWhile = r100;
        this.$predicate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$dropWhile$1 r102 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b1 -> B:27:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0102 -> B:35:0x00d9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L12;
        if (r101 != 5) goto L11;
        ChannelIterator r102 = (ChannelIterator) this.L$1;
        k r103 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        ChannelIterator r111 = r102;
        k r104 = r103;
        Object r105 = r100;
        ChannelsKt__DeprecatedKt$dropWhile$1 r106 = this;
    L35:
        r106.L$0 = r104;
        r106.L$1 = r111;
        r106.label = 4;
        Object r107 = r111.hasNext(r106);
        if (r107 != r105) goto L38;
        return r105;
    L38:
        ChannelIterator r108 = r111;
        r110 = r107;
    L40:
        if (((Boolean) r110).booleanValue() == false) goto L46;
        Object r112 = r108.next();
        r106.L$0 = r104;
        r106.L$1 = r108;
        r106.label = 5;
        if (r104.send(r112, r106) != r105) goto L44;
        return r105;
    L44:
        r111 = r108;
        goto L35
    L46:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ChannelIterator r109 = (ChannelIterator) this.L$1;
        k r113 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r104 = r113;
        r108 = r109;
        r105 = r100;
        r106 = this;
        goto L40
    L13:
        k r114 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        k r115 = r114;
        r105 = r100;
        r106 = this;
    L32:
        r104 = r115;
    L34:
        r111 = r106.$this_dropWhile.iterator();
        goto L35
    L14:
        Object r116 = this.L$2;
        ChannelIterator r117 = (ChannelIterator) this.L$1;
        k r118 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r115 = r118;
        Object r119 = r116;
        r105 = r100;
        r106 = this;
    L28:
        if (((Boolean) r110).booleanValue() == true) goto L33;
        r106.L$0 = r115;
        r106.L$1 = null;
        r106.L$2 = null;
        r106.label = 3;
        if (r115.send(r119, r106) != r105) goto L32;
        return r105;
    L33:
        ChannelsKt__DeprecatedKt$dropWhile$1 r120 = r106;
        r100 = r105;
        ChannelIterator r121 = r117;
        k r122 = r115;
    L17:
        r120.L$0 = r122;
        r120.L$1 = r121;
        r120.L$2 = null;
        r120.label = 1;
        Object r123 = r121.hasNext(r120);
        if (r123 != r100) goto L20;
        return r100;
    L20:
        Object r124 = r100;
        r106 = r120;
        r110 = r123;
        r104 = r122;
        r117 = r121;
        r105 = r124;
    L22:
        if (((Boolean) r110).booleanValue() == false) goto L34;
        Object r125 = r117.next();
        Function2 r126 = r106.$predicate;
        r106.L$0 = r104;
        r106.L$1 = r117;
        r106.L$2 = r125;
        r106.label = 2;
        Object r127 = r126.invoke(r125, r106);
        if (r127 != r105) goto L26;
        return r105;
    L26:
        k r128 = r104;
        r119 = r125;
        r110 = r127;
        r115 = r128;
        goto L28
    L15:
        ChannelIterator r129 = (ChannelIterator) this.L$1;
        k r130 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r104 = r130;
        r117 = r129;
        r105 = r100;
        r106 = this;
        goto L22
    L16:
        ResultKt.throwOnFailure(r110);
        k r131 = (k) this.L$0;
        r121 = this.$this_dropWhile.iterator();
        r122 = r131;
        r120 = this;
        goto L17
    }
}
