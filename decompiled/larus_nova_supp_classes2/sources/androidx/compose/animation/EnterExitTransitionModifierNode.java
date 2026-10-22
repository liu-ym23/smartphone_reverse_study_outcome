package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020OH\u0016J\u001d\u0010P\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\bQ\u0010MJ#\u0010R\u001a\u00020S*\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u000206H\u0016¢\u0006\u0004\bX\u0010YJ\u001d\u0010\\\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\b]\u0010MR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R \u00107\u001a\u0002062\u0006\u00105\u001a\u000206@BX\u0082\u000e¢\u0006\n\n\u0002\u00104\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\bA\u0010=R.\u0010B\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR.\u0010Z\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001a\u0004\b[\u0010H¨\u0006^"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "lookaheadConstraintsAvailable", "lookaheadSize", "J", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "currentAlignment", "Landroidx/compose/ui/Alignment;", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "alignment", "getAlignment", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "onAttach", "", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "slideSpec", "getSlideSpec", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec;
    private Transition<EnterExitState> transition;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EnterExitState.values().length];
            r0[EnterExitState.Visible.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[EnterExitState.PreEnter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[EnterExitState.PostExit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public final Alignment getAlignment() {
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible) == false) goto L11;
        ChangeSize r0 = this.enter.getData$animation().getChangeSize();
        if (r0 == null) goto L8;
        Alignment r1 = r0.getAlignment();
        if (r1 == null) goto L8;
    L23:
        return r1;
    L8:
        ChangeSize r2 = this.exit.getData$animation().getChangeSize();
        if (r2 != null) goto L22;
        return null;
    L22:
        return r2.getAlignment();
    L11:
        ChangeSize r3 = this.exit.getData$animation().getChangeSize();
        if (r3 == null) goto L17;
        r1 = r3.getAlignment();
        if (r1 != null) goto L23;
    L17:
        ChangeSize r4 = this.enter.getData$animation().getChangeSize();
        if (r4 != null) goto L20;
        return null;
    L20:
        return r4.getAlignment();
    }

    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m182setLookaheadConstraintsBRTryo0(long r2) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = r2;
    }

    public final void setCurrentAlignment(Alignment r1) {
        this.currentAlignment = r1;
    }

    public final void setEnabled(Function0<Boolean> r1) {
        this.isEnabled = r1;
    }

    public final void setEnter(EnterTransition r1) {
        this.enter = r1;
    }

    public final void setExit(ExitTransition r1) {
        this.exit = r1;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit r1) {
        this.graphicsLayerBlock = r1;
    }

    public final void setOffsetAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r1) {
        this.offsetAnimation = r1;
    }

    public final void setSizeAnimation(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r1) {
        this.sizeAnimation = r1;
    }

    public final void setSlideAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r1) {
        this.slideAnimation = r1;
    }

    public final void setTransition(Transition<EnterExitState> r1) {
        this.transition = r1;
    }

    /* JADX INFO: renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m184sizeByStateUzc_VyU(EnterExitState r2, long r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 != 1) goto L5;
        return r3;
    L5:
        if (r4 != 2) goto L7;
        ChangeSize r5 = this.enter.getData$animation().getChangeSize();
        if (r5 == null) goto L25;
        Function1<IntSize, IntSize> r6 = r5.getSize();
        if (r6 != null) goto L20;
        return r3;
    L20:
        return ((IntSize) r6.invoke(IntSize.box-impl(r3))).unbox-impl();
    L25:
        return r3;
    L7:
        if (r4 != 3) goto L14;
        ChangeSize r7 = this.exit.getData$animation().getChangeSize();
        if (r7 == null) goto L22;
        Function1<IntSize, IntSize> r8 = r7.getSize();
        if (r8 != null) goto L24;
        return r3;
    L24:
        return ((IntSize) r8.invoke(IntSize.box-impl(r3))).unbox-impl();
    L22:
        return r3;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: slideTargetValueByState-oFUgxo0, reason: not valid java name */
    public final long m185slideTargetValueByStateoFUgxo0(EnterExitState r4, long r5) {
        Slide r0 = this.enter.getData$animation().getSlide();
        if (r0 == null) goto L7;
        Function1<IntSize, IntOffset> r1 = r0.getSlideOffset();
        if (r1 == null) goto L7;
        long r2 = ((IntOffset) r1.invoke(IntSize.box-impl(r5))).unbox-impl();
    L8:
        Slide r3 = this.exit.getData$animation().getSlide();
        if (r3 == null) goto L13;
        Function1<IntSize, IntOffset> r6 = r3.getSlideOffset();
        if (r6 == null) goto L13;
        long r7 = ((IntOffset) r6.invoke(IntSize.box-impl(r5))).unbox-impl();
    L14:
        int r8 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r8 == 1) goto L24;
        if (r8 != 2) goto L19;
        return r2;
    L19:
        if (r8 != 3) goto L22;
        return r7;
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        return IntOffset.Companion.getZero-nOcc-ac();
    L13:
        r7 = IntOffset.Companion.getZero-nOcc-ac();
    L7:
        r2 = IntOffset.Companion.getZero-nOcc-ac();
        goto L8
    }

    /* JADX INFO: renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m186targetOffsetByStateoFUgxo0(EnterExitState r11, long r12) {
        if (this.currentAlignment != null) goto L6;
        return IntOffset.Companion.getZero-nOcc-ac();
    L6:
        if (getAlignment() != null) goto L9;
        return IntOffset.Companion.getZero-nOcc-ac();
    L9:
        if (Intrinsics.areEqual(this.currentAlignment, getAlignment()) == true) goto L28;
        int r13 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r13 == 1) goto L25;
        if (r13 == 2) goto L31;
        if (r13 != 3) goto L22;
        ChangeSize r14 = this.exit.getData$animation().getChangeSize();
        if (r14 == null) goto L30;
        long r6 = ((IntSize) r14.getSize().invoke(IntSize.box-impl(r12))).unbox-impl();
        Alignment r0 = getAlignment();
        Intrinsics.checkNotNull(r0);
        LayoutDirection r15 = LayoutDirection.Ltr;
        long r8 = r0.align-KFBX0sM(r12, r6, r15);
        Alignment r1 = this.currentAlignment;
        Intrinsics.checkNotNull(r1);
        return IntOffset.minus-qkQi6aY(r8, r1.align-KFBX0sM(r12, r6, r15));
    L30:
        return IntOffset.Companion.getZero-nOcc-ac();
    L22:
        throw new NoWhenBranchMatchedException();
    L31:
        return IntOffset.Companion.getZero-nOcc-ac();
    L25:
        return IntOffset.Companion.getZero-nOcc-ac();
    L28:
        return IntOffset.Companion.getZero-nOcc-ac();
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m183measure3p2s80s(MeasureScope r31, Measurable r32, long r33) {
        State<IntSize> r5 = null;
        if (this.transition.getCurrentState() != this.transition.getTargetState()) goto L6;
        this.currentAlignment = null;
    L12:
        if (r31.isLookingAhead() == false) goto L16;
        final Placeable r3 = r32.measure-BRTryo0(r33);
        int r6 = r3.getWidth();
        long r8 = IntSize.constructor-impl((((long) r6) << 32) | (((long) r3.getHeight()) & 4294967295L));
        this.lookaheadSize = r8;
        m182setLookaheadConstraintsBRTryo0(r33);
        return MeasureScope.-CC.layout$default(r31, (int) (r8 >> 32), (int) (r8 & 4294967295L), null, new EnterExitTransitionModifierNode$measure$1(r3), 4, null);
    L16:
        if (((Boolean) this.isEnabled.invoke()).booleanValue() == false) goto L44;
        final Function1<GraphicsLayerScope, Unit> r14 = this.graphicsLayerBlock.init();
        final Placeable r9 = r32.measure-BRTryo0(r33);
        int r4 = r9.getWidth();
        long r10 = IntSize.constructor-impl((((long) r4) << 32) | (((long) r9.getHeight()) & 4294967295L));
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L20;
        final long r12 = this.lookaheadSize;
    L21:
        Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r7 = this.sizeAnimation;
        if (r7 == null) goto L24;
        r5 = r7.animate(this.sizeTransitionSpec, new EnterExitTransitionModifierNode$measure$animSize$1(this, r12));
    L24:
        if (r5 == null) goto L26;
        r10 = ((IntSize) r5.getValue()).unbox-impl();
    L26:
        long r1 = ConstraintsKt.constrain-4WqzIAM(r33, r10);
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r11 = this.offsetAnimation;
        if (r11 == null) goto L31;
        State<IntOffset> r13 = r11.animate(EnterExitTransitionModifierNode$measure$offsetDelta$1.INSTANCE, new EnterExitTransitionModifierNode$measure$offsetDelta$2(this, r12));
        if (r13 == null) goto L31;
        long r15 = ((IntOffset) r13.getValue()).unbox-impl();
    L32:
        final long r21 = r15;
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r16 = this.slideAnimation;
        if (r16 == null) goto L37;
        State<IntOffset> r17 = r16.animate(this.slideSpec, new EnterExitTransitionModifierNode$measure$slideOffset$1(this, r12));
        if (r17 == null) goto L37;
        long r18 = ((IntOffset) r17.getValue()).unbox-impl();
    L38:
        Alignment r19 = this.currentAlignment;
        if (r19 == null) goto L41;
        long r110 = r12;
        long r111 = r19.align-KFBX0sM(r110, r1, LayoutDirection.Ltr);
    L42:
        final long r112 = IntOffset.plus-qkQi6aY(r111, r18);
        return MeasureScope.-CC.layout$default(r31, (int) (r1 >> 32), (int) (r1 & 4294967295L), null, new EnterExitTransitionModifierNode$measure$2(r9, r112, r21, r14), 4, null);
    L41:
        r111 = IntOffset.Companion.getZero-nOcc-ac();
    L37:
        r18 = IntOffset.Companion.getZero-nOcc-ac();
    L31:
        r15 = IntOffset.Companion.getZero-nOcc-ac();
        goto L32
    L20:
        r12 = r10;
        goto L21
    L44:
        final Placeable r2 = r32.measure-BRTryo0(r33);
        return MeasureScope.-CC.layout$default(r31, r2.getWidth(), r2.getHeight(), null, new EnterExitTransitionModifierNode$measure$3$1(r2), 4, null);
    L6:
        if (this.currentAlignment != null) goto L12;
        Alignment r20 = getAlignment();
        if (r20 != null) goto L10;
        r20 = Alignment.Companion.getTopStart();
    L10:
        this.currentAlignment = r20;
        goto L12
    }

    public EnterExitTransitionModifierNode(Transition<EnterExitState> r1, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r3, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r4, EnterTransition r5, ExitTransition r6, Function0<Boolean> r7, GraphicsLayerBlockForEnterExit r8) {
        this.transition = r1;
        this.sizeAnimation = r2;
        this.offsetAnimation = r3;
        this.slideAnimation = r4;
        this.enter = r5;
        this.exit = r6;
        this.isEnabled = r7;
        this.graphicsLayerBlock = r8;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.sizeTransitionSpec = new EnterExitTransitionModifierNode$sizeTransitionSpec$1(this);
        this.slideSpec = new EnterExitTransitionModifierNode$slideSpec$1(this);
    }
}
