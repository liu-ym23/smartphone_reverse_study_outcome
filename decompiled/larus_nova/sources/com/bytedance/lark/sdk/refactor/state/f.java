package com.bytedance.lark.sdk.refactor.state;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.sdk.refactor.m;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f extends j {
    @Override // com.bytedance.lark.sdk.refactor.state.j
    public final SdkState a() {
        return SdkState.OFFLINE;
    }

    public f(m r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.state.j, com.bytedance.lark.sdk.refactor.l
    public final int p(InitSDKRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        Log.w("RustSDK", "sdk already init");
        return -1;
    }

    @Override // com.bytedance.lark.sdk.refactor.state.j, com.bytedance.lark.sdk.refactor.l
    public final int l(String r100, byte[] r101) {
        Log.w("RustSDK", "sdk already init");
        return -1;
    }
}
