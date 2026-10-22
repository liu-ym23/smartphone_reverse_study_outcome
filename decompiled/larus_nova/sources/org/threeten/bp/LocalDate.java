package org.threeten.bp;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.ttm.player.C;
import com.ss.ttm.player.MediaPlayer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.chrono.f;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;
import org.threeten.bp.zone.ZoneOffsetTransition;
import zwc.d;

/* JADX INFO: loaded from: classes41.dex */
public final class LocalDate extends org.threeten.bp.chrono.a implements Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    public static final h<LocalDate> FROM = null;
    public static final LocalDate MAX = null;
    public static final LocalDate MIN = null;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    public static class a implements h<LocalDate> {
        public a() {
        }

        @Override // org.threeten.bp.temporal.h
        public final LocalDate a(org.threeten.bp.temporal.b r100) {
            return LocalDate.from(r100);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f526244a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f526245b = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f526245b = r100;
            r100[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L76:
            f526245b[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L60:
            f526245b[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L74:
            f526245b[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L78:
            f526245b[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L62:
            f526245b[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L64:
            f526245b[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L90:
            f526245b[ChronoUnit.ERAS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L18:
            int[] r101 = new int[ChronoField.values().length];
            f526244a = r101;
            r101[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L84:
            f526244a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L86:
            f526244a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L58:
            f526244a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L80:
            f526244a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L94:
            f526244a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L54:
            f526244a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L66:
            f526244a[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L92:
            f526244a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L56:
            f526244a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L82:
            f526244a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L88:
            f526244a[ChronoField.YEAR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L72:
            f526244a[ChronoField.ERA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public final long c() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        int r100 = this.year;
        short r101 = this.month;
        int r102 = r100 & (-2048);
        int r103 = (r100 << 11) + (r101 << 6);
        return (r103 + this.day) ^ r102;
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        short r100 = this.month;
        if (r100 == 2) goto L17;
        if (r100 != 4) goto L7;
        return 30;
    L7:
        if (r100 != 6) goto L9;
        return 30;
    L9:
        if (r100 != 9) goto L11;
        return 30;
    L11:
        if (r100 == 11) goto L24;
        return 31;
    L24:
        return 30;
    L17:
        if (isLeapYear() == false) goto L19;
        return 29;
    L19:
        return 28;
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        long r100 = this.year;
        long r101 = this.month;
        long r102 = (365 * r100) + 0;
        if (r100 < 0) goto L5;
        long r103 = r102 + ((((3 + r100) / 4) - ((99 + r100) / 100)) + ((r100 + 399) / 400));
    L6:
        long r104 = (r103 + (((367 * r101) - 362) / 12)) + ((long) (this.day - 1));
        if (r101 <= 2) goto L12;
        r104 = r104 - 1;
        if (isLeapYear() == true) goto L12;
        r104 = r104 - 1;
    L12:
        return r104 - DAYS_0000_TO_1970;
    L5:
        r103 = r102 - (((r100 / (-4)) - (r100 / (-100))) + (r100 / (-400)));
        goto L6
    }

    @Override // org.threeten.bp.chrono.a
    public String toString() {
        int r100 = this.year;
        short r101 = this.month;
        short r102 = this.day;
        int r103 = Math.abs(r100);
        StringBuilder r104 = new StringBuilder(10);
        if (r103 >= 1000) goto L8;
        if (r100 >= 0) goto L6;
        r104.append(r100 - 10000);
        r104.deleteCharAt(1);
    L11:
        String r105 = "-0";
        if (r101 >= 10) goto L14;
        String r106 = "-0";
    L15:
        r104.append(r106);
        r104.append(r101);
        if (r102 < 10) goto L19;
        r105 = "-";
    L19:
        r104.append(r105);
        r104.append(r102);
        return r104.toString();
    L14:
        r106 = "-";
        goto L15
    L6:
        r104.append(r100 + 10000);
        r104.deleteCharAt(0);
        goto L11
    L8:
        if (r100 <= 9999) goto L10;
        r104.append('+');
    L10:
        r104.append(r100);
        goto L11
    }

    static {
        MIN = of(-999999999, 1, 1);
        MAX = of(999999999, 12, 31);
        FROM = new a();
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ e getChronology() {
        return getChronology();
    }

    public DayOfWeek getDayOfWeek() {
        long r100 = 7;
        return DayOfWeek.of(((int) ((((toEpochDay() + 3) % r100) + r100) % r100)) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.a
    public f getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME;
    L5:
        return MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME;
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override // org.threeten.bp.chrono.a
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public static LocalDate from(org.threeten.bp.temporal.b r100) {
        LocalDate r101 = (LocalDate) r100.query(g.f526473f);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + r100 + ", type " + r100.getClass().getName());
    }

    public static LocalDate now(Clock r100) {
        d.d(r100, "clock");
        Instant r101 = r100.instant();
        ZoneOffset r102 = r100.getZone().getRules().getOffset(r101);
        return ofEpochDay(d.c(r101.getEpochSecond() + ((long) r102.getTotalSeconds()), 86400));
    }

    public static LocalDate ofEpochDay(long r210) {
        ChronoField.EPOCH_DAY.checkValidValue(r210);
        long r100 = (r210 + DAYS_0000_TO_1970) - 60;
        if (r100 >= 0) goto L5;
        long r110 = ((r100 + 1) / 146097) - 1;
        long r111 = r110 * 400;
        r100 = r100 + ((-r110) * 146097);
    L6:
        long r112 = ((r100 * 400) + 591) / 146097;
        long r113 = r100 - ((((r112 * 365) + (r112 / 4)) - (r112 / 100)) + (r112 / 400));
        if (r113 >= 0) goto L9;
        r112 = r112 - 1;
        r113 = r100 - ((((365 * r112) + (r112 / 4)) - (r112 / 100)) + (r112 / 400));
    L9:
        int r101 = (int) r113;
        int r102 = ((r101 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue((r112 + r111) + ((long) (r102 / 10))), ((r102 + 2) % 12) + 1, (r101 - (((r102 * 306) + 5) / 10)) + 1);
    L5:
        r111 = 0;
        goto L6
    }

    public static LocalDate parse(CharSequence r100) {
        return parse(r100, DateTimeFormatter.f526328h);
    }

    public static LocalDate readExternal(DataInput r100) throws IOException {
        return of(r100.readInt(), r100.readByte(), r100.readByte());
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.c
    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a r100) {
        return super.adjustInto(r100);
    }

    public ZonedDateTime atStartOfDay(ZoneId r100) {
        d.d(r100, "zone");
        LocalDateTime r101 = atTime(LocalTime.MIDNIGHT);
        if ((r100 instanceof ZoneOffset) == true) goto L10;
        ZoneOffsetTransition r102 = r100.getRules().getTransition(r101);
        if (r102 == null) goto L10;
        if (r102.isGap() == false) goto L10;
        r101 = r102.getDateTimeAfter();
    L10:
        return ZonedDateTime.of(r101, r100);
    }

    public OffsetDateTime atTime(OffsetTime r100) {
        return OffsetDateTime.of(LocalDateTime.of(this, r100.toLocalTime()), r100.getOffset());
    }

    public final int b(org.threeten.bp.temporal.f r100) {
        switch(b.f526244a[((ChronoField) r100).ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L7;
            default: goto L5;
        };
    L27:
        int r101 = this.year;
        if (r101 < 1) goto L31;
        return r101;
    L31:
        return 1 - r101;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L7:
        if (this.year >= 1) goto L38;
        return 0;
    L38:
        return 1;
    L12:
        return this.year;
    L14:
        throw new DateTimeException("Field too large for an int: " + r100);
    L16:
        return this.month;
    L18:
        return ((getDayOfYear() - 1) / 7) + 1;
    L20:
        throw new DateTimeException("Field too large for an int: " + r100);
    L22:
        return ((getDayOfYear() - 1) % 7) + 1;
    L24:
        return ((this.day - 1) % 7) + 1;
    L26:
        return getDayOfWeek().getValue();
    L33:
        return ((this.day - 1) / 7) + 1;
    L35:
        return getDayOfYear();
    L37:
        return this.day;
    }

    @Override // org.threeten.bp.chrono.a
    public int compareTo(org.threeten.bp.chrono.a r100) {
        if ((r100 instanceof LocalDate) == false) goto L7;
        return compareTo0((LocalDate) r100);
    L7:
        return super.compareTo(r100);
    }

    public int compareTo0(LocalDate r100) {
        int r101 = this.year - r100.year;
        if (r101 != 0) goto L8;
        int r102 = this.month - r100.month;
        if (r102 == 0) goto L7;
        return r102;
    L7:
        return this.day - r100.day;
    L8:
        return r101;
    }

    public final long d(LocalDate r100) {
        long r101 = (c() * 32) + ((long) getDayOfMonth());
        return (((r100.c() * 32) + ((long) r100.getDayOfMonth())) - r101) / 32;
    }

    public long daysUntil(LocalDate r100) {
        return r100.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalDate) == true) goto L8;
        return false;
    L8:
        if (compareTo0((LocalDate) r100) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // org.threeten.bp.chrono.a
    public String format(DateTimeFormatter r100) {
        return super.format(r100);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public int get(org.threeten.bp.temporal.f r100) {
        if ((r100 instanceof ChronoField) == false) goto L7;
        return b(r100);
    L7:
        return super.get(r100);
    }

    @Override // org.threeten.bp.temporal.b
    public long getLong(org.threeten.bp.temporal.f r100) {
        if ((r100 instanceof ChronoField) == false) goto L15;
        if (r100 != ChronoField.EPOCH_DAY) goto L9;
        return toEpochDay();
    L9:
        if (r100 != ChronoField.PROLEPTIC_MONTH) goto L13;
        return c();
    L13:
        return b(r100);
    L15:
        return r100.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isAfter(org.threeten.bp.chrono.a r100) {
        if ((r100 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r100) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r100);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isBefore(org.threeten.bp.chrono.a r100) {
        if ((r100 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r100) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r100);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isEqual(org.threeten.bp.chrono.a r100) {
        if ((r100 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r100) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r100);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.b
    public boolean isSupported(org.threeten.bp.temporal.f r100) {
        return super.isSupported(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public LocalDate minus(org.threeten.bp.temporal.e r100) {
        return (LocalDate) r100.subtractFrom(this);
    }

    public LocalDate minusDays(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusDays(Long.MAX_VALUE).plusDays(1);
    L6:
        return plusDays(-r100);
    }

    public LocalDate minusMonths(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusMonths(Long.MAX_VALUE).plusMonths(1);
    L6:
        return plusMonths(-r100);
    }

    public LocalDate minusWeeks(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusWeeks(Long.MAX_VALUE).plusWeeks(1);
    L6:
        return plusWeeks(-r100);
    }

    public LocalDate minusYears(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusYears(Long.MAX_VALUE).plusYears(1);
    L6:
        return plusYears(-r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public LocalDate plus(org.threeten.bp.temporal.e r100) {
        return (LocalDate) r100.addTo(this);
    }

    public LocalDate plusDays(long r100) {
        if (r100 != 0) goto L6;
        return this;
    L6:
        return ofEpochDay(d.f(toEpochDay(), r100));
    }

    public LocalDate plusMonths(long r100) {
        if (r100 != 0) goto L5;
        return this;
    L5:
        long r101 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r100;
        long r102 = 12;
        return e(ChronoField.YEAR.checkValidIntValue(d.c(r101, 12)), ((int) (((r101 % r102) + r102) % r102)) + 1, this.day);
    }

    public LocalDate plusWeeks(long r100) {
        return plusDays(d.h(r100, 7));
    }

    public LocalDate plusYears(long r100) {
        if (r100 != 0) goto L6;
        return this;
    L6:
        return e(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r100), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.a, zwc.c, org.threeten.bp.temporal.b
    public <R> R query(h<R> r100) {
        if (r100 != g.f526473f) goto L6;
        return this;
    L6:
        return (R) super.query(r100);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public ValueRange range(org.threeten.bp.temporal.f r100) {
        if ((r100 instanceof ChronoField) == false) goto L37;
        ChronoField r101 = (ChronoField) r100;
        if (r101.isDateBased() == false) goto L35;
        int r102 = b.f526244a[r101.ordinal()];
        if (r102 == 1) goto L33;
        if (r102 == 2) goto L31;
        if (r102 == 3) goto L23;
        if (r102 == 4) goto L17;
        return r100.range();
    L17:
        if (getYear() > 0) goto L19;
        long r103 = C.NANOS_PER_SECOND;
    L21:
        return ValueRange.of(1, r103);
    L19:
        r103 = 999999999;
        goto L21
    L23:
        if (getMonth() == Month.FEBRUARY) goto L25;
    L27:
        long r104 = 5;
    L29:
        return ValueRange.of(1, r104);
    L25:
        if (isLeapYear() == true) goto L27;
        r104 = 4;
        goto L29
    L31:
        return ValueRange.of(1, lengthOfYear());
    L33:
        return ValueRange.of(1, lengthOfMonth());
    L35:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L37:
        return r100.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.a
    public Period until(org.threeten.bp.chrono.a r100) {
        LocalDate r101 = from(r100);
        long r102 = r101.c() - c();
        int r103 = r101.day - this.day;
        if (r102 <= 0) goto L6;
        if (r103 >= 0) goto L6;
        r102 = r102 - 1;
        LocalDate r104 = plusMonths(r102);
        r103 = (int) (r101.toEpochDay() - r104.toEpochDay());
    L9:
        long r105 = r102 / 12;
        int r106 = (int) (r102 % 12);
        return Period.of(d.l(r105), r106, r103);
    L6:
        if (r102 >= 0) goto L9;
        if (r103 <= 0) goto L9;
        r102 = r102 + 1;
        r103 = r103 - r101.lengthOfMonth();
        goto L9
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public LocalDate with(c r100) {
        if ((r100 instanceof LocalDate) == false) goto L7;
        return (LocalDate) r100;
    L7:
        return (LocalDate) r100.adjustInto(this);
    }

    public LocalDate withDayOfMonth(int r100) {
        if (this.day != r100) goto L6;
        return this;
    L6:
        return of(this.year, this.month, r100);
    }

    public LocalDate withDayOfYear(int r100) {
        if (getDayOfYear() != r100) goto L6;
        return this;
    L6:
        return ofYearDay(this.year, r100);
    }

    public LocalDate withMonth(int r100) {
        if (this.month != r100) goto L5;
        return this;
    L5:
        ChronoField.MONTH_OF_YEAR.checkValidValue(r100);
        return e(this.year, r100, this.day);
    }

    public LocalDate withYear(int r100) {
        if (this.year != r100) goto L5;
        return this;
    L5:
        ChronoField.YEAR.checkValidValue(r100);
        return e(r100, this.month, this.day);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeInt(this.year);
        r100.writeByte(this.month);
        r100.writeByte(this.day);
    }

    public static LocalDate now(ZoneId r100) {
        return now(Clock.system(r100));
    }

    @Override // org.threeten.bp.chrono.a
    public LocalDateTime atTime(LocalTime r100) {
        return LocalDateTime.of(this, r100);
    }

    @Override // org.threeten.bp.chrono.a, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return compareTo((org.threeten.bp.chrono.a) r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(org.threeten.bp.temporal.e r100) {
        return minus(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(org.threeten.bp.temporal.e r100) {
        return plus(r100);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.c until(org.threeten.bp.chrono.a r100) {
        return until(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(c r100) {
        return with(r100);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b atTime(LocalTime r100) {
        return atTime(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a minus(org.threeten.bp.temporal.e r100) {
        return minus(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a plus(org.threeten.bp.temporal.e r100) {
        return plus(r100);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(c r100) {
        return with(r100);
    }

    public static LocalDate ofYearDay(int r100, int r101) {
        long r102 = r100;
        ChronoField.YEAR.checkValidValue(r102);
        ChronoField.DAY_OF_YEAR.checkValidValue(r101);
        boolean r103 = IsoChronology.INSTANCE.isLeapYear(r102);
        if (r101 != 366) goto L8;
        if (r103 == true) goto L8;
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + r100 + "' is not a leap year");
    L8:
        Month r104 = Month.of(((r101 - 1) / 31) + 1);
        if (r101 <= ((r104.firstDayOfYear(r103) + r104.length(r103)) - 1)) goto L12;
        r104 = r104.plus(1);
    L12:
        return a(r100, r104, (r101 - r104.firstDayOfYear(r103)) + 1);
    }

    public static LocalDate parse(CharSequence r100, DateTimeFormatter r101) {
        d.d(r101, "formatter");
        return (LocalDate) r101.c(r100, FROM);
    }

    public LocalDateTime atTime(int r100, int r101) {
        return atTime(LocalTime.of(r100, r101));
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public LocalDate minus(long r100, i r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public LocalDate plus(long r100, i r101) {
        if ((r101 instanceof ChronoUnit) == false) goto L25;
        switch(b.f526245b[((ChronoUnit) r101).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r102 = ChronoField.ERA;
        return with(r102, d.f(getLong(r102), r100));
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L11:
        return plusYears(d.h(r100, 1000));
    L13:
        return plusYears(d.h(r100, 100));
    L15:
        return plusYears(d.h(r100, 10));
    L17:
        return plusYears(r100);
    L19:
        return plusMonths(r100);
    L21:
        return plusWeeks(r100);
    L23:
        return plusDays(r100);
    L25:
        return (LocalDate) r101.addTo(this, r100);
    }

    @Override // org.threeten.bp.temporal.a
    public long until(org.threeten.bp.temporal.a r100, i r101) {
        LocalDate r102 = from(r100);
        if ((r101 instanceof ChronoUnit) == false) goto L25;
        switch(b.f526245b[((ChronoUnit) r101).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r103 = ChronoField.ERA;
        return r102.getLong(r103) - getLong(r103);
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L11:
        return d(r102) / 12000;
    L13:
        return d(r102) / AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    L15:
        return d(r102) / 120;
    L17:
        return d(r102) / 12;
    L19:
        return d(r102);
    L21:
        return daysUntil(r102) / 7;
    L23:
        return daysUntil(r102);
    L25:
        return r101.between(this, r102);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public LocalDate with(org.threeten.bp.temporal.f r100, long r101) {
        if ((r100 instanceof ChronoField) == false) goto L42;
        ChronoField r102 = (ChronoField) r100;
        r102.checkValidValue(r101);
        switch(b.f526244a[r102.ordinal()]) {
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L9:
        if (getLong(ChronoField.ERA) != r101) goto L12;
        return this;
    L12:
        return withYear(1 - this.year);
    L14:
        return withYear((int) r101);
    L16:
        return plusMonths(r101 - getLong(ChronoField.PROLEPTIC_MONTH));
    L18:
        return withMonth((int) r101);
    L20:
        return plusWeeks(r101 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
    L22:
        return ofEpochDay(r101);
    L24:
        return plusDays(r101 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L26:
        return plusDays(r101 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L28:
        return plusDays(r101 - ((long) getDayOfWeek().getValue()));
    L30:
        if (this.year >= 1) goto L34;
        r101 = 1 - r101;
    L34:
        return withYear((int) r101);
    L36:
        return plusWeeks(r101 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
    L38:
        return withDayOfYear((int) r101);
    L40:
        return withDayOfMonth((int) r101);
    L42:
        return (LocalDate) r100.adjustInto(this, r101);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(long r100, i r101) {
        return minus(r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r100, i r101) {
        return plus(r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(org.threeten.bp.temporal.f r100, long r101) {
        return with(r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a minus(long r100, i r101) {
        return minus(r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a plus(long r100, i r101) {
        return plus(r100, r101);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(org.threeten.bp.temporal.f r100, long r101) {
        return with(r100, r101);
    }

    public LocalDate(int r100, int r101, int r102) {
        this.year = r100;
        this.month = (short) r101;
        this.day = (short) r102;
    }

    public static LocalDate a(int r100, Month r101, int r102) {
        if (r102 <= 28) goto L13;
        if (r102 <= r101.length(IsoChronology.INSTANCE.isLeapYear(r100))) goto L13;
        if (r102 != 29) goto L11;
        throw new DateTimeException("Invalid date 'February 29' as '" + r100 + "' is not a leap year");
    L11:
        throw new DateTimeException("Invalid date '" + r101.name() + " " + r102 + "'");
    L13:
        return new LocalDate(r100, r101.getValue(), r102);
    }

    public static LocalDate e(int r100, int r101, int r102) {
        if (r101 == 2) goto L15;
        if (r101 != 4) goto L7;
    L13:
        r102 = Math.min(r102, 30);
    L20:
        return of(r100, r101, r102);
    L7:
        if (r101 == 6) goto L13;
        if (r101 == 9) goto L13;
        if (r101 == 11) goto L13;
    L15:
        if (IsoChronology.INSTANCE.isLeapYear(r100) == false) goto L17;
        int r103 = 29;
    L18:
        r102 = Math.min(r102, r103);
        goto L20
    L17:
        r103 = 28;
        goto L18
    }

    public static LocalDate of(int r100, int r101, int r102) {
        ChronoField.YEAR.checkValidValue(r100);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r101);
        ChronoField.DAY_OF_MONTH.checkValidValue(r102);
        return a(r100, Month.of(r101), r102);
    }

    public LocalDateTime atTime(int r100, int r101, int r102) {
        return atTime(LocalTime.of(r100, r101, r102));
    }

    public static LocalDate of(int r100, Month r101, int r102) {
        ChronoField.YEAR.checkValidValue(r100);
        d.d(r101, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        ChronoField.DAY_OF_MONTH.checkValidValue(r102);
        return a(r100, r101, r102);
    }

    public LocalDateTime atTime(int r100, int r101, int r102, int r103) {
        return atTime(LocalTime.of(r100, r101, r102, r103));
    }
}
