package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageSide;", "", "<init>", "(Ljava/lang/String;I)V", "SPOKEN", "TARGET", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmStandaloneAIInterpretationLanguageSide extends Enum<MmStandaloneAIInterpretationLanguageSide> {
    public static final MmStandaloneAIInterpretationLanguageSide SPOKEN = null;
    public static final MmStandaloneAIInterpretationLanguageSide TARGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmStandaloneAIInterpretationLanguageSide[] f436728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436729b = null;

    public static EnumEntries<MmStandaloneAIInterpretationLanguageSide> getEntries() {
        return f436729b;
    }

    static {
        MmStandaloneAIInterpretationLanguageSide r100 = new MmStandaloneAIInterpretationLanguageSide("SPOKEN", 0);
        SPOKEN = r100;
        MmStandaloneAIInterpretationLanguageSide r101 = new MmStandaloneAIInterpretationLanguageSide("TARGET", 1);
        TARGET = r101;
        MmStandaloneAIInterpretationLanguageSide[] r102 = {r100, r101};
        f436728a = r102;
        f436729b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmStandaloneAIInterpretationLanguageSide[] values() {
        return (MmStandaloneAIInterpretationLanguageSide[]) f436728a.clone();
    }

    public static MmStandaloneAIInterpretationLanguageSide valueOf(String r100) {
        return (MmStandaloneAIInterpretationLanguageSide) r27.a.a(MmStandaloneAIInterpretationLanguageSide.class, r100);
    }

    public MmStandaloneAIInterpretationLanguageSide(String r100, int r101) {
        super(r100, r101);
    }
}
