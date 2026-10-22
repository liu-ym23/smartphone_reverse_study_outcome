package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020$H\u0001¢\u0006\u0004\b*\u0010'J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b,\u0010'J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u000200H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Landroidx/compose/material3/SegmentedButtonColors;", "", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveContainerColor-0d7_KjU", "()J", "J", "getActiveContentColor-0d7_KjU", "getActiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "borderColor", "enabled", "", "active", "borderColor-WaAFU9c$material3", "(ZZ)J", "contentColor", "checked", "contentColor-WaAFU9c$material3", "containerColor", "containerColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonColors {
    public static final int $stable = 0;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;

    public /* synthetic */ SegmentedButtonColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, DefaultConstructorMarker r25) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.hashCode-impl(this.activeBorderColor) * 31) + Color.hashCode-impl(this.activeContentColor)) * 31) + Color.hashCode-impl(this.activeContainerColor)) * 31) + Color.hashCode-impl(this.inactiveBorderColor)) * 31) + Color.hashCode-impl(this.inactiveContentColor)) * 31) + Color.hashCode-impl(this.inactiveContainerColor)) * 31) + Color.hashCode-impl(this.disabledActiveBorderColor)) * 31) + Color.hashCode-impl(this.disabledActiveContentColor)) * 31) + Color.hashCode-impl(this.disabledActiveContainerColor)) * 31) + Color.hashCode-impl(this.disabledInactiveBorderColor)) * 31) + Color.hashCode-impl(this.disabledInactiveContentColor)) * 31) + Color.hashCode-impl(this.disabledInactiveContainerColor);
    }

    /* JADX INFO: renamed from: getActiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3080getActiveBorderColor0d7_KjU() {
        return this.activeBorderColor;
    }

    /* JADX INFO: renamed from: getActiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3081getActiveContainerColor0d7_KjU() {
        return this.activeContainerColor;
    }

    /* JADX INFO: renamed from: getActiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m3082getActiveContentColor0d7_KjU() {
        return this.activeContentColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3083getDisabledActiveBorderColor0d7_KjU() {
        return this.disabledActiveBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3084getDisabledActiveContainerColor0d7_KjU() {
        return this.disabledActiveContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m3085getDisabledActiveContentColor0d7_KjU() {
        return this.disabledActiveContentColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3086getDisabledInactiveBorderColor0d7_KjU() {
        return this.disabledInactiveBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3087getDisabledInactiveContainerColor0d7_KjU() {
        return this.disabledInactiveContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m3088getDisabledInactiveContentColor0d7_KjU() {
        return this.disabledInactiveContentColor;
    }

    /* JADX INFO: renamed from: getInactiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3089getInactiveBorderColor0d7_KjU() {
        return this.inactiveBorderColor;
    }

    /* JADX INFO: renamed from: getInactiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3090getInactiveContainerColor0d7_KjU() {
        return this.inactiveContainerColor;
    }

    /* JADX INFO: renamed from: getInactiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m3091getInactiveContentColor0d7_KjU() {
        return this.inactiveContentColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (SegmentedButtonColors.class == r7.getClass()) goto L11;
        return false;
    L11:
        SegmentedButtonColors r8 = (SegmentedButtonColors) r7;
        if (Color.equals-impl0(this.activeBorderColor, r8.activeBorderColor) == true) goto L15;
        return false;
    L15:
        if (Color.equals-impl0(this.activeContentColor, r8.activeContentColor) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(this.activeContainerColor, r8.activeContainerColor) == true) goto L21;
        return false;
    L21:
        if (Color.equals-impl0(this.inactiveBorderColor, r8.inactiveBorderColor) == true) goto L24;
        return false;
    L24:
        if (Color.equals-impl0(this.inactiveContentColor, r8.inactiveContentColor) == true) goto L27;
        return false;
    L27:
        if (Color.equals-impl0(this.inactiveContainerColor, r8.inactiveContainerColor) == true) goto L30;
        return false;
    L30:
        if (Color.equals-impl0(this.disabledActiveBorderColor, r8.disabledActiveBorderColor) == true) goto L33;
        return false;
    L33:
        if (Color.equals-impl0(this.disabledActiveContentColor, r8.disabledActiveContentColor) == true) goto L36;
        return false;
    L36:
        if (Color.equals-impl0(this.disabledActiveContainerColor, r8.disabledActiveContainerColor) == true) goto L39;
        return false;
    L39:
        if (Color.equals-impl0(this.disabledInactiveBorderColor, r8.disabledInactiveBorderColor) == true) goto L42;
        return false;
    L42:
        if (Color.equals-impl0(this.disabledInactiveContentColor, r8.disabledInactiveContentColor) == true) goto L45;
        return false;
    L45:
        if (Color.equals-impl0(this.disabledInactiveContainerColor, r8.disabledInactiveContainerColor) == true) goto L47;
        return false;
    L47:
        return true;
    }

    /* JADX INFO: renamed from: borderColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3076borderColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return this.activeBorderColor;
    L5:
        if (r1 == false) goto L8;
        if (r2 == true) goto L8;
        return this.inactiveBorderColor;
    L8:
        if (r1 == true) goto L12;
        if (r2 == false) goto L12;
        return this.disabledActiveBorderColor;
    L12:
        return this.disabledInactiveBorderColor;
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3077containerColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return this.activeContainerColor;
    L5:
        if (r1 == false) goto L8;
        if (r2 == true) goto L8;
        return this.inactiveContainerColor;
    L8:
        if (r1 == true) goto L12;
        if (r2 == false) goto L12;
        return this.disabledActiveContainerColor;
    L12:
        return this.disabledInactiveContainerColor;
    }

    /* JADX INFO: renamed from: contentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3078contentColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return this.activeContentColor;
    L5:
        if (r1 == false) goto L8;
        if (r2 == true) goto L8;
        return this.inactiveContentColor;
    L8:
        if (r1 == true) goto L12;
        if (r2 == false) goto L12;
        return this.disabledActiveContentColor;
    L12:
        return this.disabledInactiveContentColor;
    }

    private SegmentedButtonColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26) {
        this.activeContainerColor = r4;
        this.activeContentColor = r6;
        this.activeBorderColor = r8;
        this.inactiveContainerColor = r10;
        this.inactiveContentColor = r12;
        this.inactiveBorderColor = r14;
        this.disabledActiveContainerColor = r16;
        this.disabledActiveContentColor = r18;
        this.disabledActiveBorderColor = r20;
        this.disabledInactiveContainerColor = r22;
        this.disabledInactiveContentColor = r24;
        this.disabledInactiveBorderColor = r26;
    }

    /* JADX INFO: renamed from: copy-2qZNXz8, reason: not valid java name */
    public final SegmentedButtonColors m3079copy2qZNXz8(long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56) {
        boolean r1 = true;
        if (r34 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r34;
    L10:
        if (r36 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r36;
    L17:
        if (r38 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r38;
    L24:
        if (r40 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r40;
    L31:
        if (r42 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r42;
    L38:
        if (r44 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r44;
    L45:
        if (r46 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r46;
    L52:
        if (r48 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r48;
    L59:
        if (r50 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r50;
    L66:
        if (r52 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r52;
    L73:
        if (r54 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r28 = r54;
    L80:
        if (r56 != 16) goto L83;
        r1 = false;
    L83:
        if (r1 == false) goto L85;
        long r30 = r56;
    L87:
        return new SegmentedButtonColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, null);
    L85:
        r30 = this.disabledInactiveBorderColor;
        goto L87
    L78:
        r28 = this.disabledInactiveContentColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.disabledInactiveContainerColor;
        goto L73
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.disabledActiveBorderColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.disabledActiveContentColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.disabledActiveContainerColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.inactiveBorderColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.inactiveContentColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.inactiveContainerColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.activeBorderColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.activeContentColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.activeContainerColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ SegmentedButtonColors m3075copy2qZNXz8$default(SegmentedButtonColors r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        long r2 = r16.activeContainerColor;
    L7:
        if ((r41 & 2) == 0) goto L9;
        long r4 = r16.activeContentColor;
    L11:
        if ((r41 & 4) == 0) goto L13;
        long r6 = r16.activeBorderColor;
    L15:
        if ((r41 & 8) == 0) goto L17;
        long r8 = r16.inactiveContainerColor;
    L19:
        if ((r41 & 16) == 0) goto L21;
        long r10 = r16.inactiveContentColor;
    L23:
        if ((r41 & 32) == 0) goto L25;
        long r12 = r16.inactiveBorderColor;
    L27:
        if ((r41 & 64) == 0) goto L29;
        long r14 = r16.disabledActiveContainerColor;
    L30:
        long r210 = r14;
        if ((r41 & 128) == 0) goto L33;
        long r15 = r16.disabledActiveContentColor;
    L34:
        long r32 = r15;
        if ((r41 & 256) == 0) goto L37;
        long r18 = r16.disabledActiveBorderColor;
    L38:
        long r34 = r18;
        if ((r41 & 512) == 0) goto L41;
        long r110 = r16.disabledInactiveContainerColor;
    L42:
        long r36 = r110;
        if ((r41 & 1024) == 0) goto L45;
        long r111 = r16.disabledInactiveContentColor;
    L46:
        long r38 = r111;
        if ((r41 & 2048) == 0) goto L49;
        long r112 = r16.disabledInactiveBorderColor;
    L51:
        return r16.m3079copy2qZNXz8(r2, r4, r6, r8, r10, r12, r210, r32, r34, r36, r38, r112);
    L49:
        r112 = r39;
        goto L51
    L45:
        r111 = r37;
        goto L46
    L41:
        r110 = r35;
        goto L42
    L37:
        r18 = r33;
        goto L38
    L33:
        r15 = r31;
        goto L34
    L29:
        r14 = r29;
        goto L30
    L25:
        r12 = r27;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
