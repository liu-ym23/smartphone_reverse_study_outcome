package com.bytedance.caijing.sdk.infra.base.api.router;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J4\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/router/CJHostRouterMonitorService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "injectRouteOutCertIdToIntent", "", "certId", "", "intent", "Landroid/content/Intent;", "notifyRouteOutCertId", "bizReportParams", "", "", "bindActivity", "Landroid/app/Activity;", "removeNotifiedRouteOutCertId", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJHostRouterMonitorService extends ICJService {
    void injectRouteOutCertIdToIntent(String r100, Intent r101);

    void notifyRouteOutCertId(String r100, Map<String, ? extends Object> r101, Activity r102);

    void removeNotifiedRouteOutCertId(String r100);
}
