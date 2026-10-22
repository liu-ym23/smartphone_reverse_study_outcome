package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a[\u0010 \u001a\u00020\u00032\n\u0010!\u001a\u00060\"j\u0002`#2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%\u001aÄ\u0001\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001b2:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b6\u00107\u001a°\u0001\u00108\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u00109\u001a°\u0001\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\b\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010=\u001ae\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00152\b\u0010A\u001a\u0004\u0018\u00010\u00152:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,H\u0002¢\u0006\u0002\u0010B\u001a#\u0010G\u001a\u00020\u0001*\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0000¢\u0006\u0004\bM\u0010N\u001a.\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0P2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0002\"\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F\"\u000e\u0010W\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[¨\u0006\\"}, d2 = {"DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "selectedStartDateMillis", "selectedEndDateMillis", "displayedMonthMillis", "displayMode", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-eVtQiho", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "DateRangePickerTitlePadding", "DateRangePickerHeadlinePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = null;
    private static final PaddingValues DateRangePickerHeadlinePadding = null;
    private static final PaddingValues DateRangePickerTitlePadding = null;
    private static final float HeaderHeightOffset = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DateRangePickerState $state;

        public AnonymousClass5(DateRangePickerState r1, DatePickerColors r2) {
            this.$state = r1;
            this.$colors = r2;
        }

        public static /* synthetic */ Unit a(DateRangePickerState r0, DisplayMode r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(DateRangePickerState r0, DisplayMode r1) {
            r0.mo2609setDisplayModevCnGnXg(r1.m2629unboximpl());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r8, int r9) {
            if ((r9 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r8.shouldExecute(r0, r9 & 1) == true) goto L9;
            r8.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1343236786, r9, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:139)");
        L11:
            Modifier r1 = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int r2 = this.$state.mo2608getDisplayModejFl4v0();
            boolean r10 = r8.changed(this.$state);
            final DateRangePickerState r3 = this.$state;
            Object r4 = r8.rememberedValue();
            if (r10 == false) goto L14;
        L15:
            r4 = new q7(r3);
            r8.updateRememberedValue(r4);
        L16:
            DatePickerKt.m2585DisplayModeToggleButtoniUJLfQg(r1, r2, (Function1) r4, this.$colors, r8, 6);
            if (ComposerKt.isTraceInProgress() == false) goto L21;
            ComposerKt.traceEventEnd();
            return;
        L21:
            return;
        L14:
            if (r4 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r0 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass6 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ FocusRequester $focusRequester;
        final /* synthetic */ DateRangePickerState $state;

        public AnonymousClass6(DateRangePickerState r1, CalendarModel r2, DatePickerFormatter r3, DatePickerColors r4, FocusRequester r5) {
            this.$state = r1;
            this.$calendarModel = r2;
            this.$dateFormatter = r3;
            this.$colors = r4;
            this.$focusRequester = r5;
        }

        public static /* synthetic */ Unit a(DateRangePickerState r0, long r1) {
            return invoke$lambda$3$lambda$2(r0, r1);
        }

        public static /* synthetic */ Unit b(DateRangePickerState r0, Long r1, Long r2) {
            return invoke$lambda$1$lambda$0(r0, r1, r2);
        }

        private static final Unit invoke$lambda$3$lambda$2(DateRangePickerState r0, long r1) {
            r0.setDisplayedMonthMillis(r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r18, int r19) {
            if ((r19 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r18.shouldExecute(r2, r19 & 1) == true) goto L9;
            r18.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(684885105, r19, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:154)");
        L11:
            Long r1 = this.$state.getSelectedStartDateMillis();
            Long r3 = this.$state.getSelectedEndDateMillis();
            long r4 = this.$state.getDisplayedMonthMillis();
            int r5 = this.$state.mo2608getDisplayModejFl4v0();
            boolean r6 = r18.changed(this.$state);
            final DateRangePickerState r7 = this.$state;
            Object r8 = r18.rememberedValue();
            if (r6 == false) goto L14;
        L15:
            r8 = new r7(r7);
            r18.updateRememberedValue(r8);
        L16:
            Function2 r9 = (Function2) r8;
            boolean r10 = r18.changed(this.$state);
            final DateRangePickerState r11 = this.$state;
            Object r12 = r18.rememberedValue();
            if (r10 == false) goto L19;
        L20:
            r12 = new s7(r11);
            r18.updateRememberedValue(r12);
        L21:
            DateRangePickerKt.m2604access$SwitchableDateEntryContenteVtQiho(r1, r3, r4, r5, r9, (Function1) r12, this.$calendarModel, this.$state.getYearRange(), this.$dateFormatter, this.$state.getSelectableDates(), this.$colors, this.$focusRequester, r18, 0, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventEnd();
            return;
        L26:
            return;
        L19:
            if (r12 != Composer.Companion.getEmpty()) goto L21;
        L14:
            if (r8 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$1$lambda$0(DateRangePickerState r0, Long r1, Long r2) {
            r0.setSelection(r1, r2);     // Catch: IllegalArgumentException -> L5
        L4:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ Long $selectedEndDateMillis;
        final /* synthetic */ Long $selectedStartDateMillis;
        final /* synthetic */ CalendarDate $today;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Long r1, Long r2, Function2<? super Long, ? super Long, Unit> r3, LazyListState r4, IntRange r5, CalendarModel r6, CalendarMonth r7, DatePickerFormatter r8, DatePickerColors r9, CalendarDate r10, SelectableDates r11) {
            this.$selectedStartDateMillis = r1;
            this.$selectedEndDateMillis = r2;
            this.$onDatesSelectionChange = r3;
            this.$lazyListState = r4;
            this.$yearRange = r5;
            this.$calendarModel = r6;
            this.$firstMonth = r7;
            this.$dateFormatter = r8;
            this.$colors = r9;
            this.$today = r10;
            this.$selectableDates = r11;
        }

        public static /* synthetic */ float a() {
            return invoke$lambda$5$lambda$4$lambda$3();
        }

        public static /* synthetic */ Unit b(IntRange r0, CalendarModel r1, CalendarMonth r2, Long r3, Long r4, Function1 r5, CalendarDate r6, DatePickerFormatter r7, SelectableDates r8, DatePickerColors r9, List r10, LazyListScope r11) {
            return invoke$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        public static /* synthetic */ Unit c(SemanticsPropertyReceiver r0) {
            return invoke$lambda$5$lambda$4(r0);
        }

        public static /* synthetic */ float d() {
            return invoke$lambda$5$lambda$4$lambda$2();
        }

        public static /* synthetic */ Unit e(Long r0, Long r1, Function2 r2, long r3) {
            return invoke$lambda$1$lambda$0(r0, r1, r2, r3);
        }

        private static final float invoke$lambda$5$lambda$4$lambda$2() {
            return MenuKt.ClosedAlphaTarget;
        }

        private static final float invoke$lambda$5$lambda$4$lambda$3() {
            return MenuKt.ClosedAlphaTarget;
        }

        private static final Unit invoke$lambda$5$lambda$4(SemanticsPropertyReceiver r7) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(r7, new ScrollAxisRange(new w7(), new x7(), false, 4, null));
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r28, int r29) {
            if ((r29 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r28.shouldExecute(r2, r29 & 1) == true) goto L9;
            r28.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1090773432, r29, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:822)");
        L11:
            Object r1 = r28.rememberedValue();
            Composer.Companion r3 = Composer.Companion;
            if (r1 != r3.getEmpty()) goto L14;
            r1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r28);
            r28.updateRememberedValue(r1);
        L14:
            CoroutineScope r4 = (CoroutineScope) r1;
            String r5 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911746), r28, 0);
            String r6 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911745), r28, 0);
            boolean r7 = (r28.changed(this.$selectedStartDateMillis) | r28.changed(this.$selectedEndDateMillis)) | r28.changed(this.$onDatesSelectionChange);
            final Long r8 = this.$selectedStartDateMillis;
            final Long r9 = this.$selectedEndDateMillis;
            final Function2<Long, Long, Unit> r10 = this.$onDatesSelectionChange;
            Object r12 = r28.rememberedValue();
            if (r7 == false) goto L17;
        L18:
            r12 = new t7(r8, r9, r10);
            r28.updateRememberedValue(r12);
        L19:
            final Function1 r11 = (Function1) r12;
            final List r13 = DateRangePickerKt.access$customScrollActions(this.$lazyListState, r4, r5, r6);
            Modifier.Companion r14 = Modifier.Companion;
            Object r15 = r28.rememberedValue();
            if (r15 != r3.getEmpty()) goto L22;
            r15 = new u7();
            r28.updateRememberedValue(r15);
        L22:
            Modifier r16 = SemanticsModifierKt.semantics$default(r14, false, (Function1) r15, 1, null);
            LazyListState r17 = this.$lazyListState;
            boolean r18 = (((((((((r28.changedInstance(this.$yearRange) | r28.changedInstance(this.$calendarModel)) | r28.changed(this.$firstMonth)) | r28.changedInstance(this.$dateFormatter)) | r28.changedInstance(r13)) | r28.changed(this.$colors)) | r28.changed(this.$selectedStartDateMillis)) | r28.changed(this.$selectedEndDateMillis)) | r28.changed(r11)) | r28.changed(this.$today)) | r28.changed(this.$selectableDates);
            final IntRange r19 = this.$yearRange;
            final CalendarModel r110 = this.$calendarModel;
            final CalendarMonth r111 = this.$firstMonth;
            final Long r112 = this.$selectedStartDateMillis;
            final Long r20 = this.$selectedEndDateMillis;
            final CalendarDate r21 = this.$today;
            final DatePickerFormatter r22 = this.$dateFormatter;
            final SelectableDates r23 = this.$selectableDates;
            final DatePickerColors r24 = this.$colors;
            Object r0 = r28.rememberedValue();
            if (r18 == false) goto L25;
        L26:
            r0 = new v7(r19, r110, r111, r112, r20, r11, r21, r22, r23, r24, r13);
            r28.updateRememberedValue(r0);
        L27:
            LazyDslKt.LazyColumn(r16, r17, null, false, null, null, null, false, null, (Function1) r0, r28, 0, 508);
            if (ComposerKt.isTraceInProgress() == false) goto L32;
            ComposerKt.traceEventEnd();
            return;
        L32:
            return;
        L25:
            if (r0 != r3.getEmpty()) goto L27;
        L17:
            if (r12 != r3.getEmpty()) goto L19;
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$1$lambda$0(Long r0, Long r1, Function2 r2, long r3) {
            DateRangePickerKt.access$updateDateSelection(r3, r0, r1, r2);
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$7$lambda$6(IntRange r15, final CalendarModel r16, final CalendarMonth r17, final Long r18, final Long r19, final Function1 r20, final CalendarDate r21, final DatePickerFormatter r22, final SelectableDates r23, final DatePickerColors r24, final List r25, LazyListScope r26) {
            LazyListScope.CC.items$default(r26, DatePickerKt.numberOfMonthsInRange(r15), null, null, ComposableLambdaKt.composableLambdaInstance(682334170, true, new DateRangePickerKt$VerticalMonthsList$1$2$1$1(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)), 6, null);
            return Unit.INSTANCE;
        }
    }

    private static final Unit DateRangePicker$lambda$3(DateRangePickerState r12, Modifier r13, DatePickerFormatter r14, DatePickerColors r15, Function2 r16, Function2 r17, boolean r18, FocusRequester r19, int r20, int r21, Composer r22, int r23) {
        DateRangePicker(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit DateRangePickerContent$lambda$12(Long r14, Long r15, long r16, Function2 r18, Function1 r19, CalendarModel r20, IntRange r21, DatePickerFormatter r22, SelectableDates r23, DatePickerColors r24, int r25, Composer r26, int r27) {
        DateRangePickerContent(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r26, RecomposeScopeImplKt.updateChangedFlags(r25 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SwitchableDateEntryContent_eVtQiho$lambda$9(Long r17, Long r18, long r19, int r21, Function2 r22, Function1 r23, CalendarModel r24, IntRange r25, DatePickerFormatter r26, SelectableDates r27, DatePickerColors r28, FocusRequester r29, int r30, int r31, Composer r32, int r33) {
        m2603SwitchableDateEntryContenteVtQiho(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31));
        return Unit.INSTANCE;
    }

    private static final Unit VerticalMonthsList$lambda$15(LazyListState r13, Long r14, Long r15, Function2 r16, Function1 r17, CalendarModel r18, IntRange r19, DatePickerFormatter r20, SelectableDates r21, DatePickerColors r22, int r23, Composer r24, int r25) {
        VerticalMonthsList(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, RecomposeScopeImplKt.updateChangedFlags(r23 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Long r1, Long r2, long r3, int r5, Function2 r6, Function1 r7, CalendarModel r8, IntRange r9, DatePickerFormatter r10, SelectableDates r11, DatePickerColors r12, FocusRequester r13, int r14, int r15, Composer r16, int r17) {
        return SwitchableDateEntryContent_eVtQiho$lambda$9(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ boolean b(LazyListState r0, CoroutineScope r1) {
        return customScrollActions$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit c(SemanticsPropertyReceiver r0) {
        return SwitchableDateEntryContent_eVtQiho$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit d(DateRangePickerState r0, Modifier r1, DatePickerFormatter r2, DatePickerColors r3, Function2 r4, Function2 r5, boolean r6, FocusRequester r7, int r8, int r9, Composer r10, int r11) {
        return DateRangePicker$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit e(LazyListState r0, Long r1, Long r2, Function2 r3, Function1 r4, CalendarModel r5, IntRange r6, DatePickerFormatter r7, SelectableDates r8, DatePickerColors r9, int r10, Composer r11, int r12) {
        return VerticalMonthsList$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ DateRangePickerStateImpl f(Long r0, Long r1, Long r2, IntRange r3, int r4, SelectableDates r5, Locale r6) {
        return rememberDateRangePickerState_IlFM19s$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ boolean g(LazyListState r0, CoroutineScope r1) {
        return customScrollActions$lambda$16(r0, r1);
    }

    public static /* synthetic */ Unit h(Long r0, Long r1, long r2, Function2 r4, Function1 r5, CalendarModel r6, IntRange r7, DatePickerFormatter r8, SelectableDates r9, DatePickerColors r10, int r11, Composer r12, int r13) {
        return DateRangePickerContent$lambda$12(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    static {
        CalendarMonthSubheadPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(24), Dp.constructor-impl(20), MenuKt.ClosedAlphaTarget, Dp.constructor-impl(8), 4, null);
        float r0 = 64;
        float r7 = 12;
        DateRangePickerTitlePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(r0), MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r7), MenuKt.ClosedAlphaTarget, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(r0), MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r7), Dp.constructor-impl(r7), 2, null);
        HeaderHeightOffset = Dp.constructor-impl(60);
    }

    public static final /* synthetic */ PaddingValues access$getDateRangePickerHeadlinePadding$p() {
        return DateRangePickerHeadlinePadding;
    }

    public static final /* synthetic */ PaddingValues access$getDateRangePickerTitlePadding$p() {
        return DateRangePickerTitlePadding;
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    private static final Unit SwitchableDateEntryContent_eVtQiho$lambda$8$lambda$7(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContainer(r1, true);
        return Unit.INSTANCE;
    }

    private static final boolean customScrollActions$lambda$16(LazyListState r6, CoroutineScope r7) {
        if (r6.getCanScrollBackward() == true) goto L5;
        return false;
    L5:
        BuildersKt.launch$default(r7, null, null, new DateRangePickerKt$customScrollActions$scrollUpAction$1$1(r6, null), 3, null);
        return true;
    }

    private static final boolean customScrollActions$lambda$17(LazyListState r6, CoroutineScope r7) {
        if (r6.getCanScrollForward() == true) goto L5;
        return false;
    L5:
        BuildersKt.launch$default(r7, null, null, new DateRangePickerKt$customScrollActions$scrollDownAction$1$1(r6, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m2605drawRangeBackgroundmxwnekA(ContentDrawScope r30, SelectedRangeInfo r31, long r32) {
        float r0 = r30.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r14 = r30.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r15 = r30.toPx-0680j_4(DatePickerModalTokens.INSTANCE.getDateStateLayerHeight-D9Ej5fM());
        float r2 = 2;
        float r1 = (r14 - r15) / r2;
        float r4 = 7;
        float r3 = (Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32)) - (r4 * r0)) / r4;
        long r5 = r31.m3113getGridStartCoordinatesnOccac();
        int r6 = IntOffset.getX-impl(r5);
        int r12 = IntOffset.getY-impl(r5);
        long r7 = r31.m3112getGridEndCoordinatesnOccac();
        int r8 = IntOffset.getX-impl(r7);
        int r11 = IntOffset.getY-impl(r7);
        float r9 = r0 + r3;
        float r10 = r6 * r9;
        boolean r13 = r31.getFirstIsSelectionStart();
        float r17 = MenuKt.ClosedAlphaTarget;
        if (r13 == false) goto L5;
        float r16 = r0 / r2;
    L6:
        float r18 = r3 / r2;
        float r19 = (r10 + r16) + r18;
        float r110 = (r12 * r14) + r1;
        float r20 = r8 * r9;
        if (r31.getLastIsSelectionEnd() == false) goto L9;
        r0 = r0 / r2;
    L9:
        float r21 = (r20 + r0) + r18;
        float r111 = (r11 * r14) + r1;
        if (r30.getLayoutDirection() != LayoutDirection.Rtl) goto L12;
        boolean r22 = true;
    L13:
        if (r22 == false) goto L15;
        r19 = Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32)) - r19;
        r21 = Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32)) - r21;
    L15:
        float r23 = r21;
        long r24 = Offset.constructor-impl((Float.floatToRawIntBits(r19) << 32) | (((long) Float.floatToRawIntBits(r110)) & 4294967295L));
        if (r12 != r11) goto L18;
        float r25 = r23 - r19;
    L21:
        DrawScope.-CC.drawRect-n-J9OG0$default(r30, r32, r24, Size.constructor-impl((Float.floatToRawIntBits(r25) << 32) | (((long) Float.floatToRawIntBits(r15)) & 4294967295L)), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        if (r12 == r11) goto L36;
        int r112 = (r11 - r12) - 1;
    L24:
        if (r112 <= 0) goto L27;
        DrawScope.-CC.drawRect-n-J9OG0$default(r30, r32, Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (Float.floatToRawIntBits(r110 + (r112 * r14)) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32))) << 32) | (((long) Float.floatToRawIntBits(r15)) & 4294967295L)), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        r112 = r112 - 1;
        goto L24
    L27:
        if (r30.getLayoutDirection() == LayoutDirection.Ltr) goto L30;
        r17 = Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32));
    L30:
        long r26 = Offset.constructor-impl((Float.floatToRawIntBits(r17) << 32) | (((long) Float.floatToRawIntBits(r111)) & 4294967295L));
        if (r22 == false) goto L33;
        r23 = r23 - Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32));
    L33:
        DrawScope.-CC.drawRect-n-J9OG0$default(r30, r32, r26, Size.constructor-impl((Float.floatToRawIntBits(r23) << 32) | (((long) Float.floatToRawIntBits(r15)) & 4294967295L)), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        return;
    L36:
        return;
    L18:
        if (r22 == false) goto L20;
        r25 = -r19;
        goto L21
    L20:
        r25 = Float.intBitsToFloat((int) (r30.getSize-NH-jbRc() >> 32)) - r19;
        goto L21
    L12:
        r22 = false;
        goto L13
    L5:
        r16 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    public static final /* synthetic */ List access$customScrollActions(LazyListState r0, CoroutineScope r1, String r2, String r3) {
        return customScrollActions(r0, r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateDateSelection(long r0, Long r2, Long r3, Function2 r4) {
        updateDateSelection(r0, r2, r3, r4);
    }

    private static final List<CustomAccessibilityAction> customScrollActions(final LazyListState r2, final CoroutineScope r3, String r4, String r5) {
        return CollectionsKt.listOf(new CustomAccessibilityAction[]{new CustomAccessibilityAction(r4, new j7(r2, r3)), new CustomAccessibilityAction(r5, new k7(r2, r3))});
    }

    private static final void updateDateSelection(long r3, Long r5, Long r6, Function2<? super Long, ? super Long, Unit> r7) {
        if (r5 != null) goto L5;
        if (r6 != null) goto L5;
    L7:
        r7.invoke(Long.valueOf(r3), null);
        return;
    L5:
        if (r5 == null) goto L8;
        if (r6 != null) goto L7;
    L8:
        if (r5 != null) goto L10;
    L12:
        r7.invoke(Long.valueOf(r3), null);
        return;
    L10:
        if (r3 < r5.longValue()) goto L12;
        r7.invoke(r5, Long.valueOf(r3));
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m2601DateRangePickerStateHVP43zI(Locale r10, Long r11, Long r12, Long r13, IntRange r14, int r15, SelectableDates r16) {
        return new DateRangePickerStateImpl(r11, r12, r13, r14, r15, r16, r10, null);
    }

    private static final DateRangePickerStateImpl rememberDateRangePickerState_IlFM19s$lambda$5$lambda$4(Long r10, Long r11, Long r12, IntRange r13, int r14, SelectableDates r15, Locale r16) {
        return new DateRangePickerStateImpl(r10, r11, r12, r13, r14, r15, r16, null);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m2602DateRangePickerStateHVP43zI$default(Locale r1, Long r2, Long r3, Long r4, IntRange r5, int r6, SelectableDates r7, int r8, Object r9) {
        if ((r8 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r4 = r2;
    L12:
        if ((r8 & 16) == 0) goto L15;
        r5 = DatePickerDefaults.INSTANCE.getYearRange();
    L15:
        if ((r8 & 32) == 0) goto L18;
        r6 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L18:
        if ((r8 & 64) == 0) goto L21;
        r7 = DatePickerDefaults.INSTANCE.getAllDates();
    L21:
        return m2601DateRangePickerStateHVP43zI(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m2606rememberDateRangePickerStateIlFM19s(Long r16, Long r17, Long r18, IntRange r19, int r20, SelectableDates r21, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        final Long r5 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        final Long r6 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        final Long r7 = r5;
    L15:
        if ((r24 & 8) == 0) goto L17;
        final IntRange r8 = DatePickerDefaults.INSTANCE.getYearRange();
    L19:
        if ((r24 & 16) == 0) goto L21;
        final int r9 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L23:
        if ((r24 & 32) == 0) goto L25;
        SelectableDates r3 = DatePickerDefaults.INSTANCE.getAllDates();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-2012087461, r23, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:283)");
    L29:
        final Locale r11 = CalendarLocale_androidKt.defaultLocale(r22, 0);
        Object[] r13 = new Object[0];
        Saver<DateRangePickerStateImpl, Object> r14 = DateRangePickerStateImpl.Companion.Saver(r3, r11);
        if (((r23 & 14) ^ 6) <= 4) goto L34;
        if (r22.changed(r5) == false) goto L34;
    L35:
        boolean r4 = true;
    L38:
        if (((r23 & 112) ^ 48) <= 32) goto L42;
        if (r22.changed(r6) == false) goto L42;
    L43:
        boolean r2 = true;
    L45:
        boolean r10 = r2 | r4;
        if (((r23 & 896) ^ 384) <= 256) goto L50;
        if (r22.changed(r7) == false) goto L50;
    L51:
        boolean r12 = true;
    L53:
        boolean r15 = (r10 | r12) | r22.changedInstance(r8);
        if (((57344 & r23) ^ 24576) <= 16384) goto L58;
        if (r22.changed(r9) == false) goto L58;
    L59:
        boolean r25 = true;
    L61:
        boolean r26 = r15 | r25;
        if (((458752 & r23) ^ 196608) <= 131072) goto L66;
        if (r22.changed(r3) == false) goto L66;
    L67:
        boolean r110 = true;
    L69:
        boolean r1 = (r26 | r110) | r22.changedInstance(r11);
        Object r27 = r22.rememberedValue();
        if (r1 == false) goto L72;
    L73:
        final SelectableDates r111 = r3;
        r27 = new i7(r5, r6, r7, r8, r9, r111, r11);
        r22.updateRememberedValue(r27);
    L74:
        DateRangePickerStateImpl r0 = (DateRangePickerStateImpl) RememberSaveableKt.rememberSaveable(r13, r14, (Function0) r27, r22, 0);
        r0.setSelectableDates(r3);
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
    L77:
        return r0;
    L72:
        if (r27 != Composer.Companion.getEmpty()) goto L74;
    L66:
        if ((r23 & 196608) == 131072) goto L67;
        r110 = false;
    L58:
        if ((r23 & 24576) == 16384) goto L59;
        r25 = false;
    L50:
        if ((r23 & 384) == 256) goto L51;
        r12 = false;
    L42:
        if ((r23 & 48) == 32) goto L43;
        r2 = false;
    L34:
        if ((r23 & 6) == 4) goto L35;
        r4 = false;
        goto L38
    L25:
        r3 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void DateRangePicker(final DateRangePickerState r26, Modifier r27, DatePickerFormatter r28, DatePickerColors r29, Function2<? super Composer, ? super Integer, Unit> r30, Function2<? super Composer, ? super Integer, Unit> r31, boolean r32, FocusRequester r33, Composer r34, final int r35, final int r36) {
        Composer r3 = r34.startRestartGroup(1969726368);
        if ((r36 & 1) == 0) goto L6;
        int r4 = r35 | 6;
    L13:
        int r5 = r36 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L25:
        if ((r35 & 384) != 0) goto L37;
        if ((r36 & 4) == 0) goto L29;
    L34:
        int r7 = 128;
    L35:
        r4 = r4 | r7;
        goto L37
    L29:
        if ((r35 & 512) != 0) goto L31;
        boolean r8 = r3.changed(r28);
    L32:
        if (r8 == false) goto L34;
        r7 = 256;
        goto L35
    L31:
        r8 = r3.changedInstance(r28);
    L37:
        if ((r35 & 3072) != 0) goto L47;
        if ((r36 & 8) != 0) goto L44;
        if (r3.changed(r29) == false) goto L44;
        int r9 = 2048;
    L45:
        r4 = r4 | r9;
    L44:
        r9 = 1024;
    L47:
        int r10 = r36 & 16;
        if (r10 == 0) goto L51;
        r4 = r4 | 24576;
    L57:
        Function2<? super Composer, ? super Integer, Unit> r11 = r30;
    L58:
        int r12 = r36 & 32;
        if (r12 == 0) goto L62;
        r4 = r4 | 196608;
    L68:
        Function2<? super Composer, ? super Integer, Unit> r13 = r31;
    L69:
        int r14 = r36 & 64;
        if (r14 == 0) goto L73;
        r4 = r4 | 1572864;
    L79:
        boolean r15 = r32;
    L80:
        int r2 = r36 & 128;
        if (r2 == 0) goto L84;
        r4 = r4 | 12582912;
    L91:
        if ((r4 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L157;
        r3.startDefaults();
        if ((r35 & 1) != 0) goto L99;
    L109:
        if (r5 == 0) goto L111;
        Modifier r1 = Modifier.Companion;
    L113:
        if ((r36 & 4) == 0) goto L118;
        Object r6 = r3.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L117;
        r6 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
        r3.updateRememberedValue(r6);
    L117:
        final DatePickerFormatter r16 = (DatePickerFormatter) r6;
        r4 = r4 & (-897);
    L120:
        if ((r36 & 8) == 0) goto L122;
        final DatePickerColors r17 = DatePickerDefaults.INSTANCE.colors(r3, 6);
        r4 = r4 & (-7169);
    L123:
        if (r10 == 0) goto L125;
        boolean r18 = true;
        int r19 = 54;
        Function2<? super Composer, ? super Integer, Unit> r20 = ComposableLambdaKt.rememberComposableLambda(-803011924, true, new AnonymousClass2(r26, r17), r3, 54);
    L126:
        if (r12 == 0) goto L128;
        Function2<? super Composer, ? super Integer, Unit> r110 = ComposableLambdaKt.rememberComposableLambda(-331385278, r18, new AnonymousClass3(r26, r16, r17), r3, r19);
    L129:
        if (r14 == 0) goto L131;
        r15 = true;
    L131:
        if (r2 == 0) goto L136;
        Object r21 = r3.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L135;
        r21 = new FocusRequester();
        r3.updateRememberedValue(r21);
    L135:
        FocusRequester r22 = (FocusRequester) r21;
        Function2<? super Composer, ? super Integer, Unit> r23 = r110;
        Modifier r24 = r1;
    L108:
        int r111 = r4;
        boolean r25 = r15;
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(1969726368, r111, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
    L140:
        boolean r112 = r3.changed(r26.getLocale());
        Object r113 = r3.rememberedValue();
        if (r112 == true) goto L145;
        if (r113 == Composer.Companion.getEmpty()) goto L145;
    L149:
        CalendarModel r114 = (CalendarModel) r113;
        if (r25 == false) goto L152;
        r3.startReplaceGroup(-2018438858);
        Function2 r115 = ComposableLambdaKt.rememberComposableLambda(1343236786, true, new AnonymousClass5(r26, r17), r3, 54);
        r3.endReplaceGroup();
        Function2 r116 = r115;
    L153:
        DatePickerModalTokens r37 = DatePickerModalTokens.INSTANCE;
        TextStyle r117 = TypographyKt.getValue(r37.getRangeSelectionHeaderHeadlineFont(), r3, 6);
        float r118 = Dp.constructor-impl(r37.getRangeSelectionHeaderContainerHeight-D9Ej5fM() - HeaderHeightOffset);
        ComposableLambda r119 = ComposableLambdaKt.rememberComposableLambda(684885105, true, new AnonymousClass6(r26, r114, r16, r17, r22), r3, 54);
        int r120 = r111 >> 9;
        DatePickerKt.m2581DateEntryContainerau3_HiA(r24, r20, r23, r116, r17, r117, r118, r119, r3, (((((r111 >> 3) & 14) | 14155776) | (r120 & 112)) | (r120 & 896)) | ((r111 << 3) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        FocusRequester r121 = r22;
        final Function2<? super Composer, ? super Integer, Unit> r38 = r23;
        final Modifier r39 = r24;
        DatePickerColors r210 = r17;
        final boolean r40 = r25;
        final DatePickerColors r41 = r210;
    L158:
        ScopeUpdateScope r122 = r3.endRestartGroup();
        if (r122 == null) goto L162;
        final DatePickerFormatter r42 = r16;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r20;
        final FocusRequester r44 = r121;
        r122.updateScope(new p7(r26, r39, r42, r41, r43, r38, r40, r44, r35, r36));
        return;
    L162:
        return;
    L152:
        r3.startReplaceGroup(-2018051234);
        r3.endReplaceGroup();
        r116 = null;
    L145:
        if ((r26 instanceof BaseDatePickerStateImpl) == false) goto L147;
        CalendarModel r123 = ((BaseDatePickerStateImpl) r26).getCalendarModel();
    L148:
        r113 = r123;
        r3.updateRememberedValue(r113);
        goto L149
    L147:
        r123 = CalendarModel_androidKt.createCalendarModel(r26.getLocale());
        goto L148
    L136:
        r24 = r1;
        r22 = r33;
        r23 = r110;
        goto L108
    L128:
        r110 = r13;
        goto L129
    L125:
        r18 = true;
        r19 = 54;
        r20 = r11;
        goto L126
    L122:
        r17 = r29;
        goto L123
    L118:
        r16 = r28;
        goto L120
    L111:
        r1 = r27;
        goto L113
    L99:
        if (r3.getDefaultsInvalid() == true) goto L109;
        r3.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L105;
        r4 = r4 & (-897);
    L105:
        if ((r36 & 8) == 0) goto L107;
        r4 = r4 & (-7169);
    L107:
        r24 = r27;
        r16 = r28;
        r17 = r29;
        r22 = r33;
        r20 = r11;
        r23 = r13;
        goto L108
    L157:
        r3.skipToGroupEnd();
        r39 = r27;
        r16 = r28;
        r41 = r29;
        r20 = r11;
        r38 = r13;
        r40 = r15;
        r121 = r33;
        goto L158
    L93:
        r0 = false;
        goto L95
    L84:
        if ((r35 & 12582912) != 0) goto L91;
        if (r3.changed(r33) == false) goto L88;
        int r124 = 8388608;
    L89:
        r4 = r4 | r124;
        goto L91
    L88:
        r124 = 4194304;
        goto L89
    L73:
        if ((1572864 & r35) != 0) goto L79;
        r15 = r32;
        if (r3.changed(r15) == false) goto L77;
        int r125 = 1048576;
    L78:
        r4 = r4 | r125;
        goto L80
    L77:
        r125 = 524288;
        goto L78
    L62:
        if ((196608 & r35) != 0) goto L68;
        r13 = r31;
        if (r3.changedInstance(r13) == false) goto L66;
        int r126 = 131072;
    L67:
        r4 = r4 | r126;
        goto L69
    L66:
        r126 = 65536;
        goto L67
    L51:
        if ((r35 & 24576) != 0) goto L57;
        r11 = r30;
        if (r3.changedInstance(r11) == false) goto L55;
        int r127 = 16384;
    L56:
        r4 = r4 | r127;
        goto L58
    L55:
        r127 = 8192;
        goto L56
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r3.changed(r27) == false) goto L21;
        int r45 = 32;
    L22:
        r4 = r4 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r4 = r35;
        goto L13
    L8:
        if (r3.changed(r26) == false) goto L10;
        int r46 = 4;
    L11:
        r4 = r46 | r35;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    private static final void DateRangePickerContent(final Long r17, final Long r18, final long r19, final Function2<? super Long, ? super Long, Unit> r21, final Function1<? super Long, Unit> r22, final CalendarModel r23, final IntRange r24, final DatePickerFormatter r25, final SelectableDates r26, final DatePickerColors r27, Composer r28, final int r29) {
        Composer r13 = r28.startRestartGroup(-787063721);
        if ((r29 & 6) == 0) goto L5;
        int r6 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r13.changed(r18) == false) goto L15;
        int r8 = 32;
    L16:
        r6 = r6 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r13.changed(r19) == false) goto L22;
        int r9 = 256;
    L23:
        r6 = r6 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r13.changedInstance(r21) == false) goto L29;
        int r10 = 2048;
    L30:
        r6 = r6 | r10;
        goto L32
    L29:
        r10 = 1024;
    L32:
        if ((r29 & 24576) != 0) goto L39;
        if (r13.changedInstance(r22) == false) goto L36;
        int r11 = 16384;
    L37:
        r6 = r6 | r11;
        goto L39
    L36:
        r11 = 8192;
    L39:
        if ((196608 & r29) != 0) goto L46;
        if (r13.changedInstance(r23) == false) goto L43;
        int r12 = 131072;
    L44:
        r6 = r6 | r12;
        goto L46
    L43:
        r12 = 65536;
    L46:
        if ((1572864 & r29) != 0) goto L53;
        if (r13.changedInstance(r24) == false) goto L50;
        int r14 = 1048576;
    L51:
        r6 = r6 | r14;
        goto L53
    L50:
        r14 = 524288;
    L53:
        if ((12582912 & r29) != 0) goto L63;
        if ((16777216 & r29) != 0) goto L57;
        boolean r15 = r13.changed(r25);
    L58:
        if (r15 == false) goto L60;
        int r16 = 8388608;
    L61:
        r6 = r6 | r16;
        goto L63
    L60:
        r16 = 4194304;
        goto L61
    L57:
        r15 = r13.changedInstance(r25);
    L63:
        if ((100663296 & r29) != 0) goto L71;
        if (r13.changed(r26) == false) goto L67;
        int r110 = 67108864;
    L68:
        r6 = r6 | r110;
        goto L71
    L67:
        r110 = 33554432;
    L71:
        if ((r29 & 805306368) != 0) goto L78;
        if (r13.changed(r27) == false) goto L75;
        int r111 = 536870912;
    L76:
        r6 = r6 | r111;
        goto L78
    L75:
        r111 = 268435456;
    L78:
        if ((r6 & 306783379) == 306783378) goto L80;
        boolean r5 = true;
    L82:
        if (r13.shouldExecute(r5, r6 & 1) == true) goto L84;
        Composer r0 = r13;
        r0.skipToGroupEnd();
    L107:
        ScopeUpdateScope r112 = r0.endRestartGroup();
        if (r112 == null) goto L111;
        r112.updateScope(new o7(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r29));
        return;
    L111:
        return;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(-787063721, r6, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:764)");
    L86:
        int r1 = RangesKt.coerceAtLeast(r23.getMonth(r19).indexIn(r24), 0);
        LazyListState r2 = LazyListStateKt.rememberLazyListState(r1, 0, r13, 0, 2);
        Integer r7 = Integer.valueOf(r1);
        boolean r20 = r13.changed(r2) | r13.changed(r1);
        Object r3 = r13.rememberedValue();
        if (r20 == false) goto L89;
    L90:
        r3 = new DateRangePickerKt$DateRangePickerContent$1$1(r2, r1, null);
        r13.updateRememberedValue(r3);
    L91:
        EffectsKt.LaunchedEffect(r7, (Function2) r3, r13, 0);
        Modifier r4 = PaddingKt.m962paddingVpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r30 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r13, 0);
        int r31 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r32 = r13.getCurrentCompositionLocalMap();
        Modifier r33 = ComposedModifierKt.materializeModifier(r13, r4);
        ComposeUiNode.Companion r34 = ComposeUiNode.Companion;
        Function0 r35 = r34.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L94;
        ComposablesKt.invalidApplier();
    L94:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L97;
        r13.createNode(r35);
    L98:
        Composer r36 = Updater.constructor-impl(r13);
        Updater.set-impl(r36, r30, r34.getSetMeasurePolicy());
        Updater.set-impl(r36, r32, r34.getSetResolvedCompositionLocals());
        Function2 r37 = r34.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L101;
    L102:
        r36.updateRememberedValue(Integer.valueOf(r31));
        r36.apply(Integer.valueOf(r31), r37);
    L103:
        Updater.set-impl(r36, r33, r34.getSetModifier());
        ColumnScopeInstance r38 = ColumnScopeInstance.INSTANCE;
        DatePickerKt.WeekDays(r27, r23, r13, ((r6 >> 27) & 14) | ((r6 >> 12) & 112));
        int r39 = r6 << 3;
        int r40 = r39 & 112;
        int r113 = ((((((((r39 & 896) | r40) | (r6 & 7168)) | (57344 & r6)) | (458752 & r6)) | (3670016 & r6)) | (29360128 & r6)) | (234881024 & r6)) | (1879048192 & r6);
        r0 = r13;
        VerticalMonthsList(r2, r17, r18, r21, r22, r23, r24, r25, r26, r27, r0, r113);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventEnd();
        goto L107
    L101:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r31)) == true) goto L103;
    L97:
        r13.useNode();
        goto L98
    L89:
        if (r3 != Composer.Companion.getEmpty()) goto L91;
    L80:
        r5 = false;
        goto L82
    L5:
        if (r13.changed(r17) == false) goto L7;
        int r41 = 4;
    L8:
        r6 = r41 | r29;
        goto L11
    L7:
        r41 = 2;
        goto L8
    }

    private static final void VerticalMonthsList(final LazyListState r22, final Long r23, final Long r24, final Function2<? super Long, ? super Long, Unit> r25, final Function1<? super Long, Unit> r26, final CalendarModel r27, final IntRange r28, final DatePickerFormatter r29, final SelectableDates r30, final DatePickerColors r31, Composer r32, final int r33) {
        Composer r10 = r32.startRestartGroup(1257365001);
        if ((r33 & 6) == 0) goto L5;
        int r1 = r33;
    L11:
        if ((r33 & 48) != 0) goto L18;
        if (r10.changed(r23) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r33 & 384) != 0) goto L25;
        if (r10.changed(r24) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r33 & 3072) != 0) goto L32;
        if (r10.changedInstance(r25) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r33 & 24576) != 0) goto L39;
        if (r10.changedInstance(r26) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r33) != 0) goto L46;
        if (r10.changedInstance(r27) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((1572864 & r33) != 0) goto L53;
        if (r10.changedInstance(r28) == false) goto L50;
        int r7 = 1048576;
    L51:
        r1 = r1 | r7;
        goto L53
    L50:
        r7 = 524288;
    L53:
        if ((12582912 & r33) != 0) goto L63;
        if ((16777216 & r33) != 0) goto L57;
        boolean r8 = r10.changed(r29);
    L58:
        if (r8 == false) goto L60;
        int r9 = 8388608;
    L61:
        r1 = r1 | r9;
        goto L63
    L60:
        r9 = 4194304;
        goto L61
    L57:
        r8 = r10.changedInstance(r29);
    L63:
        if ((100663296 & r33) != 0) goto L70;
        if (r10.changed(r30) == false) goto L67;
        int r11 = 67108864;
    L68:
        r1 = r1 | r11;
        goto L70
    L67:
        r11 = 33554432;
    L70:
        if ((805306368 & r33) != 0) goto L77;
        if (r10.changed(r31) == false) goto L74;
        int r16 = 536870912;
    L75:
        r1 = r1 | r16;
        goto L77
    L74:
        r16 = 268435456;
    L77:
        boolean r17 = false;
        if ((r1 & 306783379) == 306783378) goto L80;
        boolean r12 = true;
    L82:
        if (r10.shouldExecute(r12, r1 & 1) == true) goto L84;
        Composer r0 = r10;
        r0.skipToGroupEnd();
    L109:
        ScopeUpdateScope r13 = r0.endRestartGroup();
        if (r13 == null) goto L113;
        r13.updateScope(new n7(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33));
        return;
    L113:
        return;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(1257365001, r1, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:812)");
    L86:
        CalendarDate r18 = r27.getToday();
        boolean r14 = r10.changed(r28);
        Object r15 = r10.rememberedValue();
        if (r14 == false) goto L89;
    L92:
        Object r19 = r27.getMonth(r28.getFirst(), 1);
        r10.updateRememberedValue(r19);
    L93:
        CalendarMonth r20 = (CalendarMonth) r19;
        int r21 = r1;
        TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), r10, 6), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new AnonymousClass1(r23, r24, r25, r22, r28, r27, r20, r29, r31, r18, r30), r10, 54), r10, 48);
        int r34 = r21 & 14;
        if (r34 != 4) goto L96;
        boolean r35 = true;
    L98:
        if ((r21 & 57344) != 16384) goto L100;
        r17 = true;
    L100:
        boolean r36 = ((r35 | r17) | r10.changedInstance(r27)) | r10.changedInstance(r28);
        Object r37 = r10.rememberedValue();
        if (r36 == false) goto L103;
    L104:
        DateRangePickerKt$VerticalMonthsList$2$1 r38 = new DateRangePickerKt$VerticalMonthsList$2$1(r22, r26, r27, r28, null);
        r10.updateRememberedValue(r38);
        r37 = r38;
    L105:
        r0 = r10;
        EffectsKt.LaunchedEffect(r22, (Function2) r37, r0, r34);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventEnd();
        goto L109
    L103:
        if (r37 != Composer.Companion.getEmpty()) goto L105;
    L96:
        r35 = false;
        goto L98
    L89:
        if (r15 == Composer.Companion.getEmpty()) goto L92;
        r19 = r15;
        goto L93
    L80:
        r12 = false;
        goto L82
    L5:
        if (r10.changed(r22) == false) goto L7;
        int r39 = 4;
    L8:
        r1 = r39 | r33;
        goto L11
    L7:
        r39 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$DateRangePickerContent(Long r0, Long r1, long r2, Function2 r4, Function1 r5, CalendarModel r6, IntRange r7, DatePickerFormatter r8, SelectableDates r9, DatePickerColors r10, Composer r11, int r12) {
        DateRangePickerContent(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: SwitchableDateEntryContent-eVtQiho, reason: not valid java name */
    private static final void m2603SwitchableDateEntryContenteVtQiho(final Long r23, final Long r24, final long r25, final int r27, final Function2<? super Long, ? super Long, Unit> r28, final Function1<? super Long, Unit> r29, final CalendarModel r30, final IntRange r31, final DatePickerFormatter r32, final SelectableDates r33, final DatePickerColors r34, final FocusRequester r35, Composer r36, final int r37, final int r38) {
        Composer r15 = r36.startRestartGroup(621028059);
        int r2 = 4;
        if ((r37 & 6) == 0) goto L5;
        int r1 = r37;
    L10:
        int r5 = 32;
        if ((r37 & 48) != 0) goto L18;
        if (r15.changed(r24) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r37 & 384) != 0) goto L25;
        if (r15.changed(r25) == false) goto L22;
        int r6 = 256;
    L23:
        r1 = r1 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r37 & 3072) != 0) goto L32;
        if (r15.changed(r27) == false) goto L29;
        int r7 = 2048;
    L30:
        r1 = r1 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r37 & 24576) != 0) goto L39;
        if (r15.changedInstance(r28) == false) goto L36;
        int r8 = 16384;
    L37:
        r1 = r1 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((196608 & r37) != 0) goto L47;
        if (r15.changedInstance(r29) == false) goto L43;
        int r16 = 131072;
    L44:
        r1 = r1 | r16;
        goto L47
    L43:
        r16 = 65536;
    L47:
        if ((r37 & 1572864) != 0) goto L54;
        if (r15.changedInstance(r30) == false) goto L51;
        int r17 = 1048576;
    L52:
        r1 = r1 | r17;
        goto L54
    L51:
        r17 = 524288;
    L54:
        if ((r37 & 12582912) != 0) goto L61;
        if (r15.changedInstance(r31) == false) goto L58;
        int r18 = 8388608;
    L59:
        r1 = r1 | r18;
        goto L61
    L58:
        r18 = 4194304;
    L61:
        if ((r37 & 100663296) != 0) goto L71;
        if ((r37 & 134217728) != 0) goto L65;
        boolean r19 = r15.changed(r32);
    L66:
        if (r19 == false) goto L68;
        int r110 = 67108864;
    L69:
        r1 = r1 | r110;
        goto L71
    L68:
        r110 = 33554432;
        goto L69
    L65:
        r19 = r15.changedInstance(r32);
    L71:
        if ((r37 & 805306368) != 0) goto L78;
        if (r15.changed(r33) == false) goto L75;
        int r111 = 536870912;
    L76:
        r1 = r1 | r111;
        goto L78
    L75:
        r111 = 268435456;
    L78:
        if ((r38 & 6) == 0) goto L80;
        int r3 = r38;
    L86:
        if ((r38 & 48) != 0) goto L94;
        if (r15.changed(r35) == true) goto L91;
        r5 = 16;
    L91:
        r3 = r3 | r5;
    L94:
        if ((306783379 & r1) == 306783378) goto L96;
    L99:
        boolean r9 = true;
    L101:
        if (r15.shouldExecute(r9, r1 & 1) == true) goto L103;
        r15.skipToGroupEnd();
    L112:
        ScopeUpdateScope r112 = r15.endRestartGroup();
        if (r112 == null) goto L116;
        r112.updateScope(new m7(r23, r24, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38));
        return;
    L116:
        return;
    L103:
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventStart(621028059, r1, r3, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:708)");
    L105:
        FiniteAnimationSpec r113 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r15, 6);
        Modifier.Companion r10 = Modifier.Companion;
        Object r11 = r15.rememberedValue();
        if (r11 != Composer.Companion.getEmpty()) goto L108;
        r11 = new l7();
        r15.updateRememberedValue(r11);
    L108:
        Modifier r114 = SemanticsModifierKt.semantics$default(r10, false, (Function1) r11, 1, null);
        CrossfadeKt.Crossfade(DisplayMode.m2623boximpl(r27), r114, r113, null, ComposableLambdaKt.rememberComposableLambda(-773828161, true, new DateRangePickerKt$SwitchableDateEntryContent$2(r23, r24, r25, r28, r29, r30, r31, r32, r33, r34, r35), r15, 54), r15, ((r1 >> 9) & 14) | 24576, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventEnd();
        goto L112
    L96:
        if ((r3 & 19) != 18) goto L99;
        r9 = false;
        goto L101
    L80:
        if (r15.changed(r34) == true) goto L83;
        r2 = 2;
    L83:
        r3 = r38 | r2;
        goto L86
    L5:
        if (r15.changed(r23) == false) goto L7;
        int r12 = 4;
    L8:
        r1 = r12 | r37;
        goto L10
    L7:
        r12 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$SwitchableDateEntryContent-eVtQiho, reason: not valid java name */
    public static final /* synthetic */ void m2604access$SwitchableDateEntryContenteVtQiho(Long r0, Long r1, long r2, int r4, Function2 r5, Function1 r6, CalendarModel r7, IntRange r8, DatePickerFormatter r9, SelectableDates r10, DatePickerColors r11, FocusRequester r12, Composer r13, int r14, int r15) {
        m2603SwitchableDateEntryContenteVtQiho(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }
}
