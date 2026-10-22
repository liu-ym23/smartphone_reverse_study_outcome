package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowReasonMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_ALLOW_LIST", "ALL_EXCEPT_BLOCKED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingEndWindowReasonMode extends Enum<MmRecordingEndWindowReasonMode> {
    public static final MmRecordingEndWindowReasonMode ALL_EXCEPT_BLOCKED = null;
    public static final MmRecordingEndWindowReasonMode DEFAULT_ALLOW_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingEndWindowReasonMode[] f434931a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434932b = null;

    public static EnumEntries<MmRecordingEndWindowReasonMode> getEntries() {
        return f434932b;
    }

    static {
        MmRecordingEndWindowReasonMode r100 = new MmRecordingEndWindowReasonMode("DEFAULT_ALLOW_LIST", 0);
        DEFAULT_ALLOW_LIST = r100;
        MmRecordingEndWindowReasonMode r101 = new MmRecordingEndWindowReasonMode("ALL_EXCEPT_BLOCKED", 1);
        ALL_EXCEPT_BLOCKED = r101;
        MmRecordingEndWindowReasonMode[] r102 = {r100, r101};
        f434931a = r102;
        f434932b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingEndWindowReasonMode[] values() {
        return (MmRecordingEndWindowReasonMode[]) f434931a.clone();
    }

    public static MmRecordingEndWindowReasonMode valueOf(String r100) {
        return (MmRecordingEndWindowReasonMode) r27.a.a(MmRecordingEndWindowReasonMode.class, r100);
    }

    public MmRecordingEndWindowReasonMode(String r100, int r101) {
        super(r100, r101);
    }
}
