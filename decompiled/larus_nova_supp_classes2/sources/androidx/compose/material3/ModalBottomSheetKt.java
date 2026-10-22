package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aú\u0001\u0010!\u001a\u00020\u0001*\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0001¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a\u0014\u00103\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a-\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u000b2\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u00108\u001a5\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0003¢\u0006\u0004\b=\u0010>\"\u0010\u0010?\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006E²\u0006\n\u0010F\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", "visible", "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final long PredictiveBackChildTransformOrigin = 0;
    private static final float PredictiveBackMaxScaleXDistance = 0.0f;
    private static final float PredictiveBackMaxScaleYDistance = 0.0f;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SheetValue.values().length];
            r0[SheetValue.Hidden.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SheetValue.PartiallyExpanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SheetValue.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope r22, Animatable r23, CoroutineScope r24, Function0 r25, Function1 r26, Modifier r27, SheetState r28, float r29, boolean r30, Shape r31, long r32, long r34, float r36, Function2 r37, Function2 r38, Function3 r39, int r40, int r41, int r42, Composer r43, int r44) {
        m2871ModalBottomSheetContent7e2Q(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r36, r37, r38, r39, r43, RecomposeScopeImplKt.updateChangedFlags(r40 | 1), RecomposeScopeImplKt.updateChangedFlags(r41), r42);
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$13(Function0 r21, Modifier r22, SheetState r23, float r24, boolean r25, Shape r26, long r27, long r29, float r31, long r32, Function2 r34, Function2 r35, ModalBottomSheetProperties r36, Function3 r37, int r38, int r39, int r40, Composer r41, int r42) {
        m2869ModalBottomSheetYbuCTN8(r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_dYc4hso$lambda$14(Function0 r20, Modifier r21, SheetState r22, float r23, Shape r24, long r25, long r27, float r29, long r30, Function2 r32, Function2 r33, ModalBottomSheetProperties r34, Function3 r35, int r36, int r37, int r38, Composer r39, int r40) {
        m2870ModalBottomSheetdYc4hso(r20, r21, r22, r23, r24, r25, r27, r29, r30, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_KTwxG1Y$lambda$34(long r7, Function0 r9, boolean r10, boolean r11, int r12, Composer r13, int r14) {
        m2872ScrimKTwxG1Y(r7, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(CoroutineScope r0, SheetState r1, Function0 r2, float r3) {
        return ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(Function0 r1, Modifier r2, SheetState r3, float r4, boolean r5, Shape r6, long r7, long r9, float r11, long r12, Function2 r14, Function2 r15, ModalBottomSheetProperties r16, Function3 r17, int r18, int r19, int r20, Composer r21, int r22) {
        return ModalBottomSheet_YbuCTN8$lambda$13(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ Pair c(SheetState r0, IntSize r1, Constraints r2) {
        return ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return Scrim_KTwxG1Y$lambda$31$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(Function0 r0, Throwable r1) {
        return ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit f(long r0, State r2, DrawScope r3) {
        return Scrim_KTwxG1Y$lambda$33$lambda$32(r0, r2, r3);
    }

    public static /* synthetic */ Unit g(long r0, Function0 r2, boolean r3, boolean r4, int r5, Composer r6, int r7) {
        return Scrim_KTwxG1Y$lambda$34(r0, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit h(Function0 r1, Modifier r2, SheetState r3, float r4, Shape r5, long r6, long r8, float r10, long r11, Function2 r13, Function2 r14, ModalBottomSheetProperties r15, Function3 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return ModalBottomSheet_dYc4hso$lambda$14(r1, r2, r3, r4, r5, r6, r8, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit i(SheetState r0, CoroutineScope r1, Function0 r2) {
        return ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit j(SheetState r0, Function0 r1, Throwable r2) {
        return ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit k(SheetState r0, Function0 r1, Throwable r2) {
        return ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ boolean l(Function0 r0) {
        return Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(r0);
    }

    public static /* synthetic */ Unit m(float r0, IntSize r1, SheetState r2, DraggableAnchorsConfig r3) {
        return ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit n(SheetState r0, CoroutineScope r1, Animatable r2, Function0 r3) {
        return ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit o(String r0, SemanticsPropertyReceiver r1) {
        return ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(r0, r1);
    }

    public static /* synthetic */ boolean p(SheetValue r0) {
        return rememberModalBottomSheetState$lambda$26$lambda$25(r0);
    }

    public static /* synthetic */ Unit q(BoxScope r1, Animatable r2, CoroutineScope r3, Function0 r4, Function1 r5, Modifier r6, SheetState r7, float r8, boolean r9, Shape r10, long r11, long r13, float r15, Function2 r16, Function2 r17, Function3 r18, int r19, int r20, int r21, Composer r22, int r23) {
        return ModalBottomSheetContent_7___e2Q$lambda$24(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    public static /* synthetic */ Unit r(SheetState r0, Animatable r1, GraphicsLayerScope r2) {
        return ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(r0, r1, r2);
    }

    private static final boolean rememberModalBottomSheetState$lambda$26$lambda$25(SheetValue r0) {
        return true;
    }

    public static /* synthetic */ Unit s(SheetState r0, FiniteAnimationSpec r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        return ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    static {
        PredictiveBackMaxScaleXDistance = Dp.constructor-impl(48);
        PredictiveBackMaxScaleYDistance = Dp.constructor-impl(24);
        PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, MenuKt.ClosedAlphaTarget);
    }

    public static final /* synthetic */ long access$getPredictiveBackChildTransformOrigin$p() {
        return PredictiveBackChildTransformOrigin;
    }

    private static final float Scrim_KTwxG1Y$lambda$27(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final boolean Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0 r0) {
        r0.invoke();
        return true;
    }

    private static final Unit ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setPaneTitle(r1, r0);
        SemanticsPropertiesKt.setTraversalIndex(r1, MenuKt.ClosedAlphaTarget);
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0 r0, Throwable r1) {
        r0.invoke();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calculatePredictiveBackScaleX(GraphicsLayerScope r0, float r1) {
        return calculatePredictiveBackScaleX(r0, r1);
    }

    public static final /* synthetic */ float access$calculatePredictiveBackScaleY(GraphicsLayerScope r0, float r1) {
        return calculatePredictiveBackScaleY(r0, r1);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope r4, float r5) {
        float r0 = Float.intBitsToFloat((int) (r4.getSize-NH-jbRc() >> 32));
        if (Float.isNaN(r0) == false) goto L5;
        return 1.0f;
    L5:
        if (r0 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        return 1.0f;
    L11:
        return 1.0f - (MathHelpersKt.lerp(MenuKt.ClosedAlphaTarget, Math.min(r4.toPx-0680j_4(PredictiveBackMaxScaleXDistance), r0), r5) / r0);
    L7:
        r3 = false;
        goto L8
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope r4, float r5) {
        float r0 = Float.intBitsToFloat((int) (r4.getSize-NH-jbRc() & 4294967295L));
        if (Float.isNaN(r0) == false) goto L5;
        return 1.0f;
    L5:
        if (r0 != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        return 1.0f;
    L11:
        return 1.0f - (MathHelpersKt.lerp(MenuKt.ClosedAlphaTarget, Math.min(r4.toPx-0680j_4(PredictiveBackMaxScaleYDistance), r0), r5) / r0);
    L7:
        r3 = false;
        goto L8
    }

    private static final Pair ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(final SheetState r2, final IntSize r3, Constraints r4) {
        final float r5 = Constraints.getMaxHeight-impl(r4.unbox-impl());
        DraggableAnchors r6 = AnchoredDraggableKt.DraggableAnchors(new ie(r5, r3, r2));
        int r7 = WhenMappings.$EnumSwitchMapping$0[((SheetValue) r2.getAnchoredDraggableState$material3().getTargetValue()).ordinal()];
        if (r7 != 1) goto L5;
        SheetValue r8 = SheetValue.Hidden;
    L23:
        return TuplesKt.to(r6, r8);
    L5:
        if (r7 != 2) goto L7;
        r8 = SheetValue.PartiallyExpanded;
        if (r6.hasAnchorFor(r8) == true) goto L23;
        r8 = SheetValue.Expanded;
        if (r6.hasAnchorFor(r8) == true) goto L23;
        r8 = SheetValue.Hidden;
        goto L23
    L7:
        if (r7 != 3) goto L13;
        r8 = SheetValue.Expanded;
        if (r6.hasAnchorFor(r8) == true) goto L23;
        r8 = SheetValue.Hidden;
        goto L23
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState r4, Animatable r5, GraphicsLayerScope r6) {
        float r7 = r4.getAnchoredDraggableState$material3().getOffset();
        float r0 = Float.intBitsToFloat((int) (r6.getSize-NH-jbRc() & 4294967295L));
        if (Float.isNaN(r7) == true) goto L13;
        if (Float.isNaN(r0) == true) goto L13;
        if (r0 != MenuKt.ClosedAlphaTarget) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        float r8 = ((Number) r5.getValue()).floatValue();
        r6.setScaleX(calculatePredictiveBackScaleX(r6, r8));
        r6.setScaleY(calculatePredictiveBackScaleY(r6, r8));
        r6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (r7 + r0) / r0));
        goto L13
    L9:
        r1 = false;
    L13:
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(final SheetState r7, CoroutineScope r8, final Function0 r9) {
        if (((Boolean) r7.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Hidden)).booleanValue() == false) goto L6;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(r7, null), 3, null).invokeOnCompletion(new he(r7, r9));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState r0, Function0 r1, Throwable r2) {
        if (r0.isVisible() == true) goto L6;
        r1.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState r0, Function0 r1, Throwable r2) {
        if (r0.isVisible() == true) goto L6;
        r1.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_KTwxG1Y$lambda$31$lambda$30(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setTraversalIndex(r3, 1.0f);
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new de(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_KTwxG1Y$lambda$33$lambda$32(long r13, State r15, DrawScope r16) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r16, r13, 0, 0, RangesKt.coerceIn(Scrim_KTwxG1Y$lambda$27(r15), MenuKt.ClosedAlphaTarget, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(float r4, IntSize r5, SheetState r6, DraggableAnchorsConfig r7) {
        r7.at(SheetValue.Hidden, r4);
        if (((int) (r5.unbox-impl() & 4294967295L)) <= (r4 / 2)) goto L8;
        if (r6.getSkipPartiallyExpanded$material3() == true) goto L8;
        r7.at(SheetValue.PartiallyExpanded, r4 / 2.0f);
    L8:
        if (((int) (r5.unbox-impl() & 4294967295L)) == 0) goto L11;
        r7.at(SheetValue.Expanded, Math.max(MenuKt.ClosedAlphaTarget, r4 - ((int) (r5.unbox-impl() & 4294967295L))));
    L11:
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState r0, FiniteAnimationSpec r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        r0.setShowMotionSpec$material3(r1);
        r0.setHideMotionSpec$material3(r2);
        r0.setAnchoredDraggableMotionSpec$material3(r3);
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState r16, CoroutineScope r17, Animatable r18, final Function0 r19) {
        if (r16.getCurrentValue() == SheetValue.Expanded) goto L5;
    L7:
        BuildersKt.launch$default(r17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(r16, null), 3, null).invokeOnCompletion(new zd(r19));
    L9:
        return Unit.INSTANCE;
    L5:
        if (r16.getHasPartiallyExpandedState() == false) goto L7;
        BuildersKt.launch$default(r17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(r18, null), 3, null);
        BuildersKt.launch$default(r17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(r16, null), 3, null);
        goto L9
    }

    private static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope r6, final SheetState r7, final Function0 r8, float r9) {
        BuildersKt.launch$default(r6, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(r7, r9, null), 3, null).invokeOnCompletion(new pe(r7, r8));
        return Unit.INSTANCE;
    }

    public static final SheetState rememberModalBottomSheetState(boolean r9, Function1<? super SheetValue, Boolean> r10, Composer r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r13 & 2) == 0) goto L12;
        Object r14 = r11.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L11;
        r14 = new ce();
        r11.updateRememberedValue(r14);
    L11:
        r10 = (Function1) r14;
    L12:
        Function1<? super SheetValue, Boolean> r1 = r10;
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventStart(-778250030, r12, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:502)");
    L15:
        SheetState r15 = SheetDefaultsKt.m3114rememberSheetStateAGcomas(r0, r1, SheetValue.Hidden, false, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, ((r12 & 14) | 384) | (r12 & 112), 56);
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventEnd();
    L18:
        return r15;
    L5:
        r0 = r9;
        goto L7
    }

    /* JADX INFO: renamed from: Scrim-KTwxG1Y, reason: not valid java name */
    private static final void m2872ScrimKTwxG1Y(final long r20, final Function0<Unit> r22, final boolean r23, final boolean r24, Composer r25, final int r26) {
        Composer r15 = r25.startRestartGroup(-391613911);
        if ((r26 & 6) == 0) goto L5;
        int r7 = r26;
    L11:
        if ((r26 & 48) != 0) goto L18;
        if (r15.changedInstance(r22) == false) goto L15;
        int r8 = 32;
    L16:
        r7 = r7 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r26 & 384) != 0) goto L25;
        if (r15.changed(r23) == false) goto L22;
        int r9 = 256;
    L23:
        r7 = r7 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r26 & 3072) == 0) goto L27;
    L31:
        int r12 = r7;
        if ((r12 & 1171) == 1170) goto L34;
        boolean r10 = true;
    L36:
        if (r15.shouldExecute(r10, r12 & 1) == true) goto L38;
        r15.skipToGroupEnd();
    L86:
        ScopeUpdateScope r11 = r15.endRestartGroup();
        if (r11 == null) goto L90;
        r11.updateScope(new ge(r20, r22, r23, r24, r26));
        return;
    L90:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventStart(-391613911, r12, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:514)");
    L41:
        if (r20 == 16) goto L43;
        boolean r0 = true;
    L44:
        if (r0 == false) goto L81;
        r15.startReplaceGroup(-1438582326);
        if (r23 == false) goto L48;
        float r13 = 1.0f;
    L49:
        final State<Float> r14 = AnimateAsStateKt.animateFloatAsState(r13, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r15, 6), MenuKt.ClosedAlphaTarget, null, null, r15, 0, 28);
        final String r16 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131895697), r15, 0);
        if (r24 == false) goto L70;
        r15.startReplaceGroup(-1438283579);
        Modifier.Companion r17 = Modifier.Companion;
        int r18 = r12 & 112;
        if (r18 != 32) goto L54;
        boolean r19 = true;
    L55:
        Object r110 = r15.rememberedValue();
        if (r19 == false) goto L58;
    L59:
        r110 = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(r22);
        r15.updateRememberedValue(r110);
    L60:
        Modifier r21 = SuspendingPointerInputFilterKt.pointerInput(r17, r22, (PointerInputEventHandler) r110);
        boolean r111 = r15.changed(r16);
        if (r18 != 32) goto L63;
        boolean r112 = true;
    L64:
        boolean r113 = r111 | r112;
        Object r114 = r15.rememberedValue();
        if (r113 == false) goto L67;
    L68:
        r114 = new ee(r16, r22);
        r15.updateRememberedValue(r114);
    L69:
        int r27 = 1;
        Modifier r28 = SemanticsModifierKt.semantics(r21, true, (Function1) r114);
        r15.endReplaceGroup();
    L71:
        Modifier r29 = SizeKt.fillMaxSize$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, r27, null).then(r28);
        if ((r12 & 14) != 4) goto L74;
        boolean r115 = true;
    L75:
        boolean r30 = r15.changed(r14) | r115;
        Object r116 = r15.rememberedValue();
        if (r30 == false) goto L78;
    L79:
        r116 = new fe(r20, r14);
        r15.updateRememberedValue(r116);
    L80:
        CanvasKt.Canvas(r29, (Function1) r116, r15, 0);
        r15.endReplaceGroup();
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventEnd();
        goto L86
    L78:
        if (r116 != Composer.Companion.getEmpty()) goto L80;
    L74:
        r115 = false;
        goto L75
    L67:
        if (r114 != Composer.Companion.getEmpty()) goto L69;
    L63:
        r112 = false;
        goto L64
    L58:
        if (r110 != Composer.Companion.getEmpty()) goto L60;
    L54:
        r19 = false;
        goto L55
    L70:
        r27 = 1;
        r15.startReplaceGroup(-1437857391);
        r15.endReplaceGroup();
        r28 = Modifier.Companion;
        goto L71
    L48:
        r13 = MenuKt.ClosedAlphaTarget;
        goto L49
    L81:
        r15.startReplaceGroup(-1437676103);
        r15.endReplaceGroup();
        goto L83
    L43:
        r0 = false;
        goto L44
    L34:
        r10 = false;
        goto L36
    L27:
        if (r15.changed(r24) == false) goto L29;
        int r31 = 2048;
    L30:
        r7 = r7 | r31;
        goto L31
    L29:
        r31 = 1024;
        goto L30
    L5:
        if (r15.changed(r20) == false) goto L7;
        int r32 = 4;
    L8:
        r7 = r32 | r26;
        goto L11
    L7:
        r32 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$Scrim-KTwxG1Y, reason: not valid java name */
    public static final /* synthetic */ void m2873access$ScrimKTwxG1Y(long r0, Function0 r2, boolean r3, boolean r4, Composer r5, int r6) {
        m2872ScrimKTwxG1Y(r0, r2, r3, r4, r5, r6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary compatibility. Use overload with sheetGesturesEnabled param.")
    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    public static final /* synthetic */ void m2870ModalBottomSheetdYc4hso(final Function0 r45, Modifier r46, SheetState r47, float r48, Shape r49, long r50, long r52, float r54, long r55, Function2 r57, Function2 r58, ModalBottomSheetProperties r59, final Function3 r60, Composer r61, final int r62, final int r63, final int r64) {
        Composer r1 = r61.startRestartGroup(953901324);
        if ((r64 & 1) == 0) goto L6;
        int r5 = r62 | 6;
    L13:
        int r6 = r64 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L25:
        if ((r62 & 384) == 0) goto L27;
        SheetState r10 = r47;
    L35:
        int r16 = r64 & 8;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L47:
        if ((r62 & 24576) != 0) goto L58;
        if ((r64 & 16) != 0) goto L54;
        if (r1.changed(r49) == false) goto L54;
        int r18 = 16384;
    L55:
        r5 = r5 | r18;
    L54:
        r18 = 8192;
    L58:
        if ((r62 & 196608) != 0) goto L68;
        if ((r64 & 32) == 0) goto L62;
    L64:
        int r20 = 65536;
    L65:
        r5 = r5 | r20;
        goto L68
    L62:
        if (r1.changed(r50) == false) goto L64;
        r20 = 131072;
    L68:
        if ((r62 & 1572864) != 0) goto L76;
        long r11 = r52;
        if ((r64 & 64) == 0) goto L72;
    L74:
        int r22 = 524288;
    L75:
        r5 = r5 | r22;
    L77:
        int r0 = r64 & 128;
        if (r0 == 0) goto L81;
        r5 = r5 | 12582912;
    L88:
        if ((r62 & 100663296) != 0) goto L98;
        if ((r64 & 256) != 0) goto L95;
        if (r1.changed(r55) == false) goto L95;
        int r23 = 67108864;
    L96:
        r5 = r5 | r23;
    L95:
        r23 = 33554432;
    L98:
        int r2 = r64 & 512;
        if (r2 == 0) goto L102;
        r5 = r5 | 805306368;
    L110:
        if ((r63 & 6) == 0) goto L112;
        int r17 = r63;
    L120:
        int r3 = r64 & 2048;
        if (r3 == 0) goto L124;
        r17 = r17 | 48;
    L130:
        int r4 = r17;
        if ((r64 & 4096) == 0) goto L134;
        r4 = r4 | 384;
    L141:
        if ((306783379 & r5) == 306783378) goto L143;
    L146:
        boolean r7 = true;
    L148:
        if (r1.shouldExecute(r7, r5 & 1) == false) goto L220;
        r1.startDefaults();
        if ((r62 & 1) != 0) goto L152;
    L173:
        if (r6 == 0) goto L175;
        Modifier r8 = Modifier.Companion;
    L177:
        if ((r64 & 4) == 0) goto L179;
        SheetState r9 = rememberModalBottomSheetState(false, null, r1, 0, 3);
        r5 = r5 & (-897);
    L180:
        if (r16 == 0) goto L182;
        float r12 = BottomSheetDefaults.INSTANCE.m2335getSheetMaxWidthD9Ej5fM();
    L184:
        if ((r64 & 16) == 0) goto L186;
        Shape r13 = BottomSheetDefaults.INSTANCE.getExpandedShape(r1, 6);
        r5 = r5 & (-57345);
    L187:
        Modifier r410 = r8;
        if ((r64 & 32) == 0) goto L190;
        int r19 = r5 & (-458753);
        long r14 = BottomSheetDefaults.INSTANCE.getContainerColor(r1, 6);
    L192:
        if ((r64 & 64) == 0) goto L194;
        r11 = ColorSchemeKt.m2496contentColorForek8zF_U(r14, r1, (r19 >> 15) & 14);
        r19 = r19 & (-3670017);
    L194:
        if (r0 == 0) goto L196;
        float r15 = Dp.constructor-impl(0);
    L198:
        if ((r64 & 256) == 0) goto L200;
        long r110 = BottomSheetDefaults.INSTANCE.getScrimColor(r1, 6);
        int r21 = r19 & (-234881025);
    L201:
        if (r2 == 0) goto L203;
        Function2 r24 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.m2533getLambda$655173438$material3();
    L205:
        if ((r64 & 1024) == 0) goto L207;
        Function2 r25 = ModalBottomSheetKt$ModalBottomSheet$7.INSTANCE;
        r4 = r4 & (-15);
    L208:
        if (r3 == 0) goto L210;
        ModalBottomSheetProperties r38 = ModalBottomSheetDefaults.INSTANCE.getProperties();
    L211:
        int r111 = r4;
        Function2 r37 = r25;
        long r26 = r110;
        Modifier r27 = r410;
        Function2 r28 = r24;
        float r29 = r15;
    L212:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L216;
        ComposerKt.traceEventStart(953901324, r21, r111, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:237)");
    L216:
        int r112 = r21 << 3;
        int r113 = r111 << 3;
        Modifier r114 = r27;
        SheetState r115 = r9;
        float r116 = r12;
        Shape r210 = r13;
        long r211 = r14;
        long r212 = r11;
        float r213 = r29;
        long r214 = r26;
        Function2 r215 = r28;
        Function2 r30 = r37;
        ModalBottomSheetProperties r31 = r38;
        m2869ModalBottomSheetYbuCTN8(r45, r114, r115, r116, true, r210, r211, r212, r213, r214, r215, r30, r31, r60, r1, (((((((((r21 & 14) | 24576) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168)) | (r112 & 458752)) | (r112 & 3670016)) | (r112 & 29360128)) | (r112 & 234881024)) | (r112 & 1879048192), ((((r21 >> 27) & 14) | (r113 & 112)) | (r113 & 896)) | (r113 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L219;
        ComposerKt.traceEventEnd();
    L219:
        final Function2 r117 = r28;
        final Function2 r118 = r37;
        final ModalBottomSheetProperties r119 = r38;
        float r41 = r29;
        final Modifier r32 = r27;
        float r42 = r12;
        final float r120 = r41;
        long r43 = r26;
        final SheetState r33 = r9;
        final long r34 = r14;
        final Shape r35 = r13;
        final float r36 = r42;
        final long r39 = r11;
        final long r121 = r43;
    L221:
        ScopeUpdateScope r40 = r1.endRestartGroup();
        if (r40 == null) goto L225;
        r40.updateScope(new oe(r45, r32, r33, r36, r35, r34, r39, r120, r121, r117, r118, r119, r60, r62, r63, r64));
        return;
    L225:
        return;
    L210:
        r38 = r59;
        goto L211
    L207:
        r25 = r58;
        goto L208
    L203:
        r24 = r57;
        goto L205
    L200:
        r110 = r55;
        r21 = r19;
        goto L201
    L196:
        r15 = r54;
        goto L198
    L190:
        r19 = r5;
        r14 = r50;
        goto L192
    L186:
        r13 = r49;
        goto L187
    L182:
        r12 = r48;
        goto L184
    L179:
        r9 = r10;
        goto L180
    L175:
        r8 = r46;
        goto L177
    L152:
        if (r1.getDefaultsInvalid() == true) goto L173;
        r1.skipToGroupEnd();
        if ((r64 & 4) == 0) goto L158;
        r5 = r5 & (-897);
    L158:
        if ((r64 & 16) == 0) goto L161;
        r5 = r5 & (-57345);
    L161:
        if ((r64 & 32) == 0) goto L164;
        r5 = r5 & (-458753);
    L164:
        if ((r64 & 64) == 0) goto L167;
        r5 = r5 & (-3670017);
    L167:
        if ((r64 & 256) == 0) goto L170;
        r5 = r5 & (-234881025);
    L170:
        if ((r64 & 1024) == 0) goto L172;
        r4 = r4 & (-15);
    L172:
        r27 = r46;
        r13 = r49;
        r29 = r54;
        r28 = r57;
        r37 = r58;
        r38 = r59;
        r111 = r4;
        r21 = r5;
        r9 = r10;
        r12 = r48;
        r14 = r50;
        r26 = r55;
        goto L212
    L220:
        r1 = r1;
        r1.skipToGroupEnd();
        r32 = r46;
        r36 = r48;
        r35 = r49;
        r34 = r50;
        r117 = r57;
        r118 = r58;
        r119 = r59;
        r33 = r10;
        r39 = r11;
        r120 = r54;
        r121 = r55;
        goto L221
    L143:
        if ((r4 & 147) != 146) goto L146;
        r7 = false;
        goto L148
    L134:
        if ((r63 & 384) != 0) goto L141;
        if (r1.changedInstance(r60) == false) goto L138;
        int r216 = 256;
    L139:
        r4 = r4 | r216;
        goto L141
    L138:
        r216 = 128;
        goto L139
    L124:
        if ((r63 & 48) != 0) goto L130;
        if (r1.changed(r59) == false) goto L128;
        int r122 = 32;
    L129:
        r17 = r17 | r122;
        goto L130
    L128:
        r122 = 16;
        goto L129
    L112:
        if ((r64 & 1024) != 0) goto L117;
        if (r1.changedInstance(r58) == false) goto L117;
        int r123 = 4;
    L118:
        r17 = r63 | r123;
    L117:
        r123 = 2;
        goto L118
    L102:
        if ((805306368 & r62) != 0) goto L110;
        if (r1.changedInstance(r57) == false) goto L106;
        int r217 = 536870912;
    L107:
        r5 = r5 | r217;
        goto L110
    L106:
        r217 = 268435456;
        goto L107
    L81:
        if ((r62 & 12582912) != 0) goto L88;
        if (r1.changed(r54) == false) goto L85;
        int r218 = 8388608;
    L86:
        r5 = r5 | r218;
        goto L88
    L85:
        r218 = 4194304;
        goto L86
    L72:
        if (r1.changed(r11) == false) goto L74;
        r22 = 1048576;
        goto L75
    L76:
        r11 = r52;
        goto L77
    L39:
        if ((r62 & 3072) != 0) goto L47;
        if (r1.changed(r48) == false) goto L43;
        int r124 = 2048;
    L44:
        r5 = r5 | r124;
        goto L47
    L43:
        r124 = 1024;
        goto L44
    L27:
        if ((r64 & 4) != 0) goto L31;
        r10 = r47;
        if (r1.changed(r10) == false) goto L32;
        int r125 = 256;
    L33:
        r5 = r5 | r125;
    L32:
        r125 = 128;
        goto L33
    L31:
        r10 = r47;
        goto L32
    L17:
        if ((r62 & 48) != 0) goto L25;
        if (r1.changed(r46) == false) goto L21;
        int r126 = 32;
    L22:
        r5 = r5 | r126;
        goto L25
    L21:
        r126 = 16;
        goto L22
    L6:
        if ((r62 & 6) == 0) goto L8;
        r5 = r62;
        goto L13
    L8:
        if (r1.changedInstance(r45) == false) goto L10;
        int r44 = 4;
    L11:
        r5 = r44 | r62;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    public static final void m2869ModalBottomSheetYbuCTN8(final Function0<Unit> r47, Modifier r48, SheetState r49, float r50, boolean r51, Shape r52, long r53, long r55, float r57, long r58, Function2<? super Composer, ? super Integer, Unit> r60, Function2<? super Composer, ? super Integer, ? extends WindowInsets> r61, ModalBottomSheetProperties r62, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r63, Composer r64, final int r65, final int r66, final int r67) {
        Composer r2 = r64.startRestartGroup(1904798512);
        if ((r67 & 1) == 0) goto L6;
        int r3 = r65 | 6;
    L13:
        int r6 = r67 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r9 = r48;
    L25:
        if ((r65 & 384) == 0) goto L27;
        SheetState r10 = r49;
    L35:
        int r16 = r67 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r19 = r67 & 16;
        if (r19 == 0) goto L50;
        r3 = r3 | 24576;
    L58:
        if ((r65 & 196608) != 0) goto L66;
        Shape r11 = r52;
        if ((r67 & 32) == 0) goto L62;
    L64:
        int r22 = 65536;
    L65:
        r3 = r3 | r22;
    L68:
        if ((r65 & 1572864) != 0) goto L78;
        if ((r67 & 64) == 0) goto L72;
    L74:
        int r23 = 524288;
    L75:
        r3 = r3 | r23;
        goto L78
    L72:
        if (r2.changed(r53) == false) goto L74;
        r23 = 1048576;
    L78:
        if ((r65 & 12582912) != 0) goto L87;
        if ((r67 & 128) == 0) goto L82;
    L84:
        int r24 = 4194304;
    L85:
        r3 = r3 | r24;
        goto L87
    L82:
        if (r2.changed(r55) == false) goto L84;
        r24 = 8388608;
    L87:
        int r13 = r67 & 256;
        if (r13 == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((805306368 & r65) != 0) goto L108;
        if ((r67 & 512) != 0) goto L105;
        if (r2.changed(r58) == false) goto L105;
        int r25 = 536870912;
    L106:
        r3 = r3 | r25;
    L105:
        r25 = 268435456;
    L108:
        int r0 = r67 & 1024;
        if (r0 == 0) goto L112;
        int r26 = r66 | 6;
    L120:
        if ((r66 & 48) != 0) goto L130;
        if ((r67 & 2048) != 0) goto L127;
        if (r2.changedInstance(r61) == false) goto L127;
        int r20 = 32;
    L128:
        r26 = r26 | r20;
    L127:
        r20 = 16;
    L130:
        int r1 = r26;
        int r4 = r67 & 4096;
        if (r4 == 0) goto L134;
        r1 = r1 | 384;
    L142:
        if ((r67 & 8192) == 0) goto L145;
        r1 = r1 | 3072;
    L152:
        if ((r3 & 306783379) == 306783378) goto L154;
    L157:
        boolean r5 = true;
    L159:
        if (r2.shouldExecute(r5, r3 & 1) == false) goto L325;
        r2.startDefaults();
        if ((r65 & 1) != 0) goto L163;
    L184:
        if (r6 == 0) goto L186;
        Modifier r21 = Modifier.Companion;
    L188:
        if ((r67 & 4) == 0) goto L190;
        final SheetState r7 = rememberModalBottomSheetState(false, null, r2, 0, 3);
        r3 = r3 & (-897);
    L191:
        if (r16 == 0) goto L193;
        float r12 = BottomSheetDefaults.INSTANCE.m2335getSheetMaxWidthD9Ej5fM();
    L194:
        if (r19 == 0) goto L196;
        boolean r14 = true;
    L198:
        if ((r67 & 32) == 0) goto L201;
        r11 = BottomSheetDefaults.INSTANCE.getExpandedShape(r2, 6);
        r3 = r3 & (-458753);
    L201:
        if ((r67 & 64) == 0) goto L203;
        r3 = r3 & (-3670017);
        long r8 = BottomSheetDefaults.INSTANCE.getContainerColor(r2, 6);
    L205:
        if ((r67 & 128) == 0) goto L207;
        long r18 = ColorSchemeKt.m2496contentColorForek8zF_U(r8, r2, (r3 >> 18) & 14);
        r3 = r3 & (-29360129);
    L208:
        if (r13 == 0) goto L210;
        float r15 = Dp.constructor-impl(0);
    L212:
        if ((r67 & 512) == 0) goto L214;
        long r27 = BottomSheetDefaults.INSTANCE.getScrimColor(r2, 6);
        r3 = r3 & (-1879048193);
    L215:
        if (r0 == 0) goto L217;
        Function2<? super Composer, ? super Integer, Unit> r28 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
    L219:
        if ((r67 & 2048) == 0) goto L221;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r29 = ModalBottomSheetKt$ModalBottomSheet$1.INSTANCE;
        r1 = r1 & (-113);
    L222:
        if (r4 == 0) goto L224;
        int r54 = r1;
        Function2<? super Composer, ? super Integer, Unit> r30 = r28;
        int r31 = r54;
        ModalBottomSheetProperties r210 = new ModalBottomSheetProperties(false, false, 3, null);
    L225:
        long r32 = r27;
    L226:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L229;
        ComposerKt.traceEventStart(1904798512, r3, r31, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:137)");
    L229:
        MotionSchemeKeyTokens r110 = MotionSchemeKeyTokens.DefaultSpatial;
        int r211 = r31;
        final FiniteAnimationSpec r33 = MotionSchemeKt.value(r110, r2, 6);
        final FiniteAnimationSpec r111 = MotionSchemeKt.value(r110, r2, 6);
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r56 = r29;
        final FiniteAnimationSpec r34 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r2, 6);
        int r112 = (r3 & 896) ^ 384;
        Function2<? super Composer, ? super Integer, Unit> r59 = r30;
        if (r112 > 256) goto L232;
    L235:
        float r510 = r15;
        if ((r3 & 384) != 256) goto L238;
    L237:
        boolean r35 = true;
    L239:
        boolean r36 = ((r35 | r2.changedInstance(r111)) | r2.changedInstance(r34)) | r2.changedInstance(r33);
        Object r113 = r2.rememberedValue();
        if (r36 == false) goto L242;
    L243:
        r113 = new je(r7, r111, r34, r33);
        r2.updateRememberedValue(r113);
    L244:
        EffectsKt.SideEffect((Function0) r113, r2, 0);
        Object r37 = r2.rememberedValue();
        Composer.Companion r38 = Composer.Companion;
        if (r37 != r38.getEmpty()) goto L247;
        r37 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r2);
        r2.updateRememberedValue(r37);
    L247:
        final CoroutineScope r39 = (CoroutineScope) r37;
        if (r112 <= 256) goto L252;
        if (r2.changed(r7) == false) goto L252;
    L253:
        boolean r114 = true;
    L255:
        boolean r115 = r114 | r2.changedInstance(r39);
        int r116 = r3 & 14;
        if (r116 != 4) goto L258;
        boolean r40 = true;
    L259:
        boolean r41 = r40 | r115;
        Object r117 = r2.rememberedValue();
        if (r41 == false) goto L262;
    L265:
        final Function0<Unit> r42 = r47;
        r117 = new ke(r7, r39, r42);
        r2.updateRememberedValue(r117);
    L266:
        Function0 r212 = (Function0) r117;
        boolean r118 = r2.changedInstance(r39);
        long r511 = r8;
        if (r112 <= 256) goto L271;
        if (r2.changed(r7) == false) goto L271;
    L272:
        boolean r43 = true;
    L274:
        boolean r44 = r118 | r43;
        if (r116 != 4) goto L277;
        boolean r45 = true;
    L278:
        boolean r46 = r44 | r45;
        Object r68 = r2.rememberedValue();
        if (r46 == false) goto L281;
    L282:
        r68 = new le(r39, r7, r42);
        r2.updateRememberedValue(r68);
    L283:
        Function1 r310 = (Function1) r68;
        Object r69 = r2.rememberedValue();
        if (r69 != r38.getEmpty()) goto L287;
        r69 = AnimatableKt.Animatable$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
        r2.updateRememberedValue(r69);
    L287:
        final Animatable r70 = (Animatable) r69;
        if (r112 <= 256) goto L292;
        if (r2.changed(r7) == false) goto L292;
    L293:
        boolean r71 = true;
    L295:
        boolean r72 = (r71 | r2.changedInstance(r39)) | r2.changedInstance(r70);
        if (r116 != 4) goto L298;
        boolean r119 = true;
    L299:
        boolean r73 = r72 | r119;
        Object r120 = r2.rememberedValue();
        if (r73 == false) goto L302;
    L303:
        r120 = new me(r7, r39, r70, r42);
        r2.updateRememberedValue(r120);
    L304:
        ModalBottomSheet_androidKt.m2875ModalBottomSheetDialogsW7UJKQ((Function0) r120, r18, r210, r70, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new ModalBottomSheetKt$ModalBottomSheet$4(r32, r212, r7, r210, r70, r39, r310, r21, r12, r14, r11, r511, r18, r510, r59, r56, r63), r2, 54), r2, ((((r3 >> 18) & 112) | 24576) | (r211 & 896)) | (Animatable.$stable << 9));
        if (r7.getHasExpandedState() == false) goto L320;
        r2.startReplaceGroup(748459762);
        if (r112 <= 256) goto L311;
        if (r2.changed(r7) == false) goto L311;
    L312:
        boolean r74 = true;
    L314:
        Object r75 = r2.rememberedValue();
        if (r74 == false) goto L317;
    L318:
        r75 = new ModalBottomSheetKt$ModalBottomSheet$5$1(r7, null);
        r2.updateRememberedValue(r75);
    L319:
        EffectsKt.LaunchedEffect(r7, (Function2) r75, r2, (r3 >> 6) & 14);
        r2.endReplaceGroup();
    L322:
        if (ComposerKt.isTraceInProgress() == false) goto L324;
        ComposerKt.traceEventEnd();
    L324:
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> r121 = r56;
        final Function2<? super Composer, ? super Integer, Unit> r122 = r59;
        final float r123 = r510;
        final long r76 = r511;
        final long r124 = r32;
        final SheetState r77 = r7;
        final boolean r78 = r14;
        final long r79 = r18;
        final ModalBottomSheetProperties r125 = r210;
        final Shape r80 = r11;
        final float r81 = r12;
    L326:
        ScopeUpdateScope r82 = r2.endRestartGroup();
        if (r82 == null) goto L330;
        final Modifier r83 = r21;
        r82.updateScope(new ne(r47, r83, r77, r81, r78, r80, r76, r79, r123, r124, r122, r121, r125, r63, r65, r66, r67));
        return;
    L330:
        return;
    L317:
        if (r75 != r38.getEmpty()) goto L319;
    L311:
        if ((r3 & 384) == 256) goto L312;
        r74 = false;
        goto L314
    L320:
        r2.startReplaceGroup(748521266);
        r2.endReplaceGroup();
        goto L322
    L302:
        if (r120 != r38.getEmpty()) goto L304;
    L298:
        r119 = false;
    L292:
        if ((r3 & 384) == 256) goto L293;
        r71 = false;
        goto L295
    L281:
        if (r68 != r38.getEmpty()) goto L283;
    L277:
        r45 = false;
    L271:
        if ((r3 & 384) == 256) goto L272;
        r43 = false;
        goto L274
    L262:
        if (r117 == r38.getEmpty()) goto L265;
        r42 = r47;
        goto L266
    L258:
        r40 = false;
    L252:
        if ((r3 & 384) == 256) goto L253;
        r114 = false;
        goto L255
    L242:
        if (r113 != Composer.Companion.getEmpty()) goto L244;
    L238:
        r35 = false;
        goto L239
    L232:
        if (r2.changed(r7) == false) goto L235;
        r510 = r15;
        goto L237
    L224:
        int r512 = r1;
        r30 = r28;
        r31 = r512;
        r210 = r62;
        goto L225
    L221:
        r29 = r61;
        goto L222
    L217:
        r28 = r60;
        goto L219
    L214:
        r27 = r58;
        goto L215
    L210:
        r15 = r57;
        goto L212
    L207:
        r18 = r55;
        goto L208
    L203:
        r8 = r53;
        goto L205
    L196:
        r14 = r51;
        goto L198
    L193:
        r12 = r50;
        goto L194
    L190:
        r7 = r10;
        goto L191
    L186:
        r21 = r9;
        goto L188
    L163:
        if (r2.getDefaultsInvalid() == true) goto L184;
        r2.skipToGroupEnd();
        if ((r67 & 4) == 0) goto L169;
        r3 = r3 & (-897);
    L169:
        if ((r67 & 32) == 0) goto L172;
        r3 = r3 & (-458753);
    L172:
        if ((r67 & 64) == 0) goto L175;
        r3 = r3 & (-3670017);
    L175:
        if ((r67 & 128) == 0) goto L178;
        r3 = r3 & (-29360129);
    L178:
        if ((r67 & 512) == 0) goto L181;
        r3 = r3 & (-1879048193);
    L181:
        if ((r67 & 2048) == 0) goto L183;
        r1 = r1 & (-113);
    L183:
        r12 = r50;
        r18 = r55;
        r15 = r57;
        r29 = r61;
        r210 = r62;
        r31 = r1;
        r3 = r3;
        r21 = r9;
        r7 = r10;
        r14 = r51;
        r8 = r53;
        r32 = r58;
        r30 = r60;
        goto L226
    L325:
        r2.skipToGroupEnd();
        r81 = r50;
        r78 = r51;
        r76 = r53;
        r124 = r58;
        r122 = r60;
        r121 = r61;
        r125 = r62;
        r21 = r9;
        r77 = r10;
        r80 = r11;
        r79 = r55;
        r123 = r57;
        goto L326
    L154:
        if ((r1 & 1171) != 1170) goto L157;
        r5 = false;
        goto L159
    L145:
        if ((r66 & 3072) != 0) goto L152;
        if (r2.changedInstance(r63) == false) goto L149;
        r17 = 2048;
    L149:
        r1 = r1 | r17;
        goto L152
    L134:
        if ((r66 & 384) != 0) goto L142;
        if (r2.changed(r62) == false) goto L138;
        int r213 = 256;
    L139:
        r1 = r1 | r213;
        goto L142
    L138:
        r213 = 128;
        goto L139
    L112:
        if ((r66 & 6) == 0) goto L114;
        r26 = r66;
        goto L120
    L114:
        if (r2.changedInstance(r60) == false) goto L116;
        int r214 = 4;
    L117:
        r26 = r66 | r214;
        goto L120
    L116:
        r214 = 2;
        goto L117
    L91:
        if ((r65 & 100663296) != 0) goto L98;
        if (r2.changed(r57) == false) goto L95;
        int r84 = 67108864;
    L96:
        r3 = r3 | r84;
        goto L98
    L95:
        r84 = 33554432;
        goto L96
    L62:
        if (r2.changed(r11) == false) goto L64;
        r22 = 131072;
        goto L65
    L66:
        r11 = r52;
        goto L68
    L50:
        if ((r65 & 24576) != 0) goto L58;
        if (r2.changed(r51) == false) goto L54;
        int r215 = 16384;
    L55:
        r3 = r3 | r215;
        goto L58
    L54:
        r215 = 8192;
        goto L55
    L39:
        if ((r65 & 3072) != 0) goto L46;
        if (r2.changed(r50) == false) goto L43;
        int r126 = 2048;
    L44:
        r3 = r3 | r126;
        goto L46
    L43:
        r126 = 1024;
        goto L44
    L27:
        if ((r67 & 4) != 0) goto L31;
        r10 = r49;
        if (r2.changed(r10) == false) goto L32;
        int r127 = 256;
    L33:
        r3 = r3 | r127;
    L32:
        r127 = 128;
        goto L33
    L31:
        r10 = r49;
        goto L32
    L17:
        if ((r65 & 48) != 0) goto L23;
        r9 = r48;
        if (r2.changed(r9) == false) goto L21;
        int r128 = 32;
    L22:
        r3 = r3 | r128;
        goto L25
    L21:
        r128 = 16;
        goto L22
    L6:
        if ((r65 & 6) == 0) goto L8;
        r3 = r65;
        goto L13
    L8:
        if (r2.changedInstance(r47) == false) goto L10;
        int r85 = 4;
    L11:
        r3 = r85 | r65;
        goto L13
    L10:
        r85 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalBottomSheetContent-7---e2Q, reason: not valid java name */
    public static final void m2871ModalBottomSheetContent7e2Q(final BoxScope r47, final Animatable<Float, AnimationVector1D> r48, final CoroutineScope r49, final Function0<Unit> r50, final Function1<? super Float, Unit> r51, Modifier r52, SheetState r53, float r54, boolean r55, Shape r56, long r57, long r59, float r61, Function2<? super Composer, ? super Integer, Unit> r62, Function2<? super Composer, ? super Integer, ? extends WindowInsets> r63, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r64, Composer r65, final int r66, final int r67, final int r68) {
        Composer r0 = r65.startRestartGroup(-37400432);
        if ((Integer.MIN_VALUE & r68) == 0) goto L6;
        int r3 = r66 | 6;
    L14:
        if ((r68 & 1) == 0) goto L17;
        r3 = r3 | 48;
    L27:
        if ((r68 & 2) == 0) goto L30;
        r3 = r3 | 384;
    L37:
        int r16 = 2048;
        if ((r68 & 4) == 0) goto L41;
        r3 = r3 | 3072;
    L48:
        int r19 = 8192;
        if ((r68 & 8) == 0) goto L52;
        r3 = r3 | 24576;
    L58:
        int r8 = r68 & 16;
        if (r8 == 0) goto L62;
        r3 = r3 | 196608;
    L69:
        if ((r66 & 1572864) != 0) goto L78;
        if ((r68 & 32) == 0) goto L73;
    L75:
        int r25 = 524288;
    L76:
        r3 = r3 | r25;
        goto L78
    L73:
        if (r0.changed(r53) == false) goto L75;
        r25 = 1048576;
    L78:
        int r26 = r68 & 64;
        if (r26 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r6 = r68 & 128;
        if (r6 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r66 & 805306368) != 0) goto L110;
        if ((r68 & 256) != 0) goto L106;
        if (r0.changed(r56) == false) goto L106;
        int r29 = 536870912;
    L107:
        r3 = r3 | r29;
    L106:
        r29 = 268435456;
    L110:
        if ((r67 & 6) == 0) goto L112;
        int r4 = r67;
    L120:
        if ((r67 & 48) != 0) goto L129;
        if ((r68 & 1024) == 0) goto L124;
    L126:
        int r18 = 16;
    L127:
        r4 = r4 | r18;
        goto L129
    L124:
        if (r0.changed(r59) == false) goto L126;
        r18 = 32;
    L129:
        int r7 = r68 & 2048;
        if (r7 == 0) goto L133;
        r4 = r4 | 384;
    L140:
        int r10 = r68 & 4096;
        if (r10 == 0) goto L144;
        r4 = r4 | 3072;
    L152:
        if ((r67 & 24576) != 0) goto L162;
        if ((r68 & 8192) != 0) goto L159;
        if (r0.changedInstance(r63) == false) goto L159;
        r19 = 16384;
    L159:
        r4 = r4 | r19;
    L162:
        if ((r68 & 16384) == 0) goto L165;
        r4 = r4 | 196608;
    L173:
        if ((r3 & 306783379) == 306783378) goto L175;
    L178:
        boolean r9 = true;
    L180:
        if (r0.shouldExecute(r9, r3 & 1) == false) goto L318;
        r0.startDefaults();
        if ((r66 & 1) != 0) goto L184;
    L202:
        if (r8 == 0) goto L204;
        Modifier r11 = Modifier.Companion;
    L206:
        if ((r68 & 32) == 0) goto L208;
        final SheetState r12 = rememberModalBottomSheetState(false, null, r0, 0, 3);
        r3 = r3 & (-3670017);
    L209:
        if (r26 == 0) goto L211;
        float r13 = BottomSheetDefaults.INSTANCE.m2335getSheetMaxWidthD9Ej5fM();
    L212:
        if (r6 == 0) goto L214;
        boolean r14 = true;
    L216:
        if ((r68 & 256) == 0) goto L218;
        Shape r15 = BottomSheetDefaults.INSTANCE.getExpandedShape(r0, 6);
        r3 = r3 & (-1879048193);
    L220:
        if ((r68 & 512) == 0) goto L222;
        long r110 = BottomSheetDefaults.INSTANCE.getContainerColor(r0, 6);
        int r17 = r4 & (-15);
        long r5 = r110;
    L223:
        Modifier r111 = r11;
        if ((r68 & 1024) == 0) goto L226;
        long r20 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r0, r17 & 14);
        r17 = r17 & (-113);
    L227:
        if (r7 == 0) goto L229;
        float r21 = BottomSheetDefaults.INSTANCE.m2333getElevationD9Ej5fM();
    L230:
        if (r10 == 0) goto L232;
        Function2<? super Composer, ? super Integer, Unit> r22 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1716959002$material3();
    L234:
        if ((r68 & 8192) == 0) goto L236;
        int r112 = r17 & (-57345);
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> r31 = ModalBottomSheetKt$ModalBottomSheetContent$1.INSTANCE;
    L237:
        float r23 = r21;
        long r24 = r5;
        Modifier r27 = r111;
        boolean r28 = r14;
    L238:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventStart(-37400432, r3, r112, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:272)");
    L242:
        final String r30 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911717), r0, 0);
        Modifier r69 = r27;
        long r32 = r24;
        Modifier r1 = SizeKt.fillMaxWidth$default(SizeKt.m1021widthInVpY3zN4$default(r47.align(r27, Alignment.Companion.getTopCenter()), MenuKt.ClosedAlphaTarget, r13, 1, null), MenuKt.ClosedAlphaTarget, 1, null);
        if (r28 == false) goto L258;
        r0.startReplaceGroup(-1582035383);
        Modifier.Companion r33 = Modifier.Companion;
        if (((3670016 & r3) ^ 1572864) <= 1048576) goto L249;
        if (r0.changed(r12) == false) goto L249;
    L250:
        boolean r34 = true;
    L252:
        Object r35 = r0.rememberedValue();
        if (r34 == false) goto L255;
    L256:
        r35 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r12, Orientation.Vertical, r51);
        r0.updateRememberedValue(r35);
    L257:
        Modifier r36 = NestedScrollModifierKt.nestedScroll$default(r33, (NestedScrollConnection) r35, null, 2, null);
        r0.endReplaceGroup();
    L259:
        Modifier r2 = r1.then(r36);
        AnchoredDraggableState<SheetValue> r37 = r12.getAnchoredDraggableState$material3();
        Orientation r38 = Orientation.Vertical;
        int r39 = (3670016 & r3) ^ 1572864;
        if (r39 > 1048576) goto L262;
    L265:
        float r610 = r13;
        if ((r3 & 1572864) != 1048576) goto L268;
    L267:
        boolean r113 = true;
    L269:
        Object r114 = r0.rememberedValue();
        if (r113 == false) goto L272;
    L273:
        r114 = new qe(r12);
        r0.updateRememberedValue(r114);
    L274:
        Modifier r310 = AnchoredDraggableKt.draggableAnchors(r2, r37, r38, (Function2) r114);
        DraggableState r311 = r12.getAnchoredDraggableState$material3().getDraggableState$material3();
        if (r28 == true) goto L277;
    L279:
        boolean r312 = false;
    L280:
        boolean r313 = r12.getAnchoredDraggableState$material3().isAnimationRunning();
        if ((57344 & r3) != 16384) goto L283;
        boolean r40 = true;
    L284:
        Object r41 = r0.rememberedValue();
        if (r40 == false) goto L287;
    L288:
        r41 = new ModalBottomSheetKt$ModalBottomSheetContent$4$1(r51, null);
        r0.updateRememberedValue(r41);
    L289:
        Modifier r42 = DraggableKt.draggable$default(r310, r311, r38, r312, null, r313, null, (Function3) r41, false, 168, null);
        boolean r43 = r0.changed(r30);
        Object r44 = r0.rememberedValue();
        if (r43 == false) goto L292;
    L293:
        r44 = new re(r30);
        r0.updateRememberedValue(r44);
    L294:
        boolean r115 = false;
        Modifier r45 = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(r42, false, (Function1) r44, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) r12.getOffset$material3(), 0), 0, 0, 13, null));
        if (r39 <= 1048576) goto L299;
        if (r0.changed(r12) == false) goto L299;
    L300:
        boolean r46 = true;
    L303:
        if ((r3 & 112) != 32) goto L305;
    L308:
        r115 = true;
    L309:
        boolean r58 = r46 | r115;
        Object r60 = r0.rememberedValue();
        if (r58 == false) goto L312;
    L313:
        r60 = new ae(r12, r48);
        r0.updateRememberedValue(r60);
    L314:
        int r70 = r112 << 6;
        Shape r116 = r15;
        long r210 = r20;
        float r211 = r23;
        SurfaceKt.m3213SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(r45, (Function1) r60), r12), r116, r32, r210, r211, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(728743275, true, new ModalBottomSheetKt$ModalBottomSheetContent$7(r31, r48, r12, r22, r64, r50, r49, r28), r0, 54), r0, (((((r3 >> 24) & 112) | 12582912) | (r70 & 896)) | (r70 & 7168)) | (r70 & 57344), 96);
        if (ComposerKt.isTraceInProgress() == false) goto L317;
        ComposerKt.traceEventEnd();
    L317:
        final float r117 = r23;
        final Modifier r71 = r69;
        final float r72 = r610;
        final SheetState r73 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r118 = r22;
        final Shape r119 = r15;
        final long r120 = r20;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> r121 = r31;
        final long r122 = r32;
        final boolean r74 = r28;
    L319:
        ScopeUpdateScope r75 = r0.endRestartGroup();
        if (r75 == null) goto L323;
        r75.updateScope(new be(r47, r48, r49, r50, r51, r71, r73, r72, r74, r119, r122, r120, r117, r118, r121, r64, r66, r67, r68));
        return;
    L323:
        return;
    L312:
        if (r60 != Composer.Companion.getEmpty()) goto L314;
    L305:
        if ((r3 & 64) == 0) goto L309;
        if (r0.changedInstance(r48) == false) goto L309;
    L299:
        if ((r3 & 1572864) == 1048576) goto L300;
        r46 = false;
        goto L303
    L292:
        if (r44 != Composer.Companion.getEmpty()) goto L294;
    L287:
        if (r41 != Composer.Companion.getEmpty()) goto L289;
    L283:
        r40 = false;
        goto L284
    L277:
        if (r12.isVisible() == false) goto L279;
        r312 = true;
        goto L280
    L272:
        if (r114 != Composer.Companion.getEmpty()) goto L274;
    L268:
        r113 = false;
        goto L269
    L262:
        if (r0.changed(r12) == false) goto L265;
        r610 = r13;
        goto L267
    L255:
        if (r35 != Composer.Companion.getEmpty()) goto L257;
    L249:
        if ((r3 & 1572864) == 1048576) goto L250;
        r34 = false;
        goto L252
    L258:
        r0.startReplaceGroup(-1582020872);
        r0.endReplaceGroup();
        r36 = Modifier.Companion;
        goto L259
    L236:
        r31 = r63;
        r112 = r17;
        goto L237
    L232:
        r22 = r62;
        goto L234
    L229:
        r21 = r61;
        goto L230
    L226:
        r20 = r59;
        goto L227
    L222:
        r17 = r4;
        r5 = r57;
        goto L223
    L218:
        r15 = r56;
        goto L220
    L214:
        r14 = r55;
        goto L216
    L211:
        r13 = r54;
        goto L212
    L208:
        r12 = r53;
        goto L209
    L204:
        r11 = r52;
        goto L206
    L184:
        if (r0.getDefaultsInvalid() == true) goto L202;
        r0.skipToGroupEnd();
        if ((r68 & 32) == 0) goto L190;
        r3 = r3 & (-3670017);
    L190:
        if ((r68 & 256) == 0) goto L193;
        r3 = r3 & (-1879048193);
    L193:
        if ((r68 & 512) == 0) goto L196;
        r4 = r4 & (-15);
    L196:
        if ((r68 & 1024) == 0) goto L199;
        r4 = r4 & (-113);
    L199:
        if ((r68 & 8192) == 0) goto L201;
        r4 = r4 & (-57345);
    L201:
        r12 = r53;
        r13 = r54;
        r15 = r56;
        r24 = r57;
        r20 = r59;
        r23 = r61;
        r22 = r62;
        r31 = r63;
        r3 = r3;
        r112 = r4;
        r27 = r52;
        r28 = r55;
        goto L238
    L318:
        r0.skipToGroupEnd();
        r71 = r52;
        r73 = r53;
        r72 = r54;
        r74 = r55;
        r119 = r56;
        r122 = r57;
        r120 = r59;
        r117 = r61;
        r118 = r62;
        r121 = r63;
        goto L319
    L175:
        if ((74899 & r4) != 74898) goto L178;
        r9 = false;
        goto L180
    L165:
        if ((r67 & 196608) != 0) goto L173;
        if (r0.changedInstance(r64) == false) goto L169;
        int r123 = 131072;
    L170:
        r4 = r4 | r123;
        goto L173
    L169:
        r123 = 65536;
        goto L170
    L144:
        if ((r67 & 3072) != 0) goto L152;
        if (r0.changedInstance(r62) == true) goto L149;
        r16 = 1024;
    L149:
        r4 = r4 | r16;
        goto L152
    L133:
        if ((r67 & 384) != 0) goto L140;
        if (r0.changed(r61) == false) goto L137;
        int r124 = 256;
    L138:
        r4 = r4 | r124;
        goto L140
    L137:
        r124 = 128;
        goto L138
    L112:
        if ((r68 & 512) == 0) goto L114;
    L116:
        int r76 = 2;
    L117:
        r4 = r76 | r67;
        goto L120
    L114:
        if (r0.changed(r57) == false) goto L116;
        r76 = 4;
        goto L117
    L92:
        if ((r66 & 100663296) != 0) goto L99;
        if (r0.changed(r55) == false) goto L96;
        int r212 = 67108864;
    L97:
        r3 = r3 | r212;
        goto L99
    L96:
        r212 = 33554432;
        goto L97
    L82:
        if ((r66 & 12582912) != 0) goto L88;
        if (r0.changed(r54) == false) goto L86;
        int r213 = 8388608;
    L87:
        r3 = r3 | r213;
        goto L88
    L86:
        r213 = 4194304;
        goto L87
    L62:
        if ((r66 & 196608) != 0) goto L69;
        if (r0.changed(r52) == false) goto L66;
        int r214 = 131072;
    L67:
        r3 = r3 | r214;
        goto L69
    L66:
        r214 = 65536;
        goto L67
    L52:
        if ((r66 & 24576) != 0) goto L58;
        if (r0.changedInstance(r51) == false) goto L56;
        int r77 = 16384;
    L57:
        r3 = r3 | r77;
        goto L58
    L56:
        r77 = 8192;
        goto L57
    L41:
        if ((r66 & 3072) != 0) goto L48;
        if (r0.changedInstance(r50) == false) goto L45;
        int r125 = 2048;
    L46:
        r3 = r3 | r125;
        goto L48
    L45:
        r125 = 1024;
        goto L46
    L30:
        if ((r66 & 384) != 0) goto L37;
        if (r0.changedInstance(r49) == false) goto L34;
        int r126 = 256;
    L35:
        r3 = r3 | r126;
        goto L37
    L34:
        r126 = 128;
        goto L35
    L17:
        if ((r66 & 48) != 0) goto L27;
        if ((r66 & 64) != 0) goto L21;
        boolean r78 = r0.changed(r48);
    L22:
        if (r78 == false) goto L24;
        int r79 = 32;
    L25:
        r3 = r3 | r79;
        goto L27
    L24:
        r79 = 16;
        goto L25
    L21:
        r78 = r0.changedInstance(r48);
        goto L22
    L6:
        if ((r66 & 6) == 0) goto L8;
        r3 = r66;
        goto L14
    L8:
        if (r0.changed(r47) == false) goto L10;
        int r80 = 4;
    L11:
        r3 = r80 | r66;
        goto L14
    L10:
        r80 = 2;
        goto L11
    }
}
