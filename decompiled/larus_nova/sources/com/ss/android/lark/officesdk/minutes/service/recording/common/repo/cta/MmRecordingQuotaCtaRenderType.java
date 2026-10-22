package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaRenderType;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "WindowLimited5H", "WindowLimited7D", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingQuotaCtaRenderType extends Enum<MmRecordingQuotaCtaRenderType> {
    public static final MmRecordingQuotaCtaRenderType Default = null;
    public static final MmRecordingQuotaCtaRenderType WindowLimited5H = null;
    public static final MmRecordingQuotaCtaRenderType WindowLimited7D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingQuotaCtaRenderType[] f434901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434902b = null;

    public static EnumEntries<MmRecordingQuotaCtaRenderType> getEntries() {
        return f434902b;
    }

    static {
        MmRecordingQuotaCtaRenderType r100 = new MmRecordingQuotaCtaRenderType("Default", 0);
        Default = r100;
        MmRecordingQuotaCtaRenderType r101 = new MmRecordingQuotaCtaRenderType("WindowLimited5H", 1);
        WindowLimited5H = r101;
        MmRecordingQuotaCtaRenderType r102 = new MmRecordingQuotaCtaRenderType("WindowLimited7D", 2);
        WindowLimited7D = r102;
        MmRecordingQuotaCtaRenderType[] r103 = {r100, r101, r102};
        f434901a = r103;
        f434902b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingQuotaCtaRenderType[] values() {
        return (MmRecordingQuotaCtaRenderType[]) f434901a.clone();
    }

    public static MmRecordingQuotaCtaRenderType valueOf(String r100) {
        return (MmRecordingQuotaCtaRenderType) r27.a.a(MmRecordingQuotaCtaRenderType.class, r100);
    }

    public MmRecordingQuotaCtaRenderType(String r100, int r101) {
        super(r100, r101);
    }
}
