package sa0;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import pa0.e;
import pa0.k;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f541139a;

    public b(c r100) {
        this.f541139a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((e) r100, "it");
        c r101 = this.f541139a;
        e r102 = (e) r101.f541141b.a().f90981b;
        if (r102 == null) goto L7;
        return r101.a((k) r102);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.incentive.balance.income.UserIncomeInfoDy");
    }
}
