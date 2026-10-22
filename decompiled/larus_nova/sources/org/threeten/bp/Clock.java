package org.threeten.bp;

import com.ss.ttm.player.C;
import java.io.Serializable;
import zwc.d;

/* JADX INFO: loaded from: classes41.dex */
public abstract class Clock {

    public static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof FixedClock) == false) goto L10;
            FixedClock r101 = (FixedClock) r100;
            if (this.instant.equals(r101.instant) == true) goto L7;
            return false;
        L7:
            if (this.zone.equals(r101.zone) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new FixedClock(this.instant, r100);
        }

        public FixedClock(Instant r100, ZoneId r101) {
            this.instant = r100;
            this.zone = r101;
        }
    }

    public static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.baseClock.instant().plus(this.offset);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return d.f(this.baseClock.millis(), this.offset.toMillis());
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof OffsetClock) == false) goto L10;
            OffsetClock r101 = (OffsetClock) r100;
            if (this.baseClock.equals(r101.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.offset.equals(r101.offset) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new OffsetClock(this.baseClock.withZone(r100), this.offset);
        }

        public OffsetClock(Clock r100, Duration r101) {
            this.baseClock = r100;
            this.offset = r101;
        }
    }

    public static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        public SystemClock(ZoneId r100) {
            this.zone = r100;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof SystemClock) == true) goto L5;
            return false;
        L5:
            return this.zone.equals(((SystemClock) r100).zone);
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new SystemClock(r100);
        }
    }

    public static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r100 = this.baseClock.hashCode();
            long r101 = this.tickNanos;
            return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            if ((this.tickNanos % 1000000) != 0) goto L6;
            long r100 = this.baseClock.millis();
            long r101 = this.tickNanos / 1000000;
            return Instant.ofEpochMilli(r100 - (((r100 % r101) + r101) % r101));
        L6:
            Instant r102 = this.baseClock.instant();
            long r103 = r102.getNano();
            long r104 = this.tickNanos;
            return r102.minusNanos(((r103 % r104) + r104) % r104);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            long r100 = this.baseClock.millis();
            long r101 = this.tickNanos / 1000000;
            return r100 - (((r100 % r101) + r101) % r101);
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof TickClock) == false) goto L10;
            TickClock r101 = (TickClock) r100;
            if (this.baseClock.equals(r101.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.tickNanos != r101.tickNanos) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new TickClock(this.baseClock.withZone(r100), this.tickNanos);
        }

        public TickClock(Clock r100, long r101) {
            this.baseClock = r100;
            this.tickNanos = r101;
        }
    }

    public abstract ZoneId getZone();

    public abstract Instant instant();

    public abstract Clock withZone(ZoneId r100);

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public long millis() {
        return instant().toEpochMilli();
    }

    public Clock() {
    }

    public static Clock system(ZoneId r100) {
        d.d(r100, "zone");
        return new SystemClock(r100);
    }

    public static Clock tickMinutes(ZoneId r100) {
        return new TickClock(system(r100), 60000000000L);
    }

    public static Clock tickSeconds(ZoneId r100) {
        return new TickClock(system(r100), C.NANOS_PER_SECOND);
    }

    public boolean equals(Object r100) {
        return super.equals(r100);
    }

    public static Clock fixed(Instant r100, ZoneId r101) {
        d.d(r100, "fixedInstant");
        d.d(r101, "zone");
        return new FixedClock(r100, r101);
    }

    public static Clock offset(Clock r100, Duration r101) {
        d.d(r100, "baseClock");
        d.d(r101, "offsetDuration");
        if (r101.equals(Duration.ZERO) == false) goto L6;
        return r100;
    L6:
        return new OffsetClock(r100, r101);
    }

    public static Clock tick(Clock r100, Duration r101) {
        d.d(r100, "baseClock");
        d.d(r101, "tickDuration");
        if (r101.isNegative() == true) goto L17;
        long r102 = r101.toNanos();
        if ((r102 % 1000000) == 0) goto L10;
        if ((C.NANOS_PER_SECOND % r102) == 0) goto L10;
        throw new IllegalArgumentException("Invalid tick duration");
    L10:
        if (r102 > 1) goto L13;
        return r100;
    L13:
        return new TickClock(r100, r102);
    L17:
        throw new IllegalArgumentException("Tick duration must not be negative");
    }
}
