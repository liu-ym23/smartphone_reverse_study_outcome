package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class TextContextMenuModifierKt$collectTextContextMenuData$1$1 extends FunctionReferenceImpl implements Function1<Function1<? super TextContextMenuComponent, ? extends Boolean>, Unit> {
    public TextContextMenuModifierKt$collectTextContextMenuData$1$1(Object r8) {
        super(1, r8, TextContextMenuBuilderScope.class, "addFilter", "addFilter$foundation_release(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Function1) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Function1<? super TextContextMenuComponent, Boolean> r2) {
        ((TextContextMenuBuilderScope) ((CallableReference) this).receiver).addFilter$foundation_release(r2);
    }
}
