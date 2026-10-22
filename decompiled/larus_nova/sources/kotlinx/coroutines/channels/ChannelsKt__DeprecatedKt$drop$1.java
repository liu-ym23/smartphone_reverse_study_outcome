package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttm.player.MediaPlayer;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 199, 200}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$drop$1(int r100, ReceiveChannel r101, Continuation r102) {
        this.$n = r100;
        this.$this_drop = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$drop$1 r102 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0077 -> B:23:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c8 -> B:32:0x009f). Please report as a decompilation issue!!! */
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
        k r111 = r103;
        ChannelIterator r104 = r102;
        Object r105 = r100;
        ChannelsKt__DeprecatedKt$drop$1 r106 = this;
    L32:
        r106.L$0 = r111;
        r106.L$1 = r104;
        r106.label = 2;
        Object r107 = r104.hasNext(r106);
        if (r107 != r105) goto L35;
        return r105;
    L35:
        k r108 = r111;
        r110 = r107;
    L37:
        if (((Boolean) r110).booleanValue() == false) goto L43;
        Object r112 = r104.next();
        r106.L$0 = r108;
        r106.L$1 = r104;
        r106.label = 3;
        if (r108.send(r112, r106) != r105) goto L41;
        return r105;
    L41:
        r111 = r108;
        goto L32
    L43:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ChannelIterator r109 = (ChannelIterator) this.L$1;
        k r113 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r108 = r113;
        r104 = r109;
        r105 = r100;
        r106 = this;
        goto L37
    L11:
        int r114 = this.I$0;
        ChannelIterator r115 = (ChannelIterator) this.L$1;
        k r116 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        k r117 = r116;
        ChannelIterator r118 = r115;
        int r119 = r114;
        r105 = r100;
        r106 = this;
    L24:
        if (((Boolean) r110).booleanValue() == false) goto L29;
        r118.next();
        int r120 = r119 - 1;
        if (r120 == 0) goto L29;
        ChannelIterator r121 = r118;
        k r122 = r117;
        Object r123 = r105;
        int r124 = r120;
        ChannelsKt__DeprecatedKt$drop$1 r125 = r106;
        r100 = r123;
    L19:
        r125.L$0 = r122;
        r125.L$1 = r121;
        r125.I$0 = r124;
        r125.label = 1;
        Object r126 = r121.hasNext(r125);
        if (r126 != r100) goto L22;
        return r100;
    L22:
        Object r127 = r100;
        r106 = r125;
        r110 = r126;
        r117 = r122;
        r118 = r121;
        r119 = r124;
        r105 = r127;
    L29:
        r111 = r117;
    L31:
        r104 = r106.$this_drop.iterator();
        goto L32
    L12:
        ResultKt.throwOnFailure(r110);
        r111 = (k) this.L$0;
        r124 = this.$n;
        if (r124 < 0) goto L15;
        boolean r128 = true;
    L16:
        if (r128 == false) goto L45;
        if (r124 <= 0) goto L30;
        r121 = this.$this_drop.iterator();
        r122 = r111;
        r125 = this;
        goto L19
    L30:
        r105 = r100;
        r106 = this;
        goto L31
    L45:
        throw new IllegalArgumentException(("Requested element count " + r124 + " is less than zero.").toString());
    L15:
        r128 = false;
        goto L16
    }
}
