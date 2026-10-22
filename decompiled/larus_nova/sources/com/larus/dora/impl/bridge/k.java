package com.larus.dora.impl.bridge;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements t39.w {
    public k() {
    }

    @Override // t39.w
    public final void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace upload log result success=" + r100 + ", msg=" + r101);
    }
}
