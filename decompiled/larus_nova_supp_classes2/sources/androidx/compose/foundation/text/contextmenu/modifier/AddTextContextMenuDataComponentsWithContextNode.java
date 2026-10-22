package androidx.compose.foundation.text.contextmenu.modifier;

import android.content.Context;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nR1\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "builder", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "Landroid/content/Context;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getBuilder", "()Lkotlin/jvm/functions/Function2;", "setBuilder", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AddTextContextMenuDataComponentsWithContextNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    private Function2<? super TextContextMenuBuilderScope, ? super Context, Unit> builder;

    public static /* synthetic */ Unit a(AddTextContextMenuDataComponentsWithContextNode r0, TextContextMenuBuilderScope r1) {
        return _init_$lambda$0(r0, r1);
    }

    public final Function2<TextContextMenuBuilderScope, Context, Unit> getBuilder() {
        return this.builder;
    }

    public AddTextContextMenuDataComponentsWithContextNode(Function2<? super TextContextMenuBuilderScope, ? super Context, Unit> r2) {
        this.builder = r2;
        delegate(new AddTextContextMenuDataComponentsNode(new a(this)));
    }

    public final void setBuilder(Function2<? super TextContextMenuBuilderScope, ? super Context, Unit> r1) {
        this.builder = r1;
    }

    private static final Unit _init_$lambda$0(AddTextContextMenuDataComponentsWithContextNode r2, TextContextMenuBuilderScope r3) {
        r2.builder.invoke(r3, CompositionLocalConsumerModifierNodeKt.currentValueOf(r2, AndroidCompositionLocals_androidKt.getLocalContext()));
        return Unit.INSTANCE;
    }
}
