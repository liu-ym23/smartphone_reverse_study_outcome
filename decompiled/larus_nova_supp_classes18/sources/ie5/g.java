package ie5;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ String a;

    public g(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        x r4 = (x) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.y(this.a, null);
        return Unit.INSTANCE;
    }
}
