package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class Anonymizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277923a = "Anonymizer";

    public Anonymizer() {
    }

    public static String maskAccountId(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        if (r100.length() > 1) goto L11;
        return "*";
    L11:
        if (r100.length() >= 8) goto L15;
        return maskCommonString(r100, 0, 1);
    L15:
        return maskCommonString(r100, 0, 4);
    }

    public static String maskBankAccount(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        if (r100.length() > 2) goto L11;
        return a.a(r100, '*');
    L11:
        if (r100.length() < 11) goto L17;
        if (r100.length() >= 20) goto L17;
        return maskCommonString(r100, 4, 4);
    L17:
        return maskCommonString(r100, 6, 4);
    }

    public static String maskBirthday(String r100) {
        if (r100 != null) goto L5;
    L13:
        return "";
    L5:
        if (r100.length() <= 0) goto L13;
        if (r100.length() <= 4) goto L10;
        String[] r101 = a.a(r100, 4);
        return a.a("", new String[]{a.a(r101, 0), a.a(a.a(r101, 1), "0123456789", "*")});
    L10:
        return a.a(r100, '*');
    }

    public static String maskEmail(String r100) {
        if (r100 != null) goto L5;
    L17:
        return "";
    L5:
        if (r100.length() <= 0) goto L17;
        if (r100.length() > 1) goto L11;
        return "*";
    L11:
        int r101 = r100.indexOf(64);
        if (r101 >= 0) goto L15;
        String[] r102 = a.a(r100, 1);
        return a.a("", new String[]{a.a(r102, 0), a.a(a.a(r102, 1), '*')});
    L15:
        String[] r103 = a.a(r100, r101, r101 + 1, r100.lastIndexOf(46));
        return a.a("", new String[]{a.a(a.a(r103, 0), '*'), a.a(r103, 1), a.a(a.a(r103, 2), '*'), a.a(r103, 3)});
    }

    public static String maskId(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        return maskCommonString(r100, r100.length() - 12, 0);
    }

    public static String maskImeiImsi(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        return maskCommonString(r100, r100.length() - 4, 0);
    }

    public static String maskIpV4(String r100) {
        if (r100 != null) goto L5;
    L13:
        return "";
    L5:
        if (r100.length() <= 0) goto L13;
        int r101 = r100.lastIndexOf(46);
        if (r101 < 0) goto L10;
        String[] r102 = a.a(r100, r101 + 1);
        return a.a("", new String[]{a.a(r102, 0), a.a(a.a(r102, 1), '*')});
    L10:
        return a.a(r100, '*');
    }

    public static String maskIpV6(String r100) {
        if (r100 != null) goto L5;
    L21:
        return "";
    L5:
        if (r100.length() <= 0) goto L21;
        String[] r101 = a.b(r100, ':');
        if (r101.length > 1) goto L12;
        return a.a(r100, '*');
    L12:
        if (r101.length == 8) goto L15;
        String[] r102 = a.a(r100, r100.indexOf(58) + 1);
        return a.a("", new String[]{a.a(r102, 0), a.a(a.a(r102, 1), "0123456789ABCDEFabcdef", "*")});
    L15:
        r101[2] = maskLower8Bit(r101[2]);
        int r103 = 3;
    L17:
        if (r103 >= r101.length) goto L20;
        r101[r103] = a.a(r101[r103], '*');
        r103 = r103 + 1;
        goto L17
    L20:
        return a.a(":", r101);
    }

    public static String maskLower8Bit(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        if (r100.length() <= 2) goto L8;
        String[] r101 = a.a(r100, r100.length() - 2);
        return a.a("", new String[]{a.a(r101, 0), a.a(a.a(r101, 1), '*')});
    L8:
        return a.a(r100, '*');
    }

    public static String maskMac(String r100) {
        if (r100 != null) goto L5;
    L13:
        return "";
    L5:
        if (r100.length() <= 0) goto L13;
        int r101 = a.a(r100, '-', 2);
        if (r101 < 0) goto L10;
        String[] r102 = a.a(r100, r101);
        return a.a("", new String[]{a.a(r102, 0), a.a(a.a(r102, 1), "0123456789ABCDEFabcdef", "*")});
    L10:
        return a.a(r100, "0123456789ABCDEFabcdef", "*");
    }

    public static String maskName(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        if (r100.length() > 1) goto L11;
        return "*";
    L11:
        return maskCommonString(r100, 1, 0);
    }

    public static String maskPhone(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        if (r100.length() > 2) goto L11;
        return a.a(r100, '*');
    L11:
        if (r100.length() < 8) goto L17;
        if (r100.length() >= 11) goto L17;
        return maskCommonString(r100, 2, 2);
    L17:
        return maskCommonString(r100, 3, 4);
    }

    public static String maskCommonString(String r100, int r101, int r102) {
        if (r100 != null) goto L5;
    L18:
        return "";
    L5:
        if (r100.length() <= 0) goto L18;
        if (r101 >= 0) goto L10;
        r101 = 0;
    L10:
        if (r102 >= 0) goto L13;
        r102 = 0;
    L13:
        if (r100.length() > (r101 + r102)) goto L15;
        int r103 = r100.length() - 1;
        r101 = 1;
    L16:
        String[] r104 = a.a(r100, r101, r103);
        return a.a("", new String[]{a.a(r104, 0), a.a(a.a(r104, 1), '*'), a.a(r104, 2)});
    L15:
        r103 = r100.length() - r102;
        goto L16
    }
}
