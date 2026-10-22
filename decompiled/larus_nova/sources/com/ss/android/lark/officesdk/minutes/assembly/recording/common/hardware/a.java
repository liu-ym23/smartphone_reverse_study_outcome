package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements iub.a<j, MmRecordingError> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmHardwareCallRecordingStartDelegate f433678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> f433679b;

    @Override // iub.a
    public final void a(MmRecordingError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        lvb.a.b(this.f433678a.f433657d, "[stopCallRecording] failed, code=" + r100.getErrorCode() + ", message=" + r100.getErrorMsg());
        if (this.f433679b.isActive() == false) goto L6;
        i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> r101 = this.f433679b;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(new com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C5196a(r100.getErrorCode(), r100.getErrorMsg())));
        return;
    }

    @Override // iub.a
    public final void onSuccess(j r100) {
        j r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        lvb.a.e(this.f433678a.f433657d, "[stopCallRecording] success, recordingId=" + r101.f495845a);
        if (this.f433679b.isActive() == false) goto L6;
        i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> r102 = this.f433679b;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.c.f435551a));
        return;
    }

    public a(MmHardwareCallRecordingStartDelegate r100, kotlinx.coroutines.j r101) {
        this.f433678a = r100;
        this.f433679b = r101;
    }
}
