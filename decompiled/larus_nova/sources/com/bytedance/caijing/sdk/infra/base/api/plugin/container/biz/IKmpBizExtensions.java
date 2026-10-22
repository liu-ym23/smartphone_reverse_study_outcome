package com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz;

import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/IKmpBizExtensions;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getExtension", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/IBizExtension;", "biz", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IKmpBizExtensions extends ICJService {
    IBizExtension getExtension(String r100);
}
