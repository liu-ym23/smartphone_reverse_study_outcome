package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingTerminateReason;", "", "<init>", "(Ljava/lang/String;I)V", "HARDWARE_STOPPED", "HARDWARE_DISCONNECTED", "PRIORITY_REPLACED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingTerminateReason extends Enum<MmRecordingTerminateReason> {
    public static final MmRecordingTerminateReason HARDWARE_DISCONNECTED = null;
    public static final MmRecordingTerminateReason HARDWARE_STOPPED = null;
    public static final MmRecordingTerminateReason PRIORITY_REPLACED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingTerminateReason[] f433529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433530b = null;

    public static EnumEntries<MmRecordingTerminateReason> getEntries() {
        return f433530b;
    }

    static {
        MmRecordingTerminateReason r100 = new MmRecordingTerminateReason("HARDWARE_STOPPED", 0);
        HARDWARE_STOPPED = r100;
        MmRecordingTerminateReason r101 = new MmRecordingTerminateReason("HARDWARE_DISCONNECTED", 1);
        HARDWARE_DISCONNECTED = r101;
        MmRecordingTerminateReason r102 = new MmRecordingTerminateReason("PRIORITY_REPLACED", 2);
        PRIORITY_REPLACED = r102;
        MmRecordingTerminateReason[] r103 = {r100, r101, r102};
        f433529a = r103;
        f433530b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingTerminateReason[] values() {
        return (MmRecordingTerminateReason[]) f433529a.clone();
    }

    public static MmRecordingTerminateReason valueOf(String r100) {
        return (MmRecordingTerminateReason) a.a(MmRecordingTerminateReason.class, r100);
    }

    public MmRecordingTerminateReason(String r100, int r101) {
        super(r100, r101);
    }
}
