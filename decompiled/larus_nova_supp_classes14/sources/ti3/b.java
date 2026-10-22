package ti3;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.lifecycle.m;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ ECStoreParam a;

    public b(ECStoreParam r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ECStorePreloadInfoResponse r4 = (ECStorePreloadInfoResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
        if (r1 == null) goto L5;
        r1.z(r4);
    L5:
        return r4;
    }
}
