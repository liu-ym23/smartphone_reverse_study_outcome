package vg3;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.PdpSKUService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface e0 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    int G0();

    String H1();

    List<SkuSpecInfo> Z0();

    PdpSKUService.b b();

    void f1(Function0<Unit> r100);

    SkuRestoreState g0();

    void l(SkuProductDetailInfo r100);

    void q(SkuRestoreState r100, boolean r101);

    void u(Function1<? super SkuProductDetailInfo, Unit> r100);
}
