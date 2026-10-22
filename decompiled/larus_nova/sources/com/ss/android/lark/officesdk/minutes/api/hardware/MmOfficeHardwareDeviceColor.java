package com.ss.android.lark.officesdk.minutes.api.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareDeviceColor;", "", "<init>", "(Ljava/lang/String;I)V", "BLACK", "WHITE", "TITANIUM", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeHardwareDeviceColor extends Enum<MmOfficeHardwareDeviceColor> {
    public static final MmOfficeHardwareDeviceColor BLACK = null;
    public static final MmOfficeHardwareDeviceColor TITANIUM = null;
    public static final MmOfficeHardwareDeviceColor UNKNOWN = null;
    public static final MmOfficeHardwareDeviceColor WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeHardwareDeviceColor[] f433490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433491b = null;

    public static EnumEntries<MmOfficeHardwareDeviceColor> getEntries() {
        return f433491b;
    }

    static {
        MmOfficeHardwareDeviceColor r100 = new MmOfficeHardwareDeviceColor("BLACK", 0);
        BLACK = r100;
        MmOfficeHardwareDeviceColor r101 = new MmOfficeHardwareDeviceColor("WHITE", 1);
        WHITE = r101;
        MmOfficeHardwareDeviceColor r102 = new MmOfficeHardwareDeviceColor("TITANIUM", 2);
        TITANIUM = r102;
        MmOfficeHardwareDeviceColor r103 = new MmOfficeHardwareDeviceColor("UNKNOWN", 3);
        UNKNOWN = r103;
        MmOfficeHardwareDeviceColor[] r104 = {r100, r101, r102, r103};
        f433490a = r104;
        f433491b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmOfficeHardwareDeviceColor[] values() {
        return (MmOfficeHardwareDeviceColor[]) f433490a.clone();
    }

    public static MmOfficeHardwareDeviceColor valueOf(String r100) {
        return (MmOfficeHardwareDeviceColor) r27.a.a(MmOfficeHardwareDeviceColor.class, r100);
    }

    public MmOfficeHardwareDeviceColor(String r100, int r101) {
        super(r100, r101);
    }
}
