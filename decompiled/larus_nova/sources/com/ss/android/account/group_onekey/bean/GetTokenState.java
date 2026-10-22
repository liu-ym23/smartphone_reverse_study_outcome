package com.ss.android.account.group_onekey.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/account/group_onekey/bean/GetTokenState;", "", "DEFAULT", "REQUESTING", "account-sdk-group-onekey_release"}, k = 1, mv = {1, 4, 0})
public final enum GetTokenState extends Enum<GetTokenState> {
    public static final GetTokenState DEFAULT = null;
    public static final GetTokenState REQUESTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetTokenState[] f406290a = null;

    static {
        GetTokenState r100 = new GetTokenState("DEFAULT", 0);
        DEFAULT = r100;
        GetTokenState r101 = new GetTokenState("REQUESTING", 1);
        REQUESTING = r101;
        f406290a = new GetTokenState[]{r100, r101};
    }

    public static GetTokenState valueOf(String r100) {
        return (GetTokenState) a.a(GetTokenState.class, r100);
    }

    public static GetTokenState[] values() {
        return (GetTokenState[]) f406290a.clone();
    }

    public GetTokenState(String r100, int r101) {
        super(r100, r101);
    }
}
