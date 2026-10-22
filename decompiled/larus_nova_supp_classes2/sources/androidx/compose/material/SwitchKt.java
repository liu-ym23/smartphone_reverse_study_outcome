package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 \"\u0016\u0010\"\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 \"\u0016\u0010$\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 \"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010'\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010(\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010)\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010*\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010-\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010.\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u000e\u0010/\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00061²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "TrackWidth", "Landroidx/compose/ui/unit/Dp;", "getTrackWidth", "()F", "F", "TrackStrokeWidth", "getTrackStrokeWidth", "ThumbDiameter", "getThumbDiameter", "ThumbRippleRadius", "DefaultSwitchPadding", "SwitchWidth", "SwitchHeight", "ThumbPathLength", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "ThumbDefaultElevation", "ThumbPressedElevation", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "material", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float DefaultSwitchPadding = 0.0f;
    private static final float SwitchHeight = 0.0f;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold = 0.0f;
    private static final float SwitchWidth = 0.0f;
    private static final float ThumbDefaultElevation = 0.0f;
    private static final float ThumbDiameter = 0.0f;
    private static final float ThumbPathLength = 0.0f;
    private static final float ThumbPressedElevation = 0.0f;
    private static final float ThumbRippleRadius = 0.0f;
    private static final float TrackStrokeWidth = 0.0f;
    private static final float TrackWidth = 0.0f;

    private static final Unit Switch$lambda$17(boolean r10, Function1 r11, Modifier r12, boolean r13, MutableInteractionSource r14, SwitchColors r15, int r16, int r17, Composer r18, int r19) {
        Switch(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final float Switch$lambda$9$lambda$7(float r1) {
        return r1 * SwitchPositionalThreshold;
    }

    private static final float Switch$lambda$9$lambda$8(float r0) {
        return r0;
    }

    private static final Unit SwitchImpl$lambda$27(BoxScope r9, boolean r10, boolean r11, SwitchColors r12, Function0 r13, InteractionSource r14, int r15, Composer r16, int r17) {
        SwitchImpl(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ IntOffset a(Function0 r0, Density r1) {
        return SwitchImpl$lambda$26$lambda$25(r0, r1);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, boolean r3, MutableInteractionSource r4, SwitchColors r5, int r6, int r7, Composer r8, int r9) {
        return Switch$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(BoxScope r0, boolean r1, boolean r2, SwitchColors r3, Function0 r4, InteractionSource r5, int r6, Composer r7, int r8) {
        return SwitchImpl$lambda$27(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(float r1, DraggableAnchorsConfig r2) {
        return Switch$lambda$9$lambda$6(androidx.compose.material3.MenuKt.ClosedAlphaTarget, r1, r2);
    }

    public static /* synthetic */ Unit e(State r0, DrawScope r1) {
        return SwitchImpl$lambda$22$lambda$21(r0, r1);
    }

    public static /* synthetic */ float f(float r0) {
        return Switch$lambda$9$lambda$7(r0);
    }

    public static /* synthetic */ float g(AnchoredDraggableState r0) {
        return Switch$lambda$16$lambda$15$lambda$14(r0);
    }

    public static /* synthetic */ float h(float r0) {
        return Switch$lambda$9$lambda$8(r0);
    }

    static {
        float r0 = Dp.constructor-impl(34);
        TrackWidth = r0;
        TrackStrokeWidth = Dp.constructor-impl(14);
        float r1 = Dp.constructor-impl(20);
        ThumbDiameter = r1;
        ThumbRippleRadius = Dp.constructor-impl(24);
        DefaultSwitchPadding = Dp.constructor-impl(2);
        SwitchWidth = r0;
        SwitchHeight = r1;
        ThumbPathLength = Dp.constructor-impl(r0 - r1);
        AnimationSpec = new TweenSpec(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.constructor-impl(1);
        ThumbPressedElevation = Dp.constructor-impl(6);
        SwitchVelocityThreshold = Dp.constructor-impl(125);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    private static final Function1<Boolean, Unit> Switch$lambda$10(State<? extends Function1<? super Boolean, Unit>> r0) {
        return (Function1) r0.getValue();
    }

    private static final boolean Switch$lambda$11(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final float Switch$lambda$16$lambda$15$lambda$14(AnchoredDraggableState r0) {
        return r0.requireOffset();
    }

    private static final boolean Switch$lambda$3(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final long SwitchImpl$lambda$20(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final long SwitchImpl$lambda$23(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final long SwitchImpl$lambda$24(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    public static final /* synthetic */ Function1 access$Switch$lambda$10(State r0) {
        return Switch$lambda$10(r0);
    }

    public static final /* synthetic */ boolean access$Switch$lambda$11(State r0) {
        return Switch$lambda$11(r0);
    }

    public static final /* synthetic */ boolean access$Switch$lambda$3(MutableState r0) {
        return Switch$lambda$3(r0);
    }

    private static final void Switch$lambda$4(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final Unit SwitchImpl$lambda$22$lambda$21(State r3, DrawScope r4) {
        m2191drawTrackRPmYEkk(r4, SwitchImpl$lambda$20(r3), r4.toPx-0680j_4(TrackWidth), r4.toPx-0680j_4(TrackStrokeWidth));
        return Unit.INSTANCE;
    }

    private static final IntOffset SwitchImpl$lambda$26$lambda$25(Function0 r4, Density r5) {
        return IntOffset.box-impl(IntOffset.constructor-impl((((long) MathKt.roundToInt(((Number) r4.invoke()).floatValue())) << 32) | (((long) 0) & 4294967295L)));
    }

    public static final /* synthetic */ void access$Switch$lambda$4(MutableState r0, boolean r1) {
        Switch$lambda$4(r0, r1);
    }

    private static final Unit Switch$lambda$9$lambda$6(float r1, float r2, DraggableAnchorsConfig r3) {
        r3.at(Boolean.FALSE, r1);
        r3.at(Boolean.TRUE, r2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    private static final void m2191drawTrackRPmYEkk(DrawScope r16, long r17, float r19, float r20) {
        float r0 = r20 / 2;
        float r1 = Float.intBitsToFloat((int) (r16.getCenter-F1C5BW0() & 4294967295L));
        long r5 = Float.floatToRawIntBits(r0);
        long r6 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r1)) & 4294967295L) | (r5 << 32));
        float r2 = Float.intBitsToFloat((int) (r16.getCenter-F1C5BW0() & 4294967295L));
        long r8 = Float.floatToRawIntBits(r19 - r0);
        DrawScope.-CC.drawLine-NGM6Ib0$default(r16, r17, r6, Offset.constructor-impl((((long) Float.floatToRawIntBits(r2)) & 4294967295L) | (r8 << 32)), r20, StrokeCap.Companion.getRound-KaPHkGw(), null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 480, null);
    }

    private static final void SwitchImpl(final BoxScope r27, final boolean r28, final boolean r29, final SwitchColors r30, final Function0<Float> r31, final InteractionSource r32, Composer r33, final int r34) {
        Composer r15 = r33.startRestartGroup(70908914);
        if ((r34 & 6) == 0) goto L5;
        int r8 = r34;
    L11:
        if ((r34 & 48) != 0) goto L18;
        if (r15.changed(r28) == false) goto L15;
        int r9 = 32;
    L16:
        r8 = r8 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r34 & 384) != 0) goto L25;
        if (r15.changed(r29) == false) goto L22;
        int r10 = 256;
    L23:
        r8 = r8 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r34 & 3072) != 0) goto L32;
        if (r15.changed(r30) == false) goto L29;
        int r11 = 2048;
    L30:
        r8 = r8 | r11;
        goto L32
    L29:
        r11 = 1024;
    L32:
        if ((r34 & 24576) != 0) goto L39;
        if (r15.changedInstance(r31) == false) goto L36;
        int r12 = 16384;
    L37:
        r8 = r8 | r12;
        goto L39
    L36:
        r12 = 8192;
    L39:
        if ((196608 & r34) == 0) goto L41;
    L45:
        int r13 = r8;
        if ((74899 & r13) == 74898) goto L48;
        boolean r14 = true;
    L50:
        if (r15.shouldExecute(r14, r13 & 1) == true) goto L52;
        Composer r0 = r15;
        r0.skipToGroupEnd();
    L93:
        ScopeUpdateScope r16 = r0.endRestartGroup();
        if (r16 == null) goto L97;
        r16.updateScope(new ub(r27, r28, r29, r30, r31, r32, r34));
        return;
    L97:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(70908914, r13, -1, "androidx.compose.material.SwitchImpl (Switch.kt:219)");
    L54:
        Object r1 = r15.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r1 != r17.getEmpty()) goto L57;
        r1 = SnapshotStateKt.mutableStateListOf();
        r15.updateRememberedValue(r1);
    L57:
        SnapshotStateList r2 = (SnapshotStateList) r1;
        if ((458752 & r13) != 131072) goto L60;
        boolean r18 = true;
    L61:
        Object r19 = r15.rememberedValue();
        if (r18 == false) goto L64;
    L65:
        r19 = new SwitchKt$SwitchImpl$1$1(r32, r2, null);
        r15.updateRememberedValue(r19);
    L66:
        EffectsKt.LaunchedEffect(r32, (Function2) r19, r15, (r13 >> 15) & 14);
        if ((!r2.isEmpty()) == false) goto L69;
        float r3 = ThumbPressedElevation;
    L70:
        float r110 = r3;
        int r4 = (((r13 >> 6) & 14) | (r13 & 112)) | ((r13 >> 3) & 896);
        final State<Color> r20 = r30.trackColor(r29, r28, r15, r4);
        Modifier r21 = Modifier.Companion;
        Alignment.Companion r111 = Alignment.Companion;
        Modifier r112 = SizeKt.fillMaxSize$default(r27.align(r21, r111.getCenter()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null);
        boolean r113 = r15.changed(r20);
        Object r114 = r15.rememberedValue();
        if (r113 == false) goto L73;
    L74:
        r114 = new sb(r20);
        r15.updateRememberedValue(r114);
    L75:
        CanvasKt.Canvas(r112, (Function1) r114, r15, 0);
        State<Color> r5 = r30.thumbColor(r29, r28, r15, r4);
        ElevationOverlay r22 = (ElevationOverlay) r15.consume(ElevationOverlayKt.getLocalElevationOverlay());
        float r115 = Dp.constructor-impl(((Dp) r15.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).unbox-impl() + r110);
        if (Color.equals-impl0(SwitchImpl$lambda$23(r5), MaterialTheme.INSTANCE.getColors(r15, 6).m2003getSurface0d7_KjU()) == false) goto L79;
        if (r22 == null) goto L79;
        r15.startReplaceGroup(-674820165);
        Modifier r116 = r21;
        long r23 = r22.mo2030apply7g2Lkgo(SwitchImpl$lambda$23(r5), r115, r15, 0);
        r15.endReplaceGroup();
    L80:
        r0 = r15;
        State<Color> r24 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r23, null, null, null, r15, 0, 14);
        Modifier r6 = r27.align(r116, r111.getCenterStart());
        if ((r13 & 57344) != 16384) goto L83;
        boolean r117 = true;
    L84:
        Object r7 = r0.rememberedValue();
        if (r117 == false) goto L87;
    L88:
        r7 = new tb(r31);
        r0.updateRememberedValue(r7);
    L89:
        SpacerKt.Spacer(BackgroundKt.m341backgroundbw27NRU(ShadowKt.shadow-s4CzXII$default(SizeKt.m1006requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(r6, (Function1) r7), r32, RippleKt.m2139rippleH2RKhps$default(false, ThumbRippleRadius, 0, 4, null)), ThumbDiameter), r110, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 24, null), SwitchImpl$lambda$24(r24), RoundedCornerShapeKt.getCircleShape()), r0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
        goto L93
    L87:
        if (r7 != r17.getEmpty()) goto L89;
    L83:
        r117 = false;
    L79:
        r116 = r21;
        r15.startReplaceGroup(-674731226);
        r15.endReplaceGroup();
        r23 = SwitchImpl$lambda$23(r5);
        goto L80
    L73:
        if (r114 != r17.getEmpty()) goto L75;
    L69:
        r3 = ThumbDefaultElevation;
        goto L70
    L64:
        if (r19 != r17.getEmpty()) goto L66;
    L60:
        r18 = false;
        goto L61
    L48:
        r14 = false;
        goto L50
    L41:
        if (r15.changed(r32) == false) goto L43;
        int r25 = 131072;
    L44:
        r8 = r8 | r25;
        goto L45
    L43:
        r25 = 65536;
        goto L44
    L5:
        if (r15.changed(r27) == false) goto L7;
        int r26 = 4;
    L8:
        r8 = r26 | r34;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    public static final void Switch(final boolean r36, final Function1<? super Boolean, Unit> r37, Modifier r38, boolean r39, MutableInteractionSource r40, SwitchColors r41, Composer r42, final int r43, final int r44) {
        Composer r6 = r42.startRestartGroup(25866825);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r44 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r38;
    L34:
        int r10 = r44 & 8;
        if (r10 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r11 = r39;
    L45:
        int r12 = r44 & 16;
        if (r12 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        MutableInteractionSource r13 = r40;
    L57:
        if ((196608 & r43) == 0) goto L59;
        SwitchColors r14 = r41;
    L68:
        if ((74899 & r1) == 74898) goto L70;
        boolean r2 = true;
    L72:
        if (r6.shouldExecute(r2, r1 & 1) == false) goto L165;
        r6.startDefaults();
        if ((r43 & 1) != 0) goto L76;
    L82:
        if (r3 == 0) goto L84;
        Modifier r5 = Modifier.Companion;
    L85:
        if (r10 == 0) goto L87;
        boolean r7 = true;
    L88:
        if (r12 == 0) goto L90;
        MutableInteractionSource r8 = null;
    L92:
        if ((r44 & 32) == 0) goto L94;
        boolean r18 = r7;
        Modifier r15 = r5;
        MutableInteractionSource r19 = r8;
        SwitchColors r20 = SwitchDefaults.INSTANCE.m2190colorsSQMK_m0(0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 0, 0, 0, r6, 0, 6, 1023);
        int r16 = r1 & (-458753);
    L95:
        r6.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(25866825, r16, -1, "androidx.compose.material.Switch (Switch.kt:99)");
    L98:
        if (r19 != null) goto L103;
        r6.startReplaceGroup(1799821714);
        Object r0 = r6.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L102;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r6.updateRememberedValue(r0);
    L102:
        r6.endReplaceGroup();
        MutableInteractionSource r17 = (MutableInteractionSource) r0;
    L104:
        final float r9 = ((Density) r6.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(ThumbPathLength);
        Object r21 = r6.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r21 != r110.getEmpty()) goto L108;
        r21 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, 0, 2, r15);
        r6.updateRememberedValue(r21);
    L108:
        MutableState r22 = (MutableState) r21;
        final float r23 = ((Density) r6.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(SwitchVelocityThreshold);
        boolean r24 = r6.changed(r9) | r6.changed(r23);
        Object r111 = r6.rememberedValue();
        if (r24 == false) goto L111;
    L112:
        TweenSpec<Float> r26 = AnimationSpec;
        r111 = new AnchoredDraggableState(Boolean.valueOf(r36), AnchoredDraggableKt.DraggableAnchors(new vb(r9)), new wb(), new xb(r23), r26, null, 32, null);
        r6.updateRememberedValue(r111);
    L113:
        final AnchoredDraggableState r112 = (AnchoredDraggableState) r111;
        int r113 = r16 >> 3;
        State r25 = SnapshotStateKt.rememberUpdatedState(r37, r6, r113 & 14);
        int r27 = r16 & 14;
        State r28 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(r36), r6, r27);
        boolean r114 = (r6.changed(r112) | r6.changed(r28)) | r6.changed(r25);
        Object r115 = r6.rememberedValue();
        if (r114 == false) goto L116;
    L117:
        r115 = new SwitchKt$Switch$1$1(r112, r28, r25, r22, null);
        r6.updateRememberedValue(r115);
    L118:
        EffectsKt.LaunchedEffect(r112, (Function2) r115, r6, 0);
        Boolean r29 = Boolean.valueOf(r36);
        Boolean r30 = Boolean.valueOf(Switch$lambda$3(r22));
        if (r27 != 4) goto L121;
        boolean r31 = true;
    L122:
        boolean r32 = r31 | r6.changed(r112);
        Object r33 = r6.rememberedValue();
        if (r32 == false) goto L125;
    L128:
        Object r116 = null;
        r33 = new SwitchKt$Switch$2$1(r36, r112, null);
        r6.updateRememberedValue(r33);
    L129:
        EffectsKt.LaunchedEffect(r29, r30, (Function2) r33, r6, r27);
        if (r6.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L132;
        boolean r210 = true;
    L133:
        if (r37 == null) goto L135;
        Modifier r34 = ToggleableKt.m1297toggleableO2vRcR0(Modifier.Companion, r36, r17, null, r18, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), r37);
    L136:
        if (r37 == null) goto L138;
        Modifier r35 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
    L139:
        Modifier r211 = r15.then(r35).then(r34);
        Orientation r212 = Orientation.Horizontal;
        if (r18 == false) goto L143;
        if (r37 == null) goto L143;
        boolean r213 = true;
    L144:
        Modifier r45 = AnchoredDraggableKt.anchoredDraggable(r211, r112, r212, r213, r210, r17, false);
        Alignment.Companion r46 = Alignment.Companion;
        Modifier r47 = SizeKt.m1008requiredSizeVpY3zN4(PaddingKt.m960padding3ABfNKs(SizeKt.wrapContentSize$default(r45, r46.getCenter(), false, 2, r116), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
        MeasurePolicy r48 = BoxKt.maybeCachedBoxMeasurePolicy(r46.getTopStart(), false);
        Composer r49 = r6;
        int r50 = ComposablesKt.getCurrentCompositeKeyHash(r49, 0);
        CompositionLocalMap r51 = r49.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r49, r47);
        ComposeUiNode.Companion r53 = ComposeUiNode.Companion;
        Function0 r54 = r53.getConstructor();
        if ((r49.getApplier() instanceof Applier) == true) goto L147;
        ComposablesKt.invalidApplier();
    L147:
        r49.startReusableNode();
        if (r49.getInserting() == false) goto L150;
        r49.createNode(r54);
    L151:
        Composer r55 = Updater.constructor-impl(r49);
        Updater.set-impl(r55, r48, r53.getSetMeasurePolicy());
        Updater.set-impl(r55, r51, r53.getSetResolvedCompositionLocals());
        Function2 r56 = r53.getSetCompositeKeyHash();
        if (r55.getInserting() == false) goto L154;
    L155:
        r55.updateRememberedValue(Integer.valueOf(r50));
        r55.apply(Integer.valueOf(r50), r56);
    L156:
        Updater.set-impl(r55, r52, r53.getSetModifier());
        BoxScopeInstance r57 = BoxScopeInstance.INSTANCE;
        boolean r58 = ((Boolean) r112.getTargetValue()).booleanValue();
        boolean r59 = r49.changed(r112);
        Object r60 = r49.rememberedValue();
        if (r59 == false) goto L159;
    L160:
        r60 = new yb(r112);
        r49.updateRememberedValue(r60);
    L161:
        Modifier r61 = r15;
        SwitchImpl(r57, r58, r18, r20, (Function0) r60, r17, r49, ((r113 & 896) | 6) | ((r16 >> 6) & 7168));
        r49.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final Modifier r62 = r61;
        final boolean r63 = r18;
        final MutableInteractionSource r64 = r19;
        final SwitchColors r65 = r20;
    L166:
        ScopeUpdateScope r117 = r49.endRestartGroup();
        if (r117 == null) goto L170;
        r117.updateScope(new zb(r36, r37, r62, r63, r64, r65, r43, r44));
        return;
    L170:
        return;
    L159:
        if (r60 != r110.getEmpty()) goto L161;
    L154:
        if (Intrinsics.areEqual(r55.rememberedValue(), Integer.valueOf(r50)) == true) goto L156;
    L150:
        r49.useNode();
    L143:
        r213 = false;
        goto L144
    L138:
        r35 = Modifier.Companion;
        goto L139
    L135:
        r34 = Modifier.Companion;
        goto L136
    L132:
        r210 = false;
        goto L133
    L125:
        if (r33 == r110.getEmpty()) goto L128;
        r116 = null;
        goto L129
    L121:
        r31 = false;
        goto L122
    L116:
        if (r115 != r110.getEmpty()) goto L118;
    L111:
        if (r111 != r110.getEmpty()) goto L113;
    L103:
        r6.startReplaceGroup(-911773211);
        r6.endReplaceGroup();
        r17 = r19;
        goto L104
    L94:
        r18 = r7;
        r16 = r1;
        r15 = r5;
        r19 = r8;
        r20 = r14;
        goto L95
    L90:
        r8 = r13;
        goto L92
    L87:
        r7 = r11;
        goto L88
    L84:
        r5 = r4;
        goto L85
    L76:
        if (r6.getDefaultsInvalid() == true) goto L82;
        r6.skipToGroupEnd();
        if ((r44 & 32) == 0) goto L81;
        r1 = r1 & (-458753);
    L81:
        r16 = r1;
        r18 = r11;
        r19 = r13;
        r20 = r14;
        r15 = r4;
        goto L95
    L165:
        r49 = r6;
        r49.skipToGroupEnd();
        r62 = r4;
        r63 = r11;
        r64 = r13;
        r65 = r14;
        goto L166
    L70:
        r2 = false;
        goto L72
    L59:
        if ((r44 & 32) != 0) goto L63;
        r14 = r41;
        if (r6.changed(r14) == false) goto L64;
        int r118 = 131072;
    L65:
        r1 = r1 | r118;
    L64:
        r118 = 65536;
        goto L65
    L63:
        r14 = r41;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r13 = r40;
        if (r6.changed(r13) == false) goto L53;
        int r119 = 16384;
    L54:
        r1 = r1 | r119;
        goto L57
    L53:
        r119 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L44;
        r11 = r39;
        if (r6.changed(r11) == false) goto L42;
        int r120 = 2048;
    L43:
        r1 = r1 | r120;
        goto L45
    L42:
        r120 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L33;
        r4 = r38;
        if (r6.changed(r4) == false) goto L31;
        int r121 = 256;
    L32:
        r1 = r1 | r121;
        goto L34
    L31:
        r121 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r6.changedInstance(r37) == false) goto L21;
        int r66 = 32;
    L22:
        r1 = r1 | r66;
        goto L23
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r6.changed(r36) == false) goto L10;
        int r67 = 4;
    L11:
        r1 = r67 | r43;
        goto L14
    L10:
        r67 = 2;
        goto L11
    }
}
