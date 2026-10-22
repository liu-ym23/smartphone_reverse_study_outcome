package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010(R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DateRangePickerState;", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_selectedStartDate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "_selectedEndDate", "selectedStartDateMillis", "getSelectedStartDateMillis", "()Ljava/lang/Long;", "selectedEndDateMillis", "getSelectedEndDateMillis", "_displayMode", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "setSelection", "", "startDateMillis", "endDateMillis", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getDate", "dateMillis", "(Ljava/lang/Long;)Landroidx/compose/material3/internal/CalendarDate;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DateRangePickerStateImpl extends BaseDatePickerStateImpl implements DateRangePickerState {
    public static final Companion Companion = null;
    private MutableState<DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedEndDate;
    private MutableState<CalendarDate> _selectedStartDate;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DateRangePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r0, DateRangePickerStateImpl r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ DateRangePickerStateImpl b(SelectableDates r0, Locale r1, List r2) {
            return Saver$lambda$1(r0, r1, r2);
        }

        private static final List Saver$lambda$0(SaverScope r2, DateRangePickerStateImpl r3) {
            return CollectionsKt.listOf(new Object[]{r3.getSelectedStartDateMillis(), r3.getSelectedEndDateMillis(), Long.valueOf(r3.getDisplayedMonthMillis()), Integer.valueOf(r3.getYearRange().getFirst()), Integer.valueOf(r3.getYearRange().getLast()), Integer.valueOf(r3.mo2608getDisplayModejFl4v0())});
        }

        public final Saver<DateRangePickerStateImpl, Object> Saver(final SelectableDates r3, final Locale r4) {
            return ListSaverKt.listSaver(new z7(), new a8(r3, r4));
        }

        private static final DateRangePickerStateImpl Saver$lambda$1(SelectableDates r10, Locale r11, List r12) {
            Long r1 = (Long) ListProtector.get(r12, 0);
            Long r2 = (Long) ListProtector.get(r12, 1);
            Long r3 = (Long) ListProtector.get(r12, 2);
            Object r0 = ListProtector.get(r12, 3);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r0).intValue();
            Object r6 = ListProtector.get(r12, 4);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Int");
            IntRange r5 = new IntRange(r4, ((Integer) r6).intValue());
            Object r13 = ListProtector.get(r12, 5);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Int");
            return new DateRangePickerStateImpl(r1, r2, r3, r5, DisplayMode.m2624constructorimpl(((Integer) r13).intValue()), r10, r11, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DateRangePickerStateImpl(Long r1, Long r2, Long r3, IntRange r4, int r5, SelectableDates r6, Locale r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // androidx.compose.material3.DateRangePickerState
    /* JADX INFO: renamed from: getDisplayMode-jFl-4v0 */
    public int mo2608getDisplayModejFl4v0() {
        return ((DisplayMode) this._displayMode.getValue()).m2629unboximpl();
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long getSelectedEndDateMillis() {
        CalendarDate r0 = (CalendarDate) this._selectedEndDate.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.getUtcTimeMillis());
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long getSelectedStartDateMillis() {
        CalendarDate r0 = (CalendarDate) this._selectedStartDate.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.getUtcTimeMillis());
    }

    private final CalendarDate getDate(Long r5) {
        if (r5 == null) goto L8;
        CalendarDate r6 = getCalendarModel().getCanonicalDate(r5.longValue());
        if (getYearRange().contains(r6.getYear()) == true) goto L7;
        return null;
    L7:
        return r6;
    L8:
        return null;
    }

    @Override // androidx.compose.material3.DateRangePickerState
    /* JADX INFO: renamed from: setDisplayMode-vCnGnXg */
    public void mo2609setDisplayModevCnGnXg(int r4) {
        Long r0 = getSelectedStartDateMillis();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
        setDisplayedMonthMillis(getCalendarModel().getMonth(r1).getStartUtcTimeMillis());
    L5:
        this._displayMode.setValue(DisplayMode.m2623boximpl(r4));
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public void setSelection(Long r6, Long r7) {
        CalendarDate r8 = getDate(r6);
        CalendarDate r9 = getDate(r7);
        if (r8 == null) goto L8;
        if (r9 != null) goto L6;
    L7:
        this._selectedStartDate.setValue(r8);
        this._selectedEndDate.setValue(r9);
        return;
    L6:
        if (r8.getUtcTimeMillis() <= r9.getUtcTimeMillis()) goto L7;
    L8:
        this._selectedStartDate.setValue(null);
        this._selectedEndDate.setValue(null);
    }

    private DateRangePickerStateImpl(Long r1, Long r2, Long r3, IntRange r4, int r5, SelectableDates r6, Locale r7) {
        super(r3, r4, r6, r7);
        this._selectedStartDate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selectedEndDate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        setSelection(r1, r2);
        this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.m2623boximpl(r5), null, 2, null);
    }
}
