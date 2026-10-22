package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u009b\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00101\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0002H\u0016J\f\u00105\u001a\u000203*\u000206H\u0016J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00108\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00109\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u0010:\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0010HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u0010>\u001a\u00020\u0015HÆ\u0003J\u00ad\u0001\u0010?\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010@\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020FHÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R2\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR2\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR2\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006G"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/EnterExitTransitionModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EnterExitTransitionElement extends ModifierNodeElement<EnterExitTransitionModifierNode> {
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private final Transition<EnterExitState> transition;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnterExitTransitionElement copy$default(EnterExitTransitionElement r9, Transition r10, Transition.DeferredAnimation r11, Transition.DeferredAnimation r12, Transition.DeferredAnimation r13, EnterTransition r14, ExitTransition r15, Function0 r16, GraphicsLayerBlockForEnterExit r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Transition r2 = r9.transition;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Transition.DeferredAnimation r3 = r9.sizeAnimation;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Transition.DeferredAnimation r4 = r9.offsetAnimation;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Transition.DeferredAnimation r5 = r9.slideAnimation;
    L19:
        if ((r18 & 16) == 0) goto L21;
        EnterTransition r6 = r9.enter;
    L23:
        if ((r18 & 32) == 0) goto L25;
        ExitTransition r7 = r9.exit;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Function0 r8 = r9.isEnabled;
    L31:
        if ((r18 & 128) == 0) goto L33;
        GraphicsLayerBlockForEnterExit r1 = r9.graphicsLayerBlock;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Transition<EnterExitState> component1() {
        return this.transition;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> component2() {
        return this.sizeAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> component3() {
        return this.offsetAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> component4() {
        return this.slideAnimation;
    }

    public final EnterTransition component5() {
        return this.enter;
    }

    public final ExitTransition component6() {
        return this.exit;
    }

    public final Function0<Boolean> component7() {
        return this.isEnabled;
    }

    public final GraphicsLayerBlockForEnterExit component8() {
        return this.graphicsLayerBlock;
    }

    public final EnterExitTransitionElement copy(Transition<EnterExitState> r11, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r12, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r13, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r14, EnterTransition r15, ExitTransition r16, Function0<Boolean> r17, GraphicsLayerBlockForEnterExit r18) {
        return new EnterExitTransitionElement(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EnterExitTransitionElement) == true) goto L8;
        return false;
    L8:
        EnterExitTransitionElement r6 = (EnterExitTransitionElement) r5;
        if (Intrinsics.areEqual(this.transition, r6.transition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sizeAnimation, r6.sizeAnimation) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.offsetAnimation, r6.offsetAnimation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slideAnimation, r6.slideAnimation) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enter, r6.enter) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.exit, r6.exit) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isEnabled, r6.isEnabled) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.graphicsLayerBlock, r6.graphicsLayerBlock) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.transition.hashCode() * 31;
        Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r1 = this.sizeAnimation;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r5 = this.offsetAnimation;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r8 = this.slideAnimation;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((r7 + r2) * 31) + this.enter.hashCode()) * 31) + this.exit.hashCode()) * 31) + this.isEnabled.hashCode()) * 31) + this.graphicsLayerBlock.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "EnterExitTransitionElement(transition=" + this.transition + ", sizeAnimation=" + this.sizeAnimation + ", offsetAnimation=" + this.offsetAnimation + ", slideAnimation=" + this.slideAnimation + ", enter=" + this.enter + ", exit=" + this.exit + ", isEnabled=" + this.isEnabled + ", graphicsLayerBlock=" + this.graphicsLayerBlock + ')';
    }

    public EnterExitTransitionModifierNode create() {
        return new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
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

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m163create() {
        return create();
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("enterExitTransition");
        r4.getProperties().set("transition", this.transition);
        r4.getProperties().set("sizeAnimation", this.sizeAnimation);
        r4.getProperties().set("offsetAnimation", this.offsetAnimation);
        r4.getProperties().set("slideAnimation", this.slideAnimation);
        r4.getProperties().set("enter", this.enter);
        r4.getProperties().set("exit", this.exit);
        r4.getProperties().set("graphicsLayerBlock", this.graphicsLayerBlock);
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

    public void update(EnterExitTransitionModifierNode r2) {
        r2.setTransition(this.transition);
        r2.setSizeAnimation(this.sizeAnimation);
        r2.setOffsetAnimation(this.offsetAnimation);
        r2.setSlideAnimation(this.slideAnimation);
        r2.setEnter(this.enter);
        r2.setExit(this.exit);
        r2.setEnabled(this.isEnabled);
        r2.setGraphicsLayerBlock(this.graphicsLayerBlock);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((EnterExitTransitionModifierNode) r1);
    }

    public EnterExitTransitionElement(Transition<EnterExitState> r1, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> r2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r3, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> r4, EnterTransition r5, ExitTransition r6, Function0<Boolean> r7, GraphicsLayerBlockForEnterExit r8) {
        this.transition = r1;
        this.sizeAnimation = r2;
        this.offsetAnimation = r3;
        this.slideAnimation = r4;
        this.enter = r5;
        this.exit = r6;
        this.isEnabled = r7;
        this.graphicsLayerBlock = r8;
    }
}
