package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {VideoRef.VALUE_VIDEO_REF_CONST_DEPTH}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<Object> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r100, FlowCollector<Object> r101, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r102) {
        this.$lastValue = r100;
        this.$downstream = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r102 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.internal.b0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Ref.ObjectRef<Object> r103 = (Ref.ObjectRef) this.L$1;
        ResultKt.throwOnFailure(r100);
    L24:
        Ref.ObjectRef<Object> r104 = r103;
    L25:
        r104.element = kotlinx.coroutines.flow.internal.o.f504894c;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ?? r105 = ((kotlinx.coroutines.channels.g) this.L$0).f504697a;
        r104 = this.$lastValue;
        boolean r106 = r105 instanceof kotlinx.coroutines.channels.g.c;
        if (r106 == true) goto L11;
        r104.element = r105;
    L11:
        FlowCollector<Object> r107 = this.$downstream;
        if (r106 == false) goto L28;
        Throwable r108 = kotlinx.coroutines.channels.g.a(r105);
        if (r108 != null) goto L26;
        Object r109 = r104.element;
        if (r109 == null) goto L25;
        if (r109 != kotlinx.coroutines.flow.internal.o.f504892a) goto L20;
        r109 = null;
    L20:
        this.L$0 = r105;
        this.L$1 = r104;
        this.label = 1;
        if (r107.emit(r109, this) != r101) goto L23;
        return r101;
    L23:
        r103 = r104;
        goto L24
    L26:
        throw r108;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<? extends Object> r100, Continuation<? super Unit> r101) {
        return m10969invokeWpGqRn0(r100.f504697a, r101);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m10969invokeWpGqRn0(Object r100, Continuation<? super Unit> r101) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(new kotlinx.coroutines.channels.g(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }
}
