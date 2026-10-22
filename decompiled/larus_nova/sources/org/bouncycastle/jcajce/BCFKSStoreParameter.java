package org.bouncycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore;
import org.bouncycastle.crypto.util.PBKDFConfig;

/* JADX INFO: loaded from: classes42.dex */
public class BCFKSStoreParameter implements KeyStore.LoadStoreParameter {
    private OutputStream out;
    private final KeyStore.ProtectionParameter protectionParameter;
    private final PBKDFConfig storeConfig;

    public BCFKSStoreParameter(OutputStream r100, PBKDFConfig r101, KeyStore.ProtectionParameter r102) {
        this.out = r100;
        this.storeConfig = r101;
        this.protectionParameter = r102;
    }

    public BCFKSStoreParameter(OutputStream r100, PBKDFConfig r101, char[] r102) {
        this(r100, r101, new KeyStore.PasswordProtection(r102));
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }
}
