package com.ss.android.lark.ug.integrator;

import com.bytedance.lark.pb.ugreach.v1.GetUGScenarioResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements SdkSender.IParser<GetUGScenarioResponse> {
    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final GetUGScenarioResponse parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        GetUGScenarioResponse r101 = GetUGScenarioResponse.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
