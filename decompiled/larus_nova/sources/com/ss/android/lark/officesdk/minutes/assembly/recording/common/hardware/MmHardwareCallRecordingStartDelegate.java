package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmHardwareCallRecordingStartDelegate {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f433653g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hub.a f433654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tub.a f433655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f433656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f433657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f433658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f433659f;

    public static final class a {
    }

    static {
    }

    public final Object a(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1) == false) goto L7;
        MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1 r102 = (MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L21:
        if (r104 == null) goto L24;
        r107 = true;
    L24:
        return Boxing.boxBoolean(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MmRecordingSessionManager r108 = this.f433656c.A();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        MmRecordingSession r109 = r108.m(r100);
        if (r109 != null) goto L18;
        lvb.a.b(this.f433657d, "[awaitLocalCaptureReady] session not found, recordingId=".concat(r100));
        return Boxing.boxBoolean(false);
    L18:
        MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$2 r110 = new MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$2(r109, null);
        r102.label = 1;
        r104 = TimeoutKt.c(5000, r110, r102);
        if (r104 != r105) goto L21;
        return r105;
    L7:
        r102 = new MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1(this, r101);
        goto L8
    }

    public MmHardwareCallRecordingStartDelegate(hub.a r100, tub.a r101, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r102) {
        Intrinsics.checkNotNullParameter(r100, "capacity");
        Intrinsics.checkNotNullParameter(r101, "priorityCapacity");
        Intrinsics.checkNotNullParameter(r102, "userContext");
        this.f433654a = r100;
        this.f433655b = r101;
        this.f433656c = r102;
        this.f433657d = "MmHardwareCallRecordingStartDelegate_" + hashCode();
        this.f433658e = LazyKt.lazy(new MmHardwareCallRecordingStartDelegate$floatController$2(this));
        this.f433659f = LazyKt.lazy(new MmHardwareCallRecordingStartDelegate$foregroundRetryController$2(this));
    }
}
