package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/SubtitleFailedQuotaDecision;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_FAILED", "CLEAR", "PEND", "NOOP", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubtitleFailedQuotaDecision extends Enum<SubtitleFailedQuotaDecision> {
    public static final SubtitleFailedQuotaDecision CLEAR = null;
    public static final SubtitleFailedQuotaDecision NOOP = null;
    public static final SubtitleFailedQuotaDecision PEND = null;
    public static final SubtitleFailedQuotaDecision SEND_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleFailedQuotaDecision[] f435193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435194b = null;

    public static EnumEntries<SubtitleFailedQuotaDecision> getEntries() {
        return f435194b;
    }

    static {
        SubtitleFailedQuotaDecision r100 = new SubtitleFailedQuotaDecision("SEND_FAILED", 0);
        SEND_FAILED = r100;
        SubtitleFailedQuotaDecision r101 = new SubtitleFailedQuotaDecision("CLEAR", 1);
        CLEAR = r101;
        SubtitleFailedQuotaDecision r102 = new SubtitleFailedQuotaDecision("PEND", 2);
        PEND = r102;
        SubtitleFailedQuotaDecision r103 = new SubtitleFailedQuotaDecision("NOOP", 3);
        NOOP = r103;
        SubtitleFailedQuotaDecision[] r104 = {r100, r101, r102, r103};
        f435193a = r104;
        f435194b = EnumEntriesKt.enumEntries(r104);
    }

    public static SubtitleFailedQuotaDecision[] values() {
        return (SubtitleFailedQuotaDecision[]) f435193a.clone();
    }

    public static SubtitleFailedQuotaDecision valueOf(String r100) {
        return (SubtitleFailedQuotaDecision) r27.a.a(SubtitleFailedQuotaDecision.class, r100);
    }

    public SubtitleFailedQuotaDecision(String r100, int r101) {
        super(r100, r101);
    }
}
