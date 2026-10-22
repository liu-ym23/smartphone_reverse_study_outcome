package com.bytedance.caijing.sdk.infra.base.api.trip.host;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import qe4.a;
import qe4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/ITripHostDepend;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lqe4/a;", "getBdpHelper", "Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/IDeviceHelper;", "getDeviceHelper", "", "isDarkMode", "isAMapPluginAvailable", "Lqe4/b;", "getTripTaxiHelper", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ITripHostDepend extends ICJService {
    a getBdpHelper();

    IDeviceHelper getDeviceHelper();

    b getTripTaxiHelper();

    boolean isAMapPluginAvailable();

    boolean isDarkMode();
}
