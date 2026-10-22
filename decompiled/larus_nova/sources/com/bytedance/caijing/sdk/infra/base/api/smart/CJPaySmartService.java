package com.bytedance.caijing.sdk.infra.base.api.smart;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import oe4.a;
import oe4.b;
import oe4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Loe4/a;", "cjModelNames", "", "isEnable", "", "downloadModel", "preLoad", "releaseModel", "Loe4/c;", "request", "Loe4/b;", "callback", "", "runAsync", "Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "getSmartConfig", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJPaySmartService extends ICJService {
    int downloadModel(a r100);

    CJPaySmartConfig getSmartConfig();

    boolean isEnable(a r100);

    int preLoad(a r100);

    int releaseModel(a r100);

    void runAsync(c r100, b r101);
}
