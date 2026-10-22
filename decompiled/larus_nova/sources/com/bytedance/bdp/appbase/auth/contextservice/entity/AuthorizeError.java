package com.bytedance.bdp.appbase.auth.contextservice.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/auth/contextservice/entity/AuthorizeError;", "", "EMPTY_AUTH_LIST", "TYPE_MIXED", "NOT_LOGIN", "SCOPE_NOT_IN_PRIVACY_AGREEMENT", "USER_DENY_PRIVACY_AGREEMENT", "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public final enum AuthorizeError extends Enum<AuthorizeError> {
    public static final AuthorizeError EMPTY_AUTH_LIST = null;
    public static final AuthorizeError NOT_LOGIN = null;
    public static final AuthorizeError SCOPE_NOT_IN_PRIVACY_AGREEMENT = null;
    public static final AuthorizeError TYPE_MIXED = null;
    public static final AuthorizeError USER_DENY_PRIVACY_AGREEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthorizeError[] f200404a = null;

    static {
        AuthorizeError r100 = new AuthorizeError("EMPTY_AUTH_LIST", 0);
        EMPTY_AUTH_LIST = r100;
        AuthorizeError r101 = new AuthorizeError("TYPE_MIXED", 1);
        TYPE_MIXED = r101;
        AuthorizeError r102 = new AuthorizeError("NOT_LOGIN", 2);
        NOT_LOGIN = r102;
        AuthorizeError r103 = new AuthorizeError("SCOPE_NOT_IN_PRIVACY_AGREEMENT", 3);
        SCOPE_NOT_IN_PRIVACY_AGREEMENT = r103;
        AuthorizeError r104 = new AuthorizeError("USER_DENY_PRIVACY_AGREEMENT", 4);
        USER_DENY_PRIVACY_AGREEMENT = r104;
        f200404a = new AuthorizeError[]{r100, r101, r102, r103, r104};
    }

    public static AuthorizeError valueOf(String r100) {
        return (AuthorizeError) a.a(AuthorizeError.class, r100);
    }

    public static AuthorizeError[] values() {
        return (AuthorizeError[]) f200404a.clone();
    }

    public AuthorizeError(String r100, int r101) {
        super(r100, r101);
    }
}
