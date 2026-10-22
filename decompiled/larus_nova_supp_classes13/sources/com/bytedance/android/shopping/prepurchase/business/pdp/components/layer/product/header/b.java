package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements x {
    public final e0 a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final List<SkuSpecInfo> v() {
        return this.a.Z0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final SkuRestoreState w() {
        return this.a.g0();
    }

    public b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceRegistry");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r3 = r2.getService(e0.class);
        Intrinsics.checkNotNull(r3);
        this.a = (e0) r3;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void l(SkuProductDetailInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "skuProductDetailInfo");
        this.a.l(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.u(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void q(SkuRestoreState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.q(r2, r3);
    }
}
