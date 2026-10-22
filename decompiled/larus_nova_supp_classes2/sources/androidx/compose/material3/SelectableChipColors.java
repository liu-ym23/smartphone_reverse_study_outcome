package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u008f\u0001\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001d\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0013\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "<init>", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "copy", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/compose/material3/SelectableChipColors;", "enabled", "", "selected", "containerColor-WaAFU9c$material3", "(ZZ)J", "labelColor-WaAFU9c$material3", "leadingIconContentColor", "leadingIconContentColor-WaAFU9c$material3", "trailingIconContentColor", "trailingIconContentColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectableChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, DefaultConstructorMarker r27) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.labelColor)) * 31) + Color.hashCode-impl(this.leadingIconColor)) * 31) + Color.hashCode-impl(this.trailingIconColor)) * 31) + Color.hashCode-impl(this.disabledContainerColor)) * 31) + Color.hashCode-impl(this.disabledLabelColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconColor)) * 31) + Color.hashCode-impl(this.disabledTrailingIconColor)) * 31) + Color.hashCode-impl(this.selectedContainerColor)) * 31) + Color.hashCode-impl(this.disabledSelectedContainerColor)) * 31) + Color.hashCode-impl(this.selectedLabelColor)) * 31) + Color.hashCode-impl(this.selectedLeadingIconColor)) * 31) + Color.hashCode-impl(this.selectedTrailingIconColor);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L50:
        return false;
    L8:
        if ((r7 instanceof SelectableChipColors) == false) goto L50;
        SelectableChipColors r8 = (SelectableChipColors) r7;
        if (Color.equals-impl0(this.containerColor, r8.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.labelColor, r8.labelColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.leadingIconColor, r8.leadingIconColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.trailingIconColor, r8.trailingIconColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.disabledContainerColor, r8.disabledContainerColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledLabelColor, r8.disabledLabelColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledLeadingIconColor, r8.disabledLeadingIconColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.disabledTrailingIconColor, r8.disabledTrailingIconColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.selectedContainerColor, r8.selectedContainerColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledSelectedContainerColor, r8.disabledSelectedContainerColor) == true) goto L41;
        return false;
    L41:
        if (Color.equals-impl0(this.selectedLabelColor, r8.selectedLabelColor) == true) goto L44;
        return false;
    L44:
        if (Color.equals-impl0(this.selectedLeadingIconColor, r8.selectedLeadingIconColor) == true) goto L47;
        return false;
    L47:
        if (Color.equals-impl0(this.selectedTrailingIconColor, r8.selectedTrailingIconColor) == true) goto L49;
        return false;
    L49:
        return true;
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3101containerColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == true) goto L6;
        if (r2 == false) goto L11;
        return this.disabledSelectedContainerColor;
    L11:
        return this.disabledContainerColor;
    L6:
        if (r2 == true) goto L9;
        return this.containerColor;
    L9:
        return this.selectedContainerColor;
    }

    /* JADX INFO: renamed from: labelColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3103labelColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L8;
        if (r2 == true) goto L7;
        return this.labelColor;
    L7:
        return this.selectedLabelColor;
    L8:
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: leadingIconContentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3104leadingIconContentColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L8;
        if (r2 == true) goto L7;
        return this.leadingIconColor;
    L7:
        return this.selectedLeadingIconColor;
    L8:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: trailingIconContentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3105trailingIconContentColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L8;
        if (r2 == true) goto L7;
        return this.trailingIconColor;
    L7:
        return this.selectedTrailingIconColor;
    L8:
        return this.disabledTrailingIconColor;
    }

    private SelectableChipColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28) {
        this.containerColor = r4;
        this.labelColor = r6;
        this.leadingIconColor = r8;
        this.trailingIconColor = r10;
        this.disabledContainerColor = r12;
        this.disabledLabelColor = r14;
        this.disabledLeadingIconColor = r16;
        this.disabledTrailingIconColor = r18;
        this.selectedContainerColor = r20;
        this.disabledSelectedContainerColor = r22;
        this.selectedLabelColor = r24;
        this.selectedLeadingIconColor = r26;
        this.selectedTrailingIconColor = r28;
    }

    /* JADX INFO: renamed from: copy-daRQuJA, reason: not valid java name */
    public final SelectableChipColors m3102copydaRQuJA(long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60) {
        boolean r1 = true;
        if (r36 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r36;
    L10:
        if (r38 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r38;
    L17:
        if (r40 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r40;
    L24:
        if (r42 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r42;
    L31:
        if (r44 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r44;
    L38:
        if (r46 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r46;
    L45:
        if (r48 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r48;
    L52:
        if (r50 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r50;
    L59:
        if (r52 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r52;
    L66:
        if (r54 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r54;
    L73:
        if (r56 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r28 = r56;
    L80:
        if (r58 == 16) goto L82;
        boolean r25 = true;
    L83:
        if (r25 == false) goto L85;
        long r30 = r58;
    L87:
        if (r60 != 16) goto L90;
        r1 = false;
    L90:
        if (r1 == false) goto L92;
        long r32 = r60;
    L94:
        return new SelectableChipColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, null);
    L92:
        r32 = this.selectedTrailingIconColor;
        goto L94
    L85:
        r30 = this.selectedLeadingIconColor;
        goto L87
    L82:
        r25 = false;
        goto L83
    L78:
        r28 = this.selectedLabelColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.disabledSelectedContainerColor;
        goto L73
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.selectedContainerColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.disabledTrailingIconColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.disabledLeadingIconColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.disabledLabelColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.disabledContainerColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.trailingIconColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.leadingIconColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.labelColor;
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

    /* JADX INFO: renamed from: copy-daRQuJA$default, reason: not valid java name */
    public static /* synthetic */ SelectableChipColors m3100copydaRQuJA$default(SelectableChipColors r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        long r2 = r16.containerColor;
    L7:
        if ((r43 & 2) == 0) goto L9;
        long r4 = r16.labelColor;
    L11:
        if ((r43 & 4) == 0) goto L13;
        long r6 = r16.leadingIconColor;
    L15:
        if ((r43 & 8) == 0) goto L17;
        long r8 = r16.trailingIconColor;
    L19:
        if ((r43 & 16) == 0) goto L21;
        long r10 = r16.disabledContainerColor;
    L23:
        if ((r43 & 32) == 0) goto L25;
        long r12 = r16.disabledLabelColor;
    L27:
        if ((r43 & 64) == 0) goto L29;
        long r14 = r16.disabledLeadingIconColor;
    L30:
        long r210 = r14;
        if ((r43 & 128) == 0) goto L33;
        long r15 = r16.disabledTrailingIconColor;
    L34:
        long r32 = r15;
        if ((r43 & 256) == 0) goto L37;
        long r18 = r16.selectedContainerColor;
    L38:
        long r34 = r18;
        if ((r43 & 512) == 0) goto L41;
        long r110 = r16.disabledSelectedContainerColor;
    L42:
        long r36 = r110;
        if ((r43 & 1024) == 0) goto L45;
        long r111 = r16.selectedLabelColor;
    L46:
        long r38 = r111;
        if ((r43 & 2048) == 0) goto L49;
        long r112 = r16.selectedLeadingIconColor;
    L50:
        long r310 = r112;
        if ((r43 & 4096) == 0) goto L53;
        long r113 = r16.selectedTrailingIconColor;
    L55:
        return r16.m3102copydaRQuJA(r2, r4, r6, r8, r10, r12, r210, r32, r34, r36, r38, r310, r113);
    L53:
        r113 = r41;
        goto L55
    L49:
        r112 = r39;
        goto L50
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
