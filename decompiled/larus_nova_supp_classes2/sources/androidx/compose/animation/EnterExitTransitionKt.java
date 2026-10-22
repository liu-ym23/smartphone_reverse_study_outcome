package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u001a\"\u0010\n\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007\u001a;\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0007\u001a;\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0007\u001a3\u0010\u0016\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aQ\u0010 \u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH\u0007\u001aQ\u0010&\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010'\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH\u0007\u001aQ\u0010)\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010!\u001a\u00020*2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u0010+\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001aQ\u0010.\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010!\u001a\u00020/2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u00100\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001aQ\u00102\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010'\u001a\u00020*2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001aQ\u00104\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010'\u001a\u00020/2\b\b\u0002\u0010#\u001a\u00020$2#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001a=\u00106\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001a=\u00108\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001a=\u0010:\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001a=\u0010<\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020,0\u000fH\u0007\u001a\f\u0010>\u001a\u00020\"*\u00020*H\u0002\u001a\f\u0010>\u001a\u00020\"*\u00020/H\u0002\u001a,\u0010?\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020\u0003*\u00020\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H@0BH\u0080\u0002¢\u0006\u0002\u0010C\u001a,\u0010?\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020\u0003*\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H@0BH\u0080\u0002¢\u0006\u0002\u0010D\u001a?\u0010E\u001a\u00020F*\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u00042\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020$0L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\u0010O\u001a\u001f\u0010P\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010Q\u001a\u001f\u0010R\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010J\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010S\u001a/\u0010T\u001a\u00020U*\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u00042\u0006\u0010M\u001a\u00020NH\u0003¢\u0006\u0002\u0010V\"\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020Y0XX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0[X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0[X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00100[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^²\u0006\n\u0010_\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020\u0004X\u008a\u008e\u0002"}, d2 = {"withEffect", "Landroidx/compose/animation/EnterTransition;", "effect", "Landroidx/compose/animation/TransitionEffect;", "Landroidx/compose/animation/ExitTransition;", "fadeIn", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "initialAlpha", "fadeOut", "targetAlpha", "slideIn", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "fullSize", "slideOut", "targetOffset", "scaleIn", "initialScale", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "expandIn", "expandFrom", "Landroidx/compose/ui/Alignment;", "clip", "", "initialSize", "shrinkOut", "shrinkTowards", "targetSize", "expandHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "initialWidth", "", "fullWidth", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "shrinkHorizontally", "targetWidth", "shrinkVertically", "targetHeight", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "toAlignment", "get", "T", "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "isEnabled", "Lkotlin/Function0;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "animation", "activeEnter", "activeExit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EnterExitTransitionKt {
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = null;
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = null;
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = null;
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = null;

    public static /* synthetic */ Function1 a(Transition.DeferredAnimation r0, Transition.DeferredAnimation r1, Transition r2, EnterTransition r3, ExitTransition r4, Transition.DeferredAnimation r5) {
        return createGraphicsLayerBlock$lambda$14$lambda$13(r0, r1, r2, r3, r4, r5);
    }

    static {
        TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);
        DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
        DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    }

    public static final /* synthetic */ SpringSpec access$getDefaultAlphaAndScaleSpring$p() {
        return DefaultAlphaAndScaleSpring;
    }

    public static final /* synthetic */ SpringSpec access$getDefaultOffsetAnimationSpec$p() {
        return DefaultOffsetAnimationSpec;
    }

    public static final /* synthetic */ SpringSpec access$getDefaultSizeAnimationSpec$p() {
        return DefaultSizeAnimationSpec;
    }

    private static final Alignment toAlignment(Alignment.Horizontal r2) {
        Alignment.Companion r0 = Alignment.Companion;
        if (Intrinsics.areEqual(r2, r0.getStart()) == false) goto L6;
        return r0.getCenterStart();
    L6:
        if (Intrinsics.areEqual(r2, r0.getEnd()) == false) goto L9;
        return r0.getCenterEnd();
    L9:
        return r0.getCenter();
    }

    private static final EnterTransition trackActiveEnter$lambda$6(MutableState<EnterTransition> r0) {
        return (EnterTransition) r0.getValue();
    }

    private static final ExitTransition trackActiveExit$lambda$9(MutableState<ExitTransition> r0) {
        return (ExitTransition) r0.getValue();
    }

    private static final Alignment toAlignment(Alignment.Vertical r2) {
        Alignment.Companion r0 = Alignment.Companion;
        if (Intrinsics.areEqual(r2, r0.getTop()) == false) goto L6;
        return r0.getTopCenter();
    L6:
        if (Intrinsics.areEqual(r2, r0.getBottom()) == false) goto L9;
        return r0.getBottomCenter();
    L9:
        return r0.getCenter();
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> r11, float r12) {
        return new EnterTransitionImpl(new TransitionData(new Fade(r12, r11), null, null, null, false, null, 62, null));
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> r11, float r12) {
        return new ExitTransitionImpl(new TransitionData(new Fade(r12, r11), null, null, null, false, null, 62, null));
    }

    public static final <T extends TransitionEffect> T get(EnterTransition r0, TransitionEffectKey<T> r1) {
        TransitionEffect r2 = r0.getData$animation().getEffectsMap().get(r1);
        if ((r2 instanceof TransitionEffect) == true) goto L7;
        return null;
    L7:
        return (T) r2;
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> r11, Function1<? super IntSize, IntOffset> r12) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(r12, r11), null, null, false, null, 61, null));
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> r1, final Function1<? super Integer, Integer> r2) {
        return slideIn(r1, new C00962(r2));
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> r1, final Function1<? super Integer, Integer> r2) {
        return slideIn(r1, new C00982(r2));
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> r11, Function1<? super IntSize, IntOffset> r12) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(r12, r11), null, null, false, null, 61, null));
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> r1, final Function1<? super Integer, Integer> r2) {
        return slideOut(r1, new C01002(r2));
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> r1, final Function1<? super Integer, Integer> r2) {
        return slideOut(r1, new C01022(r2));
    }

    private static final void trackActiveEnter$lambda$7(MutableState<EnterTransition> r0, EnterTransition r1) {
        r0.setValue(r1);
    }

    private static final void trackActiveExit$lambda$10(MutableState<ExitTransition> r0, ExitTransition r1) {
        r0.setValue(r1);
    }

    public static final EnterTransition withEffect(EnterTransition r10, TransitionEffect r11) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(r11.getKey$animation(), r11)), 31, null));
    }

    public static final <T extends TransitionEffect> T get(ExitTransition r0, TransitionEffectKey<T> r1) {
        TransitionEffect r2 = r0.getData$animation().getEffectsMap().get(r1);
        if ((r2 instanceof TransitionEffect) == true) goto L7;
        return null;
    L7:
        return (T) r2;
    }

    public static final ExitTransition withEffect(ExitTransition r10, TransitionEffect r11) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(r11.getKey$animation(), r11)), 31, null));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m164scaleInL8ZKhE(FiniteAnimationSpec<Float> r17, float r18, long r19) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(r18, r19, r17, null), false, null, 55, null));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m166scaleOutL8ZKhE(FiniteAnimationSpec<Float> r17, float r18, long r19) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(r18, r19, r17, null), false, null, 55, null));
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> r1, Alignment.Horizontal r2, boolean r3, final Function1<? super Integer, Integer> r4) {
        return expandIn(r1, toAlignment(r2), r3, new AnonymousClass2(r4));
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> r11, Alignment r12, boolean r13, Function1<? super IntSize, IntSize> r14) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(r12, r14, r11, r13), null, false, null, 59, null));
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> r1, Alignment.Vertical r2, boolean r3, final Function1<? super Integer, Integer> r4) {
        return expandIn(r1, toAlignment(r2), r3, new C00892(r4));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = MenuKt.ClosedAlphaTarget;
    L9:
        return fadeIn(r2, r3);
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = MenuKt.ClosedAlphaTarget;
    L9:
        return fadeOut(r2, r3);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> r1, Alignment.Horizontal r2, boolean r3, final Function1<? super Integer, Integer> r4) {
        return shrinkOut(r1, toAlignment(r2), r3, new C00912(r4));
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> r11, Alignment r12, boolean r13, Function1<? super IntSize, IntSize> r14) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(r12, r14, r11, r13), null, false, null, 59, null));
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> r1, Alignment.Vertical r2, boolean r3, final Function1<? super Integer, Integer> r4) {
        return shrinkOut(r1, toAlignment(r2), r3, new C00942(r4));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        return slideIn(r2, r3);
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = C00951.INSTANCE;
    L9:
        return slideInHorizontally(r3, r4);
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = C00971.INSTANCE;
    L9:
        return slideInVertically(r3, r4);
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        return slideOut(r2, r3);
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = C00991.INSTANCE;
    L9:
        return slideOutHorizontally(r3, r4);
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = C01011.INSTANCE;
    L9:
        return slideOutVertically(r3, r4);
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> r3, EnterTransition r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(21614502, r6, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:908)");
    L6:
        if (((r6 & 14) ^ 6) <= 4) goto L10;
        if (r5.changed(r3) == false) goto L10;
    L11:
        boolean r7 = true;
    L13:
        Object r0 = r5.rememberedValue();
        if (r7 == false) goto L16;
    L17:
        r0 = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        r5.updateRememberedValue(r0);
    L18:
        MutableState r1 = (MutableState) r0;
        if (r3.getCurrentState() != r3.getTargetState()) goto L27;
        if (r3.getCurrentState() != EnterExitState.Visible) goto L27;
        if (r3.isSeeking() == false) goto L25;
        trackActiveEnter$lambda$7(r1, r4);
    L29:
        EnterTransition r8 = trackActiveEnter$lambda$6(r1);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r8;
    L25:
        trackActiveEnter$lambda$7(r1, EnterTransition.Companion.getNone());
    L27:
        if (r3.getTargetState() != EnterExitState.Visible) goto L29;
        trackActiveEnter$lambda$7(r1, trackActiveEnter$lambda$6(r1).plus(r4));
        goto L29
    L16:
        if (r0 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r6 & 6) == 4) goto L11;
        r7 = false;
        goto L13
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> r3, ExitTransition r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1363864804, r6, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:928)");
    L6:
        if (((r6 & 14) ^ 6) <= 4) goto L10;
        if (r5.changed(r3) == false) goto L10;
    L11:
        boolean r7 = true;
    L13:
        Object r0 = r5.rememberedValue();
        if (r7 == false) goto L16;
    L17:
        r0 = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        r5.updateRememberedValue(r0);
    L18:
        MutableState r1 = (MutableState) r0;
        if (r3.getCurrentState() != r3.getTargetState()) goto L27;
        if (r3.getCurrentState() != EnterExitState.Visible) goto L27;
        if (r3.isSeeking() == false) goto L25;
        trackActiveExit$lambda$10(r1, r4);
    L29:
        ExitTransition r8 = trackActiveExit$lambda$9(r1);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r8;
    L25:
        trackActiveExit$lambda$10(r1, ExitTransition.Companion.getNone());
    L27:
        if (r3.getTargetState() == EnterExitState.Visible) goto L29;
        trackActiveExit$lambda$10(r1, trackActiveExit$lambda$9(r1).plus(r4));
        goto L29
    L16:
        if (r0 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r6 & 6) == 4) goto L11;
        r7 = false;
        goto L13
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m165scaleInL8ZKhE$default(FiniteAnimationSpec r2, float r3, long r4, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
    L12:
        return m164scaleInL8ZKhE(r2, r3, r4);
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m167scaleOutL8ZKhE$default(FiniteAnimationSpec r2, float r3, long r4, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
    L12:
        return m166scaleOutL8ZKhE(r2, r3, r4);
    }

    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(final Transition<EnterExitState> r20, final EnterTransition r21, final ExitTransition r22, String r23, Composer r24, int r25) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(642253525, r25, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:956)");
    L5:
        boolean r9 = false;
        if (r21.getData$animation().getFade() == null) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (r21.getData$animation().getScale() == null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        Transition.DeferredAnimation r12 = null;
        if (r1 == false) goto L25;
        r24.startReplaceGroup(-703859581);
        TwoWayConverter<Float, AnimationVector1D> r2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Object r3 = r24.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L24;
        r3 = r23 + " alpha";
        r24.updateRememberedValue(r3);
    L24:
        Transition.DeferredAnimation r4 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r20, r2, (String) r3, r24, (r25 & 14) | 384, 0);
        r24.endReplaceGroup();
        final Transition.DeferredAnimation r14 = r4;
    L26:
        if (r11 == false) goto L31;
        r24.startReplaceGroup(-703622493);
        TwoWayConverter<Float, AnimationVector1D> r5 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Object r6 = r24.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L30;
        r6 = r23 + " scale";
        r24.updateRememberedValue(r6);
    L30:
        Transition.DeferredAnimation r0 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r20, r5, (String) r6, r24, (r25 & 14) | 384, 0);
        r24.endReplaceGroup();
        final Transition.DeferredAnimation r15 = r0;
    L32:
        if (r11 == false) goto L34;
        r24.startReplaceGroup(-703375392);
        r12 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r20, TransformOriginVectorConverter, "TransformOriginInterruptionHandling", r24, (r25 & 14) | 384, 0);
        r24.endReplaceGroup();
    L35:
        boolean r7 = r24.changedInstance(r14);
        if (((r25 & 112) ^ 48) <= 32) goto L42;
        if (r24.changed(r21) == false) goto L42;
    L43:
        boolean r8 = true;
    L45:
        boolean r10 = r7 | r8;
        if (((r25 & 896) ^ 384) <= 256) goto L52;
        if (r24.changed(r22) == false) goto L52;
    L53:
        boolean r13 = true;
    L55:
        boolean r16 = (r10 | r13) | r24.changedInstance(r15);
        if (((r25 & 14) ^ 6) <= 4) goto L62;
        if (r24.changed(r20) == false) goto L62;
    L63:
        r9 = true;
    L64:
        boolean r17 = (r16 | r9) | r24.changedInstance(r12);
        Object r18 = r24.rememberedValue();
        if (r17 == false) goto L67;
    L68:
        final Transition.DeferredAnimation r19 = r12;
        r18 = new b(r14, r15, r20, r21, r22, r19);
        r24.updateRememberedValue(r18);
    L69:
        GraphicsLayerBlockForEnterExit r26 = (GraphicsLayerBlockForEnterExit) r18;
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        return r26;
    L67:
        if (r18 != Composer.Companion.getEmpty()) goto L69;
    L62:
        if ((r25 & 6) != 4) goto L64;
    L52:
        if ((r25 & 384) == 256) goto L53;
        r13 = false;
    L42:
        if ((r25 & 48) == 32) goto L43;
        r8 = false;
        goto L45
    L34:
        r24.startReplaceGroup(-703203064);
        r24.endReplaceGroup();
        goto L35
    L31:
        r24.startReplaceGroup(-703453048);
        r24.endReplaceGroup();
        r15 = null;
        goto L32
    L25:
        r24.startReplaceGroup(-703690136);
        r24.endReplaceGroup();
        r14 = null;
        goto L26
    L15:
        if (r22.getData$animation().getScale() != null) goto L18;
        r11 = false;
        goto L19
    L8:
        if (r22.getData$animation().getFade() != null) goto L11;
        r1 = false;
        goto L13
    }

    private static final Function1 createGraphicsLayerBlock$lambda$14$lambda$13(Transition.DeferredAnimation r3, Transition.DeferredAnimation r4, Transition r5, final EnterTransition r6, final ExitTransition r7, Transition.DeferredAnimation r8) {
        final State r0 = null;
        if (r3 == null) goto L5;
        final State r9 = r3.animate(new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1(r6, r7), new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2(r6, r7));
    L6:
        if (r4 == null) goto L8;
        final State r10 = r4.animate(new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1(r6, r7), new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2(r6, r7));
    L10:
        if (r5.getCurrentState() != EnterExitState.PreEnter) goto L17;
        Scale r11 = r6.getData$animation().getScale();
        if (r11 == null) goto L14;
    L13:
        final TransformOrigin r12 = TransformOrigin.box-impl(r11.m195getTransformOriginSzJe1aQ());
    L24:
        if (r8 == null) goto L27;
        r0 = r8.animate(EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.INSTANCE, new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2(r12, r6, r7));
    L27:
        return new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1(r9, r10, r0);
    L14:
        r11 = r7.getData$animation().getScale();
        if (r11 != null) goto L13;
    L23:
        r12 = null;
        goto L24
    L17:
        Scale r13 = r7.getData$animation().getScale();
        if (r13 == null) goto L20;
    L19:
        r12 = TransformOrigin.box-impl(r13.m195getTransformOriginSzJe1aQ());
        goto L24
    L20:
        r13 = r6.getData$animation().getScale();
        if (r13 == null) goto L23;
    L8:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec r3, Alignment.Horizontal r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getEnd();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = AnonymousClass1.INSTANCE;
    L15:
        return expandHorizontally(r3, r4, r5, r6);
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec r3, Alignment r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getBottomEnd();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = C00871.INSTANCE;
    L15:
        return expandIn(r3, r4, r5, r6);
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec r3, Alignment.Vertical r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getBottom();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = C00881.INSTANCE;
    L15:
        return expandVertically(r3, r4, r5, r6);
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec r3, Alignment.Horizontal r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getEnd();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = C00901.INSTANCE;
    L15:
        return shrinkHorizontally(r3, r4, r5, r6);
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec r3, Alignment r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getBottomEnd();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = C00921.INSTANCE;
    L15:
        return shrinkOut(r3, r4, r5, r6);
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec r3, Alignment.Vertical r4, boolean r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = Alignment.Companion.getBottom();
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r6 = C00931.INSTANCE;
    L15:
        return shrinkVertically(r3, r4, r5, r6);
    }

    public static final Modifier createModifier(Transition<EnterExitState> r21, EnterTransition r22, ExitTransition r23, Function0<Boolean> r24, String r25, Composer r26, int r27, int r28) {
        if ((r28 & 4) == 0) goto L8;
        Object r0 = r26.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L7;
        r0 = EnterExitTransitionKt$createModifier$1$1.INSTANCE;
        r26.updateRememberedValue(r0);
    L7:
        final Function0<Boolean> r10 = (Function0) r0;
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventStart(28261782, r27, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:860)");
    L12:
        int r11 = r27 & 14;
        EnterTransition r12 = trackActiveEnter(r21, r22, r26, (r27 & 112) | r11);
        int r13 = r27 >> 3;
        ExitTransition r14 = trackActiveExit(r21, r23, r26, (r13 & 112) | r11);
        boolean r15 = true;
        if (r12.getData$animation().getSlide() == null) goto L15;
    L18:
        boolean r1 = true;
    L20:
        if (r12.getData$animation().getChangeSize() == null) goto L22;
    L25:
        boolean r17 = true;
    L26:
        Transition.DeferredAnimation r18 = null;
        if (r1 == false) goto L32;
        r26.startReplaceGroup(133838277);
        TwoWayConverter<IntOffset, AnimationVector2D> r2 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        Object r3 = r26.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L31;
        r3 = r25 + " slide";
        r26.updateRememberedValue(r3);
    L31:
        Transition.DeferredAnimation r4 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r21, r2, (String) r3, r26, r11 | 384, 0);
        r26.endReplaceGroup();
        Transition.DeferredAnimation r19 = r4;
    L33:
        if (r17 == false) goto L38;
        r26.startReplaceGroup(134035871);
        TwoWayConverter<IntSize, AnimationVector2D> r5 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        Object r6 = r26.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L37;
        r6 = r25 + " shrink/expand";
        r26.updateRememberedValue(r6);
    L37:
        Transition.DeferredAnimation r7 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r21, r5, (String) r6, r26, r11 | 384, 0);
        r26.endReplaceGroup();
        Transition.DeferredAnimation r20 = r7;
    L39:
        if (r17 == false) goto L44;
        r26.startReplaceGroup(134220321);
        TwoWayConverter<IntOffset, AnimationVector2D> r8 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        Object r9 = r26.rememberedValue();
        if (r9 != Composer.Companion.getEmpty()) goto L43;
        r9 = r25 + " InterruptionHandlingOffset";
        r26.updateRememberedValue(r9);
    L43:
        Transition.DeferredAnimation r16 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r21, r8, (String) r9, r26, r11 | 384, 0);
        r26.endReplaceGroup();
        r18 = r16;
    L45:
        ChangeSize r29 = r12.getData$animation().getChangeSize();
        if (r29 != null) goto L48;
    L50:
        boolean r30 = false;
    L51:
        if (r30 == true) goto L62;
        ChangeSize r31 = r14.getData$animation().getChangeSize();
        if (r31 != null) goto L55;
    L57:
        boolean r32 = false;
    L58:
        if (r32 == true) goto L62;
        if (r17 == false) goto L62;
        boolean r33 = false;
    L63:
        final boolean r34 = r33;
        GraphicsLayerBlockForEnterExit r110 = createGraphicsLayerBlock(r21, r12, r14, r25, r26, r11 | (r13 & 7168));
        Modifier.Companion r35 = Modifier.Companion;
        boolean r36 = r26.changed(r34);
        if (((r27 & 7168) ^ 3072) <= 2048) goto L68;
        if (r26.changed(r10) == false) goto L68;
    L71:
        boolean r37 = r36 | r15;
        Object r38 = r26.rememberedValue();
        if (r37 == false) goto L74;
    L75:
        r38 = new EnterExitTransitionKt$createModifier$2$1(r34, r10);
        r26.updateRememberedValue(r38);
    L76:
        Modifier r39 = GraphicsLayerModifierKt.graphicsLayer(r35, (Function1) r38).then(new EnterExitTransitionElement(r21, r20, r18, r19, r12, r14, r10, r110));
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
    L79:
        return r39;
    L74:
        if (r38 != Composer.Companion.getEmpty()) goto L76;
    L68:
        if ((r27 & 3072) == 2048) goto L71;
        r15 = false;
        goto L71
    L55:
        if (r31.getClip() == true) goto L57;
        r32 = true;
    L62:
        r33 = true;
        goto L63
    L48:
        if (r29.getClip() == true) goto L50;
        r30 = true;
        goto L51
    L44:
        r26.startReplaceGroup(134390727);
        r26.endReplaceGroup();
        goto L45
    L38:
        r26.startReplaceGroup(134146695);
        r26.endReplaceGroup();
        r20 = null;
        goto L39
    L32:
        r26.startReplaceGroup(133944080);
        r26.endReplaceGroup();
        r19 = null;
        goto L33
    L22:
        if (r14.getData$animation().getChangeSize() != null) goto L25;
        r17 = false;
        goto L26
    L15:
        if (r14.getData$animation().getSlide() != null) goto L18;
        r1 = false;
        goto L20
    L8:
        r10 = r24;
        goto L10
    }
}
