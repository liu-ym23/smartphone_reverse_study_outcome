package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
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
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", i = {}, l = {1539}, m = "invokeSuspend", n = {}, s = {})
public final class ClockDialNode$pointerInputDragNode$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Offset $dragAmount;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    public ClockDialNode$pointerInputDragNode$1$2$1(ClockDialNode r1, Offset r2, Continuation<? super ClockDialNode$pointerInputDragNode$1$2$1> r3) {
        this.this$0 = r1;
        this.$dragAmount = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ClockDialNode$pointerInputDragNode$1$2$1(this.this$0, this.$dragAmount, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        TimePickerKt.m3411access$moveSelectord3b8Pxo(ClockDialNode.access$getState$p(this.this$0), ClockDialNode.access$getOffsetX$p(this.this$0), ClockDialNode.access$getOffsetY$p(this.this$0), ClockDialNode.access$getMaxDist(this.this$0), ClockDialNode.m2430access$getCenternOccac(this.this$0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ClockDialNode r12 = this.this$0;
        ClockDialNode.access$setOffsetX$p(r12, ClockDialNode.access$getOffsetX$p(r12) + Float.intBitsToFloat((int) (this.$dragAmount.unbox-impl() >> 32)));
        ClockDialNode r13 = this.this$0;
        ClockDialNode.access$setOffsetY$p(r13, ClockDialNode.access$getOffsetY$p(r13) + Float.intBitsToFloat((int) (this.$dragAmount.unbox-impl() & 4294967295L)));
        AnalogTimePickerState r3 = ClockDialNode.access$getState$p(this.this$0);
        float r4 = TimePickerKt.access$atan(ClockDialNode.access$getOffsetY$p(this.this$0) - IntOffset.getY-impl(ClockDialNode.m2430access$getCenternOccac(this.this$0)), ClockDialNode.access$getOffsetX$p(this.this$0) - IntOffset.getX-impl(ClockDialNode.m2430access$getCenternOccac(this.this$0)));
        AnimationSpec r5 = ClockDialNode.access$getAnimationSpec$p(this.this$0);
        this.label = 1;
        if (AnalogTimePickerState.rotateTo$default(r3, r4, r5, false, this, 4, null) != r0) goto L11;
        return r0;
    }
}
