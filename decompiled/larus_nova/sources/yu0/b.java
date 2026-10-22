package yu0;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f569216a;

    public b(Function0 r100) {
        this.f569216a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Unit) r100, "it");
        jy0.b.d("PrivilegeRepository", "exchange request is completed");
        return (SingleSource) this.f569216a.invoke();
    }
}
