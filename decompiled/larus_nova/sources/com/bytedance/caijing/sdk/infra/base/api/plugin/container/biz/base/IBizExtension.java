package com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import fe4.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/IBizExtension;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "getBizName", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "containerContext", "Lfe4/b;", "getWebGlobalConfigService", "Lfe4/a;", "getLifecycle", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IBizExtension extends ICJService {
    String getBizName();

    fe4.a getLifecycle(ContainerContext r100);

    b getWebGlobalConfigService(ContainerContext r100);
}
