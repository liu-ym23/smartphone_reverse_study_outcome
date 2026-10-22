package com.facebook.common.util;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = null;

    public SecureHashUtil() {
    }

    static {
        HEX_CHAR_TABLE = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    public static String convertToHex(byte[] r100) throws UnsupportedEncodingException {
        StringBuilder r101 = new StringBuilder(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        byte[] r105 = HEX_CHAR_TABLE;
        r101.append((char) r105[r104 >>> 4]);
        r101.append((char) r105[r104 & 15]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static String makeMD5Hash(String r100) {
        return makeMD5Hash(r100.getBytes(XML.CHARSET_UTF8));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String makeSHA1Hash(String r100) {
        return makeSHA1Hash(r100.getBytes(XML.CHARSET_UTF8));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String makeSHA1HashBase64(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L4
        r101.update(r100, 0, r100.length);     // Catch: NoSuchAlgorithmException -> L4
        return Base64.encodeToString(r101.digest(), 11);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String makeSHA256Hash(byte[] r100) {
        return makeHash(r100, "SHA-256");
    }

    public static String makeMD5Hash(InputStream r100) throws IOException {
        return makeHash(r100, "MD5");
    }

    public static String makeSHA1Hash(byte[] r100) {
        return makeHash(r100, "SHA-1");
    }

    public static String makeMD5Hash(byte[] r100) {
        return makeHash(r100, "MD5");
    }

    private static String makeHash(InputStream r100, String r101) throws IOException {
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: UnsupportedEncodingException -> L8 NoSuchAlgorithmException -> L11
        byte[] r103 = new byte[4096];     // Catch: UnsupportedEncodingException -> L8 NoSuchAlgorithmException -> L11
    L3:
        int r104 = r100.read(r103);     // Catch: UnsupportedEncodingException -> L8 NoSuchAlgorithmException -> L11
        if (r104 <= 0) goto L6;
        r102.update(r103, 0, r104);     // Catch: UnsupportedEncodingException -> L8 NoSuchAlgorithmException -> L11
        goto L3
    L6:
        return convertToHex(r102.digest());
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static String makeHash(byte[] r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: UnsupportedEncodingException -> L4 NoSuchAlgorithmException -> L7
        r102.update(r100, 0, r100.length);     // Catch: UnsupportedEncodingException -> L4 NoSuchAlgorithmException -> L7
        return convertToHex(r102.digest());
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
