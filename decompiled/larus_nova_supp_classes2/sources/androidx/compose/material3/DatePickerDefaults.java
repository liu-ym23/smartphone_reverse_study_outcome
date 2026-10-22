package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u008b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b\"\u0010#J$\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+J+\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b5\u00106J=\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bC\u0010DR\u0018\u0010$\u001a\u00020\u0005*\u00020%8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u00020J¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0011\u0010N\u001a\u00020O8G¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "DatePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "DatePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DatePickerHeadline", "selectedDateMillis", "", "DatePickerHeadline-ISIPfiY", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "YearMonthSkeleton", "YearAbbrMonthDaySkeleton", "YearMonthWeekdayDaySkeleton", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDefaults {
    public static final int $stable = 0;
    private static final SelectableDates AllDates = null;
    public static final DatePickerDefaults INSTANCE = null;
    private static final float TonalElevation = 0.0f;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange = null;

    private DatePickerDefaults() {
    }

    private static final Unit DatePickerHeadline_ISIPfiY$lambda$4(DatePickerDefaults r11, Long r12, int r13, DatePickerFormatter r14, Modifier r15, long r16, int r18, int r19, Composer r20, int r21) {
        r11.m2576DatePickerHeadlineISIPfiY(r12, r13, r14, r15, r16, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit DatePickerTitle_FNtVw6o$lambda$1(DatePickerDefaults r9, int r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m2577DatePickerTitleFNtVw6o(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DatePickerDefaults r0, Long r1, int r2, DatePickerFormatter r3, Modifier r4, long r5, int r7, int r8, Composer r9, int r10) {
        return DatePickerHeadline_ISIPfiY$lambda$4(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(String r0, SemanticsPropertyReceiver r1) {
        return DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(DatePickerDefaults r0, int r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return DatePickerTitle_FNtVw6o$lambda$1(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    static {
        INSTANCE = new DatePickerDefaults();
        YearRange = new IntRange(1900, 2100);
        TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        AllDates = new DatePickerDefaults$AllDates$1();
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2579getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    private static final Unit DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(String r1, SemanticsPropertyReceiver r2) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r2, LiveRegionMode.Companion.getPolite-0phEisY());
        SemanticsPropertiesKt.setContentDescription(r2, r1);
        return Unit.INSTANCE;
    }

    public final DatePickerColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-275219611, r5, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:447)");
    L5:
        DatePickerColors r6 = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(r4, 6), r4, (r5 << 3) & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(700927667, r5, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:770)");
    L5:
        Shape r6 = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final DatePickerFormatter dateFormatter(String r2, String r3, String r4) {
        return new DatePickerFormatterImpl(r2, r3, r4);
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme r57, Composer r58, int r59) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1180555308, r59, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:546)");
    L5:
        DatePickerColors r3 = r57.getDefaultDatePickerColorsCached$material3();
        if (r3 != null) goto L8;
        r58.startReplaceGroup(642416503);
        DatePickerModalTokens r4 = DatePickerModalTokens.INSTANCE;
        long r6 = ColorSchemeKt.fromToken(r57, r4.getContainerColor());
        long r8 = ColorSchemeKt.fromToken(r57, r4.getHeaderSupportingTextColor());
        long r10 = ColorSchemeKt.fromToken(r57, r4.getHeaderHeadlineColor());
        long r12 = ColorSchemeKt.fromToken(r57, r4.getWeekdaysLabelTextColor());
        long r14 = ColorSchemeKt.fromToken(r57, r4.getRangeSelectionMonthSubheadColor());
        long r16 = r57.m2464getOnSurfaceVariant0d7_KjU();
        long r18 = ColorSchemeKt.fromToken(r57, r4.getSelectionYearUnselectedLabelTextColor());
        long r20 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getSelectionYearUnselectedLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r22 = ColorSchemeKt.fromToken(r57, r4.getDateTodayLabelTextColor());
        long r24 = ColorSchemeKt.fromToken(r57, r4.getSelectionYearSelectedLabelTextColor());
        long r26 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getSelectionYearSelectedLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r28 = ColorSchemeKt.fromToken(r57, r4.getSelectionYearSelectedContainerColor());
        long r30 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getSelectionYearSelectedContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r32 = ColorSchemeKt.fromToken(r57, r4.getDateUnselectedLabelTextColor());
        long r34 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getDateUnselectedLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r36 = ColorSchemeKt.fromToken(r57, r4.getDateSelectedLabelTextColor());
        long r38 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getDateSelectedLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r40 = ColorSchemeKt.fromToken(r57, r4.getDateSelectedContainerColor());
        long r42 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r57, r4.getDateSelectedContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r44 = ColorSchemeKt.fromToken(r57, r4.getDateTodayLabelTextColor());
        long r46 = ColorSchemeKt.fromToken(r57, r4.getDateTodayContainerOutlineColor());
        long r50 = ColorSchemeKt.fromToken(r57, r4.getSelectionDateInRangeLabelTextColor());
        r3 = new DatePickerColors(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, ColorSchemeKt.fromToken(r57, r4.getRangeSelectionActiveIndicatorContainerColor()), r50, ColorSchemeKt.fromToken(r57, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(r57, r58, (r59 & 14) | 48), null);
        r57.setDefaultDatePickerColorsCached$material3(r3);
        r58.endReplaceGroup();
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r3;
    L8:
        r58.startReplaceGroup(642290457);
        r58.endReplaceGroup();
        goto L10
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3(LazyListState r7, DecayAnimationSpec<Float> r8, Composer r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r8 = DecayAnimationSpecKt.exponentialDecay$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 3, null);
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-2036003494, r10, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:741)");
    L8:
        FiniteAnimationSpec r12 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r9, 6);
        boolean r3 = r9.changed(r8);
        if (((r10 & 14) ^ 6) <= 4) goto L13;
        if (r9.changed(r7) == false) goto L13;
    L14:
        boolean r13 = true;
    L16:
        boolean r14 = r13 | r3;
        Object r2 = r9.rememberedValue();
        if (r14 == false) goto L19;
    L20:
        final SnapLayoutInfoProvider r15 = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(r7, null, 2, null);
        r2 = SnapFlingBehaviorKt.snapFlingBehavior(new DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1(r15), r8, r12);
        r9.updateRememberedValue(r2);
    L21:
        TargetedFlingBehavior r4 = (TargetedFlingBehavior) r2;
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r4;
    L19:
        if (r2 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r10 & 6) == 4) goto L14;
        r13 = false;
        goto L16
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = YearMonthSkeleton;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = YearAbbrMonthDaySkeleton;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = YearMonthWeekdayDaySkeleton;
    L12:
        return r0.dateFormatter(r1, r2, r3);
    }

    /* JADX INFO: renamed from: DatePickerTitle-FNtVw6o, reason: not valid java name */
    public final void m2577DatePickerTitleFNtVw6o(final int r38, Modifier r39, long r40, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(-390880814);
        if ((r44 & 1) == 0) goto L6;
        int r3 = r43 | 6;
    L13:
        int r4 = r44 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r39;
    L25:
        if ((r43 & 384) != 0) goto L33;
        long r9 = r40;
        if ((r44 & 4) == 0) goto L29;
    L31:
        int r7 = 128;
    L32:
        r3 = r3 | r7;
    L35:
        if ((r44 & 8) == 0) goto L38;
        r3 = r3 | 3072;
    L45:
        if ((r3 & 1171) == 1170) goto L47;
        boolean r8 = true;
    L49:
        if (r1.shouldExecute(r8, r3 & 1) == false) goto L79;
        r1.startDefaults();
        if ((r43 & 1) != 0) goto L53;
    L59:
        if (r4 == 0) goto L61;
        Modifier r6 = Modifier.Companion;
    L63:
        if ((r44 & 4) == 0) goto L65;
        r9 = colors(r1, (r3 >> 9) & 14).m2571getTitleContentColor0d7_KjU();
        r3 = r3 & (-897);
    L65:
        long r35 = r9;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L68;
        ComposerKt.traceEventStart(-390880814, r3, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:649)");
    L68:
        DisplayMode.Companion r0 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r38, r0.m2631getPickerjFl4v0()) == false) goto L72;
        r1.startReplaceGroup(-1974299164);
        Modifier r10 = r6;
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911738), r1, 0), r10, r35, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, (r3 & 112) | (r3 & 896), 0, 262136);
        r1.endReplaceGroup();
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventEnd();
    L78:
        final Modifier r11 = r6;
        final long r12 = r35;
    L80:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L84;
        r13.updateScope(new t4(this, r38, r11, r12, r43, r44));
        return;
    L84:
        return;
    L72:
        if (DisplayMode.m2626equalsimpl0(r38, r0.m2630getInputjFl4v0()) == false) goto L74;
        r1.startReplaceGroup(-1974291869);
        Modifier r14 = r6;
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911725), r1, 0), r14, r35, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, (r3 & 112) | (r3 & 896), 0, 262136);
        r1.endReplaceGroup();
        goto L76
    L74:
        r1.startReplaceGroup(-1073325776);
        r1.endReplaceGroup();
        goto L76
    L61:
        r6 = r5;
        goto L63
    L53:
        if (r1.getDefaultsInvalid() == true) goto L59;
        r1.skipToGroupEnd();
        if ((r44 & 4) == 0) goto L58;
        r3 = r3 & (-897);
    L58:
        r6 = r5;
        goto L65
    L79:
        r1.skipToGroupEnd();
        r11 = r5;
        r12 = r9;
        goto L80
    L47:
        r8 = false;
        goto L49
    L38:
        if ((r43 & 3072) != 0) goto L45;
        if (r1.changed(this) == false) goto L42;
        int r15 = 2048;
    L43:
        r3 = r3 | r15;
        goto L45
    L42:
        r15 = 1024;
        goto L43
    L29:
        if (r1.changed(r9) == false) goto L31;
        r7 = 256;
        goto L32
    L33:
        r9 = r40;
        goto L35
    L17:
        if ((r43 & 48) != 0) goto L23;
        r5 = r39;
        if (r1.changed(r5) == false) goto L21;
        int r16 = 32;
    L22:
        r3 = r3 | r16;
        goto L25
    L21:
        r16 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r3 = r43;
        goto L13
    L8:
        if (r1.changed(r38) == false) goto L10;
        int r17 = 4;
    L11:
        r3 = r17 | r43;
        goto L13
    L10:
        r17 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DatePickerHeadline-ISIPfiY, reason: not valid java name */
    public final void m2576DatePickerHeadlineISIPfiY(final Long r40, final int r41, final DatePickerFormatter r42, Modifier r43, long r44, Composer r46, final int r47, final int r48) {
        Composer r13 = r46.startRestartGroup(1913724796);
        if ((r48 & 1) == 0) goto L6;
        int r1 = r47 | 6;
    L14:
        if ((r48 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r48 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L36:
        int r2 = r48 & 8;
        if (r2 == 0) goto L40;
        r1 = r1 | 3072;
    L46:
        Modifier r3 = r43;
    L48:
        if ((r47 & 24576) == 0) goto L50;
        long r4 = r44;
    L59:
        if ((r48 & 32) == 0) goto L62;
        r1 = r1 | 196608;
    L69:
        if ((74899 & r1) == 74898) goto L71;
        boolean r11 = true;
    L73:
        if (r13.shouldExecute(r11, r1 & 1) == false) goto L131;
        r13.startDefaults();
        if ((r47 & 1) != 0) goto L77;
    L83:
        if (r2 == 0) goto L85;
        Modifier r5 = Modifier.Companion;
    L87:
        if ((r48 & 16) == 0) goto L89;
        long r6 = colors(r13, (r1 >> 15) & 14).m2564getHeadlineContentColor0d7_KjU();
        int r12 = r1 & (-57345);
        Modifier r14 = r5;
        long r37 = r6;
    L91:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(1913724796, r12, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:684)");
    L94:
        Locale r7 = CalendarLocale_androidKt.defaultLocale(r13, 0);
        String r0 = DatePickerFormatter.CC.formatDate$default(r42, r40, r7, false, 4, null);
        String r8 = r42.formatDate(r40, r7, true);
        String r9 = "";
        if (r8 != null) goto L104;
        r13.startReplaceGroup(380185931);
        DisplayMode.Companion r10 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r41, r10.m2631getPickerjFl4v0()) == false) goto L100;
        r13.startReplaceGroup(843549871);
        r8 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911729), r13, 0);
        r13.endReplaceGroup();
    L103:
        r13.endReplaceGroup();
    L105:
        if (r0 != null) goto L114;
        r13.startReplaceGroup(380507587);
        DisplayMode.Companion r15 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r41, r15.m2631getPickerjFl4v0()) == false) goto L110;
        r13.startReplaceGroup(843560257);
        r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911726), r13, 0);
        r13.endReplaceGroup();
    L113:
        r13.endReplaceGroup();
    L115:
        DisplayMode.Companion r16 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r41, r16.m2631getPickerjFl4v0()) == false) goto L118;
        r13.startReplaceGroup(843570444);
        char r17 = 0;
        r9 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911727), r13, 0);
        r13.endReplaceGroup();
    L122:
        Object[] r18 = new Object[1];
        r18[r17] = r8;
        final String r19 = String.format(r9, Arrays.copyOf(r18, 1));
        boolean r20 = r13.changed(r19);
        Object r21 = r13.rememberedValue();
        if (r20 == false) goto L125;
    L126:
        r21 = new u4(r19);
        r13.updateRememberedValue(r21);
    L127:
        Modifier r22 = SemanticsModifierKt.semantics$default(r14, false, (Function1) r21, 1, null);
        int r23 = (r12 >> 6) & 896;
        Modifier r24 = r14;
        String r110 = r0;
        Composer r25 = r13;
        TextKt.m3363TextNvy7gAk(r110, r22, r37, null, 0, null, null, null, 0, null, null, 0, 0, false, 1, 0, null, null, r25, r23, 24576, 245752);
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventEnd();
    L130:
        final Modifier r26 = r24;
    L132:
        ScopeUpdateScope r111 = r25.endRestartGroup();
        if (r111 == null) goto L136;
        final long r27 = r37;
        r111.updateScope(new v4(this, r40, r41, r42, r26, r27, r47, r48));
        return;
    L136:
        return;
    L125:
        if (r21 != Composer.Companion.getEmpty()) goto L127;
    L118:
        r17 = 0;
        if (DisplayMode.m2626equalsimpl0(r41, r16.m2630getInputjFl4v0()) == false) goto L121;
        r13.startReplaceGroup(843573323);
        r9 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911719), r13, 0);
        r13.endReplaceGroup();
        goto L122
    L121:
        r13.startReplaceGroup(381043234);
        r13.endReplaceGroup();
        goto L122
    L110:
        if (DisplayMode.m2626equalsimpl0(r41, r15.m2630getInputjFl4v0()) == false) goto L112;
        r13.startReplaceGroup(843562784);
        r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911718), r13, 0);
        r13.endReplaceGroup();
        goto L113
    L112:
        r13.startReplaceGroup(380705954);
        r13.endReplaceGroup();
        r0 = "";
        goto L113
    L114:
        r13.startReplaceGroup(843557408);
        r13.endReplaceGroup();
        goto L115
    L100:
        if (DisplayMode.m2626equalsimpl0(r41, r10.m2630getInputjFl4v0()) == false) goto L102;
        r13.startReplaceGroup(843552842);
        r8 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911724), r13, 0);
        r13.endReplaceGroup();
        goto L103
    L102:
        r13.startReplaceGroup(380407362);
        r13.endReplaceGroup();
        r8 = "";
        goto L103
    L104:
        r13.startReplaceGroup(843542258);
        r13.endReplaceGroup();
        goto L105
    L89:
        r12 = r1;
        r14 = r5;
    L90:
        r37 = r4;
        goto L91
    L85:
        r5 = r3;
        goto L87
    L77:
        if (r13.getDefaultsInvalid() == true) goto L83;
        r13.skipToGroupEnd();
        if ((r48 & 16) == 0) goto L82;
        r1 = r1 & (-57345);
    L82:
        r12 = r1;
        r14 = r3;
        goto L90
    L131:
        r25 = r13;
        r25.skipToGroupEnd();
        r37 = r4;
        r26 = r3;
        goto L132
    L71:
        r11 = false;
        goto L73
    L62:
        if ((r47 & 196608) != 0) goto L69;
        if (r13.changed(this) == false) goto L66;
        int r112 = 131072;
    L67:
        r1 = r1 | r112;
        goto L69
    L66:
        r112 = 65536;
        goto L67
    L50:
        if ((r48 & 16) != 0) goto L54;
        r4 = r44;
        if (r13.changed(r4) == false) goto L55;
        int r113 = 16384;
    L56:
        r1 = r1 | r113;
    L55:
        r113 = 8192;
        goto L56
    L54:
        r4 = r44;
        goto L55
    L40:
        if ((r47 & 3072) != 0) goto L46;
        r3 = r43;
        if (r13.changed(r3) == false) goto L44;
        int r28 = 2048;
    L45:
        r1 = r1 | r28;
        goto L48
    L44:
        r28 = 1024;
        goto L45
    L27:
        if ((r47 & 384) != 0) goto L36;
        if ((r47 & 512) != 0) goto L31;
        boolean r29 = r13.changed(r42);
    L32:
        if (r29 == false) goto L34;
        int r30 = 256;
    L35:
        r1 = r1 | r30;
        goto L36
    L34:
        r30 = 128;
        goto L35
    L31:
        r29 = r13.changedInstance(r42);
        goto L32
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r13.changed(r41) == false) goto L21;
        int r31 = 32;
    L22:
        r1 = r1 | r31;
        goto L24
    L21:
        r31 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r1 = r47;
        goto L14
    L8:
        if (r13.changed(r40) == false) goto L10;
        int r32 = 4;
    L11:
        r1 = r32 | r47;
        goto L14
    L10:
        r32 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m2578colorsbSRYm20(long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, TextFieldColors r103, Composer r104, int r105, int r106, int r107, int r108) {
        if ((r108 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r108 & 2) == 0) goto L9;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r108 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r108 & 8) == 0) goto L17;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r108 & 16) == 0) goto L21;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r108 & 32) == 0) goto L25;
        long r12 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r108 & 64) == 0) goto L29;
        long r14 = Color.Companion.getUnspecified-0d7_KjU();
    L30:
        long r16 = r14;
        if ((r108 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r18 = r15;
        if ((r108 & 256) == 0) goto L37;
        long r17 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r20 = r17;
        if ((r108 & 512) == 0) goto L41;
        long r19 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r22 = r19;
        if ((r108 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L46:
        long r24 = r110;
        if ((r108 & 2048) == 0) goto L49;
        long r111 = Color.Companion.getUnspecified-0d7_KjU();
    L50:
        long r26 = r111;
        if ((r108 & 4096) == 0) goto L53;
        long r112 = Color.Companion.getUnspecified-0d7_KjU();
    L54:
        long r28 = r112;
        if ((r108 & 8192) == 0) goto L57;
        long r113 = Color.Companion.getUnspecified-0d7_KjU();
    L58:
        long r30 = r113;
        if ((r108 & 16384) == 0) goto L61;
        long r114 = Color.Companion.getUnspecified-0d7_KjU();
    L63:
        if ((r108 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r32 = Color.Companion.getUnspecified-0d7_KjU();
    L67:
        if ((r108 & 65536) == 0) goto L69;
        long r34 = Color.Companion.getUnspecified-0d7_KjU();
    L71:
        if ((r108 & 131072) == 0) goto L73;
        long r36 = Color.Companion.getUnspecified-0d7_KjU();
    L75:
        if ((r108 & 262144) == 0) goto L77;
        long r38 = Color.Companion.getUnspecified-0d7_KjU();
    L79:
        if ((r108 & 524288) == 0) goto L81;
        long r40 = Color.Companion.getUnspecified-0d7_KjU();
    L83:
        if ((r108 & 1048576) == 0) goto L85;
        long r42 = Color.Companion.getUnspecified-0d7_KjU();
    L87:
        if ((r108 & 2097152) == 0) goto L89;
        long r44 = Color.Companion.getUnspecified-0d7_KjU();
    L91:
        if ((r108 & 4194304) == 0) goto L93;
        long r46 = Color.Companion.getUnspecified-0d7_KjU();
    L95:
        if ((r108 & 8388608) == 0) goto L97;
        long r48 = Color.Companion.getUnspecified-0d7_KjU();
    L99:
        if ((r108 & 16777216) == 0) goto L101;
        TextFieldColors r1 = null;
    L102:
        TextFieldColors r109 = r1;
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventStart(1991626358, r105, r106, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:516)");
    L106:
        DatePickerColors r0 = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(r104, 6), r104, (r107 >> 12) & 112).m2551copytNwlRmA(r2, r4, r6, r8, r10, r12, r16, r18, r20, r22, r24, r26, r28, r30, r114, r32, r34, r36, r38, r40, r42, r46, r44, r48, r109);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventEnd();
    L109:
        return r0;
    L101:
        r1 = r103;
        goto L102
    L97:
        r48 = r101;
        goto L99
    L93:
        r46 = r99;
        goto L95
    L89:
        r44 = r97;
        goto L91
    L85:
        r42 = r95;
        goto L87
    L81:
        r40 = r93;
        goto L83
    L77:
        r38 = r91;
        goto L79
    L73:
        r36 = r89;
        goto L75
    L69:
        r34 = r87;
        goto L71
    L65:
        r32 = r85;
        goto L67
    L61:
        r114 = r83;
        goto L63
    L57:
        r113 = r81;
        goto L58
    L53:
        r112 = r79;
        goto L54
    L49:
        r111 = r77;
        goto L50
    L45:
        r110 = r75;
        goto L46
    L41:
        r19 = r73;
        goto L42
    L37:
        r17 = r71;
        goto L38
    L33:
        r15 = r69;
        goto L34
    L29:
        r14 = r67;
        goto L30
    L25:
        r12 = r65;
        goto L27
    L21:
        r10 = r63;
        goto L23
    L17:
        r8 = r61;
        goto L19
    L13:
        r6 = r59;
        goto L15
    L9:
        r4 = r57;
        goto L11
    L5:
        r2 = r55;
        goto L7
    }
}
