package org.threeten.bp.chrono;

import androidx.core.text.util.LocalePreferences;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e implements Comparable<e> {
    public static final h<e> FROM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e> f526324a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e> f526325b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f526326c = null;

    public static class a implements h<e> {
        public a() {
        }

        @Override // org.threeten.bp.temporal.h
        public final e a(org.threeten.bp.temporal.b r100) {
            return e.from(r100);
        }
    }

    public class b extends zwc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f526327a;

        @Override // org.threeten.bp.temporal.b
        public final boolean isSupported(org.threeten.bp.temporal.f r100) {
            return false;
        }

        public b(e r100) {
            this.f526327a = r100;
        }

        @Override // org.threeten.bp.temporal.b
        public final long getLong(org.threeten.bp.temporal.f r100) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
        }

        @Override // zwc.c, org.threeten.bp.temporal.b
        public <R> R query(h<R> r100) {
            if (r100 != g.f526469b) goto L7;
            return (R) this.f526327a;
        L7:
            return (R) super.query(r100);
        }
    }

    public abstract org.threeten.bp.chrono.a date(int r100, int r101, int r102);

    public abstract org.threeten.bp.chrono.a date(org.threeten.bp.temporal.b r100);

    public abstract org.threeten.bp.chrono.a dateEpochDay(long r100);

    public abstract org.threeten.bp.chrono.a dateYearDay(int r100, int r101);

    public abstract f eraOf(int r100);

    public abstract List<f> eras();

    public abstract String getCalendarType();

    public abstract String getId();

    public abstract boolean isLeapYear(long r100);

    public abstract int prolepticYear(f r100, int r101);

    public abstract ValueRange range(ChronoField r100);

    public abstract org.threeten.bp.chrono.a resolveDate(Map<org.threeten.bp.temporal.f, Long> r100, ResolverStyle r101);

    static {
        FROM = new a();
        f526324a = new ConcurrentHashMap();
        f526325b = new ConcurrentHashMap();
        Method r100 = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});     // Catch: Throwable -> L5
    L6:
        f526326c = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static void a() {
        ConcurrentHashMap<String, e> r100 = f526324a;
        if (r100.isEmpty() == false) goto L10;
        b(IsoChronology.INSTANCE);
        b(ThaiBuddhistChronology.INSTANCE);
        b(MinguoChronology.INSTANCE);
        b(JapaneseChronology.INSTANCE);
        HijrahChronology r101 = HijrahChronology.INSTANCE;
        b(r101);
        r100.putIfAbsent("Hijrah", r101);
        f526325b.putIfAbsent(LocalePreferences.CalendarType.ISLAMIC, r101);
        Iterator r102 = ServiceLoader.load(e.class, e.class.getClassLoader()).iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        e r103 = (e) r102.next();
        f526324a.putIfAbsent(r103.getId(), r103);
        String r104 = r103.getCalendarType();
        if (r104 == null) goto L6;
        f526325b.putIfAbsent(r104, r103);
        goto L6
    L16:
        return;
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 11, this);
    }

    public static Set<e> getAvailableChronologies() {
        a();
        return new HashSet(f526324a.values());
    }

    public org.threeten.bp.chrono.a dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public String toString() {
        return getId();
    }

    public e() {
    }

    public static void b(e r100) {
        f526324a.putIfAbsent(r100.getId(), r100);
        String r101 = r100.getCalendarType();
        if (r101 == null) goto L6;
        f526325b.putIfAbsent(r101, r100);
        return;
    }

    public static e from(org.threeten.bp.temporal.b r100) {
        zwc.d.d(r100, "temporal");
        e r101 = (e) r100.query(g.f526469b);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return IsoChronology.INSTANCE;
    }

    public static e of(String r100) {
        a();
        e r101 = f526324a.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        e r102 = f526325b.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new DateTimeException("Unknown chronology: " + r100);
    }

    public static e ofLocale(Locale r100) {
        a();
        zwc.d.d(r100, "locale");
        Method r101 = f526326c;
        if (r101 == null) goto L9;
        String r102 = (String) r101.invoke(r100, new Object[]{"ca"});     // Catch: Throwable -> L7
    L12:
        if (r102 == null) goto L24;
        if ("iso".equals(r102) == true) goto L24;
        if ("iso8601".equals(r102) == true) goto L24;
        e r103 = f526325b.get(r102);
        if (r103 == null) goto L22;
        return r103;
    L22:
        throw new DateTimeException("Unknown calendar system: ".concat(r102));
    L24:
        return IsoChronology.INSTANCE;
    L11:
        r102 = "iso";
        goto L12
    L9:
        if (r100.equals(JapaneseChronology.LOCALE) == false) goto L11;
        r102 = "japanese";
        goto L12
    }

    public static e readExternal(DataInput r100) throws IOException {
        return of(r100.readUTF());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(e r100) {
        return getId().compareTo(r100.getId());
    }

    public org.threeten.bp.chrono.a dateNow(Clock r100) {
        zwc.d.d(r100, "clock");
        return date(LocalDate.now(r100));
    }

    public <D extends org.threeten.bp.chrono.a> D ensureChronoLocalDate(org.threeten.bp.temporal.a r100) {
        D r101 = (D) r100;
        if (equals(r101.getChronology()) == false) goto L6;
        return r101;
    L6:
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + r101.getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(org.threeten.bp.temporal.a r100) {
        ChronoLocalDateTimeImpl<D> r101 = (ChronoLocalDateTimeImpl) r100;
        if (equals(r101.toLocalDate().getChronology()) == false) goto L6;
        return r101;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r101.toLocalDate().getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(org.threeten.bp.temporal.a r100) {
        ChronoZonedDateTimeImpl<D> r101 = (ChronoZonedDateTimeImpl) r100;
        if (equals(r101.toLocalDate().getChronology()) == false) goto L6;
        return r101;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r101.toLocalDate().getChronology().getId());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        if (compareTo2((e) r100) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public org.threeten.bp.chrono.b<?> localDateTime(org.threeten.bp.temporal.b r100) {
        return date(r100).atTime(LocalTime.from(r100));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + r100.getClass(), e);
    }

    void writeExternal(DataOutput r100) throws IOException {
        r100.writeUTF(getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [org.threeten.bp.chrono.d, org.threeten.bp.chrono.d<?>] */
    public d<?> zonedDateTime(Object r100) {
        ZoneId r101 = ZoneId.from(r100);     // Catch: DateTimeException -> L7
        r100 = zonedDateTime(Instant.from(r100), r101);     // Catch: DateTimeException -> L5
        return r100;
    L6:
        return ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(r100)), r101, null);
    L7:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + r100.getClass(), e);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(e r100) {
        return compareTo2(r100);
    }

    public org.threeten.bp.chrono.a dateNow(ZoneId r100) {
        return dateNow(Clock.system(r100));
    }

    public String getDisplayName(TextStyle r100, Locale r101) {
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        zwc.d.d(r100, "textStyle");
        r102.b(new DateTimeFormatterBuilder.e(r100));
        return r102.q(r101).a(new b(this));
    }

    public d<?> zonedDateTime(Instant r100, ZoneId r101) {
        return ChronoZonedDateTimeImpl.ofInstant(this, r100, r101);
    }

    public org.threeten.bp.chrono.a dateYearDay(f r100, int r101, int r102) {
        return dateYearDay(prolepticYear(r100, r101), r102);
    }

    public c period(int r100, int r101, int r102) {
        return new ChronoPeriodImpl(this, r100, r101, r102);
    }

    public void updateResolveMap(Map<org.threeten.bp.temporal.f, Long> r100, ChronoField r101, long r102) {
        Long r103 = r100.get(r101);
        if (r103 != null) goto L5;
    L9:
        r100.put(r101, Long.valueOf(r102));
        return;
    L5:
        if (r103.longValue() == r102) goto L9;
        throw new DateTimeException("Invalid state, field: " + r101 + " " + r103 + " conflicts with " + r101 + " " + r102);
    }

    public org.threeten.bp.chrono.a date(f r100, int r101, int r102, int r103) {
        return date(prolepticYear(r100, r101), r102, r103);
    }
}
