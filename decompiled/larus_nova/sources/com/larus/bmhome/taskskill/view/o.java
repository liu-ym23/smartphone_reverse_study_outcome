package com.larus.bmhome.taskskill.view;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o implements IIMCallback<OmniDispatchCommandResponse> {
    public o() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("PcConnectionStatusManager", "[sendPermissionControlCommand] failed, error=" + r100, r100.getException());
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(OmniDispatchCommandResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }
}
