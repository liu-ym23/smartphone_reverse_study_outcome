package com.huawei.hms.support.log.common;

import com.alipay.sdk.m.n.a;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import kotlin.UByte;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes23.dex */
public final class Base64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f277817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f277818b = null;

    static {
        f277817a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', a.f25612h};
        f277818b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    private Base64() {
    }

    private static int a(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L11;
        char r103 = r100.charAt(r102);
        if (r103 <= 255) goto L8;
    L9:
        r101 = r101 - 1;
    L10:
        r102 = r102 + 1;
        goto L4
    L8:
        if (f277818b[r103] >= 0) goto L10;
    L11:
        return r101;
    }

    public static byte[] decode(String r110) {
        if (r110 == null) goto L5;
        int r100 = a(r110);
        int r101 = (r100 / 4) * 3;
        int r102 = r100 % 4;
        if (r102 != 3) goto L10;
        r101 = r101 + 2;
    L10:
        if (r102 != 2) goto L12;
        r101 = r101 + 1;
    L12:
        byte[] r103 = new byte[r101];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L14:
        if (r104 >= r110.length()) goto L24;
        char r108 = r110.charAt(r104);
        if (r108 <= 255) goto L18;
        byte r109 = -1;
    L19:
        if (r109 < 0) goto L23;
        r107 = r107 + 6;
        r106 = (r106 << 6) | r109;
        if (r107 < 8) goto L23;
        r107 = r107 - 8;
        r103[r105] = (byte) (255 & (r106 >> r107));
        r105 = r105 + 1;
    L23:
        r104 = r104 + 1;
        goto L14
    L18:
        r109 = f277818b[r108];
        goto L19
    L24:
        if (r105 != r101) goto L26;
        return r103;
    L26:
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static String encode(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return encode(r100, r100.length);
    }

    public static String encode(byte[] r110, int r111) {
        if (r110 != null) goto L5;
        return "";
    L5:
        char[] r100 = new char[((r111 + 2) / 3) * 4];
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r101 >= r111) goto L24;
        int r103 = (r110[r101] & UByte.MAX_VALUE) << 8;
        int r104 = r101 + 1;
        boolean r105 = true;
        if (r104 >= r111) goto L10;
        r103 = r103 | (r110[r104] & UByte.MAX_VALUE);
        boolean r106 = true;
    L11:
        int r107 = r103 << 8;
        int r108 = r101 + 2;
        if (r108 >= r111) goto L14;
        r107 = r107 | (r110[r108] & UByte.MAX_VALUE);
    L15:
        int r109 = r102 + 3;
        char[] r112 = f277817a;
        int r113 = 64;
        if (r105 == false) goto L18;
        int r114 = r107 & 63;
    L19:
        r100[r109] = r112[r114];
        int r115 = r107 >> 6;
        int r116 = r102 + 2;
        if (r106 == false) goto L22;
        r113 = r115 & 63;
    L22:
        r100[r116] = r112[r113];
        int r117 = r115 >> 6;
        r100[r102 + 1] = r112[r117 & 63];
        r100[r102 + 0] = r112[(r117 >> 6) & 63];
        r101 = r101 + 3;
        r102 = r102 + 4;
        goto L6
    L18:
        r114 = 64;
        goto L19
    L14:
        r105 = false;
        goto L15
    L10:
        r106 = false;
        goto L11
    L24:
        return new String(r100);
    }
}
