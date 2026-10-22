package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoTranslationStage;", "", "<init>", "(Ljava/lang/String;I)V", "TRANSLATION", "BILINGUAL", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAutoTranslationStage extends Enum<MmAutoTranslationStage> {
    public static final MmAutoTranslationStage BILINGUAL = null;
    public static final MmAutoTranslationStage TRANSLATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAutoTranslationStage[] f435250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435251b = null;

    public static EnumEntries<MmAutoTranslationStage> getEntries() {
        return f435251b;
    }

    static {
        MmAutoTranslationStage r100 = new MmAutoTranslationStage("TRANSLATION", 0);
        TRANSLATION = r100;
        MmAutoTranslationStage r101 = new MmAutoTranslationStage("BILINGUAL", 1);
        BILINGUAL = r101;
        MmAutoTranslationStage[] r102 = {r100, r101};
        f435250a = r102;
        f435251b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAutoTranslationStage[] values() {
        return (MmAutoTranslationStage[]) f435250a.clone();
    }

    public static MmAutoTranslationStage valueOf(String r100) {
        return (MmAutoTranslationStage) r27.a.a(MmAutoTranslationStage.class, r100);
    }

    public MmAutoTranslationStage(String r100, int r101) {
        super(r100, r101);
    }
}
