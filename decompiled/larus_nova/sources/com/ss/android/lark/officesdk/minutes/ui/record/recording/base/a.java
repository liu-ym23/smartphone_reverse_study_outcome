package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingInterruptionReason;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingSessionState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5205a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436174a = null;

        static {
            int[] r100 = new int[HardwareRecordingInterruptionReason.values().length];
            r100[HardwareRecordingInterruptionReason.AUDIO_MODE_SWITCHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[HardwareRecordingInterruptionReason.MIC_IN_USE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[HardwareRecordingInterruptionReason.BLUETOOTH_DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f436174a = r100;
        }
    }

    public static final int a(com.ss.android.lark.officesdk.minutes.service.recording.hardware.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HardwareRecordingInterruptionReason r101 = r100.f435560h;
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L10;
        return R.string.View_MempopeTwo_AudioModeSwitchedSuspended_Toast;
    L10:
        if (r102 != 2) goto L12;
    L19:
        return R.string.View_MempopeTwo_MicInUseSuspended_Toast;
    L12:
        if (r102 != 3) goto L15;
    L20:
        return R.string.View_MempopeTwo_BluetoothDisconnectedRecordingSuspended_Toast;
    L15:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r100.f435557e != HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L20;
    L5:
        r102 = C5205a.f436174a[r101.ordinal()];
        goto L6
    }
}
