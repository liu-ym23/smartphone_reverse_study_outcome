package androidx.compose.material;

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
import androidx.compose.ui.graphics.Color;
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
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonKt {
    private static final Unit Button$lambda$4(Function0 r14, Modifier r15, boolean r16, MutableInteractionSource r17, ButtonElevation r18, Shape r19, BorderStroke r20, ButtonColors r21, PaddingValues r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        Button(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return Button$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit b(Function0 r0, Modifier r1, boolean r2, MutableInteractionSource r3, ButtonElevation r4, Shape r5, BorderStroke r6, ButtonColors r7, PaddingValues r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return Button$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private static final long Button$lambda$1(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final Unit Button$lambda$3$lambda$2(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ long access$Button$lambda$1(State r2) {
        return Button$lambda$1(r2);
    }

    public static final void Button(final Function0<Unit> r35, Modifier r36, boolean r37, MutableInteractionSource r38, ButtonElevation r39, Shape r40, BorderStroke r41, ButtonColors r42, PaddingValues r43, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r44, Composer r45, final int r46, final int r47) {
        Composer r14 = r45.startRestartGroup(-1084573925);
        if ((r47 & 1) == 0) goto L6;
        int r1 = r46 | 6;
    L13:
        int r2 = r47 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r47 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        boolean r5 = r37;
    L35:
        int r6 = r47 & 8;
        if (r6 == 0) goto L39;
        r1 = r1 | 3072;
    L45:
        MutableInteractionSource r7 = r38;
    L47:
        if ((r46 & 24576) == 0) goto L49;
        ButtonElevation r8 = r39;
    L58:
        if ((196608 & r46) != 0) goto L66;
        Shape r13 = r40;
        if ((r47 & 32) == 0) goto L62;
    L64:
        int r9 = 65536;
    L65:
        r1 = r1 | r9;
    L67:
        int r16 = r47 & 64;
        if (r16 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        BorderStroke r10 = r41;
    L79:
        if ((r46 & 12582912) != 0) goto L89;
        if ((r47 & 128) != 0) goto L86;
        if (r14.changed(r42) == false) goto L86;
        int r17 = 8388608;
    L87:
        r1 = r1 | r17;
    L86:
        r17 = 4194304;
    L89:
        int r15 = r47 & 256;
        if (r15 == 0) goto L93;
        r1 = r1 | 100663296;
    L101:
        if ((r47 & 512) == 0) goto L104;
        r1 = r1 | 805306368;
    L110:
        int r0 = r1;
        if ((306783379 & r0) == 306783378) goto L113;
        boolean r3 = true;
    L115:
        if (r14.shouldExecute(r3, r0 & 1) == false) goto L181;
        r14.startDefaults();
        if ((r46 & 1) != 0) goto L119;
    L131:
        if (r2 == 0) goto L133;
        Modifier r28 = Modifier.Companion;
    L134:
        if (r4 == 0) goto L136;
        boolean r29 = true;
    L137:
        if (r6 == 0) goto L139;
        MutableInteractionSource r30 = null;
    L141:
        if ((r47 & 16) == 0) goto L144;
        r0 = r0 & (-57345);
        r8 = ButtonDefaults.INSTANCE.m1968elevationR_JCAzs(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r14, 196608, 31);
    L144:
        if ((r47 & 32) == 0) goto L146;
        Shape r11 = MaterialTheme.INSTANCE.getShapes(r14, 6).getSmall();
        r0 = r0 & (-458753);
    L147:
        if (r16 == 0) goto L149;
        BorderStroke r12 = null;
    L151:
        if ((r47 & 128) == 0) goto L153;
        Composer r18 = r14;
        ButtonColors r19 = ButtonDefaults.INSTANCE.m1967buttonColorsro_MJ88(0, 0, 0, 0, r18, 24576, 15);
        r0 = r0 & (-29360129);
    L154:
        if (r15 == 0) goto L156;
        int r110 = r0;
        ButtonColors r20 = r19;
        final PaddingValues r111 = ButtonDefaults.INSTANCE.getContentPadding();
        Modifier r21 = r28;
        r5 = r29;
        r7 = r30;
        Shape r22 = r11;
        BorderStroke r23 = r12;
    L157:
        r18.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventStart(-1084573925, r110, -1, "androidx.compose.material.Button (Button.kt:105)");
    L160:
        if (r7 != null) goto L165;
        r18.startReplaceGroup(497772480);
        Object r24 = r18.rememberedValue();
        if (r24 != Composer.Companion.getEmpty()) goto L164;
        r24 = InteractionSourceKt.MutableInteractionSource();
        r18.updateRememberedValue(r24);
    L164:
        MutableInteractionSource r25 = (MutableInteractionSource) r24;
        r18.endReplaceGroup();
    L166:
        int r26 = r110 >> 6;
        int r112 = r26 & 14;
        MutableInteractionSource r310 = r7;
        int r27 = r112 | ((r110 >> 18) & 112);
        final State<Color> r113 = r20.contentColor(r5, r18, r27);
        Object r114 = r18.rememberedValue();
        BorderStroke r311 = r23;
        if (r114 != Composer.Companion.getEmpty()) goto L169;
        r114 = new o2();
        r18.updateRememberedValue(r114);
    L169:
        Shape r312 = r22;
        int r115 = r110;
        State<Dp> r31 = null;
        Modifier r116 = SemanticsModifierKt.semantics$default(r21, false, (Function1) r114, 1, null);
        long r117 = ((Color) r20.backgroundColor(r5, r18, r27).getValue()).unbox-impl();
        long r210 = Color.copy-wmQWz5c$default(Button$lambda$1(r113), 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        if (r8 != null) goto L172;
        r18.startReplaceGroup(498179137);
    L173:
        r18.endReplaceGroup();
        if (r31 == null) goto L176;
        float r32 = ((Dp) r31.getValue()).unbox-impl();
    L177:
        PaddingValues r33 = r111;
        boolean r118 = r5;
        MutableInteractionSource r211 = r25;
        Composer r212 = r18;
        SurfaceKt.m2176SurfaceLPr_se0(r35, r116, r118, r312, r117, r210, r311, r32, r211, ComposableLambdaKt.rememberComposableLambda(-20345758, true, new AnonymousClass2(r113, r111, r44), r18, 54), r212, ((r26 & 7168) | (((r115 & 14) | 805306368) | (r115 & 896))) | (3670016 & r115), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        final BorderStroke r34 = r311;
        final Modifier r48 = r21;
        PaddingValues r119 = r33;
        final boolean r49 = r5;
        final ButtonElevation r50 = r8;
        final MutableInteractionSource r51 = r310;
        final ButtonColors r52 = r20;
        final Shape r53 = r312;
    L182:
        ScopeUpdateScope r120 = r18.endRestartGroup();
        if (r120 == null) goto L186;
        final PaddingValues r54 = r119;
        r120.updateScope(new p2(r35, r48, r49, r51, r50, r53, r34, r52, r54, r44, r46, r47));
        return;
    L186:
        return;
    L176:
        r32 = Dp.constructor-impl(0);
        goto L177
    L172:
        r18.startReplaceGroup(1401543616);
        r31 = r8.elevation(r5, r25, r18, (r26 & 896) | r112);
        goto L173
    L165:
        r18.startReplaceGroup(1401529847);
        r18.endReplaceGroup();
        r25 = r7;
        goto L166
    L156:
        r23 = r12;
        r111 = r43;
        r110 = r0;
        r20 = r19;
        r21 = r28;
        r5 = r29;
        r7 = r30;
        r22 = r11;
        goto L157
    L153:
        r18 = r14;
        r19 = r42;
        goto L154
    L149:
        r12 = r41;
        goto L151
    L146:
        r11 = r13;
        goto L147
    L139:
        r30 = r7;
        goto L141
    L136:
        r29 = r5;
        goto L137
    L133:
        r28 = r36;
        goto L134
    L119:
        if (r14.getDefaultsInvalid() == true) goto L131;
        r14.skipToGroupEnd();
        if ((r47 & 16) == 0) goto L125;
        r0 = r0 & (-57345);
    L125:
        if ((r47 & 32) == 0) goto L128;
        r0 = r0 & (-458753);
    L128:
        if ((r47 & 128) == 0) goto L130;
        r0 = r0 & (-29360129);
    L130:
        r20 = r42;
        r111 = r43;
        r23 = r10;
        r22 = r13;
        r18 = r14;
        r110 = r0;
        r21 = r36;
        goto L157
    L181:
        r18 = r14;
        r18.skipToGroupEnd();
        r48 = r36;
        r119 = r43;
        r49 = r5;
        r51 = r7;
        r50 = r8;
        r53 = r13;
        r34 = r41;
        r52 = r42;
        goto L182
    L113:
        r3 = false;
        goto L115
    L104:
        if ((r46 & 805306368) != 0) goto L110;
        if (r14.changedInstance(r44) == false) goto L108;
        int r55 = 536870912;
    L109:
        r1 = r1 | r55;
        goto L110
    L108:
        r55 = 268435456;
        goto L109
    L93:
        if ((r46 & 100663296) != 0) goto L101;
        if (r14.changed(r43) == false) goto L97;
        int r121 = 67108864;
    L98:
        r1 = r1 | r121;
        goto L101
    L97:
        r121 = 33554432;
        goto L98
    L71:
        if ((1572864 & r46) != 0) goto L77;
        r10 = r41;
        if (r14.changed(r10) == false) goto L75;
        int r122 = 1048576;
    L76:
        r1 = r1 | r122;
        goto L79
    L75:
        r122 = 524288;
        goto L76
    L62:
        if (r14.changed(r13) == false) goto L64;
        r9 = 131072;
        goto L65
    L66:
        r13 = r40;
        goto L67
    L49:
        if ((r47 & 16) != 0) goto L53;
        r8 = r39;
        if (r14.changed(r8) == false) goto L54;
        int r56 = 16384;
    L55:
        r1 = r1 | r56;
    L54:
        r56 = 8192;
        goto L55
    L53:
        r8 = r39;
        goto L54
    L39:
        if ((r46 & 3072) != 0) goto L45;
        r7 = r38;
        if (r14.changed(r7) == false) goto L43;
        int r57 = 2048;
    L44:
        r1 = r1 | r57;
        goto L47
    L43:
        r57 = 1024;
        goto L44
    L28:
        if ((r46 & 384) != 0) goto L34;
        r5 = r37;
        if (r14.changed(r5) == false) goto L32;
        int r58 = 256;
    L33:
        r1 = r1 | r58;
        goto L35
    L32:
        r58 = 128;
        goto L33
    L17:
        if ((r46 & 48) != 0) goto L24;
        if (r14.changed(r36) == false) goto L21;
        int r59 = 32;
    L22:
        r1 = r1 | r59;
        goto L24
    L21:
        r59 = 16;
        goto L22
    L6:
        if ((r46 & 6) == 0) goto L8;
        r1 = r46;
        goto L13
    L8:
        if (r14.changedInstance(r35) == false) goto L10;
        int r60 = 4;
    L11:
        r1 = r60 | r46;
        goto L13
    L10:
        r60 = 2;
        goto L11
    }

    public static final void OutlinedButton(Function0<Unit> r19, Modifier r20, boolean r21, MutableInteractionSource r22, ButtonElevation r23, Shape r24, BorderStroke r25, ButtonColors r26, PaddingValues r27, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r28, Composer r29, int r30, int r31) {
        if ((r31 & 2) == 0) goto L5;
        Modifier r13 = Modifier.Companion;
    L7:
        if ((r31 & 4) == 0) goto L9;
        boolean r14 = true;
    L11:
        if ((r31 & 8) == 0) goto L13;
        MutableInteractionSource r15 = null;
    L15:
        if ((r31 & 16) == 0) goto L17;
        ButtonElevation r16 = null;
    L19:
        if ((r31 & 32) == 0) goto L21;
        Shape r17 = MaterialTheme.INSTANCE.getShapes(r29, 6).getSmall();
    L23:
        if ((r31 & 64) == 0) goto L25;
        BorderStroke r18 = ButtonDefaults.INSTANCE.getOutlinedBorder(r29, 6);
    L27:
        if ((r31 & 128) == 0) goto L29;
        ButtonColors r7 = ButtonDefaults.INSTANCE.m1975outlinedButtonColorsRGew2ao(0, 0, 0, r29, 3072, 7);
    L31:
        if ((r31 & 256) == 0) goto L33;
        PaddingValues r8 = ButtonDefaults.INSTANCE.getContentPadding();
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(-1445054947, r30, -1, "androidx.compose.material.OutlinedButton (Button.kt:181)");
    L37:
        Button(r19, r13, r14, r15, r16, r17, r18, r7, r8, r28, r29, (((((((((r30 & 14) | (r30 & 112)) | (r30 & 896)) | (r30 & 7168)) | (57344 & r30)) | (458752 & r30)) | (3670016 & r30)) | (29360128 & r30)) | (234881024 & r30)) | (1879048192 & r30), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
        return;
    L41:
        return;
    L33:
        r8 = r27;
        goto L35
    L29:
        r7 = r26;
        goto L31
    L25:
        r18 = r25;
        goto L27
    L21:
        r17 = r24;
        goto L23
    L17:
        r16 = r23;
        goto L19
    L13:
        r15 = r22;
        goto L15
    L9:
        r14 = r21;
        goto L11
    L5:
        r13 = r20;
        goto L7
    }

    public static final void TextButton(Function0<Unit> r19, Modifier r20, boolean r21, MutableInteractionSource r22, ButtonElevation r23, Shape r24, BorderStroke r25, ButtonColors r26, PaddingValues r27, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r28, Composer r29, int r30, int r31) {
        if ((r31 & 2) == 0) goto L5;
        Modifier r4 = Modifier.Companion;
    L7:
        if ((r31 & 4) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r31 & 8) == 0) goto L13;
        MutableInteractionSource r6 = null;
    L15:
        if ((r31 & 16) == 0) goto L17;
        ButtonElevation r7 = null;
    L19:
        if ((r31 & 32) == 0) goto L21;
        Shape r8 = MaterialTheme.INSTANCE.getShapes(r29, 6).getSmall();
    L23:
        if ((r31 & 64) == 0) goto L25;
        BorderStroke r2 = null;
    L27:
        if ((r31 & 128) == 0) goto L29;
        ButtonColors r10 = ButtonDefaults.INSTANCE.m1976textButtonColorsRGew2ao(0, 0, 0, r29, 3072, 7);
    L31:
        if ((r31 & 256) == 0) goto L33;
        PaddingValues r11 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(724562088, r30, -1, "androidx.compose.material.TextButton (Button.kt:238)");
    L37:
        Button(r19, r4, r5, r6, r7, r8, r2, r10, r11, r28, r29, (((((((((r30 & 14) | (r30 & 112)) | (r30 & 896)) | (r30 & 7168)) | (57344 & r30)) | (458752 & r30)) | (3670016 & r30)) | (29360128 & r30)) | (234881024 & r30)) | (r30 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
        return;
    L41:
        return;
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r2 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r5 = r21;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }
}
