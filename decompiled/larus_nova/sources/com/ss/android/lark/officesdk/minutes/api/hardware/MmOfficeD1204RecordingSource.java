package com.ss.android.lark.officesdk.minutes.api.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeD1204RecordingSource;", "", "<init>", "(Ljava/lang/String;I)V", "EARBUDS", "CHARGING_CASE", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmOfficeD1204RecordingSource extends Enum<MmOfficeD1204RecordingSource> {
    public static final MmOfficeD1204RecordingSource CHARGING_CASE = null;
    public static final MmOfficeD1204RecordingSource EARBUDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmOfficeD1204RecordingSource[] f433486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433487b = null;

    public static EnumEntries<MmOfficeD1204RecordingSource> getEntries() {
        return f433487b;
    }

    static {
        MmOfficeD1204RecordingSource r100 = new MmOfficeD1204RecordingSource("EARBUDS", 0);
        EARBUDS = r100;
        MmOfficeD1204RecordingSource r101 = new MmOfficeD1204RecordingSource("CHARGING_CASE", 1);
        CHARGING_CASE = r101;
        MmOfficeD1204RecordingSource[] r102 = {r100, r101};
        f433486a = r102;
        f433487b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmOfficeD1204RecordingSource[] values() {
        return (MmOfficeD1204RecordingSource[]) f433486a.clone();
    }

    public static MmOfficeD1204RecordingSource valueOf(String r100) {
        return (MmOfficeD1204RecordingSource) r27.a.a(MmOfficeD1204RecordingSource.class, r100);
    }

    public MmOfficeD1204RecordingSource(String r100, int r101) {
        super(r100, r101);
    }
}
