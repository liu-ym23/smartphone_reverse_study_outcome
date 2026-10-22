package com.ss.android.lark.ug.integrator;

import com.ss.android.lark.pb.ug_reach.ReportUGEventRequest;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements SdkSender.IParser<ReportUGEventRequest> {
    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final ReportUGEventRequest parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ReportUGEventRequest r101 = ReportUGEventRequest.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
