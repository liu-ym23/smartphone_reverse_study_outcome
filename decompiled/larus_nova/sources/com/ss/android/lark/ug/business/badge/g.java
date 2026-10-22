package com.ss.android.lark.ug.business.badge;

import com.bytedance.lark.pb.ugreach.v1.GetUGScenarioResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements SdkSender.IParser<GetUGScenarioResponse> {
    public g() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final GetUGScenarioResponse parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return GetUGScenarioResponse.ADAPTER.decode(r100);
    }
}
