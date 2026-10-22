package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"alignPopupAxis", "", "position", "popupLength", "windowLength", "closeAffinity", "", "popupFitsBetweenPositionAndStartEdge", "popupFitsBetweenPositionAndEndEdge", "alignPopupStartEdgeToPosition", "alignPopupEndEdgeToPosition", "alignStartEdges", "alignEndEdges", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuPopupPositionProviderKt {
    private static final int alignPopupStartEdgeToPosition(int r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return r0;
    L5:
        return r0 - r1;
    }

    private static final int alignStartEdges(int r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return 0;
    L5:
        return r1 - r0;
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int r2, int r3, int r4, boolean r5) {
        if (r5 == false) goto L7;
        if (r3 <= r2) goto L11;
    L9:
        return false;
    L11:
        return true;
    L7:
        if ((r4 - r3) <= r2) goto L9;
        return true;
    }

    private static final int alignEndEdges(int r0, int r1, boolean r2) {
        return alignStartEdges(r0, r1, !r2);
    }

    private static final int alignPopupEndEdgeToPosition(int r0, int r1, boolean r2) {
        return alignPopupStartEdgeToPosition(r0, r1, !r2);
    }

    public static final int alignPopupAxis(int r1, int r2, int r3, boolean r4) {
        if (r2 < r3) goto L5;
        return alignStartEdges(r2, r3, r4);
    L5:
        if (popupFitsBetweenPositionAndEndEdge(r1, r2, r3, r4) == false) goto L8;
        return alignPopupStartEdgeToPosition(r1, r2, r4);
    L8:
        if (popupFitsBetweenPositionAndStartEdge(r1, r2, r3, r4) == false) goto L11;
        return alignPopupEndEdgeToPosition(r1, r2, r4);
    L11:
        return alignEndEdges(r2, r3, r4);
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int r0, int r1, int r2, boolean r3) {
        return popupFitsBetweenPositionAndStartEdge(r0, r1, r2, !r3);
    }

    public static /* synthetic */ int alignPopupAxis$default(int r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = true;
    L6:
        return alignPopupAxis(r0, r1, r2, r3);
    }
}
