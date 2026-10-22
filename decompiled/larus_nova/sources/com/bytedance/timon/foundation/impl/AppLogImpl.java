package com.bytedance.timon.foundation.impl;

import com.bytedance.timon.foundation.interfaces.IAppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/foundation/impl/AppLogImpl;", "Lcom/bytedance/timon/foundation/interfaces/IAppLog;", "<init>", "()V", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class AppLogImpl implements IAppLog {
    public AppLogImpl() {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IAppLog
    public final void log(String r100, JSONObject r101) {
        AppLogNewUtils.onEventV3(r100, r101);
    }
}
