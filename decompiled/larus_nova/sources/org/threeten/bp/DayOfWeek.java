package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* JADX INFO: loaded from: classes41.dex */
public final enum DayOfWeek extends Enum<DayOfWeek> implements b, c {
    public static final DayOfWeek FRIDAY = null;
    public static final h<DayOfWeek> FROM = null;
    public static final DayOfWeek MONDAY = null;
    public static final DayOfWeek SATURDAY = null;
    public static final DayOfWeek SUNDAY = null;
    public static final DayOfWeek THURSDAY = null;
    public static final DayOfWeek TUESDAY = null;
    public static final DayOfWeek WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DayOfWeek[] f526237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DayOfWeek[] f526238b = null;

    static {
        DayOfWeek r100 = new DayOfWeek("MONDAY", 0);
        MONDAY = r100;
        DayOfWeek r101 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = r101;
        DayOfWeek r102 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = r102;
        DayOfWeek r103 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = r103;
        DayOfWeek r104 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = r104;
        DayOfWeek r105 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = r105;
        DayOfWeek r110 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = r110;
        f526238b = new DayOfWeek[]{r100, r101, r102, r103, r104, r105, r110};
        FROM = new a();
        f526237a = values();
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) f526238b.clone();
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public static DayOfWeek from(b r100) {
        if ((r100 instanceof DayOfWeek) == true) goto L5;
        return of(r100.get(ChronoField.DAY_OF_WEEK));
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + r100 + ", type " + r100.getClass().getName(), e);
    L5:
        return (DayOfWeek) r100;
    }

    public static DayOfWeek of(int r100) {
        if (r100 < 1) goto L9;
        if (r100 > 7) goto L9;
        return f526237a[r100 - 1];
    L9:
        throw new DateTimeException("Invalid value for DayOfWeek: " + r100);
    }

    public static DayOfWeek valueOf(String r100) {
        return (DayOfWeek) r27.a.a(DayOfWeek.class, r100);
    }

    @Override // org.threeten.bp.temporal.c
    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a r100) {
        return r100.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // org.threeten.bp.temporal.b
    public int get(f r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        return range(r100).checkValidIntValue(getLong(r100), r100);
    }

    @Override // org.threeten.bp.temporal.b
    public long getLong(f r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        if ((r100 instanceof ChronoField) == true) goto L11;
        return r100.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    @Override // org.threeten.bp.temporal.b
    public boolean isSupported(f r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L11;
    L13:
        return false;
    L11:
        if (r100.isSupportedBy(this) == false) goto L13;
        return true;
    L5:
        if (r100 == ChronoField.DAY_OF_WEEK) goto L15;
        return false;
    L15:
        return true;
    }

    public DayOfWeek minus(long r100) {
        return plus(-(r100 % 7));
    }

    public DayOfWeek plus(long r100) {
        int r101 = (int) (r100 % 7);
        return f526237a[(ordinal() + (r101 + 7)) % 7];
    }

    @Override // org.threeten.bp.temporal.b
    public <R> R query(h<R> r100) {
        if (r100 != g.f526470c) goto L7;
        return (R) ChronoUnit.DAYS;
    L7:
        if (r100 != g.f526473f) goto L9;
        return null;
    L9:
        if (r100 != g.f526474g) goto L11;
        return null;
    L11:
        if (r100 != g.f526469b) goto L13;
        return null;
    L13:
        if (r100 != g.f526471d) goto L15;
        return null;
    L15:
        if (r100 != g.f526468a) goto L17;
        return null;
    L17:
        if (r100 != g.f526472e) goto L20;
        return null;
    L20:
        return r100.a(this);
    }

    @Override // org.threeten.bp.temporal.b
    public ValueRange range(f r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return r100.range();
    L7:
        if ((r100 instanceof ChronoField) == true) goto L11;
        return r100.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    public DayOfWeek(String r100, int r101) {
        super(r100, r101);
    }

    public String getDisplayName(TextStyle r100, Locale r101) {
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        r102.i(ChronoField.DAY_OF_WEEK, r100);
        return r102.q(r101).a(this);
    }
}
