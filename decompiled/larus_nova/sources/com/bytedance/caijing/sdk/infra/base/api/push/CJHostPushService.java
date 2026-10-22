package com.bytedance.caijing.sdk.infra.base.api.push;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/push/CJHostPushService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "isConnected", "()Ljava/lang/Boolean;", "Lcom/bytedance/caijing/sdk/infra/base/api/push/CJHostPushService$a;", "listener", "", "registerOnWsStatusChangedListener", "unregisterOnWsStatusChangedListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJHostPushService extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public interface a {
    }

    Boolean isConnected();

    void registerOnWsStatusChangedListener(a r100);

    void unregisterOnWsStatusChangedListener(a r100);
}
