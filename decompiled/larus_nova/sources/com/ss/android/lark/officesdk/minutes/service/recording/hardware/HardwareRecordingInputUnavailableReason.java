package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingInputUnavailableReason;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_DISCONNECTED", "SPEAKER_SWITCHED", "AUDIO_PATH_PREEMPTED", "AUDIO_ROUTE_CHANGED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordingInputUnavailableReason extends Enum<HardwareRecordingInputUnavailableReason> {
    public static final HardwareRecordingInputUnavailableReason AUDIO_PATH_PREEMPTED = null;
    public static final HardwareRecordingInputUnavailableReason AUDIO_ROUTE_CHANGED = null;
    public static final HardwareRecordingInputUnavailableReason BLUETOOTH_DISCONNECTED = null;
    public static final HardwareRecordingInputUnavailableReason SPEAKER_SWITCHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordingInputUnavailableReason[] f435526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435527b = null;

    public static EnumEntries<HardwareRecordingInputUnavailableReason> getEntries() {
        return f435527b;
    }

    static {
        HardwareRecordingInputUnavailableReason r100 = new HardwareRecordingInputUnavailableReason("BLUETOOTH_DISCONNECTED", 0);
        BLUETOOTH_DISCONNECTED = r100;
        HardwareRecordingInputUnavailableReason r101 = new HardwareRecordingInputUnavailableReason("SPEAKER_SWITCHED", 1);
        SPEAKER_SWITCHED = r101;
        HardwareRecordingInputUnavailableReason r102 = new HardwareRecordingInputUnavailableReason("AUDIO_PATH_PREEMPTED", 2);
        AUDIO_PATH_PREEMPTED = r102;
        HardwareRecordingInputUnavailableReason r103 = new HardwareRecordingInputUnavailableReason("AUDIO_ROUTE_CHANGED", 3);
        AUDIO_ROUTE_CHANGED = r103;
        HardwareRecordingInputUnavailableReason[] r104 = {r100, r101, r102, r103};
        f435526a = r104;
        f435527b = EnumEntriesKt.enumEntries(r104);
    }

    public static HardwareRecordingInputUnavailableReason[] values() {
        return (HardwareRecordingInputUnavailableReason[]) f435526a.clone();
    }

    public static HardwareRecordingInputUnavailableReason valueOf(String r100) {
        return (HardwareRecordingInputUnavailableReason) r27.a.a(HardwareRecordingInputUnavailableReason.class, r100);
    }

    public HardwareRecordingInputUnavailableReason(String r100, int r101) {
        super(r100, r101);
    }
}
