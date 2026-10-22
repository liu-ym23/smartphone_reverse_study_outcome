package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingCreateMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_RTC", "OFFLINE_LOCAL", "HARDWARE_LIVE", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingCreateMode extends Enum<MmRecordingCreateMode> {
    public static final MmRecordingCreateMode DEFAULT_RTC = null;
    public static final MmRecordingCreateMode HARDWARE_LIVE = null;
    public static final MmRecordingCreateMode OFFLINE_LOCAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingCreateMode[] f433522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433523b = null;

    public static EnumEntries<MmRecordingCreateMode> getEntries() {
        return f433523b;
    }

    static {
        MmRecordingCreateMode r100 = new MmRecordingCreateMode("DEFAULT_RTC", 0);
        DEFAULT_RTC = r100;
        MmRecordingCreateMode r101 = new MmRecordingCreateMode("OFFLINE_LOCAL", 1);
        OFFLINE_LOCAL = r101;
        MmRecordingCreateMode r102 = new MmRecordingCreateMode("HARDWARE_LIVE", 2);
        HARDWARE_LIVE = r102;
        MmRecordingCreateMode[] r103 = {r100, r101, r102};
        f433522a = r103;
        f433523b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingCreateMode[] values() {
        return (MmRecordingCreateMode[]) f433522a.clone();
    }

    public static MmRecordingCreateMode valueOf(String r100) {
        return (MmRecordingCreateMode) a.a(MmRecordingCreateMode.class, r100);
    }

    public MmRecordingCreateMode(String r100, int r101) {
        super(r100, r101);
    }
}
