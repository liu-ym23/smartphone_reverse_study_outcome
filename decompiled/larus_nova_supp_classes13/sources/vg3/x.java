package vg3;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService$onAttach$1;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface x extends com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore>, k {

    public static final class a {
        public static /* synthetic */ void a(x r0, boolean r1, String r2, Map r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            r0.w0(r2, r3, false, null);
        }
    }

    void D1(PackResponseDTO r1);

    PdpSliceLocalCacheHelper M();

    void Q();

    void T(Map<String, ? extends Object> r1, boolean r2);

    void c0(boolean r1);

    void c1(Map<String, ? extends Object> r1);

    void h1(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r1);

    void o0(ProductDetailEventService$onAttach$1.b r1);

    void w0(String r1, Map r2, boolean r3, Function1 r4);

    void w1(m0 r1);
}
