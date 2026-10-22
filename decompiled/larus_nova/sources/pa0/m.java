package pa0;

import com.bytedance.android.live.recharge.platform.service.z;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements Observer<e> {
    public m() {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        jy0.b.b("Incentive/UserIncomeRepository", "updateIncomeInfo error", r100);
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r101 = z.a();
        if (r101 == null) goto L5;
        r101.E7();
        iw0.a r102 = iw0.a.f496137a;
    L6:
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // io.reactivex.Observer
    public final void onNext(e r100) {
        e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        jy0.b.a("Incentive/UserIncomeRepository", "updateIncomeInfo success");
        o.f528350a.setValue(r101);
    }
}
