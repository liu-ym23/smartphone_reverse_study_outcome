package com.bytedance.caijing.sdk.infra.base.api.network;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/network/CJNetworkService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "isAvailable", "isWifi", "", "getNetType", "Lcom/bytedance/caijing/sdk/infra/base/api/network/CJNetworkService$a;", "listener", "", "registerNetStateChangeListener", "unRegisterNetStateChangeListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJNetworkService extends ICJService {

    public interface a {
    }

    String getNetType(Context r100);

    boolean isAvailable(Context r100);

    boolean isWifi(Context r100);

    void registerNetStateChangeListener(a r100);

    void unRegisterNetStateChangeListener(a r100);
}
