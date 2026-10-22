package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class BasicTextFieldKt$DefaultTextFieldDecorator$1 implements TextFieldDecorator {
    public static final BasicTextFieldKt$DefaultTextFieldDecorator$1 INSTANCE = null;

    static {
        INSTANCE = new BasicTextFieldKt$DefaultTextFieldDecorator$1();
    }

    public BasicTextFieldKt$DefaultTextFieldDecorator$1() {
    }

    private static final Unit Decoration$lambda$0(BasicTextFieldKt$DefaultTextFieldDecorator$1 r0, Function2 r1, int r2, Composer r3, int r4) {
        r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(BasicTextFieldKt$DefaultTextFieldDecorator$1 r0, Function2 r1, int r2, Composer r3, int r4) {
        return Decoration$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldDecorator
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r5, Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(-2101003086);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r7 & 48) != 0) goto L18;
        if (r8.changed(this) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r8.shouldExecute(r3, r1 & 1) == true) goto L24;
        r8.skipToGroupEnd();
    L30:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L34;
        r9.updateScope(new k0(this, r5, r7));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-2101003086, r1, -1, "androidx.compose.foundation.text.DefaultTextFieldDecorator.<no name provided>.Decoration (BasicTextField.kt:610)");
    L26:
        r5.invoke(r8, Integer.valueOf(r1 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r8.changedInstance(r5) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r7;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }
}
