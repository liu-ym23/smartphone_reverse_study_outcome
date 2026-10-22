package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u0013\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006&"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "<init>", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedIconColor-0d7_KjU", "()J", "J", "getSelectedTextColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationBarItemColors;", "iconColor", "selected", "", "enabled", "iconColor-WaAFU9c$material3", "(ZZ)J", "textColor", "textColor-WaAFU9c$material3", "indicatorColor", "getIndicatorColor-0d7_KjU$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, DefaultConstructorMarker r15) {
        this(r1, r3, r5, r7, r9, r11, r13);
    }

    public int hashCode() {
        return (((((((((((Color.hashCode-impl(this.selectedIconColor) * 31) + Color.hashCode-impl(this.unselectedIconColor)) * 31) + Color.hashCode-impl(this.selectedTextColor)) * 31) + Color.hashCode-impl(this.unselectedTextColor)) * 31) + Color.hashCode-impl(this.selectedIndicatorColor)) * 31) + Color.hashCode-impl(this.disabledIconColor)) * 31) + Color.hashCode-impl(this.disabledTextColor);
    }

    /* JADX INFO: renamed from: getDisabledIconColor-0d7_KjU, reason: not valid java name */
    public final long m2881getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m2882getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getIndicatorColor-0d7_KjU$material3, reason: not valid java name */
    public final long m2883getIndicatorColor0d7_KjU$material3() {
        return this.selectedIndicatorColor;
    }

    /* JADX INFO: renamed from: getSelectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2884getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2885getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* JADX INFO: renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2886getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* JADX INFO: renamed from: getUnselectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2887getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* JADX INFO: renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2888getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L32:
        return false;
    L8:
        if ((r7 instanceof NavigationBarItemColors) == false) goto L32;
        NavigationBarItemColors r8 = (NavigationBarItemColors) r7;
        if (Color.equals-impl0(this.selectedIconColor, r8.selectedIconColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.unselectedIconColor, r8.unselectedIconColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.selectedTextColor, r8.selectedTextColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.unselectedTextColor, r8.unselectedTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.selectedIndicatorColor, r8.selectedIndicatorColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledIconColor, r8.disabledIconColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledTextColor, r8.disabledTextColor) == true) goto L31;
        return false;
    L31:
        return true;
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2889iconColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (r1 == false) goto L7;
        return this.selectedIconColor;
    L7:
        return this.unselectedIconColor;
    L8:
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: textColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2890textColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (r1 == false) goto L7;
        return this.selectedTextColor;
    L7:
        return this.unselectedTextColor;
    L8:
        return this.disabledTextColor;
    }

    private NavigationBarItemColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13) {
        this.selectedIconColor = r1;
        this.selectedTextColor = r3;
        this.selectedIndicatorColor = r5;
        this.unselectedIconColor = r7;
        this.unselectedTextColor = r9;
        this.disabledIconColor = r11;
        this.disabledTextColor = r13;
    }

    /* JADX INFO: renamed from: copy-4JmcsL4, reason: not valid java name */
    public final NavigationBarItemColors m2880copy4JmcsL4(long r24, long r26, long r28, long r30, long r32, long r34, long r36) {
        boolean r1 = true;
        if (r24 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r24;
    L10:
        if (r26 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r26;
    L17:
        if (r28 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r28;
    L24:
        if (r30 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r30;
    L31:
        if (r32 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r32;
    L38:
        if (r34 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r34;
    L45:
        if (r36 != 16) goto L48;
        r1 = false;
    L48:
        if (r1 == false) goto L50;
        long r20 = r36;
    L52:
        return new NavigationBarItemColors(r8, r10, r12, r14, r16, r18, r20, null);
    L50:
        r20 = this.disabledTextColor;
        goto L52
    L43:
        r18 = this.disabledIconColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.unselectedTextColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.unselectedIconColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.selectedIndicatorColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.selectedTextColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.selectedIconColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-4JmcsL4$default, reason: not valid java name */
    public static /* synthetic */ NavigationBarItemColors m2879copy4JmcsL4$default(NavigationBarItemColors r15, long r16, long r18, long r20, long r22, long r24, long r26, long r28, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        long r1 = r15.selectedIconColor;
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r3 = r15.selectedTextColor;
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r5 = r15.selectedIndicatorColor;
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r7 = r15.unselectedIconColor;
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r9 = r15.unselectedTextColor;
    L23:
        if ((r30 & 32) == 0) goto L25;
        long r11 = r15.disabledIconColor;
    L27:
        if ((r30 & 64) == 0) goto L29;
        long r13 = r15.disabledTextColor;
    L31:
        return r15.m2880copy4JmcsL4(r1, r3, r5, r7, r9, r11, r13);
    L29:
        r13 = r28;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
