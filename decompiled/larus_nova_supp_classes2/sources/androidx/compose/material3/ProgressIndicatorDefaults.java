package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0019¢\u0006\u0004\b6\u00107R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u001f\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u001e\u0010!\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0016R\u001e\u0010'\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00068"}, d2 = {"Landroidx/compose/material3/ProgressIndicatorDefaults;", "", "<init>", "()V", "linearColor", "Landroidx/compose/ui/graphics/Color;", "getLinearColor", "(Landroidx/compose/runtime/Composer;I)J", "circularColor", "getCircularColor", "linearTrackColor", "getLinearTrackColor", "circularTrackColor", "getCircularTrackColor$annotations", "getCircularTrackColor", "circularDeterminateTrackColor", "getCircularDeterminateTrackColor", "circularIndeterminateTrackColor", "getCircularIndeterminateTrackColor", "CircularStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getCircularStrokeWidth-D9Ej5fM", "()F", "F", "LinearStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getLinearStrokeCap-KaPHkGw", "()I", "I", "CircularDeterminateStrokeCap", "getCircularDeterminateStrokeCap-KaPHkGw", "CircularIndeterminateStrokeCap", "getCircularIndeterminateStrokeCap-KaPHkGw", "LinearTrackStopIndicatorSize", "getLinearTrackStopIndicatorSize-D9Ej5fM$annotations", "getLinearTrackStopIndicatorSize-D9Ej5fM", "LinearIndicatorTrackGapSize", "getLinearIndicatorTrackGapSize-D9Ej5fM$annotations", "getLinearIndicatorTrackGapSize-D9Ej5fM", "CircularIndicatorTrackGapSize", "getCircularIndicatorTrackGapSize-D9Ej5fM$annotations", "getCircularIndicatorTrackGapSize-D9Ej5fM", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "drawStopIndicator", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "stopSize", "color", "strokeCap", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorDefaults {
    public static final int $stable = 0;
    private static final int CircularDeterminateStrokeCap = 0;
    private static final int CircularIndeterminateStrokeCap = 0;
    private static final float CircularIndicatorTrackGapSize = 0.0f;
    private static final float CircularStrokeWidth = 0.0f;
    public static final ProgressIndicatorDefaults INSTANCE = null;
    private static final float LinearIndicatorTrackGapSize = 0.0f;
    private static final int LinearStrokeCap = 0;
    private static final float LinearTrackStopIndicatorSize = 0.0f;
    private static final SpringSpec<Float> ProgressAnimationSpec = null;

    private ProgressIndicatorDefaults() {
    }

    /* JADX INFO: renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2985getCircularIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor", replaceWith = @ReplaceWith(expression = "ProgressIndicatorDefaults.circularIndeterminateTrackColor", imports = {}))
    public static /* synthetic */ void getCircularTrackColor$annotations() {
    }

    /* JADX INFO: renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2986getLinearIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2987getLinearTrackStopIndicatorSizeD9Ej5fM$annotations() {
    }

    static {
        INSTANCE = new ProgressIndicatorDefaults();
        CircularProgressIndicatorTokens r0 = CircularProgressIndicatorTokens.INSTANCE;
        CircularStrokeWidth = r0.getTrackThickness-D9Ej5fM();
        StrokeCap.Companion r1 = StrokeCap.Companion;
        LinearStrokeCap = r1.getRound-KaPHkGw();
        CircularDeterminateStrokeCap = r1.getRound-KaPHkGw();
        CircularIndeterminateStrokeCap = r1.getRound-KaPHkGw();
        LinearProgressIndicatorTokens r2 = LinearProgressIndicatorTokens.INSTANCE;
        LinearTrackStopIndicatorSize = r2.getStopSize-D9Ej5fM();
        LinearIndicatorTrackGapSize = r2.getTrackActiveSpace-D9Ej5fM();
        CircularIndicatorTrackGapSize = r0.getTrackActiveSpace-D9Ej5fM();
        ProgressAnimationSpec = new SpringSpec(1.0f, 50.0f, Float.valueOf(0.001f));
    }

    /* JADX INFO: renamed from: getCircularDeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2989getCircularDeterminateStrokeCapKaPHkGw() {
        return CircularDeterminateStrokeCap;
    }

    /* JADX INFO: renamed from: getCircularIndeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2990getCircularIndeterminateStrokeCapKaPHkGw() {
        return CircularIndeterminateStrokeCap;
    }

    /* JADX INFO: renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m2991getCircularIndicatorTrackGapSizeD9Ej5fM() {
        return CircularIndicatorTrackGapSize;
    }

    /* JADX INFO: renamed from: getCircularStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m2992getCircularStrokeWidthD9Ej5fM() {
        return CircularStrokeWidth;
    }

    /* JADX INFO: renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m2993getLinearIndicatorTrackGapSizeD9Ej5fM() {
        return LinearIndicatorTrackGapSize;
    }

    /* JADX INFO: renamed from: getLinearStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m2994getLinearStrokeCapKaPHkGw() {
        return LinearStrokeCap;
    }

    /* JADX INFO: renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m2995getLinearTrackStopIndicatorSizeD9Ej5fM() {
        return LinearTrackStopIndicatorSize;
    }

    public final SpringSpec<Float> getProgressAnimationSpec() {
        return ProgressAnimationSpec;
    }

    public final long getCircularColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1803349725, r5, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:817)");
    L5:
        long r6 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getCircularDeterminateTrackColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2143778381, r5, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:834)");
    L5:
        long r6 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getCircularIndeterminateTrackColor(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1947901123, r4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:838)");
    L5:
        long r5 = Color.Companion.getTransparent-0d7_KjU();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public final long getCircularTrackColor(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-404222247, r4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:830)");
    L5:
        long r5 = Color.Companion.getTransparent-0d7_KjU();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public final long getLinearColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-914312983, r5, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:813)");
    L5:
        long r6 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getLinearTrackColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1677541593, r5, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:821)");
    L5:
        long r6 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: drawStopIndicator-EgI2THU, reason: not valid java name */
    public final void m2988drawStopIndicatorEgI2THU(DrawScope r11, float r12, long r13, int r15) {
        float r8 = Math.min(r11.toPx-0680j_4(r12), Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() & 4294967295L)));
        float r14 = r11.toPx-0680j_4(ProgressIndicatorKt.getStopIndicatorTrailingSpace());
        float r0 = (Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() & 4294967295L)) - r8) / 2;
        if (r0 <= r14) goto L5;
        float r9 = r14;
    L7:
        if (r11.getLayoutDirection() != LayoutDirection.Rtl) goto L14;
        long r1 = r11.getCenter-F1C5BW0();
        DrawContext r16 = r11.getDrawContext();
        long r2 = r16.getSize-NH-jbRc();
        r16.getCanvas().save();
        r16.getTransform().scale-0AR0LA0(-1.0f, 1.0f, r1);     // Catch: Throwable -> L11
        drawStopIndicator_EgI2THU$drawIndicator(r11, r15, r13, r8, r9);     // Catch: Throwable -> L11
        r16.getCanvas().restore();
        r16.setSize-uvyYCjk(r2);
        return;
    L11:
        th = move-exception;
        r16.getCanvas().restore();
        r16.setSize-uvyYCjk(r2);
        throw th;
    L14:
        drawStopIndicator_EgI2THU$drawIndicator(r11, r15, r13, r8, r9);
        return;
    L5:
        r9 = r0;
        goto L7
    }

    private static final void drawStopIndicator_EgI2THU$drawIndicator(DrawScope r18, int r19, long r20, float r22, float r23) {
        if (StrokeCap.equals-impl0(r19, StrokeCap.Companion.getRound-KaPHkGw()) == false) goto L5;
        float r8 = r22 / 2.0f;
        float r0 = (Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() >> 32)) - r8) - r23;
        float r5 = Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() & 4294967295L)) / 2.0f;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r18, r20, r8, Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(r5)))), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        return;
    L5:
        float r1 = (Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() >> 32)) - r22) - r23;
        float r6 = (Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() & 4294967295L)) - r22) / 2.0f;
        DrawScope.-CC.drawRect-n-J9OG0$default(r18, r20, Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r6)) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(r22) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(r22)))), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
    }
}
