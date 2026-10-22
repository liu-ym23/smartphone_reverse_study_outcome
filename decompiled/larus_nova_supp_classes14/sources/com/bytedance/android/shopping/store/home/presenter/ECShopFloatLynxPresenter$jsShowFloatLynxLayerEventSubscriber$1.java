package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.floatlayout.StoreFloatLayout;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFloatLynxPresenter$jsShowFloatLynxLayerEventSubscriber$1 implements ti.j {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public ECShopFloatLynxPresenter$jsShowFloatLynxLayerEventSubscriber$1(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void a(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (((ArrayList) this.a.u).contains(r12.optString("tag")) == true) goto L22;
        final JSONObject r0 = com.bytedance.android.ec.core.utils.z1.g(r12.optString("module"));
        ((ArrayList) this.a.u).add(r12.optString("tag"));
        final Context r5 = this.a.u().c();
        final Fragment r6 = this.a.u().a;
        if (r0 == null) goto L7;
        String r2 = r0.optString("data");
    L8:
        final JSONObject r7 = com.bytedance.android.ec.core.utils.z1.g(r2);
        if (r0 == null) goto L11;
        final String r8 = r0.optString("name");
    L12:
        final int r9 = this.a.e0();
        StoreFloatLayout r13 = new ECShopFloatLynxPresenter$jsShowFloatLynxLayerEventSubscriber$1$onReceiveJsEvent$1(this, r0, r5, r6, r7, r8, r9);
        if (r0 == null) goto L15;
        String r3 = r0.optString("module_url");
    L16:
        Pair[] r4 = new Pair[2];
        if (r0 == null) goto L19;
        String r1 = r0.optString("data");
    L20:
        r4[0] = TuplesKt.to("data", r1);
        r4[1] = TuplesKt.to("metaInfo", ECStoreParam.getTabMetaInfo$default(this.a.T().getStoreParam(), 0, null, 2, null));
        StoreFloatLayout.d(r13, r3, MapsKt.mapOf(r4));
        return;
    L19:
        r1 = null;
        goto L20
    L15:
        r3 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }
}
