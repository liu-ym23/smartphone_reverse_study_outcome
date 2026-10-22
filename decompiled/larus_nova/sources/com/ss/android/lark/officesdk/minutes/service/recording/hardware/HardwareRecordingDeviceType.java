package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "LIBERTY_D1204", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HardwareRecordingDeviceType extends Enum<HardwareRecordingDeviceType> {
    public static final HardwareRecordingDeviceType LIBERTY_D1204 = null;
    public static final HardwareRecordingDeviceType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HardwareRecordingDeviceType[] f435524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435525b = null;

    public static EnumEntries<HardwareRecordingDeviceType> getEntries() {
        return f435525b;
    }

    static {
        HardwareRecordingDeviceType r100 = new HardwareRecordingDeviceType("LIBERTY_D1204", 0);
        LIBERTY_D1204 = r100;
        HardwareRecordingDeviceType r101 = new HardwareRecordingDeviceType("UNKNOWN", 1);
        UNKNOWN = r101;
        HardwareRecordingDeviceType[] r102 = {r100, r101};
        f435524a = r102;
        f435525b = EnumEntriesKt.enumEntries(r102);
    }

    public static HardwareRecordingDeviceType[] values() {
        return (HardwareRecordingDeviceType[]) f435524a.clone();
    }

    public static HardwareRecordingDeviceType valueOf(String r100) {
        return (HardwareRecordingDeviceType) r27.a.a(HardwareRecordingDeviceType.class, r100);
    }

    public HardwareRecordingDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
