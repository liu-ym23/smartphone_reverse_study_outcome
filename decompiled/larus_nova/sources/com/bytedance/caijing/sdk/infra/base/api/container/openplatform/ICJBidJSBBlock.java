package com.bytedance.caijing.sdk.infra.base.api.container.openplatform;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import id4.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u000bJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/openplatform/ICJBidJSBBlock;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "methodName", "url", "Lid4/c;", "providerFactory", "", "shouldBlock", "Lcom/bytedance/caijing/sdk/infra/base/api/container/openplatform/ICJBidJSBBlock$a;", "isBlock", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJBidJSBBlock extends ICJService {

    public static final class a {
    }

    a isBlock(String r100, String r101, c r102);

    boolean shouldBlock(String r100, String r101, c r102);
}
