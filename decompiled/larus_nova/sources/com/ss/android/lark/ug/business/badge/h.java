package com.ss.android.lark.ug.business.badge;

import com.ss.android.lark.pb.ug_reach.ReportUGEventResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements SdkSender.IParser<ReportUGEventResponse> {
    public h() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final ReportUGEventResponse parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ReportUGEventResponse r101 = ReportUGEventResponse.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
