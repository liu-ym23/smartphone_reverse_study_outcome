package com.bytedance.caijing.sdk.infra.base.api.cloudunionpay;

import android.app.Activity;
import bd4.a;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/cloudunionpay/CloudUnionPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/app/Activity;", "activity", "", "payData", "Lbd4/a;", "callback", "", "pay", "getVersion", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CloudUnionPayService extends ICJService {
    String getVersion();

    void pay(Activity r100, String r101, a r102);
}
