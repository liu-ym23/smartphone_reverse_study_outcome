package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "RadioAnimationDuration", "", "RadioButtonRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonSize", "RadioRadius", "RadioButtonDotSize", "RadioStrokeWidth", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = 0.0f;
    private static final float RadioButtonPadding = 0.0f;
    private static final float RadioButtonRippleRadius = 0.0f;
    private static final float RadioButtonSize = 0.0f;
    private static final float RadioRadius = 0.0f;
    private static final float RadioStrokeWidth = 0.0f;

    private static final Unit RadioButton$lambda$2(boolean r10, Function0 r11, Modifier r12, boolean r13, MutableInteractionSource r14, RadioButtonColors r15, int r16, int r17, Composer r18, int r19) {
        RadioButton(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, Function0 r1, Modifier r2, boolean r3, MutableInteractionSource r4, RadioButtonColors r5, int r6, int r7, Composer r8, int r9) {
        return RadioButton$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit b(State r0, State r1, DrawScope r2) {
        return RadioButton$lambda$1$lambda$0(r0, r1, r2);
    }

    static {
        RadioButtonRippleRadius = Dp.constructor-impl(24);
        float r0 = 2;
        RadioButtonPadding = Dp.constructor-impl(r0);
        float r1 = Dp.constructor-impl(20);
        RadioButtonSize = r1;
        RadioRadius = Dp.constructor-impl(r1 / r0);
        RadioButtonDotSize = Dp.constructor-impl(12);
        RadioStrokeWidth = Dp.constructor-impl(r0);
    }

    private static final Unit RadioButton$lambda$1$lambda$0(State r21, State r22, DrawScope r23) {
        float r2 = r23.toPx-0680j_4(RadioStrokeWidth);
        float r13 = r2 / 2;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, ((Color) r21.getValue()).unbox-impl(), r23.toPx-0680j_4(RadioRadius) - r13, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, new Stroke(r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.compareTo-0680j_4(((Dp) r22.getValue()).unbox-impl(), Dp.constructor-impl(0)) <= 0) goto L6;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, ((Color) r21.getValue()).unbox-impl(), r23.toPx-0680j_4(((Dp) r22.getValue()).unbox-impl()) - r13, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, Fill.INSTANCE, null, 0, 108, null);
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public static final void RadioButton(final boolean r27, final Function0<Unit> r28, Modifier r29, boolean r30, MutableInteractionSource r31, RadioButtonColors r32, Composer r33, final int r34, final int r35) {
        Composer r6 = r33.startRestartGroup(1314435585);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r35 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        final Modifier r3 = r29;
    L34:
        int r4 = r35 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r10 = r30;
    L45:
        int r11 = r35 & 16;
        if (r11 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        MutableInteractionSource r12 = r31;
    L57:
        if ((196608 & r34) == 0) goto L59;
        RadioButtonColors r13 = r32;
    L68:
        if ((74899 & r1) == 74898) goto L70;
        boolean r14 = true;
    L72:
        if (r6.shouldExecute(r14, r1 & 1) == false) goto L118;
        r6.startDefaults();
        if ((r34 & 1) != 0) goto L76;
    L83:
        if (r2 == 0) goto L85;
        Modifier r5 = Modifier.Companion;
    L86:
        if (r4 == 0) goto L88;
        boolean r7 = true;
    L89:
        if (r11 == 0) goto L91;
        MutableInteractionSource r8 = null;
    L93:
        if ((r35 & 32) == 0) goto L95;
        r1 = r1 & (-458753);
        MutableInteractionSource r17 = r8;
        Modifier r9 = r5;
        RadioButtonColors r15 = RadioButtonDefaults.INSTANCE.m2134colorsRGew2ao(0, 0, 0, r6, 3072, 7);
    L96:
        r6.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventStart(1314435585, r1, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
    L99:
        if (r27 == false) goto L101;
        float r0 = Dp.constructor-impl(RadioButtonDotSize / 2);
    L102:
        final State<Dp> r16 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r0, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, r6, 48, 12);
        int r18 = r1 >> 9;
        final State<Color> r19 = r15.radioColor(r7, r27, r6, (r18 & 896) | (((r1 << 3) & 112) | (r18 & 14)));
        if (r28 == null) goto L105;
        MutableInteractionSource r20 = r17;
        boolean r110 = r7;
        int r21 = 2;
        ?? r22 = 0;
        Modifier r23 = SelectableKt.m1289selectableO2vRcR0(Modifier.Companion, r27, r20, RippleKt.m2139rippleH2RKhps$default(false, RadioButtonRippleRadius, 0, 4, null), r110, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), r28);
    L106:
        if (r28 == null) goto L108;
        Modifier r24 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
    L109:
        Modifier r25 = SizeKt.m1006requiredSize3ABfNKs(PaddingKt.m960padding3ABfNKs(SizeKt.wrapContentSize$default(r9.then(r24).then(r23), Alignment.Companion.getCenter(), r22, r21, null), RadioButtonPadding), RadioButtonSize);
        boolean r26 = r6.changed(r19) | r6.changed(r16);
        Object r36 = r6.rememberedValue();
        if (r26 == false) goto L112;
    L113:
        r36 = new r8(r19, r16);
        r6.updateRememberedValue(r36);
    L114:
        CanvasKt.Canvas(r25, (Function1) r36, r6, r22);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r3 = r9;
        Composer r37 = r6;
        final RadioButtonColors r38 = r15;
        final boolean r39 = r110;
        final MutableInteractionSource r40 = r17;
    L119:
        ScopeUpdateScope r41 = r37.endRestartGroup();
        if (r41 == null) goto L123;
        r41.updateScope(new s8(r27, r28, r3, r39, r40, r38, r34, r35));
        return;
    L123:
        return;
    L112:
        if (r36 != Composer.Companion.getEmpty()) goto L114;
    L108:
        r24 = Modifier.Companion;
        goto L109
    L105:
        r110 = r7;
        r21 = 2;
        r22 = 0;
        r23 = Modifier.Companion;
        goto L106
    L101:
        r0 = Dp.constructor-impl(0);
        goto L102
    L95:
        r17 = r8;
        r9 = r5;
    L82:
        r15 = r13;
        goto L96
    L91:
        r8 = r12;
        goto L93
    L88:
        r7 = r10;
        goto L89
    L85:
        r5 = r3;
        goto L86
    L76:
        if (r6.getDefaultsInvalid() == true) goto L83;
        r6.skipToGroupEnd();
        if ((r35 & 32) == 0) goto L81;
        r1 = r1 & (-458753);
    L81:
        r9 = r3;
        r7 = r10;
        r17 = r12;
        goto L82
    L118:
        r37 = r6;
        r37.skipToGroupEnd();
        r39 = r10;
        r40 = r12;
        r38 = r13;
        goto L119
    L70:
        r14 = false;
        goto L72
    L59:
        if ((r35 & 32) != 0) goto L63;
        r13 = r32;
        if (r6.changed(r13) == false) goto L64;
        int r111 = 131072;
    L65:
        r1 = r1 | r111;
    L64:
        r111 = 65536;
        goto L65
    L63:
        r13 = r32;
        goto L64
    L49:
        if ((r34 & 24576) != 0) goto L55;
        r12 = r31;
        if (r6.changed(r12) == false) goto L53;
        int r112 = 16384;
    L54:
        r1 = r1 | r112;
        goto L57
    L53:
        r112 = 8192;
        goto L54
    L38:
        if ((r34 & 3072) != 0) goto L44;
        r10 = r30;
        if (r6.changed(r10) == false) goto L42;
        int r113 = 2048;
    L43:
        r1 = r1 | r113;
        goto L45
    L42:
        r113 = 1024;
        goto L43
    L27:
        if ((r34 & 384) != 0) goto L33;
        r3 = r29;
        if (r6.changed(r3) == false) goto L31;
        int r42 = 256;
    L32:
        r1 = r1 | r42;
        goto L34
    L31:
        r42 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        if (r6.changedInstance(r28) == false) goto L21;
        int r43 = 32;
    L22:
        r1 = r1 | r43;
        goto L23
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r6.changed(r27) == false) goto L10;
        int r44 = 4;
    L11:
        r1 = r44 | r34;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }
}
