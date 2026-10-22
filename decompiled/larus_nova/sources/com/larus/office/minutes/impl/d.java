package com.larus.office.minutes.impl;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements iub.a<j, MmRecordingError> {
    public d() {
    }

    @Override // iub.a
    public final void a(MmRecordingError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("MinutesServiceImpl", "Stop canceled recording failed, error=" + r100.getMessage());
    }

    @Override // iub.a
    public final void onSuccess(j r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}
