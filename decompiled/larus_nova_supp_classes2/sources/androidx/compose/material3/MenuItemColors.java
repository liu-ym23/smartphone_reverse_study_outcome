package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "getLeadingIconColor-0d7_KjU", "getTrailingIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/MenuItemColors;", "enabled", "", "textColor-vNxB06k$material3", "(Z)J", "leadingIconColor-vNxB06k$material3", "trailingIconColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long r1, long r3, long r5, long r7, long r9, long r11, DefaultConstructorMarker r13) {
        this(r1, r3, r5, r7, r9, r11);
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.textColor) * 31) + Color.hashCode-impl(this.leadingIconColor)) * 31) + Color.hashCode-impl(this.trailingIconColor)) * 31) + Color.hashCode-impl(this.disabledTextColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconColor)) * 31) + Color.hashCode-impl(this.disabledTrailingIconColor);
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2856getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m2857getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2858getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* JADX INFO: renamed from: getLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2859getLeadingIconColor0d7_KjU() {
        return this.leadingIconColor;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m2860getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2861getTrailingIconColor0d7_KjU() {
        return this.trailingIconColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L29:
        return false;
    L8:
        if ((r7 instanceof MenuItemColors) == false) goto L29;
        MenuItemColors r8 = (MenuItemColors) r7;
        if (Color.equals-impl0(this.textColor, r8.textColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.leadingIconColor, r8.leadingIconColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.trailingIconColor, r8.trailingIconColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.disabledTextColor, r8.disabledTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledLeadingIconColor, r8.disabledLeadingIconColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledTrailingIconColor, r8.disabledTrailingIconColor) == true) goto L28;
        return false;
    L28:
        return true;
    }

    /* JADX INFO: renamed from: leadingIconColor-vNxB06k$material3, reason: not valid java name */
    public final long m2862leadingIconColorvNxB06k$material3(boolean r3) {
        if (r3 == false) goto L5;
        return this.leadingIconColor;
    L5:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: textColor-vNxB06k$material3, reason: not valid java name */
    public final long m2863textColorvNxB06k$material3(boolean r3) {
        if (r3 == false) goto L5;
        return this.textColor;
    L5:
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: trailingIconColor-vNxB06k$material3, reason: not valid java name */
    public final long m2864trailingIconColorvNxB06k$material3(boolean r3) {
        if (r3 == false) goto L5;
        return this.trailingIconColor;
    L5:
        return this.disabledTrailingIconColor;
    }

    private MenuItemColors(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.textColor = r1;
        this.leadingIconColor = r3;
        this.trailingIconColor = r5;
        this.disabledTextColor = r7;
        this.disabledLeadingIconColor = r9;
        this.disabledTrailingIconColor = r11;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final MenuItemColors m2855copytNS2XkQ(long r22, long r24, long r26, long r28, long r30, long r32) {
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
        return new MenuItemColors(r8, r10, r12, r14, r16, r18, null);
    L43:
        r18 = this.disabledTrailingIconColor;
        goto L45
    L36:
        r16 = this.disabledLeadingIconColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.disabledTextColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.trailingIconColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.leadingIconColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.textColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ MenuItemColors m2854copytNS2XkQ$default(MenuItemColors r13, long r14, long r16, long r18, long r20, long r22, long r24, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r1 = r13.textColor;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r3 = r13.leadingIconColor;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r5 = r13.trailingIconColor;
    L15:
        if ((r26 & 8) == 0) goto L17;
        long r7 = r13.disabledTextColor;
    L19:
        if ((r26 & 16) == 0) goto L21;
        long r9 = r13.disabledLeadingIconColor;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r11 = r13.disabledTrailingIconColor;
    L27:
        return r13.m2855copytNS2XkQ(r1, r3, r5, r7, r9, r11);
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
