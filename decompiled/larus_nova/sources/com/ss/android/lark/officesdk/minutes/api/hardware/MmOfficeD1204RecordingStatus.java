package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeD1204RecordingStatus;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "PAUSED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeD1204RecordingStatus extends Enum<MmOfficeD1204RecordingStatus> {
    public static final MmOfficeD1204RecordingStatus PAUSED = null;
    public static final MmOfficeD1204RecordingStatus RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeD1204RecordingStatus[] f433488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433489b = null;

    public static EnumEntries<MmOfficeD1204RecordingStatus> getEntries() {
        return f433489b;
    }

    static {
        MmOfficeD1204RecordingStatus r100 = new MmOfficeD1204RecordingStatus(State.RECORDING, 0);
        RECORDING = r100;
        MmOfficeD1204RecordingStatus r101 = new MmOfficeD1204RecordingStatus("PAUSED", 1);
        PAUSED = r101;
        MmOfficeD1204RecordingStatus[] r102 = {r100, r101};
        f433488a = r102;
        f433489b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmOfficeD1204RecordingStatus[] values() {
        return (MmOfficeD1204RecordingStatus[]) f433488a.clone();
    }

    public static MmOfficeD1204RecordingStatus valueOf(String r100) {
        return (MmOfficeD1204RecordingStatus) r27.a.a(MmOfficeD1204RecordingStatus.class, r100);
    }

    public MmOfficeD1204RecordingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
