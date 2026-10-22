package org.bouncycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    private final boolean forDEREncoding;
    private final OutputStream out;
    private final KeyStore.ProtectionParameter protectionParameter;

    public PKCS12StoreParameter(OutputStream r100, KeyStore.ProtectionParameter r101) {
        this(r100, r101, false);
    }

    public PKCS12StoreParameter(OutputStream r100, KeyStore.ProtectionParameter r101, boolean r102) {
        this.out = r100;
        this.protectionParameter = r101;
        this.forDEREncoding = r102;
    }

    public PKCS12StoreParameter(OutputStream r100, char[] r101) {
        this(r100, r101, false);
    }

    public PKCS12StoreParameter(OutputStream r100, char[] r101, boolean r102) {
        this(r100, new KeyStore.PasswordProtection(r101), r102);
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public boolean isForDEREncoding() {
        return this.forDEREncoding;
    }
}
