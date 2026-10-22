package zwc;

import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b extends c implements org.threeten.bp.temporal.a {
    public b() {
    }

    public org.threeten.bp.temporal.a minus(e r100) {
        return r100.subtractFrom(this);
    }

    public org.threeten.bp.temporal.a plus(e r100) {
        return r100.addTo(this);
    }

    public org.threeten.bp.temporal.a with(org.threeten.bp.temporal.c r100) {
        return r100.adjustInto(this);
    }

    public org.threeten.bp.temporal.a minus(long r100, i r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }
}
