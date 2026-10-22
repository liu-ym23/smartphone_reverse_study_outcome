package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001aC\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001aO\u0010\u0014\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aM\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aY\u0010 \u001a\u00020\u001b2\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0016\u0010#\u001a\u00020$*\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\tH\u0007\u001a\u000e\u0010&\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0007\u001a\u0014\u0010'\u001a\u00020$*\u00020\u00072\u0006\u0010(\u001a\u00020\u000bH\u0007\u001a\f\u0010)\u001a\u00020\u000b*\u00020\u0007H\u0007\u001a \u0010*\u001a\u00020$*\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0007\u001a\u000e\u0010-\u001a\u0004\u0018\u00010\t*\u00020\u001bH\u0007\u001a\u000e\u0010.\u001a\u0004\u0018\u00010\t*\u00020\u001bH\u0007\u001a\u0014\u0010'\u001a\u00020$*\u00020\u001b2\u0006\u0010(\u001a\u00020\u000bH\u0007\u001a\f\u0010)\u001a\u00020\u000b*\u00020\u001bH\u0007\u001a\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0003\u001a\u0010\u00102\u001a\u0002012\u0006\u0010(\u001a\u00020\u000bH\u0003\u001a\u0019\u00103\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u000101H\u0003¢\u0006\u0002\u00105\u001a\u0019\u00106\u001a\u0004\u0018\u0001012\b\u0010%\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u00107¨\u00068"}, d2 = {"formatDatePickerNavigateToYearString", "", "template", "localizedYear", "formatHeadlineDescription", "verboseDateDescription", "rememberDatePickerState", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDate", "Ljava/time/LocalDate;", "initialDisplayedMonth", "Ljava/time/YearMonth;", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "rememberDateRangePickerState", "Landroidx/compose/material3/DateRangePickerState;", "initialSelectedStartDate", "initialSelectedEndDate", "rememberDateRangePickerState-IlFM19s", "(Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "setSelectedDate", "", "date", "getSelectedDate", "setDisplayedMonth", "yearMonth", "getDisplayedMonth", "setSelection", "startDate", "endDate", "getSelectedStartDate", "getSelectedEndDate", "getYearMonth", "millisUtcFirstOfMonth", "", "getYearMonthMillisUtc", "getLocalDate", "millisUtc", "(Ljava/lang/Long;)Ljava/time/LocalDate;", "getLocalDateMillisUtc", "(Ljava/time/LocalDate;)Ljava/lang/Long;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePicker_jvmKt {
    public static final YearMonth getDisplayedMonth(DatePickerState r2) {
        return getYearMonth(r2.getDisplayedMonthMillis());
    }

    private static final LocalDate getLocalDate(Long r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return Instant.ofEpochMilli(r2.longValue()).atZone(ZoneOffset.UTC).toLocalDate();
    }

    private static final Long getLocalDateMillisUtc(LocalDate r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return Long.valueOf(r2.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
    }

    public static final LocalDate getSelectedDate(DatePickerState r0) {
        return getLocalDate(r0.getSelectedDateMillis());
    }

    public static final LocalDate getSelectedEndDate(DateRangePickerState r0) {
        return getLocalDate(r0.getSelectedEndDateMillis());
    }

    public static final LocalDate getSelectedStartDate(DateRangePickerState r0) {
        return getLocalDate(r0.getSelectedStartDateMillis());
    }

    private static final YearMonth getYearMonth(long r0) {
        return YearMonth.from(Instant.ofEpochMilli(r0).atZone(ZoneOffset.UTC));
    }

    private static final long getYearMonthMillisUtc(YearMonth r2) {
        return r2.atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public static final YearMonth getDisplayedMonth(DateRangePickerState r2) {
        return getYearMonth(r2.getDisplayedMonthMillis());
    }

    public static final String formatDatePickerNavigateToYearString(String r3, String r4) {
        return String.format(r3, Arrays.copyOf(new Object[]{r4}, 1));
    }

    public static final String formatHeadlineDescription(String r3, String r4) {
        return String.format(r3, Arrays.copyOf(new Object[]{r4}, 1));
    }

    public static final void setDisplayedMonth(DatePickerState r2, YearMonth r3) {
        r2.setDisplayedMonthMillis(getYearMonthMillisUtc(r3));
    }

    public static final void setSelectedDate(DatePickerState r0, LocalDate r1) {
        r0.setSelectedDateMillis(getLocalDateMillisUtc(r1));
    }

    public static final void setDisplayedMonth(DateRangePickerState r2, YearMonth r3) {
        r2.setDisplayedMonthMillis(getYearMonthMillisUtc(r3));
    }

    public static final void setSelection(DateRangePickerState r0, LocalDate r1, LocalDate r2) {
        r0.setSelection(getLocalDateMillisUtc(r1), getLocalDateMillisUtc(r2));
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m2592DatePickerStatesHin3Bw(Locale r6, LocalDate r7, YearMonth r8, IntRange r9, int r10, SelectableDates r11) {
        Long r1 = getLocalDateMillisUtc(r7);
        if (r8 == null) goto L5;
        Long r12 = Long.valueOf(getYearMonthMillisUtc(r8));
    L7:
        return DatePickerKt.m2583DatePickerStatesHin3Bw(r6, r1, r12, r9, r10, r11);
    L5:
        r12 = null;
        goto L7
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m2594DateRangePickerStateHVP43zI(Locale r7, LocalDate r8, LocalDate r9, YearMonth r10, IntRange r11, int r12, SelectableDates r13) {
        Long r1 = getLocalDateMillisUtc(r8);
        Long r2 = getLocalDateMillisUtc(r9);
        if (r10 == null) goto L5;
        Long r14 = Long.valueOf(getYearMonthMillisUtc(r10));
    L7:
        return DateRangePickerKt.m2601DateRangePickerStateHVP43zI(r7, r1, r2, r14, r11, r12, r13);
    L5:
        r14 = null;
        goto L7
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m2593DatePickerStatesHin3Bw$default(Locale r6, LocalDate r7, YearMonth r8, IntRange r9, int r10, SelectableDates r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L7;
        if (r7 == null) goto L6;
        r8 = YearMonth.from(r7);
        goto L7
    L6:
        r8 = null;
    L7:
        YearMonth r2 = r8;
        if ((r12 & 8) == 0) goto L10;
        r9 = DatePickerDefaults.INSTANCE.getYearRange();
    L10:
        IntRange r3 = r9;
        if ((r12 & 16) == 0) goto L13;
        r10 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L13:
        int r4 = r10;
        if ((r12 & 32) == 0) goto L17;
        r11 = DatePickerDefaults.INSTANCE.getAllDates();
    L17:
        return m2592DatePickerStatesHin3Bw(r6, r7, r2, r3, r4, r11);
    }

    /* JADX INFO: renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m2596rememberDatePickerStateEU0dCGE(LocalDate r12, YearMonth r13, IntRange r14, int r15, SelectableDates r16, Composer r17, int r18, int r19) {
        Long r2 = null;
        if ((r19 & 2) == 0) goto L7;
        if (r12 == null) goto L6;
        YearMonth r1 = YearMonth.from(r12);
    L9:
        if ((r19 & 4) == 0) goto L11;
        IntRange r6 = DatePickerDefaults.INSTANCE.getYearRange();
    L13:
        if ((r19 & 8) == 0) goto L15;
        int r7 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L17:
        if ((r19 & 16) == 0) goto L19;
        SelectableDates r8 = DatePickerDefaults.INSTANCE.getAllDates();
    L21:
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(-1802387829, r18, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.jvm.kt:70)");
    L23:
        if (r12 == null) goto L25;
        Long r4 = getLocalDateMillisUtc(r12);
    L26:
        if (r1 == null) goto L28;
        r2 = Long.valueOf(getYearMonthMillisUtc(r1));
    L28:
        DatePickerState r0 = DatePickerKt.m2588rememberDatePickerStateEU0dCGE(r4, r2, r6, r7, r8, r17, ((r18 & 896) | (r18 & 7168)) | (r18 & 57344), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
    L31:
        return r0;
    L25:
        r4 = null;
        goto L26
    L19:
        r8 = r16;
        goto L21
    L15:
        r7 = r15;
        goto L17
    L11:
        r6 = r14;
        goto L13
    L6:
        r1 = null;
        goto L9
    L7:
        r1 = r13;
        goto L9
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m2595DateRangePickerStateHVP43zI$default(Locale r7, LocalDate r8, LocalDate r9, YearMonth r10, IntRange r11, int r12, SelectableDates r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L7;
        if (r8 == null) goto L6;
        r10 = YearMonth.from(r8);
        goto L7
    L6:
        r10 = null;
    L7:
        YearMonth r3 = r10;
        if ((r14 & 16) == 0) goto L10;
        r11 = DatePickerDefaults.INSTANCE.getYearRange();
    L10:
        IntRange r4 = r11;
        if ((r14 & 32) == 0) goto L13;
        r12 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L13:
        int r5 = r12;
        if ((r14 & 64) == 0) goto L17;
        r13 = DatePickerDefaults.INSTANCE.getAllDates();
    L17:
        return m2594DateRangePickerStateHVP43zI(r7, r8, r9, r3, r4, r5, r13);
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m2597rememberDateRangePickerStateIlFM19s(LocalDate r13, LocalDate r14, YearMonth r15, IntRange r16, int r17, SelectableDates r18, Composer r19, int r20, int r21) {
        Long r2 = null;
        if ((r21 & 4) == 0) goto L7;
        if (r13 == null) goto L6;
        YearMonth r1 = YearMonth.from(r13);
    L9:
        if ((r21 & 8) == 0) goto L11;
        IntRange r7 = DatePickerDefaults.INSTANCE.getYearRange();
    L13:
        if ((r21 & 16) == 0) goto L15;
        int r8 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L17:
        if ((r21 & 32) == 0) goto L19;
        SelectableDates r9 = DatePickerDefaults.INSTANCE.getAllDates();
    L21:
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(-1580705706, r20, -1, "androidx.compose.material3.rememberDateRangePickerState (DatePicker.jvm.kt:175)");
    L23:
        if (r13 == null) goto L25;
        Long r4 = getLocalDateMillisUtc(r13);
    L26:
        if (r14 == null) goto L28;
        Long r5 = getLocalDateMillisUtc(r14);
    L29:
        if (r1 == null) goto L31;
        r2 = Long.valueOf(getYearMonthMillisUtc(r1));
    L31:
        DateRangePickerState r0 = DateRangePickerKt.m2606rememberDateRangePickerStateIlFM19s(r4, r5, r2, r7, r8, r9, r19, ((r20 & 7168) | (57344 & r20)) | (r20 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
    L34:
        return r0;
    L28:
        r5 = null;
        goto L29
    L25:
        r4 = null;
        goto L26
    L19:
        r9 = r18;
        goto L21
    L15:
        r8 = r17;
        goto L17
    L11:
        r7 = r16;
        goto L13
    L6:
        r1 = null;
        goto L9
    L7:
        r1 = r15;
        goto L9
    }
}
