package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes41.dex */
final enum JulianFields$Field extends Enum<JulianFields$Field> implements f {
    public static final JulianFields$Field JULIAN_DAY = null;
    public static final JulianFields$Field MODIFIED_JULIAN_DAY = null;
    public static final JulianFields$Field RATA_DIE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JulianFields$Field[] f526449a = null;
    private final i baseUnit;
    private final String name;
    private final long offset;
    private final ValueRange range;
    private final i rangeUnit;

    @Override // org.threeten.bp.temporal.f
    public boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.f
    public boolean isTimeBased() {
        return false;
    }

    static {
        ChronoUnit r110 = ChronoUnit.DAYS;
        ChronoUnit r111 = ChronoUnit.FOREVER;
        JulianFields$Field r100 = new JulianFields$Field("JULIAN_DAY", 0, "JulianDay", r110, r111, 2440588);
        JULIAN_DAY = r100;
        JulianFields$Field r101 = new JulianFields$Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", r110, r111, 40587);
        MODIFIED_JULIAN_DAY = r101;
        JulianFields$Field r102 = new JulianFields$Field("RATA_DIE", 2, "RataDie", r110, r111, 719163);
        RATA_DIE = r102;
        f526449a = new JulianFields$Field[]{r100, r101, r102};
    }

    public static JulianFields$Field[] values() {
        return (JulianFields$Field[]) f526449a.clone();
    }

    public i getBaseUnit() {
        return this.baseUnit;
    }

    public i getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // org.threeten.bp.temporal.f
    public ValueRange range() {
        return this.range;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    public static JulianFields$Field valueOf(String r100) {
        return (JulianFields$Field) r27.a.a(JulianFields$Field.class, r100);
    }

    public String getDisplayName(Locale r100) {
        zwc.d.d(r100, "locale");
        return toString();
    }

    @Override // org.threeten.bp.temporal.f
    public long getFrom(b r100) {
        return r100.getLong(ChronoField.EPOCH_DAY) + this.offset;
    }

    @Override // org.threeten.bp.temporal.f
    public boolean isSupportedBy(b r100) {
        return r100.isSupported(ChronoField.EPOCH_DAY);
    }

    @Override // org.threeten.bp.temporal.f
    public ValueRange rangeRefinedBy(b r100) {
        if (isSupportedBy(r100) == false) goto L7;
        return range();
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
    }

    @Override // org.threeten.bp.temporal.f
    public <R extends a> R adjustInto(R r100, long r101) {
        if (range().isValidValue(r101) == false) goto L7;
        return (R) r100.with(ChronoField.EPOCH_DAY, zwc.d.k(r101, this.offset));
    L7:
        throw new DateTimeException("Invalid value: " + this.name + " " + r101);
    }

    @Override // org.threeten.bp.temporal.f
    public b resolve(Map<f, Long> r100, b r101, ResolverStyle r102) {
        long r103 = r100.remove(this).longValue();
        return org.threeten.bp.chrono.e.from(r101).dateEpochDay(zwc.d.k(r103, this.offset));
    }

    public JulianFields$Field(String r100, int r101, String r102, ChronoUnit r103, ChronoUnit r104, long r105) {
        super(r100, r101);
        this.name = r102;
        this.baseUnit = r103;
        this.rangeUnit = r104;
        this.range = ValueRange.of((-365243219162L) + r105, 365241780471L + r105);
        this.offset = r105;
    }
}
