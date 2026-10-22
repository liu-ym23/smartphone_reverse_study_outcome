package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class OpenSSHPrivateKeySpec extends EncodedKeySpec {
    private final String format;

    public OpenSSHPrivateKeySpec(byte[] r100) {
        super(r100);
        byte r101 = r100[0];
        if (r101 != 48) goto L7;
        String r102 = "ASN.1";
    L5:
        this.format = r102;
        return;
    L7:
        if (r101 != 111) goto L11;
        r102 = "OpenSSH";
        goto L5
    L11:
        throw new IllegalArgumentException("unknown byte encoding");
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return this.format;
    }
}
