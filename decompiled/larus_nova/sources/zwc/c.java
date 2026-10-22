package zwc;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c implements org.threeten.bp.temporal.b {
    public c() {
    }

    @Override // org.threeten.bp.temporal.b
    public int get(f r100) {
        return range(r100).checkValidIntValue(getLong(r100), r100);
    }

    @Override // org.threeten.bp.temporal.b
    public <R> R query(h<R> r100) {
        if (r100 != g.f526468a) goto L5;
        return null;
    L5:
        if (r100 != g.f526469b) goto L7;
        return null;
    L7:
        if (r100 != g.f526470c) goto L10;
        return null;
    L10:
        return r100.a(this);
    }

    @Override // org.threeten.bp.temporal.b
    public ValueRange range(f r100) {
        if ((r100 instanceof ChronoField) == false) goto L11;
        if (isSupported(r100) == false) goto L9;
        return r100.range();
    L9:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L11:
        return r100.rangeRefinedBy(this);
    }
}
