package org.bouncycastle.x509;

import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X509StreamParserSpi {
    public X509StreamParserSpi() {
    }

    public abstract void engineInit(InputStream r100);

    public abstract Object engineRead() throws StreamParsingException;

    public abstract Collection engineReadAll() throws StreamParsingException;
}
