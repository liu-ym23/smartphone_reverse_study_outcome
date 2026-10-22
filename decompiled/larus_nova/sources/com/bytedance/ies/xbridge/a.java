package com.bytedance.ies.xbridge;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.xbridge.MultiAudioAudienceApplyResultModel;
import com.bytedance.ies.xbridge.k;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a<P extends k, R extends MultiAudioAudienceApplyResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
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
