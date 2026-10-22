package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingObjectReadyCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f434424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f434425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1 f434426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutinesSafe f434427d;

    public final boolean c() {
        Result r100 = (Result) this.f434425b.getValue();
        String r101 = null;
        if (r100 == null) goto L10;
        Object r102 = r100.m9458unboximpl();
        if (Result.m9455isFailureimpl(r102) == false) goto L7;
        r102 = null;
    L7:
        MmCreateAudioResponse r103 = (MmCreateAudioResponse) r102;
        if (r103 == null) goto L10;
        r101 = r103.getRecordingId();
    L10:
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        return b(r101);
    }

    public MmRecordingObjectReadyCoordinator(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f434424a = r100;
        StateFlowImpl r101 = j1.a(null);
        this.f434425b = r101;
        this.f434426c = kotlinx.coroutines.flow.e.b(r101);
        this.f434427d = new CoroutinesSafe(r100);
    }

    public static boolean b(String r100) {
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100, "0") == true) goto L7;
        return true;
    }

    public final Object a(Continuation<? super String> r100) {
        if ((r100 instanceof MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1) == false) goto L7;
        MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1 r101 = (MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        Object r106 = ((Result) r103).m9458unboximpl();
        ResultKt.throwOnFailure(r106);
        return ((MmCreateAudioResponse) r106).getRecordingId();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1 r107 = new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(this.f434426c);
        r101.label = 1;
        r103 = kotlinx.coroutines.flow.e.s(r107, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1(this, r100);
        goto L8
    }
}
