package vg3;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService$onAttach$1;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface x extends com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore>, k {

    public static final class a {
        public static /* synthetic */ void a(x r100, boolean r101, String r102, Map r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.w0(r102, r103, false, null);
        }
    }

    void D1(PackResponseDTO r100);

    PdpSliceLocalCacheHelper M();

    void Q();

    void T(Map<String, ? extends Object> r100, boolean r101);

    void c0(boolean r100);

    void c1(Map<String, ? extends Object> r100);

    void h1(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r100);

    void o0(ProductDetailEventService$onAttach$1.b r100);

    void w0(String r100, Map r101, boolean r102, Function1 r103);

    void w1(m0 r100);
}
