package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingInterruptionReason;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_DISCONNECTED", "AUDIO_MODE_SWITCHED", "MIC_IN_USE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordingInterruptionReason extends Enum<HardwareRecordingInterruptionReason> {
    public static final HardwareRecordingInterruptionReason AUDIO_MODE_SWITCHED = null;
    public static final HardwareRecordingInterruptionReason BLUETOOTH_DISCONNECTED = null;
    public static final HardwareRecordingInterruptionReason MIC_IN_USE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordingInterruptionReason[] f435528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435529b = null;

    public static EnumEntries<HardwareRecordingInterruptionReason> getEntries() {
        return f435529b;
    }

    static {
        HardwareRecordingInterruptionReason r100 = new HardwareRecordingInterruptionReason("BLUETOOTH_DISCONNECTED", 0);
        BLUETOOTH_DISCONNECTED = r100;
        HardwareRecordingInterruptionReason r101 = new HardwareRecordingInterruptionReason("AUDIO_MODE_SWITCHED", 1);
        AUDIO_MODE_SWITCHED = r101;
        HardwareRecordingInterruptionReason r102 = new HardwareRecordingInterruptionReason("MIC_IN_USE", 2);
        MIC_IN_USE = r102;
        HardwareRecordingInterruptionReason[] r103 = {r100, r101, r102};
        f435528a = r103;
        f435529b = EnumEntriesKt.enumEntries(r103);
    }

    public static HardwareRecordingInterruptionReason[] values() {
        return (HardwareRecordingInterruptionReason[]) f435528a.clone();
    }

    public static HardwareRecordingInterruptionReason valueOf(String r100) {
        return (HardwareRecordingInterruptionReason) r27.a.a(HardwareRecordingInterruptionReason.class, r100);
    }

    public HardwareRecordingInterruptionReason(String r100, int r101) {
        super(r100, r101);
    }
}
