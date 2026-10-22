package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¨\u0006\b"}, d2 = {"contextMenuGestures", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onOpenGesture", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuGestures_androidKt {
    public static /* synthetic */ Unit a(ContextMenuState r0, Offset r1) {
        return contextMenuGestures$lambda$0(r0, r1);
    }

    public static final Modifier contextMenuGestures(Modifier r2, final Function1<? super Offset, Unit> r3) {
        return SuspendingPointerInputFilterKt.pointerInput(r2, ContextMenuKey.INSTANCE, new AnonymousClass2(r3));
    }

    private static final Unit contextMenuGestures$lambda$0(ContextMenuState r3, Offset r4) {
        r3.setStatus(new ContextMenuState.Status.Open(r4.unbox-impl(), null));
        return Unit.INSTANCE;
    }

    public static final Modifier contextMenuGestures(Modifier r1, final ContextMenuState r2) {
        return contextMenuGestures(r1, new f(r2));
    }
}
