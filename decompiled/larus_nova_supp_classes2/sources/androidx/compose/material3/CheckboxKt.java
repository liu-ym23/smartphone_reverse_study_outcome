package androidx.compose.material3;

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
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding = 0.0f;
    private static final float CheckboxSize = 0.0f;
    private static final float RadiusSize = 0.0f;
    private static final int SnapAnimationDelay = 100;

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

    static {
        float r0 = 2;
        CheckboxDefaultPadding = Dp.constructor-impl(r0);
        CheckboxSize = Dp.constructor-impl(20);
        RadiusSize = Dp.constructor-impl(r0);
    }

    private static final Unit Checkbox$lambda$3(boolean r10, Function1 r11, Modifier r12, boolean r13, CheckboxColors r14, MutableInteractionSource r15, int r16, int r17, Composer r18, int r19) {
        Checkbox(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit Checkbox$lambda$6(boolean r12, Function1 r13, Stroke r14, Stroke r15, Modifier r16, boolean r17, CheckboxColors r18, MutableInteractionSource r19, int r20, int r21, Composer r22, int r23) {
        Checkbox(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit CheckboxImpl$lambda$15(boolean r9, ToggleableState r10, Modifier r11, CheckboxColors r12, Stroke r13, Stroke r14, int r15, Composer r16, int r17) {
        CheckboxImpl(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TriStateCheckbox$lambda$8(ToggleableState r10, Function0 r11, Modifier r12, boolean r13, CheckboxColors r14, MutableInteractionSource r15, int r16, int r17, Composer r18, int r19) {
        TriStateCheckbox(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit TriStateCheckbox$lambda$9(ToggleableState r12, Function0 r13, Stroke r14, Stroke r15, Modifier r16, boolean r17, CheckboxColors r18, MutableInteractionSource r19, int r20, int r21, Composer r22, int r23) {
        TriStateCheckbox(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, Function1 r1, Stroke r2, Stroke r3, Modifier r4, boolean r5, CheckboxColors r6, MutableInteractionSource r7, int r8, int r9, Composer r10, int r11) {
        return Checkbox$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(Function1 r0, boolean r1) {
        return Checkbox$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit c(boolean r0, Function1 r1, Modifier r2, boolean r3, CheckboxColors r4, MutableInteractionSource r5, int r6, int r7, Composer r8, int r9) {
        return Checkbox$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit d(boolean r0, ToggleableState r1, Modifier r2, CheckboxColors r3, Stroke r4, Stroke r5, int r6, Composer r7, int r8) {
        return CheckboxImpl$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit e(State r0, State r1, Stroke r2, State r3, State r4, State r5, Stroke r6, CheckDrawingCache r7, DrawScope r8) {
        return CheckboxImpl$lambda$14$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit f(ToggleableState r0, Function0 r1, Modifier r2, boolean r3, CheckboxColors r4, MutableInteractionSource r5, int r6, int r7, Composer r8, int r9) {
        return TriStateCheckbox$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit g(ToggleableState r0, Function0 r1, Stroke r2, Stroke r3, Modifier r4, boolean r5, CheckboxColors r6, MutableInteractionSource r7, int r8, int r9, Composer r10, int r11) {
        return TriStateCheckbox$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit h(Function1 r0, boolean r1) {
        return Checkbox$lambda$2$lambda$1(r0, r1);
    }

    private static final Unit Checkbox$lambda$2$lambda$1(Function1 r0, boolean r1) {
        r0.invoke(Boolean.valueOf(!r1));
        return Unit.INSTANCE;
    }

    private static final Unit Checkbox$lambda$5$lambda$4(Function1 r0, boolean r1) {
        r0.invoke(Boolean.valueOf(!r1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m2393drawBox1wkBAMs(DrawScope r23, long r24, long r26, float r28, Stroke r29) {
        float r0 = r29.getWidth() / 2.0f;
        float r1 = Float.intBitsToFloat((int) (r23.getSize-NH-jbRc() >> 32));
        if (Color.equals-impl0(r24, r26) == false) goto L5;
        long r6 = Float.floatToRawIntBits(r1);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r23, r24, 0, Size.constructor-impl((((long) Float.floatToRawIntBits(r1)) & 4294967295L) | (r6 << 32)), CornerRadius.constructor-impl((Float.floatToRawIntBits(r28) << 32) | (((long) Float.floatToRawIntBits(r28)) & 4294967295L)), Fill.INSTANCE, MenuKt.ClosedAlphaTarget, null, 0, 226, null);
        return;
    L5:
        float r2 = r29.getWidth();
        float r7 = r29.getWidth();
        long r11 = Offset.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (Float.floatToRawIntBits(r7) & 4294967295L));
        float r8 = 2;
        float r3 = r1 - (r29.getWidth() * r8);
        float r9 = r1 - (r29.getWidth() * r8);
        long r13 = Size.constructor-impl((Float.floatToRawIntBits(r3) << 32) | (Float.floatToRawIntBits(r9) & 4294967295L));
        float r4 = Math.max(MenuKt.ClosedAlphaTarget, r28 - r29.getWidth());
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r23, r24, r11, r13, CornerRadius.constructor-impl((Float.floatToRawIntBits(r4) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)), Fill.INSTANCE, MenuKt.ClosedAlphaTarget, null, 0, 224, null);
        long r12 = Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r0)) & 4294967295L));
        float r5 = r1 - r29.getWidth();
        float r10 = r1 - r29.getWidth();
        long r14 = Float.floatToRawIntBits(r5);
        float r15 = r28 - r0;
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default(r23, r26, r12, Size.constructor-impl((((long) Float.floatToRawIntBits(r10)) & 4294967295L) | (r14 << 32)), CornerRadius.constructor-impl((Float.floatToRawIntBits(r15) << 32) | (Float.floatToRawIntBits(r15) & 4294967295L)), r29, MenuKt.ClosedAlphaTarget, null, 0, 224, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m2394drawCheck3IgeMak(DrawScope r15, long r16, float r18, float r19, Stroke r20, CheckDrawingCache r21) {
        float r1 = Float.intBitsToFloat((int) (r15.getSize-NH-jbRc() >> 32));
        float r2 = MathHelpersKt.lerp(0.4f, 0.5f, r19);
        float r4 = MathHelpersKt.lerp(0.7f, 0.5f, r19);
        float r5 = MathHelpersKt.lerp(0.5f, 0.5f, r19);
        float r0 = MathHelpersKt.lerp(0.3f, 0.5f, r19);
        r21.getCheckPath().rewind();
        r21.getCheckPath().moveTo(0.2f * r1, r5 * r1);
        r21.getCheckPath().lineTo(r2 * r1, r4 * r1);
        r21.getCheckPath().lineTo(0.8f * r1, r1 * r0);
        r21.getPathMeasure().setPath(r21.getCheckPath(), false);
        r21.getPathToDraw().rewind();
        r21.getPathMeasure().getSegment(MenuKt.ClosedAlphaTarget, r21.getPathMeasure().getLength() * r18, r21.getPathToDraw(), true);
        DrawScope.-CC.drawPath-LG529CI$default(r15, r21.getPathToDraw(), r16, MenuKt.ClosedAlphaTarget, r20, null, 0, 52, null);
    }

    private static final void CheckboxImpl(final boolean r35, final ToggleableState r36, final Modifier r37, final CheckboxColors r38, final Stroke r39, final Stroke r40, Composer r41, final int r42) {
        Composer r13 = r41.startRestartGroup(-891330208);
        if ((r42 & 6) == 0) goto L5;
        int r6 = r42;
    L11:
        if ((r42 & 48) != 0) goto L18;
        if (r13.changed(r36.ordinal()) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r42 & 384) != 0) goto L25;
        if (r13.changed(r37) == false) goto L22;
        int r8 = 256;
    L23:
        r6 = r6 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r42 & 3072) != 0) goto L32;
        if (r13.changed(r38) == false) goto L29;
        int r9 = 2048;
    L30:
        r6 = r6 | r9;
        goto L32
    L29:
        r9 = 1024;
    L32:
        if ((r42 & 24576) != 0) goto L39;
        if (r13.changedInstance(r39) == false) goto L36;
        int r10 = 16384;
    L37:
        r6 = r6 | r10;
        goto L39
    L36:
        r10 = 8192;
    L39:
        if ((196608 & r42) == 0) goto L41;
    L45:
        int r11 = r6;
        if ((74899 & r11) == 74898) goto L48;
        boolean r12 = true;
    L50:
        if (r13.shouldExecute(r12, r11 & 1) == true) goto L52;
        Composer r14 = r13;
        r14.skipToGroupEnd();
    L134:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L138;
        r15.updateScope(new z2(r35, r36, r37, r38, r39, r40, r42));
        return;
    L138:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-891330208, r11, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:401)");
    L54:
        int r5 = r11 >> 3;
        int r16 = r5 & 14;
        Transition r17 = TransitionKt.updateTransition(r36, null, r13, r16, 2);
        final FiniteAnimationSpec r18 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r13, 6);
        Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> r19 = new CheckboxKt$CheckboxImpl$checkDrawFraction$1(r18);
        FloatCompanionObject r110 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r20 = VectorConvertersKt.getVectorConverter(r110);
        ToggleableState r21 = (ToggleableState) r17.getCurrentState();
        r13.startReplaceGroup(-768316570);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
    L57:
        int[] r22 = WhenMappings.$EnumSwitchMapping$0;
        int r23 = r22[r21.ordinal()];
        float r24 = MenuKt.ClosedAlphaTarget;
        if (r23 != 1) goto L60;
    L66:
        float r25 = 1.0f;
    L68:
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        r13.endReplaceGroup();
        Float r26 = Float.valueOf(r25);
        ToggleableState r27 = (ToggleableState) r17.getTargetState();
        r13.startReplaceGroup(-768316570);
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)");
    L74:
        int r0 = r22[r27.ordinal()];
        if (r0 == 1) goto L85;
        if (r0 != 2) goto L79;
        float r1 = MenuKt.ClosedAlphaTarget;
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
    L89:
        r13.endReplaceGroup();
        r14 = r13;
        final State r111 = TransitionKt.createTransitionAnimation(r17, r26, Float.valueOf(r1), (FiniteAnimationSpec) r19.invoke(r17.getSegment(), r13, 0), r20, "FloatAnimation", r13, 0);
        Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> r28 = new CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1(r18);
        TwoWayConverter<Float, AnimationVector1D> r112 = VectorConvertersKt.getVectorConverter(r110);
        ToggleableState r2 = (ToggleableState) r17.getCurrentState();
        r14.startReplaceGroup(1840054703);
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
    L92:
        int r3 = r22[r2.ordinal()];
        if (r3 == 1) goto L102;
        if (r3 == 2) goto L102;
        if (r3 != 3) goto L100;
        float r4 = 1.0f;
    L104:
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        r14.endReplaceGroup();
        Float r29 = Float.valueOf(r4);
        ToggleableState r30 = (ToggleableState) r17.getTargetState();
        r14.startReplaceGroup(1840054703);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)");
    L109:
        int r31 = r22[r30.ordinal()];
        if (r31 == 1) goto L120;
        if (r31 == 2) goto L120;
        if (r31 != 3) goto L117;
        r24 = 1.0f;
        goto L120
    L117:
        throw new NoWhenBranchMatchedException();
    L120:
        if (ComposerKt.isTraceInProgress() == false) goto L122;
        ComposerKt.traceEventEnd();
    L122:
        r14.endReplaceGroup();
        final State r113 = TransitionKt.createTransitionAnimation(r17, r29, Float.valueOf(r24), (FiniteAnimationSpec) r28.invoke(r17.getSegment(), r14, 0), r112, "FloatAnimation", r14, 0);
        Object r32 = r14.rememberedValue();
        Composer.Companion r33 = Composer.Companion;
        if (r32 != r33.getEmpty()) goto L125;
        r32 = new CheckDrawingCache(null, null, null, 7, null);
        r14.updateRememberedValue(r32);
    L125:
        final CheckDrawingCache r114 = (CheckDrawingCache) r32;
        final State<Color> r34 = r38.checkmarkColor$material3(r36, r14, r16 | ((r11 >> 6) & 112));
        int r43 = r5 & 896;
        int r44 = r43 | ((r11 & 14) | (r11 & 112));
        final State<Color> r45 = r38.boxColor$material3(r35, r36, r14, r44);
        final State<Color> r46 = r38.borderColor$material3(r35, r36, r14, r44);
        Modifier r47 = SizeKt.m1006requiredSize3ABfNKs(SizeKt.wrapContentSize$default(r37, Alignment.Companion.getCenter(), false, 2, null), CheckboxSize);
        boolean r48 = (((((r14.changed(r45) | r14.changed(r46)) | r14.changedInstance(r40)) | r14.changed(r34)) | r14.changed(r111)) | r14.changed(r113)) | r14.changedInstance(r39);
        Object r49 = r14.rememberedValue();
        if (r48 == false) goto L128;
    L129:
        r49 = new y2(r45, r46, r40, r34, r111, r113, r39, r114);
        r14.updateRememberedValue(r49);
    L130:
        CanvasKt.Canvas(r47, (Function1) r49, r14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventEnd();
        goto L134
    L128:
        if (r49 != r33.getEmpty()) goto L130;
    L100:
        throw new NoWhenBranchMatchedException();
    L102:
        r4 = MenuKt.ClosedAlphaTarget;
        goto L104
    L79:
        if (r0 == 3) goto L85;
        throw new NoWhenBranchMatchedException();
    L85:
        r1 = 1.0f;
        goto L87
    L60:
        if (r23 == 2) goto L65;
        if (r23 == 3) goto L66;
        throw new NoWhenBranchMatchedException();
    L65:
        r25 = MenuKt.ClosedAlphaTarget;
        goto L68
    L48:
        r12 = false;
        goto L50
    L41:
        if (r13.changedInstance(r40) == false) goto L43;
        int r50 = 131072;
    L44:
        r6 = r6 | r50;
        goto L45
    L43:
        r50 = 65536;
        goto L44
    L5:
        if (r13.changed(r35) == false) goto L7;
        int r51 = 4;
    L8:
        r6 = r51 | r42;
        goto L11
    L7:
        r51 = 2;
        goto L8
    }

    public static final void Checkbox(final boolean r29, final Function1<? super Boolean, Unit> r30, Modifier r31, boolean r32, CheckboxColors r33, MutableInteractionSource r34, Composer r35, final int r36, final int r37) {
        Composer r3 = r35.startRestartGroup(-1406741137);
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
        Modifier r9 = r31;
    L34:
        int r10 = r37 & 8;
        if (r10 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        boolean r11 = r32;
    L46:
        if ((r36 & 24576) == 0) goto L48;
        CheckboxColors r12 = r33;
    L56:
        int r13 = r37 & 32;
        if (r13 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        MutableInteractionSource r14 = r34;
    L67:
        boolean r16 = false;
        if ((74899 & r4) == 74898) goto L70;
        boolean r5 = true;
    L72:
        if (r3.shouldExecute(r5, r4 & 1) == false) goto L115;
        r3.startDefaults();
        if ((r36 & 1) != 0) goto L76;
    L83:
        if (r6 == 0) goto L85;
        r9 = Modifier.Companion;
    L85:
        if (r10 == 0) goto L88;
        r11 = true;
    L88:
        if ((r37 & 16) == 0) goto L90;
        r4 = r4 & (-57345);
        r12 = CheckboxDefaults.INSTANCE.colors(r3, 6);
    L90:
        if (r13 != 0) goto L91;
    L81:
        boolean r7 = r11;
        CheckboxColors r8 = r12;
        MutableInteractionSource r19 = r14;
    L82:
        Modifier r28 = r9;
        int r15 = r4;
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventStart(-1406741137, r15, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
    L95:
        float r0 = (float) Math.floor(((Density) r3.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(CheckboxDefaults.INSTANCE.m2392getStrokeWidthD9Ej5fM()));
        ToggleableState r17 = ToggleableStateKt.ToggleableState(r29);
        if (r30 == null) goto L110;
        r3.startReplaceGroup(2066152950);
        if ((r15 & 112) != 32) goto L100;
        boolean r18 = true;
    L102:
        if ((r15 & 14) != 4) goto L104;
        r16 = true;
    L104:
        boolean r20 = r18 | r16;
        Object r110 = r3.rememberedValue();
        if (r20 == false) goto L107;
    L108:
        r110 = new b3(r30, r29);
        r3.updateRememberedValue(r110);
    L109:
        Function0 r111 = (Function0) r110;
        r3.endReplaceGroup();
    L111:
        Stroke r112 = new Stroke(r0, MenuKt.ClosedAlphaTarget, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null);
        Stroke r113 = new Stroke(r0, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null);
        int r1 = r15 << 6;
        TriStateCheckbox(r17, r111, r112, r113, r28, r7, r8, r19, r3, (((57344 & r1) | (458752 & r1)) | (3670016 & r1)) | (r1 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventEnd();
    L114:
        r9 = r28;
        final boolean r21 = r7;
        final CheckboxColors r22 = r8;
        final MutableInteractionSource r23 = r19;
    L116:
        ScopeUpdateScope r114 = r3.endRestartGroup();
        if (r114 == null) goto L120;
        final Modifier r24 = r9;
        r114.updateScope(new c3(r29, r30, r24, r21, r22, r23, r36, r37));
        return;
    L120:
        return;
    L107:
        if (r110 != Composer.Companion.getEmpty()) goto L109;
    L100:
        r18 = false;
        goto L102
    L110:
        r3.startReplaceGroup(2066218639);
        r3.endReplaceGroup();
        r111 = null;
        goto L111
    L91:
        r7 = r11;
        r8 = r12;
        r19 = null;
        goto L82
    L76:
        if (r3.getDefaultsInvalid() == true) goto L83;
        r3.skipToGroupEnd();
        if ((r37 & 16) == 0) goto L81;
        r4 = r4 & (-57345);
        goto L81
    L115:
        r3.skipToGroupEnd();
        r21 = r11;
        r22 = r12;
        r23 = r14;
        goto L116
    L70:
        r5 = false;
        goto L72
    L60:
        if ((196608 & r36) != 0) goto L66;
        r14 = r34;
        if (r3.changed(r14) == false) goto L64;
        int r115 = 131072;
    L65:
        r4 = r4 | r115;
        goto L67
    L64:
        r115 = 65536;
        goto L65
    L48:
        if ((r37 & 16) != 0) goto L52;
        r12 = r33;
        if (r3.changed(r12) == false) goto L53;
        int r116 = 16384;
    L54:
        r4 = r4 | r116;
    L53:
        r116 = 8192;
        goto L54
    L52:
        r12 = r33;
        goto L53
    L38:
        if ((r36 & 3072) != 0) goto L44;
        r11 = r32;
        if (r3.changed(r11) == false) goto L42;
        int r117 = 2048;
    L43:
        r4 = r4 | r117;
        goto L46
    L42:
        r117 = 1024;
        goto L43
    L27:
        if ((r36 & 384) != 0) goto L33;
        r9 = r31;
        if (r3.changed(r9) == false) goto L31;
        int r118 = 256;
    L32:
        r4 = r4 | r118;
        goto L34
    L31:
        r118 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        if (r3.changedInstance(r30) == false) goto L21;
        int r25 = 32;
    L22:
        r4 = r4 | r25;
        goto L23
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r3.changed(r29) == false) goto L10;
        int r26 = 4;
    L11:
        r4 = r26 | r36;
        goto L14
    L10:
        r26 = 2;
        goto L11
    }

    private static final Unit CheckboxImpl$lambda$14$lambda$13(State r7, State r8, Stroke r9, State r10, State r11, State r12, Stroke r13, CheckDrawingCache r14, DrawScope r15) {
        m2393drawBox1wkBAMs(r15, ((Color) r7.getValue()).unbox-impl(), ((Color) r8.getValue()).unbox-impl(), r15.toPx-0680j_4(RadiusSize), r9);
        m2394drawCheck3IgeMak(r15, ((Color) r10.getValue()).unbox-impl(), ((Number) r11.getValue()).floatValue(), ((Number) r12.getValue()).floatValue(), r13, r14);
        return Unit.INSTANCE;
    }

    public static final void TriStateCheckbox(final ToggleableState r25, final Function0<Unit> r26, Modifier r27, boolean r28, CheckboxColors r29, MutableInteractionSource r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-1608358065);
        if ((r33 & 1) == 0) goto L6;
        int r2 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        int r4 = r33 & 4;
        if (r4 == 0) goto L28;
        r2 = r2 | 384;
    L34:
        Modifier r5 = r27;
    L35:
        int r6 = r33 & 8;
        if (r6 == 0) goto L39;
        r2 = r2 | 3072;
    L45:
        boolean r8 = r28;
    L47:
        if ((r32 & 24576) == 0) goto L49;
        CheckboxColors r9 = r29;
    L57:
        int r10 = r33 & 32;
        if (r10 == 0) goto L61;
        r2 = r2 | 196608;
    L67:
        MutableInteractionSource r11 = r30;
    L69:
        if ((74899 & r2) == 74898) goto L71;
        boolean r12 = true;
    L73:
        if (r1.shouldExecute(r12, r2 & 1) == false) goto L102;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L77;
    L85:
        if (r4 == 0) goto L87;
        Modifier r7 = Modifier.Companion;
    L88:
        if (r6 == 0) goto L91;
        r8 = true;
    L91:
        if ((r33 & 16) == 0) goto L93;
        r2 = r2 & (-57345);
        r9 = CheckboxDefaults.INSTANCE.colors(r1, 6);
    L93:
        if (r10 != 0) goto L94;
    L83:
        final CheckboxColors r13 = r9;
        final MutableInteractionSource r14 = r11;
    L84:
        boolean r24 = r8;
        int r15 = r2;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(-1608358065, r15, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
    L98:
        float r0 = (float) Math.floor(((Density) r1.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(CheckboxDefaults.INSTANCE.m2392getStrokeWidthD9Ej5fM()));
        Stroke r16 = new Stroke(r0, MenuKt.ClosedAlphaTarget, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null);
        Stroke r17 = new Stroke(r0, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null);
        int r3 = (r15 & 14) | (r15 & 112);
        int r18 = r15 << 6;
        TriStateCheckbox(r25, r26, r16, r17, r7, r24, r13, r14, r1, (((r3 | (57344 & r18)) | (458752 & r18)) | (3670016 & r18)) | (r18 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventEnd();
    L101:
        r8 = r24;
    L103:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L107;
        final Modifier r20 = r7;
        final boolean r21 = r8;
        r19.updateScope(new d3(r25, r26, r20, r21, r13, r14, r32, r33));
        return;
    L107:
        return;
    L94:
        r14 = null;
        r13 = r9;
        goto L84
    L87:
        r7 = r5;
        goto L88
    L77:
        if (r1.getDefaultsInvalid() == true) goto L85;
        r1.skipToGroupEnd();
        if ((r33 & 16) == 0) goto L82;
        r2 = r2 & (-57345);
    L82:
        r7 = r5;
        goto L83
    L102:
        r1.skipToGroupEnd();
        r7 = r5;
        r13 = r9;
        r14 = r11;
        goto L103
    L71:
        r12 = false;
        goto L73
    L61:
        if ((196608 & r32) != 0) goto L67;
        r11 = r30;
        if (r1.changed(r11) == false) goto L65;
        int r110 = 131072;
    L66:
        r2 = r2 | r110;
        goto L69
    L65:
        r110 = 65536;
        goto L66
    L49:
        if ((r33 & 16) != 0) goto L53;
        r9 = r29;
        if (r1.changed(r9) == false) goto L54;
        int r111 = 16384;
    L55:
        r2 = r2 | r111;
    L54:
        r111 = 8192;
        goto L55
    L53:
        r9 = r29;
        goto L54
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r8 = r28;
        if (r1.changed(r8) == false) goto L43;
        int r22 = 2048;
    L44:
        r2 = r2 | r22;
        goto L47
    L43:
        r22 = 1024;
        goto L44
    L28:
        if ((r32 & 384) != 0) goto L34;
        r5 = r27;
        if (r1.changed(r5) == false) goto L32;
        int r23 = 256;
    L33:
        r2 = r2 | r23;
        goto L35
    L32:
        r23 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r1.changedInstance(r26) == false) goto L21;
        int r34 = 32;
    L22:
        r2 = r2 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r2 = r32;
        goto L14
    L8:
        if (r1.changed(r25.ordinal()) == false) goto L10;
        int r35 = 4;
    L11:
        r2 = r35 | r32;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    public static final void Checkbox(final boolean r22, final Function1<? super Boolean, Unit> r23, final Stroke r24, final Stroke r25, Modifier r26, boolean r27, CheckboxColors r28, MutableInteractionSource r29, Composer r30, final int r31, final int r32) {
        Composer r3 = r30.startRestartGroup(534932591);
        if ((r32 & 1) == 0) goto L6;
        int r4 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r32 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L35:
        if ((r32 & 8) == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        int r11 = r32 & 16;
        if (r11 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        Modifier r12 = r26;
    L56:
        int r13 = r32 & 32;
        if (r13 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        boolean r14 = r27;
    L68:
        if ((1572864 & r31) == 0) goto L70;
        CheckboxColors r15 = r28;
    L78:
        int r5 = r32 & 128;
        if (r5 == 0) goto L81;
        r4 = r4 | 12582912;
        MutableInteractionSource r7 = r29;
    L88:
        boolean r17 = false;
        if ((r4 & 4793491) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L136;
        r3.startDefaults();
        Function0 r6 = null;
        if ((r31 & 1) != 0) goto L97;
    L104:
        if (r11 == 0) goto L106;
        r12 = Modifier.Companion;
    L106:
        if (r13 == 0) goto L109;
        r14 = true;
    L109:
        if ((r32 & 64) == 0) goto L111;
        r4 = r4 & (-3670017);
        r15 = CheckboxDefaults.INSTANCE.colors(r3, 6);
    L111:
        if (r5 != 0) goto L112;
    L102:
        int r16 = r4;
    L103:
        Modifier r1 = r12;
        boolean r8 = r14;
        CheckboxColors r9 = r15;
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventStart(534932591, r16, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
    L116:
        ToggleableState r18 = ToggleableStateKt.ToggleableState(r22);
        if (r23 == null) goto L131;
        r3.startReplaceGroup(1848599606);
        if ((r16 & 112) != 32) goto L121;
        boolean r10 = true;
    L123:
        if ((r16 & 14) != 4) goto L125;
        r17 = true;
    L125:
        boolean r19 = r10 | r17;
        Object r110 = r3.rememberedValue();
        if (r19 == false) goto L128;
    L129:
        r110 = new e3(r23, r22);
        r3.updateRememberedValue(r110);
    L130:
        r3.endReplaceGroup();
        r6 = (Function0) r110;
    L132:
        TriStateCheckbox(r18, r6, r24, r25, r1, r8, r9, r7, r3, (((((r16 & 896) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16)) | (r16 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
    L135:
        final boolean r20 = r8;
        MutableInteractionSource r111 = r7;
        final CheckboxColors r21 = r9;
        final Modifier r33 = r1;
    L137:
        ScopeUpdateScope r112 = r3.endRestartGroup();
        if (r112 == null) goto L141;
        final MutableInteractionSource r34 = r111;
        r112.updateScope(new f3(r22, r23, r24, r25, r33, r20, r21, r34, r31, r32));
        return;
    L141:
        return;
    L128:
        if (r110 != Composer.Companion.getEmpty()) goto L130;
    L121:
        r10 = false;
        goto L123
    L131:
        r3.startReplaceGroup(1848665295);
        r3.endReplaceGroup();
        goto L132
    L112:
        r16 = r4;
        r7 = null;
        goto L103
    L97:
        if (r3.getDefaultsInvalid() == true) goto L104;
        r3.skipToGroupEnd();
        if ((r32 & 64) == 0) goto L102;
        r4 = r4 & (-3670017);
        goto L102
    L136:
        r3.skipToGroupEnd();
        r111 = r7;
        r33 = r12;
        r20 = r14;
        r21 = r15;
        goto L137
    L91:
        r0 = false;
        goto L93
    L81:
        r7 = r29;
        if ((r31 & 12582912) != 0) goto L88;
        if (r3.changed(r7) == false) goto L86;
        int r113 = 8388608;
    L87:
        r4 = r4 | r113;
        goto L88
    L86:
        r113 = 4194304;
        goto L87
    L70:
        if ((r32 & 64) != 0) goto L74;
        r15 = r28;
        if (r3.changed(r15) == false) goto L75;
        int r114 = 1048576;
    L76:
        r4 = r4 | r114;
    L75:
        r114 = 524288;
        goto L76
    L74:
        r15 = r28;
        goto L75
    L60:
        if ((196608 & r31) != 0) goto L66;
        r14 = r27;
        if (r3.changed(r14) == false) goto L64;
        int r115 = 131072;
    L65:
        r4 = r4 | r115;
        goto L68
    L64:
        r115 = 65536;
        goto L65
    L49:
        if ((r31 & 24576) != 0) goto L55;
        r12 = r26;
        if (r3.changed(r12) == false) goto L53;
        int r116 = 16384;
    L54:
        r4 = r4 | r116;
        goto L56
    L53:
        r116 = 8192;
        goto L54
    L38:
        if ((r31 & 3072) != 0) goto L45;
        if (r3.changedInstance(r25) == false) goto L42;
        int r117 = 2048;
    L43:
        r4 = r4 | r117;
        goto L45
    L42:
        r117 = 1024;
        goto L43
    L27:
        if ((r31 & 384) != 0) goto L35;
        if (r3.changedInstance(r24) == false) goto L31;
        int r35 = 256;
    L32:
        r4 = r4 | r35;
        goto L35
    L31:
        r35 = 128;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r3.changedInstance(r23) == false) goto L21;
        int r36 = 32;
    L22:
        r4 = r4 | r36;
        goto L24
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r4 = r31;
        goto L14
    L8:
        if (r3.changed(r22) == false) goto L10;
        int r37 = 4;
    L11:
        r4 = r37 | r31;
        goto L14
    L10:
        r37 = 2;
        goto L11
    }

    public static final void TriStateCheckbox(final ToggleableState r28, final Function0<Unit> r29, final Stroke r30, final Stroke r31, Modifier r32, boolean r33, CheckboxColors r34, MutableInteractionSource r35, Composer r36, final int r37, final int r38) {
        Composer r8 = r36.startRestartGroup(-406243761);
        if ((r38 & 1) == 0) goto L6;
        int r1 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r38 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r38 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r3 = r38 & 16;
        if (r3 == 0) goto L47;
        r1 = r1 | 24576;
    L53:
        Modifier r4 = r32;
    L54:
        int r5 = r38 & 32;
        if (r5 == 0) goto L58;
        r1 = r1 | 196608;
    L64:
        final boolean r6 = r33;
    L66:
        if ((1572864 & r37) == 0) goto L68;
        CheckboxColors r11 = r34;
    L76:
        int r12 = r38 & 128;
        if (r12 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        MutableInteractionSource r13 = r35;
    L88:
        if ((r1 & 4793491) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r8.shouldExecute(r0, r1 & 1) == false) goto L127;
        r8.startDefaults();
        if ((r37 & 1) != 0) goto L96;
    L102:
        if (r3 == 0) goto L104;
        Modifier r2 = Modifier.Companion;
    L105:
        if (r5 == 0) goto L108;
        r6 = true;
    L108:
        if ((r38 & 64) == 0) goto L110;
        r1 = r1 & (-3670017);
        r11 = CheckboxDefaults.INSTANCE.colors(r8, 6);
    L110:
        if (r12 == 0) goto L112;
        MutableInteractionSource r21 = null;
    L113:
        int r14 = r1;
    L114:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(-406243761, r14, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:275)");
    L117:
        if (r29 == null) goto L119;
        MutableInteractionSource r7 = r21;
        boolean r9 = r6;
        Modifier r10 = ToggleableKt.m1303triStateToggleableO2vRcR0(Modifier.Companion, r28, r7, RippleKt.m3031rippleH2RKhps$default(false, Dp.constructor-impl(CheckboxTokens.INSTANCE.getStateLayerSize-D9Ej5fM() / 2), 0, 4, null), r9, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), r29);
    L120:
        if (r29 == null) goto L122;
        Modifier r15 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
    L123:
        Modifier r16 = PaddingKt.m960padding3ABfNKs(r2.then(r15).then(r10), CheckboxDefaultPadding);
        int r17 = (((r14 >> 15) & 14) | ((r14 << 3) & 112)) | ((r14 >> 9) & 7168);
        int r18 = r14 << 6;
        Modifier r19 = r2;
        CheckboxImpl(r6, r28, r16, r11, r30, r31, r8, (r17 | (57344 & r18)) | (r18 & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        final Modifier r20 = r19;
        r6 = r6;
        r11 = r11;
    L128:
        ScopeUpdateScope r110 = r8.endRestartGroup();
        if (r110 == null) goto L132;
        final CheckboxColors r22 = r11;
        final MutableInteractionSource r23 = r21;
        r110.updateScope(new a3(r28, r29, r30, r31, r20, r6, r22, r23, r37, r38));
        return;
    L132:
        return;
    L122:
        r15 = Modifier.Companion;
        goto L123
    L119:
        r10 = Modifier.Companion;
        goto L120
    L112:
        r21 = r13;
        goto L113
    L104:
        r2 = r4;
        goto L105
    L96:
        if (r8.getDefaultsInvalid() == true) goto L102;
        r8.skipToGroupEnd();
        if ((r38 & 64) == 0) goto L101;
        r1 = r1 & (-3670017);
    L101:
        r6 = r6;
        r11 = r11;
        r21 = r13;
        r14 = r1;
        r2 = r4;
        goto L114
    L127:
        r8.skipToGroupEnd();
        r20 = r4;
        r21 = r13;
        goto L128
    L90:
        r0 = false;
        goto L92
    L80:
        if ((12582912 & r37) != 0) goto L86;
        r13 = r35;
        if (r8.changed(r13) == false) goto L84;
        int r111 = 8388608;
    L85:
        r1 = r1 | r111;
        goto L88
    L84:
        r111 = 4194304;
        goto L85
    L68:
        if ((r38 & 64) != 0) goto L72;
        r11 = r34;
        if (r8.changed(r11) == false) goto L73;
        int r112 = 1048576;
    L74:
        r1 = r1 | r112;
    L73:
        r112 = 524288;
        goto L74
    L72:
        r11 = r34;
        goto L73
    L58:
        if ((196608 & r37) != 0) goto L64;
        r6 = r33;
        if (r8.changed(r6) == false) goto L62;
        int r113 = 131072;
    L63:
        r1 = r1 | r113;
        goto L66
    L62:
        r113 = 65536;
        goto L63
    L47:
        if ((r37 & 24576) != 0) goto L53;
        r4 = r32;
        if (r8.changed(r4) == false) goto L51;
        int r24 = 16384;
    L52:
        r1 = r1 | r24;
        goto L54
    L51:
        r24 = 8192;
        goto L52
    L37:
        if ((r37 & 3072) != 0) goto L43;
        if (r8.changedInstance(r31) == false) goto L41;
        int r25 = 2048;
    L42:
        r1 = r1 | r25;
        goto L43
    L41:
        r25 = 1024;
        goto L42
    L27:
        if ((r37 & 384) != 0) goto L34;
        if (r8.changedInstance(r30) == false) goto L31;
        int r26 = 256;
    L32:
        r1 = r1 | r26;
        goto L34
    L31:
        r26 = 128;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r8.changedInstance(r29) == false) goto L21;
        int r27 = 32;
    L22:
        r1 = r1 | r27;
        goto L24
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r1 = r37;
        goto L14
    L8:
        if (r8.changed(r28.ordinal()) == false) goto L10;
        int r39 = 4;
    L11:
        r1 = r39 | r37;
        goto L14
    L10:
        r39 = 2;
        goto L11
    }
}
