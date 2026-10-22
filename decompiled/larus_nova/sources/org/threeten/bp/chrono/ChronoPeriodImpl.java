package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes41.dex */
final class ChronoPeriodImpl extends c implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final e chronology;
    private final int days;
    private final int months;
    private final int years;

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.e
    public List<i> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new i[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    @Override // org.threeten.bp.chrono.c
    public int hashCode() {
        return ((this.chronology.hashCode() + Integer.rotateLeft(this.years, 16)) + Integer.rotateLeft(this.months, 8)) + this.days;
    }

    @Override // org.threeten.bp.chrono.c
    public c normalized() {
        e r100 = this.chronology;
        ChronoField r101 = ChronoField.MONTH_OF_YEAR;
        if (r100.range(r101).isFixed() == false) goto L6;
        long r102 = (this.chronology.range(r101).getMaximum() - this.chronology.range(r101).getMinimum()) + 1;
        long r103 = (((long) this.years) * r102) + ((long) this.months);
        int r104 = zwc.d.l(r103 / r102);
        int r105 = zwc.d.l(r103 % r102);
        return new ChronoPeriodImpl(this.chronology, r104, r105, this.days);
    L6:
        return this;
    }

    @Override // org.threeten.bp.chrono.c
    public String toString() {
        if (isZero() == true) goto L5;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.chronology);
        r100.append(" P");
        int r101 = this.years;
        if (r101 == 0) goto L9;
        r100.append(r101);
        r100.append('Y');
    L9:
        int r102 = this.months;
        if (r102 == 0) goto L12;
        r100.append(r102);
        r100.append('M');
    L12:
        int r103 = this.days;
        if (r103 == 0) goto L16;
        r100.append(r103);
        r100.append('D');
    L16:
        return r100.toString();
    L5:
        return this.chronology + " P0D";
    }

    @Override // org.threeten.bp.chrono.c
    public e getChronology() {
        return this.chronology;
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.a addTo(org.threeten.bp.temporal.a r100) {
        zwc.d.d(r100, "temporal");
        e r101 = (e) r100.query(g.f526469b);
        if (r101 != null) goto L5;
    L9:
        int r102 = this.years;
        if (r102 == 0) goto L12;
        r100 = r100.plus(r102, ChronoUnit.YEARS);
    L12:
        int r103 = this.months;
        if (r103 == 0) goto L15;
        r100 = r100.plus(r103, ChronoUnit.MONTHS);
    L15:
        int r104 = this.days;
        if (r104 != 0) goto L18;
        return r100;
    L18:
        return r100.plus(r104, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r101) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r101.getId());
    }

    @Override // org.threeten.bp.chrono.c
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChronoPeriodImpl) == false) goto L18;
        ChronoPeriodImpl r101 = (ChronoPeriodImpl) r100;
        if (this.years == r101.years) goto L10;
    L16:
        return false;
    L10:
        if (this.months != r101.months) goto L16;
        if (this.days != r101.days) goto L16;
        if (this.chronology.equals(r101.chronology) == false) goto L16;
        return true;
    L18:
        return false;
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.e
    public long get(i r100) {
        if (r100 != ChronoUnit.YEARS) goto L8;
        int r101 = this.years;
    L6:
        return r101;
    L8:
        if (r100 != ChronoUnit.MONTHS) goto L11;
        r101 = this.months;
        goto L6
    L11:
        if (r100 != ChronoUnit.DAYS) goto L14;
        r101 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r100);
    }

    @Override // org.threeten.bp.chrono.c
    public c minus(org.threeten.bp.temporal.e r100) {
        if ((r100 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r101 = (ChronoPeriodImpl) r100;
        if (r101.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, zwc.d.j(this.years, r101.years), zwc.d.j(this.months, r101.months), zwc.d.j(this.days, r101.days));
    L9:
        throw new DateTimeException("Unable to subtract amount: " + r100);
    }

    @Override // org.threeten.bp.chrono.c
    public c multipliedBy(int r100) {
        return new ChronoPeriodImpl(this.chronology, zwc.d.g(this.years, r100), zwc.d.g(this.months, r100), zwc.d.g(this.days, r100));
    }

    @Override // org.threeten.bp.chrono.c
    public c plus(org.threeten.bp.temporal.e r100) {
        if ((r100 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r101 = (ChronoPeriodImpl) r100;
        if (r101.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, zwc.d.e(this.years, r101.years), zwc.d.e(this.months, r101.months), zwc.d.e(this.days, r101.days));
    L9:
        throw new DateTimeException("Unable to add amount: " + r100);
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.a subtractFrom(org.threeten.bp.temporal.a r100) {
        zwc.d.d(r100, "temporal");
        e r101 = (e) r100.query(g.f526469b);
        if (r101 != null) goto L5;
    L9:
        int r102 = this.years;
        if (r102 == 0) goto L12;
        r100 = r100.minus(r102, ChronoUnit.YEARS);
    L12:
        int r103 = this.months;
        if (r103 == 0) goto L15;
        r100 = r100.minus(r103, ChronoUnit.MONTHS);
    L15:
        int r104 = this.days;
        if (r104 != 0) goto L18;
        return r100;
    L18:
        return r100.minus(r104, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r101) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r101.getId());
    }

    public ChronoPeriodImpl(e r100, int r101, int r102, int r103) {
        this.chronology = r100;
        this.years = r101;
        this.months = r102;
        this.days = r103;
    }
}
