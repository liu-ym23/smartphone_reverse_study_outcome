package com.obric.assistant.ipc;

import com.larus.utils.logger.FLogger;
import com.obric.memorydata.sdk.ResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b0 implements ResultCallback<Boolean> {
    public b0() {
    }

    @Override // com.obric.memorydata.sdk.ResultCallback
    public final void onResult(int r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        FLogger.f375446a.i("WakeupTruthUploadManager", "ContextAwareness init code=" + r100 + " result=" + r102 + " msg=" + r101);
    }
}
