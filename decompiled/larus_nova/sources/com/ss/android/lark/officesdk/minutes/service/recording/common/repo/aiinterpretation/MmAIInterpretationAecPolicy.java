package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationAecPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORE", "TRANSCRIPT_ONLY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAIInterpretationAecPolicy extends Enum<MmAIInterpretationAecPolicy> {
    public static final MmAIInterpretationAecPolicy RESTORE = null;
    public static final MmAIInterpretationAecPolicy TRANSCRIPT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAIInterpretationAecPolicy[] f434726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434727b = null;

    public static EnumEntries<MmAIInterpretationAecPolicy> getEntries() {
        return f434727b;
    }

    static {
        MmAIInterpretationAecPolicy r100 = new MmAIInterpretationAecPolicy("RESTORE", 0);
        RESTORE = r100;
        MmAIInterpretationAecPolicy r101 = new MmAIInterpretationAecPolicy("TRANSCRIPT_ONLY", 1);
        TRANSCRIPT_ONLY = r101;
        MmAIInterpretationAecPolicy[] r102 = {r100, r101};
        f434726a = r102;
        f434727b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAIInterpretationAecPolicy[] values() {
        return (MmAIInterpretationAecPolicy[]) f434726a.clone();
    }

    public static MmAIInterpretationAecPolicy valueOf(String r100) {
        return (MmAIInterpretationAecPolicy) r27.a.a(MmAIInterpretationAecPolicy.class, r100);
    }

    public MmAIInterpretationAecPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
