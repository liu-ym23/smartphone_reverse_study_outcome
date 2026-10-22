package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceBusinessStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INTERPRETATION", "RECORDING_MINUTES", "VIDEO_RECORDING", "VIDEO_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceBusinessStatus extends Enum<DoraObricDeviceBusinessStatus> {
    public static final DoraObricDeviceBusinessStatus INTERPRETATION = null;
    public static final DoraObricDeviceBusinessStatus RECORDING_MINUTES = null;
    public static final DoraObricDeviceBusinessStatus VIDEO_CALL = null;
    public static final DoraObricDeviceBusinessStatus VIDEO_RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceBusinessStatus[] f339023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339024b = null;

    public static EnumEntries<DoraObricDeviceBusinessStatus> getEntries() {
        return f339024b;
    }

    static {
        DoraObricDeviceBusinessStatus r100 = new DoraObricDeviceBusinessStatus("INTERPRETATION", 0);
        INTERPRETATION = r100;
        DoraObricDeviceBusinessStatus r101 = new DoraObricDeviceBusinessStatus("RECORDING_MINUTES", 1);
        RECORDING_MINUTES = r101;
        DoraObricDeviceBusinessStatus r102 = new DoraObricDeviceBusinessStatus("VIDEO_RECORDING", 2);
        VIDEO_RECORDING = r102;
        DoraObricDeviceBusinessStatus r103 = new DoraObricDeviceBusinessStatus("VIDEO_CALL", 3);
        VIDEO_CALL = r103;
        DoraObricDeviceBusinessStatus[] r104 = {r100, r101, r102, r103};
        f339023a = r104;
        f339024b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricDeviceBusinessStatus[] values() {
        return (DoraObricDeviceBusinessStatus[]) f339023a.clone();
    }

    public static DoraObricDeviceBusinessStatus valueOf(String r100) {
        return (DoraObricDeviceBusinessStatus) r27.a.a(DoraObricDeviceBusinessStatus.class, r100);
    }

    public DoraObricDeviceBusinessStatus(String r100, int r101) {
        super(r100, r101);
    }
}
