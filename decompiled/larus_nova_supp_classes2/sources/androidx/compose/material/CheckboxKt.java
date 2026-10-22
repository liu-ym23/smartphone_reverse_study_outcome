package androidx.compose.material;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001aO\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010!\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u00065²\u0006\n\u00106\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxDefaultPadding", "CheckboxSize", "StrokeWidth", "RadiusSize", "material", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding = 0.0f;
    private static final float CheckboxRippleRadius = 0.0f;
    private static final float CheckboxSize = 0.0f;
    private static final float RadiusSize = 0.0f;
    private static final float StrokeWidth = 0.0f;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ToggleableState.values().length];
            r0[ToggleableState.On.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToggleableState.Off.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToggleableState.Indeterminate.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit Checkbox$lambda$2(boolean r10, Function1 r11, Modifier r12, boolean r13, MutableInteractionSource r14, CheckboxColors r15, int r16, int r17, Composer r18, int r19) {
        Checkbox(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit CheckboxImpl$lambda$14(boolean r6, ToggleableState r7, Modifier r8, CheckboxColors r9, int r10, Composer r11, int r12) {
        CheckboxImpl(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TriStateCheckbox$lambda$3(ToggleableState r10, Function0 r11, Modifier r12, boolean r13, MutableInteractionSource r14, CheckboxColors r15, int r16, int r17, Composer r18, int r19) {
        TriStateCheckbox(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ToggleableState r0, Function0 r1, Modifier r2, boolean r3, MutableInteractionSource r4, CheckboxColors r5, int r6, int r7, Composer r8, int r9) {
        return TriStateCheckbox$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, boolean r3, MutableInteractionSource r4, CheckboxColors r5, int r6, int r7, Composer r8, int r9) {
        return Checkbox$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(boolean r0, ToggleableState r1, Modifier r2, CheckboxColors r3, int r4, Composer r5, int r6) {
        return CheckboxImpl$lambda$14(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit d(CheckDrawingCache r0, State r1, State r2, State r3, State r4, State r5, DrawScope r6) {
        return CheckboxImpl$lambda$13$lambda$12(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit e(Function1 r0, boolean r1) {
        return Checkbox$lambda$1$lambda$0(r0, r1);
    }

    static {
        CheckboxRippleRadius = Dp.constructor-impl(24);
        float r0 = 2;
        CheckboxDefaultPadding = Dp.constructor-impl(r0);
        CheckboxSize = Dp.constructor-impl(20);
        StrokeWidth = Dp.constructor-impl(r0);
        RadiusSize = Dp.constructor-impl(r0);
    }

    private static final long CheckboxImpl$lambda$10(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final long CheckboxImpl$lambda$11(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final float CheckboxImpl$lambda$5(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float CheckboxImpl$lambda$7(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final long CheckboxImpl$lambda$9(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final Unit Checkbox$lambda$1$lambda$0(Function1 r0, boolean r1) {
        r0.invoke(Boolean.valueOf(!r1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m1980drawBox1wkBAMs(DrawScope r34, long r35, long r37, float r39, float r40) {
        float r8 = r40 / 2.0f;
        Stroke r18 = new Stroke(r40, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null);
        float r0 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32));
        if (Color.equals-impl0(r35, r37) == false) goto L5;
        long r5 = Float.floatToRawIntBits(r0);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r34, r35, 0, Size.constructor-impl((((long) Float.floatToRawIntBits(r0)) & 4294967295L) | (r5 << 32)), CornerRadius.constructor-impl((Float.floatToRawIntBits(r39) << 32) | (((long) Float.floatToRawIntBits(r39)) & 4294967295L)), Fill.INSTANCE, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 226, null);
        return;
    L5:
        long r22 = Offset.constructor-impl((Float.floatToRawIntBits(r40) << 32) | (((long) Float.floatToRawIntBits(r40)) & 4294967295L));
        float r1 = r0 - (2 * r40);
        long r24 = Size.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r1)) & 4294967295L));
        float r2 = Math.max(androidx.compose.material3.MenuKt.ClosedAlphaTarget, r39 - r40);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r34, r35, r22, r24, CornerRadius.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (((long) Float.floatToRawIntBits(r2)) & 4294967295L)), Fill.INSTANCE, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 224, null);
        long r12 = Offset.constructor-impl((Float.floatToRawIntBits(r8) << 32) | (((long) Float.floatToRawIntBits(r8)) & 4294967295L));
        float r3 = r0 - r40;
        long r6 = Float.floatToRawIntBits(r3);
        long r14 = Size.constructor-impl((((long) Float.floatToRawIntBits(r3)) & 4294967295L) | (r6 << 32));
        float r4 = r39 - r8;
        long r7 = Float.floatToRawIntBits(r4);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r34, r37, r12, r14, CornerRadius.constructor-impl((((long) Float.floatToRawIntBits(r4)) & 4294967295L) | (r7 << 32)), r18, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 224, null);
    }

    private static final void CheckboxImpl(final boolean r35, final ToggleableState r36, final Modifier r37, final CheckboxColors r38, Composer r39, final int r40) {
        Composer r14 = r39.startRestartGroup(-2118895727);
        if ((r40 & 6) == 0) goto L5;
        int r6 = r40;
    L11:
        if ((r40 & 48) != 0) goto L18;
        if (r14.changed(r36.ordinal()) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r40 & 384) != 0) goto L25;
        if (r14.changed(r37) == false) goto L22;
        int r8 = 256;
    L23:
        r6 = r6 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r40 & 3072) == 0) goto L27;
    L31:
        int r13 = r6;
        if ((r13 & 1171) == 1170) goto L34;
        boolean r9 = true;
    L36:
        if (r14.shouldExecute(r9, r13 & 1) == true) goto L38;
        r14.skipToGroupEnd();
    L115:
        ScopeUpdateScope r10 = r14.endRestartGroup();
        if (r10 == null) goto L119;
        r10.updateScope(new t2(r35, r36, r37, r38, r40));
        return;
    L119:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-2118895727, r13, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:256)");
    L40:
        int r0 = r13 >> 3;
        int r11 = r0 & 14;
        Transition r16 = TransitionKt.updateTransition(r36, null, r14, r11, 2);
        CheckboxKt$CheckboxImpl$checkDrawFraction$2 r12 = CheckboxKt$CheckboxImpl$checkDrawFraction$2.INSTANCE;
        FloatCompanionObject r18 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r19 = VectorConvertersKt.getVectorConverter(r18);
        ToggleableState r15 = (ToggleableState) r16.getCurrentState();
        r14.startReplaceGroup(-1798345588);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
    L43:
        int[] r20 = WhenMappings.$EnumSwitchMapping$0;
        int r17 = r20[r15.ordinal()];
        float r22 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        if (r17 != 1) goto L46;
    L52:
        float r21 = 1.0f;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventEnd();
    L56:
        r14.endReplaceGroup();
        Float r23 = Float.valueOf(r21);
        ToggleableState r110 = (ToggleableState) r16.getTargetState();
        r14.startReplaceGroup(-1798345588);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
    L59:
        int r24 = r20[r110.ordinal()];
        if (r24 != 1) goto L62;
    L68:
        float r25 = 1.0f;
    L70:
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        r14.endReplaceGroup();
        final State r111 = TransitionKt.createTransitionAnimation(r16, r23, Float.valueOf(r25), (FiniteAnimationSpec) r12.invoke(r16.getSegment(), r14, 0), r19, "FloatAnimation", r14, 0);
        CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 r26 = CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r112 = VectorConvertersKt.getVectorConverter(r18);
        ToggleableState r27 = (ToggleableState) r16.getCurrentState();
        r14.startReplaceGroup(-2098942571);
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        int r28 = -1;
        ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
    L76:
        int r29 = r20[r27.ordinal()];
        if (r29 != 1) goto L79;
    L85:
        int r113 = 3;
        float r30 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
    L89:
        r14.endReplaceGroup();
        Float r31 = Float.valueOf(r30);
        ToggleableState r114 = (ToggleableState) r16.getTargetState();
        r14.startReplaceGroup(-2098942571);
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-2098942571, 0, r28, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
    L92:
        int r32 = r20[r114.ordinal()];
        if (r32 == 1) goto L101;
        if (r32 == 2) goto L101;
        if (r32 != r113) goto L99;
        r22 = 1.0f;
        goto L101
    L99:
        throw new NoWhenBranchMatchedException();
    L101:
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventEnd();
    L103:
        r14.endReplaceGroup();
        final State r33 = TransitionKt.createTransitionAnimation(r16, r31, Float.valueOf(r22), (FiniteAnimationSpec) r26.invoke(r16.getSegment(), r14, 0), r112, "FloatAnimation", r14, 0);
        Object r34 = r14.rememberedValue();
        Composer.Companion r41 = Composer.Companion;
        if (r34 != r41.getEmpty()) goto L106;
        r34 = new CheckDrawingCache(null, null, null, 7, null);
        r14.updateRememberedValue(r34);
    L106:
        final CheckDrawingCache r210 = (CheckDrawingCache) r34;
        final State<Color> r42 = r38.checkmarkColor(r36, r14, r11 | ((r13 >> 6) & 112));
        int r1 = r0 & 896;
        int r2 = r1 | ((r13 & 14) | (r13 & 112));
        final State<Color> r43 = r38.boxColor(r35, r36, r14, r2);
        final State<Color> r3 = r38.borderColor(r35, r36, r14, r2);
        Modifier r115 = SizeKt.m1006requiredSize3ABfNKs(SizeKt.wrapContentSize$default(r37, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
        boolean r116 = (((r14.changed(r43) | r14.changed(r3)) | r14.changed(r42)) | r14.changed(r111)) | r14.changed(r33);
        Object r117 = r14.rememberedValue();
        if (r116 == false) goto L109;
    L110:
        r117 = new s2(r210, r43, r3, r42, r111, r33);
        r14.updateRememberedValue(r117);
    L111:
        CanvasKt.Canvas(r115, (Function1) r117, r14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
        goto L115
    L109:
        if (r117 != r41.getEmpty()) goto L111;
    L79:
        if (r29 == 2) goto L85;
        r113 = 3;
        if (r29 != 3) goto L84;
        r30 = 1.0f;
        goto L87
    L84:
        throw new NoWhenBranchMatchedException();
    L75:
        r28 = -1;
        goto L76
    L62:
        if (r24 == 2) goto L67;
        if (r24 == 3) goto L68;
        throw new NoWhenBranchMatchedException();
    L67:
        r25 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L70
    L46:
        if (r17 == 2) goto L51;
        if (r17 == 3) goto L52;
        throw new NoWhenBranchMatchedException();
    L51:
        r21 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L54
    L34:
        r9 = false;
        goto L36
    L27:
        if (r14.changed(r38) == false) goto L29;
        int r44 = 2048;
    L30:
        r6 = r6 | r44;
        goto L31
    L29:
        r44 = 1024;
        goto L30
    L5:
        if (r14.changed(r35) == false) goto L7;
        int r45 = 4;
    L8:
        r6 = r45 | r40;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m1981drawCheck3IgeMak(DrawScope r11, long r12, float r14, float r15, float r16, CheckDrawingCache r17) {
        Stroke r9 = new Stroke(r16, androidx.compose.material3.MenuKt.ClosedAlphaTarget, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null);
        float r1 = Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() >> 32));
        float r2 = MathHelpersKt.lerp(0.4f, 0.5f, r15);
        float r4 = MathHelpersKt.lerp(0.7f, 0.5f, r15);
        float r5 = MathHelpersKt.lerp(0.5f, 0.5f, r15);
        float r0 = MathHelpersKt.lerp(0.3f, 0.5f, r15);
        r17.getCheckPath().reset();
        r17.getCheckPath().moveTo(0.2f * r1, r5 * r1);
        r17.getCheckPath().lineTo(r2 * r1, r4 * r1);
        r17.getCheckPath().lineTo(0.8f * r1, r1 * r0);
        r17.getPathMeasure().setPath(r17.getCheckPath(), false);
        r17.getPathToDraw().reset();
        r17.getPathMeasure().getSegment(androidx.compose.material3.MenuKt.ClosedAlphaTarget, r17.getPathMeasure().getLength() * r14, r17.getPathToDraw(), true);
        DrawScope.-CC.drawPath-LG529CI$default(r11, r17.getPathToDraw(), r12, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, null, 0, 52, null);
    }

    private static final Unit CheckboxImpl$lambda$13$lambda$12(CheckDrawingCache r9, State r10, State r11, State r12, State r13, State r14, DrawScope r15) {
        float r0 = (float) Math.floor(r15.toPx-0680j_4(StrokeWidth));
        m1980drawBox1wkBAMs(r15, CheckboxImpl$lambda$10(r10), CheckboxImpl$lambda$11(r11), r15.toPx-0680j_4(RadiusSize), r0);
        m1981drawCheck3IgeMak(r15, CheckboxImpl$lambda$9(r12), CheckboxImpl$lambda$5(r13), CheckboxImpl$lambda$7(r14), r0, r9);
        return Unit.INSTANCE;
    }

    public static final void Checkbox(final boolean r29, final Function1<? super Boolean, Unit> r30, Modifier r31, boolean r32, MutableInteractionSource r33, CheckboxColors r34, Composer r35, final int r36, final int r37) {
        Composer r3 = r35.startRestartGroup(-2118660998);
        if ((r37 & 1) == 0) goto L6;
        int r4 = r36 | 6;
    L14:
        if ((r37 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r6 = r37 & 4;
        if (r6 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r8 = r31;
    L34:
        int r9 = r37 & 8;
        if (r9 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        boolean r10 = r32;
    L45:
        int r11 = r37 & 16;
        if (r11 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        MutableInteractionSource r12 = r33;
    L57:
        if ((196608 & r36) == 0) goto L59;
        CheckboxColors r13 = r34;
    L67:
        boolean r22 = false;
        if ((74899 & r4) == 74898) goto L70;
        boolean r14 = true;
    L72:
        if (r3.shouldExecute(r14, r4 & 1) == false) goto L118;
        r3.startDefaults();
        if ((r36 & 1) != 0) goto L76;
    L83:
        if (r6 == 0) goto L85;
        Modifier r7 = Modifier.Companion;
    L86:
        if (r9 == 0) goto L88;
        boolean r26 = true;
    L89:
        if (r11 == 0) goto L91;
        MutableInteractionSource r27 = null;
    L93:
        if ((r37 & 32) != 0) goto L94;
    L82:
        int r5 = 32;
        int r15 = r4;
        CheckboxColors r16 = r13;
    L95:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(-2118660998, r15, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
    L98:
        ToggleableState r0 = ToggleableStateKt.ToggleableState(r29);
        if (r30 == null) goto L113;
        r3.startReplaceGroup(1809984331);
        if ((r15 & 112) != r5) goto L103;
        boolean r17 = true;
    L105:
        if ((r15 & 14) != 4) goto L107;
        r22 = true;
    L107:
        boolean r18 = r17 | r22;
        Object r19 = r3.rememberedValue();
        if (r18 == false) goto L110;
    L111:
        r19 = new q2(r30, r29);
        r3.updateRememberedValue(r19);
    L112:
        Function0 r20 = (Function0) r19;
        r3.endReplaceGroup();
    L114:
        TriStateCheckbox(r0, r20, r7, r26, r27, r16, r3, (((r15 & 896) | (r15 & 7168)) | (57344 & r15)) | (r15 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r8 = r7;
        final MutableInteractionSource r21 = r27;
        final CheckboxColors r23 = r16;
        final boolean r24 = r26;
    L119:
        ScopeUpdateScope r25 = r3.endRestartGroup();
        if (r25 == null) goto L123;
        final Modifier r28 = r8;
        r25.updateScope(new r2(r29, r30, r28, r24, r21, r23, r36, r37));
        return;
    L123:
        return;
    L110:
        if (r19 != Composer.Companion.getEmpty()) goto L112;
    L103:
        r17 = false;
        goto L105
    L113:
        r3.startReplaceGroup(1810049027);
        r3.endReplaceGroup();
        r20 = null;
        goto L114
    L94:
        r5 = 32;
        r15 = r4 & (-458753);
        r16 = CheckboxDefaults.INSTANCE.m1979colorszjMxDiM(0, 0, 0, 0, 0, r3, 196608, 31);
        goto L95
    L91:
        r27 = r12;
        goto L93
    L88:
        r26 = r10;
        goto L89
    L85:
        r7 = r8;
        goto L86
    L76:
        if (r3.getDefaultsInvalid() == true) goto L83;
        r3.skipToGroupEnd();
        if ((r37 & 32) == 0) goto L81;
        r4 = r4 & (-458753);
    L81:
        r7 = r8;
        r26 = r10;
        r27 = r12;
        goto L82
    L118:
        r3.skipToGroupEnd();
        r24 = r10;
        r21 = r12;
        r23 = r13;
        goto L119
    L70:
        r14 = false;
        goto L72
    L59:
        if ((r37 & 32) != 0) goto L63;
        r13 = r34;
        if (r3.changed(r13) == false) goto L64;
        int r110 = 131072;
    L65:
        r4 = r4 | r110;
    L64:
        r110 = 65536;
        goto L65
    L63:
        r13 = r34;
        goto L64
    L49:
        if ((r36 & 24576) != 0) goto L55;
        r12 = r33;
        if (r3.changed(r12) == false) goto L53;
        int r111 = 16384;
    L54:
        r4 = r4 | r111;
        goto L57
    L53:
        r111 = 8192;
        goto L54
    L38:
        if ((r36 & 3072) != 0) goto L44;
        r10 = r32;
        if (r3.changed(r10) == false) goto L42;
        int r112 = 2048;
    L43:
        r4 = r4 | r112;
        goto L45
    L42:
        r112 = 1024;
        goto L43
    L27:
        if ((r36 & 384) != 0) goto L33;
        r8 = r31;
        if (r3.changed(r8) == false) goto L31;
        int r38 = 256;
    L32:
        r4 = r4 | r38;
        goto L34
    L31:
        r38 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        if (r3.changedInstance(r30) == false) goto L21;
        int r39 = 32;
    L22:
        r4 = r4 | r39;
        goto L23
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r3.changed(r29) == false) goto L10;
        int r40 = 4;
    L11:
        r4 = r40 | r36;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }

    public static final void TriStateCheckbox(final ToggleableState r24, final Function0<Unit> r25, Modifier r26, boolean r27, MutableInteractionSource r28, CheckboxColors r29, Composer r30, final int r31, final int r32) {
        Composer r6 = r30.startRestartGroup(2031255194);
        if ((r32 & 1) == 0) goto L6;
        int r1 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r32 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        final Modifier r3 = r26;
    L34:
        int r4 = r32 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r27;
    L45:
        int r9 = r32 & 16;
        if (r9 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        MutableInteractionSource r10 = r28;
    L57:
        if ((196608 & r31) == 0) goto L59;
        CheckboxColors r11 = r29;
    L68:
        if ((74899 & r1) == 74898) goto L70;
        boolean r12 = true;
    L72:
        if (r6.shouldExecute(r12, r1 & 1) == false) goto L108;
        r6.startDefaults();
        if ((r31 & 1) != 0) goto L76;
    L83:
        if (r2 == 0) goto L85;
        Modifier r7 = Modifier.Companion;
    L86:
        if (r4 == 0) goto L88;
        r5 = true;
    L88:
        if (r9 == 0) goto L90;
        MutableInteractionSource r8 = null;
    L92:
        if ((r32 & 32) == 0) goto L94;
        CheckboxColors r13 = CheckboxDefaults.INSTANCE.m1979colorszjMxDiM(0, 0, 0, 0, 0, r6, 196608, 31);
        int r14 = r1 & (-458753);
        Modifier r15 = r7;
        MutableInteractionSource r16 = r8;
        CheckboxColors r17 = r13;
    L82:
        boolean r18 = r5;
    L95:
        r6.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(2031255194, r14, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
    L98:
        if (r25 == null) goto L100;
        Modifier.Companion r0 = Modifier.Companion;
        int r19 = Role.Companion.getCheckbox-o7Vup1c();
        MutableInteractionSource r20 = r16;
        boolean r21 = r18;
        Modifier r22 = ToggleableKt.m1303triStateToggleableO2vRcR0(r0, r24, r20, RippleKt.m2139rippleH2RKhps$default(false, CheckboxRippleRadius, 0, 4, null), r21, Role.box-impl(r19), r25);
    L101:
        if (r25 == null) goto L103;
        Modifier r23 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
    L104:
        Modifier r33 = PaddingKt.m960padding3ABfNKs(r15.then(r23).then(r22), CheckboxDefaultPadding);
        int r34 = (((r14 >> 9) & 14) | ((r14 << 3) & 112)) | ((r14 >> 6) & 7168);
        CheckboxImpl(r18, r24, r33, r17, r6, r34);
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventEnd();
    L107:
        r3 = r15;
        final boolean r35 = r18;
        final MutableInteractionSource r36 = r16;
        final CheckboxColors r37 = r17;
    L109:
        ScopeUpdateScope r38 = r6.endRestartGroup();
        if (r38 == null) goto L113;
        r38.updateScope(new u2(r24, r25, r3, r35, r36, r37, r31, r32));
        return;
    L113:
        return;
    L103:
        r23 = Modifier.Companion;
        goto L104
    L100:
        r22 = Modifier.Companion;
        goto L101
    L94:
        r14 = r1;
        r15 = r7;
        r18 = r5;
        r17 = r11;
        r16 = r8;
        goto L95
    L90:
        r8 = r10;
        goto L92
    L85:
        r7 = r3;
        goto L86
    L76:
        if (r6.getDefaultsInvalid() == true) goto L83;
        r6.skipToGroupEnd();
        if ((r32 & 32) == 0) goto L81;
        r1 = r1 & (-458753);
    L81:
        r14 = r1;
        r15 = r3;
        r17 = r11;
        r16 = r10;
        goto L82
    L108:
        r6 = r6;
        r6.skipToGroupEnd();
        r35 = r5;
        r36 = r10;
        r37 = r11;
        goto L109
    L70:
        r12 = false;
        goto L72
    L59:
        if ((r32 & 32) != 0) goto L63;
        r11 = r29;
        if (r6.changed(r11) == false) goto L64;
        int r110 = 131072;
    L65:
        r1 = r1 | r110;
    L64:
        r110 = 65536;
        goto L65
    L63:
        r11 = r29;
        goto L64
    L49:
        if ((r31 & 24576) != 0) goto L55;
        r10 = r28;
        if (r6.changed(r10) == false) goto L53;
        int r111 = 16384;
    L54:
        r1 = r1 | r111;
        goto L57
    L53:
        r111 = 8192;
        goto L54
    L38:
        if ((r31 & 3072) != 0) goto L44;
        r5 = r27;
        if (r6.changed(r5) == false) goto L42;
        int r39 = 2048;
    L43:
        r1 = r1 | r39;
        goto L45
    L42:
        r39 = 1024;
        goto L43
    L27:
        if ((r31 & 384) != 0) goto L33;
        r3 = r26;
        if (r6.changed(r3) == false) goto L31;
        int r40 = 256;
    L32:
        r1 = r1 | r40;
        goto L34
    L31:
        r40 = 128;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L23;
        if (r6.changedInstance(r25) == false) goto L21;
        int r41 = 32;
    L22:
        r1 = r1 | r41;
        goto L23
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r1 = r31;
        goto L14
    L8:
        if (r6.changed(r24.ordinal()) == false) goto L10;
        int r42 = 4;
    L11:
        r1 = r42 | r31;
        goto L14
    L10:
        r42 = 2;
        goto L11
    }
}
