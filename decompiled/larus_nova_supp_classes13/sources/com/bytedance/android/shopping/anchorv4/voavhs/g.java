package com.bytedance.android.shopping.anchorv4.voavhs;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements x {
    public final AnchorV4VM a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final List<SkuSpecInfo> v() {
        CommonMeta r0 = this.a.commonMeta();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSkuSpecInfo();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final SkuRestoreState w() {
        return this.a.skuStore();
    }

    public g(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void l(SkuProductDetailInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "skuProductDetailInfo");
        this.a.notifyRefreshDetailInfo(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerRefreshDetailInfoListener(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void q(SkuRestoreState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.justUpdateSkuStoreArray(r2, r3);
    }
}
