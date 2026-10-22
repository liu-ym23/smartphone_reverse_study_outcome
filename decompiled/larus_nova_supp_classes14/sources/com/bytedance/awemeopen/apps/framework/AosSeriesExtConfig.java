package com.bytedance.awemeopen.apps.framework;

import com.bytedance.awemeopen.export.api.AosSeriesConfigService;
import j64.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/AosSeriesExtConfig;", "Lcom/bytedance/awemeopen/export/api/AosSeriesConfigService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosSeriesExtConfig implements AosSeriesConfigService {
    public final /* synthetic */ AosSeriesConfigService a;

    static {
        new AosSeriesExtConfig();
    }

    private AosSeriesExtConfig() {
        AosSeriesConfigServiceDefaultImpl r0 = (AosSeriesConfigService) a.a(AosSeriesConfigService.class);
        if (r0 != null) goto L5;
        r0 = new AosSeriesConfigServiceDefaultImpl();
    L5:
        this.a = r0;
    }
}
