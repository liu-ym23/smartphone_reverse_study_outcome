package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.RadioButtonTokens;
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
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final float RadioButtonDotSize = 0.0f;
    private static final float RadioButtonPadding = 0.0f;
    private static final float RadioStrokeWidth = 0.0f;

    static {
        float r0 = 2;
        RadioButtonPadding = Dp.constructor-impl(r0);
        RadioButtonDotSize = Dp.constructor-impl(12);
        RadioStrokeWidth = Dp.constructor-impl(r0);
    }

    private static final Unit RadioButton$lambda$2(boolean r10, Function0 r11, Modifier r12, boolean r13, RadioButtonColors r14, MutableInteractionSource r15, int r16, int r17, Composer r18, int r19) {
        RadioButton(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(State r0, State r1, DrawScope r2) {
        return RadioButton$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(boolean r0, Function0 r1, Modifier r2, boolean r3, RadioButtonColors r4, MutableInteractionSource r5, int r6, int r7, Composer r8, int r9) {
        return RadioButton$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private static final Unit RadioButton$lambda$1$lambda$0(State r21, State r22, DrawScope r23) {
        float r2 = r23.toPx-0680j_4(RadioStrokeWidth);
        float r1 = 2;
        float r13 = r2 / r1;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, ((Color) r21.getValue()).unbox-impl(), r23.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.getIconSize-D9Ej5fM() / r1)) - r13, 0, MenuKt.ClosedAlphaTarget, new Stroke(r2, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.compareTo-0680j_4(((Dp) r22.getValue()).unbox-impl(), Dp.constructor-impl(0)) <= 0) goto L6;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, ((Color) r21.getValue()).unbox-impl(), r23.toPx-0680j_4(((Dp) r22.getValue()).unbox-impl()) - r13, 0, MenuKt.ClosedAlphaTarget, Fill.INSTANCE, null, 0, 108, null);
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v15 */
    public static final void RadioButton(final boolean r25, final Function0<Unit> r26, Modifier r27, boolean r28, RadioButtonColors r29, MutableInteractionSource r30, Composer r31, final int r32, final int r33) {
        Composer r6 = r31.startRestartGroup(408580840);
        if ((r33 & 1) == 0) goto L6;
        int r1 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r33 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        final Modifier r3 = r27;
    L34:
        int r4 = r33 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r10 = r28;
    L46:
        if ((r32 & 24576) == 0) goto L48;
        RadioButtonColors r11 = r29;
    L56:
        int r12 = r33 & 32;
        if (r12 == 0) goto L60;
        r1 = r1 | 196608;
    L68:
        if ((74899 & r1) == 74898) goto L70;
        boolean r14 = true;
    L72:
        if (r6.shouldExecute(r14, r1 & 1) == false) goto L116;
        r6.startDefaults();
        if ((r32 & 1) != 0) goto L76;
    L83:
        if (r2 == 0) goto L85;
        Modifier r5 = Modifier.Companion;
    L86:
        if (r4 == 0) goto L89;
        r10 = true;
    L89:
        if ((r33 & 16) == 0) goto L91;
        r1 = r1 & (-57345);
        r11 = RadioButtonDefaults.INSTANCE.colors(r6, 6);
    L91:
        if (r12 == 0) goto L93;
        Modifier r7 = r5;
        boolean r8 = r10;
        RadioButtonColors r9 = r11;
        r30 = null;
    L94:
        r6.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(408580840, r1, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
    L97:
        if (r25 == false) goto L99;
        float r0 = Dp.constructor-impl(RadioButtonDotSize / 2);
    L100:
        final State<Dp> r13 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r0, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r6, 6), null, null, r6, 0, 12);
        final State<Color> r15 = r9.radioColor$material3(r8, r25, r6, ((r1 >> 6) & 896) | (((r1 >> 9) & 14) | ((r1 << 3) & 112)));
        if (r26 == null) goto L103;
        ?? r16 = 0;
        MutableInteractionSource r17 = r30;
        boolean r18 = r8;
        int r19 = 2;
        Modifier r20 = SelectableKt.m1289selectableO2vRcR0(Modifier.Companion, r25, r17, RippleKt.m3031rippleH2RKhps$default(false, Dp.constructor-impl(RadioButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM() / 2), 0, 4, null), r18, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), r26);
    L104:
        if (r26 == null) goto L106;
        Modifier r21 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
    L107:
        Modifier r22 = SizeKt.m1006requiredSize3ABfNKs(PaddingKt.m960padding3ABfNKs(SizeKt.wrapContentSize$default(r7.then(r21).then(r20), Alignment.Companion.getCenter(), r16, r19, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.getIconSize-D9Ej5fM());
        boolean r23 = r6.changed(r15) | r6.changed(r13);
        Object r24 = r6.rememberedValue();
        if (r23 == false) goto L110;
    L111:
        r24 = new sk(r15, r13);
        r6.updateRememberedValue(r24);
    L112:
        CanvasKt.Canvas(r22, (Function1) r24, r6, r16);
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        r3 = r7;
        final RadioButtonColors r34 = r9;
        final boolean r35 = r18;
        final MutableInteractionSource r36 = r30;
    L117:
        ScopeUpdateScope r110 = r6.endRestartGroup();
        if (r110 == null) goto L121;
        r110.updateScope(new tk(r25, r26, r3, r35, r34, r36, r32, r33));
        return;
    L121:
        return;
    L110:
        if (r24 != Composer.Companion.getEmpty()) goto L112;
    L106:
        r21 = Modifier.Companion;
        goto L107
    L103:
        r18 = r8;
        r19 = 2;
        r16 = 0;
        r20 = Modifier.Companion;
        goto L104
    L99:
        r0 = Dp.constructor-impl(0);
        goto L100
    L93:
        r7 = r5;
    L82:
        r8 = r10;
        r9 = r11;
        goto L94
    L85:
        r5 = r3;
        goto L86
    L76:
        if (r6.getDefaultsInvalid() == true) goto L83;
        r6.skipToGroupEnd();
        if ((r33 & 16) == 0) goto L81;
        r1 = r1 & (-57345);
    L81:
        r7 = r3;
        goto L82
    L116:
        r6 = r6;
        r6.skipToGroupEnd();
        r36 = r30;
        r35 = r10;
        r34 = r11;
        goto L117
    L70:
        r14 = false;
        goto L72
    L60:
        if ((196608 & r32) != 0) goto L68;
        if (r6.changed(r30) == false) goto L64;
        int r111 = 131072;
    L65:
        r1 = r1 | r111;
        goto L68
    L64:
        r111 = 65536;
        goto L65
    L48:
        if ((r33 & 16) != 0) goto L52;
        r11 = r29;
        if (r6.changed(r11) == false) goto L53;
        int r112 = 16384;
    L54:
        r1 = r1 | r112;
    L53:
        r112 = 8192;
        goto L54
    L52:
        r11 = r29;
        goto L53
    L38:
        if ((r32 & 3072) != 0) goto L44;
        r10 = r28;
        if (r6.changed(r10) == false) goto L42;
        int r113 = 2048;
    L43:
        r1 = r1 | r113;
        goto L46
    L42:
        r113 = 1024;
        goto L43
    L27:
        if ((r32 & 384) != 0) goto L33;
        r3 = r27;
        if (r6.changed(r3) == false) goto L31;
        int r37 = 256;
    L32:
        r1 = r1 | r37;
        goto L34
    L31:
        r37 = 128;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L23;
        if (r6.changedInstance(r26) == false) goto L21;
        int r38 = 32;
    L22:
        r1 = r1 | r38;
        goto L23
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r1 = r32;
        goto L14
    L8:
        if (r6.changed(r25) == false) goto L10;
        int r39 = 4;
    L11:
        r1 = r39 | r32;
        goto L14
    L10:
        r39 = 2;
        goto L11
    }
}
