package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1", f = "Slider.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$RangeSlider$2$gestureEndAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $current;
    final /* synthetic */ boolean $isStart;
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableFloatState $rawOffsetEnd;
    final /* synthetic */ MutableFloatState $rawOffsetStart;
    final /* synthetic */ float $target;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    int label;

    public SliderKt$RangeSlider$2$gestureEndAction$1$1$1(float r1, float r2, Function0<Unit> r3, boolean r4, MutableFloatState r5, MutableFloatState r6, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> r7, Ref.FloatRef r8, Ref.FloatRef r9, ClosedFloatingPointRange<Float> r10, Continuation<? super SliderKt$RangeSlider$2$gestureEndAction$1$1$1> r11) {
        this.$current = r1;
        this.$target = r2;
        this.$onValueChangeFinished = r3;
        this.$isStart = r4;
        this.$rawOffsetStart = r5;
        this.$rawOffsetEnd = r6;
        this.$onValueChangeState = r7;
        this.$minPx = r8;
        this.$maxPx = r9;
        this.$valueRange = r10;
        super(2, r11);
    }

    public static /* synthetic */ Unit a(boolean r0, MutableFloatState r1, MutableFloatState r2, State r3, Ref.FloatRef r4, Ref.FloatRef r5, ClosedFloatingPointRange r6, Animatable r7) {
        return invokeSuspend$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new SliderKt$RangeSlider$2$gestureEndAction$1$1$1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L11:
        Function0<Unit> r1 = this.$onValueChangeFinished;
        if (r1 == null) goto L15;
        r1.invoke();
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        Animatable r2 = AnimatableKt.Animatable$default(this.$current, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        Float r3 = Boxing.boxFloat(this.$target);
        TweenSpec r4 = SliderKt.access$getSliderToTickAnimation$p();
        Float r5 = Boxing.boxFloat(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        final boolean r9 = this.$isStart;
        final MutableFloatState r10 = this.$rawOffsetStart;
        final MutableFloatState r11 = this.$rawOffsetEnd;
        final State<Function1<ClosedFloatingPointRange<Float>, Unit>> r12 = this.$onValueChangeState;
        final Ref.FloatRef r13 = this.$minPx;
        final Ref.FloatRef r14 = this.$maxPx;
        final ClosedFloatingPointRange<Float> r15 = this.$valueRange;
        Function1 r6 = new z9(r9, r10, r11, r12, r13, r14, r15);
        this.label = 1;
        if (r2.animateTo(r3, r4, r5, r6, this) != r7) goto L11;
        return r7;
    }

    private static final Unit invokeSuspend$lambda$0(boolean r0, MutableFloatState r1, MutableFloatState r2, State r3, Ref.FloatRef r4, Ref.FloatRef r5, ClosedFloatingPointRange r6, Animatable r7) {
        if (r0 == false) goto L4;
        MutableFloatState r8 = r1;
    L5:
        r8.setFloatValue(((Number) r7.getValue()).floatValue());
        ((Function1) r3.getValue()).invoke(SliderKt.AnonymousClass2.access$invoke$scaleToUserValue(r4, r5, r6, RangesKt.rangeTo(r1.getFloatValue(), r2.getFloatValue())));
        return Unit.INSTANCE;
    L4:
        r8 = r2;
        goto L5
    }
}
