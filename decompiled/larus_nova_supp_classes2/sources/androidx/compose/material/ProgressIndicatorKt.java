package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001aA\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a;\u0010\u0014\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001aK\u0010\u001e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b \u0010!\u001aA\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\"\u0010#\u001a5\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001fH\u0007¢\u0006\u0004\b$\u0010%\u001a-\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u001fH\u0007¢\u0006\u0004\b&\u0010'\u001a3\u0010(\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101\u001a3\u00102\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u0010.\u001a;\u00104\u001a\u00020\u0003*\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b5\u00106\"\u0010\u00107\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u0010\u00109\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u0010\u0010:\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u000e\u0010;\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S²\u0006\n\u0010T\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010W\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020<X\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"increaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "LinearProgressIndicator", "", "progress", "", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "CircularProgressIndicator", "Landroidx/compose/ui/unit/Dp;", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "LinearIndicatorHeight", "F", "LinearIndicatorWidth", "CircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "FirstLineHeadEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "FirstLineTailEasing", "SecondLineHeadEasing", "SecondLineTailEasing", "RotationsPerCycle", "RotationDuration", "StartAngleOffset", "BaseRotationAngle", "JumpRotationAngle", "RotationAngleOffset", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "CircularEasing", "material", "firstLineHead", "firstLineTail", "secondLineHead", "secondLineTail", "currentRotation", "baseRotation", "endAngle"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing = null;
    private static final float CircularIndicatorDiameter = 0.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing = null;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing = null;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = 0.0f;
    private static final float LinearIndicatorWidth = 0.0f;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing = null;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing = null;
    private static final float StartAngleOffset = -90.0f;

    private static final Unit CircularProgressIndicator_DUhRLBM$lambda$28(float r12, Modifier r13, long r14, float r16, long r17, int r19, int r20, int r21, Composer r22, int r23) {
        m2120CircularProgressIndicatorDUhRLBM(r12, r13, r14, r16, r17, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_LxG7B9w$lambda$40(Modifier r11, long r12, float r14, long r15, int r17, int r18, int r19, Composer r20, int r21) {
        m2121CircularProgressIndicatorLxG7B9w(r11, r12, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_MBs18nI$lambda$41(float r9, Modifier r10, long r11, float r13, int r14, int r15, Composer r16, int r17) {
        m2122CircularProgressIndicatorMBs18nI(r9, r10, r11, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_aM_cp0Q$lambda$42(Modifier r7, long r8, float r10, int r11, int r12, Composer r13, int r14) {
        m2123CircularProgressIndicatoraMcp0Q(r7, r8, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$21(Modifier r10, long r11, long r13, int r15, int r16, int r17, Composer r18, int r19) {
        m2124LinearProgressIndicator2cYBFYY(r10, r11, r13, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_RIQooxk$lambda$23(Modifier r9, long r10, long r12, int r14, int r15, Composer r16, int r17) {
        m2125LinearProgressIndicatorRIQooxk(r9, r10, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator__5eSR_E$lambda$6(float r11, Modifier r12, long r13, long r15, int r17, int r18, int r19, Composer r20, int r21) {
        m2126LinearProgressIndicator_5eSRE(r11, r12, r13, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_eaDK9VM$lambda$22(float r10, Modifier r11, long r12, long r14, int r16, int r17, Composer r18, int r19) {
        m2127LinearProgressIndicatoreaDK9VM(r10, r11, r12, r14, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, Stroke r2, float r3, long r4, State r6, State r7, State r8, State r9, DrawScope r10) {
        return CircularProgressIndicator_LxG7B9w$lambda$39$lambda$38(r0, r2, r3, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(float r0, Modifier r1, long r2, long r4, int r6, int r7, Composer r8, int r9) {
        return LinearProgressIndicator_eaDK9VM$lambda$22(r0, r1, r2, r4, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(Modifier r0, long r1, long r3, int r5, int r6, Composer r7, int r8) {
        return LinearProgressIndicator_RIQooxk$lambda$23(r0, r1, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(KeyframesSpec.KeyframesSpecConfig r0) {
        return CircularProgressIndicator_LxG7B9w$lambda$36$lambda$35(r0);
    }

    public static /* synthetic */ Unit e(KeyframesSpec.KeyframesSpecConfig r0) {
        return LinearProgressIndicator_2cYBFYY$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit f(Modifier r0, long r1, float r3, int r4, int r5, Composer r6, int r7) {
        return CircularProgressIndicator_aM_cp0Q$lambda$42(r0, r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit g(KeyframesSpec.KeyframesSpecConfig r0) {
        return LinearProgressIndicator_2cYBFYY$lambda$14$lambda$13(r0);
    }

    public static /* synthetic */ Unit h(float r0, long r1, Stroke r3, long r4, DrawScope r6) {
        return CircularProgressIndicator_DUhRLBM$lambda$27$lambda$26(r0, r1, r3, r4, r6);
    }

    public static /* synthetic */ Unit i(float r0, Modifier r1, long r2, float r4, int r5, int r6, Composer r7, int r8) {
        return CircularProgressIndicator_MBs18nI$lambda$41(r0, r1, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit j(Modifier r0, long r1, long r3, int r5, int r6, int r7, Composer r8, int r9) {
        return LinearProgressIndicator_2cYBFYY$lambda$21(r0, r1, r3, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit k(KeyframesSpec.KeyframesSpecConfig r0) {
        return LinearProgressIndicator_2cYBFYY$lambda$11$lambda$10(r0);
    }

    public static /* synthetic */ Unit l(KeyframesSpec.KeyframesSpecConfig r0) {
        return LinearProgressIndicator_2cYBFYY$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit m(Placeable r0, int r1, Placeable.PlacementScope r2) {
        return increaseSemanticsBounds$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit n(KeyframesSpec.KeyframesSpecConfig r0) {
        return CircularProgressIndicator_LxG7B9w$lambda$33$lambda$32(r0);
    }

    public static /* synthetic */ Unit o(float r0, Modifier r1, long r2, long r4, int r6, int r7, int r8, Composer r9, int r10) {
        return LinearProgressIndicator__5eSR_E$lambda$6(r0, r1, r2, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit p(long r0, int r2, float r3, long r4, DrawScope r6) {
        return LinearProgressIndicator__5eSR_E$lambda$5$lambda$4(r0, r2, r3, r4, r6);
    }

    public static /* synthetic */ Unit q(Modifier r0, long r1, float r3, long r4, int r6, int r7, int r8, Composer r9, int r10) {
        return CircularProgressIndicator_LxG7B9w$lambda$40(r0, r1, r3, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ MeasureResult r(float r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return increaseSemanticsBounds$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit s(SemanticsPropertyReceiver r0) {
        return increaseSemanticsBounds$lambda$2(r0);
    }

    public static /* synthetic */ Unit t(float r0, Modifier r1, long r2, float r4, long r5, int r7, int r8, int r9, Composer r10, int r11) {
        return CircularProgressIndicator_DUhRLBM$lambda$28(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit u(long r0, int r2, long r3, State r5, State r6, State r7, State r8, DrawScope r9) {
        return LinearProgressIndicator_2cYBFYY$lambda$20$lambda$19(r0, r2, r3, r5, r6, r7, r8, r9);
    }

    static {
        LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m2119getStrokeWidthD9Ej5fM();
        LinearIndicatorWidth = Dp.constructor-impl(240);
        CircularIndicatorDiameter = Dp.constructor-impl(40);
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.2f, 1.0f);
    }

    private static final int CircularProgressIndicator_LxG7B9w$lambda$30(State<Integer> r0) {
        return ((Number) r0.getValue()).intValue();
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$31(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit CircularProgressIndicator_LxG7B9w$lambda$33$lambda$32(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(RotationDuration);
        r2.using(r2.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), 0), CircularEasing);
        r2.at(Float.valueOf(JumpRotationAngle), 666);
        return Unit.INSTANCE;
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$34(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit CircularProgressIndicator_LxG7B9w$lambda$36$lambda$35(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(RotationDuration);
        r2.using(r2.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), 666), CircularEasing);
        r2.at(Float.valueOf(JumpRotationAngle), r2.getDurationMillis());
        return Unit.INSTANCE;
    }

    private static final float CircularProgressIndicator_LxG7B9w$lambda$37(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$11$lambda$10(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), FirstLineTailDelay), FirstLineTailEasing);
        r2.at(Float.valueOf(1.0f), 1183);
        return Unit.INSTANCE;
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$12(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$14$lambda$13(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), 1000), SecondLineHeadEasing);
        r2.at(Float.valueOf(1.0f), 1567);
        return Unit.INSTANCE;
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$15(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$17$lambda$16(KeyframesSpec.KeyframesSpecConfig r3) {
        r3.setDurationMillis(LinearAnimationDuration);
        r3.using(r3.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), SecondLineTailDelay), SecondLineTailEasing);
        r3.at(Float.valueOf(1.0f), LinearAnimationDuration);
        return Unit.INSTANCE;
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$18(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$8$lambda$7(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget), 0), FirstLineHeadEasing);
        r2.at(Float.valueOf(1.0f), FirstLineHeadDuration);
        return Unit.INSTANCE;
    }

    private static final float LinearProgressIndicator_2cYBFYY$lambda$9(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public static final Modifier increaseSemanticsBounds(Modifier r4) {
        final float r0 = Dp.constructor-impl(10);
        return PaddingKt.m962paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(r4, new o8(r0)), true, new p8()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r0, 1, null);
    }

    private static final Unit increaseSemanticsBounds$lambda$2(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawCircularIndicatorBackground-bw27NRU, reason: not valid java name */
    private static final void m2129drawCircularIndicatorBackgroundbw27NRU(DrawScope r6, long r7, Stroke r9) {
        m2128drawCircularIndicator42QJj7c(r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 360.0f, r7, r9);
    }

    private static final Unit increaseSemanticsBounds$lambda$1$lambda$0(Placeable r7, int r8, Placeable.PlacementScope r9) {
        Placeable.PlacementScope.place$default(r9, r7, 0, -r8, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawLinearIndicatorBackground-AZGd3zU, reason: not valid java name */
    private static final void m2133drawLinearIndicatorBackgroundAZGd3zU(DrawScope r7, long r8, float r10, int r11) {
        m2132drawLinearIndicatorqYKTg0g(r7, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, r8, r10, r11);
    }

    private static final MeasureResult increaseSemanticsBounds$lambda$1(float r8, MeasureScope r9, Measurable r10, Constraints r11) {
        final int r12 = r9.roundToPx-0680j_4(r8);
        long r0 = r11.unbox-impl();
        int r13 = r12 * 2;
        final Placeable r14 = r10.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r0, 0, r13));
        int r3 = r14.getHeight() - r13;
        return MeasureScope.-CC.layout$default(r9, r14.getWidth(), r3, null, new a8(r14, r12), 4, null);
    }

    private static final Unit CircularProgressIndicator_DUhRLBM$lambda$27$lambda$26(float r6, long r7, Stroke r9, long r10, DrawScope r12) {
        m2129drawCircularIndicatorBackgroundbw27NRU(r12, r7, r9);
        m2130drawDeterminateCircularIndicator42QJj7c(r12, 270.0f, r6 * 360.0f, r10, r9);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator__5eSR_E$lambda$5$lambda$4(long r9, int r11, float r12, long r13, DrawScope r15) {
        float r7 = Float.intBitsToFloat((int) (r15.getSize-NH-jbRc() & 4294967295L));
        m2133drawLinearIndicatorBackgroundAZGd3zU(r15, r9, r7, r11);
        m2132drawLinearIndicatorqYKTg0g(r15, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r12, r13, r7, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m2128drawCircularIndicator42QJj7c(DrawScope r21, float r22, float r23, long r24, Stroke r26) {
        float r1 = 2;
        float r0 = r26.getWidth() / r1;
        float r2 = Float.intBitsToFloat((int) (r21.getSize-NH-jbRc() >> 32)) - (r1 * r0);
        long r5 = Float.floatToRawIntBits(r0);
        DrawScope.-CC.drawArc-yD3GUKo$default(r21, r24, r22, r23, false, Offset.constructor-impl((((long) Float.floatToRawIntBits(r0)) & 4294967295L) | (r5 << 32)), Size.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (((long) Float.floatToRawIntBits(r2)) & 4294967295L)), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r26, null, 0, 832, null);
    }

    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m2130drawDeterminateCircularIndicator42QJj7c(DrawScope r0, float r1, float r2, long r3, Stroke r5) {
        m2128drawCircularIndicator42QJj7c(r0, r1, r2, r3, r5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m2123CircularProgressIndicatoraMcp0Q(Modifier r19, long r20, float r22, Composer r23, final int r24, final int r25) {
        Composer r1 = r23.startRestartGroup(-392089979);
        int r2 = r25 & 1;
        if (r2 == 0) goto L6;
        int r4 = r24 | 6;
        Modifier r3 = r19;
    L14:
        if ((r24 & 48) == 0) goto L16;
        long r6 = r20;
    L24:
        int r8 = r25 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        float r9 = r22;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L67;
        r1.startDefaults();
        if ((r24 & 1) != 0) goto L44;
    L52:
        if (r2 == 0) goto L54;
        Modifier r5 = Modifier.Companion;
    L56:
        if ((r25 & 2) == 0) goto L58;
        r6 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r4 = r4 & (-113);
    L58:
        if (r8 != 0) goto L59;
    L50:
        float r16 = r9;
    L51:
        long r17 = r6;
        int r7 = r4;
        long r11 = r17;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(-392089979, r7, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:446)");
    L63:
        long r12 = Color.Companion.getTransparent-0d7_KjU();
        int r13 = StrokeCap.Companion.getSquare-KaPHkGw();
        int r14 = (((r7 & 14) | 3072) | (r7 & 112)) | (r7 & 896);
        m2121CircularProgressIndicatorLxG7B9w(r5, r11, r16, r12, r13, r1, r14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        r9 = r16;
    L68:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L72;
        final Modifier r18 = r5;
        final long r21 = r11;
        final float r26 = r9;
        r15.updateScope(new f8(r18, r21, r26, r24, r25));
        return;
    L72:
        return;
    L59:
        r16 = ProgressIndicatorDefaults.INSTANCE.m2119getStrokeWidthD9Ej5fM();
        goto L51
    L54:
        r5 = r3;
        goto L56
    L44:
        if (r1.getDefaultsInvalid() == true) goto L52;
        r1.skipToGroupEnd();
        if ((r25 & 2) == 0) goto L49;
        r4 = r4 & (-113);
    L49:
        r5 = r3;
        goto L50
    L67:
        r1.skipToGroupEnd();
        r5 = r3;
        r11 = r6;
        goto L68
    L38:
        r10 = false;
        goto L40
    L28:
        if ((r24 & 384) != 0) goto L34;
        r9 = r22;
        if (r1.changed(r9) == false) goto L32;
        int r110 = 256;
    L33:
        r4 = r4 | r110;
        goto L36
    L32:
        r110 = 128;
        goto L33
    L16:
        if ((r25 & 2) != 0) goto L20;
        r6 = r20;
        if (r1.changed(r6) == false) goto L21;
        int r27 = 32;
    L22:
        r4 = r4 | r27;
    L21:
        r27 = 16;
        goto L22
    L20:
        r6 = r20;
        goto L21
    L6:
        if ((r24 & 6) != 0) goto L12;
        r3 = r19;
        if (r1.changed(r3) == false) goto L10;
        int r28 = 4;
    L11:
        r4 = r28 | r24;
        goto L14
    L10:
        r28 = 2;
        goto L11
    L12:
        r3 = r19;
        r4 = r24;
        goto L14
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m2125LinearProgressIndicatorRIQooxk(Modifier r18, long r19, long r21, Composer r23, final int r24, final int r25) {
        Composer r1 = r23.startRestartGroup(-819397058);
        int r2 = r25 & 1;
        if (r2 == 0) goto L6;
        int r4 = r24 | 6;
        Modifier r3 = r18;
    L14:
        if ((r24 & 48) != 0) goto L22;
        long r7 = r19;
        if ((r25 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L24:
        if ((r24 & 384) != 0) goto L32;
        long r9 = r21;
        if ((r25 & 4) == 0) goto L28;
    L30:
        int r6 = 128;
    L31:
        r4 = r4 | r6;
    L34:
        if ((r4 & 147) == 146) goto L36;
        boolean r8 = true;
    L38:
        if (r1.shouldExecute(r8, r4 & 1) == false) goto L67;
        r1.startDefaults();
        if ((r24 & 1) != 0) goto L42;
    L51:
        if (r2 == 0) goto L53;
        Modifier r10 = Modifier.Companion;
    L55:
        if ((r25 & 2) == 0) goto L58;
        r7 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r4 = r4 & (-113);
    L58:
        if ((r25 & 4) == 0) goto L60;
        r9 = Color.copy-wmQWz5c$default(r7, 0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r4 = r4 & (-897);
    L60:
        int r11 = r4;
        long r12 = r7;
        long r16 = r9;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(-819397058, r11, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:233)");
    L63:
        int r13 = StrokeCap.Companion.getButt-KaPHkGw();
        int r14 = ((r11 & 14) | (r11 & 112)) | (r11 & 896);
        m2124LinearProgressIndicator2cYBFYY(r10, r12, r16, r13, r1, r14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        r9 = r16;
    L68:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L72;
        final Modifier r17 = r10;
        final long r20 = r12;
        final long r22 = r9;
        r15.updateScope(new d8(r17, r20, r22, r24, r25));
        return;
    L72:
        return;
    L53:
        r10 = r3;
        goto L55
    L42:
        if (r1.getDefaultsInvalid() == true) goto L51;
        r1.skipToGroupEnd();
        if ((r25 & 2) == 0) goto L48;
        r4 = r4 & (-113);
    L48:
        if ((r25 & 4) == 0) goto L50;
        r4 = r4 & (-897);
    L50:
        r10 = r3;
        goto L60
    L67:
        r1.skipToGroupEnd();
        r10 = r3;
        r12 = r7;
        goto L68
    L36:
        r8 = false;
        goto L38
    L28:
        if (r1.changed(r9) == false) goto L30;
        r6 = 256;
        goto L31
    L32:
        r9 = r21;
        goto L34
    L18:
        if (r1.changed(r7) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r7 = r19;
        goto L24
    L6:
        if ((r24 & 6) != 0) goto L12;
        r3 = r18;
        if (r1.changed(r3) == false) goto L10;
        int r26 = 4;
    L11:
        r4 = r26 | r24;
        goto L14
    L10:
        r26 = 2;
        goto L11
    L12:
        r3 = r18;
        r4 = r24;
        goto L14
    }

    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    private static final void m2131drawIndeterminateCircularIndicatorhrjfTZI(DrawScope r6, float r7, float r8, float r9, long r10, Stroke r12) {
        if (StrokeCap.equals-impl0(r12.getCap-KaPHkGw(), StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
        float r11 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        m2128drawCircularIndicator42QJj7c(r6, r7 + r11, Math.max(r9, 0.1f), r10, r12);
        return;
    L5:
        r11 = ((r8 / Dp.constructor-impl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f;
        goto L6
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    private static final void m2132drawLinearIndicatorqYKTg0g(DrawScope r25, float r26, float r27, long r28, float r30, int r31) {
        float r0 = Float.intBitsToFloat((int) (r25.getSize-NH-jbRc() >> 32));
        float r1 = Float.intBitsToFloat((int) (r25.getSize-NH-jbRc() & 4294967295L));
        float r3 = 2;
        float r4 = r1 / r3;
        if (r25.getLayoutDirection() != LayoutDirection.Ltr) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        float r9 = r26;
    L10:
        float r10 = r9 * r0;
        if (r7 == false) goto L13;
        float r8 = r27;
    L14:
        float r11 = r8 * r0;
        if (StrokeCap.equals-impl0(r31, StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L17;
    L22:
        DrawScope.-CC.drawLine-NGM6Ib0$default(r25, r28, Offset.constructor-impl((Float.floatToRawIntBits(r10) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), Offset.constructor-impl((Float.floatToRawIntBits(r11) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), r30, 0, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 496, null);
        return;
    L17:
        if (r1 > r0) goto L22;
        float r2 = r30 / r3;
        ClosedFloatingPointRange r5 = RangesKt.rangeTo(r2, r0 - r2);
        float r6 = ((Number) RangesKt.coerceIn(Float.valueOf(r10), r5)).floatValue();
        float r12 = ((Number) RangesKt.coerceIn(Float.valueOf(r11), r5)).floatValue();
        if (Math.abs(r27 - r26) <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L24;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r25, r28, Offset.constructor-impl((Float.floatToRawIntBits(r6) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), Offset.constructor-impl((Float.floatToRawIntBits(r12) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), r30, r31, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        return;
    L24:
        return;
    L13:
        r8 = 1.0f - r26;
        goto L14
    L9:
        r9 = 1.0f - r27;
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final /* synthetic */ void m2122CircularProgressIndicatorMBs18nI(final float r20, Modifier r21, long r22, float r24, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(-409649739);
        if ((r27 & 1) == 0) goto L6;
        int r3 = r26 | 6;
    L13:
        int r4 = r27 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L25:
        if ((r26 & 384) == 0) goto L27;
        long r7 = r22;
    L35:
        int r9 = r27 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        float r10 = r24;
    L47:
        if ((r3 & 1171) == 1170) goto L49;
        boolean r11 = true;
    L51:
        if (r1.shouldExecute(r11, r3 & 1) == false) goto L76;
        r1.startDefaults();
        if ((r26 & 1) != 0) goto L55;
    L62:
        if (r4 == 0) goto L64;
        Modifier r6 = Modifier.Companion;
    L66:
        if ((r27 & 4) == 0) goto L68;
        r7 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r3 = r3 & (-897);
    L68:
        if (r9 != 0) goto L69;
    L61:
        long r18 = r7;
        final float r8 = r10;
    L70:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventStart(-409649739, r3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:430)");
    L73:
        Modifier r12 = r6;
        long r13 = r18;
        float r14 = r8;
        m2120CircularProgressIndicatorDUhRLBM(r20, r12, r13, r14, Color.Companion.getTransparent-0d7_KjU(), StrokeCap.Companion.getButt-KaPHkGw(), r1, ((((r3 & 14) | 24576) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
    L77:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L81;
        final Modifier r2 = r6;
        final long r16 = r18;
        r15.updateScope(new w7(r20, r2, r16, r8, r26, r27));
        return;
    L81:
        return;
    L69:
        r8 = ProgressIndicatorDefaults.INSTANCE.m2119getStrokeWidthD9Ej5fM();
        r18 = r7;
        goto L70
    L64:
        r6 = r5;
        goto L66
    L55:
        if (r1.getDefaultsInvalid() == true) goto L62;
        r1.skipToGroupEnd();
        if ((r27 & 4) == 0) goto L60;
        r3 = r3 & (-897);
    L60:
        r6 = r5;
        goto L61
    L76:
        r1.skipToGroupEnd();
        r6 = r5;
        r18 = r7;
        r8 = r10;
        goto L77
    L49:
        r11 = false;
        goto L51
    L39:
        if ((r26 & 3072) != 0) goto L45;
        r10 = r24;
        if (r1.changed(r10) == false) goto L43;
        int r17 = 2048;
    L44:
        r3 = r3 | r17;
        goto L47
    L43:
        r17 = 1024;
        goto L44
    L27:
        if ((r27 & 4) != 0) goto L31;
        r7 = r22;
        if (r1.changed(r7) == false) goto L32;
        int r19 = 256;
    L33:
        r3 = r3 | r19;
    L32:
        r19 = 128;
        goto L33
    L31:
        r7 = r22;
        goto L32
    L17:
        if ((r26 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r23 = 32;
    L22:
        r3 = r3 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r26 & 6) == 0) goto L8;
        r3 = r26;
        goto L13
    L8:
        if (r1.changed(r20) == false) goto L10;
        int r28 = 4;
    L11:
        r3 = r28 | r26;
        goto L13
    L10:
        r28 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final void m2124LinearProgressIndicator2cYBFYY(Modifier r32, long r33, long r35, int r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(1501635280);
        int r2 = r40 & 1;
        if (r2 == 0) goto L6;
        int r4 = r39 | 6;
        Modifier r3 = r32;
    L14:
        if ((r39 & 48) != 0) goto L22;
        long r8 = r33;
        if ((r40 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L24:
        if ((r39 & 384) != 0) goto L32;
        long r10 = r35;
        if ((r40 & 4) == 0) goto L28;
    L30:
        int r6 = 128;
    L31:
        r4 = r4 | r6;
    L34:
        if ((r39 & 3072) == 0) goto L36;
        int r7 = r37;
    L45:
        if ((r4 & 1171) == 1170) goto L47;
        boolean r12 = true;
    L49:
        if (r1.shouldExecute(r12, r4 & 1) == false) goto L127;
        r1.startDefaults();
        if ((r39 & 1) != 0) goto L53;
    L65:
        if (r2 == 0) goto L67;
        Modifier r9 = Modifier.Companion;
    L69:
        if ((r40 & 2) == 0) goto L72;
        r8 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r4 = r4 & (-113);
    L72:
        if ((r40 & 4) == 0) goto L75;
        r10 = Color.copy-wmQWz5c$default(r8, 0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r4 = r4 & (-897);
    L75:
        if ((r40 & 8) == 0) goto L77;
        r4 = r4 & (-7169);
        r7 = StrokeCap.Companion.getButt-KaPHkGw();
    L77:
        long r13 = r10;
        int r11 = r4;
        final long r14 = r8;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventStart(1501635280, r11, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:144)");
    L80:
        InfiniteTransition r0 = InfiniteTransitionKt.rememberInfiniteTransition(null, r1, 0, 1);
        Object r15 = r1.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r15 != r17.getEmpty()) goto L83;
        r15 = new h8();
        r1.updateRememberedValue(r15);
    L83:
        InfiniteRepeatableSpec r16 = AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r15), null, 0, 6, null);
        int r18 = InfiniteTransition.$stable;
        int r21 = InfiniteRepeatableSpec.$stable;
        final State<Float> r19 = InfiniteTransitionKt.animateFloat(r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, r16, null, r1, (r18 | 432) | (r21 << 9), 8);
        Object r20 = r1.rememberedValue();
        if (r20 != r17.getEmpty()) goto L86;
        r20 = new j8();
        r1.updateRememberedValue(r20);
    L86:
        final State<Float> r110 = InfiniteTransitionKt.animateFloat(r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r20), null, 0, 6, null), null, r1, (r18 | 432) | (r21 << 9), 8);
        Object r22 = r1.rememberedValue();
        if (r22 != r17.getEmpty()) goto L89;
        r22 = new k8();
        r1.updateRememberedValue(r22);
    L89:
        final State<Float> r111 = InfiniteTransitionKt.animateFloat(r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r22), null, 0, 6, null), null, r1, (r18 | 432) | (r21 << 9), 8);
        Object r23 = r1.rememberedValue();
        if (r23 != r17.getEmpty()) goto L92;
        r23 = new l8();
        r1.updateRememberedValue(r23);
    L92:
        final State<Float> r24 = InfiniteTransitionKt.animateFloat(r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r23), null, 0, 6, null), null, r1, (r18 | 432) | (r21 << 9), 8);
        Modifier r25 = SizeKt.m1016sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(increaseSemanticsBounds(r9)), LinearIndicatorWidth, LinearIndicatorHeight);
        if (((r11 & 896) ^ 384) <= 256) goto L97;
        r10 = r13;
        if (r1.changed(r10) == false) goto L99;
    L100:
        boolean r112 = true;
    L103:
        if (((r11 & 7168) ^ 3072) <= 2048) goto L107;
        if (r1.changed(r7) == false) goto L107;
    L108:
        boolean r26 = true;
    L110:
        boolean r27 = ((r26 | r112) | r1.changed(r19)) | r1.changed(r110);
        if (((r11 & 112) ^ 48) <= 32) goto L115;
        if (r1.changed(r14) == false) goto L115;
    L116:
        boolean r113 = true;
    L118:
        boolean r28 = ((r27 | r113) | r1.changed(r111)) | r1.changed(r24);
        Object r29 = r1.rememberedValue();
        if (r28 == false) goto L121;
    L122:
        final long r114 = r10;
        final int r210 = r7;
        r29 = new m8(r114, r210, r14, r19, r110, r111, r24);
        r1.updateRememberedValue(r29);
    L123:
        CanvasKt.Canvas(r25, (Function1) r29, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        r8 = r14;
    L128:
        final int r30 = r7;
        final long r31 = r10;
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L132;
        final Modifier r34 = r9;
        final long r36 = r8;
        r115.updateScope(new n8(r34, r36, r31, r30, r39, r40));
        return;
    L132:
        return;
    L121:
        if (r29 != r17.getEmpty()) goto L123;
    L115:
        if ((r11 & 48) == 32) goto L116;
        r113 = false;
    L107:
        if ((r11 & 3072) == 2048) goto L108;
        r26 = false;
    L99:
        if ((r11 & 384) == 256) goto L100;
        r112 = false;
        goto L103
    L97:
        r10 = r13;
        goto L99
    L67:
        r9 = r3;
        goto L69
    L53:
        if (r1.getDefaultsInvalid() == true) goto L65;
        r1.skipToGroupEnd();
        if ((r40 & 2) == 0) goto L59;
        r4 = r4 & (-113);
    L59:
        if ((r40 & 4) == 0) goto L62;
        r4 = r4 & (-897);
    L62:
        if ((r40 & 8) == 0) goto L64;
        r4 = r4 & (-7169);
    L64:
        r9 = r3;
        goto L77
    L127:
        r1.skipToGroupEnd();
        r9 = r3;
        goto L128
    L47:
        r12 = false;
        goto L49
    L36:
        if ((r40 & 8) != 0) goto L40;
        r7 = r37;
        if (r1.changed(r7) == false) goto L41;
        int r116 = 2048;
    L42:
        r4 = r4 | r116;
    L41:
        r116 = 1024;
        goto L42
    L40:
        r7 = r37;
        goto L41
    L28:
        if (r1.changed(r10) == false) goto L30;
        r6 = 256;
        goto L31
    L32:
        r10 = r35;
        goto L34
    L18:
        if (r1.changed(r8) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r8 = r33;
        goto L24
    L6:
        if ((r39 & 6) != 0) goto L12;
        r3 = r32;
        if (r1.changed(r3) == false) goto L10;
        int r41 = 4;
    L11:
        r4 = r41 | r39;
        goto L14
    L10:
        r41 = 2;
        goto L11
    L12:
        r3 = r32;
        r4 = r39;
        goto L14
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m2127LinearProgressIndicatoreaDK9VM(final float r20, Modifier r21, long r22, long r24, Composer r26, final int r27, final int r28) {
        Composer r1 = r26.startRestartGroup(-850309746);
        if ((r28 & 1) == 0) goto L6;
        int r3 = r27 | 6;
    L13:
        int r4 = r28 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L25:
        if ((r27 & 384) != 0) goto L33;
        long r8 = r22;
        if ((r28 & 4) == 0) goto L29;
    L31:
        int r6 = 128;
    L32:
        r3 = r3 | r6;
    L35:
        if ((r27 & 3072) != 0) goto L43;
        long r10 = r24;
        if ((r28 & 8) == 0) goto L39;
    L41:
        int r7 = 1024;
    L42:
        r3 = r3 | r7;
    L45:
        if ((r3 & 1171) == 1170) goto L47;
        boolean r9 = true;
    L49:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L80;
        r1.startDefaults();
        if ((r27 & 1) != 0) goto L53;
    L62:
        if (r4 == 0) goto L64;
        Modifier r11 = Modifier.Companion;
    L66:
        if ((r28 & 4) == 0) goto L68;
        long r12 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r3 = r3 & (-897);
    L70:
        if ((r28 & 8) == 0) goto L72;
        r3 = r3 & (-7169);
        long r18 = Color.copy-wmQWz5c$default(r12, 0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L73:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(-850309746, r3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:225)");
    L76:
        Modifier r13 = r11;
        long r14 = r12;
        long r15 = r18;
        m2126LinearProgressIndicator_5eSRE(r20, r13, r14, r15, StrokeCap.Companion.getButt-KaPHkGw(), r1, (((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
    L79:
        r8 = r12;
        final long r16 = r18;
    L81:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L85;
        final Modifier r2 = r11;
        final long r19 = r8;
        r17.updateScope(new e8(r20, r2, r19, r16, r27, r28));
        return;
    L85:
        return;
    L72:
        r18 = r10;
        goto L73
    L68:
        r12 = r8;
        goto L70
    L64:
        r11 = r5;
        goto L66
    L53:
        if (r1.getDefaultsInvalid() == true) goto L62;
        r1.skipToGroupEnd();
        if ((r28 & 4) == 0) goto L59;
        r3 = r3 & (-897);
    L59:
        if ((r28 & 8) == 0) goto L61;
        r3 = r3 & (-7169);
    L61:
        r11 = r5;
        r12 = r8;
        goto L72
    L80:
        r1.skipToGroupEnd();
        r11 = r5;
        r16 = r10;
        goto L81
    L47:
        r9 = false;
        goto L49
    L39:
        if (r1.changed(r10) == false) goto L41;
        r7 = 2048;
        goto L42
    L43:
        r10 = r24;
        goto L45
    L29:
        if (r1.changed(r8) == false) goto L31;
        r6 = 256;
        goto L32
    L33:
        r8 = r22;
        goto L35
    L17:
        if ((r27 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r23 = 32;
    L22:
        r3 = r3 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r3 = r27;
        goto L13
    L8:
        if (r1.changed(r20) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r27;
        goto L13
    L10:
        r25 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m2121CircularProgressIndicatorLxG7B9w(Modifier r34, long r35, float r37, long r38, int r40, Composer r41, final int r42, final int r43) {
        Composer r1 = r41.startRestartGroup(-1119119072);
        int r2 = r43 & 1;
        if (r2 == 0) goto L6;
        int r5 = r42 | 6;
        Modifier r4 = r34;
    L14:
        if ((r42 & 48) != 0) goto L22;
        long r9 = r35;
        if ((r43 & 2) == 0) goto L18;
    L20:
        int r6 = 16;
    L21:
        r5 = r5 | r6;
    L23:
        int r7 = r43 & 4;
        if (r7 == 0) goto L27;
        r5 = r5 | 384;
    L33:
        float r11 = r37;
    L34:
        int r12 = r43 & 8;
        if (r12 == 0) goto L38;
        r5 = r5 | 3072;
    L45:
        if ((r42 & 24576) == 0) goto L47;
        int r13 = r40;
    L56:
        if ((r5 & 9363) == 9362) goto L58;
        boolean r3 = true;
    L60:
        if (r1.shouldExecute(r3, r5 & 1) == false) goto L123;
        r1.startDefaults();
        if ((r42 & 1) != 0) goto L64;
    L74:
        if (r2 == 0) goto L76;
        Modifier r8 = Modifier.Companion;
    L78:
        if ((r43 & 2) == 0) goto L80;
        r5 = r5 & (-113);
        r9 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
    L80:
        if (r7 == 0) goto L82;
        r11 = ProgressIndicatorDefaults.INSTANCE.m2119getStrokeWidthD9Ej5fM();
    L82:
        if (r12 == 0) goto L84;
        long r10 = Color.Companion.getTransparent-0d7_KjU();
    L86:
        if ((r43 & 16) == 0) goto L88;
        int r14 = r5 & (-57345);
        int r30 = StrokeCap.Companion.getSquare-KaPHkGw();
        float r15 = r11;
        long r16 = r10;
        long r17 = r9;
    L89:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-1119119072, r14, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:353)");
    L92:
        final Stroke r18 = new Stroke(((Density) r1.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r15), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r30, 0, null, 26, null);
        InfiniteTransition r19 = InfiniteTransitionKt.rememberInfiniteTransition(null, r1, 0, 1);
        TwoWayConverter<Integer, AnimationVector1D> r110 = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        InfiniteRepeatableSpec r20 = AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0, 6, null);
        int r21 = InfiniteTransition.$stable;
        int r22 = InfiniteRepeatableSpec.$stable;
        int r32 = r14;
        boolean r23 = true;
        final State r24 = InfiniteTransitionKt.animateValue(r19, 0, 5, r110, r20, null, r1, (r21 | 432) | (r22 << 12), 16);
        final State<Float> r0 = InfiniteTransitionKt.animateFloat(r19, androidx.compose.material3.MenuKt.ClosedAlphaTarget, BaseRotationAngle, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0, 6, null), null, r1, (r21 | 432) | (r22 << 9), 8);
        Object r111 = r1.rememberedValue();
        Composer.Companion r112 = Composer.Companion;
        if (r111 != r112.getEmpty()) goto L95;
        r111 = new q8();
        r1.updateRememberedValue(r111);
    L95:
        final State<Float> r25 = InfiniteTransitionKt.animateFloat(r19, androidx.compose.material3.MenuKt.ClosedAlphaTarget, JumpRotationAngle, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r111), null, 0, 6, null), null, r1, (r21 | 432) | (r22 << 9), 8);
        Object r113 = r1.rememberedValue();
        if (r113 != r112.getEmpty()) goto L98;
        r113 = new x7();
        r1.updateRememberedValue(r113);
    L98:
        final State<Float> r114 = InfiniteTransitionKt.animateFloat(r19, androidx.compose.material3.MenuKt.ClosedAlphaTarget, JumpRotationAngle, AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) r113), null, 0, 6, null), null, r1, (r21 | 432) | (r22 << 9), 8);
        Modifier r115 = SizeKt.m1014size3ABfNKs(ProgressSemanticsKt.progressSemantics(r8), CircularIndicatorDiameter);
        if ((r32 & 7168) != 2048) goto L101;
        boolean r116 = true;
    L102:
        boolean r117 = ((((r116 | r1.changedInstance(r31)) | r1.changed(r24)) | r1.changed(r25)) | r1.changed(r114)) | r1.changed(r0);
        Modifier r36 = r8;
        if ((r32 & 896) != 256) goto L105;
        boolean r26 = true;
    L106:
        boolean r27 = r26 | r117;
        if (((r32 & 112) ^ 48) <= 32) goto L111;
        if (r1.changed(r17) == false) goto L111;
    L114:
        boolean r28 = r27 | r23;
        Object r118 = r1.rememberedValue();
        if (r28 == false) goto L117;
    L118:
        final long r29 = r16;
        final float r210 = r15;
        final long r211 = r17;
        r118 = new y7(r29, r18, r210, r211, r24, r25, r114, r0);
        r1.updateRememberedValue(r118);
    L119:
        CanvasKt.Canvas(r115, (Function1) r118, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L122;
        ComposerKt.traceEventEnd();
    L122:
        final long r31 = r17;
        r11 = r15;
        final long r33 = r16;
        final int r39 = r30;
        r4 = r36;
    L124:
        ScopeUpdateScope r119 = r1.endRestartGroup();
        if (r119 == null) goto L128;
        final Modifier r44 = r4;
        final float r45 = r11;
        r119.updateScope(new z7(r44, r31, r45, r33, r39, r42, r43));
        return;
    L128:
        return;
    L117:
        if (r118 != r112.getEmpty()) goto L119;
    L111:
        if ((r32 & 48) == 32) goto L114;
        r23 = false;
        goto L114
    L105:
        r26 = false;
        goto L106
    L101:
        r116 = false;
        goto L102
    L88:
        r16 = r10;
    L73:
        r17 = r9;
        r30 = r13;
        r14 = r5;
        r15 = r11;
        goto L89
    L84:
        r10 = r38;
        goto L86
    L76:
        r8 = r4;
        goto L78
    L64:
        if (r1.getDefaultsInvalid() == true) goto L74;
        r1.skipToGroupEnd();
        if ((r43 & 2) == 0) goto L70;
        r5 = r5 & (-113);
    L70:
        if ((r43 & 16) == 0) goto L72;
        r5 = r5 & (-57345);
    L72:
        r16 = r38;
        r8 = r4;
        goto L73
    L123:
        r1.skipToGroupEnd();
        r33 = r38;
        r31 = r9;
        r39 = r13;
        goto L124
    L58:
        r3 = false;
        goto L60
    L47:
        if ((r43 & 16) != 0) goto L51;
        r13 = r40;
        if (r1.changed(r13) == false) goto L52;
        int r120 = 16384;
    L53:
        r5 = r5 | r120;
    L52:
        r120 = 8192;
        goto L53
    L51:
        r13 = r40;
        goto L52
    L38:
        if ((r42 & 3072) != 0) goto L45;
        if (r1.changed(r38) == false) goto L42;
        int r121 = 2048;
    L43:
        r5 = r5 | r121;
        goto L45
    L42:
        r121 = 1024;
        goto L43
    L27:
        if ((r42 & 384) != 0) goto L33;
        r11 = r37;
        if (r1.changed(r11) == false) goto L31;
        int r122 = 256;
    L32:
        r5 = r5 | r122;
        goto L34
    L31:
        r122 = 128;
        goto L32
    L18:
        if (r1.changed(r9) == false) goto L20;
        r6 = 32;
        goto L21
    L22:
        r9 = r35;
        goto L23
    L6:
        if ((r42 & 6) != 0) goto L12;
        r4 = r34;
        if (r1.changed(r4) == false) goto L10;
        int r46 = 4;
    L11:
        r5 = r46 | r42;
        goto L14
    L10:
        r46 = 2;
        goto L11
    L12:
        r4 = r34;
        r5 = r42;
        goto L14
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final void m2126LinearProgressIndicator_5eSRE(final float r25, Modifier r26, long r27, long r29, int r31, Composer r32, final int r33, final int r34) {
        Composer r2 = r32.startRestartGroup(-531984864);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r4 = r34 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r26;
    L25:
        if ((r33 & 384) != 0) goto L33;
        long r9 = r27;
        if ((r34 & 4) == 0) goto L29;
    L31:
        int r6 = 128;
    L32:
        r3 = r3 | r6;
    L35:
        if ((r33 & 3072) != 0) goto L43;
        long r12 = r29;
        if ((r34 & 8) == 0) goto L39;
    L41:
        int r7 = 1024;
    L42:
        r3 = r3 | r7;
    L45:
        if ((r33 & 24576) == 0) goto L47;
        int r8 = r31;
    L55:
        boolean r16 = true;
        if ((r3 & 9363) == 9362) goto L58;
        boolean r10 = true;
    L60:
        if (r2.shouldExecute(r10, r3 & 1) == false) goto L137;
        r2.startDefaults();
        if ((r33 & 1) != 0) goto L64;
    L76:
        if (r4 == 0) goto L78;
        Modifier r11 = Modifier.Companion;
    L80:
        if ((r34 & 4) == 0) goto L83;
        r9 = MaterialTheme.INSTANCE.getColors(r2, 6).m1999getPrimary0d7_KjU();
        r3 = r3 & (-897);
    L83:
        if ((r34 & 8) == 0) goto L86;
        r12 = Color.copy-wmQWz5c$default(r9, 0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r3 = r3 & (-7169);
    L86:
        if ((r34 & 16) == 0) goto L88;
        r3 = r3 & (-57345);
        r8 = StrokeCap.Companion.getButt-KaPHkGw();
    L88:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventStart(-531984864, r3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:108)");
    L91:
        float r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        if (r25 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L94;
        float r13 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L95:
        float r14 = 1.0f;
        if (r13 > 1.0f) goto L99;
        r14 = r13;
    L99:
        Modifier r15 = increaseSemanticsBounds(r11);
        Float r17 = Float.valueOf(r14);
        if (Float.isNaN(r17.floatValue()) == false) goto L103;
        r17 = null;
    L103:
        if (r17 == null) goto L105;
        r0 = r17.floatValue();
    L105:
        Modifier r1 = SizeKt.m1016sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(r15, r0, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
        if (((r3 & 7168) ^ 3072) <= 2048) goto L110;
        if (r2.changed(r12) == false) goto L110;
    L111:
        boolean r18 = true;
    L114:
        if (((57344 & r3) ^ 24576) <= 16384) goto L118;
        if (r2.changed(r8) == false) goto L118;
    L119:
        boolean r19 = true;
    L121:
        boolean r20 = (r18 | r19) | r2.changed(r14);
        if (((r3 & 896) ^ 384) <= 256) goto L126;
        if (r2.changed(r9) == false) goto L126;
    L129:
        boolean r21 = r20 | r16;
        Object r22 = r2.rememberedValue();
        if (r21 == false) goto L132;
    L133:
        final long r110 = r12;
        final int r23 = r8;
        final float r24 = r14;
        final long r28 = r9;
        r22 = new g8(r110, r23, r24, r28);
        r2.updateRememberedValue(r22);
    L134:
        CanvasKt.Canvas(r1, (Function1) r22, r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        final int r30 = r8;
        final long r35 = r12;
        ScopeUpdateScope r111 = r2.endRestartGroup();
        if (r111 == null) goto L142;
        final Modifier r36 = r11;
        final long r37 = r9;
        r111.updateScope(new i8(r25, r36, r37, r35, r30, r33, r34));
        return;
    L142:
        return;
    L132:
        if (r22 != Composer.Companion.getEmpty()) goto L134;
    L126:
        if ((r3 & 384) == 256) goto L129;
        r16 = false;
    L118:
        if ((r3 & 24576) == 16384) goto L119;
        r19 = false;
    L110:
        if ((r3 & 3072) == 2048) goto L111;
        r18 = false;
        goto L114
    L94:
        r13 = r25;
        goto L95
    L78:
        r11 = r5;
        goto L80
    L64:
        if (r2.getDefaultsInvalid() == true) goto L76;
        r2.skipToGroupEnd();
        if ((r34 & 4) == 0) goto L70;
        r3 = r3 & (-897);
    L70:
        if ((r34 & 8) == 0) goto L73;
        r3 = r3 & (-7169);
    L73:
        if ((r34 & 16) == 0) goto L75;
        r3 = r3 & (-57345);
    L75:
        r11 = r5;
        goto L88
    L137:
        r2.skipToGroupEnd();
        r11 = r5;
        goto L138
    L58:
        r10 = false;
        goto L60
    L47:
        if ((r34 & 16) != 0) goto L51;
        r8 = r31;
        if (r2.changed(r8) == false) goto L52;
        int r112 = 16384;
    L53:
        r3 = r3 | r112;
    L52:
        r112 = 8192;
        goto L53
    L51:
        r8 = r31;
        goto L52
    L39:
        if (r2.changed(r12) == false) goto L41;
        r7 = 2048;
        goto L42
    L43:
        r12 = r29;
        goto L45
    L29:
        if (r2.changed(r9) == false) goto L31;
        r6 = 256;
        goto L32
    L33:
        r9 = r27;
        goto L35
    L17:
        if ((r33 & 48) != 0) goto L23;
        r5 = r26;
        if (r2.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L25
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r33;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$20$lambda$19(long r12, int r14, long r15, State r17, State r18, State r19, State r20, DrawScope r21) {
        float r0 = Float.intBitsToFloat((int) (r21.getSize-NH-jbRc() & 4294967295L));
        m2133drawLinearIndicatorBackgroundAZGd3zU(r21, r12, r0, r14);
        if ((LinearProgressIndicator_2cYBFYY$lambda$9(r17) - LinearProgressIndicator_2cYBFYY$lambda$12(r18)) <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L6;
        m2132drawLinearIndicatorqYKTg0g(r21, LinearProgressIndicator_2cYBFYY$lambda$9(r17), LinearProgressIndicator_2cYBFYY$lambda$12(r18), r15, r0, r14);
    L6:
        if ((LinearProgressIndicator_2cYBFYY$lambda$15(r19) - LinearProgressIndicator_2cYBFYY$lambda$18(r20)) <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L9;
        m2132drawLinearIndicatorqYKTg0g(r21, LinearProgressIndicator_2cYBFYY$lambda$15(r19), LinearProgressIndicator_2cYBFYY$lambda$18(r20), r15, r0, r14);
    L9:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m2120CircularProgressIndicatorDUhRLBM(final float r26, Modifier r27, long r28, float r30, long r31, int r33, Composer r34, final int r35, final int r36) {
        Composer r2 = r34.startRestartGroup(1746618448);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L13:
        int r4 = r36 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r35 & 384) != 0) goto L33;
        long r10 = r28;
        if ((r36 & 4) == 0) goto L29;
    L31:
        int r6 = 128;
    L32:
        r3 = r3 | r6;
    L34:
        int r7 = r36 & 8;
        if (r7 == 0) goto L38;
        r3 = r3 | 3072;
    L44:
        float r8 = r30;
    L45:
        int r12 = r36 & 16;
        if (r12 == 0) goto L49;
        r3 = r3 | 24576;
    L55:
        long r14 = r31;
    L57:
        if ((r35 & 196608) != 0) goto L65;
        int r9 = r33;
        if ((r36 & 32) == 0) goto L61;
    L63:
        int r16 = 65536;
    L64:
        r3 = r3 | r16;
    L66:
        boolean r17 = true;
        if ((r3 & 74899) == 74898) goto L69;
        boolean r0 = true;
    L71:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L133;
        r2.startDefaults();
        if ((r35 & 1) != 0) goto L75;
    L84:
        if (r4 == 0) goto L86;
        Modifier r1 = Modifier.Companion;
    L88:
        if ((r36 & 4) == 0) goto L90;
        r10 = MaterialTheme.INSTANCE.getColors(r2, 6).m1999getPrimary0d7_KjU();
        r3 = r3 & (-897);
    L90:
        if (r7 == 0) goto L92;
        r8 = ProgressIndicatorDefaults.INSTANCE.m2119getStrokeWidthD9Ej5fM();
    L92:
        if (r12 == 0) goto L95;
        r14 = Color.Companion.getTransparent-0d7_KjU();
    L95:
        if ((r36 & 32) == 0) goto L97;
        r3 = r3 & (-458753);
        r9 = StrokeCap.Companion.getButt-KaPHkGw();
    L97:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(1746618448, r3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:313)");
    L100:
        float r5 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        if (r26 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L103;
        float r11 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L105:
        if (r11 <= 1.0f) goto L107;
        r11 = 1.0f;
    L107:
        final Stroke r13 = new Stroke(((Density) r2.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r8), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, 0, null, 26, null);
        Float r15 = Float.valueOf(r11);
        if (Float.isNaN(r15.floatValue()) == false) goto L111;
        r15 = null;
    L111:
        if (r15 == null) goto L113;
        r5 = r15.floatValue();
    L113:
        Modifier r18 = SizeKt.m1014size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(r1, r5, null, 0, 6, null), CircularIndicatorDiameter);
        boolean r19 = r2.changed(r11);
        Modifier r110 = r1;
        if ((r3 & 57344) != 16384) goto L116;
        boolean r20 = true;
    L117:
        boolean r21 = (r20 | r19) | r2.changedInstance(r13);
        if (((r3 & 896) ^ 384) <= 256) goto L122;
        if (r2.changed(r10) == false) goto L122;
    L125:
        boolean r22 = r21 | r17;
        Object r23 = r2.rememberedValue();
        if (r22 == false) goto L128;
    L129:
        final float r29 = r11;
        final long r210 = r14;
        final long r32 = r10;
        r23 = new b8(r29, r210, r13, r32);
        r2.updateRememberedValue(r23);
    L130:
        CanvasKt.Canvas(r18, (Function1) r23, r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventEnd();
    L134:
        final float r24 = r8;
        final long r25 = r10;
        final int r37 = r9;
        final long r38 = r14;
        ScopeUpdateScope r111 = r2.endRestartGroup();
        if (r111 == null) goto L138;
        final Modifier r39 = r110;
        r111.updateScope(new c8(r26, r39, r25, r24, r38, r37, r35, r36));
        return;
    L138:
        return;
    L128:
        if (r23 != Composer.Companion.getEmpty()) goto L130;
    L122:
        if ((r3 & 384) == 256) goto L125;
        r17 = false;
        goto L125
    L116:
        r20 = false;
        goto L117
    L103:
        r11 = r26;
        goto L105
    L86:
        r1 = r27;
        goto L88
    L75:
        if (r2.getDefaultsInvalid() == true) goto L84;
        r2.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L81;
        r3 = r3 & (-897);
    L81:
        if ((r36 & 32) == 0) goto L83;
        r3 = r3 & (-458753);
    L83:
        r1 = r27;
        goto L97
    L133:
        r2.skipToGroupEnd();
        r110 = r27;
        goto L134
    L69:
        r0 = false;
        goto L71
    L61:
        if (r2.changed(r9) == false) goto L63;
        r16 = 131072;
        goto L64
    L65:
        r9 = r33;
        goto L66
    L49:
        if ((r35 & 24576) != 0) goto L55;
        r14 = r31;
        if (r2.changed(r14) == false) goto L53;
        int r112 = 16384;
    L54:
        r3 = r3 | r112;
        goto L57
    L53:
        r112 = 8192;
        goto L54
    L38:
        if ((r35 & 3072) != 0) goto L44;
        r8 = r30;
        if (r2.changed(r8) == false) goto L42;
        int r113 = 2048;
    L43:
        r3 = r3 | r113;
        goto L45
    L42:
        r113 = 1024;
        goto L43
    L29:
        if (r2.changed(r10) == false) goto L31;
        r6 = 256;
        goto L32
    L33:
        r10 = r28;
        goto L34
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r2.changed(r27) == false) goto L21;
        int r40 = 32;
    L22:
        r3 = r3 | r40;
        goto L25
    L21:
        r40 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L13
    L8:
        if (r2.changed(r26) == false) goto L10;
        int r41 = 4;
    L11:
        r3 = r41 | r35;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }

    private static final Unit CircularProgressIndicator_LxG7B9w$lambda$39$lambda$38(long r7, Stroke r9, float r10, long r11, State r13, State r14, State r15, State r16, DrawScope r17) {
        m2129drawCircularIndicatorBackgroundbw27NRU(r17, r7, r9);
        float r0 = (CircularProgressIndicator_LxG7B9w$lambda$30(r13) * RotationAngleOffset) % 360.0f;
        m2131drawIndeterminateCircularIndicatorhrjfTZI(r17, CircularProgressIndicator_LxG7B9w$lambda$37(r15) + ((r0 + StartAngleOffset) + CircularProgressIndicator_LxG7B9w$lambda$31(r16)), r10, Math.abs(CircularProgressIndicator_LxG7B9w$lambda$34(r14) - CircularProgressIndicator_LxG7B9w$lambda$37(r15)), r11, r9);
        return Unit.INSTANCE;
    }
}
