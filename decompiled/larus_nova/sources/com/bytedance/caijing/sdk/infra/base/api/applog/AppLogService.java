package com.bytedance.caijing.sdk.infra.base.api.applog;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/applog/AppLogService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "addCommonParams", "", "url", "isApi", "", "checkInstall", "onEventV3", "", "event", "param", "Lorg/json/JSONObject;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AppLogService extends ICJService {
    String addCommonParams(String r100, boolean r101);

    boolean checkInstall();

    void onEventV3(String r100, JSONObject r101);
}
