package com.larus.account.base.model;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum AuthorizationPlatform extends Enum<AuthorizationPlatform> {
    public static final AuthorizationPlatform LARK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthorizationPlatform[] f286197a = null;

    static {
        AuthorizationPlatform r100 = new AuthorizationPlatform();
        LARK = r100;
        f286197a = new AuthorizationPlatform[]{r100};
    }

    public AuthorizationPlatform() {
        super(AccountType.LARK, 0);
    }

    public static AuthorizationPlatform[] values() {
        return (AuthorizationPlatform[]) f286197a.clone();
    }

    public static AuthorizationPlatform valueOf(String r100) {
        return (AuthorizationPlatform) a.a(AuthorizationPlatform.class, r100);
    }
}
