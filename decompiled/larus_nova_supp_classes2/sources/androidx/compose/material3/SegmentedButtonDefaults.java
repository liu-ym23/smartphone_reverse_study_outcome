package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u0087\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010(J\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101JA\u00102\u001a\u0002002\u0006\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020006¢\u0006\u0002\b72\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u000200\u0018\u000106¢\u0006\u0002\b7H\u0007¢\u0006\u0002\u00109J\u001f\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u001f¢\u0006\u0004\b>\u0010?R\u0018\u0010\u0016\u001a\u00020\u0005*\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010)\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b*\u0010!R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006@"}, d2 = {"Landroidx/compose/material3/SegmentedButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "baseShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "BorderWidth", "Landroidx/compose/ui/unit/Dp;", "getBorderWidth-D9Ej5fM", "()F", "F", "itemShape", "Landroidx/compose/ui/graphics/Shape;", "index", "", "count", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "IconSize", "getIconSize-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ActiveIcon", "", "(Landroidx/compose/runtime/Composer;I)V", "Icon", "active", "", "activeContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "inactiveContent", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "color", "width", "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonDefaults {
    public static final int $stable = 0;
    private static final float BorderWidth = 0.0f;
    private static final PaddingValues ContentPadding = null;
    public static final SegmentedButtonDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private SegmentedButtonDefaults() {
    }

    private static final Unit ActiveIcon$lambda$1(SegmentedButtonDefaults r0, int r1, Composer r2, int r3) {
        r0.ActiveIcon(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Icon$lambda$2(SegmentedButtonDefaults r7, boolean r8, Function2 r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        r7.Icon(r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SegmentedButtonDefaults r0, boolean r1, Function2 r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return Icon$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit b(SegmentedButtonDefaults r0, int r1, Composer r2, int r3) {
        return ActiveIcon$lambda$1(r0, r1, r2, r3);
    }

    static {
        INSTANCE = new SegmentedButtonDefaults();
        OutlinedSegmentedButtonTokens r0 = OutlinedSegmentedButtonTokens.INSTANCE;
        BorderWidth = r0.getOutlineWidth-D9Ej5fM();
        IconSize = r0.getIconSize-D9Ej5fM();
        ContentPadding = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
    }

    /* JADX INFO: renamed from: getBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m3096getBorderWidthD9Ej5fM() {
        return BorderWidth;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3097getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColors$material3(ColorScheme r38) {
        SegmentedButtonColors r1 = r38.getDefaultSegmentedButtonColorsCached$material3();
        if (r1 != null) goto L6;
        OutlinedSegmentedButtonTokens r25 = OutlinedSegmentedButtonTokens.INSTANCE;
        long r3 = ColorSchemeKt.fromToken(r38, r25.getSelectedContainerColor());
        long r5 = ColorSchemeKt.fromToken(r38, r25.getSelectedLabelTextColor());
        long r7 = ColorSchemeKt.fromToken(r38, r25.getOutlineColor());
        Color.Companion r21 = Color.Companion;
        SegmentedButtonColors r2 = new SegmentedButtonColors(r3, r5, r7, r21.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r38, r25.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(r38, r25.getOutlineColor()), ColorSchemeKt.fromToken(r38, r25.getSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getDisabledLabelTextColor()), r25.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getOutlineColor()), r25.getDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r21.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getDisabledLabelTextColor()), r25.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getOutlineColor()), r25.getDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r38.setDefaultSegmentedButtonColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final void ActiveIcon(Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-1273041460);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r12.shouldExecute(r2, r1 & 1) == true) goto L17;
        r12.skipToGroupEnd();
    L23:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L27;
        r13.updateScope(new in(this, r11));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1273041460, r1, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:614)");
    L19:
        IconKt.m2775Iconww6aTOc(Icons.Filled.INSTANCE.getCheck$material3(), null, SizeKt.m1014size3ABfNKs(Modifier.Companion, IconSize), 0, r12, 48, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r12.changed(this) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r11;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: borderStroke-l07J4OM, reason: not valid java name */
    public final BorderStroke m3094borderStrokel07J4OM(long r1, float r3) {
        return BorderStrokeKt.m369BorderStrokecXLIe8U(r3, r1);
    }

    public final SegmentedButtonColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(679457321, r5, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:494)");
    L5:
        SegmentedButtonColors r6 = getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final CornerBasedShape getBaseShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1264240381, r5, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:578)");
    L5:
        Shape r6 = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), r4, 6);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape r7 = (CornerBasedShape) r6;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r7;
    }

    /* JADX INFO: renamed from: borderStroke-l07J4OM$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m3093borderStrokel07J4OM$default(SegmentedButtonDefaults r0, long r1, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = BorderWidth;
    L6:
        return r0.m3094borderStrokel07J4OM(r1, r3);
    }

    public final void Icon(final boolean r17, Function2<? super Composer, ? super Integer, Unit> r18, Function2<? super Composer, ? super Integer, Unit> r19, Composer r20, final int r21, final int r22) {
        Composer r1 = r20.startRestartGroup(-657462570);
        if ((r22 & 1) == 0) goto L6;
        int r4 = r21 | 6;
    L13:
        int r6 = r22 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Function2<? super Composer, ? super Integer, Unit> r7 = r18;
    L24:
        int r8 = r22 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r9 = r19;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L59;
        if (r6 == 0) goto L43;
        final Function2<? super Composer, ? super Integer, Unit> r15 = ComposableSingletons$SegmentedButtonKt.INSTANCE.getLambda$1863131183$material3();
    L45:
        if (r8 == 0) goto L47;
        Function2<? super Composer, ? super Integer, Unit> r14 = null;
    L49:
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventStart(-657462570, r4, -1, "androidx.compose.material3.SegmentedButtonDefaults.Icon (SegmentedButton.kt:635)");
    L52:
        if (r14 != null) goto L54;
        r1.startReplaceGroup(-1416314439);
        ExitTransition r11 = ExitTransition.Companion.getNone();
        final Function2<? super Composer, ? super Integer, Unit> r3 = r14;
        AnimatedVisibilityKt.AnimatedVisibility(r17, null, EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r1, 6), MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.m164scaleInL8ZKhE(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r1, 6), MenuKt.ClosedAlphaTarget, TransformOriginKt.TransformOrigin(MenuKt.ClosedAlphaTarget, 1.0f))), r11, null, ComposableLambdaKt.rememberComposableLambda(2059591811, true, new AnonymousClass1(r15), r1, 54), r1, (r4 & 14) | 196608, 18);
        r1.endReplaceGroup();
    L56:
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventEnd();
    L58:
        final Function2<? super Composer, ? super Integer, Unit> r5 = r3;
        final Function2<? super Composer, ? super Integer, Unit> r12 = r15;
    L60:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L64;
        r13.updateScope(new hn(this, r17, r12, r5, r21, r22));
        return;
    L64:
        return;
    L54:
        r3 = r14;
        r1.startReplaceGroup(-1415695803);
        CrossfadeKt.Crossfade(Boolean.valueOf(r17), null, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r1, 6), null, ComposableLambdaKt.rememberComposableLambda(-1785818285, true, new AnonymousClass2(r15, r3), r1, 54), r1, (r4 & 14) | 24576, 10);
        r1.endReplaceGroup();
        goto L56
    L47:
        r14 = r9;
        goto L49
    L43:
        r15 = r7;
        goto L45
    L59:
        r1.skipToGroupEnd();
        r12 = r7;
        r5 = r9;
        goto L60
    L38:
        r10 = false;
        goto L40
    L28:
        if ((r21 & 384) != 0) goto L34;
        r9 = r19;
        if (r1.changedInstance(r9) == false) goto L32;
        int r16 = 256;
    L33:
        r4 = r4 | r16;
        goto L36
    L32:
        r16 = 128;
        goto L33
    L17:
        if ((r21 & 48) != 0) goto L23;
        r7 = r18;
        if (r1.changedInstance(r7) == false) goto L21;
        int r23 = 32;
    L22:
        r4 = r4 | r23;
        goto L24
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r21 & 6) == 0) goto L8;
        r4 = r21;
        goto L13
    L8:
        if (r1.changed(r17) == false) goto L10;
        int r24 = 4;
    L11:
        r4 = r24 | r21;
        goto L13
    L10:
        r24 = 2;
        goto L11
    }

    public final Shape itemShape(int r2, int r3, CornerBasedShape r4, Composer r5, int r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = getBaseShape(r5, (r6 >> 9) & 14);
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-942072063, r6, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:594)");
    L9:
        if (r3 != 1) goto L15;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r4;
    L15:
        if (r2 != 0) goto L18;
        Shape r8 = ShapesKt.start$default(r4, null, 1, null);
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r8;
    L18:
        if (r2 != (r3 - 1)) goto L20;
        r8 = ShapesKt.end$default(r4, null, 1, null);
        goto L22
    L20:
        r8 = RectangleShapeKt.getRectangleShape();
        goto L22
    }

    /* JADX INFO: renamed from: colors-XqyqHi0, reason: not valid java name */
    public final SegmentedButtonColors m3095colorsXqyqHi0(long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, Composer r54, int r55, int r56, int r57) {
        if ((r57 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r57 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r57 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r57 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r57 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r57 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r57 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r57 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r57 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r16;
        if ((r57 & 512) == 0) goto L41;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r18;
        if ((r57 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L47:
        if ((r57 & 2048) == 0) goto L49;
        long r23 = Color.Companion.getUnspecified-0d7_KjU();
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(132526205, r55, r56, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:530)");
    L54:
        SegmentedButtonColors r0 = getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r54, 6)).m3079copy2qZNXz8(r1, r3, r5, r7, r9, r11, r13, r17, r19, r21, r110, r23);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventEnd();
    L57:
        return r0;
    L49:
        r23 = r52;
        goto L51
    L45:
        r110 = r50;
        goto L47
    L41:
        r18 = r48;
        goto L42
    L37:
        r16 = r46;
        goto L38
    L33:
        r15 = r44;
        goto L34
    L29:
        r13 = r42;
        goto L31
    L25:
        r11 = r40;
        goto L27
    L21:
        r9 = r38;
        goto L23
    L17:
        r7 = r36;
        goto L19
    L13:
        r5 = r34;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }
}
