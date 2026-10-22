package com.larus.minutes.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/minutes/api/MinutesOfflineRecordingDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "GLASSES", "EARBUDS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MinutesOfflineRecordingDeviceType extends Enum<MinutesOfflineRecordingDeviceType> {
    public static final MinutesOfflineRecordingDeviceType EARBUDS = null;
    public static final MinutesOfflineRecordingDeviceType GLASSES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MinutesOfflineRecordingDeviceType[] f359288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359289b = null;

    public static EnumEntries<MinutesOfflineRecordingDeviceType> getEntries() {
        return f359289b;
    }

    static {
        MinutesOfflineRecordingDeviceType r100 = new MinutesOfflineRecordingDeviceType("GLASSES", 0);
        GLASSES = r100;
        MinutesOfflineRecordingDeviceType r101 = new MinutesOfflineRecordingDeviceType("EARBUDS", 1);
        EARBUDS = r101;
        MinutesOfflineRecordingDeviceType[] r102 = {r100, r101};
        f359288a = r102;
        f359289b = EnumEntriesKt.enumEntries(r102);
    }

    public static MinutesOfflineRecordingDeviceType[] values() {
        return (MinutesOfflineRecordingDeviceType[]) f359288a.clone();
    }

    public static MinutesOfflineRecordingDeviceType valueOf(String r100) {
        return (MinutesOfflineRecordingDeviceType) a.a(MinutesOfflineRecordingDeviceType.class, r100);
    }

    public MinutesOfflineRecordingDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
