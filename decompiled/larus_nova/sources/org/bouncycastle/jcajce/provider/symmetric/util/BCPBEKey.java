package org.bouncycastle.jcajce.provider.symmetric.util;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.Destroyable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCPBEKey implements PBEKey, Destroyable {
    String algorithm;
    int digest;
    private final AtomicBoolean hasBeenDestroyed;
    private final int iterationCount;
    int ivSize;
    int keySize;
    ASN1ObjectIdentifier oid;
    private final CipherParameters param;
    private final char[] password;
    private final byte[] salt;
    boolean tryWrong;
    int type;

    public BCPBEKey(String r100, ASN1ObjectIdentifier r101, int r102, int r103, int r104, int r105, PBEKeySpec r106, CipherParameters r110) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = r100;
        this.oid = r101;
        this.type = r102;
        this.digest = r103;
        this.keySize = r104;
        this.ivSize = r105;
        this.password = r106.getPassword();
        this.iterationCount = r106.getIterationCount();
        this.salt = r106.getSalt();
        this.param = r110;
    }

    public BCPBEKey(String r100, CipherParameters r101) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = r100;
        this.param = r101;
        this.password = null;
        this.iterationCount = -1;
        this.salt = null;
    }

    public static void checkDestroyed(Destroyable r100) {
        if (r100.isDestroyed() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("key has been destroyed");
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true) == true) goto L11;
        char[] r100 = this.password;
        if (r100 == null) goto L7;
        Arrays.fill(r100, 0);
    L7:
        byte[] r101 = this.salt;
        if (r101 == null) goto L12;
        Arrays.fill(r101, (byte) 0);
        return;
    L12:
        return;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        checkDestroyed(this);
        return this.algorithm;
    }

    public int getDigest() {
        checkDestroyed(this);
        return this.digest;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        checkDestroyed(this);
        CipherParameters r100 = this.param;
        if (r100 != null) goto L5;
        int r101 = this.type;
        if (r101 != 2) goto L14;
        return PBEParametersGenerator.PKCS12PasswordToBytes(this.password);
    L14:
        if (r101 != 5) goto L18;
        return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.password);
    L18:
        return PBEParametersGenerator.PKCS5PasswordToBytes(this.password);
    L5:
        if ((r100 instanceof ParametersWithIV) == false) goto L8;
        r100 = ((ParametersWithIV) r100).getParameters();
    L8:
        return ((KeyParameter) r100).getKey();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "RAW";
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        checkDestroyed(this);
        return this.iterationCount;
    }

    public int getIvSize() {
        checkDestroyed(this);
        return this.ivSize;
    }

    public int getKeySize() {
        checkDestroyed(this);
        return this.keySize;
    }

    public ASN1ObjectIdentifier getOID() {
        checkDestroyed(this);
        return this.oid;
    }

    public CipherParameters getParam() {
        checkDestroyed(this);
        return this.param;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public char[] getPassword() {
        checkDestroyed(this);
        char[] r100 = this.password;
        if (r100 == null) goto L7;
        return Arrays.clone(r100);
    L7:
        throw new IllegalStateException("no password available");
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        checkDestroyed(this);
        return Arrays.clone(this.salt);
    }

    public int getType() {
        checkDestroyed(this);
        return this.type;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }

    public void setTryWrongPKCS12Zero(boolean r100) {
        this.tryWrong = r100;
    }

    public boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }
}
