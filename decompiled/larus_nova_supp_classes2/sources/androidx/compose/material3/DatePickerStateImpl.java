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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\u0010\f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_selectedDate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "dateMillis", "selectedDateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "_displayMode", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DatePickerStateImpl extends BaseDatePickerStateImpl implements DatePickerState {
    public static final Companion Companion = null;
    private MutableState<DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedDate;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DatePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r0, DatePickerStateImpl r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ DatePickerStateImpl b(SelectableDates r0, Locale r1, List r2) {
            return Saver$lambda$1(r0, r1, r2);
        }

        private static final List Saver$lambda$0(SaverScope r2, DatePickerStateImpl r3) {
            return CollectionsKt.listOf(new Object[]{r3.getSelectedDateMillis(), Long.valueOf(r3.getDisplayedMonthMillis()), Integer.valueOf(r3.getYearRange().getFirst()), Integer.valueOf(r3.getYearRange().getLast()), Integer.valueOf(r3.mo2590getDisplayModejFl4v0())});
        }

        public final Saver<DatePickerStateImpl, Object> Saver(final SelectableDates r3, final Locale r4) {
            return ListSaverKt.listSaver(new v6(), new w6(r3, r4));
        }

        private static final DatePickerStateImpl Saver$lambda$1(SelectableDates r9, Locale r10, List r11) {
            Long r1 = (Long) ListProtector.get(r11, 0);
            Long r2 = (Long) ListProtector.get(r11, 1);
            Object r0 = ListProtector.get(r11, 2);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
            int r3 = ((Integer) r0).intValue();
            Object r5 = ListProtector.get(r11, 3);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            IntRange r4 = new IntRange(r3, ((Integer) r5).intValue());
            Object r12 = ListProtector.get(r11, 4);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
            return new DatePickerStateImpl(r1, r2, r4, DisplayMode.m2624constructorimpl(((Integer) r12).intValue()), r9, r10, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DatePickerStateImpl(Long r1, Long r2, IntRange r3, int r4, SelectableDates r5, Locale r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    @Override // androidx.compose.material3.DatePickerState
    /* JADX INFO: renamed from: getDisplayMode-jFl-4v0 */
    public int mo2590getDisplayModejFl4v0() {
        return ((DisplayMode) this._displayMode.getValue()).m2629unboximpl();
    }

    @Override // androidx.compose.material3.DatePickerState
    public Long getSelectedDateMillis() {
        CalendarDate r0 = (CalendarDate) this._selectedDate.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.getUtcTimeMillis());
    }

    @Override // androidx.compose.material3.DatePickerState
    /* JADX INFO: renamed from: setDisplayMode-vCnGnXg */
    public void mo2591setDisplayModevCnGnXg(int r4) {
        Long r0 = getSelectedDateMillis();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
        setDisplayedMonthMillis(getCalendarModel().getMonth(r1).getStartUtcTimeMillis());
    L5:
        this._displayMode.setValue(DisplayMode.m2623boximpl(r4));
    }

    @Override // androidx.compose.material3.DatePickerState
    public void setSelectedDateMillis(Long r5) {
        CalendarDate r0 = null;
        if (r5 == null) goto L8;
        CalendarDate r6 = getCalendarModel().getCanonicalDate(r5.longValue());
        MutableState<CalendarDate> r1 = this._selectedDate;
        if (getYearRange().contains(r6.getYear()) == false) goto L7;
        r0 = r6;
    L7:
        r1.setValue(r0);
        return;
    L8:
        this._selectedDate.setValue(null);
    }

    private DatePickerStateImpl(Long r3, Long r4, IntRange r5, int r6, SelectableDates r7, Locale r8) {
        super(r4, r5, r7, r8);
        if (r3 == null) goto L7;
        CalendarDate r9 = getCalendarModel().getCanonicalDate(r3.longValue());
        if (r5.contains(r9.getYear()) == false) goto L7;
    L8:
        this._selectedDate = SnapshotStateKt.mutableStateOf$default(r9, null, 2, null);
        this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.m2623boximpl(r6), null, 2, null);
        return;
    L7:
        r9 = null;
        goto L8
    }
}
