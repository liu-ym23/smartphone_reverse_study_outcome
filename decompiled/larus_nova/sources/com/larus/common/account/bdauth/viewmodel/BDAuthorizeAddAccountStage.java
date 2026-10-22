package com.larus.common.account.bdauth.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeAddAccountStage;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "OpeningLoginPanel", "WaitingAddAccountResult", "Completed", "Failed", "isInProgress", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeAddAccountStage extends Enum<BDAuthorizeAddAccountStage> {
    public static final BDAuthorizeAddAccountStage Completed = null;
    public static final BDAuthorizeAddAccountStage Failed = null;
    public static final BDAuthorizeAddAccountStage Idle = null;
    public static final BDAuthorizeAddAccountStage OpeningLoginPanel = null;
    public static final BDAuthorizeAddAccountStage WaitingAddAccountResult = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDAuthorizeAddAccountStage[] f325967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325968b = null;

    public static EnumEntries<BDAuthorizeAddAccountStage> getEntries() {
        return f325968b;
    }

    static {
        BDAuthorizeAddAccountStage r100 = new BDAuthorizeAddAccountStage("Idle", 0);
        Idle = r100;
        BDAuthorizeAddAccountStage r101 = new BDAuthorizeAddAccountStage("OpeningLoginPanel", 1);
        OpeningLoginPanel = r101;
        BDAuthorizeAddAccountStage r102 = new BDAuthorizeAddAccountStage("WaitingAddAccountResult", 2);
        WaitingAddAccountResult = r102;
        BDAuthorizeAddAccountStage r103 = new BDAuthorizeAddAccountStage("Completed", 3);
        Completed = r103;
        BDAuthorizeAddAccountStage r104 = new BDAuthorizeAddAccountStage("Failed", 4);
        Failed = r104;
        BDAuthorizeAddAccountStage[] r105 = {r100, r101, r102, r103, r104};
        f325967a = r105;
        f325968b = EnumEntriesKt.enumEntries(r105);
    }

    public static BDAuthorizeAddAccountStage[] values() {
        return (BDAuthorizeAddAccountStage[]) f325967a.clone();
    }

    public final boolean isInProgress() {
        if (this != OpeningLoginPanel) goto L5;
    L8:
        return true;
    L5:
        if (this == WaitingAddAccountResult) goto L8;
        return false;
    }

    public static BDAuthorizeAddAccountStage valueOf(String r100) {
        return (BDAuthorizeAddAccountStage) r27.a.a(BDAuthorizeAddAccountStage.class, r100);
    }

    public BDAuthorizeAddAccountStage(String r100, int r101) {
        super(r100, r101);
    }
}
