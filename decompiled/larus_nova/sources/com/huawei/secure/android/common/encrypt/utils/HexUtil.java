package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class HexUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278047a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278048b = "HexUtil";

    private HexUtil() {
    }

    public static String byteArray2HexStr(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L20;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L12;
        r101.append('0');
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L14:
        return r101.toString();
    L20:
        return "";
    }

    public static byte[] hexStr2ByteArray(String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L5;
        String r111 = r110.toUpperCase(Locale.ENGLISH);     // Catch: Throwable -> L18
        int r100 = r111.length() / 2;
        byte[] r101 = new byte[r100];
        byte[] r112 = r111.getBytes("UTF-8");     // Catch: NumberFormatException -> L13 Throwable -> L15
        int r102 = 0;
    L9:
        if (r102 >= r100) goto L12;
        StringBuilder r103 = new StringBuilder();     // Catch: NumberFormatException -> L13 Throwable -> L15
        r103.append("0x");     // Catch: NumberFormatException -> L13 Throwable -> L15
        int r113 = r102 * 2;     // Catch: NumberFormatException -> L13 Throwable -> L15
        r103.append(new String(new byte[]{r112[r113]}, "UTF-8"));     // Catch: NumberFormatException -> L13 Throwable -> L15
        r101[r102] = (byte) (((byte) (Byte.decode(r103.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{r112[r113 + 1]}, "UTF-8")).byteValue());     // Catch: NumberFormatException -> L13 Throwable -> L15
        r102 = r102 + 1;
        goto L9
    L12:
        return r101;
    L15:
        e = move-exception;
        b.b(f278048b, "hex string 2 byte array exception : " + e.getMessage());
        return new byte[0];
    L18:
        th = move-exception;
        b.b(f278048b, "hex string toUpperCase exception : " + th.getMessage());
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static String byteArray2HexStr(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return byteArray2HexStr(r100.getBytes("UTF-8"));
    L7:
        e = move-exception;
        b.b(f278048b, "byte array 2 hex string exception : " + e.getMessage());
        return "";
    }
}
