package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003VWXB'\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u001a\u001a\u00020\u001b*\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0004JH\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020'0&H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108JH\u00109\u001a\u00020:2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020'0&H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u001bH\u0001¢\u0006\u0004\bT\u0010UR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010-\u001a\u00020.*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u00101\u001a\u00020.*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00100R+\u0010?\u001a\u0002052\u0006\u0010>\u001a\u0002058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR&\u0010F\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002050H0GX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\"\u0010K\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u00106\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010A¨\u0006Y²\u0006\n\u0010Z\u001a\u00020.X\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "S", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "getTransition$animation", "()Landroidx/compose/animation/core/Transition;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "setContentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getLayoutDirection$animation", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "isLeft", "", "isLeft-gWo6LJ4", "(I)Z", "isRight", "isRight-gWo6LJ4", "calculateOffset", "fullSize", "Landroidx/compose/ui/unit/IntSize;", "currentSize", "calculateOffset-emnUabE", "(JJ)J", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "<set-?>", "measuredSize", "getMeasuredSize-YbymL2g$animation", "()J", "setMeasuredSize-ozmzZPI$animation", "(J)V", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "targetSizeMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/State;", "getTargetSizeMap$animation", "()Landroidx/collection/MutableScatterMap;", "animatedSize", "getAnimatedSize$animation", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation", "(Landroidx/compose/runtime/State;)V", "getCurrentSize-YbymL2g", "createSizeAnimationModifier", "Landroidx/compose/ui/Modifier;", "contentTransform", "createSizeAnimationModifier$animation", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "ChildData", "SizeModifierElement", "SizeModifierNode", "animation", "shouldAnimateSize"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedContentTransitionScopeImpl<S> implements AnimatedContentTransitionScope<S> {
    public static final int $stable = 8;
    private State<IntSize> animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;
    private final MutableState measuredSize$delegate;
    private final MutableScatterMap<S, State<IntSize>> targetSizeMap;
    private final Transition<S> transition;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "<init>", "(Z)V", "<set-?>", "()Z", "setTarget", "isTarget$delegate", "Landroidx/compose/runtime/MutableState;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ChildData implements ParentDataModifier {
        public static final int $stable = 0;
        private final MutableState isTarget$delegate;

        public final /* synthetic */ boolean all(Function1 r1) {
            return Modifier.Element.-CC.$default$all(this, r1);
        }

        public final /* synthetic */ boolean any(Function1 r1) {
            return Modifier.Element.-CC.$default$any(this, r1);
        }

        public final /* synthetic */ Object foldIn(Object r1, Function2 r2) {
            return Modifier.Element.-CC.$default$foldIn(this, r1, r2);
        }

        public final /* synthetic */ Object foldOut(Object r1, Function2 r2) {
            return Modifier.Element.-CC.$default$foldOut(this, r1, r2);
        }

        public Object modifyParentData(Density r1, Object r2) {
            return this;
        }

        public final /* synthetic */ Modifier then(Modifier r1) {
            return Modifier.-CC.$default$then(this, r1);
        }

        public final boolean isTarget() {
            return ((Boolean) this.isTarget$delegate.getValue()).booleanValue();
        }

        public ChildData(boolean r3) {
            this.isTarget$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r3), null, 2, null);
        }

        public final void setTarget(boolean r2) {
            this.isTarget$delegate.setValue(Boolean.valueOf(r2));
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002BE\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016J\f\u0010 \u001a\u00020\u001e*\u00020!H\u0016R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierElement;", "S", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierNode;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "scope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "getScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "create", "hashCode", "", "equals", "", "other", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SizeModifierElement<S> extends ModifierNodeElement<SizeModifierNode<S>> {
        private final AnimatedContentTransitionScopeImpl<S> scope;
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        private final State<SizeTransform> sizeTransform;

        public SizeModifierNode<S> create() {
            return new SizeModifierNode(this.sizeAnimation, this.sizeTransform, this.scope);
        }

        public int hashCode() {
            int r0 = this.scope.hashCode() * 31;
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> r1 = this.sizeAnimation;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((r0 + r2) * 31) + this.sizeTransform.hashCode();
        L5:
            r2 = 0;
            goto L7
        }

        public final AnimatedContentTransitionScopeImpl<S> getScope() {
            return this.scope;
        }

        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        /* JADX INFO: renamed from: create, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Modifier.Node m139create() {
            return create();
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof SizeModifierElement) == false) goto L9;
            SizeModifierElement r4 = (SizeModifierElement) r3;
            if (Intrinsics.areEqual(r4.sizeAnimation, this.sizeAnimation) == false) goto L9;
            if (Intrinsics.areEqual(r4.sizeTransform, this.sizeTransform) == false) goto L9;
            return true;
        L9:
            return false;
        }

        public void inspectableProperties(InspectorInfo r5) {
            r5.setName("sizeTransform");
            r5.getProperties().set("sizeAnimation", this.sizeAnimation);
            r5.getProperties().set("sizeTransform", this.sizeTransform);
            r5.getProperties().set("scope", this.scope);
        }

        public void update(SizeModifierNode<S> r2) {
            r2.setSizeAnimation(this.sizeAnimation);
            r2.setSizeTransform(this.sizeTransform);
            r2.setScope(this.scope);
        }

        public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
            update((SizeModifierNode) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SizeModifierElement(Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> r1, State<? extends SizeTransform> r2, AnimatedContentTransitionScopeImpl<S> r3) {
            this.sizeAnimation = r1;
            this.sizeTransform = r2;
            this.scope = r3;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002BE\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\"H\u0016J#\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R2\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006,"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierNode;", "S", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "scope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeTransform", "()Landroidx/compose/runtime/State;", "setSizeTransform", "(Landroidx/compose/runtime/State;)V", "getScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "setScope", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "lastSize", "J", "lastContinuousSizeOrDefault", "default", "lastContinuousSizeOrDefault-mzRDjE0", "(J)J", "onReset", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SizeModifierNode<S> extends LayoutModifierNodeWithPassThroughIntrinsics {
        private long lastSize;
        private AnimatedContentTransitionScopeImpl<S> scope;
        private Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        private State<? extends SizeTransform> sizeTransform;

        public void onReset() {
            super.onReset();
            this.lastSize = AnimatedContentKt.access$getUnspecifiedSize$p();
        }

        public final AnimatedContentTransitionScopeImpl<S> getScope() {
            return this.scope;
        }

        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        /* JADX INFO: renamed from: lastContinuousSizeOrDefault-mzRDjE0, reason: not valid java name */
        private final long m141lastContinuousSizeOrDefaultmzRDjE0(long r5) {
            if (IntSize.equals-impl0(this.lastSize, AnimatedContentKt.access$getUnspecifiedSize$p()) == false) goto L6;
            return r5;
        L6:
            return this.lastSize;
        }

        public final void setScope(AnimatedContentTransitionScopeImpl<S> r1) {
            this.scope = r1;
        }

        public final void setSizeAnimation(Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> r1) {
            this.sizeAnimation = r1;
        }

        public final void setSizeTransform(State<? extends SizeTransform> r1) {
            this.sizeTransform = r1;
        }

        /* JADX INFO: renamed from: access$lastContinuousSizeOrDefault-mzRDjE0, reason: not valid java name */
        public static final /* synthetic */ long m140access$lastContinuousSizeOrDefaultmzRDjE0(SizeModifierNode r0, long r1) {
            return r0.m141lastContinuousSizeOrDefaultmzRDjE0(r1);
        }

        public SizeModifierNode(Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> r1, State<? extends SizeTransform> r2, AnimatedContentTransitionScopeImpl<S> r3) {
            this.sizeAnimation = r1;
            this.sizeTransform = r2;
            this.scope = r3;
            this.lastSize = AnimatedContentKt.access$getUnspecifiedSize$p();
        }

        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult m142measure3p2s80s(MeasureScope r12, Measurable r13, long r14) {
            final Placeable r15 = r13.measure-BRTryo0(r14);
            if (r12.isLookingAhead() == false) goto L6;
            int r16 = r15.getWidth();
            final long r2 = IntSize.constructor-impl((((long) r16) << 32) | (((long) r15.getHeight()) & 4294967295L));
        L10:
            return MeasureScope.-CC.layout$default(r12, (int) (r2 >> 32), (int) (r2 & 4294967295L), null, new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$1(this, r15, r2), 4, null);
        L6:
            if (this.sizeAnimation != null) goto L8;
            int r17 = r15.getWidth();
            r2 = IntSize.constructor-impl((((long) r17) << 32) | (((long) r15.getHeight()) & 4294967295L));
            int r18 = r15.getWidth();
            this.lastSize = IntSize.constructor-impl((((long) r18) << 32) | (((long) r15.getHeight()) & 4294967295L));
            goto L10
        L8:
            int r19 = r15.getWidth();
            final long r3 = IntSize.constructor-impl((((long) r19) << 32) | (((long) r15.getHeight()) & 4294967295L));
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> r110 = this.sizeAnimation;
            Intrinsics.checkNotNull(r110);
            Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> r4 = new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$1(this, r3);
            State<IntSize> r111 = r110.animate(r4, (Function1<? super S, ? extends IntSize>) new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$2(this, r3));
            this.scope.setAnimatedSize$animation(r111);
            r2 = ((IntSize) r111.getValue()).unbox-impl();
            this.lastSize = ((IntSize) r111.getValue()).unbox-impl();
            goto L10
        }
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final /* synthetic */ ExitTransition getKeepUntilTransitionsFinished(ExitTransition.Companion r1) {
        return AnimatedContentTransitionScope.CC.$default$getKeepUntilTransitionsFinished(this, r1);
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final /* synthetic */ boolean isTransitioningTo(Object r1, Object r2) {
        return Transition.Segment.CC.$default$isTransitioningTo(this, r1, r2);
    }

    /* JADX INFO: renamed from: getCurrentSize-YbymL2g, reason: not valid java name */
    private final long m134getCurrentSizeYbymL2g() {
        State<IntSize> r0 = this.animatedSize;
        if (r0 == null) goto L6;
        return ((IntSize) r0.getValue()).unbox-impl();
    L6:
        return m137getMeasuredSizeYbymL2g$animation();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g$animation, reason: not valid java name */
    public final long m137getMeasuredSizeYbymL2g$animation() {
        return ((IntSize) this.measuredSize$delegate.getValue()).unbox-impl();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    public final State<IntSize> getAnimatedSize$animation() {
        return this.animatedSize;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    public final LayoutDirection getLayoutDirection$animation() {
        return this.layoutDirection;
    }

    public final MutableScatterMap<S, State<IntSize>> getTargetSizeMap$animation() {
        return this.targetSizeMap;
    }

    public final Transition<S> getTransition$animation() {
        return this.transition;
    }

    /* JADX INFO: renamed from: access$getCurrentSize-YbymL2g, reason: not valid java name */
    public static final /* synthetic */ long m132access$getCurrentSizeYbymL2g(AnimatedContentTransitionScopeImpl r2) {
        return r2.m134getCurrentSizeYbymL2g();
    }

    private static final boolean createSizeAnimationModifier$lambda$2(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: isLeft-gWo6LJ4, reason: not valid java name */
    private final boolean m135isLeftgWo6LJ4(int r4) {
        AnimatedContentTransitionScope.SlideDirection.Companion r0 = AnimatedContentTransitionScope.SlideDirection.Companion;
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m127getLeftDKzdypw()) == false) goto L5;
    L14:
        return true;
    L5:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m129getStartDKzdypw()) == false) goto L9;
        if (this.layoutDirection == LayoutDirection.Ltr) goto L14;
    L9:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m126getEndDKzdypw()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.layoutDirection != LayoutDirection.Rtl) goto L13;
        goto L13
    }

    /* JADX INFO: renamed from: isRight-gWo6LJ4, reason: not valid java name */
    private final boolean m136isRightgWo6LJ4(int r4) {
        AnimatedContentTransitionScope.SlideDirection.Companion r0 = AnimatedContentTransitionScope.SlideDirection.Companion;
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m128getRightDKzdypw()) == false) goto L5;
    L14:
        return true;
    L5:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m129getStartDKzdypw()) == false) goto L9;
        if (this.layoutDirection == LayoutDirection.Rtl) goto L14;
    L9:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r4, r0.m126getEndDKzdypw()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.layoutDirection != LayoutDirection.Ltr) goto L13;
        goto L13
    }

    public final void setAnimatedSize$animation(State<IntSize> r1) {
        this.animatedSize = r1;
    }

    public void setContentAlignment(Alignment r1) {
        this.contentAlignment = r1;
    }

    public final void setLayoutDirection$animation(LayoutDirection r1) {
        this.layoutDirection = r1;
    }

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI$animation, reason: not valid java name */
    public final void m138setMeasuredSizeozmzZPI$animation(long r2) {
        this.measuredSize$delegate.setValue(IntSize.box-impl(r2));
    }

    /* JADX INFO: renamed from: calculateOffset-emnUabE, reason: not valid java name */
    private final long m133calculateOffsetemnUabE(long r7, long r9) {
        return getContentAlignment().align-KFBX0sM(r7, r9, LayoutDirection.Ltr);
    }

    private static final void createSizeAnimationModifier$lambda$3(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public ContentTransform using(ContentTransform r1, SizeTransform r2) {
        r1.setSizeTransform$animation(r2);
        return r1;
    }

    public AnimatedContentTransitionScopeImpl(Transition<S> r1, Alignment r2, LayoutDirection r3) {
        this.transition = r1;
        this.contentAlignment = r2;
        this.layoutDirection = r3;
        this.measuredSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
        this.targetSizeMap = ScatterMapKt.mutableScatterMapOf();
    }

    /* JADX INFO: renamed from: access$calculateOffset-emnUabE, reason: not valid java name */
    public static final /* synthetic */ long m131access$calculateOffsetemnUabE(AnimatedContentTransitionScopeImpl r0, long r1, long r3) {
        return r0.m133calculateOffsetemnUabE(r1, r3);
    }

    public final Modifier createSizeAnimationModifier$animation(ContentTransform r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(93755870, r13, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:557)");
    L5:
        boolean r14 = r12.changed(this);
        Object r0 = r12.rememberedValue();
        Transition.DeferredAnimation r1 = null;
        if (r14 == false) goto L8;
    L9:
        r0 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r12.updateRememberedValue(r0);
    L10:
        MutableState r2 = (MutableState) r0;
        boolean r15 = false;
        State r16 = SnapshotStateKt.rememberUpdatedState(r11.getSizeTransform(), r12, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState()) == false) goto L14;
        createSizeAnimationModifier$lambda$3(r2, false);
    L17:
        if (createSizeAnimationModifier$lambda$2(r2) == false) goto L32;
        r12.startReplaceGroup(1353180665);
        r1 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), null, r12, 0, 2);
        boolean r3 = r12.changed(r1);
        Object r4 = r12.rememberedValue();
        if (r3 == false) goto L21;
    L22:
        SizeTransform r5 = (SizeTransform) r16.getValue();
        if (r5 != null) goto L25;
    L27:
        if (r15 == false) goto L29;
        Modifier.Companion r17 = Modifier.Companion;
    L30:
        r4 = r17;
        r12.updateRememberedValue(r4);
    L31:
        Modifier r6 = (Modifier) r4;
        r12.endReplaceGroup();
    L33:
        Modifier r18 = r6.then(new SizeModifierElement(r1, r16, this));
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
    L36:
        return r18;
    L29:
        r17 = ClipKt.clipToBounds(Modifier.Companion);
        goto L30
    L25:
        if (r5.getClip() == true) goto L27;
        r15 = true;
        goto L27
    L21:
        if (r4 != Composer.Companion.getEmpty()) goto L31;
    L32:
        r12.startReplaceGroup(1353446707);
        r12.endReplaceGroup();
        this.animatedSize = null;
        r6 = Modifier.Companion;
        goto L33
    L14:
        if (r16.getValue() == null) goto L17;
        createSizeAnimationModifier$lambda$3(r2, true);
        goto L17
    L8:
        if (r0 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    /* JADX INFO: renamed from: slideIntoContainer-mOhB8PU */
    public EnterTransition mo114slideIntoContainermOhB8PU(int r3, FiniteAnimationSpec<IntOffset> r4, final Function1<? super Integer, Integer> r5) {
        if (m135isLeftgWo6LJ4(r3) == false) goto L6;
        return EnterExitTransitionKt.slideInHorizontally(r4, new AnimatedContentTransitionScopeImpl$slideIntoContainer$1(r5, this));
    L6:
        if (m136isRightgWo6LJ4(r3) == true) goto L17;
        AnimatedContentTransitionScope.SlideDirection.Companion r0 = AnimatedContentTransitionScope.SlideDirection.Companion;
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r3, r0.m130getUpDKzdypw()) == false) goto L12;
        return EnterExitTransitionKt.slideInVertically(r4, new AnimatedContentTransitionScopeImpl$slideIntoContainer$3(r5, this));
    L12:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r3, r0.m125getDownDKzdypw()) == false) goto L15;
        return EnterExitTransitionKt.slideInVertically(r4, new AnimatedContentTransitionScopeImpl$slideIntoContainer$4(r5, this));
    L15:
        return EnterTransition.Companion.getNone();
    L17:
        return EnterExitTransitionKt.slideInHorizontally(r4, new AnimatedContentTransitionScopeImpl$slideIntoContainer$2(r5, this));
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    /* JADX INFO: renamed from: slideOutOfContainer-mOhB8PU */
    public ExitTransition mo115slideOutOfContainermOhB8PU(int r3, FiniteAnimationSpec<IntOffset> r4, final Function1<? super Integer, Integer> r5) {
        if (m135isLeftgWo6LJ4(r3) == false) goto L6;
        return EnterExitTransitionKt.slideOutHorizontally(r4, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$1(this, r5));
    L6:
        if (m136isRightgWo6LJ4(r3) == true) goto L17;
        AnimatedContentTransitionScope.SlideDirection.Companion r0 = AnimatedContentTransitionScope.SlideDirection.Companion;
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r3, r0.m130getUpDKzdypw()) == false) goto L12;
        return EnterExitTransitionKt.slideOutVertically(r4, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$3(this, r5));
    L12:
        if (AnimatedContentTransitionScope.SlideDirection.m121equalsimpl0(r3, r0.m125getDownDKzdypw()) == false) goto L15;
        return EnterExitTransitionKt.slideOutVertically(r4, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$4(this, r5));
    L15:
        return ExitTransition.Companion.getNone();
    L17:
        return EnterExitTransitionKt.slideOutHorizontally(r4, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$2(this, r5));
    }
}
