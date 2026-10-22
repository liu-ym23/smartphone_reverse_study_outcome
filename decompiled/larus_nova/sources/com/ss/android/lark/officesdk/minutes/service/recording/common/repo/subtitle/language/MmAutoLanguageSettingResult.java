package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoLanguageSettingResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "OBSOLETE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAutoLanguageSettingResult extends Enum<MmAutoLanguageSettingResult> {
    public static final MmAutoLanguageSettingResult FAILED = null;
    public static final MmAutoLanguageSettingResult OBSOLETE = null;
    public static final MmAutoLanguageSettingResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAutoLanguageSettingResult[] f435248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435249b = null;

    public static EnumEntries<MmAutoLanguageSettingResult> getEntries() {
        return f435249b;
    }

    static {
        MmAutoLanguageSettingResult r100 = new MmAutoLanguageSettingResult("SUCCESS", 0);
        SUCCESS = r100;
        MmAutoLanguageSettingResult r101 = new MmAutoLanguageSettingResult("FAILED", 1);
        FAILED = r101;
        MmAutoLanguageSettingResult r102 = new MmAutoLanguageSettingResult("OBSOLETE", 2);
        OBSOLETE = r102;
        MmAutoLanguageSettingResult[] r103 = {r100, r101, r102};
        f435248a = r103;
        f435249b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmAutoLanguageSettingResult[] values() {
        return (MmAutoLanguageSettingResult[]) f435248a.clone();
    }

    public static MmAutoLanguageSettingResult valueOf(String r100) {
        return (MmAutoLanguageSettingResult) r27.a.a(MmAutoLanguageSettingResult.class, r100);
    }

    public MmAutoLanguageSettingResult(String r100, int r101) {
        super(r100, r101);
    }
}
