package org.threeten.bp;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;
import zwc.c;
import zwc.d;

/* JADX INFO: loaded from: classes41.dex */
public final class Instant extends c implements org.threeten.bp.temporal.a, org.threeten.bp.temporal.c, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = null;
    public static final h<Instant> FROM = null;
    public static final Instant MAX = null;
    public static final Instant MIN = null;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    public static class a implements h<Instant> {
        public a() {
        }

        @Override // org.threeten.bp.temporal.h
        public final Instant a(org.threeten.bp.temporal.b r100) {
            return Instant.from(r100);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f526242a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f526243b = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f526243b = r100;
            r100[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            f526243b[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            f526243b[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f526243b[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            f526243b[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            f526243b[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            f526243b[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            f526243b[ChronoUnit.DAYS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r101 = new int[ChronoField.values().length];
            f526242a = r101;
            r101[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            f526242a[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f526242a[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            f526242a[ChronoField.INSTANT_SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        EPOCH = new Instant(0, 0);
        MIN = ofEpochSecond(-31557014167219200L, 0);
        MAX = ofEpochSecond(31556889864403199L, 999999999);
        FROM = new a();
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public int hashCode() {
        long r100 = this.seconds;
        return ((int) (r100 ^ (r100 >>> 32))) + (this.nanos * 51);
    }

    public long toEpochMilli() {
        long r100 = this.seconds;
        if (r100 < 0) goto L7;
        return d.f(d.i(r100, 1000), this.nanos / 1000000);
    L7:
        return d.k(d.i(r100 + 1, 1000), 1000 - ((long) (this.nanos / 1000000)));
    }

    public String toString() {
        return DateTimeFormatter.f526334n.a(this);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    public static Instant from(org.threeten.bp.temporal.b r100) {
        return ofEpochSecond(r100.getLong(ChronoField.INSTANT_SECONDS), r100.get(ChronoField.NANO_OF_SECOND));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + r100 + ", type " + r100.getClass().getName(), e);
    }

    public static Instant now(Clock r100) {
        d.d(r100, "clock");
        return r100.instant();
    }

    public static Instant ofEpochMilli(long r100) {
        long r101 = 1000;
        return a(d.c(r100, 1000), ((int) (((r100 % r101) + r101) % r101)) * 1000000);
    }

    public static Instant ofEpochSecond(long r100) {
        return a(r100, 0);
    }

    public static Instant parse(CharSequence r100) {
        return (Instant) DateTimeFormatter.f526334n.c(r100, FROM);
    }

    public static Instant readExternal(DataInput r100) throws IOException {
        return ofEpochSecond(r100.readLong(), r100.readInt());
    }

    @Override // org.threeten.bp.temporal.c
    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a r100) {
        return r100.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset r100) {
        return OffsetDateTime.ofInstant(this, r100);
    }

    public ZonedDateTime atZone(ZoneId r100) {
        return ZonedDateTime.ofInstant(this, r100);
    }

    public final long c(Instant r110) {
        long r100 = d.k(r110.seconds, this.seconds);
        long r101 = r110.nanos - this.nanos;
        if (r100 > 0) goto L5;
    L7:
        if (r100 < 0) goto L9;
        return r100;
    L9:
        if (r101 > 0) goto L11;
        return r100;
    L11:
        return r100 + 1;
    L5:
        if (r101 >= 0) goto L7;
        return r100 - 1;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Instant r100) {
        int r101 = d.a(this.seconds, r100.seconds);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        return this.nanos - r100.nanos;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Instant) == false) goto L14;
        Instant r101 = (Instant) r100;
        if (this.seconds == r101.seconds) goto L10;
    L12:
        return false;
    L10:
        if (this.nanos != r101.nanos) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public int get(f r100) {
        if ((r100 instanceof ChronoField) == false) goto L19;
        int r101 = b.f526242a[((ChronoField) r100).ordinal()];
        if (r101 == 1) goto L17;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L13;
        return this.nanos / 1000000;
    L13:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L15:
        return this.nanos / 1000;
    L17:
        return this.nanos;
    L19:
        return range(r100).checkValidIntValue(r100.getFrom(this), r100);
    }

    @Override // org.threeten.bp.temporal.b
    public long getLong(f r100) {
        if ((r100 instanceof ChronoField) == false) goto L22;
        int r101 = b.f526242a[((ChronoField) r100).ordinal()];
        if (r101 != 1) goto L7;
        int r102 = this.nanos;
    L18:
        return r102;
    L7:
        if (r101 != 2) goto L9;
        r102 = this.nanos / 1000;
        goto L18
    L9:
        if (r101 != 3) goto L11;
        r102 = this.nanos / 1000000;
        goto L18
    L11:
        if (r101 != 4) goto L15;
        return this.seconds;
    L15:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L22:
        return r100.getFrom(this);
    }

    public boolean isAfter(Instant r100) {
        if (compareTo2(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Instant r100) {
        if (compareTo2(r100) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.b
    public boolean isSupported(f r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L17;
    L19:
        return false;
    L17:
        if (r100.isSupportedBy(this) == false) goto L19;
        return true;
    L5:
        if (r100 != ChronoField.INSTANT_SECONDS) goto L7;
        return true;
    L7:
        if (r100 != ChronoField.NANO_OF_SECOND) goto L9;
        return true;
    L9:
        if (r100 != ChronoField.MICRO_OF_SECOND) goto L11;
        return true;
    L11:
        if (r100 == ChronoField.MILLI_OF_SECOND) goto L24;
        return false;
    L24:
        return true;
    }

    public Instant minus(e r100) {
        return (Instant) r100.subtractFrom(this);
    }

    public Instant minusMillis(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L7:
        return plusMillis(-r100);
    }

    public Instant minusNanos(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L7:
        return plusNanos(-r100);
    }

    public Instant minusSeconds(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L7:
        return plusSeconds(-r100);
    }

    public Instant plus(e r100) {
        return (Instant) r100.addTo(this);
    }

    public Instant plusMillis(long r100) {
        return b(r100 / 1000, (r100 % 1000) * 1000000);
    }

    public Instant plusNanos(long r100) {
        return b(0, r100);
    }

    public Instant plusSeconds(long r100) {
        return b(r100, 0);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public <R> R query(h<R> r100) {
        if (r100 != g.f526470c) goto L7;
        return (R) ChronoUnit.NANOS;
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
        if (r100 != g.f526468a) goto L15;
        return null;
    L15:
        if (r100 != g.f526471d) goto L17;
        return null;
    L17:
        if (r100 != g.f526472e) goto L20;
        return null;
    L20:
        return r100.a(this);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public ValueRange range(f r100) {
        return super.range(r100);
    }

    public Instant truncatedTo(i r100) {
        if (r100 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r101 = r100.getDuration();
        if (r101.getSeconds() > 86400) goto L14;
        long r102 = r101.toNanos();
        if ((86400000000000L % r102) != 0) goto L12;
        long r103 = ((this.seconds % 86400) * C.NANOS_PER_SECOND) + ((long) this.nanos);
        return plusNanos((d.c(r103, r102) * r102) - r103);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.a
    public Instant with(org.threeten.bp.temporal.c r100) {
        return (Instant) r100.adjustInto(this);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeLong(this.seconds);
        r100.writeInt(this.nanos);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Instant r100) {
        return compareTo2(r100);
    }

    public boolean isSupported(i r100) {
        if ((r100 instanceof ChronoUnit) == true) goto L5;
        if (r100 != null) goto L13;
    L15:
        return false;
    L13:
        if (r100.isSupportedBy(this) == false) goto L15;
        return true;
    L5:
        if (r100.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r100 == ChronoUnit.DAYS) goto L18;
        return false;
    L18:
        return true;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a m10992minus(e r100) {
        return minus(r100);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a m10993plus(e r100) {
        return plus(r100);
    }

    @Override // org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(org.threeten.bp.temporal.c r100) {
        return with(r100);
    }

    public Instant(long r100, int r101) {
        this.seconds = r100;
        this.nanos = r101;
    }

    public static Instant a(long r100, int r101) {
        if ((((long) r101) | r100) != 0) goto L7;
        return EPOCH;
    L7:
        if (r100 < (-31557014167219200L)) goto L13;
        if (r100 > 31556889864403199L) goto L13;
        return new Instant(r100, r101);
    L13:
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant ofEpochSecond(long r100, long r101) {
        long r102 = 1000000000;
        return a(d.f(r100, d.c(r101, C.NANOS_PER_SECOND)), (int) (((r101 % r102) + r102) % r102));
    }

    public final Instant b(long r100, long r101) {
        if ((r100 | r101) != 0) goto L5;
        return this;
    L5:
        long r102 = d.f(d.f(this.seconds, r100), r101 / C.NANOS_PER_SECOND);
        long r103 = r101 % C.NANOS_PER_SECOND;
        return ofEpochSecond(r102, ((long) this.nanos) + r103);
    }

    @Override // org.threeten.bp.temporal.a
    public Instant minus(long r100, i r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    @Override // org.threeten.bp.temporal.a
    public Instant plus(long r100, i r101) {
        if ((r101 instanceof ChronoUnit) == false) goto L25;
        switch(b.f526243b[((ChronoUnit) r101).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L9:
        return plusSeconds(d.h(r100, 86400));
    L11:
        return plusSeconds(d.h(r100, 43200));
    L13:
        return plusSeconds(d.h(r100, AnnouncementViewModel.HOUR_DURATION));
    L15:
        return plusSeconds(d.h(r100, 60));
    L17:
        return plusSeconds(r100);
    L19:
        return plusMillis(r100);
    L21:
        return b(r100 / 1000000, (r100 % 1000000) * 1000);
    L23:
        return plusNanos(r100);
    L25:
        return (Instant) r101.addTo(this, r100);
    }

    @Override // org.threeten.bp.temporal.a
    public long until(org.threeten.bp.temporal.a r100, i r101) {
        Instant r102 = from(r100);
        if ((r101 instanceof ChronoUnit) == false) goto L25;
        switch(b.f526243b[((ChronoUnit) r101).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L9:
        return c(r102) / 86400;
    L11:
        return c(r102) / 43200;
    L13:
        return c(r102) / TimeUtils.SECONDS_PER_HOUR;
    L15:
        return c(r102) / 60;
    L17:
        return c(r102);
    L19:
        return d.k(r102.toEpochMilli(), toEpochMilli());
    L21:
        return d.f(d.h(d.k(r102.seconds, this.seconds), 1000000000), r102.nanos - this.nanos) / 1000;
    L23:
        return d.f(d.h(d.k(r102.seconds, this.seconds), 1000000000), r102.nanos - this.nanos);
    L25:
        return r101.between(this, r102);
    }

    @Override // org.threeten.bp.temporal.a
    public Instant with(f r100, long r101) {
        if ((r100 instanceof ChronoField) == false) goto L35;
        ChronoField r102 = (ChronoField) r100;
        r102.checkValidValue(r101);
        int r103 = b.f526242a[r102.ordinal()];
        if (r103 == 1) goto L30;
        if (r103 != 2) goto L9;
        int r104 = ((int) r101) * 1000;
        if (r104 == this.nanos) goto L28;
        return a(this.seconds, r104);
    L28:
        return this;
    L9:
        if (r103 != 3) goto L11;
        int r105 = ((int) r101) * 1000000;
        if (r105 == this.nanos) goto L23;
        return a(this.seconds, r105);
    L23:
        return this;
    L11:
        if (r103 != 4) goto L18;
        if (r101 == this.seconds) goto L16;
        return a(r101, this.nanos);
    L16:
        return this;
    L18:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L30:
        if (r101 == this.nanos) goto L33;
        return a(this.seconds, (int) r101);
    L33:
        return this;
    L35:
        return (Instant) r100.adjustInto(this, r101);
    }

    @Override // org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a minus(long r100, i r101) {
        return minus(r100, r101);
    }

    @Override // org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a plus(long r100, i r101) {
        return plus(r100, r101);
    }

    @Override // org.threeten.bp.temporal.a
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.a with(f r100, long r101) {
        return with(r100, r101);
    }
}
