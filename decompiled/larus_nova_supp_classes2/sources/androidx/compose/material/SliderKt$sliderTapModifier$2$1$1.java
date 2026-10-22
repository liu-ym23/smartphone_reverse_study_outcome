package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SliderKt$sliderTapModifier$2$1$1 implements PointerInputEventHandler {
    final /* synthetic */ DraggableState $draggableState;
    final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ float $maxPx;
    final /* synthetic */ MutableState<Float> $pressOffset;
    final /* synthetic */ State<Float> $rawOffset;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pos", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$1", f = "Slider.kt", i = {}, l = {1009}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ MutableState<Float> $pressOffset;
        final /* synthetic */ State<Float> $rawOffset;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(boolean r1, float r2, MutableState<Float> r3, State<Float> r4, Continuation<? super AnonymousClass1> r5) {
            this.$isRtl = r1;
            this.$maxPx = r2;
            this.$pressOffset = r3;
            this.$rawOffset = r4;
            super(3, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return m2154invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m2154invoked4ec7I(PressGestureScope r8, long r9, Continuation<? super Unit> r11) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, r11);
            r6.L$0 = r8;
            r6.J$0 = r9;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: GestureCancellationException -> L17
        L20:
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            PressGestureScope r8 = (PressGestureScope) this.L$0;
            long r3 = this.J$0;
            if (this.$isRtl == false) goto L12;
            float r2 = this.$maxPx - Float.intBitsToFloat((int) (r3 >> 32));
        L13:
            this.$pressOffset.setValue(Boxing.boxFloat(r2 - ((Number) this.$rawOffset.getValue()).floatValue()));
            this.label = 1;     // Catch: GestureCancellationException -> L17
            if (r8.awaitRelease(this) != r0) goto L20;
            return r0;
        L12:
            r2 = Float.intBitsToFloat((int) (r3 >> 32));
        L17:
            this.$pressOffset.setValue(Boxing.boxFloat(androidx.compose.material3.MenuKt.ClosedAlphaTarget));
            goto L19
        }
    }

    public SliderKt$sliderTapModifier$2$1$1(boolean r1, float r2, MutableState<Float> r3, State<Float> r4, CoroutineScope r5, DraggableState r6, State<? extends Function1<? super Float, Unit>> r7) {
        this.$isRtl = r1;
        this.$maxPx = r2;
        this.$pressOffset = r3;
        this.$rawOffset = r4;
        this.$scope = r5;
        this.$draggableState = r6;
        this.$gestureEndAction = r7;
    }

    public static /* synthetic */ Unit a(CoroutineScope r0, DraggableState r1, State r2, Offset r3) {
        return invoke$lambda$0(r0, r1, r2, r3);
    }

    public final Object invoke(PointerInputScope r11, Continuation<? super Unit> r12) {
        AnonymousClass1 r9 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
        final CoroutineScope r0 = this.$scope;
        final DraggableState r3 = this.$draggableState;
        final State<Function1<Float, Unit>> r4 = this.$gestureEndAction;
        Object r13 = TapGestureDetectorKt.detectTapGestures$default(r11, null, null, r9, new ea(r0, r3, r4), r12, 3, null);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$0(CoroutineScope r6, DraggableState r7, State r8, Offset r9) {
        BuildersKt.launch$default(r6, null, null, new SliderKt$sliderTapModifier$2$1$1$2$1(r7, r8, null), 3, null);
        return Unit.INSTANCE;
    }
}
