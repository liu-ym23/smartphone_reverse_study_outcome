package com.bytedance.caijing.sdk.infra.base.api.location;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\u000b\fJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/location/CJLocationService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "token", "auth", "Lcom/bytedance/caijing/sdk/infra/base/api/location/CJLocationService$a;", "callback", "", "tryToLocate", "Lcom/bytedance/caijing/sdk/infra/base/api/location/CJLocationService$b;", "addSubmitNotification", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJLocationService extends ICJService {

    public interface a {
    }

    public interface b {
    }

    void addSubmitNotification(String r100, String r101, b r102);

    void tryToLocate(String r100, String r101, a r102);
}
