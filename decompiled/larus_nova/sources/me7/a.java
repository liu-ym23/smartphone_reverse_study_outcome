package me7;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.sdk.xbridge.cn.registry.core.LiveCloseProfileResultModel;
import me7.k;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<P extends k, R extends LiveCloseProfileResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
