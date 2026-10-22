package com.larus.agents.impl.experience;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/agents/impl/experience/WorkExperienceMutationResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "SECURITY_RISK", "DUPLICATE_NAME", "FAILURE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkExperienceMutationResult extends Enum<WorkExperienceMutationResult> {
    public static final WorkExperienceMutationResult DUPLICATE_NAME = null;
    public static final WorkExperienceMutationResult FAILURE = null;
    public static final WorkExperienceMutationResult SECURITY_RISK = null;
    public static final WorkExperienceMutationResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkExperienceMutationResult[] f286656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286657b = null;

    public static EnumEntries<WorkExperienceMutationResult> getEntries() {
        return f286657b;
    }

    static {
        WorkExperienceMutationResult r100 = new WorkExperienceMutationResult("SUCCESS", 0);
        SUCCESS = r100;
        WorkExperienceMutationResult r101 = new WorkExperienceMutationResult("SECURITY_RISK", 1);
        SECURITY_RISK = r101;
        WorkExperienceMutationResult r102 = new WorkExperienceMutationResult("DUPLICATE_NAME", 2);
        DUPLICATE_NAME = r102;
        WorkExperienceMutationResult r103 = new WorkExperienceMutationResult("FAILURE", 3);
        FAILURE = r103;
        WorkExperienceMutationResult[] r104 = {r100, r101, r102, r103};
        f286656a = r104;
        f286657b = EnumEntriesKt.enumEntries(r104);
    }

    public static WorkExperienceMutationResult[] values() {
        return (WorkExperienceMutationResult[]) f286656a.clone();
    }

    public static WorkExperienceMutationResult valueOf(String r100) {
        return (WorkExperienceMutationResult) r27.a.a(WorkExperienceMutationResult.class, r100);
    }

    public WorkExperienceMutationResult(String r100, int r101) {
        super(r100, r101);
    }
}
