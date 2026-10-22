package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u00ad\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b1\u0010/J\u001f\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b3\u0010/J\u001f\u00104\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b5\u0010/J\u0013\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00108\u001a\u000209H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b&\u0010\u0016¨\u0006:"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "<init>", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedThumbColor-0d7_KjU", "()J", "J", "getCheckedTrackColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getCheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "thumbColor", "enabled", "", "checked", "thumbColor-WaAFU9c$material3", "(ZZ)J", "trackColor", "trackColor-WaAFU9c$material3", "borderColor", "borderColor-WaAFU9c$material3", "iconColor", "iconColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, DefaultConstructorMarker r33) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.hashCode-impl(this.checkedThumbColor) * 31) + Color.hashCode-impl(this.checkedTrackColor)) * 31) + Color.hashCode-impl(this.checkedBorderColor)) * 31) + Color.hashCode-impl(this.checkedIconColor)) * 31) + Color.hashCode-impl(this.uncheckedThumbColor)) * 31) + Color.hashCode-impl(this.uncheckedTrackColor)) * 31) + Color.hashCode-impl(this.uncheckedBorderColor)) * 31) + Color.hashCode-impl(this.uncheckedIconColor)) * 31) + Color.hashCode-impl(this.disabledCheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledCheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledCheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledCheckedIconColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedIconColor);
    }

    /* JADX INFO: renamed from: getCheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3224getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* JADX INFO: renamed from: getCheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m3225getCheckedIconColor0d7_KjU() {
        return this.checkedIconColor;
    }

    /* JADX INFO: renamed from: getCheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3226getCheckedThumbColor0d7_KjU() {
        return this.checkedThumbColor;
    }

    /* JADX INFO: renamed from: getCheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3227getCheckedTrackColor0d7_KjU() {
        return this.checkedTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3228getDisabledCheckedBorderColor0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m3229getDisabledCheckedIconColor0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3230getDisabledCheckedThumbColor0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3231getDisabledCheckedTrackColor0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3232getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m3233getDisabledUncheckedIconColor0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3234getDisabledUncheckedThumbColor0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3235getDisabledUncheckedTrackColor0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    /* JADX INFO: renamed from: getUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m3236getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getUncheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m3237getUncheckedIconColor0d7_KjU() {
        return this.uncheckedIconColor;
    }

    /* JADX INFO: renamed from: getUncheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m3238getUncheckedThumbColor0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    /* JADX INFO: renamed from: getUncheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m3239getUncheckedTrackColor0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L59:
        return false;
    L8:
        if ((r7 instanceof SwitchColors) == false) goto L59;
        SwitchColors r8 = (SwitchColors) r7;
        if (Color.equals-impl0(this.checkedThumbColor, r8.checkedThumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.checkedTrackColor, r8.checkedTrackColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.checkedBorderColor, r8.checkedBorderColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.checkedIconColor, r8.checkedIconColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.uncheckedThumbColor, r8.uncheckedThumbColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.uncheckedTrackColor, r8.uncheckedTrackColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.uncheckedBorderColor, r8.uncheckedBorderColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.uncheckedIconColor, r8.uncheckedIconColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.disabledCheckedThumbColor, r8.disabledCheckedThumbColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledCheckedTrackColor, r8.disabledCheckedTrackColor) == true) goto L41;
        return false;
    L41:
        if (Color.equals-impl0(this.disabledCheckedBorderColor, r8.disabledCheckedBorderColor) == true) goto L44;
        return false;
    L44:
        if (Color.equals-impl0(this.disabledCheckedIconColor, r8.disabledCheckedIconColor) == true) goto L47;
        return false;
    L47:
        if (Color.equals-impl0(this.disabledUncheckedThumbColor, r8.disabledUncheckedThumbColor) == true) goto L50;
        return false;
    L50:
        if (Color.equals-impl0(this.disabledUncheckedTrackColor, r8.disabledUncheckedTrackColor) == true) goto L53;
        return false;
    L53:
        if (Color.equals-impl0(this.disabledUncheckedBorderColor, r8.disabledUncheckedBorderColor) == true) goto L56;
        return false;
    L56:
        if (Color.equals-impl0(this.disabledUncheckedIconColor, r8.disabledUncheckedIconColor) == true) goto L58;
        return false;
    L58:
        return true;
    }

    /* JADX INFO: renamed from: borderColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3222borderColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.checkedBorderColor;
    L11:
        return this.uncheckedBorderColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledCheckedBorderColor;
    L9:
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3240iconColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.checkedIconColor;
    L11:
        return this.uncheckedIconColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledCheckedIconColor;
    L9:
        return this.disabledUncheckedIconColor;
    }

    /* JADX INFO: renamed from: thumbColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3241thumbColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.checkedThumbColor;
    L11:
        return this.uncheckedThumbColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledCheckedThumbColor;
    L9:
        return this.disabledUncheckedThumbColor;
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3242trackColorWaAFU9c$material3(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L11;
        return this.checkedTrackColor;
    L11:
        return this.uncheckedTrackColor;
    L6:
        if (r2 == false) goto L9;
        return this.disabledCheckedTrackColor;
    L9:
        return this.disabledUncheckedTrackColor;
    }

    private SwitchColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34) {
        this.checkedThumbColor = r4;
        this.checkedTrackColor = r6;
        this.checkedBorderColor = r8;
        this.checkedIconColor = r10;
        this.uncheckedThumbColor = r12;
        this.uncheckedTrackColor = r14;
        this.uncheckedBorderColor = r16;
        this.uncheckedIconColor = r18;
        this.disabledCheckedThumbColor = r20;
        this.disabledCheckedTrackColor = r22;
        this.disabledCheckedBorderColor = r24;
        this.disabledCheckedIconColor = r26;
        this.disabledUncheckedThumbColor = r28;
        this.disabledUncheckedTrackColor = r30;
        this.disabledUncheckedBorderColor = r32;
        this.disabledUncheckedIconColor = r34;
    }

    /* JADX INFO: renamed from: copy-Q_H9qLU, reason: not valid java name */
    public final SwitchColors m3223copyQ_H9qLU(long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72) {
        boolean r1 = true;
        if (r42 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r42;
    L10:
        if (r44 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r44;
    L17:
        if (r46 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r46;
    L24:
        if (r48 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r48;
    L31:
        if (r50 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r50;
    L38:
        if (r52 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r52;
    L45:
        if (r54 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r54;
    L52:
        if (r56 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r56;
    L59:
        if (r58 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r58;
    L66:
        if (r60 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r60;
    L73:
        if (r62 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r28 = r62;
    L80:
        if (r64 == 16) goto L82;
        boolean r25 = true;
    L83:
        if (r25 == false) goto L85;
        long r30 = r64;
    L87:
        if (r66 == 16) goto L89;
        boolean r27 = true;
    L90:
        if (r27 == false) goto L92;
        long r32 = r66;
    L94:
        if (r68 == 16) goto L96;
        boolean r29 = true;
    L97:
        if (r29 == false) goto L99;
        long r34 = r68;
    L101:
        if (r70 == 16) goto L103;
        boolean r31 = true;
    L104:
        if (r31 == false) goto L106;
        long r36 = r70;
    L108:
        if (r72 != 16) goto L111;
        r1 = false;
    L111:
        if (r1 == false) goto L113;
        long r38 = r72;
    L115:
        return new SwitchColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, null);
    L113:
        r38 = this.disabledUncheckedIconColor;
        goto L115
    L106:
        r36 = this.disabledUncheckedBorderColor;
        goto L108
    L103:
        r31 = false;
        goto L104
    L99:
        r34 = this.disabledUncheckedTrackColor;
        goto L101
    L96:
        r29 = false;
        goto L97
    L92:
        r32 = this.disabledUncheckedThumbColor;
        goto L94
    L89:
        r27 = false;
        goto L90
    L85:
        r30 = this.disabledCheckedIconColor;
        goto L87
    L82:
        r25 = false;
        goto L83
    L78:
        r28 = this.disabledCheckedBorderColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.disabledCheckedTrackColor;
        goto L73
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.disabledCheckedThumbColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.uncheckedIconColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.uncheckedBorderColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.uncheckedTrackColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.uncheckedThumbColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.checkedIconColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.checkedBorderColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.checkedTrackColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.checkedThumbColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-Q_H9qLU$default, reason: not valid java name */
    public static /* synthetic */ SwitchColors m3221copyQ_H9qLU$default(SwitchColors r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, int r50, Object r51) {
        if ((r50 & 1) == 0) goto L5;
        long r2 = r17.checkedThumbColor;
    L7:
        if ((r50 & 2) == 0) goto L9;
        long r4 = r17.checkedTrackColor;
    L11:
        if ((r50 & 4) == 0) goto L13;
        long r6 = r17.checkedBorderColor;
    L15:
        if ((r50 & 8) == 0) goto L17;
        long r8 = r17.checkedIconColor;
    L19:
        if ((r50 & 16) == 0) goto L21;
        long r10 = r17.uncheckedThumbColor;
    L23:
        if ((r50 & 32) == 0) goto L25;
        long r12 = r17.uncheckedTrackColor;
    L27:
        if ((r50 & 64) == 0) goto L29;
        long r14 = r17.uncheckedBorderColor;
    L30:
        long r31 = r14;
        if ((r50 & 128) == 0) goto L33;
        long r15 = r17.uncheckedIconColor;
    L34:
        long r33 = r15;
        if ((r50 & 256) == 0) goto L37;
        long r16 = r17.disabledCheckedThumbColor;
    L38:
        long r35 = r16;
        if ((r50 & 512) == 0) goto L41;
        long r19 = r17.disabledCheckedTrackColor;
    L42:
        long r37 = r19;
        if ((r50 & 1024) == 0) goto L45;
        long r110 = r17.disabledCheckedBorderColor;
    L46:
        long r39 = r110;
        if ((r50 & 2048) == 0) goto L49;
        long r111 = r17.disabledCheckedIconColor;
    L50:
        long r41 = r111;
        if ((r50 & 4096) == 0) goto L53;
        long r112 = r17.disabledUncheckedThumbColor;
    L54:
        long r43 = r112;
        if ((r50 & 8192) == 0) goto L57;
        long r113 = r17.disabledUncheckedTrackColor;
    L58:
        long r45 = r113;
        if ((r50 & 16384) == 0) goto L61;
        long r114 = r17.disabledUncheckedBorderColor;
    L62:
        long r47 = r114;
        if ((r50 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r115 = r17.disabledUncheckedIconColor;
    L67:
        return r17.m3223copyQ_H9qLU(r2, r4, r6, r8, r10, r12, r31, r33, r35, r37, r39, r41, r43, r45, r47, r115);
    L65:
        r115 = r48;
        goto L67
    L61:
        r114 = r46;
        goto L62
    L57:
        r113 = r44;
        goto L58
    L53:
        r112 = r42;
        goto L54
    L49:
        r111 = r40;
        goto L50
    L45:
        r110 = r38;
        goto L46
    L41:
        r19 = r36;
        goto L42
    L37:
        r16 = r34;
        goto L38
    L33:
        r15 = r32;
        goto L34
    L29:
        r14 = r30;
        goto L30
    L25:
        r12 = r28;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
