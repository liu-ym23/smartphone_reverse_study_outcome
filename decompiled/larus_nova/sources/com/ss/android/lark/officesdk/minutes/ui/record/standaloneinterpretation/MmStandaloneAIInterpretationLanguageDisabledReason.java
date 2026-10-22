package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageDisabledReason;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_LANGUAGE", "SOURCE_TO_TARGET_UNSUPPORTED", "TARGET_TO_SOURCE_UNSUPPORTED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmStandaloneAIInterpretationLanguageDisabledReason extends Enum<MmStandaloneAIInterpretationLanguageDisabledReason> {
    public static final MmStandaloneAIInterpretationLanguageDisabledReason SAME_LANGUAGE = null;
    public static final MmStandaloneAIInterpretationLanguageDisabledReason SOURCE_TO_TARGET_UNSUPPORTED = null;
    public static final MmStandaloneAIInterpretationLanguageDisabledReason TARGET_TO_SOURCE_UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmStandaloneAIInterpretationLanguageDisabledReason[] f436708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436709b = null;

    public static EnumEntries<MmStandaloneAIInterpretationLanguageDisabledReason> getEntries() {
        return f436709b;
    }

    static {
        MmStandaloneAIInterpretationLanguageDisabledReason r100 = new MmStandaloneAIInterpretationLanguageDisabledReason("SAME_LANGUAGE", 0);
        SAME_LANGUAGE = r100;
        MmStandaloneAIInterpretationLanguageDisabledReason r101 = new MmStandaloneAIInterpretationLanguageDisabledReason("SOURCE_TO_TARGET_UNSUPPORTED", 1);
        SOURCE_TO_TARGET_UNSUPPORTED = r101;
        MmStandaloneAIInterpretationLanguageDisabledReason r102 = new MmStandaloneAIInterpretationLanguageDisabledReason("TARGET_TO_SOURCE_UNSUPPORTED", 2);
        TARGET_TO_SOURCE_UNSUPPORTED = r102;
        MmStandaloneAIInterpretationLanguageDisabledReason[] r103 = {r100, r101, r102};
        f436708a = r103;
        f436709b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmStandaloneAIInterpretationLanguageDisabledReason[] values() {
        return (MmStandaloneAIInterpretationLanguageDisabledReason[]) f436708a.clone();
    }

    public static MmStandaloneAIInterpretationLanguageDisabledReason valueOf(String r100) {
        return (MmStandaloneAIInterpretationLanguageDisabledReason) r27.a.a(MmStandaloneAIInterpretationLanguageDisabledReason.class, r100);
    }

    public MmStandaloneAIInterpretationLanguageDisabledReason(String r100, int r101) {
        super(r100, r101);
    }
}
