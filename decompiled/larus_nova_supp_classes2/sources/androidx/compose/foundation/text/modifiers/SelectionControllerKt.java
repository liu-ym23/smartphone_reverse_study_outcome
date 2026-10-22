package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¨\u0006\b"}, d2 = {"makeSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionControllerKt {
    public static final /* synthetic */ Modifier access$makeSelectionModifier(SelectionRegistrar r0, long r1, Function0 r3) {
        return makeSelectionModifier(r0, r1, r3);
    }

    private static final Modifier makeSelectionModifier(final SelectionRegistrar r2, final long r3, final Function0<? extends LayoutCoordinates> r5) {
        TextDragObserver r0 = new SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1(r5, r2, r3);
        MouseSelectionObserver r1 = new SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1(r5, r2, r3);
        return SelectionGesturesKt.selectionGestureInput(Modifier.Companion, r1, r0);
    }
}
