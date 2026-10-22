package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttm.player.MediaPlayer;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, Object, Continuation<Object>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<Object> r100, Function3<? super Integer, Object, ? super Continuation<Object>, ? extends Object> r101, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> r102) {
        this.$this_mapIndexed = r100;
        this.$transform = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 r102 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<Object> r100, Continuation<? super Unit> r101) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ab -> B:13:0x005c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        int r102 = this.I$0;
        ChannelIterator<Object> r103 = (ChannelIterator) this.L$1;
        k r104 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        k r111 = r104;
        ChannelsKt__DeprecatedKt$mapIndexed$1 r105 = this;
    L13:
        r105.L$0 = r111;
        r105.L$1 = r103;
        r105.I$0 = r102;
        r105.label = 1;
        Object r106 = r103.hasNext(r105);
        if (r106 != r100) goto L16;
        return r100;
    L16:
        ChannelsKt__DeprecatedKt$mapIndexed$1 r112 = r105;
        k r107 = r111;
        r110 = r106;
        ChannelsKt__DeprecatedKt$mapIndexed$1 r108 = r112;
    L18:
        if (((Boolean) r110).booleanValue() == false) goto L28;
        Object r113 = r103.next();
        Function3<Integer, Object, Continuation<Object>, Object> r109 = r108.$transform;
        int r114 = r102 + 1;
        Integer r115 = Boxing.boxInt(r102);
        r108.L$0 = r107;
        r108.L$1 = r103;
        r108.L$2 = r107;
        r108.I$0 = r114;
        r108.label = 2;
        r110 = r109.invoke(r115, r113, r108);
        if (r110 != r100) goto L22;
        return r100;
    L22:
        ChannelsKt__DeprecatedKt$mapIndexed$1 r116 = r108;
        r102 = r114;
        k r117 = r107;
        ChannelIterator<Object> r118 = r103;
        k r119 = r117;
    L23:
        r116.L$0 = r117;
        r116.L$1 = r118;
        r116.L$2 = null;
        r116.I$0 = r102;
        r116.label = 3;
        if (r119.send(r110, r116) != r100) goto L26;
        return r100;
    L26:
        r103 = r118;
        r111 = r117;
        r105 = r116;
        goto L13
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r102 = this.I$0;
        r119 = (k) this.L$2;
        r118 = (ChannelIterator) this.L$1;
        r117 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r116 = this;
        goto L23
    L11:
        r102 = this.I$0;
        r103 = (ChannelIterator) this.L$1;
        r107 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r108 = this;
        goto L18
    L12:
        ResultKt.throwOnFailure(r110);
        r111 = (k) this.L$0;
        r105 = this;
        r103 = this.$this_mapIndexed.iterator();
        r102 = 0;
        goto L13
    }
}
