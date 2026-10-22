package rlc;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f538504a = null;

    static {
        f538504a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(PolarisFileWrapper r100) throws Exception {
        MessageDigest r101 = MessageDigest.getInstance("MD5");
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L14
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L12
    L6:
        int r104 = r102.read(r103, 0, 8192);     // Catch: Throwable -> L12
        if (r104 <= 0) goto L9;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L12
        goto L6
    L9:
        String r105 = c(r101.digest());     // Catch: Throwable -> L12
        r102.close();
        return r105;
    L12:
        th = th;
    L16:
        if (r102 == null) goto L18;
        r102.close();
    L18:
        throw th;
    L14:
        th = th;
        r102 = null;
        goto L16
    }

    public static String b(String r100) throws Exception {
        if (r100 == null) goto L8;
        if (r100.length() == 0) goto L8;
        MessageDigest r101 = MessageDigest.getInstance("MD5");
        r101.update(r100.getBytes("UTF-8"));
        return c(r101.digest());
    L8:
        throw new IllegalArgumentException("str is null");
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
        char[] r107 = f538504a;
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
