package org.bouncycastle.jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes42.dex */
public class BCLoadStoreParameter implements KeyStore.LoadStoreParameter {

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f525349in;
    private final OutputStream out;
    private final KeyStore.ProtectionParameter protectionParameter;

    public BCLoadStoreParameter(InputStream r100, OutputStream r101, KeyStore.ProtectionParameter r102) {
        this.f525349in = r100;
        this.out = r101;
        this.protectionParameter = r102;
    }

    public BCLoadStoreParameter(InputStream r100, KeyStore.ProtectionParameter r101) {
        this(r100, null, r101);
    }

    public BCLoadStoreParameter(InputStream r100, char[] r101) {
        this(r100, new KeyStore.PasswordProtection(r101));
    }

    public BCLoadStoreParameter(OutputStream r100, KeyStore.ProtectionParameter r101) {
        this(null, r100, r101);
    }

    public BCLoadStoreParameter(OutputStream r100, char[] r101) {
        this(r100, new KeyStore.PasswordProtection(r101));
    }

    public InputStream getInputStream() {
        if (this.out != null) goto L7;
        return this.f525349in;
    L7:
        throw new UnsupportedOperationException("parameter configured for storage OutputStream present");
    }

    public OutputStream getOutputStream() {
        OutputStream r100 = this.out;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new UnsupportedOperationException("parameter not configured for storage - no OutputStream");
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }
}
