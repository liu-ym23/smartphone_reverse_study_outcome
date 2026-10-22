package ha3;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Function<Observable<? extends Throwable>, Observable<?>> {
    public final int a;
    public final List<Integer> b;
    public int c;
    public final TimeUnit d;

    public final Object apply(Object r2) throws Exception {
        return ((Observable) r2).flatMap(new a(this));
    }

    public b(int r1, List<Integer> r2, TimeUnit r3) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.c = 0;
    }
}
