package ak5;

import io.reactivex.functions.Function;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r<T extends Serializable> implements Function<String, T> {
    public final s<T> a;

    public r(s<T> r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) throws Exception {
        s<T> r0 = this.a;
        return r0.parse((String) r2);
    }
}
