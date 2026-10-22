package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushSubtitleStatusData;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435220a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f435221b = null;

        static {
            int[] r100 = new int[UpdateLiveRecordingSettingResponse.Status.values().length];
            r100[UpdateLiveRecordingSettingResponse.Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[UpdateLiveRecordingSettingResponse.Status.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r100[UpdateLiveRecordingSettingResponse.Status.LIMIT_REACHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r100[UpdateLiveRecordingSettingResponse.Status.RECORDING_DEGRADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            f435220a = r100;
            int[] r101 = new int[MinutesRecordingPushSubtitleStatusData.Status.values().length];
            r101[MinutesRecordingPushSubtitleStatusData.Status.SUBTITLE_TRANSLATION_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[MinutesRecordingPushSubtitleStatusData.Status.SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            f435221b = r101;
        }
    }

    public static final boolean b(MmRecordingSource r100) {
        if (r100 != MmRecordingSource.FEISHU) goto L5;
    L10:
        return true;
    L5:
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L10;
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        return false;
    }

    public static final SubtitleFailedQuotaDecision a(MmRecordingSource r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r101, boolean r102, boolean r103) {
        if (r102 == false) goto L4;
        if (r103 == false) goto L9;
        return SubtitleFailedQuotaDecision.CLEAR;
    L9:
        if (r100 != MmRecordingSource.FEISHU) goto L11;
        if (r101 != null) goto L16;
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L16:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r101.f434914a) == false) goto L19;
        return SubtitleFailedQuotaDecision.CLEAR;
    L19:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.b(r101) == false) goto L22;
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L22:
        return SubtitleFailedQuotaDecision.PEND;
    L11:
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L4:
        return SubtitleFailedQuotaDecision.CLEAR;
    }
}
