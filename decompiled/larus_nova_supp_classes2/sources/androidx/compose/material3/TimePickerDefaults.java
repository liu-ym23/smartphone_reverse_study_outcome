package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u009b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0018\u001a\u00020\u0005*\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/compose/material3/TimePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TimePickerColors;", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "selectorColor", "containerColor", "periodSelectorBorderColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "colors-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TimePickerColors;", "defaultTimePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTimePickerColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType-sDNSZnc", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDefaults {
    public static final int $stable = 0;
    public static final TimePickerDefaults INSTANCE = null;

    static {
        INSTANCE = new TimePickerDefaults();
    }

    private TimePickerDefaults() {
    }

    public final TimePickerColors getDefaultTimePickerColors$material3(ColorScheme r34) {
        TimePickerColors r1 = r34.getDefaultTimePickerColorsCached$material3();
        if (r1 != null) goto L6;
        TimePickerTokens r2 = TimePickerTokens.INSTANCE;
        long r4 = ColorSchemeKt.fromToken(r34, r2.getClockDialColor());
        long r12 = ColorSchemeKt.fromToken(r34, r2.getClockDialSelectedLabelTextColor());
        long r14 = ColorSchemeKt.fromToken(r34, r2.getClockDialUnselectedLabelTextColor());
        TimePickerColors r3 = new TimePickerColors(r4, ColorSchemeKt.fromToken(r34, r2.getClockDialSelectorHandleContainerColor()), ColorSchemeKt.fromToken(r34, r2.getContainerColor()), ColorSchemeKt.fromToken(r34, r2.getPeriodSelectorOutlineColor()), r12, r14, ColorSchemeKt.fromToken(r34, r2.getPeriodSelectorSelectedContainerColor()), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r34, r2.getPeriodSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(r34, r2.getPeriodSelectorUnselectedLabelTextColor()), ColorSchemeKt.fromToken(r34, r2.getTimeSelectorSelectedContainerColor()), ColorSchemeKt.fromToken(r34, r2.getTimeSelectorUnselectedContainerColor()), ColorSchemeKt.fromToken(r34, r2.getTimeSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(r34, r2.getTimeSelectorUnselectedLabelTextColor()), null);
        r34.setDefaultTimePickerColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final TimePickerColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2085808058, r5, -1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:284)");
    L5:
        TimePickerColors r6 = getDefaultTimePickerColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: layoutType-sDNSZnc, reason: not valid java name */
    public final int m3390layoutTypesDNSZnc(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(517161502, r5, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:381)");
    L5:
        int r6 = TimePickerKt.getDefaultTimePickerLayoutType(r4, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-u3YEpmA, reason: not valid java name */
    public final TimePickerColors m3389colorsu3YEpmA(long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, Composer r62, int r63, int r64, int r65) {
        if ((r65 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r65 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r65 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r65 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r65 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r65 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r65 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r65 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r65 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r16;
        if ((r65 & 512) == 0) goto L41;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r18;
        if ((r65 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L46:
        long r23 = r110;
        if ((r65 & 2048) == 0) goto L49;
        long r111 = Color.Companion.getUnspecified-0d7_KjU();
    L50:
        long r25 = r111;
        if ((r65 & 4096) == 0) goto L53;
        long r112 = Color.Companion.getUnspecified-0d7_KjU();
    L55:
        if ((r65 & 8192) == 0) goto L57;
        long r27 = Color.Companion.getUnspecified-0d7_KjU();
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventStart(-646352288, r63, r64, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:331)");
    L62:
        TimePickerColors r0 = getDefaultTimePickerColors$material3(MaterialTheme.INSTANCE.getColorScheme(r62, 6)).m3370copydVHXu7A(r1, r7, r9, r11, r3, r5, r13, r17, r19, r21, r23, r25, r112, r27);
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        return r0;
    L57:
        r27 = r60;
        goto L59
    L53:
        r112 = r58;
        goto L55
    L49:
        r111 = r56;
        goto L50
    L45:
        r110 = r54;
        goto L46
    L41:
        r18 = r52;
        goto L42
    L37:
        r16 = r50;
        goto L38
    L33:
        r15 = r48;
        goto L34
    L29:
        r13 = r46;
        goto L31
    L25:
        r11 = r44;
        goto L27
    L21:
        r9 = r42;
        goto L23
    L17:
        r7 = r40;
        goto L19
    L13:
        r5 = r38;
        goto L15
    L9:
        r3 = r36;
        goto L11
    L5:
        r1 = r34;
        goto L7
    }
}
