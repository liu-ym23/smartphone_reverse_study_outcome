package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJq\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0001¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0001¢\u0006\u0004\b'\u0010%J\u0013\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "<init>", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getThumbColor-0d7_KjU", "()J", "J", "getActiveTrackColor-0d7_KjU", "getActiveTickColor-0d7_KjU", "getInactiveTrackColor-0d7_KjU", "getInactiveTickColor-0d7_KjU", "getDisabledThumbColor-0d7_KjU", "getDisabledActiveTrackColor-0d7_KjU", "getDisabledActiveTickColor-0d7_KjU", "getDisabledInactiveTrackColor-0d7_KjU", "getDisabledInactiveTickColor-0d7_KjU", "copy", "copy--K518z4", "(JJJJJJJJJJ)Landroidx/compose/material3/SliderColors;", "enabled", "", "thumbColor-vNxB06k$material3", "(Z)J", "trackColor", "active", "trackColor-WaAFU9c$material3", "(ZZ)J", "tickColor", "tickColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderColors {
    public static final int $stable = 0;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, DefaultConstructorMarker r21) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19);
    }

    public int hashCode() {
        return (((((((((((((((((Color.hashCode-impl(this.thumbColor) * 31) + Color.hashCode-impl(this.activeTrackColor)) * 31) + Color.hashCode-impl(this.activeTickColor)) * 31) + Color.hashCode-impl(this.inactiveTrackColor)) * 31) + Color.hashCode-impl(this.inactiveTickColor)) * 31) + Color.hashCode-impl(this.disabledThumbColor)) * 31) + Color.hashCode-impl(this.disabledActiveTrackColor)) * 31) + Color.hashCode-impl(this.disabledActiveTickColor)) * 31) + Color.hashCode-impl(this.disabledInactiveTrackColor)) * 31) + Color.hashCode-impl(this.disabledInactiveTickColor);
    }

    /* JADX INFO: renamed from: getActiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m3138getActiveTickColor0d7_KjU() {
        return this.activeTickColor;
    }

    /* JADX INFO: renamed from: getActiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3139getActiveTrackColor0d7_KjU() {
        return this.activeTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m3140getDisabledActiveTickColor0d7_KjU() {
        return this.disabledActiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3141getDisabledActiveTrackColor0d7_KjU() {
        return this.disabledActiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m3142getDisabledInactiveTickColor0d7_KjU() {
        return this.disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3143getDisabledInactiveTrackColor0d7_KjU() {
        return this.disabledInactiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3144getDisabledThumbColor0d7_KjU() {
        return this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: getInactiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m3145getInactiveTickColor0d7_KjU() {
        return this.inactiveTickColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3146getInactiveTrackColor0d7_KjU() {
        return this.inactiveTrackColor;
    }

    /* JADX INFO: renamed from: getThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3147getThumbColor0d7_KjU() {
        return this.thumbColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L41:
        return false;
    L8:
        if ((r7 instanceof SliderColors) == false) goto L41;
        SliderColors r8 = (SliderColors) r7;
        if (Color.equals-impl0(this.thumbColor, r8.thumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.activeTrackColor, r8.activeTrackColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.activeTickColor, r8.activeTickColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.inactiveTrackColor, r8.inactiveTrackColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.inactiveTickColor, r8.inactiveTickColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.disabledThumbColor, r8.disabledThumbColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledActiveTrackColor, r8.disabledActiveTrackColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.disabledActiveTickColor, r8.disabledActiveTickColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.disabledInactiveTrackColor, r8.disabledInactiveTrackColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledInactiveTickColor, r8.disabledInactiveTickColor) == true) goto L40;
        return false;
    L40:
        return true;
    }

    /* JADX INFO: renamed from: thumbColor-vNxB06k$material3, reason: not valid java name */
    public final long m3148thumbColorvNxB06k$material3(boolean r3) {
        if (r3 == false) goto L5;
        return this.thumbColor;
    L5:
        return this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: tickColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3149tickColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.activeTickColor;
    L11:
        return this.inactiveTickColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledActiveTickColor;
    L9:
        return this.disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3150trackColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.activeTrackColor;
    L11:
        return this.inactiveTrackColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledActiveTrackColor;
    L9:
        return this.disabledInactiveTrackColor;
    }

    private SliderColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22) {
        this.thumbColor = r4;
        this.activeTrackColor = r6;
        this.activeTickColor = r8;
        this.inactiveTrackColor = r10;
        this.inactiveTickColor = r12;
        this.disabledThumbColor = r14;
        this.disabledActiveTrackColor = r16;
        this.disabledActiveTickColor = r18;
        this.disabledInactiveTrackColor = r20;
        this.disabledInactiveTickColor = r22;
    }

    /* JADX INFO: renamed from: copy--K518z4, reason: not valid java name */
    public final SliderColors m3137copyK518z4(long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48) {
        boolean r1 = true;
        if (r30 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r30;
    L10:
        if (r32 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r32;
    L17:
        if (r34 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r34;
    L24:
        if (r36 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r36;
    L31:
        if (r38 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r38;
    L38:
        if (r40 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r40;
    L45:
        if (r42 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r42;
    L52:
        if (r44 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r44;
    L59:
        if (r46 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r46;
    L66:
        if (r48 != 16) goto L69;
        r1 = false;
    L69:
        if (r1 == false) goto L71;
        long r26 = r48;
    L73:
        return new SliderColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, null);
    L71:
        r26 = this.disabledInactiveTickColor;
        goto L73
    L64:
        r24 = this.disabledInactiveTrackColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.disabledActiveTickColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.disabledActiveTrackColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.disabledThumbColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.inactiveTickColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.inactiveTrackColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.activeTickColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.activeTrackColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.thumbColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy--K518z4$default, reason: not valid java name */
    public static /* synthetic */ SliderColors m3136copyK518z4$default(SliderColors r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        long r2 = r16.thumbColor;
    L7:
        if ((r37 & 2) == 0) goto L9;
        long r4 = r16.activeTrackColor;
    L11:
        if ((r37 & 4) == 0) goto L13;
        long r6 = r16.activeTickColor;
    L15:
        if ((r37 & 8) == 0) goto L17;
        long r8 = r16.inactiveTrackColor;
    L19:
        if ((r37 & 16) == 0) goto L21;
        long r10 = r16.inactiveTickColor;
    L23:
        if ((r37 & 32) == 0) goto L25;
        long r12 = r16.disabledThumbColor;
    L27:
        if ((r37 & 64) == 0) goto L29;
        long r14 = r16.disabledActiveTrackColor;
    L30:
        long r210 = r14;
        if ((r37 & 128) == 0) goto L33;
        long r15 = r16.disabledActiveTickColor;
    L34:
        long r32 = r15;
        if ((r37 & 256) == 0) goto L37;
        long r18 = r16.disabledInactiveTrackColor;
    L38:
        long r34 = r18;
        if ((r37 & 512) == 0) goto L41;
        long r110 = r16.disabledInactiveTickColor;
    L43:
        return r16.m3137copyK518z4(r2, r4, r6, r8, r10, r12, r210, r32, r34, r110);
    L41:
        r110 = r35;
        goto L43
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
