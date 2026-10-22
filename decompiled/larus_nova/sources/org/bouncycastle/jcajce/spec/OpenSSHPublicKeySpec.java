package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = null;
    private final String type;

    static {
        allowedTypes = new String[]{"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    }

    public OpenSSHPublicKeySpec(byte[] r100) {
        super(r100);
        int r101 = 0;
        int r102 = (((((r100[0] & UByte.MAX_VALUE) << 24) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8)) | (r100[3] & UByte.MAX_VALUE)) + 4;
        if (r102 >= r100.length) goto L16;
        String r103 = Strings.fromByteArray(Arrays.copyOfRange(r100, 4, r102));
        this.type = r103;
        if (r103.startsWith("ecdsa") == false) goto L7;
        return;
    L7:
        String[] r104 = allowedTypes;
        if (r101 >= r104.length) goto L14;
        if (r104[r101].equals(this.type) == true) goto L11;
        r101 = r101 + 1;
        goto L7
    L11:
        return;
    L14:
        throw new IllegalArgumentException("unrecognised public key type " + this.type);
    L16:
        throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }

    public String getType() {
        return this.type;
    }
}
