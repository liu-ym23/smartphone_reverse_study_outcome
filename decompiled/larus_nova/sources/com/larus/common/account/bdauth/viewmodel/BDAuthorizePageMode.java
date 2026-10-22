package com.larus.common.account.bdauth.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizePageMode;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Content", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizePageMode extends Enum<BDAuthorizePageMode> {
    public static final BDAuthorizePageMode Content = null;
    public static final BDAuthorizePageMode Loading = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDAuthorizePageMode[] f325969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325970b = null;

    public static EnumEntries<BDAuthorizePageMode> getEntries() {
        return f325970b;
    }

    static {
        BDAuthorizePageMode r100 = new BDAuthorizePageMode("Loading", 0);
        Loading = r100;
        BDAuthorizePageMode r101 = new BDAuthorizePageMode("Content", 1);
        Content = r101;
        BDAuthorizePageMode[] r102 = {r100, r101};
        f325969a = r102;
        f325970b = EnumEntriesKt.enumEntries(r102);
    }

    public static BDAuthorizePageMode[] values() {
        return (BDAuthorizePageMode[]) f325969a.clone();
    }

    public static BDAuthorizePageMode valueOf(String r100) {
        return (BDAuthorizePageMode) r27.a.a(BDAuthorizePageMode.class, r100);
    }

    public BDAuthorizePageMode(String r100, int r101) {
        super(r100, r101);
    }
}
