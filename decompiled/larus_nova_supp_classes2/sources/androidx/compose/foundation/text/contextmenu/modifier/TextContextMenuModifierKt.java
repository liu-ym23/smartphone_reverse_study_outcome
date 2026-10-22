package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003\u001aQ\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00050\u00032#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00050\u0003H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u000fH\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"appendTextContextMenuComponents", "Landroidx/compose/ui/Modifier;", "builder", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "filterTextContextMenuComponents", "filter", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "", "continueTraversal", "wrongNodeTypeErrorMessage", "", "traverseTextContextMenuDataNodes", "Landroidx/compose/ui/node/DelegatableNode;", "filterBlock", "builderBlock", "collectTextContextMenuData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuModifierKt {
    private static final boolean continueTraversal = true;
    private static final String wrongNodeTypeErrorMessage = "TextContextMenuDataNode.TraverseKey key must only be attached to instances of TextContextMenuDataNode.";

    public static /* synthetic */ boolean a(Function1 r0, Function1 r1, TraversableNode r2) {
        return traverseTextContextMenuDataNodes$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(TextContextMenuBuilderScope r0, Function1 r1) {
        return collectTextContextMenuData$lambda$2$lambda$1(r0, r1);
    }

    public static final TextContextMenuData collectTextContextMenuData(DelegatableNode r3) {
        final TextContextMenuBuilderScope r0 = new TextContextMenuBuilderScope();
        traverseTextContextMenuDataNodes(r3, new TextContextMenuModifierKt$collectTextContextMenuData$1$1(r0), new b(r0));
        return r0.build$foundation_release();
    }

    public static final Modifier appendTextContextMenuComponents(Modifier r1, Function1<? super TextContextMenuBuilderScope, Unit> r2) {
        return r1.then(new AddTextContextMenuDataComponentsElement(r2));
    }

    private static final Unit collectTextContextMenuData$lambda$2$lambda$1(TextContextMenuBuilderScope r0, Function1 r1) {
        r1.invoke(r0);
        return Unit.INSTANCE;
    }

    public static final Modifier filterTextContextMenuComponents(Modifier r1, Function1<? super TextContextMenuComponent, Boolean> r2) {
        return r1.then(new FilterTextContextMenuDataComponentsElement(r2));
    }

    private static final void traverseTextContextMenuDataNodes(DelegatableNode r2, final Function1<? super Function1<? super TextContextMenuComponent, Boolean>, Unit> r3, final Function1<? super Function1<? super TextContextMenuBuilderScope, Unit>, Unit> r4) {
        TraversableNodeKt.traverseAncestors(r2, TextContextMenuDataTraverseKey.INSTANCE, new c(r4, r3));
    }

    private static final boolean traverseTextContextMenuDataNodes$lambda$0(Function1 r1, Function1 r2, TraversableNode r3) {
        if ((r3 instanceof AddTextContextMenuDataComponentsNode) == false) goto L6;
        r1.invoke(((AddTextContextMenuDataComponentsNode) r3).getBuilder());
        return continueTraversal;
    L6:
        if ((r3 instanceof FilterTextContextMenuDataComponentsNode) == false) goto L11;
        r2.invoke(((FilterTextContextMenuDataComponentsNode) r3).getFilter());
        return continueTraversal;
    L11:
        throw new IllegalStateException(wrongNodeTypeErrorMessage);
    }
}
