package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/SubtitleOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "DEGRADED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubtitleOpenResult extends Enum<SubtitleOpenResult> {
    public static final SubtitleOpenResult DEGRADED = null;
    public static final SubtitleOpenResult FAILURE = null;
    public static final SubtitleOpenResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleOpenResult[] f435195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435196b = null;

    public static EnumEntries<SubtitleOpenResult> getEntries() {
        return f435196b;
    }

    static {
        SubtitleOpenResult r100 = new SubtitleOpenResult("SUCCESS", 0);
        SUCCESS = r100;
        SubtitleOpenResult r101 = new SubtitleOpenResult("FAILURE", 1);
        FAILURE = r101;
        SubtitleOpenResult r102 = new SubtitleOpenResult("DEGRADED", 2);
        DEGRADED = r102;
        SubtitleOpenResult[] r103 = {r100, r101, r102};
        f435195a = r103;
        f435196b = EnumEntriesKt.enumEntries(r103);
    }

    public static SubtitleOpenResult[] values() {
        return (SubtitleOpenResult[]) f435195a.clone();
    }

    public static SubtitleOpenResult valueOf(String r100) {
        return (SubtitleOpenResult) r27.a.a(SubtitleOpenResult.class, r100);
    }

    public SubtitleOpenResult(String r100, int r101) {
        super(r100, r101);
    }
}
