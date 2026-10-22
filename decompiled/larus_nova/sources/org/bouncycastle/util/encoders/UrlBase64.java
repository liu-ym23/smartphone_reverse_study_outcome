package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class UrlBase64 {
    private static final Encoder encoder = null;

    static {
        encoder = new UrlBase64Encoder();
    }

    public UrlBase64() {
    }

    public static int decode(String r100, OutputStream r101) throws IOException {
        return encoder.decode(r100, r101);
    }

    public static int decode(byte[] r100, OutputStream r101) throws IOException {
        return encoder.decode(r100, 0, r100.length, r101);
    }

    public static byte[] decode(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encoder.decode(r100, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("exception decoding URL safe base64 string: " + e.getMessage(), e);
    }

    public static byte[] decode(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encoder.decode(r100, 0, r100.length, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("exception decoding URL safe base64 string: " + e.getMessage(), e);
    }

    public static int encode(byte[] r100, OutputStream r101) throws IOException {
        return encoder.encode(r100, 0, r100.length, r101);
    }

    public static byte[] encode(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encoder.encode(r100, 0, r100.length, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new EncoderException("exception encoding URL safe base64 data: " + e.getMessage(), e);
    }
}
