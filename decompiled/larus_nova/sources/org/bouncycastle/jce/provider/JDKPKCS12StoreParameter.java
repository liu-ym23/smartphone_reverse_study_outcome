package org.bouncycastle.jce.provider;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes42.dex */
public class JDKPKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    private OutputStream outputStream;
    private KeyStore.ProtectionParameter protectionParameter;
    private boolean useDEREncoding;

    public JDKPKCS12StoreParameter() {
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public boolean isUseDEREncoding() {
        return this.useDEREncoding;
    }

    public void setOutputStream(OutputStream r100) {
        this.outputStream = r100;
    }

    public void setPassword(char[] r100) {
        this.protectionParameter = new KeyStore.PasswordProtection(r100);
    }

    public void setProtectionParameter(KeyStore.ProtectionParameter r100) {
        this.protectionParameter = r100;
    }

    public void setUseDEREncoding(boolean r100) {
        this.useDEREncoding = r100;
    }
}
