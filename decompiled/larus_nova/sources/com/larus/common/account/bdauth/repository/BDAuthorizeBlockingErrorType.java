package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common/account/bdauth/repository/BDAuthorizeBlockingErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "MinorMode", "EnterpriseAccount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeBlockingErrorType extends Enum<BDAuthorizeBlockingErrorType> {
    public static final BDAuthorizeBlockingErrorType EnterpriseAccount = null;
    public static final BDAuthorizeBlockingErrorType MinorMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDAuthorizeBlockingErrorType[] f325915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325916b = null;

    public static EnumEntries<BDAuthorizeBlockingErrorType> getEntries() {
        return f325916b;
    }

    static {
        BDAuthorizeBlockingErrorType r100 = new BDAuthorizeBlockingErrorType("MinorMode", 0);
        MinorMode = r100;
        BDAuthorizeBlockingErrorType r101 = new BDAuthorizeBlockingErrorType("EnterpriseAccount", 1);
        EnterpriseAccount = r101;
        BDAuthorizeBlockingErrorType[] r102 = {r100, r101};
        f325915a = r102;
        f325916b = EnumEntriesKt.enumEntries(r102);
    }

    public static BDAuthorizeBlockingErrorType[] values() {
        return (BDAuthorizeBlockingErrorType[]) f325915a.clone();
    }

    public static BDAuthorizeBlockingErrorType valueOf(String r100) {
        return (BDAuthorizeBlockingErrorType) r27.a.a(BDAuthorizeBlockingErrorType.class, r100);
    }

    public BDAuthorizeBlockingErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
