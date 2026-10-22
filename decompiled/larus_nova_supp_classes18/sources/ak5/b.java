package ak5;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Function<k, Flowable<k>> {
    public final h a;

    public b(h r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) throws Exception {
        k r4 = (k) r3;
        if (this.a != null) goto L6;
        tt5.a.d("CheckLoginFun", "login checker is null.");
        return Flowable.just(r4);
    L6:
        return Flowable.create(new a(this, r4), BackpressureStrategy.BUFFER);
    }
}
