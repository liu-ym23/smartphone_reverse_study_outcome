package com.bytedance.caijing.sdk.infra.base.api.env;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/ICJDeviceHelper;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "isFold", "", "isLargeScreen", "isPad", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJDeviceHelper extends ICJService {
    boolean isFold();

    boolean isLargeScreen();

    boolean isPad();
}
