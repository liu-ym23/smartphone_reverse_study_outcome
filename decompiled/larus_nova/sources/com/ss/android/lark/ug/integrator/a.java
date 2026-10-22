package com.ss.android.lark.ug.integrator;

import com.bytedance.lark.pb.ugreach.v1.DeleteUGReachPointCacheResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements SdkSender.IParser<DeleteUGReachPointCacheResponse> {
    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final DeleteUGReachPointCacheResponse parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        DeleteUGReachPointCacheResponse r101 = DeleteUGReachPointCacheResponse.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
