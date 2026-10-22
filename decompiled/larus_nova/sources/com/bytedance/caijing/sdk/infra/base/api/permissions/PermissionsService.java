package com.bytedance.caijing.sdk.infra.base.api.permissions;

import be4.a;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/permissions/PermissionsService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "scene", "Lbe4/a;", "callBack", "", "permissionsRequest", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface PermissionsService extends ICJService {
    void permissionsRequest(String r100, a r101);
}
