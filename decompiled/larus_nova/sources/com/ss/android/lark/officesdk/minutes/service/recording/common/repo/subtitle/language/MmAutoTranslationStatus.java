package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoTranslationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "APPLYING", "APPLIED", "SKIPPED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAutoTranslationStatus extends Enum<MmAutoTranslationStatus> {
    public static final MmAutoTranslationStatus APPLIED = null;
    public static final MmAutoTranslationStatus APPLYING = null;
    public static final MmAutoTranslationStatus SKIPPED = null;
    public static final MmAutoTranslationStatus WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAutoTranslationStatus[] f435252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435253b = null;

    public static EnumEntries<MmAutoTranslationStatus> getEntries() {
        return f435253b;
    }

    static {
        MmAutoTranslationStatus r100 = new MmAutoTranslationStatus("WAITING", 0);
        WAITING = r100;
        MmAutoTranslationStatus r101 = new MmAutoTranslationStatus("APPLYING", 1);
        APPLYING = r101;
        MmAutoTranslationStatus r102 = new MmAutoTranslationStatus("APPLIED", 2);
        APPLIED = r102;
        MmAutoTranslationStatus r103 = new MmAutoTranslationStatus("SKIPPED", 3);
        SKIPPED = r103;
        MmAutoTranslationStatus[] r104 = {r100, r101, r102, r103};
        f435252a = r104;
        f435253b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmAutoTranslationStatus[] values() {
        return (MmAutoTranslationStatus[]) f435252a.clone();
    }

    public static MmAutoTranslationStatus valueOf(String r100) {
        return (MmAutoTranslationStatus) r27.a.a(MmAutoTranslationStatus.class, r100);
    }

    public MmAutoTranslationStatus(String r100, int r101) {
        super(r100, r101);
    }
}
