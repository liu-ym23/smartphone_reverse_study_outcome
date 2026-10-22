package kotlinx.coroutines.flow;

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

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<Object> $downStream;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<Object> r100, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r101) {
        this.$downStream = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r102 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Object r103 = this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        Object r104 = r103;
    L16:
        if ((r104 instanceof kotlinx.coroutines.channels.g.a) == false) goto L23;
        Throwable r105 = kotlinx.coroutines.channels.g.a(r104);
        if (r105 == null) goto L20;
        throw r105;
    L20:
        return Boxing.boxBoolean(false);
    L23:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = ((kotlinx.coroutines.channels.g) this.L$0).f504697a;
        FlowCollector<Object> r106 = this.$downStream;
        if ((r104 instanceof kotlinx.coroutines.channels.g.c) == true) goto L16;
        this.L$0 = r104;
        this.label = 1;
        if (r106.emit(r104, this) != r101) goto L13;
        return r101;
    L13:
        r103 = r104;
        goto L14
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<Object> r100, Continuation<? super Boolean> r101) {
        return m10971invokeWpGqRn0(r100.f504697a, r101);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m10971invokeWpGqRn0(Object r100, Continuation<? super Boolean> r101) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(new kotlinx.coroutines.channels.g(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }
}
