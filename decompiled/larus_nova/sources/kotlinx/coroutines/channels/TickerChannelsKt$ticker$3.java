package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {68, 69}, m = "invokeSuspend", n = {}, s = {})
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<k<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f504672a = null;

        static {
            int[] r100 = new int[TickerMode.values().length];
            r100[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f504672a = r100;
        }
    }

    public TickerChannelsKt$ticker$3(TickerMode r100, long r101, long r102, Continuation<? super TickerChannelsKt$ticker$3> r103) {
        this.$mode = r100;
        this.$delayMillis = r101;
        this.$initialDelayMillis = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        TickerChannelsKt$ticker$3 r101 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super Unit> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super Unit> r100, Continuation<? super Unit> r101) {
        return ((TickerChannelsKt$ticker$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L6;
        if (r101 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r110);
    L20:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r110);
        k r111 = (k) this.L$0;
        TickerMode r102 = this.$mode;
        int r103 = a.f504672a[r102.ordinal()];
        if (r103 == 1) goto L16;
        if (r103 != 2) goto L20;
        long r104 = this.$delayMillis;
        long r105 = this.$initialDelayMillis;
        SendChannel r106 = r111.getChannel();
        this.label = 2;
        if (m.a(r104, r105, r106, this) != r100) goto L20;
        return r100;
    L16:
        long r107 = this.$delayMillis;
        long r108 = this.$initialDelayMillis;
        SendChannel r112 = r111.getChannel();
        this.label = 1;
        if (m.b(r107, r108, r112, this) != r100) goto L20;
        return r100;
    }
}
