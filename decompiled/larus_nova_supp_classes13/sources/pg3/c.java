package pg3;

import com.bytedance.android.shopping.prepurchase.arch.container.aware.DataFetchLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c<STATE extends h, STORE> {
    PdpDataFetchService a(DataFetchLifecycleDispatcher r1);

    wg3.a b();

    xg3.d c(RenderLifecycleDispatcher r1);

    e d();

    PdpDynamicFeatureService e();

    PdpRootComponent f();
}
