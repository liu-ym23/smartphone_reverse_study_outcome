package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "pageInfoMap");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        v93.a.c.getClass();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter("pitaya_analyze_interest_on_good", "business");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter("lastest_ecom_video_behavior", "key");     // Catch: Throwable -> L22
        IFeatureCore r2 = FeatureCoreFactory.INSTANCE.getFeatureCore(String.valueOf(HybridAppInfoService.p.getAppId()));     // Catch: Throwable -> L22
        Unit r4 = null;
        if (r2 == null) goto L8;
        IKVStore r3 = r2.createInMemoryKVStore("pitaya_analyze_interest_on_good");     // Catch: Throwable -> L22
        if (r3 == null) goto L8;
        Object r6 = r3.getValueForKey("lastest_ecom_video_behavior");     // Catch: Throwable -> L22
    L9:
        if (r6 == null) goto L20;
        String r7 = r6.toString();     // Catch: Throwable -> L22
        if (r7 == null) goto L20;
        String r8 = new JSONObject(r7).optString("group_id");     // Catch: Throwable -> L22
        if (r8.length() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L18;
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L18:
        return Intrinsics.areEqual(r8, r5.get("groupId"));
    L15:
        r9 = false;
    L20:
        Result.constructor-impl(r4);     // Catch: Throwable -> L22
    L24:
        return false;
    L8:
        r6 = null;
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
