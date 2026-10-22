package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* JADX INFO: loaded from: classes23.dex */
public class BaseKeyUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278037a = "BaseKeyUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278038b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f278039c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f278040d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278041e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f278042f = 1;

    private static int a(int r100, int r101, int r102) {
        if (r101 >= r100) goto L4;
        r100 = r101;
    L4:
        if (r102 >= r100) goto L7;
        return r102;
    L7:
        return r100;
    }

    private static boolean a(int r100) {
        if (r100 < 16) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean b(int r100) {
        if (r100 < 16) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseKeyUtil() {
    }

    private static boolean a(byte[] r100) {
        if (r100.length < 16) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean a(int r100, String r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r101.length() < r100) goto L6;
        return true;
    }

    private static boolean a(int r100, byte[] r101) {
        return b(r100) & a(r101);
    }

    public static byte[] exportRootKey(String r100, String r101, String r102, byte[] r103, boolean r110) {
        return exportRootKey(r100, r101, r102, r103, 16, r110);
    }

    public static byte[] exportRootKey32(String r100, String r101, String r102, byte[] r103, boolean r110) {
        return exportRootKey(r100, r101, r102, r103, 32, r110);
    }

    public static byte[] exportRootKey32Iteration1(String r100, String r101, String r102, byte[] r110, boolean r111) {
        return exportRootKey(r100, r101, r102, r110, 1, 32, r111);
    }

    public static byte[] exportRootKeyIteration1(String r100, String r101, String r102, byte[] r110, boolean r111) {
        return exportRootKey(r100, r101, r102, r110, 1, 16, r111);
    }

    public static String exportHexRootKey(String r100, String r101, String r102, byte[] r103, int r104, boolean r105) {
        return HexUtil.byteArray2HexStr(exportRootKey(r100, r101, r102, r103, r104, r105));
    }

    public static byte[] exportRootKey(String r100, String r101, String r102, String r103, int r110, boolean r111) {
        return exportRootKey(r100, r101, r102, HexUtil.hexStr2ByteArray(r103), r110, r111);
    }

    public static byte[] exportRootKey(String r100, String r101, String r102, byte[] r110, int r111, boolean r112) {
        return exportRootKey(r100, r101, r102, r110, 10000, r111, r112);
    }

    public static byte[] exportRootKey(String r100, String r101, String r102, byte[] r103, int r110, int r111, boolean r112) {
        if (a(r111) == true) goto L7;
        b.b(f278037a, "exportLen length must be more than 128bit.");
        return new byte[0];
    L7:
        if (a(r111, r100) == true) goto L11;
        b.b(f278037a, "material(first) length must be Greater than or equal to export length.");
        return new byte[0];
    L11:
        if (a(r111, r101) == true) goto L15;
        b.b(f278037a, "material(second) length must be Greater than or equal to export length.");
        return new byte[0];
    L15:
        if (a(r111, r102) == true) goto L18;
        b.b(f278037a, "material(third) length must be Greater than or equal to export length.");
        return new byte[0];
    L18:
        byte[] r104 = HexUtil.hexStr2ByteArray(r100);
        byte[] r105 = HexUtil.hexStr2ByteArray(r101);
        byte[] r106 = HexUtil.hexStr2ByteArray(r102);
        int r107 = a(r104.length, r105.length, r106.length);
        if (a(r107, r103) == false) goto L33;
        char[] r108 = new char[r107];
        int r109 = 0;
    L21:
        if (r109 >= r107) goto L23;
        r108[r109] = (char) ((r104[r109] ^ r105[r109]) ^ r106[r109]);
        r109 = r109 + 1;
        goto L21
    L23:
        if (r112 == true) goto L26;
        b.c(f278037a, "exportRootKey: sha1");
        return PBKDF2.pbkdfBottom(r108, r103, r110, r111 * 8, false);
    L26:
        String r113 = f278037a;
        b.c(r113, "exportRootKey: sha256");
        if (Build.VERSION.SDK_INT >= 26) goto L31;
        b.b(r113, "system version not high than 26");
        return new byte[0];
    L31:
        return PBKDF2.pbkdfBottom(r108, r103, r110, r111 * 8, true);
    L33:
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }
}
