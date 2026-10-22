package io.ktor.utils.io;

import com.amap.api.maps.MapsInitializer;
import com.ss.ttm.player.MediaPlayer;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/t;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2", f = "ByteChannelSequential.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK}, m = "invokeSuspend", n = {"$this$readSuspendableSession"}, s = {"L$0"})
final class ByteChannelSequentialBase$peekTo$2 extends SuspendLambda implements Function2<t, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $bytesCopied;
    final /* synthetic */ ByteBuffer $destination;
    final /* synthetic */ long $destinationOffset;
    final /* synthetic */ long $max;
    final /* synthetic */ long $min;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;

    public ByteChannelSequentialBase$peekTo$2(long r100, long r101, Ref.LongRef r102, long r103, ByteBuffer r104, long r105, Continuation<? super ByteChannelSequentialBase$peekTo$2> r110) {
        this.$min = r100;
        this.$offset = r101;
        this.$bytesCopied = r102;
        this.$max = r103;
        this.$destination = r104;
        this.$destinationOffset = r105;
        super(2, r110);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        ByteChannelSequentialBase$peekTo$2 r112 = new ByteChannelSequentialBase$peekTo$2(this.$min, this.$offset, this.$bytesCopied, this.$max, this.$destination, this.$destinationOffset, r111);
        r112.L$0 = r110;
        return r112;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(t r100, Continuation<? super Unit> r101) {
        return ((ByteChannelSequentialBase$peekTo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(t r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        t r102 = (t) this.L$0;
        ResultKt.throwOnFailure(r110);
    L12:
        io.ktor.utils.io.core.internal.a r111 = r102.a(1);
        if (r111 != null) goto L15;
        AtomicReferenceFieldUpdater r112 = io.ktor.utils.io.core.internal.a.f492027j;
        r111 = io.ktor.utils.io.core.internal.a.f492030m;
    L15:
        int r103 = r111.f492022c;
        int r104 = r111.f492021b;
        long r105 = r103 - r104;
        long r106 = this.$offset;
        if (r105 <= r106) goto L19;
        this.$bytesCopied.element = Math.min(((long) (r103 - r104)) - r106, Math.min(this.$max, ((long) this.$destination.limit()) - this.$destinationOffset));
        jsc.c.b(r111.f492020a, this.$destination, this.$offset, this.$bytesCopied.element, this.$destinationOffset);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        t r113 = (t) this.L$0;
        int r107 = (int) RangesKt.coerceAtMost(this.$min + this.$offset, MapsInitializer.alc_level_ALL);
        this.L$0 = r113;
        this.label = 1;
        if (r113.f(r107, this) != r100) goto L11;
        return r100;
    L11:
        r102 = r113;
        goto L12
    }
}
