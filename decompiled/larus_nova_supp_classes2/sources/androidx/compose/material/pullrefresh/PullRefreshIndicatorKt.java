package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a;\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\"\u000e\u0010 \u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010*\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010+\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010,\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u000e\u0010-\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001500X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"PullRefreshIndicator", "", "refreshing", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "CircularArrowIndicator", "color", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "CrossfadeDurationMs", "", "MaxProgressArc", "IndicatorSize", "Landroidx/compose/ui/unit/Dp;", "F", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "ArcRadius", "StrokeWidth", "ArrowWidth", "ArrowHeight", "Elevation", "MinAlpha", "MaxAlpha", "AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "material", "showElevation", "targetAlpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshIndicatorKt {
    private static final TweenSpec<Float> AlphaTween = null;
    private static final float ArcRadius = 0.0f;
    private static final float ArrowHeight = 0.0f;
    private static final float ArrowWidth = 0.0f;
    private static final int CrossfadeDurationMs = 100;
    private static final float Elevation = 0.0f;
    private static final float IndicatorSize = 0.0f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final RoundedCornerShape SpinnerShape = null;
    private static final float StrokeWidth = 0.0f;

    private static final Unit CircularArrowIndicator_iJQMabo$lambda$15(PullRefreshState r6, long r7, Modifier r9, int r10, Composer r11, int r12) {
        m2250CircularArrowIndicatoriJQMabo(r6, r7, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit PullRefreshIndicator_jB83MbM$lambda$4(boolean r12, PullRefreshState r13, Modifier r14, long r15, long r17, boolean r19, int r20, int r21, Composer r22, int r23) {
        m2251PullRefreshIndicatorjB83MbM(r12, r13, r14, r15, r17, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean a(boolean r0, PullRefreshState r1) {
        return PullRefreshIndicator_jB83MbM$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(PullRefreshState r0, State r1, long r2, Path r4, DrawScope r5) {
        return CircularArrowIndicator_iJQMabo$lambda$14$lambda$13(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ Unit c(PullRefreshState r0, long r1, Modifier r3, int r4, Composer r5, int r6) {
        return CircularArrowIndicator_iJQMabo$lambda$15(r0, r1, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return CircularArrowIndicator_iJQMabo$lambda$11$lambda$10(r0);
    }

    public static /* synthetic */ Unit e(boolean r0, PullRefreshState r1, Modifier r2, long r3, long r5, boolean r7, int r8, int r9, Composer r10, int r11) {
        return PullRefreshIndicator_jB83MbM$lambda$4(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ float f(PullRefreshState r0) {
        return CircularArrowIndicator_iJQMabo$lambda$8$lambda$7(r0);
    }

    static {
        IndicatorSize = Dp.constructor-impl(40);
        SpinnerShape = RoundedCornerShapeKt.getCircleShape();
        ArcRadius = Dp.constructor-impl((float) 7.5d);
        StrokeWidth = Dp.constructor-impl((float) 2.5d);
        ArrowWidth = Dp.constructor-impl(10);
        ArrowHeight = Dp.constructor-impl(5);
        Elevation = Dp.constructor-impl(6);
        AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);
    }

    public static final /* synthetic */ float access$getArcRadius$p() {
        return ArcRadius;
    }

    public static final /* synthetic */ float access$getStrokeWidth$p() {
        return StrokeWidth;
    }

    private static final ArrowValues ArrowValues(float r8) {
        float r1 = Math.min(1.0f, r8) - 0.4f;
        float r3 = MenuKt.ClosedAlphaTarget;
        float r2 = (Math.max(r1, MenuKt.ClosedAlphaTarget) * 5) / 3;
        float r9 = Math.abs(r8) - 1.0f;
        if (r9 < MenuKt.ClosedAlphaTarget) goto L7;
        r3 = r9;
    L7:
        if (r3 <= 2.0f) goto L9;
        r3 = 2.0f;
    L9:
        float r4 = (((0.4f * r2) - 0.25f) + (r3 - (((float) Math.pow(r3, 2)) / 4))) * 0.5f;
        float r5 = 360;
        return new ArrowValues(r4, r4 * r5, ((0.8f * r2) + r4) * r5, Math.min(1.0f, r2));
    }

    private static final Unit CircularArrowIndicator_iJQMabo$lambda$11$lambda$10(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$8$lambda$7(PullRefreshState r1) {
        if (r1.getProgress() >= 1.0f) goto L7;
        return MinAlpha;
    L7:
        return 1.0f;
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$9(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$2(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1$lambda$0(boolean r0, PullRefreshState r1) {
        if (r0 == false) goto L4;
    L7:
        return true;
    L4:
        if (r1.getPosition$material() > 0.5f) goto L7;
        return false;
    }

    /* JADX INFO: renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    private static final void m2250CircularArrowIndicatoriJQMabo(final PullRefreshState r19, final long r20, final Modifier r22, Composer r23, final int r24) {
        Composer r5 = r23.startRestartGroup(-486016981);
        if ((r24 & 6) == 0) goto L5;
        int r1 = r24;
    L11:
        if ((r24 & 48) != 0) goto L18;
        if (r5.changed(r20) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r24 & 384) != 0) goto L25;
        if (r5.changed(r22) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r5.shouldExecute(r4, r1 & 1) == true) goto L31;
        Composer r13 = r5;
        r13.skipToGroupEnd();
    L59:
        ScopeUpdateScope r9 = r13.endRestartGroup();
        if (r9 == null) goto L63;
        r9.updateScope(new d(r19, r20, r22, r24));
        return;
    L63:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-486016981, r1, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:124)");
    L33:
        Object r0 = r5.rememberedValue();
        Composer.Companion r6 = Composer.Companion;
        Object r7 = r0;
        if (r0 != r6.getEmpty()) goto L36;
        Path r8 = AndroidPath_androidKt.Path();
        r8.setFillType-oQ8Xj4U(PathFillType.Companion.getEvenOdd-Rg-k1Os());
        r5.updateRememberedValue(r8);
        r7 = r8;
    L36:
        final Path r10 = (Path) r7;
        boolean r11 = r5.changed(r19);
        Object r12 = r5.rememberedValue();
        if (r11 == false) goto L39;
    L40:
        r12 = SnapshotStateKt.derivedStateOf(new a(r19));
        r5.updateRememberedValue(r12);
    L41:
        final State<Float> r14 = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$9((State) r12), AlphaTween, MenuKt.ClosedAlphaTarget, null, null, r5, 48, 28);
        Object r15 = r5.rememberedValue();
        if (r15 != r6.getEmpty()) goto L44;
        r15 = new b();
        r5.updateRememberedValue(r15);
    L44:
        Modifier r16 = SemanticsModifierKt.semantics$default(r22, false, (Function1) r15, 1, null);
        boolean r17 = r5.changedInstance(r19) | r5.changed(r14);
        if ((r1 & 112) != 32) goto L47;
        boolean r18 = true;
    L48:
        boolean r21 = (r17 | r18) | r5.changedInstance(r10);
        Object r25 = r5.rememberedValue();
        if (r21 == false) goto L51;
    L54:
        int r110 = 0;
        r13 = r5;
        Function1 r111 = new c(r19, r14, r20, r10);
        r13.updateRememberedValue(r111);
        r25 = r111;
    L55:
        CanvasKt.Canvas(r16, (Function1) r25, r13, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L51:
        if (r25 == r6.getEmpty()) goto L54;
        r13 = r5;
        r110 = 0;
        goto L55
    L47:
        r18 = false;
        goto L48
    L39:
        if (r12 != r6.getEmpty()) goto L41;
    L27:
        r4 = false;
        goto L29
    L5:
        if (r5.changedInstance(r19) == false) goto L7;
        int r26 = 4;
    L8:
        r1 = r26 | r24;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    private static final Unit CircularArrowIndicator_iJQMabo$lambda$14$lambda$13(PullRefreshState r29, State r30, long r31, Path r33, DrawScope r34) {
        ArrowValues r17 = ArrowValues(r29.getProgress());
        float r18 = ((Number) r30.getValue()).floatValue();
        float r1 = r17.getRotation();
        long r2 = r34.getCenter-F1C5BW0();
        DrawContext r15 = r34.getDrawContext();
        long r13 = r15.getSize-NH-jbRc();
        r15.getCanvas().save();
        r15.getTransform().rotate-Uv8p0NA(r1, r2);     // Catch: Throwable -> L10
        float r3 = r34.toPx-0680j_4(ArcRadius);     // Catch: Throwable -> L10
        float r4 = StrokeWidth;     // Catch: Throwable -> L10
        float r5 = r3 + (r34.toPx-0680j_4(r4) / 2.0f);     // Catch: Throwable -> L10
        Rect r12 = new Rect(Float.intBitsToFloat((int) (SizeKt.getCenter-uvyYCjk(r34.getSize-NH-jbRc()) >> 32)) - r5, Float.intBitsToFloat((int) (SizeKt.getCenter-uvyYCjk(r34.getSize-NH-jbRc()) & 4294967295L)) - r5, Float.intBitsToFloat((int) (SizeKt.getCenter-uvyYCjk(r34.getSize-NH-jbRc()) >> 32)) + r5, Float.intBitsToFloat((int) (SizeKt.getCenter-uvyYCjk(r34.getSize-NH-jbRc()) & 4294967295L)) + r5);     // Catch: Throwable -> L10
        DrawScope.-CC.drawArc-yD3GUKo$default(r34, r31, r17.getStartAngle(), r17.getEndAngle() - r17.getStartAngle(), false, r12.getTopLeft-F1C5BW0(), r12.getSize-NH-jbRc(), r18, new Stroke(r34.toPx-0680j_4(r4), MenuKt.ClosedAlphaTarget, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null), null, 0, 768, null);     // Catch: Throwable -> L8
        m2253drawArrowBx497Mc(r34, r33, r12, r31, r18, r17);     // Catch: Throwable -> L8
        r15.getCanvas().restore();
        r15.setSize-uvyYCjk(r13);
        return Unit.INSTANCE;
    L8:
        th = th;
        DrawContext r6 = r15;
        long r7 = r13;
    L12:
        r6.getCanvas().restore();
        r6.setSize-uvyYCjk(r7);
        throw th;
    L10:
        th = th;
        r7 = r13;
        r6 = r15;
        goto L12
    }

    /* JADX INFO: renamed from: access$CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final /* synthetic */ void m2252access$CircularArrowIndicatoriJQMabo(PullRefreshState r0, long r1, Modifier r3, Composer r4, int r5) {
        m2250CircularArrowIndicatoriJQMabo(r0, r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    private static final void m2253drawArrowBx497Mc(DrawScope r14, Path r15, Rect r16, long r17, float r19, ArrowValues r20) {
        r15.reset();
        r15.moveTo(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget);
        float r3 = ArrowWidth;
        r15.lineTo(r14.toPx-0680j_4(r3) * r20.getScale(), MenuKt.ClosedAlphaTarget);
        r15.lineTo((r14.toPx-0680j_4(r3) * r20.getScale()) / 2, r14.toPx-0680j_4(ArrowHeight) * r20.getScale());
        float r1 = Math.min(r16.getRight() - r16.getLeft(), r16.getBottom() - r16.getTop()) / 2.0f;
        float r2 = (r1 + Float.intBitsToFloat((int) (r16.getCenter-F1C5BW0() >> 32))) - ((r14.toPx-0680j_4(r3) * r20.getScale()) / 2.0f);
        float r4 = Float.intBitsToFloat((int) (r16.getCenter-F1C5BW0() & 4294967295L)) + (r14.toPx-0680j_4(StrokeWidth) / 2.0f);
        r15.translate-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (Float.floatToRawIntBits(r4) & 4294967295L)));
        r15.close();
        float r5 = r20.getEndAngle();
        long r6 = r14.getCenter-F1C5BW0();
        DrawContext r11 = r14.getDrawContext();
        long r12 = r11.getSize-NH-jbRc();
        r11.getCanvas().save();
        r11.getTransform().rotate-Uv8p0NA(r5, r6);     // Catch: Throwable -> L6
        DrawScope.-CC.drawPath-LG529CI$default(r14, r15, r17, r19, null, null, 0, 56, null);     // Catch: Throwable -> L6
        r11.getCanvas().restore();
        r11.setSize-uvyYCjk(r12);
        return;
    L6:
        th = move-exception;
        r11.getCanvas().restore();
        r11.setSize-uvyYCjk(r12);
        throw th;
    }

    /* JADX INFO: renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m2251PullRefreshIndicatorjB83MbM(final boolean r33, final PullRefreshState r34, Modifier r35, long r36, long r38, boolean r40, Composer r41, final int r42, final int r43) {
        Composer r3 = r41.startRestartGroup(308716636);
        if ((r43 & 1) == 0) goto L6;
        int r4 = r42 | 6;
    L14:
        if ((r43 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r6 = r43 & 4;
        if (r6 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r7 = r35;
    L35:
        if ((r42 & 3072) != 0) goto L43;
        long r10 = r36;
        if ((r43 & 8) == 0) goto L39;
    L41:
        int r8 = 1024;
    L42:
        r4 = r4 | r8;
    L45:
        if ((r42 & 24576) != 0) goto L53;
        long r12 = r38;
        if ((r43 & 16) == 0) goto L49;
    L51:
        int r9 = 8192;
    L52:
        r4 = r4 | r9;
    L54:
        int r11 = r43 & 32;
        if (r11 == 0) goto L58;
        r4 = r4 | 196608;
    L64:
        boolean r14 = r40;
    L66:
        if ((74899 & r4) == 74898) goto L68;
        boolean r5 = true;
    L70:
        if (r3.shouldExecute(r5, r4 & 1) == false) goto L136;
        r3.startDefaults();
        if ((r42 & 1) != 0) goto L74;
    L83:
        if (r6 == 0) goto L85;
        Modifier r13 = Modifier.Companion;
    L87:
        if ((r43 & 8) == 0) goto L89;
        long r15 = MaterialTheme.INSTANCE.getColors(r3, 6).m2003getSurface0d7_KjU();
        r4 = r4 & (-7169);
    L91:
        if ((r43 & 16) == 0) goto L93;
        long r16 = ColorsKt.m2017contentColorForek8zF_U(r15, r3, (r4 >> 9) & 14);
        r4 = r4 & (-57345);
    L94:
        if (r11 == 0) goto L96;
        int r17 = r4;
        long r18 = r16;
        boolean r19 = false;
    L97:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(308716636, r17, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:81)");
    L100:
        int r110 = r17 & 14;
        if (r110 != 4) goto L103;
        boolean r111 = true;
    L104:
        boolean r112 = r111 | r3.changed(r34);
        Object r113 = r3.rememberedValue();
        if (r112 == false) goto L107;
    L108:
        r113 = SnapshotStateKt.derivedStateOf(new e(r33, r34));
        r3.updateRememberedValue(r113);
    L109:
        State r114 = (State) r113;
        ElevationOverlay r115 = (ElevationOverlay) r3.consume(ElevationOverlayKt.getLocalElevationOverlay());
        if (r115 != null) goto L112;
        r3.startReplaceGroup(1453247536);
        r3.endReplaceGroup();
        Color r0 = null;
    L113:
        if (r0 == null) goto L115;
        long r116 = r0.unbox-impl();
        long r117 = r18;
    L116:
        Modifier r21 = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.m1014size3ABfNKs(r13, IndicatorSize), r34, r19);
        if (PullRefreshIndicator_jB83MbM$lambda$2(r114) == false) goto L119;
        float r1 = Elevation;
    L120:
        float r22 = r1;
        RoundedCornerShape r2 = SpinnerShape;
        Modifier r20 = BackgroundKt.m341backgroundbw27NRU(ShadowKt.shadow-s4CzXII$default(r21, r22, r2, true, 0, 0, 24, null), r116, r2);
        MeasurePolicy r23 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r118 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r119 = r3.getCurrentCompositionLocalMap();
        Modifier r24 = ComposedModifierKt.materializeModifier(r3, r20);
        ComposeUiNode.Companion r120 = ComposeUiNode.Companion;
        Function0 r121 = r120.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L123;
        ComposablesKt.invalidApplier();
    L123:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L126;
        r3.createNode(r121);
    L127:
        Composer r122 = Updater.constructor-impl(r3);
        Updater.set-impl(r122, r23, r120.getSetMeasurePolicy());
        Updater.set-impl(r122, r119, r120.getSetResolvedCompositionLocals());
        Function2 r25 = r120.getSetCompositeKeyHash();
        if (r122.getInserting() == false) goto L130;
    L131:
        r122.updateRememberedValue(Integer.valueOf(r118));
        r122.apply(Integer.valueOf(r118), r25);
    L132:
        Updater.set-impl(r122, r24, r120.getSetModifier());
        BoxScopeInstance r26 = BoxScopeInstance.INSTANCE;
        final long r123 = r117;
        CrossfadeKt.Crossfade(Boolean.valueOf(r33), null, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, ComposableLambdaKt.rememberComposableLambda(1853731063, true, new PullRefreshIndicatorKt$PullRefreshIndicator$1$1(r123, r34), r3, 54), r3, r110 | 24960, 10);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
    L135:
        final boolean r27 = r19;
        r12 = r123;
    L137:
        ScopeUpdateScope r124 = r3.endRestartGroup();
        if (r124 == null) goto L141;
        final Modifier r28 = r13;
        final long r29 = r15;
        final long r30 = r12;
        r124.updateScope(new f(r33, r34, r28, r29, r30, r27, r42, r43));
        return;
    L141:
        return;
    L130:
        if (Intrinsics.areEqual(r122.rememberedValue(), Integer.valueOf(r118)) == true) goto L132;
    L126:
        r3.useNode();
        goto L127
    L119:
        r1 = Dp.constructor-impl(0);
        goto L120
    L115:
        r117 = r18;
        r116 = r15;
        goto L116
    L112:
        r3.startReplaceGroup(323973617);
        long r125 = r115.mo2030apply7g2Lkgo(r15, Elevation, r3, ((r17 >> 9) & 14) | 48);
        r3.endReplaceGroup();
        r0 = Color.box-impl(r125);
        goto L113
    L107:
        if (r113 != Composer.Companion.getEmpty()) goto L109;
    L103:
        r111 = false;
        goto L104
    L96:
        r17 = r4;
        r19 = r14;
        r18 = r16;
        goto L97
    L93:
        r16 = r12;
        goto L94
    L89:
        r15 = r10;
        goto L91
    L85:
        r13 = r7;
        goto L87
    L74:
        if (r3.getDefaultsInvalid() == true) goto L83;
        r3.skipToGroupEnd();
        if ((r43 & 8) == 0) goto L80;
        r4 = r4 & (-7169);
    L80:
        if ((r43 & 16) == 0) goto L82;
        r4 = r4 & (-57345);
    L82:
        r17 = r4;
        r13 = r7;
        r15 = r10;
        r19 = r14;
        r18 = r12;
        goto L97
    L136:
        r3.skipToGroupEnd();
        r13 = r7;
        r15 = r10;
        r27 = r14;
        goto L137
    L68:
        r5 = false;
        goto L70
    L58:
        if ((196608 & r42) != 0) goto L64;
        r14 = r40;
        if (r3.changed(r14) == false) goto L62;
        int r126 = 131072;
    L63:
        r4 = r4 | r126;
        goto L66
    L62:
        r126 = 65536;
        goto L63
    L49:
        if (r3.changed(r12) == false) goto L51;
        r9 = 16384;
        goto L52
    L53:
        r12 = r38;
        goto L54
    L39:
        if (r3.changed(r10) == false) goto L41;
        r8 = 2048;
        goto L42
    L43:
        r10 = r36;
        goto L45
    L27:
        if ((r42 & 384) != 0) goto L33;
        r7 = r35;
        if (r3.changed(r7) == false) goto L31;
        int r31 = 256;
    L32:
        r4 = r4 | r31;
        goto L35
    L31:
        r31 = 128;
        goto L32
    L17:
        if ((r42 & 48) != 0) goto L23;
        if (r3.changedInstance(r34) == false) goto L21;
        int r32 = 32;
    L22:
        r4 = r4 | r32;
        goto L23
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r4 = r42;
        goto L14
    L8:
        if (r3.changed(r33) == false) goto L10;
        int r37 = 4;
    L11:
        r4 = r37 | r42;
        goto L14
    L10:
        r37 = 2;
        goto L11
    }
}
