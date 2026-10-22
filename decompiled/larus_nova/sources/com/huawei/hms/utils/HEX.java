package com.huawei.hms.utils;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;

/* JADX INFO: loaded from: classes23.dex */
public final class HEX {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f277859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f277860b = null;

    static {
        f277859a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        f277860b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private HEX() {
    }

    public static char[] encodeHex(byte[] r100) {
        return encodeHex(r100, false);
    }

    private static char[] a(byte[] r100, char[] r101) {
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = r100.length;
        char[] r104 = new char[r103 << 1];
        int r105 = 0;
    L7:
        if (r102 >= r103) goto L9;
        int r106 = r105 + 1;
        byte r107 = r100[r102];
        r104[r105] = r101[(r107 & 240) >>> 4];
        r105 = r106 + 1;
        r104[r106] = r101[r107 & 15];
        r102 = r102 + 1;
        goto L7
    L9:
        return r104;
    L5:
        return new char[0];
    }

    public static char[] encodeHex(byte[] r100, boolean r101) {
        if (r101 == false) goto L4;
        char[] r102 = f277860b;
    L6:
        return a(r100, r102);
    L4:
        r102 = f277859a;
        goto L6
    }

    public static String encodeHexString(byte[] r100, boolean r101) {
        return new String(encodeHex(r100, r101));
    }
}
