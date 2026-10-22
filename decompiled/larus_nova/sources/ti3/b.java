package ti3;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.lifecycle.m;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreParam f546059a;

    public b(ECStoreParam r100) {
        this.f546059a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ECStorePreloadInfoResponse r101 = (ECStorePreloadInfoResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        Map<Long, m> r102 = com.bytedance.android.shopping.store.lifecycle.a.f185441a;
        m r103 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.f546059a.getLifecycleMonitorId()));
        if (r103 == null) goto L5;
        r103.z(r101);
    L5:
        return r101;
    }
}
