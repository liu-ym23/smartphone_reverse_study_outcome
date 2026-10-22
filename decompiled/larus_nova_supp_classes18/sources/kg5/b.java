package kg5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Function<Result<NonProguard>, NonProguard> {
    public b() {
    }

    public final Object apply(Object r4) throws Exception {
        Result r5 = (Result) r4;
        if (r5 == null) goto L11;
        if (r5.code != 0) goto L11;
        if (r5.getData() == null) goto L11;
        return r5.getData();
    L11:
        throw new Exception(b.class.getSimpleName() + " access error: " + r5);
    }
}
