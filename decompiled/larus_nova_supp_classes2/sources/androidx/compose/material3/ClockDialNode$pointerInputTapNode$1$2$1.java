package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$2$1", f = "TimePicker.kt", i = {}, l = {1509}, m = "invokeSuspend", n = {}, s = {})
public final class ClockDialNode$pointerInputTapNode$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Offset $it;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    public ClockDialNode$pointerInputTapNode$1$2$1(ClockDialNode r1, Offset r2, Continuation<? super ClockDialNode$pointerInputTapNode$1$2$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ClockDialNode$pointerInputTapNode$1$2$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AnalogTimePickerState r3 = ClockDialNode.access$getState$p(this.this$0);
        float r4 = Float.intBitsToFloat((int) (this.$it.unbox-impl() >> 32));
        float r5 = Float.intBitsToFloat((int) (this.$it.unbox-impl() & 4294967295L));
        float r6 = ClockDialNode.access$getMaxDist(this.this$0);
        boolean r7 = ClockDialNode.access$getAutoSwitchToMinute$p(this.this$0);
        long r8 = ClockDialNode.m2430access$getCenternOccac(this.this$0);
        AnimationSpec r10 = ClockDialNode.access$getAnimationSpec$p(this.this$0);
        this.label = 1;
        if (TimePickerKt.m3412access$onTapuYHVD98(r3, r4, r5, r6, r7, r8, r10, this) != r0) goto L12;
        return r0;
    }
}
