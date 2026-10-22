package ie5;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f489483a;

    public g(String r100) {
        this.f489483a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        x r101 = (x) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        r101.y(this.f489483a, null);
        return Unit.INSTANCE;
    }
}
