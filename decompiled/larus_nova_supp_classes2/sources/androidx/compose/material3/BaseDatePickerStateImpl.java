package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "initialDisplayedMonthMillis", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "getYearRange", "()Lkotlin/ranges/IntRange;", "getLocale", "()Ljava/util/Locale;", "Ljava/util/Locale;", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/internal/CalendarModel;", "<set-?>", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "setSelectableDates", "(Landroidx/compose/material3/SelectableDates;)V", "selectableDates$delegate", "Landroidx/compose/runtime/MutableState;", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarMonth;", "monthMillis", "displayedMonthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseDatePickerStateImpl {
    public static final int $stable = 0;
    private final MutableState<CalendarMonth> _displayedMonth;
    private final CalendarModel calendarModel;
    private final Locale locale;
    private final MutableState selectableDates$delegate;
    private final IntRange yearRange;

    public final long getDisplayedMonthMillis() {
        return ((CalendarMonth) this._displayedMonth.getValue()).getStartUtcTimeMillis();
    }

    public final SelectableDates getSelectableDates() {
        return (SelectableDates) this.selectableDates$delegate.getValue();
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final IntRange getYearRange() {
        return this.yearRange;
    }

    public final void setDisplayedMonthMillis(long r2) {
        CalendarMonth r3 = this.calendarModel.getMonth(r2);
        if (this.yearRange.contains(r3.getYear()) == false) goto L6;
        this._displayedMonth.setValue(r3);
        return;
    }

    public final void setSelectableDates(SelectableDates r2) {
        this.selectableDates$delegate.setValue(r2);
    }

    public BaseDatePickerStateImpl(Long r5, IntRange r6, SelectableDates r7, Locale r8) {
        this.yearRange = r6;
        this.locale = r8;
        CalendarModel r9 = CalendarModel_androidKt.createCalendarModel(r8);
        this.calendarModel = r9;
        this.selectableDates$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        if (r5 == null) goto L7;
        CalendarMonth r10 = r9.getMonth(r5.longValue());
        if (r6.contains(r10.getYear()) == true) goto L8;
        r10 = r9.getMonth(r9.getToday());
    L8:
        this._displayedMonth = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
        return;
    L7:
        r10 = r9.getMonth(r9.getToday());
        goto L8
    }
}
