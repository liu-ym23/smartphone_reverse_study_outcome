package tr2;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.scope.o;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements o, a {
    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // tr2.a
    public final Object Qm(Object r100) {
        Intrinsics.checkNotNullParameter("revlink_opt_type", "faName");
        LiveData r101 = Ki("revlink_opt_type", r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    @Override // tr2.a
    public final <T> LiveData<T> Ki(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        IStrategyService r102 = (IStrategyService) k.f(IStrategyService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return IStrategyService.a.a(r102, r100, r101, false, 12);
    }
}
