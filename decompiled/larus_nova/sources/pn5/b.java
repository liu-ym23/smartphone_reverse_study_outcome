package pn5;

import android.text.Spanned;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spanned f529960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f529961b;

    public /* synthetic */ b(Spanned r100, int r101) {
        this.f529960a = r100;
        this.f529961b = r101;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate r100) {
        return Predicate.CC.$default$and(this, r100);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate r100) {
        return Predicate.CC.$default$or(this, r100);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r100) {
        Spanned r101 = this.f529960a;
        int r102 = this.f529961b;
        if (r101.getSpanStart((zm5.d) r100) == r102) goto L5;
        return true;
    L5:
        return false;
    }
}
