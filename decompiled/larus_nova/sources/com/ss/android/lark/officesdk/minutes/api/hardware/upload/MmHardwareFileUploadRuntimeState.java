package com.ss.android.lark.officesdk.minutes.api.hardware.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/upload/MmHardwareFileUploadRuntimeState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "PREPARING", "UPLOADING", "PROCESSING", "COMPLETED", "FAILED", "CANCELLED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareFileUploadRuntimeState extends Enum<MmHardwareFileUploadRuntimeState> {
    public static final MmHardwareFileUploadRuntimeState CANCELLED = null;
    public static final MmHardwareFileUploadRuntimeState COMPLETED = null;
    public static final MmHardwareFileUploadRuntimeState FAILED = null;
    public static final MmHardwareFileUploadRuntimeState PREPARING = null;
    public static final MmHardwareFileUploadRuntimeState PROCESSING = null;
    public static final MmHardwareFileUploadRuntimeState UNKNOWN = null;
    public static final MmHardwareFileUploadRuntimeState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareFileUploadRuntimeState[] f433508a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433509b = null;

    public static EnumEntries<MmHardwareFileUploadRuntimeState> getEntries() {
        return f433509b;
    }

    static {
        MmHardwareFileUploadRuntimeState r100 = new MmHardwareFileUploadRuntimeState("UNKNOWN", 0);
        UNKNOWN = r100;
        MmHardwareFileUploadRuntimeState r101 = new MmHardwareFileUploadRuntimeState("PREPARING", 1);
        PREPARING = r101;
        MmHardwareFileUploadRuntimeState r102 = new MmHardwareFileUploadRuntimeState("UPLOADING", 2);
        UPLOADING = r102;
        MmHardwareFileUploadRuntimeState r103 = new MmHardwareFileUploadRuntimeState("PROCESSING", 3);
        PROCESSING = r103;
        MmHardwareFileUploadRuntimeState r104 = new MmHardwareFileUploadRuntimeState("COMPLETED", 4);
        COMPLETED = r104;
        MmHardwareFileUploadRuntimeState r105 = new MmHardwareFileUploadRuntimeState("FAILED", 5);
        FAILED = r105;
        MmHardwareFileUploadRuntimeState r110 = new MmHardwareFileUploadRuntimeState("CANCELLED", 6);
        CANCELLED = r110;
        MmHardwareFileUploadRuntimeState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f433508a = r111;
        f433509b = EnumEntriesKt.enumEntries(r111);
    }

    public static MmHardwareFileUploadRuntimeState[] values() {
        return (MmHardwareFileUploadRuntimeState[]) f433508a.clone();
    }

    public static MmHardwareFileUploadRuntimeState valueOf(String r100) {
        return (MmHardwareFileUploadRuntimeState) a.a(MmHardwareFileUploadRuntimeState.class, r100);
    }

    public MmHardwareFileUploadRuntimeState(String r100, int r101) {
        super(r100, r101);
    }
}
