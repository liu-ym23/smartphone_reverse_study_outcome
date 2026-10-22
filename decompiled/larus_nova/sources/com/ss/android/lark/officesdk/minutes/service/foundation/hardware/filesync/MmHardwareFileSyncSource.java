package com.ss.android.lark.officesdk.minutes.service.foundation.hardware.filesync;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/filesync/MmHardwareFileSyncSource;", "", "<init>", "(Ljava/lang/String;I)V", "D1204_CHARGING_CASE", "D3200_DEVICE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareFileSyncSource extends Enum<MmHardwareFileSyncSource> {
    public static final MmHardwareFileSyncSource D1204_CHARGING_CASE = null;
    public static final MmHardwareFileSyncSource D3200_DEVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareFileSyncSource[] f433804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433805b = null;

    public static EnumEntries<MmHardwareFileSyncSource> getEntries() {
        return f433805b;
    }

    static {
        MmHardwareFileSyncSource r100 = new MmHardwareFileSyncSource("D1204_CHARGING_CASE", 0);
        D1204_CHARGING_CASE = r100;
        MmHardwareFileSyncSource r101 = new MmHardwareFileSyncSource("D3200_DEVICE", 1);
        D3200_DEVICE = r101;
        MmHardwareFileSyncSource[] r102 = {r100, r101};
        f433804a = r102;
        f433805b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmHardwareFileSyncSource[] values() {
        return (MmHardwareFileSyncSource[]) f433804a.clone();
    }

    public static MmHardwareFileSyncSource valueOf(String r100) {
        return (MmHardwareFileSyncSource) a.a(MmHardwareFileSyncSource.class, r100);
    }

    public MmHardwareFileSyncSource(String r100, int r101) {
        super(r100, r101);
    }
}
