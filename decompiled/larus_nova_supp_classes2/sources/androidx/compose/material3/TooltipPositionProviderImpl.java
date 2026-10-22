package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001cJ%\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b \u0010\u001cJ-\u0010!\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b%\u0010#R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006&"}, d2 = {"Landroidx/compose/material3/TooltipPositionProviderImpl;", "Landroidx/compose/ui/window/PopupPositionProvider;", "type", "Landroidx/compose/material3/TooltipAnchorPosition;", "tooltipAnchorSpacing", "", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getType-lOKsHw4", "()I", "I", "getTooltipAnchorSpacing", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "leftPositioning", "leftPositioning-oFUgxo0", "(Landroidx/compose/ui/unit/IntRect;J)J", "rightPositioning", "rightPositioning-uHY26d4", "(Landroidx/compose/ui/unit/IntRect;JJ)J", "abovePositioning", "abovePositioning-uHY26d4", "belowPositioning", "belowPositioning-uHY26d4", "startPositioning", "startPositioning-_JLpSYE", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/IntRect;JJ)J", "endPositioning", "endPositioning-_JLpSYE", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TooltipPositionProviderImpl implements PopupPositionProvider {
    private final int tooltipAnchorSpacing;
    private final int type;

    public /* synthetic */ TooltipPositionProviderImpl(int r1, int r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public final int getTooltipAnchorSpacing() {
        return this.tooltipAnchorSpacing;
    }

    /* JADX INFO: renamed from: getType-lOKsHw4, reason: not valid java name */
    public final int m3564getTypelOKsHw4() {
        return this.type;
    }

    private TooltipPositionProviderImpl(int r1, int r2) {
        this.type = r1;
        this.tooltipAnchorSpacing = r2;
    }

    /* JADX INFO: renamed from: leftPositioning-oFUgxo0, reason: not valid java name */
    public final long m3565leftPositioningoFUgxo0(IntRect r6, long r7) {
        int r0 = r6.getLeft() - (((int) (r7 >> 32)) + this.tooltipAnchorSpacing);
        if (r0 >= 0) goto L5;
        r0 = r6.getRight() + this.tooltipAnchorSpacing;
    L5:
        int r2 = ((r6.getTop() + r6.getBottom()) - ((int) (r7 & 4294967295L))) / 2;
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r2) & 4294967295L));
    }

    /* JADX INFO: renamed from: abovePositioning-uHY26d4, reason: not valid java name */
    public final long m3560abovePositioninguHY26d4(IntRect r6, long r7, long r9) {
        int r4 = (int) (r7 >> 32);
        int r0 = r6.getLeft() + ((r6.getWidth() - r4) / 2);
        if (r0 >= 0) goto L6;
        r0 = r6.getLeft();
    L8:
        int r10 = (r6.getTop() - ((int) (r7 & 4294967295L))) - this.tooltipAnchorSpacing;
        if (r10 >= 0) goto L12;
        r10 = r6.getBottom() + this.tooltipAnchorSpacing;
    L12:
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r10) & 4294967295L));
    L6:
        if ((r0 + r4) <= ((int) (r9 >> 32))) goto L8;
        r0 = r6.getRight() - r4;
        goto L8
    }

    /* JADX INFO: renamed from: belowPositioning-uHY26d4, reason: not valid java name */
    public final long m3561belowPositioninguHY26d4(IntRect r8, long r9, long r11) {
        int r4 = (int) (r9 >> 32);
        int r0 = r8.getLeft() + ((r8.getWidth() - r4) / 2);
        if (r0 >= 0) goto L6;
        r0 = r8.getLeft();
    L8:
        int r1 = r8.getBottom() + this.tooltipAnchorSpacing;
        int r10 = (int) (r9 & 4294967295L);
        if ((r1 + r10) <= ((int) (r11 & 4294967295L))) goto L12;
        r1 = (r8.getTop() - r10) - this.tooltipAnchorSpacing;
    L12:
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r1) & 4294967295L));
    L6:
        if ((r0 + r4) <= ((int) (r11 >> 32))) goto L8;
        r0 = r8.getRight() - r4;
        goto L8
    }

    /* JADX INFO: renamed from: rightPositioning-uHY26d4, reason: not valid java name */
    public final long m3566rightPositioninguHY26d4(IntRect r5, long r6, long r8) {
        int r0 = r5.getRight() + this.tooltipAnchorSpacing;
        int r3 = (int) (r6 >> 32);
        if ((r0 + r3) <= ((int) (r8 >> 32))) goto L5;
        r0 = r5.getLeft() - (r3 + this.tooltipAnchorSpacing);
    L5:
        int r9 = ((r5.getTop() + r5.getBottom()) - ((int) (r6 & 4294967295L))) / 2;
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r9) & 4294967295L));
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long m3562calculatePositionllwVHH4(IntRect r8, long r9, LayoutDirection r11, long r12) {
        int r0 = this.type;
        TooltipAnchorPosition.Companion r1 = TooltipAnchorPosition.Companion;
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3538getLeftlOKsHw4()) == false) goto L6;
        return m3565leftPositioningoFUgxo0(r8, r12);
    L6:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3539getRightlOKsHw4()) == false) goto L9;
        return m3566rightPositioninguHY26d4(r8, r12, r9);
    L9:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3535getAbovelOKsHw4()) == false) goto L12;
        return m3560abovePositioninguHY26d4(r8, r12, r9);
    L12:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3536getBelowlOKsHw4()) == false) goto L15;
        return m3561belowPositioninguHY26d4(r8, r12, r9);
    L15:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3540getStartlOKsHw4()) == false) goto L18;
        return m3567startPositioning_JLpSYE(r11, r8, r12, r9);
    L18:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r1.m3537getEndlOKsHw4()) == false) goto L21;
        return m3563endPositioning_JLpSYE(r11, r8, r12, r9);
    L21:
        return m3560abovePositioninguHY26d4(r8, r12, r9);
    }

    /* JADX INFO: renamed from: endPositioning-_JLpSYE, reason: not valid java name */
    public final long m3563endPositioning_JLpSYE(LayoutDirection r7, IntRect r8, long r9, long r11) {
        if (r7 != LayoutDirection.Ltr) goto L6;
        return m3566rightPositioninguHY26d4(r8, r9, r11);
    L6:
        return m3565leftPositioningoFUgxo0(r8, r9);
    }

    /* JADX INFO: renamed from: startPositioning-_JLpSYE, reason: not valid java name */
    public final long m3567startPositioning_JLpSYE(LayoutDirection r7, IntRect r8, long r9, long r11) {
        if (r7 != LayoutDirection.Ltr) goto L6;
        return m3565leftPositioningoFUgxo0(r8, r9);
    L6:
        return m3566rightPositioninguHY26d4(r8, r9, r11);
    }
}
