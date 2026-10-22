package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u001aE\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aj\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\u001a\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a;\u0010\u001f\u001a\u00020\u0001*\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010$\u001aO\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010'\u001aY\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b(\u0010)\u001aA\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010+\u001aK\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b,\u0010-\u001aI\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010.\u001a5\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b/\u00100\u001a-\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b1\u00102\u001a3\u00103\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109\u001a#\u0010:\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b;\u0010<\u001a3\u0010=\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b>\u00109\u001a;\u0010?\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b@\u0010A\"\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\"\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\"\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010E\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010E\"\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010E\"\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010E\"\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010E\"\u0016\u0010R\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0016\u0010V\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bW\u0010T\"\u0016\u0010X\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bY\u0010T\"\u0016\u0010Z\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\b[\u0010T\"\u000e\u0010\\\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u0014\u0010j\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010i\"\u000e\u0010l\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010o\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"LinearProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "gapSize", "Landroidx/compose/ui/unit/Dp;", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "CircularProgressIndicator", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-4lLiAd8", "(Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "circularIndeterminateGlobalRotationAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "getCircularIndeterminateGlobalRotationAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "circularIndeterminateRotationAnimationSpec", "getCircularIndeterminateRotationAnimationSpec", "circularIndeterminateProgressAnimationSpec", "getCircularIndeterminateProgressAnimationSpec", "linearIndeterminateFirstLineHeadAnimationSpec", "getLinearIndeterminateFirstLineHeadAnimationSpec", "linearIndeterminateFirstLineTailAnimationSpec", "getLinearIndeterminateFirstLineTailAnimationSpec", "linearIndeterminateSecondLineHeadAnimationSpec", "getLinearIndeterminateSecondLineHeadAnimationSpec", "linearIndeterminateSecondLineTailAnimationSpec", "getLinearIndeterminateSecondLineTailAnimationSpec", "LinearIndicatorWidth", "getLinearIndicatorWidth", "()F", "F", "LinearIndicatorHeight", "getLinearIndicatorHeight", "StopIndicatorTrailingSpace", "getStopIndicatorTrailingSpace", "CircularIndicatorDiameter", "getCircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "LinearIndeterminateProgressEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getLinearIndeterminateProgressEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "CircularProgressEasing", "getCircularProgressEasing", "CircularIndeterminateMinProgress", "CircularIndeterminateMaxProgress", "CircularAnimationProgressDuration", "CircularAnimationAdditionalRotationDelay", "CircularAnimationAdditionalRotationDuration", "CircularAdditionalRotationDegreesTarget", "CircularGlobalRotationDegreesTarget", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorKt {
    public static final float CircularAdditionalRotationDegreesTarget = 360.0f;
    public static final int CircularAnimationAdditionalRotationDelay = 1500;
    public static final int CircularAnimationAdditionalRotationDuration = 300;
    public static final int CircularAnimationProgressDuration = 6000;
    public static final float CircularGlobalRotationDegreesTarget = 1080.0f;
    public static final float CircularIndeterminateMaxProgress = 0.87f;
    public static final float CircularIndeterminateMinProgress = 0.1f;
    private static final float CircularIndicatorDiameter = 0.0f;
    private static final CubicBezierEasing CircularProgressEasing = null;
    public static final int FirstLineHeadDelay = 0;
    public static final int FirstLineHeadDuration = 1000;
    public static final int FirstLineTailDelay = 250;
    public static final int FirstLineTailDuration = 1000;
    public static final int LinearAnimationDuration = 1750;
    private static final CubicBezierEasing LinearIndeterminateProgressEasing = null;
    private static final float LinearIndicatorHeight = 0.0f;
    private static final float LinearIndicatorWidth = 0.0f;
    public static final int SecondLineHeadDelay = 650;
    public static final int SecondLineHeadDuration = 850;
    public static final int SecondLineTailDelay = 900;
    public static final int SecondLineTailDuration = 850;
    private static final float StopIndicatorTrailingSpace = 0.0f;

    public static /* synthetic */ Unit A(int r0, float r1, Function0 r2, long r3, long r5, Function1 r7, DrawScope r8) {
        return LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(r0, r1, r2, r3, r5, r7, r8);
    }

    public static /* synthetic */ Unit B(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_circularIndeterminateProgressAnimationSpec_$lambda$42(r0);
    }

    public static /* synthetic */ Unit C(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44(r0);
    }

    private static final Unit CircularProgressIndicator_4lLiAd8$lambda$35(Modifier r12, long r13, float r15, long r16, int r18, float r19, int r20, int r21, Composer r22, int r23) {
        m2996CircularProgressIndicator4lLiAd8(r12, r13, r15, r16, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_DUhRLBM$lambda$20(Function0 r12, Modifier r13, long r14, float r16, long r17, int r19, int r20, int r21, Composer r22, int r23) {
        m2998CircularProgressIndicatorDUhRLBM(r12, r13, r14, r16, r17, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final float CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(float r0) {
        return r0;
    }

    private static final Unit CircularProgressIndicator_DUhRLBM$lambda$38(float r12, Modifier r13, long r14, float r16, long r17, int r19, int r20, int r21, Composer r22, int r23) {
        m2997CircularProgressIndicatorDUhRLBM(r12, r13, r14, r16, r17, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_IyT6zlY$lambda$29(Function0 r13, Modifier r14, long r15, float r17, long r18, int r20, float r21, int r22, int r23, Composer r24, int r25) {
        m2999CircularProgressIndicatorIyT6zlY(r13, r14, r15, r17, r18, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_LxG7B9w$lambda$30(Modifier r11, long r12, float r14, long r15, int r17, int r18, int r19, Composer r20, int r21) {
        m3000CircularProgressIndicatorLxG7B9w(r11, r12, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_MBs18nI$lambda$39(float r9, Modifier r10, long r11, float r13, int r14, int r15, Composer r16, int r17) {
        m3001CircularProgressIndicatorMBs18nI(r9, r10, r11, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_aM_cp0Q$lambda$40(Modifier r7, long r8, float r10, int r11, int r12, Composer r13, int r14) {
        m3002CircularProgressIndicatoraMcp0Q(r7, r8, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit D(Function0 r0, Modifier r1, long r2, float r4, long r5, int r7, float r8, int r9, int r10, Composer r11, int r12) {
        return CircularProgressIndicator_IyT6zlY$lambda$29(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit E(Modifier r0, long r1, float r3, long r4, int r6, float r7, int r8, int r9, Composer r10, int r11) {
        return CircularProgressIndicator_4lLiAd8$lambda$35(r0, r1, r3, r4, r6, r7, r8, r9, r10, r11);
    }

    private static final Unit LinearProgressIndicator_2cYBFYY$lambda$11(Modifier r10, long r11, long r13, int r15, int r16, int r17, Composer r18, int r19) {
        m3003LinearProgressIndicator2cYBFYY(r10, r11, r13, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_GJbTh5U$lambda$10(Function0 r13, Modifier r14, long r15, long r17, int r19, float r20, Function1 r21, int r22, int r23, Composer r24, int r25) {
        m3004LinearProgressIndicatorGJbTh5U(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_RIQooxk$lambda$19(Modifier r9, long r10, long r12, int r14, int r15, Composer r16, int r17) {
        m3005LinearProgressIndicatorRIQooxk(r9, r10, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator__5eSR_E$lambda$0(Function0 r11, Modifier r12, long r13, long r15, int r17, int r18, int r19, Composer r20, int r21) {
        m3007LinearProgressIndicator_5eSRE(r11, r12, r13, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final float LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(float r0) {
        return r0;
    }

    private static final Unit LinearProgressIndicator__5eSR_E$lambda$17(float r11, Modifier r12, long r13, long r15, int r17, int r18, int r19, Composer r20, int r21) {
        m3006LinearProgressIndicator_5eSRE(r11, r12, r13, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_eaDK9VM$lambda$18(float r10, Modifier r11, long r12, long r14, int r16, int r17, Composer r18, int r19) {
        m3008LinearProgressIndicatoreaDK9VM(r10, r11, r12, r14, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit LinearProgressIndicator_rIrjwxo$lambda$14(Modifier r11, long r12, long r14, int r16, float r17, int r18, int r19, Composer r20, int r21) {
        m3009LinearProgressIndicatorrIrjwxo(r11, r12, r14, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, long r1, long r3, int r5, int r6, Composer r7, int r8) {
        return LinearProgressIndicator_RIQooxk$lambda$19(r0, r1, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ float b(float r0) {
        return LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(r0);
    }

    public static /* synthetic */ Unit c(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46(r0);
    }

    public static /* synthetic */ Unit d(long r0, int r2, DrawScope r3) {
        return LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(r0, r2, r3);
    }

    public static /* synthetic */ Unit e(Function0 r0, Modifier r1, long r2, float r4, long r5, int r7, int r8, int r9, Composer r10, int r11) {
        return CircularProgressIndicator_DUhRLBM$lambda$20(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit f(Modifier r0, long r1, long r3, int r5, float r6, int r7, int r8, Composer r9, int r10) {
        return LinearProgressIndicator_rIrjwxo$lambda$14(r0, r1, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit g(float r0, Modifier r1, long r2, long r4, int r6, int r7, Composer r8, int r9) {
        return LinearProgressIndicator_eaDK9VM$lambda$18(r0, r1, r2, r4, r6, r7, r8, r9);
    }

    public static /* synthetic */ float h(Function0 r0) {
        return LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ float i(Function0 r0) {
        return CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(r0);
    }

    public static /* synthetic */ Unit j(Function0 r0, SemanticsPropertyReceiver r1) {
        return LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit k(float r0, Modifier r1, long r2, float r4, long r5, int r7, int r8, int r9, Composer r10, int r11) {
        return CircularProgressIndicator_DUhRLBM$lambda$38(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit l(Function0 r0, Modifier r1, long r2, long r4, int r6, int r7, int r8, Composer r9, int r10) {
        return LinearProgressIndicator__5eSR_E$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit m(Function0 r0, Modifier r1, long r2, long r4, int r6, float r7, Function1 r8, int r9, int r10, Composer r11, int r12) {
        return LinearProgressIndicator_GJbTh5U$lambda$10(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit n(int r0, float r1, State r2, long r3, State r5, long r6, State r8, State r9, DrawScope r10) {
        return LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(r0, r1, r2, r3, r5, r6, r8, r9, r10);
    }

    public static /* synthetic */ Unit o(State r0, int r1, float r2, float r3, State r4, State r5, long r6, Stroke r8, long r9, DrawScope r11) {
        return CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(r0, r1, r2, r3, r4, r5, r6, r8, r9, r11);
    }

    public static /* synthetic */ Unit p(Modifier r0, long r1, long r3, int r5, int r6, int r7, Composer r8, int r9) {
        return LinearProgressIndicator_2cYBFYY$lambda$11(r0, r1, r3, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit q(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_circularIndeterminateRotationAnimationSpec_$lambda$41(r0);
    }

    public static /* synthetic */ Unit r(Function0 r0, int r1, float r2, float r3, long r4, Stroke r6, long r7, DrawScope r9) {
        return CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(r0, r1, r2, r3, r4, r6, r7, r9);
    }

    public static /* synthetic */ float s(float r0) {
        return CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(r0);
    }

    public static /* synthetic */ Unit t(Modifier r0, long r1, float r3, int r4, int r5, Composer r6, int r7) {
        return CircularProgressIndicator_aM_cp0Q$lambda$40(r0, r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit u(Function0 r0, SemanticsPropertyReceiver r1) {
        return CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(r0, r1);
    }

    public static /* synthetic */ Unit v(Modifier r0, long r1, float r3, long r4, int r6, int r7, int r8, Composer r9, int r10) {
        return CircularProgressIndicator_LxG7B9w$lambda$30(r0, r1, r3, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit w(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45(r0);
    }

    public static /* synthetic */ Unit x(float r0, Modifier r1, long r2, float r4, int r5, int r6, Composer r7, int r8) {
        return CircularProgressIndicator_MBs18nI$lambda$39(r0, r1, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit y(float r0, Modifier r1, long r2, long r4, int r6, int r7, int r8, Composer r9, int r10) {
        return LinearProgressIndicator__5eSR_E$lambda$17(r0, r1, r2, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit z(KeyframesSpec.KeyframesSpecConfig r0) {
        return _get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43(r0);
    }

    static {
        LinearIndicatorWidth = Dp.constructor-impl(240);
        LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.getHeight-D9Ej5fM();
        StopIndicatorTrailingSpace = Dp.constructor-impl(6);
        CircularIndicatorDiameter = CircularProgressIndicatorTokens.INSTANCE.getSize-D9Ej5fM();
        MotionTokens r0 = MotionTokens.INSTANCE;
        LinearIndeterminateProgressEasing = r0.getEasingEmphasizedAccelerateCubicBezier();
        CircularProgressEasing = r0.getEasingStandardCubicBezier();
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateProgressAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new nk()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateRotationAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new lk()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineHeadAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new kk()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineTailAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new ak()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineHeadAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new yj()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineTailAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new qk()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateGlobalRotationAnimationSpec() {
        return AnimationSpecKt.m249infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(CircularAnimationProgressDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0, 6, null);
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final CubicBezierEasing getCircularProgressEasing() {
        return CircularProgressEasing;
    }

    public static final CubicBezierEasing getLinearIndeterminateProgressEasing() {
        return LinearIndeterminateProgressEasing;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getStopIndicatorTrailingSpace() {
        return StopIndicatorTrailingSpace;
    }

    private static final float CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(Function0 r2) {
        float r3 = ((Number) r2.invoke()).floatValue();
        if (r3 >= MenuKt.ClosedAlphaTarget) goto L6;
        r3 = MenuKt.ClosedAlphaTarget;
    L6:
        if (r3 <= 1.0f) goto L9;
        return 1.0f;
    L9:
        return r3;
    }

    private static final float LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(Function0 r2) {
        float r3 = ((Number) r2.invoke()).floatValue();
        if (r3 >= MenuKt.ClosedAlphaTarget) goto L6;
        r3 = MenuKt.ClosedAlphaTarget;
    L6:
        if (r3 <= 1.0f) goto L9;
        return 1.0f;
    L9:
        return r3;
    }

    private static final Unit _get_circularIndeterminateProgressAnimationSpec_$lambda$42(KeyframesSpec.KeyframesSpecConfig r3) {
        r3.setDurationMillis(CircularAnimationProgressDuration);
        r3.using(r3.at(Float.valueOf(0.87f), 3000), CircularProgressEasing);
        r3.at(Float.valueOf(0.1f), CircularAnimationProgressDuration);
        return Unit.INSTANCE;
    }

    private static final Unit _get_circularIndeterminateRotationAnimationSpec_$lambda$41(KeyframesSpec.KeyframesSpecConfig r4) {
        r4.setDurationMillis(CircularAnimationProgressDuration);
        Float r1 = Float.valueOf(90.0f);
        r4.using(r4.at(r1, 300), MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier());
        r4.at(r1, CircularAnimationAdditionalRotationDelay);
        Float r2 = Float.valueOf(180.0f);
        r4.at(r2, 1800);
        r4.at(r2, 3000);
        Float r3 = Float.valueOf(270.0f);
        r4.at(r3, 3300);
        r4.at(r3, 4500);
        Float r5 = Float.valueOf(360.0f);
        r4.at(r5, 4800);
        r4.at(r5, CircularAnimationProgressDuration);
        return Unit.INSTANCE;
    }

    private static final Unit _get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(MenuKt.ClosedAlphaTarget), 0), LinearIndeterminateProgressEasing);
        r2.at(Float.valueOf(1.0f), 1000);
        return Unit.INSTANCE;
    }

    private static final Unit _get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(MenuKt.ClosedAlphaTarget), FirstLineTailDelay), LinearIndeterminateProgressEasing);
        r2.at(Float.valueOf(1.0f), 1250);
        return Unit.INSTANCE;
    }

    private static final Unit _get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45(KeyframesSpec.KeyframesSpecConfig r2) {
        r2.setDurationMillis(LinearAnimationDuration);
        r2.using(r2.at(Float.valueOf(MenuKt.ClosedAlphaTarget), SecondLineHeadDelay), LinearIndeterminateProgressEasing);
        r2.at(Float.valueOf(1.0f), CircularAnimationAdditionalRotationDelay);
        return Unit.INSTANCE;
    }

    private static final Unit _get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46(KeyframesSpec.KeyframesSpecConfig r3) {
        r3.setDurationMillis(LinearAnimationDuration);
        r3.using(r3.at(Float.valueOf(MenuKt.ClosedAlphaTarget), SecondLineTailDelay), LinearIndeterminateProgressEasing);
        r3.at(Float.valueOf(1.0f), LinearAnimationDuration);
        return Unit.INSTANCE;
    }

    private static final Unit CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(Function0 r7, SemanticsPropertyReceiver r8) {
        Object r9 = r7.invoke();
        if (Float.isNaN(((Number) r9).floatValue()) == false) goto L6;
        r9 = null;
    L6:
        Float r10 = (Float) r9;
        if (r10 == null) goto L9;
        float r2 = r10.floatValue();
    L10:
        SemanticsPropertiesKt.setProgressBarRangeInfo(r8, new ProgressBarRangeInfo(r2, RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    L9:
        r2 = MenuKt.ClosedAlphaTarget;
        goto L10
    }

    private static final Unit LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(Function0 r7, SemanticsPropertyReceiver r8) {
        Object r9 = r7.invoke();
        if (Float.isNaN(((Number) r9).floatValue()) == false) goto L6;
        r9 = null;
    L6:
        Float r10 = (Float) r9;
        if (r10 == null) goto L9;
        float r2 = r10.floatValue();
    L10:
        SemanticsPropertiesKt.setProgressBarRangeInfo(r8, new ProgressBarRangeInfo(r2, RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    L9:
        r2 = MenuKt.ClosedAlphaTarget;
        goto L10
    }

    private static final Unit LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(long r6, int r8, DrawScope r9) {
        ProgressIndicatorDefaults r0 = ProgressIndicatorDefaults.INSTANCE;
        r0.m2988drawStopIndicatorEgI2THU(r9, r0.m2995getLinearTrackStopIndicatorSizeD9Ej5fM(), r6, r8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    private static final void m3011drawCircularIndicatorTrackbw27NRU(DrawScope r6, long r7, Stroke r9) {
        m3010drawCircularIndicator42QJj7c(r6, MenuKt.ClosedAlphaTarget, 360.0f, r7, r9);
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3010drawCircularIndicator42QJj7c(DrawScope r21, float r22, float r23, long r24, Stroke r26) {
        float r1 = 2;
        float r0 = r26.getWidth() / r1;
        float r2 = Float.intBitsToFloat((int) (r21.getSize-NH-jbRc() >> 32)) - (r1 * r0);
        long r5 = Float.floatToRawIntBits(r0);
        DrawScope.-CC.drawArc-yD3GUKo$default(r21, r24, r22, r23, false, Offset.constructor-impl((((long) Float.floatToRawIntBits(r0)) & 4294967295L) | (r5 << 32)), Size.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (((long) Float.floatToRawIntBits(r2)) & 4294967295L)), MenuKt.ClosedAlphaTarget, r26, null, 0, 832, null);
    }

    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3012drawDeterminateCircularIndicator42QJj7c(DrawScope r0, float r1, float r2, long r3, Stroke r5) {
        m3010drawCircularIndicator42QJj7c(r0, r1, r2, r3, r5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m3002CircularProgressIndicatoraMcp0Q(Modifier r20, long r21, float r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(947193756);
        int r2 = r26 & 1;
        if (r2 == 0) goto L6;
        int r4 = r25 | 6;
        Modifier r3 = r20;
    L14:
        if ((r25 & 48) == 0) goto L16;
        long r6 = r21;
    L24:
        int r8 = r26 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        float r9 = r23;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L67;
        r1.startDefaults();
        if ((r25 & 1) != 0) goto L44;
    L52:
        if (r2 == 0) goto L54;
        Modifier r5 = Modifier.Companion;
    L56:
        if ((r26 & 2) == 0) goto L58;
        r6 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r1, 6);
        r4 = r4 & (-113);
    L58:
        if (r8 != 0) goto L59;
    L50:
        float r17 = r9;
    L51:
        long r18 = r6;
        int r7 = r4;
        long r11 = r18;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(947193756, r7, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:740)");
    L63:
        ProgressIndicatorDefaults r0 = ProgressIndicatorDefaults.INSTANCE;
        long r12 = r0.getCircularTrackColor(r1, 6);
        int r13 = r0.m2990getCircularIndeterminateStrokeCapKaPHkGw();
        int r15 = (((r7 & 14) | 24576) | (r7 & 112)) | (r7 & 896);
        m2996CircularProgressIndicator4lLiAd8(r5, r11, r17, r12, r13, MenuKt.ClosedAlphaTarget, r1, r15, 32);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        r9 = r17;
    L68:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L72;
        final Modifier r16 = r5;
        final long r19 = r11;
        final float r22 = r9;
        r14.updateScope(new ok(r16, r19, r22, r25, r26));
        return;
    L72:
        return;
    L59:
        r17 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
        goto L51
    L54:
        r5 = r3;
        goto L56
    L44:
        if (r1.getDefaultsInvalid() == true) goto L52;
        r1.skipToGroupEnd();
        if ((r26 & 2) == 0) goto L49;
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
        if ((r25 & 384) != 0) goto L34;
        r9 = r23;
        if (r1.changed(r9) == false) goto L32;
        int r110 = 256;
    L33:
        r4 = r4 | r110;
        goto L36
    L32:
        r110 = 128;
        goto L33
    L16:
        if ((r26 & 2) != 0) goto L20;
        r6 = r21;
        if (r1.changed(r6) == false) goto L21;
        int r27 = 32;
    L22:
        r4 = r4 | r27;
    L21:
        r27 = 16;
        goto L22
    L20:
        r6 = r21;
        goto L21
    L6:
        if ((r25 & 6) != 0) goto L12;
        r3 = r20;
        if (r1.changed(r3) == false) goto L10;
        int r28 = 4;
    L11:
        r4 = r28 | r25;
        goto L14
    L10:
        r28 = 2;
        goto L11
    L12:
        r3 = r20;
        r4 = r25;
        goto L14
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m3005LinearProgressIndicatorRIQooxk(Modifier r19, long r20, long r22, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(585576195);
        int r2 = r26 & 1;
        if (r2 == 0) goto L6;
        int r4 = r25 | 6;
        Modifier r3 = r19;
    L14:
        if ((r25 & 48) != 0) goto L22;
        long r7 = r20;
        if ((r26 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L24:
        if ((r25 & 384) != 0) goto L32;
        long r9 = r22;
        if ((r26 & 4) == 0) goto L28;
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
        if ((r25 & 1) != 0) goto L42;
    L51:
        if (r2 == 0) goto L53;
        Modifier r10 = Modifier.Companion;
    L55:
        if ((r26 & 2) == 0) goto L58;
        r7 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r1, 6);
        r4 = r4 & (-113);
    L58:
        if ((r26 & 4) == 0) goto L60;
        r9 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r1, 6);
        r4 = r4 & (-897);
    L60:
        int r11 = r4;
        long r12 = r7;
        long r17 = r9;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(585576195, r11, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:391)");
    L63:
        int r13 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
        int r15 = (((r11 & 14) | 3072) | (r11 & 112)) | (r11 & 896);
        m3009LinearProgressIndicatorrIrjwxo(r10, r12, r17, r13, MenuKt.ClosedAlphaTarget, r1, r15, 16);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        r9 = r17;
    L68:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L72;
        final Modifier r16 = r10;
        final long r18 = r12;
        final long r21 = r9;
        r14.updateScope(new bk(r16, r18, r21, r25, r26));
        return;
    L72:
        return;
    L53:
        r10 = r3;
        goto L55
    L42:
        if (r1.getDefaultsInvalid() == true) goto L51;
        r1.skipToGroupEnd();
        if ((r26 & 2) == 0) goto L48;
        r4 = r4 & (-113);
    L48:
        if ((r26 & 4) == 0) goto L50;
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
        r9 = r22;
        goto L34
    L18:
        if (r1.changed(r7) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r7 = r20;
        goto L24
    L6:
        if ((r25 & 6) != 0) goto L12;
        r3 = r19;
        if (r1.changed(r3) == false) goto L10;
        int r23 = 4;
    L11:
        r4 = r23 | r25;
        goto L14
    L10:
        r23 = 2;
        goto L11
    L12:
        r3 = r19;
        r4 = r25;
        goto L14
    }

    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    private static final void m3013drawIndeterminateCircularIndicatorhrjfTZI(DrawScope r6, float r7, float r8, float r9, long r10, Stroke r12) {
        if (StrokeCap.equals-impl0(r12.getCap-KaPHkGw(), StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
        float r11 = MenuKt.ClosedAlphaTarget;
    L6:
        m3010drawCircularIndicator42QJj7c(r6, r7 + r11, Math.max(r9, 0.1f), r10, r12);
        return;
    L5:
        r11 = ((r8 / Dp.constructor-impl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f;
        goto L6
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    private static final void m3014drawLinearIndicatorqYKTg0g(DrawScope r25, float r26, float r27, long r28, float r30, int r31) {
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
    L35:
        DrawScope.-CC.drawLine-NGM6Ib0$default(r25, r28, Offset.constructor-impl((Float.floatToRawIntBits(r10) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), Offset.constructor-impl((Float.floatToRawIntBits(r11) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), r30, 0, null, MenuKt.ClosedAlphaTarget, null, 0, 496, null);
        return;
    L17:
        if (r1 > r0) goto L35;
        float r2 = r30 / r3;
        float r5 = r0 - r2;
        if (r10 >= r2) goto L23;
        r10 = r2;
    L23:
        if (r10 <= r5) goto L26;
        r10 = r5;
    L26:
        if (r11 >= r2) goto L29;
        r11 = r2;
    L29:
        if (r11 > r5) goto L33;
        r5 = r11;
    L33:
        if (Math.abs(r27 - r26) <= MenuKt.ClosedAlphaTarget) goto L37;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r25, r28, Offset.constructor-impl((Float.floatToRawIntBits(r10) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), Offset.constructor-impl((Float.floatToRawIntBits(r5) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), r30, r31, null, MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        return;
    L37:
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
    public static final /* synthetic */ void m3001CircularProgressIndicatorMBs18nI(final float r20, Modifier r21, long r22, float r24, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(402841196);
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
        r7 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r1, 6);
        r3 = r3 & (-897);
    L68:
        if (r9 != 0) goto L69;
    L61:
        long r18 = r7;
        final float r8 = r10;
    L70:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventStart(402841196, r3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:723)");
    L73:
        ProgressIndicatorDefaults r0 = ProgressIndicatorDefaults.INSTANCE;
        Modifier r12 = r6;
        long r13 = r18;
        float r14 = r8;
        m2997CircularProgressIndicatorDUhRLBM(r20, r12, r13, r14, r0.getCircularTrackColor(r1, 6), r0.m2989getCircularDeterminateStrokeCapKaPHkGw(), r1, ((((r3 & 14) | 196608) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
    L77:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L81;
        final Modifier r2 = r6;
        final long r16 = r18;
        r15.updateScope(new pk(r20, r2, r16, r8, r26, r27));
        return;
    L81:
        return;
    L69:
        r8 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
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

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final /* synthetic */ void m3003LinearProgressIndicator2cYBFYY(Modifier r21, long r22, long r24, int r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-476865359);
        int r2 = r29 & 1;
        if (r2 == 0) goto L6;
        int r4 = r28 | 6;
        Modifier r3 = r21;
    L14:
        if ((r28 & 48) == 0) goto L16;
        long r5 = r22;
    L25:
        if ((r28 & 384) == 0) goto L27;
        long r8 = r24;
    L35:
        int r10 = r29 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        int r11 = r26;
    L47:
        if ((r4 & 1171) == 1170) goto L49;
        boolean r12 = true;
    L51:
        if (r1.shouldExecute(r12, r4 & 1) == false) goto L84;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L55;
    L66:
        if (r2 == 0) goto L68;
        Modifier r6 = Modifier.Companion;
    L70:
        if ((r29 & 2) == 0) goto L73;
        r5 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r1, 6);
        r4 = r4 & (-113);
    L73:
        if ((r29 & 4) == 0) goto L75;
        r8 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r1, 6);
        r4 = r4 & (-897);
    L75:
        if (r10 != 0) goto L76;
    L64:
        int r18 = r11;
    L65:
        long r19 = r8;
        int r9 = r4;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventStart(-476865359, r9, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:219)");
    L80:
        float r14 = ProgressIndicatorDefaults.INSTANCE.m2993getLinearIndicatorTrackGapSizeD9Ej5fM();
        int r16 = ((((r9 & 14) | 24576) | (r9 & 112)) | (r9 & 896)) | (r9 & 7168);
        m3009LinearProgressIndicatorrIrjwxo(r6, r5, r19, r18, r14, r1, r16, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventEnd();
    L83:
        r8 = r19;
        r11 = r18;
    L85:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L89;
        final Modifier r7 = r6;
        final long r15 = r5;
        final long r17 = r8;
        final int r20 = r11;
        r13.updateScope(new jk(r7, r15, r17, r20, r28, r29));
        return;
    L89:
        return;
    L76:
        r18 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
        goto L65
    L68:
        r6 = r3;
        goto L70
    L55:
        if (r1.getDefaultsInvalid() == true) goto L66;
        r1.skipToGroupEnd();
        if ((r29 & 2) == 0) goto L61;
        r4 = r4 & (-113);
    L61:
        if ((r29 & 4) == 0) goto L63;
        r4 = r4 & (-897);
    L63:
        r6 = r3;
        goto L64
    L84:
        r1.skipToGroupEnd();
        r6 = r3;
        goto L85
    L49:
        r12 = false;
        goto L51
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r11 = r26;
        if (r1.changed(r11) == false) goto L43;
        int r110 = 2048;
    L44:
        r4 = r4 | r110;
        goto L47
    L43:
        r110 = 1024;
        goto L44
    L27:
        if ((r29 & 4) != 0) goto L31;
        r8 = r24;
        if (r1.changed(r8) == false) goto L32;
        int r111 = 256;
    L33:
        r4 = r4 | r111;
    L32:
        r111 = 128;
        goto L33
    L31:
        r8 = r24;
        goto L32
    L16:
        if ((r29 & 2) != 0) goto L20;
        r5 = r22;
        if (r1.changed(r5) == false) goto L21;
        int r23 = 32;
    L22:
        r4 = r4 | r23;
    L21:
        r23 = 16;
        goto L22
    L20:
        r5 = r22;
        goto L21
    L6:
        if ((r28 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r25 = 4;
    L11:
        r4 = r25 | r28;
        goto L14
    L10:
        r25 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r28;
        goto L14
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m3008LinearProgressIndicatoreaDK9VM(final float r20, Modifier r21, long r22, long r24, Composer r26, final int r27, final int r28) {
        Composer r1 = r26.startRestartGroup(-372717133);
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
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L79;
        r1.startDefaults();
        if ((r27 & 1) != 0) goto L53;
    L62:
        if (r4 == 0) goto L64;
        Modifier r11 = Modifier.Companion;
    L66:
        if ((r28 & 4) == 0) goto L69;
        r8 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r1, 6);
        r3 = r3 & (-897);
    L69:
        if ((r28 & 8) == 0) goto L71;
        r3 = r3 & (-7169);
        long r18 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r1, 6);
        long r12 = r8;
    L72:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-372717133, r3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:376)");
    L75:
        Modifier r13 = r11;
        long r14 = r12;
        long r15 = r18;
        m3006LinearProgressIndicator_5eSRE(r20, r13, r14, r15, ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw(), r1, ((((r3 & 14) | 24576) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventEnd();
    L78:
        r8 = r12;
        final long r16 = r18;
    L80:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L84;
        final Modifier r2 = r11;
        final long r19 = r8;
        r17.updateScope(new nj(r20, r2, r19, r16, r27, r28));
        return;
    L84:
        return;
    L71:
        r12 = r8;
        r18 = r10;
        goto L72
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
        goto L71
    L79:
        r1.skipToGroupEnd();
        r11 = r5;
        r16 = r10;
        goto L80
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

    private static final Unit LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(int r11, float r12, Function0 r13, long r14, long r16, Function1 r18, DrawScope r19) {
        float r8 = Float.intBitsToFloat((int) (r19.getSize-NH-jbRc() & 4294967295L));
        if (StrokeCap.equals-impl0(r11, StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
    L8:
        float r0 = r12;
    L9:
        float r1 = r0 / r19.toDp-u2uoSUM(Float.intBitsToFloat((int) (r19.getSize-NH-jbRc() >> 32)));
        float r10 = ((Number) r13.invoke()).floatValue();
        float r2 = r10 + Math.min(r10, r1);
        if (r2 > 1.0f) goto L12;
        m3014drawLinearIndicatorqYKTg0g(r19, r2, 1.0f, r14, r8, r11);
    L12:
        m3014drawLinearIndicatorqYKTg0g(r19, MenuKt.ClosedAlphaTarget, r10, r16, r8, r11);
        r18.invoke(r19);
        return Unit.INSTANCE;
    L5:
        if (Float.intBitsToFloat((int) (4294967295L & r19.getSize-NH-jbRc())) > Float.intBitsToFloat((int) (r19.getSize-NH-jbRc() >> 32))) goto L8;
        r0 = Dp.constructor-impl(r19.toDp-u2uoSUM(r8) + r12);
        goto L9
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final /* synthetic */ void m3000CircularProgressIndicatorLxG7B9w(Modifier r22, long r23, float r25, long r26, int r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(-115871647);
        int r2 = r31 & 1;
        if (r2 == 0) goto L6;
        int r4 = r30 | 6;
        Modifier r3 = r22;
    L14:
        if ((r30 & 48) == 0) goto L16;
        long r5 = r23;
    L24:
        int r7 = r31 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        float r9 = r25;
    L36:
        if ((r30 & 3072) == 0) goto L38;
        long r10 = r26;
    L46:
        int r12 = r31 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r13 = r28;
    L58:
        if ((r4 & 9363) == 9362) goto L60;
        boolean r14 = true;
    L62:
        if (r1.shouldExecute(r14, r4 & 1) == false) goto L96;
        r1.startDefaults();
        if ((r30 & 1) != 0) goto L66;
    L76:
        if (r2 == 0) goto L78;
        Modifier r6 = Modifier.Companion;
    L80:
        if ((r31 & 2) == 0) goto L82;
        r5 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r1, 6);
        r4 = r4 & (-113);
    L82:
        if (r7 == 0) goto L85;
        r9 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
    L85:
        if ((r31 & 8) == 0) goto L87;
        r10 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(r1, 6);
        r4 = r4 & (-7169);
    L87:
        if (r12 != 0) goto L88;
    L75:
        int r8 = r4;
        float r11 = r9;
        long r20 = r10;
        int r15 = r13;
    L89:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-115871647, r8, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:594)");
    L92:
        float r16 = ProgressIndicatorDefaults.INSTANCE.m2991getCircularIndicatorTrackGapSizeD9Ej5fM();
        int r18 = (((((r8 & 14) | 196608) | (r8 & 112)) | (r8 & 896)) | (r8 & 7168)) | (r8 & 57344);
        m2996CircularProgressIndicator4lLiAd8(r6, r5, r11, r20, r15, r16, r1, r18, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
    L95:
        final int r17 = r15;
        r10 = r20;
        final float r19 = r11;
    L97:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L101;
        final Modifier r21 = r6;
        final long r24 = r5;
        final long r27 = r10;
        r110.updateScope(new mk(r21, r24, r19, r27, r17, r30, r31));
        return;
    L101:
        return;
    L88:
        r8 = r4;
        r20 = r10;
        r15 = ProgressIndicatorDefaults.INSTANCE.m2990getCircularIndeterminateStrokeCapKaPHkGw();
        r11 = r9;
        goto L89
    L78:
        r6 = r3;
        goto L80
    L66:
        if (r1.getDefaultsInvalid() == true) goto L76;
        r1.skipToGroupEnd();
        if ((r31 & 2) == 0) goto L72;
        r4 = r4 & (-113);
    L72:
        if ((r31 & 8) == 0) goto L74;
        r4 = r4 & (-7169);
    L74:
        r6 = r3;
        goto L75
    L96:
        r1.skipToGroupEnd();
        r6 = r3;
        r19 = r9;
        r17 = r13;
        goto L97
    L60:
        r14 = false;
        goto L62
    L50:
        if ((r30 & 24576) != 0) goto L56;
        r13 = r28;
        if (r1.changed(r13) == false) goto L54;
        int r111 = 16384;
    L55:
        r4 = r4 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L38:
        if ((r31 & 8) != 0) goto L42;
        r10 = r26;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r4 = r4 | r112;
    L43:
        r112 = 1024;
        goto L44
    L42:
        r10 = r26;
        goto L43
    L28:
        if ((r30 & 384) != 0) goto L34;
        r9 = r25;
        if (r1.changed(r9) == false) goto L32;
        int r113 = 256;
    L33:
        r4 = r4 | r113;
        goto L36
    L32:
        r113 = 128;
        goto L33
    L16:
        if ((r31 & 2) != 0) goto L20;
        r5 = r23;
        if (r1.changed(r5) == false) goto L21;
        int r32 = 32;
    L22:
        r4 = r4 | r32;
    L21:
        r32 = 16;
        goto L22
    L20:
        r5 = r23;
        goto L21
    L6:
        if ((r30 & 6) != 0) goto L12;
        r3 = r22;
        if (r1.changed(r3) == false) goto L10;
        int r33 = 4;
    L11:
        r4 = r33 | r30;
        goto L14
    L10:
        r33 = 2;
        goto L11
    L12:
        r3 = r22;
        r4 = r30;
        goto L14
    }

    private static final Unit CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(Function0 r11, int r12, float r13, float r14, long r15, Stroke r17, long r18, DrawScope r20) {
        float r0 = ((Number) r11.invoke()).floatValue() * 360.0f;
        if (StrokeCap.equals-impl0(r12, StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
    L8:
        float r2 = r13;
    L9:
        float r3 = (r2 / ((float) (((double) r20.toDp-u2uoSUM(Float.intBitsToFloat((int) (r20.getSize-NH-jbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        m3010drawCircularIndicator42QJj7c(r20, (270.0f + r0) + Math.min(r0, r3), (360.0f - r0) - (Math.min(r0, r3) * 2), r15, r17);
        m3012drawDeterminateCircularIndicator42QJj7c(r20, 270.0f, r0, r18, r17);
        return Unit.INSTANCE;
    L5:
        if (Float.intBitsToFloat((int) (r20.getSize-NH-jbRc() & 4294967295L)) > Float.intBitsToFloat((int) (r20.getSize-NH-jbRc() >> 32))) goto L8;
        r2 = Dp.constructor-impl(r13 + r14);
        goto L9
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final void m3006LinearProgressIndicator_5eSRE(final float r25, Modifier r26, long r27, long r29, int r31, Composer r32, final int r33, final int r34) {
        Composer r2 = r32.startRestartGroup(905419617);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r5 = r34 & 2;
        if (r5 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r6 = r26;
    L25:
        if ((r33 & 384) != 0) goto L33;
        long r9 = r27;
        if ((r34 & 4) == 0) goto L29;
    L31:
        int r7 = 128;
    L32:
        r3 = r3 | r7;
    L35:
        if ((r33 & 3072) != 0) goto L43;
        long r11 = r29;
        if ((r34 & 8) == 0) goto L39;
    L41:
        int r8 = 1024;
    L42:
        r3 = r3 | r8;
    L44:
        int r10 = r34 & 16;
        if (r10 == 0) goto L48;
        r3 = r3 | 24576;
    L54:
        int r13 = r31;
    L55:
        boolean r16 = false;
        if ((r3 & 9363) == 9362) goto L58;
        boolean r14 = true;
    L60:
        if (r2.shouldExecute(r14, r3 & 1) == false) goto L98;
        r2.startDefaults();
        if ((r33 & 1) != 0) goto L64;
    L73:
        if (r5 == 0) goto L76;
        r6 = Modifier.Companion;
    L76:
        if ((r34 & 4) == 0) goto L79;
        r9 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r2, 6);
        r3 = r3 & (-897);
    L79:
        if ((r34 & 8) == 0) goto L81;
        r11 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r2, 6);
        r3 = r3 & (-7169);
    L81:
        if (r10 != 0) goto L82;
    L72:
        long r21 = r9;
        long r23 = r11;
        int r12 = r13;
    L83:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(905419617, r3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:359)");
    L87:
        if ((r3 & 14) != 4) goto L89;
        r16 = true;
    L89:
        Object r0 = r2.rememberedValue();
        if (r16 == false) goto L92;
    L93:
        r0 = new xj(r25);
        r2.updateRememberedValue(r0);
    L94:
        Modifier r15 = r6;
        long r17 = r21;
        long r18 = r23;
        int r19 = r12;
        m3004LinearProgressIndicatorGJbTh5U((Function0) r0, r15, r17, r18, r19, MenuKt.ClosedAlphaTarget, null, r2, (((r3 & 112) | (r3 & 896)) | (r3 & 7168)) | (r3 & 57344), 96);
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        final int r20 = r12;
        final long r4 = r21;
    L99:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L103;
        final Modifier r22 = r6;
        final long r24 = r23;
        r110.updateScope(new zj(r25, r22, r4, r24, r20, r33, r34));
        return;
    L103:
        return;
    L92:
        if (r0 != Composer.Companion.getEmpty()) goto L94;
    L82:
        r12 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
        r21 = r9;
        r23 = r11;
        goto L83
    L64:
        if (r2.getDefaultsInvalid() == true) goto L73;
        r2.skipToGroupEnd();
        if ((r34 & 4) == 0) goto L70;
        r3 = r3 & (-897);
    L70:
        if ((r34 & 8) == 0) goto L72;
        r3 = r3 & (-7169);
        goto L72
    L98:
        r2.skipToGroupEnd();
        r4 = r9;
        r23 = r11;
        r20 = r13;
        goto L99
    L58:
        r14 = false;
        goto L60
    L48:
        if ((r33 & 24576) != 0) goto L54;
        r13 = r31;
        if (r2.changed(r13) == false) goto L52;
        int r111 = 16384;
    L53:
        r3 = r3 | r111;
        goto L55
    L52:
        r111 = 8192;
        goto L53
    L39:
        if (r2.changed(r11) == false) goto L41;
        r8 = 2048;
        goto L42
    L43:
        r11 = r29;
        goto L44
    L29:
        if (r2.changed(r9) == false) goto L31;
        r7 = 256;
        goto L32
    L33:
        r9 = r27;
        goto L35
    L17:
        if ((r33 & 48) != 0) goto L23;
        r6 = r26;
        if (r2.changed(r6) == false) goto L21;
        int r28 = 32;
    L22:
        r3 = r3 | r28;
        goto L25
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r30 = 4;
    L11:
        r3 = r30 | r33;
        goto L13
    L10:
        r30 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    public static final void m3009LinearProgressIndicatorrIrjwxo(Modifier r29, long r30, long r32, int r34, float r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(567589233);
        int r2 = r38 & 1;
        if (r2 == 0) goto L6;
        int r4 = r37 | 6;
        Modifier r3 = r29;
    L14:
        if ((r37 & 48) != 0) goto L22;
        long r9 = r30;
        if ((r38 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L24:
        if ((r37 & 384) != 0) goto L32;
        long r11 = r32;
        if ((r38 & 4) == 0) goto L28;
    L30:
        int r6 = 128;
    L31:
        r4 = r4 | r6;
    L33:
        int r7 = r38 & 8;
        if (r7 == 0) goto L37;
        r4 = r4 | 3072;
    L43:
        int r14 = r34;
    L44:
        int r15 = r38 & 16;
        if (r15 == 0) goto L48;
        r4 = r4 | 24576;
    L54:
        final float r8 = r35;
    L56:
        if ((r4 & 9363) == 9362) goto L58;
        boolean r10 = true;
    L60:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L122;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L64;
    L73:
        if (r2 == 0) goto L75;
        Modifier r12 = Modifier.Companion;
    L77:
        if ((r38 & 2) == 0) goto L80;
        r9 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r1, 6);
        r4 = r4 & (-113);
    L80:
        if ((r38 & 4) == 0) goto L82;
        r11 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r1, 6);
        r4 = r4 & (-897);
    L82:
        if (r7 == 0) goto L84;
        r14 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
    L84:
        if (r15 == 0) goto L86;
        r8 = ProgressIndicatorDefaults.INSTANCE.m2993getLinearIndicatorTrackGapSizeD9Ej5fM();
    L86:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(567589233, r4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:254)");
    L89:
        InfiniteTransition r13 = InfiniteTransitionKt.rememberInfiniteTransition(null, r1, 0, 1);
        InfiniteRepeatableSpec<Float> r16 = getLinearIndeterminateFirstLineHeadAnimationSpec();
        int r0 = InfiniteTransition.$stable;
        int r18 = InfiniteRepeatableSpec.$stable;
        final State<Float> r17 = InfiniteTransitionKt.animateFloat(r13, MenuKt.ClosedAlphaTarget, 1.0f, r16, null, r1, (r0 | 432) | (r18 << 9), 8);
        final State<Float> r19 = InfiniteTransitionKt.animateFloat(r13, MenuKt.ClosedAlphaTarget, 1.0f, getLinearIndeterminateFirstLineTailAnimationSpec(), null, r1, (r0 | 432) | (r18 << 9), 8);
        final State<Float> r110 = InfiniteTransitionKt.animateFloat(r13, MenuKt.ClosedAlphaTarget, 1.0f, getLinearIndeterminateSecondLineHeadAnimationSpec(), null, r1, (r0 | 432) | (r18 << 9), 8);
        final State<Float> r20 = InfiniteTransitionKt.animateFloat(r13, MenuKt.ClosedAlphaTarget, 1.0f, getLinearIndeterminateSecondLineTailAnimationSpec(), null, r1, (r0 | 432) | (r18 << 9), 8);
        Modifier r210 = r12;
        Modifier r21 = SizeKt.m1016sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(r12.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), LinearIndicatorWidth, LinearIndicatorHeight);
        if ((r4 & 7168) != 2048) goto L92;
        boolean r22 = true;
    L94:
        if ((57344 & r4) != 16384) goto L96;
        boolean r23 = true;
    L97:
        boolean r24 = (r22 | r23) | r1.changed(r17);
        if (((r4 & 896) ^ 384) <= 256) goto L102;
        if (r1.changed(r11) == false) goto L102;
    L103:
        boolean r25 = true;
    L105:
        boolean r26 = (r24 | r25) | r1.changed(r19);
        if (((r4 & 112) ^ 48) <= 32) goto L110;
        if (r1.changed(r9) == false) goto L110;
    L111:
        boolean r111 = true;
    L113:
        boolean r27 = ((r26 | r111) | r1.changed(r110)) | r1.changed(r20);
        Object r28 = r1.rememberedValue();
        if (r27 == false) goto L116;
    L117:
        final int r112 = r14;
        final float r211 = r8;
        final long r212 = r11;
        final long r213 = r9;
        r28 = new vj(r112, r211, r17, r212, r19, r213, r110, r20);
        r1.updateRememberedValue(r28);
    L118:
        CanvasKt.Canvas(r21, (Function1) r28, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        r3 = r210;
    L123:
        final long r31 = r11;
        final int r33 = r14;
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L127;
        final Modifier r39 = r3;
        final long r40 = r9;
        r113.updateScope(new wj(r39, r40, r31, r33, r8, r37, r38));
        return;
    L127:
        return;
    L116:
        if (r28 != Composer.Companion.getEmpty()) goto L118;
    L110:
        if ((r4 & 48) == 32) goto L111;
        r111 = false;
    L102:
        if ((r4 & 384) == 256) goto L103;
        r25 = false;
        goto L105
    L96:
        r23 = false;
        goto L97
    L92:
        r22 = false;
        goto L94
    L75:
        r12 = r3;
        goto L77
    L64:
        if (r1.getDefaultsInvalid() == true) goto L73;
        r1.skipToGroupEnd();
        if ((r38 & 2) == 0) goto L70;
        r4 = r4 & (-113);
    L70:
        if ((r38 & 4) == 0) goto L72;
        r4 = r4 & (-897);
    L72:
        r12 = r3;
        goto L86
    L122:
        r1.skipToGroupEnd();
        goto L123
    L58:
        r10 = false;
        goto L60
    L48:
        if ((r37 & 24576) != 0) goto L54;
        r8 = r35;
        if (r1.changed(r8) == false) goto L52;
        int r114 = 16384;
    L53:
        r4 = r4 | r114;
        goto L56
    L52:
        r114 = 8192;
        goto L53
    L37:
        if ((r37 & 3072) != 0) goto L43;
        r14 = r34;
        if (r1.changed(r14) == false) goto L41;
        int r115 = 2048;
    L42:
        r4 = r4 | r115;
        goto L44
    L41:
        r115 = 1024;
        goto L42
    L28:
        if (r1.changed(r11) == false) goto L30;
        r6 = 256;
        goto L31
    L32:
        r11 = r32;
        goto L33
    L18:
        if (r1.changed(r9) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r9 = r30;
        goto L24
    L6:
        if ((r37 & 6) != 0) goto L12;
        r3 = r29;
        if (r1.changed(r3) == false) goto L10;
        int r41 = 4;
    L11:
        r4 = r41 | r37;
        goto L14
    L10:
        r41 = 2;
        goto L11
    L12:
        r3 = r29;
        r4 = r37;
        goto L14
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final /* synthetic */ void m3007LinearProgressIndicator_5eSRE(final Function0 r23, Modifier r24, long r25, long r27, int r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1796992155);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r24;
    L25:
        if ((r31 & 384) == 0) goto L27;
        long r6 = r25;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        long r9 = r27;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r12 = r29;
    L58:
        if ((r3 & 9363) == 9362) goto L60;
        boolean r13 = true;
    L62:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L94;
        r1.startDefaults();
        if ((r31 & 1) != 0) goto L66;
    L76:
        if (r4 == 0) goto L78;
        Modifier r7 = Modifier.Companion;
    L80:
        if ((r32 & 4) == 0) goto L83;
        r3 = r3 & (-897);
        r6 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r1, 6);
    L83:
        if ((r32 & 8) == 0) goto L85;
        r9 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r1, 6);
        r3 = r3 & (-7169);
    L85:
        if (r11 != 0) goto L86;
    L75:
        long r21 = r9;
        int r8 = r12;
    L87:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventStart(-1796992155, r3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:100)");
    L90:
        Modifier r10 = r7;
        long r14 = r6;
        long r15 = r21;
        int r16 = r8;
        m3004LinearProgressIndicatorGJbTh5U(r23, r10, r14, r15, r16, ProgressIndicatorDefaults.INSTANCE.m2993getLinearIndicatorTrackGapSizeD9Ej5fM(), null, r1, (((((r3 & 14) | 196608) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (r3 & 57344), 64);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
    L93:
        r12 = r8;
        r9 = r21;
    L95:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L99;
        final Modifier r2 = r7;
        final long r18 = r6;
        final long r19 = r9;
        final int r20 = r12;
        r17.updateScope(new ck(r23, r2, r18, r19, r20, r31, r32));
        return;
    L99:
        return;
    L86:
        r8 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
        r21 = r9;
        goto L87
    L78:
        r7 = r5;
        goto L80
    L66:
        if (r1.getDefaultsInvalid() == true) goto L76;
        r1.skipToGroupEnd();
        if ((r32 & 4) == 0) goto L72;
        r3 = r3 & (-897);
    L72:
        if ((r32 & 8) == 0) goto L74;
        r3 = r3 & (-7169);
    L74:
        r7 = r5;
        goto L75
    L94:
        r1.skipToGroupEnd();
        r7 = r5;
        goto L95
    L60:
        r13 = false;
        goto L62
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r12 = r29;
        if (r1.changed(r12) == false) goto L54;
        int r110 = 16384;
    L55:
        r3 = r3 | r110;
        goto L58
    L54:
        r110 = 8192;
        goto L55
    L38:
        if ((r32 & 8) != 0) goto L42;
        r9 = r27;
        if (r1.changed(r9) == false) goto L43;
        int r111 = 2048;
    L44:
        r3 = r3 | r111;
    L43:
        r111 = 1024;
        goto L44
    L42:
        r9 = r27;
        goto L43
    L27:
        if ((r32 & 4) != 0) goto L31;
        r6 = r25;
        if (r1.changed(r6) == false) goto L32;
        int r22 = 256;
    L33:
        r3 = r3 | r22;
    L32:
        r22 = 128;
        goto L33
    L31:
        r6 = r25;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L23;
        r5 = r24;
        if (r1.changed(r5) == false) goto L21;
        int r26 = 32;
    L22:
        r3 = r3 | r26;
        goto L25
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r1.changedInstance(r23) == false) goto L10;
        int r28 = 4;
    L11:
        r3 = r28 | r31;
        goto L13
    L10:
        r28 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-4lLiAd8, reason: not valid java name */
    public static final void m2996CircularProgressIndicator4lLiAd8(Modifier r31, long r32, float r34, long r35, int r37, float r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(333154241);
        int r2 = r41 & 1;
        if (r2 == 0) goto L6;
        int r4 = r40 | 6;
    L14:
        if ((r40 & 48) != 0) goto L22;
        long r7 = r32;
        if ((r41 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L23:
        int r6 = r41 & 4;
        if (r6 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        float r11 = r34;
    L35:
        if ((r40 & 3072) != 0) goto L43;
        long r14 = r35;
        if ((r41 & 8) == 0) goto L39;
    L41:
        int r12 = 1024;
    L42:
        r4 = r4 | r12;
    L44:
        int r13 = r41 & 16;
        if (r13 == 0) goto L48;
        r4 = r4 | 24576;
    L54:
        int r15 = r37;
    L55:
        int r16 = r41 & 32;
        if (r16 == 0) goto L58;
        r4 = r4 | 196608;
        float r10 = r38;
    L66:
        if ((r4 & 74899) == 74898) goto L68;
        boolean r0 = true;
    L70:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L139;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L74;
    L83:
        if (r2 == 0) goto L85;
        Modifier r3 = Modifier.Companion;
    L87:
        if ((r41 & 2) == 0) goto L89;
        r7 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r1, 6);
        r4 = r4 & (-113);
    L89:
        if (r6 == 0) goto L92;
        r11 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
    L92:
        if ((r41 & 8) == 0) goto L94;
        final long r8 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(r1, 6);
        r4 = r4 & (-7169);
    L95:
        if (r13 == 0) goto L97;
        r15 = ProgressIndicatorDefaults.INSTANCE.m2990getCircularIndeterminateStrokeCapKaPHkGw();
    L97:
        if (r16 == 0) goto L99;
        r10 = ProgressIndicatorDefaults.INSTANCE.m2991getCircularIndicatorTrackGapSizeD9Ej5fM();
    L99:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(333154241, r4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:630)");
    L102:
        final Stroke r17 = new Stroke(((Density) r1.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r11), MenuKt.ClosedAlphaTarget, r15, 0, null, 26, null);
        InfiniteTransition r9 = InfiniteTransitionKt.rememberInfiniteTransition(null, r1, 0, 1);
        InfiniteRepeatableSpec<Float> r18 = getCircularIndeterminateGlobalRotationAnimationSpec();
        int r19 = InfiniteTransition.$stable;
        int r20 = InfiniteRepeatableSpec.$stable;
        final State<Float> r110 = InfiniteTransitionKt.animateFloat(r9, MenuKt.ClosedAlphaTarget, 1080.0f, r18, null, r1, (r19 | 432) | (r20 << 9), 8);
        final State<Float> r111 = InfiniteTransitionKt.animateFloat(r9, MenuKt.ClosedAlphaTarget, 360.0f, getCircularIndeterminateRotationAnimationSpec(), null, r1, (r19 | 432) | (r20 << 9), 8);
        final State<Float> r21 = InfiniteTransitionKt.animateFloat(r9, 0.1f, 0.87f, getCircularIndeterminateProgressAnimationSpec(), null, r1, (r19 | 432) | (r20 << 9), 8);
        Modifier r33 = r3;
        Modifier r22 = SizeKt.m1014size3ABfNKs(ProgressSemanticsKt.progressSemantics(r3), CircularIndicatorDiameter);
        boolean r23 = r1.changed(r21);
        if ((r4 & 57344) != 16384) goto L105;
        boolean r24 = true;
    L106:
        boolean r25 = r24 | r23;
        if ((458752 & r4) != 131072) goto L109;
        boolean r26 = true;
    L110:
        boolean r27 = r25 | r26;
        if ((r4 & 896) != 256) goto L113;
        boolean r28 = true;
    L114:
        boolean r29 = ((r27 | r28) | r1.changed(r110)) | r1.changed(r111);
        if (((r4 & 7168) ^ 3072) <= 2048) goto L119;
        if (r1.changed(r8) == false) goto L119;
    L120:
        boolean r30 = true;
    L122:
        boolean r36 = (r29 | r30) | r1.changedInstance(r17);
        if (((r4 & 112) ^ 48) <= 32) goto L127;
        if (r1.changed(r7) == false) goto L127;
    L128:
        boolean r42 = true;
    L130:
        boolean r43 = r36 | r42;
        Object r44 = r1.rememberedValue();
        if (r43 == false) goto L133;
    L134:
        final int r210 = r15;
        final float r211 = r10;
        final float r212 = r11;
        final long r213 = r8;
        final long r214 = r7;
        r44 = new rk(r21, r210, r211, r212, r110, r111, r213, r17, r214);
        r1.updateRememberedValue(r44);
    L135:
        CanvasKt.Canvas(r22, (Function1) r44, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        Modifier r45 = r33;
        final float r46 = r11;
    L140:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L144;
        final Modifier r47 = r45;
        final long r48 = r7;
        final int r49 = r15;
        final float r50 = r10;
        r112.updateScope(new oj(r47, r48, r46, r8, r49, r50, r40, r41));
        return;
    L144:
        return;
    L133:
        if (r44 != Composer.Companion.getEmpty()) goto L135;
    L127:
        if ((r4 & 48) == 32) goto L128;
        r42 = false;
    L119:
        if ((r4 & 3072) == 2048) goto L120;
        r30 = false;
        goto L122
    L113:
        r28 = false;
        goto L114
    L109:
        r26 = false;
        goto L110
    L105:
        r24 = false;
        goto L106
    L94:
        r8 = r14;
        goto L95
    L85:
        r3 = r31;
        goto L87
    L74:
        if (r1.getDefaultsInvalid() == true) goto L83;
        r1.skipToGroupEnd();
        if ((r41 & 2) == 0) goto L80;
        r4 = r4 & (-113);
    L80:
        if ((r41 & 8) == 0) goto L82;
        r4 = r4 & (-7169);
    L82:
        r3 = r31;
        r8 = r14;
        goto L99
    L139:
        r1.skipToGroupEnd();
        r45 = r31;
        r46 = r11;
        r8 = r14;
        goto L140
    L68:
        r0 = false;
        goto L70
    L58:
        r10 = r38;
        if ((r40 & 196608) != 0) goto L66;
        if (r1.changed(r10) == false) goto L63;
        int r113 = 131072;
    L64:
        r4 = r4 | r113;
        goto L66
    L63:
        r113 = 65536;
        goto L64
    L48:
        if ((r40 & 24576) != 0) goto L54;
        r15 = r37;
        if (r1.changed(r15) == false) goto L52;
        int r114 = 16384;
    L53:
        r4 = r4 | r114;
        goto L55
    L52:
        r114 = 8192;
        goto L53
    L39:
        if (r1.changed(r14) == false) goto L41;
        r12 = 2048;
        goto L42
    L43:
        r14 = r35;
        goto L44
    L27:
        if ((r40 & 384) != 0) goto L33;
        r11 = r34;
        if (r1.changed(r11) == false) goto L31;
        int r115 = 256;
    L32:
        r4 = r4 | r115;
        goto L35
    L31:
        r115 = 128;
        goto L32
    L18:
        if (r1.changed(r7) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r7 = r32;
        goto L23
    L6:
        if ((r40 & 6) == 0) goto L8;
        r4 = r40;
        goto L14
    L8:
        if (r1.changed(r31) == false) goto L10;
        int r51 = 4;
    L11:
        r4 = r51 | r40;
        goto L14
    L10:
        r51 = 2;
        goto L11
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m2997CircularProgressIndicatorDUhRLBM(final float r22, Modifier r23, long r24, float r26, long r27, int r29, Composer r30, final int r31, final int r32) {
        Composer r2 = r30.startRestartGroup(-1472321743);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r5 = r32 & 2;
        if (r5 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r6 = r23;
    L25:
        if ((r31 & 384) == 0) goto L27;
        long r7 = r24;
    L35:
        int r10 = r32 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        float r11 = r26;
    L47:
        if ((r31 & 24576) == 0) goto L49;
        long r12 = r27;
    L57:
        int r14 = r32 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r15 = r29;
    L68:
        boolean r17 = false;
        if ((r3 & 74899) == 74898) goto L71;
        boolean r0 = true;
    L73:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L113;
        r2.startDefaults();
        if ((r31 & 1) != 0) goto L77;
    L86:
        if (r5 == 0) goto L89;
        r6 = Modifier.Companion;
    L89:
        if ((r32 & 4) == 0) goto L91;
        r7 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r2, 6);
        r3 = r3 & (-897);
    L91:
        if (r10 == 0) goto L94;
        r11 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
    L94:
        if ((r32 & 16) == 0) goto L96;
        r12 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(r2, 6);
        r3 = r3 & (-57345);
    L96:
        if (r14 != 0) goto L97;
    L85:
        int r13 = r3;
        float r1 = r11;
        long r4 = r12;
        int r8 = r15;
    L98:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(-1472321743, r13, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:705)");
    L102:
        if ((r13 & 14) != 4) goto L104;
        r17 = true;
    L104:
        Object r16 = r2.rememberedValue();
        if (r17 == false) goto L107;
    L108:
        r16 = new pj(r22);
        r2.updateRememberedValue(r16);
    L109:
        int r20 = ((((r13 & 112) | (r13 & 896)) | (r13 & 7168)) | (57344 & r13)) | (r13 & 458752);
        m2999CircularProgressIndicatorIyT6zlY((Function0) r16, r6, r7, r1, r4, r8, MenuKt.ClosedAlphaTarget, r2, r20, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventEnd();
    L112:
        r12 = r4;
        final long r9 = r7;
        final int r18 = r8;
        final float r19 = r1;
    L114:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L118;
        final Modifier r21 = r6;
        final long r25 = r12;
        r110.updateScope(new qj(r22, r21, r9, r19, r25, r18, r31, r32));
        return;
    L118:
        return;
    L107:
        if (r16 != Composer.Companion.getEmpty()) goto L109;
    L97:
        r8 = ProgressIndicatorDefaults.INSTANCE.m2989getCircularDeterminateStrokeCapKaPHkGw();
        r13 = r3;
        r1 = r11;
        r4 = r12;
        goto L98
    L77:
        if (r2.getDefaultsInvalid() == true) goto L86;
        r2.skipToGroupEnd();
        if ((r32 & 4) == 0) goto L83;
        r3 = r3 & (-897);
    L83:
        if ((r32 & 16) == 0) goto L85;
        r3 = r3 & (-57345);
        goto L85
    L113:
        r2.skipToGroupEnd();
        r9 = r7;
        r19 = r11;
        r18 = r15;
        goto L114
    L71:
        r0 = false;
        goto L73
    L61:
        if ((196608 & r31) != 0) goto L67;
        r15 = r29;
        if (r2.changed(r15) == false) goto L65;
        int r111 = 131072;
    L66:
        r3 = r3 | r111;
        goto L68
    L65:
        r111 = 65536;
        goto L66
    L49:
        if ((r32 & 16) != 0) goto L53;
        r12 = r27;
        if (r2.changed(r12) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
    L54:
        r112 = 8192;
        goto L55
    L53:
        r12 = r27;
        goto L54
    L39:
        if ((r31 & 3072) != 0) goto L45;
        r11 = r26;
        if (r2.changed(r11) == false) goto L43;
        int r113 = 2048;
    L44:
        r3 = r3 | r113;
        goto L47
    L43:
        r113 = 1024;
        goto L44
    L27:
        if ((r32 & 4) != 0) goto L31;
        r7 = r24;
        if (r2.changed(r7) == false) goto L32;
        int r114 = 256;
    L33:
        r3 = r3 | r114;
    L32:
        r114 = 128;
        goto L33
    L31:
        r7 = r24;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L23;
        r6 = r23;
        if (r2.changed(r6) == false) goto L21;
        int r28 = 32;
    L22:
        r3 = r3 | r28;
        goto L25
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r2.changed(r22) == false) goto L10;
        int r33 = 4;
    L11:
        r3 = r33 | r31;
        goto L13
    L10:
        r33 = 2;
        goto L11
    }

    private static final Unit LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(int r13, float r14, State r15, long r16, State r18, long r19, State r21, State r22, DrawScope r23) {
        float r8 = Float.intBitsToFloat((int) (r23.getSize-NH-jbRc() & 4294967295L));
        if (StrokeCap.equals-impl0(r13, StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
    L8:
        float r0 = r14;
    L9:
        float r10 = r0 / r23.toDp-u2uoSUM(Float.intBitsToFloat((int) (r23.getSize-NH-jbRc() >> 32)));
        if (((Number) r15.getValue()).floatValue() >= (1.0f - r10)) goto L17;
        if (((Number) r15.getValue()).floatValue() <= MenuKt.ClosedAlphaTarget) goto L14;
        float r1 = ((Number) r15.getValue()).floatValue() + r10;
    L15:
        m3014drawLinearIndicatorqYKTg0g(r23, r1, 1.0f, r16, r8, r13);
        goto L17
    L14:
        r1 = MenuKt.ClosedAlphaTarget;
    L17:
        if ((((Number) r15.getValue()).floatValue() - ((Number) r18.getValue()).floatValue()) <= MenuKt.ClosedAlphaTarget) goto L20;
        m3014drawLinearIndicatorqYKTg0g(r23, ((Number) r15.getValue()).floatValue(), ((Number) r18.getValue()).floatValue(), r19, r8, r13);
    L20:
        if (((Number) r18.getValue()).floatValue() <= r10) goto L31;
        if (((Number) r21.getValue()).floatValue() <= MenuKt.ClosedAlphaTarget) goto L24;
        float r2 = ((Number) r21.getValue()).floatValue() + r10;
    L26:
        if (((Number) r18.getValue()).floatValue() >= 1.0f) goto L28;
        float r3 = ((Number) r18.getValue()).floatValue() - r10;
    L29:
        m3014drawLinearIndicatorqYKTg0g(r23, r2, r3, r16, r8, r13);
        goto L31
    L28:
        r3 = 1.0f;
        goto L29
    L24:
        r2 = MenuKt.ClosedAlphaTarget;
    L31:
        if ((((Number) r21.getValue()).floatValue() - ((Number) r22.getValue()).floatValue()) <= MenuKt.ClosedAlphaTarget) goto L34;
        m3014drawLinearIndicatorqYKTg0g(r23, ((Number) r21.getValue()).floatValue(), ((Number) r22.getValue()).floatValue(), r19, r8, r13);
    L34:
        if (((Number) r22.getValue()).floatValue() <= r10) goto L41;
        if (((Number) r22.getValue()).floatValue() >= 1.0f) goto L38;
        float r4 = ((Number) r22.getValue()).floatValue() - r10;
    L39:
        m3014drawLinearIndicatorqYKTg0g(r23, MenuKt.ClosedAlphaTarget, r4, r16, r8, r13);
        goto L41
    L38:
        r4 = 1.0f;
    L41:
        return Unit.INSTANCE;
    L5:
        if (Float.intBitsToFloat((int) (4294967295L & r23.getSize-NH-jbRc())) > Float.intBitsToFloat((int) (r23.getSize-NH-jbRc() >> 32))) goto L8;
        r0 = Dp.constructor-impl(r23.toDp-u2uoSUM(r8) + r14);
        goto L9
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final /* synthetic */ void m2998CircularProgressIndicatorDUhRLBM(final Function0 r24, Modifier r25, long r26, float r28, long r29, int r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-761680467);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r4 = r34 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r25;
    L25:
        if ((r33 & 384) == 0) goto L27;
        long r6 = r26;
    L35:
        int r8 = r34 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        float r10 = r28;
    L47:
        if ((r33 & 24576) == 0) goto L49;
        long r11 = r29;
    L57:
        int r13 = r34 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r14 = r31;
    L69:
        if ((74899 & r3) == 74898) goto L71;
        boolean r0 = true;
    L73:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L106;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L77;
    L87:
        if (r4 == 0) goto L90;
        r5 = Modifier.Companion;
    L90:
        if ((r34 & 4) == 0) goto L92;
        r6 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r1, 6);
        r3 = r3 & (-897);
    L92:
        if (r8 == 0) goto L95;
        r10 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
    L95:
        if ((r34 & 16) == 0) goto L97;
        r11 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(r1, 6);
        r3 = r3 & (-57345);
    L97:
        if (r13 != 0) goto L98;
    L85:
        float r2 = r10;
        final int r9 = r14;
    L86:
        int r12 = r3;
        long r7 = r11;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(-761680467, r12, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:480)");
    L102:
        float r18 = ProgressIndicatorDefaults.INSTANCE.m2991getCircularIndicatorTrackGapSizeD9Ej5fM();
        int r20 = ((((((r12 & 14) | 1572864) | (r12 & 112)) | (r12 & 896)) | (r12 & 7168)) | (57344 & r12)) | (r12 & 458752);
        m2999CircularProgressIndicatorIyT6zlY(r24, r5, r6, r2, r7, r9, r18, r1, r20, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventEnd();
    L105:
        r10 = r2;
        final long r15 = r6;
        final long r16 = r7;
    L107:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L111;
        final Modifier r19 = r5;
        final float r21 = r10;
        r17.updateScope(new ik(r24, r19, r15, r21, r16, r9, r33, r34));
        return;
    L111:
        return;
    L98:
        r9 = ProgressIndicatorDefaults.INSTANCE.m2989getCircularDeterminateStrokeCapKaPHkGw();
        r2 = r10;
        goto L86
    L77:
        if (r1.getDefaultsInvalid() == true) goto L87;
        r1.skipToGroupEnd();
        if ((r34 & 4) == 0) goto L83;
        r3 = r3 & (-897);
    L83:
        if ((r34 & 16) == 0) goto L85;
        r3 = r3 & (-57345);
        goto L85
    L106:
        r1.skipToGroupEnd();
        r15 = r6;
        r16 = r11;
        r9 = r14;
        goto L107
    L71:
        r0 = false;
        goto L73
    L61:
        if ((196608 & r33) != 0) goto L67;
        r14 = r31;
        if (r1.changed(r14) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L69
    L65:
        r110 = 65536;
        goto L66
    L49:
        if ((r34 & 16) != 0) goto L53;
        r11 = r29;
        if (r1.changed(r11) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
    L54:
        r111 = 8192;
        goto L55
    L53:
        r11 = r29;
        goto L54
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r10 = r28;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L47
    L43:
        r112 = 1024;
        goto L44
    L27:
        if ((r34 & 4) != 0) goto L31;
        r6 = r26;
        if (r1.changed(r6) == false) goto L32;
        int r22 = 256;
    L33:
        r3 = r3 | r22;
    L32:
        r22 = 128;
        goto L33
    L31:
        r6 = r26;
        goto L32
    L17:
        if ((r33 & 48) != 0) goto L23;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r23 = 32;
    L22:
        r3 = r3 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r1.changedInstance(r24) == false) goto L10;
        int r27 = 4;
    L11:
        r3 = r27 | r33;
        goto L13
    L10:
        r27 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    public static final void m2999CircularProgressIndicatorIyT6zlY(final Function0<Float> r33, Modifier r34, long r35, float r37, long r38, int r40, float r41, Composer r42, final int r43, final int r44) {
        Composer r2 = r42.startRestartGroup(-1798883595);
        if ((r44 & 1) == 0) goto L6;
        int r3 = r43 | 6;
    L13:
        int r5 = r44 & 2;
        if (r5 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r43 & 384) != 0) goto L33;
        long r11 = r35;
        if ((r44 & 4) == 0) goto L29;
    L31:
        int r7 = 128;
    L32:
        r3 = r3 | r7;
    L34:
        int r8 = r44 & 8;
        if (r8 == 0) goto L38;
        r3 = r3 | 3072;
    L44:
        float r13 = r37;
    L46:
        if ((r43 & 24576) != 0) goto L54;
        long r9 = r38;
        if ((r44 & 16) == 0) goto L50;
    L52:
        int r16 = 8192;
    L53:
        r3 = r3 | r16;
    L55:
        int r17 = r44 & 32;
        if (r17 == 0) goto L58;
        r3 = r3 | 196608;
        int r15 = r40;
    L65:
        int r18 = r44 & 64;
        if (r18 == 0) goto L68;
        r3 = r3 | 1572864;
        float r14 = r41;
    L76:
        if ((r3 & 599187) == 599186) goto L78;
        boolean r0 = true;
    L80:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L165;
        r2.startDefaults();
        if ((r43 & 1) != 0) goto L84;
    L93:
        if (r5 == 0) goto L95;
        Modifier r1 = Modifier.Companion;
    L97:
        if ((r44 & 4) == 0) goto L99;
        r11 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(r2, 6);
        r3 = r3 & (-897);
    L99:
        if (r8 == 0) goto L101;
        final float r6 = ProgressIndicatorDefaults.INSTANCE.m2992getCircularStrokeWidthD9Ej5fM();
    L103:
        if ((r44 & 16) == 0) goto L105;
        final long r10 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(r2, 6);
        r3 = r3 & (-57345);
    L106:
        if (r17 == 0) goto L108;
        int r4 = ProgressIndicatorDefaults.INSTANCE.m2989getCircularDeterminateStrokeCapKaPHkGw();
    L109:
        if (r18 == 0) goto L111;
        r14 = ProgressIndicatorDefaults.INSTANCE.m2991getCircularIndicatorTrackGapSizeD9Ej5fM();
    L111:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventStart(-1798883595, r3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:526)");
    L115:
        if ((r3 & 14) != 4) goto L117;
        boolean r12 = true;
    L118:
        Object r19 = r2.rememberedValue();
        if (r12 == false) goto L121;
    L122:
        r19 = new rj(r33);
        r2.updateRememberedValue(r19);
    L123:
        final Function0 r20 = (Function0) r19;
        final Stroke r110 = new Stroke(((Density) r2.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r6), MenuKt.ClosedAlphaTarget, r4, 0, null, 26, null);
        boolean r21 = r2.changed(r20);
        Object r111 = r2.rememberedValue();
        if (r21 == false) goto L126;
    L127:
        r111 = new sj(r20);
        r2.updateRememberedValue(r111);
    L128:
        Modifier r22 = SizeKt.m1014size3ABfNKs(SemanticsModifierKt.semantics(r1, true, (Function1) r111), CircularIndicatorDiameter);
        boolean r112 = r2.changed(r20);
        Modifier r113 = r1;
        if ((r3 & 458752) != 131072) goto L131;
        boolean r23 = true;
    L132:
        boolean r24 = r23 | r112;
        if ((3670016 & r3) != 1048576) goto L135;
        boolean r25 = true;
    L136:
        boolean r26 = r24 | r25;
        if ((r3 & 7168) != 2048) goto L139;
        boolean r27 = true;
    L140:
        boolean r28 = r26 | r27;
        if (((57344 & r3) ^ 24576) <= 16384) goto L145;
        if (r2.changed(r10) == false) goto L145;
    L146:
        boolean r29 = true;
    L148:
        boolean r30 = (r28 | r29) | r2.changedInstance(r110);
        if (((r3 & 896) ^ 384) <= 256) goto L153;
        if (r2.changed(r11) == false) goto L153;
    L154:
        boolean r210 = true;
    L156:
        boolean r31 = r30 | r210;
        Object r32 = r2.rememberedValue();
        if (r31 == false) goto L159;
    L160:
        final int r211 = r4;
        final float r212 = r14;
        final float r213 = r6;
        final long r214 = r10;
        final long r36 = r11;
        r32 = new tj(r20, r211, r212, r213, r214, r110, r36);
        r2.updateRememberedValue(r32);
    L161:
        CanvasKt.Canvas(r22, (Function1) r32, r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final int r39 = r4;
        final long r45 = r11;
        final float r46 = r14;
    L166:
        ScopeUpdateScope r114 = r2.endRestartGroup();
        if (r114 == null) goto L170;
        final Modifier r47 = r113;
        r114.updateScope(new uj(r33, r47, r45, r6, r10, r39, r46, r43, r44));
        return;
    L170:
        return;
    L159:
        if (r32 != Composer.Companion.getEmpty()) goto L161;
    L153:
        if ((r3 & 384) == 256) goto L154;
        r210 = false;
    L145:
        if ((r3 & 24576) == 16384) goto L146;
        r29 = false;
        goto L148
    L139:
        r27 = false;
        goto L140
    L135:
        r25 = false;
        goto L136
    L131:
        r23 = false;
        goto L132
    L126:
        if (r111 != Composer.Companion.getEmpty()) goto L128;
    L121:
        if (r19 != Composer.Companion.getEmpty()) goto L123;
    L117:
        r12 = false;
        goto L118
    L108:
        r4 = r15;
        goto L109
    L105:
        r10 = r9;
        goto L106
    L101:
        r6 = r13;
        goto L103
    L95:
        r1 = r34;
        goto L97
    L84:
        if (r2.getDefaultsInvalid() == true) goto L93;
        r2.skipToGroupEnd();
        if ((r44 & 4) == 0) goto L90;
        r3 = r3 & (-897);
    L90:
        if ((r44 & 16) == 0) goto L92;
        r3 = r3 & (-57345);
    L92:
        r1 = r34;
        r10 = r9;
        r6 = r13;
        r4 = r15;
        goto L111
    L165:
        r2.skipToGroupEnd();
        r113 = r34;
        r10 = r9;
        r45 = r11;
        r6 = r13;
        r46 = r14;
        r39 = r15;
        goto L166
    L78:
        r0 = false;
        goto L80
    L68:
        r14 = r41;
        if ((r43 & 1572864) != 0) goto L76;
        if (r2.changed(r14) == false) goto L73;
        int r215 = 1048576;
    L74:
        r3 = r3 | r215;
        goto L76
    L73:
        r215 = 524288;
        goto L74
    L58:
        r15 = r40;
        if ((r43 & 196608) != 0) goto L65;
        if (r2.changed(r15) == false) goto L63;
        int r115 = 131072;
    L64:
        r3 = r3 | r115;
        goto L65
    L63:
        r115 = 65536;
        goto L64
    L50:
        if (r2.changed(r9) == false) goto L52;
        r16 = 16384;
        goto L53
    L54:
        r9 = r38;
        goto L55
    L38:
        if ((r43 & 3072) != 0) goto L44;
        r13 = r37;
        if (r2.changed(r13) == false) goto L42;
        int r116 = 2048;
    L43:
        r3 = r3 | r116;
        goto L46
    L42:
        r116 = 1024;
        goto L43
    L29:
        if (r2.changed(r11) == false) goto L31;
        r7 = 256;
        goto L32
    L33:
        r11 = r35;
        goto L34
    L17:
        if ((r43 & 48) != 0) goto L25;
        if (r2.changed(r34) == false) goto L21;
        int r48 = 32;
    L22:
        r3 = r3 | r48;
        goto L25
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r3 = r43;
        goto L13
    L8:
        if (r2.changedInstance(r33) == false) goto L10;
        int r49 = 4;
    L11:
        r3 = r49 | r43;
        goto L13
    L10:
        r49 = 2;
        goto L11
    }

    private static final Unit CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(State r11, int r12, float r13, float r14, State r15, State r16, long r17, Stroke r19, long r20, DrawScope r22) {
        float r0 = ((Number) r11.getValue()).floatValue() * 360.0f;
        if (StrokeCap.equals-impl0(r12, StrokeCap.Companion.getButt-KaPHkGw()) == false) goto L5;
    L8:
        float r2 = r13;
    L9:
        float r3 = (r2 / ((float) (((double) r22.toDp-u2uoSUM(Float.intBitsToFloat((int) (r22.getSize-NH-jbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        float r4 = ((Number) r15.getValue()).floatValue() + ((Number) r16.getValue()).floatValue();
        long r5 = r22.getCenter-F1C5BW0();
        DrawContext r7 = r22.getDrawContext();
        long r8 = r7.getSize-NH-jbRc();
        r7.getCanvas().save();
        r7.getTransform().rotate-Uv8p0NA(r4, r5);     // Catch: Throwable -> L13
        m3010drawCircularIndicator42QJj7c(r22, Math.min(r0, r3) + r0, (360.0f - r0) - (Math.min(r0, r3) * 2), r17, r19);     // Catch: Throwable -> L13
        m3012drawDeterminateCircularIndicator42QJj7c(r22, MenuKt.ClosedAlphaTarget, r0, r20, r19);     // Catch: Throwable -> L13
        r7.getCanvas().restore();
        r7.setSize-uvyYCjk(r8);
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        r7.getCanvas().restore();
        r7.setSize-uvyYCjk(r8);
        throw th;
    L5:
        if (Float.intBitsToFloat((int) (r22.getSize-NH-jbRc() & 4294967295L)) > Float.intBitsToFloat((int) (r22.getSize-NH-jbRc() >> 32))) goto L8;
        r2 = Dp.constructor-impl(r13 + r14);
        goto L9
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    public static final void m3004LinearProgressIndicatorGJbTh5U(final Function0<Float> r30, Modifier r31, long r32, long r34, int r36, float r37, Function1<? super DrawScope, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r2 = r39.startRestartGroup(-339970038);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r5 = r41 & 2;
        if (r5 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r6 = r31;
    L25:
        if ((r40 & 384) != 0) goto L33;
        final long r11 = r32;
        if ((r41 & 4) == 0) goto L29;
    L31:
        int r7 = 128;
    L32:
        r3 = r3 | r7;
    L35:
        if ((r40 & 3072) != 0) goto L43;
        long r13 = r34;
        if ((r41 & 8) == 0) goto L39;
    L41:
        int r8 = 1024;
    L42:
        r3 = r3 | r8;
    L44:
        int r9 = r41 & 16;
        if (r9 == 0) goto L48;
        r3 = r3 | 24576;
    L54:
        int r10 = r36;
    L55:
        int r16 = r41 & 32;
        if (r16 == 0) goto L58;
        r3 = r3 | 196608;
        float r4 = r37;
    L66:
        if ((r40 & 1572864) != 0) goto L76;
        if ((r41 & 64) == 0) goto L70;
    L72:
        int r20 = 524288;
    L73:
        r3 = r3 | r20;
        goto L76
    L70:
        if (r2.changedInstance(r38) == false) goto L72;
        r20 = 1048576;
    L76:
        if ((r3 & 599187) == 599186) goto L78;
        boolean r12 = true;
    L80:
        if (r2.shouldExecute(r12, r3 & 1) == false) goto L189;
        r2.startDefaults();
        if ((r40 & 1) != 0) goto L84;
    L96:
        if (r5 == 0) goto L98;
        Modifier r14 = Modifier.Companion;
    L100:
        if ((r41 & 4) == 0) goto L103;
        r11 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(r2, 6);
        r3 = r3 & (-897);
    L103:
        if ((r41 & 8) == 0) goto L105;
        r13 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(r2, 6);
        r3 = r3 & (-7169);
    L105:
        if (r9 == 0) goto L107;
        final int r15 = ProgressIndicatorDefaults.INSTANCE.m2994getLinearStrokeCapKaPHkGw();
    L108:
        if (r16 == 0) goto L111;
        r4 = ProgressIndicatorDefaults.INSTANCE.m2993getLinearIndicatorTrackGapSizeD9Ej5fM();
    L111:
        if ((r41 & 64) != 0) goto L113;
        Function1<? super DrawScope, Unit> r17 = r38;
    L131:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventStart(-339970038, r3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:153)");
    L135:
        if ((r3 & 14) != 4) goto L137;
        boolean r18 = true;
    L138:
        Object r19 = r2.rememberedValue();
        if (r18 == false) goto L141;
    L142:
        r19 = new ek(r30);
        r2.updateRememberedValue(r19);
    L143:
        final Function0 r21 = (Function0) r19;
        Modifier r22 = r14.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
        boolean r110 = r2.changed(r21);
        Object r0 = r2.rememberedValue();
        if (r110 == false) goto L146;
    L147:
        r0 = new fk(r21);
        r2.updateRememberedValue(r0);
    L148:
        Modifier r1 = SizeKt.m1016sizeVpY3zN4(SemanticsModifierKt.semantics(r22, true, (Function1) r0), LinearIndicatorWidth, LinearIndicatorHeight);
        if ((57344 & r3) != 16384) goto L151;
        boolean r23 = true;
    L153:
        if ((458752 & r3) != 131072) goto L155;
        boolean r24 = true;
    L156:
        boolean r25 = (r24 | r23) | r2.changed(r21);
        if (((r3 & 7168) ^ 3072) <= 2048) goto L161;
        if (r2.changed(r13) == false) goto L161;
    L162:
        boolean r26 = true;
    L164:
        boolean r27 = r25 | r26;
        if (((r3 & 896) ^ 384) <= 256) goto L169;
        if (r2.changed(r11) == false) goto L169;
    L170:
        boolean r28 = true;
    L172:
        boolean r29 = r27 | r28;
        if (((3670016 & r3) ^ 1572864) <= 1048576) goto L177;
        if (r2.changed(r17) == false) goto L177;
    L178:
        boolean r111 = true;
    L180:
        boolean r33 = r29 | r111;
        Object r35 = r2.rememberedValue();
        if (r33 == false) goto L183;
    L184:
        final int r210 = r15;
        final float r211 = r4;
        final long r212 = r13;
        final long r213 = r11;
        final Function1<? super DrawScope, Unit> r214 = r17;
        r35 = new gk(r210, r211, r21, r212, r213, r214);
        r2.updateRememberedValue(r35);
    L185:
        CanvasKt.Canvas(r1, (Function1) r35, r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L188;
        ComposerKt.traceEventEnd();
    L188:
        final float r42 = r4;
        final Function1<? super DrawScope, Unit> r43 = r17;
        final long r44 = r11;
        final int r45 = r15;
    L190:
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L194;
        final Modifier r46 = r14;
        final long r47 = r13;
        r112.updateScope(new hk(r30, r46, r44, r47, r45, r42, r43, r40, r41));
        return;
    L194:
        return;
    L183:
        if (r35 != Composer.Companion.getEmpty()) goto L185;
    L177:
        if ((r3 & 1572864) == 1048576) goto L178;
        r111 = false;
    L169:
        if ((r3 & 384) == 256) goto L170;
        r28 = false;
    L161:
        if ((r3 & 3072) == 2048) goto L162;
        r26 = false;
        goto L164
    L155:
        r24 = false;
        goto L156
    L151:
        r23 = false;
        goto L153
    L146:
        if (r0 != Composer.Companion.getEmpty()) goto L148;
    L141:
        if (r19 != Composer.Companion.getEmpty()) goto L143;
    L137:
        r18 = false;
        goto L138
    L113:
        if (((r3 & 896) ^ 384) <= 256) goto L117;
        if (r2.changed(r11) == false) goto L117;
    L118:
        boolean r48 = true;
    L121:
        if ((57344 & r3) != 16384) goto L123;
        boolean r49 = true;
    L124:
        boolean r50 = r48 | r49;
        Object r51 = r2.rememberedValue();
        if (r50 == false) goto L127;
    L128:
        r51 = new dk(r11, r15);
        r2.updateRememberedValue(r51);
    L129:
        r17 = (Function1) r51;
        r3 = r3 & (-3670017);
        goto L131
    L127:
        if (r51 != Composer.Companion.getEmpty()) goto L129;
    L123:
        r49 = false;
    L117:
        if ((r3 & 384) == 256) goto L118;
        r48 = false;
        goto L121
    L107:
        r15 = r10;
        goto L108
    L98:
        r14 = r6;
        goto L100
    L84:
        if (r2.getDefaultsInvalid() == true) goto L96;
        r2.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L90;
        r3 = r3 & (-897);
    L90:
        if ((r41 & 8) == 0) goto L93;
        r3 = r3 & (-7169);
    L93:
        if ((r41 & 64) == 0) goto L95;
        r3 = r3 & (-3670017);
    L95:
        r17 = r38;
        r14 = r6;
        r15 = r10;
        goto L131
    L189:
        r2.skipToGroupEnd();
        r42 = r4;
        r14 = r6;
        r45 = r10;
        r44 = r11;
        r43 = r38;
        goto L190
    L78:
        r12 = false;
        goto L80
    L58:
        r4 = r37;
        if ((r40 & 196608) != 0) goto L66;
        if (r2.changed(r4) == false) goto L63;
        int r113 = 131072;
    L64:
        r3 = r3 | r113;
        goto L66
    L63:
        r113 = 65536;
        goto L64
    L48:
        if ((r40 & 24576) != 0) goto L54;
        r10 = r36;
        if (r2.changed(r10) == false) goto L52;
        int r114 = 16384;
    L53:
        r3 = r3 | r114;
        goto L55
    L52:
        r114 = 8192;
        goto L53
    L39:
        if (r2.changed(r13) == false) goto L41;
        r8 = 2048;
        goto L42
    L43:
        r13 = r34;
        goto L44
    L29:
        if (r2.changed(r11) == false) goto L31;
        r7 = 256;
        goto L32
    L33:
        r11 = r32;
        goto L35
    L17:
        if ((r40 & 48) != 0) goto L23;
        r6 = r31;
        if (r2.changed(r6) == false) goto L21;
        int r52 = 32;
    L22:
        r3 = r3 | r52;
        goto L25
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r2.changedInstance(r30) == false) goto L10;
        int r53 = 4;
    L11:
        r3 = r53 | r40;
        goto L13
    L10:
        r53 = 2;
        goto L11
    }
}
