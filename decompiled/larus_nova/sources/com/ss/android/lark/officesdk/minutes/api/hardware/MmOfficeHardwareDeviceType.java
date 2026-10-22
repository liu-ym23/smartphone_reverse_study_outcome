package com.ss.android.lark.officesdk.minutes.api.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "D3200", "D1204", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeHardwareDeviceType extends Enum<MmOfficeHardwareDeviceType> {
    public static final MmOfficeHardwareDeviceType D1204 = null;
    public static final MmOfficeHardwareDeviceType D3200 = null;
    public static final MmOfficeHardwareDeviceType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeHardwareDeviceType[] f433492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433493b = null;

    public static EnumEntries<MmOfficeHardwareDeviceType> getEntries() {
        return f433493b;
    }

    static {
        MmOfficeHardwareDeviceType r100 = new MmOfficeHardwareDeviceType("D3200", 0);
        D3200 = r100;
        MmOfficeHardwareDeviceType r101 = new MmOfficeHardwareDeviceType("D1204", 1);
        D1204 = r101;
        MmOfficeHardwareDeviceType r102 = new MmOfficeHardwareDeviceType("UNKNOWN", 2);
        UNKNOWN = r102;
        MmOfficeHardwareDeviceType[] r103 = {r100, r101, r102};
        f433492a = r103;
        f433493b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmOfficeHardwareDeviceType[] values() {
        return (MmOfficeHardwareDeviceType[]) f433492a.clone();
    }

    public static MmOfficeHardwareDeviceType valueOf(String r100) {
        return (MmOfficeHardwareDeviceType) r27.a.a(MmOfficeHardwareDeviceType.class, r100);
    }

    public MmOfficeHardwareDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
