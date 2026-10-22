package com.larus.office.minutes.impl;

import com.larus.avlink.record.util.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements iub.a<j, MmRecordingError> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yk9.b f362312a;

    public g(i r100) {
        this.f362312a = r100;
    }

    @Override // iub.a
    public final void a(MmRecordingError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("MinutesServiceImpl", "Retry hardware recording failed, errorCode=" + r100.getErrorCode() + ", errorMsg=" + r100.getMessage());
        this.f362312a.onFail(r100.getErrorCode(), r100.getMessage());
    }

    @Override // iub.a
    public final void onSuccess(j r100) {
        j r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        FLogger.f375446a.i("MinutesServiceImpl", "Retry hardware recording success, recordingId=" + r101.f495845a);
        this.f362312a.onSuccess(r101.f495845a);
    }
}
