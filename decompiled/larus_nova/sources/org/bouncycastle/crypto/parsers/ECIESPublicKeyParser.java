package org.bouncycastle.crypto.parsers;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class ECIESPublicKeyParser implements KeyParser {
    private ECDomainParameters ecParams;

    public ECIESPublicKeyParser(ECDomainParameters r100) {
        this.ecParams = r100;
    }

    @Override // org.bouncycastle.crypto.KeyParser
    public AsymmetricKeyParameter readKey(InputStream r100) throws IOException {
        int r101 = r100.read();
        if (r101 == 0) goto L21;
        if (r101 != 2) goto L7;
    L17:
        byte[] r102 = new byte[((this.ecParams.getCurve().getFieldSize() + 7) / 8) + 1];
    L18:
        r102[0] = (byte) r101;
        Streams.readFully(r100, r102, 1, r102.length - 1);
        return new ECPublicKeyParameters(this.ecParams.getCurve().decodePoint(r102), this.ecParams);
    L7:
        if (r101 == 3) goto L17;
        if (r101 != 4) goto L11;
    L16:
        r102 = new byte[(((this.ecParams.getCurve().getFieldSize() + 7) / 8) * 2) + 1];
        goto L18
    L11:
        if (r101 == 6) goto L16;
        if (r101 == 7) goto L16;
        throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(r101, 16));
    L21:
        throw new IOException("Sender's public key invalid.");
    }
}
