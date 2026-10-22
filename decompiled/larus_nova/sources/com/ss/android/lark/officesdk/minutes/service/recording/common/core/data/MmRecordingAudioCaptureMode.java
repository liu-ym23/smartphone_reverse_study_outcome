package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingAudioCaptureMode;", "", "<init>", "(Ljava/lang/String;I)V", "RTC", "EXTERNAL_AUDIO_SOURCE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingAudioCaptureMode extends Enum<MmRecordingAudioCaptureMode> {
    public static final MmRecordingAudioCaptureMode EXTERNAL_AUDIO_SOURCE = null;
    public static final MmRecordingAudioCaptureMode RTC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingAudioCaptureMode[] f434184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434185b = null;

    public static EnumEntries<MmRecordingAudioCaptureMode> getEntries() {
        return f434185b;
    }

    static {
        MmRecordingAudioCaptureMode r100 = new MmRecordingAudioCaptureMode("RTC", 0);
        RTC = r100;
        MmRecordingAudioCaptureMode r101 = new MmRecordingAudioCaptureMode("EXTERNAL_AUDIO_SOURCE", 1);
        EXTERNAL_AUDIO_SOURCE = r101;
        MmRecordingAudioCaptureMode[] r102 = {r100, r101};
        f434184a = r102;
        f434185b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingAudioCaptureMode[] values() {
        return (MmRecordingAudioCaptureMode[]) f434184a.clone();
    }

    public static MmRecordingAudioCaptureMode valueOf(String r100) {
        return (MmRecordingAudioCaptureMode) a.a(MmRecordingAudioCaptureMode.class, r100);
    }

    public MmRecordingAudioCaptureMode(String r100, int r101) {
        super(r100, r101);
    }
}
