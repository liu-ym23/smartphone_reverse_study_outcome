package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> r100, ReceiveChannel<Unit> r101, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r102) {
        this.$lastValue = r100;
        this.$ticker = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowKt__DelayKt$sample$2$1$1 r102 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.b0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        ?? r101 = ((kotlinx.coroutines.channels.g) this.L$0).f504697a;
        Ref.ObjectRef<Object> r102 = this.$lastValue;
        boolean r103 = r101 instanceof kotlinx.coroutines.channels.g.c;
        if (r103 == true) goto L7;
        r102.element = r101;
    L7:
        ReceiveChannel<Unit> r104 = this.$ticker;
        if (r103 == false) goto L14;
        Throwable r105 = kotlinx.coroutines.channels.g.a(r101);
        if (r105 != null) goto L12;
        r104.cancel(new ChildCancelledException());
        r102.element = kotlinx.coroutines.flow.internal.o.f504894c;
        goto L14
    L12:
        throw r105;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<? extends Object> r100, Continuation<? super Unit> r101) {
        return m10970invokeWpGqRn0(r100.f504697a, r101);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m10970invokeWpGqRn0(Object r100, Continuation<? super Unit> r101) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(new kotlinx.coroutines.channels.g(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }
}
