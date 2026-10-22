package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmRecordingAutoSaveDecisionScene;", "", "<init>", "(Ljava/lang/String;I)V", "TOKEN_READY", "RECORD_FINISH", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingAutoSaveDecisionScene extends Enum<MmRecordingAutoSaveDecisionScene> {
    public static final MmRecordingAutoSaveDecisionScene RECORD_FINISH = null;
    public static final MmRecordingAutoSaveDecisionScene TOKEN_READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingAutoSaveDecisionScene[] f434880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434881b = null;

    public static EnumEntries<MmRecordingAutoSaveDecisionScene> getEntries() {
        return f434881b;
    }

    static {
        MmRecordingAutoSaveDecisionScene r100 = new MmRecordingAutoSaveDecisionScene("TOKEN_READY", 0);
        TOKEN_READY = r100;
        MmRecordingAutoSaveDecisionScene r101 = new MmRecordingAutoSaveDecisionScene("RECORD_FINISH", 1);
        RECORD_FINISH = r101;
        MmRecordingAutoSaveDecisionScene[] r102 = {r100, r101};
        f434880a = r102;
        f434881b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingAutoSaveDecisionScene[] values() {
        return (MmRecordingAutoSaveDecisionScene[]) f434880a.clone();
    }

    public static MmRecordingAutoSaveDecisionScene valueOf(String r100) {
        return (MmRecordingAutoSaveDecisionScene) r27.a.a(MmRecordingAutoSaveDecisionScene.class, r100);
    }

    public MmRecordingAutoSaveDecisionScene(String r100, int r101) {
        super(r100, r101);
    }
}
