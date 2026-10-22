package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

/* JADX INFO: loaded from: classes42.dex */
public class TarUtils {
    static final ZipEncoding DEFAULT_ENCODING = null;
    static final ZipEncoding FALLBACK_ENCODING = null;

    static {
        DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding(null);
        FALLBACK_ENCODING = new AnonymousClass1();
    }

    public static boolean verifyCheckSum(byte[] r110) {
        long r100 = parseOctal(r110, 148, 8);
        long r101 = 0;
        long r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r110.length) goto L12;
        byte r104 = r110[r103];
        if (148 > r103) goto L10;
        if (r103 >= 156) goto L10;
        r104 = 32;
    L10:
        r101 = r101 + ((long) (r104 & UByte.MAX_VALUE));
        r102 = r102 + ((long) r104);
        r103 = r103 + 1;
        goto L4
    L12:
        if (r100 != r101) goto L14;
    L15:
        return true;
    L14:
        if (r100 == r102) goto L15;
        return false;
    }

    public static boolean parseBoolean(byte[] r100, int r101) {
        if (r100[r101] == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String parseName(byte[] r100, int r101, int r102) {
        return parseName(r100, r101, r102, DEFAULT_ENCODING);
    L4:
        return parseName(r100, r101, r102, FALLBACK_ENCODING);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static long parseOctal(byte[] r100, int r101, int r102) {
        int r103 = r101 + r102;
        if (r102 < 2) goto L28;
        long r104 = 0;
        if (r100[r101] != 0) goto L7;
        return 0;
    L7:
        int r105 = r101;
    L9:
        if (r105 >= r103) goto L13;
        if (r100[r105] != 32) goto L13;
        r105 = r105 + 1;
    L13:
        byte r106 = r100[r103 - 1];
    L14:
        if (r105 >= r103) goto L18;
        if (r106 == 0) goto L17;
        if (r106 != 32) goto L18;
    L17:
        r103 = r103 - 1;
        r106 = r100[r103 - 1];
    L18:
        if (r105 >= r103) goto L26;
        byte r107 = r100[r105];
        if (r107 < 48) goto L25;
        if (r107 > 55) goto L25;
        r104 = (r104 << 3) + ((long) (r107 - 48));
        r105 = r105 + 1;
    L25:
        throw new IllegalArgumentException(exceptionMessage(r100, r101, r102, r105, r107));
    L26:
        return r104;
    L28:
        throw new IllegalArgumentException("Length " + r102 + " must be at least 2");
    }

    public static long parseOctalOrBinary(byte[] r100, int r101, int r102) {
        byte r103 = r100[r101];
        if ((r103 & ByteCompanionObject.MIN_VALUE) != 0) goto L7;
        return parseOctal(r100, r101, r102);
    L7:
        if (r103 != (-1)) goto L9;
        boolean r104 = true;
    L11:
        if (r102 >= 9) goto L15;
        return parseBinaryLong(r100, r101, r102, r104);
    L15:
        return parseBinaryBigInteger(r100, r101, r102, r104);
    L9:
        r104 = false;
        goto L11
    }

    private static long parseBinaryBigInteger(byte[] r100, int r101, int r102, boolean r103) {
        int r104 = r102 - 1;
        byte[] r105 = new byte[r104];
        System.arraycopy(r100, r101 + 1, r105, 0, r104);
        BigInteger r106 = new BigInteger(r105);
        if (r103 == false) goto L6;
        r106 = r106.add(BigInteger.valueOf(-1)).not();
    L6:
        if (r106.bitLength() > 63) goto L12;
        long r107 = r106.longValue();
        if (r103 == true) goto L10;
        return r107;
    L10:
        return -r107;
    L12:
        throw new IllegalArgumentException("At offset " + r101 + ", " + r102 + " byte binary number exceeds maximum signed long value");
    }

    private static long parseBinaryLong(byte[] r100, int r101, int r102, boolean r110) {
        if (r102 >= 9) goto L13;
        long r103 = 0;
        int r104 = 1;
    L5:
        if (r104 >= r102) goto L7;
        r103 = (r103 << 8) + ((long) (r100[r101 + r104] & UByte.MAX_VALUE));
        r104 = r104 + 1;
        goto L5
    L7:
        if (r110 == false) goto L9;
        r103 = (r103 - 1) ^ (((long) Math.pow(2.0d, ((double) (r102 - 1)) * 8.0d)) - 1);
    L9:
        if (r110 == true) goto L11;
        return r103;
    L11:
        return -r103;
    L13:
        throw new IllegalArgumentException("At offset " + r101 + ", " + r102 + " byte binary number exceeds maximum signed long value");
    }

    public static String parseName(byte[] r100, int r101, int r102, ZipEncoding r103) throws IOException {
        int r104 = r101;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L7;
        if (r100[r104] == 0) goto L7;
        r105 = r105 + 1;
        r104 = r104 + 1;
    L7:
        if (r105 <= 0) goto L10;
        byte[] r106 = new byte[r105];
        System.arraycopy(r100, r101, r106, 0, r105);
        return r103.decode(r106);
    L10:
        return "";
    }

    private static String exceptionMessage(byte[] r100, int r101, int r102, int r103, byte r104) {
        return "Invalid byte " + r104 + " at offset " + (r103 - r101) + " in '" + new String(r100, r101, r102).replaceAll("\u0000", "{NUL}") + "' len=" + r102;
    }
}
