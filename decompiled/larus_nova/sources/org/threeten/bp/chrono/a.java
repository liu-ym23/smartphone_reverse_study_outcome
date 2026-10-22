package org.threeten.bp.chrono;

import com.ss.ttm.player.MediaPlayer;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a extends zwc.b implements org.threeten.bp.temporal.c, Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7100a f526320a = null;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.a$a, reason: collision with other inner class name */
    public static class C7100a implements Comparator<a> {
        public C7100a() {
        }

        @Override // java.util.Comparator
        public final int compare(a r100, a r101) {
            return zwc.d.a(r100.toEpochDay(), r101.toEpochDay());
        }
    }

    public abstract e getChronology();

    public abstract int lengthOfMonth();

    public abstract a plus(long r100, i r101);

    public abstract c until(a r100);

    public abstract a with(org.threeten.bp.temporal.f r100, long r101);

    static {
        f526320a = new C7100a();
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long r100 = getLong(ChronoField.YEAR_OF_ERA);
        long r101 = getLong(ChronoField.MONTH_OF_YEAR);
        long r102 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder r103 = new StringBuilder(30);
        r103.append(getChronology().toString());
        r103.append(" ");
        r103.append(getEra());
        r103.append(" ");
        r103.append(r100);
        String r104 = "-0";
        if (r101 >= 10) goto L5;
        String r105 = "-0";
    L6:
        r103.append(r105);
        r103.append(r101);
        if (r102 < 10) goto L10;
        r104 = "-";
    L10:
        r103.append(r104);
        r103.append(r102);
        return r103.toString();
    L5:
        r105 = "-";
        goto L6
    }

    public f getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long r100 = toEpochDay();
        return getChronology().hashCode() ^ ((int) (r100 ^ (r100 >>> 32)));
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME;
    L5:
        return MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME;
    }

    public a() {
    }

    public static Comparator<a> timeLineOrder() {
        return f526320a;
    }

    public static a from(org.threeten.bp.temporal.b r100) {
        zwc.d.d(r100, "temporal");
        if ((r100 instanceof a) == true) goto L5;
        e r101 = (e) r100.query(g.f526469b);
        if (r101 == null) goto L11;
        return r101.date(r100);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + r100.getClass());
    L5:
        return (a) r100;
    }

    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a r100) {
        return r100.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public b<?> atTime(LocalTime r100) {
        return ChronoLocalDateTimeImpl.of(this, r100);
    }

    public int compareTo(a r100) {
        int r101 = zwc.d.a(toEpochDay(), r100.toEpochDay());
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return getChronology().compareTo2(r100.getChronology());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        if (compareTo((a) r100) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public String format(DateTimeFormatter r100) {
        zwc.d.d(r100, "formatter");
        return r100.a(this);
    }

    public boolean isAfter(a r100) {
        if (toEpochDay() <= r100.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(a r100) {
        if (toEpochDay() >= r100.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(a r100) {
        if (toEpochDay() != r100.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.b
    public boolean isSupported(org.threeten.bp.temporal.f r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r100.isDateBased();
    }

    @Override // zwc.b
    public a minus(org.threeten.bp.temporal.e r100) {
        return getChronology().ensureChronoLocalDate(super.minus(r100));
    }

    @Override // zwc.b
    public a plus(org.threeten.bp.temporal.e r100) {
        return getChronology().ensureChronoLocalDate(super.plus(r100));
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public <R> R query(h<R> r100) {
        if (r100 != g.f526469b) goto L7;
        return (R) getChronology();
    L7:
        if (r100 != g.f526470c) goto L11;
        return (R) ChronoUnit.DAYS;
    L11:
        if (r100 != g.f526473f) goto L15;
        return (R) LocalDate.ofEpochDay(toEpochDay());
    L15:
        if (r100 != g.f526474g) goto L17;
        return null;
    L17:
        if (r100 != g.f526471d) goto L19;
        return null;
    L19:
        if (r100 != g.f526468a) goto L21;
        return null;
    L21:
        if (r100 != g.f526472e) goto L24;
        return null;
    L24:
        return (R) super.query(r100);
    }

    @Override // zwc.b, org.threeten.bp.temporal.a
    public a with(org.threeten.bp.temporal.c r100) {
        return getChronology().ensureChronoLocalDate(super.with(r100));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return compareTo((a) r100);
    }

    public boolean isSupported(i r100) {
        if ((r100 instanceof ChronoUnit) == true) goto L5;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r100.isDateBased();
    }

    @Override // zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a minus(org.threeten.bp.temporal.e r100) {
        return minus(r100);
    }

    @Override // zwc.b
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a plus(org.threeten.bp.temporal.e r100) {
        return plus(r100);
    }

    @Override // zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(org.threeten.bp.temporal.c r100) {
        return with(r100);
    }

    @Override // zwc.b, org.threeten.bp.temporal.a
    public a minus(long r100, i r101) {
        return getChronology().ensureChronoLocalDate(super.minus(r100, r101));
    }

    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a plus(long r100, i r101) {
        return plus(r100, r101);
    }

    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(org.threeten.bp.temporal.f r100, long r101) {
        return with(r100, r101);
    }

    @Override // zwc.b, org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a minus(long r100, i r101) {
        return minus(r100, r101);
    }
}
