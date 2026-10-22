package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/MaintainWindowPositionPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "<init>", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "getPopupPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "previousWindowSize", "Landroidx/compose/ui/unit/IntSize;", "getPreviousWindowSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPreviousWindowSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "previousLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getPreviousLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setPreviousLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "previousPopupContentSize", "getPreviousPopupContentSize-bOM6tXw", "setPreviousPopupContentSize-fhxjrPA", "previousPosition", "Landroidx/compose/ui/unit/IntOffset;", "getPreviousPosition-JyOPPKE", "()Landroidx/compose/ui/unit/IntOffset;", "setPreviousPosition-fg0MpWk", "(Landroidx/compose/ui/unit/IntOffset;)V", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "layoutDirection", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaintainWindowPositionPopupPositionProvider implements PopupPositionProvider {
    private final PopupPositionProvider popupPositionProvider;
    private LayoutDirection previousLayoutDirection;
    private IntSize previousPopupContentSize;
    private IntOffset previousPosition;
    private IntSize previousWindowSize;

    public final PopupPositionProvider getPopupPositionProvider() {
        return this.popupPositionProvider;
    }

    public final LayoutDirection getPreviousLayoutDirection() {
        return this.previousLayoutDirection;
    }

    /* JADX INFO: renamed from: getPreviousPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m1498getPreviousPopupContentSizebOM6tXw() {
        return this.previousPopupContentSize;
    }

    /* JADX INFO: renamed from: getPreviousPosition-JyOPPKE, reason: not valid java name */
    public final IntOffset m1499getPreviousPositionJyOPPKE() {
        return this.previousPosition;
    }

    /* JADX INFO: renamed from: getPreviousWindowSize-bOM6tXw, reason: not valid java name */
    public final IntSize m1500getPreviousWindowSizebOM6tXw() {
        return this.previousWindowSize;
    }

    public MaintainWindowPositionPopupPositionProvider(PopupPositionProvider r1) {
        this.popupPositionProvider = r1;
    }

    public final void setPreviousLayoutDirection(LayoutDirection r1) {
        this.previousLayoutDirection = r1;
    }

    /* JADX INFO: renamed from: setPreviousPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m1501setPreviousPopupContentSizefhxjrPA(IntSize r1) {
        this.previousPopupContentSize = r1;
    }

    /* JADX INFO: renamed from: setPreviousPosition-fg0MpWk, reason: not valid java name */
    public final void m1502setPreviousPositionfg0MpWk(IntOffset r1) {
        this.previousPosition = r1;
    }

    /* JADX INFO: renamed from: setPreviousWindowSize-fhxjrPA, reason: not valid java name */
    public final void m1503setPreviousWindowSizefhxjrPA(IntSize r1) {
        this.previousWindowSize = r1;
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long m1497calculatePositionllwVHH4(IntRect r8, long r9, LayoutDirection r11, long r12) {
        IntOffset r0 = this.previousPosition;
        if (r0 == null) goto L18;
        IntSize r1 = this.previousWindowSize;
        boolean r2 = false;
        if (r1 != null) goto L7;
        boolean r3 = false;
    L8:
        if (r3 == false) goto L18;
        if (this.previousLayoutDirection != r11) goto L18;
        IntSize r4 = this.previousPopupContentSize;
        if (r4 == null) goto L15;
        r2 = IntSize.equals-impl0(r4.unbox-impl(), r12);
    L15:
        if (r2 == false) goto L18;
        return r0.unbox-impl();
    L7:
        r3 = IntSize.equals-impl0(r1.unbox-impl(), r9);
    L18:
        long r5 = this.popupPositionProvider.calculatePosition-llwVHH4(r8, r9, r11, r12);
        this.previousWindowSize = IntSize.box-impl(r9);
        this.previousLayoutDirection = r11;
        this.previousPopupContentSize = IntSize.box-impl(r12);
        this.previousPosition = IntOffset.box-impl(r5);
        return r5;
    }
}
