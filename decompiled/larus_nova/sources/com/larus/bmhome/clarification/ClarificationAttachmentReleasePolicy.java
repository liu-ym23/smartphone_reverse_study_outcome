package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/clarification/ClarificationAttachmentReleasePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "DETACH_ONLY", "DETACH_AND_KEEP_FOR_RESULT", "DISMISS_AND_DELETE_TEMP_RESOURCES", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ClarificationAttachmentReleasePolicy extends Enum<ClarificationAttachmentReleasePolicy> {
    public static final ClarificationAttachmentReleasePolicy DETACH_AND_KEEP_FOR_RESULT = null;
    public static final ClarificationAttachmentReleasePolicy DETACH_ONLY = null;
    public static final ClarificationAttachmentReleasePolicy DISMISS_AND_DELETE_TEMP_RESOURCES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClarificationAttachmentReleasePolicy[] f310451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f310452b = null;

    public static EnumEntries<ClarificationAttachmentReleasePolicy> getEntries() {
        return f310452b;
    }

    static {
        ClarificationAttachmentReleasePolicy r100 = new ClarificationAttachmentReleasePolicy("DETACH_ONLY", 0);
        DETACH_ONLY = r100;
        ClarificationAttachmentReleasePolicy r101 = new ClarificationAttachmentReleasePolicy("DETACH_AND_KEEP_FOR_RESULT", 1);
        DETACH_AND_KEEP_FOR_RESULT = r101;
        ClarificationAttachmentReleasePolicy r102 = new ClarificationAttachmentReleasePolicy("DISMISS_AND_DELETE_TEMP_RESOURCES", 2);
        DISMISS_AND_DELETE_TEMP_RESOURCES = r102;
        ClarificationAttachmentReleasePolicy[] r103 = {r100, r101, r102};
        f310451a = r103;
        f310452b = EnumEntriesKt.enumEntries(r103);
    }

    public static ClarificationAttachmentReleasePolicy[] values() {
        return (ClarificationAttachmentReleasePolicy[]) f310451a.clone();
    }

    public static ClarificationAttachmentReleasePolicy valueOf(String r100) {
        return (ClarificationAttachmentReleasePolicy) r27.a.a(ClarificationAttachmentReleasePolicy.class, r100);
    }

    public ClarificationAttachmentReleasePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
