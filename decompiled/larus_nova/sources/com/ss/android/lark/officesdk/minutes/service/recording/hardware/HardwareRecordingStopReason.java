package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingStopReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_STOP", "INTERRUPTED_BY_HIGHER_PRIORITY", "HARDWARE_DISCONNECT", "HARDWARE_MEETING_CONFLICT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordingStopReason extends Enum<HardwareRecordingStopReason> {
    public static final HardwareRecordingStopReason HARDWARE_DISCONNECT = null;
    public static final HardwareRecordingStopReason HARDWARE_MEETING_CONFLICT = null;
    public static final HardwareRecordingStopReason INTERRUPTED_BY_HIGHER_PRIORITY = null;
    public static final HardwareRecordingStopReason USER_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordingStopReason[] f435532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435533b = null;

    public static EnumEntries<HardwareRecordingStopReason> getEntries() {
        return f435533b;
    }

    static {
        HardwareRecordingStopReason r100 = new HardwareRecordingStopReason("USER_STOP", 0);
        USER_STOP = r100;
        HardwareRecordingStopReason r101 = new HardwareRecordingStopReason("INTERRUPTED_BY_HIGHER_PRIORITY", 1);
        INTERRUPTED_BY_HIGHER_PRIORITY = r101;
        HardwareRecordingStopReason r102 = new HardwareRecordingStopReason("HARDWARE_DISCONNECT", 2);
        HARDWARE_DISCONNECT = r102;
        HardwareRecordingStopReason r103 = new HardwareRecordingStopReason("HARDWARE_MEETING_CONFLICT", 3);
        HARDWARE_MEETING_CONFLICT = r103;
        HardwareRecordingStopReason[] r104 = {r100, r101, r102, r103};
        f435532a = r104;
        f435533b = EnumEntriesKt.enumEntries(r104);
    }

    public static HardwareRecordingStopReason[] values() {
        return (HardwareRecordingStopReason[]) f435532a.clone();
    }

    public static HardwareRecordingStopReason valueOf(String r100) {
        return (HardwareRecordingStopReason) r27.a.a(HardwareRecordingStopReason.class, r100);
    }

    public HardwareRecordingStopReason(String r100, int r101) {
        super(r100, r101);
    }
}
