package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f435588a = null;

    static {
        f435588a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void a() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void b() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final Object c() {
        Result.Companion r100 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("hardware live recording is unsupported")));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void f(MmHardwareLiveRecordingCapacityDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "hardwareRecordId");
        Intrinsics.checkNotNullParameter(r101, "recordingId");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "hardwareRecordId");
        Intrinsics.checkNotNullParameter(r101, "recordingId");
    }
}
