package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\f\u0010\b\u001a\u00020\u0005*\u00020\u0005H\u0017¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/layout/BoxScopeInstance;", "Landroidx/compose/foundation/layout/BoxScope;", "<init>", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoxScopeInstance implements BoxScope {
    public static final int $stable = 0;
    public static final BoxScopeInstance INSTANCE = null;

    static {
        INSTANCE = new BoxScopeInstance();
    }

    private BoxScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier matchParentSize(Modifier r5) {
        Alignment r1 = Alignment.Companion.getCenter();
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r2 = new BoxScopeInstance$matchParentSize$$inlined$debugInspectorInfo$1();
    L7:
        return r5.then(new BoxChildDataElement(r1, true, r2));
    L5:
        r2 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier align(Modifier r4, final Alignment r5) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new BoxScopeInstance$align$$inlined$debugInspectorInfo$1(r5);
    L7:
        return r4.then(new BoxChildDataElement(r5, false, r1));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }
}
