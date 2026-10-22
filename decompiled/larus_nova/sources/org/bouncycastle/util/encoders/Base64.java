package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class Base64 {
    private static final Encoder encoder = null;

    static {
        encoder = new Base64Encoder();
    }

    public Base64() {
    }

    public static int decode(String r100, OutputStream r101) throws IOException {
        return encoder.decode(r100, r101);
    }

    public static int decode(byte[] r100, int r101, int r102, OutputStream r103) {
        return encoder.decode(r100, r101, r102, r103);
    L4:
        e = move-exception;
        throw new DecoderException("unable to decode base64 data: " + e.getMessage(), e);
    }

    public static byte[] decode(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream((r100.length() / 4) * 3);
        encoder.decode(r100, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("unable to decode base64 string: " + e.getMessage(), e);
    }

    public static byte[] decode(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream((r100.length / 4) * 3);
        encoder.decode(r100, 0, r100.length, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("unable to decode base64 data: " + e.getMessage(), e);
    }

    public static int encode(byte[] r100, int r101, int r102, OutputStream r103) throws IOException {
        return encoder.encode(r100, r101, r102, r103);
    }

    public static int encode(byte[] r100, OutputStream r101) throws IOException {
        return encoder.encode(r100, 0, r100.length, r101);
    }

    public static byte[] encode(byte[] r100) {
        return encode(r100, 0, r100.length);
    }

    public static byte[] encode(byte[] r100, int r101, int r102) {
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(((r102 + 2) / 3) * 4);
        encoder.encode(r100, r101, r102, r103);     // Catch: Exception -> L6
        return r103.toByteArray();
    L6:
        e = move-exception;
        throw new EncoderException("exception encoding base64 string: " + e.getMessage(), e);
    }

    public static String toBase64String(byte[] r100) {
        return toBase64String(r100, 0, r100.length);
    }

    public static String toBase64String(byte[] r100, int r101, int r102) {
        return Strings.fromByteArray(encode(r100, r101, r102));
    }
}
