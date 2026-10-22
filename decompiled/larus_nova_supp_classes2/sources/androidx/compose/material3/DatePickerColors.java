package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0089\u0002\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001c0@H\u0000¢\u0006\u0002\bAJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bH\u0010IJ-\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020D2\u0006\u0010K\u001a\u00020DH\u0001¢\u0006\u0004\bL\u0010MJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010N\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bO\u0010MJ%\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bQ\u0010RJ\u0013\u0010S\u001a\u00020D2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010U\u001a\u00020VH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b*\u0010 R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b0\u0010 R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010 R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b2\u0010 R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010 R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b4\u0010 R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010 R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b6\u0010 R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010 R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b8\u0010 R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006W"}, d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getTitleContentColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getCurrentYearContentColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDayContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "Landroidx/compose/runtime/State;", "isToday", "", "selected", "inRange", "enabled", "dayContentColor$material3", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "dayContainerColor", "animate", "dayContainerColor$material3", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3", "yearContainerColor", "yearContainerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, TextFieldColors r49, DefaultConstructorMarker r50) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49);
    }

    public static /* synthetic */ TextFieldColors a(DatePickerColors r0) {
        return copy_tNwlRmA$lambda$24(r0);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.hashCode-impl(this.containerColor) * 31) + Color.hashCode-impl(this.titleContentColor)) * 31) + Color.hashCode-impl(this.headlineContentColor)) * 31) + Color.hashCode-impl(this.weekdayContentColor)) * 31) + Color.hashCode-impl(this.subheadContentColor)) * 31) + Color.hashCode-impl(this.yearContentColor)) * 31) + Color.hashCode-impl(this.disabledYearContentColor)) * 31) + Color.hashCode-impl(this.currentYearContentColor)) * 31) + Color.hashCode-impl(this.selectedYearContentColor)) * 31) + Color.hashCode-impl(this.disabledSelectedYearContentColor)) * 31) + Color.hashCode-impl(this.selectedYearContainerColor)) * 31) + Color.hashCode-impl(this.disabledSelectedYearContainerColor)) * 31) + Color.hashCode-impl(this.dayContentColor)) * 31) + Color.hashCode-impl(this.disabledDayContentColor)) * 31) + Color.hashCode-impl(this.selectedDayContentColor)) * 31) + Color.hashCode-impl(this.disabledSelectedDayContentColor)) * 31) + Color.hashCode-impl(this.selectedDayContainerColor)) * 31) + Color.hashCode-impl(this.disabledSelectedDayContainerColor)) * 31) + Color.hashCode-impl(this.todayContentColor)) * 31) + Color.hashCode-impl(this.todayDateBorderColor)) * 31) + Color.hashCode-impl(this.dayInSelectionRangeContainerColor)) * 31) + Color.hashCode-impl(this.dayInSelectionRangeContentColor);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2552getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getCurrentYearContentColor-0d7_KjU, reason: not valid java name */
    public final long m2553getCurrentYearContentColor0d7_KjU() {
        return this.currentYearContentColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    /* JADX INFO: renamed from: getDayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2554getDayContentColor0d7_KjU() {
        return this.dayContentColor;
    }

    /* JADX INFO: renamed from: getDayInSelectionRangeContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2555getDayInSelectionRangeContainerColor0d7_KjU() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* JADX INFO: renamed from: getDayInSelectionRangeContentColor-0d7_KjU, reason: not valid java name */
    public final long m2556getDayInSelectionRangeContentColor0d7_KjU() {
        return this.dayInSelectionRangeContentColor;
    }

    /* JADX INFO: renamed from: getDisabledDayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2557getDisabledDayContentColor0d7_KjU() {
        return this.disabledDayContentColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedDayContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2558getDisabledSelectedDayContainerColor0d7_KjU() {
        return this.disabledSelectedDayContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedDayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2559getDisabledSelectedDayContentColor0d7_KjU() {
        return this.disabledSelectedDayContentColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedYearContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2560getDisabledSelectedYearContainerColor0d7_KjU() {
        return this.disabledSelectedYearContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedYearContentColor-0d7_KjU, reason: not valid java name */
    public final long m2561getDisabledSelectedYearContentColor0d7_KjU() {
        return this.disabledSelectedYearContentColor;
    }

    /* JADX INFO: renamed from: getDisabledYearContentColor-0d7_KjU, reason: not valid java name */
    public final long m2562getDisabledYearContentColor0d7_KjU() {
        return this.disabledYearContentColor;
    }

    /* JADX INFO: renamed from: getDividerColor-0d7_KjU, reason: not valid java name */
    public final long m2563getDividerColor0d7_KjU() {
        return this.dividerColor;
    }

    /* JADX INFO: renamed from: getHeadlineContentColor-0d7_KjU, reason: not valid java name */
    public final long m2564getHeadlineContentColor0d7_KjU() {
        return this.headlineContentColor;
    }

    /* JADX INFO: renamed from: getNavigationContentColor-0d7_KjU, reason: not valid java name */
    public final long m2565getNavigationContentColor0d7_KjU() {
        return this.navigationContentColor;
    }

    /* JADX INFO: renamed from: getSelectedDayContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2566getSelectedDayContainerColor0d7_KjU() {
        return this.selectedDayContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedDayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2567getSelectedDayContentColor0d7_KjU() {
        return this.selectedDayContentColor;
    }

    /* JADX INFO: renamed from: getSelectedYearContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2568getSelectedYearContainerColor0d7_KjU() {
        return this.selectedYearContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedYearContentColor-0d7_KjU, reason: not valid java name */
    public final long m2569getSelectedYearContentColor0d7_KjU() {
        return this.selectedYearContentColor;
    }

    /* JADX INFO: renamed from: getSubheadContentColor-0d7_KjU, reason: not valid java name */
    public final long m2570getSubheadContentColor0d7_KjU() {
        return this.subheadContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m2571getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: getTodayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2572getTodayContentColor0d7_KjU() {
        return this.todayContentColor;
    }

    /* JADX INFO: renamed from: getTodayDateBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2573getTodayDateBorderColor0d7_KjU() {
        return this.todayDateBorderColor;
    }

    /* JADX INFO: renamed from: getWeekdayContentColor-0d7_KjU, reason: not valid java name */
    public final long m2574getWeekdayContentColor0d7_KjU() {
        return this.weekdayContentColor;
    }

    /* JADX INFO: renamed from: getYearContentColor-0d7_KjU, reason: not valid java name */
    public final long m2575getYearContentColor0d7_KjU() {
        return this.yearContentColor;
    }

    private static final TextFieldColors copy_tNwlRmA$lambda$24(DatePickerColors r0) {
        return r0.dateTextFieldColors;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof DatePickerColors) == true) goto L5;
        return false;
    L5:
        DatePickerColors r8 = (DatePickerColors) r7;
        if (Color.equals-impl0(this.containerColor, r8.containerColor) == true) goto L9;
        return false;
    L9:
        if (Color.equals-impl0(this.titleContentColor, r8.titleContentColor) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(this.headlineContentColor, r8.headlineContentColor) == true) goto L15;
        return false;
    L15:
        if (Color.equals-impl0(this.weekdayContentColor, r8.weekdayContentColor) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(this.subheadContentColor, r8.subheadContentColor) == true) goto L21;
        return false;
    L21:
        if (Color.equals-impl0(this.yearContentColor, r8.yearContentColor) == true) goto L24;
        return false;
    L24:
        if (Color.equals-impl0(this.disabledYearContentColor, r8.disabledYearContentColor) == true) goto L27;
        return false;
    L27:
        if (Color.equals-impl0(this.currentYearContentColor, r8.currentYearContentColor) == true) goto L30;
        return false;
    L30:
        if (Color.equals-impl0(this.selectedYearContentColor, r8.selectedYearContentColor) == true) goto L33;
        return false;
    L33:
        if (Color.equals-impl0(this.disabledSelectedYearContentColor, r8.disabledSelectedYearContentColor) == true) goto L36;
        return false;
    L36:
        if (Color.equals-impl0(this.selectedYearContainerColor, r8.selectedYearContainerColor) == true) goto L39;
        return false;
    L39:
        if (Color.equals-impl0(this.disabledSelectedYearContainerColor, r8.disabledSelectedYearContainerColor) == true) goto L42;
        return false;
    L42:
        if (Color.equals-impl0(this.dayContentColor, r8.dayContentColor) == true) goto L45;
        return false;
    L45:
        if (Color.equals-impl0(this.disabledDayContentColor, r8.disabledDayContentColor) == true) goto L48;
        return false;
    L48:
        if (Color.equals-impl0(this.selectedDayContentColor, r8.selectedDayContentColor) == true) goto L51;
        return false;
    L51:
        if (Color.equals-impl0(this.disabledSelectedDayContentColor, r8.disabledSelectedDayContentColor) == true) goto L54;
        return false;
    L54:
        if (Color.equals-impl0(this.selectedDayContainerColor, r8.selectedDayContainerColor) == true) goto L57;
        return false;
    L57:
        if (Color.equals-impl0(this.disabledSelectedDayContainerColor, r8.disabledSelectedDayContainerColor) == true) goto L60;
        return false;
    L60:
        if (Color.equals-impl0(this.todayContentColor, r8.todayContentColor) == true) goto L63;
        return false;
    L63:
        if (Color.equals-impl0(this.todayDateBorderColor, r8.todayDateBorderColor) == true) goto L66;
        return false;
    L66:
        if (Color.equals-impl0(this.dayInSelectionRangeContainerColor, r8.dayInSelectionRangeContainerColor) == true) goto L69;
        return false;
    L69:
        if (Color.equals-impl0(this.dayInSelectionRangeContentColor, r8.dayInSelectionRangeContentColor) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final TextFieldColors takeOrElse$material3(TextFieldColors r1, Function0<TextFieldColors> r2) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return (TextFieldColors) r2.invoke();
    }

    public final State<Color> yearContainerColor$material3(boolean r9, boolean r10, Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1306331107, r12, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:1030)");
    L5:
        if (r9 == false) goto L9;
        if (r10 == false) goto L8;
        long r13 = this.selectedYearContainerColor;
    L10:
        State<Color> r14 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r13, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r11, 6), null, null, r11, 0, 12);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r14;
    L8:
        r13 = this.disabledSelectedYearContainerColor;
        goto L10
    L9:
        r13 = Color.Companion.getTransparent-0d7_KjU();
        goto L10
    }

    public final State<Color> dayContainerColor$material3(boolean r9, boolean r10, boolean r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1240482658, r13, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:976)");
    L5:
        if (r9 == false) goto L9;
        if (r10 == false) goto L8;
        long r14 = this.selectedDayContainerColor;
    L10:
        long r0 = r14;
        if (r11 == false) goto L13;
        r12.startReplaceGroup(-1319856736);
        State<Color> r15 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r12, 6), null, null, r12, 0, 12);
        r12.endReplaceGroup();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r15;
    L13:
        r12.startReplaceGroup(-1319630064);
        r15 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r12, 0);
        r12.endReplaceGroup();
        goto L15
    L8:
        r14 = this.disabledSelectedDayContainerColor;
        goto L10
    L9:
        r14 = Color.Companion.getTransparent-0d7_KjU();
        goto L10
    }

    public final State<Color> yearContentColor$material3(boolean r9, boolean r10, boolean r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(874111097, r13, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:1006)");
    L5:
        if (r10 == false) goto L9;
        if (r11 == false) goto L9;
        long r14 = this.selectedYearContentColor;
    L8:
        long r0 = r14;
        State<Color> r15 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r12, 6), null, null, r12, 0, 12);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r15;
    L9:
        if (r10 == false) goto L12;
        if (r11 == true) goto L12;
        r14 = this.disabledSelectedYearContentColor;
    L12:
        if (r9 == false) goto L15;
        if (r11 == false) goto L15;
        r14 = this.currentYearContentColor;
    L15:
        if (r11 == false) goto L17;
        r14 = this.yearContentColor;
        goto L8
    L17:
        r14 = this.disabledYearContentColor;
        goto L8
    }

    public final State<Color> dayContentColor$material3(boolean r9, boolean r10, boolean r11, boolean r12, Composer r13, int r14) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1233694918, r14, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:940)");
    L5:
        if (r10 == false) goto L9;
        if (r12 == false) goto L9;
        long r15 = this.selectedDayContentColor;
    L8:
        long r0 = r15;
        if (r11 == false) goto L26;
        r13.startReplaceGroup(-969483020);
        State<Color> r16 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r13, 0);
        r13.endReplaceGroup();
    L28:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
    L30:
        return r16;
    L26:
        r13.startReplaceGroup(-969417610);
        r16 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r13, 6), null, null, r13, 0, 12);
        r13.endReplaceGroup();
    L9:
        if (r10 == false) goto L12;
        if (r12 == true) goto L12;
        r15 = this.disabledSelectedDayContentColor;
    L12:
        if (r11 == false) goto L15;
        if (r12 == false) goto L15;
        r15 = this.dayInSelectionRangeContentColor;
    L15:
        if (r11 == false) goto L18;
        if (r12 == true) goto L18;
        r15 = this.disabledDayContentColor;
    L18:
        if (r9 == false) goto L21;
        if (r12 == false) goto L21;
        r15 = this.todayContentColor;
    L21:
        if (r12 == false) goto L23;
        r15 = this.dayContentColor;
        goto L8
    L23:
        r15 = this.disabledDayContentColor;
        goto L8
    }

    private DatePickerColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, TextFieldColors r52) {
        this.containerColor = r4;
        this.titleContentColor = r6;
        this.headlineContentColor = r8;
        this.weekdayContentColor = r10;
        this.subheadContentColor = r12;
        this.navigationContentColor = r14;
        this.yearContentColor = r16;
        this.disabledYearContentColor = r18;
        this.currentYearContentColor = r20;
        this.selectedYearContentColor = r22;
        this.disabledSelectedYearContentColor = r24;
        this.selectedYearContainerColor = r26;
        this.disabledSelectedYearContainerColor = r28;
        this.dayContentColor = r30;
        this.disabledDayContentColor = r32;
        this.selectedDayContentColor = r34;
        this.disabledSelectedDayContentColor = r36;
        this.selectedDayContainerColor = r38;
        this.disabledSelectedDayContainerColor = r40;
        this.todayContentColor = r42;
        this.todayDateBorderColor = r44;
        this.dayInSelectionRangeContainerColor = r46;
        this.dayInSelectionRangeContentColor = r48;
        this.dividerColor = r50;
        this.dateTextFieldColors = r52;
    }

    /* JADX INFO: renamed from: copy-tNwlRmA, reason: not valid java name */
    public final DatePickerColors m2551copytNwlRmA(long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, TextFieldColors r107) {
        boolean r1 = true;
        if (r59 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r59;
    L10:
        if (r61 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r61;
    L17:
        if (r63 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r63;
    L24:
        if (r65 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r65;
    L31:
        if (r67 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r67;
    L38:
        if (r69 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r69;
    L45:
        if (r71 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r71;
    L52:
        if (r73 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r73;
    L59:
        if (r75 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r75;
    L66:
        if (r77 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r77;
    L73:
        if (r79 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r28 = r79;
    L80:
        if (r81 == 16) goto L82;
        boolean r25 = true;
    L83:
        if (r25 == false) goto L85;
        long r30 = r81;
    L87:
        if (r83 == 16) goto L89;
        boolean r27 = true;
    L90:
        if (r27 == false) goto L92;
        long r32 = r83;
    L94:
        if (r85 == 16) goto L96;
        boolean r29 = true;
    L97:
        if (r29 == false) goto L99;
        long r34 = r85;
    L101:
        if (r87 == 16) goto L103;
        boolean r31 = true;
    L104:
        if (r31 == false) goto L106;
        long r36 = r87;
    L108:
        if (r89 == 16) goto L110;
        boolean r33 = true;
    L111:
        if (r33 == false) goto L113;
        long r38 = r89;
    L115:
        if (r91 == 16) goto L117;
        boolean r35 = true;
    L118:
        if (r35 == false) goto L120;
        long r40 = r91;
    L122:
        if (r93 == 16) goto L124;
        boolean r37 = true;
    L125:
        if (r37 == false) goto L127;
        long r42 = r93;
    L129:
        if (r95 == 16) goto L131;
        boolean r39 = true;
    L132:
        if (r39 == false) goto L134;
        long r44 = r95;
    L136:
        if (r97 == 16) goto L138;
        boolean r41 = true;
    L139:
        if (r41 == false) goto L141;
        long r46 = r97;
    L143:
        if (r99 == 16) goto L145;
        boolean r43 = true;
    L146:
        if (r43 == false) goto L148;
        long r48 = r99;
    L150:
        if (r101 == 16) goto L152;
        boolean r45 = true;
    L153:
        if (r45 == false) goto L155;
        long r50 = r101;
    L157:
        if (r103 == 16) goto L159;
        boolean r47 = true;
    L160:
        if (r47 == false) goto L162;
        long r52 = r103;
    L164:
        if (r105 != 16) goto L167;
        r1 = false;
    L167:
        if (r1 == false) goto L169;
        long r54 = r105;
    L171:
        return new DatePickerColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, takeOrElse$material3(r107, new s4(this)), null);
    L169:
        r54 = this.dividerColor;
        goto L171
    L162:
        r52 = this.dayInSelectionRangeContentColor;
        goto L164
    L159:
        r47 = false;
        goto L160
    L155:
        r50 = this.dayInSelectionRangeContainerColor;
        goto L157
    L152:
        r45 = false;
        goto L153
    L148:
        r48 = this.todayDateBorderColor;
        goto L150
    L145:
        r43 = false;
        goto L146
    L141:
        r46 = this.todayContentColor;
        goto L143
    L138:
        r41 = false;
        goto L139
    L134:
        r44 = this.disabledSelectedDayContainerColor;
        goto L136
    L131:
        r39 = false;
        goto L132
    L127:
        r42 = this.selectedDayContainerColor;
        goto L129
    L124:
        r37 = false;
        goto L125
    L120:
        r40 = this.disabledSelectedDayContentColor;
        goto L122
    L117:
        r35 = false;
        goto L118
    L113:
        r38 = this.selectedDayContentColor;
        goto L115
    L110:
        r33 = false;
        goto L111
    L106:
        r36 = this.disabledDayContentColor;
        goto L108
    L103:
        r31 = false;
        goto L104
    L99:
        r34 = this.dayContentColor;
        goto L101
    L96:
        r29 = false;
        goto L97
    L92:
        r32 = this.disabledSelectedYearContainerColor;
        goto L94
    L89:
        r27 = false;
        goto L90
    L85:
        r30 = this.selectedYearContainerColor;
        goto L87
    L82:
        r25 = false;
        goto L83
    L78:
        r28 = this.disabledSelectedYearContentColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.selectedYearContentColor;
        goto L73
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.currentYearContentColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.disabledYearContentColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.yearContentColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.navigationContentColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.subheadContentColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.weekdayContentColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.headlineContentColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.titleContentColor;
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

    /* JADX INFO: renamed from: copy-tNwlRmA$default, reason: not valid java name */
    public static /* synthetic */ DatePickerColors m2550copytNwlRmA$default(DatePickerColors r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, TextFieldColors r66, int r67, Object r68) {
        if ((r67 & 1) == 0) goto L5;
        long r2 = r17.containerColor;
    L7:
        if ((r67 & 2) == 0) goto L9;
        long r4 = r17.titleContentColor;
    L11:
        if ((r67 & 4) == 0) goto L13;
        long r6 = r17.headlineContentColor;
    L15:
        if ((r67 & 8) == 0) goto L17;
        long r8 = r17.weekdayContentColor;
    L19:
        if ((r67 & 16) == 0) goto L21;
        long r10 = r17.subheadContentColor;
    L23:
        if ((r67 & 32) == 0) goto L25;
        long r12 = r17.navigationContentColor;
    L27:
        if ((r67 & 64) == 0) goto L29;
        long r14 = r17.yearContentColor;
    L30:
        long r31 = r14;
        if ((r67 & 128) == 0) goto L33;
        long r15 = r17.disabledYearContentColor;
    L34:
        long r33 = r15;
        if ((r67 & 256) == 0) goto L37;
        long r16 = r17.currentYearContentColor;
    L38:
        long r35 = r16;
        if ((r67 & 512) == 0) goto L41;
        long r19 = r17.selectedYearContentColor;
    L42:
        long r37 = r19;
        if ((r67 & 1024) == 0) goto L45;
        long r110 = r17.disabledSelectedYearContentColor;
    L46:
        long r39 = r110;
        if ((r67 & 2048) == 0) goto L49;
        long r111 = r17.selectedYearContainerColor;
    L50:
        long r41 = r111;
        if ((r67 & 4096) == 0) goto L53;
        long r112 = r17.disabledSelectedYearContainerColor;
    L54:
        long r43 = r112;
        if ((r67 & 8192) == 0) goto L57;
        long r113 = r17.dayContentColor;
    L58:
        long r45 = r113;
        if ((r67 & 16384) == 0) goto L61;
        long r114 = r17.disabledDayContentColor;
    L62:
        long r47 = r114;
        if ((r67 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r115 = r17.selectedDayContentColor;
    L66:
        long r49 = r115;
        if ((r67 & 65536) == 0) goto L69;
        long r116 = r17.disabledSelectedDayContentColor;
    L70:
        long r51 = r116;
        if ((r67 & 131072) == 0) goto L73;
        long r117 = r17.selectedDayContainerColor;
    L74:
        long r53 = r117;
        if ((r67 & 262144) == 0) goto L77;
        long r118 = r17.disabledSelectedDayContainerColor;
    L78:
        long r55 = r118;
        if ((r67 & 524288) == 0) goto L81;
        long r119 = r17.todayContentColor;
    L82:
        long r57 = r119;
        if ((r67 & 1048576) == 0) goto L85;
        long r120 = r17.todayDateBorderColor;
    L86:
        long r59 = r120;
        if ((r67 & 2097152) == 0) goto L89;
        long r121 = r17.dayInSelectionRangeContainerColor;
    L90:
        long r61 = r121;
        if ((r67 & 4194304) == 0) goto L93;
        long r122 = r17.dayInSelectionRangeContentColor;
    L94:
        long r63 = r122;
        if ((r67 & 8388608) == 0) goto L97;
        long r123 = r17.dividerColor;
    L99:
        if ((r67 & 16777216) == 0) goto L101;
        TextFieldColors r1 = r17.dateTextFieldColors;
    L103:
        return r17.m2551copytNwlRmA(r2, r4, r6, r8, r10, r12, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r123, r1);
    L101:
        r1 = r66;
        goto L103
    L97:
        r123 = r64;
        goto L99
    L93:
        r122 = r62;
        goto L94
    L89:
        r121 = r60;
        goto L90
    L85:
        r120 = r58;
        goto L86
    L81:
        r119 = r56;
        goto L82
    L77:
        r118 = r54;
        goto L78
    L73:
        r117 = r52;
        goto L74
    L69:
        r116 = r50;
        goto L70
    L65:
        r115 = r48;
        goto L66
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
