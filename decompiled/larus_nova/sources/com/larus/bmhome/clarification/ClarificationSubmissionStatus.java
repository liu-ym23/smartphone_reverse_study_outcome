package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/clarification/ClarificationSubmissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH", "CANCEL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClarificationSubmissionStatus extends Enum<ClarificationSubmissionStatus> {
    public static final ClarificationSubmissionStatus CANCEL = null;
    public static final ClarificationSubmissionStatus FINISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClarificationSubmissionStatus[] f310478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f310479b = null;

    public static EnumEntries<ClarificationSubmissionStatus> getEntries() {
        return f310479b;
    }

    static {
        ClarificationSubmissionStatus r100 = new ClarificationSubmissionStatus("FINISH", 0);
        FINISH = r100;
        ClarificationSubmissionStatus r101 = new ClarificationSubmissionStatus("CANCEL", 1);
        CANCEL = r101;
        ClarificationSubmissionStatus[] r102 = {r100, r101};
        f310478a = r102;
        f310479b = EnumEntriesKt.enumEntries(r102);
    }

    public static ClarificationSubmissionStatus[] values() {
        return (ClarificationSubmissionStatus[]) f310478a.clone();
    }

    public static ClarificationSubmissionStatus valueOf(String r100) {
        return (ClarificationSubmissionStatus) r27.a.a(ClarificationSubmissionStatus.class, r100);
    }

    public ClarificationSubmissionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
