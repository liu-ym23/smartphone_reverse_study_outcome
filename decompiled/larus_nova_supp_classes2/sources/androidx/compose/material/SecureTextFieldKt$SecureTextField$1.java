package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt$SecureTextField$1 implements TextFieldDecorator {
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

    public SecureTextFieldKt$SecureTextField$1(TextFieldState r1, boolean r2, MutableInteractionSource r3, boolean r4, Function2<? super Composer, ? super Integer, Unit> r5, Function2<? super Composer, ? super Integer, Unit> r6, Function2<? super Composer, ? super Integer, Unit> r7, Function2<? super Composer, ? super Integer, Unit> r8, Shape r9, TextFieldColors r10) {
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

    private static final Unit Decoration$lambda$0(SecureTextFieldKt$SecureTextField$1 r0, Function2 r1, int r2, Composer r3, int r4) {
        r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SecureTextFieldKt$SecureTextField$1 r0, Function2 r1, int r2, Composer r3, int r4) {
        return Decoration$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldDecorator
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r22, Composer r23, final int r24) {
        Composer r14 = r23.startRestartGroup(-1564434043);
        if ((r24 & 6) == 0) goto L5;
        int r2 = r24;
    L11:
        if ((r24 & 48) == 0) goto L13;
    L17:
        int r13 = r2;
        if ((r13 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r14.shouldExecute(r3, r13 & 1) == true) goto L24;
        Composer r20 = r14;
        r20.skipToGroupEnd();
    L30:
        ScopeUpdateScope r1 = r20.endRestartGroup();
        if (r1 == null) goto L34;
        r1.updateScope(new f9(this, r22, r24));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1564434043, r13, -1, "androidx.compose.material.SecureTextField.<no name provided>.Decoration (SecureTextField.kt:148)");
    L26:
        TextFieldDefaults r4 = TextFieldDefaults.INSTANCE;
        String r5 = this.$state.getText().toString();
        VisualTransformation r6 = VisualTransformation.Companion.getNone();
        r20 = r14;
        r4.TextFieldDecorationBox(r5, r22, this.$enabled, true, r6, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$shape, this.$colors, null, r20, ((r13 << 3) & 112) | 27648, 24576, 8192);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L13:
        if (r14.changed(this) == false) goto L15;
        int r7 = 32;
    L16:
        r2 = r2 | r7;
        goto L17
    L15:
        r7 = 16;
        goto L16
    L5:
        if (r14.changedInstance(r22) == false) goto L7;
        int r8 = 4;
    L8:
        r2 = r8 | r24;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }
}
