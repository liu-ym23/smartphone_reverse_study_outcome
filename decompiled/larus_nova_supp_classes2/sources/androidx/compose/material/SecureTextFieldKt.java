package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicSecureTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b!\u0010\"\u001añ\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b$\u0010\"\"\u000e\u0010%\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"SecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SecureTextField-0vce7ms", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;ICLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "OutlinedSecureTextField", "OutlinedSecureTextField-0vce7ms", "SecureTextFieldKeyboardOptions", "DefaultObfuscationCharacter", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final KeyboardOptions SecureTextFieldKeyboardOptions = null;

    private static final Unit OutlinedSecureTextField_0vce7ms$lambda$8(TextFieldState r21, Modifier r22, boolean r23, TextStyle r24, Function2 r25, Function2 r26, Function2 r27, Function2 r28, boolean r29, InputTransformation r30, int r31, char r32, KeyboardOptions r33, KeyboardActionHandler r34, Shape r35, TextFieldColors r36, MutableInteractionSource r37, int r38, int r39, int r40, Composer r41, int r42) {
        m2147OutlinedSecureTextField0vce7ms(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit SecureTextField_0vce7ms$lambda$2(TextFieldState r21, Modifier r22, boolean r23, TextStyle r24, Function2 r25, Function2 r26, Function2 r27, Function2 r28, boolean r29, InputTransformation r30, int r31, char r32, KeyboardOptions r33, KeyboardActionHandler r34, Shape r35, TextFieldColors r36, MutableInteractionSource r37, int r38, int r39, int r40, Composer r41, int r42) {
        m2148SecureTextField0vce7ms(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return OutlinedSecureTextField_0vce7ms$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit b(TextFieldState r1, Modifier r2, boolean r3, TextStyle r4, Function2 r5, Function2 r6, Function2 r7, Function2 r8, boolean r9, InputTransformation r10, int r11, char r12, KeyboardOptions r13, KeyboardActionHandler r14, Shape r15, TextFieldColors r16, MutableInteractionSource r17, int r18, int r19, int r20, Composer r21, int r22) {
        return OutlinedSecureTextField_0vce7ms$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ Unit c(TextFieldState r1, Modifier r2, boolean r3, TextStyle r4, Function2 r5, Function2 r6, Function2 r7, Function2 r8, boolean r9, InputTransformation r10, int r11, char r12, KeyboardOptions r13, KeyboardActionHandler r14, Shape r15, TextFieldColors r16, MutableInteractionSource r17, int r18, int r19, int r20, Composer r21, int r22) {
        return SecureTextField_0vce7ms$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    static {
        SecureTextFieldKeyboardOptions = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.getPassword-PjHm6EE(), 0, null, null, null, 121, null);
    }

    private static final Unit OutlinedSecureTextField_0vce7ms$lambda$6$lambda$5(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: OutlinedSecureTextField-0vce7ms, reason: not valid java name */
    public static final void m2147OutlinedSecureTextField0vce7ms(final TextFieldState r69, Modifier r70, boolean r71, TextStyle r72, Function2<? super Composer, ? super Integer, Unit> r73, Function2<? super Composer, ? super Integer, Unit> r74, Function2<? super Composer, ? super Integer, Unit> r75, Function2<? super Composer, ? super Integer, Unit> r76, boolean r77, InputTransformation r78, int r79, char r80, KeyboardOptions r81, KeyboardActionHandler r82, Shape r83, TextFieldColors r84, MutableInteractionSource r85, Composer r86, final int r87, final int r88, final int r89) {
        Composer r0 = r86.startRestartGroup(-1856037588);
        if ((r89 & 1) == 0) goto L6;
        int r4 = r87 | 6;
    L13:
        int r5 = r89 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r89 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = 2048;
        if ((r87 & 3072) != 0) goto L46;
        if ((r89 & 8) != 0) goto L43;
        if (r0.changed(r72) == false) goto L43;
        int r18 = 2048;
    L44:
        r4 = r4 | r18;
    L43:
        r18 = 1024;
    L46:
        int r19 = r89 & 16;
        int r110 = 8192;
        if (r19 == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        int r22 = r89 & 32;
        if (r22 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r26 = r89 & 64;
        if (r26 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r10 = r89 & 128;
        if (r10 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r89 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r89 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L108:
        if ((r88 & 6) == 0) goto L110;
        int r21 = r88;
    L118:
        int r3 = r89 & 2048;
        if (r3 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r89 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r8 = r89 & 8192;
        if (r8 == 0) goto L143;
        r6 = r6 | 3072;
    L151:
        if ((r88 & 24576) != 0) goto L161;
        if ((r89 & 16384) != 0) goto L158;
        if (r0.changed(r83) == false) goto L158;
        r110 = 16384;
    L158:
        r6 = r6 | r110;
    L161:
        if ((r88 & 196608) != 0) goto L170;
        if ((r89 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L165;
    L167:
        int r17 = 65536;
    L168:
        r6 = r6 | r17;
        goto L170
    L165:
        if (r0.changed(r84) == false) goto L167;
        r17 = 131072;
    L170:
        int r64 = r89 & 65536;
        if (r64 == 0) goto L174;
        r6 = r6 | 1572864;
    L181:
        if ((r4 & 306783379) == 306783378) goto L183;
    L186:
        boolean r11 = true;
    L188:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L289;
        r0.startDefaults();
        if ((r87 & 1) != 0) goto L192;
    L207:
        if (r5 == 0) goto L209;
        Modifier r12 = Modifier.Companion;
    L210:
        if (r9 == 0) goto L212;
        boolean r13 = true;
    L214:
        if ((r89 & 8) == 0) goto L216;
        TextStyle r14 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-7169);
    L217:
        if (r19 == 0) goto L219;
        Function2<? super Composer, ? super Integer, Unit> r65 = null;
    L220:
        if (r22 == 0) goto L222;
        Function2<? super Composer, ? super Integer, Unit> r66 = null;
    L223:
        if (r26 == 0) goto L225;
        Function2<? super Composer, ? super Integer, Unit> r67 = null;
    L226:
        if (r10 == 0) goto L228;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L229:
        if (r1 == 0) goto L231;
        boolean r20 = false;
    L232:
        if (r2 == 0) goto L234;
        InputTransformation r23 = null;
    L236:
        if ((r89 & 1024) == 0) goto L238;
        int r111 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
        r6 = r6 & (-15);
    L239:
        if (r3 == 0) goto L241;
        char r24 = DefaultObfuscationCharacter;
    L242:
        if (r7 == 0) goto L244;
        KeyboardOptions r25 = SecureTextFieldKeyboardOptions;
    L245:
        if (r8 == 0) goto L247;
        KeyboardActionHandler r27 = null;
    L249:
        if ((r89 & 16384) == 0) goto L251;
        Shape r112 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        r6 = r6 & (-57345);
    L253:
        if ((r89 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L255;
        TextFieldColors r28 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        r6 = r6 & (-458753);
    L256:
        int r113 = r4;
        int r114 = r6;
        if (r64 == 0) goto L259;
        MutableInteractionSource r29 = null;
    L260:
        TextFieldColors r30 = r28;
        boolean r31 = r20;
    L261:
        r0.endDefaults();
        char r810 = r24;
        if (ComposerKt.isTraceInProgress() == false) goto L265;
        ComposerKt.traceEventStart(-1856037588, r113, r114, "androidx.compose.material.OutlinedSecureTextField (SecureTextField.kt:243)");
    L265:
        if (r29 != null) goto L270;
        r0.startReplaceGroup(194195663);
        Object r32 = r0.rememberedValue();
        if (r32 != Composer.Companion.getEmpty()) goto L269;
        r32 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r32);
    L269:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r32;
    L271:
        r0.startReplaceGroup(-1240656518);
        long r115 = r14.getColor-0d7_KjU();
        if (r115 == 16) goto L274;
        boolean r33 = true;
    L275:
        if (r33 == true) goto L278;
        r115 = ((Color) r30.textColor(r13, r0, ((r113 >> 6) & 14) | ((r114 >> 12) & 112)).getValue()).unbox-impl();
    L278:
        r0.endReplaceGroup();
        TextStyle r211 = r14.merge(new TextStyle(r115, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        Density r34 = (Density) r0.consume(CompositionLocalsKt.getLocalDensity());
        if (r65 == null) goto L284;
        r0.startReplaceGroup(194672877);
        Modifier.Companion r116 = Modifier.Companion;
        Object r35 = r0.rememberedValue();
        if (r35 != Composer.Companion.getEmpty()) goto L283;
        r35 = new c9();
        r0.updateRememberedValue(r35);
    L283:
        Modifier r36 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r116, true, (Function1) r35), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r34.toDp-GaN1DYA(OutlinedTextFieldKt.getOutlinedTextFieldTopPadding()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 13, null);
        r0.endReplaceGroup();
    L285:
        Modifier r37 = TextFieldImplKt.defaultErrorSemantics(r12.then(r36), r31, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6));
        TextFieldDefaults r38 = TextFieldDefaults.INSTANCE;
        int r39 = ((r113 & 14) | (r113 & 896)) | ((r113 >> 15) & 57344);
        int r40 = r114 << 12;
        int r310 = (r39 | (3670016 & r40)) | (r40 & 29360128);
        int r41 = r114 << 6;
        boolean r117 = r13;
        InputTransformation r212 = r23;
        KeyboardOptions r213 = r25;
        KeyboardActionHandler r214 = r27;
        int r215 = r111;
        BasicSecureTextFieldKt.m1342BasicSecureTextFieldegD4TGM(r69, SizeKt.m998defaultMinSizeVpY3zN4(r37, r38.m2214getMinWidthD9Ej5fM(), r38.m2213getMinHeightD9Ej5fM()), r117, false, r212, r211, r213, r214, null, r210, new SolidColor(((Color) r30.cursorColor(r31, r0, ((r113 >> 24) & 14) | ((r114 >> 12) & 112)).getValue()).unbox-impl(), null), new SecureTextFieldKt$OutlinedSecureTextField$3(r69, r13, r210, r31, r65, r66, r67, r15, r112, r30), r215, r810, r0, r310, (r41 & 896) | (r41 & 7168), 264);
        if (ComposerKt.isTraceInProgress() == false) goto L288;
        ComposerKt.traceEventEnd();
    L288:
        final char r118 = r810;
        final int r119 = r111;
        final MutableInteractionSource r120 = r29;
        final Shape r121 = r112;
        final TextFieldColors r122 = r30;
        final KeyboardOptions r123 = r25;
        final KeyboardActionHandler r124 = r27;
        final boolean r42 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r66;
        final Function2<? super Composer, ? super Integer, Unit> r45 = r67;
        final TextStyle r46 = r14;
        final boolean r47 = r31;
        final InputTransformation r125 = r23;
        final Modifier r48 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r65;
    L290:
        ScopeUpdateScope r50 = r0.endRestartGroup();
        if (r50 == null) goto L294;
        r50.updateScope(new d9(r69, r48, r42, r46, r49, r44, r45, r43, r47, r125, r119, r118, r123, r124, r121, r122, r120, r87, r88, r89));
        return;
    L294:
        return;
    L284:
        r0.startReplaceGroup(195058238);
        r0.endReplaceGroup();
        r36 = Modifier.Companion;
        goto L285
    L274:
        r33 = false;
        goto L275
    L270:
        r0.startReplaceGroup(-1240662264);
        r0.endReplaceGroup();
        r210 = r29;
        goto L271
    L259:
        r29 = r85;
        goto L260
    L255:
        r28 = r84;
        goto L256
    L251:
        r112 = r83;
        goto L253
    L247:
        r27 = r82;
        goto L249
    L244:
        r25 = r81;
        goto L245
    L241:
        r24 = r80;
        goto L242
    L238:
        r111 = r79;
        goto L239
    L234:
        r23 = r78;
        goto L236
    L231:
        r20 = r77;
        goto L232
    L228:
        r15 = r76;
        goto L229
    L225:
        r67 = r75;
        goto L226
    L222:
        r66 = r74;
        goto L223
    L219:
        r65 = r73;
        goto L220
    L216:
        r14 = r72;
        goto L217
    L212:
        r13 = r71;
        goto L214
    L209:
        r12 = r70;
        goto L210
    L192:
        if (r0.getDefaultsInvalid() == true) goto L207;
        r0.skipToGroupEnd();
        if ((r89 & 8) == 0) goto L198;
        r4 = r4 & (-7169);
    L198:
        if ((r89 & 1024) == 0) goto L201;
        r6 = r6 & (-15);
    L201:
        if ((r89 & 16384) == 0) goto L204;
        r6 = r6 & (-57345);
    L204:
        if ((r89 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L206;
        r6 = r6 & (-458753);
    L206:
        r12 = r70;
        r13 = r71;
        r14 = r72;
        r65 = r73;
        r66 = r74;
        r67 = r75;
        r15 = r76;
        r31 = r77;
        r23 = r78;
        r111 = r79;
        r24 = r80;
        r25 = r81;
        r27 = r82;
        r112 = r83;
        r113 = r4;
        r114 = r6;
        r30 = r84;
        r29 = r85;
        goto L261
    L289:
        r0.skipToGroupEnd();
        r48 = r70;
        r42 = r71;
        r46 = r72;
        r49 = r73;
        r44 = r74;
        r45 = r75;
        r43 = r76;
        r47 = r77;
        r125 = r78;
        r119 = r79;
        r118 = r80;
        r123 = r81;
        r124 = r82;
        r121 = r83;
        r122 = r84;
        r120 = r85;
        goto L290
    L183:
        if ((599187 & r6) != 599186) goto L186;
        r11 = false;
        goto L188
    L174:
        if ((r88 & 1572864) != 0) goto L181;
        if (r0.changed(r85) == false) goto L178;
        int r126 = 1048576;
    L179:
        r6 = r6 | r126;
        goto L181
    L178:
        r126 = 524288;
        goto L179
    L143:
        if ((r88 & 3072) != 0) goto L151;
        if (r0.changed(r82) == true) goto L148;
        r16 = 1024;
    L148:
        r6 = r6 | r16;
        goto L151
    L132:
        if ((r88 & 384) != 0) goto L139;
        if (r0.changed(r81) == false) goto L136;
        int r216 = 256;
    L137:
        r6 = r6 | r216;
        goto L139
    L136:
        r216 = 128;
        goto L137
    L122:
        if ((r88 & 48) != 0) goto L128;
        if (r0.changed(r80) == false) goto L126;
        int r217 = 32;
    L127:
        r21 = r21 | r217;
        goto L128
    L126:
        r217 = 16;
        goto L127
    L110:
        if ((r89 & 1024) != 0) goto L115;
        if (r0.changed(r79) == false) goto L115;
        int r218 = 4;
    L116:
        r21 = r88 | r218;
    L115:
        r218 = 2;
        goto L116
    L101:
        if ((r87 & 805306368) != 0) goto L108;
        if (r0.changed(r78) == false) goto L105;
        int r311 = 536870912;
    L106:
        r4 = r4 | r311;
        goto L108
    L105:
        r311 = 268435456;
        goto L106
    L91:
        if ((r87 & 100663296) != 0) goto L97;
        if (r0.changed(r77) == false) goto L95;
        int r312 = 67108864;
    L96:
        r4 = r4 | r312;
        goto L97
    L95:
        r312 = 33554432;
        goto L96
    L81:
        if ((r87 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r76) == false) goto L85;
        int r313 = 8388608;
    L86:
        r4 = r4 | r313;
        goto L87
    L85:
        r313 = 4194304;
        goto L86
    L71:
        if ((r87 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r75) == false) goto L75;
        int r219 = 1048576;
    L76:
        r4 = r4 | r219;
        goto L77
    L75:
        r219 = 524288;
        goto L76
    L61:
        if ((r87 & 196608) != 0) goto L67;
        if (r0.changedInstance(r74) == false) goto L65;
        int r220 = 131072;
    L66:
        r4 = r4 | r220;
        goto L67
    L65:
        r220 = 65536;
        goto L66
    L50:
        if ((r87 & 24576) != 0) goto L57;
        if (r0.changedInstance(r73) == false) goto L54;
        int r221 = 16384;
    L55:
        r4 = r4 | r221;
        goto L57
    L54:
        r221 = 8192;
        goto L55
    L28:
        if ((r87 & 384) != 0) goto L35;
        if (r0.changed(r71) == false) goto L32;
        int r127 = 256;
    L33:
        r4 = r4 | r127;
        goto L35
    L32:
        r127 = 128;
        goto L33
    L17:
        if ((r87 & 48) != 0) goto L24;
        if (r0.changed(r70) == false) goto L21;
        int r51 = 32;
    L22:
        r4 = r4 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r87 & 6) == 0) goto L8;
        r4 = r87;
        goto L13
    L8:
        if (r0.changed(r69) == false) goto L10;
        int r52 = 4;
    L11:
        r4 = r52 | r87;
        goto L13
    L10:
        r52 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SecureTextField-0vce7ms, reason: not valid java name */
    public static final void m2148SecureTextField0vce7ms(final TextFieldState r102, Modifier r103, boolean r104, TextStyle r105, Function2<? super Composer, ? super Integer, Unit> r106, Function2<? super Composer, ? super Integer, Unit> r107, Function2<? super Composer, ? super Integer, Unit> r108, Function2<? super Composer, ? super Integer, Unit> r109, boolean r110, InputTransformation r111, int r112, char r113, KeyboardOptions r114, KeyboardActionHandler r115, Shape r116, TextFieldColors r117, MutableInteractionSource r118, Composer r119, final int r120, final int r121, final int r122) {
        Composer r0 = r119.startRestartGroup(-308805078);
        if ((r122 & 1) == 0) goto L6;
        int r4 = r120 | 6;
    L13:
        int r5 = r122 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r122 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = 2048;
        if ((r120 & 3072) != 0) goto L46;
        if ((r122 & 8) != 0) goto L43;
        if (r0.changed(r105) == false) goto L43;
        int r18 = 2048;
    L44:
        r4 = r4 | r18;
    L43:
        r18 = 1024;
    L46:
        int r19 = r122 & 16;
        int r123 = 8192;
        if (r19 == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        int r22 = r122 & 32;
        if (r22 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r26 = r122 & 64;
        if (r26 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r10 = r122 & 128;
        if (r10 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r122 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r122 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L108:
        if ((r121 & 6) == 0) goto L110;
        int r21 = r121;
    L118:
        int r3 = r122 & 2048;
        if (r3 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r122 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r8 = r122 & 8192;
        if (r8 == 0) goto L143;
        r6 = r6 | 3072;
    L151:
        if ((r121 & 24576) != 0) goto L161;
        if ((r122 & 16384) != 0) goto L158;
        if (r0.changed(r116) == false) goto L158;
        r123 = 16384;
    L158:
        r6 = r6 | r123;
    L161:
        if ((r121 & 196608) != 0) goto L170;
        if ((r122 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L165;
    L167:
        int r17 = 65536;
    L168:
        r6 = r6 | r17;
        goto L170
    L165:
        if (r0.changed(r117) == false) goto L167;
        r17 = 131072;
    L170:
        int r64 = r122 & 65536;
        if (r64 == 0) goto L174;
        r6 = r6 | 1572864;
    L180:
        boolean r65 = true;
        if ((r4 & 306783379) == 306783378) goto L183;
    L186:
        boolean r11 = true;
    L188:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L281;
        r0.startDefaults();
        if ((r120 & 1) != 0) goto L192;
    L207:
        if (r5 == 0) goto L209;
        Modifier r12 = Modifier.Companion;
    L210:
        if (r9 == 0) goto L212;
        boolean r13 = true;
    L214:
        if ((r122 & 8) == 0) goto L216;
        TextStyle r14 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-7169);
    L217:
        if (r19 == 0) goto L219;
        Function2<? super Composer, ? super Integer, Unit> r66 = null;
    L220:
        if (r22 == 0) goto L222;
        Function2<? super Composer, ? super Integer, Unit> r67 = null;
    L223:
        if (r26 == 0) goto L225;
        Function2<? super Composer, ? super Integer, Unit> r68 = null;
    L226:
        if (r10 == 0) goto L228;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L229:
        if (r1 == 0) goto L231;
        boolean r20 = false;
    L232:
        if (r2 == 0) goto L234;
        InputTransformation r23 = null;
    L236:
        if ((r122 & 1024) == 0) goto L238;
        int r124 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
        r6 = r6 & (-15);
    L239:
        if (r3 == 0) goto L241;
        char r24 = DefaultObfuscationCharacter;
    L242:
        if (r7 == 0) goto L244;
        KeyboardOptions r25 = SecureTextFieldKeyboardOptions;
    L245:
        if (r8 == 0) goto L247;
        KeyboardActionHandler r27 = null;
    L248:
        boolean r1010 = r20;
        if ((r122 & 16384) == 0) goto L251;
        Shape r28 = TextFieldDefaults.INSTANCE.getTextFieldShape(r0, 6);
        r6 = r6 & (-57345);
    L253:
        if ((r122 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L255;
        TextFieldColors r29 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        r6 = r6 & (-458753);
    L256:
        if (r64 == 0) goto L258;
        MutableInteractionSource r34 = null;
    L259:
        Shape r30 = r28;
        TextFieldColors r31 = r29;
        boolean r32 = r1010;
        InputTransformation r33 = r23;
    L260:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L264;
        ComposerKt.traceEventStart(-308805078, r4, r6, "androidx.compose.material.SecureTextField (SecureTextField.kt:121)");
    L264:
        if (r34 != null) goto L269;
        r0.startReplaceGroup(208856593);
        Object r35 = r0.rememberedValue();
        if (r35 != Composer.Companion.getEmpty()) goto L268;
        r35 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r35);
    L268:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r35;
    L270:
        r0.startReplaceGroup(-408899592);
        long r125 = r14.getColor-0d7_KjU();
        if (r125 != 16) goto L274;
        r65 = false;
    L274:
        if (r65 == true) goto L277;
        r125 = ((Color) r31.textColor(r13, r0, ((r4 >> 6) & 14) | ((r6 >> 12) & 112)).getValue()).unbox-impl();
    L277:
        r0.endReplaceGroup();
        TextStyle r211 = r14.merge(new TextStyle(r125, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        TextFieldDefaults r36 = TextFieldDefaults.INSTANCE;
        Modifier r1110 = r12;
        TextStyle r1111 = r14;
        int r1112 = r124;
        int r37 = ((r4 & 14) | (r4 & 896)) | ((r4 >> 15) & 57344);
        int r38 = r6 << 12;
        int r39 = (r37 | (3670016 & r38)) | (r38 & 29360128);
        int r40 = r6 << 6;
        boolean r126 = r13;
        InputTransformation r212 = r33;
        KeyboardOptions r213 = r25;
        KeyboardActionHandler r214 = r27;
        char r215 = r24;
        BasicSecureTextFieldKt.m1342BasicSecureTextFieldegD4TGM(r102, SizeKt.m998defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m2207indicatorLinegv0btCI$default(r36, r12, r13, r32, r210, r31, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 48, null), r32, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6)), r36.m2214getMinWidthD9Ej5fM(), r36.m2213getMinHeightD9Ej5fM()), r126, false, r212, r211, r213, r214, null, r210, new SolidColor(((Color) r31.cursorColor(r32, r0, ((r4 >> 24) & 14) | ((r6 >> 12) & 112)).getValue()).unbox-impl(), null), new SecureTextFieldKt$SecureTextField$1(r102, r13, r210, r32, r66, r67, r68, r15, r30, r31), r1112, r215, r0, r39, (r40 & 896) | (r40 & 7168), 264);
        if (ComposerKt.isTraceInProgress() == false) goto L280;
        ComposerKt.traceEventEnd();
    L280:
        final char r127 = r24;
        final int r128 = r1112;
        final Shape r129 = r30;
        final TextFieldColors r130 = r31;
        final KeyboardOptions r131 = r25;
        final KeyboardActionHandler r132 = r27;
        final boolean r41 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r42 = r15;
        final MutableInteractionSource r133 = r34;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r66;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r67;
        final Function2<? super Composer, ? super Integer, Unit> r45 = r68;
        final TextStyle r46 = r1111;
        final boolean r47 = r32;
        final InputTransformation r134 = r33;
        final Modifier r48 = r1110;
    L282:
        ScopeUpdateScope r49 = r0.endRestartGroup();
        if (r49 == null) goto L286;
        r49.updateScope(new b9(r102, r48, r41, r46, r43, r44, r45, r42, r47, r134, r128, r127, r131, r132, r129, r130, r133, r120, r121, r122));
        return;
    L286:
        return;
    L269:
        r0.startReplaceGroup(-408905338);
        r0.endReplaceGroup();
        r210 = r34;
        goto L270
    L258:
        r34 = r118;
        goto L259
    L255:
        r29 = r117;
        goto L256
    L251:
        r28 = r116;
        goto L253
    L247:
        r27 = r115;
        goto L248
    L244:
        r25 = r114;
        goto L245
    L241:
        r24 = r113;
        goto L242
    L238:
        r124 = r112;
        goto L239
    L234:
        r23 = r111;
        goto L236
    L231:
        r20 = r110;
        goto L232
    L228:
        r15 = r109;
        goto L229
    L225:
        r68 = r108;
        goto L226
    L222:
        r67 = r107;
        goto L223
    L219:
        r66 = r106;
        goto L220
    L216:
        r14 = r105;
        goto L217
    L212:
        r13 = r104;
        goto L214
    L209:
        r12 = r103;
        goto L210
    L192:
        if (r0.getDefaultsInvalid() == true) goto L207;
        r0.skipToGroupEnd();
        if ((r122 & 8) == 0) goto L198;
        r4 = r4 & (-7169);
    L198:
        if ((r122 & 1024) == 0) goto L201;
        r6 = r6 & (-15);
    L201:
        if ((r122 & 16384) == 0) goto L204;
        r6 = r6 & (-57345);
    L204:
        if ((r122 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L206;
        r6 = r6 & (-458753);
    L206:
        r12 = r103;
        r13 = r104;
        r14 = r105;
        r66 = r106;
        r67 = r107;
        r68 = r108;
        r15 = r109;
        r32 = r110;
        r33 = r111;
        r124 = r112;
        r24 = r113;
        r25 = r114;
        r27 = r115;
        r34 = r118;
        r4 = r4;
        r6 = r6;
        r30 = r116;
        r31 = r117;
        goto L260
    L281:
        r0.skipToGroupEnd();
        r48 = r103;
        r41 = r104;
        r46 = r105;
        r43 = r106;
        r44 = r107;
        r45 = r108;
        r42 = r109;
        r47 = r110;
        r134 = r111;
        r128 = r112;
        r127 = r113;
        r131 = r114;
        r132 = r115;
        r129 = r116;
        r130 = r117;
        r133 = r118;
        goto L282
    L183:
        if ((599187 & r6) != 599186) goto L186;
        r11 = false;
        goto L188
    L174:
        if ((r121 & 1572864) != 0) goto L180;
        if (r0.changed(r118) == false) goto L178;
        int r135 = 1048576;
    L179:
        r6 = r6 | r135;
        goto L180
    L178:
        r135 = 524288;
        goto L179
    L143:
        if ((r121 & 3072) != 0) goto L151;
        if (r0.changed(r115) == true) goto L148;
        r16 = 1024;
    L148:
        r6 = r6 | r16;
        goto L151
    L132:
        if ((r121 & 384) != 0) goto L139;
        if (r0.changed(r114) == false) goto L136;
        int r216 = 256;
    L137:
        r6 = r6 | r216;
        goto L139
    L136:
        r216 = 128;
        goto L137
    L122:
        if ((r121 & 48) != 0) goto L128;
        if (r0.changed(r113) == false) goto L126;
        int r217 = 32;
    L127:
        r21 = r21 | r217;
        goto L128
    L126:
        r217 = 16;
        goto L127
    L110:
        if ((r122 & 1024) != 0) goto L115;
        if (r0.changed(r112) == false) goto L115;
        int r218 = 4;
    L116:
        r21 = r121 | r218;
    L115:
        r218 = 2;
        goto L116
    L101:
        if ((r120 & 805306368) != 0) goto L108;
        if (r0.changed(r111) == false) goto L105;
        int r310 = 536870912;
    L106:
        r4 = r4 | r310;
        goto L108
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r120 & 100663296) != 0) goto L97;
        if (r0.changed(r110) == false) goto L95;
        int r311 = 67108864;
    L96:
        r4 = r4 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r120 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r109) == false) goto L85;
        int r312 = 8388608;
    L86:
        r4 = r4 | r312;
        goto L87
    L85:
        r312 = 4194304;
        goto L86
    L71:
        if ((r120 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r108) == false) goto L75;
        int r219 = 1048576;
    L76:
        r4 = r4 | r219;
        goto L77
    L75:
        r219 = 524288;
        goto L76
    L61:
        if ((r120 & 196608) != 0) goto L67;
        if (r0.changedInstance(r107) == false) goto L65;
        int r220 = 131072;
    L66:
        r4 = r4 | r220;
        goto L67
    L65:
        r220 = 65536;
        goto L66
    L50:
        if ((r120 & 24576) != 0) goto L57;
        if (r0.changedInstance(r106) == false) goto L54;
        int r221 = 16384;
    L55:
        r4 = r4 | r221;
        goto L57
    L54:
        r221 = 8192;
        goto L55
    L28:
        if ((r120 & 384) != 0) goto L35;
        if (r0.changed(r104) == false) goto L32;
        int r136 = 256;
    L33:
        r4 = r4 | r136;
        goto L35
    L32:
        r136 = 128;
        goto L33
    L17:
        if ((r120 & 48) != 0) goto L24;
        if (r0.changed(r103) == false) goto L21;
        int r50 = 32;
    L22:
        r4 = r4 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r120 & 6) == 0) goto L8;
        r4 = r120;
        goto L13
    L8:
        if (r0.changed(r102) == false) goto L10;
        int r51 = 4;
    L11:
        r4 = r51 | r120;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }
}
