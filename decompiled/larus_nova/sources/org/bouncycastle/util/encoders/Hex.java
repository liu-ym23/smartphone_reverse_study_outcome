package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class Hex {
    private static final HexEncoder encoder = null;

    static {
        encoder = new HexEncoder();
    }

    public Hex() {
    }

    public static int decode(String r100, OutputStream r101) throws IOException {
        return encoder.decode(r100, r101);
    }

    public static byte[] decode(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encoder.decode(r100, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] decode(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encoder.decode(r100, 0, r100.length, r101);     // Catch: Exception -> L6
        return r101.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("exception decoding Hex data: " + e.getMessage(), e);
    }

    public static byte[] decodeStrict(String r100) {
        return encoder.decodeStrict(r100, 0, r100.length());
    L4:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] decodeStrict(String r100, int r101, int r102) {
        return encoder.decodeStrict(r100, r101, r102);
    L4:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
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
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        encoder.encode(r100, r101, r102, r103);     // Catch: Exception -> L6
        return r103.toByteArray();
    L6:
        e = move-exception;
        throw new EncoderException("exception encoding Hex string: " + e.getMessage(), e);
    }

    public static String toHexString(byte[] r100) {
        return toHexString(r100, 0, r100.length);
    }

    public static String toHexString(byte[] r100, int r101, int r102) {
        return Strings.fromByteArray(encode(r100, r101, r102));
    }
}
