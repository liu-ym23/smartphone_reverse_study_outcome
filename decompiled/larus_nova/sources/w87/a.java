package w87;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f558658a = null;

    static {
        f558658a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L16;
    L14:
        return null;
    L16:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L15
        if (r101 != null) goto L8;
        return null;
    L8:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L15
        byte[] r103 = new byte[8192];     // Catch: Exception -> L15
    L9:
        int r104 = r102.read(r103, 0, 8192);     // Catch: Exception -> L15
        if (r104 <= 0) goto L12;
        r101.update(r103, 0, r104);     // Catch: Exception -> L15
        goto L9
    L12:
        r102.close();     // Catch: Exception -> L15
        return c(r101.digest());
    }

    public static String b(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return c(r101.digest());
    }

    public static String c(byte[] r110) {
        if (r110 == null) goto L13;
        int r100 = r110.length;
        if ((0 + r100) > r110.length) goto L11;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r100) goto L9;
        int r105 = r110[r103 + 0] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = f558658a;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return new String(r102, 0, r101);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }
}
