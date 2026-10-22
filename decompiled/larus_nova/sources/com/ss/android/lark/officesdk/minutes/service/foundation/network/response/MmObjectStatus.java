package com.ss.android.lark.officesdk.minutes.service.foundation.network.response;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/MmObjectStatus;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "Deleted", "Trash", "Recording", "WaitASR", "Complete", "Failed", "Transcode", "Uploading", "WaitDiarization", "Pending", "PendingLowPriority", "FileCorrupted", "RealTimeRecording", "RealTimePause", "RealTimeCompleteUploading", "RealTimeCompleteForced", "RealTimeCompleteUpload", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmObjectStatus extends Enum<MmObjectStatus> implements Serializable {
    public static final a Companion = null;
    public static final MmObjectStatus Complete = null;
    public static final MmObjectStatus Deleted = null;
    public static final MmObjectStatus Failed = null;
    public static final MmObjectStatus FileCorrupted = null;
    public static final MmObjectStatus Pending = null;
    public static final MmObjectStatus PendingLowPriority = null;
    public static final MmObjectStatus RealTimeCompleteForced = null;
    public static final MmObjectStatus RealTimeCompleteUpload = null;
    public static final MmObjectStatus RealTimeCompleteUploading = null;
    public static final MmObjectStatus RealTimePause = null;
    public static final MmObjectStatus RealTimeRecording = null;
    public static final MmObjectStatus Recording = null;
    public static final MmObjectStatus Transcode = null;
    public static final MmObjectStatus Trash = null;
    public static final MmObjectStatus UNKNOWN = null;
    public static final MmObjectStatus Uploading = null;
    public static final MmObjectStatus WaitASR = null;
    public static final MmObjectStatus WaitDiarization = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmObjectStatus[] f433997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433998b = null;
    private final int value;

    public static EnumEntries<MmObjectStatus> getEntries() {
        return f433998b;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.response.MmObjectStatus$a] */
    static {
        MmObjectStatus r100 = new MmObjectStatus("UNKNOWN", 0, -10000);
        UNKNOWN = r100;
        MmObjectStatus r101 = new MmObjectStatus("Deleted", 1, -2);
        Deleted = r101;
        MmObjectStatus r102 = new MmObjectStatus("Trash", 2, -1);
        Trash = r102;
        MmObjectStatus r103 = new MmObjectStatus("Recording", 3, 0);
        Recording = r103;
        MmObjectStatus r104 = new MmObjectStatus("WaitASR", 4, 1);
        WaitASR = r104;
        MmObjectStatus r105 = new MmObjectStatus("Complete", 5, 2);
        Complete = r105;
        MmObjectStatus r110 = new MmObjectStatus("Failed", 6, 3);
        Failed = r110;
        MmObjectStatus r111 = new MmObjectStatus("Transcode", 7, 4);
        Transcode = r111;
        MmObjectStatus r112 = new MmObjectStatus("Uploading", 8, 5);
        Uploading = r112;
        MmObjectStatus r113 = new MmObjectStatus("WaitDiarization", 9, 11);
        WaitDiarization = r113;
        MmObjectStatus r114 = new MmObjectStatus("Pending", 10, 12);
        Pending = r114;
        MmObjectStatus r115 = new MmObjectStatus("PendingLowPriority", 11, 13);
        PendingLowPriority = r115;
        MmObjectStatus r106 = new MmObjectStatus("FileCorrupted", 12, 31);
        FileCorrupted = r106;
        MmObjectStatus r107 = new MmObjectStatus("RealTimeRecording", 13, 40);
        RealTimeRecording = r107;
        MmObjectStatus r108 = new MmObjectStatus("RealTimePause", 14, 41);
        RealTimePause = r108;
        MmObjectStatus r109 = new MmObjectStatus("RealTimeCompleteUploading", 15, 42);
        RealTimeCompleteUploading = r109;
        MmObjectStatus r116 = new MmObjectStatus("RealTimeCompleteForced", 16, 43);
        RealTimeCompleteForced = r116;
        MmObjectStatus r117 = new MmObjectStatus("RealTimeCompleteUpload", 17, 44);
        RealTimeCompleteUpload = r117;
        MmObjectStatus[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f433997a = r118;
        f433998b = EnumEntriesKt.enumEntries(r118);
        Companion = new a();
    }

    public static MmObjectStatus[] values() {
        return (MmObjectStatus[]) f433997a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmObjectStatus valueOf(String r100) {
        return (MmObjectStatus) r27.a.a(MmObjectStatus.class, r100);
    }

    public MmObjectStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
