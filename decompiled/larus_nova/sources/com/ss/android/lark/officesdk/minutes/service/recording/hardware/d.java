package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f435552a;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object a(Continuation<? super e> r100) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object c(Continuation<? super Unit> r100) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Unit d(MmHardwareRecordingAudioRoute r100, MmHardwareRecordingAudioRoute r101, Continuation r102) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object e(HardwareRecordingStopReason r100, Continuation<? super a> r101) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object f(boolean r100, Continuation<? super Unit> r101) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object g(String r100, Continuation<? super a> r101) {
        throw null;
    }

    public final Object l(e r100, EndRecordingReason r101, boolean r102, Continuation<? super a> r103) {
        throw null;
    }

    public final Object m(g r100, boolean r101, Continuation<? super h> r102) {
        throw null;
    }

    public final Object n(e r100, String r101, Continuation<? super b> r102) {
        throw null;
    }

    public final h.a o(e r100, Continuation r101) {
        throw null;
    }

    public final Object q(e r100, String r101, Continuation<? super Unit> r102) {
        throw null;
    }

    public static void k(String r100, int r101, String r102) {
        lvb.a.b(null, "[" + r100 + "] failed, code=" + r101 + ", message=" + r102);
        throw null;
    }

    public static void p(int r100, String r101, String r102) {
        lvb.a.b(null, "[startFailed] sceneInstanceId=" + r102 + ", code=" + r100 + ", message=" + r101);
        throw null;
    }
}
