package com.facebook.imageutils;

import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public class WebpUtil {
    private static final String VP8L_HEADER = "VP8L";
    private static final String VP8X_HEADER = "VP8X";
    private static final String VP8_HEADER = "VP8 ";

    private WebpUtil() {
    }

    public static int get2BytesAsInt(InputStream r100) throws IOException {
        byte r101 = (byte) r100.read();
        return ((((byte) r100.read()) << 8) & 65280) | (r101 & UByte.MAX_VALUE);
    }

    private static byte getByte(InputStream r100) throws IOException {
        return (byte) (r100.read() & 255);
    }

    private static String getHeader(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101.append((char) r100[r102]);
        r102 = r102 + 1;
        goto L4
    L7:
        return r101.toString();
    }

    private static int getInt(InputStream r100) throws IOException {
        byte r101 = (byte) r100.read();
        byte r102 = (byte) r100.read();
        byte r103 = (byte) r100.read();
        return ((((((byte) r100.read()) << 24) & (-16777216)) | ((r103 << 16) & 16711680)) | ((r102 << 8) & 65280)) | (r101 & UByte.MAX_VALUE);
    }

    private static short getShort(InputStream r100) throws IOException {
        return (short) (r100.read() & 255);
    }

    @Nullable
    public static Pair<Integer, Integer> getSize(InputStream r100) {
        byte[] r101 = new byte[4];
        r100.read(r101);     // Catch: Throwable -> L43 IOException -> L45
        if (compare(r101, "RIFF") == false) goto L64;
        getInt(r100);     // Catch: Throwable -> L43 IOException -> L45
        r100.read(r101);     // Catch: Throwable -> L43 IOException -> L45
        if (compare(r101, "WEBP") == false) goto L59;
        r100.read(r101);     // Catch: Throwable -> L43 IOException -> L45
        String r102 = getHeader(r101);     // Catch: Throwable -> L43 IOException -> L45
        if (VP8_HEADER.equals(r102) == false) goto L26;
        Pair<Integer, Integer> r103 = getVP8Dimension(r100);     // Catch: Throwable -> L43 IOException -> L45
        r100.close();     // Catch: IOException -> L22
    L24:
        return r103;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L26:
        if (VP8L_HEADER.equals(r102) == false) goto L34;
        Pair<Integer, Integer> r104 = getVP8LDimension(r100);     // Catch: Throwable -> L43 IOException -> L45
        r100.close();     // Catch: IOException -> L30
    L32:
        return r104;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L34:
        if (VP8X_HEADER.equals(r102) == false) goto L41;
        Pair<Integer, Integer> r105 = getVP8XDimension(r100);     // Catch: Throwable -> L43 IOException -> L45
        r100.close();     // Catch: IOException -> L38
    L40:
        return r105;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        r100.close();     // Catch: IOException -> L50
    L52:
        return null;
    L59:
        r100.close();     // Catch: IOException -> L14
    L16:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L64:
        r100.close();     // Catch: IOException -> L7
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = move-exception;
        e.printStackTrace();
    L45:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L43
        if (r100 == null) goto L52;
        r100.close();     // Catch: IOException -> L50
    L43:
        th = move-exception;
        if (r100 != null) goto L67;
    L58:
        throw th;
    L67:
        r100.close();     // Catch: IOException -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    }

    private static Pair<Integer, Integer> getVP8Dimension(InputStream r100) throws IOException {
        r100.skip(7);
        short r101 = getShort(r100);
        short r102 = getShort(r100);
        short r103 = getShort(r100);
        if (r101 == 157) goto L5;
        return null;
    L5:
        if (r102 == 1) goto L7;
        return null;
    L7:
        if (r103 == 42) goto L10;
        return null;
    L10:
        return new Pair(Integer.valueOf(get2BytesAsInt(r100)), Integer.valueOf(get2BytesAsInt(r100)));
    }

    private static Pair<Integer, Integer> getVP8LDimension(InputStream r100) throws IOException {
        getInt(r100);
        if (getByte(r100) == 47) goto L6;
        return null;
    L6:
        int r101 = ((byte) r100.read()) & UByte.MAX_VALUE;
        int r102 = ((byte) r100.read()) & UByte.MAX_VALUE;
        int r103 = ((byte) r100.read()) & UByte.MAX_VALUE;
        int r104 = (r101 | ((r102 & 63) << 8)) + 1;
        int r105 = (((((((byte) r100.read()) & UByte.MAX_VALUE) & 15) << 10) | (r103 << 2)) | ((r102 & 192) >> 6)) + 1;
        return new Pair(Integer.valueOf(r104), Integer.valueOf(r105));
    }

    private static Pair<Integer, Integer> getVP8XDimension(InputStream r100) throws IOException {
        r100.skip(8);
        return new Pair(Integer.valueOf(read3Bytes(r100) + 1), Integer.valueOf(read3Bytes(r100) + 1));
    }

    private static int read3Bytes(InputStream r100) throws IOException {
        byte r101 = getByte(r100);
        byte r102 = getByte(r100);
        return (((getByte(r100) << 16) & 16711680) | ((r102 << 8) & 65280)) | (r101 & UByte.MAX_VALUE);
    }

    private static boolean compare(byte[] r100, String r101) {
        if (r100.length == r101.length()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L12;
        if (r101.charAt(r102) != r100[r102]) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static boolean isBitOne(byte r100, int r101) {
        if (((r100 >> (r101 % 8)) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
