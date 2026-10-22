package com.bytedance.caijing.sdk.infra.base.api.preload;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/preload/CJBizPreloadService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "checkYuefuTemplatePreloaded", "", "mainUrl", "", "preloadForest", "", "containerType", "subResource", "Lorg/json/JSONArray;", "preloadYuefuTemplate", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJBizPreloadService extends ICJService {
    boolean checkYuefuTemplatePreloaded(String r100);

    void preloadForest(String r100, String r101, JSONArray r102);

    void preloadYuefuTemplate();
}
