package org.bouncycastle.asn1;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Generator {
    protected OutputStream _out;

    public ASN1Generator(OutputStream r100) {
        this._out = r100;
    }

    public abstract OutputStream getRawOutputStream();
}
