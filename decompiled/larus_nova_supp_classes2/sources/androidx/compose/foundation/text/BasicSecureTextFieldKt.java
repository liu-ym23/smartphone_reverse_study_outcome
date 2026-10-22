package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode_androidKt;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a\u001a\u0010(\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002\u001a \u0010-\u001a\u00020\u00012\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b/H\u0003¢\u0006\u0002\u00100\u001aÇ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b1\u00102\u001aÑ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b3\u00104\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-ltb6GB4", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "then", "next", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "DefaultObfuscationCharacter", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    private static final Unit BasicSecureTextField_Jb9bMDk$lambda$11(TextFieldState r17, Modifier r18, boolean r19, InputTransformation r20, TextStyle r21, KeyboardOptions r22, KeyboardActionHandler r23, Function2 r24, MutableInteractionSource r25, Brush r26, TextFieldDecorator r27, int r28, char r29, int r30, int r31, int r32, Composer r33, int r34) {
        m1341BasicSecureTextFieldJb9bMDk(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit BasicSecureTextField_egD4TGM$lambda$12(TextFieldState r18, Modifier r19, boolean r20, boolean r21, InputTransformation r22, TextStyle r23, KeyboardOptions r24, KeyboardActionHandler r25, Function2 r26, MutableInteractionSource r27, Brush r28, TextFieldDecorator r29, int r30, char r31, int r32, int r33, int r34, Composer r35, int r36) {
        m1342BasicSecureTextFieldegD4TGM(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    private static final Unit BasicSecureTextField_ltb6GB4$lambda$8(TextFieldState r19, Modifier r20, boolean r21, boolean r22, InputTransformation r23, TextStyle r24, KeyboardOptions r25, KeyboardActionHandler r26, Function2 r27, MutableInteractionSource r28, Brush r29, TextFieldDecorator r30, int r31, char r32, ScrollState r33, int r34, int r35, int r36, Composer r37, int r38) {
        m1343BasicSecureTextFieldltb6GB4(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit DisableCutCopy$lambda$10(Function2 r0, int r1, Composer r2, int r3) {
        DisableCutCopy(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldState r1, Modifier r2, boolean r3, boolean r4, InputTransformation r5, TextStyle r6, KeyboardOptions r7, KeyboardActionHandler r8, Function2 r9, MutableInteractionSource r10, Brush r11, TextFieldDecorator r12, int r13, char r14, int r15, int r16, int r17, Composer r18, int r19) {
        return BasicSecureTextField_egD4TGM$lambda$12(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit b(Function2 r0, int r1, Composer r2, int r3) {
        return DisableCutCopy$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(TextFieldState r1, Modifier r2, boolean r3, boolean r4, InputTransformation r5, TextStyle r6, KeyboardOptions r7, KeyboardActionHandler r8, Function2 r9, MutableInteractionSource r10, Brush r11, TextFieldDecorator r12, int r13, char r14, ScrollState r15, int r16, int r17, int r18, Composer r19, int r20) {
        return BasicSecureTextField_ltb6GB4$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ int d(State r0, int r1, int r2) {
        return BasicSecureTextField_ltb6GB4$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(TextFieldState r1, Modifier r2, boolean r3, InputTransformation r4, TextStyle r5, KeyboardOptions r6, KeyboardActionHandler r7, Function2 r8, MutableInteractionSource r9, Brush r10, TextFieldDecorator r11, int r12, char r13, int r14, int r15, int r16, Composer r17, int r18) {
        return BasicSecureTextField_Jb9bMDk$lambda$11(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit f(SemanticsPropertyReceiver r0) {
        return BasicSecureTextField_ltb6GB4$lambda$6$lambda$5(r0);
    }

    private static final Unit BasicSecureTextField_ltb6GB4$lambda$6$lambda$5(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentType(r1, ContentType.Companion.getPassword());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ InputTransformation access$then(InputTransformation r0, InputTransformation r1) {
        return then(r0, r1);
    }

    private static final InputTransformation then(InputTransformation r0, InputTransformation r1) {
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return r0;
    L7:
        return InputTransformationKt.then(r0, r1);
    L8:
        return r1;
    }

    private static final int BasicSecureTextField_ltb6GB4$lambda$4$lambda$3(State r0, int r1, int r2) {
        return ((Character) r0.getValue()).charValue();
    }

    private static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> r4, Composer r5, final int r6) {
        Composer r7 = r5.startRestartGroup(1141174275);
        if ((r6 & 6) == 0) goto L5;
        int r1 = r6;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r7.shouldExecute(r2, r1 & 1) == true) goto L17;
        r7.skipToGroupEnd();
    L28:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L32;
        r8.updateScope(new h(r4, r6));
        return;
    L32:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1141174275, r1, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:311)");
    L19:
        final TextToolbar r0 = (TextToolbar) r7.consume(CompositionLocalsKt.getLocalTextToolbar());
        boolean r3 = r7.changed(r0);
        Object r9 = r7.rememberedValue();
        if (r3 == false) goto L22;
    L23:
        r9 = new BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1(r0);
        r7.updateRememberedValue(r9);
    L24:
        ProvidableCompositionLocal r10 = CompositionLocalsKt.getLocalTextToolbar();
        int r11 = (r1 << 3) & 112;
        CompositionLocalKt.CompositionLocalProvider(r10.provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) r9), r4, r7, r11 | ProvidedValue.$stable);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        goto L28
    L22:
        if (r9 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r7.changedInstance(r4) == false) goto L7;
        int r12 = 4;
    L8:
        r1 = r12 | r6;
        goto L11
    L7:
        r12 = 2;
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* JADX INFO: renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    public static final /* synthetic */ void m1341BasicSecureTextFieldJb9bMDk(final TextFieldState r40, Modifier r41, boolean r42, InputTransformation r43, TextStyle r44, KeyboardOptions r45, KeyboardActionHandler r46, Function2 r47, MutableInteractionSource r48, Brush r49, TextFieldDecorator r50, int r51, char r52, Composer r53, final int r54, final int r55, final int r56) {
        Composer r2 = r53.startRestartGroup(1399310985);
        if ((r56 & 1) == 0) goto L6;
        int r6 = r54 | 6;
    L13:
        int r7 = r56 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L24:
        int r11 = r56 & 4;
        int r16 = 128;
        if (r11 == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r17 = r56 & 8;
        if (r17 == 0) goto L39;
        r6 = r6 | 3072;
    L46:
        int r19 = r56 & 16;
        if (r19 == 0) goto L50;
        r6 = r6 | 24576;
    L57:
        int r21 = r56 & 32;
        if (r21 == 0) goto L61;
        r6 = r6 | 196608;
    L67:
        int r23 = r56 & 64;
        if (r23 == 0) goto L71;
        r6 = r6 | 1572864;
    L77:
        int r1 = r56 & 128;
        if (r1 == 0) goto L81;
        r6 = r6 | 12582912;
    L87:
        int r3 = r56 & 256;
        if (r3 == 0) goto L91;
        r6 = r6 | 100663296;
    L97:
        int r4 = r56 & 512;
        if (r4 == 0) goto L101;
        r6 = r6 | 805306368;
    L107:
        int r5 = r56 & 1024;
        if (r5 == 0) goto L111;
        int r18 = r55 | 6;
    L121:
        int r0 = r56 & 2048;
        if (r0 == 0) goto L125;
        r18 = r18 | 48;
    L131:
        int r8 = r18;
        int r9 = r56 & 4096;
        if (r9 == 0) goto L135;
        r8 = r8 | 384;
    L142:
        if ((r6 & 306783379) == 306783378) goto L144;
    L147:
        boolean r10 = true;
    L149:
        if (r2.shouldExecute(r10, r6 & 1) == false) goto L194;
        if (r7 == 0) goto L152;
        Modifier r12 = Modifier.Companion;
    L153:
        if (r11 == 0) goto L155;
        boolean r13 = true;
    L156:
        final TextFieldDecorator r14 = null;
        if (r17 == 0) goto L159;
        InputTransformation r15 = null;
    L160:
        if (r19 == 0) goto L162;
        TextStyle r35 = TextStyle.Companion.getDefault();
    L163:
        if (r21 == 0) goto L165;
        KeyboardOptions r36 = KeyboardOptions.Companion.getSecureTextField$foundation_release();
    L166:
        if (r23 == 0) goto L168;
        KeyboardActionHandler r37 = null;
    L169:
        if (r1 == 0) goto L171;
        Function2 r20 = null;
    L172:
        if (r3 == 0) goto L174;
        MutableInteractionSource r22 = null;
    L175:
        if (r4 == 0) goto L177;
        Brush r24 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L178:
        if (r5 != 0) goto L181;
        r14 = r50;
    L181:
        if (r0 == 0) goto L183;
        int r25 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
    L184:
        if (r9 == 0) goto L186;
        char r26 = DefaultObfuscationCharacter;
    L188:
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventStart(1399310985, r6, r8, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:363)");
    L190:
        int r110 = r6 << 3;
        int r27 = r8 << 3;
        Modifier r111 = r12;
        boolean r112 = r13;
        InputTransformation r28 = r15;
        TextStyle r29 = r35;
        KeyboardOptions r210 = r36;
        KeyboardActionHandler r211 = r37;
        Function2 r212 = r20;
        MutableInteractionSource r213 = r22;
        Brush r214 = r24;
        TextFieldDecorator r215 = r14;
        int r216 = r25;
        char r217 = r26;
        m1343BasicSecureTextFieldltb6GB4(r40, r111, r112, false, r28, r29, r210, r211, r212, r213, r214, r215, r216, r217, null, r2, (((((((((r6 & 14) | 3072) | (r6 & 112)) | (r6 & 896)) | (57344 & r110)) | (458752 & r110)) | (3670016 & r110)) | (29360128 & r110)) | (234881024 & r110)) | (r110 & 1879048192), ((((r6 >> 27) & 14) | (r27 & 112)) | (r27 & 896)) | (r27 & 7168), 16384);
        if (ComposerKt.isTraceInProgress() == false) goto L193;
        ComposerKt.traceEventEnd();
    L193:
        final Function2 r30 = r20;
        final MutableInteractionSource r31 = r22;
        final char r113 = r26;
        final boolean r32 = r13;
        final TextStyle r33 = r35;
        final KeyboardOptions r34 = r36;
        final Brush r114 = r24;
        final InputTransformation r38 = r15;
        final int r115 = r25;
    L195:
        ScopeUpdateScope r116 = r2.endRestartGroup();
        if (r116 == null) goto L199;
        final Modifier r39 = r12;
        final KeyboardActionHandler r57 = r37;
        r116.updateScope(new m(r40, r39, r32, r38, r33, r34, r57, r30, r31, r114, r14, r115, r113, r54, r55, r56));
        return;
    L199:
        return;
    L186:
        r26 = r52;
        goto L188
    L183:
        r25 = r51;
        goto L184
    L177:
        r24 = r49;
        goto L178
    L174:
        r22 = r48;
        goto L175
    L171:
        r20 = r47;
        goto L172
    L168:
        r37 = r46;
        goto L169
    L165:
        r36 = r45;
        goto L166
    L162:
        r35 = r44;
        goto L163
    L159:
        r15 = r43;
        goto L160
    L155:
        r13 = r42;
        goto L156
    L152:
        r12 = r41;
        goto L153
    L194:
        r2.skipToGroupEnd();
        r12 = r41;
        r32 = r42;
        r38 = r43;
        r33 = r44;
        r34 = r45;
        r37 = r46;
        r30 = r47;
        r31 = r48;
        r114 = r49;
        r14 = r50;
        r115 = r51;
        r113 = r52;
        goto L195
    L144:
        if ((r8 & 147) != 146) goto L147;
        r10 = false;
        goto L149
    L135:
        if ((r55 & 384) != 0) goto L142;
        if (r2.changed(r52) == false) goto L139;
        r16 = 256;
    L139:
        r8 = r8 | r16;
        goto L142
    L125:
        if ((r55 & 48) != 0) goto L131;
        if (r2.changed(r51) == false) goto L129;
        int r218 = 32;
    L130:
        r18 = r18 | r218;
        goto L131
    L129:
        r218 = 16;
        goto L130
    L111:
        if ((r55 & 6) == 0) goto L113;
        r18 = r55;
        goto L121
    L113:
        if ((r55 & 8) != 0) goto L115;
        boolean r219 = r2.changed(r50);
    L116:
        if (r219 == false) goto L118;
        int r117 = 4;
    L119:
        r18 = r55 | r117;
        goto L121
    L118:
        r117 = 2;
        goto L119
    L115:
        r219 = r2.changedInstance(r50);
        goto L116
    L101:
        if ((r54 & 805306368) != 0) goto L107;
        if (r2.changed(r49) == false) goto L105;
        int r220 = 536870912;
    L106:
        r6 = r6 | r220;
        goto L107
    L105:
        r220 = 268435456;
        goto L106
    L91:
        if ((r54 & 100663296) != 0) goto L97;
        if (r2.changed(r48) == false) goto L95;
        int r221 = 67108864;
    L96:
        r6 = r6 | r221;
        goto L97
    L95:
        r221 = 33554432;
        goto L96
    L81:
        if ((r54 & 12582912) != 0) goto L87;
        if (r2.changedInstance(r47) == false) goto L85;
        int r222 = 8388608;
    L86:
        r6 = r6 | r222;
        goto L87
    L85:
        r222 = 4194304;
        goto L86
    L71:
        if ((r54 & 1572864) != 0) goto L77;
        if (r2.changed(r46) == false) goto L75;
        int r223 = 1048576;
    L76:
        r6 = r6 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L61:
        if ((r54 & 196608) != 0) goto L67;
        if (r2.changed(r45) == false) goto L65;
        int r224 = 131072;
    L66:
        r6 = r6 | r224;
        goto L67
    L65:
        r224 = 65536;
        goto L66
    L50:
        if ((r54 & 24576) != 0) goto L57;
        if (r2.changed(r44) == false) goto L54;
        int r225 = 16384;
    L55:
        r6 = r6 | r225;
        goto L57
    L54:
        r225 = 8192;
        goto L55
    L39:
        if ((r54 & 3072) != 0) goto L46;
        if (r2.changed(r43) == false) goto L43;
        int r118 = 2048;
    L44:
        r6 = r6 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r54 & 384) != 0) goto L35;
        if (r2.changed(r42) == false) goto L32;
        int r119 = 256;
    L33:
        r6 = r6 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r54 & 48) != 0) goto L24;
        if (r2.changed(r41) == false) goto L21;
        int r120 = 32;
    L22:
        r6 = r6 | r120;
        goto L24
    L21:
        r120 = 16;
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r6 = r54;
        goto L13
    L8:
        if (r2.changed(r40) == false) goto L10;
        int r58 = 4;
    L11:
        r6 = r58 | r54;
        goto L13
    L10:
        r58 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in scrollState parameter.")
    /* JADX INFO: renamed from: BasicSecureTextField-egD4TGM, reason: not valid java name */
    public static final /* synthetic */ void m1342BasicSecureTextFieldegD4TGM(final TextFieldState r41, Modifier r42, boolean r43, boolean r44, InputTransformation r45, TextStyle r46, KeyboardOptions r47, KeyboardActionHandler r48, Function2 r49, MutableInteractionSource r50, Brush r51, TextFieldDecorator r52, int r53, char r54, Composer r55, final int r56, final int r57, final int r58) {
        Composer r2 = r55.startRestartGroup(-817513499);
        if ((r58 & 1) == 0) goto L6;
        int r6 = r56 | 6;
    L13:
        int r7 = r58 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L24:
        int r11 = r58 & 4;
        int r16 = 128;
        if (r11 == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r17 = r58 & 16;
        if (r17 == 0) goto L39;
        r6 = r6 | 24576;
    L46:
        int r19 = r58 & 32;
        if (r19 == 0) goto L50;
        r6 = r6 | 196608;
    L56:
        int r21 = r58 & 64;
        if (r21 == 0) goto L60;
        r6 = r6 | 1572864;
    L66:
        int r12 = r58 & 128;
        if (r12 == 0) goto L70;
        r6 = r6 | 12582912;
    L76:
        int r1 = r58 & 256;
        if (r1 == 0) goto L80;
        r6 = r6 | 100663296;
    L86:
        int r3 = r58 & 512;
        if (r3 == 0) goto L90;
        r6 = r6 | 805306368;
    L96:
        int r4 = r58 & 1024;
        if (r4 == 0) goto L100;
        int r18 = r57 | 6;
    L107:
        int r5 = r58 & 2048;
        if (r5 == 0) goto L111;
        r18 = r18 | 48;
    L120:
        int r0 = r18;
        int r8 = r58 & 4096;
        if (r8 == 0) goto L124;
        r0 = r0 | 384;
    L130:
        int r9 = r58 & 8192;
        if (r9 == 0) goto L134;
        r0 = r0 | 3072;
    L142:
        if ((r6 & 306782355) == 306782354) goto L144;
    L147:
        boolean r10 = true;
    L149:
        if (r2.shouldExecute(r10, r6 & 1) == false) goto L198;
        if (r7 == 0) goto L152;
        Modifier r13 = Modifier.Companion;
    L153:
        if (r11 == 0) goto L155;
        boolean r14 = true;
    L157:
        if ((r58 & 8) == 0) goto L159;
        boolean r15 = false;
    L160:
        TextFieldDecorator r110 = null;
        if (r17 == 0) goto L163;
        InputTransformation r35 = null;
    L164:
        if (r19 == 0) goto L166;
        TextStyle r36 = TextStyle.Companion.getDefault();
    L167:
        if (r21 == 0) goto L169;
        KeyboardOptions r37 = KeyboardOptions.Companion.getSecureTextField$foundation_release();
    L170:
        if (r12 == 0) goto L172;
        KeyboardActionHandler r111 = null;
    L173:
        if (r1 == 0) goto L175;
        Function2 r20 = null;
    L176:
        if (r3 == 0) goto L178;
        MutableInteractionSource r22 = null;
    L179:
        if (r4 == 0) goto L181;
        Brush r23 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L182:
        if (r5 != 0) goto L185;
        r110 = r52;
    L185:
        if (r8 == 0) goto L187;
        int r24 = TextObfuscationMode.Companion.m1559getRevealLastTypedvTwcZD0();
    L188:
        if (r9 == 0) goto L190;
        char r25 = DefaultObfuscationCharacter;
    L192:
        if (ComposerKt.isTraceInProgress() == false) goto L194;
        ComposerKt.traceEventStart(-817513499, r6, r0, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:405)");
    L194:
        m1343BasicSecureTextFieldltb6GB4(r41, r13, r14, false, r35, r36, r37, r111, r20, r22, r23, r110, r24, r25, ScrollKt.rememberScrollState(0, r2, 0, 1), r2, (((((((((r6 & 14) | 3072) | (r6 & 112)) | (r6 & 896)) | (57344 & r6)) | (458752 & r6)) | (3670016 & r6)) | (29360128 & r6)) | (234881024 & r6)) | (r6 & 1879048192), (((r0 & 14) | (r0 & 112)) | (r0 & 896)) | (r0 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L197;
        ComposerKt.traceEventEnd();
    L197:
        final Function2 r26 = r20;
        final Brush r112 = r23;
        char r113 = r25;
        final TextFieldDecorator r114 = r110;
        final TextStyle r27 = r36;
        final boolean r28 = r15;
        final KeyboardActionHandler r29 = r111;
        int r115 = r24;
        final InputTransformation r30 = r35;
        boolean r40 = r14;
        final MutableInteractionSource r116 = r22;
        final boolean r31 = r40;
    L199:
        ScopeUpdateScope r32 = r2.endRestartGroup();
        if (r32 == null) goto L203;
        final Modifier r33 = r13;
        final KeyboardOptions r34 = r37;
        final int r117 = r115;
        final char r118 = r113;
        r32.updateScope(new l(r41, r33, r31, r28, r30, r27, r34, r29, r26, r116, r112, r114, r117, r118, r56, r57, r58));
        return;
    L203:
        return;
    L190:
        r25 = r54;
        goto L192
    L187:
        r24 = r53;
        goto L188
    L181:
        r23 = r51;
        goto L182
    L178:
        r22 = r50;
        goto L179
    L175:
        r20 = r49;
        goto L176
    L172:
        r111 = r48;
        goto L173
    L169:
        r37 = r47;
        goto L170
    L166:
        r36 = r46;
        goto L167
    L163:
        r35 = r45;
        goto L164
    L159:
        r15 = r44;
        goto L160
    L155:
        r14 = r43;
        goto L157
    L152:
        r13 = r42;
        goto L153
    L198:
        r2.skipToGroupEnd();
        r13 = r42;
        r31 = r43;
        r28 = r44;
        r30 = r45;
        r27 = r46;
        r37 = r47;
        r29 = r48;
        r26 = r49;
        r116 = r50;
        r112 = r51;
        r114 = r52;
        r115 = r53;
        r113 = r54;
        goto L199
    L144:
        if ((r0 & 1171) != 1170) goto L147;
        r10 = false;
        goto L149
    L134:
        if ((r57 & 3072) != 0) goto L142;
        if (r2.changed(r54) == false) goto L138;
        int r119 = 2048;
    L139:
        r0 = r0 | r119;
        goto L142
    L138:
        r119 = 1024;
        goto L139
    L124:
        if ((r57 & 384) != 0) goto L130;
        if (r2.changed(r53) == false) goto L128;
        r16 = 256;
    L128:
        r0 = r0 | r16;
        goto L130
    L111:
        if ((r57 & 48) != 0) goto L120;
        if ((r57 & 64) != 0) goto L115;
        boolean r210 = r2.changed(r52);
    L116:
        if (r210 == false) goto L118;
        int r211 = 32;
    L119:
        r18 = r18 | r211;
        goto L120
    L118:
        r211 = 16;
        goto L119
    L115:
        r210 = r2.changedInstance(r52);
        goto L116
    L100:
        if ((r57 & 6) == 0) goto L102;
        r18 = r57;
        goto L107
    L102:
        if (r2.changed(r51) == false) goto L104;
        int r120 = 4;
    L105:
        r18 = r57 | r120;
        goto L107
    L104:
        r120 = 2;
        goto L105
    L90:
        if ((r56 & 805306368) != 0) goto L96;
        if (r2.changed(r50) == false) goto L94;
        int r212 = 536870912;
    L95:
        r6 = r6 | r212;
        goto L96
    L94:
        r212 = 268435456;
        goto L95
    L80:
        if ((r56 & 100663296) != 0) goto L86;
        if (r2.changedInstance(r49) == false) goto L84;
        int r213 = 67108864;
    L85:
        r6 = r6 | r213;
        goto L86
    L84:
        r213 = 33554432;
        goto L85
    L70:
        if ((r56 & 12582912) != 0) goto L76;
        if (r2.changed(r48) == false) goto L74;
        int r214 = 8388608;
    L75:
        r6 = r6 | r214;
        goto L76
    L74:
        r214 = 4194304;
        goto L75
    L60:
        if ((r56 & 1572864) != 0) goto L66;
        if (r2.changed(r47) == false) goto L64;
        int r215 = 1048576;
    L65:
        r6 = r6 | r215;
        goto L66
    L64:
        r215 = 524288;
        goto L65
    L50:
        if ((r56 & 196608) != 0) goto L56;
        if (r2.changed(r46) == false) goto L54;
        int r216 = 131072;
    L55:
        r6 = r6 | r216;
        goto L56
    L54:
        r216 = 65536;
        goto L55
    L39:
        if ((r56 & 24576) != 0) goto L46;
        if (r2.changed(r45) == false) goto L43;
        int r121 = 16384;
    L44:
        r6 = r6 | r121;
        goto L46
    L43:
        r121 = 8192;
        goto L44
    L28:
        if ((r56 & 384) != 0) goto L35;
        if (r2.changed(r43) == false) goto L32;
        int r122 = 256;
    L33:
        r6 = r6 | r122;
        goto L35
    L32:
        r122 = 128;
        goto L33
    L17:
        if ((r56 & 48) != 0) goto L24;
        if (r2.changed(r42) == false) goto L21;
        int r123 = 32;
    L22:
        r6 = r6 | r123;
        goto L24
    L21:
        r123 = 16;
        goto L22
    L6:
        if ((r56 & 6) == 0) goto L8;
        r6 = r56;
        goto L13
    L8:
        if (r2.changed(r41) == false) goto L10;
        int r38 = 4;
    L11:
        r6 = r38 | r56;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BasicSecureTextField-ltb6GB4, reason: not valid java name */
    public static final void m1343BasicSecureTextFieldltb6GB4(final TextFieldState r36, Modifier r37, boolean r38, boolean r39, InputTransformation r40, TextStyle r41, KeyboardOptions r42, KeyboardActionHandler r43, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r44, MutableInteractionSource r45, Brush r46, TextFieldDecorator r47, int r48, char r49, ScrollState r50, Composer r51, final int r52, final int r53, final int r54) {
        Composer r2 = r51.startRestartGroup(1568790509);
        if ((r54 & 1) == 0) goto L6;
        int r6 = r52 | 6;
    L13:
        int r7 = r54 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L24:
        int r11 = r54 & 4;
        if (r11 == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r17 = r54 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L39;
        r6 = r6 | 3072;
    L46:
        int r21 = r54 & 16;
        int r22 = 8192;
        if (r21 == 0) goto L50;
        r6 = r6 | 24576;
    L57:
        int r25 = r54 & 32;
        if (r25 == 0) goto L61;
        r6 = r6 | 196608;
    L67:
        int r27 = r54 & 64;
        if (r27 == 0) goto L71;
        r6 = r6 | 1572864;
    L77:
        int r1 = r54 & 128;
        if (r1 == 0) goto L81;
        r6 = r6 | 12582912;
    L87:
        int r3 = r54 & 256;
        if (r3 == 0) goto L91;
        r6 = r6 | 100663296;
    L97:
        int r4 = r54 & 512;
        if (r4 == 0) goto L101;
        r6 = r6 | 805306368;
    L107:
        int r5 = r54 & 1024;
        if (r5 == 0) goto L111;
        int r16 = r53 | 6;
    L118:
        int r8 = r54 & 2048;
        if (r8 == 0) goto L122;
        r16 = r16 | 48;
    L132:
        if ((r53 & 384) != 0) goto L142;
        if ((r54 & 4096) != 0) goto L139;
        if (r2.changed(r48) == false) goto L139;
        int r26 = 256;
    L140:
        r16 = r16 | r26;
    L139:
        r26 = 128;
    L142:
        int r0 = r16;
        int r9 = r54 & 8192;
        if (r9 == 0) goto L146;
        r0 = r0 | 3072;
    L154:
        if ((r53 & 24576) != 0) goto L164;
        if ((r54 & 16384) != 0) goto L161;
        if (r2.changed(r50) == false) goto L161;
        r22 = 16384;
    L161:
        r0 = r0 | r22;
    L164:
        if ((r6 & 306783379) == 306783378) goto L166;
    L169:
        boolean r10 = true;
    L171:
        if (r2.shouldExecute(r10, r6 & 1) == false) goto L284;
        r2.startDefaults();
        if ((r52 & 1) != 0) goto L175;
    L184:
        if (r7 == 0) goto L186;
        Modifier r12 = Modifier.Companion;
    L187:
        if (r11 == 0) goto L189;
        boolean r13 = true;
    L190:
        if (r17 == 0) goto L192;
        boolean r14 = false;
    L193:
        if (r21 == 0) goto L195;
        InputTransformation r19 = null;
    L196:
        if (r25 == 0) goto L198;
        TextStyle r110 = TextStyle.Companion.getDefault();
    L199:
        if (r27 == 0) goto L201;
        KeyboardOptions r111 = KeyboardOptions.Companion.getSecureTextField$foundation_release();
    L202:
        if (r1 == 0) goto L204;
        KeyboardActionHandler r15 = null;
    L205:
        if (r3 == 0) goto L207;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r20 = null;
    L208:
        if (r4 == 0) goto L210;
        MutableInteractionSource r23 = null;
    L211:
        if (r5 == 0) goto L213;
        Brush r24 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
    L214:
        if (r8 == 0) goto L216;
        TextFieldDecorator r28 = null;
    L218:
        if ((r54 & 4096) == 0) goto L220;
        int r112 = TextObfuscationMode_androidKt.getDefault(TextObfuscationMode.Companion);
        r0 = r0 & (-897);
    L221:
        if (r9 == 0) goto L223;
        char r29 = DefaultObfuscationCharacter;
    L225:
        if ((r54 & 16384) == 0) goto L227;
        int r113 = r0 & (-57345);
        ScrollState r33 = ScrollKt.rememberScrollState(0, r2, 0, 1);
    L228:
        MutableInteractionSource r30 = r23;
        Brush r31 = r24;
        KeyboardActionHandler r32 = r15;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r34 = r20;
        TextStyle r35 = r110;
        KeyboardOptions r55 = r111;
    L229:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L233;
        ComposerKt.traceEventStart(1568790509, r6, r113, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:139)");
    L233:
        final State r56 = SnapshotStateKt.rememberUpdatedState(Character.valueOf(r29), r2, (r113 >> 9) & 14);
        Object r57 = r2.rememberedValue();
        Composer.Companion r114 = Composer.Companion;
        char r310 = r29;
        if (r57 != r114.getEmpty()) goto L236;
        r57 = new SecureTextFieldController(r56);
        r2.updateRememberedValue(r57);
    L236:
        final SecureTextFieldController r58 = (SecureTextFieldController) r57;
        boolean r115 = r2.changedInstance(r58);
        final MutableInteractionSource r410 = r30;
        Object r59 = r2.rememberedValue();
        if (r115 == false) goto L239;
    L240:
        r59 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(r58, null);
        r2.updateRememberedValue(r59);
    L241:
        EffectsKt.LaunchedEffect(r58, (Function2) r59, r2, 0);
        TextObfuscationMode.Companion r60 = TextObfuscationMode.Companion;
        if (TextObfuscationMode.m1554equalsimpl0(r112, r60.m1559getRevealLastTypedvTwcZD0()) == false) goto L244;
        r2.startReplaceGroup(74209068);
        boolean r116 = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped(r2, 0);
        r2.endReplaceGroup();
        boolean r117 = r116;
    L245:
        Boolean r61 = Boolean.valueOf(r117);
        boolean r118 = r2.changed(r117) | r2.changedInstance(r58);
        final KeyboardActionHandler r411 = r32;
        Object r62 = r2.rememberedValue();
        final KeyboardOptions r412 = r55;
        if (r118 == false) goto L248;
    L249:
        r62 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(r117, r58, null);
        r2.updateRememberedValue(r62);
    L250:
        EffectsKt.LaunchedEffect(r61, (Function2) r62, r2, 0);
        if (((r113 & 896) ^ 384) <= 256) goto L255;
        if (r2.changed(r112) == false) goto L255;
    L256:
        boolean r63 = true;
    L258:
        Object r64 = r2.rememberedValue();
        if (r63 == true) goto L263;
        if (r64 == r114.getEmpty()) goto L263;
    L270:
        final CodepointTransformation r311 = (CodepointTransformation) r64;
        Object r65 = r2.rememberedValue();
        if (r65 != r114.getEmpty()) goto L273;
        r65 = new j();
        r2.updateRememberedValue(r65);
    L273:
        Modifier r66 = SemanticsModifierKt.semantics$default(r12, false, (Function1) r65, 1, null);
        Object r67 = r2.rememberedValue();
        if (r67 != r114.getEmpty()) goto L276;
        r67 = BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1.INSTANCE;
        r2.updateRememberedValue(r67);
    L276:
        Modifier r68 = KeyInputModifierKt.onPreviewKeyEvent(r66, (Function1) r67);
        if (r117 == false) goto L279;
        Modifier r69 = r58.getFocusChangeModifier();
    L280:
        final Modifier r210 = r68.then(r69);
        final boolean r119 = r117;
        final InputTransformation r120 = r19;
        final boolean r211 = r13;
        final boolean r212 = r14;
        final TextStyle r213 = r35;
        final Function2 r214 = r34;
        final Brush r215 = r31;
        final TextFieldDecorator r312 = r28;
        final ScrollState r313 = r33;
        DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(135148049, true, new BasicSecureTextFieldKt$BasicSecureTextField$3(r119, r120, r58, r36, r210, r211, r212, r213, r412, r411, r214, r410, r215, r311, r312, r313), r2, 54), r2, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L283;
        ComposerKt.traceEventEnd();
    L283:
        TextFieldDecorator r121 = r28;
        Brush r122 = r31;
        char r123 = r310;
        KeyboardActionHandler r70 = r411;
        KeyboardOptions r71 = r412;
        final InputTransformation r72 = r19;
        final TextStyle r73 = r35;
        final boolean r74 = r13;
        final boolean r75 = r14;
        MutableInteractionSource r124 = r410;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r125 = r34;
    L285:
        ScopeUpdateScope r76 = r2.endRestartGroup();
        if (r76 == null) goto L289;
        final Modifier r77 = r12;
        final KeyboardOptions r78 = r71;
        final KeyboardActionHandler r79 = r70;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r80 = r125;
        final MutableInteractionSource r126 = r124;
        final Brush r127 = r122;
        final TextFieldDecorator r128 = r121;
        final int r129 = r112;
        final char r130 = r123;
        final ScrollState r131 = r33;
        r76.updateScope(new k(r36, r77, r74, r75, r72, r73, r78, r79, r80, r126, r127, r128, r129, r130, r131, r52, r53, r54));
        return;
    L289:
        return;
    L279:
        r69 = Modifier.Companion;
    L263:
        if (TextObfuscationMode.m1554equalsimpl0(r112, r60.m1559getRevealLastTypedvTwcZD0()) == false) goto L266;
        CodepointTransformation r81 = r58.getCodepointTransformation();
    L269:
        r2.updateRememberedValue(r81);
        r64 = r81;
        goto L270
    L266:
        if (TextObfuscationMode.m1554equalsimpl0(r112, r60.m1558getHiddenvTwcZD0()) == false) goto L268;
        r81 = new i(r56);
        goto L269
    L268:
        r81 = null;
    L255:
        if ((r113 & 384) == 256) goto L256;
        r63 = false;
        goto L258
    L248:
        if (r62 != r114.getEmpty()) goto L250;
    L244:
        r2.startReplaceGroup(-1994484951);
        r2.endReplaceGroup();
        r117 = false;
        goto L245
    L239:
        if (r59 != r114.getEmpty()) goto L241;
    L227:
        r33 = r50;
        r113 = r0;
        goto L228
    L223:
        r29 = r49;
        goto L225
    L220:
        r112 = r48;
        goto L221
    L216:
        r28 = r47;
        goto L218
    L213:
        r24 = r46;
        goto L214
    L210:
        r23 = r45;
        goto L211
    L207:
        r20 = r44;
        goto L208
    L204:
        r15 = r43;
        goto L205
    L201:
        r111 = r42;
        goto L202
    L198:
        r110 = r41;
        goto L199
    L195:
        r19 = r40;
        goto L196
    L192:
        r14 = r39;
        goto L193
    L189:
        r13 = r38;
        goto L190
    L186:
        r12 = r37;
        goto L187
    L175:
        if (r2.getDefaultsInvalid() == true) goto L184;
        r2.skipToGroupEnd();
        if ((r54 & 4096) == 0) goto L181;
        r0 = r0 & (-897);
    L181:
        if ((r54 & 16384) == 0) goto L183;
        r0 = r0 & (-57345);
    L183:
        r12 = r37;
        r13 = r38;
        r14 = r39;
        r35 = r41;
        r55 = r42;
        r32 = r43;
        r34 = r44;
        r30 = r45;
        r31 = r46;
        r28 = r47;
        r112 = r48;
        r29 = r49;
        r33 = r50;
        r113 = r0;
        r19 = r40;
        goto L229
    L284:
        r2.skipToGroupEnd();
        r12 = r37;
        r74 = r38;
        r75 = r39;
        r72 = r40;
        r73 = r41;
        r71 = r42;
        r70 = r43;
        r125 = r44;
        r124 = r45;
        r122 = r46;
        r121 = r47;
        r112 = r48;
        r123 = r49;
        r33 = r50;
        goto L285
    L166:
        if ((r0 & 9363) != 9362) goto L169;
        r10 = false;
        goto L171
    L146:
        if ((r53 & 3072) != 0) goto L154;
        if (r2.changed(r49) == true) goto L151;
        r18 = 1024;
    L151:
        r0 = r0 | r18;
        goto L154
    L122:
        if ((r53 & 48) != 0) goto L132;
        if ((r53 & 64) != 0) goto L126;
        boolean r314 = r2.changed(r47);
    L127:
        if (r314 == false) goto L129;
        int r216 = 32;
    L130:
        r16 = r16 | r216;
        goto L132
    L129:
        r216 = 16;
        goto L130
    L126:
        r314 = r2.changedInstance(r47);
        goto L127
    L111:
        if ((r53 & 6) == 0) goto L113;
        r16 = r53;
        goto L118
    L113:
        if (r2.changed(r46) == false) goto L115;
        int r132 = 4;
    L116:
        r16 = r53 | r132;
        goto L118
    L115:
        r132 = 2;
        goto L116
    L101:
        if ((r52 & 805306368) != 0) goto L107;
        if (r2.changed(r45) == false) goto L105;
        int r315 = 536870912;
    L106:
        r6 = r6 | r315;
        goto L107
    L105:
        r315 = 268435456;
        goto L106
    L91:
        if ((r52 & 100663296) != 0) goto L97;
        if (r2.changedInstance(r44) == false) goto L95;
        int r316 = 67108864;
    L96:
        r6 = r6 | r316;
        goto L97
    L95:
        r316 = 33554432;
        goto L96
    L81:
        if ((r52 & 12582912) != 0) goto L87;
        if (r2.changed(r43) == false) goto L85;
        int r317 = 8388608;
    L86:
        r6 = r6 | r317;
        goto L87
    L85:
        r317 = 4194304;
        goto L86
    L71:
        if ((r52 & 1572864) != 0) goto L77;
        if (r2.changed(r42) == false) goto L75;
        int r217 = 1048576;
    L76:
        r6 = r6 | r217;
        goto L77
    L75:
        r217 = 524288;
        goto L76
    L61:
        if ((r52 & 196608) != 0) goto L67;
        if (r2.changed(r41) == false) goto L65;
        int r218 = 131072;
    L66:
        r6 = r6 | r218;
        goto L67
    L65:
        r218 = 65536;
        goto L66
    L50:
        if ((r52 & 24576) != 0) goto L57;
        if (r2.changed(r40) == false) goto L54;
        int r219 = 16384;
    L55:
        r6 = r6 | r219;
        goto L57
    L54:
        r219 = 8192;
        goto L55
    L39:
        if ((r52 & 3072) != 0) goto L46;
        if (r2.changed(r39) == false) goto L43;
        int r220 = 2048;
    L44:
        r6 = r6 | r220;
        goto L46
    L43:
        r220 = 1024;
        goto L44
    L28:
        if ((r52 & 384) != 0) goto L35;
        if (r2.changed(r38) == false) goto L32;
        int r133 = 256;
    L33:
        r6 = r6 | r133;
        goto L35
    L32:
        r133 = 128;
        goto L33
    L17:
        if ((r52 & 48) != 0) goto L24;
        if (r2.changed(r37) == false) goto L21;
        int r134 = 32;
    L22:
        r6 = r6 | r134;
        goto L24
    L21:
        r134 = 16;
        goto L22
    L6:
        if ((r52 & 6) == 0) goto L8;
        r6 = r52;
        goto L13
    L8:
        if (r2.changed(r36) == false) goto L10;
        int r82 = 4;
    L11:
        r6 = r82 | r52;
        goto L13
    L10:
        r82 = 2;
        goto L11
    }
}
