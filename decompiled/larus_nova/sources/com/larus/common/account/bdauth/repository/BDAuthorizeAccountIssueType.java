package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/bdauth/repository/BDAuthorizeAccountIssueType;", "", "<init>", "(Ljava/lang/String;I)V", "SessionExpired", "AccountDeactivated", "EnterpriseUnsupported", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeAccountIssueType extends Enum<BDAuthorizeAccountIssueType> {
    public static final BDAuthorizeAccountIssueType AccountDeactivated = null;
    public static final BDAuthorizeAccountIssueType EnterpriseUnsupported = null;
    public static final BDAuthorizeAccountIssueType SessionExpired = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDAuthorizeAccountIssueType[] f325913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325914b = null;

    public static EnumEntries<BDAuthorizeAccountIssueType> getEntries() {
        return f325914b;
    }

    static {
        BDAuthorizeAccountIssueType r100 = new BDAuthorizeAccountIssueType("SessionExpired", 0);
        SessionExpired = r100;
        BDAuthorizeAccountIssueType r101 = new BDAuthorizeAccountIssueType("AccountDeactivated", 1);
        AccountDeactivated = r101;
        BDAuthorizeAccountIssueType r102 = new BDAuthorizeAccountIssueType("EnterpriseUnsupported", 2);
        EnterpriseUnsupported = r102;
        BDAuthorizeAccountIssueType[] r103 = {r100, r101, r102};
        f325913a = r103;
        f325914b = EnumEntriesKt.enumEntries(r103);
    }

    public static BDAuthorizeAccountIssueType[] values() {
        return (BDAuthorizeAccountIssueType[]) f325913a.clone();
    }

    public static BDAuthorizeAccountIssueType valueOf(String r100) {
        return (BDAuthorizeAccountIssueType) r27.a.a(BDAuthorizeAccountIssueType.class, r100);
    }

    public BDAuthorizeAccountIssueType(String r100, int r101) {
        super(r100, r101);
    }
}
