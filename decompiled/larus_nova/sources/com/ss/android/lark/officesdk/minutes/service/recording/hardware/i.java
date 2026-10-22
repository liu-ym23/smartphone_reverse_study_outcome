package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public interface i {
    Object a(Continuation<? super e> r100);

    void b(MmHardwareCallRecordingStartDelegate r100);

    Object c(Continuation<? super Unit> r100);

    Unit d(MmHardwareRecordingAudioRoute r100, MmHardwareRecordingAudioRoute r101, Continuation r102);

    Object e(HardwareRecordingStopReason r100, Continuation<? super a> r101);

    Object f(boolean r100, Continuation<? super Unit> r101);

    Object g(String r100, Continuation<? super a> r101);

    i1<e> h();

    long i();

    void j(MmHardwareCallRecordingStartDelegate r100);
}
