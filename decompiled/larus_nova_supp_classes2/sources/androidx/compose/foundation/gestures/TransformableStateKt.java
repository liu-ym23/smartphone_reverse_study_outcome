package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003\u001aZ\u0010\f\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\r\u001a*\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a,\u0010\u0015\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\\\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0004\b\u001f\u0010 \u001a\u001a\u0010#\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001a\u001a\u0010%\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001a\u001c\u0010&\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,\"\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animateZoomBy", "zoomFactor", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "animatePanBy", "offset", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy", "panOffset", "rotationDegrees", "zoomAnimationSpec", "panAnimationSpec", "rotationAnimationSpec", "animateBy-Su4bsnU", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ZeroAnimationVelocity", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformableStateKt {
    private static final AnimationData ZeroAnimationVelocity = null;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $degrees;
        final /* synthetic */ Ref.FloatRef $previous;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Ref.FloatRef r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass2> r4) {
            this.$previous = r1;
            this.$degrees = r2;
            this.$animationSpec = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(Ref.FloatRef r0, TransformScope r1, AnimationScope r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$previous, this.$degrees, this.$animationSpec, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransformScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r20) {
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r20);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            final TransformScope r1 = (TransformScope) this.L$0;
            AnimationState r2 = AnimationStateKt.AnimationState$default(this.$previous.element, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
            Float r3 = Boxing.boxFloat(this.$degrees);
            AnimationSpec<Float> r4 = this.$animationSpec;
            final Ref.FloatRef r6 = this.$previous;
            Function1 r7 = new s2(r6, r1);
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(r2, r3, r4, false, r7, this, 4, null) != r9) goto L12;
            return r9;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r9, TransformScope r10, AnimationScope r11) {
            TransformScope.CC.m721transformByd4ec7I$default(r10, MenuKt.ClosedAlphaTarget, 0, ((Number) r11.getValue()).floatValue() - r9.element, 3, null);
            r9.element = ((Number) r11.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ Ref.FloatRef $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(Ref.FloatRef r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass3> r4) {
            this.$previous = r1;
            this.$zoomFactor = r2;
            this.$animationSpec = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(Ref.FloatRef r0, TransformScope r1, AnimationScope r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass3 r0 = new AnonymousClass3(this.$previous, this.$zoomFactor, this.$animationSpec, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransformScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r20) {
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r20);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            final TransformScope r1 = (TransformScope) this.L$0;
            AnimationState r2 = AnimationStateKt.AnimationState$default(this.$previous.element, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
            Float r3 = Boxing.boxFloat(this.$zoomFactor);
            AnimationSpec<Float> r4 = this.$animationSpec;
            final Ref.FloatRef r6 = this.$previous;
            Function1 r7 = new t2(r6, r1);
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(r2, r3, r4, false, r7, this, 4, null) != r9) goto L12;
            return r9;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r8, TransformScope r9, AnimationScope r10) {
            if (r8.element != MenuKt.ClosedAlphaTarget) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            float r2 = 1.0f;
        L9:
            TransformScope.CC.m721transformByd4ec7I$default(r9, r2, 0, MenuKt.ClosedAlphaTarget, 6, null);
            r8.element = ((Number) r10.getValue()).floatValue();
            return Unit.INSTANCE;
        L8:
            r2 = ((Number) r10.getValue()).floatValue() / r8.element;
            goto L9
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01642 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        public C01642(float r1, Continuation<? super C01642> r2) {
            this.$degrees = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01642 r0 = new C01642(this.$degrees, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransformScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            ((TransformScope) this.L$0).mo564transformByd4ec7I(1.0f, Offset.Companion.getZero-F1C5BW0(), this.$degrees);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01652 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        int label;

        public C01652(Continuation<? super C01652> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01652(r2);
        }

        public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransformScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01662 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        public C01662(float r1, Continuation<? super C01662> r2) {
            this.$zoomFactor = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01662 r0 = new C01662(this.$zoomFactor, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(TransformScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransformScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            ((TransformScope) this.L$0).mo564transformByd4ec7I(this.$zoomFactor, Offset.Companion.getZero-F1C5BW0(), MenuKt.ClosedAlphaTarget);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Unit a(State r0, float r1, Offset r2, float r3) {
        return rememberTransformableState$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    static {
        ZeroAnimationVelocity = new AnimationData(MenuKt.ClosedAlphaTarget, Offset.Companion.getZero-F1C5BW0(), MenuKt.ClosedAlphaTarget, null);
    }

    public static final /* synthetic */ AnimationData access$getZeroAnimationVelocity$p() {
        return ZeroAnimationVelocity;
    }

    public static final TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> r1) {
        return new DefaultTransformableState(r1);
    }

    /* JADX INFO: renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m730panByd4ec7I(TransformableState r6, long r7, Continuation<? super Unit> r9) {
        Object r8 = TransformableState.CC.transform$default(r6, null, new TransformableStateKt$panBy$2(r7, null), r9, 1, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public static final TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1681419281, r5, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:122)");
    L5:
        final State r6 = SnapshotStateKt.rememberUpdatedState(r3, r4, r5 & 14);
        Object r7 = r4.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L8;
        r7 = TransformableState(new p2(r6));
        r4.updateRememberedValue(r7);
    L8:
        TransformableState r8 = (TransformableState) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r8;
    }

    public static final Object rotateBy(TransformableState r6, float r7, Continuation<? super Unit> r8) {
        Object r9 = TransformableState.CC.transform$default(r6, null, new C01642(r7, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object stopTransformation(TransformableState r2, MutatePriority r3, Continuation<? super Unit> r4) {
        Object r5 = r2.transform(r3, new C01652(null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object zoomBy(TransformableState r6, float r7, Continuation<? super Unit> r8) {
        Object r9 = TransformableState.CC.transform$default(r6, null, new C01662(r7, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m728animatePanByubNVwUQ(TransformableState r10, long r11, AnimationSpec<Offset> r13, Continuation<? super Unit> r14) {
        Ref.LongRef r1 = new Ref.LongRef();
        r1.element = Offset.Companion.getZero-F1C5BW0();
        Object r12 = TransformableState.CC.transform$default(r10, null, new TransformableStateKt$animatePanBy$2(r1, r11, r13, null), r14, 1, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object animateRotateBy(TransformableState r7, float r8, AnimationSpec<Float> r9, Continuation<? super Unit> r10) {
        Object r11 = TransformableState.CC.transform$default(r7, null, new AnonymousClass2(new Ref.FloatRef(), r8, r9, null), r10, 1, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object animateZoomBy(TransformableState r8, float r9, AnimationSpec<Float> r10, Continuation<? super Unit> r11) {
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
    L8:
        Ref.FloatRef r1 = new Ref.FloatRef();
        r1.element = 1.0f;
        Object r12 = TransformableState.CC.transform$default(r8, null, new AnonymousClass3(r1, r9, r10, null), r11, 1, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r12;
    L12:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit rememberTransformableState$lambda$1$lambda$0(State r0, float r1, Offset r2, float r3) {
        ((Function3) r0.getValue()).invoke(Float.valueOf(r1), r2, Float.valueOf(r3));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState r0, MutatePriority r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return stopTransformation(r0, r1, r2);
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m729animatePanByubNVwUQ$default(TransformableState r6, long r7, AnimationSpec r9, Continuation r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r9 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L6:
        return m728animatePanByubNVwUQ(r6, r7, r9, r10);
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState r6, float r7, AnimationSpec r8, Continuation r9, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L6;
        r8 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L6:
        return animateRotateBy(r6, r7, r8, r9);
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState r6, float r7, AnimationSpec r8, Continuation r9, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L6;
        r8 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L6:
        return animateZoomBy(r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: animateBy-Su4bsnU, reason: not valid java name */
    public static final Object m726animateBySu4bsnU(TransformableState r8, float r9, long r10, float r12, AnimationSpec<Float> r13, AnimationSpec<Offset> r14, AnimationSpec<Float> r15, Continuation<? super Unit> r16) {
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
    L8:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = new AnimationData(1.0f, Offset.Companion.getZero-F1C5BW0(), MenuKt.ClosedAlphaTarget, null);
        Object r2 = TransformableState.CC.transform$default(r8, null, new TransformableStateKt$animateBy$3(r1, new AnimationData(r9, r10, r12, null), new DelegatingAnimationSpec(r13, r14, r15), null), r16, 1, null);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r2;
    L12:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: animateBy-Su4bsnU$default, reason: not valid java name */
    public static /* synthetic */ Object m727animateBySu4bsnU$default(TransformableState r16, float r17, long r18, float r20, AnimationSpec r21, AnimationSpec r22, AnimationSpec r23, Continuation r24, int r25, Object r26) {
        if ((r25 & 8) == 0) goto L5;
        AnimationSpec r12 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L7:
        if ((r25 & 16) == 0) goto L9;
        AnimationSpec r13 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L11:
        if ((r25 & 32) == 0) goto L13;
        AnimationSpec r14 = new SpringSpec(MenuKt.ClosedAlphaTarget, 200.0f, null, 5, null);
    L15:
        return m726animateBySu4bsnU(r16, r17, r18, r20, r12, r13, r14, r24);
    L13:
        r14 = r23;
        goto L15
    L9:
        r13 = r22;
        goto L11
    L5:
        r12 = r21;
        goto L7
    }
}
