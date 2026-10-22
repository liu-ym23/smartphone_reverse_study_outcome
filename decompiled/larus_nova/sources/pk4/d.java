package pk4;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f529618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f529619b = null;

    static {
        f529618a = new String[256];
        f529619b = "0123456789ABCDEF".toCharArray();
        char[] r100 = new char[5];
        int r101 = 0;
        r100[0] = '0';
        r100[1] = Permission.EXECUTE;
        r100[4] = ' ';
    L3:
        if (r101 >= 256) goto L5;
        char[] r102 = f529619b;
        r100[2] = r102[(r101 >>> 4) & 15];
        r100[3] = r102[r101 & 15];
        f529618a[r101] = new String(r100);
        r101 = r101 + 1;
        goto L3
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return b(r100, r100.length);
    }

    public static String b(byte[] r100, int r110) {
        if (r100 == null) goto L17;
        if (r110 <= 0) goto L22;
        int r111 = Math.min(r110, r100.length);
        char[] r101 = new char[(r111 * 5) - 1];
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r111) goto L16;
        String r104 = f529618a[r100[r102] & UByte.MAX_VALUE];
        int r105 = r111 - 1;
        int r106 = 4;
        if (r102 >= r105) goto L10;
        int r107 = 5;
    L11:
        r104.getChars(0, r107, r101, r103);
        if (r102 >= r105) goto L14;
        r106 = 5;
    L14:
        r103 = r103 + r106;
        r102 = r102 + 1;
        goto L6
    L10:
        r107 = 4;
        goto L11
    L16:
        return new String(r101);
    L22:
        return null;
    L17:
        return null;
    }
}
