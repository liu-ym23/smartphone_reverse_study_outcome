package org.threeten.bp.chrono;

import java.util.Iterator;
import java.util.List;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c implements org.threeten.bp.temporal.e {
    public c() {
    }

    @Override // org.threeten.bp.temporal.e
    public abstract org.threeten.bp.temporal.a addTo(org.threeten.bp.temporal.a r100);

    public abstract boolean equals(Object r100);

    @Override // org.threeten.bp.temporal.e
    public abstract long get(i r100);

    public abstract e getChronology();

    @Override // org.threeten.bp.temporal.e
    public abstract List<i> getUnits();

    public abstract int hashCode();

    public abstract c minus(org.threeten.bp.temporal.e r100);

    public abstract c multipliedBy(int r100);

    public c negated() {
        return multipliedBy(-1);
    }

    public abstract c normalized();

    public abstract c plus(org.threeten.bp.temporal.e r100);

    @Override // org.threeten.bp.temporal.e
    public abstract org.threeten.bp.temporal.a subtractFrom(org.threeten.bp.temporal.a r100);

    public abstract String toString();

    public boolean isNegative() {
        Iterator<i> r100 = getUnits().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (get(r100.next()) >= 0) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isZero() {
        Iterator<i> r100 = getUnits().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (get(r100.next()) == 0) goto L4;
        return false;
    L9:
        return true;
    }

    public static c between(a r100, a r101) {
        zwc.d.d(r100, "startDateInclusive");
        zwc.d.d(r101, "endDateExclusive");
        return r100.until(r101);
    }
}
