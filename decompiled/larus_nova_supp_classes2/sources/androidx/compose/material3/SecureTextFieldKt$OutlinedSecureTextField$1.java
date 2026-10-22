package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicSecureTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt$OutlinedSecureTextField$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
    final /* synthetic */ TextFieldLabelPosition $labelPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ KeyboardActionHandler $onKeyboardAction;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ char $textObfuscationCharacter;
    final /* synthetic */ int $textObfuscationMode;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX WARN: Multi-variable type inference failed */
    public SecureTextFieldKt$OutlinedSecureTextField$1(Modifier r3, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r4, TextFieldLabelPosition r5, boolean r6, TextFieldColors r7, TextFieldState r8, boolean r9, MutableInteractionSource r10, Function2<? super Composer, ? super Integer, Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Function2<? super Composer, ? super Integer, Unit> r13, Function2<? super Composer, ? super Integer, Unit> r14, Function2<? super Composer, ? super Integer, Unit> r15, Function2<? super Composer, ? super Integer, Unit> r16, PaddingValues r17, InputTransformation r18, TextStyle r19, KeyboardOptions r20, KeyboardActionHandler r21, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r22, int r23, char r24, Shape r25) {
        this.$modifier = r3;
        this.$label = r4;
        this.$labelPosition = r5;
        this.$isError = r6;
        this.$colors = r7;
        this.$state = r8;
        this.$enabled = r9;
        this.$interactionSource = r10;
        this.$placeholder = r11;
        this.$leadingIcon = r12;
        this.$trailingIcon = r13;
        this.$prefix = r14;
        this.$suffix = r15;
        this.$supportingText = r16;
        this.$contentPadding = r17;
        this.$inputTransformation = r18;
        this.$mergedTextStyle = r19;
        this.$keyboardOptions = r20;
        this.$onKeyboardAction = r21;
        this.$onTextLayout = r22;
        this.$textObfuscationMode = r23;
        this.$textObfuscationCharacter = r24;
        this.$shape = r25;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void invoke(Composer r42, int r43) {
        if ((r43 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r42.shouldExecute(r2, r43 & 1) == true) goto L9;
        r42.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1147500080, r43, -1, "androidx.compose.material3.OutlinedSecureTextField.<anonymous> (SecureTextField.kt:327)");
    L11:
        Modifier r1 = this.$modifier;
        if (this.$label != null) goto L14;
    L19:
        r42.startReplaceGroup(1530795410);
        r42.endReplaceGroup();
        Modifier r3 = Modifier.Companion;
    L20:
        Modifier r4 = TextFieldImplKt.defaultErrorSemantics(r1.then(r3), this.$isError, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131896082), r42, 0));
        OutlinedTextFieldDefaults r5 = OutlinedTextFieldDefaults.INSTANCE;
        Modifier r24 = SizeKt.m998defaultMinSizeVpY3zN4(r4, r5.m2975getMinWidthD9Ej5fM(), r5.m2974getMinHeightD9Ej5fM());
        SolidColor r6 = new SolidColor(this.$colors.m3278cursorColorvNxB06k$material3(this.$isError), null);
        TextFieldState r7 = this.$state;
        final boolean r13 = this.$enabled;
        TextFieldLineLimits.SingleLine r8 = TextFieldLineLimits.SingleLine.INSTANCE;
        final MutableInteractionSource r12 = this.$interactionSource;
        TextFieldLabelPosition r9 = this.$labelPosition;
        Function3<TextFieldLabelScope, Composer, Integer, Unit> r10 = this.$label;
        Function2<? super Composer, ? super Integer, Unit> r11 = this.$placeholder;
        Function2<? super Composer, ? super Integer, Unit> r14 = this.$leadingIcon;
        Function2<? super Composer, ? super Integer, Unit> r15 = this.$trailingIcon;
        Function2<? super Composer, ? super Integer, Unit> r16 = this.$prefix;
        Function2<? super Composer, ? super Integer, Unit> r17 = this.$suffix;
        Function2<? super Composer, ? super Integer, Unit> r18 = this.$supportingText;
        final boolean r19 = this.$isError;
        final TextFieldColors r20 = this.$colors;
        PaddingValues r21 = this.$contentPadding;
        final Shape r22 = this.$shape;
        TextFieldDecorator r34 = r5.decorator(r7, r13, r8, null, r12, r9, r10, r11, r14, r15, r16, r17, r18, r19, r20, r21, ComposableLambdaKt.rememberComposableLambda(-1406782897, true, new AnonymousClass2(r13, r19, r12, r20, r22), r42, 54), r42, 3456, 14155776, 0);
        BasicSecureTextFieldKt.m1342BasicSecureTextFieldegD4TGM(this.$state, r24, this.$enabled, false, this.$inputTransformation, this.$mergedTextStyle, this.$keyboardOptions, this.$onKeyboardAction, this.$onTextLayout, this.$interactionSource, r6, r34, this.$textObfuscationMode, this.$textObfuscationCharacter, r42, 0, 0, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventEnd();
        return;
    L25:
        return;
    L14:
        if ((this.$labelPosition instanceof TextFieldLabelPosition.Above) == true) goto L19;
        r42.startReplaceGroup(1530411723);
        Modifier.Companion r23 = Modifier.Companion;
        Object r25 = r42.rememberedValue();
        if (r25 != Composer.Companion.getEmpty()) goto L18;
        r25 = new fn();
        r42.updateRememberedValue(r25);
    L18:
        r3 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r23, true, (Function1) r25), MenuKt.ClosedAlphaTarget, TextFieldImplKt.minimizedLabelHalfHeight(r42, 0), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null);
        r42.endReplaceGroup();
        goto L20
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
