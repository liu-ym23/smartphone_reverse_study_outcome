package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingTerminateReason;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f433644a = null;

    static {
        int[] r100 = new int[MmRecordingTerminateReason.values().length];
        r100[MmRecordingTerminateReason.HARDWARE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[MmRecordingTerminateReason.HARDWARE_DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[MmRecordingTerminateReason.PRIORITY_REPLACED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f433644a = r100;
    }
}
