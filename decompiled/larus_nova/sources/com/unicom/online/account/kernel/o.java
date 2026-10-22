package com.unicom.online.account.kernel;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f462065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f462066b;

    static {
        f462065a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f462066b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(String r100) {
        return r100.replaceAll("\\+", "%2B");
    }

    public static String a(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        int r104 = r103 + 1;
        int r105 = r100[r103] & UByte.MAX_VALUE;
        if (r104 == r102) goto L6;
        int r106 = r104 + 1;
        int r107 = r100[r104] & UByte.MAX_VALUE;
        if (r106 == r102) goto L10;
        int r108 = r106 + 1;
        int r109 = r100[r106] & UByte.MAX_VALUE;
        r101.append(f462065a[r105 >>> 2]);
        r101.append(f462065a[((r105 & 3) << 4) | ((r107 & 240) >>> 4)]);
        r101.append(f462065a[((r107 & 15) << 2) | ((r109 & 192) >>> 6)]);
        r101.append(f462065a[r109 & 63]);
        r103 = r108;
        goto L3
    L10:
        r101.append(f462065a[r105 >>> 2]);
        r101.append(f462065a[((r105 & 3) << 4) | ((r107 & 240) >>> 4)]);
        r101.append(f462065a[(r107 & 15) << 2]);
        String r110 = ContainerUtils.KEY_VALUE_DELIMITER;
    L7:
        r101.append(r110);
        goto L13
    L6:
        r101.append(f462065a[r105 >>> 2]);
        r101.append(f462065a[(r105 & 3) << 4]);
        r110 = "==";
    L13:
        return r101.toString();
    }

    public static byte[] b(String r100) {
        byte[] r101 = r100.getBytes();
        int r102 = r101.length;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(r102);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L40;
    L4:
        int r105 = r104 + 1;
        byte r106 = f462066b[r101[r104]];
        if (r105 >= r102) goto L9;
        if (r106 != (-1)) goto L9;
        r104 = r105;
    L9:
        if (r106 == (-1)) goto L40;
    L10:
        int r107 = r105 + 1;
        byte r108 = f462066b[r101[r105]];
        if (r107 >= r102) goto L15;
        if (r108 != (-1)) goto L15;
        r105 = r107;
    L15:
        if (r108 == (-1)) goto L40;
        r103.write((r106 << 2) | ((r108 & 48) >>> 4));
    L17:
        int r109 = r107 + 1;
        byte r110 = r101[r107];
        if (r110 == 61) goto L20;
        byte r111 = f462066b[r110];
        if (r109 >= r102) goto L26;
        if (r111 != (-1)) goto L26;
        r107 = r109;
    L26:
        if (r111 == (-1)) goto L40;
        r103.write(((r108 & 15) << 4) | ((r111 & 60) >>> 2));
    L28:
        int r112 = r109 + 1;
        byte r113 = r101[r109];
        if (r113 == 61) goto L31;
        byte r114 = f462066b[r113];
        if (r112 >= r102) goto L37;
        if (r114 != (-1)) goto L37;
        r109 = r112;
    L37:
        if (r114 == (-1)) goto L40;
        r103.write(r114 | ((r111 & 3) << 6));
        r104 = r112;
        goto L3
    L31:
        return r103.toByteArray();
    L20:
        return r103.toByteArray();
    L40:
        return r103.toByteArray();
    }
}
