package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bJI\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getScrolledContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionIconContentColor-0d7_KjU", "getSubtitleContentColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/TopAppBarColors;", "colorTransitionFraction", "", "containerColor-vNxB06k$material3", "(F)J", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TopAppBarColors {
    public static final int $stable = 0;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long subtitleContentColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long r1, long r3, long r5, long r7, long r9, long r11, DefaultConstructorMarker r13) {
        this(r1, r3, r5, r7, r9, r11);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the TopAppBarColors constructor with subtitleContentColor", replaceWith = @ReplaceWith(expression = "TopAppBarColors(containerColor, scrolledContainerColor,navigationIconContentColor, titleContentColor, actionIconContentColor, subtitleContentColor)", imports = {}))
    public /* synthetic */ TopAppBarColors(long r1, long r3, long r5, long r7, long r9, DefaultConstructorMarker r11) {
        this(r1, r3, r5, r7, r9);
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.scrolledContainerColor)) * 31) + Color.hashCode-impl(this.navigationIconContentColor)) * 31) + Color.hashCode-impl(this.titleContentColor)) * 31) + Color.hashCode-impl(this.actionIconContentColor)) * 31) + Color.hashCode-impl(this.subtitleContentColor);
    }

    /* JADX INFO: renamed from: getActionIconContentColor-0d7_KjU, reason: not valid java name */
    public final long m3571getActionIconContentColor0d7_KjU() {
        return this.actionIconContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3572getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getNavigationIconContentColor-0d7_KjU, reason: not valid java name */
    public final long m3573getNavigationIconContentColor0d7_KjU() {
        return this.navigationIconContentColor;
    }

    /* JADX INFO: renamed from: getScrolledContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3574getScrolledContainerColor0d7_KjU() {
        return this.scrolledContainerColor;
    }

    /* JADX INFO: renamed from: getSubtitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m3575getSubtitleContentColor0d7_KjU() {
        return this.subtitleContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m3576getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: containerColor-vNxB06k$material3, reason: not valid java name */
    public final long m3569containerColorvNxB06k$material3(float r6) {
        return ColorKt.lerp-jxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(r6));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L29:
        return false;
    L8:
        if ((r7 instanceof TopAppBarColors) == false) goto L29;
        TopAppBarColors r8 = (TopAppBarColors) r7;
        if (Color.equals-impl0(this.containerColor, r8.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.scrolledContainerColor, r8.scrolledContainerColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.navigationIconContentColor, r8.navigationIconContentColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.titleContentColor, r8.titleContentColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.actionIconContentColor, r8.actionIconContentColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.subtitleContentColor, r8.subtitleContentColor) == true) goto L28;
        return false;
    L28:
        return true;
    }

    private TopAppBarColors(long r15, long r17, long r19, long r21, long r23) {
        this(r15, r17, r19, r21, r23, r21, null);
    }

    private TopAppBarColors(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.containerColor = r1;
        this.scrolledContainerColor = r3;
        this.navigationIconContentColor = r5;
        this.titleContentColor = r7;
        this.actionIconContentColor = r9;
        this.subtitleContentColor = r11;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final TopAppBarColors m3570copytNS2XkQ(long r22, long r24, long r26, long r28, long r30, long r32) {
        boolean r1 = true;
        if (r22 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r22;
    L10:
        if (r24 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r24;
    L17:
        if (r26 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r26;
    L24:
        if (r28 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r28;
    L31:
        if (r30 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r30;
    L38:
        if (r32 != 16) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L43;
        long r18 = r32;
    L45:
        return new TopAppBarColors(r8, r10, r12, r14, r16, r18, null);
    L43:
        r18 = this.subtitleContentColor;
        goto L45
    L36:
        r16 = this.actionIconContentColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.titleContentColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.navigationIconContentColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.scrolledContainerColor;
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

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ TopAppBarColors m3568copytNS2XkQ$default(TopAppBarColors r13, long r14, long r16, long r18, long r20, long r22, long r24, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r1 = r13.containerColor;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r3 = r13.scrolledContainerColor;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r5 = r13.navigationIconContentColor;
    L15:
        if ((r26 & 8) == 0) goto L17;
        long r7 = r13.titleContentColor;
    L19:
        if ((r26 & 16) == 0) goto L21;
        long r9 = r13.actionIconContentColor;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r11 = r13.subtitleContentColor;
    L27:
        return r13.m3570copytNS2XkQ(r1, r3, r5, r7, r9, r11);
    L25:
        r11 = r24;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
