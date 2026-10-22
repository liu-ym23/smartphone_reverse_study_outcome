package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParser;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes42.dex */
public class X509StreamParser implements StreamParser {
    private Provider _provider;
    private X509StreamParserSpi _spi;

    private X509StreamParser(Provider r100, X509StreamParserSpi r101) {
        this._provider = r100;
        this._spi = r101;
    }

    private static X509StreamParser createParser(X509Util.Implementation r100) {
        X509StreamParserSpi r101 = (X509StreamParserSpi) r100.getEngine();
        return new X509StreamParser(r100.getProvider(), r101);
    }

    public static X509StreamParser getInstance(String r100) throws NoSuchParserException {
        return createParser(X509Util.getImplementation("X509StreamParser", r100));
    L4:
        e = move-exception;
        throw new NoSuchParserException(e.getMessage());
    }

    public static X509StreamParser getInstance(String r100, String r101) throws NoSuchParserException, NoSuchProviderException {
        return getInstance(r100, X509Util.getProvider(r101));
    }

    public static X509StreamParser getInstance(String r100, Provider r101) throws NoSuchParserException {
        return createParser(X509Util.getImplementation("X509StreamParser", r100, r101));
    L4:
        e = move-exception;
        throw new NoSuchParserException(e.getMessage());
    }

    public Provider getProvider() {
        return this._provider;
    }

    public void init(InputStream r100) {
        this._spi.engineInit(r100);
    }

    public void init(byte[] r100) {
        this._spi.engineInit(new ByteArrayInputStream(r100));
    }

    @Override // org.bouncycastle.x509.util.StreamParser
    public Object read() throws StreamParsingException {
        return this._spi.engineRead();
    }

    @Override // org.bouncycastle.x509.util.StreamParser
    public Collection readAll() throws StreamParsingException {
        return this._spi.engineReadAll();
    }
}
