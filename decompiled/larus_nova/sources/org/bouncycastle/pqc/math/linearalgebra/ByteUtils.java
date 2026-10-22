package org.bouncycastle.pqc.math.linearalgebra;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;

/* JADX INFO: loaded from: classes42.dex */
public final class ByteUtils {
    private static final char[] HEX_CHARS = null;

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private ByteUtils() {
    }

    public static byte[] clone(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r101 = new byte[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static byte[] concatenate(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static byte[] concatenate(byte[][] r100) {
        int r101 = r100[0].length;
        byte[] r102 = new byte[r100.length * r101];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        System.arraycopy(r100[r103], 0, r102, r104, r101);
        r104 = r104 + r101;
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public static int deepHashCode(byte[] r100) {
        int r101 = 1;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101 = (r101 * 31) + r100[r102];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int deepHashCode(byte[][] r100) {
        int r101 = 1;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101 = (r101 * 31) + deepHashCode(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int deepHashCode(byte[][][] r100) {
        int r101 = 1;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101 = (r101 * 31) + deepHashCode(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static boolean equals(byte[] r100, byte[] r101) {
        if (r100 != null) goto L8;
        if (r101 == null) goto L24;
        return false;
    L24:
        return true;
    L8:
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r100.length == r101.length) goto L13;
        return false;
    L13:
        int r102 = r100.length - 1;
        boolean r103 = true;
    L14:
        if (r102 < 0) goto L20;
        if (r100[r102] != r101[r102]) goto L18;
        boolean r104 = true;
    L19:
        r103 = r103 & r104;
        r102 = r102 - 1;
        goto L14
    L18:
        r104 = false;
        goto L19
    L20:
        return r103;
    }

    public static boolean equals(byte[][] r100, byte[][] r101) {
        if (r100.length == r101.length) goto L6;
        return false;
    L6:
        boolean r102 = true;
        int r103 = r100.length - 1;
    L7:
        if (r103 < 0) goto L9;
        r102 = r102 & equals(r100[r103], r101[r103]);
        r103 = r103 - 1;
        goto L7
    L9:
        return r102;
    }

    public static boolean equals(byte[][][] r100, byte[][][] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = r100.length - 1;
        boolean r103 = true;
    L6:
        if (r102 < 0) goto L14;
        byte[][] r104 = r100[r102];
        if (r104.length != r101[r102].length) goto L9;
        int r105 = r104.length - 1;
    L11:
        if (r105 < 0) goto L13;
        r103 = r103 & equals(r100[r102][r105], r101[r102][r105]);
        r105 = r105 - 1;
        goto L11
    L13:
        r102 = r102 - 1;
        goto L6
    L9:
        return false;
    L14:
        return r103;
    }

    public static byte[] fromHexString(String r110) {
        char[] r111 = r110.toUpperCase().toCharArray();
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r111.length) goto L12;
        char r103 = r111[r101];
        if (r103 < '0') goto L8;
        if (r103 > '9') goto L8;
    L10:
        r102 = r102 + 1;
    L11:
        r101 = r101 + 1;
    L8:
        if (r103 < 'A') goto L11;
        if (r103 > 'F') goto L11;
    L12:
        byte[] r104 = new byte[(r102 + 1) >> 1];
        int r105 = r102 & 1;
    L14:
        if (r100 >= r111.length) goto L24;
        char r106 = r111[r100];
        if (r106 < '0') goto L19;
        if (r106 > '9') goto L19;
        int r107 = r105 >> 1;
        byte r108 = (byte) (r104[r107] << 4);
        r104[r107] = r108;
        r104[r107] = (byte) ((r106 - '0') | r108);
    L22:
        r105 = r105 + 1;
    L23:
        r100 = r100 + 1;
    L19:
        if (r106 < 'A') goto L23;
        if (r106 > 'F') goto L23;
        int r109 = r105 >> 1;
        byte r112 = (byte) (r104[r109] << 4);
        r104[r109] = r112;
        r104[r109] = (byte) (((r106 - 'A') + 10) | r112);
        goto L22
    L24:
        return r104;
    }

    public static byte[][] split(byte[] r100, int r101) throws ArrayIndexOutOfBoundsException {
        if (r101 > r100.length) goto L7;
        byte[] r102 = new byte[r101];
        byte[][] r103 = {r102, new byte[r100.length - r101]};
        System.arraycopy(r100, 0, r102, 0, r101);
        System.arraycopy(r100, r101, r103[1], 0, r100.length - r101);
        return r103;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static byte[] subArray(byte[] r100, int r101) {
        return subArray(r100, r101, r100.length);
    }

    public static byte[] subArray(byte[] r100, int r101, int r102) {
        int r103 = r102 - r101;
        byte[] r104 = new byte[r103];
        System.arraycopy(r100, r101, r104, 0, r103);
        return r104;
    }

    public static String toBinaryString(byte[] r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L13;
        byte r103 = r100[r102];
        int r104 = 0;
    L7:
        if (r104 >= 8) goto L10;
        r101 = r101 + ((r103 >>> r104) & 1);
        r104 = r104 + 1;
        goto L7
    L10:
        if (r102 == (r100.length - 1)) goto L12;
        r101 = r101 + " ";
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        return r101;
    }

    public static char[] toCharArray(byte[] r100) {
        char[] r101 = new char[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = (char) r100[r102];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static String toHexString(byte[] r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        char[] r104 = HEX_CHARS;
        r103.append(r104[(r100[r102] >>> 4) & 15]);
        r101 = r103.toString() + r104[r100[r102] & 15];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static String toHexString(byte[] r100, String r101, String r102) {
        String r103 = new String(r101);
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L9;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        char[] r106 = HEX_CHARS;
        r105.append(r106[(r100[r104] >>> 4) & 15]);
        r103 = r105.toString() + r106[r100[r104] & 15];
        if (r104 >= (r100.length - 1)) goto L8;
        r103 = r103 + r102;
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        return r103;
    }

    public static byte[] xor(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length];
        int r103 = r100.length - 1;
    L3:
        if (r103 < 0) goto L5;
        r102[r103] = (byte) (r100[r103] ^ r101[r103]);
        r103 = r103 - 1;
        goto L3
    L5:
        return r102;
    }
}
