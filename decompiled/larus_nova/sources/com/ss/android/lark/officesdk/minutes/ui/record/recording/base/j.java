package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {
    public static final MMRecordingState a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L6;
        return MMRecordingState.IDLE;
    L6:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c.f434646c) == false) goto L9;
        return MMRecordingState.INIT;
    L9:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L12;
        return MMRecordingState.PAUSED;
    L12:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == false) goto L15;
        return MMRecordingState.IDLE;
    L15:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.f434654c) == false) goto L18;
        return MMRecordingState.RECORDING;
    L18:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.f434647c) == false) goto L21;
        return MMRecordingState.RECORDING;
    L21:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.f434655c) == false) goto L24;
        return MMRecordingState.RECORDING;
    L24:
        if ((r100 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L27;
        return MMRecordingState.IDLE;
    L27:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == false) goto L30;
        return MMRecordingState.IDLE;
    L30:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.f434648c) == false) goto L33;
        return MMRecordingState.RECORDING;
    L33:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.f434649c) == false) goto L36;
        return MMRecordingState.RECORDING;
    L36:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.f434650c) == false) goto L39;
        return MMRecordingState.RECORDING;
    L39:
        if (Intrinsics.areEqual(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.f434653c) == false) goto L43;
        return MMRecordingState.RECORDING;
    L43:
        throw new NoWhenBranchMatchedException();
    }
}
