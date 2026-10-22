package com.larus.business.accessbility.impl;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import defpackage.h;
import defpackage.i;
import defpackage.l;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\u0006H'J\u0012\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0003H'¨\u0006\f"}, d2 = {"Lcom/larus/business/accessbility/impl/AccessibilityHttpService;", "", "getAccessibilityConfig", "Lcom/bytedance/retrofit2/Call;", "LAccessibilityLabelConfigResponse;", "labelId", "", "getAccessibilityData", "LAccessibilityDataResponse;", "url", "getAccessibilityDebugConfigData", "LAccessibilityDebugDataResponse;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AccessibilityHttpService {
    @GET("/v3/accessibility/label?product_id=100150")
    Call<l> getAccessibilityConfig(@Query(a.KEY_LABEL_ID) String r100);

    @GET("{url}")
    Call<h> getAccessibilityData(@Path("url") String r100);

    @GET("/api/application/get_json_dev_for_native?app_id=482431&platform=android")
    Call<i> getAccessibilityDebugConfigData();
}
