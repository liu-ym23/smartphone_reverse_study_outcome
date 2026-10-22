package com.bytedance.cloudplay.xplay2.api.module.auth;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/auth/AuthResult;", "", "SUCCESS", "FAIL", "CANCEL", "EXIT", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum AuthResult extends Enum<AuthResult> {
    public static final AuthResult CANCEL = null;
    public static final AuthResult EXIT = null;
    public static final AuthResult FAIL = null;
    public static final AuthResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthResult[] f202796a = null;

    public static AuthResult valueOf(String r100) {
        return (AuthResult) a.a(AuthResult.class, r100);
    }

    public static AuthResult[] values() {
        return (AuthResult[]) f202796a.clone();
    }

    static {
        AuthResult r100 = new AuthResult("SUCCESS", 0);
        SUCCESS = r100;
        AuthResult r101 = new AuthResult("FAIL", 1);
        FAIL = r101;
        AuthResult r102 = new AuthResult("CANCEL", 2);
        CANCEL = r102;
        AuthResult r103 = new AuthResult("EXIT", 3);
        EXIT = r103;
        f202796a = new AuthResult[]{r100, r101, r102, r103};
    }

    public AuthResult(String r100, int r101) {
        super(r100, r101);
    }
}
