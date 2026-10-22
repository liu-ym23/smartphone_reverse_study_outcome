package com.ss.android.lark.officesdk.minutes.api.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareFileSyncStage;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TRANSFERRING", "UPLOADING", "PROCESSING", "COMPLETED", "FAILED", "CANCELLED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeHardwareFileSyncStage extends Enum<MmOfficeHardwareFileSyncStage> {
    public static final MmOfficeHardwareFileSyncStage CANCELLED = null;
    public static final MmOfficeHardwareFileSyncStage COMPLETED = null;
    public static final MmOfficeHardwareFileSyncStage FAILED = null;
    public static final MmOfficeHardwareFileSyncStage PROCESSING = null;
    public static final MmOfficeHardwareFileSyncStage TRANSFERRING = null;
    public static final MmOfficeHardwareFileSyncStage UNKNOWN = null;
    public static final MmOfficeHardwareFileSyncStage UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeHardwareFileSyncStage[] f433494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433495b = null;

    public static EnumEntries<MmOfficeHardwareFileSyncStage> getEntries() {
        return f433495b;
    }

    static {
        MmOfficeHardwareFileSyncStage r100 = new MmOfficeHardwareFileSyncStage("UNKNOWN", 0);
        UNKNOWN = r100;
        MmOfficeHardwareFileSyncStage r101 = new MmOfficeHardwareFileSyncStage("TRANSFERRING", 1);
        TRANSFERRING = r101;
        MmOfficeHardwareFileSyncStage r102 = new MmOfficeHardwareFileSyncStage("UPLOADING", 2);
        UPLOADING = r102;
        MmOfficeHardwareFileSyncStage r103 = new MmOfficeHardwareFileSyncStage("PROCESSING", 3);
        PROCESSING = r103;
        MmOfficeHardwareFileSyncStage r104 = new MmOfficeHardwareFileSyncStage("COMPLETED", 4);
        COMPLETED = r104;
        MmOfficeHardwareFileSyncStage r105 = new MmOfficeHardwareFileSyncStage("FAILED", 5);
        FAILED = r105;
        MmOfficeHardwareFileSyncStage r110 = new MmOfficeHardwareFileSyncStage("CANCELLED", 6);
        CANCELLED = r110;
        MmOfficeHardwareFileSyncStage[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f433494a = r111;
        f433495b = EnumEntriesKt.enumEntries(r111);
    }

    public static MmOfficeHardwareFileSyncStage[] values() {
        return (MmOfficeHardwareFileSyncStage[]) f433494a.clone();
    }

    public static MmOfficeHardwareFileSyncStage valueOf(String r100) {
        return (MmOfficeHardwareFileSyncStage) r27.a.a(MmOfficeHardwareFileSyncStage.class, r100);
    }

    public MmOfficeHardwareFileSyncStage(String r100, int r101) {
        super(r100, r101);
    }
}
