package com.ss.android.account;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/account/ThirdPartyAuthType;", "", "LOGIN", "IS_AUTHORIZE_ONLY", "IS_AUTHORIZE_AND_SWITCH", "BIND", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
public final enum ThirdPartyAuthType extends Enum<ThirdPartyAuthType> {
    public static final ThirdPartyAuthType BIND = null;
    public static final ThirdPartyAuthType IS_AUTHORIZE_AND_SWITCH = null;
    public static final ThirdPartyAuthType IS_AUTHORIZE_ONLY = null;
    public static final ThirdPartyAuthType LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThirdPartyAuthType[] f406229a = null;

    static {
        ThirdPartyAuthType r100 = new ThirdPartyAuthType("LOGIN", 0);
        LOGIN = r100;
        ThirdPartyAuthType r101 = new ThirdPartyAuthType("IS_AUTHORIZE_ONLY", 1);
        IS_AUTHORIZE_ONLY = r101;
        ThirdPartyAuthType r102 = new ThirdPartyAuthType("IS_AUTHORIZE_AND_SWITCH", 2);
        IS_AUTHORIZE_AND_SWITCH = r102;
        ThirdPartyAuthType r103 = new ThirdPartyAuthType("BIND", 3);
        BIND = r103;
        f406229a = new ThirdPartyAuthType[]{r100, r101, r102, r103};
    }

    public static ThirdPartyAuthType valueOf(String r100) {
        return (ThirdPartyAuthType) r27.a.a(ThirdPartyAuthType.class, r100);
    }

    public static ThirdPartyAuthType[] values() {
        return (ThirdPartyAuthType[]) f406229a.clone();
    }

    public ThirdPartyAuthType(String r100, int r101) {
        super(r100, r101);
    }
}
