package org.bouncycastle.crypto.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class DHIESPublicKeyParser implements KeyParser {
    private DHParameters dhParams;

    public DHIESPublicKeyParser(DHParameters r100) {
        this.dhParams = r100;
    }

    @Override // org.bouncycastle.crypto.KeyParser
    public AsymmetricKeyParameter readKey(InputStream r100) throws IOException {
        int r101 = (this.dhParams.getP().bitLength() + 7) / 8;
        byte[] r102 = new byte[r101];
        Streams.readFully(r100, r102, 0, r101);
        return new DHPublicKeyParameters(new BigInteger(1, r102), this.dhParams);
    }
}
