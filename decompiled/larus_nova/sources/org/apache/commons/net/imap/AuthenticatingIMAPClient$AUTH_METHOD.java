package org.apache.commons.net.imap;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum AuthenticatingIMAPClient$AUTH_METHOD extends Enum<AuthenticatingIMAPClient$AUTH_METHOD> {
    private static final /* synthetic */ AuthenticatingIMAPClient$AUTH_METHOD[] $VALUES = null;
    public static final AuthenticatingIMAPClient$AUTH_METHOD CRAM_MD5 = null;
    public static final AuthenticatingIMAPClient$AUTH_METHOD LOGIN = null;
    public static final AuthenticatingIMAPClient$AUTH_METHOD PLAIN = null;
    public static final AuthenticatingIMAPClient$AUTH_METHOD XOAUTH = null;
    private final String authName;

    static {
        AuthenticatingIMAPClient$AUTH_METHOD r100 = new AuthenticatingIMAPClient$AUTH_METHOD("PLAIN", 0, "PLAIN");
        PLAIN = r100;
        AuthenticatingIMAPClient$AUTH_METHOD r101 = new AuthenticatingIMAPClient$AUTH_METHOD("CRAM_MD5", 1, "CRAM-MD5");
        CRAM_MD5 = r101;
        AuthenticatingIMAPClient$AUTH_METHOD r102 = new AuthenticatingIMAPClient$AUTH_METHOD("LOGIN", 2, "LOGIN");
        LOGIN = r102;
        AuthenticatingIMAPClient$AUTH_METHOD r103 = new AuthenticatingIMAPClient$AUTH_METHOD("XOAUTH", 3, "XOAUTH");
        XOAUTH = r103;
        $VALUES = new AuthenticatingIMAPClient$AUTH_METHOD[]{r100, r101, r102, r103};
    }

    public static AuthenticatingIMAPClient$AUTH_METHOD[] values() {
        return (AuthenticatingIMAPClient$AUTH_METHOD[]) $VALUES.clone();
    }

    public final String getAuthName() {
        return this.authName;
    }

    public static AuthenticatingIMAPClient$AUTH_METHOD valueOf(String r100) {
        return (AuthenticatingIMAPClient$AUTH_METHOD) a.a(AuthenticatingIMAPClient$AUTH_METHOD.class, r100);
    }

    private AuthenticatingIMAPClient$AUTH_METHOD(String r100, int r101, String r102) {
        super(r100, r101);
        this.authName = r102;
    }
}
