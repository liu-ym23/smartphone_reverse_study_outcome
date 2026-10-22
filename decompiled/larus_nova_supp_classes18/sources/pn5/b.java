package pn5;

import android.text.Spanned;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class b implements Predicate {
    public final /* synthetic */ Spanned a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(Spanned r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final /* synthetic */ Predicate and(Predicate r1) {
        return Predicate.-CC.$default$and(this, r1);
    }

    public final /* synthetic */ Predicate negate() {
        return Predicate.-CC.$default$negate(this);
    }

    public final /* synthetic */ Predicate or(Predicate r1) {
        return Predicate.-CC.$default$or(this, r1);
    }

    public final boolean test(Object r3) {
        Spanned r0 = this.a;
        int r1 = this.b;
        if (r0.getSpanStart((zm5.d) r3) == r1) goto L5;
        return true;
    L5:
        return false;
    }
}
