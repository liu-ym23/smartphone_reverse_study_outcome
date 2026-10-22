package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ZoneRules {

    public static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;
        private final ZoneOffset offset;

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition getTransition(LocalDateTime r100) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isDaylightSavings(Instant r100) {
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isFixedOffset() {
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition nextTransition(Instant r100) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition previousTransition(Instant r100) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public int hashCode() {
            return ((((this.offset.hashCode() + 31) ^ 1) ^ 1) ^ (this.offset.hashCode() + 31)) ^ 1;
        }

        public String toString() {
            return "FixedRules:" + this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffsetTransitionRule> getTransitionRules() {
            return Collections.emptyList();
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffsetTransition> getTransitions() {
            return Collections.emptyList();
        }

        public Fixed(ZoneOffset r100) {
            this.offset = r100;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Fixed) == false) goto L10;
            return this.offset.equals(((Fixed) r100).offset);
        L10:
            if ((r100 instanceof StandardZoneRules) == false) goto L18;
            StandardZoneRules r101 = (StandardZoneRules) r100;
            if (r101.isFixedOffset() == true) goto L14;
        L16:
            return false;
        L14:
            if (this.offset.equals(r101.getOffset(Instant.EPOCH)) == false) goto L16;
            return true;
        L18:
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public Duration getDaylightSavings(Instant r100) {
            return Duration.ZERO;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(Instant r100) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getStandardOffset(Instant r100) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffset> getValidOffsets(LocalDateTime r100) {
            return Collections.singletonList(this.offset);
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(LocalDateTime r100) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isValidOffset(LocalDateTime r100, ZoneOffset r101) {
            return this.offset.equals(r101);
        }
    }

    public abstract boolean equals(Object r100);

    public abstract Duration getDaylightSavings(Instant r100);

    public abstract ZoneOffset getOffset(Instant r100);

    public abstract ZoneOffset getOffset(LocalDateTime r100);

    public abstract ZoneOffset getStandardOffset(Instant r100);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime r100);

    public abstract List<ZoneOffsetTransitionRule> getTransitionRules();

    public abstract List<ZoneOffsetTransition> getTransitions();

    public abstract List<ZoneOffset> getValidOffsets(LocalDateTime r100);

    public abstract int hashCode();

    public abstract boolean isDaylightSavings(Instant r100);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime r100, ZoneOffset r101);

    public abstract ZoneOffsetTransition nextTransition(Instant r100);

    public abstract ZoneOffsetTransition previousTransition(Instant r100);

    public ZoneRules() {
    }

    public static ZoneRules of(ZoneOffset r100) {
        zwc.d.d(r100, "offset");
        return new Fixed(r100);
    }

    public static ZoneRules of(ZoneOffset r100, ZoneOffset r101, List<ZoneOffsetTransition> r102, List<ZoneOffsetTransition> r110, List<ZoneOffsetTransitionRule> r111) {
        zwc.d.d(r100, "baseStandardOffset");
        zwc.d.d(r101, "baseWallOffset");
        zwc.d.d(r102, "standardOffsetTransitionList");
        zwc.d.d(r110, "transitionList");
        zwc.d.d(r111, "lastRules");
        return new StandardZoneRules(r100, r101, r102, r110, r111);
    }
}
