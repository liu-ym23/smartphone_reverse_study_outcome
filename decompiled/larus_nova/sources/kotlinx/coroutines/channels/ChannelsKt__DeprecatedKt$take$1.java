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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChannelsKt__DeprecatedKt$take$1(int r100, ReceiveChannel r101, Continuation r102) {
        this.$n = r100;
        this.$this_take = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$take$1 r102 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((k) r100, (Continuation) r101);
    }

    public final Object invoke(k r100, Continuation r101) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0080 -> B:29:0x0082). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        int r103 = this.I$0;
        ChannelIterator r104 = (ChannelIterator) this.L$1;
        k r105 = (k) this.L$0;
        ResultKt.throwOnFailure(r100);
        k r106 = r105;
        ChannelsKt__DeprecatedKt$take$1 r107 = this;
    L29:
        r103 = r103 - 1;
        if (r103 == 0) goto L32;
    L19:
        r107.L$0 = r106;
        r107.L$1 = r104;
        r107.I$0 = r103;
        r107.label = 1;
        Object r108 = r104.hasNext(r107);
        if (r108 != r101) goto L22;
        return r101;
    L22:
        ChannelsKt__DeprecatedKt$take$1 r109 = r107;
        k r110 = r106;
        r100 = r108;
        ChannelsKt__DeprecatedKt$take$1 r111 = r109;
    L24:
        if (((Boolean) r100).booleanValue() == false) goto L34;
        Object r112 = r104.next();
        r111.L$0 = r110;
        r111.L$1 = r104;
        r111.I$0 = r103;
        r111.label = 2;
        if (r110.send(r112, r111) != r101) goto L28;
        return r101;
    L28:
        r106 = r110;
        r107 = r111;
        goto L29
    L34:
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r103 = this.I$0;
        r104 = (ChannelIterator) this.L$1;
        r110 = (k) this.L$0;
        ResultKt.throwOnFailure(r100);
        r111 = this;
        goto L24
    L10:
        ResultKt.throwOnFailure(r100);
        r106 = (k) this.L$0;
        r103 = this.$n;
        if (r103 == 0) goto L13;
        if (r103 < 0) goto L16;
        boolean r113 = true;
    L17:
        if (r113 == false) goto L36;
        r104 = this.$this_take.iterator();
        r107 = this;
        goto L19
    L36:
        throw new IllegalArgumentException(("Requested element count " + r103 + " is less than zero.").toString());
    L16:
        r113 = false;
        goto L17
    L13:
        return Unit.INSTANCE;
    }
}
