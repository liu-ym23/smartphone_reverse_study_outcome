package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/ScrollableDefaultFlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "motionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/ui/MotionDurationScale;)V", "lastAnimationCycleCount", "", "getLastAnimationCycleCount", "()I", "setLastAnimationCycleCount", "(I)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDensity", "", "density", "Landroidx/compose/ui/unit/Density;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultFlingBehavior implements ScrollableDefaultFlingBehavior {
    public static final int $stable = 0;
    private DecayAnimationSpec<Float> flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", i = {0, 0}, l = {981}, m = "invokeSuspend", n = {"velocityLeft", "animationState"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
        final /* synthetic */ float $initialVelocity;
        final /* synthetic */ ScrollScope $this_performFling;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DefaultFlingBehavior this$0;

        public AnonymousClass2(float r1, DefaultFlingBehavior r2, ScrollScope r3, Continuation<? super AnonymousClass2> r4) {
            this.$initialVelocity = r1;
            this.this$0 = r2;
            this.$this_performFling = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(Ref.FloatRef r0, ScrollScope r1, Ref.FloatRef r2, DefaultFlingBehavior r3, AnimationScope r4) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$initialVelocity, this.this$0, this.$this_performFling, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Float> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 != 1) goto L9;
            AnimationState r1 = (AnimationState) this.L$1;
            Ref.FloatRef r2 = (Ref.FloatRef) this.L$0;
            ResultKt.throwOnFailure(r20);     // Catch: CancellationException -> L23
        L19:
            float r3 = r2.element;
        L22:
            return Boxing.boxFloat(r3);
        L18:
            r2.element = ((Number) r1.getVelocity()).floatValue();
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r20);
            if (Math.abs(this.$initialVelocity) <= 1.0f) goto L20;
            final Ref.FloatRef r9 = new Ref.FloatRef();
            r9.element = this.$initialVelocity;
            final Ref.FloatRef r4 = new Ref.FloatRef();
            AnimationState r10 = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, this.$initialVelocity, 0, 0, false, 28, null);
            DecayAnimationSpec r5 = DefaultFlingBehavior.access$getFlingDecay$p(this.this$0);     // Catch: CancellationException -> L17
            final ScrollScope r6 = this.$this_performFling;     // Catch: CancellationException -> L17
            final DefaultFlingBehavior r7 = this.this$0;     // Catch: CancellationException -> L17
            Function1 r11 = new f0(r4, r6, r9, r7);     // Catch: CancellationException -> L17
            this.L$0 = r9;     // Catch: CancellationException -> L17
            this.L$1 = r10;     // Catch: CancellationException -> L17
            this.label = 1;     // Catch: CancellationException -> L17
            if (SuspendAnimationKt.animateDecay$default(r10, r5, false, r11, this, 2, null) != r8) goto L16;
            return r8;
        L16:
            r2 = r9;
        L17:
            r2 = r9;
            r1 = r10;
            goto L18
        L20:
            r3 = this.$initialVelocity;
            goto L22
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r2, ScrollScope r3, Ref.FloatRef r4, DefaultFlingBehavior r5, AnimationScope r6) {
            float r0 = ((Number) r6.getValue()).floatValue() - r2.element;
            float r7 = r3.scrollBy(r0);
            r2.element = ((Number) r6.getValue()).floatValue();
            r4.element = ((Number) r6.getVelocity()).floatValue();
            if (Math.abs(r0 - r7) <= 0.5f) goto L5;
            r6.cancelAnimation();
        L5:
            r5.setLastAnimationCycleCount(r5.getLastAnimationCycleCount() + 1);
            return Unit.INSTANCE;
        }
    }

    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    public static final /* synthetic */ DecayAnimationSpec access$getFlingDecay$p(DefaultFlingBehavior r0) {
        return r0.flingDecay;
    }

    public final void setLastAnimationCycleCount(int r1) {
        this.lastAnimationCycleCount = r1;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableDefaultFlingBehavior
    public void updateDensity(Density r1) {
        this.flingDecay = SplineBasedDecayKt.splineBasedDecay(r1);
    }

    public DefaultFlingBehavior(DecayAnimationSpec<Float> r1, MotionDurationScale r2) {
        this.flingDecay = r1;
        this.motionDurationScale = r2;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope r4, float r5, Continuation<? super Float> r6) {
        this.lastAnimationCycleCount = 0;
        return BuildersKt.withContext(this.motionDurationScale, new AnonymousClass2(r5, this, r4, null), r6);
    }

    public /* synthetic */ DefaultFlingBehavior(DecayAnimationSpec r1, MotionDurationScale r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ScrollableKt.getDefaultScrollMotionDurationScale();
    L5:
        this(r1, r2);
    }
}
