package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt$OutlinedSecureTextField$3 implements TextFieldDecorator {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    public SecureTextFieldKt$OutlinedSecureTextField$3(TextFieldState r1, boolean r2, MutableInteractionSource r3, boolean r4, Function2<? super Composer, ? super Integer, Unit> r5, Function2<? super Composer, ? super Integer, Unit> r6, Function2<? super Composer, ? super Integer, Unit> r7, Function2<? super Composer, ? super Integer, Unit> r8, Shape r9, TextFieldColors r10) {
        this.$state = r1;
        this.$enabled = r2;
        this.$interactionSource = r3;
        this.$isError = r4;
        this.$label = r5;
        this.$placeholder = r6;
        this.$leadingIcon = r7;
        this.$trailingIcon = r8;
        this.$shape = r9;
        this.$colors = r10;
    }

    private static final Unit Decoration$lambda$0(SecureTextFieldKt$OutlinedSecureTextField$3 r0, Function2 r1, int r2, Composer r3, int r4) {
        r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SecureTextFieldKt$OutlinedSecureTextField$3 r0, Function2 r1, int r2, Composer r3, int r4) {
        return Decoration$lambda$0(r0, r1, r2, r3, r4);
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
    @Override // androidx.compose.foundation.text.input.TextFieldDecorator
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r24, Composer r25, final int r26) {
        Composer r14 = r25.startRestartGroup(-741592697);
        if ((r26 & 6) == 0) goto L5;
        int r2 = r26;
    L11:
        if ((r26 & 48) == 0) goto L13;
    L17:
        int r13 = r2;
        if ((r13 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r14.shouldExecute(r3, r13 & 1) == true) goto L24;
        Composer r0 = r14;
        r0.skipToGroupEnd();
    L30:
        ScopeUpdateScope r1 = r0.endRestartGroup();
        if (r1 == null) goto L34;
        r1.updateScope(new e9(this, r24, r26));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-741592697, r13, -1, "androidx.compose.material.OutlinedSecureTextField.<no name provided>.Decoration (SecureTextField.kt:282)");
    L26:
        TextFieldDefaults r4 = TextFieldDefaults.INSTANCE;
        String r5 = this.$state.getText().toString();
        VisualTransformation r6 = VisualTransformation.Companion.getNone();
        final boolean r11 = this.$enabled;
        final MutableInteractionSource r10 = this.$interactionSource;
        final boolean r9 = this.$isError;
        Function2<? super Composer, ? super Integer, Unit> r12 = this.$label;
        Function2<? super Composer, ? super Integer, Unit> r15 = this.$placeholder;
        Function2<? super Composer, ? super Integer, Unit> r16 = this.$leadingIcon;
        Function2<? super Composer, ? super Integer, Unit> r17 = this.$trailingIcon;
        final Shape r7 = this.$shape;
        final TextFieldColors r18 = this.$colors;
        r0 = r14;
        r4.OutlinedTextFieldDecorationBox(r5, r24, r11, true, r6, r10, r9, r12, r15, r16, r17, r7, r18, null, ComposableLambdaKt.rememberComposableLambda(910489071, true, new SecureTextFieldKt$OutlinedSecureTextField$3$Decoration$1(r11, r9, r10, r18, r7), r0, 54), r0, ((r13 << 3) & 112) | 27648, 221184, 8192);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L13:
        if (r14.changed(this) == false) goto L15;
        int r8 = 32;
    L16:
        r2 = r2 | r8;
        goto L17
    L15:
        r8 = 16;
        goto L16
    L5:
        if (r14.changedInstance(r24) == false) goto L7;
        int r19 = 4;
    L8:
        r2 = r19 | r26;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }
}
