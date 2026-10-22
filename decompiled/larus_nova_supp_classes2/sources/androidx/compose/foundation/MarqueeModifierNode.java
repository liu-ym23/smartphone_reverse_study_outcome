package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020>H\u0016J=\u0010@\u001a\u00020>2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J#\u0010F\u001a\u00020G*\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u001c\u0010O\u001a\u00020\u0006*\u00020P2\u0006\u0010I\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u001c\u0010S\u001a\u00020\u0006*\u00020P2\u0006\u0010I\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u001c\u0010T\u001a\u00020\u0006*\u00020P2\u0006\u0010I\u001a\u00020Q2\u0006\u0010U\u001a\u00020\u0006H\u0016J\u001c\u0010V\u001a\u00020\u0006*\u00020P2\u0006\u0010I\u001a\u00020Q2\u0006\u0010U\u001a\u00020\u0006H\u0016J\f\u0010W\u001a\u00020>*\u00020XH\u0016J\b\u0010Y\u001a\u00020>H\u0002J\u000e\u0010Z\u001a\u00020>H\u0082@¢\u0006\u0002\u0010[R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R+\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u001e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010%\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u0010\u0015¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "<init>", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "<set-?>", "contentWidth", "getContentWidth", "()I", "setContentWidth", "(I)V", "contentWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "animationJob", "Lkotlinx/coroutines/Job;", "marqueeLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "getAnimationMode-ZbEOnfQ", "setAnimationMode-97h66l8", "animationMode$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "direction", "getDirection", "()F", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "onAttach", "", "onDetach", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    private Job animationJob;
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    private int delayMillis;
    private final MutableState hasFocus$delegate;
    private int initialDelayMillis;
    private int iterations;
    private GraphicsLayer marqueeLayer;
    private final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    private float velocity;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1", f = "BasicMarquee.kt", i = {}, l = {379, 380}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $oldJob;
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        public AnonymousClass1(Job r1, MarqueeModifierNode r2, Continuation<? super AnonymousClass1> r3) {
            this.$oldJob = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$oldJob, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L15:
            MarqueeModifierNode r6 = this.this$0;
            this.label = 2;
            if (MarqueeModifierNode.access$runAnimation(r6, this) != r0) goto L19;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            Job r7 = this.$oldJob;
            if (r7 == null) goto L15;
            this.label = 1;
            if (r7.join(this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", i = {0, 0}, l = {416, 418, 422, 422}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"})
        public static final class C00132 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ MarqueeModifierNode this$0;

            public C00132(MarqueeModifierNode r1, Continuation<? super C00132> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00132 r0 = new C00132(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(Float r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Float) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r22) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r0 = this.label;
                if (r0 == 0) goto L17;
                if (r0 == 1) goto L16;
                if (r0 == 2) goto L12;
                if (r0 == 3) goto L11;
                if (r0 != 4) goto L9;
                Throwable r1 = (Throwable) this.L$0;
                ResultKt.throwOnFailure(r22);
                throw r1;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r22);
            L33:
                return Unit.INSTANCE;
            L12:
                ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L14
                Object r2 = r22;
            L28:
                AnimationResult r3 = (AnimationResult) r2;     // Catch: Throwable -> L14
                Animatable r4 = MarqueeModifierNode.access$getOffset$p(this.this$0);
                Float r5 = Boxing.boxFloat(MenuKt.ClosedAlphaTarget);
                this.label = 3;
                if (r4.snapTo(r5, this) != r10) goto L33;
                return r10;
            L16:
                AnimationSpec r6 = (AnimationSpec) this.L$1;
                Float r7 = (Float) this.L$0;
                ResultKt.throwOnFailure(r22);
                AnimationSpec r8 = r6;
            L25:
                Animatable r9 = MarqueeModifierNode.access$getOffset$p(this.this$0);     // Catch: Throwable -> L14
                this.L$0 = null;     // Catch: Throwable -> L14
                this.L$1 = null;     // Catch: Throwable -> L14
                this.label = 2;     // Catch: Throwable -> L14
                r2 = Animatable.animateTo$default(r9, r7, r8, null, null, this, 12, null);     // Catch: Throwable -> L14
                if (r2 != r10) goto L28;
                return r10;
            L17:
                ResultKt.throwOnFailure(r22);
                Float r11 = (Float) this.L$0;
                if (r11 == null) goto L20;
                r8 = BasicMarqueeKt.m346access$createMarqueeAnimationSpecZ4HSEVQ(MarqueeModifierNode.access$getIterations$p(this.this$0), r11.floatValue(), MarqueeModifierNode.access$getInitialDelayMillis$p(this.this$0), MarqueeModifierNode.access$getDelayMillis$p(this.this$0), MarqueeModifierNode.access$getVelocity$p(this.this$0), DelegatableNodeKt.requireDensity(this.this$0));
                Animatable r12 = MarqueeModifierNode.access$getOffset$p(this.this$0);
                Float r13 = Boxing.boxFloat(MenuKt.ClosedAlphaTarget);
                this.L$0 = r11;
                this.L$1 = r8;
                this.label = 1;
                if (r12.snapTo(r13, this) != r10) goto L24;
                return r10;
            L24:
                r7 = r11;
                goto L25
            L20:
                return Unit.INSTANCE;
            L14:
                th = move-exception;
                Animatable r14 = MarqueeModifierNode.access$getOffset$p(this.this$0);
                Float r15 = Boxing.boxFloat(MenuKt.ClosedAlphaTarget);
                this.L$0 = th;
                this.L$1 = null;
                this.label = 4;
                if (r14.snapTo(r15, this) != r10) goto L40;
                return r10;
            L40:
                throw th;
            }
        }

        public AnonymousClass2(MarqueeModifierNode r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ Float a(MarqueeModifierNode r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Float invokeSuspend$lambda$0(MarqueeModifierNode r3) {
            if (MarqueeModifierNode.access$getContentWidth(r3) > MarqueeModifierNode.access$getContainerWidth(r3)) goto L6;
            return null;
        L6:
            if (MarqueeAnimationMode.m429equalsimpl0(r3.m441getAnimationModeZbEOnfQ(), MarqueeAnimationMode.Companion.m434getWhileFocusedZbEOnfQ()) == false) goto L11;
            if (MarqueeModifierNode.access$getHasFocus(r3) == true) goto L11;
            return null;
        L11:
            return Float.valueOf(MarqueeModifierNode.access$getContentWidth(r3) + MarqueeModifierNode.access$getSpacingPx(r3));
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            final MarqueeModifierNode r7 = this.this$0;
            Flow r8 = SnapshotStateKt.snapshotFlow(new z0(r7));
            C00132 r2 = new C00132(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ MarqueeModifierNode(int r1, int r2, int r3, int r4, MarqueeSpacing r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ int a(MarqueeSpacing r0, MarqueeModifierNode r1) {
        return spacingPx_delegate$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit b(ContentDrawScope r0, DrawScope r1) {
        return draw$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit c(Placeable r0, MarqueeModifierNode r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$2(r0, r1, r2);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return 0;
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    private final int getContainerWidth() {
        return this.containerWidth$delegate.getIntValue();
    }

    private final int getContentWidth() {
        return this.contentWidth$delegate.getIntValue();
    }

    private final float getDirection() {
        float r0 = Math.signum(this.velocity);
        int r1 = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
        int r2 = 1;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        r2 = -1;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return r0 * r2;
    }

    private final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    private final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    private final void restartAnimation() {
        Job r0 = this.animationJob;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L6:
        if (isAttached() == false) goto L9;
        this.animationJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(r0, this, null), 3, null);
        return;
    }

    /* JADX INFO: renamed from: getAnimationMode-ZbEOnfQ, reason: not valid java name */
    public final int m441getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m432unboximpl();
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    public void onAttach() {
        GraphicsLayer r0 = this.marqueeLayer;
        GraphicsContext r1 = DelegatableNodeKt.requireGraphicsContext(this);
        if (r0 == null) goto L5;
        r1.releaseGraphicsLayer(r0);
    L5:
        this.marqueeLayer = r1.createGraphicsLayer();
        restartAnimation();
    }

    public void onDetach() {
        Job r0 = this.animationJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.animationJob = null;
        GraphicsLayer r1 = this.marqueeLayer;
        if (r1 == null) goto L9;
        DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(r1);
        this.marqueeLayer = null;
        return;
    }

    public static final /* synthetic */ int access$getContainerWidth(MarqueeModifierNode r0) {
        return r0.getContainerWidth();
    }

    public static final /* synthetic */ int access$getContentWidth(MarqueeModifierNode r0) {
        return r0.getContentWidth();
    }

    public static final /* synthetic */ int access$getDelayMillis$p(MarqueeModifierNode r0) {
        return r0.delayMillis;
    }

    public static final /* synthetic */ boolean access$getHasFocus(MarqueeModifierNode r0) {
        return r0.getHasFocus();
    }

    public static final /* synthetic */ int access$getInitialDelayMillis$p(MarqueeModifierNode r0) {
        return r0.initialDelayMillis;
    }

    public static final /* synthetic */ int access$getIterations$p(MarqueeModifierNode r0) {
        return r0.iterations;
    }

    public static final /* synthetic */ Animatable access$getOffset$p(MarqueeModifierNode r0) {
        return r0.offset;
    }

    public static final /* synthetic */ int access$getSpacingPx(MarqueeModifierNode r0) {
        return r0.getSpacingPx();
    }

    public static final /* synthetic */ float access$getVelocity$p(MarqueeModifierNode r0) {
        return r0.velocity;
    }

    private final Object runAnimation(Continuation<? super Unit> r4) {
        if (this.iterations <= 0) goto L5;
        Object r5 = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new AnonymousClass2(this, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r5;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final void setContainerWidth(int r2) {
        this.containerWidth$delegate.setIntValue(r2);
    }

    private final void setContentWidth(int r2) {
        this.contentWidth$delegate.setIntValue(r2);
    }

    private final void setHasFocus(boolean r2) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(r2));
    }

    public void draw(final ContentDrawScope r14) {
        float r3 = this.offset.getValue().floatValue() * getDirection();
        boolean r1 = true;
        if (getDirection() != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (this.offset.getValue().floatValue() < getContentWidth()) goto L12;
    L13:
        boolean r2 = false;
    L15:
        if (getDirection() != 1.0f) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L23;
        if (this.offset.getValue().floatValue() > ((getContentWidth() + getSpacingPx()) - getContainerWidth())) goto L24;
    L25:
        boolean r8 = false;
    L27:
        if (getDirection() == 1.0f) goto L30;
        r1 = false;
    L30:
        if (r1 == false) goto L32;
        int r4 = getContentWidth() + getSpacingPx();
    L33:
        float r6 = r4;
        float r7 = Float.intBitsToFloat((int) (r14.getSize-NH-jbRc() & 4294967295L));
        GraphicsLayer r9 = this.marqueeLayer;
        if (r9 == null) goto L36;
        r14.record-JVtK1S4(r9, IntSize.constructor-impl((((long) getContentWidth()) << 32) | (((long) MathKt.roundToInt(r7)) & 4294967295L)), new y0(r14));
    L36:
        float r10 = r3 + getContainerWidth();
        float r11 = Float.intBitsToFloat((int) (4294967295L & r14.getSize-NH-jbRc()));
        int r12 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext r13 = r14.getDrawContext();
        long r15 = r13.getSize-NH-jbRc();
        r13.getCanvas().save();
        r13.getTransform().clipRect-N_I0leg(r3, MenuKt.ClosedAlphaTarget, r10, r11, r12);     // Catch: Throwable -> L59
        GraphicsLayer r16 = this.marqueeLayer;     // Catch: Throwable -> L59
        if (r16 == null) goto L48;
        if (r2 == false) goto L41;
        GraphicsLayerKt.drawLayer(r14, r16);     // Catch: Throwable -> L59
    L41:
        if (r8 == false) goto L57;
        r14.getDrawContext().getTransform().translate(r6, MenuKt.ClosedAlphaTarget);     // Catch: Throwable -> L59
        GraphicsLayerKt.drawLayer(r14, r16);     // Catch: Throwable -> L45
        r14.getDrawContext().getTransform().translate(-r6, -0.0f);     // Catch: Throwable -> L59
        goto L57
    L45:
        th = move-exception;
        r14.getDrawContext().getTransform().translate(-r6, -0.0f);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L57:
        r13.getCanvas().restore();
        r13.setSize-uvyYCjk(r15);
        return;
    L48:
        if (r2 == false) goto L50;
        r14.drawContent();     // Catch: Throwable -> L59
    L50:
        if (r8 == false) goto L57;
        r14.getDrawContext().getTransform().translate(r6, MenuKt.ClosedAlphaTarget);     // Catch: Throwable -> L59
        r14.drawContent();     // Catch: Throwable -> L54
        r14.getDrawContext().getTransform().translate(-r6, -0.0f);     // Catch: Throwable -> L59
        goto L57
    L54:
        th = move-exception;
        r14.getDrawContext().getTransform().translate(-r6, -0.0f);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r13.getCanvas().restore();
        r13.setSize-uvyYCjk(r15);
        throw th;
    L32:
        r4 = (-getContentWidth()) - getSpacingPx();
    L24:
        r8 = true;
        goto L27
    L23:
        if (this.offset.getValue().floatValue() <= getSpacingPx()) goto L25;
    L17:
        r5 = false;
    L12:
        r2 = true;
        goto L15
    L11:
        if (this.offset.getValue().floatValue() >= getContainerWidth()) goto L13;
    L5:
        r0 = false;
        goto L6
    }

    public void onFocusEvent(FocusState r1) {
        setHasFocus(r1.getHasFocus());
    }

    /* JADX INFO: renamed from: setAnimationMode-97h66l8, reason: not valid java name */
    public final void m443setAnimationMode97h66l8(int r2) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m426boximpl(r2));
    }

    public final void setSpacing(MarqueeSpacing r2) {
        this.spacing$delegate.setValue(r2);
    }

    public static final /* synthetic */ Object access$runAnimation(MarqueeModifierNode r0, Continuation r1) {
        return r0.runAnimation(r1);
    }

    private static final Unit draw$lambda$4$lambda$3(ContentDrawScope r0, DrawScope r1) {
        r0.drawContent();
        return Unit.INSTANCE;
    }

    private static final int spacingPx_delegate$lambda$1(MarqueeSpacing r2, MarqueeModifierNode r3) {
        return r2.calculateSpacing(DelegatableNodeKt.requireDensity(r3), r3.getContentWidth(), r3.getContainerWidth());
    }

    private static final Unit measure_3p2s80s$lambda$2(Placeable r9, MarqueeModifierNode r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.placeWithLayer$default(r11, r9, MathKt.roundToInt((-r10.offset.getValue().floatValue()) * r10.getDirection()), 0, MenuKt.ClosedAlphaTarget, null, 12, null);
        return Unit.INSTANCE;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.maxIntrinsicWidth(r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m442measure3p2s80s(MeasureScope r9, Measurable r10, long r11) {
        final Placeable r12 = r10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r11, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.constrainWidth-K40F9xA(r11, r12.getWidth()));
        setContentWidth(r12.getWidth());
        return MeasureScope.-CC.layout$default(r9, getContainerWidth(), r12.getHeight(), null, new w0(r12, this), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    private MarqueeModifierNode(int r1, int r2, int r3, int r4, final MarqueeSpacing r5, float r6) {
        this.iterations = r1;
        this.delayMillis = r3;
        this.initialDelayMillis = r4;
        this.velocity = r6;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.spacing$delegate = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        this.animationMode$delegate = SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m426boximpl(r2), null, 2, null);
        this.offset = AnimatableKt.Animatable$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new x0(r5, this));
    }

    /* JADX INFO: renamed from: update-lWfNwf4, reason: not valid java name */
    public final void m444updatelWfNwf4(int r1, int r2, int r3, int r4, MarqueeSpacing r5, float r6) {
        setSpacing(r5);
        m443setAnimationMode97h66l8(r2);
        if (this.iterations == r1) goto L5;
    L10:
        this.iterations = r1;
        this.delayMillis = r3;
        this.initialDelayMillis = r4;
        this.velocity = r6;
        restartAnimation();
        return;
    L5:
        if (this.delayMillis != r3) goto L10;
        if (this.initialDelayMillis != r4) goto L10;
        if (Dp.equals-impl0(this.velocity, r6) == false) goto L10;
    }
}
