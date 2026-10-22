package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/live/MmHardwareLiveRecordingSource;", "", "<init>", "(Ljava/lang/String;I)V", "D1204_CHARGING_CASE", "D3200_DEVICE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareLiveRecordingSource extends Enum<MmHardwareLiveRecordingSource> {
    public static final MmHardwareLiveRecordingSource D1204_CHARGING_CASE = null;
    public static final MmHardwareLiveRecordingSource D3200_DEVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareLiveRecordingSource[] f435577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435578b = null;

    public static EnumEntries<MmHardwareLiveRecordingSource> getEntries() {
        return f435578b;
    }

    static {
        MmHardwareLiveRecordingSource r100 = new MmHardwareLiveRecordingSource("D1204_CHARGING_CASE", 0);
        D1204_CHARGING_CASE = r100;
        MmHardwareLiveRecordingSource r101 = new MmHardwareLiveRecordingSource("D3200_DEVICE", 1);
        D3200_DEVICE = r101;
        MmHardwareLiveRecordingSource[] r102 = {r100, r101};
        f435577a = r102;
        f435578b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmHardwareLiveRecordingSource[] values() {
        return (MmHardwareLiveRecordingSource[]) f435577a.clone();
    }

    public static MmHardwareLiveRecordingSource valueOf(String r100) {
        return (MmHardwareLiveRecordingSource) r27.a.a(MmHardwareLiveRecordingSource.class, r100);
    }

    public MmHardwareLiveRecordingSource(String r100, int r101) {
        super(r100, r101);
    }
}
