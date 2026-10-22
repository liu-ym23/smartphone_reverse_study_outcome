package org.bouncycastle.jcajce.io;

import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.Signature;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes42.dex */
public class OutputStreamFactory {
    public OutputStreamFactory() {
    }

    public static OutputStream createStream(MessageDigest r100) {
        return new DigestUpdatingOutputStream(r100);
    }

    public static OutputStream createStream(Signature r100) {
        return new SignatureUpdatingOutputStream(r100);
    }

    public static OutputStream createStream(Mac r100) {
        return new MacUpdatingOutputStream(r100);
    }
}
