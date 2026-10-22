package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long r1, long r3, long r5, long r7, DefaultConstructorMarker r9) {
        this(r1, r3, r5, r7);
    }

    public int hashCode() {
        return (((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.titleContentColor)) * 31) + Color.hashCode-impl(this.actionContentColor);
    }

    /* JADX INFO: renamed from: getActionContentColor-0d7_KjU, reason: not valid java name */
    public final long m3025getActionContentColor0d7_KjU() {
        return this.actionContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3026getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m3027getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m3028getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RichTooltipColors) == true) goto L8;
        return false;
    L8:
        RichTooltipColors r9 = (RichTooltipColors) r8;
        if (Color.equals-impl0(this.containerColor, r9.containerColor) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(this.contentColor, r9.contentColor) == true) goto L15;
        return false;
    L15:
        if (Color.equals-impl0(this.titleContentColor, r9.titleContentColor) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(this.actionContentColor, r9.actionContentColor) == true) goto L20;
        return false;
    L20:
        return true;
    }

    private RichTooltipColors(long r1, long r3, long r5, long r7) {
        this.containerColor = r1;
        this.contentColor = r3;
        this.titleContentColor = r5;
        this.actionContentColor = r7;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RichTooltipColors m3024copyjRlVdoo(long r18, long r20, long r22, long r24) {
        boolean r1 = true;
        if (r18 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r18;
    L10:
        if (r20 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r20;
    L17:
        if (r22 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r22;
    L24:
        if (r24 != 16) goto L27;
        r1 = false;
    L27:
        if (r1 == false) goto L29;
        long r14 = r24;
    L31:
        return new RichTooltipColors(r8, r10, r12, r14, null);
    L29:
        r14 = this.actionContentColor;
        goto L31
    L22:
        r12 = this.titleContentColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.contentColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.containerColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ RichTooltipColors m3023copyjRlVdoo$default(RichTooltipColors r9, long r10, long r12, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.containerColor;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r3 = r9.contentColor;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r5 = r9.titleContentColor;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r7 = r9.actionContentColor;
    L19:
        return r9.m3024copyjRlVdoo(r1, r3, r5, r7);
    L17:
        r7 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
