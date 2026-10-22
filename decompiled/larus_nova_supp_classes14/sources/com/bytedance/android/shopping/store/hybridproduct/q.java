package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements JsEventSubscriber {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public q(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onReceiveJsEvent(Js2NativeEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "jsEvent");
        XReadableMap r6 = r5.getParams();
        if (r6 == null) goto L15;
        Map r7 = r6.toMap();
        if (r7 == null) goto L16;
        Object r0 = r7.get("sec_shop_id");
        String r1 = String.valueOf(r7.get("product_id"));
        String r2 = String.valueOf(r7.get("from"));
        String r8 = String.valueOf(r7.get("status"));
        if ((!Intrinsics.areEqual(r0, this.a.m0().getStoreParam().getSecShopId())) == false) goto L11;
        return;
    L11:
        if ((!Intrinsics.areEqual(r2, "new_category_tab")) == false) goto L13;
        return;
    L13:
        jm.a<ej3.a> r3 = this.a.m0().getUpdateProduct();
        ej3.a r4 = new ej3.a();
        r4.a = r1;
        r4.b = r8;
        Unit r9 = Unit.INSTANCE;
        r3.setValue(r4);
        return;
    L16:
        return;
    }
}
