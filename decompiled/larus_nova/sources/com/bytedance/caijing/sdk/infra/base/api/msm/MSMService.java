package com.bytedance.caijing.sdk.infra.base.api.msm;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/msm/MSMService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "sceneName", "aid", "", "report", "", "var0", "Lcom/bytedance/caijing/sdk/infra/base/api/msm/MSMService$a;", "callback", "registerScenePageNameCallback", "checkMSSDKInstalled", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface MSMService extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public interface a {
        int getScenePageName();
    }

    int checkMSSDKInstalled();

    int registerScenePageNameCallback(int r100, a r101);

    void report(String r100, String r101);
}
