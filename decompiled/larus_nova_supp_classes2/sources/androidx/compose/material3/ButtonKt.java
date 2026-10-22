package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonKt {
    private static final Unit Button$lambda$3(Function0 r14, Modifier r15, boolean r16, Shape r17, ButtonColors r18, ButtonElevation r19, BorderStroke r20, PaddingValues r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        Button(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedButton$lambda$4(Function0 r14, Modifier r15, boolean r16, Shape r17, ButtonColors r18, ButtonElevation r19, BorderStroke r20, PaddingValues r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        ElevatedButton(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit FilledTonalButton$lambda$5(Function0 r14, Modifier r15, boolean r16, Shape r17, ButtonColors r18, ButtonElevation r19, BorderStroke r20, PaddingValues r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        FilledTonalButton(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedButton$lambda$6(Function0 r14, Modifier r15, boolean r16, Shape r17, ButtonColors r18, ButtonElevation r19, BorderStroke r20, PaddingValues r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        OutlinedButton(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit TextButton$lambda$7(Function0 r14, Modifier r15, boolean r16, Shape r17, ButtonColors r18, ButtonElevation r19, BorderStroke r20, PaddingValues r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        TextButton(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, boolean r2, Shape r3, ButtonColors r4, ButtonElevation r5, BorderStroke r6, PaddingValues r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return FilledTonalButton$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(Function0 r0, Modifier r1, boolean r2, Shape r3, ButtonColors r4, ButtonElevation r5, BorderStroke r6, PaddingValues r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return ElevatedButton$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(SemanticsPropertyReceiver r0) {
        return Button$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Unit d(Function0 r0, Modifier r1, boolean r2, Shape r3, ButtonColors r4, ButtonElevation r5, BorderStroke r6, PaddingValues r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return OutlinedButton$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit e(Function0 r0, Modifier r1, boolean r2, Shape r3, ButtonColors r4, ButtonElevation r5, BorderStroke r6, PaddingValues r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return TextButton$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit f(Function0 r0, Modifier r1, boolean r2, Shape r3, ButtonColors r4, ButtonElevation r5, BorderStroke r6, PaddingValues r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return Button$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private static final Unit Button$lambda$2$lambda$1(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final void Button(final Function0<Unit> r31, Modifier r32, boolean r33, Shape r34, ButtonColors r35, ButtonElevation r36, BorderStroke r37, PaddingValues r38, MutableInteractionSource r39, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r40, Composer r41, final int r42, final int r43) {
        Composer r15 = r41.startRestartGroup(-1310015664);
        if ((r43 & 1) == 0) goto L6;
        int r1 = r42 | 6;
    L13:
        int r2 = r43 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r43 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L36:
        if ((r42 & 3072) == 0) goto L38;
        Shape r6 = r34;
    L47:
        if ((r42 & 24576) == 0) goto L49;
        ButtonColors r7 = r35;
    L58:
        if ((196608 & r42) == 0) goto L60;
        ButtonElevation r8 = r36;
    L68:
        int r14 = r43 & 64;
        if (r14 == 0) goto L72;
        r1 = r1 | 1572864;
    L79:
        int r0 = r43 & 128;
        if (r0 == 0) goto L83;
        r1 = r1 | 12582912;
    L89:
        int r9 = r43 & 256;
        if (r9 == 0) goto L93;
        r1 = r1 | 100663296;
    L101:
        if ((r43 & 512) == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        if ((306783379 & r1) == 306783378) goto L113;
        boolean r3 = true;
    L115:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L181;
        r15.startDefaults();
        if ((r42 & 1) != 0) goto L119;
    L131:
        if (r2 == 0) goto L133;
        Modifier r21 = Modifier.Companion;
    L134:
        if (r4 == 0) goto L136;
        boolean r22 = true;
    L138:
        if ((r43 & 8) == 0) goto L140;
        r1 = r1 & (-7169);
        Shape r23 = ButtonDefaults.INSTANCE.getShape(r15, 6);
    L142:
        if ((r43 & 16) == 0) goto L144;
        int r25 = r1 & (-57345);
        ButtonColors r24 = ButtonDefaults.INSTANCE.buttonColors(r15, 6);
    L146:
        if ((r43 & 32) == 0) goto L148;
        r8 = ButtonDefaults.INSTANCE.m2351buttonElevationR_JCAzs(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r15, 196608, 31);
        int r5 = r25 & (-458753);
    L149:
        if (r14 == 0) goto L151;
        BorderStroke r10 = null;
    L152:
        if (r0 == 0) goto L154;
        PaddingValues r11 = ButtonDefaults.INSTANCE.getContentPadding();
    L155:
        if (r9 == 0) goto L157;
        final PaddingValues r12 = r11;
        int r13 = r5;
        Modifier r16 = r21;
        boolean r17 = r22;
        r6 = r23;
        r7 = r24;
        MutableInteractionSource r18 = null;
    L158:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventStart(-1310015664, r13, -1, "androidx.compose.material3.Button (Button.kt:121)");
    L161:
        if (r18 != null) goto L166;
        r15.startReplaceGroup(1691738187);
        Object r19 = r15.rememberedValue();
        if (r19 != Composer.Companion.getEmpty()) goto L165;
        r19 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r19);
    L165:
        MutableInteractionSource r20 = (MutableInteractionSource) r19;
        r15.endReplaceGroup();
    L167:
        long r110 = r7.m2343containerColorvNxB06k$material3(r17);
        final long r111 = r7.m2344contentColorvNxB06k$material3(r17);
        if (r8 != null) goto L170;
        r15.startReplaceGroup(1691921830);
        r15.endReplaceGroup();
        State<Dp> r26 = null;
    L171:
        if (r26 == null) goto L173;
        float r27 = ((Dp) r26.getValue()).unbox-impl();
    L174:
        float r28 = r27;
        Object r29 = r15.rememberedValue();
        if (r29 != Composer.Companion.getEmpty()) goto L177;
        r29 = new k2();
        r15.updateRememberedValue(r29);
    L177:
        ButtonColors r30 = r7;
        ButtonElevation r310 = r8;
        Modifier r311 = r16;
        Composer r44 = r15;
        SurfaceKt.m3216Surfaceo_FOJdg(r31, SemanticsModifierKt.semantics$default(r16, false, (Function1) r29, 1, null), r17, r6, r110, r111, MenuKt.ClosedAlphaTarget, r28, r10, r20, ComposableLambdaKt.rememberComposableLambda(-535639973, true, new AnonymousClass2(r111, r12, r40), r15, 54), r44, (((r13 & 14) | (r13 & 896)) | (r13 & 7168)) | (234881024 & (r13 << 6)), 6, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        final MutableInteractionSource r45 = r18;
        final BorderStroke r46 = r10;
        final PaddingValues r47 = r12;
        final Shape r48 = r6;
        final ButtonColors r49 = r30;
        final ButtonElevation r50 = r310;
        final Modifier r51 = r311;
        final boolean r52 = r17;
    L182:
        ScopeUpdateScope r112 = r44.endRestartGroup();
        if (r112 == null) goto L186;
        r112.updateScope(new l2(r31, r51, r52, r48, r49, r50, r46, r47, r45, r40, r42, r43));
        return;
    L186:
        return;
    L173:
        r27 = Dp.constructor-impl(0);
        goto L174
    L170:
        r15.startReplaceGroup(-499611205);
        r26 = r8.shadowElevation$material3(r17, r20, r15, ((r13 >> 9) & 896) | ((r13 >> 6) & 14));
        r15.endReplaceGroup();
        goto L171
    L166:
        r15.startReplaceGroup(-499617780);
        r15.endReplaceGroup();
        r20 = r18;
        goto L167
    L157:
        r18 = r39;
        r12 = r11;
        r13 = r5;
        r16 = r21;
        r17 = r22;
        r6 = r23;
        r7 = r24;
        goto L158
    L154:
        r11 = r38;
        goto L155
    L151:
        r10 = r37;
        goto L152
    L148:
        r5 = r25;
        goto L149
    L144:
        r25 = r1;
        r24 = r7;
        goto L146
    L140:
        r23 = r6;
        goto L142
    L136:
        r22 = r33;
        goto L138
    L133:
        r21 = r32;
        goto L134
    L119:
        if (r15.getDefaultsInvalid() == true) goto L131;
        r15.skipToGroupEnd();
        if ((r43 & 8) == 0) goto L125;
        r1 = r1 & (-7169);
    L125:
        if ((r43 & 16) == 0) goto L128;
        r1 = r1 & (-57345);
    L128:
        if ((r43 & 32) == 0) goto L130;
        r1 = r1 & (-458753);
    L130:
        r16 = r32;
        r10 = r37;
        r12 = r38;
        r18 = r39;
        r13 = r1;
        r17 = r33;
        goto L158
    L181:
        r44 = r15;
        r44.skipToGroupEnd();
        r51 = r32;
        r52 = r33;
        r45 = r39;
        r48 = r6;
        r49 = r7;
        r50 = r8;
        r46 = r37;
        r47 = r38;
        goto L182
    L113:
        r3 = false;
        goto L115
    L104:
        if ((r42 & 805306368) != 0) goto L111;
        if (r15.changedInstance(r40) == false) goto L108;
        int r53 = 536870912;
    L109:
        r1 = r1 | r53;
        goto L111
    L108:
        r53 = 268435456;
        goto L109
    L93:
        if ((r42 & 100663296) != 0) goto L101;
        if (r15.changed(r39) == false) goto L97;
        int r113 = 67108864;
    L98:
        r1 = r1 | r113;
        goto L101
    L97:
        r113 = 33554432;
        goto L98
    L83:
        if ((r42 & 12582912) != 0) goto L89;
        if (r15.changed(r38) == false) goto L87;
        int r114 = 8388608;
    L88:
        r1 = r1 | r114;
        goto L89
    L87:
        r114 = 4194304;
        goto L88
    L72:
        if ((1572864 & r42) != 0) goto L79;
        if (r15.changed(r37) == false) goto L76;
        int r115 = 1048576;
    L77:
        r1 = r1 | r115;
        goto L79
    L76:
        r115 = 524288;
        goto L77
    L60:
        if ((r43 & 32) != 0) goto L64;
        r8 = r36;
        if (r15.changed(r8) == false) goto L65;
        int r54 = 131072;
    L66:
        r1 = r1 | r54;
    L65:
        r54 = 65536;
        goto L66
    L64:
        r8 = r36;
        goto L65
    L49:
        if ((r43 & 16) != 0) goto L53;
        r7 = r35;
        if (r15.changed(r7) == false) goto L54;
        int r55 = 16384;
    L55:
        r1 = r1 | r55;
    L54:
        r55 = 8192;
        goto L55
    L53:
        r7 = r35;
        goto L54
    L38:
        if ((r43 & 8) != 0) goto L42;
        r6 = r34;
        if (r15.changed(r6) == false) goto L43;
        int r56 = 2048;
    L44:
        r1 = r1 | r56;
    L43:
        r56 = 1024;
        goto L44
    L42:
        r6 = r34;
        goto L43
    L28:
        if ((r42 & 384) != 0) goto L36;
        if (r15.changed(r33) == false) goto L32;
        int r57 = 256;
    L33:
        r1 = r1 | r57;
        goto L36
    L32:
        r57 = 128;
        goto L33
    L17:
        if ((r42 & 48) != 0) goto L24;
        if (r15.changed(r32) == false) goto L21;
        int r58 = 32;
    L22:
        r1 = r1 | r58;
        goto L24
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r1 = r42;
        goto L13
    L8:
        if (r15.changedInstance(r31) == false) goto L10;
        int r59 = 4;
    L11:
        r1 = r59 | r42;
        goto L13
    L10:
        r59 = 2;
        goto L11
    }

    public static final void ElevatedButton(final Function0<Unit> r26, Modifier r27, boolean r28, Shape r29, ButtonColors r30, ButtonElevation r31, BorderStroke r32, PaddingValues r33, MutableInteractionSource r34, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r10 = r36.startRestartGroup(-1943994298);
        if ((r38 & 1) == 0) goto L6;
        int r1 = r37 | 6;
    L13:
        int r2 = r38 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r38 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        boolean r5 = r28;
    L36:
        if ((r37 & 3072) == 0) goto L38;
        Shape r6 = r29;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        ButtonColors r7 = r30;
    L58:
        if ((196608 & r37) == 0) goto L60;
        ButtonElevation r8 = r31;
    L68:
        int r13 = r38 & 64;
        if (r13 == 0) goto L71;
        r1 = r1 | 1572864;
        BorderStroke r14 = r32;
    L78:
        int r9 = r38 & 128;
        if (r9 == 0) goto L82;
        r1 = r1 | 12582912;
    L88:
        int r11 = r38 & 256;
        if (r11 == 0) goto L92;
        r1 = r1 | 100663296;
    L98:
        final MutableInteractionSource r12 = r34;
    L100:
        if ((r38 & 512) == 0) goto L103;
        r1 = r1 | 805306368;
    L110:
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L113;
        boolean r0 = true;
    L115:
        if (r10.shouldExecute(r0, r1 & 1) == false) goto L166;
        r10.startDefaults();
        if ((r37 & 1) != 0) goto L119;
    L132:
        if (r2 == 0) goto L134;
        Modifier r3 = Modifier.Companion;
    L135:
        if (r4 != 0) goto L139;
        r19 = r5;
    L139:
        if ((r38 & 8) == 0) goto L141;
        r1 = r1 & (-7169);
        Shape r21 = ButtonDefaults.INSTANCE.getElevatedShape(r10, 6);
    L143:
        if ((r38 & 16) == 0) goto L145;
        int r23 = r1 & (-57345);
        ButtonColors r22 = ButtonDefaults.INSTANCE.elevatedButtonColors(r10, 6);
    L147:
        if ((r38 & 32) == 0) goto L149;
        r8 = ButtonDefaults.INSTANCE.m2353elevatedButtonElevationR_JCAzs(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r10, 196608, 31);
        r1 = r23 & (-458753);
    L151:
        if (r13 == 0) goto L153;
        r14 = null;
    L153:
        if (r9 == 0) goto L155;
        PaddingValues r15 = ButtonDefaults.INSTANCE.getContentPadding();
    L156:
        if (r11 == 0) goto L158;
        r12 = null;
        r5 = r19;
        r6 = r21;
        r7 = r22;
    L131:
        int r16 = r1;
        BorderStroke r17 = r14;
    L159:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(-1943994298, r16, -1, "androidx.compose.material3.ElevatedButton (Button.kt:215)");
    L162:
        Button(r26, r3, r5, r6, r7, r8, r17, r15, r12, r35, r10, (((((((((r16 & 14) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16)) | (29360128 & r16)) | (234881024 & r16)) | (r16 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final Modifier r18 = r3;
        final Shape r20 = r6;
        final ButtonElevation r24 = r8;
        final PaddingValues r25 = r15;
        final boolean r39 = r5;
        final ButtonColors r40 = r7;
        final BorderStroke r41 = r17;
    L167:
        ScopeUpdateScope r110 = r10.endRestartGroup();
        if (r110 == null) goto L171;
        r110.updateScope(new m2(r26, r18, r39, r20, r40, r24, r41, r25, r12, r35, r37, r38));
        return;
    L171:
        return;
    L158:
        r12 = r34;
        r16 = r1;
        r17 = r14;
        r5 = r19;
        r6 = r21;
        r7 = r22;
        goto L159
    L155:
        r15 = r33;
        goto L156
    L149:
        r1 = r23;
        goto L151
    L145:
        r23 = r1;
        r22 = r7;
        goto L147
    L141:
        r21 = r6;
        goto L143
    L134:
        r3 = r27;
        goto L135
    L119:
        if (r10.getDefaultsInvalid() == true) goto L132;
        r10.skipToGroupEnd();
        if ((r38 & 8) == 0) goto L125;
        r1 = r1 & (-7169);
    L125:
        if ((r38 & 16) == 0) goto L128;
        r1 = r1 & (-57345);
    L128:
        if ((r38 & 32) == 0) goto L130;
        r1 = r1 & (-458753);
    L130:
        r3 = r27;
        r15 = r33;
        goto L131
    L166:
        r10.skipToGroupEnd();
        r18 = r27;
        r12 = r34;
        r39 = r5;
        r20 = r6;
        r40 = r7;
        r24 = r8;
        r41 = r14;
        r25 = r33;
        goto L167
    L113:
        r0 = false;
        goto L115
    L103:
        if ((r37 & 805306368) != 0) goto L110;
        if (r10.changedInstance(r35) == false) goto L107;
        int r111 = 536870912;
    L108:
        r1 = r1 | r111;
        goto L110
    L107:
        r111 = 268435456;
        goto L108
    L92:
        if ((r37 & 100663296) != 0) goto L98;
        r12 = r34;
        if (r10.changed(r12) == false) goto L96;
        int r112 = 67108864;
    L97:
        r1 = r1 | r112;
        goto L100
    L96:
        r112 = 33554432;
        goto L97
    L82:
        if ((r37 & 12582912) != 0) goto L88;
        if (r10.changed(r33) == false) goto L86;
        int r113 = 8388608;
    L87:
        r1 = r1 | r113;
        goto L88
    L86:
        r113 = 4194304;
        goto L87
    L71:
        r14 = r32;
        if ((1572864 & r37) != 0) goto L78;
        if (r10.changed(r14) == false) goto L76;
        int r42 = 1048576;
    L77:
        r1 = r1 | r42;
        goto L78
    L76:
        r42 = 524288;
        goto L77
    L60:
        if ((r38 & 32) != 0) goto L64;
        r8 = r31;
        if (r10.changed(r8) == false) goto L65;
        int r43 = 131072;
    L66:
        r1 = r1 | r43;
    L65:
        r43 = 65536;
        goto L66
    L64:
        r8 = r31;
        goto L65
    L49:
        if ((r38 & 16) != 0) goto L53;
        r7 = r30;
        if (r10.changed(r7) == false) goto L54;
        int r44 = 16384;
    L55:
        r1 = r1 | r44;
    L54:
        r44 = 8192;
        goto L55
    L53:
        r7 = r30;
        goto L54
    L38:
        if ((r38 & 8) != 0) goto L42;
        r6 = r29;
        if (r10.changed(r6) == false) goto L43;
        int r45 = 2048;
    L44:
        r1 = r1 | r45;
    L43:
        r45 = 1024;
        goto L44
    L42:
        r6 = r29;
        goto L43
    L28:
        if ((r37 & 384) != 0) goto L34;
        r5 = r28;
        if (r10.changed(r5) == false) goto L32;
        int r46 = 256;
    L33:
        r1 = r1 | r46;
        goto L36
    L32:
        r46 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r10.changed(r27) == false) goto L21;
        int r47 = 32;
    L22:
        r1 = r1 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r1 = r37;
        goto L13
    L8:
        if (r10.changedInstance(r26) == false) goto L10;
        int r48 = 4;
    L11:
        r1 = r48 | r37;
        goto L13
    L10:
        r48 = 2;
        goto L11
    }

    public static final void FilledTonalButton(final Function0<Unit> r26, Modifier r27, boolean r28, Shape r29, ButtonColors r30, ButtonElevation r31, BorderStroke r32, PaddingValues r33, MutableInteractionSource r34, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r10 = r36.startRestartGroup(-102343472);
        if ((r38 & 1) == 0) goto L6;
        int r1 = r37 | 6;
    L13:
        int r2 = r38 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r38 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        boolean r5 = r28;
    L36:
        if ((r37 & 3072) == 0) goto L38;
        Shape r6 = r29;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        ButtonColors r7 = r30;
    L58:
        if ((196608 & r37) == 0) goto L60;
        ButtonElevation r8 = r31;
    L68:
        int r13 = r38 & 64;
        if (r13 == 0) goto L71;
        r1 = r1 | 1572864;
        BorderStroke r14 = r32;
    L78:
        int r9 = r38 & 128;
        if (r9 == 0) goto L82;
        r1 = r1 | 12582912;
    L88:
        int r11 = r38 & 256;
        if (r11 == 0) goto L92;
        r1 = r1 | 100663296;
    L98:
        final MutableInteractionSource r12 = r34;
    L100:
        if ((r38 & 512) == 0) goto L103;
        r1 = r1 | 805306368;
    L110:
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L113;
        boolean r0 = true;
    L115:
        if (r10.shouldExecute(r0, r1 & 1) == false) goto L166;
        r10.startDefaults();
        if ((r37 & 1) != 0) goto L119;
    L132:
        if (r2 == 0) goto L134;
        Modifier r3 = Modifier.Companion;
    L135:
        if (r4 != 0) goto L139;
        r19 = r5;
    L139:
        if ((r38 & 8) == 0) goto L141;
        r1 = r1 & (-7169);
        Shape r21 = ButtonDefaults.INSTANCE.getFilledTonalShape(r10, 6);
    L143:
        if ((r38 & 16) == 0) goto L145;
        int r23 = r1 & (-57345);
        ButtonColors r22 = ButtonDefaults.INSTANCE.filledTonalButtonColors(r10, 6);
    L147:
        if ((r38 & 32) == 0) goto L149;
        r8 = ButtonDefaults.INSTANCE.m2355filledTonalButtonElevationR_JCAzs(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r10, 196608, 31);
        r1 = r23 & (-458753);
    L151:
        if (r13 == 0) goto L153;
        r14 = null;
    L153:
        if (r9 == 0) goto L155;
        PaddingValues r15 = ButtonDefaults.INSTANCE.getContentPadding();
    L156:
        if (r11 == 0) goto L158;
        r12 = null;
        r5 = r19;
        r6 = r21;
        r7 = r22;
    L131:
        int r16 = r1;
        BorderStroke r17 = r14;
    L159:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(-102343472, r16, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:288)");
    L162:
        Button(r26, r3, r5, r6, r7, r8, r17, r15, r12, r35, r10, (((((((((r16 & 14) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16)) | (29360128 & r16)) | (234881024 & r16)) | (r16 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final Modifier r18 = r3;
        final Shape r20 = r6;
        final ButtonElevation r24 = r8;
        final PaddingValues r25 = r15;
        final boolean r39 = r5;
        final ButtonColors r40 = r7;
        final BorderStroke r41 = r17;
    L167:
        ScopeUpdateScope r110 = r10.endRestartGroup();
        if (r110 == null) goto L171;
        r110.updateScope(new o2(r26, r18, r39, r20, r40, r24, r41, r25, r12, r35, r37, r38));
        return;
    L171:
        return;
    L158:
        r12 = r34;
        r16 = r1;
        r17 = r14;
        r5 = r19;
        r6 = r21;
        r7 = r22;
        goto L159
    L155:
        r15 = r33;
        goto L156
    L149:
        r1 = r23;
        goto L151
    L145:
        r23 = r1;
        r22 = r7;
        goto L147
    L141:
        r21 = r6;
        goto L143
    L134:
        r3 = r27;
        goto L135
    L119:
        if (r10.getDefaultsInvalid() == true) goto L132;
        r10.skipToGroupEnd();
        if ((r38 & 8) == 0) goto L125;
        r1 = r1 & (-7169);
    L125:
        if ((r38 & 16) == 0) goto L128;
        r1 = r1 & (-57345);
    L128:
        if ((r38 & 32) == 0) goto L130;
        r1 = r1 & (-458753);
    L130:
        r3 = r27;
        r15 = r33;
        goto L131
    L166:
        r10.skipToGroupEnd();
        r18 = r27;
        r12 = r34;
        r39 = r5;
        r20 = r6;
        r40 = r7;
        r24 = r8;
        r41 = r14;
        r25 = r33;
        goto L167
    L113:
        r0 = false;
        goto L115
    L103:
        if ((r37 & 805306368) != 0) goto L110;
        if (r10.changedInstance(r35) == false) goto L107;
        int r111 = 536870912;
    L108:
        r1 = r1 | r111;
        goto L110
    L107:
        r111 = 268435456;
        goto L108
    L92:
        if ((r37 & 100663296) != 0) goto L98;
        r12 = r34;
        if (r10.changed(r12) == false) goto L96;
        int r112 = 67108864;
    L97:
        r1 = r1 | r112;
        goto L100
    L96:
        r112 = 33554432;
        goto L97
    L82:
        if ((r37 & 12582912) != 0) goto L88;
        if (r10.changed(r33) == false) goto L86;
        int r113 = 8388608;
    L87:
        r1 = r1 | r113;
        goto L88
    L86:
        r113 = 4194304;
        goto L87
    L71:
        r14 = r32;
        if ((1572864 & r37) != 0) goto L78;
        if (r10.changed(r14) == false) goto L76;
        int r42 = 1048576;
    L77:
        r1 = r1 | r42;
        goto L78
    L76:
        r42 = 524288;
        goto L77
    L60:
        if ((r38 & 32) != 0) goto L64;
        r8 = r31;
        if (r10.changed(r8) == false) goto L65;
        int r43 = 131072;
    L66:
        r1 = r1 | r43;
    L65:
        r43 = 65536;
        goto L66
    L64:
        r8 = r31;
        goto L65
    L49:
        if ((r38 & 16) != 0) goto L53;
        r7 = r30;
        if (r10.changed(r7) == false) goto L54;
        int r44 = 16384;
    L55:
        r1 = r1 | r44;
    L54:
        r44 = 8192;
        goto L55
    L53:
        r7 = r30;
        goto L54
    L38:
        if ((r38 & 8) != 0) goto L42;
        r6 = r29;
        if (r10.changed(r6) == false) goto L43;
        int r45 = 2048;
    L44:
        r1 = r1 | r45;
    L43:
        r45 = 1024;
        goto L44
    L42:
        r6 = r29;
        goto L43
    L28:
        if ((r37 & 384) != 0) goto L34;
        r5 = r28;
        if (r10.changed(r5) == false) goto L32;
        int r46 = 256;
    L33:
        r1 = r1 | r46;
        goto L36
    L32:
        r46 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r10.changed(r27) == false) goto L21;
        int r47 = 32;
    L22:
        r1 = r1 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r1 = r37;
        goto L13
    L8:
        if (r10.changedInstance(r26) == false) goto L10;
        int r48 = 4;
    L11:
        r1 = r48 | r37;
        goto L13
    L10:
        r48 = 2;
        goto L11
    }

    public static final void OutlinedButton(final Function0<Unit> r27, Modifier r28, boolean r29, Shape r30, ButtonColors r31, ButtonElevation r32, BorderStroke r33, PaddingValues r34, MutableInteractionSource r35, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(399974542);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r4 = r39 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r39 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r38 & 3072) == 0) goto L38;
        Shape r8 = r30;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        ButtonColors r9 = r31;
    L57:
        int r10 = r39 & 32;
        if (r10 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        ButtonElevation r13 = r32;
    L69:
        if ((1572864 & r38) == 0) goto L71;
        BorderStroke r14 = r33;
    L79:
        int r15 = r39 & 128;
        if (r15 == 0) goto L83;
        r3 = r3 | 12582912;
    L89:
        int r0 = r39 & 256;
        if (r0 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r39 & 512) == 0) goto L103;
        r3 = r3 | 805306368;
    L111:
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L166;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L119;
    L131:
        if (r4 == 0) goto L133;
        final Modifier r5 = Modifier.Companion;
    L134:
        if (r6 == 0) goto L136;
        boolean r7 = true;
    L138:
        if ((r39 & 8) == 0) goto L140;
        Shape r11 = ButtonDefaults.INSTANCE.getOutlinedShape(r1, 6);
        r3 = r3 & (-7169);
    L142:
        if ((r39 & 16) == 0) goto L144;
        final ButtonColors r12 = ButtonDefaults.INSTANCE.outlinedButtonColors(r1, 6);
        r3 = r3 & (-57345);
    L145:
        MutableInteractionSource r16 = null;
        if (r10 == 0) goto L149;
        r13 = null;
    L149:
        if ((r39 & 64) == 0) goto L151;
        final BorderStroke r17 = ButtonDefaults.INSTANCE.outlinedButtonBorder(r7, r1, ((r3 >> 6) & 14) | 48, 0);
        r3 = r3 & (-3670017);
    L152:
        if (r15 == 0) goto L154;
        PaddingValues r18 = ButtonDefaults.INSTANCE.getContentPadding();
    L155:
        if (r0 != 0) goto L158;
        r16 = r35;
    L158:
        ButtonElevation r19 = r13;
    L159:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(399974542, r3, -1, "androidx.compose.material3.OutlinedButton (Button.kt:360)");
    L162:
        Button(r27, r5, r7, r11, r12, r19, r17, r18, r16, r36, r1, (((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final boolean r20 = r7;
        final Shape r21 = r11;
        final ButtonElevation r22 = r19;
        PaddingValues r26 = r18;
        final MutableInteractionSource r23 = r16;
        final PaddingValues r24 = r26;
    L167:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L171;
        r110.updateScope(new p2(r27, r5, r20, r21, r12, r22, r17, r24, r23, r36, r38, r39));
        return;
    L171:
        return;
    L154:
        r18 = r34;
        goto L155
    L151:
        r17 = r14;
        goto L152
    L144:
        r12 = r9;
        goto L145
    L140:
        r11 = r8;
        goto L142
    L136:
        r7 = r29;
        goto L138
    L133:
        r5 = r28;
        goto L134
    L119:
        if (r1.getDefaultsInvalid() == true) goto L131;
        r1.skipToGroupEnd();
        if ((r39 & 8) == 0) goto L125;
        r3 = r3 & (-7169);
    L125:
        if ((r39 & 16) == 0) goto L128;
        r3 = r3 & (-57345);
    L128:
        if ((r39 & 64) == 0) goto L130;
        r3 = r3 & (-3670017);
    L130:
        r5 = r28;
        r7 = r29;
        r11 = r8;
        r12 = r9;
        r19 = r13;
        r17 = r14;
        r18 = r34;
        r16 = r35;
        goto L159
    L166:
        r1.skipToGroupEnd();
        r5 = r28;
        r20 = r29;
        r21 = r8;
        r12 = r9;
        r22 = r13;
        r17 = r14;
        r24 = r34;
        r23 = r35;
        goto L167
    L113:
        r2 = false;
        goto L115
    L103:
        if ((r38 & 805306368) != 0) goto L111;
        if (r1.changedInstance(r36) == false) goto L107;
        int r111 = 536870912;
    L108:
        r3 = r3 | r111;
        goto L111
    L107:
        r111 = 268435456;
        goto L108
    L93:
        if ((r38 & 100663296) != 0) goto L100;
        if (r1.changed(r35) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L100
    L97:
        r112 = 33554432;
        goto L98
    L83:
        if ((r38 & 12582912) != 0) goto L89;
        if (r1.changed(r34) == false) goto L87;
        int r113 = 8388608;
    L88:
        r3 = r3 | r113;
        goto L89
    L87:
        r113 = 4194304;
        goto L88
    L71:
        if ((r39 & 64) != 0) goto L75;
        r14 = r33;
        if (r1.changed(r14) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
    L76:
        r114 = 524288;
        goto L77
    L75:
        r14 = r33;
        goto L76
    L61:
        if ((196608 & r38) != 0) goto L67;
        r13 = r32;
        if (r1.changed(r13) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L69
    L65:
        r115 = 65536;
        goto L66
    L49:
        if ((r39 & 16) != 0) goto L53;
        r9 = r31;
        if (r1.changed(r9) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r9 = r31;
        goto L54
    L38:
        if ((r39 & 8) != 0) goto L42;
        r8 = r30;
        if (r1.changed(r8) == false) goto L43;
        int r25 = 2048;
    L44:
        r3 = r3 | r25;
    L43:
        r25 = 1024;
        goto L44
    L42:
        r8 = r30;
        goto L43
    L28:
        if ((r38 & 384) != 0) goto L36;
        if (r1.changed(r29) == false) goto L32;
        int r40 = 256;
    L33:
        r3 = r3 | r40;
        goto L36
    L32:
        r40 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changed(r28) == false) goto L21;
        int r41 = 32;
    L22:
        r3 = r3 | r41;
        goto L24
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r1.changedInstance(r27) == false) goto L10;
        int r42 = 4;
    L11:
        r3 = r42 | r38;
        goto L13
    L10:
        r42 = 2;
        goto L11
    }

    public static final void TextButton(final Function0<Unit> r27, Modifier r28, boolean r29, Shape r30, ButtonColors r31, ButtonElevation r32, BorderStroke r33, PaddingValues r34, MutableInteractionSource r35, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(-1061374109);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r4 = r39 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r39 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r38 & 3072) == 0) goto L38;
        Shape r8 = r30;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        ButtonColors r9 = r31;
    L57:
        int r10 = r39 & 32;
        if (r10 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        ButtonElevation r13 = r32;
    L68:
        int r14 = r39 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        BorderStroke r15 = r33;
    L79:
        int r0 = r39 & 128;
        if (r0 == 0) goto L83;
        r3 = r3 | 12582912;
    L89:
        int r2 = r39 & 256;
        if (r2 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r39 & 512) == 0) goto L103;
        r3 = r3 | 805306368;
    L110:
        boolean r17 = true;
        if ((r3 & 306783379) == 306783378) goto L113;
        boolean r5 = true;
    L115:
        if (r1.shouldExecute(r5, r3 & 1) == false) goto L161;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L119;
    L128:
        if (r4 == 0) goto L130;
        Modifier r7 = Modifier.Companion;
    L131:
        if (r6 != 0) goto L135;
        r17 = r29;
    L135:
        if ((r39 & 8) == 0) goto L137;
        Shape r11 = ButtonDefaults.INSTANCE.getTextShape(r1, 6);
        r3 = r3 & (-7169);
    L139:
        if ((r39 & 16) == 0) goto L141;
        ButtonColors r12 = ButtonDefaults.INSTANCE.textButtonColors(r1, 6);
        r3 = r3 & (-57345);
    L143:
        if (r10 == 0) goto L145;
        r13 = null;
    L145:
        if (r14 == 0) goto L147;
        r15 = null;
    L147:
        if (r0 == 0) goto L149;
        PaddingValues r16 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
    L150:
        if (r2 == 0) goto L152;
        MutableInteractionSource r18 = null;
    L153:
        boolean r19 = r17;
    L154:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L157;
        ComposerKt.traceEventStart(-1061374109, r3, -1, "androidx.compose.material3.TextButton (Button.kt:429)");
    L157:
        Button(r27, r7, r19, r11, r12, r13, r15, r16, r18, r36, r1, (((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        final MutableInteractionSource r20 = r18;
        final PaddingValues r21 = r16;
        final BorderStroke r22 = r15;
        final boolean r23 = r19;
        ButtonColors r26 = r12;
        final ButtonElevation r24 = r13;
        final Modifier r25 = r7;
        final Shape r40 = r11;
        final ButtonColors r41 = r26;
    L162:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L166;
        r110.updateScope(new n2(r27, r25, r23, r40, r41, r24, r22, r21, r20, r36, r38, r39));
        return;
    L166:
        return;
    L152:
        r18 = r35;
        goto L153
    L149:
        r16 = r34;
        goto L150
    L141:
        r12 = r9;
        goto L143
    L137:
        r11 = r8;
        goto L139
    L130:
        r7 = r28;
        goto L131
    L119:
        if (r1.getDefaultsInvalid() == true) goto L128;
        r1.skipToGroupEnd();
        if ((r39 & 8) == 0) goto L125;
        r3 = r3 & (-7169);
    L125:
        if ((r39 & 16) == 0) goto L127;
        r3 = r3 & (-57345);
    L127:
        r7 = r28;
        r19 = r29;
        r16 = r34;
        r11 = r8;
        r12 = r9;
        r13 = r13;
        r18 = r35;
        r3 = r3;
        r15 = r15;
        goto L154
    L161:
        r1.skipToGroupEnd();
        r25 = r28;
        r23 = r29;
        r40 = r8;
        r41 = r9;
        r24 = r13;
        r22 = r15;
        r21 = r34;
        r20 = r35;
        goto L162
    L113:
        r5 = false;
        goto L115
    L103:
        if ((r38 & 805306368) != 0) goto L110;
        if (r1.changedInstance(r36) == false) goto L107;
        int r111 = 536870912;
    L108:
        r3 = r3 | r111;
        goto L110
    L107:
        r111 = 268435456;
        goto L108
    L93:
        if ((r38 & 100663296) != 0) goto L100;
        if (r1.changed(r35) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L100
    L97:
        r112 = 33554432;
        goto L98
    L83:
        if ((r38 & 12582912) != 0) goto L89;
        if (r1.changed(r34) == false) goto L87;
        int r113 = 8388608;
    L88:
        r3 = r3 | r113;
        goto L89
    L87:
        r113 = 4194304;
        goto L88
    L72:
        if ((1572864 & r38) != 0) goto L78;
        r15 = r33;
        if (r1.changed(r15) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L79
    L76:
        r114 = 524288;
        goto L77
    L61:
        if ((196608 & r38) != 0) goto L67;
        r13 = r32;
        if (r1.changed(r13) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L68
    L65:
        r115 = 65536;
        goto L66
    L49:
        if ((r39 & 16) != 0) goto L53;
        r9 = r31;
        if (r1.changed(r9) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
    L54:
        r116 = 8192;
        goto L55
    L53:
        r9 = r31;
        goto L54
    L38:
        if ((r39 & 8) != 0) goto L42;
        r8 = r30;
        if (r1.changed(r8) == false) goto L43;
        int r42 = 2048;
    L44:
        r3 = r3 | r42;
    L43:
        r42 = 1024;
        goto L44
    L42:
        r8 = r30;
        goto L43
    L28:
        if ((r38 & 384) != 0) goto L36;
        if (r1.changed(r29) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L36
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changed(r28) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r1.changedInstance(r27) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r38;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }
}
