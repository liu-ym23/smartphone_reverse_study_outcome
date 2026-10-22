package org.bouncycastle.jcajce.provider.config;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12StoreParameter extends org.bouncycastle.jcajce.PKCS12StoreParameter {
    public PKCS12StoreParameter(OutputStream r100, KeyStore.ProtectionParameter r101) {
        super(r100, r101, false);
    }

    public PKCS12StoreParameter(OutputStream r100, KeyStore.ProtectionParameter r101, boolean r102) {
        super(r100, r101, r102);
    }

    public PKCS12StoreParameter(OutputStream r100, char[] r101) {
        super(r100, r101, false);
    }

    public PKCS12StoreParameter(OutputStream r100, char[] r101, boolean r102) {
        super(r100, new KeyStore.PasswordProtection(r101), r102);
    }
}
