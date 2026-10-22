package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaScene;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE", "SUMMARY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingQuotaCtaScene extends Enum<MmRecordingQuotaCtaScene> {
    public static final MmRecordingQuotaCtaScene SUBTITLE = null;
    public static final MmRecordingQuotaCtaScene SUMMARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingQuotaCtaScene[] f434912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434913b = null;

    public static EnumEntries<MmRecordingQuotaCtaScene> getEntries() {
        return f434913b;
    }

    static {
        MmRecordingQuotaCtaScene r100 = new MmRecordingQuotaCtaScene("SUBTITLE", 0);
        SUBTITLE = r100;
        MmRecordingQuotaCtaScene r101 = new MmRecordingQuotaCtaScene("SUMMARY", 1);
        SUMMARY = r101;
        MmRecordingQuotaCtaScene[] r102 = {r100, r101};
        f434912a = r102;
        f434913b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmRecordingQuotaCtaScene[] values() {
        return (MmRecordingQuotaCtaScene[]) f434912a.clone();
    }

    public static MmRecordingQuotaCtaScene valueOf(String r100) {
        return (MmRecordingQuotaCtaScene) r27.a.a(MmRecordingQuotaCtaScene.class, r100);
    }

    public MmRecordingQuotaCtaScene(String r100, int r101) {
        super(r100, r101);
    }
}
