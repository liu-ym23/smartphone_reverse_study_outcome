package com.larus.agents.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "MAX_CHARACTER_LIMIT_EXCEEDED", "SECURITY_RISK", "FAILURE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeTaskPreferenceSaveResult extends Enum<OfficeTaskPreferenceSaveResult> {
    public static final OfficeTaskPreferenceSaveResult FAILURE = null;
    public static final OfficeTaskPreferenceSaveResult MAX_CHARACTER_LIMIT_EXCEEDED = null;
    public static final OfficeTaskPreferenceSaveResult SECURITY_RISK = null;
    public static final OfficeTaskPreferenceSaveResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeTaskPreferenceSaveResult[] f286616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286617b = null;

    public static EnumEntries<OfficeTaskPreferenceSaveResult> getEntries() {
        return f286617b;
    }

    static {
        OfficeTaskPreferenceSaveResult r100 = new OfficeTaskPreferenceSaveResult("SUCCESS", 0);
        SUCCESS = r100;
        OfficeTaskPreferenceSaveResult r101 = new OfficeTaskPreferenceSaveResult("MAX_CHARACTER_LIMIT_EXCEEDED", 1);
        MAX_CHARACTER_LIMIT_EXCEEDED = r101;
        OfficeTaskPreferenceSaveResult r102 = new OfficeTaskPreferenceSaveResult("SECURITY_RISK", 2);
        SECURITY_RISK = r102;
        OfficeTaskPreferenceSaveResult r103 = new OfficeTaskPreferenceSaveResult("FAILURE", 3);
        FAILURE = r103;
        OfficeTaskPreferenceSaveResult[] r104 = {r100, r101, r102, r103};
        f286616a = r104;
        f286617b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeTaskPreferenceSaveResult[] values() {
        return (OfficeTaskPreferenceSaveResult[]) f286616a.clone();
    }

    public static OfficeTaskPreferenceSaveResult valueOf(String r100) {
        return (OfficeTaskPreferenceSaveResult) a.a(OfficeTaskPreferenceSaveResult.class, r100);
    }

    public OfficeTaskPreferenceSaveResult(String r100, int r101) {
        super(r100, r101);
    }
}
