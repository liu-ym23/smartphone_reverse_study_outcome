package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u008f\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"28\b\u0002\u0010#\u001a2\u0012\u0004\u0012\u00020%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007¢\u0006\u0004\b2\u00103\u001a\u008f\u0003\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"28\b\u0002\u0010#\u001a2\u0012\u0004\u0012\u00020%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007¢\u0006\u0004\b5\u00103\"\u000e\u00106\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"SecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SecureTextField-XvU6IwQ", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;ICLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedSecureTextField", "OutlinedSecureTextField-XvU6IwQ", "SecureTextFieldKeyboardOptions", "DefaultObfuscationCharacter", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final KeyboardOptions SecureTextFieldKeyboardOptions = null;

    private static final Unit OutlinedSecureTextField_XvU6IwQ$lambda$5(TextFieldState r28, Modifier r29, boolean r30, TextStyle r31, TextFieldLabelPosition r32, Function3 r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, boolean r40, InputTransformation r41, int r42, char r43, KeyboardOptions r44, KeyboardActionHandler r45, Function2 r46, Shape r47, TextFieldColors r48, PaddingValues r49, MutableInteractionSource r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        m3073OutlinedSecureTextFieldXvU6IwQ(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    private static final Unit SecureTextField_XvU6IwQ$lambda$2(TextFieldState r28, Modifier r29, boolean r30, TextStyle r31, TextFieldLabelPosition r32, Function3 r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, boolean r40, InputTransformation r41, int r42, char r43, KeyboardOptions r44, KeyboardActionHandler r45, Function2 r46, Shape r47, TextFieldColors r48, PaddingValues r49, MutableInteractionSource r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        m3074SecureTextFieldXvU6IwQ(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldState r1, Modifier r2, boolean r3, TextStyle r4, TextFieldLabelPosition r5, Function3 r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, boolean r13, InputTransformation r14, int r15, char r16, KeyboardOptions r17, KeyboardActionHandler r18, Function2 r19, Shape r20, TextFieldColors r21, PaddingValues r22, MutableInteractionSource r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return OutlinedSecureTextField_XvU6IwQ$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    public static /* synthetic */ Unit b(TextFieldState r1, Modifier r2, boolean r3, TextStyle r4, TextFieldLabelPosition r5, Function3 r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, boolean r13, InputTransformation r14, int r15, char r16, KeyboardOptions r17, KeyboardActionHandler r18, Function2 r19, Shape r20, TextFieldColors r21, PaddingValues r22, MutableInteractionSource r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return SecureTextField_XvU6IwQ$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    static {
        SecureTextFieldKeyboardOptions = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.getPassword-PjHm6EE(), 0, null, null, null, 121, null);
    }

    /* JADX INFO: renamed from: OutlinedSecureTextField-XvU6IwQ, reason: not valid java name */
    public static final void m3073OutlinedSecureTextFieldXvU6IwQ(final TextFieldState r83, Modifier r84, boolean r85, TextStyle r86, TextFieldLabelPosition r87, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, InputTransformation r96, int r97, char r98, KeyboardOptions r99, KeyboardActionHandler r100, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r101, Shape r102, TextFieldColors r103, PaddingValues r104, MutableInteractionSource r105, Composer r106, final int r107, final int r108, final int r109, final int r110) {
        Composer r0 = r106.startRestartGroup(-273370384);
        if ((r110 & 1) == 0) goto L6;
        int r4 = r107 | 6;
    L13:
        int r5 = r110 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r110 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L36:
        if ((r107 & 3072) != 0) goto L46;
        if ((r110 & 8) != 0) goto L43;
        if (r0.changed(r86) == false) goto L43;
        int r17 = 2048;
    L44:
        r4 = r4 | r17;
    L43:
        r17 = 1024;
    L46:
        int r18 = 16384;
        if ((r107 & 24576) != 0) goto L57;
        if ((r110 & 16) != 0) goto L54;
        if (r0.changed(r87) == false) goto L54;
        int r19 = 16384;
    L55:
        r4 = r4 | r19;
    L54:
        r19 = 8192;
    L57:
        int r111 = r110 & 32;
        if (r111 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r22 = r110 & 64;
        if (r22 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r11 = r110 & 128;
        if (r11 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r110 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r110 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r110 & 1024;
        if (r3 == 0) goto L111;
        int r30 = r108 | 6;
    L118:
        int r6 = r110 & 2048;
        if (r6 == 0) goto L122;
        r30 = r30 | 48;
    L128:
        int r7 = r30;
        int r8 = r110 & 4096;
        if (r8 == 0) goto L132;
        r7 = r7 | 384;
    L139:
        int r10 = r110 & 8192;
        if (r10 == 0) goto L142;
        r7 = r7 | 3072;
        int r31 = r10;
    L151:
        if ((r108 & 24576) != 0) goto L161;
        if ((r110 & 16384) != 0) goto L158;
        if (r0.changed(r97) == false) goto L158;
    L159:
        r7 = r7 | r18;
    L158:
        r18 = 8192;
    L161:
        int r112 = r110 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r112 == 0) goto L165;
        r7 = r7 | 196608;
    L171:
        int r20 = r110 & 65536;
        if (r20 == 0) goto L175;
        r7 = r7 | 1572864;
    L181:
        int r24 = r110 & 131072;
        if (r24 == 0) goto L185;
        r7 = r7 | 12582912;
    L191:
        int r28 = r110 & 262144;
        if (r28 == 0) goto L195;
        r7 = r7 | 100663296;
    L202:
        if ((r108 & 805306368) != 0) goto L212;
        if ((r110 & 524288) == 0) goto L206;
    L208:
        int r29 = 268435456;
    L209:
        r7 = r7 | r29;
        goto L212
    L206:
        if (r0.changed(r102) == false) goto L208;
        r29 = 536870912;
    L212:
        if ((r109 & 6) == 0) goto L214;
        int r16 = r109;
    L222:
        if ((r109 & 48) != 0) goto L231;
        if ((r110 & 2097152) == 0) goto L226;
    L228:
        int r21 = 16;
    L229:
        r16 = r16 | r21;
        goto L231
    L226:
        if (r0.changed(r104) == false) goto L228;
        r21 = 32;
    L231:
        int r12 = r16;
        int r113 = r110 & 4194304;
        if (r113 == 0) goto L235;
        r12 = r12 | 384;
    L243:
        if ((r4 & 306783379) == 306783378) goto L245;
    L250:
        boolean r13 = true;
    L252:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L367;
        r0.startDefaults();
        if ((r107 & 1) != 0) goto L256;
    L271:
        if (r5 == 0) goto L273;
        Modifier r14 = Modifier.Companion;
    L274:
        if (r9 == 0) goto L276;
        boolean r15 = true;
    L278:
        if ((r110 & 8) == 0) goto L280;
        TextStyle r114 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-7169);
    L282:
        if ((r110 & 16) == 0) goto L284;
        TextFieldLabelPosition r115 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
        r4 = r4 & (-57345);
    L286:
        if (r111 == 0) goto L288;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r116 = null;
    L289:
        if (r22 == 0) goto L291;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L292:
        if (r11 == 0) goto L294;
        Function2<? super Composer, ? super Integer, Unit> r117 = null;
    L295:
        if (r1 == 0) goto L297;
        Function2<? super Composer, ? super Integer, Unit> r25 = null;
    L298:
        if (r2 == 0) goto L300;
        Function2<? super Composer, ? super Integer, Unit> r26 = null;
    L301:
        if (r3 == 0) goto L303;
        Function2<? super Composer, ? super Integer, Unit> r27 = null;
    L304:
        if (r6 == 0) goto L306;
        Function2<? super Composer, ? super Integer, Unit> r32 = null;
    L307:
        if (r8 == 0) goto L309;
        boolean r118 = false;
    L310:
        if (r31 == 0) goto L312;
        InputTransformation r210 = null;
    L314:
        if ((r110 & 16384) == 0) goto L316;
        int r33 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
        r7 = r7 & (-57345);
    L317:
        if (r112 == 0) goto L319;
        char r119 = DefaultObfuscationCharacter;
    L320:
        if (r20 == 0) goto L322;
        KeyboardOptions r120 = SecureTextFieldKeyboardOptions;
    L323:
        if (r24 == 0) goto L325;
        KeyboardActionHandler r211 = null;
    L326:
        if (r28 == 0) goto L328;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r212 = null;
    L329:
        Function2<? super Composer, ? super Integer, Unit> r810 = r25;
        Function2<? super Composer, ? super Integer, Unit> r811 = r26;
        if ((r110 & 524288) == 0) goto L332;
        Shape r34 = OutlinedTextFieldDefaults.INSTANCE.getShape(r0, 6);
        r7 = r7 & (-1879048193);
    L333:
        Shape r812 = r34;
        if ((r110 & 1048576) == 0) goto L336;
        TextFieldColors r35 = OutlinedTextFieldDefaults.INSTANCE.colors(r0, 6);
    L338:
        if ((2097152 & r110) == 0) goto L340;
        PaddingValues r36 = OutlinedTextFieldDefaults.m2968contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L341:
        Shape r45 = r812;
        if (r113 == 0) goto L344;
        MutableInteractionSource r47 = null;
    L345:
        Function2<? super Composer, ? super Integer, Unit> r37 = r23;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r44 = r212;
        Function2<? super Composer, ? super Integer, Unit> r38 = r811;
        int r121 = r7;
        Function2<? super Composer, ? super Integer, Unit> r39 = r32;
        Function2<? super Composer, ? super Integer, Unit> r40 = r27;
        Function2<? super Composer, ? super Integer, Unit> r41 = r810;
        InputTransformation r813 = r210;
    L346:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L350;
        ComposerKt.traceEventStart(-273370384, r4, r121, "androidx.compose.material3.OutlinedSecureTextField (SecureTextField.kt:315)");
    L350:
        if (r47 != null) goto L355;
        r0.startReplaceGroup(-717679893);
        Object r42 = r0.rememberedValue();
        if (r42 != Composer.Companion.getEmpty()) goto L354;
        r42 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r42);
    L354:
        MutableInteractionSource r43 = (MutableInteractionSource) r42;
        r0.endReplaceGroup();
    L356:
        r0.startReplaceGroup(-715882166);
        long r122 = r114.getColor-0d7_KjU();
        if (r122 == 16) goto L359;
        boolean r46 = true;
    L360:
        if (r46 == true) goto L363;
        r122 = r35.m3328textColorXeAY9LY$material3(r15, r118, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r43, r0, 0).getValue()).booleanValue());
    L363:
        r0.endReplaceGroup();
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r814 = r116;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r35.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1147500080, true, new SecureTextFieldKt$OutlinedSecureTextField$1(r14, r116, r115, r118, r35, r83, r15, r43, r37, r117, r41, r38, r40, r39, r36, r813, r114.merge(new TextStyle(r122, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null)), r120, r211, r44, r33, r119, r45), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L366;
        ComposerKt.traceEventEnd();
    L366:
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r48 = r814;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r37;
        final Modifier r50 = r14;
        final boolean r123 = r118;
        final Function2<? super Composer, ? super Integer, Unit> r51 = r117;
        final TextFieldColors r213 = r35;
        final TextFieldLabelPosition r52 = r115;
        final int r124 = r33;
        final char r125 = r119;
        final KeyboardOptions r126 = r120;
        final KeyboardActionHandler r127 = r211;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r128 = r44;
        final Shape r214 = r45;
        final PaddingValues r215 = r36;
        final MutableInteractionSource r216 = r47;
        final InputTransformation r129 = r813;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r40;
        boolean r81 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r53 = r41;
        final boolean r54 = r81;
        TextStyle r82 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r38;
        final TextStyle r55 = r82;
    L368:
        ScopeUpdateScope r56 = r0.endRestartGroup();
        if (r56 == null) goto L372;
        r56.updateScope(new en(r83, r50, r54, r55, r52, r48, r49, r51, r53, r132, r131, r130, r123, r129, r124, r125, r126, r127, r128, r214, r213, r215, r216, r107, r108, r109, r110));
        return;
    L372:
        return;
    L359:
        r46 = false;
        goto L360
    L355:
        r0.startReplaceGroup(-715888276);
        r0.endReplaceGroup();
        r43 = r47;
        goto L356
    L344:
        r47 = r105;
        goto L345
    L340:
        r36 = r104;
        goto L341
    L336:
        r35 = r103;
        goto L338
    L332:
        r34 = r102;
        goto L333
    L328:
        r212 = r101;
        goto L329
    L325:
        r211 = r100;
        goto L326
    L322:
        r120 = r99;
        goto L323
    L319:
        r119 = r98;
        goto L320
    L316:
        r33 = r97;
        goto L317
    L312:
        r210 = r96;
        goto L314
    L309:
        r118 = r95;
        goto L310
    L306:
        r32 = r94;
        goto L307
    L303:
        r27 = r93;
        goto L304
    L300:
        r26 = r92;
        goto L301
    L297:
        r25 = r91;
        goto L298
    L294:
        r117 = r90;
        goto L295
    L291:
        r23 = r89;
        goto L292
    L288:
        r116 = r88;
        goto L289
    L284:
        r115 = r87;
        goto L286
    L280:
        r114 = r86;
        goto L282
    L276:
        r15 = r85;
        goto L278
    L273:
        r14 = r84;
        goto L274
    L256:
        if (r0.getDefaultsInvalid() == true) goto L271;
        r0.skipToGroupEnd();
        if ((r110 & 8) == 0) goto L262;
        r4 = r4 & (-7169);
    L262:
        if ((r110 & 16) == 0) goto L265;
        r4 = r4 & (-57345);
    L265:
        if ((r110 & 16384) == 0) goto L268;
        r7 = r7 & (-57345);
    L268:
        if ((r110 & 524288) == 0) goto L270;
        r7 = r7 & (-1879048193);
    L270:
        r14 = r84;
        r15 = r85;
        r114 = r86;
        r115 = r87;
        r116 = r88;
        r37 = r89;
        r117 = r90;
        r41 = r91;
        r40 = r93;
        r118 = r95;
        r813 = r96;
        r33 = r97;
        r119 = r98;
        r120 = r99;
        r211 = r100;
        r44 = r101;
        r45 = r102;
        r35 = r103;
        r36 = r104;
        r47 = r105;
        r4 = r4;
        r121 = r7;
        r38 = r92;
        r39 = r94;
        goto L346
    L367:
        r0.skipToGroupEnd();
        r50 = r84;
        r54 = r85;
        r55 = r86;
        r52 = r87;
        r48 = r88;
        r49 = r89;
        r51 = r90;
        r53 = r91;
        r132 = r92;
        r131 = r93;
        r130 = r94;
        r123 = r95;
        r129 = r96;
        r124 = r97;
        r125 = r98;
        r126 = r99;
        r127 = r100;
        r128 = r101;
        r214 = r102;
        r213 = r103;
        r215 = r104;
        r216 = r105;
        goto L368
    L245:
        if ((306783379 & r7) != 306783378) goto L250;
        if ((r12 & 147) != 146) goto L250;
        r13 = false;
        goto L252
    L235:
        if ((r109 & 384) != 0) goto L243;
        if (r0.changed(r105) == false) goto L239;
        int r217 = 256;
    L240:
        r12 = r12 | r217;
        goto L243
    L239:
        r217 = 128;
        goto L240
    L214:
        if ((r110 & 1048576) == 0) goto L216;
    L218:
        int r133 = 2;
    L219:
        r16 = r109 | r133;
        goto L222
    L216:
        if (r0.changed(r103) == false) goto L218;
        r133 = 4;
        goto L219
    L195:
        if ((r108 & 100663296) != 0) goto L202;
        if (r0.changedInstance(r101) == false) goto L199;
        int r218 = 67108864;
    L200:
        r7 = r7 | r218;
        goto L202
    L199:
        r218 = 33554432;
        goto L200
    L185:
        if ((r108 & 12582912) != 0) goto L191;
        if (r0.changed(r100) == false) goto L189;
        int r219 = 8388608;
    L190:
        r7 = r7 | r219;
        goto L191
    L189:
        r219 = 4194304;
        goto L190
    L175:
        if ((r108 & 1572864) != 0) goto L181;
        if (r0.changed(r99) == false) goto L179;
        int r220 = 1048576;
    L180:
        r7 = r7 | r220;
        goto L181
    L179:
        r220 = 524288;
        goto L180
    L165:
        if ((r108 & 196608) != 0) goto L171;
        if (r0.changed(r98) == false) goto L169;
        int r221 = 131072;
    L170:
        r7 = r7 | r221;
        goto L171
    L169:
        r221 = 65536;
        goto L170
    L142:
        r31 = r10;
        if ((r108 & 3072) != 0) goto L151;
        if (r0.changed(r96) == false) goto L147;
        int r310 = 2048;
    L148:
        r7 = r7 | r310;
        goto L151
    L147:
        r310 = 1024;
        goto L148
    L132:
        if ((r108 & 384) != 0) goto L139;
        if (r0.changed(r95) == false) goto L136;
        int r311 = 256;
    L137:
        r7 = r7 | r311;
        goto L139
    L136:
        r311 = 128;
        goto L137
    L122:
        if ((r108 & 48) != 0) goto L128;
        if (r0.changedInstance(r94) == false) goto L126;
        int r312 = 32;
    L127:
        r30 = r30 | r312;
        goto L128
    L126:
        r312 = 16;
        goto L127
    L111:
        if ((r108 & 6) == 0) goto L113;
        r30 = r108;
        goto L118
    L113:
        if (r0.changedInstance(r93) == false) goto L115;
        int r313 = 4;
    L116:
        r30 = r108 | r313;
        goto L118
    L115:
        r313 = 2;
        goto L116
    L101:
        if ((r107 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r92) == false) goto L105;
        int r314 = 536870912;
    L106:
        r4 = r4 | r314;
        goto L107
    L105:
        r314 = 268435456;
        goto L106
    L91:
        if ((r107 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r91) == false) goto L95;
        int r315 = 67108864;
    L96:
        r4 = r4 | r315;
        goto L97
    L95:
        r315 = 33554432;
        goto L96
    L81:
        if ((r107 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r90) == false) goto L85;
        int r222 = 8388608;
    L86:
        r4 = r4 | r222;
        goto L87
    L85:
        r222 = 4194304;
        goto L86
    L71:
        if ((r107 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r89) == false) goto L75;
        int r223 = 1048576;
    L76:
        r4 = r4 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L61:
        if ((r107 & 196608) != 0) goto L67;
        if (r0.changedInstance(r88) == false) goto L65;
        int r224 = 131072;
    L66:
        r4 = r4 | r224;
        goto L67
    L65:
        r224 = 65536;
        goto L66
    L28:
        if ((r107 & 384) != 0) goto L36;
        if (r0.changed(r85) == false) goto L32;
        int r134 = 256;
    L33:
        r4 = r4 | r134;
        goto L36
    L32:
        r134 = 128;
        goto L33
    L17:
        if ((r107 & 48) != 0) goto L24;
        if (r0.changed(r84) == false) goto L21;
        int r57 = 32;
    L22:
        r4 = r4 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r107 & 6) == 0) goto L8;
        r4 = r107;
        goto L13
    L8:
        if (r0.changed(r83) == false) goto L10;
        int r58 = 4;
    L11:
        r4 = r58 | r107;
        goto L13
    L10:
        r58 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SecureTextField-XvU6IwQ, reason: not valid java name */
    public static final void m3074SecureTextFieldXvU6IwQ(final TextFieldState r83, Modifier r84, boolean r85, TextStyle r86, TextFieldLabelPosition r87, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, InputTransformation r96, int r97, char r98, KeyboardOptions r99, KeyboardActionHandler r100, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r101, Shape r102, TextFieldColors r103, PaddingValues r104, MutableInteractionSource r105, Composer r106, final int r107, final int r108, final int r109, final int r110) {
        Composer r0 = r106.startRestartGroup(1177133806);
        if ((r110 & 1) == 0) goto L6;
        int r4 = r107 | 6;
    L13:
        int r5 = r110 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r110 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L36:
        if ((r107 & 3072) != 0) goto L46;
        if ((r110 & 8) != 0) goto L43;
        if (r0.changed(r86) == false) goto L43;
        int r17 = 2048;
    L44:
        r4 = r4 | r17;
    L43:
        r17 = 1024;
    L46:
        int r18 = 16384;
        if ((r107 & 24576) != 0) goto L57;
        if ((r110 & 16) != 0) goto L54;
        if (r0.changed(r87) == false) goto L54;
        int r19 = 16384;
    L55:
        r4 = r4 | r19;
    L54:
        r19 = 8192;
    L57:
        int r111 = r110 & 32;
        if (r111 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r22 = r110 & 64;
        if (r22 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r11 = r110 & 128;
        if (r11 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r110 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r110 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r110 & 1024;
        if (r3 == 0) goto L111;
        int r30 = r108 | 6;
    L118:
        int r6 = r110 & 2048;
        if (r6 == 0) goto L122;
        r30 = r30 | 48;
    L128:
        int r7 = r30;
        int r8 = r110 & 4096;
        if (r8 == 0) goto L132;
        r7 = r7 | 384;
    L139:
        int r10 = r110 & 8192;
        if (r10 == 0) goto L142;
        r7 = r7 | 3072;
        int r31 = r10;
    L151:
        if ((r108 & 24576) != 0) goto L161;
        if ((r110 & 16384) != 0) goto L158;
        if (r0.changed(r97) == false) goto L158;
    L159:
        r7 = r7 | r18;
    L158:
        r18 = 8192;
    L161:
        int r112 = r110 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r112 == 0) goto L165;
        r7 = r7 | 196608;
    L171:
        int r20 = r110 & 65536;
        if (r20 == 0) goto L175;
        r7 = r7 | 1572864;
    L181:
        int r24 = r110 & 131072;
        if (r24 == 0) goto L185;
        r7 = r7 | 12582912;
    L191:
        int r28 = r110 & 262144;
        if (r28 == 0) goto L195;
        r7 = r7 | 100663296;
    L202:
        if ((r108 & 805306368) != 0) goto L212;
        if ((r110 & 524288) == 0) goto L206;
    L208:
        int r29 = 268435456;
    L209:
        r7 = r7 | r29;
        goto L212
    L206:
        if (r0.changed(r102) == false) goto L208;
        r29 = 536870912;
    L212:
        if ((r109 & 6) == 0) goto L214;
        int r16 = r109;
    L222:
        if ((r109 & 48) != 0) goto L231;
        if ((r110 & 2097152) == 0) goto L226;
    L228:
        int r21 = 16;
    L229:
        r16 = r16 | r21;
        goto L231
    L226:
        if (r0.changed(r104) == false) goto L228;
        r21 = 32;
    L231:
        int r12 = r16;
        int r113 = r110 & 4194304;
        if (r113 == 0) goto L235;
        r12 = r12 | 384;
    L243:
        if ((r4 & 306783379) == 306783378) goto L245;
    L250:
        boolean r13 = true;
    L252:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L372;
        r0.startDefaults();
        if ((r107 & 1) != 0) goto L256;
    L271:
        if (r5 == 0) goto L273;
        Modifier r14 = Modifier.Companion;
    L274:
        if (r9 == 0) goto L276;
        boolean r15 = true;
    L278:
        if ((r110 & 8) == 0) goto L280;
        TextStyle r114 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-7169);
    L282:
        if ((r110 & 16) == 0) goto L284;
        TextFieldLabelPosition r115 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
        r4 = r4 & (-57345);
    L286:
        if (r111 == 0) goto L288;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r116 = null;
    L289:
        if (r22 == 0) goto L291;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L292:
        if (r11 == 0) goto L294;
        Function2<? super Composer, ? super Integer, Unit> r117 = null;
    L295:
        if (r1 == 0) goto L297;
        Function2<? super Composer, ? super Integer, Unit> r25 = null;
    L298:
        if (r2 == 0) goto L300;
        Function2<? super Composer, ? super Integer, Unit> r26 = null;
    L301:
        if (r3 == 0) goto L303;
        Function2<? super Composer, ? super Integer, Unit> r27 = null;
    L304:
        if (r6 == 0) goto L306;
        Function2<? super Composer, ? super Integer, Unit> r32 = null;
    L307:
        if (r8 == 0) goto L309;
        boolean r118 = false;
    L310:
        if (r31 == 0) goto L312;
        InputTransformation r210 = null;
    L314:
        if ((r110 & 16384) == 0) goto L316;
        int r33 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
        r7 = r7 & (-57345);
    L317:
        if (r112 == 0) goto L319;
        char r119 = DefaultObfuscationCharacter;
    L320:
        if (r20 == 0) goto L322;
        KeyboardOptions r120 = SecureTextFieldKeyboardOptions;
    L323:
        if (r24 == 0) goto L325;
        KeyboardActionHandler r211 = null;
    L326:
        if (r28 == 0) goto L328;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r212 = null;
    L329:
        Function2<? super Composer, ? super Integer, Unit> r810 = r25;
        Function2<? super Composer, ? super Integer, Unit> r811 = r26;
        if ((r110 & 524288) == 0) goto L332;
        Shape r34 = TextFieldDefaults.INSTANCE.getShape(r0, 6);
        r7 = r7 & (-1879048193);
    L333:
        Shape r812 = r34;
        if ((r110 & 1048576) == 0) goto L336;
        TextFieldColors r35 = TextFieldDefaults.INSTANCE.colors(r0, 6);
    L338:
        if ((2097152 & r110) == 0) goto L345;
        if (r116 != null) goto L341;
    L344:
        PaddingValues r36 = TextFieldDefaults.m3331contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L346:
        Shape r45 = r812;
        if (r113 == 0) goto L349;
        MutableInteractionSource r47 = null;
    L350:
        Function2<? super Composer, ? super Integer, Unit> r37 = r23;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r44 = r212;
        Function2<? super Composer, ? super Integer, Unit> r38 = r811;
        int r121 = r7;
        Function2<? super Composer, ? super Integer, Unit> r39 = r32;
        Function2<? super Composer, ? super Integer, Unit> r40 = r27;
        Function2<? super Composer, ? super Integer, Unit> r41 = r810;
        InputTransformation r813 = r210;
    L351:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L355;
        ComposerKt.traceEventStart(1177133806, r4, r121, "androidx.compose.material3.SecureTextField (SecureTextField.kt:155)");
    L355:
        if (r47 != null) goto L360;
        r0.startReplaceGroup(-413168883);
        Object r42 = r0.rememberedValue();
        if (r42 != Composer.Companion.getEmpty()) goto L359;
        r42 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r42);
    L359:
        MutableInteractionSource r43 = (MutableInteractionSource) r42;
        r0.endReplaceGroup();
    L361:
        r0.startReplaceGroup(1649245416);
        long r122 = r114.getColor-0d7_KjU();
        if (r122 == 16) goto L364;
        boolean r46 = true;
    L365:
        if (r46 == true) goto L368;
        r122 = r35.m3328textColorXeAY9LY$material3(r15, r118, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r43, r0, 0).getValue()).booleanValue());
    L368:
        r0.endReplaceGroup();
        final TextStyle r310 = r114.merge(new TextStyle(r122, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        final Modifier r123 = r14;
        final boolean r124 = r118;
        final TextFieldColors r125 = r35;
        final boolean r213 = r15;
        final MutableInteractionSource r214 = r43;
        final TextFieldLabelPosition r215 = r115;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r216 = r116;
        final Function2<? super Composer, ? super Integer, Unit> r217 = r37;
        final Function2<? super Composer, ? super Integer, Unit> r218 = r117;
        final Function2<? super Composer, ? super Integer, Unit> r219 = r41;
        final Function2<? super Composer, ? super Integer, Unit> r220 = r38;
        final Function2 r221 = r40;
        final Function2 r311 = r39;
        final PaddingValues r312 = r36;
        final InputTransformation r313 = r813;
        final KeyboardOptions r314 = r120;
        final KeyboardActionHandler r315 = r211;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r316 = r44;
        final int r317 = r33;
        final char r318 = r119;
        final Shape r319 = r45;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r814 = r116;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r35.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-2072926674, true, new SecureTextFieldKt$SecureTextField$1(r123, r124, r125, r83, r213, r214, r215, r216, r217, r218, r219, r220, r221, r311, r312, r313, r310, r314, r315, r316, r317, r318, r319), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L371;
        ComposerKt.traceEventEnd();
    L371:
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r48 = r814;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r37;
        final Modifier r50 = r14;
        final boolean r126 = r118;
        final Function2<? super Composer, ? super Integer, Unit> r51 = r117;
        final TextFieldColors r222 = r35;
        final TextFieldLabelPosition r52 = r115;
        final int r127 = r33;
        final char r128 = r119;
        final KeyboardOptions r129 = r120;
        final KeyboardActionHandler r130 = r211;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r131 = r44;
        final Shape r223 = r45;
        final PaddingValues r224 = r36;
        final MutableInteractionSource r225 = r47;
        final InputTransformation r132 = r813;
        final Function2<? super Composer, ? super Integer, Unit> r133 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r134 = r40;
        boolean r81 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r53 = r41;
        final boolean r54 = r81;
        TextStyle r82 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r135 = r38;
        final TextStyle r55 = r82;
    L373:
        ScopeUpdateScope r56 = r0.endRestartGroup();
        if (r56 == null) goto L377;
        r56.updateScope(new dn(r83, r50, r54, r55, r52, r48, r49, r51, r53, r135, r134, r133, r126, r132, r127, r128, r129, r130, r131, r223, r222, r224, r225, r107, r108, r109, r110));
        return;
    L377:
        return;
    L364:
        r46 = false;
        goto L365
    L360:
        r0.startReplaceGroup(1649239306);
        r0.endReplaceGroup();
        r43 = r47;
        goto L361
    L349:
        r47 = r105;
        goto L350
    L341:
        if ((r115 instanceof TextFieldLabelPosition.Above) == true) goto L344;
        r36 = TextFieldDefaults.m3330contentPaddingWithLabela9UjIt4$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        goto L346
    L345:
        r36 = r104;
        goto L346
    L336:
        r35 = r103;
        goto L338
    L332:
        r34 = r102;
        goto L333
    L328:
        r212 = r101;
        goto L329
    L325:
        r211 = r100;
        goto L326
    L322:
        r120 = r99;
        goto L323
    L319:
        r119 = r98;
        goto L320
    L316:
        r33 = r97;
        goto L317
    L312:
        r210 = r96;
        goto L314
    L309:
        r118 = r95;
        goto L310
    L306:
        r32 = r94;
        goto L307
    L303:
        r27 = r93;
        goto L304
    L300:
        r26 = r92;
        goto L301
    L297:
        r25 = r91;
        goto L298
    L294:
        r117 = r90;
        goto L295
    L291:
        r23 = r89;
        goto L292
    L288:
        r116 = r88;
        goto L289
    L284:
        r115 = r87;
        goto L286
    L280:
        r114 = r86;
        goto L282
    L276:
        r15 = r85;
        goto L278
    L273:
        r14 = r84;
        goto L274
    L256:
        if (r0.getDefaultsInvalid() == true) goto L271;
        r0.skipToGroupEnd();
        if ((r110 & 8) == 0) goto L262;
        r4 = r4 & (-7169);
    L262:
        if ((r110 & 16) == 0) goto L265;
        r4 = r4 & (-57345);
    L265:
        if ((r110 & 16384) == 0) goto L268;
        r7 = r7 & (-57345);
    L268:
        if ((r110 & 524288) == 0) goto L270;
        r7 = r7 & (-1879048193);
    L270:
        r14 = r84;
        r15 = r85;
        r114 = r86;
        r115 = r87;
        r116 = r88;
        r37 = r89;
        r117 = r90;
        r41 = r91;
        r40 = r93;
        r118 = r95;
        r813 = r96;
        r33 = r97;
        r119 = r98;
        r120 = r99;
        r211 = r100;
        r44 = r101;
        r45 = r102;
        r35 = r103;
        r36 = r104;
        r47 = r105;
        r4 = r4;
        r121 = r7;
        r38 = r92;
        r39 = r94;
        goto L351
    L372:
        r0.skipToGroupEnd();
        r50 = r84;
        r54 = r85;
        r55 = r86;
        r52 = r87;
        r48 = r88;
        r49 = r89;
        r51 = r90;
        r53 = r91;
        r135 = r92;
        r134 = r93;
        r133 = r94;
        r126 = r95;
        r132 = r96;
        r127 = r97;
        r128 = r98;
        r129 = r99;
        r130 = r100;
        r131 = r101;
        r223 = r102;
        r222 = r103;
        r224 = r104;
        r225 = r105;
        goto L373
    L245:
        if ((306783379 & r7) != 306783378) goto L250;
        if ((r12 & 147) != 146) goto L250;
        r13 = false;
        goto L252
    L235:
        if ((r109 & 384) != 0) goto L243;
        if (r0.changed(r105) == false) goto L239;
        int r226 = 256;
    L240:
        r12 = r12 | r226;
        goto L243
    L239:
        r226 = 128;
        goto L240
    L214:
        if ((r110 & 1048576) == 0) goto L216;
    L218:
        int r136 = 2;
    L219:
        r16 = r109 | r136;
        goto L222
    L216:
        if (r0.changed(r103) == false) goto L218;
        r136 = 4;
        goto L219
    L195:
        if ((r108 & 100663296) != 0) goto L202;
        if (r0.changedInstance(r101) == false) goto L199;
        int r227 = 67108864;
    L200:
        r7 = r7 | r227;
        goto L202
    L199:
        r227 = 33554432;
        goto L200
    L185:
        if ((r108 & 12582912) != 0) goto L191;
        if (r0.changed(r100) == false) goto L189;
        int r228 = 8388608;
    L190:
        r7 = r7 | r228;
        goto L191
    L189:
        r228 = 4194304;
        goto L190
    L175:
        if ((r108 & 1572864) != 0) goto L181;
        if (r0.changed(r99) == false) goto L179;
        int r229 = 1048576;
    L180:
        r7 = r7 | r229;
        goto L181
    L179:
        r229 = 524288;
        goto L180
    L165:
        if ((r108 & 196608) != 0) goto L171;
        if (r0.changed(r98) == false) goto L169;
        int r230 = 131072;
    L170:
        r7 = r7 | r230;
        goto L171
    L169:
        r230 = 65536;
        goto L170
    L142:
        r31 = r10;
        if ((r108 & 3072) != 0) goto L151;
        if (r0.changed(r96) == false) goto L147;
        int r320 = 2048;
    L148:
        r7 = r7 | r320;
        goto L151
    L147:
        r320 = 1024;
        goto L148
    L132:
        if ((r108 & 384) != 0) goto L139;
        if (r0.changed(r95) == false) goto L136;
        int r321 = 256;
    L137:
        r7 = r7 | r321;
        goto L139
    L136:
        r321 = 128;
        goto L137
    L122:
        if ((r108 & 48) != 0) goto L128;
        if (r0.changedInstance(r94) == false) goto L126;
        int r322 = 32;
    L127:
        r30 = r30 | r322;
        goto L128
    L126:
        r322 = 16;
        goto L127
    L111:
        if ((r108 & 6) == 0) goto L113;
        r30 = r108;
        goto L118
    L113:
        if (r0.changedInstance(r93) == false) goto L115;
        int r323 = 4;
    L116:
        r30 = r108 | r323;
        goto L118
    L115:
        r323 = 2;
        goto L116
    L101:
        if ((r107 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r92) == false) goto L105;
        int r324 = 536870912;
    L106:
        r4 = r4 | r324;
        goto L107
    L105:
        r324 = 268435456;
        goto L106
    L91:
        if ((r107 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r91) == false) goto L95;
        int r325 = 67108864;
    L96:
        r4 = r4 | r325;
        goto L97
    L95:
        r325 = 33554432;
        goto L96
    L81:
        if ((r107 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r90) == false) goto L85;
        int r231 = 8388608;
    L86:
        r4 = r4 | r231;
        goto L87
    L85:
        r231 = 4194304;
        goto L86
    L71:
        if ((r107 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r89) == false) goto L75;
        int r232 = 1048576;
    L76:
        r4 = r4 | r232;
        goto L77
    L75:
        r232 = 524288;
        goto L76
    L61:
        if ((r107 & 196608) != 0) goto L67;
        if (r0.changedInstance(r88) == false) goto L65;
        int r233 = 131072;
    L66:
        r4 = r4 | r233;
        goto L67
    L65:
        r233 = 65536;
        goto L66
    L28:
        if ((r107 & 384) != 0) goto L36;
        if (r0.changed(r85) == false) goto L32;
        int r137 = 256;
    L33:
        r4 = r4 | r137;
        goto L36
    L32:
        r137 = 128;
        goto L33
    L17:
        if ((r107 & 48) != 0) goto L24;
        if (r0.changed(r84) == false) goto L21;
        int r57 = 32;
    L22:
        r4 = r4 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r107 & 6) == 0) goto L8;
        r4 = r107;
        goto L13
    L8:
        if (r0.changed(r83) == false) goto L10;
        int r58 = 4;
    L11:
        r4 = r58 | r107;
        goto L13
    L10:
        r58 = 2;
        goto L11
    }
}
