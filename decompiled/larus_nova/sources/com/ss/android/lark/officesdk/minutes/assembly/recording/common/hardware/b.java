package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements iub.a<j, MmRecordingError> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController f433680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f433681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f433682c;

    @Override // iub.a
    public final void a(MmRecordingError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        lvb.a.b(this.f433680a.f433673d, "[retryCreateRecording] failed, trigger=" + this.f433681b + ", recordingId=" + this.f433682c + ", code=" + r100.getErrorCode() + ", message=" + r100.getErrorMsg());
    }

    @Override // iub.a
    public final void onSuccess(j r100) {
        j r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        lvb.a.e(this.f433680a.f433673d, "[retryCreateRecording] success, trigger=" + this.f433681b + ", recordingId=" + r101.f495845a);
        this.f433680a.b(this.f433682c);
        this.f433680a.f433671b.a(r101.f495845a, this.f433681b);
    }

    public b(MmHardwareOfflineRecordingForegroundRetryController r100, String r101, String r102) {
        this.f433680a = r100;
        this.f433681b = r101;
        this.f433682c = r102;
    }
}
