package com.bytedance.caijing.sdk.infra.base.api.env;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/INetEnv;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getEnvChannel", "", "isBoe", "", "isPpe", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface INetEnv extends ICJService {
    String getEnvChannel();

    boolean isBoe();

    boolean isPpe();
}
