package com.larus.caijing_pay.impl.config;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bd4.a;
import com.bytedance.caijing.sdk.infra.base.api.cloudunionpay.CloudUnionPayService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CloudUnionPayServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/cloudunionpay/CloudUnionPayService;", "<init>", "()V", "pay", "", "activity", "Landroid/app/Activity;", "payData", "", "callback", "Lcom/bytedance/caijing/sdk/infra/base/api/cloudunionpay/CloudUnionPayResultCallback;", "getVersion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloudUnionPayServiceImpl implements CloudUnionPayService {
    public CloudUnionPayServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.cloudunionpay.CloudUnionPayService
    public String getVersion() {
        return "3.5.18";
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.cloudunionpay.CloudUnionPayService
    public void pay(Activity r100, String r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intent r103 = new Intent(r100, CJCloudUnionPayResultActivity.class);
        Bundle r104 = new Bundle();
        r104.putString("payData", r101);
        r103.putExtras(r104);
        r100.startActivity(r103);
    }
}
