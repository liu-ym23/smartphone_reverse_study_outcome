package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static void a() {
        Intrinsics.checkNotNullParameter("ecom_store_rerank", "businessName");
        String r0 = ECAppInfoService.e.getAppId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        PitayaCoreFactory.getCore(r0).runTask("ecom_store_rerank", new PTYTaskData(null), new PTYTaskConfig(false, null, 0.0f, 7, null), new ECShopProductListPitayaManager$runTask$1());
    }

    static {
    }
}
