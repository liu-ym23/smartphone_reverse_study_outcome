package j25;

import io.reactivex.Flowable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t {
    public static Flowable<Boolean> a(final String r1, Map<String, String> r2, final boolean r3, final String r4) {
        if (r2.isEmpty() == false) goto L7;
        return Flowable.error(new IllegalStateException("empty files"));
    L7:
        return Flowable.just(r2).observeOn(fo5.d.b()).map(new r(r4, r1, r3)).map(new s());
    }
}
