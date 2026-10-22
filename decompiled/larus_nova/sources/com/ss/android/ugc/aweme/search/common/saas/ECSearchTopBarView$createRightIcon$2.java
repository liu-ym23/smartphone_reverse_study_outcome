package com.ss.android.ugc.aweme.search.common.saas;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/common/saas/ECSearchTopBarView$createRightIcon$2", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickMenuListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchTopBarView$createRightIcon$2 implements CapsuleComponent.OnClickMenuListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECSearchTopBarView f451995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IECAIHostService f451996b;

    @Override // com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent.OnClickMenuListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        IECAIHostService r111 = this.f451996b;
        Context r100 = this.f451995a.getContext();
        PanelItem r112 = new PanelItem(BuyNowUrlType.ORDER_LIST, "我的订单", 1, null, null, 0, 56, null);
        r112.setOnClickListener(new ECSearchTopBarView$createRightIcon$2$onClick$$inlined$also$lambda$1(this));
        Unit r101 = Unit.INSTANCE;
        r111.showAppletPanel(r100, "search_result", CollectionsKt.listOf(r112), null);
    }

    public ECSearchTopBarView$createRightIcon$2(ECSearchTopBarView r100, IECAIHostService r101) {
        this.f451995a = r100;
        this.f451996b = r101;
    }
}
