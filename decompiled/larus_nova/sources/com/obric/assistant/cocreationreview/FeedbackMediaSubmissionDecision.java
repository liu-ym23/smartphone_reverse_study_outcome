package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaSubmissionDecision;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOAD", "WAIT", "SUBMIT_FEEDBACK", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaSubmissionDecision extends Enum<FeedbackMediaSubmissionDecision> {
    public static final FeedbackMediaSubmissionDecision SUBMIT_FEEDBACK = null;
    public static final FeedbackMediaSubmissionDecision UPLOAD = null;
    public static final FeedbackMediaSubmissionDecision WAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackMediaSubmissionDecision[] f387138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387139b = null;

    public static EnumEntries<FeedbackMediaSubmissionDecision> getEntries() {
        return f387139b;
    }

    static {
        FeedbackMediaSubmissionDecision r100 = new FeedbackMediaSubmissionDecision("UPLOAD", 0);
        UPLOAD = r100;
        FeedbackMediaSubmissionDecision r101 = new FeedbackMediaSubmissionDecision("WAIT", 1);
        WAIT = r101;
        FeedbackMediaSubmissionDecision r102 = new FeedbackMediaSubmissionDecision("SUBMIT_FEEDBACK", 2);
        SUBMIT_FEEDBACK = r102;
        FeedbackMediaSubmissionDecision[] r103 = {r100, r101, r102};
        f387138a = r103;
        f387139b = EnumEntriesKt.enumEntries(r103);
    }

    public static FeedbackMediaSubmissionDecision[] values() {
        return (FeedbackMediaSubmissionDecision[]) f387138a.clone();
    }

    public static FeedbackMediaSubmissionDecision valueOf(String r100) {
        return (FeedbackMediaSubmissionDecision) r27.a.a(FeedbackMediaSubmissionDecision.class, r100);
    }

    public FeedbackMediaSubmissionDecision(String r100, int r101) {
        super(r100, r101);
    }
}
