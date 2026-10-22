package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\f\u0010\u0014\u001a\u00020\b*\u00020\u0015H\u0016J\f\u0010\u0016\u001a\u00020\b*\u00020\u0017H\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "<init>", "()V", "update", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TextFieldMagnifierNode extends DelegatingNode implements OnGloballyPositionedModifier, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 0;

    public final /* synthetic */ boolean all(Function1 r1) {
        return Modifier.Element.-CC.$default$all(this, r1);
    }

    public final /* synthetic */ boolean any(Function1 r1) {
        return Modifier.Element.-CC.$default$any(this, r1);
    }

    public void applySemantics(SemanticsPropertyReceiver r1) {
    }

    public void draw(ContentDrawScope r1) {
    }

    public final /* synthetic */ Object foldIn(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldIn(this, r1, r2);
    }

    public final /* synthetic */ Object foldOut(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldOut(this, r1, r2);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public void onGloballyPositioned(LayoutCoordinates r1) {
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public final /* synthetic */ Modifier then(Modifier r1) {
        return Modifier.-CC.$default$then(this, r1);
    }

    public abstract void update(TransformedTextFieldState r1, TextFieldSelectionState r2, TextLayoutState r3, boolean r4);

    public TextFieldMagnifierNode() {
    }
}
