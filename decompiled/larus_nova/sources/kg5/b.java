package kg5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Function<Result<NonProguard>, NonProguard> {
    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final NonProguard apply(Result<NonProguard> r100) throws Exception {
        Result<NonProguard> r101 = r100;
        if (r101 == null) goto L11;
        if (r101.code != 0) goto L11;
        if (r101.getData() == null) goto L11;
        return (NonProguard) r101.getData();
    L11:
        throw new Exception(b.class.getSimpleName() + " access error: " + r101);
    }
}
