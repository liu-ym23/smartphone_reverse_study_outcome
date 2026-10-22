package com.bytedance.caijing.sdk.infra.base.api.sec;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/sec/ICJSwordEncryptDepend;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", LBSLightLocationTraceLogger.ENCRYPT, "", "plainText", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJSwordEncryptDepend extends ICJService {
    String encrypt(String r100);
}
