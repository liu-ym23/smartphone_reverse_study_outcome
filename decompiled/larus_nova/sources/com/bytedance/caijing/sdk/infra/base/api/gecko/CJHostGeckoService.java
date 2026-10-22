package com.bytedance.caijing.sdk.infra.base.api.gecko;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import wd4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/gecko/CJHostGeckoService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "tag", "Lwd4/a;", "listener", "", "updateGeckoByConfig", "accessKey", "channel", "cleanCache", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJHostGeckoService extends ICJService {
    void cleanCache(String r100, String r101);

    void updateGeckoByConfig(String r100, a r101);
}
