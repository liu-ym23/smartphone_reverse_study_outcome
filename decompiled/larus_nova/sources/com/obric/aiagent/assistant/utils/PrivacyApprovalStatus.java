package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CannotObtain", "Timeout", "NotApproved", "Approved", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PrivacyApprovalStatus extends Enum<PrivacyApprovalStatus> {
    public static final PrivacyApprovalStatus Approved = null;
    public static final PrivacyApprovalStatus CannotObtain = null;
    public static final PrivacyApprovalStatus NotApproved = null;
    public static final PrivacyApprovalStatus Timeout = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrivacyApprovalStatus[] f384609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384610b = null;

    public static EnumEntries<PrivacyApprovalStatus> getEntries() {
        return f384610b;
    }

    static {
        PrivacyApprovalStatus r100 = new PrivacyApprovalStatus("CannotObtain", 0);
        CannotObtain = r100;
        PrivacyApprovalStatus r101 = new PrivacyApprovalStatus("Timeout", 1);
        Timeout = r101;
        PrivacyApprovalStatus r102 = new PrivacyApprovalStatus("NotApproved", 2);
        NotApproved = r102;
        PrivacyApprovalStatus r103 = new PrivacyApprovalStatus("Approved", 3);
        Approved = r103;
        PrivacyApprovalStatus[] r104 = {r100, r101, r102, r103};
        f384609a = r104;
        f384610b = EnumEntriesKt.enumEntries(r104);
    }

    public static PrivacyApprovalStatus[] values() {
        return (PrivacyApprovalStatus[]) f384609a.clone();
    }

    public static PrivacyApprovalStatus valueOf(String r100) {
        return (PrivacyApprovalStatus) r27.a.a(PrivacyApprovalStatus.class, r100);
    }

    public PrivacyApprovalStatus(String r100, int r101) {
        super(r100, r101);
    }
}
