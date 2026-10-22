package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f435568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f435569b = null;

    public j() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object a(Continuation<? super e> r100) {
        return null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final void b(MmHardwareCallRecordingStartDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final long i() {
        return 2000;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final void j(MmHardwareCallRecordingStartDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
    }

    static {
        f435568a = new j();
        f435569b = j1.a(null);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final i1<e> h() {
        return f435569b;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object c(Continuation<? super Unit> r100) {
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object e(HardwareRecordingStopReason r100, Continuation<? super a> r101) {
        return new a.C5196a(-10001, "hardware recording is unsupported");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object f(boolean r100, Continuation<? super Unit> r101) {
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object g(String r100, Continuation<? super a> r101) {
        return new a.C5196a(-10001, "hardware recording is unsupported");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Unit d(MmHardwareRecordingAudioRoute r100, MmHardwareRecordingAudioRoute r101, Continuation r102) {
        return Unit.INSTANCE;
    }
}
