package org.apache.commons.net.pop3;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ExtendedPOP3Client$AUTH_METHOD extends Enum<ExtendedPOP3Client$AUTH_METHOD> {
    private static final /* synthetic */ ExtendedPOP3Client$AUTH_METHOD[] $VALUES = null;
    public static final ExtendedPOP3Client$AUTH_METHOD CRAM_MD5 = null;
    public static final ExtendedPOP3Client$AUTH_METHOD PLAIN = null;
    private final String methodName;

    static {
        ExtendedPOP3Client$AUTH_METHOD r100 = new ExtendedPOP3Client$AUTH_METHOD("PLAIN", 0, "PLAIN");
        PLAIN = r100;
        ExtendedPOP3Client$AUTH_METHOD r101 = new ExtendedPOP3Client$AUTH_METHOD("CRAM_MD5", 1, "CRAM-MD5");
        CRAM_MD5 = r101;
        $VALUES = new ExtendedPOP3Client$AUTH_METHOD[]{r100, r101};
    }

    public static ExtendedPOP3Client$AUTH_METHOD[] values() {
        return (ExtendedPOP3Client$AUTH_METHOD[]) $VALUES.clone();
    }

    public final String getAuthName() {
        return this.methodName;
    }

    public static ExtendedPOP3Client$AUTH_METHOD valueOf(String r100) {
        return (ExtendedPOP3Client$AUTH_METHOD) a.a(ExtendedPOP3Client$AUTH_METHOD.class, r100);
    }

    private ExtendedPOP3Client$AUTH_METHOD(String r100, int r101, String r102) {
        super(r100, r101);
        this.methodName = r102;
    }
}
