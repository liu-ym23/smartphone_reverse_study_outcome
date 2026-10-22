package org.apache.commons.net.smtp;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum AuthenticatingSMTPClient$AUTH_METHOD extends Enum<AuthenticatingSMTPClient$AUTH_METHOD> {
    private static final /* synthetic */ AuthenticatingSMTPClient$AUTH_METHOD[] $VALUES = null;
    public static final AuthenticatingSMTPClient$AUTH_METHOD CRAM_MD5 = null;
    public static final AuthenticatingSMTPClient$AUTH_METHOD LOGIN = null;
    public static final AuthenticatingSMTPClient$AUTH_METHOD PLAIN = null;
    public static final AuthenticatingSMTPClient$AUTH_METHOD XOAUTH = null;

    static {
        AuthenticatingSMTPClient$AUTH_METHOD r100 = new AuthenticatingSMTPClient$AUTH_METHOD("PLAIN", 0);
        PLAIN = r100;
        AuthenticatingSMTPClient$AUTH_METHOD r101 = new AuthenticatingSMTPClient$AUTH_METHOD("CRAM_MD5", 1);
        CRAM_MD5 = r101;
        AuthenticatingSMTPClient$AUTH_METHOD r102 = new AuthenticatingSMTPClient$AUTH_METHOD("LOGIN", 2);
        LOGIN = r102;
        AuthenticatingSMTPClient$AUTH_METHOD r103 = new AuthenticatingSMTPClient$AUTH_METHOD("XOAUTH", 3);
        XOAUTH = r103;
        $VALUES = new AuthenticatingSMTPClient$AUTH_METHOD[]{r100, r101, r102, r103};
    }

    public static AuthenticatingSMTPClient$AUTH_METHOD[] values() {
        return (AuthenticatingSMTPClient$AUTH_METHOD[]) $VALUES.clone();
    }

    public static final String getAuthName(AuthenticatingSMTPClient$AUTH_METHOD r100) {
        if (r100.equals(PLAIN) == false) goto L7;
        return "PLAIN";
    L7:
        if (r100.equals(CRAM_MD5) == false) goto L11;
        return "CRAM-MD5";
    L11:
        if (r100.equals(LOGIN) == false) goto L15;
        return "LOGIN";
    L15:
        if (r100.equals(XOAUTH) == false) goto L18;
        return "XOAUTH";
    L18:
        return null;
    }

    public static AuthenticatingSMTPClient$AUTH_METHOD valueOf(String r100) {
        return (AuthenticatingSMTPClient$AUTH_METHOD) a.a(AuthenticatingSMTPClient$AUTH_METHOD.class, r100);
    }

    private AuthenticatingSMTPClient$AUTH_METHOD(String r100, int r101) {
        super(r100, r101);
    }
}
